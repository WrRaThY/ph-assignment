package priv.rdo.ph.customer.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonalInformation {
    private final String firstname;
    private final String lastname;
    private final int age;

    public PersonalInformation(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstname", firstname)
                .append("lastname", lastname)
                .append("age", age)
                .toString();
    }
}
