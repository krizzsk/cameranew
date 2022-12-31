package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddo implements zzdfi<zzddp> {
    private final PackageInfo zzdue;
    private final com.google.android.gms.ads.internal.util.zzf zzedg;
    private final zzdnp zzfwy;
    private final zzdzv zzghl;

    public zzddo(zzdzv zzdzvVar, zzdnp zzdnpVar, @Nullable PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzghl = zzdzvVar;
        this.zzfwy = zzdnpVar;
        this.zzdue = packageInfo;
        this.zzedg = zzfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f5, code lost:
        if (r9 == 3) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzddo.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzddp> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddr
            private final zzddo zzhch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhch.zzati();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzddp zzati() throws Exception {
        final ArrayList<String> arrayList = this.zzfwy.zzhky;
        if (arrayList == null) {
            return zzddq.zzhcg;
        }
        if (arrayList.isEmpty()) {
            return zzddt.zzhcg;
        }
        return new zzddp(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdds
            private final zzddo zzhch;
            private final ArrayList zzhci;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzhci = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Bundle bundle) {
                this.zzhch.zza(this.zzhci, bundle);
            }
        };
    }
}
