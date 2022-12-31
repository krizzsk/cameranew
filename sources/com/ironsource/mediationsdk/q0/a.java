package com.ironsource.mediationsdk.q0;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IronsourceJsonUtilities.java */
/* loaded from: classes2.dex */
public class a {
    public static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(c(jSONArray.get(i2)));
            } catch (JSONException e2) {
                IronLog.INTERNAL.error(String.format("Could not put value into list: %s", e2.getMessage()));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, c(jSONObject.get(next)));
            } catch (JSONException e2) {
                IronLog.INTERNAL.error(String.format("Could not put value in map: %s, %s", next, e2.getMessage()));
            }
        }
        return hashMap;
    }

    private static Object c(Object obj) {
        if (obj instanceof JSONObject) {
            return b((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static JSONObject d(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            jSONObject.put(next, jSONObject2.get(next));
                        } catch (JSONException e2) {
                            IronLog.INTERNAL.error(e2.getMessage());
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
