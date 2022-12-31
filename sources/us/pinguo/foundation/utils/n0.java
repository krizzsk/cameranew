package us.pinguo.foundation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.Closeable;
import java.util.Calendar;
import java.util.Locale;
/* compiled from: Util.java */
/* loaded from: classes4.dex */
public class n0 {
    public static String a = "";
    private static int b = 0;
    private static int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static float f11108d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private static int f11109e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static long f11110f = 0;

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static float b(float f2) {
        return f11108d * f2;
    }

    public static int c(int i2) {
        return Math.round(b(i2));
    }

    public static int d(float f2) {
        return (int) ((f11108d * f2) + 0.5f);
    }

    public static long e(Context context) {
        return context.getSharedPreferences("xiaoc_new_flag_manager", 4).getLong("key_evenry_day_open_time", 0L);
    }

    public static PackageInfo f(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
    }

    public static float g() {
        float f2 = f11108d;
        if (f2 != -1.0f) {
            return f2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static int h() {
        int i2 = b;
        if (i2 != 0) {
            return i2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static int i() {
        int i2 = c;
        if (i2 != 0) {
            return i2;
        }
        throw new RuntimeException("Must call initialize method first !!!");
    }

    public static int j(Context context) {
        int i2 = f11109e;
        if (i2 != -1) {
            return i2;
        }
        if (context == null) {
            f11109e = -1;
        }
        try {
            f11109e = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            f11109e = -1;
        }
        return f11109e;
    }

    public static void k(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        f11108d = displayMetrics.density;
        b = displayMetrics.heightPixels;
        c = displayMetrics.widthPixels;
        try {
            a = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a, 16384);
            String.valueOf(packageInfo.versionCode);
            String str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        h0.b();
    }

    public static boolean l(Context context) {
        if (Math.abs(System.currentTimeMillis() - f11110f) < 600000) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(e(context));
        return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
    }

    public static boolean m(String str) {
        return "zh".equals(str.toLowerCase(Locale.ENGLISH));
    }

    public static boolean n() {
        return m(Locale.getDefault().getLanguage());
    }

    public static int o(float f2) {
        return Math.round(b(f2 * 39.37f * 160.0f));
    }

    public static void p(Context context) {
        if (Math.abs(System.currentTimeMillis() - f11110f) >= 600000) {
            f11110f = System.currentTimeMillis();
            q(context, Calendar.getInstance().getTimeInMillis());
        }
    }

    public static void q(Context context, long j2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("xiaoc_new_flag_manager", 0).edit();
        edit.putLong("key_evenry_day_open_time", j2);
        edit.commit();
    }
}
