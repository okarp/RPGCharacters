package items.weapons;

import heroes.Hero;
import items.EquipmentSlot;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Ranged type weapons. All weapons have a different base damage and their damages scale
 * differently on level up. Every weapon type also has different effective damage, depending on heroes stats.
 *
 */

public class RangedWeapon extends Weapon{
    private final int BASE_DMG = 5;


    public RangedWeapon(String name, int level){
        //initialize new ranged weapon with name, base damage, ranged type, level and slot it fits into.
        //scale it's damage accordingly
        super(name, 5, WeaponType.RANGED, level, EquipmentSlot.WEAPONSLOT);
        this.scaleStats();
    }

    @Override
    public void levelUp() {
        this.level +=1;
        this.scaleStats();
    }

    //scales weapons damage according to it's level
    @Override
    public void scaleStats() {
        this.damage = BASE_DMG + (this.getLevel() * 3);
    }

    //implementation of EffectiveDamage method, effective damage depends on heroes stats.
    @Override
    public int getEffectiveDamage(Hero hero){
        return (hero.getDex() + hero.getBonusDex()) * 2 + this.damage;
    }
}
