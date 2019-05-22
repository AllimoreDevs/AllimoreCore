package taurasi.marc.allimorecore;

import org.bukkit.configuration.file.FileConfiguration;

import java.security.InvalidParameterException;

public class Range {
    public int min;
    public int max;

    public Range(){}
    public Range(int min, int max){
        if (min >= max) {
            throw new InvalidParameterException("Min cannot be greater than or equal to max!");
        }
        this.min = min;
        this.max = max;
    }
    public Range(FileConfiguration config, String path){
        min = config.getInt(path + "min");
        max = config.getInt(path + "max");
    }

    public int GetRandomInRange(){
        return RandomUtils.getRandomNumberInRange(min, max);
    }
}
