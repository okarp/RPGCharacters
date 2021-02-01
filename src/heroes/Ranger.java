package heroes;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Concrete Ranger hero class. Every hero has an unique way of attacking and gaining stats on level up.
 * Extends abstract Hero class.
 *
 */

public class Ranger extends Hero{
    //initialize ranger hero with 120 health, 1 level, 5 strength, 10 dexterity, 2 intelligence
    public Ranger(String name) {
        super(name,120, 1, 5, 10,2);
    }

    @Override
    public void levelUp() {
        this.level += 1;
        this.scaleStats();
    }

    @Override
    public void scaleStats() {
        this.health += 20;
        this.dex += 5;
        this.strength += 2;
        this.intelligence += 1;
        this.totalXp += xpToNextLvl;
        this.baseXpToLvl += (int)(this.baseXpToLvl * 0.1);
        this.xpToNextLvl = this.baseXpToLvl;

    }
    @Override
    public void attack() {
        if (this.equipment.getWeapon() == null)
            System.out.println("No weapon equipped. Hitting for 0 dmg");
        else {
            int attackDmg = equipment.getWeapon().getEffectiveDamage(this);
            System.out.println(this.name + " attacks sneakily! Does " + attackDmg + " damage.");
        }
    }

    @Override
    public void attack(Hero another) {
        if (this.equipment.getWeapon() == null)
            System.out.println("No weapon equipped. Hitting for 0 dmg");
        else {
            int attackDmg = this.equipment.getWeapon().getEffectiveDamage(this);
            System.out.println(this.name + " attacks: '" + another.getName() + "' swiftly! Does " + attackDmg +" damage.");
            another.takeDamage(attackDmg);
        }
    }
}