package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwd extends zzws<zzaro> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzwc zzciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwd(zzwc zzwcVar, Activity activity) {
        this.zzciw = zzwcVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaro zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zzb(d.z0(this.val$activity));
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* synthetic */ zzaro zzqj() {
        zzwc.zza(this.val$activity, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaro zzqk() throws RemoteException {
        zzarp zzarpVar;
        zzarpVar = this.zzciw.zzcjd;
        return zzarpVar.zze(this.val$activity);
    }
}
