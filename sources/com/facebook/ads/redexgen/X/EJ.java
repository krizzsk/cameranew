package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.TextInformationFrame;
/* loaded from: assets/audience_network.dex */
public class EJ implements Parcelable.Creator<TextInformationFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final TextInformationFrame createFromParcel(Parcel parcel) {
        return new TextInformationFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final TextInformationFrame[] newArray(int i2) {
        return new TextInformationFrame[i2];
    }
}
