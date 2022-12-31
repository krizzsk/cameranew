package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.ActivityTransitionRequest;
/* loaded from: classes2.dex */
public final class zze {
    public final e<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzg(this, googleApiClient, pendingIntent));
    }

    public final e<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j2, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzf(this, googleApiClient, j2, pendingIntent));
    }

    public final e<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzi(this, googleApiClient, pendingIntent));
    }

    public final e<Status> zza(GoogleApiClient googleApiClient, ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzh(this, googleApiClient, activityTransitionRequest, pendingIntent));
    }
}
