package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzao;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaa implements Runnable {
    private final /* synthetic */ String val$tag;
    private final /* synthetic */ long zzam;
    private final /* synthetic */ zzab zzan;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzab zzabVar, String str, long j2) {
        this.zzan = zzabVar;
        this.val$tag = str;
        this.zzam = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzao.zza zzaVar;
        zzao.zza zzaVar2;
        zzaVar = this.zzan.zzao;
        zzaVar.zza(this.val$tag, this.zzam);
        zzaVar2 = this.zzan.zzao;
        zzaVar2.zzd(this.zzan.toString());
    }
}
