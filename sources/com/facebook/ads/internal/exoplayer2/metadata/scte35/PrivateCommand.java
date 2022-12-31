package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.EL;
import com.facebook.ads.redexgen.X.IV;
/* loaded from: assets/audience_network.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new EL();
    public final long A00;
    public final long A01;
    public final byte[] A02;

    public PrivateCommand(long j2, byte[] bArr, long j3) {
        this.A01 = j3;
        this.A00 = j2;
        this.A02 = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.A01 = parcel.readLong();
        this.A00 = parcel.readLong();
        this.A02 = new byte[parcel.readInt()];
        parcel.readByteArray(this.A02);
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, EL el) {
        this(parcel);
    }

    public static PrivateCommand A00(IV iv, int i2, long j2) {
        long A0M = iv.A0M();
        byte[] bArr = new byte[i2 - 4];
        iv.A0c(bArr, 0, bArr.length);
        return new PrivateCommand(A0M, bArr, j2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
        parcel.writeInt(this.A02.length);
        parcel.writeByteArray(this.A02);
    }
}
