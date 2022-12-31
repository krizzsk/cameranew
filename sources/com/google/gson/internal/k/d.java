package com.google.gson.internal.k;

import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class d implements r {
    private final com.google.gson.internal.b constructorConstructor;

    public d(com.google.gson.internal.b bVar) {
        this.constructorConstructor = bVar;
    }

    @Override // com.google.gson.r
    public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
        com.google.gson.s.b bVar = (com.google.gson.s.b) aVar.getRawType().getAnnotation(com.google.gson.s.b.class);
        if (bVar == null) {
            return null;
        }
        return (q<T>) getTypeAdapter(this.constructorConstructor, eVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<?> getTypeAdapter(com.google.gson.internal.b bVar, com.google.gson.e eVar, com.google.gson.t.a<?> aVar, com.google.gson.s.b bVar2) {
        q<?> lVar;
        Object a = bVar.a(com.google.gson.t.a.get((Class) bVar2.value())).a();
        if (a instanceof q) {
            lVar = (q) a;
        } else if (a instanceof r) {
            lVar = ((r) a).create(eVar, aVar);
        } else {
            boolean z = a instanceof p;
            if (!z && !(a instanceof com.google.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (p) a : null, a instanceof com.google.gson.j ? (com.google.gson.j) a : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar2.nullSafe()) ? lVar : lVar.nullSafe();
    }
}
