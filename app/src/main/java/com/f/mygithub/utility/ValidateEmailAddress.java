package com.f.mygithub.utility;

public class ValidateEmailAddress {
    private final String emailAdress;

    public ValidateEmailAddress(String emailAdress){
        this.emailAdress = emailAdress;
    }

    public boolean validate(){
        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
        return emailAdress.matches(regx);
    }
}
