package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;
/* renamed from: com.facebook.ads.redexgen.X.Io  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0926Io implements Parcelable.Creator<ColorInfo> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final ColorInfo createFromParcel(Parcel parcel) {
        return new ColorInfo(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final ColorInfo[] newArray(int i2) {
        return new ColorInfo[0];
    }
}
