package com.google.android.gms.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbk;
import com.google.android.gms.internal.location.zzq;
/* loaded from: classes2.dex */
public class e {
    private static final a.g<zzaz> a;
    private static final a.AbstractC0134a<zzaz, Object> b;
    public static final com.google.android.gms.common.api.a<Object> c;

    /* loaded from: classes2.dex */
    public static abstract class a<R extends com.google.android.gms.common.api.g> extends com.google.android.gms.common.api.internal.c<R, zzaz> {
        public a(GoogleApiClient googleApiClient) {
            super(e.c, googleApiClient);
        }
    }

    static {
        a.g<zzaz> gVar = new a.g<>();
        a = gVar;
        k kVar = new k();
        b = kVar;
        c = new com.google.android.gms.common.api.a<>("LocationServices.API", kVar, gVar);
        new zzq();
        new zzaf();
        new zzbk();
    }

    public static zzaz a(GoogleApiClient googleApiClient) {
        com.google.android.gms.common.internal.q.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        googleApiClient.c(a);
        throw null;
    }
}
