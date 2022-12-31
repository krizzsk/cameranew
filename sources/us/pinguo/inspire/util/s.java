package us.pinguo.inspire.util;

import vStudio.Android.Camera360.R;
/* compiled from: MediaIconUtils.java */
/* loaded from: classes9.dex */
public class s {
    private static final int[] a = {R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};

    public static int a(int i2) {
        if (i2 < 2 || i2 > 9) {
            return 0;
        }
        return a[i2 - 2];
    }
}
