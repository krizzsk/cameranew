package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;
/* compiled from: AppCall.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f3045d;
    private UUID a;
    private Intent b;
    private int c;

    public a(int i2) {
        this(i2, UUID.randomUUID());
    }

    public static synchronized a a(UUID uuid, int i2) {
        synchronized (a.class) {
            if (com.facebook.internal.instrument.e.a.c(a.class)) {
                return null;
            }
            a c = c();
            if (c != null && c.b().equals(uuid) && c.d() == i2) {
                f(null);
                return c;
            }
            return null;
        }
    }

    public static a c() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            return f3045d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    private static synchronized boolean f(a aVar) {
        synchronized (a.class) {
            if (com.facebook.internal.instrument.e.a.c(a.class)) {
                return false;
            }
            a c = c();
            f3045d = aVar;
            return c != null;
        }
    }

    public UUID b() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.a;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public int d() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        try {
            return this.c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return 0;
        }
    }

    public Intent e() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public boolean g() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return false;
        }
        try {
            return f(this);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return false;
        }
    }

    public void h(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.b = intent;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public a(int i2, UUID uuid) {
        this.a = uuid;
        this.c = i2;
    }
}
