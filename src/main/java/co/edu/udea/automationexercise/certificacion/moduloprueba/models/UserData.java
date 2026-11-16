package co.edu.udea.automationexercise.certificacion.moduloprueba.models;

import co.edu.udea.automationexercise.certificacion.moduloprueba.utils.Util;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserData {

    private final String name;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String country;
    private final String state;
    private final String city;
    private final String zipcode;
    private final String mobile;

    /** Usuario válido con un email único en cada ejecución. */
    public static UserData withName(String name) {
        return UserData.builder()
                .name(name)
                .email(Util.uniqueEmail(name.toLowerCase()))
                .password("Test1234*")
                .firstName(name)
                .lastName("QA")
                .address("Calle 10 # 20-30")
                .country("Canada")
                .state("Antioquia")
                .city("Medellin")
                .zipcode("050001")
                .mobile("3001234567")
                .build();
    }
}
