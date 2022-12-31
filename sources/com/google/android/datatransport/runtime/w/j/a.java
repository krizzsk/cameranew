package com.google.android.datatransport.runtime.w.j;

import com.google.android.datatransport.runtime.w.j.d;
/* compiled from: AutoValue_EventStoreConfig.java */
/* loaded from: classes2.dex */
final class a extends d {
    private final long b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3423d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3424e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3425f;

    /* compiled from: AutoValue_EventStoreConfig.java */
    /* loaded from: classes2.dex */
    static final class b extends d.a {
        private Long a;
        private Integer b;
        private Integer c;

        /* renamed from: d  reason: collision with root package name */
        private Long f3426d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f3427e;

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.b == null) {
                str = str + " loadBatchSize";
            }
            if (this.c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f3426d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f3427e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.f3426d.longValue(), this.f3427e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d.a b(int i2) {
            this.c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d.a c(long j2) {
            this.f3426d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d.a d(int i2) {
            this.b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d.a e(int i2) {
            this.f3427e = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.w.j.d.a
        d.a f(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.w.j.d
    int b() {
        return this.f3423d;
    }

    @Override // com.google.android.datatransport.runtime.w.j.d
    long c() {
        return this.f3424e;
    }

    @Override // com.google.android.datatransport.runtime.w.j.d
    int d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.w.j.d
    int e() {
        return this.f3425f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.b == dVar.f() && this.c == dVar.d() && this.f3423d == dVar.b() && this.f3424e == dVar.c() && this.f3425f == dVar.e();
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.w.j.d
    long f() {
        return this.b;
    }

    public int hashCode() {
        long j2 = this.b;
        long j3 = this.f3424e;
        return this.f3425f ^ ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.f3423d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.f3423d + ", eventCleanUpAge=" + this.f3424e + ", maxBlobByteSizePerRow=" + this.f3425f + "}";
    }

    private a(long j2, int i2, int i3, long j3, int i4) {
        this.b = j2;
        this.c = i2;
        this.f3423d = i3;
        this.f3424e = j3;
        this.f3425f = i4;
    }
}
