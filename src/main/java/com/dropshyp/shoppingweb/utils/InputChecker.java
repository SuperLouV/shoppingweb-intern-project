package com.dropshyp.shoppingweb.utils;

import java.util.regex.Pattern;


/**
* @Description: check Email
* @Param: 
* @return:
*/
public class InputChecker {
    public boolean emailChecker(String email) {
        String pattern = "^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.matches(pattern, email);
    }

}
