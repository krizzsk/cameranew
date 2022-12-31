package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdtj implements c.a, c.b {
    private final long startTime;
    private final HandlerThread zzegn;
    private zzduh zzhsr;
    private final LinkedBlockingQueue<zzduw> zzhst;
    private final String zzhsu;
    private final String zzhsv;
    private final int zzhsw = 1;
    private final zzdsy zzvs;
    private final zzgp zzvu;

    public zzdtj(Context context, int i2, zzgp zzgpVar, String str, String str2, String str3, zzdsy zzdsyVar) {
        this.zzhsu = str;
        this.zzvu = zzgpVar;
        this.zzhsv = str2;
        this.zzvs = zzdsyVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzegn = handlerThread;
        handlerThread.start();
        this.startTime = System.currentTimeMillis();
        this.zzhsr = new zzduh(context, handlerThread.getLooper(), this, this, 19621000);
        this.zzhst = new LinkedBlockingQueue<>();
        this.zzhsr.checkAvailabilityAndConnect();
    }

    private final void zzarp() {
        zzduh zzduhVar = this.zzhsr;
        if (zzduhVar != null) {
            if (zzduhVar.isConnected() || this.zzhsr.isConnecting()) {
                this.zzhsr.disconnect();
            }
        }
    }

    private final zzduo zzaxs() {
        try {
            return this.zzhsr.zzayh();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    private static zzduw zzaxu() {
        return new zzduw(null, 1);
    }

    private final void zzb(int i2, long j2, Exception exc) {
        zzdsy zzdsyVar = this.zzvs;
        if (zzdsyVar != null) {
            zzdsyVar.zza(i2, System.currentTimeMillis() - j2, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(Bundle bundle) {
        zzduo zzaxs = zzaxs();
        if (zzaxs != null) {
            try {
                zzduw zza = zzaxs.zza(new zzduu(this.zzhsw, this.zzvu, this.zzhsu, this.zzhsv));
                zzb(5011, this.startTime, null);
                this.zzhst.put(zza);
            } catch (Throwable th) {
                try {
                    zzb(2010, this.startTime, new Exception(th));
                } finally {
                    zzarp();
                    this.zzegn.quit();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, null);
            this.zzhst.put(zzaxu());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
        try {
            zzb(4011, this.startTime, null);
            this.zzhst.put(zzaxu());
        } catch (InterruptedException unused) {
        }
    }

    public final zzduw zzeg(int i2) {
        zzduw zzduwVar;
        try {
            zzduwVar = this.zzhst.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zzb(AdError.INTERSTITIAL_AD_TIMEOUT, this.startTime, e2);
            zzduwVar = null;
        }
        zzb(3004, this.startTime, null);
        if (zzduwVar != null) {
            if (zzduwVar.status == 7) {
                zzdsy.zza(zzbw.zza.zzc.DISABLED);
            } else {
                zzdsy.zza(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzduwVar == null ? zzaxu() : zzduwVar;
    }
}
