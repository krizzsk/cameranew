package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
class b {
    protected static final Comparator<byte[]> a = new Comparator<byte[]>() { // from class: com.bytedance.sdk.adnet.core.b.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private final List<byte[]> b = new ArrayList();
    private final List<byte[]> c = new ArrayList(64);

    /* renamed from: d  reason: collision with root package name */
    private int f1228d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f1229e;

    public b(int i2) {
        this.f1229e = i2;
    }

    public synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            byte[] bArr = this.c.get(i3);
            if (bArr.length >= i2) {
                this.f1228d -= bArr.length;
                this.c.remove(i3);
                this.b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f1229e) {
                this.b.add(bArr);
                int binarySearch = Collections.binarySearch(this.c, bArr, a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.c.add(binarySearch, bArr);
                this.f1228d += bArr.length;
                a();
            }
        }
    }

    private synchronized void a() {
        while (this.f1228d > this.f1229e) {
            byte[] remove = this.b.remove(0);
            this.c.remove(remove);
            this.f1228d -= remove.length;
        }
    }
}
