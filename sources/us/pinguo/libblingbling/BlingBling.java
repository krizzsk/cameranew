package us.pinguo.libblingbling;
/* loaded from: classes2.dex */
public class BlingBling {
    static {
        System.loadLibrary("blingbling");
    }

    public static native long getRenderResult();

    public static native void release();

    public static native void render(int i2, int i3, int i4, int i5);
}
