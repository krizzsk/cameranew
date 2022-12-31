package us.pinguo.hawkeye;

import kotlin.jvm.internal.o;
/* compiled from: Config.kt */
/* loaded from: classes4.dex */
public final class a {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11139d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11140e;

    /* compiled from: Config.kt */
    /* renamed from: us.pinguo.hawkeye.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0397a {
        private boolean a;
        private boolean b;
        private boolean c;

        /* renamed from: d  reason: collision with root package name */
        private int f11141d = 500;

        /* renamed from: e  reason: collision with root package name */
        private int f11142e = 64;

        public final a a() {
            return new a(this.a, this.b, this.c, this.f11141d, this.f11142e);
        }

        public final C0397a b(boolean z) {
            this.a = z;
            return this;
        }

        public final C0397a c(boolean z) {
            this.b = z;
            return this;
        }

        public final C0397a d(boolean z) {
            this.c = z;
            return this;
        }
    }

    public a() {
        this(false, false, false, 0, 0, 31, null);
    }

    public a(boolean z, boolean z2, boolean z3, int i2, int i3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.f11139d = i2;
        this.f11140e = i3;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.a == aVar.a) {
                    if (this.b == aVar.b) {
                        if (this.c == aVar.c) {
                            if (this.f11139d == aVar.f11139d) {
                                if (this.f11140e == aVar.f11140e) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        ?? r2 = this.b;
        int i3 = r2;
        if (r2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z2 = this.c;
        return ((((i4 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.f11139d) * 31) + this.f11140e;
    }

    public String toString() {
        return "Config(debug=" + this.a + ", logEnable=" + this.b + ", uiFpsEnable=" + this.c + ", fpsInterval=" + this.f11139d + ", fpsMaxSaveCount=" + this.f11140e + ")";
    }

    public /* synthetic */ a(boolean z, boolean z2, boolean z3, int i2, int i3, int i4, o oVar) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? false : z2, (i4 & 4) == 0 ? z3 : false, (i4 & 8) != 0 ? 500 : i2, (i4 & 16) != 0 ? 64 : i3);
    }
}
