package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.h;
import java.util.Map;
import java.util.Objects;
/* compiled from: AutoValue_EventInternal.java */
/* loaded from: classes2.dex */
final class a extends h {
    private final String a;
    private final Integer b;
    private final g c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3377d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3378e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f3379f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_EventInternal.java */
    /* loaded from: classes2.dex */
    public static final class b extends h.a {
        private String a;
        private Integer b;
        private g c;

        /* renamed from: d  reason: collision with root package name */
        private Long f3380d;

        /* renamed from: e  reason: collision with root package name */
        private Long f3381e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f3382f;

        @Override // com.google.android.datatransport.runtime.h.a
        public h d() {
            String str = "";
            if (this.a == null) {
                str = " transportName";
            }
            if (this.c == null) {
                str = str + " encodedPayload";
            }
            if (this.f3380d == null) {
                str = str + " eventMillis";
            }
            if (this.f3381e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f3382f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.b, this.c, this.f3380d.longValue(), this.f3381e.longValue(), this.f3382f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.h.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f3382f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.datatransport.runtime.h.a
        public h.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f3382f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.h.a
        public h.a g(Integer num) {
            this.b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.h.a
        public h.a h(g gVar) {
            Objects.requireNonNull(gVar, "Null encodedPayload");
            this.c = gVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.h.a
        public h.a i(long j2) {
            this.f3380d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.h.a
        public h.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.h.a
        public h.a k(long j2) {
            this.f3381e = Long.valueOf(j2);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.datatransport.runtime.h
    public Map<String, String> c() {
        return this.f3379f;
    }

    @Override // com.google.android.datatransport.runtime.h
    @Nullable
    public Integer d() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.h
    public g e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.a.equals(hVar.j()) && ((num = this.b) != null ? num.equals(hVar.d()) : hVar.d() == null) && this.c.equals(hVar.e()) && this.f3377d == hVar.f() && this.f3378e == hVar.k() && this.f3379f.equals(hVar.c());
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.h
    public long f() {
        return this.f3377d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f3377d;
        long j3 = this.f3378e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f3379f.hashCode();
    }

    @Override // com.google.android.datatransport.runtime.h
    public String j() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.h
    public long k() {
        return this.f3378e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.f3377d + ", uptimeMillis=" + this.f3378e + ", autoMetadata=" + this.f3379f + "}";
    }

    private a(String str, @Nullable Integer num, g gVar, long j2, long j3, Map<String, String> map) {
        this.a = str;
        this.b = num;
        this.c = gVar;
        this.f3377d = j2;
        this.f3378e = j3;
        this.f3379f = map;
    }
}
