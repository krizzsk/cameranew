package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.f;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private String e2e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private void C(String str) {
        this.b.l().getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).edit().putString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str).apply();
    }

    private String y() {
        return this.b.l().getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String str;
        LoginClient.Result c;
        this.e2e = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                AccessToken f2 = LoginMethodHandler.f(request.k(), bundle, x(), request.a());
                c = LoginClient.Result.f(this.b.t(), f2);
                CookieSyncManager.createInstance(this.b.l()).sync();
                C(f2.t());
            } catch (FacebookException e2) {
                c = LoginClient.Result.b(this.b.t(), null, e2.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            c = LoginClient.Result.a(this.b.t(), "User canceled log in.");
        } else {
            this.e2e = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, TimeModel.NUMBER_FORMAT, Integer.valueOf(requestError.c()));
                message = requestError.toString();
            } else {
                str = null;
            }
            c = LoginClient.Result.c(this.b.t(), null, message, str);
        }
        if (!x.S(this.e2e)) {
            k(this.e2e);
        }
        this.b.j(c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle r(Bundle bundle, LoginClient.Request request) {
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, t());
        bundle.putString("client_id", request.a());
        bundle.putString("e2e", LoginClient.n());
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "token,signed_request,graph_domain");
        bundle.putString("return_scopes", "true");
        bundle.putString("auth_type", request.c());
        bundle.putString("login_behavior", request.j().name());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", f.w()));
        if (u() != null) {
            bundle.putString("sso", u());
        }
        bundle.putString("cct_prefetching", f.q ? "1" : "0");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle s(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!x.T(request.k())) {
            String join = TextUtils.join(",", request.k());
            bundle.putString("scope", join);
            a("scope", join);
        }
        bundle.putString("default_audience", request.f().getNativeProtocolAudience());
        bundle.putString("state", g(request.b()));
        AccessToken j2 = AccessToken.j();
        String t = j2 != null ? j2.t() : null;
        if (t != null && t.equals(y())) {
            bundle.putString("access_token", t);
            a("access_token", "1");
        } else {
            x.g(this.b.l());
            a("access_token", "0");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        bundle.putString("ies", f.k() ? "1" : "0");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return "fb" + f.g() + "://authorize";
    }

    protected String u() {
        return null;
    }

    abstract AccessTokenSource x();

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
