package com.growingio.android.sdk.monitor;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.growingio.android.sdk.monitor.context.ContextManager;
import com.growingio.android.sdk.monitor.context.SingletonContextManager;
import com.growingio.android.sdk.monitor.dsn.Dsn;
import com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper;
import com.growingio.android.sdk.monitor.util.Util;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes2.dex */
public class AndroidMonitorClientFactory extends DefaultMonitorClientFactory {
    public static final String TAG = "com.growingio.android.sdk.monitor.AndroidMonitorClientFactory";
    private Context ctx;

    public AndroidMonitorClientFactory(Context context) {
        Log.d(TAG, "Construction of Android Monitor.");
        this.ctx = context.getApplicationContext();
    }

    private boolean checkPermission(String str) {
        return this.ctx.checkCallingOrSelfPermission(str) == 0;
    }

    @Override // com.growingio.android.sdk.monitor.DefaultMonitorClientFactory, com.growingio.android.sdk.monitor.MonitorClientFactory
    public MonitorClient createMonitorClient(String str, Dsn dsn) {
        if (!checkPermission("android.permission.INTERNET")) {
            Log.e(TAG, "android.permission.INTERNET is required to connect to the Monitor server, please add it to your AndroidManifest.xml");
        }
        String str2 = TAG;
        Log.d(str2, "Monitor init with ctx='" + this.ctx.toString());
        MonitorClient createMonitorClient = super.createMonitorClient(str, dsn);
        createMonitorClient.addBuilderHelper(new AndroidEventBuilderHelper(this.ctx, createMonitorClient.getContext()));
        return createMonitorClient;
    }

    @Override // com.growingio.android.sdk.monitor.DefaultMonitorClientFactory
    protected ContextManager getContextManager(Dsn dsn) {
        return new SingletonContextManager();
    }

    @Override // com.growingio.android.sdk.monitor.DefaultMonitorClientFactory
    protected Collection<String> getInAppFrames(Dsn dsn) {
        Collection<String> inAppFrames = super.getInAppFrames(dsn);
        if (inAppFrames.isEmpty()) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(TAG, "Error getting package information.", e2);
            }
            if (packageInfo == null || Util.isNullOrEmpty(packageInfo.packageName)) {
                return inAppFrames;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(packageInfo.packageName);
            return arrayList;
        }
        return inAppFrames;
    }
}
