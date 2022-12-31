package us.pinguo.u3dengine.edit;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public enum EditModel {
    None(-1),
    Normal(0),
    Brush(1),
    AutoDeformation(2),
    ManualDeformation(3),
    SoftSkin(4),
    BackgroundBlur(5),
    BasicAdjustment(6),
    OneStepToBeauty(7),
    StaticSticker(8),
    SpotRemove(9),
    Filter(10),
    Clip(11),
    Blur(12),
    Makeup(13),
    MagicBackground(14),
    Facial3D(15),
    BodyBeautify(17);
    
    private final int key;

    EditModel(int i2) {
        this.key = i2;
    }

    public final int getKey() {
        return this.key;
    }
}
