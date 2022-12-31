package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0919Ih;
import com.facebook.ads.redexgen.X.ES;
import com.facebook.ads.redexgen.X.IV;
/* loaded from: assets/audience_network.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new ES();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j2, long j3) {
        this.A01 = j2;
        this.A00 = j3;
    }

    public /* synthetic */ TimeSignalCommand(long j2, long j3, ES es) {
        this(j2, j3);
    }

    public static long A00(IV iv, long j2) {
        long A0E = iv.A0E();
        if ((128 & A0E) == 0) {
            return -9223372036854775807L;
        }
        long ptsTime = 1 & A0E;
        return (((ptsTime << 32) | iv.A0M()) + j2) & 8589934591L;
    }

    public static TimeSignalCommand A01(IV iv, long j2, C0919Ih c0919Ih) {
        long A00 = A00(iv, j2);
        return new TimeSignalCommand(A00, c0919Ih.A07(A00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
