package srpfacadelab;

import java.util.List;

public class InventoryManager {


    protected static int calculateInventoryWeight(RpgPlayer player) {
        int sum=0;
        for (Item i: player.inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    protected static boolean checkIfItemExistsInInventory(RpgPlayer player, Item item) {
        for (Item i: player.inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    protected static void useItem(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.gameEngine.getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    protected static boolean pickUpItem(RpgPlayer player, Item item) {
        int weight = calculateInventoryWeight(player);
        if (weight + item.getWeight() > player.carryingCapacity)
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(player, item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            return pickUpHeal(player, item);
        }

        if (item.isRare()) {
            player.gameEngine.playSpecialEffect("cool_swirly_particles");
            if (item.isUnique()) {
                player.gameEngine.playSpecialEffect("blue_swirly");
            }
        }

        player.inventory.add(item);
        Action.calculateStats(player);

        return true;
    }

    protected static boolean pickUpHeal(RpgPlayer player, Item item) {
        player.health += item.getHeal();
        if (player.health > player.maxHealth)
            player.health = player.maxHealth;
        if (item.getHeal() > 500)
            player.gameEngine.playSpecialEffect("green_swirly");
        return true;
    }
}
