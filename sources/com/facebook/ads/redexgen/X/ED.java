package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.CommentFrame;
/* loaded from: assets/audience_network.dex */
public class ED implements Parcelable.Creator<CommentFrame> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A00 */
    public final CommentFrame createFromParcel(Parcel parcel) {
        return new CommentFrame(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* renamed from: A01 */
    public final CommentFrame[] newArray(int i2) {
        return new CommentFrame[i2];
    }
}
