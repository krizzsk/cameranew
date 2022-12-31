package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdth implements c.a, c.b {
    private final String packageName;
    private final HandlerThread zzegn;
    private zzduh zzhsr;
    private final String zzhss;
    private final LinkedBlockingQueue<zzcf.zza> zzhst;

    public zzdth(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhss = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzegn = handlerThread;
        handlerThread.start();
        this.zzhsr = new zzduh(context, handlerThread.getLooper(), this, this, 9200000);
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

    private static zzcf.zza zzaxt() {
        return (zzcf.zza) ((zzelb) zzcf.zza.zzap().zzau(32768L).zzbiw());
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(Bundle bundle) {
        zzduo zzaxs = zzaxs();
        if (zzaxs != null) {
            try {
                try {
                    this.zzhst.put(zzaxs.zza(new zzduk(this.packageName, this.zzhss)).zzayi());
                    zzarp();
                    this.zzegn.quit();
                } catch (Throwable unused) {
                    this.zzhst.put(zzaxt());
                    zzarp();
                    this.zzegn.quit();
                }
            } catch (InterruptedException unused2) {
                zzarp();
                this.zzegn.quit();
            } catch (Throwable th) {
                zzarp();
                this.zzegn.quit();
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhst.put(zzaxt());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
        try {
            this.zzhst.put(zzaxt());
        } catch (InterruptedException unused) {
        }
    }

    public final zzcf.zza zzef(int i2) {
        zzcf.zza zzaVar;
        try {
            zzaVar = this.zzhst.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVar = null;
        }
        return zzaVar == null ? zzaxt() : zzaVar;
    }
}
