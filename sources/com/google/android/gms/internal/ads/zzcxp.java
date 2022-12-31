package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.tapjoy.TapjoyConstants;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxp extends zzapo {
    private final String zzdit;
    private final zzapk zzgxl;
    private zzbaa<JSONObject> zzgxm;
    private final JSONObject zzgxn;
    @GuardedBy("this")
    private boolean zzgxo;

    public zzcxp(String str, zzapk zzapkVar, zzbaa<JSONObject> zzbaaVar) {
        JSONObject jSONObject = new JSONObject();
        this.zzgxn = jSONObject;
        this.zzgxo = false;
        this.zzgxm = zzbaaVar;
        this.zzdit = str;
        this.zzgxl = zzapkVar;
        try {
            jSONObject.put(TapjoyConstants.TJC_ADAPTER_VERSION, zzapkVar.zzvc().toString());
            jSONObject.put("sdk_version", zzapkVar.zzvd().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapp
    public final synchronized void onFailure(String str) throws RemoteException {
        if (this.zzgxo) {
            return;
        }
        try {
            this.zzgxn.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.zzgxm.set(this.zzgxn);
        this.zzgxo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapp
    public final synchronized void zzdn(String str) throws RemoteException {
        if (this.zzgxo) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.zzgxn.put("signals", str);
        } catch (JSONException unused) {
        }
        this.zzgxm.set(this.zzgxn);
        this.zzgxo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapp
    public final synchronized void zzh(zzvg zzvgVar) throws RemoteException {
        if (this.zzgxo) {
            return;
        }
        try {
            this.zzgxn.put("signal_error", zzvgVar.zzchg);
        } catch (JSONException unused) {
        }
        this.zzgxm.set(this.zzgxn);
        this.zzgxo = true;
    }
}
