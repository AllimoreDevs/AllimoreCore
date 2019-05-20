package taurasi.marc.allimorecore.GUI;

import org.bukkit.inventory.ItemStack;

public abstract class Button {
    protected int slot;
    protected ItemStack item;
    protected InventoryGUI inv;

    public Button(ItemStack item, InventoryGUI inv){
        this.item = item;
        this.inv = inv;
    }

    public abstract void Run();
}
