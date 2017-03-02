package pl.sda.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {

    private String firstName;
    private String lastName;
    private List<String> childrenNames = new ArrayList<>();

    private Map<String, Address> addresses = new HashMap<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(List<String> childrenNames) {
        this.childrenNames = childrenNames;
    }
}
