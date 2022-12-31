package us.pinguo.libdeepvision;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public class SkySegmentation {
    private static volatile boolean a = false;

    public static boolean a(Context context, boolean z, String str, String str2, String str3) {
        String c = a.c(context, "pgss_shufflenet.onnx.fb");
        if (new File(c).exists() || a.b(context, "pgss_shufflenet.onnx.fb", c)) {
            if (nInit(c, z, str, str2, str3)) {
                a = true;
            }
            return a;
        }
        return false;
    }

    private static native boolean nInit(String str, boolean z, String str2, String str3, String str4);

    private static native void nRelease();

    public static native byte[] segment(byte[] bArr, int i2, int i3, int i4);
}
