package us.pinguo.foundation.n;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import java.io.IOException;
import us.pinguo.foundation.e;
import us.pinguo.image.ImageNative;
import us.pinguo.util.l;
/* compiled from: ImageNativeUtils.java */
/* loaded from: classes4.dex */
public final class b {
    private static int a = -1;

    public static String a() {
        return e() ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(String str, String str2, int i2, int i3, int i4, int i5, float f2, float f3, boolean z) throws IOException, OutOfMemoryError {
        return ImageNative.cropCImg(str, str2, i2, i3, i4, i5, f2, f3, Bitmap.CompressFormat.JPEG.ordinal(), 95, 0, !z ? 1 : 0);
    }

    public static boolean c(String str, String str2, Rect rect, float f2, float f3) {
        try {
            return b(str, str2, rect.left, rect.top, rect.width(), rect.height(), f2, f3, false);
        } catch (Throwable th) {
            Log.e("BitmapCropTask", "error", th);
            return false;
        }
    }

    private static int d() {
        Context b = e.b();
        int i2 = a;
        if (i2 != -1) {
            return i2;
        }
        if (b == null) {
            a = -1;
        }
        try {
            a = b.getPackageManager().getPackageInfo(b.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            a = -1;
        }
        return a;
    }

    public static boolean e() {
        try {
            try {
                return ImageNative.abiType() == 2;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
            String substring = String.valueOf(d()).substring(0, 3);
            if (!"130".equals(substring) && !"210".equals(substring)) {
                if ("131".equals(substring)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean f() {
        return ImageNative.abiType() != 2;
    }

    public static boolean g(String str, String str2, float f2) throws IOException, OutOfMemoryError {
        Point m = us.pinguo.util.e.m(str);
        int i2 = m.x;
        int i3 = m.y;
        if (i2 * i3 <= 100) {
            return false;
        }
        if (f2 != 90.0f && f2 != 270.0f) {
            return b(str, str2, 0, 0, i2, i3, f2, 1.0f, true);
        }
        return b(str, str2, 0, 0, i3, i2, (f2 + 180.0f) % 360.0f, 1.0f, true);
    }

    private static boolean h(String str, String str2, float f2, boolean z, boolean z2, Point point, float f3) throws IOException {
        int i2 = (int) (point.x * f3);
        int i3 = (int) (point.y * f3);
        if (f2 == 90.0f || f2 == 270.0f) {
            if (z2) {
                if (i3 > i2) {
                    return b(str, str2, (i3 - i2) / 2, 0, i2, i2, f2, f3, z);
                }
                return b(str, str2, 0, (i2 - i3) / 2, i3, i3, f2, f3, z);
            }
            return b(str, str2, 0, 0, i3, i2, f2, f3, z);
        } else if (z2) {
            if (i3 > i2) {
                return b(str, str2, 0, (i3 - i2) / 2, i2, i2, f2, f3, z);
            }
            return b(str, str2, (i2 - i3) / 2, 0, i3, i3, f2, f3, z);
        } else {
            return b(str, str2, 0, 0, i2, i3, f2, f3, z);
        }
    }

    public static boolean i(String str, String str2, float f2, int i2, boolean z, boolean z2) throws IOException, OutOfMemoryError {
        float f3;
        Point m = us.pinguo.util.e.m(str);
        int i3 = m.x;
        int i4 = m.y;
        if (i3 * i4 <= 100) {
            return false;
        }
        float sqrt = (float) Math.sqrt(i2 / (i3 * i4));
        if (sqrt < 0.99f) {
            f3 = sqrt;
        } else if (f2 == 0.0f && !z && !z2) {
            l.d(str, str2);
            return true;
        } else {
            f3 = 1.0f;
        }
        return h(str, str2, f2, z, z2, m, f3);
    }
}
