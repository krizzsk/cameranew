package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzacp implements zzeqp {
    @Nullable
    private CustomTabsSession zzdbp;
    @Nullable
    private CustomTabsClient zzdbq;
    @Nullable
    private CustomTabsServiceConnection zzdbr;
    @Nullable
    private zzaco zzdbs;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzeqn.zzcl(context));
                }
            }
        }
        return false;
    }

    public final void zza(zzaco zzacoVar) {
        this.zzdbs = zzacoVar;
    }

    public final void zzc(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzdbr;
        if (customTabsServiceConnection == null) {
            return;
        }
        activity.unbindService(customTabsServiceConnection);
        this.zzdbq = null;
        this.zzdbp = null;
        this.zzdbr = null;
    }

    public final void zzd(Activity activity) {
        String zzcl;
        if (this.zzdbq == null && (zzcl = zzeqn.zzcl(activity)) != null) {
            zzeqq zzeqqVar = new zzeqq(this);
            this.zzdbr = zzeqqVar;
            CustomTabsClient.bindCustomTabsService(activity, zzcl, zzeqqVar);
        }
    }

    @Nullable
    public final CustomTabsSession zzsv() {
        CustomTabsClient customTabsClient = this.zzdbq;
        if (customTabsClient == null) {
            this.zzdbp = null;
        } else if (this.zzdbp == null) {
            this.zzdbp = customTabsClient.newSession(null);
        }
        return this.zzdbp;
    }

    @Override // com.google.android.gms.internal.ads.zzeqp
    public final void zzsw() {
        this.zzdbq = null;
        this.zzdbp = null;
        zzaco zzacoVar = this.zzdbs;
        if (zzacoVar != null) {
            zzacoVar.zzsu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqp
    public final void zza(CustomTabsClient customTabsClient) {
        this.zzdbq = customTabsClient;
        customTabsClient.warmup(0L);
        zzaco zzacoVar = this.zzdbs;
        if (zzacoVar != null) {
            zzacoVar.zzst();
        }
    }
}
