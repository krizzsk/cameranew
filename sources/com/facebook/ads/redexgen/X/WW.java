package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.CA;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@TargetApi(18)
/* loaded from: assets/audience_network.dex */
public final class WW<T extends CA> implements C8<T> {
    public static byte[] A0K;
    public static String[] A0L = {"ygnbftuzQ623Ar", "0dBxCv", "0mS6EqtDw1IrcjMleAT8IB1AlC6o9dAz", "RvmLzAjUPGIONaTchxcxVzTcBBQZgw7Y", "nJTfBRZW6rn0", "sj1G7dKmGRmO2HqivExl", "qBp8iQwY5MoBhJy8uyiyd2Hnkft4tubm", "GRqzAUhZ8aAEJGz"};
    public int A00;
    public int A01;
    public HandlerThread A02;
    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/WW<TT;>.PostRequestHandler; */
    public HandlerC0758Bo A03;
    public C6 A04;
    public T A05;
    public Object A06;
    public Object A07;
    public byte[] A08;
    public byte[] A09;
    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/WW<TT;>.PostResponseHandler; */
    public final HandlerC0759Bp A0A;
    public final CK A0B;
    public final UUID A0C;
    public final int A0D;
    public final int A0E;
    public final InterfaceC0760Bq<T> A0F;
    public final C0766Bw A0G;
    public final DrmInitData.SchemeData A0H;
    public final CG<T> A0I;
    public final HashMap<String, String> A0J;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private long A01() {
        if (A3.A05.equals(this.A0C)) {
            Pair<Long, Long> A01 = CO.A01(this);
            return Math.min(((Long) A01.first).longValue(), ((Long) A01.second).longValue());
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0K = new byte[]{38, 71, 72, 67, 87, 78, 86, 38, 84, 79, 53, 71, 85, 85, 75, 81, 80, -51, -5, -10, -37, -18, -6, -2, -18, -4, -3, -47, -22, -9, -19, -11, -18, -5, -55, -10, -10, -13, -10, -92, -8, -10, -3, -19, -14, -21, -92, -8, -13, -92, -10, -23, -9, -8, -13, -10, -23, -92, -37, -19, -24, -23, -6, -19, -14, -23, -92, -17, -23, -3, -9, -78, -23, 0, 0, 6, 3, 8, -1, -70, 6, 3, -3, -1, 8, Draft_75.CR, -1, -70, 2, -5, Draft_75.CR, -70, -1, 18, 10, 3, 12, -1, -2, -70, 9, 12, -70, 17, 3, 6, 6, -70, -1, 18, 10, 3, 12, -1, -70, Draft_75.CR, 9, 9, 8, -56, -70, -20, -1, 7, -5, 3, 8, 3, 8, 1, -70, Draft_75.CR, -1, -3, 9, 8, -2, Draft_75.CR, -44, -70};
    }

    static {
        A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bq != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession$ProvisioningManager<T extends com.facebook.ads.redexgen.X.CA> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.CG != com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm<T extends com.facebook.ads.redexgen.X.CA> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public WW(UUID uuid, CG<T> cg, InterfaceC0760Bq<T> interfaceC0760Bq, @Nullable DrmInitData.SchemeData schemeData, int i2, @Nullable byte[] bArr, HashMap<String, String> hashMap, CK ck, Looper looper, C0766Bw c0766Bw, int i3) {
        this.A0C = uuid;
        this.A0F = interfaceC0760Bq;
        this.A0I = cg;
        this.A0E = i2;
        this.A08 = bArr;
        this.A0H = bArr != null ? null : schemeData;
        this.A0J = hashMap;
        this.A0B = ck;
        this.A0D = i3;
        this.A0G = c0766Bw;
        this.A01 = 2;
        this.A0A = new HandlerC0759Bp(this, looper);
        this.A02 = new HandlerThread(A02(17, 17, 29));
        this.A02.start();
        this.A03 = new HandlerC0758Bo(this, this.A02.getLooper());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private void A03() {
        if (this.A01 == 4) {
            this.A01 = 3;
            A08(new CJ());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private void A05(int i2, boolean z) {
        byte[] bArr = i2 == 3 ? this.A08 : this.A09;
        byte[] bArr2 = null;
        String mimeType = null;
        String licenseServerUrl = null;
        DrmInitData.SchemeData schemeData = this.A0H;
        if (schemeData != null) {
            bArr2 = schemeData.A04;
            mimeType = this.A0H.A02;
            licenseServerUrl = this.A0H.A01;
        }
        try {
            this.A06 = Pair.create(this.A0I.getKeyRequest(bArr, bArr2, mimeType, i2, this.A0J), licenseServerUrl);
            this.A03.A02(1, this.A06, z);
        } catch (Exception e2) {
            A09(e2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private void A08(Exception exc) {
        this.A04 = new C6(exc);
        this.A0G.A04(exc);
        if (this.A01 != 4) {
            this.A01 = 1;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private void A09(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.A0F.AD8(this);
        } else {
            A08(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r4 == 3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4 == 3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r5.A0I.provideKeyResponse(r5.A08, r7);
        r5.A0G.A01();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        r2 = r5.A0I.provideKeyResponse(r5.A09, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (r5.A0E == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r5.A0E != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (r5.A08 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r2.length == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        r5.A08 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        r5.A01 = 4;
        r5.A0G.A00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0A(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.A06
            if (r6 != r0) goto L23
            boolean r3 = r5.A0D()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.WW.A0L
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 19
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.WW.A0L
            java.lang.String r1 = "Dj52Xz5E9G6B"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "yQtL6VAJC1YqjW"
            r0 = 0
            r2[r0] = r1
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            r0 = 0
            r5.A06 = r0
            boolean r0 = r7 instanceof java.lang.Exception
            if (r0 == 0) goto L31
            java.lang.Exception r7 = (java.lang.Exception) r7
            r5.A09(r7)
            return
        L31:
            byte[] r7 = (byte[]) r7     // Catch: java.lang.Exception -> L83
            int r4 = r5.A0E     // Catch: java.lang.Exception -> L83
            r3 = 3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.WW.A0L
            r0 = 3
            r1 = r1[r0]
            r0 = 22
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L4f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.WW.A0L
            java.lang.String r1 = "2X8HJVAZNrszLj0VXzfxBiDDerG65NXA"
            r0 = 2
            r2[r0] = r1
            if (r4 != r3) goto L5e
            goto L51
        L4f:
            if (r4 != r3) goto L5e
        L51:
            com.facebook.ads.redexgen.X.CG<T extends com.facebook.ads.redexgen.X.CA> r1 = r5.A0I     // Catch: java.lang.Exception -> L83
            byte[] r0 = r5.A08     // Catch: java.lang.Exception -> L83
            r1.provideKeyResponse(r0, r7)     // Catch: java.lang.Exception -> L83
            com.facebook.ads.redexgen.X.Bw r0 = r5.A0G     // Catch: java.lang.Exception -> L83
            r0.A01()     // Catch: java.lang.Exception -> L83
            goto L87
        L5e:
            com.facebook.ads.redexgen.X.CG<T extends com.facebook.ads.redexgen.X.CA> r1 = r5.A0I     // Catch: java.lang.Exception -> L83
            byte[] r0 = r5.A09     // Catch: java.lang.Exception -> L83
            byte[] r2 = r1.provideKeyResponse(r0, r7)     // Catch: java.lang.Exception -> L83
            int r1 = r5.A0E     // Catch: java.lang.Exception -> L83
            r0 = 2
            if (r1 == r0) goto L73
            int r0 = r5.A0E     // Catch: java.lang.Exception -> L83
            if (r0 != 0) goto L7a
            byte[] r0 = r5.A08     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L7a
        L73:
            if (r2 == 0) goto L7a
            int r0 = r2.length     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto L7a
            r5.A08 = r2     // Catch: java.lang.Exception -> L83
        L7a:
            r0 = 4
            r5.A01 = r0     // Catch: java.lang.Exception -> L83
            com.facebook.ads.redexgen.X.Bw r0 = r5.A0G     // Catch: java.lang.Exception -> L83
            r0.A00()     // Catch: java.lang.Exception -> L83
            goto L87
        L83:
            r0 = move-exception
            r5.A09(r0)
        L87:
            return
        L88:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WW.A0A(java.lang.Object, java.lang.Object):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public void A0B(Object obj, Object obj2) {
        if (obj == this.A07) {
            if (this.A01 != 2 && !A0D()) {
                return;
            }
            this.A07 = null;
            if (obj2 instanceof Exception) {
                this.A0F.ABm((Exception) obj2);
                return;
            }
            try {
                this.A0I.provideProvisionResponse((byte[]) obj2);
                this.A0F.ABl();
            } catch (Exception e2) {
                InterfaceC0760Bq<T> interfaceC0760Bq = this.A0F;
                String[] strArr = A0L;
                if (strArr[4].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                A0L[2] = "a4sDA20kWFGOKzGfRWeaug5eKqIpzvIQ";
                interfaceC0760Bq.ABm(e2);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private void A0C(boolean z) {
        int i2 = this.A0E;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3 || !A0E()) {
                    return;
                }
                A05(3, z);
                return;
            }
            byte[] bArr = this.A08;
            if (A0L[5].length() == 7) {
                throw new RuntimeException();
            }
            A0L[3] = "nvqtgBbI1rUZtdpDbdJLT2qwzjn5A3EQ";
            if (bArr == null) {
                A05(2, z);
            } else if (!A0E()) {
            } else {
                A05(2, z);
            }
        } else if (this.A08 == null) {
            A05(1, z);
        } else if (this.A01 != 4 && !A0E()) {
        } else {
            long A01 = A01();
            if (this.A0E == 0 && A01 <= 60) {
                String str = A02(72, 68, 46) + A01;
                A05(2, z);
            } else if (A01 <= 0) {
                A08(new CJ());
            } else {
                this.A01 = 4;
                this.A0G.A02();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private boolean A0D() {
        int i2 = this.A01;
        return i2 == 3 || i2 == 4;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private boolean A0E() {
        try {
            this.A0I.restoreKeys(this.A09, this.A08);
            return true;
        } catch (Exception e2) {
            Log.e(A02(0, 17, 118), A02(34, 38, 24), e2);
            A08(e2);
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    private boolean A0F(boolean z) {
        if (A0D()) {
            return true;
        }
        try {
            this.A09 = this.A0I.openSession();
            this.A05 = this.A0I.createMediaCrypto(this.A09);
            this.A01 = 3;
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.A0F.AD8(this);
                return false;
            }
            A08(e2);
            return false;
        } catch (Exception e3) {
            A08(e3);
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final void A0G() {
        int i2 = this.A00 + 1;
        this.A00 = i2;
        if (i2 == 1 && this.A01 != 1 && A0F(true)) {
            A0C(true);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final void A0H() {
        if (A0F(false)) {
            A0C(true);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final void A0I() {
        this.A07 = this.A0I.getProvisionRequest();
        this.A03.A02(0, this.A07, true);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final void A0J(int i2) {
        if (A0D()) {
            String[] strArr = A0L;
            if (strArr[4].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A0L[3] = "lZu3kopIqXcrfR3er40TopUaCPNEg1WS";
            if (i2 == 1) {
                this.A01 = 3;
                this.A0F.AD8(this);
            } else if (i2 == 2) {
                A0C(false);
            } else if (i2 != 3) {
            } else {
                A03();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final void A0K(Exception exc) {
        A08(exc);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final boolean A0L() {
        int i2 = this.A00 - 1;
        this.A00 = i2;
        if (i2 == 0) {
            this.A01 = 0;
            this.A0A.removeCallbacksAndMessages(null);
            this.A03.removeCallbacksAndMessages(null);
            this.A03 = null;
            this.A02.quit();
            this.A02 = null;
            this.A05 = null;
            this.A04 = null;
            this.A06 = null;
            this.A07 = null;
            byte[] bArr = this.A09;
            if (bArr != null) {
                this.A0I.closeSession(bArr);
                this.A09 = null;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final boolean A0M(byte[] bArr) {
        DrmInitData.SchemeData schemeData = this.A0H;
        return Arrays.equals(schemeData != null ? schemeData.A04 : null, bArr);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    public final boolean A0N(byte[] bArr) {
        return Arrays.equals(this.A09, bArr);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    @Override // com.facebook.ads.redexgen.X.C8
    public final C6 A6U() {
        if (this.A01 == 1) {
            return this.A04;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    @Override // com.facebook.ads.redexgen.X.C8
    public final T A6s() {
        return this.A05;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    @Override // com.facebook.ads.redexgen.X.C8
    public final int A7Q() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T extends com.facebook.ads.redexgen.X.CA> */
    @Override // com.facebook.ads.redexgen.X.C8
    public final Map<String, String> AD9() {
        byte[] bArr = this.A09;
        if (bArr == null) {
            return null;
        }
        CG<T> cg = this.A0I;
        if (A0L[5].length() != 7) {
            A0L[7] = "lzhfD5NgGZX1H2DfqRAO4AgkK";
            return cg.queryKeyStatus(bArr);
        }
        throw new RuntimeException();
    }
}
