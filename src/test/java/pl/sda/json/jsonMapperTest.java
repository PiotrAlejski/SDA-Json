package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by RENT on 2017-03-02.
 */
public class jsonMapperTest {
    @Test
    public void test1() throws IOException {

        String jsonToDeserialize = "{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"childrenNames\":[\"Marek\",\"Zosia\"],\"addresses\":{\"Work\":{\"street\":\"Mokotowska\",\"code\":\"66-666\",\"city\":\"Warszawa\"},\"Home\":{\"street\":\"Baraniaka\",\"code\":\"11-111\",\"city\":\"Poznan\"}}}\n";

        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(jsonToDeserialize, User.class);

        Assert.assertEquals("Jan", user.getFirstName());

        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);

        Assert.assertTrue(user.getChildrenNames().size() == 2);
        Assert.assertEquals(Arrays.asList("Marek", "Zosia"), user.getChildrenNames());

    }

    @Test
    public void test2() throws IOException {
        User user = new UserBuilder()
                .withFirstName("Janek")
                .withLastName("Kaczmarek")
                .withAddress("Work", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Nowa").build())
                .withAddress("Home", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Domowa").build())
                .withChildrenNames(Arrays.asList("Tomek", "Ola"))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);

        Assert.assertTrue(serializedObject.contains("Jan"));
        Assert.assertTrue(serializedObject.contains("Kowalski"));
        Assert.assertTrue(serializedObject.contains("Zosia"));
    }

    @Test
    public void test3() throws IOException {
        User user = new UserBuilder()
                .withFirstName("Janek")
                .withLastName("Kaczmarek")
                .withAddress("Work", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Nowa").build())
                .withAddress("Home", new AddressBuilder().withCity("Wawa").withCode("11-111").withStreet("Domowa").build())
                .withChildrenNames(Arrays.asList("Tomek", "Ola"))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObject = mapper.writeValueAsString(user);

        System.out.println(serializedObject);

    }
}
