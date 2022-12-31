package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.d;
/* loaded from: classes2.dex */
public final class zzq {
    public final e<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.b(new zzv(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        com.google.android.gms.location.e.a(googleApiClient);
        throw null;
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        com.google.android.gms.location.e.a(googleApiClient);
        throw null;
    }

    public final e<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzaa(this, googleApiClient, pendingIntent));
    }

    public final e<Status> removeLocationUpdates(GoogleApiClient googleApiClient, c cVar) {
        return googleApiClient.b(new zzs(this, googleApiClient, cVar));
    }

    public final e<Status> removeLocationUpdates(GoogleApiClient googleApiClient, d dVar) {
        return googleApiClient.b(new zzz(this, googleApiClient, dVar));
    }

    public final e<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new zzy(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final e<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, c cVar, Looper looper) {
        return googleApiClient.b(new zzx(this, googleApiClient, locationRequest, cVar, looper));
    }

    public final e<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, d dVar) {
        q.k(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.b(new zzr(this, googleApiClient, locationRequest, dVar));
    }

    public final e<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, d dVar, Looper looper) {
        return googleApiClient.b(new zzw(this, googleApiClient, locationRequest, dVar, looper));
    }

    public final e<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.b(new zzu(this, googleApiClient, location));
    }

    public final e<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.b(new zzt(this, googleApiClient, z));
    }
}
