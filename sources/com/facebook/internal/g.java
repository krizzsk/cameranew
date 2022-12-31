package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.internal.l;
import com.facebook.internal.t;
import com.tencent.tauth.AuthActivity;
/* compiled from: DialogPresenter.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: DialogPresenter.java */
    /* loaded from: classes.dex */
    public interface a {
        Bundle a();

        Bundle getParameters();
    }

    public static boolean a(f fVar) {
        return c(fVar).e() != -1;
    }

    private static Uri b(f fVar) {
        String name = fVar.name();
        l.a d2 = l.d(com.facebook.f.g(), fVar.getAction(), name);
        if (d2 != null) {
            return d2.b();
        }
        return null;
    }

    public static t.g c(f fVar) {
        String g2 = com.facebook.f.g();
        String action = fVar.getAction();
        return t.u(action, d(g2, action, fVar));
    }

    private static int[] d(String str, String str2, f fVar) {
        l.a d2 = l.d(str, str2, fVar.name());
        return d2 != null ? d2.d() : new int[]{fVar.getMinVersion()};
    }

    public static void e(com.facebook.internal.a aVar, Activity activity) {
        activity.startActivityForResult(aVar.e(), aVar.d());
        aVar.g();
    }

    public static void f(com.facebook.internal.a aVar, n nVar) {
        nVar.d(aVar.e(), aVar.d());
        aVar.g();
    }

    public static void g(com.facebook.internal.a aVar) {
        j(aVar, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void h(com.facebook.internal.a aVar, FacebookException facebookException) {
        if (facebookException == null) {
            return;
        }
        y.f(com.facebook.f.f());
        Intent intent = new Intent();
        intent.setClass(com.facebook.f.f(), FacebookActivity.class);
        intent.setAction(FacebookActivity.b);
        t.D(intent, aVar.b().toString(), null, t.x(), t.i(facebookException));
        aVar.h(intent);
    }

    public static void i(com.facebook.internal.a aVar, a aVar2, f fVar) {
        Bundle a2;
        Context f2 = com.facebook.f.f();
        String action = fVar.getAction();
        t.g c = c(fVar);
        int e2 = c.e();
        if (e2 != -1) {
            if (t.C(e2)) {
                a2 = aVar2.getParameters();
            } else {
                a2 = aVar2.a();
            }
            if (a2 == null) {
                a2 = new Bundle();
            }
            Intent l2 = t.l(f2, aVar.b().toString(), action, c, a2);
            if (l2 != null) {
                aVar.h(l2);
                return;
            }
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    public static void j(com.facebook.internal.a aVar, FacebookException facebookException) {
        h(aVar, facebookException);
    }

    public static void k(com.facebook.internal.a aVar, String str, Bundle bundle) {
        y.f(com.facebook.f.f());
        y.h(com.facebook.f.f());
        Bundle bundle2 = new Bundle();
        bundle2.putString(AuthActivity.ACTION_KEY, str);
        bundle2.putBundle("params", bundle);
        Intent intent = new Intent();
        t.D(intent, aVar.b().toString(), str, t.x(), bundle2);
        intent.setClass(com.facebook.f.f(), FacebookActivity.class);
        intent.setAction("FacebookDialogFragment");
        aVar.h(intent);
    }

    public static void l(com.facebook.internal.a aVar, Bundle bundle, f fVar) {
        Uri e2;
        y.f(com.facebook.f.f());
        y.h(com.facebook.f.f());
        String name = fVar.name();
        Uri b = b(fVar);
        if (b != null) {
            Bundle e3 = w.e(aVar.b().toString(), t.x(), bundle);
            if (e3 != null) {
                if (b.isRelative()) {
                    e2 = x.e(w.b(), b.toString(), e3);
                } else {
                    e2 = x.e(b.getAuthority(), b.getPath(), e3);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", e2.toString());
                bundle2.putBoolean("is_fallback", true);
                Intent intent = new Intent();
                t.D(intent, aVar.b().toString(), fVar.getAction(), t.x(), bundle2);
                intent.setClass(com.facebook.f.f(), FacebookActivity.class);
                intent.setAction("FacebookDialogFragment");
                aVar.h(intent);
                return;
            }
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + "'");
    }
}
