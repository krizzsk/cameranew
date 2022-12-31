package com.bytedance.sdk.openadsdk.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: JsAppAdDownloadManager.java */
/* loaded from: classes.dex */
public class a implements c {
    private final h a;
    private final b b;
    private final Map<String, d.a.a.a.a.a.b> c = new HashMap();

    private a(b bVar, h hVar) {
        this.b = bVar;
        this.a = hVar;
    }

    public static a a(b bVar, h hVar) {
        return new a(bVar, hVar);
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void c() {
        this.c.clear();
    }

    private h a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.b(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            hVar.j(str);
        }
        if (this.a == null) {
            return hVar;
        }
        String a = hVar.K() != null ? hVar.K().a() : null;
        if (TextUtils.isEmpty(a)) {
            return this.a;
        }
        return (this.a.K() == null || !a.equals(this.a.K().a())) ? hVar : this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject, String str, int i2, boolean z) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, str), optJSONObject, i2, z);
    }

    private void a(Context context, h hVar, JSONObject jSONObject, int i2, boolean z) {
        if (context == null || hVar == null || hVar.K() == null || jSONObject == null || this.b == null || this.c.get(hVar.K().a()) != null) {
            return;
        }
        String a = ab.a(i2);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        this.c.put(hVar.K().a(), a(context, hVar, jSONObject, a, z));
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, (String) null));
    }

    private void a(Context context, h hVar) {
        if (context == null || hVar == null || hVar.K() == null) {
            return;
        }
        d.a.a.a.a.a.b bVar = this.c.get(hVar.K().a());
        if (bVar != null) {
            bVar.a();
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.video.d.b) {
            ((com.bytedance.sdk.openadsdk.core.video.d.b) context).Q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(a(optJSONObject, (String) null), optJSONObject);
    }

    private void a(h hVar, JSONObject jSONObject) {
        if (this.b == null || hVar == null || hVar.K() == null) {
            return;
        }
        String a = hVar.K().a();
        if (this.c.containsKey(a)) {
            this.c.remove(a);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", FirebaseAnalytics.Param.SUCCESS);
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.b.a("app_ad_event", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private d.a.a.a.a.a.b a(@NonNull Context context, @NonNull h hVar, @NonNull JSONObject jSONObject, @NonNull String str, boolean z) {
        d.a.a.a.a.a.b a = d.a.a.a.a.a.c.a(context, hVar, str);
        a.a(true);
        return a;
    }
}
