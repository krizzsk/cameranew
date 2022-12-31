package com.tencent.open.log;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class b {
    private static SimpleDateFormat a = d.C0282d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    private File f8188g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f8185d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f8186e = 4096;

    /* renamed from: f  reason: collision with root package name */
    private long f8187f = 10000;

    /* renamed from: h  reason: collision with root package name */
    private int f8189h = 10;

    /* renamed from: i  reason: collision with root package name */
    private String f8190i = ".log";

    /* renamed from: j  reason: collision with root package name */
    private long f8191j = LocationRequestCompat.PASSIVE_INTERVAL;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j2);
        d(i5);
        b(str2);
        b(j3);
    }

    private File[] c(long j2) {
        File b = b();
        String c = c(d(j2));
        try {
            b = new File(b, c);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String b2 = l.b();
        File file = null;
        if (!TextUtils.isEmpty(b2) || b2 != null) {
            try {
                File file2 = new File(b2, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return new File[]{b, file};
    }

    private String d(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e2 = e();
        if (e2 != null) {
            e2.mkdirs();
        }
        return e2;
    }

    public File e() {
        return this.f8188g;
    }

    public int f() {
        return this.f8189h;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i2) {
        this.c = i2;
    }

    public void b(int i2) {
        this.f8185d = i2;
    }

    public void a(long j2) {
        this.f8187f = j2;
    }

    public void b(String str) {
        this.f8190i = str;
    }

    public void a(File file) {
        this.f8188g = file;
    }

    public void b(long j2) {
        this.f8191j = j2;
    }

    public int d() {
        return this.f8186e;
    }

    public void d(int i2) {
        this.f8189h = i2;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public String c() {
        return this.b;
    }

    public void c(int i2) {
        this.f8186e = i2;
    }
}
