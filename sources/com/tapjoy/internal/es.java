package com.tapjoy.internal;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class es extends er {
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f7419d = "";

    /* renamed from: e  reason: collision with root package name */
    private TJCurrency f7420e = null;

    /* renamed from: f  reason: collision with root package name */
    private TapjoyCache f7421f = null;

    @Override // com.tapjoy.internal.er
    public final TJPlacement b(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.b(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.er
    public final String b() {
        return "12.6.1";
    }

    @Override // com.tapjoy.internal.er
    public final float c() {
        if (l("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    @Override // com.tapjoy.internal.er
    public final void d() {
        if (l("startSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fl.a();
            }
            TapjoyConnectCore.getInstance().appResume();
            gn.a();
        }
    }

    @Override // com.tapjoy.internal.er
    public final void e(String str) {
        if (k("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    @Override // com.tapjoy.internal.er
    public final Set f() {
        return gz.a().c();
    }

    @Override // com.tapjoy.internal.er
    public final void g() {
        gz.a().a((Set) null);
    }

    @Override // com.tapjoy.internal.er
    public final boolean h() {
        gz a = gz.a();
        if (a.d("isPushNotificationDisabled")) {
            boolean f2 = a.f7595f.f();
            gw.a("isPushNotificationDisabled = {}", Boolean.valueOf(f2));
            return f2;
        }
        return false;
    }

    @Override // com.tapjoy.internal.er
    public final boolean i() {
        return this.a;
    }

    @Override // com.tapjoy.internal.er
    public final void j(String str) {
        TapjoyConnectCore.setCustomParameter(str);
    }

    @Override // com.tapjoy.internal.er
    public final String k() {
        return TapjoyConnectCore.getUserToken();
    }

    @Override // com.tapjoy.internal.er
    public final String l() {
        return TapjoyConnectCore.getCustomParameter();
    }

    @Override // com.tapjoy.internal.er
    public final TJPrivacyPolicy m() {
        return TJPrivacyPolicy.getInstance();
    }

    private boolean k(String str) {
        if (this.a) {
            return true;
        }
        TapjoyLog.w("TapjoyAPI", "Can not call " + str + " because Tapjoy SDK has not successfully connected.");
        return false;
    }

    private boolean l(String str) {
        if (this.c) {
            return true;
        }
        String str2 = "Can not call " + str + " because Tapjoy SDK is not initialized.";
        this.f7419d = str2;
        TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, str2));
        return false;
    }

    @Override // com.tapjoy.internal.er
    public final void b(String str, String str2, String str3, String str4) {
        gn.a(str, str2, str3, str4, 0L);
    }

    @Override // com.tapjoy.internal.er
    public final void f(String str) {
        gz a = gz.a();
        gw.a("setGcmSender({}) called", str);
        a.f7593d = jq.a(str);
        a.b();
    }

    @Override // com.tapjoy.internal.er
    public final String g(String str) {
        if (k("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    @Override // com.tapjoy.internal.er
    public final void i(String str) {
        gz.a().a(str);
    }

    @Override // com.tapjoy.internal.er
    public final boolean j() {
        return this.b;
    }

    @Override // com.tapjoy.internal.er
    public final void a(boolean z) {
        TapjoyLog.setDebugEnabled(z);
    }

    @Override // com.tapjoy.internal.er
    public final void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fl.a();
        }
        gz.a().n = true;
        gn.a(activity);
    }

    @Override // com.tapjoy.internal.er
    public final void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fl.a();
        }
        gn.b(activity);
    }

    @Override // com.tapjoy.internal.er
    public final void e() {
        if (l("endSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fl.a();
            }
            gz.a().n = false;
            TapjoyConnectCore.getInstance().appPause();
            gn.b();
        }
    }

    @Override // com.tapjoy.internal.er
    public final boolean a(Context context, String str) {
        return a(context, str, (Hashtable) null, (TJConnectListener) null);
    }

    @Override // com.tapjoy.internal.er
    public synchronized boolean a(final Context context, String str, Hashtable hashtable, final TJConnectListener tJConnectListener) {
        String valueOf;
        if (hashtable != null) {
            Object obj = hashtable.get(TapjoyConnectFlag.ENABLE_LOGGING);
            if (obj != null) {
                TapjoyLog.setDebugEnabled("true".equals(obj.toString()));
            }
        }
        TapjoyConnectCore.setSDKType("event");
        boolean z = false;
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (jq.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            FiveRocksIntegration.a();
            try {
                TapjoyAppSettings.init(context);
                TapjoyConnectCore.requestTapjoyConnect(context, str, hashtable, new TJConnectListener() { // from class: com.tapjoy.internal.es.1
                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectFailure();
                        }
                    }

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectSuccess() {
                        es.this.f7420e = new TJCurrency(context);
                        es.this.f7421f = new TapjoyCache(context);
                        try {
                            TJEventOptimizer.init(context);
                            es.this.a = true;
                            TJConnectListener tJConnectListener2 = tJConnectListener;
                            if (tJConnectListener2 != null) {
                                tJConnectListener2.onConnectSuccess();
                            }
                        } catch (InterruptedException unused) {
                            onConnectFailure();
                        } catch (RuntimeException e2) {
                            TapjoyLog.w("TapjoyAPI", e2.getMessage());
                            onConnectFailure();
                        }
                    }
                });
                this.c = true;
                if (Build.VERSION.SDK_INT < 14) {
                    TapjoyLog.i("TapjoyAPI", "Automatic session tracking is not available on this device.");
                } else {
                    if (hashtable != null && (valueOf = String.valueOf(hashtable.get(TapjoyConnectFlag.DISABLE_AUTOMATIC_SESSION_TRACKING))) != null && valueOf.equalsIgnoreCase("true")) {
                        z = true;
                    }
                    if (!z) {
                        fl.a(context);
                    } else {
                        TapjoyLog.i("TapjoyAPI", "Automatic session tracking is disabled.");
                    }
                }
                return true;
            } catch (TapjoyIntegrationException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e3) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void h(String str) {
        ge.a().a(str);
    }

    @Override // com.tapjoy.internal.er
    public final void c(String str) {
        if (jq.c(str)) {
            return;
        }
        gz a = gz.a();
        Set c = a.c();
        if (c.add(str)) {
            a.a(c);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void d(String str) {
        if (jq.c(str)) {
            return;
        }
        gz a = gz.a();
        Set c = a.c();
        if (c.remove(str)) {
            a.a(c);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void b(boolean z) {
        String str;
        Object[] objArr;
        String b;
        gz a = gz.a();
        if (a.d("setPushNotificationDisabled")) {
            boolean a2 = a.f7595f.a(z);
            char c = 0;
            String str2 = "setPushNotificationDisabled({}) called, but it is already {}";
            if (a2) {
                objArr = new Object[1];
                str = Boolean.valueOf(z);
                str2 = "setPushNotificationDisabled({}) called";
            } else {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(z);
                str = z ? "disabled" : TJAdUnitConstants.String.ENABLED;
                objArr = objArr2;
                c = 1;
            }
            objArr[c] = str;
            gw.a(str2, objArr);
            if (a2 && a.f7600k && !jq.c(a.f7593d)) {
                if (a.o != null) {
                    b = null;
                } else {
                    hb b2 = hb.b(a.f7594e);
                    b = jq.b(b2.b.b(b2.a));
                }
                a.a(b);
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void c(boolean z) {
        ge.a().a(z);
    }

    @Override // com.tapjoy.internal.er
    public final void d(boolean z) {
        ge.a().b(z);
    }

    @Override // com.tapjoy.internal.er
    public final void b(int i2) {
        gz a = gz.a();
        if (a.d("setUserFriendCount")) {
            gw.a("setUserFriendCount({}) called", Integer.valueOf(i2));
            a.f7595f.b(i2 >= 0 ? Integer.valueOf(i2) : null);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void b(String str) {
        gz a = gz.a();
        if (a.d("setAppDataVersion")) {
            a.f7595f.a(gu.a(str));
        }
    }

    @Override // com.tapjoy.internal.er
    public final synchronized boolean a(final Context context, String str, final TJConnectListener tJConnectListener) {
        TapjoyConnectCore.setSDKType("event");
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (jq.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The limited SDK key is NULL. A valid limited SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            try {
                TapjoyConnectCore.requestLimitedTapjoyConnect(context, str, new TJConnectListener() { // from class: com.tapjoy.internal.es.2
                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectFailure();
                        }
                    }

                    @Override // com.tapjoy.TJConnectListener
                    public final void onConnectSuccess() {
                        es.this.f7421f = new TapjoyCache(context);
                        es.this.b = true;
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectSuccess();
                        }
                    }
                });
                return true;
            } catch (TapjoyIntegrationException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e3) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e3.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final TJPlacement a(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.a(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(Activity activity) {
        if (activity != null) {
            b.a(activity);
        } else {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(float f2) {
        if (l("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f2);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.f7420e == null || !k("getCurrencyBalance")) {
            return;
        }
        this.f7420e.getCurrencyBalance(tJGetCurrencyBalanceListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.f7420e == null || !k("spendCurrency")) {
            return;
        }
        this.f7420e.spendCurrency(i2, tJSpendCurrencyListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.f7420e == null || !k("awardCurrency")) {
            return;
        }
        this.f7420e.awardCurrency(i2, tJAwardCurrencyListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.f7420e == null || !k("setEarnedCurrencyListener")) {
            return;
        }
        this.f7420e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
    }

    @Override // com.tapjoy.internal.er
    public final void a(TJVideoListener tJVideoListener) {
        if (l("setVideoListener")) {
            TJAdUnit.a = tJVideoListener;
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4) {
        gn.a(str, str2, str3, str4);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2) {
        gn.a(str, null, null, str2);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str) {
        gn.a(null, str, null, null, 0L);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, long j2) {
        gn.a(null, str, null, null, j2);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, long j2) {
        gn.a(str, str2, null, null, j2);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, long j2) {
        gn.a(str, str2, str3, str4, j2);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j2) {
        gn.a(str, str2, str3, str4, str5, j2, null, 0L, null, 0L);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3) {
        gn.a(str, str2, str3, str4, str5, j2, str6, j3, null, 0L);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3, String str7, long j4) {
        gn.a(str, str2, str3, str4, str5, j2, str6, j3, str7, j4);
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, TJSetUserIDListener tJSetUserIDListener) {
        if (!l("setUserID")) {
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDFailure(this.f7419d);
                return;
            }
            return;
        }
        TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
        gz a = gz.a();
        if (a.d("setUserId")) {
            a.f7595f.b(gu.a(str));
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(Set set) {
        gz.a().a(set);
    }

    @Override // com.tapjoy.internal.er
    public final void a(Context context, Map map) {
        gz a = gz.a();
        if (a.f7594e == null) {
            a.b(context);
        }
        hb.b(a.f7594e);
        Context context2 = a.f7594e;
        String str = (String) map.get("fiverocks");
        if (str != null) {
            if (hc.a(context2).f()) {
                gz.a(context2).b(str);
                return;
            }
            String str2 = (String) map.get("title");
            String str3 = (String) map.get("message");
            if (str3 != null) {
                String str4 = (String) map.get("rich");
                String str5 = (String) map.get("sound");
                String str6 = (String) map.get("payload");
                String str7 = (String) map.get("always");
                boolean z = "true".equals(str7) || Boolean.TRUE.equals(str7);
                String str8 = (String) map.get("repeatable");
                boolean z2 = "true".equals(str8) || Boolean.TRUE.equals(str8);
                String str9 = (String) map.get("placement");
                int b = hb.b(map.get("nid"));
                String str10 = (String) map.get("channel_id");
                if (z || !gz.a(context2).d()) {
                    Notification a2 = hb.a(context2, str, jq.a(str2), str3, hb.a((Object) str4), hb.a((Object) str5), str6, str9, b, str10);
                    if (gz.a(context2).a(context2, str, z2)) {
                        hb.a(context2, b, a2);
                    }
                }
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, double d2, String str3) {
        String a;
        String a2;
        gz a3 = gz.a();
        if (!a3.c("trackPurchase") || (a = gu.a(str, "trackPurchase", "productId")) == null || (a2 = gu.a(str2, "trackPurchase", "currencyCode")) == null) {
            return;
        }
        if (a2.length() != 3) {
            gw.a("trackPurchase", "currencyCode", "invalid currency code");
            return;
        }
        a3.f7596g.a(a, a2.toUpperCase(Locale.US), d2, (String) null, (String) null, gu.b(str3));
        gw.a("trackPurchase called");
    }

    @Override // com.tapjoy.internal.er
    public final void a(String str, String str2, String str3, String str4, Map map) {
        gz a = gz.a();
        if (!a.c("trackEvent") || jq.c(str2)) {
            return;
        }
        LinkedHashMap b = ju.b();
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                if (key == null) {
                    if (gw.a) {
                        x.a("Tapjoy", "{}: {} must not be null", "trackEvent", "key in values map");
                        return;
                    }
                    return;
                } else if (key instanceof String) {
                    String a2 = gu.a((String) key, "trackEvent", "key in values map");
                    if (a2 == null) {
                        return;
                    }
                    Object value = entry.getValue();
                    if (value instanceof Number) {
                        b.put(a2, Long.valueOf(((Number) value).longValue()));
                    } else {
                        gw.a("trackEvent", "value in values map", "must be a long");
                        return;
                    }
                }
            }
        }
        a.f7596g.a(str, str2, str3, str4, b);
        gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i2) {
        gz a = gz.a();
        if (a.d("setUserLevel")) {
            gw.a("setUserLevel({}) called", Integer.valueOf(i2));
            a.f7595f.a(i2 >= 0 ? Integer.valueOf(i2) : null);
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(int i2, String str) {
        gz a = gz.a();
        if (a.d("setUserCohortVariable")) {
            boolean z = i2 > 0 && i2 <= 5;
            if (gw.a && !z) {
                gw.b("setCohortVariable: variableIndex is out of range");
            }
            if (z) {
                gw.a("setUserCohortVariable({}, {}) called", Integer.valueOf(i2), str);
                a.f7595f.a(i2, gu.a(str));
            }
        }
    }

    @Override // com.tapjoy.internal.er
    public final void a(GLSurfaceView gLSurfaceView) {
        gz.a();
        gz.a(gLSurfaceView);
    }
}
