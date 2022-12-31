package com.facebook.drawee.components;
/* compiled from: RetryManager.java */
/* loaded from: classes.dex */
public class b {
    private boolean a;
    private int b;
    private int c;

    public b() {
        a();
    }

    public void a() {
        this.a = false;
        this.b = 4;
        c();
    }

    public void b() {
        this.c++;
    }

    public void c() {
        this.c = 0;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public boolean e() {
        return this.a && this.c < this.b;
    }
}
