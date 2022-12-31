package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.util.Arrays;
@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.1c */
/* loaded from: assets/audience_network.dex */
public final class C04991c extends AnonymousClass39 implements IM {
    public static byte[] A0E;
    public static String[] A0F = {"aLXIjAOeq43kD47uUx47KIQfBztZ5JR6", "bYDvuG1CO7Q3NDumZhhBhB8jHe", "lzauC9VKCpzgBdv7KHug0xPju0EyyDRc", "zBmjWuq", "FwqFg", "FmVSMSIXQUSd0OcxsELVimAN3SmZwHxI", "I9K2sHUvqtNZm1Rj9xJMtQcmEPzsJytW", "SRtBuggTCbvw2MXSYfok3SEL95E53gc0"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaFormat A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final Context A0B;
    public final BF A0C;
    public final BL A0D;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 16);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0E = new byte[]{7, 5, 16, 102, 27, Draft_75.CR, 11, 102, 41, 41, 43, 102, 44, 45, 43, 65, 67, 86, 32, 105, 97, 97, 105, 98, 107, 32, 124, 111, 121, 32, 106, 107, 109, 97, 106, 107, 124, 54, 57, 51, 37, 56, 62, 51, 121, 36, 56, 49, 35, 32, 54, 37, 50, 121, 59, 50, 54, 57, 53, 54, 52, 60, 64, 84, 69, 72, 78, 14, 83, 64, 86, 24, 19, 26, 21, 21, 30, 23, 86, 24, 20, 14, 21, 15, 63, 50, 37, 56, 59, 35, 50, 76, 65, 86, 75, 85, 72, 80, 65, 95, 83, 74, 31, 91, 92, 66, 71, 70, 31, 65, 91, 72, 87, 70, 66, 70, 78, 48, 50, 41, 47, 50, 41, 52, 57, 121, 107, 103, 122, 102, 111, 39, 120, 107, 126, 111, 70, 84, 88, 70, 64, 91, 82, 5, 26, Draft_75.CR, 16, 25, 19, 11, 26};
    }

    static {
        A06();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C04991c(Context context, InterfaceC0805Dt interfaceC0805Dt, @Nullable C9<WT> c9, boolean z, @Nullable Handler handler, @Nullable BG bg, @Nullable B1 b1, B8... b8Arr) {
        this(context, interfaceC0805Dt, c9, z, handler, bg, new C1270Wg(b1, b8Arr));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C04991c(Context context, InterfaceC0805Dt interfaceC0805Dt, @Nullable C9<WT> c9, boolean z, @Nullable Handler handler, @Nullable BG bg, BL bl) {
        super(1, interfaceC0805Dt, c9, z);
        this.A0B = context.getApplicationContext();
        this.A0D = bl;
        this.A0C = new BF(handler, bg);
        bl.AEP(new C1268We(this));
    }

    private int A00(C0799Dn c0799Dn, Format format) {
        PackageManager packageManager;
        if (C0923Il.A02 < 24) {
            if (A04(15, 22, 30).equals(c0799Dn.A02)) {
                boolean z = true;
                if (C0923Il.A02 == 23 && (packageManager = this.A0B.getPackageManager()) != null && packageManager.hasSystemFeature(A04(37, 25, 71))) {
                    z = false;
                }
                if (z) {
                    return -1;
                }
            }
        }
        return format.A09;
    }

    private final int A01(C0799Dn c0799Dn, Format format, Format[] formatArr) {
        return A00(c0799Dn, format);
    }

    @SuppressLint({"InlinedApi"})
    private final MediaFormat A02(Format format, String str, int i2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A04(113, 4, 59), str);
        mediaFormat.setInteger(A04(71, 13, 107), format.A05);
        mediaFormat.setInteger(A04(125, 11, 26), format.A0C);
        C0811Dz.A06(mediaFormat, format.A0P);
        C0811Dz.A04(mediaFormat, A04(99, 14, 34), i2);
        if (C0923Il.A02 >= 23) {
            mediaFormat.setInteger(A04(117, 8, 80), 0);
        }
        return mediaFormat;
    }

    private void A05() {
        long A6C = this.A0D.A6C(A8J());
        if (A6C != Long.MIN_VALUE) {
            if (!this.A08) {
                A6C = Math.max(this.A05, A6C);
            }
            this.A05 = A6C;
            this.A08 = false;
        }
    }

    public static boolean A08(String str) {
        if (C0923Il.A02 < 24 && A04(0, 15, 88).equals(str)) {
            if (A04(136, 7, 37).equals(C0923Il.A05) && (C0923Il.A03.startsWith(A04(143, 8, 111)) || C0923Il.A03.startsWith(A04(84, 7, 71)) || C0923Il.A03.startsWith(A04(91, 8, 52)))) {
                return true;
            }
        }
        return false;
    }

    private final boolean A09(String str) {
        int A00 = IO.A00(str);
        if (A00 != 0) {
            boolean A8I = this.A0D.A8I(A00);
            if (A0F[5].charAt(2) != 'V') {
                throw new RuntimeException();
            }
            A0F[1] = "OP";
            if (A8I) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A12() {
        try {
            this.A0D.ADS();
            try {
                super.A12();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.A12();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A13() {
        super.A13();
        this.A0D.ACw();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A14() {
        A05();
        this.A0D.pause();
        super.A14();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A15(long j2, boolean z) throws A9 {
        super.A15(j2, z);
        this.A0D.reset();
        this.A05 = j2;
        this.A07 = true;
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A16(boolean z) throws A9 {
        super.A16(z);
        this.A0C.A05(this.A0U);
        int i2 = A11().A00;
        if (i2 != 0) {
            this.A0D.A58(i2);
        } else {
            this.A0D.A4m();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final int A1A(MediaCodec mediaCodec, C0799Dn c0799Dn, Format format, Format format2) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x00cf, code lost:
        if (r7 != (-1)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00d7, code lost:
        if (r4.A0G(r17.A0C) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x00db, code lost:
        if (r17.A05 == (-1)) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00e3, code lost:
        if (r4.A0F(r17.A05) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00fa, code lost:
        if (r7 != (-1)) goto L52;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    /* JADX WARN: Incorrect condition in loop: B:98:0x0074 */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00ec  */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A1B(com.facebook.ads.redexgen.X.InterfaceC0805Dt r15, com.facebook.ads.redexgen.X.C9<com.facebook.ads.redexgen.X.WT> r16, com.facebook.ads.internal.exoplayer2.Format r17) throws com.facebook.ads.redexgen.X.C0808Dw {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C04991c.A1B(com.facebook.ads.redexgen.X.Dt, com.facebook.ads.redexgen.X.C9, com.facebook.ads.internal.exoplayer2.Format):int");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final C0799Dn A1E(InterfaceC0805Dt interfaceC0805Dt, Format format, boolean z) throws C0808Dw {
        C0799Dn A73;
        if (A09(format.A0O) && (A73 = interfaceC0805Dt.A73()) != null) {
            return A73;
        }
        return super.A1E(interfaceC0805Dt, format, z);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1H() throws A9 {
        try {
            this.A0D.ACx();
        } catch (BK e2) {
            throw A9.A01(e2, A0y());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1K(MediaCodec mediaCodec, MediaFormat mediaFormat) throws A9 {
        int i2;
        int[] iArr;
        int i3;
        MediaFormat mediaFormat2 = this.A06;
        if (mediaFormat2 != null) {
            i2 = IO.A00(mediaFormat2.getString(A04(113, 4, 59)));
            mediaFormat = this.A06;
        } else {
            i2 = this.A04;
        }
        int integer = mediaFormat.getInteger(A04(71, 13, 107));
        int integer2 = mediaFormat.getInteger(A04(125, 11, 26));
        if (this.A09 && integer == 6 && (i3 = this.A00) < 6) {
            iArr = new int[i3];
            for (int i4 = 0; i4 < this.A00; i4++) {
                iArr[i4] = i4;
            }
        } else {
            iArr = null;
        }
        try {
            this.A0D.A44(i2, integer, integer2, 0, iArr, this.A02, this.A03);
        } catch (BH e2) {
            throw A9.A01(e2, A0y());
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1L(Format format) throws A9 {
        int i2;
        super.A1L(format);
        this.A0C.A03(format);
        if (A04(62, 9, 49).equals(format.A0O)) {
            i2 = format.A0A;
        } else {
            i2 = 2;
        }
        this.A04 = i2;
        this.A00 = format.A05;
        this.A02 = format.A06;
        this.A03 = format.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1M(WZ wz) {
        if (this.A07 && !wz.A03()) {
            if (Math.abs(wz.A00 - this.A05) > 500000) {
                this.A05 = wz.A00;
            }
            this.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1N(C0799Dn c0799Dn, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.A01 = A01(c0799Dn, format, A19());
        this.A09 = A08(c0799Dn.A02);
        this.A0A = c0799Dn.A04;
        MediaFormat A02 = A02(format, c0799Dn.A01 == null ? A04(62, 9, 49) : c0799Dn.A01, this.A01);
        mediaCodec.configure(A02, (Surface) null, mediaCrypto, 0);
        if (this.A0A) {
            this.A06 = A02;
            this.A06.setString(A04(113, 4, 59), format.A0O);
            return;
        }
        this.A06 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final void A1O(String str, long j2, long j3) {
        this.A0C.A06(str, j2, j3);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39
    public final boolean A1P(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws A9 {
        if (this.A0A && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.A0U.A08++;
            this.A0D.A7p();
            return true;
        } else {
            try {
                if (this.A0D.A7m(byteBuffer, j4)) {
                    mediaCodec.releaseOutputBuffer(i2, false);
                    this.A0U.A06++;
                    return true;
                }
                return false;
            } catch (BI | BK e2) {
                throw A9.A01(e2, A0y());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df, com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final IM A6r() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU A78() {
        return this.A0D.A78();
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final long A7B() {
        if (A7Q() == 2) {
            A05();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df, com.facebook.ads.redexgen.X.InterfaceC0724Ae
    public final void A7q(int i2, Object obj) throws A9 {
        if (i2 != 2) {
            if (i2 != 3) {
                super.A7q(i2, obj);
                return;
            }
            this.A0D.AEI((B0) obj);
            return;
        }
        BL bl = this.A0D;
        if (A0F[7].charAt(17) == 'P') {
            throw new RuntimeException();
        }
        A0F[4] = "awvXiH99cLu1HaadjiPENScqQYAeI";
        bl.setVolume(((Float) obj).floatValue());
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8J() {
        return super.A8J() && this.A0D.A8J();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass39, com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8U() {
        return this.A0D.A7v() || super.A8U();
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU AET(AU au) {
        return this.A0D.AET(au);
    }
}
