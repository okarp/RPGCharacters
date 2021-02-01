package items.weapons;

import heroes.Hero;
import items.EquipmentSlot;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * A concrete class for Magic type weapon. All weapons have a different base damage and their damages scale
 * differently on level up. Every weapon type also has different effective damage, depending on heroes stats.
 */

public class MagicWeapon extends Weapon{
    private final int BASE_DMG = 25;

    public MagicWeapon(String name, int level){
        //initialize new magic weapon with name, base damage, magic type, level and slot it fits into.
        //scale it's damage accordingly
        super(name, 25, WeaponType.MAGIC, level, EquipmentSlot.WEAPONSLOT);
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
        this.damage = BASE_DMG + (2 * this.getLevel());
    }

    //implementation of EffectiveDamage method, effective damage depends on heroes stats.
    @Override
    public int getEffectiveDamage(Hero hero){
        return (hero.getBonusIntelligence() + hero.getIntelligence()) * 3 + this.damage;
    }
}
