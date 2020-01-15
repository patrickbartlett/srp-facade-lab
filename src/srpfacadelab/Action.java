package srpfacadelab;

public class Action {

    protected static void calculateStats(RpgPlayer player) {
        for (Item i: player.inventory) {
            player.armour += i.getArmour();
        }
    }

    protected static void takeDamage(RpgPlayer player, int damage) {
        if (damage < player.armour) {
            player.gameEngine.playSpecialEffect("parry");
        }
        if (InventoryManager.calculateInventoryWeight(player) < player.carryingCapacity / 2) {
            damage *= .75;
        }

        int damageToDeal = damage - player.armour;
        player.health -= damageToDeal;

        player.gameEngine.playSpecialEffect("lots_of_gore");
    }
}
