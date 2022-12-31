package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
/* loaded from: assets/audience_network.dex */
public class H5 implements Parcelable.Creator<DefaultTrackSelector$Parameters> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final DefaultTrackSelector$Parameters createFromParcel(Parcel parcel) {
        return new DefaultTrackSelector$Parameters(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final DefaultTrackSelector$Parameters[] newArray(int i2) {
        return new DefaultTrackSelector$Parameters[i2];
    }
}
