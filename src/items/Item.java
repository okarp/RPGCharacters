package items;
/**
 * Java Fullstack Upskill - Winter 2021 - Denmark/Finland. Task 3
 * Okko Partanen
 *
 * Abstract class for items. All items have a name, level, type and a slot they fit into.
 *
 */
public abstract class Item{
    protected String name;
    protected int level;
    protected ItemType itemType;
    protected EquipmentSlot slot;

    public Item(String name, int level, ItemType itemType, EquipmentSlot slot){
        this.name = name;
        this.level = level;
        this.itemType = itemType;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public EquipmentSlot getSlot(){
        return this.slot;
    }

}
