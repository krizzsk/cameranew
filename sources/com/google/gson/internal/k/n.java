package com.google.gson.internal.k;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;
/* compiled from: TypeAdapters.java */
/* loaded from: classes2.dex */
public final class n {
    public static final com.google.gson.q<String> A;
    public static final com.google.gson.q<BigDecimal> B;
    public static final com.google.gson.q<BigInteger> C;
    public static final com.google.gson.r D;
    public static final com.google.gson.q<StringBuilder> E;
    public static final com.google.gson.r F;
    public static final com.google.gson.q<StringBuffer> G;
    public static final com.google.gson.r H;
    public static final com.google.gson.q<URL> I;
    public static final com.google.gson.r J;
    public static final com.google.gson.q<URI> K;
    public static final com.google.gson.r L;
    public static final com.google.gson.q<InetAddress> M;
    public static final com.google.gson.r N;
    public static final com.google.gson.q<UUID> O;
    public static final com.google.gson.r P;
    public static final com.google.gson.q<Currency> Q;
    public static final com.google.gson.r R;
    public static final com.google.gson.r S;
    public static final com.google.gson.q<Calendar> T;
    public static final com.google.gson.r U;
    public static final com.google.gson.q<Locale> V;
    public static final com.google.gson.r W;
    public static final com.google.gson.q<com.google.gson.k> X;
    public static final com.google.gson.r Y;
    public static final com.google.gson.r Z;
    public static final com.google.gson.q<Class> a;
    public static final com.google.gson.r b;
    public static final com.google.gson.q<BitSet> c;

    /* renamed from: d  reason: collision with root package name */
    public static final com.google.gson.r f4958d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f4959e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f4960f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.google.gson.r f4961g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.google.gson.q<Number> f4962h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.google.gson.r f4963i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.google.gson.q<Number> f4964j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.google.gson.r f4965k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.google.gson.q<Number> f4966l;
    public static final com.google.gson.r m;
    public static final com.google.gson.q<AtomicInteger> n;
    public static final com.google.gson.r o;
    public static final com.google.gson.q<AtomicBoolean> p;
    public static final com.google.gson.r q;
    public static final com.google.gson.q<AtomicIntegerArray> r;
    public static final com.google.gson.r s;
    public static final com.google.gson.q<Number> t;
    public static final com.google.gson.q<Number> u;
    public static final com.google.gson.q<Number> v;
    public static final com.google.gson.q<Number> w;
    public static final com.google.gson.r x;
    public static final com.google.gson.q<Character> y;
    public static final com.google.gson.r z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class a extends com.google.gson.q<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.q
        public AtomicIntegerArray read(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.d();
            while (aVar.N()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.U()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.y();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            bVar.v();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                bVar.c0(atomicIntegerArray.get(i2));
            }
            bVar.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public class a0 implements com.google.gson.r {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ com.google.gson.q val$typeAdapter;

        a0(Class cls, Class cls2, com.google.gson.q qVar) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.val$base || rawType == this.val$sub) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$base.getName() + Marker.ANY_NON_NULL_MARKER + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class b extends com.google.gson.q<Number> {
        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return Long.valueOf(aVar.V());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public class b0 implements com.google.gson.r {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ com.google.gson.q val$typeAdapter;

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a extends com.google.gson.q<T1> {
            final /* synthetic */ Class val$requestedType;

            a(Class cls) {
                this.val$requestedType = cls;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
            @Override // com.google.gson.q
            public T1 read(com.google.gson.stream.a aVar) throws IOException {
                ?? read = b0.this.val$typeAdapter.read(aVar);
                if (read == 0 || this.val$requestedType.isInstance(read)) {
                    return read;
                }
                throw new JsonSyntaxException("Expected a " + this.val$requestedType.getName() + " but was " + read.getClass().getName());
            }

            @Override // com.google.gson.q
            public void write(com.google.gson.stream.b bVar, T1 t1) throws IOException {
                b0.this.val$typeAdapter.write(bVar, t1);
            }
        }

        b0(Class cls, com.google.gson.q qVar) {
            this.val$clazz = cls;
            this.val$typeAdapter = qVar;
        }

        @Override // com.google.gson.r
        public <T2> com.google.gson.q<T2> create(com.google.gson.e eVar, com.google.gson.t.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.val$clazz.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.val$clazz.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class c extends com.google.gson.q<Number> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Float.valueOf((float) aVar.T());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c0 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class d extends com.google.gson.q<Number> {
        d() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Double.valueOf(aVar.T());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class d0 extends com.google.gson.q<Boolean> {
        d0() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken c0 = aVar.c0();
            if (c0 == JsonToken.NULL) {
                aVar.Y();
                return null;
            } else if (c0 == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.a0()));
            } else {
                return Boolean.valueOf(aVar.S());
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.d0(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class e extends com.google.gson.q<Number> {
        e() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken c0 = aVar.c0();
            int i2 = c0.a[c0.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new LazilyParsedNumber(aVar.a0());
            }
            if (i2 == 4) {
                aVar.Y();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + c0);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class e0 extends com.google.gson.q<Boolean> {
        e0() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Boolean read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return Boolean.valueOf(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Boolean bool) throws IOException {
            bVar.f0(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class f extends com.google.gson.q<Character> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Character read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            String a0 = aVar.a0();
            if (a0.length() == 1) {
                return Character.valueOf(a0.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + a0);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Character ch) throws IOException {
            bVar.f0(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class f0 extends com.google.gson.q<Number> {
        f0() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.U());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class g extends com.google.gson.q<String> {
        g() {
        }

        @Override // com.google.gson.q
        public String read(com.google.gson.stream.a aVar) throws IOException {
            JsonToken c0 = aVar.c0();
            if (c0 == JsonToken.NULL) {
                aVar.Y();
                return null;
            } else if (c0 == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.S());
            } else {
                return aVar.a0();
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, String str) throws IOException {
            bVar.f0(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class g0 extends com.google.gson.q<Number> {
        g0() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.U());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class h extends com.google.gson.q<BigDecimal> {
        h() {
        }

        @Override // com.google.gson.q
        public BigDecimal read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return new BigDecimal(aVar.a0());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, BigDecimal bigDecimal) throws IOException {
            bVar.e0(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class h0 extends com.google.gson.q<Number> {
        h0() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Number read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return Integer.valueOf(aVar.U());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Number number) throws IOException {
            bVar.e0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class i extends com.google.gson.q<BigInteger> {
        i() {
        }

        @Override // com.google.gson.q
        public BigInteger read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                return new BigInteger(aVar.a0());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, BigInteger bigInteger) throws IOException {
            bVar.e0(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class i0 extends com.google.gson.q<AtomicInteger> {
        i0() {
        }

        @Override // com.google.gson.q
        public AtomicInteger read(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.U());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, AtomicInteger atomicInteger) throws IOException {
            bVar.c0(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class j extends com.google.gson.q<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.q
        public StringBuilder read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return new StringBuilder(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, StringBuilder sb) throws IOException {
            bVar.f0(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class j0 extends com.google.gson.q<AtomicBoolean> {
        j0() {
        }

        @Override // com.google.gson.q
        public AtomicBoolean read(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.S());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, AtomicBoolean atomicBoolean) throws IOException {
            bVar.g0(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class k extends com.google.gson.q<Class> {
        k() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public Class read(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    private static final class k0<T extends Enum<T>> extends com.google.gson.q<T> {
        private final Map<String, T> nameToConstant = new HashMap();
        private final Map<T, String> constantToName = new HashMap();

        public k0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.s.c cVar = (com.google.gson.s.c) cls.getField(name).getAnnotation(com.google.gson.s.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.nameToConstant.put(str, t);
                        }
                    }
                    this.nameToConstant.put(name, t);
                    this.constantToName.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void write(com.google.gson.stream.b bVar, Object obj) throws IOException {
            write(bVar, (com.google.gson.stream.b) ((Enum) obj));
        }

        @Override // com.google.gson.q
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return this.nameToConstant.get(aVar.a0());
        }

        public void write(com.google.gson.stream.b bVar, T t) throws IOException {
            bVar.f0(t == null ? null : this.constantToName.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class l extends com.google.gson.q<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.q
        public StringBuffer read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return new StringBuffer(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, StringBuffer stringBuffer) throws IOException {
            bVar.f0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class m extends com.google.gson.q<URL> {
        m() {
        }

        @Override // com.google.gson.q
        public URL read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            String a0 = aVar.a0();
            if ("null".equals(a0)) {
                return null;
            }
            return new URL(a0);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, URL url) throws IOException {
            bVar.f0(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.internal.k.n$n  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0190n extends com.google.gson.q<URI> {
        C0190n() {
        }

        @Override // com.google.gson.q
        public URI read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            try {
                String a0 = aVar.a0();
                if ("null".equals(a0)) {
                    return null;
                }
                return new URI(a0);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, URI uri) throws IOException {
            bVar.f0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class o extends com.google.gson.q<InetAddress> {
        o() {
        }

        @Override // com.google.gson.q
        public InetAddress read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return InetAddress.getByName(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, InetAddress inetAddress) throws IOException {
            bVar.f0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class p extends com.google.gson.q<UUID> {
        p() {
        }

        @Override // com.google.gson.q
        public UUID read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            return UUID.fromString(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, UUID uuid) throws IOException {
            bVar.f0(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class q extends com.google.gson.q<Currency> {
        q() {
        }

        @Override // com.google.gson.q
        public Currency read(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.a0());
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Currency currency) throws IOException {
            bVar.f0(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class r implements com.google.gson.r {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a extends com.google.gson.q<Timestamp> {
            final /* synthetic */ com.google.gson.q val$dateTypeAdapter;

            a(com.google.gson.q qVar) {
                this.val$dateTypeAdapter = qVar;
            }

            @Override // com.google.gson.q
            public Timestamp read(com.google.gson.stream.a aVar) throws IOException {
                Date date = (Date) this.val$dateTypeAdapter.read(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.q
            public void write(com.google.gson.stream.b bVar, Timestamp timestamp) throws IOException {
                this.val$dateTypeAdapter.write(bVar, timestamp);
            }
        }

        r() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new a(eVar.m(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class s extends com.google.gson.q<Calendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        s() {
        }

        @Override // com.google.gson.q
        public Calendar read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            aVar.t();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.c0() != JsonToken.END_OBJECT) {
                String W = aVar.W();
                int U = aVar.U();
                if (YEAR.equals(W)) {
                    i2 = U;
                } else if (MONTH.equals(W)) {
                    i3 = U;
                } else if (DAY_OF_MONTH.equals(W)) {
                    i4 = U;
                } else if (HOUR_OF_DAY.equals(W)) {
                    i5 = U;
                } else if (MINUTE.equals(W)) {
                    i6 = U;
                } else if (SECOND.equals(W)) {
                    i7 = U;
                }
            }
            aVar.z();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                bVar.S();
                return;
            }
            bVar.w();
            bVar.Q(YEAR);
            bVar.c0(calendar.get(1));
            bVar.Q(MONTH);
            bVar.c0(calendar.get(2));
            bVar.Q(DAY_OF_MONTH);
            bVar.c0(calendar.get(5));
            bVar.Q(HOUR_OF_DAY);
            bVar.c0(calendar.get(11));
            bVar.Q(MINUTE);
            bVar.c0(calendar.get(12));
            bVar.Q(SECOND);
            bVar.c0(calendar.get(13));
            bVar.z();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class t extends com.google.gson.q<Locale> {
        t() {
        }

        @Override // com.google.gson.q
        public Locale read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.c0() == JsonToken.NULL) {
                aVar.Y();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.a0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, Locale locale) throws IOException {
            bVar.f0(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class u extends com.google.gson.q<com.google.gson.k> {
        u() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.q
        public com.google.gson.k read(com.google.gson.stream.a aVar) throws IOException {
            switch (c0.a[aVar.c0().ordinal()]) {
                case 1:
                    return new com.google.gson.n(new LazilyParsedNumber(aVar.a0()));
                case 2:
                    return new com.google.gson.n(Boolean.valueOf(aVar.S()));
                case 3:
                    return new com.google.gson.n(aVar.a0());
                case 4:
                    aVar.Y();
                    return com.google.gson.l.a;
                case 5:
                    com.google.gson.h hVar = new com.google.gson.h();
                    aVar.d();
                    while (aVar.N()) {
                        hVar.i(read(aVar));
                    }
                    aVar.y();
                    return hVar;
                case 6:
                    com.google.gson.m mVar = new com.google.gson.m();
                    aVar.t();
                    while (aVar.N()) {
                        mVar.i(aVar.W(), read(aVar));
                    }
                    aVar.z();
                    return mVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, com.google.gson.k kVar) throws IOException {
            if (kVar != null && !kVar.f()) {
                if (kVar.h()) {
                    com.google.gson.n d2 = kVar.d();
                    if (d2.p()) {
                        bVar.e0(d2.l());
                        return;
                    } else if (d2.n()) {
                        bVar.g0(d2.i());
                        return;
                    } else {
                        bVar.f0(d2.m());
                        return;
                    }
                } else if (kVar.e()) {
                    bVar.v();
                    Iterator<com.google.gson.k> it = kVar.b().iterator();
                    while (it.hasNext()) {
                        write(bVar, it.next());
                    }
                    bVar.y();
                    return;
                } else if (kVar.g()) {
                    bVar.w();
                    for (Map.Entry<String, com.google.gson.k> entry : kVar.c().j()) {
                        bVar.Q(entry.getKey());
                        write(bVar, entry.getValue());
                    }
                    bVar.z();
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
                }
            }
            bVar.S();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class v extends com.google.gson.q<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.U() != 0) goto L15;
         */
        @Override // com.google.gson.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet read(com.google.gson.stream.a r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.d()
                com.google.gson.stream.JsonToken r1 = r8.c0()
                r2 = 0
                r3 = 0
            Le:
                com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = com.google.gson.internal.k.n.c0.a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.a0()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.S()
                goto L69
            L63:
                int r1 = r8.U()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                com.google.gson.stream.JsonToken r1 = r8.c0()
                goto Le
            L75:
                r8.y()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.k.n.v.read(com.google.gson.stream.a):java.util.BitSet");
        }

        @Override // com.google.gson.q
        public void write(com.google.gson.stream.b bVar, BitSet bitSet) throws IOException {
            bVar.v();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                bVar.c0(bitSet.get(i2) ? 1L : 0L);
            }
            bVar.y();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class w implements com.google.gson.r {
        w() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            Class rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = (Class<? super Object>) rawType.getSuperclass();
            }
            return new k0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    class x implements com.google.gson.r {
        final /* synthetic */ com.google.gson.t.a val$type;
        final /* synthetic */ com.google.gson.q val$typeAdapter;

        x(com.google.gson.t.a aVar, com.google.gson.q qVar) {
            this.val$type = aVar;
            this.val$typeAdapter = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.equals(this.val$type)) {
                return this.val$typeAdapter;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public class y implements com.google.gson.r {
        final /* synthetic */ Class val$type;
        final /* synthetic */ com.google.gson.q val$typeAdapter;

        y(Class cls, com.google.gson.q qVar) {
            this.val$type = cls;
            this.val$typeAdapter = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public class z implements com.google.gson.r {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ com.google.gson.q val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        z(Class cls, Class cls2, com.google.gson.q qVar) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.val$boxed.getName() + Marker.ANY_NON_NULL_MARKER + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    static {
        com.google.gson.q<Class> nullSafe = new k().nullSafe();
        a = nullSafe;
        b = b(Class.class, nullSafe);
        com.google.gson.q<BitSet> nullSafe2 = new v().nullSafe();
        c = nullSafe2;
        f4958d = b(BitSet.class, nullSafe2);
        d0 d0Var = new d0();
        f4959e = d0Var;
        f4960f = new e0();
        f4961g = c(Boolean.TYPE, Boolean.class, d0Var);
        f0 f0Var = new f0();
        f4962h = f0Var;
        f4963i = c(Byte.TYPE, Byte.class, f0Var);
        g0 g0Var = new g0();
        f4964j = g0Var;
        f4965k = c(Short.TYPE, Short.class, g0Var);
        h0 h0Var = new h0();
        f4966l = h0Var;
        m = c(Integer.TYPE, Integer.class, h0Var);
        com.google.gson.q<AtomicInteger> nullSafe3 = new i0().nullSafe();
        n = nullSafe3;
        o = b(AtomicInteger.class, nullSafe3);
        com.google.gson.q<AtomicBoolean> nullSafe4 = new j0().nullSafe();
        p = nullSafe4;
        q = b(AtomicBoolean.class, nullSafe4);
        com.google.gson.q<AtomicIntegerArray> nullSafe5 = new a().nullSafe();
        r = nullSafe5;
        s = b(AtomicIntegerArray.class, nullSafe5);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = b(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = c(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = b(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = b(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = b(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = b(URL.class, mVar);
        C0190n c0190n = new C0190n();
        K = c0190n;
        L = b(URI.class, c0190n);
        o oVar = new o();
        M = oVar;
        N = e(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = b(UUID.class, pVar);
        com.google.gson.q<Currency> nullSafe6 = new q().nullSafe();
        Q = nullSafe6;
        R = b(Currency.class, nullSafe6);
        S = new r();
        s sVar = new s();
        T = sVar;
        U = d(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = b(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = e(com.google.gson.k.class, uVar);
        Z = new w();
    }

    public static <TT> com.google.gson.r a(com.google.gson.t.a<TT> aVar, com.google.gson.q<TT> qVar) {
        return new x(aVar, qVar);
    }

    public static <TT> com.google.gson.r b(Class<TT> cls, com.google.gson.q<TT> qVar) {
        return new y(cls, qVar);
    }

    public static <TT> com.google.gson.r c(Class<TT> cls, Class<TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new z(cls, cls2, qVar);
    }

    public static <TT> com.google.gson.r d(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new a0(cls, cls2, qVar);
    }

    public static <T1> com.google.gson.r e(Class<T1> cls, com.google.gson.q<T1> qVar) {
        return new b0(cls, qVar);
    }
}
