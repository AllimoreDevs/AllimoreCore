package taurasi.marc.allimorecore.GUI;

import org.bukkit.inventory.ItemStack;

public class StandardButton extends Button {
    String name;
    StandardButtonListener listener;

    public StandardButton(String name, ItemStack item, InventoryGUI inv, StandardButtonListener listener) {
        super(item, inv);
        this.listener = listener;
        this.name = name;
    }

    @Override
    public void Run() {
        listener.OnButtonClick(name);
    }
}
