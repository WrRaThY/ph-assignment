package priv.rdo.ph.customer.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //jackson
@AllArgsConstructor
@Getter
public class StatusUpdateRequest {
    @NotNull
    private CustomerStatus newStatus;
}
