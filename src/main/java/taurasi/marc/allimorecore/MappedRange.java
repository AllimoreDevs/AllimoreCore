package taurasi.marc.allimorecore;

import org.bukkit.configuration.file.FileConfiguration;

public class MappedRange extends Range {
    private static RangeUnit[] units = new RangeUnit[]{ new RangeStackUnit("STACK") };
    private RangeUnit unit;

    public MappedRange(FileConfiguration config, String path){
        String unitKey = config.getString(path + "unit");
        for(RangeUnit unit : units){
            if(RangeUnit.IsSingle(unitKey)){
                min = config.getInt(path + "min");
                max = config.getInt(path + "max");
                return;
            }
            if( !(unit.IsUnit(unitKey)) ) continue;
            min = Math.round(unit.Remap( (float)config.getDouble(path + "min")));
            max = Math.round(unit.Remap( (float)config.getDouble(path + "max")));
            this.unit = unit;
            return;
        }
    }
}
