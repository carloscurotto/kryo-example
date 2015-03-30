package ar.com.carloscurotto.kryo.model;

import org.apache.commons.lang3.Validate;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Address {

    private String streetName;
    private Integer streetNumber;
    private String city;
    private String zip;

    public Address(final String theStreetName, final Integer theStreetNumber, final String theCity, final String theZip) {
        Validate.notBlank(theStreetName, "The street name cannot be blank.");
        Validate.notNull(theStreetNumber, "The street number cannot be null.");
        Validate.notBlank(theCity, "The city cannot be blank.");
        Validate.notBlank(theZip, "The zip cannot be blank.");
        streetName = theStreetName;
        streetNumber = theStreetNumber;
        city = theCity;
        zip = theZip;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Address) {
            final Address other = (Address) object;
            return Objects.equal(streetName, other.streetName)
                    && Objects.equal(streetNumber, other.streetNumber)
                    && Objects.equal(city, other.city) && Objects.equal(zip, other.zip);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(streetName, streetNumber, city, zip);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("streetName", streetName)
                .add("streetNumber", streetNumber).add("city", city).add("zip", zip).toString();
    }

}
