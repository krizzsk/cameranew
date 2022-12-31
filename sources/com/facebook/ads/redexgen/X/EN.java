package com.facebook.ads.redexgen.X;

import android.os.Parcel;
/* loaded from: assets/audience_network.dex */
public final class EN {
    public final int A00;
    public final long A01;
    public final long A02;

    public EN(int i2, long j2, long j3) {
        this.A00 = i2;
        this.A02 = j2;
        this.A01 = j3;
    }

    public /* synthetic */ EN(int i2, long j2, long j3, EM em) {
        this(i2, j2, j3);
    }

    public static EN A00(Parcel parcel) {
        return new EN(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}
