package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.dI  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1563dI implements C0G {
    public static byte[] A03;
    public static String[] A04 = {"P4WBUOUbWFZVPUfllum665PEFtgA", "hl2hcMpTCTU39UgF1EW38AmixRhm49P4", "sNWuTokwvfj2sOZCyjSoO11B4mAkUdMG", "H", "URwERncuc0axl8tzw7s1hCSOmGWPEg1Z", "US601emoXJvV4DnAkF2mociZLiAqpNhW", Constants.VIA_SHARE_TYPE_INFO, "hJG0zhFr2Lsx"};
    public File A00;
    public RandomAccessFile A01;
    public final C0B A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-99, -34, -16, -99, -31, -26, -16, -32, -99, -32, -34, -32, -27, -30, 101, -85, -76, -73, 101, -88, -76, -78, -75, -79, -86, -71, -82, -76, -77, 102, -65, 8, 18, -65, 2, 14, 12, 15, 11, 4, 19, 4, 3, -64, -59, 25, 20, -59, 102, -100, -89, -81, -90, -92, -89, -103, -100, 114, -112, -99, 86, -93, 79, -110, -101, -108, -112, -99, 79, -107, -104, -101, -108, -94, -49, -49, -52, -49, 125, -66, -51, -51, -62, -53, -63, 125, -64, -66, -64, -59, -62, -105, 125, -64, -66, -64, -59, -62, 125, -61, -58, -55, -62, 125, -47, -2, -2, -5, -2, -84, -17, -8, -5, -1, -11, -6, -13, -84, -14, -11, -8, -15, -84, -22, 23, 23, 20, 23, -59, 20, 21, 10, 19, 14, 19, 12, -59, -65, -20, -20, -23, -20, -102, -20, -33, -37, -34, -29, -24, -31, -102, -26, -33, -24, -31, -18, -30, -102, -23, -32, -102, -32, -29, -26, -33, -102, -106, -61, -61, -64, -61, 113, -61, -74, -65, -78, -66, -70, -65, -72, 113, -73, -70, -67, -74, 113, -20, 25, 25, 22, 25, -57, 28, 26, 16, 21, 14, -57, Draft_75.CR, 16, 19, 12, -57, -41, 4, 4, 1, 4, -78, 9, 4, -5, 6, -5, 0, -7, -78, -73, -10, -78, -12, 11, 6, -9, 5, -78, 6, 1, -78, -73, 5, -78, -8, 4, 1, -1, -78, -12, 7, -8, -8, -9, 4, -78, 9, -5, 6, -6, -78, 5, -5, 12, -9, -78, -73, -10, -34, 18, 23};
    }

    static {
        A01();
    }

    public C1563dI(File file, C0B c0b) throws C1561dG {
        File file2;
        try {
            if (c0b != null) {
                this.A02 = c0b;
                C0E.A06(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + A00(48, 9, 15));
                }
                this.A00 = file2;
                this.A01 = new RandomAccessFile(this.A00, exists ? A00(256, 1, 67) : A00(257, 2, 119));
                return;
            }
            throw new NullPointerException();
        } catch (IOException e2) {
            throw new C1561dG(A00(186, 17, 126) + file + A00(0, 14, 84), e2);
        }
    }

    private boolean A02(File file) {
        return file.getName().endsWith(A00(48, 9, 15));
    }

    public final synchronized int A03() throws C1561dG {
        try {
        } catch (IOException e2) {
            throw new C1561dG(A00(137, 29, 81) + this.A00, e2);
        }
        return (int) this.A01.length();
    }

    public final File A04() {
        return this.A00;
    }

    public final synchronized void A05() throws C1561dG {
        try {
            this.A01.setLength(0L);
        } catch (IOException e2) {
            throw new C1561dG(A00(57, 16, 6), e2);
        }
        String[] strArr = A04;
        if (strArr[7].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[2] = "4ly1cFvfi9Man28fVF2v4dhkOJlcUKEY";
    }

    public final synchronized void A06() throws C1561dG {
        try {
            this.A01.close();
            this.A02.AF0(this.A00);
        } catch (IOException e2) {
            throw new C1561dG(A00(104, 19, 99) + this.A00, e2);
        }
    }

    public final synchronized void A07() throws C1561dG {
        if (A09()) {
            return;
        }
        A06();
        File file = new File(this.A00.getParentFile(), this.A00.getName().substring(0, this.A00.getName().length() - A00(48, 9, 15).length()));
        File completedFile = this.A00;
        boolean renamed = completedFile.renameTo(file);
        if (renamed) {
            this.A00 = file;
            try {
                this.A01 = new RandomAccessFile(this.A00, A00(256, 1, 67));
                return;
            } catch (IOException e2) {
                throw new C1561dG(A00(123, 14, 124) + this.A00 + A00(0, 14, 84), e2);
            }
        }
        throw new C1561dG(A00(166, 20, 40) + this.A00 + A00(44, 4, 124) + file + A00(14, 16, 28));
    }

    public final synchronized void A08(byte[] bArr, int i2) throws C1561dG {
        try {
            if (!A09()) {
                this.A01.seek(A03());
                this.A01.write(bArr, 0, i2);
            } else {
                throw new C1561dG(A00(73, 31, 52) + this.A00 + A00(30, 14, 118));
            }
        } catch (IOException e2) {
            throw new C1561dG(String.format(Locale.US, A00(203, 53, 105), Integer.valueOf(i2), this.A01, Integer.valueOf(bArr.length)), e2);
        }
    }

    public final synchronized boolean A09() {
        return !A02(this.A00);
    }
}
