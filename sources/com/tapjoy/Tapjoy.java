package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.er;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class Tapjoy {
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static void actionComplete(String str) {
        er.a().e(str);
    }

    public static void addUserTag(String str) {
        er.a().c(str);
    }

    public static void awardCurrency(int i2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        er.a().a(i2, tJAwardCurrencyListener);
    }

    @Deprecated
    public static void belowConsentAge(boolean z) {
        er.a().d(z);
    }

    public static void clearUserTags() {
        er.a().g();
    }

    public static boolean connect(Context context, String str) {
        return er.a().a(context, str);
    }

    public static void endSession() {
        er.a().e();
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        er.a().a(tJGetCurrencyBalanceListener);
    }

    @Deprecated
    public static float getCurrencyMultiplier() {
        return er.a().c();
    }

    public static String getCustomParameter() {
        return er.a().l();
    }

    public static TJPlacement getLimitedPlacement(String str, TJPlacementListener tJPlacementListener) {
        return er.a().b(str, tJPlacementListener);
    }

    public static TJPlacement getPlacement(String str, TJPlacementListener tJPlacementListener) {
        return er.a().a(str, tJPlacementListener);
    }

    public static TJPrivacyPolicy getPrivacyPolicy() {
        return er.a().m();
    }

    public static String getSupportURL() {
        return er.a().g(null);
    }

    public static Set getUserTags() {
        return er.a().f();
    }

    public static String getUserToken() {
        return er.a().k();
    }

    public static String getVersion() {
        return er.a().b();
    }

    public static boolean isConnected() {
        return er.a().i();
    }

    public static boolean isLimitedConnected() {
        return er.a().j();
    }

    public static boolean isPushNotificationDisabled() {
        return er.a().h();
    }

    public static synchronized boolean limitedConnect(Context context, String str, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = er.a().a(context, str, tJConnectListener);
        }
        return a;
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary("tapjoy");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void onActivityStart(Activity activity) {
        er.a().b(activity);
    }

    public static void onActivityStop(Activity activity) {
        er.a().c(activity);
    }

    public static void removeUserTag(String str) {
        er.a().d(str);
    }

    public static void setActivity(Activity activity) {
        er.a().a(activity);
    }

    public static void setAppDataVersion(String str) {
        er.a().b(str);
    }

    @Deprecated
    public static void setCurrencyMultiplier(float f2) {
        er.a().a(f2);
    }

    public static void setCustomParameter(String str) {
        er.a().j(str);
    }

    public static void setDebugEnabled(boolean z) {
        er.a().a(z);
    }

    public static void setDeviceToken(String str) {
        er.a().i(str);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        er.a().a(tJEarnedCurrencyListener);
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        er.a().a(gLSurfaceView);
    }

    public static void setGcmSender(String str) {
        er.a().f(str);
    }

    public static void setPushNotificationDisabled(boolean z) {
        er.a().b(z);
    }

    public static void setReceiveRemoteNotification(Context context, Map map) {
        er.a().a(context, map);
    }

    public static void setUserCohortVariable(int i2, String str) {
        er.a().a(i2, str);
    }

    @Deprecated
    public static void setUserConsent(String str) {
        er.a().h(str);
    }

    public static void setUserFriendCount(int i2) {
        er.a().b(i2);
    }

    public static void setUserID(String str) {
        setUserID(str, null);
    }

    public static void setUserLevel(int i2) {
        er.a().a(i2);
    }

    public static void setUserTags(Set set) {
        er.a().a(set);
    }

    public static void setVideoListener(TJVideoListener tJVideoListener) {
        er.a().a(tJVideoListener);
    }

    public static void spendCurrency(int i2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        er.a().a(i2, tJSpendCurrencyListener);
    }

    public static void startSession() {
        er.a().d();
    }

    @Deprecated
    public static void subjectToGDPR(boolean z) {
        er.a().c(z);
    }

    public static void trackEvent(String str) {
        er.a().a(str);
    }

    public static void trackPurchase(String str, String str2, double d2, String str3) {
        er.a().a(str, str2, d2, str3);
    }

    public static boolean connect(Context context, String str, Hashtable hashtable) {
        return er.a().a(context, str, hashtable, (TJConnectListener) null);
    }

    public static String getSupportURL(String str) {
        return er.a().g(str);
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        er.a().a(str, tJSetUserIDListener);
    }

    public static void trackEvent(String str, long j2) {
        er.a().a(str, j2);
    }

    public static void trackPurchase(String str, String str2, String str3, String str4) {
        er.a().a(str, str2, str3, str4);
    }

    public static synchronized boolean connect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = er.a().a(context, str, hashtable, tJConnectListener);
        }
        return a;
    }

    public static void trackEvent(String str, String str2, long j2) {
        er.a().a(str, str2, j2);
    }

    @Deprecated
    public static void trackPurchase(String str, String str2) {
        er.a().a(str, str2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4) {
        er.a().b(str, str2, str3, str4);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, long j2) {
        er.a().a(str, str2, str3, str4, j2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j2) {
        er.a().a(str, str2, str3, str4, str5, j2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3) {
        er.a().a(str, str2, str3, str4, str5, j2, str6, j3);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3, String str7, long j4) {
        er.a().a(str, str2, str3, str4, str5, j2, str6, j3, str7, j4);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, Map map) {
        er.a().a(str, str2, str3, str4, map);
    }
}
