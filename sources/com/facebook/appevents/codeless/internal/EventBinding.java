package com.facebook.appevents.codeless.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes.dex */
public class EventBinding {
    private final String a;
    private final List<PathComponent> b;
    private final List<a> c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2284d;

    /* loaded from: classes.dex */
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    /* loaded from: classes.dex */
    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<a> list2, String str3, String str4, String str5) {
        this.a = str;
        this.b = list;
        this.c = list2;
        this.f2284d = str5;
    }

    public static EventBinding c(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
        String string = jSONObject.getString(TJAdUnitConstants.PARAM_PLACEMENT_NAME);
        String string2 = jSONObject.getString("method");
        Locale locale = Locale.ENGLISH;
        MappingMethod valueOf = MappingMethod.valueOf(string2.toUpperCase(locale));
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase(locale));
        String string3 = jSONObject.getString(TapjoyConstants.TJC_APP_VERSION_NAME);
        JSONArray jSONArray = jSONObject.getJSONArray(PGEditResultActivity2.PATH);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i2)));
        }
        String optString = jSONObject.optString("path_type", "absolute");
        JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList2.add(new a(optJSONArray.getJSONObject(i3)));
            }
        }
        return new EventBinding(string, valueOf, valueOf2, string3, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    public static List<EventBinding> f(JSONArray jSONArray) {
        int length;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (IllegalArgumentException | JSONException unused) {
            }
        } else {
            length = 0;
        }
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(c(jSONArray.getJSONObject(i2)));
        }
        return arrayList;
    }

    public String a() {
        return this.f2284d;
    }

    public String b() {
        return this.a;
    }

    public List<a> d() {
        return Collections.unmodifiableList(this.c);
    }

    public List<PathComponent> e() {
        return Collections.unmodifiableList(this.b);
    }
}
