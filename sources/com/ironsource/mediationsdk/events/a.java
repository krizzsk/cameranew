package com.ironsource.mediationsdk.events;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AbstractEventsFormatter.java */
/* loaded from: classes2.dex */
abstract class a {
    JSONObject a;
    int b;
    private String c;

    private String e(int i2) {
        return i2 != 2 ? "events" : "InterstitialEvents";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(JSONArray jSONArray) {
        try {
            if (this.a != null) {
                JSONObject jSONObject = new JSONObject(this.a.toString());
                jSONObject.put("timestamp", IronSourceUtils.N());
                jSONObject.put("adUnit", this.b);
                jSONObject.put(e(this.b), jSONArray);
                return jSONObject.toString();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject b(d.e.b.b bVar) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(bVar.b())) {
                jSONObject = new JSONObject(bVar.b());
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("eventId", bVar.d());
            jSONObject.put("timestamp", bVar.e());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public abstract String c(ArrayList<d.e.b.b> arrayList, JSONObject jSONObject);

    protected abstract String d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return TextUtils.isEmpty(this.c) ? d() : this.c;
    }

    public abstract String g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str) {
        this.c = str;
    }
}
