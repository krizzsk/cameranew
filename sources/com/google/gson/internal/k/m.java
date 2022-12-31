package com.google.gson.internal.k;

import com.google.gson.internal.k.i;
import com.google.gson.q;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes2.dex */
public final class m<T> extends q<T> {
    private final com.google.gson.e context;
    private final q<T> delegate;
    private final Type type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.google.gson.e eVar, q<T> qVar, Type type) {
        this.context = eVar;
        this.delegate = qVar;
        this.type = type;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.q
    public T read(com.google.gson.stream.a aVar) throws IOException {
        return this.delegate.read(aVar);
    }

    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, T t) throws IOException {
        q<T> qVar = this.delegate;
        Type runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t);
        if (runtimeTypeIfMoreSpecific != this.type) {
            qVar = this.context.l(com.google.gson.t.a.get(runtimeTypeIfMoreSpecific));
            if (qVar instanceof i.b) {
                q<T> qVar2 = this.delegate;
                if (!(qVar2 instanceof i.b)) {
                    qVar = qVar2;
                }
            }
        }
        qVar.write(bVar, t);
    }
}
