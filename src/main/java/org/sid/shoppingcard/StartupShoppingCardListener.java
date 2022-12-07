package org.sid.shoppingcard;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.adapter.out.CartPersistenceAdapter;
import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.application.services.CancelCartService;
import org.sid.shoppingcard.application.services.GetAllCartService;
import org.sid.shoppingcard.application.services.ValidationCartService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupShoppingCardListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final CartPersistenceAdapter persistenceAdapter;
    private final ValidationCartService validationCartService;
    private final GetAllCartService allCartService;
    private final CancelCartService cancelCartService;

    public StartupShoppingCardListener(CommandBus commandBus, QueryBus queryBus,
            CartPersistenceAdapter persistenceAdapter, ValidationCartService validationCartService,
            GetAllCartService allCartService, CancelCartService cancelCartService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.validationCartService = validationCartService;
        this.cancelCartService = cancelCartService;
        this.allCartService = allCartService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(CancelCartCommand.class, cancelCartService);
        commandBus.register(ValidationCartCommand.class, validationCartService);
        queryBus.register(ListCartQuery.class, allCartService);
    }
}
