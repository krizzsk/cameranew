package d.e.d;

import org.json.JSONObject;
/* compiled from: IronSourceNetworkAPIUtils.java */
/* loaded from: classes2.dex */
public class g {
    static String a = "ManRewInst_";

    public static String a(JSONObject jSONObject) {
        if (jSONObject.optBoolean("rewarded")) {
            return a + jSONObject.optString("name");
        }
        return jSONObject.optString("name");
    }

    public static String b() {
        return String.valueOf(System.currentTimeMillis());
    }
}
