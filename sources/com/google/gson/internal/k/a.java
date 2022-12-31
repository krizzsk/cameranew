package com.google.gson.internal.k;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes2.dex */
public final class a<E> extends q<Object> {
    public static final r FACTORY = new C0189a();
    private final Class<E> componentType;
    private final q<E> componentTypeAdapter;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: com.google.gson.internal.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0189a implements r {
        C0189a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            Type type = aVar.getType();
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type g2 = C$Gson$Types.g(type);
                return new a(eVar, eVar.l(com.google.gson.t.a.get(g2)), C$Gson$Types.k(g2));
            }
            return null;
        }
    }

    public a(com.google.gson.e eVar, q<E> qVar, Class<E> cls) {
        this.componentTypeAdapter = new m(eVar, qVar, cls);
        this.componentType = cls;
    }

    @Override // com.google.gson.q
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.c0() == JsonToken.NULL) {
            aVar.Y();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.d();
        while (aVar.N()) {
            arrayList.add(this.componentTypeAdapter.read(aVar));
        }
        aVar.y();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.componentType, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.S();
            return;
        }
        bVar.v();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.componentTypeAdapter.write(bVar, Array.get(obj, i2));
        }
        bVar.y();
    }
}
