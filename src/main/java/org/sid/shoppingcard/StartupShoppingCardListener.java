package org.sid.shoppingcard;

import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.adapter.out.CartPersistenceAdapter;
import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.CreateClientCommand;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.in.ListClientQuery;
import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.application.services.CancelCartService;
import org.sid.shoppingcard.application.services.CreateClientService;
import org.sid.shoppingcard.application.services.GetAllCartService;
import org.sid.shoppingcard.application.services.GetAllClientService;
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
    private final GetAllClientService allClientService;
    private final CancelCartService cancelCartService;
    private final CreateClientService createClientService;

    public StartupShoppingCardListener(CommandBus commandBus, QueryBus queryBus,
            CartPersistenceAdapter persistenceAdapter, ValidationCartService validationCartService,
            GetAllCartService allCartService, CancelCartService cancelCartService,
            GetAllClientService allClientService, CreateClientService createClientService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.validationCartService = validationCartService;
        this.cancelCartService = cancelCartService;
        this.allCartService = allCartService;
        this.allClientService = allClientService;
        this.createClientService = createClientService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(CancelCartCommand.class, cancelCartService);
        commandBus.register(ValidationCartCommand.class, validationCartService);
        commandBus.register(CreateClientCommand.class, createClientService);
        queryBus.register(ListCartQuery.class, allCartService);
        queryBus.register(ListClientQuery.class, allClientService);
    }
}
