package us.pinguo.libdeepvision;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public class PortraitMatting {
    private static volatile boolean a = false;

    public static boolean a(Context context, String str, String str2, String str3) {
        String c = a.c(context, "pgps_acc_0.97464_cls_0.96591_miou_0.93681_freq_0.96740.pth.fb");
        if (new File(c).exists() || a.b(context, "pgps_acc_0.97464_cls_0.96591_miou_0.93681_freq_0.96740.pth.fb", c)) {
            if (nInit(c, str, str2, str3)) {
                a = true;
            }
            return a;
        }
        return false;
    }

    public static void b() {
        if (a) {
            a = false;
            nRelease();
        }
    }

    public static native byte[] matting(byte[] bArr, int i2, int i3, int i4);

    private static native boolean nInit(String str, String str2, String str3, String str4);

    private static native void nRelease();
}
