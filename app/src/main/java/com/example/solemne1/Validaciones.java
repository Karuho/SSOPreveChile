package com.example.solemne1;
import android.util.Patterns;

import java.util.regex.Pattern;

public class Validaciones {
    public boolean validateEmail(String emailV){
        return Patterns.EMAIL_ADDRESS.matcher(emailV).matches();
    }
    public boolean validatePass(String passV){
        Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,32}$");
        return pattern.matcher(passV).matches();
    }
    public boolean ValidateLongPass(String longPassV){
        boolean error = false;
        if (longPassV.length()<8){
            error = true;
        }
        if (longPassV.length()>32){
            error = true;
        }
        return error;
    }
    public boolean validateEmpty(String empty){
        boolean error = false;
        if (empty.equals("") || empty.length() == 0 || empty.trim().equals("")){
            error = true;
        }
        return error;
    }
    public boolean ValidateConfirmPass(String newPassV, String confirmPassV){
        boolean error = false;
        if (!confirmPassV.equals(newPassV)){
            error = true;
        }
        return error;
    }
}
