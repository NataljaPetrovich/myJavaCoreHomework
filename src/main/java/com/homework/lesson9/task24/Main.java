package main.java.com.homework.lesson9.task24;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ElectricalAppliance[] myAppliance = new ElectricalAppliance[3];
        myAppliance[0] = new Toaster("Bosh14","Bosh","Mix food");
        myAppliance[1] = new Mixer("Vitec12-01", "Vitec", "For mixing liquid food.");
        myAppliance[2] = new Iron("Bosh221", "Bosh");

        myAppliance[1].switchON();
        myAppliance[2].switchON();
        myAppliance[2].functioning();
        for (ElectricalAppliance apl : myAppliance) {
            apl.functioning();
            apl.showStatus();
        }
    }
}
