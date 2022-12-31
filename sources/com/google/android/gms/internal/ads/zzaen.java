package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaen implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzafn zzdfw;

    public zzaen(zzafn zzafnVar) {
        this.zzdfw = zzafnVar;
        try {
            zzafnVar.zztu();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdfw.zzq(d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdfw.zztt();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            return false;
        }
    }
}
