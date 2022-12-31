package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: InitChecker.java */
/* loaded from: classes.dex */
public class k {
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a() {
        /*
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.o.a()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r1 = com.bytedance.sdk.openadsdk.utils.o.c()
            if (r1 != 0) goto Le
            return
        Le:
            java.lang.String r1 = b(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Current process name："
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "TTAdSdk-InitChecker"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r1)
            java.lang.String r1 = "The pangolin sdk access, the environment is debug, the initial configuration detection starts"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r1)
            java.lang.String r1 = r0.getPackageName()
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            android.content.pm.PackageManager r4 = r0.getPackageManager()
            a(r0)
            r0 = 4096(0x1000, float:5.74E-42)
            r5 = 0
            r6 = 1
            android.content.pm.PackageInfo r0 = r4.getPackageInfo(r1, r0)     // Catch: java.lang.Throwable -> La2
            java.lang.String[] r0 = r0.requestedPermissions     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L9c
            int r1 = r0.length     // Catch: java.lang.Throwable -> La2
            if (r1 <= 0) goto L9c
            java.util.List r1 = b()     // Catch: java.lang.Throwable -> La2
            int r4 = r0.length     // Catch: java.lang.Throwable -> La2
            r7 = 0
        L53:
            if (r7 >= r4) goto L5f
            r8 = r0[r7]     // Catch: java.lang.Throwable -> La2
            if (r8 == 0) goto L5c
            r1.remove(r8)     // Catch: java.lang.Throwable -> La2
        L5c:
            int r7 = r7 + 1
            goto L53
        L5f:
            boolean r0 = r1.isEmpty()     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L6b
            java.lang.String r0 = "AndroidManifest.xml permissions configuration is normal"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r0)     // Catch: java.lang.Throwable -> La2
            goto Laa
        L6b:
            java.util.Iterator r0 = r1.iterator()     // Catch: java.lang.Throwable -> La2
        L6f:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto Laa
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r4.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = "    May be missing permissions："
            r4.append(r6)     // Catch: java.lang.Throwable -> L97
            r4.append(r1)     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = "，Please refer to the access documentation"
            r4.append(r1)     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L97
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r1)     // Catch: java.lang.Throwable -> L97
            r6 = 0
            goto L6f
        L97:
            r0 = move-exception
            goto La4
        L99:
            r0 = move-exception
            r5 = r6
            goto La4
        L9c:
            java.lang.String r0 = "The uses-permission configuration in AndroidManifest.xml is missing, please refer to the access documentation"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r0)     // Catch: java.lang.Throwable -> La2
            goto Laa
        La2:
            r0 = move-exception
            r5 = 1
        La4:
            java.lang.String r1 = "The usage-permission configuration error in AndroidManifest.xml, please refer to the access documentation"
            com.bytedance.sdk.openadsdk.utils.o.c(r2, r1, r0)
            r6 = r5
        Laa:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ld7
            r1 = 23
            if (r0 < r1) goto Lb2
            if (r3 >= r1) goto Ldd
        Lb2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r4.<init>()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r5 = "No adaptation required for dynamic permissions：target="
            r4.append(r5)     // Catch: java.lang.Throwable -> Ld7
            r4.append(r3)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r3 = "&phone="
            r4.append(r3)     // Catch: java.lang.Throwable -> Ld7
            r4.append(r0)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = ", require="
            r4.append(r0)     // Catch: java.lang.Throwable -> Ld7
            r4.append(r1)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> Ld7
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r0)     // Catch: java.lang.Throwable -> Ld7
            goto Ldd
        Ld7:
            r0 = move-exception
            java.lang.String r1 = "The dynamic permission is abnormal. Please check and read the access document in detail： "
            com.bytedance.sdk.openadsdk.utils.o.c(r2, r1, r0)
        Ldd:
            if (r6 != 0) goto Le4
            java.lang.String r0 = "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r0)
        Le4:
            java.lang.String r0 = "End of pangolin sdk initial configuration test"
            com.bytedance.sdk.openadsdk.utils.o.e(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.k.a():void");
    }

    private static String b(Context context) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "unknown";
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    public static boolean a(Context context) {
        o.e("TTAdSdk-InitChecker", "Start to check if TTMultiProvider and FileProvider are registered in AndroidManifest");
        boolean z = false;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders != null && queryContentProviders.size() != 0) {
            boolean z2 = false;
            for (ProviderInfo providerInfo : queryContentProviders) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (!TextUtils.isEmpty(str) && str.equals(providerInfo.authority)) {
                        o.e("TTAdSdk-InitChecker", "TTMultiProvider configuration in AndroidManifest.xml is normal");
                        z = true;
                        z2 = true;
                    } else {
                        o.e("TTAdSdk-InitChecker", "TTMultiProvider configuration exception in AndroidManifest.xml: android: authorities, please refer to the access documentation");
                        z = true;
                    }
                }
            }
            if (!z) {
                o.e("TTAdSdk-InitChecker", "You have not configured TTMultiProvider, please refer to the access documentation, otherwise it will affect the conversion");
            }
            o.e("TTAdSdk-InitChecker", "End the check of whether TTMultiProvider and FileProvider are registered in AndroidManifest");
            return z2;
        }
        o.e("TTAdSdk-InitChecker", "TTMultiProvider isTTMultiProviderRegistered pInfos == null or pInfos.size() == 0");
        return false;
    }
}
