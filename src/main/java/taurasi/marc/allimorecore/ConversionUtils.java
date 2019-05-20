package taurasi.marc.allimorecore;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;

public class ConversionUtils {
    public static Sound ConvertSoundToString(String string){
        return Sound.valueOf(string.toUpperCase());
    }
    public static ChatColor ConvertStringToColor(String string){
        return ChatColor.valueOf(string.toUpperCase());
    }
    public static EntityType ConvertStringtoEntityType(String string){
        return EntityType.valueOf(string.toUpperCase());
    }
}
