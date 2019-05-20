package taurasi.marc.allimorecore.GUI;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public interface InventoryObserver {
    void OnInventoryClick(InventoryClickEvent event);
    void OnInventoryClose(InventoryCloseEvent event);
}
