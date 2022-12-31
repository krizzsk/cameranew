package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdz implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        zzdsy zzdsyVar;
        zzds zzdsVar;
        zzds zzdsVar2;
        try {
            zzdsVar = zzea.zzxa;
            zzdsVar.zzbq();
            zzdsVar2 = zzea.zzxa;
            zzdsVar2.zzbr();
        } catch (Exception e2) {
            zzdsyVar = zzea.zzxc;
            zzdsyVar.zza(AdError.INTERNAL_ERROR_CODE, -1L, e2);
        }
    }
}
