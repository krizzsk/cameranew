package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import androidx.annotation.VisibleForTesting;
import com.facebook.LoggingBehavior;
import com.facebook.internal.r;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class FacebookSDKJSInterface {
    public static final String b = "FacebookSDKJSInterface";
    private Context a;

    public FacebookSDKJSInterface(Context context) {
        this.a = context;
    }

    @VisibleForTesting
    static Bundle a(String str) {
        try {
            if (com.facebook.internal.instrument.e.a.c(FacebookSDKJSInterface.class)) {
                return null;
            }
            try {
                return b(new JSONObject(str));
            } catch (JSONException unused) {
                return new Bundle();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, FacebookSDKJSInterface.class);
            return null;
        }
    }

    private static Bundle b(JSONObject jSONObject) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(FacebookSDKJSInterface.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
            return bundle;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, FacebookSDKJSInterface.class);
            return null;
        }
    }

    @JavascriptInterface
    public String getProtocol() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        return "fbmq-0.1";
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (str == null) {
                r.g(LoggingBehavior.DEVELOPER_ERRORS, b, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
                return;
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.a);
            Bundle a = a(str3);
            a.putString("_fb_pixel_referral_id", str);
            internalAppEventsLogger.g(str2, a);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
