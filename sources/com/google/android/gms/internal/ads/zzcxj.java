package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxj {
    private final Executor executor;
    private JSONObject zzgkp;
    private final Map<String, zzcxq> zzgxi = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcxq>>> zzgxj = new ConcurrentHashMap();

    public zzcxj(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzase */
    public final synchronized void zzash() {
        JSONArray optJSONArray;
        JSONObject zzyb = com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyn().zzyb();
        if (zzyb != null) {
            try {
                JSONArray optJSONArray2 = zzyb.optJSONArray("ad_unit_id_settings");
                this.zzgkp = zzyb.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString(IjkMediaMeta.IJKM_KEY_FORMAT, "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                            String optString3 = optJSONArray3.optString(i4, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        int size = arrayList3.size();
                                        int i5 = 0;
                                        while (i5 < size) {
                                            Object obj = arrayList3.get(i5);
                                            i5++;
                                            String str = (String) obj;
                                            zzgp(str);
                                            if (this.zzgxi.get(str) != null) {
                                                arrayList2.add(new zzcxq(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcxq>> map = this.zzgxj.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.zzgxj.put(optString2, map);
                            List<zzcxq> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.zzd.zza("Malformed config loading JSON.", e2);
            }
        }
    }

    public final void zzapw() {
        com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcxm
            private final zzcxj zzgxk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxk = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgxk.zzasg();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcxl
            private final zzcxj zzgxk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxk = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgxk.zzasf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzasg() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcxo
            private final zzcxj zzgxk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxk = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgxk.zzash();
            }
        });
    }

    public final void zzgp(String str) {
        if (TextUtils.isEmpty(str) || this.zzgxi.containsKey(str)) {
            return;
        }
        this.zzgxi.put(str, new zzcxq(str, "", new Bundle()));
    }

    public final Map<String, List<Bundle>> zzt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Map<String, List<zzcxq>> map = this.zzgxj.get(str);
            if (map == null) {
                return Collections.emptyMap();
            }
            List<zzcxq> list = map.get(str2);
            if (list == null) {
                list = map.get(zzciw.zza(this.zzgkp, str2, str));
            }
            if (list == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (zzcxq zzcxqVar : list) {
                String str3 = zzcxqVar.zzcio;
                if (!hashMap.containsKey(str3)) {
                    hashMap.put(str3, new ArrayList());
                }
                ((List) hashMap.get(str3)).add(zzcxqVar.zzeup);
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
