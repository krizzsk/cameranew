package com.google.gson.internal.k;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class g implements r {
    final boolean complexMapKeySerialization;
    private final com.google.gson.internal.b constructorConstructor;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    private final class a<K, V> extends q<Map<K, V>> {
        private final com.google.gson.internal.f<? extends Map<K, V>> constructor;
        private final q<K> keyTypeAdapter;
        private final q<V> valueTypeAdapter;

        public a(com.google.gson.e eVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.google.gson.internal.f<? extends Map<K, V>> fVar) {
            this.keyTypeAdapter = new m(eVar, qVar, type);
            this.valueTypeAdapter = new m(eVar, qVar2, type2);
            this.constructor = fVar;
        }

        private String keyToString(com.google.gson.k kVar) {
            if (kVar.h()) {
                com.google.gson.n d2 = kVar.d();
                if (d2.p()) {
                    return String.valueOf(d2.l());
                }
                if (d2.n()) {
                    return Boolean.toString(d2.i());
                }
                if (d2.q()) {
                    return d2.m();
                }
                throw new AssertionError();
            } else if (kVar.f()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
            write(bVar, (Map) ((Map) obj));
        }

        @Override // com.google.gson.q
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken c0 = aVar.c0();
            if (c0 == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            Map<K, V> a = this.constructor.a();
            if (c0 == JsonToken.BEGIN_ARRAY) {
                aVar.d();
                while (aVar.N()) {
                    aVar.d();
                    K read = this.keyTypeAdapter.read(aVar);
                    if (a.put(read, this.valueTypeAdapter.read(aVar)) == null) {
                        aVar.y();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                aVar.y();
            } else {
                aVar.t();
                while (aVar.N()) {
                    com.google.gson.internal.e.a.a(aVar);
                    K read2 = this.keyTypeAdapter.read(aVar);
                    if (a.put(read2, this.valueTypeAdapter.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                aVar.z();
            }
            return a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void write(com.google.gson.stream.b bVar, Map<K, V> map) throws IOException {
            if (map == null) {
                bVar.S();
            } else if (!g.this.complexMapKeySerialization) {
                bVar.w();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.Q(String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(bVar, entry.getValue());
                }
                bVar.z();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.google.gson.k jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(entry2.getValue());
                    z |= jsonTree.e() || jsonTree.g();
                }
                if (z) {
                    bVar.v();
                    int size = arrayList.size();
                    while (i2 < size) {
                        bVar.v();
                        com.google.gson.internal.i.b((com.google.gson.k) arrayList.get(i2), bVar);
                        this.valueTypeAdapter.write(bVar, arrayList2.get(i2));
                        bVar.y();
                        i2++;
                    }
                    bVar.y();
                    return;
                }
                bVar.w();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    bVar.Q(keyToString((com.google.gson.k) arrayList.get(i2)));
                    this.valueTypeAdapter.write(bVar, arrayList2.get(i2));
                    i2++;
                }
                bVar.z();
            }
        }
    }

    public g(com.google.gson.internal.b bVar, boolean z) {
        this.constructorConstructor = bVar;
        this.complexMapKeySerialization = z;
    }

    private q<?> getKeyAdapter(com.google.gson.e eVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return eVar.l(com.google.gson.t.a.get(type));
        }
        return n.f4960f;
    }

    @Override // com.google.gson.r
    public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
        Type type = aVar.getType();
        if (Map.class.isAssignableFrom(aVar.getRawType())) {
            Type[] j2 = C$Gson$Types.j(type, C$Gson$Types.k(type));
            return new a(eVar, j2[0], getKeyAdapter(eVar, j2[0]), j2[1], eVar.l(com.google.gson.t.a.get(j2[1])), this.constructorConstructor.a(aVar));
        }
        return null;
    }
}
