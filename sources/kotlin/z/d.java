package kotlin.z;

import kotlin.jvm.internal.o;
/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class d extends b implements kotlin.z.a<Integer> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8691e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final d f8692f = new d(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final d a() {
            return d.f8692f;
        }
    }

    public d(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // kotlin.z.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (a() != dVar.a() || b() != dVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i2) {
        return a() <= i2 && i2 <= b();
    }

    @Override // kotlin.z.a
    /* renamed from: g */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    @Override // kotlin.z.a
    /* renamed from: h */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.z.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // kotlin.z.b
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // kotlin.z.b
    public String toString() {
        return a() + ".." + b();
    }
}
