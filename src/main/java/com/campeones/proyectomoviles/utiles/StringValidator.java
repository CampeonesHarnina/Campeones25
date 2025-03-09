package com.campeones.proyectomoviles.utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

    private String regex = "^[a-zA-Z0-9_@#%$€&!?¿¡'/*.,\\sáéíóúÁÉÍÓÚñÑ]*$";

    public boolean isValid(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
