package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.MainThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
@TargetApi(14)
@MainThread
/* loaded from: classes2.dex */
public final class q6 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ r6 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q6(r6 r6Var, c6 c6Var) {
        this.a = r6Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        o4 o4Var;
        try {
            try {
                this.a.a.a().u().a("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    o4Var = this.a.a;
                } else {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        this.a.a.E();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        this.a.a.c().p(new p6(this, z, data, str, queryParameter));
                        o4Var = this.a.a;
                    }
                    o4Var = this.a.a;
                }
            } catch (Exception e2) {
                this.a.a.a().m().b("Throwable caught in onActivityCreated", e2);
                o4Var = this.a.a;
            }
            o4Var.O().x(activity, bundle);
        } catch (Throwable th) {
            this.a.a.O().x(activity, bundle);
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.a.a.O().B(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.a.a.O().z(activity);
        u8 A = this.a.a.A();
        A.a.c().p(new n8(A, A.a.zzax().a()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        u8 A = this.a.a.A();
        A.a.c().p(new m8(A, A.a.zzax().a()));
        this.a.a.O().y(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.a.O().A(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
