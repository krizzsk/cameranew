package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwo extends zzws<zzyg> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwc zzciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwo(zzwc zzwcVar, Context context) {
        this.zzciw = zzwcVar;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzyg zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zza(d.z0(this.val$context), 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* synthetic */ zzyg zzqj() {
        zzwc.zza(this.val$context, "mobile_ads_settings");
        return new zzaae();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzyg zzqk() throws RemoteException {
        zzzz zzzzVar;
        zzzzVar = this.zzciw.zzciz;
        return zzzzVar.zzh(this.val$context);
    }
}
