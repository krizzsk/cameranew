package us.pinguo.advconfigdata.a;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
/* compiled from: CookieHelper.java */
/* loaded from: classes3.dex */
public class a {
    public static Boolean a(String str) {
        String string = AdvPrefUtil.getInstance().getString(AdvPrefUtil.ENABLE_COOKIE_SITES);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (str.contains((String) jSONArray.get(i2))) {
                        return Boolean.TRUE;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return Boolean.FALSE;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        AdvPrefUtil.getInstance().putString(AdvPrefUtil.COOKIE, httpURLConnection.getHeaderField("Set-Cookie"));
    }

    public static void c(JSONObject jSONObject) {
        try {
            AdvPrefUtil.getInstance().putString(AdvPrefUtil.ENABLE_COOKIE_SITES, jSONObject.getJSONArray("enableCookieSites").toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void d(HttpURLConnection httpURLConnection, String str) {
        if (a(str).booleanValue()) {
            String string = AdvPrefUtil.getInstance().getString(AdvPrefUtil.COOKIE);
            if (TextUtils.isEmpty(string) || string.indexOf(";") <= 0) {
                return;
            }
            httpURLConnection.setRequestProperty("Cookie", string.substring(0, string.indexOf(";")));
        }
    }
}
