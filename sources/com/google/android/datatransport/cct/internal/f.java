package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.k;
import java.util.Arrays;
/* compiled from: AutoValue_LogEvent.java */
/* loaded from: classes.dex */
final class f extends k {
    private final long a;
    private final Integer b;
    private final long c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f3359d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3360e;

    /* renamed from: f  reason: collision with root package name */
    private final long f3361f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f3362g;

    /* compiled from: AutoValue_LogEvent.java */
    /* loaded from: classes.dex */
    static final class b extends k.a {
        private Long a;
        private Integer b;
        private Long c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f3363d;

        /* renamed from: e  reason: collision with root package name */
        private String f3364e;

        /* renamed from: f  reason: collision with root package name */
        private Long f3365f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f3366g;

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k a() {
            String str = "";
            if (this.a == null) {
                str = " eventTimeMs";
            }
            if (this.c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f3365f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.a.longValue(), this.b, this.c.longValue(), this.f3363d, this.f3364e, this.f3365f.longValue(), this.f3366g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k.a b(@Nullable Integer num) {
            this.b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k.a c(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k.a d(long j2) {
            this.c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k.a e(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.f3366g = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        k.a f(@Nullable byte[] bArr) {
            this.f3363d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        k.a g(@Nullable String str) {
            this.f3364e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.k.a
        public k.a h(long j2) {
            this.f3365f = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.k
    @Nullable
    public Integer b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    public long d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    @Nullable
    public NetworkConnectionInfo e() {
        return this.f3362g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.a == kVar.c() && ((num = this.b) != null ? num.equals(kVar.b()) : kVar.b() == null) && this.c == kVar.d()) {
                if (Arrays.equals(this.f3359d, kVar instanceof f ? ((f) kVar).f3359d : kVar.f()) && ((str = this.f3360e) != null ? str.equals(kVar.g()) : kVar.g() == null) && this.f3361f == kVar.h()) {
                    NetworkConnectionInfo networkConnectionInfo = this.f3362g;
                    if (networkConnectionInfo == null) {
                        if (kVar.e() == null) {
                            return true;
                        }
                    } else if (networkConnectionInfo.equals(kVar.e())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    @Nullable
    public byte[] f() {
        return this.f3359d;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    @Nullable
    public String g() {
        return this.f3360e;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    public long h() {
        return this.f3361f;
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int hashCode = num == null ? 0 : num.hashCode();
        long j3 = this.c;
        int hashCode2 = (((((i2 ^ hashCode) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3359d)) * 1000003;
        String str = this.f3360e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j4 = this.f3361f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f3362g;
        return i3 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.f3359d) + ", sourceExtensionJsonProto3=" + this.f3360e + ", timezoneOffsetSeconds=" + this.f3361f + ", networkConnectionInfo=" + this.f3362g + "}";
    }

    private f(long j2, @Nullable Integer num, long j3, @Nullable byte[] bArr, @Nullable String str, long j4, @Nullable NetworkConnectionInfo networkConnectionInfo) {
        this.a = j2;
        this.b = num;
        this.c = j3;
        this.f3359d = bArr;
        this.f3360e = str;
        this.f3361f = j4;
        this.f3362g = networkConnectionInfo;
    }
}
