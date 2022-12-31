package kotlin.jvm.internal;
/* compiled from: PackageReference.kt */
/* loaded from: classes3.dex */
public final class u implements l {
    private final Class<?> a;

    public u(Class<?> jClass, String moduleName) {
        s.h(jClass, "jClass");
        s.h(moduleName, "moduleName");
        this.a = jClass;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && s.c(a(), ((u) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
