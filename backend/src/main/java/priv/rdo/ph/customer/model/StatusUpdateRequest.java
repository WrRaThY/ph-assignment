package priv.rdo.ph.customer.model;

import javax.validation.constraints.NotNull;

public class StatusUpdateRequest {
    @NotNull
    private CustomerStatus newStatus;

    private StatusUpdateRequest() {
    }

    StatusUpdateRequest(CustomerStatus newStatus) {
        this.newStatus = newStatus;
    }

    public CustomerStatus getNewStatus() {
        return newStatus;
    }
}
