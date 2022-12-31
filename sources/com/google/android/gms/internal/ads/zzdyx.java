package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyo;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdyx<V, C> extends zzdyo<V, C> {
    private List<zzdyz<V>> zziae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyx(zzdwy<? extends zzdzw<? extends V>> zzdwyVar, boolean z) {
        super(zzdwyVar, true, true);
        List<zzdyz<V>> zzet;
        if (zzdwyVar.isEmpty()) {
            zzet = zzdxd.zzazm();
        } else {
            zzet = zzdxl.zzet(zzdwyVar.size());
        }
        for (int i2 = 0; i2 < zzdwyVar.size(); i2++) {
            zzet.add(null);
        }
        this.zziae = zzet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void zza(zzdyo.zza zzaVar) {
        super.zza(zzaVar);
        this.zziae = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdyo
    final void zzazx() {
        List<zzdyz<V>> list = this.zziae;
        if (list != null) {
            set(zzl(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    final void zzb(int i2, @NullableDecl V v) {
        List<zzdyz<V>> list = this.zziae;
        if (list != null) {
            list.set(i2, new zzdyz<>(v));
        }
    }

    abstract C zzl(List<zzdyz<V>> list);
}
