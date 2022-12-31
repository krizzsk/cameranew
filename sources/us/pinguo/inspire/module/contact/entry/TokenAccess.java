package us.pinguo.inspire.module.contact.entry;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.e;
import us.pinguo.inspire.Inspire;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class TokenAccess {
    private static e gson = new e();
    private long expiresIn;
    private long lastSaveTime;
    private String siteCode;
    private String token;

    public TokenAccess(String str, long j2, String str2) {
        this.token = str;
        this.expiresIn = j2;
        this.siteCode = str2;
    }

    private static TokenAccess getTokenData(String str) {
        String userId = s0.getInstance().getUserId();
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        SharedPreferences c = Inspire.c();
        String string = c.getString(userId + "_" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (TokenAccess) gson.j(string, TokenAccess.class);
        } catch (Exception e2) {
            us.pinguo.foundation.e.e(e2);
            return null;
        }
    }

    public static boolean isTokenValide(String str) {
        TokenAccess tokenData = getTokenData(str);
        if (tokenData == null) {
            return false;
        }
        long j2 = tokenData.expiresIn;
        return j2 == 0 || (System.currentTimeMillis() - tokenData.lastSaveTime) / 1000 < j2;
    }

    public static void saveToken(TokenAccess tokenAccess) {
        String userId = s0.getInstance().getUserId();
        if (tokenAccess == null || TextUtils.isEmpty(userId)) {
            return;
        }
        tokenAccess.setLastSaveTime(System.currentTimeMillis());
        String t = gson.t(tokenAccess, TokenAccess.class);
        SharedPreferences.Editor edit = Inspire.c().edit();
        edit.putString(userId + "_" + tokenAccess.siteCode, t).apply();
    }

    public void setLastSaveTime(long j2) {
        this.lastSaveTime = j2;
    }
}
