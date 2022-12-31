package com.google.gson.internal.k;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class i implements r {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final com.google.gson.internal.b constructorConstructor;
    private final com.google.gson.internal.c excluder;
    private final com.google.gson.d fieldNamingPolicy;
    private final d jsonAdapterFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Field f4952d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f4953e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q f4954f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f4955g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.google.gson.t.a f4956h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f4957i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i iVar, String str, boolean z, boolean z2, Field field, boolean z3, q qVar, com.google.gson.e eVar, com.google.gson.t.a aVar, boolean z4) {
            super(str, z, z2);
            this.f4952d = field;
            this.f4953e = z3;
            this.f4954f = qVar;
            this.f4955g = eVar;
            this.f4956h = aVar;
            this.f4957i = z4;
        }

        @Override // com.google.gson.internal.k.i.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object read = this.f4954f.read(aVar);
            if (read == null && this.f4957i) {
                return;
            }
            this.f4952d.set(obj, read);
        }

        @Override // com.google.gson.internal.k.i.c
        void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException {
            (this.f4953e ? this.f4954f : new m(this.f4955g, this.f4954f, this.f4956h.getType())).write(bVar, this.f4952d.get(obj));
        }

        @Override // com.google.gson.internal.k.i.c
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.b && this.f4952d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<T> extends q<T> {
        private final Map<String, c> boundFields;
        private final com.google.gson.internal.f<T> constructor;

        b(com.google.gson.internal.f<T> fVar, Map<String, c> map) {
            this.constructor = fVar;
            this.boundFields = map;
        }

        @Override // com.google.gson.q
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            T a = this.constructor.a();
            try {
                aVar.t();
                while (aVar.N()) {
                    c cVar = this.boundFields.get(aVar.W());
                    if (cVar != null && cVar.c) {
                        cVar.a(aVar, a);
                    }
                    aVar.m0();
                }
                aVar.z();
                return a;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.S();
                return;
            }
            bVar.w();
            try {
                for (c cVar : this.boundFields.values()) {
                    if (cVar.c(t)) {
                        bVar.Q(cVar.a);
                        cVar.b(bVar, t);
                    }
                }
                bVar.z();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static abstract class c {
        final String a;
        final boolean b;
        final boolean c;

        protected c(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.b bVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.google.gson.internal.b bVar, com.google.gson.d dVar, com.google.gson.internal.c cVar, d dVar2) {
        this.constructorConstructor = bVar;
        this.fieldNamingPolicy = dVar;
        this.excluder = cVar;
        this.jsonAdapterFactory = dVar2;
    }

    private c createBoundField(com.google.gson.e eVar, Field field, String str, com.google.gson.t.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = com.google.gson.internal.h.a(aVar.getRawType());
        com.google.gson.s.b bVar = (com.google.gson.s.b) field.getAnnotation(com.google.gson.s.b.class);
        q<?> typeAdapter = bVar != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, eVar, aVar, bVar) : null;
        boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = eVar.l(aVar);
        }
        return new a(this, str, z, z2, field, z3, typeAdapter, eVar, aVar, a2);
    }

    private Map<String, c> getBoundFields(com.google.gson.e eVar, com.google.gson.t.a<?> aVar, Class<?> cls) {
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.t.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, z);
                if (excludeField || excludeField2) {
                    this.accessor.a(field);
                    Type p = C$Gson$Types.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    int size = fieldNames.size();
                    c cVar2 = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = fieldNames.get(i3);
                        boolean z2 = i3 != 0 ? false : excludeField;
                        int i4 = i3;
                        c cVar3 = cVar2;
                        int i5 = size;
                        List<String> list = fieldNames;
                        Field field2 = field;
                        cVar2 = cVar3 == null ? (c) linkedHashMap.put(str, createBoundField(eVar, field, str, com.google.gson.t.a.get(p), z2, excludeField2)) : cVar3;
                        i3 = i4 + 1;
                        excludeField = z2;
                        fieldNames = list;
                        size = i5;
                        field = field2;
                    }
                    if (cVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar.a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.google.gson.t.a.get(C$Gson$Types.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        com.google.gson.s.c cVar = (com.google.gson.s.c) field.getAnnotation(com.google.gson.s.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.r
    public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.constructorConstructor.a(aVar), getBoundFields(eVar, aVar, rawType));
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, com.google.gson.internal.c cVar) {
        return (cVar.excludeClass(field.getType(), z) || cVar.excludeField(field, z)) ? false : true;
    }
}
