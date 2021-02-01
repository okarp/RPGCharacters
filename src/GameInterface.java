import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.EquipmentSlot;
import items.armors.ClothArmor;
import items.armors.LeatherArmor;
import items.armors.PlateArmor;
import items.weapons.MagicWeapon;
import items.weapons.MeleeWeapon;
import items.weapons.RangedWeapon;

public class GameInterface {
    public void run() {

        //create some heroes
        Mage mage = new Mage("wizard");
        Ranger ranger = new Ranger("ranger");
        Warrior warrior = new Warrior("warrior");

        //level the heroes up
        warrior.gainXp(1200);

        for (int i = 0; i < 11 ; i++) {
            ranger.levelUp();
            mage.levelUp();
        }

        System.out.println(mage);
        System.out.println(warrior);
        System.out.println(ranger);

        //create weapons and print them out
        MagicWeapon wand = new MagicWeapon("wand", 1);
        System.out.println(wand);
        MeleeWeapon axe = new MeleeWeapon("Great Axe of the Exiled", 5);
        System.out.println(axe);
        RangedWeapon bow = new RangedWeapon("Long bow of the lone wolf", 10);
        System.out.println(bow);

        //create armors and print them out
        ClothArmor clothLeggings = new ClothArmor("Cloth leggings", 8, EquipmentSlot.LEGSLOT);
        LeatherArmor leatherCap = new LeatherArmor("A weak Leather Cap", 3, EquipmentSlot.HEADSLOT);
        PlateArmor plateBody = new PlateArmor("Plate chest of the Juggernaut", 5, EquipmentSlot.BODYSLOT);
        PlateArmor strongPlateBody = new PlateArmor("Plate chest of the Juggernaut", 15, EquipmentSlot.BODYSLOT);
        ClothArmor weakClothBody = new ClothArmor("Rugged cloth armor", 1, EquipmentSlot.BODYSLOT);

        System.out.println(clothLeggings);
        System.out.println(plateBody);
        System.out.println(strongPlateBody);

        //equip same armor and weapon as in spec document. Print out warriors stats and attack to show damage.
        warrior.equip(plateBody);
        System.out.println(warrior);
        warrior.equip(axe);
        warrior.attack();

        //equip will fail, armor level > hero level
        warrior.equip(strongPlateBody);

        //equip some more items and print out warrior to show stat change
        warrior.equip(leatherCap);
        warrior.equip(clothLeggings);
        System.out.println(warrior);

        //equip new body armor with weaker stats
        warrior.equip(weakClothBody);
        System.out.println(warrior);

        mage.equip(wand);

        //character attacking another character
        //(mage will die here, but no actual logic 'death'-logic implemented apart from print out).
        warrior.attack(mage);
        mage.attack(warrior);
        warrior.attack(mage);
        warrior.attack(mage);
    }
}
