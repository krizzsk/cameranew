package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.l;
import java.util.Objects;
/* compiled from: AutoValue_SendRequest.java */
/* loaded from: classes2.dex */
final class b extends l {
    private final m a;
    private final String b;
    private final com.google.android.datatransport.c<?> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.d<?, byte[]> f3383d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.b f3384e;

    /* compiled from: AutoValue_SendRequest.java */
    /* renamed from: com.google.android.datatransport.runtime.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0129b extends l.a {
        private m a;
        private String b;
        private com.google.android.datatransport.c<?> c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.datatransport.d<?, byte[]> f3385d;

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.datatransport.b f3386e;

        @Override // com.google.android.datatransport.runtime.l.a
        public l a() {
            String str = "";
            if (this.a == null) {
                str = " transportContext";
            }
            if (this.b == null) {
                str = str + " transportName";
            }
            if (this.c == null) {
                str = str + " event";
            }
            if (this.f3385d == null) {
                str = str + " transformer";
            }
            if (this.f3386e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.b, this.c, this.f3385d, this.f3386e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.l.a
        l.a b(com.google.android.datatransport.b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.f3386e = bVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        l.a c(com.google.android.datatransport.c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.c = cVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        l.a d(com.google.android.datatransport.d<?, byte[]> dVar) {
            Objects.requireNonNull(dVar, "Null transformer");
            this.f3385d = dVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a e(m mVar) {
            Objects.requireNonNull(mVar, "Null transportContext");
            this.a = mVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.b = str;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.l
    public com.google.android.datatransport.b b() {
        return this.f3384e;
    }

    @Override // com.google.android.datatransport.runtime.l
    com.google.android.datatransport.c<?> c() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.l
    com.google.android.datatransport.d<?, byte[]> e() {
        return this.f3383d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.a.equals(lVar.f()) && this.b.equals(lVar.g()) && this.c.equals(lVar.c()) && this.f3383d.equals(lVar.e()) && this.f3384e.equals(lVar.b());
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.l
    public m f() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.l
    public String g() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.f3383d.hashCode()) * 1000003) ^ this.f3384e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.b + ", event=" + this.c + ", transformer=" + this.f3383d + ", encoding=" + this.f3384e + "}";
    }

    private b(m mVar, String str, com.google.android.datatransport.c<?> cVar, com.google.android.datatransport.d<?, byte[]> dVar, com.google.android.datatransport.b bVar) {
        this.a = mVar;
        this.b = str;
        this.c = cVar;
        this.f3383d = dVar;
        this.f3384e = bVar;
    }
}
