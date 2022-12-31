package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.report.Issue;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AdEventManager.java */
/* loaded from: classes.dex */
public class d {
    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.bytedance.sdk.openadsdk.utils.g.e(context).toString());
            jSONObject2.put("is_cache", hVar.S() ? 1 : 0);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", hVar.M());
            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ab.g(hVar.M())).floatValue();
            if (floatValue <= 0.0f) {
                floatValue = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(floatValue));
            jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
            String f2 = hVar.f();
            if (!TextUtils.isEmpty(f2)) {
                jSONObject.put("ttdsp_price", Float.parseFloat(f2) * 100000.0f);
            }
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, "show", hVar.J(), jSONObject));
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a()))) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.D(), true));
        }
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "show " + hVar.J());
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        c(context, hVar, str, str2, jSONObject);
    }

    public static void e(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("ad_extra_data", jSONObject2.toString());
        c(context, hVar, str, str2, jSONObject);
    }

    public static void f(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void g(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    private static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", hVar.M());
            jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, str2, hVar.J(), jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tag: " + str + "label: " + str2 + " " + hVar.J());
        }
    }

    private static void c(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (hVar == null) {
            return;
        }
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("log_extra", hVar.M());
                jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str, str2, hVar.J(), jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tag: " + str + "label: " + str2 + " " + hVar.J());
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, hVar, str, str2, jSONObject2);
    }

    public static void a(Context context, String str, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.core.d.d dVar, String str2, boolean z, Map<String, Object> map) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        JSONObject jSONObject = new JSONObject();
        if (dVar != null) {
            try {
                JSONObject a = dVar.a();
                a.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.bytedance.sdk.openadsdk.utils.g.e(context).toString());
                a.put("is_valid", z);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        a.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", a.toString());
            } catch (JSONException unused) {
            }
        }
        jSONObject.putOpt("log_extra", hVar.M());
        float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ab.g(hVar.M())).floatValue();
        if (floatValue <= 0.0f) {
            floatValue = 0.0f;
        }
        jSONObject.putOpt("show_time", Float.valueOf(floatValue));
        jSONObject.putOpt("ua_policy", Integer.valueOf(hVar.t()));
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(context, str2, str, hVar.J(), jSONObject));
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a())) && "click".equals(str)) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.E(), true));
        }
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", str + " " + hVar.J());
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c(context, hVar, str, str2, jSONObject2);
            return;
        }
        b(context, hVar, str, str2);
    }

    public static void a(@NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(hVar, list);
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "tt_dislike_icon " + hVar.J());
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        b(context, hVar, str, "click_close");
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
        Context a = com.bytedance.sdk.openadsdk.core.o.a();
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.bytedance.sdk.openadsdk.utils.g.e(a).toString());
                Object remove = map.remove("total_time");
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                if (remove instanceof Long) {
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, remove);
                } else {
                    jSONObject.put(TypedValues.TransitionType.S_DURATION, 0);
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(a, hVar, str, "load_ad_duration", jSONObject);
            return;
        }
        b(a, hVar, str, "load_ad_duration");
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, long j2, int i2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(TypedValues.TransitionType.S_DURATION, j2);
            jSONObject.put("percent", i2);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, hVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2) {
        b(context, hVar, str, str2);
    }

    public static void a(Context context, String str, long j2) {
        com.bytedance.sdk.openadsdk.core.b.c.a(context, str, j2);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                jSONObject2.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.bytedance.sdk.openadsdk.utils.g.e(com.bytedance.sdk.openadsdk.core.o.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put(Issue.ISSUE_REPORT_TAG, str2);
                if ("click".equals(str3)) {
                    float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ab.g(jSONObject.optString("log_extra"))).floatValue();
                    if (floatValue <= 0.0f) {
                        floatValue = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(floatValue));
                    if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a())) && hVar != null) {
                        com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.E(), true));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(a.a(str, str2, str3, j2, j3, jSONObject));
        if (com.bytedance.sdk.openadsdk.utils.o.c()) {
            com.bytedance.sdk.openadsdk.utils.o.c("AdEvent", "sendJsAdEvent");
        }
    }
}
