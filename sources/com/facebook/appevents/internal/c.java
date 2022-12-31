package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.y;
import com.tencent.open.SocialConstants;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: AutomaticAnalyticsLogger.java */
/* loaded from: classes.dex */
public class c {
    private static final String a = "com.facebook.appevents.internal.c";
    private static final InternalAppEventsLogger b = new InternalAppEventsLogger(com.facebook.f.f());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutomaticAnalyticsLogger.java */
    /* loaded from: classes.dex */
    public static class a {
        BigDecimal a;
        Currency b;
        Bundle c;

        a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.a = bigDecimal;
            this.b = currency;
            this.c = bundle;
        }
    }

    @Nullable
    private static a a(String str, String str2) {
        return b(str, str2, new HashMap());
    }

    @Nullable
    private static a b(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString(SocialConstants.PARAM_COMMENT));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            for (String str3 : map.keySet()) {
                bundle.putCharSequence(str3, map.get(str3));
            }
            return new a(new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
        } catch (JSONException e2) {
            Log.e(a, "Error parsing in-app subscription data.", e2);
            return null;
        }
    }

    public static boolean c() {
        l j2 = FetchedAppSettingsManager.j(com.facebook.f.g());
        return j2 != null && com.facebook.f.k() && j2.g();
    }

    public static void d() {
        Context f2 = com.facebook.f.f();
        String g2 = com.facebook.f.g();
        boolean k2 = com.facebook.f.k();
        y.l(f2, "context");
        if (k2) {
            if (f2 instanceof Application) {
                AppEventsLogger.a((Application) f2, g2);
            } else {
                Log.w(a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    public static void e(String str, long j2) {
        Context f2 = com.facebook.f.f();
        String g2 = com.facebook.f.g();
        y.l(f2, "context");
        l o = FetchedAppSettingsManager.o(g2, false);
        if (o == null || !o.a() || j2 <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(f2);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence("fb_aa_time_spent_view_name", str);
        internalAppEventsLogger.f("fb_aa_time_spent_on_view", j2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(String str, String str2, boolean z) {
        a a2;
        if (c() && (a2 = a(str, str2)) != null) {
            boolean z2 = false;
            if (z && com.facebook.internal.k.f("app_events_if_auto_log_subs", com.facebook.f.g(), false)) {
                z2 = true;
            }
            if (z2) {
                b.l(h.m(str2) ? "StartTrial" : "Subscribe", a2.a, a2.b, a2.c);
            } else {
                b.m(a2.a, a2.b, a2.c);
            }
        }
    }
}
