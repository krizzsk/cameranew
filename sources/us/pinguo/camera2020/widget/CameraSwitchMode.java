package us.pinguo.camera2020.widget;
/* compiled from: CameraSwitchMode.kt */
/* loaded from: classes3.dex */
public enum CameraSwitchMode {
    PHOTO(0),
    MOVIE(1);
    
    private final int index;

    CameraSwitchMode(int i2) {
        this.index = i2;
    }

    public final int getIndex() {
        return this.index;
    }
}
