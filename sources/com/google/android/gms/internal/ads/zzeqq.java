package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqq extends CustomTabsServiceConnection {
    private WeakReference<zzeqp> zzjcg;

    public zzeqq(zzeqp zzeqpVar) {
        this.zzjcg = new WeakReference<>(zzeqpVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzeqp zzeqpVar = this.zzjcg.get();
        if (zzeqpVar != null) {
            zzeqpVar.zza(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzeqp zzeqpVar = this.zzjcg.get();
        if (zzeqpVar != null) {
            zzeqpVar.zzsw();
        }
    }
}
