package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: TNCConfigHandler.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f1206d = new Object();
    private Context a;
    private d b = new d();
    private boolean c;

    public e(Context context, boolean z) {
        this.c = true;
        this.a = context;
        this.c = z;
    }

    public void a(JSONObject jSONObject) {
        if (!this.c) {
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        f.a().b();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (com.bytedance.sdk.adnet.a.b() && z && optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i2)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it.next();
                        Iterator<String> keys = jSONObject4.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("tnc_config");
            if (optJSONObject == null && jSONObject2 == null) {
                com.bytedance.sdk.adnet.d.c.a("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                optJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                optJSONObject.put("host_replace_map", jSONObject2);
            }
            d b = b(optJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(b == null ? "null" : b.toString());
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", sb.toString());
            if (b == null) {
                synchronized (f1206d) {
                    this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.d.a(this.a, 1, "");
                }
                return;
            }
            this.b = b;
            String jSONObject5 = optJSONObject.toString();
            synchronized (f1206d) {
                this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", jSONObject5).apply();
                com.bytedance.sdk.adnet.d.d.a(this.a, 1, jSONObject5);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.b = new d();
                synchronized (f1206d) {
                    this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.d.a(this.a, 1, "");
                }
            } catch (Throwable th2) {
                synchronized (f1206d) {
                    this.a.getSharedPreferences("ttnet_tnc_config", 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.adnet.d.d.a(this.a, 1, "");
                    throw th2;
                }
            }
        }
    }

    public void b() {
        try {
            String a = com.bytedance.sdk.adnet.d.d.a(this.a, 1);
            if (TextUtils.isEmpty(a)) {
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d b = b(new JSONObject(a));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(b == null ? "null" : b.toString());
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", sb.toString());
            if (b != null) {
                this.b = b;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public d c() {
        return this.b;
    }

    private d b(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                dVar.c = hashMap;
            } else {
                dVar.c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                dVar.f1197d = hashMap2;
            } else {
                dVar.f1197d = null;
            }
            dVar.f1198e = jSONObject.optInt("req_to_cnt", dVar.f1198e);
            dVar.f1199f = jSONObject.optInt("req_to_api_cnt", dVar.f1199f);
            dVar.f1200g = jSONObject.optInt("req_to_ip_cnt", dVar.f1200g);
            dVar.f1201h = jSONObject.optInt("req_err_cnt", dVar.f1201h);
            dVar.f1202i = jSONObject.optInt("req_err_api_cnt", dVar.f1202i);
            dVar.f1203j = jSONObject.optInt("req_err_ip_cnt", dVar.f1203j);
            dVar.f1204k = jSONObject.optInt("update_interval", dVar.f1204k);
            dVar.f1205l = jSONObject.optInt("update_random_range", dVar.f1205l);
            dVar.m = jSONObject.optString("http_code_black", dVar.m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a() {
        if (this.c) {
            String string = this.a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d b = b(new JSONObject(string));
                if (b != null) {
                    this.b = b;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(b == null ? "null" : b.toString());
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
