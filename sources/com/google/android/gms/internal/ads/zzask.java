package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzask {
    @GuardedBy("InternalQueryInfoGenerator.class")
    private static zzaxy zzdtn;
    private final Context context;
    @Nullable
    private final zzzk zzacw;
    private final AdFormat zzdtm;

    public zzask(Context context, AdFormat adFormat, @Nullable zzzk zzzkVar) {
        this.context = context;
        this.zzdtm = adFormat;
        this.zzacw = zzzkVar;
    }

    @Nullable
    public static zzaxy zzp(Context context) {
        zzaxy zzaxyVar;
        synchronized (zzask.class) {
            if (zzdtn == null) {
                zzdtn = zzwr.zzqo().zza(context, new zzanf());
            }
            zzaxyVar = zzdtn;
        }
        return zzaxyVar;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzvl zza;
        zzaxy zzp = zzp(this.context);
        if (zzp == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        b z0 = d.z0(this.context);
        zzzk zzzkVar = this.zzacw;
        if (zzzkVar == null) {
            zza = new zzvo().zzqd();
        } else {
            zza = zzvq.zza(this.context, zzzkVar);
        }
        try {
            zzp.zza(z0, new zzaye(null, this.zzdtm.name(), null, zza), new zzasn(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
