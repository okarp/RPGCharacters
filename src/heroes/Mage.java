package heroes;

/**
 *
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Concrete Mage hero class. Every hero has a unique way of attacking and gaining stats on level up.
 * Extends abstract Hero class.
 *
 */

public class Mage extends Hero {
    //initialize mage hero with 100 health, 1 level, 2 strength, 3 dexterity, 10 intelligence
    public Mage(String name) {
        super(name,100, 1, 2, 3, 10);
    }

    //on level up gain one level and scale stats accordingly
    @Override
    public void levelUp() {
        this.level += 1;
        this.scaleStats();
    }

    @Override
    public void scaleStats() {
        this.health += 15;
        this.dex += 2;
        this.strength += 1;
        this.intelligence += 5;
        this.totalXp += xpToNextLvl;
        this.baseXpToLvl += (int)(this.baseXpToLvl * 0.1);
        this.xpToNextLvl = this.baseXpToLvl;
    }

    @Override
    public void attack() {
        if (this.equipment.getWeapon() == null)
            System.out.println("No weapon equipped. Hitting for 0 dmg");
        else {
            int attackDmg = this.equipment.getWeapon().getEffectiveDamage(this);
            System.out.println("The wise " + this.name + "attacks! Does: " + attackDmg + " damage.");
        }
    }

    @Override
    public void attack(Hero another) {
        if (this.equipment.getWeapon() == null)
            System.out.println("No weapon equipped. Hitting for 0 dmg");
        else {
            int attackDmg = this.equipment.getWeapon().getEffectiveDamage(this);
            System.out.println(this.name + " attacks: '" + another.getName() + "' with might! Does " + attackDmg +" damage.");
            another.takeDamage(attackDmg);
        }
    }
}