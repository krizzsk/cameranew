package kotlin.z;

import kotlin.collections.h0;
import kotlin.jvm.internal.o;
/* compiled from: Progressions.kt */
/* loaded from: classes3.dex */
public class b implements Iterable<Integer>, kotlin.jvm.internal.z.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f8689d = new a(null);
    private final int a;
    private final int b;
    private final int c;

    /* compiled from: Progressions.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final b a(int i2, int i3, int i4) {
            return new b(i2, i3, i4);
        }
    }

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 != Integer.MIN_VALUE) {
            this.a = i2;
            this.b = kotlin.internal.c.c(i2, i3, i4);
            this.c = i4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public h0 iterator() {
        return new c(this.a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.a != bVar.a || this.b != bVar.b || this.c != bVar.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.a > this.b) {
                return true;
            }
        } else if (this.a < this.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i2 = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i2 = -this.c;
        }
        sb.append(i2);
        return sb.toString();
    }
}
