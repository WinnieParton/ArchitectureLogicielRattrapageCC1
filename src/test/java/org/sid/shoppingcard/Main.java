package org.sid.shoppingcard;

import org.sid.kernel.BusFactory;
import org.sid.shoppingcard.adapter.in.CartController;
import org.sid.shoppingcard.adapter.in.ClientController;
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

public class Main {

    public static void main(String[] args) {

        var persistenceAdapter = new CartPersistenceAdapter();

        var createClientPort = persistenceAdapter;
        var allClienttPort = persistenceAdapter;

        var validationCartPort = persistenceAdapter;
        var allCartPort = persistenceAdapter;
        var cancelCartStatePort = persistenceAdapter;

        var createClientUseCase = new CreateClientService(createClientPort);
        var validationCartUseCase = new ValidationCartService(validationCartPort);
        var cancelCartUseCase = new CancelCartService(cancelCartStatePort);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(ValidationCartCommand.class, validationCartUseCase);
        commandBus.register(CancelCartCommand.class, cancelCartUseCase);
        commandBus.register(CreateClientCommand.class, createClientUseCase);

        var queryBus = BusFactory.defaultQueryBus();
        var clientUseCase = new GetAllClientService(allClienttPort);
        var cartUseCase = new GetAllCartService(allCartPort);
        queryBus.register(ListClientQuery.class, clientUseCase);
        queryBus.register(ListCartQuery.class, cartUseCase);

        var clientController = new ClientController(commandBus, queryBus);
        var cartController = new CartController(commandBus, queryBus);

        var createClient = clientController.createClient("KOUM WO", "Winnie Parton");
        var createClient2 = clientController.createClient("NKOAGNI", "Parton");
        clientController.createClient("ORNEST", "Elvin");

        var validateCart = cartController.validation(300, createClient);

        cartController.validation(500, createClient2);

        var listAllClient = clientController.getAllClient();
        var listAllCart = cartController.getAllCart();

        System.out.println("Liste de tous les clients: \n" + listAllClient);

        System.out.println("Valider un panier: \n" + validateCart);

        System.out.println("Liste de tous les panier: \n" + listAllCart);

        if (listAllCart.size() > 0) {
            var annulationCart = cartController.cancel(validateCart);
            System.out.println("Annuler un panier: \n" + annulationCart);
            var listAllCart2 = cartController.getAllCart();
            System.out.println("Liste de tous les panier apres annulation: \n" + listAllCart2);
        }
    }
}
