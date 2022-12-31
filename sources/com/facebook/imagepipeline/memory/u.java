package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: MemoryChunkPool.java */
@ThreadSafe
/* loaded from: classes.dex */
public abstract class u extends BasePool<t> {

    /* renamed from: k  reason: collision with root package name */
    private final int[] f2860k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
        super(cVar, c0Var, d0Var);
        SparseIntArray sparseIntArray = c0Var.c;
        com.facebook.common.internal.h.g(sparseIntArray);
        SparseIntArray sparseIntArray2 = sparseIntArray;
        this.f2860k = new int[sparseIntArray2.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2860k;
            if (i2 < iArr.length) {
                iArr[i2] = sparseIntArray2.keyAt(i2);
                i2++;
            } else {
                r();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: A */
    public void j(t tVar) {
        com.facebook.common.internal.h.g(tVar);
        tVar.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: B */
    public int n(t tVar) {
        com.facebook.common.internal.h.g(tVar);
        return tVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f2860k[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: D */
    public boolean t(t tVar) {
        com.facebook.common.internal.h.g(tVar);
        return !tVar.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int m(int i2) {
        int[] iArr;
        if (i2 > 0) {
            for (int i3 : this.f2860k) {
                if (i3 >= i2) {
                    return i3;
                }
            }
            return i2;
        }
        throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int o(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: z */
    public abstract t f(int i2);
}
