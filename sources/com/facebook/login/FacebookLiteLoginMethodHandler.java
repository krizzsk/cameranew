package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.t;
import com.facebook.login.LoginClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<FacebookLiteLoginMethodHandler> CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<FacebookLiteLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
            return new FacebookLiteLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FacebookLiteLoginMethodHandler[] newArray(int i2) {
            return new FacebookLiteLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String h() {
        return "fb_lite_login";
    }

    @Override // com.facebook.login.LoginMethodHandler
    int q(LoginClient.Request request) {
        String n = LoginClient.n();
        Intent j2 = t.j(this.b.l(), request.a(), request.k(), n, request.m(), request.l(), request.f(), g(request.b()), request.c());
        a("e2e", n);
        return x(j2, LoginClient.s()) ? 1 : 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
