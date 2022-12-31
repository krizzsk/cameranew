package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class zzas {
    private final zzbj<zzao> zzcb;
    private final Context zzcu;
    private ContentProviderClient zzcv = null;
    private boolean zzcw = false;
    private final Map<j.a<d>, zzax> zzcx = new HashMap();
    private final Map<j.a<Object>, zzaw> zzcy = new HashMap();
    private final Map<j.a<c>, zzat> zzcz = new HashMap();

    public zzas(Context context, zzbj<zzao> zzbjVar) {
        this.zzcu = context;
        this.zzcb = zzbjVar;
    }

    private final zzax zza(j<d> jVar) {
        zzax zzaxVar;
        synchronized (this.zzcx) {
            zzaxVar = this.zzcx.get(jVar.b());
            if (zzaxVar == null) {
                zzaxVar = new zzax(jVar);
            }
            this.zzcx.put(jVar.b(), zzaxVar);
        }
        return zzaxVar;
    }

    private final zzat zzb(j<c> jVar) {
        zzat zzatVar;
        synchronized (this.zzcz) {
            zzatVar = this.zzcz.get(jVar.b());
            if (zzatVar == null) {
                zzatVar = new zzat(jVar);
            }
            this.zzcz.put(jVar.b(), zzatVar);
        }
        return zzatVar;
    }

    public final Location getLastLocation() throws RemoteException {
        this.zzcb.checkConnected();
        return this.zzcb.getService().zza(this.zzcu.getPackageName());
    }

    public final void removeAllListeners() throws RemoteException {
        synchronized (this.zzcx) {
            for (zzax zzaxVar : this.zzcx.values()) {
                if (zzaxVar != null) {
                    this.zzcb.getService().zza(zzbf.zza(zzaxVar, (zzaj) null));
                }
            }
            this.zzcx.clear();
        }
        synchronized (this.zzcz) {
            for (zzat zzatVar : this.zzcz.values()) {
                if (zzatVar != null) {
                    this.zzcb.getService().zza(zzbf.zza(zzatVar, (zzaj) null));
                }
            }
            this.zzcz.clear();
        }
        synchronized (this.zzcy) {
            for (zzaw zzawVar : this.zzcy.values()) {
                if (zzawVar != null) {
                    this.zzcb.getService().zza(new zzo(2, null, zzawVar.asBinder(), null));
                }
            }
            this.zzcy.clear();
        }
    }

    public final LocationAvailability zza() throws RemoteException {
        this.zzcb.checkConnected();
        return this.zzcb.getService().zzb(this.zzcu.getPackageName());
    }

    public final void zza(PendingIntent pendingIntent, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(new zzbf(2, null, null, pendingIntent, null, zzajVar != null ? zzajVar.asBinder() : null));
    }

    public final void zza(Location location) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(location);
    }

    public final void zza(j.a<d> aVar, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        q.k(aVar, "Invalid null listener key");
        synchronized (this.zzcx) {
            zzax remove = this.zzcx.remove(aVar);
            if (remove != null) {
                remove.release();
                this.zzcb.getService().zza(zzbf.zza(remove, zzajVar));
            }
        }
    }

    public final void zza(zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(zzajVar);
    }

    public final void zza(zzbd zzbdVar, j<c> jVar, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(new zzbf(1, zzbdVar, null, null, zzb(jVar).asBinder(), zzajVar != null ? zzajVar.asBinder() : null));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(new zzbf(1, zzbd.zza(locationRequest), null, pendingIntent, null, zzajVar != null ? zzajVar.asBinder() : null));
    }

    public final void zza(LocationRequest locationRequest, j<d> jVar, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(new zzbf(1, zzbd.zza(locationRequest), zza(jVar).asBinder(), null, null, zzajVar != null ? zzajVar.asBinder() : null));
    }

    public final void zza(boolean z) throws RemoteException {
        this.zzcb.checkConnected();
        this.zzcb.getService().zza(z);
        this.zzcw = z;
    }

    public final void zzb() throws RemoteException {
        if (this.zzcw) {
            zza(false);
        }
    }

    public final void zzb(j.a<c> aVar, zzaj zzajVar) throws RemoteException {
        this.zzcb.checkConnected();
        q.k(aVar, "Invalid null listener key");
        synchronized (this.zzcz) {
            zzat remove = this.zzcz.remove(aVar);
            if (remove != null) {
                remove.release();
                this.zzcb.getService().zza(zzbf.zza(remove, zzajVar));
            }
        }
    }
}
