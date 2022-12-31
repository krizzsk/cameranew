package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
/* loaded from: classes.dex */
public class MemorySizeCalculator {
    private final int a;
    private final int b;
    private final Context c;

    /* loaded from: classes.dex */
    private static class a implements b {
        private final DisplayMetrics a;

        public a(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.b
        public int a() {
            return this.a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.b
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        int a();

        int b();
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    private static int b(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (d(activityManager) ? 0.33f : 0.4f));
    }

    @TargetApi(19)
    private static boolean d(ActivityManager activityManager) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return activityManager.isLowRamDevice();
        }
        return i2 < 11;
    }

    private String e(int i2) {
        return Formatter.formatFileSize(this.c, i2);
    }

    public int a() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    MemorySizeCalculator(Context context, ActivityManager activityManager, b bVar) {
        this.c = context;
        int b2 = b(activityManager);
        int b3 = bVar.b() * bVar.a() * 4;
        int i2 = b3 * 4;
        int i3 = b3 * 2;
        int i4 = i3 + i2;
        if (i4 <= b2) {
            this.b = i3;
            this.a = i2;
        } else {
            int round = Math.round(b2 / 6.0f);
            this.b = round * 2;
            this.a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(e(this.b));
            sb.append(" pool size: ");
            sb.append(e(this.a));
            sb.append(" memory class limited? ");
            sb.append(i4 > b2);
            sb.append(" max size: ");
            sb.append(e(b2));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(d(activityManager));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }
}
