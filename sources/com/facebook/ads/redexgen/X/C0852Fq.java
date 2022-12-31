package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
/* renamed from: com.facebook.ads.redexgen.X.Fq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0852Fq implements Parcelable.Creator<TrackGroup> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final TrackGroup createFromParcel(Parcel parcel) {
        return new TrackGroup(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final TrackGroup[] newArray(int i2) {
        return new TrackGroup[i2];
    }
}
