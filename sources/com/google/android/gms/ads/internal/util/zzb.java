package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzdzw;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzb {
    public static void zzaj(Context context) {
        if (zzaze.zzbs(context) && !zzaze.zzaaa()) {
            zzdzw<?> zzye = new t(context).zzye();
            zzazk.zzew("Updating ad debug logging enablement.");
            zzazw.zza(zzye, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
