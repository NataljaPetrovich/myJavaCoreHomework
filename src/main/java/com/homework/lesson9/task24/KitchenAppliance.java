package main.java.com.homework.lesson9.task24;

/**
 * The type Kitchen appliance.
 */
abstract class KitchenAppliance extends ElectricalAppliance {
    String methodOfUse;
    /**
     * Instantiates a new Kitchen appliance.
     *
     * @param name         the name
     * @param manufacturer the manufacturer
     */
    public KitchenAppliance(final String name, final String manufacturer, final String method) {
        super(name, manufacturer);
        this.methodOfUse = method;
    }

}
