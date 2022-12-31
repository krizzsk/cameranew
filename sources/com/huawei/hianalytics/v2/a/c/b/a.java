package com.huawei.hianalytics.v2.a.c.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    private String a;
    private long b;
    private long c;

    public a(String str, long j2) {
        this.a = "";
        this.b = 0L;
        this.c = 0L;
        this.a = str;
        this.b = j2;
    }

    public a(String str, long j2, long j3) {
        this.a = "";
        this.b = 0L;
        this.c = 0L;
        this.a = str;
        this.b = j2;
        this.c = j3;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.a) && this.b > 0 && this.c >= 0;
    }
}
