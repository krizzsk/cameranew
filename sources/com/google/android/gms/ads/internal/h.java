package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzdfd;
import com.google.android.gms.internal.ads.zzvl;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class h {
    private final Context a;
    private final String b;
    private final Map<String, String> c = new TreeMap();

    /* renamed from: d  reason: collision with root package name */
    private String f3454d;

    /* renamed from: e  reason: collision with root package name */
    private String f3455e;

    public h(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    public final String a() {
        return this.f3454d;
    }

    public final void b(zzvl zzvlVar, zzazn zzaznVar) {
        this.f3454d = zzvlVar.zzchs.zzbrb;
        Bundle bundle = zzvlVar.zzchu;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 == null) {
            return;
        }
        String str = zzadb.zzdcq.get();
        for (String str2 : bundle2.keySet()) {
            if (str.equals(str2)) {
                this.f3455e = bundle2.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.c.put(str2.substring(4), bundle2.getString(str2));
            }
        }
        this.c.put("SDKVersion", zzaznVar.zzbrp);
        if (zzadb.zzdco.get().booleanValue()) {
            try {
                Bundle zza = zzdfd.zza(this.a, new JSONArray(zzadb.zzdcp.get()));
                for (String str3 : zza.keySet()) {
                    this.c.put(str3, zza.get(str3).toString());
                }
            } catch (JSONException e2) {
                zzazk.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e2);
            }
        }
    }

    public final String c() {
        return this.f3455e;
    }

    public final String d() {
        return this.b;
    }

    public final Map<String, String> e() {
        return this.c;
    }
}
