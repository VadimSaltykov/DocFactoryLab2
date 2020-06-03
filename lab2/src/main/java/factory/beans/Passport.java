package factory.beans;

import factory.Doc;

public class Passport implements Doc {
    private final String PASSPORTNAME = "Passport";
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Passport() {
    }

    public String getDocName() {
        return this.PASSPORTNAME;
    }
}