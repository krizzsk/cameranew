package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcu implements zzdfi<zzdcv> {
    private final Context context;
    private final zzdzv zzghl;

    public zzdcu(Context context, zzdzv zzdzvVar) {
        this.context = context;
        this.zzghl = zzdzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdcv> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcx
            private final zzdcu zzhbz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String zzyj;
                String zzyl;
                String str;
                com.google.android.gms.ads.internal.zzr.zzkr();
                zzrp zzyh = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyh();
                Bundle bundle = null;
                if (zzyh != null && zzyh != null && (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyi() || !com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyk())) {
                    if (zzyh.zzmm()) {
                        zzyh.wakeup();
                    }
                    zzrj zzmk = zzyh.zzmk();
                    if (zzmk != null) {
                        zzyj = zzmk.zzlz();
                        str = zzmk.zzma();
                        zzyl = zzmk.zzmb();
                        if (zzyj != null) {
                            com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzec(zzyj);
                        }
                        if (zzyl != null) {
                            com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzed(zzyl);
                        }
                    } else {
                        zzyj = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyj();
                        zzyl = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyl();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyk()) {
                        if (zzyl != null && !TextUtils.isEmpty(zzyl)) {
                            bundle2.putString("v_fp_vertical", zzyl);
                        } else {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        }
                    }
                    if (zzyj != null && !com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyi()) {
                        bundle2.putString("fingerprint", zzyj);
                        if (!zzyj.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzdcv(bundle);
            }
        });
    }
}
