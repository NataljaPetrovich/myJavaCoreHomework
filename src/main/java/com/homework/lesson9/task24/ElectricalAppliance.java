package main.java.com.homework.lesson9.task24;

/**
 * The type Electrical appliance.
 */
abstract class ElectricalAppliance {
    /**
     * The Name.
     */
    String name;
    /**
     * The Manufacturer.
     */
    String manufacturer;
    /**
     * The Is on.
     */
    boolean isON;

    /**
     * Instantiates a new Electrical appliance.
     *
     * @param name         the name
     * @param manufacturer the manufacturer
     */
    public ElectricalAppliance(final String name, final String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    /**
     * Switch on.
     */
    public void switchON() {
        this.isON = true;
    }

    /**
     * Switch off.
     */
    public void switchOFF() {
        this.isON = false;
    }


    /**
     * Show status.
     */
    abstract void showStatus();

    /**
     * Functioning.
     */
    abstract void functioning();
}
