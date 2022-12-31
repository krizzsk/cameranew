package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
/* renamed from: com.facebook.ads.redexgen.X.Fs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0853Fs implements Parcelable.Creator<TrackGroupArray> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final TrackGroupArray createFromParcel(Parcel parcel) {
        return new TrackGroupArray(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final TrackGroupArray[] newArray(int i2) {
        return new TrackGroupArray[i2];
    }
}
