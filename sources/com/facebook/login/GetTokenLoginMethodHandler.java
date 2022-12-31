package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.u;
import com.facebook.internal.x;
import com.facebook.login.LoginClient;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new c();
    private com.facebook.login.b getTokenClient;

    /* loaded from: classes.dex */
    class a implements u.b {
        final /* synthetic */ LoginClient.Request a;

        a(LoginClient.Request request) {
            this.a = request;
        }

        @Override // com.facebook.internal.u.b
        public void a(Bundle bundle) {
            GetTokenLoginMethodHandler.this.s(this.a, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements x.c {
        final /* synthetic */ Bundle a;
        final /* synthetic */ LoginClient.Request b;

        b(Bundle bundle, LoginClient.Request request) {
            this.a = bundle;
            this.b = request;
        }

        @Override // com.facebook.internal.x.c
        public void a(JSONObject jSONObject) {
            try {
                this.a.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID));
                GetTokenLoginMethodHandler.this.t(this.b, this.a);
            } catch (JSONException e2) {
                LoginClient loginClient = GetTokenLoginMethodHandler.this.b;
                loginClient.h(LoginClient.Result.b(loginClient.t(), "Caught exception", e2.getMessage()));
            }
        }

        @Override // com.facebook.internal.x.c
        public void b(FacebookException facebookException) {
            LoginClient loginClient = GetTokenLoginMethodHandler.this.b;
            loginClient.h(LoginClient.Result.b(loginClient.t(), "Caught exception", facebookException.getMessage()));
        }
    }

    /* loaded from: classes.dex */
    static class c implements Parcelable.Creator {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GetTokenLoginMethodHandler[] newArray(int i2) {
            return new GetTokenLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.LoginMethodHandler
    void b() {
        com.facebook.login.b bVar = this.getTokenClient;
        if (bVar != null) {
            bVar.b();
            this.getTokenClient.f(null);
            this.getTokenClient = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String h() {
        return "get_token";
    }

    @Override // com.facebook.login.LoginMethodHandler
    int q(LoginClient.Request request) {
        com.facebook.login.b bVar = new com.facebook.login.b(this.b.l(), request.a());
        this.getTokenClient = bVar;
        if (bVar.g()) {
            this.b.y();
            this.getTokenClient.f(new a(request));
            return 1;
        }
        return 0;
    }

    void r(LoginClient.Request request, Bundle bundle) {
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (string != null && !string.isEmpty()) {
            t(request, bundle);
            return;
        }
        this.b.y();
        x.z(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new b(bundle, request));
    }

    void s(LoginClient.Request request, Bundle bundle) {
        com.facebook.login.b bVar = this.getTokenClient;
        if (bVar != null) {
            bVar.f(null);
        }
        this.getTokenClient = null;
        this.b.B();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            Set<String> k2 = request.k();
            if (stringArrayList != null && (k2 == null || stringArrayList.containsAll(k2))) {
                r(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : k2) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                a("new_permissions", TextUtils.join(",", hashSet));
            }
            request.n(hashSet);
        }
        this.b.J();
    }

    void t(LoginClient.Request request, Bundle bundle) {
        this.b.j(LoginClient.Result.f(this.b.t(), LoginMethodHandler.c(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.a())));
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
