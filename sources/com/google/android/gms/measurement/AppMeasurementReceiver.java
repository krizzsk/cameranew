package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.e4;
import com.google.android.gms.measurement.internal.f4;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements e4 {
    private f4 a;

    @Override // com.google.android.gms.measurement.internal.e4
    @MainThread
    public void a(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(@RecentlyNonNull Context context, @RecentlyNonNull Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if (this.a == null) {
            this.a = new f4(this);
        }
        this.a.b(context, intent);
    }
}
