package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/* compiled from: CustomTabUtils.java */
/* loaded from: classes.dex */
public class e {
    private static final String[] a = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    public static String a() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            Context f2 = com.facebook.f.f();
            List<ResolveInfo> queryIntentServices = f2.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices != null) {
                HashSet hashSet = new HashSet(Arrays.asList(a));
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                        return serviceInfo.packageName;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    public static String b() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            return "fbconnect://cct." + com.facebook.f.f().getPackageName();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    public static String c(String str) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            return y.e(com.facebook.f.f(), str) ? str : y.e(com.facebook.f.f(), b()) ? b() : "";
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }
}
