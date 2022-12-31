package com.tapjoy.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes3.dex */
public final class gi {
    public static final gi a = new gi(0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    public final long b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7580d;

    /* renamed from: e  reason: collision with root package name */
    public long f7581e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7582f;

    public gi(long j2, long j3, long j4, double d2) {
        this.f7582f = j2;
        this.b = j3;
        this.c = j4;
        this.f7580d = d2;
        this.f7581e = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && gi.class == obj.getClass()) {
            gi giVar = (gi) obj;
            if (this.f7582f == giVar.f7582f && this.b == giVar.b && this.c == giVar.c && this.f7580d == giVar.f7580d && this.f7581e == giVar.f7581e) {
                return true;
            }
        }
        return false;
    }
}
