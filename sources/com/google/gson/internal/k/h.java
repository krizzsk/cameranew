package com.google.gson.internal.k;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes2.dex */
public final class h extends q<Object> {
    public static final r FACTORY = new a();
    private final com.google.gson.e gson;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes2.dex */
    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(com.google.gson.e eVar) {
        this.gson = eVar;
    }

    @Override // com.google.gson.q
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        switch (b.a[aVar.c0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.d();
                while (aVar.N()) {
                    arrayList.add(read(aVar));
                }
                aVar.y();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                aVar.t();
                while (aVar.N()) {
                    linkedTreeMap.put(aVar.W(), read(aVar));
                }
                aVar.z();
                return linkedTreeMap;
            case 3:
                return aVar.a0();
            case 4:
                return Double.valueOf(aVar.T());
            case 5:
                return Boolean.valueOf(aVar.S());
            case 6:
                aVar.Y();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.S();
            return;
        }
        q m = this.gson.m(obj.getClass());
        if (m instanceof h) {
            bVar.w();
            bVar.z();
            return;
        }
        m.write(bVar, obj);
    }
}
