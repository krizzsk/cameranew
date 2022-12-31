package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* compiled from: ParameterComponent.java */
/* loaded from: classes.dex */
public final class a {
    public final String a;
    public final String b;
    public final List<PathComponent> c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2290d;

    public a(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.getString("name");
        this.b = jSONObject.optString(FirebaseAnalytics.Param.VALUE);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(PGEditResultActivity2.PATH);
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i2)));
            }
        }
        this.c = arrayList;
        this.f2290d = jSONObject.optString("path_type", "absolute");
    }
}
