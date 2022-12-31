package com.huawei.hianalytics.v2.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hianalytics.util.k;
import com.huawei.hianalytics.util.m;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    private static final String f5129e = "e";

    public static e[] a(SharedPreferences sharedPreferences, Context context) {
        if (sharedPreferences == null) {
            return new e[0];
        }
        String a = k.a(sharedPreferences, "events", "");
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(a)) {
                jSONArray = new JSONArray(a);
            }
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c(f5129e, "JSONException happened when events turn to JSONArray");
        }
        if (jSONArray.length() == 0) {
            return new e[0];
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    e eVar = new e();
                    eVar.b = jSONObject.getString("event") == null ? "" : jSONObject.getString("event");
                    eVar.c = jSONObject.getString(FirebaseAnalytics.Param.CONTENT) == null ? "" : m.a(jSONObject.getString(FirebaseAnalytics.Param.CONTENT), context);
                    eVar.a = jSONObject.getString("eventtime") == null ? "" : jSONObject.getString("eventtime");
                    eVar.f5128d = jSONObject.getString("type") == null ? "" : jSONObject.getString("type");
                    arrayList.add(eVar);
                }
            } catch (JSONException unused2) {
                com.huawei.hianalytics.b.b.c(f5129e, "JSONException happened when create data for report");
            }
        }
        return (e[]) arrayList.toArray(new e[arrayList.size()]);
    }

    @SuppressLint({"ApplySharedPref"})
    public void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        String a = k.a(sharedPreferences, "events", "");
        try {
            JSONArray jSONArray = TextUtils.isEmpty(a) ? new JSONArray() : new JSONArray(a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", this.b);
            jSONObject.put(FirebaseAnalytics.Param.CONTENT, this.c);
            jSONObject.put("eventtime", this.a);
            jSONObject.put("type", this.f5128d);
            jSONArray.put(jSONObject);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String jSONArray2 = jSONArray.toString();
            edit.remove("events");
            edit.putString("events", jSONArray2);
            edit.commit();
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c(f5129e, "saveInSp(): JSONException");
        }
    }
}
