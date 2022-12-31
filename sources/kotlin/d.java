package kotlin;
/* compiled from: KotlinVersion.kt */
/* loaded from: classes3.dex */
public final class d implements Comparable<d> {

    /* renamed from: e  reason: collision with root package name */
    public static final d f8676e = e.a();
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8677d;

    public d(int i2, int i3, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f8677d = b(i2, i3, i4);
    }

    private final int b(int i2, int i3, int i4) {
        boolean z = false;
        if (new kotlin.z.d(0, 255).f(i2) && new kotlin.z.d(0, 255).f(i3) && new kotlin.z.d(0, 255).f(i4)) {
            z = true;
        }
        if (z) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d other) {
        kotlin.jvm.internal.s.h(other, "other");
        return this.f8677d - other.f8677d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        d dVar = obj instanceof d ? (d) obj : null;
        return dVar != null && this.f8677d == dVar.f8677d;
    }

    public int hashCode() {
        return this.f8677d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
