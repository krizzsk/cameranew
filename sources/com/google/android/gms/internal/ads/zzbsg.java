package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbsg extends zzbwf<zzbsh> {
    public zzbsg(Set<zzbya<zzbsh>> set) {
        super(set);
    }

    public final void zza(zzbyq zzbyqVar, Executor executor) {
        zza(zzbya.zzb(new zzbsk(this, zzbyqVar), executor));
    }

    public final void zzcb(final Context context) {
        zza(new zzbwh(context) { // from class: com.google.android.gms.internal.ads.zzbsj
            private final Context zzcmi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbsh) obj).zzcb(this.zzcmi);
            }
        });
    }

    public final void zzcc(final Context context) {
        zza(new zzbwh(context) { // from class: com.google.android.gms.internal.ads.zzbsi
            private final Context zzcmi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbsh) obj).zzcc(this.zzcmi);
            }
        });
    }

    public final void zzcd(final Context context) {
        zza(new zzbwh(context) { // from class: com.google.android.gms.internal.ads.zzbsl
            private final Context zzcmi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbsh) obj).zzcd(this.zzcmi);
            }
        });
    }
}
