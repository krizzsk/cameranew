package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.l0;
import kotlin.collections.m0;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: ClassReference.kt */
/* loaded from: classes3.dex */
public final class m implements kotlin.reflect.c<Object>, l {
    private static final Map<Class<? extends kotlin.c<?>>, Integer> b;
    private static final HashMap<String, String> c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f8679d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f8680e;
    private final Class<?> a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List j2;
        int o;
        Map<Class<? extends kotlin.c<?>>, Integer> m;
        int c2;
        String A0;
        String A02;
        int i2 = 0;
        j2 = kotlin.collections.u.j(kotlin.jvm.b.a.class, kotlin.jvm.b.l.class, kotlin.jvm.b.p.class, kotlin.jvm.b.q.class, kotlin.jvm.b.r.class, kotlin.jvm.b.s.class, kotlin.jvm.b.t.class, kotlin.jvm.b.u.class, kotlin.jvm.b.v.class, kotlin.jvm.b.w.class, kotlin.jvm.b.b.class, kotlin.jvm.b.c.class, kotlin.jvm.b.d.class, kotlin.jvm.b.e.class, kotlin.jvm.b.f.class, kotlin.jvm.b.g.class, kotlin.jvm.b.h.class, kotlin.jvm.b.i.class, kotlin.jvm.b.j.class, kotlin.jvm.b.k.class, kotlin.jvm.b.m.class, kotlin.jvm.b.n.class, kotlin.jvm.b.o.class);
        o = kotlin.collections.v.o(j2, 10);
        ArrayList arrayList = new ArrayList(o);
        for (Object obj : j2) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                arrayList.add(kotlin.k.a((Class) obj, Integer.valueOf(i2)));
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        m = m0.m(arrayList);
        b = m;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put(Constants.LONG, "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f8679d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        s.g(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            s.g(kotlinName, "kotlinName");
            A02 = StringsKt__StringsKt.A0(kotlinName, '.', null, 2, null);
            sb.append(A02);
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair a = kotlin.k.a(sb2, kotlinName + ".Companion");
            hashMap3.put(a.getFirst(), a.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.c<?>>, Integer> entry : b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f8680e = hashMap3;
        c2 = l0.c(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(c2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            A0 = StringsKt__StringsKt.A0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, A0);
        }
    }

    public m(Class<?> jClass) {
        s.h(jClass, "jClass");
        this.a = jClass;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && s.c(kotlin.jvm.a.b(this), kotlin.jvm.a.b((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
