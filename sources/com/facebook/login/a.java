package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
/* compiled from: CustomTabPrefetchHelper.java */
/* loaded from: classes.dex */
public class a extends CustomTabsServiceConnection {
    private static CustomTabsClient a;
    private static CustomTabsSession b;

    public static CustomTabsSession a() {
        CustomTabsSession customTabsSession = b;
        b = null;
        return customTabsSession;
    }

    public static void b(Uri uri) {
        if (b == null) {
            c();
        }
        CustomTabsSession customTabsSession = b;
        if (customTabsSession != null) {
            customTabsSession.mayLaunchUrl(uri, null, null);
        }
    }

    private static void c() {
        CustomTabsClient customTabsClient;
        if (b != null || (customTabsClient = a) == null) {
            return;
        }
        b = customTabsClient.newSession(null);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        a = customTabsClient;
        customTabsClient.warmup(0L);
        c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
