package com.ironsource.mediationsdk.m0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import cn.sharesdk.facebook.Facebook;
import com.ironsource.environment.j;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: IntegrationHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntegrationHelper.java */
    /* renamed from: com.ironsource.mediationsdk.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0208a extends Thread {
        final /* synthetic */ Activity a;

        C0208a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.w("IntegrationHelper", "--------------- Google Play Services --------------");
                if (this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                    Log.i("IntegrationHelper", "Google Play Services - VERIFIED");
                    String h2 = IronSourceObject.getInstance().h(this.a);
                    if (!TextUtils.isEmpty(h2)) {
                        Log.i("IntegrationHelper", "GAID is: " + h2 + " (use this for test devices)");
                    }
                } else {
                    Log.e("IntegrationHelper", "Google Play Services - MISSING");
                }
            } catch (Exception unused) {
                Log.e("IntegrationHelper", "Google Play Services - MISSING");
            }
        }
    }

    private static boolean a(Context context, String[] strArr) {
        boolean z;
        String str;
        List<PackageInfo> installedPackages;
        ArrayList arrayList = new ArrayList();
        if (context != null && (installedPackages = context.getPackageManager().getInstalledPackages(8)) != null) {
            for (PackageInfo packageInfo : installedPackages) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (providerInfoArr != null) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        arrayList.add(providerInfo.name);
                    }
                }
            }
        }
        boolean z2 = true;
        if (strArr != null) {
            Log.i("IntegrationHelper", "*** Content Providers ***");
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                if (arrayList.contains(str2)) {
                    z = z2;
                    str = "- VERIFIED";
                } else {
                    str = "- MISSING";
                    z = false;
                }
                Log.d("IntegrationHelper", str2 + str);
                i2++;
                z2 = z;
            }
        }
        return z2;
    }

    private static s b(Activity activity, String str) {
        try {
            s sVar = (s) Class.forName(str).getMethod("getIntegrationData", Activity.class).invoke(null, activity);
            Log.i("IntegrationHelper", "Adapter " + sVar.b + " - VERIFIED");
            return sVar;
        } catch (ClassNotFoundException unused) {
            Log.e("IntegrationHelper", "Adapter - MISSING");
            return null;
        } catch (Exception unused2) {
            Log.e("IntegrationHelper", "Adapter version - NOT VERIFIED");
            return null;
        }
    }

    private static boolean c(Activity activity, String[] strArr) {
        boolean z = true;
        if (strArr == null) {
            return true;
        }
        Log.i("IntegrationHelper", "*** Activities ***");
        for (String str : strArr) {
            try {
            } catch (ClassNotFoundException unused) {
                Log.e("IntegrationHelper", str + " - MISSING");
            }
            if (activity.getPackageManager().queryIntentActivities(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                Log.i("IntegrationHelper", str + " - VERIFIED");
            } else {
                Log.e("IntegrationHelper", str + " - MISSING");
                z = false;
            }
        }
        return z;
    }

    private static boolean d(Activity activity, String str) {
        try {
            if (str.equalsIgnoreCase("SupersonicAds")) {
                Log.i("IntegrationHelper", "--------------- IronSource  --------------");
            } else {
                Log.i("IntegrationHelper", "--------------- " + str + " --------------");
            }
            String str2 = "com.ironsource.adapters." + j.a(str) + "." + str + "Adapter";
            s b = b(activity, str2);
            if (b == null) {
                return false;
            }
            if (str.equalsIgnoreCase("SupersonicAds") || e(b)) {
                k(str2);
                boolean c = c(activity, b.c);
                if (!f(b.f5648e)) {
                    c = false;
                }
                if (!g(activity, b.f5649f)) {
                    c = false;
                }
                if (!a(activity, b.f5647d)) {
                    c = false;
                }
                if (b.f5650g && Build.VERSION.SDK_INT <= 18) {
                    if (activity.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName()) == 0) {
                        Log.i("IntegrationHelper", "android.permission.WRITE_EXTERNAL_STORAGE - VERIFIED");
                    } else {
                        Log.e("IntegrationHelper", "android.permission.WRITE_EXTERNAL_STORAGE - MISSING");
                        return false;
                    }
                }
                return c;
            }
            return false;
        } catch (Exception e2) {
            Log.e("IntegrationHelper", "isAdapterValid " + str, e2);
            return false;
        }
    }

    private static boolean e(s sVar) {
        if (!sVar.b.startsWith("4.1") && !sVar.b.startsWith("4.3")) {
            Log.e("IntegrationHelper", sVar.a + " adapter " + sVar.b + " is incompatible with SDK version " + IronSourceUtils.I() + ", please update your adapter to version 4.1.*");
            return false;
        }
        Log.i("IntegrationHelper", "Adapter - VERIFIED");
        return true;
    }

    private static boolean f(ArrayList<Pair<String, String>> arrayList) {
        boolean z = true;
        if (arrayList == null) {
            return true;
        }
        Log.i("IntegrationHelper", "*** External Libraries ***");
        Iterator<Pair<String, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                Class.forName((String) next.first);
                Log.i("IntegrationHelper", ((String) next.second) + " - VERIFIED");
            } catch (ClassNotFoundException unused) {
                z = false;
                Log.e("IntegrationHelper", ((String) next.second) + " - MISSING");
            }
        }
        return z;
    }

    private static boolean g(Activity activity, String[] strArr) {
        boolean z = true;
        if (strArr == null) {
            return true;
        }
        PackageManager packageManager = activity.getPackageManager();
        Log.i("IntegrationHelper", "*** Services ***");
        for (String str : strArr) {
            try {
            } catch (ClassNotFoundException unused) {
                Log.e("IntegrationHelper", str + " - MISSING");
            }
            if (packageManager.queryIntentServices(new Intent(activity, Class.forName(str)), 65536).size() > 0) {
                Log.i("IntegrationHelper", str + " - VERIFIED");
            } else {
                Log.e("IntegrationHelper", str + " - MISSING");
                z = false;
            }
        }
        return z;
    }

    private static void h(Activity activity) {
        new C0208a(activity).start();
    }

    public static void i(Activity activity) {
        Log.i("IntegrationHelper", "Verifying Integration:");
        j(activity);
        String[] strArr = {"AdColony", "AdMob", "Amazon", "AppLovin", "Chartboost", Facebook.NAME, "Fyber", "HyprMX", "InMobi", "SupersonicAds", "Maio", "MyTarget", "Pangle", "Smaato", "Tapjoy", "UnityAds", "Vungle"};
        for (int i2 = 0; i2 < 17; i2++) {
            String str = strArr[i2];
            if (d(activity, str)) {
                if (str.equalsIgnoreCase("SupersonicAds")) {
                    Log.i("IntegrationHelper", ">>>> IronSource - VERIFIED");
                } else {
                    Log.i("IntegrationHelper", ">>>> " + str + " - VERIFIED");
                }
            } else if (str.equalsIgnoreCase("SupersonicAds")) {
                Log.e("IntegrationHelper", ">>>> IronSource - NOT VERIFIED");
            } else {
                Log.e("IntegrationHelper", ">>>> " + str + " - NOT VERIFIED");
            }
        }
        h(activity);
    }

    private static void j(Activity activity) {
        Log.i("IntegrationHelper", "*** Permissions ***");
        PackageManager packageManager = activity.getPackageManager();
        if (packageManager.checkPermission("android.permission.INTERNET", activity.getPackageName()) == 0) {
            Log.i("IntegrationHelper", "android.permission.INTERNET - VERIFIED");
        } else {
            Log.e("IntegrationHelper", "android.permission.INTERNET - MISSING");
        }
        if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", activity.getPackageName()) == 0) {
            Log.i("IntegrationHelper", "android.permission.ACCESS_NETWORK_STATE - VERIFIED");
        } else {
            Log.e("IntegrationHelper", "android.permission.ACCESS_NETWORK_STATE - MISSING");
        }
    }

    private static void k(String str) {
        try {
            Log.i("IntegrationHelper", "SDK Version - " + ((String) Class.forName(str).getMethod("getAdapterSDKVersion", new Class[0]).invoke(null, new Object[0])));
        } catch (Exception unused) {
            Log.w("validateSDKVersion", "Unable to get SDK version");
        }
    }
}
