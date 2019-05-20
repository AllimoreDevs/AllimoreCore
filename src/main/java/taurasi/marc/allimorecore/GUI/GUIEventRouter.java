package taurasi.marc.allimorecore.GUI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;
import taurasi.marc.allimorecore.AllimoreLogger;

import java.util.ArrayList;

public class GUIEventRouter implements Listener {
    private ArrayList<InventoryObserver> inventoryObservers;

    public GUIEventRouter(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        inventoryObservers = new ArrayList<>();
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent event){
        for(InventoryObserver observer : inventoryObservers){
            if(observer == null) continue;
            observer.OnInventoryClick(event);
        }
    }

    @EventHandler
    public void OnInventoryClose(InventoryCloseEvent event){
        for(InventoryObserver observer : inventoryObservers){
            if(observer == null) continue;
            observer.OnInventoryClose(event);
        }
    }

    public void Subscribe(InventoryObserver observer){
        inventoryObservers.add (observer);
    }
    public void Unsubscribe(InventoryObserver observer){
        inventoryObservers.remove(observer);
    }
}
