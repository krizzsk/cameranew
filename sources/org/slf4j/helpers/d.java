package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
/* compiled from: SubstituteLogger.java */
/* loaded from: classes3.dex */
public class d implements org.slf4j.b {
    private final String a;
    private volatile org.slf4j.b b;
    private Boolean c;

    /* renamed from: d  reason: collision with root package name */
    private Method f8968d;

    /* renamed from: e  reason: collision with root package name */
    private org.slf4j.event.a f8969e;

    /* renamed from: f  reason: collision with root package name */
    private Queue<org.slf4j.event.c> f8970f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8971g;

    public d(String str, Queue<org.slf4j.event.c> queue, boolean z) {
        this.a = str;
        this.f8970f = queue;
        this.f8971g = z;
    }

    private org.slf4j.b b() {
        if (this.f8969e == null) {
            this.f8969e = new org.slf4j.event.a(this, this.f8970f);
        }
        return this.f8969e;
    }

    org.slf4j.b a() {
        if (this.b != null) {
            return this.b;
        }
        if (this.f8971g) {
            return NOPLogger.NOP_LOGGER;
        }
        return b();
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f8968d = this.b.getClass().getMethod("log", org.slf4j.event.b.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    @Override // org.slf4j.b
    public void debug(String str) {
        a().debug(str);
    }

    public boolean e() {
        return this.b instanceof NOPLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && d.class == obj.getClass() && this.a.equals(((d) obj).a);
    }

    @Override // org.slf4j.b
    public void error(String str) {
        a().error(str);
    }

    public boolean f() {
        return this.b == null;
    }

    public void g(org.slf4j.event.b bVar) {
        if (d()) {
            try {
                this.f8968d.invoke(this.b, bVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void h(org.slf4j.b bVar) {
        this.b = bVar;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // org.slf4j.b
    public void info(String str) {
        a().info(str);
    }

    @Override // org.slf4j.b
    public void warn(String str) {
        a().warn(str);
    }

    @Override // org.slf4j.b
    public void error(String str, Throwable th) {
        a().error(str, th);
    }

    @Override // org.slf4j.b
    public void warn(String str, Object obj) {
        a().warn(str, obj);
    }

    @Override // org.slf4j.b
    public void warn(String str, Object obj, Object obj2) {
        a().warn(str, obj, obj2);
    }
}
