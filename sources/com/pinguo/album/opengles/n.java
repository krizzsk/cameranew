package com.pinguo.album.opengles;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* compiled from: NinePatchChunk.java */
/* loaded from: classes3.dex */
class n {
    public Rect a = new Rect();
    public int[] b;
    public int[] c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6083d;

    n() {
    }

    private static void a(int i2) {
        if (i2 == 0 || (i2 & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i2);
        }
    }

    public static n b(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        n nVar = new n();
        nVar.b = new int[order.get()];
        nVar.c = new int[order.get()];
        nVar.f6083d = new int[order.get()];
        a(nVar.b.length);
        a(nVar.c.length);
        order.getInt();
        order.getInt();
        nVar.a.left = order.getInt();
        nVar.a.right = order.getInt();
        nVar.a.top = order.getInt();
        nVar.a.bottom = order.getInt();
        order.getInt();
        c(nVar.b, order);
        c(nVar.c, order);
        c(nVar.f6083d, order);
        return nVar;
    }

    private static void c(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = byteBuffer.getInt();
        }
    }
}
