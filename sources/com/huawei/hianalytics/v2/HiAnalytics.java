package com.huawei.hianalytics.v2;

import android.content.Context;
import com.huawei.hianalytics.b.b;
import com.huawei.hianalytics.v2.a.b.h;
import com.huawei.hianalytics.v2.a.b.i;
import com.huawei.hianalytics.v2.a.b.j;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public abstract class HiAnalytics {
    public static void checkCollectURL(int i2, String str, String str2) {
        b.b("HiAnalytics", "HiAnalytics.checkCollectURL(int type, String tag, String collectUR) is execute.");
        h.a(i2, str, str2);
    }

    public static void clearCachedData() {
        b.b("HiAnalytics", "HiAnalytics.clearCachedData() is execute.");
        h.e();
    }

    public static boolean getInitFlag() {
        b.b("HiAnalytics", "HiAnalytics.getInitFlag is execute.");
        return h.b();
    }

    public static void handleV1Cache() {
        b.b("HiAnalytics", "HiAnalytics.handleV1Cache execute.");
        j.a();
    }

    public static void onEvent(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.");
        i.a(i2, str, linkedHashMap);
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        b.b("HiAnalytics", "HiAnalytics.onEvent(Context context, String eventId, String value) is execute.");
        i.a(context, str, str2);
    }

    public static void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onEvent(String eventId, Map<String, String> mapValue) is execute.");
        i.a(0, str, linkedHashMap);
    }

    public static void onPause(Context context) {
        b.b("HiAnalytics", "HiAnalytics.onPause(Context context) is execute.");
        i.b(context);
    }

    public static void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onPause(context,map) is execute.");
        i.a(context, linkedHashMap);
    }

    public static void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onPause(viewName,map) is execute.");
        i.a(str, linkedHashMap);
    }

    public static void onReport() {
        b.b("HiAnalytics", "HiAnalytics.onReport() is execute.");
        i.a();
    }

    @Deprecated
    public static void onReport(Context context) {
        b.b("HiAnalytics", "HiAnalytics.onReport(Context context) is execute.");
        i.a(context);
    }

    public static void onResume(Context context) {
        b.b("HiAnalytics", "HiAnalytics.onResume(Context context) is execute.");
        i.c(context);
    }

    public static void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onResume(context,map) is execute.");
        i.b(context, linkedHashMap);
    }

    public static void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        b.b("HiAnalytics", "HiAnalytics.onResume(viewname,map) is execute.");
        i.b(str, linkedHashMap);
    }

    public static void setIsOaidTracking(boolean z) {
        b.b("HiAnalytics", "setOaidTracking(boolean) is execute");
        h.a(z);
    }

    public static void setOAID(String str) {
        b.b("HiAnalytics", "HiAnalytics.setOAID(oaid) is execute.");
        h.a(str);
    }

    public static void setUPID(String str) {
        b.b("HiAnalytics", "HiAnalytics.setUPID(String upid) is execute.");
        h.b(str);
    }
}
