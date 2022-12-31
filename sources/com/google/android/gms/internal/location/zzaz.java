package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.c;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public final class zzaz extends zzk {
    private final zzas zzde;

    public zzaz(Context context, Looper looper, GoogleApiClient.a aVar, GoogleApiClient.b bVar, String str) {
        this(context, looper, aVar, bVar, str, d.a(context));
    }

    public zzaz(Context context, Looper looper, GoogleApiClient.a aVar, GoogleApiClient.b bVar, String str, @Nullable d dVar) {
        super(context, looper, aVar, bVar, str, dVar);
        this.zzde = new zzas(context, this.zzcb);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final void disconnect() {
        synchronized (this.zzde) {
            if (isConnected()) {
                try {
                    this.zzde.removeAllListeners();
                    this.zzde.zzb();
                } catch (Exception e2) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e2);
                }
            }
            super.disconnect();
        }
    }

    public final Location getLastLocation() throws RemoteException {
        return this.zzde.getLastLocation();
    }

    public final LocationAvailability zza() throws RemoteException {
        return this.zzde.zza();
    }

    public final void zza(long j2, PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        q.j(pendingIntent);
        q.b(j2 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzao) getService()).zza(j2, true, pendingIntent);
    }

    public final void zza(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.d<Status> dVar) throws RemoteException {
        checkConnected();
        q.k(dVar, "ResultHolder not provided.");
        ((zzao) getService()).zza(pendingIntent, new n(dVar));
    }

    public final void zza(PendingIntent pendingIntent, zzaj zzajVar) throws RemoteException {
        this.zzde.zza(pendingIntent, zzajVar);
    }

    public final void zza(Location location) throws RemoteException {
        this.zzde.zza(location);
    }

    public final void zza(j.a<com.google.android.gms.location.d> aVar, zzaj zzajVar) throws RemoteException {
        this.zzde.zza(aVar, zzajVar);
    }

    public final void zza(zzaj zzajVar) throws RemoteException {
        this.zzde.zza(zzajVar);
    }

    public final void zza(zzbd zzbdVar, j<c> jVar, zzaj zzajVar) throws RemoteException {
        synchronized (this.zzde) {
            this.zzde.zza(zzbdVar, jVar, zzajVar);
        }
    }

    public final void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.d<Status> dVar) throws RemoteException {
        checkConnected();
        q.k(dVar, "ResultHolder not provided.");
        ((zzao) getService()).zza(activityTransitionRequest, pendingIntent, new n(dVar));
    }

    public final void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.d<Status> dVar) throws RemoteException {
        checkConnected();
        q.k(geofencingRequest, "geofencingRequest can't be null.");
        q.k(pendingIntent, "PendingIntent must be specified.");
        q.k(dVar, "ResultHolder not provided.");
        ((zzao) getService()).zza(geofencingRequest, pendingIntent, new zzba(dVar));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzaj zzajVar) throws RemoteException {
        this.zzde.zza(locationRequest, pendingIntent, zzajVar);
    }

    public final void zza(LocationRequest locationRequest, j<com.google.android.gms.location.d> jVar, zzaj zzajVar) throws RemoteException {
        synchronized (this.zzde) {
            this.zzde.zza(locationRequest, jVar, zzajVar);
        }
    }

    public final void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.internal.d<LocationSettingsResult> dVar, @Nullable String str) throws RemoteException {
        checkConnected();
        q.b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        q.b(dVar != null, "listener can't be null.");
        ((zzao) getService()).zza(locationSettingsRequest, new zzbc(dVar), str);
    }

    public final void zza(com.google.android.gms.location.zzal zzalVar, com.google.android.gms.common.api.internal.d<Status> dVar) throws RemoteException {
        checkConnected();
        q.k(zzalVar, "removeGeofencingRequest can't be null.");
        q.k(dVar, "ResultHolder not provided.");
        ((zzao) getService()).zza(zzalVar, new zzbb(dVar));
    }

    public final void zza(boolean z) throws RemoteException {
        this.zzde.zza(z);
    }

    public final void zzb(PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        q.j(pendingIntent);
        ((zzao) getService()).zzb(pendingIntent);
    }

    public final void zzb(j.a<c> aVar, zzaj zzajVar) throws RemoteException {
        this.zzde.zzb(aVar, zzajVar);
    }
}
