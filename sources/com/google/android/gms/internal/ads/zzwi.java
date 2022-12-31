package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwi extends zzws<zzarf> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzane zzciv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwi(zzwc zzwcVar, Context context, zzane zzaneVar) {
        this.val$context = context;
        this.zzciv = zzaneVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzws
    /* renamed from: zzqm */
    public final zzarf zzqk() {
        try {
            return ((zzarg) zzazj.zza(this.val$context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzwh.zzbyi)).zzc(d.z0(this.val$context), this.zzciv, 204204000);
        } catch (RemoteException | zzazl | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzarf zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zzc(d.z0(this.val$context), this.zzciv, 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* bridge */ /* synthetic */ zzarf zzqj() {
        return null;
    }
}
