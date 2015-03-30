package ar.com.carloscurotto.kryo.model;

import org.apache.commons.lang3.Validate;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private Address address;

    public Person(final String theFirstName, final String theLastName, final Integer theAge,
            final Address theAddress) {
        Validate.notBlank(theFirstName, "The first name cannot be blank.");
        Validate.notBlank(theLastName, "The last name cannot be blank.");
        Validate.notNull(theAge, "The age cannot be null.");
        Validate.notNull(theAddress, "The address cannot be null.");
        firstName = theFirstName;
        lastName = theLastName;
        age = theAge;
        address = theAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Person) {
            final Person other = (Person) object;
            return Objects.equal(firstName, other.firstName)
                    && Objects.equal(lastName, other.lastName) && Objects.equal(age, other.age)
                    && Objects.equal(address, other.address);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, age, address);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("firstName", firstName)
                .add("lastName", lastName).add("age", age).add("address", address).toString();
    }

}
