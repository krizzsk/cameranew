package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqv implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzafn zzdqm;

    public zzaqv(zzafn zzafnVar) {
        this.zzdqm = zzafnVar;
        try {
            zzafnVar.zztu();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdqm.zzq(d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdqm.zztt();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }
}
