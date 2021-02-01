package heroes;

import items.EquipmentSlot;
import items.armors.Armor;
import items.weapons.Weapon;

/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Concrete Equipment class. Class holds and equips heroes equipment.
 * Equip method is called from hero class to equip items.
 *
 */

public class Equipment{
    //hero has a head, body and leg armor and a main hand weapon.
    private Armor head;
    private Armor body;
    private Armor leg;
    private Weapon mainHand;

    //returns the previous armor the slot held (null if slot was empty).
    //this is done to remove bonus stats associated with the previous armor.
    public Armor equip(Armor armor) {
        Armor previousArmor = null;
            //slot the new armor has
            EquipmentSlot slot = armor.getSlot();
            if (slot.equals(EquipmentSlot.HEADSLOT)) {
                if (head != null)
                    previousArmor = head;
                this.head = armor;
            }
            if (slot.equals(EquipmentSlot.BODYSLOT)) {
                if (body != null)
                    previousArmor = body;
                this.body = armor;
            }
            if (slot.equals(EquipmentSlot.LEGSLOT))
                if(leg != null){
                    previousArmor = leg;
                this.leg = armor;
        }
            return previousArmor;
    }

    public void equip(Weapon weapon){
           this.mainHand = weapon;
    }

    public Weapon getWeapon(){
        return this.mainHand;
    }

}
