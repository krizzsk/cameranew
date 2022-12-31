package com.tencent.bugly.crashreport;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.y;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.d(str, str2);
        }
        y.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.e(str, str2);
        }
        y.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.i(str, str2);
        }
        y.a("I", str, str2);
    }

    public static void setCache(int i2) {
        y.a(i2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.v(str, str2);
        }
        y.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.w(str, str2);
        }
        y.a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (b.c) {
            Log.e(str, str2, th);
        }
        y.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
