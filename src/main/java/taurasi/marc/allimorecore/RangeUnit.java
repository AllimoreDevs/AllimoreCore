package taurasi.marc.allimorecore;

public abstract class RangeUnit {
    public static String SINGLE_UNIT_KEY = "SINGLE";
    public String unitName;

    public RangeUnit(String unitName){
        this.unitName = unitName;
    }

    public abstract float Remap(float rawValue);

    public static boolean IsSingle(String unitKey){
        return unitKey.equalsIgnoreCase(SINGLE_UNIT_KEY);
    }
    public boolean IsUnit(String unitKey){
        return unitKey.equalsIgnoreCase(unitName);
    }
}
