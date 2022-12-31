package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
/* compiled from: InstallReferrerUtil.java */
/* loaded from: classes.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InstallReferrerUtil.java */
    /* loaded from: classes.dex */
    public static class a implements InstallReferrerStateListener {
        final /* synthetic */ InstallReferrerClient a;
        final /* synthetic */ b b;

        a(InstallReferrerClient installReferrerClient, b bVar) {
            this.a = installReferrerClient;
            this.b = bVar;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i2) {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (i2 != 0) {
                    if (i2 != 2) {
                        return;
                    }
                    o.a();
                    return;
                }
                try {
                    String installReferrer = this.a.getInstallReferrer().getInstallReferrer();
                    if (installReferrer != null && (installReferrer.contains("fb") || installReferrer.contains("facebook"))) {
                        this.b.a(installReferrer);
                    }
                    o.a();
                } catch (RemoteException unused) {
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: InstallReferrerUtil.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    private o() {
    }

    static /* synthetic */ void a() {
        if (com.facebook.internal.instrument.e.a.c(o.class)) {
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, o.class);
        }
    }

    private static boolean b() {
        if (com.facebook.internal.instrument.e.a.c(o.class)) {
            return false;
        }
        try {
            return com.facebook.f.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, o.class);
            return false;
        }
    }

    private static void c(b bVar) {
        if (com.facebook.internal.instrument.e.a.c(o.class)) {
            return;
        }
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(com.facebook.f.f()).build();
            try {
                build.startConnection(new a(build, bVar));
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, o.class);
        }
    }

    public static void d(b bVar) {
        if (com.facebook.internal.instrument.e.a.c(o.class)) {
            return;
        }
        try {
            if (b()) {
                return;
            }
            c(bVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, o.class);
        }
    }

    private static void e() {
        if (com.facebook.internal.instrument.e.a.c(o.class)) {
            return;
        }
        try {
            com.facebook.f.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, o.class);
        }
    }
}
