package org.sid.shoppingcard;

import org.sid.kernel.BusFactory;
import org.sid.shoppingcard.adapter.in.CartController;
import org.sid.shoppingcard.adapter.out.CartPersistenceAdapter;
import org.sid.shoppingcard.application.port.in.CancelCartCommand;
import org.sid.shoppingcard.application.port.in.ListCartQuery;
import org.sid.shoppingcard.application.port.in.ValidationCartCommand;
import org.sid.shoppingcard.application.services.CancelCartService;
import org.sid.shoppingcard.application.services.GetAllCartService;
import org.sid.shoppingcard.application.services.ValidationCartService;

public class Main {

    public static void main(String[] args) {

        var persistenceAdapter = new CartPersistenceAdapter();

        var validationCartPort = persistenceAdapter;
        var allCartPort = persistenceAdapter;
        var cancelCartStatePort = persistenceAdapter;

        var validationCartUseCase = new ValidationCartService(validationCartPort);
        var cancelCartUseCase = new CancelCartService(cancelCartStatePort);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(ValidationCartCommand.class, validationCartUseCase);
        commandBus.register(CancelCartCommand.class, cancelCartUseCase);

        var queryBus = BusFactory.defaultQueryBus();
        var cartUseCase = new GetAllCartService(allCartPort);
        queryBus.register(ListCartQuery.class, cartUseCase);

        var cartController = new CartController(commandBus, queryBus);

        var validateCart = cartController.validation(300);
        cartController.validation(500);

        var listAllCart = cartController.getAllCart();

        System.out.println(validateCart);

        System.out.println("Liste de tous les panier: \n" + listAllCart);

        if (listAllCart.size() > 0) {
            var annulationCart = cartController.cancel(validateCart);
            System.out.println(annulationCart);
            var listAllCart2 = cartController.getAllCart();
            System.out.println("Liste de tous les panier apres annulation: \n" + listAllCart2);
        }
    }
}
