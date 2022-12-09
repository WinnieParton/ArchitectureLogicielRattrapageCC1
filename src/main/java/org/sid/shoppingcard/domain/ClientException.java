package org.sid.shoppingcard.domain;

public class ClientException extends RuntimeException {

    private ClientException(String message) {
        super(message);
    }

    public static ClientException notFoundClientId(ClientId clientId) {
        return new ClientException(String.format("%s not found.", clientId.getValue()));
    }
}
