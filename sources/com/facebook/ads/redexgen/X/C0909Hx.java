package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
/* renamed from: com.facebook.ads.redexgen.X.Hx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0909Hx {
    public static byte[] A05;
    public static String[] A06 = {"MBceJWRKAgeQJNY3ZRBdRhYJgpL3jkFQ", "518xlpwWcjlWASul8lHAahT8PqQVPF3u", "9RLjFZMlaqPSYVxgrCr3N29CAF4vaCFh", "Nd9PnywG3g8LluWsmNbg8PXBjZKSlX8G", "s", "C1TdeuC5gtnvKYkq95Rq", "MkXsOhuicHq9DXlwRCZefot2VxsvXJH1", "VJm3srbtmlXEw3gKHWc"};
    public boolean A01;
    public final int A02;
    public final String A03;
    public UK A00 = UK.A04;
    public final TreeSet<UI> A04 = new TreeSet<>();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{70, 0, 7, 15, 10, 3, 2, 72, 58, 110, 117, 58, 0, 55, 60, 51, 63, 59, 60, 53, 114, 61, 52, 114};
    }

    static {
        A02();
    }

    public C0909Hx(int i2, String str) {
        this.A02 = i2;
        this.A03 = str;
    }

    public static C0909Hx A00(int id, DataInputStream dataInputStream) throws IOException {
        C0909Hx c0909Hx = new C0909Hx(dataInputStream.readInt(), dataInputStream.readUTF());
        if (id < 2) {
            long readLong = dataInputStream.readLong();
            I2 mutations = new I2();
            I1.A05(mutations, readLong);
            c0909Hx.A0F(mutations);
        } else {
            UK A00 = UK.A00(dataInputStream);
            if (A06[4].length() == 13) {
                throw new RuntimeException();
            }
            A06[1] = "w2ExrNvXNhLYBLEt12rGyqcfRXmaXRhw";
            c0909Hx.A00 = A00;
        }
        return c0909Hx;
    }

    public final int A03(int result) {
        int hashCode = (this.A02 * 31) + this.A03.hashCode();
        if (result < 2) {
            long A00 = I1.A00(this.A00);
            return (hashCode * 31) + ((int) ((A00 >>> 32) ^ A00));
        }
        return (hashCode * 31) + this.A00.hashCode();
    }

    public final long A04(long queryEndPosition, long currentEndPosition) {
        UI A062 = A06(queryEndPosition);
        if (A062.A01()) {
            long j2 = -Math.min(A062.A02() ? LocationRequestCompat.PASSIVE_INTERVAL : A062.A01, currentEndPosition);
            if (A06[3].charAt(14) != 'W') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "ZNj15xTvoSD0UBJTiXr";
            strArr[5] = "u99g5dbJfvVcRXaISwTW";
            return j2;
        }
        long j3 = queryEndPosition + currentEndPosition;
        long j4 = A062.A02 + A062.A01;
        if (j4 < j3) {
            for (UI ui : this.A04.tailSet(A062, false)) {
                if (ui.A02 > j4) {
                    break;
                }
                j4 = Math.max(j4, ui.A02 + ui.A01);
                if (j4 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j4 - queryEndPosition, currentEndPosition);
    }

    public final I0 A05() {
        return this.A00;
    }

    public final UI A06(long j2) {
        UI A01 = UI.A01(this.A03, j2);
        UI floor = this.A04.floor(A01);
        if (floor != null && floor.A02 + floor.A01 > j2) {
            return floor;
        }
        UI ceiling = this.A04.ceiling(A01);
        if (ceiling == null) {
            return UI.A02(this.A03, j2);
        }
        return UI.A03(this.A03, j2, ceiling.A02 - j2);
    }

    public final UI A07(UI ui) throws C0900Ho {
        I6.A04(this.A04.remove(ui));
        UI A08 = ui.A08(this.A02);
        if (ui.A03.renameTo(A08.A03)) {
            this.A04.add(A08);
            return A08;
        }
        throw new C0900Ho(A01(12, 12, 78) + ui.A03 + A01(8, 4, 6) + A08.A03 + A01(0, 8, 122));
    }

    public final TreeSet<UI> A08() {
        return this.A04;
    }

    public final void A09(UI ui) {
        this.A04.add(ui);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A02);
        dataOutputStream.writeUTF(this.A03);
        this.A00.A09(dataOutputStream);
    }

    public final void A0B(boolean z) {
        this.A01 = z;
    }

    public final boolean A0C() {
        return this.A04.isEmpty();
    }

    public final boolean A0D() {
        return this.A01;
    }

    public final boolean A0E(C0906Hu c0906Hu) {
        if (this.A04.remove(c0906Hu)) {
            c0906Hu.A03.delete();
            return true;
        }
        return false;
    }

    public final boolean A0F(I2 i2) {
        UK uk = this.A00;
        this.A00 = this.A00.A08(i2);
        return !this.A00.equals(uk);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0909Hx c0909Hx = (C0909Hx) obj;
        if (this.A02 == c0909Hx.A02 && this.A03.equals(c0909Hx.A03)) {
            TreeSet<UI> treeSet = this.A04;
            if (A06[4].length() == 13) {
                throw new RuntimeException();
            }
            A06[4] = "qw9AeUbTiw";
            if (treeSet.equals(c0909Hx.A04) && this.A00.equals(c0909Hx.A00)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (A03(Integer.MAX_VALUE) * 31) + this.A04.hashCode();
    }
}
