package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.tencent.matrix.plugin.PluginShareConstants;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class d4 {
    final o4 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d4(o4 o4Var) {
        this.a = o4Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void a(String str) {
        if (str != null && !str.isEmpty()) {
            this.a.c().f();
            if (!b()) {
                this.a.a().s().a("Install Referrer Reporter is not available");
                return;
            }
            b4 b4Var = new b4(this, str);
            this.a.c().f();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.a.zzaw().getPackageManager();
            if (packageManager == null) {
                this.a.a().q().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                return;
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.packageName;
                    if (serviceInfo.name != null && "com.android.vending".equals(str2) && b()) {
                        try {
                            this.a.a().u().b("Install Referrer Service is", true != ConnectionTracker.getInstance().a(this.a.zzaw(), new Intent(intent), b4Var, 1) ? "not available" : PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE);
                            return;
                        } catch (Exception e2) {
                            this.a.a().m().b("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                            return;
                        }
                    }
                    this.a.a().p().a("Play Store version 8.3.73 or higher required for Install Referrer");
                    return;
                }
                return;
            }
            this.a.a().s().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        this.a.a().q().a("Install Referrer Reporter was called with invalid app package name");
    }

    final boolean b() {
        try {
            PackageManagerWrapper a = com.google.android.gms.common.wrappers.b.a(this.a.zzaw());
            if (a != null) {
                return a.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.a().u().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            this.a.a().u().b("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }
}
