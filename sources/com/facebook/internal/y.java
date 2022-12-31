package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.List;
/* compiled from: Validate.java */
/* loaded from: classes.dex */
public final class y {
    private static final String a = "com.facebook.internal.y";

    public static <T> void a(Collection<T> collection, String str) {
        l(collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static String b() {
        String g2 = com.facebook.f.g();
        if (g2 != null) {
            return g2;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    public static String c() {
        String n = com.facebook.f.n();
        if (n != null) {
            return n;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }

    public static void d(Context context) {
        l(context, "context");
        String b = b();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = "com.facebook.app.FacebookContentProvider" + b;
            if (packageManager.resolveContentProvider(str, 0) == null) {
                throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", str));
            }
        }
    }

    public static boolean e(Context context, String str) {
        List<ResolveInfo> list;
        l(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list != null) {
            boolean z = false;
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                    return false;
                }
                z = true;
            }
            return z;
        }
        return false;
    }

    public static void f(Context context) {
        g(context, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(android.content.Context r3, boolean r4) {
        /*
            java.lang.String r0 = "context"
            l(r3, r0)
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            if (r0 == 0) goto L18
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.String r2 = "com.facebook.FacebookActivity"
            r1.<init>(r3, r2)
            r3 = 1
            android.content.pm.ActivityInfo r3 = r0.getActivityInfo(r1, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L18
            goto L19
        L18:
            r3 = 0
        L19:
            if (r3 != 0) goto L2b
            java.lang.String r3 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            if (r4 != 0) goto L25
            java.lang.String r4 = com.facebook.internal.y.a
            android.util.Log.w(r4, r3)
            goto L2b
        L25:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r3)
            throw r4
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.y.g(android.content.Context, boolean):void");
    }

    public static void h(Context context) {
        i(context, true);
    }

    public static void i(Context context, boolean z) {
        l(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (!z) {
                Log.w(a, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
                return;
            }
            throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
    }

    public static <T> void j(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    public static <T> void k(Collection<T> collection, String str) {
        a(collection, str);
        j(collection, str);
    }

    public static void l(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + str + "' cannot be null");
    }

    public static void m(String str, String str2) {
        if (x.S(str)) {
            throw new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
        }
    }

    public static void n() {
        if (!com.facebook.f.z()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }
}
