package factory.beans;

import factory.Doc;

public class Contract implements Doc {
    private final String CONTRACTNAME = "Contract";
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Contract() {
    }

    public String getDocName() {
        return this.CONTRACTNAME;
    }
}