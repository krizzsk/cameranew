package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String r(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    private String s(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString("error_description") : string;
    }

    private LoginClient.Result t(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String r = r(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        if ("CONNECTION_FAILURE".equals(obj)) {
            return LoginClient.Result.c(request, r, s(extras), obj);
        }
        return LoginClient.Result.a(request, r);
    }

    private LoginClient.Result u(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String r = r(extras);
        String obj = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        String s = s(extras);
        String string = extras.getString("e2e");
        if (!x.S(string)) {
            k(string);
        }
        if (r == null && obj == null && s == null) {
            try {
                return LoginClient.Result.f(request, LoginMethodHandler.f(request.k(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.a()));
            } catch (FacebookException e2) {
                return LoginClient.Result.b(request, null, e2.getMessage());
            }
        } else if (r.equals("logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            return null;
        } else if (w.b.contains(r)) {
            return null;
        } else {
            if (w.c.contains(r)) {
                return LoginClient.Result.a(request, null);
            }
            return LoginClient.Result.c(request, r, s, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean m(int i2, int i3, Intent intent) {
        LoginClient.Result u;
        LoginClient.Request t = this.b.t();
        if (intent == null) {
            u = LoginClient.Result.a(t, "Operation canceled");
        } else if (i3 == 0) {
            u = t(t, intent);
        } else if (i3 != -1) {
            u = LoginClient.Result.b(t, "Unexpected resultCode from authorization.", null);
        } else {
            u = u(t, intent);
        }
        if (u != null) {
            this.b.j(u);
            return true;
        }
        this.b.J();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(Intent intent, int i2) {
        if (intent == null) {
            return false;
        }
        try {
            this.b.o().startActivityForResult(intent, i2);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
