package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.internal.ads.zzazk;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class WorkManagerUtil extends zzbf {
    private static void x0(Context context) {
        try {
            WorkManager.initialize(context.getApplicationContext(), new Configuration.Builder().build());
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final void zzap(com.google.android.gms.dynamic.b bVar) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        x0(context);
        try {
            WorkManager workManager = WorkManager.getInstance(context);
            workManager.cancelAllWorkByTag("offline_ping_sender_work");
            workManager.enqueue(new OneTimeWorkRequest.Builder(OfflinePingSender.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).addTag("offline_ping_sender_work").build());
        } catch (IllegalStateException e2) {
            zzazk.zzd("Failed to instantiate WorkManager.", e2);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final boolean zzd(com.google.android.gms.dynamic.b bVar, String str, String str2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        x0(context);
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        try {
            WorkManager.getInstance(context).enqueue(new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).setConstraints(build).setInputData(new Data.Builder().putString("uri", str).putString("gws_query_id", str2).build()).addTag("offline_notification_work").build());
            return true;
        } catch (IllegalStateException e2) {
            zzazk.zzd("Failed to instantiate WorkManager.", e2);
            return false;
        }
    }
}
