package com.huawei.hianalytics.b;

import androidx.exifinterface.media.ExifInterface;
/* loaded from: classes2.dex */
public abstract class e {
    public static String a(int i2) {
        return i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? String.valueOf(i2) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D";
    }
}
