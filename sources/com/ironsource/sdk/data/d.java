package com.ironsource.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SSAObj.java */
/* loaded from: classes2.dex */
public class d {
    private JSONObject a;

    public d() {
        this.a = new JSONObject();
    }

    private Object b(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return l((JSONObject) obj);
        }
        return obj instanceof JSONArray ? k((JSONArray) obj) : obj;
    }

    private void j(String str) {
        try {
            this.a = new JSONObject(str);
        } catch (Exception unused) {
            this.a = new JSONObject();
        }
    }

    private Map<String, Object> l(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, b(jSONObject.get(next)));
        }
        return hashMap;
    }

    public boolean a(String str) {
        return e().has(str);
    }

    public Object c(String str) {
        try {
            return e().get(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean d(String str) {
        try {
            return this.a.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public JSONObject e() {
        return this.a;
    }

    public String f(String str) {
        try {
            return this.a.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean g(String str) {
        return e().isNull(str);
    }

    public void h(String str, String str2) {
        try {
            this.a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void i(String str, JSONObject jSONObject) {
        try {
            this.a.put(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    public List k(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(b(jSONArray.get(i2)));
        }
        return arrayList;
    }

    public String toString() {
        JSONObject jSONObject = this.a;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public d(String str) {
        j(str);
    }
}
