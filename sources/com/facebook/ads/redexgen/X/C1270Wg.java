package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.tencent.matrix.trace.constants.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/* renamed from: com.facebook.ads.redexgen.X.Wg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1270Wg implements BL {
    public static boolean A0p;
    public static boolean A0q;
    public static byte[] A0r;
    public static String[] A0s = {"5Nyv0guRYVcKSAuezGPcUxg9vJAOBGI4", "vvUbbcGamjazB6O7sNKlV2Due1EGN4h1", "bCdq7Y65nqLa7O1PpyZ9UmfFfim1tIKH", "XSMaSGyqY735xp0uf5mX1ioiT5AfU73", "LbuXdG3g6wlkS0wgubrQcd1EFcxL1vaW", "BfdFnDj7fdcaZnnCNK5XWBslzsEwyMTC", "82TROEAjyC6M053XP3PwF3IgkAnZSWb8", "TH4S9e3rxD8emXavfeipeAwkF3kWLOvQ"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public AudioTrack A0M;
    @Nullable
    public AudioTrack A0N;
    @Nullable
    public AU A0O;
    public AU A0P;
    public B0 A0Q;
    @Nullable
    public BJ A0R;
    @Nullable
    public ByteBuffer A0S;
    @Nullable
    public ByteBuffer A0T;
    @Nullable
    public ByteBuffer A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public B8[] A0d;
    public ByteBuffer[] A0e;
    public final ConditionVariable A0f;
    @Nullable
    public final B1 A0g;
    public final BR A0h;
    public final C1273Wj A0i;
    public final BU A0j;
    public final C1264Wa A0k;
    public final ArrayDeque<BW> A0l;
    public final boolean A0m;
    public final B8[] A0n;
    public final B8[] A0o;

    public static String A0I(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0r, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 75);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0r = new byte[]{68, 72, 15, 7, 28, 72, 94, 106, 123, 118, 112, 75, 109, 126, 124, 116, 78, 99, 121, 105, 101, 100, 126, 99, 100, Byte.MAX_VALUE, 99, 126, 115, 42, 110, 111, 126, 111, 105, 126, 111, 110, 42, 81, 111, 114, 122, 111, 105, 126, 111, 110, 42, 14, 22, 9, 4, 9, 1, 8, 63, 41, 63, 46, 46, 51, 52, 61, 122, 41, 46, 59, 54, 54, 63, 62, 122, 59, 47, 62, 51, 53, 122, 46, 40, 59, 57, 49, 102, 93, 86, 75, 67, 86, 80, 71, 86, 87, 19, 82, 70, 87, 90, 92, 19, 86, 93, 80, 92, 87, 90, 93, 84, 9, 19, 96, 91, 70, 64, 69, 69, 90, 71, 65, 80, 81, 21, 86, 93, 84, 91, 91, 80, 89, 21, 86, 90, 64, 91, 65, 15, 21, 101, 10, 3, 31, 24, 9, 30, 59, 40, 58, 40};
    }

    static {
        A0O();
        A0p = false;
        A0q = false;
    }

    public C1270Wg(@Nullable B1 b1, BU bu, boolean z) {
        this.A0g = b1;
        this.A0j = (BU) I6.A01(bu);
        this.A0m = z;
        this.A0f = new ConditionVariable(true);
        this.A0h = new BR(new C1271Wh(this, null));
        this.A0i = new C1273Wj();
        this.A0k = new C1264Wa();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C1267Wd(), this.A0i, this.A0k);
        Collections.addAll(arrayList, bu.A5i());
        this.A0o = (B8[]) arrayList.toArray(new B8[arrayList.size()]);
        this.A0n = new B8[]{new C1269Wf()};
        this.A00 = 1.0f;
        this.A0D = 0;
        this.A0Q = B0.A04;
        this.A01 = 0;
        this.A0P = AU.A04;
        this.A04 = -1;
        this.A0d = new B8[0];
        this.A0e = new ByteBuffer[0];
        this.A0l = new ArrayDeque<>();
    }

    public C1270Wg(@Nullable B1 b1, B8[] b8Arr) {
        this(b1, b8Arr, false);
    }

    public C1270Wg(@Nullable B1 b1, B8[] b8Arr, boolean z) {
        this(b1, new C1272Wi(b8Arr), z);
    }

    public static int A00(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return BY.A00(byteBuffer);
        }
        if (i2 == 5) {
            return C0742Ax.A00();
        }
        if (i2 == 6) {
            return C0742Ax.A03(byteBuffer);
        }
        if (i2 == 14) {
            int A02 = C0742Ax.A02(byteBuffer);
            if (A02 == -1) {
                return 0;
            }
            int A04 = C0742Ax.A04(byteBuffer, A02);
            String[] strArr = A0s;
            if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            A0s[3] = "Dqt88CMr8vwwAc3fZIJcRVt2XyhD8Cl";
            return A04 * 16;
        }
        throw new IllegalStateException(A0I(84, 27, 120) + i2);
    }

    @TargetApi(21)
    public static int A01(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @TargetApi(21)
    private int A02(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.A0S == null) {
            this.A0S = ByteBuffer.allocate(16);
            this.A0S.order(ByteOrder.BIG_ENDIAN);
            this.A0S.putInt(1431633921);
        }
        if (this.A03 == 0) {
            this.A0S.putInt(4, i2);
            this.A0S.putLong(8, 1000 * j2);
            this.A0S.position(0);
            this.A03 = i2;
        }
        int remaining = this.A0S.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.A0S, remaining, 1);
            if (write < 0) {
                this.A03 = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int A01 = A01(audioTrack, byteBuffer, i2);
        String[] strArr = A0s;
        if (strArr[4].charAt(9) != strArr[1].charAt(9)) {
            String[] strArr2 = A0s;
            strArr2[5] = "EGdI4VK4aN1uiBzzsuaeFo7lQ03tB7Gh";
            strArr2[2] = "vodoofn0TiYpLi76FRuwTlDh379TFVaK";
            if (A01 < 0) {
                this.A03 = 0;
                return A01;
            }
            this.A03 -= A01;
            return A01;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A0X ? this.A0J / this.A0B : this.A0I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A0X ? this.A0L / this.A09 : this.A0K;
    }

    private long A05(long j2) {
        return A08(this.A0j.A7P()) + j2;
    }

    private long A06(long j2) {
        BW bw = null;
        while (!this.A0l.isEmpty() && j2 >= BW.A00(this.A0l.getFirst())) {
            bw = this.A0l.remove();
        }
        if (bw != null) {
            this.A0P = BW.A02(bw);
            this.A0G = BW.A00(bw);
            this.A0F = BW.A01(bw) - this.A0H;
        }
        if (this.A0P.A01 == 1.0f) {
            return (this.A0F + j2) - this.A0G;
        }
        if (this.A0l.isEmpty()) {
            return this.A0F + this.A0j.A6t(j2 - this.A0G);
        }
        return this.A0F + C0923Il.A0C(j2 - this.A0G, this.A0P.A01);
    }

    private long A07(long j2) {
        return (this.A0A * j2) / 1000000;
    }

    private long A08(long j2) {
        return (1000000 * j2) / this.A0A;
    }

    private long A09(long j2) {
        return (1000000 * j2) / this.A06;
    }

    @TargetApi(21)
    private AudioTrack A0D() {
        AudioAttributes A00;
        if (this.A0b) {
            A00 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            A00 = this.A0Q.A00();
        }
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.A07).setEncoding(this.A08).setSampleRate(this.A0A).build();
        int i2 = this.A01;
        if (i2 == 0) {
            i2 = 0;
        }
        return new AudioTrack(A00, build, this.A02, 1, i2);
    }

    private AudioTrack A0E() throws BI {
        AudioTrack audioTrack;
        if (C0923Il.A02 >= 21) {
            audioTrack = A0D();
        } else {
            int A03 = C0923Il.A03(this.A0Q.A03);
            int i2 = this.A01;
            String[] strArr = A0s;
            String str = strArr[4];
            String str2 = strArr[1];
            int state = str.charAt(9);
            if (state == str2.charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[4] = "uEqtixTroQ47jvhgXsjygxp317gkhCVZ";
            strArr2[1] = "MeWTB72qJhBmjPGmSmxXQDSK14yx53vJ";
            if (i2 == 0) {
                audioTrack = new AudioTrack(A03, this.A0A, this.A07, this.A08, this.A02, 1);
            } else {
                audioTrack = new AudioTrack(A03, this.A0A, this.A07, this.A08, this.A02, 1, i2);
            }
        }
        int state2 = audioTrack.getState();
        if (state2 == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new BI(state2, this.A0A, this.A07, this.A02);
    }

    private AudioTrack A0F(int i2) {
        return new AudioTrack(3, Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM, 4, 2, 2, 0, i2);
    }

    private void A0J() {
        int i2 = 0;
        while (true) {
            B8[] b8Arr = this.A0d;
            if (i2 < b8Arr.length) {
                B8 b8 = b8Arr[i2];
                b8.flush();
                this.A0e[i2] = b8.A6x();
                i2++;
            } else {
                return;
            }
        }
    }

    private void A0K() throws BI {
        AU au;
        this.A0f.block();
        this.A0M = A0E();
        int audioSessionId = this.A0M.getAudioSessionId();
        if (A0p && C0923Il.A02 < 21) {
            AudioTrack audioTrack = this.A0N;
            if (audioTrack != null) {
                int audioSessionId2 = audioTrack.getAudioSessionId();
                String[] strArr = A0s;
                if (strArr[4].charAt(9) == strArr[1].charAt(9)) {
                    throw new RuntimeException();
                }
                A0s[7] = "BXErtyYgJXamt9yde7CeLqS26Q9j6Dt3";
                if (audioSessionId != audioSessionId2) {
                    A0L();
                }
            }
            if (this.A0N == null) {
                this.A0N = A0F(audioSessionId);
            }
        }
        if (this.A01 != audioSessionId) {
            this.A01 = audioSessionId;
            BJ bj = this.A0R;
            if (bj != null) {
                bj.A9w(audioSessionId);
            }
        }
        if (this.A0V) {
            au = this.A0j.A3O(this.A0P);
        } else {
            au = AU.A04;
        }
        this.A0P = au;
        A0N();
        this.A0h.A0G(this.A0M, this.A08, this.A09, this.A02);
        A0M();
    }

    private void A0L() {
        if (this.A0N == null) {
            return;
        }
        AudioTrack audioTrack = this.A0N;
        this.A0N = null;
        new BT(this, audioTrack).start();
    }

    private void A0M() {
        if (!A0U()) {
            return;
        }
        if (C0923Il.A02 >= 21) {
            AudioTrack audioTrack = this.A0M;
            float f2 = this.A00;
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            A0s[7] = "8NL9PZoDB9Ch1WQJQaXfXaVAIVHPoweZ";
            A0Q(audioTrack, f2);
            return;
        }
        A0R(this.A0M, this.A00);
    }

    private void A0N() {
        B8[] A0V;
        ArrayList arrayList = new ArrayList();
        for (B8 b8 : A0V()) {
            if (b8.A8F()) {
                arrayList.add(b8);
            } else {
                b8.flush();
            }
        }
        int size = arrayList.size();
        B8[] b8Arr = new B8[size];
        if (A0s[3].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0s;
        strArr[5] = "YRdEguSYP1wOqJMzR8T0sEbN9ru3F1GF";
        strArr[2] = "jCd7Ib2fALhdhS4xedSLoMHgXMVbMQ2Z";
        this.A0d = (B8[]) arrayList.toArray(b8Arr);
        this.A0e = new ByteBuffer[size];
        A0J();
    }

    private void A0P(long j2) throws BK {
        ByteBuffer input;
        int length = this.A0d.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                input = this.A0e[i2 - 1];
            } else {
                input = this.A0T;
                if (input == null) {
                    input = B8.A00;
                }
            }
            if (i2 == length) {
                A0S(input, j2);
            } else {
                B8 audioProcessor = this.A0d[i2];
                audioProcessor.ADB(input);
                ByteBuffer A6x = audioProcessor.A6x();
                this.A0e[i2] = A6x;
                if (A6x.hasRemaining()) {
                    i2++;
                }
            }
            if (input.hasRemaining()) {
                return;
            }
            i2--;
        }
    }

    @TargetApi(21)
    public static void A0Q(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    public static void A0R(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c4, code lost:
        if (r0 < r2) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0S(java.nio.ByteBuffer r12, long r13) throws com.facebook.ads.redexgen.X.BK {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1270Wg.A0S(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        A0S(r5, -9223372036854775807L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r9.A0U == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
        if (r5 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
        r9.A04 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A0T() throws com.facebook.ads.redexgen.X.BK {
        /*
            r9 = this;
            r5 = 0
            int r0 = r9.A04
            r6 = -1
            r8 = 0
            if (r0 != r6) goto Lf
            boolean r0 = r9.A0Z
            if (r0 == 0) goto L54
            r0 = 0
        Lc:
            r9.A04 = r0
            r5 = 1
        Lf:
            int r4 = r9.A04
            com.facebook.ads.redexgen.X.B8[] r1 = r9.A0d
            int r0 = r1.length
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 1
            if (r4 >= r0) goto L5e
            r0 = r1[r4]
            if (r5 == 0) goto L23
            r0.ADA()
        L23:
            r9.A0P(r2)
            boolean r3 = r0.A8J()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1270Wg.A0s
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L58
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1270Wg.A0s
            java.lang.String r1 = "2xZTToEoCwsl8MeSQ9EIUdCBiuq4j6Lb"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "WXli42TSAlQlgSv7suJf6xw7W0hHNYE8"
            r0 = 1
            r2[r0] = r1
            if (r3 != 0) goto L4d
            return r8
        L4d:
            r5 = 1
            int r0 = r9.A04
            int r0 = r0 + r7
            r9.A04 = r0
            goto Lf
        L54:
            com.facebook.ads.redexgen.X.B8[] r0 = r9.A0d
            int r0 = r0.length
            goto Lc
        L58:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L5e:
            java.nio.ByteBuffer r5 = r9.A0U
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1270Wg.A0s
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L77
            if (r5 == 0) goto L86
        L6f:
            r9.A0S(r5, r2)
            java.nio.ByteBuffer r0 = r9.A0U
            if (r0 == 0) goto L86
            return r8
        L77:
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.C1270Wg.A0s
            java.lang.String r1 = "9QdkqYSTFHb7WYiPiRp7Y6nS2TP2i0It"
            r0 = 5
            r4[r0] = r1
            java.lang.String r1 = "gIdgEUZyaZheDXAdPlxJ5YfvFSsVsGnk"
            r0 = 2
            r4[r0] = r1
            if (r5 == 0) goto L86
            goto L6f
        L86:
            r9.A04 = r6
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1270Wg.A0T():boolean");
    }

    private boolean A0U() {
        return this.A0M != null;
    }

    private B8[] A0V() {
        if (this.A0a) {
            return this.A0n;
        }
        return this.A0o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01be, code lost:
        if (r15 == 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c0, code lost:
        r11.A02 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c2, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c5, code lost:
        if (r11.A0X == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c7, code lost:
        r2 = android.media.AudioTrack.getMinBufferSize(r14, r6, r11.A08);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ce, code lost:
        if (r2 == (-2)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01d0, code lost:
        com.facebook.ads.redexgen.X.I6.A04(r4);
        r11.A02 = com.facebook.ads.redexgen.X.C0923Il.A06(r2 * 4, ((int) A07(250000)) * r11.A09, (int) java.lang.Math.max(r2, A07(750000) * r11.A09));
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f8, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01fa, code lost:
        r1 = r11.A08;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01fc, code lost:
        if (r1 == r5) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01ff, code lost:
        if (r1 != 6) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0201, code lost:
        r11.A02 = 20480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0207, code lost:
        if (r1 != 7) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0209, code lost:
        r11.A02 = 49152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x020f, code lost:
        r11.A02 = 294912;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0215, code lost:
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ef, code lost:
        if (r9 <= 23) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
        if (A0I(139, 6, 39).equals(com.facebook.ads.redexgen.X.C0923Il.A03) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0111, code lost:
        if (A0I(49, 6, 11).equals(com.facebook.ads.redexgen.X.C0923Il.A05) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0114, code lost:
        if (r13 == 3) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0116, code lost:
        if (r13 == r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0119, code lost:
        if (r13 == 7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011b, code lost:
        r1 = com.facebook.ads.redexgen.X.C0923Il.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011f, code lost:
        if (r1 > 25) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
        if (A0I(com.growingio.android.sdk.monitor.BuildConfig.VERSION_CODE, 4, 22).equals(com.facebook.ads.redexgen.X.C0923Il.A03) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0134, code lost:
        if (r11.A0X != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0136, code lost:
        r4 = true;
        r2 = com.facebook.ads.redexgen.X.C1270Wg.A0s;
        r1 = r2[5];
        r2 = r2[2];
        r1 = r1.charAt(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0148, code lost:
        if (r1 == r2.charAt(2)) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014f, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0150, code lost:
        r6 = com.facebook.ads.redexgen.X.A3.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0153, code lost:
        r6 = 252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0163, code lost:
        if (r9 <= 23) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0166, code lost:
        r2 = com.facebook.ads.redexgen.X.C1270Wg.A0s;
        r2[6] = "lyxpn71WQn9dckKW56P9nO6T9wnpMgEk";
        r2[0] = "LnPBCXPfIDTyG7NKycPeENmI65ZDVhzG";
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
        if (r13 != 1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0174, code lost:
        r6 = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0177, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0178, code lost:
        if (r10 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x017e, code lost:
        if (A0U() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0182, code lost:
        if (r11.A08 != r8) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0184, code lost:
        r9 = r11.A0A;
        r1 = com.facebook.ads.redexgen.X.C1270Wg.A0s[3].length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0191, code lost:
        if (r1 == 31) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0198, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0199, code lost:
        com.facebook.ads.redexgen.X.C1270Wg.A0s[7] = "QJheChQOtEbeash7G8AcHOsRzFDcTJZ5";
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a0, code lost:
        if (r9 != r14) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a4, code lost:
        if (r11.A07 != r6) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a6, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a7, code lost:
        reset();
        r11.A0Z = r7;
        r11.A0A = r14;
        r11.A07 = r6;
        r11.A08 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b4, code lost:
        if (r11.A0X == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b6, code lost:
        r0 = com.facebook.ads.redexgen.X.C0923Il.A05(r11.A08, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01bc, code lost:
        r11.A09 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0156  */
    @Override // com.facebook.ads.redexgen.X.BL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A44(int r12, int r13, int r14, int r15, @androidx.annotation.Nullable int[] r16, int r17, int r18) throws com.facebook.ads.redexgen.X.BH {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1270Wg.A44(int, int, int, int, int[], int, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void A4m() {
        if (this.A0b) {
            this.A0b = false;
            this.A01 = 0;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void A58(int i2) {
        I6.A04(C0923Il.A02 >= 21);
        if (!this.A0b || this.A01 != i2) {
            this.A0b = true;
            this.A01 = i2;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final long A6C(boolean z) {
        if (!A0U() || this.A0D == 0) {
            return Long.MIN_VALUE;
        }
        return this.A0H + A05(A06(Math.min(this.A0h.A0C(z), A08(A04()))));
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final AU A78() {
        return this.A0P;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r19.A0X == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        r19.A0J += r20.remaining();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
        r19.A0T = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0083, code lost:
        r4 = r19.A0I;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
        if (com.facebook.ads.redexgen.X.C1270Wg.A0s[7].charAt(5) == 'v') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
        com.facebook.ads.redexgen.X.C1270Wg.A0s[7] = "RMIgxhGSPUjaAJeGU8ndpU4l5tEpmaGN";
        r19.A0I = r4 + r19.A05;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0117, code lost:
        if (r12 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0119, code lost:
        r19.A0H = java.lang.Math.max(0L, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012a, code lost:
        if (com.facebook.ads.redexgen.X.C1270Wg.A0s[3].length() == 31) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0131, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0139, code lost:
        if (r12 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013c, code lost:
        r4 = r19.A0H + A09(A03());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014a, code lost:
        if (r19.A0D != 1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014c, code lost:
        r15 = java.lang.Math.abs(r4 - r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0161, code lost:
        if (com.facebook.ads.redexgen.X.C1270Wg.A0s[7].charAt(5) == 'v') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0163, code lost:
        r9 = com.facebook.ads.redexgen.X.C1270Wg.A0s;
        r9[5] = "Mjd2F7C7kiLCVUTRblLdSlwSo04If9jH";
        r9[2] = "SFdTDB39f2uDBeT9Tbwwt5W5QdPlKJfQ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0171, code lost:
        if (r15 <= 200000) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0173, code lost:
        android.util.Log.e(r10, A0I(16, 33, 65) + r4 + A0I(0, 6, 35) + r21 + A0I(138, 1, 115));
        r19.A0D = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ab, code lost:
        r13 = r19.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b8, code lost:
        if (com.facebook.ads.redexgen.X.C1270Wg.A0s[3].length() == 31) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bc, code lost:
        com.facebook.ads.redexgen.X.C1270Wg.A0s[7] = "vGS91cAAG7hMw0xriamqCYCKlpI1kVhb";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01c5, code lost:
        if (r15 <= 200000) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c8, code lost:
        r4 = com.facebook.ads.redexgen.X.C1270Wg.A0s;
        r4[5] = "k8d1uoKGcn9oqEPcbfqEuDtWZEluvqcv";
        r4[2] = "0FdbLpGzKjPPYkWO7EHSmW7ecHxpzOIE";
        r19.A0D = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d8, code lost:
        r9 = com.facebook.ads.redexgen.X.C1270Wg.A0s;
        r9[6] = "1n9GuuRZsd3tbftYhBPGe0z5aHsix9eq";
        r9[0] = "CrYGxTKVQxqkoEEYRaPu1U1mUEDoOHWT";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e4, code lost:
        if (r13 != 2) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e6, code lost:
        r19.A0H += r21 - r4;
        r19.A0D = 1;
        r2 = r19.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01f1, code lost:
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f3, code lost:
        r2.ABe();
     */
    @Override // com.facebook.ads.redexgen.X.BL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A7m(java.nio.ByteBuffer r20, long r21) throws com.facebook.ads.redexgen.X.BI, com.facebook.ads.redexgen.X.BK {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1270Wg.A7m(java.nio.ByteBuffer, long):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void A7p() {
        if (this.A0D == 1) {
            this.A0D = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final boolean A7v() {
        return A0U() && this.A0h.A0J(A04());
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final boolean A8I(int i2) {
        if (C0923Il.A0c(i2)) {
            return i2 != 4 || C0923Il.A02 >= 21;
        }
        B1 b1 = this.A0g;
        return b1 != null && b1.A04(i2);
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final boolean A8J() {
        return !A0U() || (this.A0W && !A7v());
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void ACw() {
        this.A0Y = true;
        if (A0U()) {
            this.A0h.A0E();
            AudioTrack audioTrack = this.A0M;
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            A0s[3] = "NrYH7da7InJYZ7DcifiCDIWgHy9XttZ";
            audioTrack.play();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void ACx() throws BK {
        if (this.A0W) {
            return;
        }
        boolean A0U = A0U();
        String[] strArr = A0s;
        if (strArr[6].charAt(18) != strArr[0].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "potoNIjJr8c5PhhOHWP3V8xbrUltb98O";
        strArr2[0] = "s7h49TBBG9Upv5zOzLPi805BwVxtpEdY";
        if (A0U && A0T()) {
            this.A0h.A0F(A04());
            this.A0M.stop();
            this.A03 = 0;
            this.A0W = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void ADS() {
        reset();
        A0L();
        for (B8 b8 : this.A0o) {
            b8.reset();
            if (A0s[3].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0s;
            strArr[5] = "qwdTDv5zTd3QZESqVqPfOIKdJj7Lz8kg";
            strArr[2] = "LbdTDWALSGuogzF76GUONHDiI7JL2ED4";
        }
        for (B8 b82 : this.A0n) {
            b82.reset();
        }
        this.A01 = 0;
        this.A0Y = false;
        if (A0s[7].charAt(5) != 'v') {
            A0s[3] = "7yJp0zMcRreZgWUPzTirOlbpECU1qPL";
            return;
        }
        String[] strArr2 = A0s;
        strArr2[5] = "IJdzF7l1OUCqcHSZRNfx63TpictB3CeC";
        strArr2[2] = "IidC6PogfV1YW6p29FProDWayU60rDbu";
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void AEI(B0 b0) {
        if (this.A0Q.equals(b0)) {
            return;
        }
        this.A0Q = b0;
        if (this.A0b) {
            return;
        }
        reset();
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void AEP(BJ bj) {
        this.A0R = bj;
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final AU AET(AU au) {
        if (A0U() && !this.A0V) {
            this.A0P = AU.A04;
            return this.A0P;
        }
        AU au2 = this.A0O;
        if (au2 == null) {
            if (!this.A0l.isEmpty()) {
                au2 = BW.A02(this.A0l.getLast());
            } else {
                au2 = this.A0P;
            }
        }
        if (!au.equals(au2)) {
            if (A0U()) {
                this.A0O = au;
            } else {
                this.A0P = this.A0j.A3O(au);
            }
        }
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void pause() {
        this.A0Y = false;
        if (A0U() && this.A0h.A0I()) {
            this.A0M.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void reset() {
        if (A0U()) {
            this.A0J = 0L;
            this.A0I = 0L;
            this.A0L = 0L;
            this.A0K = 0L;
            this.A05 = 0;
            AU au = this.A0O;
            if (au != null) {
                this.A0P = au;
                this.A0O = null;
            } else if (!this.A0l.isEmpty()) {
                ArrayDeque<BW> arrayDeque = this.A0l;
                if (A0s[7].charAt(5) == 'v') {
                    throw new RuntimeException();
                }
                A0s[7] = "7Zd0LJuJ8v1AsDIGeh9Ten8e10sO09Lx";
                this.A0P = BW.A02(arrayDeque.getLast());
            }
            this.A0l.clear();
            this.A0F = 0L;
            this.A0G = 0L;
            this.A0T = null;
            this.A0U = null;
            A0J();
            this.A0W = false;
            this.A04 = -1;
            this.A0S = null;
            this.A03 = 0;
            this.A0D = 0;
            if (this.A0h.A0H()) {
                this.A0M.pause();
            }
            AudioTrack audioTrack = this.A0M;
            this.A0M = null;
            this.A0h.A0D();
            this.A0f.close();
            new BS(this, audioTrack).start();
        }
    }

    @Override // com.facebook.ads.redexgen.X.BL
    public final void setVolume(float f2) {
        if (this.A00 != f2) {
            this.A00 = f2;
            A0M();
        }
    }
}
