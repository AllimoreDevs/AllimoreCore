package taurasi.marc.allimorecore;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {
    public static boolean ItemNameMatch(ItemStack item, String nameString){
        return item.getItemMeta().getDisplayName().equals(nameString);
    }
    public static boolean ItemMaterialMatch(ItemStack item, Material material){
        return item.getType().equals(material);
    }
    public static boolean ItemMatch(ItemStack item, Material material, String nameString){
        return ItemMaterialMatch(item, material) && ItemNameMatch(item, nameString);
    }

    public static int GetAmountOfMaterialFromInventory(Material material, Inventory inventory){
        int runningTotal = 0;

        for(int i = 0; i < inventory.getSize(); i++){
            ItemStack item = inventory.getItem(i);
            if(item == null) continue;
            if(item.getType() == material){
                runningTotal += item.getAmount();
            }
        }
        return runningTotal;
    }
    public static void RemoveQuantityOfMaterial(Inventory inventory, Material targetMaterial, int targetAmount){
        int removedAmount = 0;
        for(int i = 0; i < inventory.getSize(); i++){
            int remainingAmount = targetAmount - removedAmount;

            ItemStack item = inventory.getItem(i);
            if( item == null || !(item.getType() == targetMaterial) ) continue;

            if(item.getAmount() > remainingAmount ) {
                item.setAmount( item.getAmount() - remainingAmount );
                return;
            }

            if(item.getAmount() == remainingAmount) {
                inventory.removeItem(item);
                return;
            }

            if(item.getAmount() < remainingAmount){
                inventory.removeItem(item);
                removedAmount += item.getAmount();
            }
        }
    }
}
