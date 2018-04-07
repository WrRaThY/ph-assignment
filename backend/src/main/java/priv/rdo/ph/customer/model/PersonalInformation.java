package priv.rdo.ph.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PersonalInformation {
    private final String firstname;
    private final String lastname;
    private final int age;
}
