package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaam extends zzyu {
    private final OnAdMetadataChangedListener zzclq;

    public zzaam(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzclq = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzclq;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
