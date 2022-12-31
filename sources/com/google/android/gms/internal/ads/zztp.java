package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.c;
import java.io.IOException;
import java.util.concurrent.Future;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztp implements c.a {
    final /* synthetic */ zztn zzbvu;
    private final /* synthetic */ zzth zzbwa;
    private final /* synthetic */ zzbaa zzbwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztp(zztn zztnVar, zzth zzthVar, zzbaa zzbaaVar) {
        this.zzbvu = zztnVar;
        this.zzbwa = zzthVar;
        this.zzbwb = zzbaaVar;
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        boolean z;
        final zzte zzteVar;
        obj = this.zzbvu.lock;
        synchronized (obj) {
            z = this.zzbvu.zzbvv;
            if (z) {
                return;
            }
            this.zzbvu.zzbvv = true;
            zzteVar = this.zzbvu.zzbve;
            if (zzteVar == null) {
                return;
            }
            zzdzv zzdzvVar = zzazp.zzeic;
            final zzth zzthVar = this.zzbwa;
            final zzbaa zzbaaVar = this.zzbwb;
            final zzdzw<?> zzg = zzdzvVar.zzg(new Runnable(this, zzteVar, zzthVar, zzbaaVar) { // from class: com.google.android.gms.internal.ads.zzto
                private final zztp zzbvw;
                private final zzte zzbvx;
                private final zzth zzbvy;
                private final zzbaa zzbvz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbvw = this;
                    this.zzbvx = zzteVar;
                    this.zzbvy = zzthVar;
                    this.zzbvz = zzbaaVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zztc zza;
                    zztp zztpVar = this.zzbvw;
                    zzte zzteVar2 = this.zzbvx;
                    zzth zzthVar2 = this.zzbvy;
                    zzbaa zzbaaVar2 = this.zzbvz;
                    try {
                        zzti zznd = zzteVar2.zznd();
                        if (zzteVar2.zzne()) {
                            zza = zznd.zzc(zzthVar2);
                        } else {
                            zza = zznd.zza(zzthVar2);
                        }
                        if (!zza.zzmw()) {
                            zzbaaVar2.setException(new RuntimeException("No entry contents."));
                            zztpVar.zzbvu.disconnect();
                            return;
                        }
                        zztq zztqVar = new zztq(zztpVar, zza.zzmx(), 1);
                        int read = zztqVar.read();
                        if (read != -1) {
                            zztqVar.unread(read);
                            zzbaaVar2.set(zztv.zza(zztqVar, zza.zzmz(), zza.zznc(), zza.zznb(), zza.zzna()));
                            return;
                        }
                        throw new IOException("Unable to read from cache.");
                    } catch (RemoteException | IOException e2) {
                        zzazk.zzc("Unable to obtain a cache service instance.", e2);
                        zzbaaVar2.setException(e2);
                        zztpVar.zzbvu.disconnect();
                    }
                }
            });
            final zzbaa zzbaaVar2 = this.zzbwb;
            zzbaaVar2.addListener(new Runnable(zzbaaVar2, zzg) { // from class: com.google.android.gms.internal.ads.zztr
                private final zzbaa zzbwd;
                private final Future zzbwe;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwd = zzbaaVar2;
                    this.zzbwe = zzg;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbaa zzbaaVar3 = this.zzbwd;
                    Future future = this.zzbwe;
                    if (zzbaaVar3.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzazp.zzeih);
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
    }
}
