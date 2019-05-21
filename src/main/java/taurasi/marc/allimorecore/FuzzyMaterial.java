package taurasi.marc.allimorecore;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class FuzzyMaterial {
    private ArrayList<Material> materials;
    private String name;

    public FuzzyMaterial(){
        materials = new ArrayList<>();
    }
    public FuzzyMaterial(Material[] materials){
        this();
        this.materials.addAll(Arrays.asList(materials));
    }
    public FuzzyMaterial(FileConfiguration config, String path){
        ConfigurationSection section = config.getConfigurationSection(path);
        Set<String> keys = section.getKeys(false);
        materials = new ArrayList<>(keys.size());

        for(String key : keys){
            String materialName = config.getString(path + key);
            materials.add(Material.getMaterial(materialName));
        }
    }
    public void WriteToConfig(FileConfiguration config, String path){
        for(int i = 0; i < materials.size(); i++){
            Material material = materials.get(i);
            if(material == null) continue;
            config.set(path + Integer.toString(i), material.name());
        }
    }

    public void AddMaterial(Material material){
        materials.add(material);
    }
    public void RemoveMaterial(Material material){
        materials.remove(material);
    }
    public boolean IsAcceptable(Material otherMaterial){
        for(Material material : materials){
            if(material == null) continue;
            if(otherMaterial == material){
                return true;
            }
        }
        return false;
    }
}
