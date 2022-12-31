package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTImage;
/* compiled from: Image.java */
/* loaded from: classes.dex */
public class g {
    private String a;
    private int b;
    private int c;

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.a) && this.b > 0 && this.c > 0;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(int i2) {
        this.c = i2;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public static TTImage a(g gVar) {
        if (gVar == null || !gVar.d()) {
            return null;
        }
        return new TTImage(gVar.c(), gVar.b(), gVar.a());
    }
}
