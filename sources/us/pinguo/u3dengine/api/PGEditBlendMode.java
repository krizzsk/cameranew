package us.pinguo.u3dengine.api;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public enum PGEditBlendMode {
    Normal(0),
    Dissolve(13),
    Darken(6),
    DarkerColor(11),
    Multiply(2),
    ColorBurn(14),
    LinearBurn(15),
    Lighten(10),
    Screen(1),
    ColorDodge(9),
    LinearDodge(16),
    LighterColor(17),
    Overlay(3),
    SoftLight(8),
    HardLight(4),
    VividLight(7),
    LinearLight(5),
    PinLight(18),
    HardMix(19),
    Difference(20),
    Exclusion(21),
    Subtract(22),
    Divide(23),
    Hue(24),
    Saturation(25),
    Color(12),
    Luminosity(26);
    
    private final int value;

    PGEditBlendMode(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
