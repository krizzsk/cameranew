package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwn extends zzws<zzaev> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwc zzciw;
    private final /* synthetic */ FrameLayout zzcjf;
    private final /* synthetic */ FrameLayout zzcjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwn(zzwc zzwcVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzciw = zzwcVar;
        this.zzcjf = frameLayout;
        this.zzcjg = frameLayout2;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaev zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zza(d.z0(this.zzcjf), d.z0(this.zzcjg));
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* synthetic */ zzaev zzqj() {
        zzwc.zza(this.val$context, "native_ad_view_delegate");
        return new zzaag();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaev zzqk() throws RemoteException {
        zzagv zzagvVar;
        zzagvVar = this.zzciw.zzcja;
        return zzagvVar.zzb(this.val$context, this.zzcjf, this.zzcjg);
    }
}
