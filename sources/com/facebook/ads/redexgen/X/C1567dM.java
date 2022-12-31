package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@SuppressLint({"BadMethodUse-java.lang.String.length"})
/* renamed from: com.facebook.ads.redexgen.X.dM  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1567dM implements AnonymousClass00 {
    public static byte[] A09;
    public static String[] A0A = {"2hmAfzTadn", "1uDqsMr9wv4o5ZghfCOZg4FuDp7sllqp", "nT1KYDstdBBAZ5nN", "UVqk4rMzzgqbiyaJgpoGMOUy0jQCoEBq", "ewXxsmpHr", "rT44HeCpkJQ", "C3kiv90mrVS0BL1BSM5Dfu9lHf0n3Csl", "grgxNBq6hb"};
    public static final String A0B;
    public final int A00;
    public final int A01;
    public final AnonymousClass08 A02;
    public final C0L A04;
    public final C8J A05;
    public final boolean A08;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final C0A A03 = new C0A();

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] - i4;
            String[] strArr = A0A;
            if (strArr[5].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "m9U6X0moZlc";
            strArr2[7] = "IfCNkNm6kG";
            copyOfRange[i5] = (byte) (i6 - 76);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-105, -33, -40, -22, -105, -39, -36, -36, -27, -105, -32, -27, -21, -36, -23, -23, -20, -25, -21, -36, -37, -91, -63, -75, -5, -2, 1, -6, -75, -8, 1, -6, -10, 3, -6, -7, -49, -75, -125, 117, -106, -55, -55, -70, -62, -59, -55, -113, 117, -7, 23, 25, 30, 31, 36, 29, -42, 28, 31, 34, 27, -42, 25, 37, 35, 38, 34, 27, 42, 27, -42, 4, 34, 36, 41, 42, 47, 40, -31, 39, 42, 45, 38, -31, 47, 48, 53, -31, 36, 48, 46, 49, 45, 38, 53, 38, -31, -91, -61, -59, -54, -53, -48, -55, -126, -47, -56, -126, -32, -2, 11, -60, 17, -67, 0, 9, 12, 16, 2, -67, 0, -2, 0, 5, 2, -67, 3, 6, 9, 2, -53, -80, -50, -37, -108, -31, -115, -33, -46, -50, -47, -115, -50, -32, -32, -46, -31, -32, -101, -69, -39, -26, -97, -20, -104, -22, -35, -39, -36, -104, -28, -35, -26, -33, -20, -32, -104, -25, -34, -104, -72, -39, -32, -39, -24, -35, -30, -37, -108, -41, -43, -41, -36, -39, -108, -38, -35, -32, -39, -108, -43, -38, -24, -39, -26, -108, -39, -20, -41, -39, -39, -40, -35, -30, -37, -108, -26, -39, -24, -26, -19, -108, -43, -24, -24, -39, -31, -28, -24, -25, -82, -108, -43, 2, 2, -1, 2, -80, -13, -15, -13, -8, -7, -2, -9, -80, 4, -8, -11, -80, -10, -7, -4, -11, -54, -9, -9, -12, -9, -91, -24, -15, -22, -26, -13, -18, -13, -20, -91, -21, -18, -15, -22, -72, -27, -27, -30, -27, -109, -42, -33, -30, -26, -36, -31, -38, -109, -26, -30, -24, -27, -42, -40, -72, -35, -46, -34, -36, -33, -37, -44, -29, -44, -113, -31, -44, -30, -33, -34, -35, -30, -44, -99, -65, -35, -28, -44, -39, -46, -117, -33, -38, -117, -35, -48, -52, -49, -117, -73, -70, -60, -51, -125, -68, -65, -62, -69, -125, -71, -73, -71, -66, -69, -18, 0, 0, -14, 1, -57, -68, -68, -68, 5, 8, 11, 4, -39, -50, -50, -50, 0, Draft_75.CR, 3, 17, 14, 8, 3, -2, 0, 18, 18, 4, 19, -50};
        String[] strArr = A0A;
        if (strArr[1].charAt(5) == strArr[3].charAt(5)) {
            throw new RuntimeException();
        }
        A0A[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
    }

    static {
        A04();
        A0B = C1567dM.class.getSimpleName();
    }

    public C1567dM(C8J c8j, AnonymousClass08 anonymousClass08, C0L c0l) {
        this.A05 = c8j;
        this.A08 = anonymousClass08.A02();
        this.A00 = anonymousClass08.A00();
        this.A04 = c0l;
        this.A01 = anonymousClass08.A01();
        this.A02 = anonymousClass08;
    }

    public static C0K A00(Context context, String str) throws C0H {
        try {
            InputStream open = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new C1565dK(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException e2) {
            throw new C0H(A03(131, 18, 33), e2);
        }
    }

    public static File A01(Context context) {
        return new File(context.getCacheDir(), A03(TypedValues.AttributesType.TYPE_PIVOT_TARGET, 15, 10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c8, code lost:
        r8 = r6.A03();
        r6.A06();
        r6 = java.lang.System.currentTimeMillis() - r13;
        r21.A00().A49(r4, r16.A04);
        r16.A06.put(r10, r4);
        r16.A04.ADL(r10, 2112, null, java.lang.Integer.valueOf(r8), java.lang.Long.valueOf(r6), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f3, code lost:
        return r4;
     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0100: INVOKE  
      (r9v1 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Integer)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     type: INTERFACE call: com.facebook.ads.redexgen.X.0L.ADL(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void, block:B:40:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x011a: INVOKE  
      (r9v0 ?? I:com.facebook.ads.redexgen.X.0L)
      (r10 I:java.lang.String)
      (r11 I:int)
      (r12 I:java.lang.String)
      (r13 I:java.lang.Integer)
      (r14 I:java.lang.Long)
      (r15 I:com.facebook.ads.redexgen.X.06)
     type: INTERFACE call: com.facebook.ads.redexgen.X.0L.ADL(java.lang.String, int, java.lang.String, java.lang.Integer, java.lang.Long, com.facebook.ads.redexgen.X.06):void, block:B:46:0x010f */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00ff: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:40:0x00f5 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0119: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:46:0x010f */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.File A02(com.facebook.ads.redexgen.X.AnonymousClass06 r17, java.lang.String r18, java.lang.String r19, int r20, com.facebook.ads.redexgen.X.AnonymousClass09 r21) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1567dM.A02(com.facebook.ads.redexgen.X.06, java.lang.String, java.lang.String, int, com.facebook.ads.redexgen.X.09):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a8, code lost:
        if (r4 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b0, code lost:
        if (r4 != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe A[Catch: all -> 0x0142, 0H -> 0x0144, TRY_LEAVE, TryCatch #15 {0H -> 0x0144, all -> 0x0142, blocks: (B:12:0x0079, B:36:0x00fe, B:42:0x0111, B:34:0x00f8, B:26:0x00b6, B:28:0x00be), top: B:98:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102 A[Catch: all -> 0x015a, 0H -> 0x015c, TRY_ENTER, TryCatch #13 {0H -> 0x015c, all -> 0x015a, blocks: (B:9:0x0051, B:15:0x0085, B:40:0x010b, B:43:0x0118, B:37:0x0102, B:39:0x0108, B:31:0x00ea, B:32:0x00f1), top: B:102:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111 A[Catch: all -> 0x0142, 0H -> 0x0144, TRY_ENTER, TRY_LEAVE, TryCatch #15 {0H -> 0x0144, all -> 0x0142, blocks: (B:12:0x0079, B:36:0x00fe, B:42:0x0111, B:34:0x00f8, B:26:0x00b6, B:28:0x00be), top: B:98:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A05(android.content.Context r24, com.facebook.ads.redexgen.X.C1563dI r25, java.lang.String r26, int r27, int r28, long r29) throws com.facebook.ads.redexgen.X.C0H {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1567dM.A05(android.content.Context, com.facebook.ads.redexgen.X.dI, java.lang.String, int, int, long):void");
    }

    @SuppressLint({"CatchGeneralException"})
    private void A06(C1563dI c1563dI) {
        try {
            File A04 = c1563dI.A04();
            if (A04.exists()) {
                c1563dI.A06();
                boolean delete = A04.delete();
                if (this.A08) {
                    String str = A0B;
                    Log.i(str, A03(170, 52, 40) + delete);
                }
            }
        } catch (Exception e2) {
            if (this.A08) {
                Log.e(A0B, A03(108, 23, 81), e2);
            }
        }
    }

    private boolean A07(C1563dI c1563dI) {
        try {
            c1563dI.A05();
            return true;
        } catch (C1561dG e2) {
            boolean z = this.A08;
            if (A0A[6].charAt(7) != 'U') {
                A0A[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
                if (z) {
                    Log.e(A0B, A03(IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 19, 57), e2);
                    return false;
                }
                return false;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<T> */
    public final <T> AnonymousClass02<T> A08(AnonymousClass06 anonymousClass06, AnonymousClass09<T> anonymousClass09) {
        Semaphore semaphore;
        if (anonymousClass09.A03()) {
            File file = this.A06.get(anonymousClass06.A09);
            if (file != null) {
                C0L c0l = this.A04;
                String str = anonymousClass06.A09;
                if (A0A[6].charAt(7) != 'U') {
                    String[] strArr = A0A;
                    strArr[0] = "ARXa8ML4Mz";
                    strArr[4] = "7SNAJeIyn";
                    c0l.ADM(str, true, anonymousClass06);
                    return anonymousClass09.A00().A39(file, this.A04);
                }
                throw new RuntimeException();
            }
            this.A04.ADM(anonymousClass06.A09, false, anonymousClass06);
            return new AnonymousClass02<>(false, null);
        }
        String str2 = anonymousClass06.A09;
        String str3 = this.A03.A03(str2) + anonymousClass06.A04;
        synchronized (this.A07) {
            semaphore = this.A07.get(str3);
            if (semaphore == null) {
                semaphore = new Semaphore(1);
                this.A07.put(str3, semaphore);
            }
            try {
            } catch (Throwable th) {
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str3);
                    throw th;
                }
            }
        }
        try {
            semaphore.acquire();
            File A02 = A02(anonymousClass06, str2, str3, this.A01, anonymousClass09);
            if (A02 != null) {
                AnonymousClass02<T> A39 = anonymousClass09.A00().A39(A02, this.A04);
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str3);
                }
                return A39;
            }
            AnonymousClass02<T> anonymousClass02 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str3);
            }
            return anonymousClass02;
        } catch (InterruptedException unused) {
            if (this.A08) {
                String str4 = A03(97, 11, 22) + str2 + A03(0, 22, 43);
            }
            AnonymousClass02<T> anonymousClass022 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str3);
                return anonymousClass022;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    public final AnonymousClass02<Bitmap> ADm(AnonymousClass06 anonymousClass06, boolean z) {
        return A08(anonymousClass06, new AnonymousClass09(new C1570dP(anonymousClass06.A01, anonymousClass06.A00, this.A02.A04(), this.A02.A03(), z)));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<java.io.File> */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final File ADn(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1569dO());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (File) A08(anonymousClass06, anonymousClass09).A00();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ADo(AnonymousClass06 anonymousClass06) {
        return (String) A08(anonymousClass06, new AnonymousClass09(new C1568dN())).A00();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.09 != com.facebook.ads.cache.config.CacheRequestConfig<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass00
    @Nullable
    public final String ADp(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1568dN());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (String) A08(anonymousClass06, anonymousClass09).A00();
    }
}
