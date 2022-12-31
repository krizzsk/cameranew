package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.b;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzaf {
    private final e<Status> zza(GoogleApiClient googleApiClient, com.google.android.gms.location.zzal zzalVar) {
        return googleApiClient.b(new zzah(this, googleApiClient, zzalVar));
    }

    public final e<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzag(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public final e<Status> addGeofences(GoogleApiClient googleApiClient, List<b> list, PendingIntent pendingIntent) {
        GeofencingRequest.a aVar = new GeofencingRequest.a();
        aVar.b(list);
        aVar.d(5);
        return addGeofences(googleApiClient, aVar.c(), pendingIntent);
    }

    public final e<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, com.google.android.gms.location.zzal.h(pendingIntent));
    }

    public final e<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return zza(googleApiClient, com.google.android.gms.location.zzal.j(list));
    }
}
