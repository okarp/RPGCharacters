package items.weapons;
import heroes.Hero;
import interfaces.Levelable;
import items.*;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * An abstract class for weapons. Extends the Item class.
 *
 */

public abstract class Weapon extends Item implements Levelable {

    protected int baseDmg;
    //slot the weapon goes into.
    protected EquipmentSlot slot;
    protected WeaponType weaponType;
    //damage after scaling base damage with level
    protected int damage;

    public Weapon(String name, int baseDmg, WeaponType weaponType, int level, EquipmentSlot slot) {
        super(name, level, ItemType.WEAPON, slot);
        this.baseDmg = baseDmg;
        this.weaponType = weaponType;
    }

    //used to calculate attack damage according to heroes stats
    public abstract int getEffectiveDamage(Hero hero);

    @Override
    public String toString() {
        return "Item stats for: " + this.name + "\n"
                + "Weapon type: " + this.weaponType + "\n"
                + "Weapon level: " + this.level + "\n"
               + "Damage: " + this.damage + "\n";
    }
}

