package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
/* compiled from: TypeAdapter.java */
/* loaded from: classes2.dex */
public abstract class q<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapter.java */
    /* loaded from: classes2.dex */
    public class a extends q<T> {
        a() {
        }

        @Override // com.google.gson.q
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return (T) q.this.read(aVar);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.S();
            } else {
                q.this.write(bVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new com.google.gson.stream.a(reader));
    }

    public final T fromJsonTree(k kVar) {
        try {
            return read(new com.google.gson.internal.k.e(kVar));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final q<T> nullSafe() {
        return new a();
    }

    public abstract T read(com.google.gson.stream.a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new com.google.gson.stream.b(writer), t);
    }

    public final k toJsonTree(T t) {
        try {
            com.google.gson.internal.k.f fVar = new com.google.gson.internal.k.f();
            write(fVar, t);
            return fVar.i0();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void write(com.google.gson.stream.b bVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
