package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
/* loaded from: assets/audience_network.dex */
public class H8 implements Parcelable.Creator<DefaultTrackSelector$SelectionOverride> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final DefaultTrackSelector$SelectionOverride createFromParcel(Parcel parcel) {
        return new DefaultTrackSelector$SelectionOverride(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final DefaultTrackSelector$SelectionOverride[] newArray(int i2) {
        return new DefaultTrackSelector$SelectionOverride[i2];
    }
}
