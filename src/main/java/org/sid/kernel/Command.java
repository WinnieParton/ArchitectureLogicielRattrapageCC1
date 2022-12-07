package org.sid.kernel;

public interface Command {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
