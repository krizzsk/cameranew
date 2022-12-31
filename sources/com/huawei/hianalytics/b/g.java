package com.huawei.hianalytics.b;

import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes2.dex */
public class g {
    private String a;
    private String b;
    private int c;

    /* renamed from: f  reason: collision with root package name */
    private String f5118f;

    /* renamed from: g  reason: collision with root package name */
    private int f5119g;

    /* renamed from: h  reason: collision with root package name */
    private int f5120h;

    /* renamed from: i  reason: collision with root package name */
    private int f5121i;

    /* renamed from: d  reason: collision with root package name */
    private long f5116d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f5117e = 0;

    /* renamed from: j  reason: collision with root package name */
    private final StringBuilder f5122j = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i2, String str, int i3, String str2) {
        this.a = null;
        this.b = "HA";
        this.c = 0;
        this.f5121i = 0;
        this.f5121i = i2;
        this.a = str;
        this.c = i3;
        if (str2 != null) {
            this.b = str2;
        }
        c();
    }

    private StringBuilder a(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f5116d)));
        String a = e.a(this.c);
        sb.append(' ');
        sb.append(a);
        sb.append('/');
        sb.append(this.a);
        sb.append('/');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.f5119g);
        sb.append(':');
        sb.append(this.f5117e);
        sb.append(' ');
        sb.append(this.f5118f);
        sb.append(':');
        sb.append(this.f5120h);
        sb.append(']');
        return sb;
    }

    private StringBuilder b(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.f5122j.toString());
        return sb;
    }

    private g c() {
        this.f5116d = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f5117e = currentThread.getId();
        this.f5119g = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i2 = this.f5121i;
        if (length > i2) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            this.f5118f = stackTraceElement.getFileName();
            this.f5120h = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public <T> g a(T t) {
        this.f5122j.append(t);
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(4096);
        a(sb);
        b(sb);
        return sb.toString();
    }
}
