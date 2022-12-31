package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.d;
/* compiled from: EventRecodingLogger.java */
/* loaded from: classes3.dex */
public class a implements org.slf4j.b {
    String a;
    d b;
    Queue<c> c;

    public a(d dVar, Queue<c> queue) {
        this.b = dVar;
        this.a = dVar.c();
        this.c = queue;
    }

    private void a(Level level, String str, Object[] objArr, Throwable th) {
        b(level, null, str, objArr, th);
    }

    private void b(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        c cVar = new c();
        cVar.i(System.currentTimeMillis());
        cVar.c(level);
        cVar.d(this.b);
        cVar.e(this.a);
        cVar.f(str);
        cVar.b(objArr);
        cVar.h(th);
        cVar.g(Thread.currentThread().getName());
        this.c.add(cVar);
    }

    @Override // org.slf4j.b
    public void debug(String str) {
        a(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.b
    public void error(String str) {
        a(Level.ERROR, str, null, null);
    }

    @Override // org.slf4j.b
    public void info(String str) {
        a(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.b
    public void warn(String str) {
        a(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.b
    public void error(String str, Throwable th) {
        a(Level.ERROR, str, null, th);
    }

    @Override // org.slf4j.b
    public void warn(String str, Object obj) {
        a(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.b
    public void warn(String str, Object obj, Object obj2) {
        a(Level.WARN, str, new Object[]{obj, obj2}, null);
    }
}
