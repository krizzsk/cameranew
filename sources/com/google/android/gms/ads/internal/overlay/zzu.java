package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzu extends zzc {
    public zzu(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzc, com.google.android.gms.internal.ads.zzaro
    public final void onCreate(Bundle bundle) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdOverlayParcel is null or does not contain valid overlay type.");
        this.m = zzn.OTHER;
        this.a.finish();
    }
}
