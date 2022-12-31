package us.pinguo.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.io.File;
/* compiled from: UtilContext.java */
/* loaded from: classes6.dex */
public final class v {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static int b(int i2) {
        return a.getResources().getColor(i2);
    }

    public static File c() {
        return new File(d());
    }

    public static String d() {
        File externalCacheDir = a.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        String packageName = a.getPackageName();
        return "/sdcard/Android/data/" + packageName + "/cache";
    }

    public static String e(@Nullable String str) {
        File externalFilesDir = a.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.getAbsolutePath();
        }
        String packageName = a.getPackageName();
        if (TextUtils.isEmpty(str)) {
            return "/sdcard/Android/data/" + packageName + "/files";
        }
        return "/sdcard/Android/data/" + packageName + "/files/" + str;
    }

    public static String f(int i2) {
        return a.getResources().getString(i2);
    }

    public static boolean g() {
        return h("android.permission.CAMERA");
    }

    public static boolean h(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(a, str) == 0;
    }

    public static boolean i() {
        return h("android.permission.RECORD_AUDIO");
    }

    public static boolean j() {
        return h("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static void k(Context context) {
        a = context.getApplicationContext();
    }
}
