package srpfacadelab;

public class RpgPlayerFacade {

    public static boolean pickUpHeal(RpgPlayer player, Item item) {
        return InventoryManager.pickUpHeal(player, item);
    }

    public static boolean pickUpItem(RpgPlayer player, Item item) {
        return InventoryManager.pickUpItem(player, item);
    }

    public static void useItem(RpgPlayer player, Item item) {
        InventoryManager.useItem(player, item);
    }

    protected static boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) {
        return InventoryManager.checkIfItemExistsInInventory(player, item);
    }

    protected static int calculateInventoryWeight(RpgPlayer player) {
        return InventoryManager.calculateInventoryWeight(player);
    }

    protected static void takeDamage(RpgPlayer player, int damage) {
        Action.takeDamage(player, damage);
    }

    protected static void calculateStats(RpgPlayer player) {
        Action.calculateStats(player);
    }
}
