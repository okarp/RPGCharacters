package items.armors;

import items.EquipmentSlot;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Plate type armors.
 * Has base stats, constructor and a scaleStats method to scale the stats according to armors level.
 *
 */

public class PlateArmor extends Armor{
    private final int BASE_HEALTH = 30;
    private final int BASE_STRENGTH = 3;
    private final int BASE_DEX = 1;

    public PlateArmor(String name, int level, EquipmentSlot slot){
        //initialize plate armor with 0 int, 3 strength, 2 dex, 30 hp, plate type and slot it fits in.
        super(name,level,0,3,2,30, ArmorType.PLATE, slot);
        this.scaleStats();
    }

    @Override
    public void levelUp() {
        this.level += 1;
    }

    @Override
    public void scaleStats() {
        //get the scaling value depending on items slot e.g. leg armor has a scale value of 0.6
        double scaleValue = this.slot.getScaler();
        this.health = (int) ((BASE_HEALTH + 12 * this.level) * scaleValue);
        this.strength = (int) ((BASE_STRENGTH + 2 * this.level) * scaleValue);
        this.dex = (int) ((BASE_DEX + this.level) * scaleValue);
    }
}
