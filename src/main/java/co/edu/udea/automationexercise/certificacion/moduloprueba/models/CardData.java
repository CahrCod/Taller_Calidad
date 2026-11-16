package co.edu.udea.automationexercise.certificacion.moduloprueba.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CardData {

    private final String nameOnCard;
    private final String number;
    private final String cvc;
    private final String expiryMonth;
    private final String expiryYear;

    /** Tarjeta de prueba (el sitio es de práctica y no valida pagos reales). */
    public static CardData valid() {
        return CardData.builder()
                .nameOnCard("Ana QA")
                .number("4111111111111111")
                .cvc("123")
                .expiryMonth("12")
                .expiryYear("2030")
                .build();
    }
}
