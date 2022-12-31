package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzys implements MuteThisAdReason {
    private final String description;
    private zzyn zzcjx;

    public zzys(zzyn zzynVar) {
        String str;
        this.zzcjx = zzynVar;
        try {
            str = zzynVar.getDescription();
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
            str = null;
        }
        this.description = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzyn zzrf() {
        return this.zzcjx;
    }
}
