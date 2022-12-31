package kotlin.z;
/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class g extends e implements a<Long> {
    static {
        new g(1L, 0L);
    }

    public g(long j2, long j3) {
        super(j2, j3, 1L);
    }

    public boolean d(long j2) {
        return a() <= j2 && j2 <= b();
    }

    @Override // kotlin.z.a
    /* renamed from: e */
    public Long getEndInclusive() {
        return Long.valueOf(b());
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (a() != gVar.a() || b() != gVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.z.a
    /* renamed from: f */
    public Long getStart() {
        return Long.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
