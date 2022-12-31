package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzec implements Runnable {
    private final /* synthetic */ Context zzxl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(zzea zzeaVar, Context context) {
        this.zzxl = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxa;
            zzdsVar.zzb(this.zzxl);
        } catch (Exception e2) {
            zzdsyVar = zzea.zzxc;
            zzdsyVar.zza(2019, -1L, e2);
        }
    }
}
