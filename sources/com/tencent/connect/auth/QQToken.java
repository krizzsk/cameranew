package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g  reason: collision with root package name */
    private static SharedPreferences f8042g;
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f8043d = 1;

    /* renamed from: e  reason: collision with root package name */
    private long f8044e = -1;

    /* renamed from: f  reason: collision with root package name */
    private com.tencent.open.utils.a f8045f;

    public QQToken(String str) {
        this.a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f8042g == null) {
                f8042g = f.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f8042g;
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(l.i(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.f8043d;
    }

    public long getExpireTimeInSecond() {
        return this.f8044e;
    }

    public String getOpenId() {
        return this.c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e2) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.f8044e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f8045f == null) {
                this.f8045f = new com.tencent.open.utils.a(f.a());
            }
            return a(str, this.f8045f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f8045f == null) {
                this.f8045f = new com.tencent.open.utils.a(f.a());
            }
            return a(this.a, jSONObject, this.f8045f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login saveSession" + e2.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.f8044e = 0L;
        if (str2 != null) {
            this.f8044e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i2) {
        this.f8043d = i2;
    }

    public void setOpenId(String str) {
        this.c = str;
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b;
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = a().getString(a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        i.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String c = c(str);
                    String string2 = a().getString(c, "");
                    if (TextUtils.isEmpty(string2)) {
                        String b2 = b(str);
                        String string3 = a().getString(b2, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            b = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                a().edit().remove(b2).apply();
                                return null;
                            }
                            a(str, new JSONObject(b), aVar);
                            a().edit().remove(b2).apply();
                        } catch (Exception e2) {
                            SLog.e("QQToken", "Catch Exception", e2);
                            a().edit().remove(b2).apply();
                            return null;
                        }
                    } else {
                        try {
                            b = JniInterface.d2(string2);
                            a(str, new JSONObject(b), aVar);
                            a().edit().remove(c).apply();
                        } catch (Exception e3) {
                            SLog.e("QQToken", "Catch Exception", e3);
                            a().edit().remove(c).apply();
                            return null;
                        }
                    }
                } else {
                    b = aVar.b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(b);
                    SLog.i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e4) {
                    SLog.i("QQToken", "loadJsonPreference decode " + e4.toString());
                    return null;
                }
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (f.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a = a(str);
                        String a2 = aVar.a(jSONObject.toString());
                        if (a.length() > 6 && a2 != null) {
                            a().edit().putString(a, a2).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e2) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e2.toString());
                    return false;
                }
            } else {
                SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(l.i(str), 2) + "_aes_google";
    }
}
