package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0919Ih;
import com.facebook.ads.redexgen.X.EM;
import com.facebook.ads.redexgen.X.EN;
import com.facebook.ads.redexgen.X.IV;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new EM();
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final List<EN> A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<EN> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.A06 = j2;
        this.A0B = z;
        this.A09 = z2;
        this.A0A = z3;
        this.A0C = z4;
        this.A05 = j3;
        this.A04 = j4;
        this.A07 = Collections.unmodifiableList(list);
        this.A08 = z5;
        this.A03 = j5;
        this.A02 = i2;
        this.A00 = i3;
        this.A01 = i4;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.A06 = parcel.readLong();
        this.A0B = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        this.A0A = parcel.readByte() == 1;
        this.A0C = parcel.readByte() == 1;
        this.A05 = parcel.readLong();
        this.A04 = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(EN.A00(parcel));
        }
        this.A07 = Collections.unmodifiableList(arrayList);
        this.A08 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, EM em) {
        this(parcel);
    }

    public static SpliceInsertCommand A00(IV iv, long j2, C0919Ih c0919Ih) {
        long A0M = iv.A0M();
        boolean z = (iv.A0E() & 128) != 0;
        boolean z2 = false;
        boolean autoReturn = false;
        boolean spliceImmediateFlag = false;
        long programSplicePts = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        long j3 = -9223372036854775807L;
        if (!z) {
            int A0E = iv.A0E();
            z2 = (A0E & 128) != 0;
            autoReturn = (A0E & 64) != 0;
            boolean programSpliceFlag = (A0E & 32) != 0;
            spliceImmediateFlag = (A0E & 16) != 0;
            if (autoReturn && !spliceImmediateFlag) {
                programSplicePts = TimeSignalCommand.A00(iv, j2);
            }
            if (!autoReturn) {
                int A0E2 = iv.A0E();
                emptyList = new ArrayList(A0E2);
                for (int i5 = 0; i5 < A0E2; i5++) {
                    int A0E3 = iv.A0E();
                    long j4 = -9223372036854775807L;
                    if (!spliceImmediateFlag) {
                        j4 = TimeSignalCommand.A00(iv, j2);
                    }
                    long spliceEventId = j4;
                    emptyList.add(new EN(A0E3, spliceEventId, c0919Ih.A07(j4), null));
                }
            }
            if (programSpliceFlag) {
                long A0E4 = iv.A0E();
                z3 = (A0E4 & 128) != 0;
                j3 = (1000 * (((A0E4 & 1) << 32) | iv.A0M())) / 90;
            }
            i2 = iv.A0I();
            i3 = iv.A0E();
            i4 = iv.A0E();
        }
        return new SpliceInsertCommand(A0M, z, z2, autoReturn, spliceImmediateFlag, programSplicePts, c0919Ih.A07(programSplicePts), emptyList, z3, j3, i2, i3, i4);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.A06);
        parcel.writeByte(this.A0B ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0C ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A05);
        parcel.writeLong(this.A04);
        int size = this.A07.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.A07.get(i3).A01(parcel);
        }
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
