package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.q;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.tencent.matrix.report.Issue;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;
/* compiled from: AdEvent.java */
/* loaded from: classes.dex */
public class a implements i {
    public final String a;
    public final JSONObject b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(context, str, str2, str3, jSONObject));
    }

    private static JSONObject b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt(Issue.ISSUE_REPORT_TAG, str);
            jSONObject2.putOpt(Constants.ScionAnalytics.PARAM_LABEL, str2);
            jSONObject2.putOpt("category", "app_union");
            try {
                jSONObject2.putOpt(FirebaseAnalytics.Param.VALUE, Long.valueOf(Long.parseLong(str3)));
            } catch (NumberFormatException unused) {
                jSONObject2.putOpt(FirebaseAnalytics.Param.VALUE, 0L);
            }
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("nt", Integer.valueOf(q.c(context)));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(str, str2, str3, j2, j3, jSONObject));
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("localId", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("event");
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                return new a(optString, optJSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String a() {
        if (TextUtils.isEmpty(this.a) || this.b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.a);
            jSONObject.put("event", this.b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    private static JSONObject b(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt(Issue.ISSUE_REPORT_TAG, str2);
            jSONObject2.putOpt(Constants.ScionAnalytics.PARAM_LABEL, str3);
            jSONObject2.putOpt("category", str);
            jSONObject2.putOpt(FirebaseAnalytics.Param.VALUE, Long.valueOf(j2));
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("ext_value", Long.valueOf(j3));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // com.bytedance.sdk.openadsdk.c.i
    public String b() {
        return this.a;
    }
}
