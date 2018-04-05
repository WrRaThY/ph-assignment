package priv.rdo.ph.customer.model;

import javax.validation.constraints.NotNull;

public class StatusUpdateRequest {
    @NotNull
    private final CustomerStatus newStatus;

    StatusUpdateRequest(CustomerStatus newStatus) {
        this.newStatus = newStatus;
    }

    public CustomerStatus getNewStatus() {
        return newStatus;
    }
}
