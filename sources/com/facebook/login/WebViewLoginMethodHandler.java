package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.WebDialog;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new b();
    private String e2e;
    private WebDialog loginDialog;

    /* loaded from: classes.dex */
    class a implements WebDialog.g {
        final /* synthetic */ LoginClient.Request a;

        a(LoginClient.Request request) {
            this.a = request;
        }

        @Override // com.facebook.internal.WebDialog.g
        public void a(Bundle bundle, FacebookException facebookException) {
            WebViewLoginMethodHandler.this.D(this.a, bundle, facebookException);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Parcelable.Creator<WebViewLoginMethodHandler> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WebViewLoginMethodHandler[] newArray(int i2) {
            return new WebViewLoginMethodHandler[i2];
        }
    }

    /* loaded from: classes.dex */
    static class c extends WebDialog.d {

        /* renamed from: h  reason: collision with root package name */
        private String f3126h;

        /* renamed from: i  reason: collision with root package name */
        private String f3127i;

        /* renamed from: j  reason: collision with root package name */
        private String f3128j;

        /* renamed from: k  reason: collision with root package name */
        private LoginBehavior f3129k;

        public c(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            this.f3128j = "fbconnect://success";
            this.f3129k = LoginBehavior.NATIVE_WITH_FALLBACK;
        }

        @Override // com.facebook.internal.WebDialog.d
        public WebDialog a() {
            Bundle f2 = f();
            f2.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f3128j);
            f2.putString("client_id", c());
            f2.putString("e2e", this.f3126h);
            f2.putString(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "token,signed_request,graph_domain");
            f2.putString("return_scopes", "true");
            f2.putString("auth_type", this.f3127i);
            f2.putString("login_behavior", this.f3129k.name());
            return WebDialog.q(d(), "oauth", f2, g(), e());
        }

        public c i(String str) {
            this.f3127i = str;
            return this;
        }

        public c j(String str) {
            this.f3126h = str;
            return this;
        }

        public c k(boolean z) {
            this.f3128j = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        public c l(LoginBehavior loginBehavior) {
            this.f3129k = loginBehavior;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    void D(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.B(request, bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public void b() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            webDialog.cancel();
            this.loginDialog = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String h() {
        return "web_view";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public int q(LoginClient.Request request) {
        Bundle s = s(request);
        a aVar = new a(request);
        String n = LoginClient.n();
        this.e2e = n;
        a("e2e", n);
        FragmentActivity l2 = this.b.l();
        boolean N = x.N(l2);
        c cVar = new c(l2, request.a(), s);
        cVar.j(this.e2e);
        cVar.k(N);
        cVar.i(request.c());
        cVar.l(request.j());
        cVar.h(aVar);
        this.loginDialog = cVar.a();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.e0(this.loginDialog);
        FragmentManager supportFragmentManager = l2.getSupportFragmentManager();
        facebookDialogFragment.show(supportFragmentManager, "FacebookDialogFragment");
        VdsAgent.showDialogFragment(facebookDialogFragment, supportFragmentManager, "FacebookDialogFragment");
        return 1;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.e2e);
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    AccessTokenSource x() {
        return AccessTokenSource.WEB_VIEW;
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }
}
