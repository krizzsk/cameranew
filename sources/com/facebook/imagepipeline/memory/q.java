package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: GenericByteArrayPool.java */
@ThreadSafe
/* loaded from: classes.dex */
public class q extends BasePool<byte[]> implements com.facebook.common.memory.a {

    /* renamed from: k  reason: collision with root package name */
    private final int[] f2857k;

    public q(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
        super(cVar, c0Var, d0Var);
        SparseIntArray sparseIntArray = c0Var.c;
        com.facebook.common.internal.h.g(sparseIntArray);
        SparseIntArray sparseIntArray2 = sparseIntArray;
        this.f2857k = new int[sparseIntArray2.size()];
        for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
            this.f2857k[i2] = sparseIntArray2.keyAt(i2);
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: A */
    public void j(byte[] bArr) {
        com.facebook.common.internal.h.g(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: B */
    public int n(byte[] bArr) {
        com.facebook.common.internal.h.g(bArr);
        return bArr.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int m(int i2) {
        int[] iArr;
        if (i2 > 0) {
            for (int i3 : this.f2857k) {
                if (i3 >= i2) {
                    return i3;
                }
            }
            return i2;
        }
        throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int o(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: z */
    public byte[] f(int i2) {
        return new byte[i2];
    }
}
