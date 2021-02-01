# RPGCharacters
Experis Academy RPGCharacters task. Java program imitating RPG game character and item functionality.

## About
The program has functionality for armors, weapons and heroes. 3 different hero classes are implemented: mage, warrior and ranger. Every hero has attributes such as strenght and dexterity, which get scaled when leveling up.

Program has implementation for 3 different type of armors currently: cloth, leather and plate armors.
Armors can be either head armor, body armor or leg armor. Every armor slot has a scale value assosicated with it, meaning that e.g. head slot scales armors stats down by 60%.

Currently there is also 3 different type of weapons: melee, magic and ranged weapons. Every weapon type gets boost to it's attack damage from it's wielders stats, melee weapons get boost from strength, ranged weapons from dexterity and magic weapons from intelligence.

Armor and Weapon class inherit from abstract Item class. Hero classes (mage, ranger, warrior) inherit from abstract Hero class. There is currently functionality for creating items, creating heroes, equpping armors and weapons to heros, leveling up and attacking.

Currently the GameInterface class of the program is creating some characters, weapons and items and demostrating the functionality by printing them out.

## Usage
to construct new hero (replace Mage with Warrior / Ranger)
```java
Mage mage = new Mage(String name);
```
to construct new Weapon (replace RangedWeapon with MeleeWeapon / MagicWeapon)
```java
RangedWeapon rangedWeapon = new RangedWeapon(String name, int level);
```
to construct new Armor (replace PlateArmor with ClothArmor / LeatherArmor and EquipmentSlot.LEGSLOT with EquipmentSlot.BODY/HEAD)
```java
ClothArmor clothLeggings = new ClothArmor(String name, int level, EquipmentSlot.LEGSLOT);
```





