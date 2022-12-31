package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* loaded from: classes2.dex */
public abstract class k {
    public int a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public h b() {
        if (e()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m c() {
        if (g()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n d() {
        if (h()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean e() {
        return this instanceof h;
    }

    public boolean f() {
        return this instanceof l;
    }

    public boolean g() {
        return this instanceof m;
    }

    public boolean h() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.b bVar = new com.google.gson.stream.b(stringWriter);
            bVar.Z(true);
            com.google.gson.internal.i.b(this, bVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
