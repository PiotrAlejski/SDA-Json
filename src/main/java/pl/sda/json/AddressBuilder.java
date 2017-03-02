package pl.sda.json;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;

/**
 * Created by RENT on 2017-03-02.
 */
public class AddressBuilder {

    private Address address = new Address();

    public AddressBuilder withStreet(String street){
        address.setStreet(street);
        return this;
    }

    public AddressBuilder withCode(String code) {
        address.setCode(code);
        return this;
    }

    public AddressBuilder withCity(String city) {
        address.setCity(city);
        return this;
    }

    public Address build() {
        return address;
    }
}
