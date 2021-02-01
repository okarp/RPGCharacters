package heroes;

import interfaces.Levelable;
import items.armors.Armor;
import items.weapons.Weapon;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * An abstract parent class for heroes. Class has some concrete functionality that is shared with every hero,
 * such as equipping items and gaining xp.
 *
 */

public abstract class Hero implements Levelable{

    protected int baseXpToLvl;
    protected int level;
    protected int xpToNextLvl;
    //total xp gained
    protected int totalXp;
    //base stats
    protected int health;
    protected int strength;
    protected int dex;
    protected int intelligence;
    //separating bonus stats from base stats
    protected int bonusHealth;
    protected int bonusDex;
    protected int bonusStrength;
    protected int bonusIntelligence;
    protected String name;
    protected Equipment equipment;

    public Hero(String name, int health, int level, int strength, int dex, int intelligence){
        this.name = name;
        this.health = health;
        this.level = level;
        this.strength = strength;
        this.dex = dex;
        this.intelligence = intelligence;
        this.baseXpToLvl = 100;
        this.xpToNextLvl = 100;
        this.equipment = new Equipment();
    }

    //adds armors stats to bonus stats
    public void addBonusStats(Armor armor){
        this.bonusHealth += armor.getHealth();
        this.bonusDex += armor.getDex();
        this.bonusIntelligence += armor.getIntelligence();
        this.bonusStrength += armor.getStrength();
    }

    //removes armors bonus stats
    public void removeBonusStats(Armor armor){
        this.bonusHealth -= armor.getHealth();
        this.bonusDex -= armor.getDex();
        this.bonusIntelligence -= armor.getIntelligence();
        this.bonusStrength -= armor.getStrength();
    }

    //calls equipment to equip an armor.
    public void equip(Armor armor){
        Armor previous = null;
        //if hero meets level requirements equip the armor
        if (this.level >= armor.getLevel()) {
            previous = this.equipment.equip(armor);
            //if method returned an armor remove the bonus stats
            if (previous != null)
                this.removeBonusStats(previous);
            this.addBonusStats(armor);
        }else
            System.out.println("Hero can't equip this armor.\n");
    }

    //equip weapon and update attack damage accordingly
    public void equip(Weapon weapon){
        if(this.level >= weapon.getLevel())
            this.equipment.equip(weapon);
    }

    //method for gaining xp
    public void gainXp(int xp) {
        if (this.xpToNextLvl - xp <= 0) {
            //If gaining xp more than level up requires, loop so hero levels multiple times.
            while (this.xpToNextLvl - xp <= 0) {
                xp = xp - this.xpToNextLvl;
                this.levelUp();
            }
        }
        //add remaining xp to totalxp
        this.totalXp += xp;
        //subtract gained xp from xpToNextLvl
        this.xpToNextLvl = this.xpToNextLvl - xp;
    }

    //method for taking damage, prints out whether hero lives or dies.
    public void takeDamage(int damage) {
        System.out.println(this.name + " takes " + damage + "damage!");
        this.health -= damage;
        if (this.health > 0)
            System.out.println("Whew. " + this.name + " lives to see another day. HP left: " + this.health +"\n");
        else
            System.out.println("Aww - " + this.name + " dies tragically :-( \n");
    }

    //heroes can attack with or without a target
    public abstract void attack(Hero another);

    public abstract void attack();

    @Override
    public String toString() {
        return this.name + " details: \n" +
                "Hero is type of: " + this.getClass().getSimpleName() +"\n" +
                "HP: " + (this.health + this.bonusHealth) + "\n"+
                "Str: " + (this.strength + this.bonusStrength) + "\n"+
                "Dex: " + (this.dex + this.bonusDex) + "\n"+
                "Int: " + (this.intelligence + this.bonusIntelligence) + "\n"+
                "Lvl: " + this.level + "\n"+
                "Total XP: " +this.totalXp +"\n"+
                "XP to next: " +this.xpToNextLvl + "\n";
    }

    public int getLevel(){
        return this.level;
    }

    public int getBonusDex() {
        return bonusDex;
    }

    public int getBonusStrength() {
        return this.bonusStrength;
    }

    public int getBonusIntelligence() {
        return bonusIntelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDex() {
        return dex;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getName(){ return this.name; }

    public int getHealth(){ return this.health; }
}


