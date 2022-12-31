package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class p {
    private static final com.google.android.play.core.internal.j c = new com.google.android.play.core.internal.j("SplitInstallInfoProvider");
    private final Context a;
    private final String b;

    public p(Context context) {
        this.a = context;
        this.b = context.getPackageName();
    }

    public static boolean b(String str) {
        return str.startsWith("config.");
    }

    public static boolean d(String str) {
        return b(str) || str.contains(".config.");
    }

    private final Set<String> f() {
        HashSet hashSet = new HashSet();
        Bundle g2 = g();
        if (g2 != null) {
            String string = g2.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                c.c("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.b, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                c.g("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                c.c("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                c.c("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            f0 a = g0.a();
            if (a != null) {
                hashSet.addAll(a.a());
            }
        }
        return hashSet;
    }

    @Nullable
    private final Bundle g() {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.b, 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                c.c("App has no applicationInfo or metaData", new Object[0]);
                return null;
            }
            return bundle;
        } catch (PackageManager.NameNotFoundException unused) {
            c.g("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        for (String str : f()) {
            if (!d(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Set<String> c() {
        z e2 = e();
        if (e2 == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> f2 = f();
        f2.add("");
        Set<String> a = a();
        a.add("");
        for (Map.Entry<String, Set<String>> entry : e2.a(a).entrySet()) {
            if (f2.containsAll(entry.getValue())) {
                hashSet.add(entry.getKey());
            }
        }
        return hashSet;
    }

    @Nullable
    public final z e() {
        Bundle g2 = g();
        if (g2 == null) {
            c.g("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i2 = g2.getInt("com.android.vending.splits");
        if (i2 == 0) {
            c.g("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            z a = new s(this.a.getResources().getXml(i2)).a();
            if (a == null) {
                c.g("Can't parse languages metadata.", new Object[0]);
            }
            return a;
        } catch (Resources.NotFoundException unused) {
            c.g("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}
