package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.f;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new a();
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    private static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch = false;
    private String currentPackage;
    private String expectedChallenge;
    private String validRedirectURI;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CustomTabLoginMethodHandler[] newArray(int i2) {
            return new CustomTabLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.validRedirectURI = "";
        this.expectedChallenge = x.q(20);
        calledThroughLoggedOutAppSwitch = false;
        this.validRedirectURI = com.facebook.internal.e.c(E());
    }

    private String D() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        String a2 = com.facebook.internal.e.a();
        this.currentPackage = a2;
        return a2;
    }

    private String E() {
        return super.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto Lbb
            java.lang.String r0 = "fbconnect://cct."
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L14
            java.lang.String r0 = super.t()
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto Lbb
        L14:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = com.facebook.internal.x.e0(r0)
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = com.facebook.internal.x.e0(r7)
            r0.putAll(r7)
            boolean r7 = r6.G(r0)
            r1 = 0
            if (r7 != 0) goto L3d
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>(r0)
            super.B(r8, r1, r7)
            return
        L3d:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L4b
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L4b:
            java.lang.String r2 = "error_msg"
            java.lang.String r2 = r0.getString(r2)
            if (r2 != 0) goto L59
            java.lang.String r2 = "error_message"
            java.lang.String r2 = r0.getString(r2)
        L59:
            if (r2 != 0) goto L61
            java.lang.String r2 = "error_description"
            java.lang.String r2 = r0.getString(r2)
        L61:
            java.lang.String r3 = "error_code"
            java.lang.String r3 = r0.getString(r3)
            boolean r4 = com.facebook.internal.x.S(r3)
            r5 = -1
            if (r4 != 0) goto L73
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L73
            goto L74
        L73:
            r3 = -1
        L74:
            boolean r4 = com.facebook.internal.x.S(r7)
            if (r4 == 0) goto L86
            boolean r4 = com.facebook.internal.x.S(r2)
            if (r4 == 0) goto L86
            if (r3 != r5) goto L86
            super.B(r8, r0, r1)
            goto Lbb
        L86:
            if (r7 == 0) goto La1
            java.lang.String r0 = "access_denied"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L98
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto La1
        L98:
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.B(r8, r1, r7)
            goto Lbb
        La1:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r3 != r0) goto Lae
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.B(r8, r1, r7)
            goto Lbb
        Lae:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r3, r7, r2)
            com.facebook.FacebookServiceException r7 = new com.facebook.FacebookServiceException
            r7.<init>(r0, r2)
            super.B(r8, r1, r7)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.F(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    private boolean G(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String h() {
        return "custom_tab";
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean m(int i2, int i3, Intent intent) {
        if (intent == null || !intent.getBooleanExtra(CustomTabMainActivity.f2242h, false)) {
            if (i2 != 1) {
                return super.m(i2, i3, intent);
            }
            LoginClient.Request t = this.b.t();
            if (i3 == -1) {
                F(intent.getStringExtra(CustomTabMainActivity.f2240f), t);
                return true;
            }
            super.B(t, null, new FacebookOperationCanceledException());
            return false;
        }
        return super.m(i2, i3, intent);
    }

    @Override // com.facebook.login.LoginMethodHandler
    protected void n(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.expectedChallenge);
    }

    @Override // com.facebook.login.LoginMethodHandler
    int q(LoginClient.Request request) {
        if (t().isEmpty()) {
            return 0;
        }
        Bundle s = s(request);
        r(s, request);
        if (calledThroughLoggedOutAppSwitch) {
            s.putString("cct_over_app_switch", "1");
        }
        if (f.q) {
            com.facebook.login.a.b(com.facebook.internal.d.a(OAUTH_DIALOG, s));
        }
        Intent intent = new Intent(this.b.l(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.c, OAUTH_DIALOG);
        intent.putExtra(CustomTabMainActivity.f2238d, s);
        intent.putExtra(CustomTabMainActivity.f2239e, D());
        this.b.o().startActivityForResult(intent, 1);
        return 1;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String t() {
        return this.validRedirectURI;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String u() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.expectedChallenge);
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    AccessTokenSource x() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.validRedirectURI = "";
        this.expectedChallenge = parcel.readString();
    }
}
