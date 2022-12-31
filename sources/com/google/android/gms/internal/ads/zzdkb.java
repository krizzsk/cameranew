package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdkb implements zzdzl<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkb(zzdjw zzdjwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@NullableDecl Void r1) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("Notification of cache hit successful.");
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("Notification of cache hit failed.");
    }
}
