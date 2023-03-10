package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzer implements zzet {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(zzel zzelVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyi = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzet
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzyi);
    }
}
