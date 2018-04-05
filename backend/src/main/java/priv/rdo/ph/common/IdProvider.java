package priv.rdo.ph.common;

import java.util.UUID;

public class IdProvider {
    private IdProvider() {
    }

    public static String id() {
        return UUID.randomUUID().toString();
    }
}
