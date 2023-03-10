package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Oauth2AccessToken {
    protected static final String KEY_ACCESS_TOKEN = "access_token";
    protected static final String KEY_EXPIRES_IN = "expires_in";
    protected static final String KEY_REFRESH_TOKEN = "refresh_token";
    protected static final String KEY_SCREEN_NAME = "userName";
    protected static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mRefreshToken;
    private String mScreenName;
    private String mUid;

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle != null) {
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(bundle.getString(KEY_UID));
            oauth2AccessToken.setScreenName(bundle.getString(KEY_SCREEN_NAME));
            oauth2AccessToken.setAccessToken(bundle.getString("access_token"));
            oauth2AccessToken.setRefreshToken(bundle.getString(KEY_REFRESH_TOKEN));
            oauth2AccessToken.setExpiresTime(Long.parseLong(bundle.getString("expires_in")) * 1000);
            return oauth2AccessToken;
        }
        return null;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScreenName() {
        return this.mScreenName;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken) && this.mExpiresTime > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExpiresTime(long j2) {
        this.mExpiresTime = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setScreenName(String str) {
        this.mScreenName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUid(String str) {
        this.mUid = str;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString(KEY_UID));
            oauth2AccessToken.setScreenName(jSONObject.optString(KEY_SCREEN_NAME));
            oauth2AccessToken.setAccessToken(jSONObject.optString("access_token"));
            oauth2AccessToken.setExpiresTime(Long.parseLong(jSONObject.getString("expires_in")) * 1000);
            oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            return oauth2AccessToken;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
