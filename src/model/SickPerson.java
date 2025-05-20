package model;


public class SickPerson extends Person {
    private String illness;

    public SickPerson(String name, String illness) {
        super(name);
        this.illness = illness;
        physicalHealth = initialPhysicalHealth();
        mentalHealth = initialMentalHealth();
    }

    private int initialPhysicalHealth(){
        switch(illness) {
            case "Diabetes":
                return 1;
            case "Hypertension":
                return 10;
            case "Asthma":
                return 15;
            case "Arthritis":
                return 15;
            case "Influenza":
                return 5;
            case "GERD":
                return 15;
            case "Pneumonia":
                return 10;
            case "Depression":
                return r.nextInt(10, 31);
            case "Anxiety Disorder":
                return r.nextInt(10, 31);
            case "Bipolar Disorder":
                return r.nextInt(10, 31);
        }
        return 0;
    }

    private int initialMentalHealth(){
        switch(illness) {
            case "Diabetes":
                return r.nextInt(10, 31);
            case "Hypertension":
                return r.nextInt(10, 31);
            case "Asthma":
                return r.nextInt(10, 31);
            case "Arthritis":
                return r.nextInt(10, 31);
            case "Influenza":
                return r.nextInt(10, 31);
            case "GERD":
                return r.nextInt(10, 31);
            case "Pneumonia":
                return r.nextInt(10, 31);
            case "Depression":
                return 1;
            case "Anxiety Disorder":
                return 10;
            case "Bipolar Disorder":
                return 5;
        }
        return 0;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
