package model;

public class SickPerson extends Person {
    private String illness;
    private Medicine medicine;

    public SickPerson(String name, Job job, String illness, Medicine medicine) {
        super(name, job);
        this.illness = illness;
        this.medicine = medicine;

        //#region Physical Health
        switch(illness) {
            case "Diabetes":
                physicalHealth = 1;
                break;
            case "Hypertension":
                physicalHealth = 10;
                break;
            case "Asthma":
                physicalHealth = 15;
                break;
            case "Arthritis":
                physicalHealth = 15;
                break;
            case "Influenza":
                physicalHealth = 5;
                break;
            case "GERD":
                physicalHealth = 15;
                break;
            case "Pneumonia":
                physicalHealth = 10;
                break;
            case "Depression":
                physicalHealth = r.nextInt(10, 31);
                break;
            case "Anxiety Disorder":
                physicalHealth = r.nextInt(10, 31);
                break;
            case "Bipolar Disorder":
                physicalHealth = r.nextInt(10, 31);
                break;
        }
        //#endregion

        //#region Mental Health
        switch(illness) {
            case "Diabetes":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Hypertension":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Asthma":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Arthritis":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Influenza":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "GERD":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Pneumonia":
                mentalHealth = r.nextInt(10, 31);
                break;
            case "Depression":
                mentalHealth = 5;
                break;
            case "Anxiety Disorder":
                mentalHealth = 10;
                break;
            case "Bipolar Disorder":
                mentalHealth = 1;
                break;
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
