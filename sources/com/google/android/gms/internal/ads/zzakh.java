package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzakh {
    private final Context context;
    private final zzvq zzact;
    private final zzxd zzacu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakh(Context context, zzxd zzxdVar) {
        this(context, zzxdVar, zzvq.zzcif);
    }

    private final void zza(zzzk zzzkVar) {
        try {
            this.zzacu.zzb(zzvq.zza(this.context, zzzkVar));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzds());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzds());
    }

    private zzakh(Context context, zzxd zzxdVar, zzvq zzvqVar) {
        this.context = context;
        this.zzacu = zzxdVar;
        this.zzact = zzvqVar;
    }
}
