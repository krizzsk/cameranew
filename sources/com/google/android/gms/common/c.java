package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.util.t;
import com.google.android.gms.common.util.x;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class c {
    @Deprecated
    public static final int a = 12451000;
    private static boolean b = false;
    private static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    static final AtomicBoolean f3642d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f3643e = new AtomicBoolean();

    @Deprecated
    public static void a(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int g2 = GoogleApiAvailabilityLight.getInstance().g(context, i2);
        if (g2 != 0) {
            Intent b2 = GoogleApiAvailabilityLight.getInstance().b(context, g2, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(g2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (b2 == null) {
                throw new GooglePlayServicesNotAvailableException(g2);
            }
            throw new GooglePlayServicesRepairableException(g2, "Google Play Services not available", b2);
        }
    }

    @Deprecated
    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @NonNull
    @Deprecated
    public static String c(int i2) {
        return ConnectionResult.V(i2);
    }

    @Nullable
    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!c) {
                PackageInfo e2 = com.google.android.gms.common.wrappers.b.a(context).e("com.google.android.gms", 64);
                d.a(context);
                if (e2 != null && !d.f(e2, false) && d.f(e2, true)) {
                    b = true;
                } else {
                    b = false;
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
        } finally {
            c = true;
        }
        return b || !com.google.android.gms.common.util.i.c();
    }

    @Deprecated
    public static int g(Context context, int i2) {
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f3643e.get()) {
            int a2 = s0.a(context);
            if (a2 != 0) {
                int i3 = a;
                if (a2 != i3) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i3);
                    sb.append(" but found ");
                    sb.append(a2);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return l(context, (com.google.android.gms.common.util.i.f(context) || com.google.android.gms.common.util.i.g(context)) ? false : true, i2);
    }

    @Deprecated
    public static boolean h(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return m(context, "com.google.android.gms");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean i(Context context) {
        Bundle applicationRestrictions;
        return com.google.android.gms.common.util.o.e() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean j(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean k(Context context, int i2, String str) {
        return t.b(context, i2, str);
    }

    private static int l(Context context, boolean z, int i2) {
        com.google.android.gms.common.internal.q.a(i2 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            d.a(context);
            if (!d.f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                return 9;
            }
            if (z) {
                com.google.android.gms.common.internal.q.j(packageInfo);
                if (!d.f(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                    return 9;
                }
            }
            if (x.a(packageInfo2.versionCode) < x.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                sb.append("Google Play services out of date for ");
                sb.append(packageName);
                sb.append(".  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @TargetApi(21)
    static boolean m(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (com.google.android.gms.common.util.o.h()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        return applicationInfo.enabled && !i(context);
    }
}
