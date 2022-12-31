package us.pinguo.u3dengine.edit;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public enum BasicBrushMode {
    None(0),
    Brush(1),
    Erasing(2),
    Waiting(3);
    
    private final int type;

    BasicBrushMode(int i2) {
        this.type = i2;
    }

    public final int getType() {
        return this.type;
    }
}
