package d.f.a.a.b.c;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
/* compiled from: LruMemoryCache.java */
/* loaded from: classes3.dex */
public class b implements d.f.a.a.b.a {
    private final LinkedHashMap<String, Bitmap> a;
    private final int b;
    private int c;

    public b(int i2) {
        if (i2 > 0) {
            this.b = i2;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int e(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L11
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L50
        L11:
            int r0 = r3.c     // Catch: java.lang.Throwable -> L6f
            if (r0 <= r4) goto L4e
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.a     // Catch: java.lang.Throwable -> L6f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.a     // Catch: java.lang.Throwable -> L6f
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6f
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6f
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L32
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L4f
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6f
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L6f
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.a     // Catch: java.lang.Throwable -> L6f
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6f
            int r2 = r3.c     // Catch: java.lang.Throwable -> L6f
            int r0 = r3.e(r1, r0)     // Catch: java.lang.Throwable -> L6f
            int r2 = r2 - r0
            r3.c = r2     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            goto L0
        L4e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
        L4f:
            return
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6f
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6f
            throw r4     // Catch: java.lang.Throwable -> L6f
        L6f:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6f
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.a.b.c.b.f(int):void");
    }

    @Override // d.f.a.a.b.b
    public Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }

    @Override // d.f.a.a.b.b
    /* renamed from: b */
    public final Bitmap get(String str) {
        Bitmap bitmap;
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            bitmap = this.a.get(str);
        }
        return bitmap;
    }

    @Override // d.f.a.a.b.b
    /* renamed from: c */
    public final boolean put(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            synchronized (this) {
                this.c += e(str, bitmap);
                Bitmap put = this.a.put(str, bitmap);
                if (put != null) {
                    this.c -= e(str, put);
                }
            }
            f(this.b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    @Override // d.f.a.a.b.b
    /* renamed from: d */
    public final Bitmap remove(String str) {
        Bitmap remove;
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            remove = this.a.remove(str);
            if (remove != null) {
                this.c -= e(str, remove);
            }
        }
        return remove;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }
}
