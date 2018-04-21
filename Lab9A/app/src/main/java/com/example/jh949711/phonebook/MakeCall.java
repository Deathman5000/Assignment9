package com.example.jh949711.phonebook;

/**
 * Created by Kyra on 4/20/18.
 */

public class MakeCall {

    private String firstName, lastName, phoneNumber;

    public MakeCall() {

    }

    public MakeCall(String f, String l, String p){
        firstName = f;
        lastName = l;
        phoneNumber = p;
    }

    public void setFirstName(String f) { firstName = f; }

    public void setLastName(String l) { lastName = l; }

    public void setPhoneNumber(String p) { phoneNumber = p; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPhoneNumber() { return phoneNumber; }


}
