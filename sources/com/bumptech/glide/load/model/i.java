package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class i implements d {
    private final Map<String, List<h>> b;
    private volatile Map<String, String> c;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final String b;
        private static final Map<String, List<h>> c;
        private Map<String, List<h>> a = c;

        static {
            String property = System.getProperty("http.agent");
            b = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put(HttpRequest.HEADER_USER_AGENT, Collections.singletonList(new b(property)));
            }
            hashMap.put(HttpRequest.HEADER_ACCEPT_ENCODING, Collections.singletonList(new b("identity")));
            c = Collections.unmodifiableMap(hashMap);
        }

        public i a() {
            return new i(this.a);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements h {
        private final String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.model.h
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    i(Map<String, List<h>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<h>> entry : this.b.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<h> value = entry.getValue();
            for (int i2 = 0; i2 < value.size(); i2++) {
                sb.append(value.get(i2).a());
                if (i2 != value.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.model.d
    public Map<String, String> a() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.b.equals(((i) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.b + '}';
    }
}
