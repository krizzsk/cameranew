package kotlin.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.reflect.KVariance;
import org.slf4j.Marker;
/* compiled from: TypeReference.kt */
/* loaded from: classes3.dex */
public final class TypeReference implements kotlin.reflect.o {
    private final kotlin.reflect.d a;
    private final List<kotlin.reflect.p> b;
    private final kotlin.reflect.o c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8678d;

    /* compiled from: TypeReference.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(kotlin.reflect.p pVar) {
        String valueOf;
        if (pVar.b() == null) {
            return Marker.ANY_MARKER;
        }
        kotlin.reflect.o a2 = pVar.a();
        TypeReference typeReference = a2 instanceof TypeReference ? (TypeReference) a2 : null;
        if (typeReference == null || (valueOf = typeReference.c(true)) == null) {
            valueOf = String.valueOf(pVar.a());
        }
        int i2 = a.a[pVar.b().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "in " + valueOf;
            } else if (i2 == 3) {
                return "out " + valueOf;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return valueOf;
    }

    private final String c(boolean z) {
        String name;
        kotlin.reflect.d f2 = f();
        kotlin.reflect.c cVar = f2 instanceof kotlin.reflect.c ? (kotlin.reflect.c) f2 : null;
        Class<?> a2 = cVar != null ? kotlin.jvm.a.a(cVar) : null;
        if (a2 == null) {
            name = f().toString();
        } else if ((this.f8678d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (a2.isArray()) {
            name = e(a2);
        } else if (z && a2.isPrimitive()) {
            kotlin.reflect.d f3 = f();
            s.f(f3, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = kotlin.jvm.a.b((kotlin.reflect.c) f3).getName();
        } else {
            name = a2.getName();
        }
        String str = name + (d().isEmpty() ? "" : c0.J(d(), ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24, null)) + (g() ? "?" : "");
        kotlin.reflect.o oVar = this.c;
        if (oVar instanceof TypeReference) {
            String c = ((TypeReference) oVar).c(true);
            if (s.c(c, str)) {
                return str;
            }
            if (s.c(c, str + '?')) {
                return str + '!';
            }
            return '(' + str + ".." + c + ')';
        }
        return str;
    }

    private final String e(Class<?> cls) {
        return s.c(cls, boolean[].class) ? "kotlin.BooleanArray" : s.c(cls, char[].class) ? "kotlin.CharArray" : s.c(cls, byte[].class) ? "kotlin.ByteArray" : s.c(cls, short[].class) ? "kotlin.ShortArray" : s.c(cls, int[].class) ? "kotlin.IntArray" : s.c(cls, float[].class) ? "kotlin.FloatArray" : s.c(cls, long[].class) ? "kotlin.LongArray" : s.c(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public List<kotlin.reflect.p> d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (s.c(f(), typeReference.f()) && s.c(d(), typeReference.d()) && s.c(this.c, typeReference.c) && this.f8678d == typeReference.f8678d) {
                return true;
            }
        }
        return false;
    }

    public kotlin.reflect.d f() {
        return this.a;
    }

    public boolean g() {
        return (this.f8678d & 1) != 0;
    }

    public int hashCode() {
        return (((f().hashCode() * 31) + d().hashCode()) * 31) + Integer.valueOf(this.f8678d).hashCode();
    }

    public String toString() {
        return c(false) + " (Kotlin reflection is not available)";
    }
}
