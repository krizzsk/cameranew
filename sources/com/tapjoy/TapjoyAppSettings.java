package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.jq;
/* loaded from: classes3.dex */
public class TapjoyAppSettings {
    public static final String TAG = "TapjoyAppSettings";
    private static TapjoyAppSettings b;
    String a;
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences f7259d;

    private TapjoyAppSettings(Context context) {
        this.c = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        this.f7259d = sharedPreferences;
        String string = sharedPreferences.getString(TapjoyConstants.PREF_LOG_LEVEL, null);
        this.a = string;
        if (jq.c(string)) {
            return;
        }
        String str = TAG;
        TapjoyLog.d(str, "restoreLoggingLevel from sharedPref -- loggingLevel=" + this.a);
        TapjoyLog.a(this.a, true);
    }

    public static TapjoyAppSettings getInstance() {
        return b;
    }

    public static void init(Context context) {
        TapjoyLog.d(TAG, "initializing app settings");
        b = new TapjoyAppSettings(context);
    }

    public void clearLoggingLevel() {
        SharedPreferences.Editor edit = this.f7259d.edit();
        edit.remove(TapjoyConstants.PREF_LOG_LEVEL);
        edit.apply();
        this.a = null;
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        String str = TAG;
        StringBuilder sb = new StringBuilder("Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: ");
        sb.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.i(str, sb.toString());
        TapjoyLog.setDebugEnabled(isLoggingEnabled);
    }

    public String getConnectResult(String str, long j2) {
        String string = this.f7259d.getString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, null);
        if (!jq.c(string) && !jq.c(str) && str.equals(this.f7259d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null))) {
            long j3 = this.f7259d.getLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, -1L);
            if (j3 < 0 || j3 >= j2) {
                return string;
            }
        }
        return null;
    }

    public void removeConnectResult() {
        if (this.f7259d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null) != null) {
            SharedPreferences.Editor edit = this.f7259d.edit();
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            TapjoyLog.i(TAG, "Removed connect result");
            edit.apply();
        }
    }

    public void saveConnectResultAndParams(String str, String str2, long j2) {
        if (jq.c(str) || jq.c(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f7259d.edit();
        edit.putString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, str);
        edit.putString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, str2);
        if (j2 >= 0) {
            edit.putLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, j2);
        } else {
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
        }
        TapjoyLog.i(TAG, "Stored connect result");
        edit.apply();
    }

    public void saveLoggingLevel(String str) {
        if (jq.c(str)) {
            TapjoyLog.d(TAG, "saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        String str2 = TAG;
        TapjoyLog.d(str2, "saveLoggingLevel -- currentLevel=" + this.a + ";newLevel=" + str);
        if (jq.c(this.a) || !this.a.equals(str)) {
            SharedPreferences.Editor edit = this.f7259d.edit();
            edit.putString(TapjoyConstants.PREF_LOG_LEVEL, str);
            edit.apply();
            this.a = str;
            TapjoyLog.a(str, true);
        }
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        StringBuilder sb = new StringBuilder("Tapjoy remote device debugging set to '");
        sb.append(str);
        sb.append("'. The SDK Debug-setting is: ");
        sb.append(isLoggingEnabled ? "'Enabled'" : "'Disabled'");
        TapjoyLog.i(str2, sb.toString());
    }
}
