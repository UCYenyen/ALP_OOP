package model;

public class SickPerson extends Person {
    private String illness;

    public SickPerson(String name, double money, double physicalHealth, double mentalHealth, double spiritualHealth, String illness) {
        super(name, money, physicalHealth, mentalHealth, spiritualHealth);
        this.illness = illness;
    }
}
