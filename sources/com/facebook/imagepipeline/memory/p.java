package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: FlexByteArrayPool.java */
@ThreadSafe
/* loaded from: classes.dex */
public class p {
    private final com.facebook.common.references.h<byte[]> a;
    @VisibleForTesting
    final b b;

    /* compiled from: FlexByteArrayPool.java */
    /* loaded from: classes.dex */
    class a implements com.facebook.common.references.h<byte[]> {
        a() {
        }

        @Override // com.facebook.common.references.h
        /* renamed from: a */
        public void release(byte[] bArr) {
            p.this.b(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlexByteArrayPool.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b extends q {
        public b(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
            super(cVar, c0Var, d0Var);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        f<byte[]> w(int i2) {
            o(i2);
            return new y(i2, this.c.f2853e, 0);
        }
    }

    public p(com.facebook.common.memory.c cVar, c0 c0Var) {
        com.facebook.common.internal.h.b(Boolean.valueOf(c0Var.f2853e > 0));
        this.b = new b(cVar, c0Var, NoOpPoolStatsTracker.getInstance());
        this.a = new a();
    }

    public com.facebook.common.references.a<byte[]> a(int i2) {
        return com.facebook.common.references.a.T(this.b.get(i2), this.a);
    }

    public void b(byte[] bArr) {
        this.b.release(bArr);
    }
}
