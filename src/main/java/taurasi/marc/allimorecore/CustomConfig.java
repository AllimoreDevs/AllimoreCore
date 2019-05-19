package taurasi.marc.allimorecore;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class CustomConfig {
    protected String configFileName;
    protected String path;
    protected Plugin plugin;

    protected File configFile;
    protected FileConfiguration config;

    public CustomConfig(String configFileName, String path, Plugin plugin){
        this.configFileName = configFileName;
        this.path = path;
        this.plugin = plugin;

        GetConfigFile();
        GetConfigFromFile();
    }

    private void SaveConfig (FileConfiguration newConfig){
        try{
            newConfig.save(configFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void SaveConfig (){
        SaveConfig(config);
    }
    public void OverrwriteFile(FileConfiguration newConfig){
        SaveConfig(newConfig);
    }

    public FileConfiguration GetConfig(){
        return config;
    }

    private void GetConfigFile(){
        configFile = new File(path, configFileName);
        if(!configFile.exists()){
            configFile.getParentFile().mkdirs();
            plugin.saveResource(configFileName, false);
        }
    }
    private void GetConfigFromFile(){
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException  e) {
            e.printStackTrace();
        }
    }
}
