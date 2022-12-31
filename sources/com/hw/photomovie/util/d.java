package com.hw.photomovie.util;

import android.graphics.Bitmap;
import android.os.Build;
/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class d {
    private static long[] a = new long[256];

    static {
        String str = Build.TYPE;
        if (!str.equals("eng")) {
            str.equals("userdebug");
        }
        for (int i2 = 0; i2 < 256; i2++) {
            long j2 = i2;
            for (int i3 = 0; i3 < 8; i3++) {
                j2 = (j2 >> 1) ^ ((((int) j2) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            a[i2] = j2;
        }
    }

    public static boolean a(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }
}
