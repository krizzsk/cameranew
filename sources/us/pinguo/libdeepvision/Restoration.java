package us.pinguo.libdeepvision;

import android.content.Context;
import android.graphics.PointF;
import java.io.File;
import java.util.List;
import us.pinguo.libdeepvision.bean.ResultImage;
import us.pinguo.libdeepvision.callback.RestorationCancelCallback;
import us.pinguo.libdeepvision.callback.ResultImageCallback;
/* loaded from: classes5.dex */
public class Restoration {
    private static volatile boolean a = false;

    public static void a(RestorationCancelCallback restorationCancelCallback) {
        if (a) {
            nCancel(restorationCancelCallback);
        } else {
            restorationCancelCallback.cancel(true);
        }
    }

    public static boolean b(Context context, String str, String str2, String str3) {
        String c = a.c(context, "pgve_img_restoration_mobile_arch.fb");
        String c2 = a.c(context, "pg13_face_restoration_mobile_arch.fb");
        if ((new File(c).exists() && new File(c2).exists()) || (a.b(context, "pgve_img_restoration_mobile_arch.fb", c) && a.b(context, "pg13_face_restoration_mobile_arch.fb", c2))) {
            if (nInit(c, c2, str, str2, str3)) {
                a = true;
            }
            return a;
        }
        return false;
    }

    public static void c() {
        if (a) {
            a = false;
            nRelease();
        }
    }

    private static native void nCancel(RestorationCancelCallback restorationCancelCallback);

    private static native boolean nInit(String str, String str2, String str3, String str4, String str5);

    private static native void nRelease();

    public static native ResultImage restore(byte[] bArr, int i2, int i3, List<List<PointF>> list, int i4, ResultImageCallback resultImageCallback);
}
