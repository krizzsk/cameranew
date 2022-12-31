package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.ads.zzanf;
import com.google.android.gms.internal.ads.zzarf;
import com.google.android.gms.internal.ads.zzwr;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class OfflineNotificationPoster extends Worker {
    private final zzarf a;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.a = zzwr.zzqo().zzb(context, new zzanf());
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        try {
            this.a.zzc(d.z0(getApplicationContext()), getInputData().getString("uri"), getInputData().getString("gws_query_id"));
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
