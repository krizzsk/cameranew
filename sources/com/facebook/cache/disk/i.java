package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEventListener;
import java.io.IOException;
import javax.annotation.Nullable;
/* compiled from: SettableCacheEvent.java */
/* loaded from: classes.dex */
public class i implements com.facebook.cache.common.a {
    private static final Object c = new Object();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static i f2391d;

    /* renamed from: e  reason: collision with root package name */
    private static int f2392e;
    @Nullable
    private com.facebook.cache.common.b a;
    @Nullable
    private i b;

    private i() {
    }

    public static i a() {
        synchronized (c) {
            i iVar = f2391d;
            if (iVar != null) {
                f2391d = iVar.b;
                iVar.b = null;
                f2392e--;
                return iVar;
            }
            return new i();
        }
    }

    private void c() {
    }

    public void b() {
        synchronized (c) {
            if (f2392e < 5) {
                c();
                f2392e++;
                i iVar = f2391d;
                if (iVar != null) {
                    this.b = iVar;
                }
                f2391d = this;
            }
        }
    }

    public i d(com.facebook.cache.common.b bVar) {
        this.a = bVar;
        return this;
    }

    public i e(long j2) {
        return this;
    }

    public i f(long j2) {
        return this;
    }

    public i g(CacheEventListener.EvictionReason evictionReason) {
        return this;
    }

    public i h(IOException iOException) {
        return this;
    }

    public i i(long j2) {
        return this;
    }

    public i j(String str) {
        return this;
    }
}
