package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazv implements zzdzl<Object> {
    private final /* synthetic */ String zzeil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazv(String str) {
        this.zzeil = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void onSuccess(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.zzr.zzkv().zza(th, this.zzeil);
    }
}
