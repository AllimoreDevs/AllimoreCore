package taurasi.marc.allimorecore.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import taurasi.marc.allimorecore.StringUtils;

import java.util.ArrayList;

public abstract class InventoryGUI implements InventoryObserver {
    protected final Inventory inv;

    private GUIEventRouter router;
    private ArrayList<Button> buttons;

    // Display Configuration Settings
    protected  int inventorySize;

    protected int characterPerLoreLine = 30;
    protected ChatColor itemTitleColor = ChatColor.BLUE;
    protected ChatColor loreColor = ChatColor.WHITE;

    public InventoryGUI(int inventorySize, GUIEventRouter router) {
        inv = Bukkit.createInventory(null, inventorySize);
        buttons = new ArrayList<>();
        this.inventorySize = inventorySize;
        this.router = router;
        router.Subscribe(this);
    }

    public void OpenGUI(Player player){
        player.openInventory(inv);
    }

    public void CreateAndAddButton(Button button){
        buttons.add(button);
        button.slot = inv.firstEmpty();
        inv.addItem(button.item);
    }
    public void CreateButtonInSlot(Button button, int slot){
        buttons.add(button);
        button.slot = slot;
        inv.setItem(slot, button.item);
    }
    public void RemoveButton(Button button){
        buttons.remove(button);
        inv.setItem(button.slot, null);
    }

    public void ClearInv(){
        inv.clear();
        buttons.clear();
    }

    public ItemStack CreateGUIItem(String name, ArrayList<String> lore, Material material, int amount){
        ItemStack i = new ItemStack(material, amount);
        ItemMeta iMeta = i.getItemMeta();
        iMeta.setDisplayName(name);
        if(lore != null) iMeta.setLore(lore);
        i.setItemMeta(iMeta);
        return i;
    }
    public ItemStack CreateGUIItem(String name, ArrayList<String> lore, Material material){
        return CreateGUIItem(name, lore, material, 1);
    }
    public ItemStack CreateGUIItem(String name, Material material, int amount){
        return CreateGUIItem(name, (ArrayList<String>) null, material, amount);
    }
    public ItemStack CreateGUIItem(String name, Material material){
        return CreateGUIItem(name, (ArrayList<String>) null, material);
    }
    public ItemStack CreateGUIItem(String name, String lore, Material material, int amount){
        ArrayList<String> loreList = FormatLoreFromString(lore);
        return CreateGUIItem(name, loreList, material, amount);
    }
    public ItemStack CreateGUIItem(String name, String lore, Material material){
        ArrayList<String> loreList = FormatLoreFromString(lore);
        return CreateGUIItem(name, loreList, material, 1);
    }

    public ItemStack CreatePreformatedItem(String name, String lore, Material material, int amount){
        ArrayList loreList = FormatLoreFromString(lore);
        return CreateGUIItem(itemTitleColor + name, loreList, material, amount);
    }
    public ItemStack CreatePreformatedItem(String name, String lore, Material material){
        ArrayList loreList = FormatLoreFromString(lore);
        return CreateGUIItem(itemTitleColor + name, loreList, material);
    }

    public ArrayList<String> FormatLoreFromString(String string){
        return StringUtils.WrapLore(string, characterPerLoreLine, loreColor.toString());
    }
    public ArrayList<String> FormatLoreFromString(String string, ChatColor loreColor){
        return StringUtils.WrapLore(string, characterPerLoreLine, loreColor.toString());
    }

    public void OnInventoryClose(InventoryCloseEvent event){
        if( (event.getInventory().equals(inv)) ) return;
        inv.clear();
    }
    public void OnInventoryClick(InventoryClickEvent event){
        if( !(event.getInventory().equals(inv)) ) return;
        event.setCancelled(true);

        for (Button button : buttons){
            if( event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR) || button == null) continue;
            if(button.slot == event.getRawSlot()){
                button.Run();
                return;
            }
        }
    }

    public void finalize(){
        router.Unsubscribe(this);
    }
}
