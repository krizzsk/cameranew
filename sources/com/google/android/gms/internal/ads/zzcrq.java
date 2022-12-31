package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcrq {
    private zzdmw zzesr = null;
    private final Map<String, zzvw> zzgsy = Collections.synchronizedMap(new HashMap());
    private final List<zzvw> zzadw = Collections.synchronizedList(new ArrayList());

    public final List<zzvw> getAdapterResponses() {
        return this.zzadw;
    }

    public final void zza(zzdmw zzdmwVar, long j2, @Nullable zzvg zzvgVar) {
        String str = zzdmwVar.zzdlu;
        if (this.zzgsy.containsKey(str)) {
            if (this.zzesr == null) {
                this.zzesr = zzdmwVar;
            }
            zzvw zzvwVar = this.zzgsy.get(str);
            zzvwVar.zzcip = j2;
            zzvwVar.zzciq = zzvgVar;
        }
    }

    public final zzbrh zzasa() {
        return new zzbrh(this.zzesr, "", this);
    }

    public final void zzd(zzdmw zzdmwVar) {
        String str = zzdmwVar.zzdlu;
        if (this.zzgsy.containsKey(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> keys = zzdmwVar.zzhjj.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                bundle.putString(next, zzdmwVar.zzhjj.getString(next));
            } catch (JSONException unused) {
            }
        }
        zzvw zzvwVar = new zzvw(zzdmwVar.zzhjn, 0L, null, bundle);
        this.zzadw.add(zzvwVar);
        this.zzgsy.put(str, zzvwVar);
    }
}
