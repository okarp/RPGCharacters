package items.armors;

import items.EquipmentSlot;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Cloth type armors.
 * Has base stats, constructor and a scaleStats method to scale the stats according to armors level.
 *
 */

public class ClothArmor extends Armor{

    private final int BASE_HEALTH = 10;
    private final int BASE_INTELLIGENCE = 3;
    private final int BASE_DEX = 1;

    public ClothArmor(String name, int level, EquipmentSlot slot){
        //initialize cloth armor with 3 int, 0 strength, 1 dex, 10 hp, cloth type and slot it fits in.
        super(name,level,3,0,1,10, ArmorType.CLOTH, slot);
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
        this.health = (int) ((BASE_HEALTH + 5 * this.level) * scaleValue);
        this.intelligence = (int) ((BASE_INTELLIGENCE + 2 * this.level) * scaleValue);
        this.dex = (int) ((BASE_DEX + this.level) * scaleValue);
    }
}
