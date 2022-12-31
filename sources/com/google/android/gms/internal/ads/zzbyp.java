package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbyp extends zzbwf<VideoController.VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzeua;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbyp(Set<zzbya<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoEnd() {
        zza(zzbyr.zzfzg);
    }

    public final void onVideoPause() {
        zza(zzbys.zzfzg);
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzeua) {
            zza(zzbyt.zzfzg);
            this.zzeua = true;
        }
        zza(zzbyw.zzfzg);
    }

    public final synchronized void onVideoStart() {
        zza(zzbyu.zzfzg);
        this.zzeua = true;
    }
}
