package kotlin.z;

import kotlin.collections.i0;
/* compiled from: Progressions.kt */
/* loaded from: classes3.dex */
public class e implements Iterable<Long>, kotlin.jvm.internal.z.a {
    private final long a;
    private final long b;
    private final long c;

    public e(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 != Long.MIN_VALUE) {
            this.a = j2;
            this.b = kotlin.internal.c.d(j2, j3, j4);
            this.c = j4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    @Override // java.lang.Iterable
    /* renamed from: c */
    public i0 iterator() {
        return new f(this.a, this.b, this.c);
    }
}
