package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
/* compiled from: CustomTab.java */
/* loaded from: classes.dex */
public class d {
    private Uri a;

    public d(String str, Bundle bundle) {
        this.a = a(str, bundle == null ? new Bundle() : bundle);
    }

    public static Uri a(String str, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            String b = w.b();
            return x.e(b, com.facebook.f.r() + "/dialog/" + str, bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    public boolean b(Activity activity, String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return false;
        }
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder(com.facebook.login.a.a()).build();
            build.intent.setPackage(str);
            build.intent.addFlags(1073741824);
            try {
                build.launchUrl(activity, this.a);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return false;
        }
    }
}
