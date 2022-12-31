package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgg implements zzdfi<zzdgh> {
    private final Context context;
    private final String packageName;
    private final zzdzv zzghl;
    private final zzatx zzhed;

    public zzdgg(@Nullable zzatx zzatxVar, Context context, String str, zzdzv zzdzvVar) {
        this.zzhed = zzatxVar;
        this.context = context;
        this.packageName = str;
        this.zzghl = zzdzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdgh> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgj
            private final zzdgg zzhef;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhef = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhef.zzatt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdgh zzatt() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzatx zzatxVar = this.zzhed;
        if (zzatxVar != null) {
            zzatxVar.zza(this.context, this.packageName, jSONObject);
        }
        return new zzdgh(jSONObject);
    }
}
