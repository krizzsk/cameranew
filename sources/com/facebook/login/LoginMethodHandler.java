package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class LoginMethodHandler implements Parcelable {
    Map<String, String> a;
    protected LoginClient b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginMethodHandler(LoginClient loginClient) {
        this.b = loginClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AccessToken c(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Date u = x.u(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date u2 = x.u(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
        if (x.S(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, null, accessTokenSource, u, new Date(), u2, bundle.getString("graph_domain"));
    }

    public static AccessToken f(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Date u = x.u(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date u2 = x.u(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
        String string2 = bundle.getString("granted_scopes");
        ArrayList arrayList = !x.S(string2) ? new ArrayList(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !x.S(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        String string4 = bundle.getString("expired_scopes");
        ArrayList arrayList3 = !x.S(string4) ? new ArrayList(Arrays.asList(string4.split(","))) : null;
        if (x.S(string)) {
            return null;
        }
        return new AccessToken(string, str, j(bundle.getString("signed_request")), arrayList, arrayList2, arrayList3, accessTokenSource, u, new Date(), u2, bundle.getString("graph_domain"));
    }

    static String j(String str) throws FacebookException {
        if (str != null && !str.isEmpty()) {
            try {
                String[] split = str.split("\\.");
                if (split.length == 2) {
                    return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString(AccessToken.USER_ID_KEY);
                }
            } catch (UnsupportedEncodingException | JSONException unused) {
            }
            throw new FacebookException("Failed to retrieve user_id from signed_request");
        }
        throw new FacebookException("Authorization response does not contain the signed_request");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj == null ? null : obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", h());
            n(jSONObject);
        } catch (JSONException e2) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String h();

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(String str) {
        String a = this.b.t().a();
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.b.l(), a);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString(TapjoyConstants.TJC_APP_ID, a);
        internalAppEventsLogger.k("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(int i2, int i3, Intent intent) {
        return false;
    }

    void n(JSONObject jSONObject) throws JSONException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(LoginClient loginClient) {
        if (this.b == null) {
            this.b = loginClient;
            return;
        }
        throw new FacebookException("Can't set LoginClient if it is already set.");
    }

    public boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int q(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        x.z0(parcel, this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginMethodHandler(Parcel parcel) {
        this.a = x.j0(parcel);
    }
}
