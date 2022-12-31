package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class ER {
    public static String[] A0B = {"s27kRN", "abG5pKADna", "w2jztrB", "I7geUVX8H5XW4NGFgS7QGYJa3", "W37aGUNVZO5G", "W3qhVhIXcY", "2nbP2bKsNJFzfOABHc993I7Qj", "6HcftuEFFeXx4hy"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<EQ> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    public ER(long j2, boolean z, boolean z2, boolean z3, List<EQ> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
        this.A04 = j2;
        this.A0A = z;
        this.A08 = z2;
        this.A09 = z3;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j3;
        this.A07 = z4;
        this.A03 = j4;
        this.A02 = i2;
        this.A00 = i3;
        this.A01 = i4;
    }

    public ER(Parcel parcel) {
        EQ A00;
        this.A04 = parcel.readLong();
        this.A0A = parcel.readByte() == 1;
        this.A08 = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            A00 = EQ.A00(parcel);
            arrayList.add(A00);
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        this.A07 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public static ER A00(Parcel parcel) {
        return new ER(parcel);
    }

    public static /* synthetic */ ER A01(Parcel parcel) {
        return A00(parcel);
    }

    public static ER A02(IV iv) {
        long A0M = iv.A0M();
        boolean autoReturn = (iv.A0E() & 128) != 0;
        boolean z = false;
        boolean z2 = false;
        long j2 = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int headerByte = 0;
        int i3 = 0;
        boolean z3 = false;
        long j3 = -9223372036854775807L;
        if (!autoReturn) {
            int A0E = iv.A0E();
            if (A0B[2].length() != 7) {
                throw new RuntimeException();
            }
            A0B[6] = "oYMFgXMCdR9ldlOsYeO";
            z = (A0E & 128) != 0;
            z2 = (A0E & 64) != 0;
            boolean z4 = (A0E & 32) != 0;
            if (z2) {
                j2 = iv.A0M();
            }
            if (!z2) {
                int A0E2 = iv.A0E();
                arrayList = new ArrayList(A0E2);
                for (int i4 = 0; i4 < A0E2; i4++) {
                    arrayList.add(new EQ(iv.A0E(), iv.A0M(), null));
                }
            }
            if (z4) {
                int componentCount = iv.A0E();
                long j4 = componentCount;
                int i5 = ((128 & j4) > 0L ? 1 : ((128 & j4) == 0L ? 0 : -1));
                z3 = i5 != 0;
                long breakDuration90khz = ((1 & j4) << 32) | iv.A0M();
                j3 = (1000 * breakDuration90khz) / 90;
            }
            i2 = iv.A0I();
            headerByte = iv.A0E();
            i3 = iv.A0E();
        }
        return new ER(A0M, autoReturn, z, z2, arrayList, j2, z3, j3, i2, headerByte, i3);
    }

    public static /* synthetic */ ER A03(IV iv) {
        return A02(iv);
    }

    public void A04(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A06.get(i2).A02(parcel);
        }
        parcel.writeLong(this.A05);
        parcel.writeByte(this.A07 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }

    public static /* synthetic */ void A05(ER er, Parcel parcel) {
        er.A04(parcel);
    }
}
