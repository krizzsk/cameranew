package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes2.dex */
public final class b {
    private final Map<Type, com.google.gson.g<?>> a;
    private final ReflectionAccessor b = ReflectionAccessor.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class a implements com.google.gson.internal.f<T> {
        a(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.internal.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0187b implements com.google.gson.internal.f<T> {
        C0187b(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class c implements com.google.gson.internal.f<T> {
        c(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class d implements com.google.gson.internal.f<T> {
        d(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class e implements com.google.gson.internal.f<T> {
        private final com.google.gson.internal.j a = com.google.gson.internal.j.b();
        final /* synthetic */ Class b;
        final /* synthetic */ Type c;

        e(b bVar, Class cls, Type type) {
            this.b = cls;
            this.c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return this.a.c(this.b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    class f implements com.google.gson.internal.f<T> {
        final /* synthetic */ com.google.gson.g a;
        final /* synthetic */ Type b;

        f(b bVar, com.google.gson.g gVar, Type type) {
            this.a = gVar;
            this.b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            return this.a.a(this.b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    class g implements com.google.gson.internal.f<T> {
        final /* synthetic */ com.google.gson.g a;
        final /* synthetic */ Type b;

        g(b bVar, com.google.gson.g gVar, Type type) {
            this.a = gVar;
            this.b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            return this.a.a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class h implements com.google.gson.internal.f<T> {
        final /* synthetic */ Constructor a;

        h(b bVar, Constructor constructor) {
            this.a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return this.a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class i implements com.google.gson.internal.f<T> {
        i(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class j implements com.google.gson.internal.f<T> {
        final /* synthetic */ Type a;

        j(b bVar, Type type) {
            this.a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            Type type = this.a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class k implements com.google.gson.internal.f<T> {
        k(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class l implements com.google.gson.internal.f<T> {
        l(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class m implements com.google.gson.internal.f<T> {
        m(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class n implements com.google.gson.internal.f<T> {
        n(b bVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public b(Map<Type, com.google.gson.g<?>> map) {
        this.a = map;
    }

    private <T> com.google.gson.internal.f<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> com.google.gson.internal.f<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C0187b(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.google.gson.t.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new c(this);
            }
            return new d(this);
        } else {
            return null;
        }
    }

    private <T> com.google.gson.internal.f<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public <T> com.google.gson.internal.f<T> a(com.google.gson.t.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.g<?> gVar = this.a.get(type);
        if (gVar != null) {
            return new f(this, gVar, type);
        }
        com.google.gson.g<?> gVar2 = this.a.get(rawType);
        if (gVar2 != null) {
            return new g(this, gVar2, type);
        }
        com.google.gson.internal.f<T> b = b(rawType);
        if (b != null) {
            return b;
        }
        com.google.gson.internal.f<T> c2 = c(type, rawType);
        return c2 != null ? c2 : d(type, rawType);
    }

    public String toString() {
        return this.a.toString();
    }
}
