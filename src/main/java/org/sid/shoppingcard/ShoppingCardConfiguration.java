package org.sid.shoppingcard;

import org.sid.kernel.BusFactory;
import org.sid.kernel.CommandBus;
import org.sid.kernel.QueryBus;
import org.sid.shoppingcard.adapter.out.CartPersistenceAdapter;
import org.sid.shoppingcard.application.services.CancelCartService;
import org.sid.shoppingcard.application.services.GetAllCartService;
import org.sid.shoppingcard.application.services.ValidationCartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ShoppingCardConfiguration {

    @Bean
    public CartPersistenceAdapter persistenceAdapter() {
        return new CartPersistenceAdapter();
    }

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }

    @Bean
    public ValidationCartService validationCartService() {
        return new ValidationCartService(persistenceAdapter());
    }

    @Bean
    public CancelCartService cancelCartService() {
        return new CancelCartService(persistenceAdapter());
    }

    @Bean
    public GetAllCartService allCartService() {
        return new GetAllCartService(persistenceAdapter());
    }
}
