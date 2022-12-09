package org.sid.shoppingcard.domain;

import java.util.Objects;
import java.util.UUID;

public final class ClientId {
    private UUID value;

    public ClientId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public static ClientId of(UUID value) {
        return new ClientId(value);
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClientId clientId = (ClientId) o;
        return Objects.equals(value, clientId.value);
    }

    @Override
    public String toString() {
        return "ClientId {value:'" + value + '\'' + '}';
    }

}
