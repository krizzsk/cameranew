package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.common.c;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauc extends zzaue {
    private final Object lock = new Object();
    private final Context zzaad;
    @Nullable
    private SharedPreferences zzdyx;
    private final zzamb<JSONObject, JSONObject> zzdyy;

    public zzauc(Context context, zzamb<JSONObject, JSONObject> zzambVar) {
        this.zzaad = context.getApplicationContext();
        this.zzdyy = zzambVar;
    }

    public static JSONObject zzw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzazn.zzaab().zzbrp);
            jSONObject.put("mf", zzadi.zzddw.get());
            jSONObject.put("cl", "350251165");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", c.a);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.c(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", c.a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzabp.zza(this.zzaad, 1, jSONObject);
        this.zzdyx.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()).apply();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaue
    public final zzdzw<Void> zzwt() {
        synchronized (this.lock) {
            if (this.zzdyx == null) {
                this.zzdyx = this.zzaad.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis() - this.zzdyx.getLong("js_last_update", 0L) < zzadi.zzddx.get().longValue()) {
            return zzdzk.zzag(null);
        }
        return zzdzk.zzb(this.zzdyy.zzh(zzw(this.zzaad)), new zzdvz(this) { // from class: com.google.android.gms.internal.ads.zzauf
            private final zzauc zzdzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdzb = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return this.zzdzb.zzf((JSONObject) obj);
            }
        }, zzazp.zzeih);
    }
}
