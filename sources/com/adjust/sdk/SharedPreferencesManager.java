package com.adjust.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class SharedPreferencesManager {
    private static final int INDEX_CLICK_TIME = 1;
    private static final int INDEX_IS_SENDING = 2;
    private static final int INDEX_RAW_REFERRER = 0;
    private static final String PREFS_KEY_DEEPLINK_CLICK_TIME = "deeplink_click_time";
    private static final String PREFS_KEY_DEEPLINK_URL = "deeplink_url";
    private static final String PREFS_KEY_DISABLE_THIRD_PARTY_SHARING = "disable_third_party_sharing";
    private static final String PREFS_KEY_GDPR_FORGET_ME = "gdpr_forget_me";
    private static final String PREFS_KEY_INSTALL_TRACKED = "install_tracked";
    private static final String PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS = "preinstall_payload_read_status";
    private static final String PREFS_KEY_PUSH_TOKEN = "push_token";
    private static final String PREFS_KEY_RAW_REFERRERS = "raw_referrers";
    private static final String PREFS_NAME = "adjust_preferences";
    private static final int REFERRERS_COUNT = 10;
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
    }

    private synchronized boolean getBoolean(String str, boolean z) {
        try {
        } catch (ClassCastException unused) {
            return z;
        }
        return this.sharedPreferences.getBoolean(str, z);
    }

    private synchronized long getLong(String str, long j2) {
        try {
        } catch (ClassCastException unused) {
            return j2;
        }
        return this.sharedPreferences.getLong(str, j2);
    }

    private synchronized int getRawReferrerIndex(String str, long j2) {
        try {
            JSONArray rawReferrerArray = getRawReferrerArray();
            for (int i2 = 0; i2 < rawReferrerArray.length(); i2++) {
                JSONArray jSONArray = rawReferrerArray.getJSONArray(i2);
                String optString = jSONArray.optString(0, null);
                if (optString != null && optString.equals(str) && jSONArray.optLong(1, -1L) == j2) {
                    return i2;
                }
            }
        } catch (JSONException unused) {
        }
        return -1;
    }

    private synchronized String getString(String str) {
        try {
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable unused2) {
            if (str.equals(PREFS_KEY_RAW_REFERRERS)) {
                remove(PREFS_KEY_RAW_REFERRERS);
            }
            return null;
        }
        return this.sharedPreferences.getString(str, null);
    }

    private synchronized void remove(String str) {
        this.sharedPreferences.edit().remove(str).apply();
    }

    private synchronized void saveBoolean(String str, boolean z) {
        this.sharedPreferences.edit().putBoolean(str, z).apply();
    }

    private synchronized void saveInteger(String str, int i2) {
        this.sharedPreferences.edit().putInt(str, i2).apply();
    }

    private synchronized void saveLong(String str, long j2) {
        this.sharedPreferences.edit().putLong(str, j2).apply();
    }

    private synchronized void saveString(String str, String str2) {
        this.sharedPreferences.edit().putString(str, str2).apply();
    }

    public synchronized void clear() {
        this.sharedPreferences.edit().clear().apply();
    }

    public synchronized long getDeeplinkClickTime() {
        return getLong(PREFS_KEY_DEEPLINK_CLICK_TIME, -1L);
    }

    public synchronized String getDeeplinkUrl() {
        return getString(PREFS_KEY_DEEPLINK_URL);
    }

    public synchronized boolean getDisableThirdPartySharing() {
        return getBoolean(PREFS_KEY_DISABLE_THIRD_PARTY_SHARING, false);
    }

    public synchronized boolean getGdprForgetMe() {
        return getBoolean(PREFS_KEY_GDPR_FORGET_ME, false);
    }

    public synchronized boolean getInstallTracked() {
        return getBoolean(PREFS_KEY_INSTALL_TRACKED, false);
    }

    public synchronized long getPreinstallPayloadReadStatus() {
        return getLong(PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS, 0L);
    }

    public synchronized String getPushToken() {
        return getString(PREFS_KEY_PUSH_TOKEN);
    }

    public synchronized JSONArray getRawReferrer(String str, long j2) {
        int rawReferrerIndex = getRawReferrerIndex(str, j2);
        if (rawReferrerIndex >= 0) {
            try {
                return getRawReferrerArray().getJSONArray(rawReferrerIndex);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public synchronized JSONArray getRawReferrerArray() {
        String string = getString(PREFS_KEY_RAW_REFERRERS);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 10) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < 10; i2++) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                    saveRawReferrerArray(jSONArray2);
                    return jSONArray2;
                }
                return new JSONArray(string);
            } catch (Throwable unused) {
            }
        }
        return new JSONArray();
    }

    public synchronized void removeDeeplink() {
        remove(PREFS_KEY_DEEPLINK_URL);
        remove(PREFS_KEY_DEEPLINK_CLICK_TIME);
    }

    public synchronized void removeDisableThirdPartySharing() {
        remove(PREFS_KEY_DISABLE_THIRD_PARTY_SHARING);
    }

    public synchronized void removeGdprForgetMe() {
        remove(PREFS_KEY_GDPR_FORGET_ME);
    }

    public synchronized void removePushToken() {
        remove(PREFS_KEY_PUSH_TOKEN);
    }

    public synchronized void removeRawReferrer(String str, long j2) {
        if (str != null) {
            if (str.length() != 0) {
                int rawReferrerIndex = getRawReferrerIndex(str, j2);
                if (rawReferrerIndex < 0) {
                    return;
                }
                JSONArray rawReferrerArray = getRawReferrerArray();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < rawReferrerArray.length(); i2++) {
                    if (i2 != rawReferrerIndex) {
                        try {
                            jSONArray.put(rawReferrerArray.getJSONArray(i2));
                        } catch (JSONException unused) {
                        }
                    }
                }
                saveString(PREFS_KEY_RAW_REFERRERS, jSONArray.toString());
            }
        }
    }

    public synchronized void saveDeeplink(Uri uri, long j2) {
        if (uri == null) {
            return;
        }
        saveString(PREFS_KEY_DEEPLINK_URL, uri.toString());
        saveLong(PREFS_KEY_DEEPLINK_CLICK_TIME, j2);
    }

    public synchronized void savePushToken(String str) {
        saveString(PREFS_KEY_PUSH_TOKEN, str);
    }

    public synchronized void saveRawReferrer(String str, long j2) {
        if (getRawReferrer(str, j2) != null) {
            return;
        }
        JSONArray rawReferrerArray = getRawReferrerArray();
        if (rawReferrerArray.length() == 10) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0, str);
        jSONArray.put(1, j2);
        jSONArray.put(2, 0);
        rawReferrerArray.put(jSONArray);
        saveRawReferrerArray(rawReferrerArray);
    }

    public synchronized void saveRawReferrerArray(JSONArray jSONArray) {
        try {
            saveString(PREFS_KEY_RAW_REFERRERS, jSONArray.toString());
        } catch (Throwable unused) {
            remove(PREFS_KEY_RAW_REFERRERS);
        }
    }

    public synchronized void setDisableThirdPartySharing() {
        saveBoolean(PREFS_KEY_DISABLE_THIRD_PARTY_SHARING, true);
    }

    public synchronized void setGdprForgetMe() {
        saveBoolean(PREFS_KEY_GDPR_FORGET_ME, true);
    }

    public synchronized void setInstallTracked() {
        saveBoolean(PREFS_KEY_INSTALL_TRACKED, true);
    }

    public synchronized void setPreinstallPayloadReadStatus(long j2) {
        saveLong(PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS, j2);
    }

    public synchronized void setSendingReferrersAsNotSent() {
        try {
            JSONArray rawReferrerArray = getRawReferrerArray();
            boolean z = false;
            for (int i2 = 0; i2 < rawReferrerArray.length(); i2++) {
                JSONArray jSONArray = rawReferrerArray.getJSONArray(i2);
                if (jSONArray.optInt(2, -1) == 1) {
                    jSONArray.put(2, 0);
                    z = true;
                }
            }
            if (z) {
                saveRawReferrerArray(rawReferrerArray);
            }
        } catch (JSONException unused) {
        }
    }
}
