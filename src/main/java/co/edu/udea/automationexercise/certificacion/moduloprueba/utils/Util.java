package co.edu.udea.automationexercise.certificacion.moduloprueba.utils;

public class Util {

    private Util() {}

    /** Genera un email que no se repite entre ejecuciones (el sitio rechaza emails ya registrados). */
    public static String uniqueEmail(String prefix) {
        return prefix + "." + System.currentTimeMillis() + "@test.com";
    }
}
