package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajb implements zzu {
    private final Context context;
    private volatile zzaiq zzdir;

    public zzajb(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdir == null) {
            return;
        }
        this.zzdir.disconnect();
        Binder.flushPendingCommands();
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final zzz zza(zzab<?> zzabVar) throws zzap {
        zzait zzh = zzait.zzh(zzabVar);
        long a = com.google.android.gms.ads.internal.zzr.zzky().a();
        try {
            zzbaa zzbaaVar = new zzbaa();
            this.zzdir = new zzaiq(this.context, com.google.android.gms.ads.internal.zzr.zzlf().zzzp(), new zzajf(this, zzbaaVar), new zzaje(this, zzbaaVar));
            this.zzdir.checkAvailabilityAndConnect();
            zzaja zzajaVar = new zzaja(this, zzh);
            zzdzv zzdzvVar = zzazp.zzeic;
            zzdzw zza = zzdzk.zza(zzdzk.zzb(zzbaaVar, zzajaVar, zzdzvVar), ((Integer) zzwr.zzqr().zzd(zzabp.zzcuo)).intValue(), TimeUnit.MILLISECONDS, zzazp.zzeif);
            zza.addListener(new zzajc(this), zzdzvVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long a2 = com.google.android.gms.ads.internal.zzr.zzky().a() - a;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(a2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
            zzaiv zzaivVar = (zzaiv) new zzatp(parcelFileDescriptor).zza(zzaiv.CREATOR);
            if (zzaivVar == null) {
                return null;
            }
            if (!zzaivVar.zzdip) {
                if (zzaivVar.zzdin.length != zzaivVar.zzdio.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                int i2 = 0;
                while (true) {
                    String[] strArr = zzaivVar.zzdin;
                    if (i2 < strArr.length) {
                        hashMap.put(strArr[i2], zzaivVar.zzdio[i2]);
                        i2++;
                    } else {
                        return new zzz(zzaivVar.statusCode, zzaivVar.data, hashMap, zzaivVar.zzak, zzaivVar.zzal);
                    }
                }
            } else {
                throw new zzap(zzaivVar.zzchg);
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(com.google.android.gms.ads.internal.zzr.zzky().a() - a);
            sb2.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb2.toString());
            return null;
        } catch (Throwable th) {
            long a3 = com.google.android.gms.ads.internal.zzr.zzky().a() - a;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(a3);
            sb3.append("ms");
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb3.toString());
            throw th;
        }
    }
}
