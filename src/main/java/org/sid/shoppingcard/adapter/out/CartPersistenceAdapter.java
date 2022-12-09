package org.sid.shoppingcard.adapter.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.sid.shoppingcard.application.port.out.CancelCartStatePort;
import org.sid.shoppingcard.application.port.out.CreateClientPort;
import org.sid.shoppingcard.application.port.out.LoadCartPort;
import org.sid.shoppingcard.application.port.out.LoadClientPort;
import org.sid.shoppingcard.application.port.out.ValidationCartPort;
import org.sid.shoppingcard.domain.Cart;
import org.sid.shoppingcard.domain.CartException;
import org.sid.shoppingcard.domain.CartId;
import org.sid.shoppingcard.domain.Client;
import org.sid.shoppingcard.domain.ClientException;
import org.sid.shoppingcard.domain.ClientId;

public class CartPersistenceAdapter
        implements LoadCartPort, CancelCartStatePort, ValidationCartPort, CreateClientPort, LoadClientPort {

    private final Map<CartId, Cart> registry = new HashMap<>();
    private final Map<ClientId, Client> registryClient = new HashMap<>();

    @Override
    public CartId nextId() {
        return CartId.of(UUID.randomUUID());
    }

    @Override
    public void save(Cart cart) {
        registryClient.computeIfAbsent(cart.getClient().getClientId(),
                key -> {
                    throw ClientException.notFoundClientId(cart.getClient().getClientId());
                });
        try {
            registry.put(cart.getCartId(), cart);
        } catch (Exception e) {
            throw CartException.notFoundCartId(cart.getCartId());
        }
    }

    @Override
    public void update(Cart cart) {
        try {
            registry.put(cart.getCartId(), cart);
        } catch (Exception e) {
            throw CartException.notFoundCartId(cart.getCartId());
        }
    }

    @Override
    public ArrayList<Cart> findAll() {
        return new ArrayList<Cart>(registry.values());
    }

    @Override
    public Cart findById(CartId cartId) {
        return registry.computeIfAbsent(cartId,
                key -> {
                    throw CartException.notFoundCartId(cartId);
                });
    }

    @Override
    public Client findById(ClientId clientId) {
        return registryClient.computeIfAbsent(clientId,
                key -> {
                    throw ClientException.notFoundClientId(clientId);
                });
    }

    @Override
    public ClientId nextIdClient() {
        return ClientId.of(UUID.randomUUID());
    }

    @Override
    public void saveClient(Client client) {
        try {
            registryClient.put(client.getClientId(), client);
        } catch (Exception e) {
            throw ClientException.notFoundClientId(client.getClientId());
        }
    }

    @Override
    public ArrayList<Client> findAllClient() {
        return new ArrayList<Client>(registryClient.values());
    }
}