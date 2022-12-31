package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.location.zzaz;
/* loaded from: classes2.dex */
final class k extends a.AbstractC0134a<zzaz, Object> {
    @Override // com.google.android.gms.common.api.a.AbstractC0134a
    public final /* synthetic */ zzaz a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, Object obj, GoogleApiClient.a aVar, GoogleApiClient.b bVar) {
        return new zzaz(context, looper, aVar, bVar, "locationServices", dVar);
    }
}
