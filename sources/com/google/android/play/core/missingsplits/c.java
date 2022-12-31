package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.google.android.play.core.internal.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
final class c {
    private static final j c = new j("MissingSplitsAppComponentsHelper");
    private final Context a;
    private final PackageManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, PackageManager packageManager) {
        this.a = context;
        this.b = packageManager;
    }

    private final void a(List<ComponentInfo> list, int i2) {
        for (ComponentInfo componentInfo : list) {
            this.b.setComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name), i2, 1);
        }
    }

    private final List<ComponentInfo> e() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.b.getPackageInfo(this.a.getPackageName(), 526);
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                Collections.addAll(arrayList, providerInfoArr);
            }
            ActivityInfo[] activityInfoArr = packageInfo.receivers;
            if (activityInfoArr != null) {
                Collections.addAll(arrayList, activityInfoArr);
            }
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                Collections.addAll(arrayList, serviceInfoArr);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            c.g("Failed to resolve own package : %s", e2);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        for (ComponentInfo componentInfo : e()) {
            if (this.b.getComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name)) != 2) {
                c.c("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        c.c("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        c.f("Disabling all non-activity components", new Object[0]);
        a(e(), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        c.f("Resetting enabled state of all non-activity components", new Object[0]);
        a(e(), 0);
    }
}
