package taurasi.marc.allimorecore;

public class RangeStackUnit extends RangeUnit {
    public RangeStackUnit(String unitName) {
        super(unitName);
    }

    @Override
    public float Remap(float rawValue) {
        return rawValue * 64;
    }
}
