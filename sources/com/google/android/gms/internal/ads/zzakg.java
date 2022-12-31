package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzakg {
    private final Context context;
    private final zzxi zzacs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzakg(Context context, String str) {
        this(context, zzwr.zzqo().zzb(context, str, new zzanf()));
        q.k(context, "context cannot be null");
    }

    public final zzakg zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacs.zza(new zzake(instreamAdLoadCallback));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    public final zzakh zzui() {
        try {
            return new zzakh(this.context, this.zzacs.zzqz());
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final zzakg zza(zzakf zzakfVar) {
        try {
            this.zzacs.zza(new zzajt(zzakfVar));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    private zzakg(Context context, zzxi zzxiVar) {
        this.context = context;
        this.zzacs = zzxiVar;
    }
}
