package heroes;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Concrete Warrior hero class. Every hero has a unique way of attacking and gaining stats on level up.
 * Extends abstract Hero class.
 *
 */

public class Warrior extends Hero {
    //initialize warrior hero with 150 health, 1 level, 10 strength, 3 dexterity, 1 intelligence
    public Warrior(String name) {
        super(name,150, 1, 10, 3,1);
    }

    @Override
    public void levelUp() {
        this.level += 1;
        this.scaleStats();
    }

    @Override
    public void scaleStats() {
        this.health += 30;
        this.dex += 2;
        this.strength += 5;
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
            System.out.println(this.name + " attacks with brute force! Does " + attackDmg + " damage." + "\n");
        }
    }

    @Override
    public void attack(Hero another) {
        if (this.equipment.getWeapon() == null)
            System.out.println("No weapon equipped. Hitting for 0 dmg");
        else {
            int attackDmg = this.equipment.getWeapon().getEffectiveDamage(this);
            System.out.println(this.name + " attacks: '" + another.getName() + "' with brute force! Does " + attackDmg +" damage");
            another.takeDamage(attackDmg);
        }
    }
}