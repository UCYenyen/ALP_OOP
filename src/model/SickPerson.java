package model;

public class SickPerson extends Person {
    private String illness;
    private Medicine medicine;

    public SickPerson(String name, String illness, Medicine medicine) {
        super(name);
        this.illness = illness;
        this.medicine = medicine;

        //#region Physical Health
        switch(illness) {
            case "Diabetes":
                physicalHealth = 1;
            case "Hypertension":
                physicalHealth = 10;
            case "Asthma":
                physicalHealth = 15;
            case "Arthritis":
                physicalHealth = 15;
            case "Influenza":
                physicalHealth = 5;
            case "GERD":
                physicalHealth = 15;
            case "Pneumonia":
                physicalHealth = 10;
            case "Depression":
                physicalHealth = r.nextInt(10, 31);
            case "Anxiety Disorder":
                physicalHealth = r.nextInt(10, 31);
            case "Bipolar Disorder":
                physicalHealth = r.nextInt(10, 31);
        }
        //#endregion

        //#region Mental Health
        switch(illness) {
            case "Diabetes":
                mentalHealth = r.nextInt(10, 31);
            case "Hypertension":
                mentalHealth = r.nextInt(10, 31);
            case "Asthma":
                mentalHealth = r.nextInt(10, 31);
            case "Arthritis":
                mentalHealth = r.nextInt(10, 31);
            case "Influenza":
                mentalHealth = r.nextInt(10, 31);
            case "GERD":
                mentalHealth = r.nextInt(10, 31);
            case "Pneumonia":
                mentalHealth = r.nextInt(10, 31);
            case "Depression":
                mentalHealth = 1;
            case "Anxiety Disorder":
                mentalHealth = 10;
            case "Bipolar Disorder":
                mentalHealth = 5;
        }
        //#endregion
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
