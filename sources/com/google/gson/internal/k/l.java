package com.google.gson.internal.k;

import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes2.dex */
public final class l<T> extends q<T> {
    private final l<T>.b context = new b();
    private q<T> delegate;
    private final com.google.gson.j<T> deserializer;
    final com.google.gson.e gson;
    private final p<T> serializer;
    private final r skipPast;
    private final com.google.gson.t.a<T> typeToken;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes2.dex */
    private final class b implements o, com.google.gson.i {
        private b(l lVar) {
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes2.dex */
    private static final class c implements r {
        private final com.google.gson.j<?> deserializer;
        private final com.google.gson.t.a<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final p<?> serializer;

        c(Object obj, com.google.gson.t.a<?> aVar, boolean z, Class<?> cls) {
            p<?> pVar = obj instanceof p ? (p) obj : null;
            this.serializer = pVar;
            com.google.gson.j<?> jVar = obj instanceof com.google.gson.j ? (com.google.gson.j) obj : null;
            this.deserializer = jVar;
            com.google.gson.internal.a.a((pVar == null && jVar == null) ? false : true);
            this.exactType = aVar;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            boolean isAssignableFrom;
            com.google.gson.t.a<?> aVar2 = this.exactType;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.matchRawType && this.exactType.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.hierarchyType.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.serializer, this.deserializer, eVar, aVar, this);
            }
            return null;
        }
    }

    public l(p<T> pVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, com.google.gson.t.a<T> aVar, r rVar) {
        this.serializer = pVar;
        this.deserializer = jVar;
        this.gson = eVar;
        this.typeToken = aVar;
        this.skipPast = rVar;
    }

    private q<T> delegate() {
        q<T> qVar = this.delegate;
        if (qVar != null) {
            return qVar;
        }
        q<T> n = this.gson.n(this.skipPast, this.typeToken);
        this.delegate = n;
        return n;
    }

    public static r newFactory(com.google.gson.t.a<?> aVar, Object obj) {
        return new c(obj, aVar, false, null);
    }

    public static r newFactoryWithMatchRawType(com.google.gson.t.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static r newTypeHierarchyFactory(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    @Override // com.google.gson.q
    public T read(com.google.gson.stream.a aVar) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(aVar);
        }
        com.google.gson.k a2 = com.google.gson.internal.i.a(aVar);
        if (a2.f()) {
            return null;
        }
        return this.deserializer.a(a2, this.typeToken.getType(), this.context);
    }

    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        p<T> pVar = this.serializer;
        if (pVar == null) {
            delegate().write(bVar, t);
        } else if (t == null) {
            bVar.S();
        } else {
            com.google.gson.internal.i.b(pVar.a(t, this.typeToken.getType(), this.context), bVar);
        }
    }
}
