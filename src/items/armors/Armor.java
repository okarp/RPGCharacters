package items.armors;
import interfaces.Levelable;
import items.*;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * An abstract class for Armors. Extends the Item class.
 *
 */

public abstract class Armor extends Item implements Levelable {
    protected int health;
    protected int dex;
    protected int intelligence;
    protected int strength;
    //Type of armor
    protected ArmorType type;

    public Armor(String name, int level, int intelligence, int strength, int dex, int health, ArmorType type, EquipmentSlot slot){
        super(name,level,ItemType.ARMOR, slot);
        this.intelligence = intelligence;
        this.strength = strength;
        this.dex = dex;
        this.health = health;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item stats for: " + this.name + "\n"
                + "Armor type: " + this.type + "\n"
                + "Slot: " + this.slot + "\n"
                + "Armor level: " + this.level + "\n"
                + "Bonus HP: " + this.health + "\n"
                + "Bonus Str: " + this.strength + "\n"
                + "Bonus Dex: " + this.dex+ "\n"
                + "Bonus Int: " +this.intelligence +"\n";
    }

    public int getHealth() {
        return health;
    }

    public int getDex() {
        return dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }
}


