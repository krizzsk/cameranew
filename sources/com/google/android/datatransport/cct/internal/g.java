package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.l;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
/* compiled from: AutoValue_LogRequest.java */
/* loaded from: classes.dex */
final class g extends l {
    private final long a;
    private final long b;
    private final ClientInfo c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f3367d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3368e;

    /* renamed from: f  reason: collision with root package name */
    private final List<k> f3369f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f3370g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_LogRequest.java */
    /* loaded from: classes.dex */
    public static final class b extends l.a {
        private Long a;
        private Long b;
        private ClientInfo c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3371d;

        /* renamed from: e  reason: collision with root package name */
        private String f3372e;

        /* renamed from: f  reason: collision with root package name */
        private List<k> f3373f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f3374g;

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l a() {
            String str = "";
            if (this.a == null) {
                str = " requestTimeMs";
            }
            if (this.b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.a.longValue(), this.b.longValue(), this.c, this.f3371d, this.f3372e, this.f3373f, this.f3374g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l.a b(@Nullable ClientInfo clientInfo) {
            this.c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l.a c(@Nullable List<k> list) {
            this.f3373f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        l.a d(@Nullable Integer num) {
            this.f3371d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        l.a e(@Nullable String str) {
            this.f3372e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l.a f(@Nullable QosTier qosTier) {
            this.f3374g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l.a g(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.l.a
        public l.a h(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.l
    @Nullable
    public ClientInfo b() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<k> c() {
        return this.f3369f;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    @Nullable
    public Integer d() {
        return this.f3367d;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    @Nullable
    public String e() {
        return this.f3368e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<k> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a == lVar.g() && this.b == lVar.h() && ((clientInfo = this.c) != null ? clientInfo.equals(lVar.b()) : lVar.b() == null) && ((num = this.f3367d) != null ? num.equals(lVar.d()) : lVar.d() == null) && ((str = this.f3368e) != null ? str.equals(lVar.e()) : lVar.e() == null) && ((list = this.f3369f) != null ? list.equals(lVar.c()) : lVar.c() == null)) {
                QosTier qosTier = this.f3370g;
                if (qosTier == null) {
                    if (lVar.f() == null) {
                        return true;
                    }
                } else if (qosTier.equals(lVar.f())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    @Nullable
    public QosTier f() {
        return this.f3370g;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    public long g() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.internal.l
    public long h() {
        return this.b;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        ClientInfo clientInfo = this.c;
        int hashCode = (i2 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f3367d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f3368e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<k> list = this.f3369f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f3370g;
        return hashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.f3367d + ", logSourceName=" + this.f3368e + ", logEvents=" + this.f3369f + ", qosTier=" + this.f3370g + "}";
    }

    private g(long j2, long j3, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<k> list, @Nullable QosTier qosTier) {
        this.a = j2;
        this.b = j3;
        this.c = clientInfo;
        this.f3367d = num;
        this.f3368e = str;
        this.f3369f = list;
        this.f3370g = qosTier;
    }
}
