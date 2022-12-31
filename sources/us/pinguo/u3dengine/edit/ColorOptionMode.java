package us.pinguo.u3dengine.edit;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public enum ColorOptionMode {
    Absolute(0, "colorselect_absolute"),
    Relative(1, "colorselect_relative");
    
    private final String key;
    private final int value;

    ColorOptionMode(int i2, String str) {
        this.value = i2;
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getValue() {
        return this.value;
    }
}
