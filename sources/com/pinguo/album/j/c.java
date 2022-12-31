package com.pinguo.album.j;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pinguo.album.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;
/* compiled from: PGAlbumUtils.java */
/* loaded from: classes3.dex */
public class c {
    private static float a = -1.0f;
    private static volatile WeakReference<Thread> b;
    private static volatile boolean c;

    static {
        Pattern.compile("(-|/| )");
    }

    public static void a() {
        if (us.pinguo.foundation.d.f10985d || c || b == null || b.get() == null || Thread.currentThread() != b.get()) {
            return;
        }
        c = true;
        us.pinguo.common.log.a.f(new Throwable("Should not do this in render thread"));
    }

    public static void b(File file) {
        File[] listFiles;
        int i2 = 0;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int i3 = 0;
            while (i2 < listFiles.length) {
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    i3++;
                } else if (!file2.getName().startsWith("C360")) {
                    file2.delete();
                }
                i2++;
            }
            i2 = i3;
        }
        if (i2 != 0 || Environment.getExternalStorageDirectory().getAbsolutePath().equals(file.getAbsolutePath())) {
            return;
        }
        file.delete();
    }

    public static float c(float f2) {
        return d(null, f2);
    }

    public static float d(Context context, float f2) {
        if (a <= 0.0f) {
            if (context == null) {
                a = 1.0f;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                a = displayMetrics.density;
            }
        }
        return a * f2;
    }

    public static int e(int i2) {
        return Math.round(c(i2));
    }

    public static String f(Context context, int i2) {
        int i3 = i2 / 3600;
        int i4 = i3 * 3600;
        int i5 = (i2 - i4) / 60;
        int i6 = i2 - (i4 + (i5 * 60));
        return i3 == 0 ? String.format(context.getString(R.string.details_ms), Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(context.getString(R.string.details_hms), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static byte[] g(String str) {
        char[] charArray;
        byte[] bArr = new byte[str.length() * 2];
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (c2 & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) (c2 >> '\b');
        }
        return bArr;
    }

    public static TextPaint h(int i2, int i3, boolean z) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(i2);
        textPaint.setAntiAlias(true);
        textPaint.setColor(i3);
        textPaint.setFilterBitmap(true);
        if (z) {
            textPaint.setTypeface(Typeface.defaultFromStyle(1));
        }
        return textPaint;
    }

    public static long i() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(7, 1);
        return calendar.getTimeInMillis();
    }

    public static long j() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 60);
        calendar.set(7, 7);
        return calendar.getTimeInMillis();
    }

    public static void k(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        a = displayMetrics.density;
        com.pinguo.album.data.utils.e.g(displayMetrics);
    }

    public static boolean l(double d2, double d3) {
        return (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? false : true;
    }

    public static int m(Context context, float f2) {
        return Math.round(d(context, f2 * 39.37f * 160.0f));
    }

    public static void n(float[] fArr, float f2, float f3, float f4) {
        Arrays.fill(fArr, 0, 16, 0.0f);
        float f5 = -f4;
        fArr[15] = f5;
        fArr[5] = f5;
        fArr[0] = f5;
        fArr[8] = f2;
        fArr[9] = f3;
        fArr[11] = 1.0f;
        fArr[10] = 1.0f;
    }
}
