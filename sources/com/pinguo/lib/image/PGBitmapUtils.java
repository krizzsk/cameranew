package com.pinguo.lib.image;

import com.tencent.bugly.crashreport.CrashReport;
import us.pinguo.foundation.k;
import us.pinguo.image.ImageNative;
import us.pinguo.util.l;
/* loaded from: classes3.dex */
public final class PGBitmapUtils {
    protected static final String MIRROR_X = "effect=mirror,1,0";
    private static final String TAG = "PGBitmapUtils";

    private PGBitmapUtils() {
    }

    public static float getPreviewFrameScale(int i2) {
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 5 ? 0.0f : 2.0f;
                    }
                    return 1.0f;
                }
                return 1.5f;
            }
            return 1.3333334f;
        }
        return 1.7777778f;
    }

    public static byte[] setCameraMirror(byte[] bArr, int i2) {
        String str = k.c;
        us.pinguo.util.k.i(str, bArr);
        String str2 = k.f11020d;
        ImageNative.fastCrop(str, str2, i2, true, 0.0f, 96);
        byte[] c = us.pinguo.util.k.c(str2);
        l.j(str2);
        l.j(str);
        if (c == null) {
            CrashReport.postCatchedException(new RuntimeException("mirror error"));
            return bArr;
        }
        return c;
    }
}
