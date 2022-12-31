package com.tapjoy.internal;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class gn {
    public static void a(Activity activity) {
        gz a = gz.a();
        if (gw.a(activity, "onActivityStart: The given activity was null")) {
            gw.c("onActivityStart");
            b.a(activity.getApplication());
            b.b(activity);
            if (a.c("onActivityStart") && a.e()) {
                gt.b(activity);
            }
        }
    }

    public static void b(Activity activity) {
        gz a = gz.a();
        if (gw.a(activity, "onActivityStop: The given activity was null")) {
            gw.c("onActivityStop");
            b.c(activity);
            if (!a.c("onActivityStop") || b.b()) {
                return;
            }
            a.f7597h.a();
        }
    }

    public static void b() {
        gz a = gz.a();
        if (a.c("endSession")) {
            a.f7597h.a();
        }
    }

    public static void a() {
        gz a = gz.a();
        if (a.c("startSession") && a.e()) {
            gt.b(null);
        }
    }

    public static void a(String str, String str2, String str3, String str4, long j2) {
        gz a = gz.a();
        if (a.d("trackEvent") && gw.a(str2, "trackEvent: name was null")) {
            LinkedHashMap linkedHashMap = null;
            if (j2 != 0) {
                linkedHashMap = ju.b();
                linkedHashMap.put(FirebaseAnalytics.Param.VALUE, Long.valueOf(j2));
            }
            a.f7596g.a(str, str2, str3, str4, linkedHashMap);
            gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, linkedHashMap);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3, String str7, long j4) {
        gz a = gz.a();
        if (a.d("trackEvent") && gw.a(str2, "trackEvent: name was null")) {
            LinkedHashMap b = ju.b();
            if (str5 != null && j2 != 0) {
                b.put(str5, Long.valueOf(j2));
            }
            if (str6 != null && j3 != 0) {
                b.put(str6, Long.valueOf(j3));
            }
            if (str7 != null && j4 != 0) {
                b.put(str7, Long.valueOf(j4));
            }
            if (b.isEmpty()) {
                b = null;
            }
            a.f7596g.a(str, str2, str3, str4, b);
            gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        gz a = gz.a();
        if (a.c("trackPurchase")) {
            try {
                e eVar = new e(str);
                String b = gu.b(eVar.a);
                String b2 = gu.b(eVar.f7393f);
                if (b != null && b2 != null) {
                    if (b2.length() != 3) {
                        gw.a("trackPurchase", "skuDetails", "invalid currency code");
                        return;
                    }
                    String b3 = gu.b(str2);
                    String b4 = gu.b(str3);
                    if (b3 != null) {
                        if (b4 != null) {
                            try {
                                f fVar = new f(b3);
                                if (jq.c(fVar.a) || jq.c(fVar.b) || jq.c(fVar.c) || fVar.f7461d == 0) {
                                    gw.a("trackPurchase", "purchaseData", "insufficient fields");
                                }
                            } catch (IOException unused) {
                                gw.a("trackPurchase", "purchaseData", "invalid PurchaseData JSON");
                            }
                        } else {
                            gw.a("trackPurchase", "dataSignature", "is null, skipping purchase validation");
                        }
                    } else if (b4 != null) {
                        gw.a("trackPurchase", "purchaseData", "is null. skipping purchase validation");
                    }
                    a.f7596g.a(b, b2.toUpperCase(Locale.US), eVar.f7394g / 1000000.0d, b3, b4, gu.b(str4));
                    if (b3 != null && b4 != null) {
                        gw.a("trackPurchase with purchaseData called");
                        return;
                    } else {
                        gw.a("trackPurchase without purchaseData called");
                        return;
                    }
                }
                gw.a("trackPurchase", "skuDetails", "insufficient fields");
            } catch (IOException unused2) {
                gw.a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            }
        }
    }
}
