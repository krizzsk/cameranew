package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.h;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@com.facebook.common.internal.d
@TargetApi(19)
/* loaded from: classes.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    private final p c;

    @com.facebook.common.internal.d
    public KitKatPurgeableDecoder(p pVar) {
        this.c = pVar;
    }

    private static void i(byte[] bArr, int i2) {
        bArr[i2] = -1;
        bArr[i2 + 1] = -39;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer A = aVar.A();
        int size = A.size();
        com.facebook.common.references.a<byte[]> a = this.c.a(size);
        try {
            byte[] A2 = a.A();
            A.b(0, A2, 0, size);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(A2, 0, size, options);
            h.h(decodeByteArray, "BitmapFactory returned null");
            return decodeByteArray;
        } finally {
            com.facebook.common.references.a.y(a);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.f(aVar, i2) ? null : DalvikPurgeableDecoder.b;
        PooledByteBuffer A = aVar.A();
        h.b(Boolean.valueOf(i2 <= A.size()));
        int i3 = i2 + 2;
        com.facebook.common.references.a<byte[]> a = this.c.a(i3);
        try {
            byte[] A2 = a.A();
            A.b(0, A2, 0, i2);
            if (bArr != null) {
                i(A2, i2);
                i2 = i3;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(A2, 0, i2, options);
            h.h(decodeByteArray, "BitmapFactory returned null");
            return decodeByteArray;
        } finally {
            com.facebook.common.references.a.y(a);
        }
    }
}
