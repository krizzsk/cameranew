package com.google.android.gms.internal.ads;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayq extends com.google.android.gms.ads.internal.util.zza {
    private final /* synthetic */ zzayo zzecs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayq(zzayo zzayoVar) {
        this.zzecs = zzayoVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwe() {
        Context context;
        zzazn zzaznVar;
        Object obj;
        zzabs zzabsVar;
        context = this.zzecs.context;
        zzaznVar = this.zzecs.zzbpn;
        zzabt zzabtVar = new zzabt(context, zzaznVar.zzbrp);
        obj = this.zzecs.lock;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzr.zzla();
                zzabsVar = this.zzecs.zzecf;
                zzabu.zza(zzabsVar, zzabtVar);
            } catch (IllegalArgumentException e2) {
                zzazk.zzd("Cannot config CSI reporter.", e2);
            }
        }
    }
}
