package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new a();
    private static ScheduledThreadPoolExecutor backgroundExecutor;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DeviceAuthMethodHandler[] newArray(int i2) {
            return new DeviceAuthMethodHandler[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    public static synchronized ScheduledThreadPoolExecutor s() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
        }
        return scheduledThreadPoolExecutor;
    }

    private void y(LoginClient.Request request) {
        FragmentActivity l2 = this.b.l();
        if (l2 == null || l2.isFinishing()) {
            return;
        }
        DeviceAuthDialog r = r();
        FragmentManager supportFragmentManager = l2.getSupportFragmentManager();
        r.show(supportFragmentManager, "login_with_facebook");
        VdsAgent.showDialogFragment(r, supportFragmentManager, "login_with_facebook");
        r.y0(request);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String h() {
        return "device_auth";
    }

    @Override // com.facebook.login.LoginMethodHandler
    int q(LoginClient.Request request) {
        y(request);
        return 1;
    }

    protected DeviceAuthDialog r() {
        return new DeviceAuthDialog();
    }

    public void t() {
        this.b.j(LoginClient.Result.a(this.b.t(), "User canceled log in."));
    }

    public void u(Exception exc) {
        this.b.j(LoginClient.Result.b(this.b.t(), null, exc.getMessage()));
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public void x(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        this.b.j(LoginClient.Result.f(this.b.t(), new AccessToken(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3)));
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
