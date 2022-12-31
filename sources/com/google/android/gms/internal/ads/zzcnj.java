package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcnj extends zzcnl {
    public zzcnj(Context context) {
        this.zzgor = new zzasy(context, com.google.android.gms.ads.internal.zzr.zzlf().zzzp(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzcnl, com.google.android.gms.common.internal.c.a
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgop) {
                this.zzgop = true;
                try {
                    this.zzgor.zzwi().zza(this.zzgoq, new zzcno(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdlg.setException(new zzcoc(zzdom.INTERNAL_ERROR));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcnl, com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzazk.zzdy("Cannot connect to remote service, fallback to local instance.");
        this.zzdlg.setException(new zzcoc(zzdom.INTERNAL_ERROR));
    }

    public final zzdzw<InputStream> zzi(zzatq zzatqVar) {
        synchronized (this.mLock) {
            if (this.zzgoo) {
                return this.zzdlg;
            }
            this.zzgoo = true;
            this.zzgoq = zzatqVar;
            this.zzgor.checkAvailabilityAndConnect();
            this.zzdlg.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcnm
                private final zzcnj zzgos;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgos = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgos.zzarp();
                }
            }, zzazp.zzeih);
            return this.zzdlg;
        }
    }
}
