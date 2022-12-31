package com.facebook.s.a.b.d;

import android.graphics.Bitmap;
import com.facebook.s.a.b.b;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: KeepLastFrameCache.java */
/* loaded from: classes.dex */
public class c implements com.facebook.s.a.b.b {
    private int a = -1;
    @Nullable
    private b.a b;
    @GuardedBy("this")
    @Nullable
    private com.facebook.common.references.a<Bitmap> c;

    private synchronized void g() {
        int i2;
        b.a aVar = this.b;
        if (aVar != null && (i2 = this.a) != -1) {
            aVar.a(this, i2);
        }
        com.facebook.common.references.a.y(this.c);
        this.c = null;
        this.a = -1;
    }

    @Override // com.facebook.s.a.b.b
    public void a(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3) {
    }

    @Override // com.facebook.s.a.b.b
    public synchronized void b(int i2, com.facebook.common.references.a<Bitmap> aVar, int i3) {
        int i4;
        if (aVar != null) {
            if (this.c != null && aVar.A().equals(this.c.A())) {
                return;
            }
        }
        com.facebook.common.references.a.y(this.c);
        b.a aVar2 = this.b;
        if (aVar2 != null && (i4 = this.a) != -1) {
            aVar2.a(this, i4);
        }
        this.c = com.facebook.common.references.a.w(aVar);
        b.a aVar3 = this.b;
        if (aVar3 != null) {
            aVar3.b(this, i2);
        }
        this.a = i2;
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> c(int i2) {
        return com.facebook.common.references.a.w(this.c);
    }

    @Override // com.facebook.s.a.b.b
    public synchronized void clear() {
        g();
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> d(int i2, int i3, int i4) {
        com.facebook.common.references.a<Bitmap> w;
        w = com.facebook.common.references.a.w(this.c);
        g();
        return w;
    }

    @Override // com.facebook.s.a.b.b
    public synchronized boolean e(int i2) {
        boolean z;
        if (i2 == this.a) {
            z = com.facebook.common.references.a.Q(this.c);
        }
        return z;
    }

    @Override // com.facebook.s.a.b.b
    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> f(int i2) {
        if (this.a == i2) {
            return com.facebook.common.references.a.w(this.c);
        }
        return null;
    }
}
