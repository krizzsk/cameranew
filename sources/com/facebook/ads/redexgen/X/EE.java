package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame;
/* loaded from: assets/audience_network.dex */
public class EE implements Parcelable.Creator<GeobFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final GeobFrame createFromParcel(Parcel parcel) {
        return new GeobFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final GeobFrame[] newArray(int i2) {
        return new GeobFrame[i2];
    }
}
