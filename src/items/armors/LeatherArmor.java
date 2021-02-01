package items.armors;

import items.EquipmentSlot;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Leather type armors.
 * Has base stats, constructor and a scaleStats method to scale the stats according to armors level.
 *
 */

public class LeatherArmor extends Armor{
    private final int BASE_HEALTH = 20;
    private final int BASE_STRENGTH = 1;
    private final int BASE_DEX = 3;

    public LeatherArmor(String name, int level, EquipmentSlot slot){
        //initialize leather armor with 0 int, 1 strength, 3 dex, 20 hp, leather type and slot it fits in.
        super(name,level,0,1,3,20, ArmorType.LEATHER, slot);
        this.scaleStats();
    }

    @Override
    public void levelUp() {
        this.level += 1;
        this.scaleStats();
    }

    @Override
    public void scaleStats() {
        //get the scaling value depending on items slot e.g. leg armor has scale value of 0.6
        double scaleValue = this.slot.getScaler();
        this.health = (int) ((BASE_HEALTH + 8 * this.level) * scaleValue);
        this.strength = (int) ((BASE_STRENGTH + this.level) * scaleValue);
        this.dex = (int) ((BASE_DEX + 2 * this.level) * scaleValue);
    }
}
