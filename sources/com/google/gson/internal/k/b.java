package com.google.gson.internal.k;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class b implements r {
    private final com.google.gson.internal.b constructorConstructor;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    private static final class a<E> extends q<Collection<E>> {
        private final com.google.gson.internal.f<? extends Collection<E>> constructor;
        private final q<E> elementTypeAdapter;

        public a(com.google.gson.e eVar, Type type, q<E> qVar, com.google.gson.internal.f<? extends Collection<E>> fVar) {
            this.elementTypeAdapter = new m(eVar, qVar, type);
            this.constructor = fVar;
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
            write(bVar, (Collection) ((Collection) obj));
        }

        @Override // com.google.gson.q
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            Collection<E> a = this.constructor.a();
            aVar.d();
            while (aVar.N()) {
                a.add(this.elementTypeAdapter.read(aVar));
            }
            aVar.y();
            return a;
        }

        public void write(com.google.gson.stream.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.S();
                return;
            }
            bVar.v();
            for (E e2 : collection) {
                this.elementTypeAdapter.write(bVar, e2);
            }
            bVar.y();
        }
    }

    public b(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.r
    public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type h2 = C$Gson$Types.h(type, rawType);
            return new a(eVar, h2, eVar.l(com.google.gson.t.a.get(h2)), this.constructorConstructor.a(aVar));
        }
        return null;
    }
}
