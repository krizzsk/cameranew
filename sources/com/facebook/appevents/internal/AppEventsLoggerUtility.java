package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.r;
import com.facebook.internal.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> a = new HashMap<GraphAPIActivityType, String>() { // from class: com.facebook.appevents.internal.AppEventsLoggerUtility.1
        {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    };

    /* loaded from: classes.dex */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject a(GraphAPIActivityType graphAPIActivityType, com.facebook.internal.b bVar, String str, boolean z, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", a.get(graphAPIActivityType));
        String e2 = AppEventsLogger.e();
        if (e2 != null) {
            jSONObject.put("app_user_id", e2);
        }
        x.s0(jSONObject, bVar, str, z);
        try {
            x.t0(jSONObject, context);
        } catch (Exception e3) {
            r.h(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e3.toString());
        }
        JSONObject x = x.x();
        if (x != null) {
            Iterator<String> keys = x.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, x.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
