package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcb implements zzdfi<zzdby> {
    private final Context context;
    private final zzdzv zzghl;

    public zzdcb(zzdzv zzdzvVar, Context context) {
        this.zzghl = zzdzvVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdby> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdca
            private final zzdcb zzhbi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbi = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhbi.zzatd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdby zzatd() throws Exception {
        double d2;
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d2 = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d2 = -1.0d;
        }
        return new zzdby(d2, z);
    }
}
