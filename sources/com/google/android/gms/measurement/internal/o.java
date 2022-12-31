package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class o {
    final String a;
    final String b;
    final long c;

    /* renamed from: d  reason: collision with root package name */
    final long f3889d;

    /* renamed from: e  reason: collision with root package name */
    final long f3890e;

    /* renamed from: f  reason: collision with root package name */
    final long f3891f;

    /* renamed from: g  reason: collision with root package name */
    final long f3892g;

    /* renamed from: h  reason: collision with root package name */
    final Long f3893h;

    /* renamed from: i  reason: collision with root package name */
    final Long f3894i;

    /* renamed from: j  reason: collision with root package name */
    final Long f3895j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f3896k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l2, Long l3, Long l4, Boolean bool) {
        com.google.android.gms.common.internal.q.f(str);
        com.google.android.gms.common.internal.q.f(str2);
        com.google.android.gms.common.internal.q.a(j2 >= 0);
        com.google.android.gms.common.internal.q.a(j3 >= 0);
        com.google.android.gms.common.internal.q.a(j4 >= 0);
        com.google.android.gms.common.internal.q.a(j6 >= 0);
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.f3889d = j3;
        this.f3890e = j4;
        this.f3891f = j5;
        this.f3892g = j6;
        this.f3893h = l2;
        this.f3894i = l3;
        this.f3895j = l4;
        this.f3896k = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a(long j2) {
        return new o(this.a, this.b, this.c, this.f3889d, this.f3890e, j2, this.f3892g, this.f3893h, this.f3894i, this.f3895j, this.f3896k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o b(long j2, long j3) {
        return new o(this.a, this.b, this.c, this.f3889d, this.f3890e, this.f3891f, j2, Long.valueOf(j3), this.f3894i, this.f3895j, this.f3896k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o c(Long l2, Long l3, Boolean bool) {
        return new o(this.a, this.b, this.c, this.f3889d, this.f3890e, this.f3891f, this.f3892g, this.f3893h, l2, l3, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
