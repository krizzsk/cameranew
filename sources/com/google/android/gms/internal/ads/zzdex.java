package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.wrappers.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdex implements zzdfi<zzdeu> {
    private final Context context;
    private final zzazn zzbpn;
    private final zzdzv zzghl;

    public zzdex(zzdzv zzdzvVar, Context context, zzazn zzaznVar) {
        this.zzghl = zzdzvVar;
        this.context = context;
        this.zzbpn = zzaznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdeu> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdew
            private final zzdex zzhdc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdc = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdc.zzato();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdeu zzato() throws Exception {
        boolean f2 = b.a(this.context).f();
        com.google.android.gms.ads.internal.zzr.zzkr();
        boolean zzau = com.google.android.gms.ads.internal.util.zzj.zzau(this.context);
        String str = this.zzbpn.zzbrp;
        com.google.android.gms.ads.internal.zzr.zzkt();
        boolean zzze = com.google.android.gms.ads.internal.util.zzr.zzze();
        com.google.android.gms.ads.internal.zzr.zzkr();
        return new zzdeu(f2, zzau, str, zzze, com.google.android.gms.ads.internal.util.zzj.zzar(this.context), DynamiteModule.c(this.context, ModuleDescriptor.MODULE_ID), DynamiteModule.a(this.context, ModuleDescriptor.MODULE_ID));
    }
}
