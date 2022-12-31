package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.measurement.api.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamz {
    private static zzamz zzdlp;
    private AtomicBoolean zzdlq = new AtomicBoolean(false);

    @VisibleForTesting
    zzamz() {
    }

    public static zzamz zzut() {
        if (zzdlp == null) {
            zzdlp = new zzamz();
        }
        return zzdlp;
    }

    @Nullable
    public final Thread zzc(final Context context, final String str) {
        if (this.zzdlq.compareAndSet(false, true)) {
            Thread thread = new Thread(new Runnable(this, context, str) { // from class: com.google.android.gms.internal.ads.zzamy
                private final Context zzcle;
                private final zzamz zzdln;
                private final String zzdlo;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdln = this;
                    this.zzcle = context;
                    this.zzdlo = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = this.zzcle;
                    String str2 = this.zzdlo;
                    zzabp.initialize(context2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("measurementEnabled", ((Boolean) zzwr.zzqr().zzd(zzabp.zzcok)).booleanValue());
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcor)).booleanValue()) {
                        bundle.putString("ad_storage", "denied");
                        bundle.putString("analytics_storage", "denied");
                    }
                    try {
                        ((zzbfv) zzazj.zza(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzanb.zzbyi)).zza(d.z0(context2), new zzamw(a.k(context2, "FA-Ads", "am", str2, bundle)));
                    } catch (RemoteException | zzazl | NullPointerException e2) {
                        zzazk.zze("#007 Could not call remote method.", e2);
                    }
                }
            });
            thread.start();
            return thread;
        }
        return null;
    }
}
