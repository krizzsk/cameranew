package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzain implements zzaif<Object> {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final Map<String, zzaip> zzdil = new HashMap();

    public final void zza(String str, zzaip zzaipVar) {
        synchronized (this.lock) {
            this.zzdil.put(str, zzaipVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get(TapjoyAuctionFlags.AUCTION_ID);
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = "";
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzaip remove = this.zzdil.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                zzazk.zzex(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str5 == null) {
                remove.zzc(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (com.google.android.gms.ads.internal.util.zzd.zzyg()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e2) {
                    remove.onFailure(e2.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzakw> zzdzw<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbaa zzbaaVar = new zzbaa();
        com.google.android.gms.ads.internal.zzr.zzkr();
        String zzyy = com.google.android.gms.ads.internal.util.zzj.zzyy();
        zza(zzyy, new zzaim(this, zzbaaVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TapjoyAuctionFlags.AUCTION_ID, zzyy);
            jSONObject2.put("args", jSONObject);
            enginet.zzb(str, jSONObject2);
        } catch (Exception e2) {
            zzbaaVar.setException(e2);
        }
        return zzbaaVar;
    }
}
