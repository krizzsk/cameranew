package us.pinguo.advconfigdata.Utils;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class AdvPrefUtil {
    static final String AD_PREF = "ad_pref";
    public static final String COOKIE = "cookie";
    public static final String ENABLE_COOKIE_SITES = "enable_cookie_sites";
    private static AdvPrefUtil sInstance;
    private SharedPreferences preferences;

    private AdvPrefUtil() {
    }

    public static AdvPrefUtil getInstance() {
        if (sInstance == null) {
            sInstance = new AdvPrefUtil();
        }
        return sInstance;
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.preferences;
        return sharedPreferences == null ? "" : sharedPreferences.getString(str, "");
    }

    public void init(Context context) {
        if (this.preferences == null) {
            this.preferences = context.getSharedPreferences(AD_PREF, 0);
        }
    }

    public void putLong(String str, long j2) {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j2);
        edit.apply();
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences == null || str == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public long getLong(String str, long j2) {
        SharedPreferences sharedPreferences = this.preferences;
        return sharedPreferences == null ? j2 : sharedPreferences.getLong(str, j2);
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.preferences;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }
}
