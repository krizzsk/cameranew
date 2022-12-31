package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class bn implements bk, bp {
    private HashMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bn$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bs.values().length];
            a = iArr;
            try {
                iArr[bs.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bs.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bs.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[bs.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[bs.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[bs.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static bn a(InputStream inputStream) {
        return a.a().a(inputStream);
    }

    public static bn b(String str) {
        return a.a().a(str);
    }

    private boolean t() {
        if (k() == bs.NULL) {
            o();
            return true;
        }
        return false;
    }

    private Object u() {
        bs k2 = k();
        switch (AnonymousClass1.a[k2.ordinal()]) {
            case 1:
                return c();
            case 2:
                return d();
            case 3:
                o();
                return null;
            case 4:
                return Boolean.valueOf(n());
            case 5:
                return new ci(m());
            case 6:
                return m();
            default:
                throw new IllegalStateException("Expected a value but was " + k2);
        }
    }

    public final String c(String str) {
        return t() ? str : m();
    }

    public final Map d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(linkedHashMap);
        return linkedHashMap;
    }

    public final URL e() {
        URI uri = (URI) a("BASE_URI");
        if (uri != null) {
            return uri.resolve(d(m())).toURL();
        }
        return new URL(m());
    }

    /* loaded from: classes3.dex */
    public static abstract class a {
        private static a a;

        public static a a() {
            a aVar = a;
            if (aVar == null) {
                a aVar2 = bo.a;
                a = aVar2;
                return aVar2;
            }
            return aVar;
        }

        public final bn a(InputStream inputStream) {
            return a(new InputStreamReader(inputStream, jm.c));
        }

        public bn a(Reader reader) {
            return a(jy.a(reader));
        }

        public bn a(String str) {
            return a(new ByteArrayInputStream(str.getBytes(jm.c.name())));
        }
    }

    @Override // com.tapjoy.internal.bk
    public final Object a(String str) {
        HashMap hashMap = this.a;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public final String b() {
        if (t()) {
            return null;
        }
        return m();
    }

    private static URI d(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e2) {
            throw new bv(e2);
        }
    }

    @Override // com.tapjoy.internal.bk
    public final void a(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj);
    }

    public final List c() {
        LinkedList linkedList = new LinkedList();
        a(linkedList);
        return linkedList;
    }

    public final boolean a() {
        return k() == bs.BEGIN_OBJECT;
    }

    private void a(List list) {
        f();
        while (j()) {
            list.add(u());
        }
        g();
    }

    public final void a(Map map) {
        h();
        while (j()) {
            map.put(l(), u());
        }
        i();
    }

    @Nullable
    public final Object a(bi biVar) {
        if (t()) {
            return null;
        }
        return biVar.a(this);
    }

    public final void a(List list, bi biVar) {
        f();
        while (j()) {
            list.add(biVar.a(this));
        }
        g();
    }
}
