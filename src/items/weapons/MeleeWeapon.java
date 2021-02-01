package items.weapons;

import heroes.Hero;
import items.EquipmentSlot;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Melee type weapon. All weapons have a different base damage and their damages scale
 * differently on level up. Every weapon type also has different effective damage, depending on heroes stats.
 *
 */

public class MeleeWeapon extends Weapon{
    private final int BASE_DMG = 15;

    public MeleeWeapon(String name, int level){
        //initialize new melee weapon with name, base damage, melee type, level and slot it fits into.
        //scale it's damage accordingly
        super(name, 15, WeaponType.MELEE, level, EquipmentSlot.WEAPONSLOT);
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
        this.damage = BASE_DMG + (this.getLevel() * 2);
    }

    //implementation of EffectiveDamage method, effective damage depends on heroes stats.
    @Override
    public int getEffectiveDamage(Hero hero){
        return (int)((hero.getStrength() + hero.getBonusStrength()) * 1.5)+ this.damage;
    }
}
