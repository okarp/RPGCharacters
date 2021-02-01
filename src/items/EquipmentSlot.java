package items;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Enums for item slots. Every armor and weapon has an equipment slot it fits into, which is associated with a scale value.
 * e.g. headslot scales armors stats by 80%.
 *
 * Weaponslots scale value is just a place holder that is currently not used.
 *
 */

public enum EquipmentSlot {

    HEADSLOT(0.8),BODYSLOT(1.0),LEGSLOT(0.6),WEAPONSLOT(1.0);

    private double scaler;

    EquipmentSlot(double scaler){
        this.scaler = scaler;
    }

    public double getScaler(){
        return this.scaler;
    }
}
