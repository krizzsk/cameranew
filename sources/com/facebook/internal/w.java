package com.facebook.internal;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.tapjoy.TapjoyConstants;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ServerProtocol.java */
/* loaded from: classes.dex */
public final class w {
    private static final String a = "com.facebook.internal.w";
    public static final Collection<String> b = x.y0("service_disabled", "AndroidAuthKillSwitchException");
    public static final Collection<String> c = x.y0("access_denied", "OAuthAccessDeniedException");

    public static final String a() {
        return "v8.0";
    }

    public static final String b() {
        return String.format("m.%s", com.facebook.f.q());
    }

    public static final String c() {
        return String.format("https://graph.%s", com.facebook.f.s());
    }

    public static final String d() {
        return String.format("https://graph-video.%s", com.facebook.f.s());
    }

    public static Bundle e(String str, int i2, Bundle bundle) {
        String i3 = com.facebook.f.i(com.facebook.f.f());
        if (x.S(i3)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", i3);
        bundle2.putString(TapjoyConstants.TJC_APP_ID, com.facebook.f.g());
        bundle2.putInt("version", i2);
        bundle2.putString("display", "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            JSONObject b2 = c.b(bundle3);
            JSONObject b3 = c.b(bundle);
            if (b2 != null && b3 != null) {
                bundle2.putString("bridge_args", b2.toString());
                bundle2.putString("method_args", b3.toString());
                return bundle2;
            }
            return null;
        } catch (IllegalArgumentException | JSONException e2) {
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str2 = a;
            r.e(loggingBehavior, 6, str2, "Error creating Url -- " + e2);
            return null;
        }
    }
}
