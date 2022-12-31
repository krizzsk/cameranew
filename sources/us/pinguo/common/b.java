package us.pinguo.common;

import android.util.SparseArray;
/* compiled from: Config.java */
/* loaded from: classes4.dex */
public class b {
    final SparseArray<i> a;
    final boolean b;

    /* compiled from: Config.java */
    /* renamed from: us.pinguo.common.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0374b {
        private SparseArray<i> a = new SparseArray<>(5);
        private boolean b = false;

        public C0374b a(int i2, i iVar) {
            if (b.a(i2)) {
                if (this.a.get(i2) == null) {
                    this.a.append(i2, iVar);
                    return this;
                }
                throw new RuntimeException("error repeat flag:" + i2);
            }
            throw new RuntimeException("error flag, must is 2^N,  N:[0 - 31]");
        }

        public C0374b b(i iVar) {
            this.a.append(0, iVar);
            return this;
        }

        public b c() {
            return new b(this.a.clone(), this.b);
        }

        public C0374b d(boolean z) {
            this.b = z;
            return this;
        }
    }

    public static boolean a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3 += i2 & 1;
            i2 >>= 1;
        }
        return i3 == 1;
    }

    private b(SparseArray<i> sparseArray, boolean z) {
        this.a = sparseArray;
        this.b = z;
    }
}
