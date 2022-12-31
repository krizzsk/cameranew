package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class ab implements Closeable {
    public static ab a(u uVar, byte[] bArr) {
        return a(uVar, bArr.length, new com.bytedance.sdk.a.a.c().c(bArr));
    }

    public abstract long a();

    public final InputStream b() {
        return c().f();
    }

    public abstract com.bytedance.sdk.a.a.e c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.a.b.a.c.a(c());
    }

    public static ab a(final u uVar, final long j2, final com.bytedance.sdk.a.a.e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new ab() { // from class: com.bytedance.sdk.a.b.ab.1
            @Override // com.bytedance.sdk.a.b.ab
            public long a() {
                return j2;
            }

            @Override // com.bytedance.sdk.a.b.ab
            public com.bytedance.sdk.a.a.e c() {
                return eVar;
            }
        };
    }
}
