package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.f;
import com.facebook.internal.t;
import com.facebook.login.LoginClient;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<KatanaProxyLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public KatanaProxyLoginMethodHandler[] newArray(int i2) {
            return new KatanaProxyLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String h() {
        return "katana_proxy_auth";
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean p() {
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    int q(LoginClient.Request request) {
        boolean z = f.r && com.facebook.internal.e.a() != null && request.j().allowsCustomTabAuth();
        String n = LoginClient.n();
        List<Intent> o = t.o(this.b.l(), request.a(), request.k(), n, request.m(), request.l(), request.f(), g(request.b()), request.c(), z);
        a("e2e", n);
        for (int i2 = 0; i2 < o.size(); i2++) {
            if (x(o.get(i2), LoginClient.s())) {
                return i2 + 1;
            }
        }
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
