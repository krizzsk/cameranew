package us.pinguo.u3dengine.api;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public enum ScreenOrientation {
    PORTRAIT(1),
    PortraitUpsideDown(2),
    LandscapeLeft(3),
    LandscapeRight(4);
    
    private final int value;

    ScreenOrientation(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
