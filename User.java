package pl.pafc.userdatabase;

import android.content.Context;

import java.io.Serializable;


public class User implements Serializable {

    private String pesel   = "";
    private String name    = "";
    private String address = "";
    private transient String street  = "";
    private transient String bNumber = "";
    private transient String aNumber = "";
    private String email   = "";
    private static Context context;


    User() {
    }
    public User (Context c) {
        context = c;
    }

    //getter
    String getPesel() {
        return pesel;
    }
    String getName() {
        return name;
    }
    String getEmail() {
        return email;
    }
    String getAddress() {
        return address;
    }

    //setter
    void setPesel (String pesel) {
        String line = "";
        String tPesel = "";

        this.pesel = pesel;
        //TODO sprawdzic te metode, aby czytala z pliku czy pesel istnieje
//        AddUserActivity addUserAcctivity = new AddUserActivity();
//
//        if (pesel.length() != 11) {
//            tPesel = "empty";
//        } else if (addUserAcctivity.readFromFile(line).contains(pesel)) {
//            tPesel = "empty";
//        }
//
//        if (!tPesel.equals("empty")) {
//            this.pesel = pesel;
//        }
    }

    void setName(String name) {
        this.name = name;
    }
    void setStreet(String street) {
        this.street = street;
    }
    void setaNumber(String aNumber) {
        this.aNumber = aNumber;
    }
    void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }
    void setAddress(String address) {
        this.address = address;
    }
    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.pesel + ", " + this.name + ", " + this.street + " " + this.bNumber + "/" + this.aNumber + ", " + this.email;
    }
}
