package com.huawei.hianalytics.b;

import android.content.Context;
/* loaded from: classes2.dex */
public class c {
    private static f a = d.a();
    private String c;
    private int b = 4;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5115d = false;

    private g b(int i2, String str, String str2) {
        g gVar = new g(7, this.c, i2, str);
        gVar.a((g) str2);
        return gVar;
    }

    public void a(int i2, String str, String str2) {
        if (a(i2)) {
            g b = b(i2, str, str2);
            a.a(b.a() + b.b(), i2, str, str2);
        }
    }

    public void a(Context context, int i2, String str) {
        this.b = i2;
        this.c = str;
        a.a(context, "HiAnalytics");
        this.f5115d = true;
    }

    public void a(String str, String str2) {
        g b = b(4, str, str2);
        a.a(b.a() + '\n' + b.b(), 4, str, str2);
    }

    public boolean a(int i2) {
        return this.f5115d && i2 >= this.b;
    }
}
