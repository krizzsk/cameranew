package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* compiled from: Gson.java */
/* loaded from: classes2.dex */
public final class e {
    private static final com.google.gson.t.a<?> n = com.google.gson.t.a.get(Object.class);
    private final ThreadLocal<Map<com.google.gson.t.a<?>, f<?>>> a;
    private final Map<com.google.gson.t.a<?>, q<?>> b;
    private final com.google.gson.internal.b c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.internal.k.d f4919d;

    /* renamed from: e  reason: collision with root package name */
    final List<r> f4920e;

    /* renamed from: f  reason: collision with root package name */
    final Map<Type, g<?>> f4921f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f4922g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f4923h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f4924i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f4925j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f4926k;

    /* renamed from: l  reason: collision with root package name */
    final List<r> f4927l;
    final List<r> m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class a extends q<Number> {
        a() {
        }

        @Override // com.google.gson.q
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Double.valueOf(aVar.T());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.S();
                return;
            }
            e.d(number.doubleValue());
            bVar.e0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class b extends q<Number> {
        b() {
        }

        @Override // com.google.gson.q
        /* renamed from: read */
        public Number read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Float.valueOf((float) aVar.T());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.S();
                return;
            }
            e.d(number.floatValue());
            bVar.e0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class c extends q<Number> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Long.valueOf(aVar.V());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            if (number == null) {
                bVar.S();
            } else {
                bVar.f0(number.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public class d extends q<AtomicLong> {
        final /* synthetic */ q val$longAdapter;

        d(q qVar) {
            this.val$longAdapter = qVar;
        }

        @Override // com.google.gson.q
        public AtomicLong read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicLong(((Number) this.val$longAdapter.read(aVar)).longValue());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, AtomicLong atomicLong) throws IOException {
            this.val$longAdapter.write(bVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0186e extends q<AtomicLongArray> {
        final /* synthetic */ q val$longAdapter;

        C0186e(q qVar) {
            this.val$longAdapter = qVar;
        }

        @Override // com.google.gson.q
        public AtomicLongArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.d();
            while (aVar.N()) {
                arrayList.add(Long.valueOf(((Number) this.val$longAdapter.read(aVar)).longValue()));
            }
            aVar.y();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, AtomicLongArray atomicLongArray) throws IOException {
            bVar.v();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.val$longAdapter.write(bVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            bVar.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes2.dex */
    public static class f<T> extends q<T> {
        private q<T> delegate;

        f() {
        }

        @Override // com.google.gson.q
        public T read(com.google.gson.stream.a aVar) throws IOException {
            q<T> qVar = this.delegate;
            if (qVar != null) {
                return qVar.read(aVar);
            }
            throw new IllegalStateException();
        }

        public void setDelegate(q<T> qVar) {
            if (this.delegate == null) {
                this.delegate = qVar;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            q<T> qVar = this.delegate;
            if (qVar != null) {
                qVar.write(bVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public e() {
        this(com.google.gson.internal.c.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.c0() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static q<AtomicLong> b(q<Number> qVar) {
        return new d(qVar).nullSafe();
    }

    private static q<AtomicLongArray> c(q<Number> qVar) {
        return new C0186e(qVar).nullSafe();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private q<Number> e(boolean z) {
        if (z) {
            return com.google.gson.internal.k.n.v;
        }
        return new a();
    }

    private q<Number> f(boolean z) {
        if (z) {
            return com.google.gson.internal.k.n.u;
        }
        return new b();
    }

    private static q<Number> o(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return com.google.gson.internal.k.n.t;
        }
        return new c();
    }

    public <T> T g(com.google.gson.stream.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean O = aVar.O();
        boolean z = true;
        aVar.h0(true);
        try {
            try {
                try {
                    aVar.c0();
                    z = false;
                    T read = l(com.google.gson.t.a.get(type)).read(aVar);
                    aVar.h0(O);
                    return read;
                } catch (AssertionError e2) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                    assertionError.initCause(e2);
                    throw assertionError;
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (z) {
                    aVar.h0(O);
                    return null;
                }
                throw new JsonSyntaxException(e4);
            } catch (IOException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (Throwable th) {
            aVar.h0(O);
            throw th;
        }
    }

    public <T> T h(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        com.google.gson.stream.a p = p(reader);
        Object g2 = g(p, cls);
        a(g2, p);
        return (T) com.google.gson.internal.h.b(cls).cast(g2);
    }

    public <T> T i(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        com.google.gson.stream.a p = p(reader);
        T t = (T) g(p, type);
        a(t, p);
        return t;
    }

    public <T> T j(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.internal.h.b(cls).cast(k(str, cls));
    }

    public <T> T k(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) i(new StringReader(str), type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> q<T> l(com.google.gson.t.a<T> aVar) {
        q<T> qVar = (q<T>) this.b.get(aVar == null ? n : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.google.gson.t.a<?>, f<?>> map = this.a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            for (r rVar : this.f4920e) {
                q qVar2 = (q<T>) rVar.create(this, aVar);
                if (qVar2 != null) {
                    fVar2.setDelegate(qVar2);
                    this.b.put(aVar, qVar2);
                    return qVar2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.a.remove();
            }
        }
    }

    public <T> q<T> m(Class<T> cls) {
        return l(com.google.gson.t.a.get((Class) cls));
    }

    public <T> q<T> n(r rVar, com.google.gson.t.a<T> aVar) {
        if (!this.f4920e.contains(rVar)) {
            rVar = this.f4919d;
        }
        boolean z = false;
        for (r rVar2 : this.f4920e) {
            if (z) {
                q<T> create = rVar2.create(this, aVar);
                if (create != null) {
                    return create;
                }
            } else if (rVar2 == rVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.stream.a p(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.h0(this.f4926k);
        return aVar;
    }

    public com.google.gson.stream.b q(Writer writer) throws IOException {
        if (this.f4923h) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.b bVar = new com.google.gson.stream.b(writer);
        if (this.f4925j) {
            bVar.Y("  ");
        }
        bVar.a0(this.f4922g);
        return bVar;
    }

    public String r(k kVar) {
        StringWriter stringWriter = new StringWriter();
        v(kVar, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        if (obj == null) {
            return r(l.a);
        }
        return t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f4922g + ",factories:" + this.f4920e + ",instanceCreators:" + this.c + "}";
    }

    public void u(k kVar, com.google.gson.stream.b bVar) throws JsonIOException {
        boolean O = bVar.O();
        bVar.Z(true);
        boolean N = bVar.N();
        bVar.X(this.f4924i);
        boolean A = bVar.A();
        bVar.a0(this.f4922g);
        try {
            try {
                com.google.gson.internal.i.b(kVar, bVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bVar.Z(O);
            bVar.X(N);
            bVar.a0(A);
        }
    }

    public void v(k kVar, Appendable appendable) throws JsonIOException {
        try {
            u(kVar, q(com.google.gson.internal.i.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void w(Object obj, Type type, com.google.gson.stream.b bVar) throws JsonIOException {
        q l2 = l(com.google.gson.t.a.get(type));
        boolean O = bVar.O();
        bVar.Z(true);
        boolean N = bVar.N();
        bVar.X(this.f4924i);
        boolean A = bVar.A();
        bVar.a0(this.f4922g);
        try {
            try {
                l2.write(bVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            bVar.Z(O);
            bVar.X(N);
            bVar.a0(A);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            w(obj, type, q(com.google.gson.internal.i.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.google.gson.internal.c cVar, com.google.gson.d dVar, Map<Type, g<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i2, int i3, List<r> list, List<r> list2, List<r> list3) {
        this.a = new ThreadLocal<>();
        this.b = new ConcurrentHashMap();
        this.f4921f = map;
        com.google.gson.internal.b bVar = new com.google.gson.internal.b(map);
        this.c = bVar;
        this.f4922g = z;
        this.f4923h = z3;
        this.f4924i = z4;
        this.f4925j = z5;
        this.f4926k = z6;
        this.f4927l = list;
        this.m = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.k.n.Y);
        arrayList.add(com.google.gson.internal.k.h.FACTORY);
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.internal.k.n.D);
        arrayList.add(com.google.gson.internal.k.n.m);
        arrayList.add(com.google.gson.internal.k.n.f4961g);
        arrayList.add(com.google.gson.internal.k.n.f4963i);
        arrayList.add(com.google.gson.internal.k.n.f4965k);
        q<Number> o = o(longSerializationPolicy);
        arrayList.add(com.google.gson.internal.k.n.c(Long.TYPE, Long.class, o));
        arrayList.add(com.google.gson.internal.k.n.c(Double.TYPE, Double.class, e(z7)));
        arrayList.add(com.google.gson.internal.k.n.c(Float.TYPE, Float.class, f(z7)));
        arrayList.add(com.google.gson.internal.k.n.x);
        arrayList.add(com.google.gson.internal.k.n.o);
        arrayList.add(com.google.gson.internal.k.n.q);
        arrayList.add(com.google.gson.internal.k.n.b(AtomicLong.class, b(o)));
        arrayList.add(com.google.gson.internal.k.n.b(AtomicLongArray.class, c(o)));
        arrayList.add(com.google.gson.internal.k.n.s);
        arrayList.add(com.google.gson.internal.k.n.z);
        arrayList.add(com.google.gson.internal.k.n.F);
        arrayList.add(com.google.gson.internal.k.n.H);
        arrayList.add(com.google.gson.internal.k.n.b(BigDecimal.class, com.google.gson.internal.k.n.B));
        arrayList.add(com.google.gson.internal.k.n.b(BigInteger.class, com.google.gson.internal.k.n.C));
        arrayList.add(com.google.gson.internal.k.n.J);
        arrayList.add(com.google.gson.internal.k.n.L);
        arrayList.add(com.google.gson.internal.k.n.P);
        arrayList.add(com.google.gson.internal.k.n.R);
        arrayList.add(com.google.gson.internal.k.n.W);
        arrayList.add(com.google.gson.internal.k.n.N);
        arrayList.add(com.google.gson.internal.k.n.f4958d);
        arrayList.add(com.google.gson.internal.k.c.FACTORY);
        arrayList.add(com.google.gson.internal.k.n.U);
        arrayList.add(com.google.gson.internal.k.k.FACTORY);
        arrayList.add(com.google.gson.internal.k.j.FACTORY);
        arrayList.add(com.google.gson.internal.k.n.S);
        arrayList.add(com.google.gson.internal.k.a.FACTORY);
        arrayList.add(com.google.gson.internal.k.n.b);
        arrayList.add(new com.google.gson.internal.k.b(bVar));
        arrayList.add(new com.google.gson.internal.k.g(bVar, z2));
        com.google.gson.internal.k.d dVar2 = new com.google.gson.internal.k.d(bVar);
        this.f4919d = dVar2;
        arrayList.add(dVar2);
        arrayList.add(com.google.gson.internal.k.n.Z);
        arrayList.add(new com.google.gson.internal.k.i(bVar, dVar, cVar, dVar2));
        this.f4920e = Collections.unmodifiableList(arrayList);
    }
}
