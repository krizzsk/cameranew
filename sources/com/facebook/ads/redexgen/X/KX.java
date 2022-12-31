package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: assets/audience_network.dex */
public final class KX {
    public static byte[] A06;
    public static final M8 A07;
    public static final Executor A08;
    @Nullable
    public KW A01;
    @Nullable
    public Map<String, String> A02;
    public final XT A03;
    public final String A05;
    public long A00 = -1;
    public final KY A04 = KY.A00();

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 80);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A06 = new byte[]{61, 56, 57, 59, 59, 56, 59, 58, 122, 105, 107, 119, 117, 78, 65, 68, 72, 67, 89, 82, 95, 72, 92, 88, 72, 94, 89, 82, 68, 73, 98, 88, 11, 121, 101, 17, 11, 100, 101, 10, 108, 99, 102, 102, 10, 88, 79, 73, 79, 67, 92, 79, 78, 20, 53, 122, 28, 51, 54, 54, 122, 63, 40, 40, 53, 40, 122, 57, 53, 62, 63, 122, 1, Byte.MAX_VALUE, 41, 7, 122, Byte.MAX_VALUE, 41, 38, 7, 72, 6, Draft_75.CR, 28, 31, 7, 26, 3, 72, 11, 7, 6, 6, Draft_75.CR, 11, 28, 1, 7, 6, 88, 90, 81, 90, 77, 86, 92, 40, 35, 50, 49, 41, 52, 45, 55, 54, 31, 48, 53, 53, 17, 54, 54, 50};
    }

    static {
        A0A();
        A07 = new M8();
        A08 = Executors.newCachedThreadPool(A07);
    }

    public KX(XT xt) {
        this.A03 = xt;
        this.A05 = C0963Kb.A01(xt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC1117Qg A03(long j2, KU ku) {
        return new TZ(this, ku, j2);
    }

    private void A09() {
        XT xt = this.A03;
        if (xt == null || !C1134Qx.A0A(xt)) {
            return;
        }
        C06818n c06818n = new C06818n(A05(8, 5, 107));
        c06818n.A03(1);
        this.A03.A06().A8q(A05(107, 7, 22), C06808m.A1k, c06818n);
    }

    private void A0B(int i2, String str) {
        String A05 = A05(114, 10, 9);
        KI.A05(A05, A05(37, 16, 122), A05(0, 8, 90));
        KI.A04(A05, String.format(Locale.US, A05(53, 26, 10), Integer.valueOf(i2), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(K3 k3) {
        KW kw = this.A01;
        if (kw != null) {
            kw.AAW(k3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(K3 k3) {
        M1.A00(new TX(this, k3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J(TW tw) {
        KW kw = this.A01;
        if (kw != null) {
            kw.ACC(tw);
        }
    }

    private void A0K(TW tw) {
        C8P A04;
        M1.A00(new TY(this, tw));
        if (JD.A1d(this.A03) && (A04 = this.A03.A04()) != null) {
            A04.A5R();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(String str, long j2, KU ku) {
        String str2;
        try {
            try {
                C0962Ka A062 = this.A04.A06(this.A03, str, j2);
                AnonymousClass94 A00 = A062.A00();
                XS A002 = this.A03.A00();
                A002.A01().A8k(A002, str);
                if (A00 != null) {
                    JD.A0O(this.A03).A24(A00.A08());
                    this.A03.A06().A9M();
                    C2A.A0O(this.A03.A00(), A00.A06());
                    KT.A05(A00.A05().A0B(), ku);
                    MJ.A01(this.A03, A08, A00);
                    C06818n c06818n = new C06818n(A05(30, 7, 123) + LZ.A02());
                    c06818n.A04(1);
                    c06818n.A08(false);
                    this.A03.A06().A9G(A05(100, 7, 111), C06808m.A1K, c06818n);
                }
                int i2 = KV.A00[A062.A01().ordinal()];
                if (i2 == 1) {
                    TW tw = (TW) A062;
                    if (A00 != null) {
                        if (A00.A05().A0E()) {
                            KT.A07(str, ku);
                        }
                        if (this.A02 != null) {
                            str2 = this.A02.get(A05(13, 17, 93));
                        } else {
                            str2 = null;
                        }
                        if (!TextUtils.isEmpty(A062.A02()) && !TextUtils.isEmpty(str2)) {
                            this.A03.A01().ADq(this.A03, str2, A062.A02());
                        }
                    }
                    this.A03.A0D().A2k(C1008Ly.A01(this.A00));
                    A0K(tw);
                } else if (i2 != 2) {
                    AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                    this.A03.A0D().A2j(C1008Ly.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                    A0D(K3.A01(adErrorType, str));
                } else {
                    TV tv2 = (TV) A062;
                    String A04 = tv2.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(tv2.A03(), AdErrorType.ERROR_MESSAGE);
                    A0B(tv2.A03(), A04);
                    if (A04 == null) {
                        A04 = str;
                    }
                    this.A03.A0D().A2j(C1008Ly.A01(this.A00), adErrorTypeFromCode.getErrorCode(), A04, adErrorTypeFromCode.isPublicError());
                    A0D(K3.A01(adErrorTypeFromCode, A04));
                }
            } catch (Exception e2) {
                e = e2;
                String message = e.getMessage();
                AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
                this.A03.A0D().A2j(C1008Ly.A01(this.A00), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
                A0D(K3.A01(adErrorType2, message));
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(String str, long j2, KU ku) {
        A08.execute(new C1189Ta(this, str, j2, ku));
    }

    public final void A0N(KU ku) {
        this.A00 = System.currentTimeMillis();
        if (C1006Lw.A00(this.A03) == EnumC1005Lv.A07) {
            A09();
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String A05 = A05(79, 21, 56);
            this.A03.A0D().A2j(C1008Ly.A01(this.A00), adErrorType.getErrorCode(), A05, adErrorType.isPublicError());
            A0D(new K3(adErrorType, A05));
            return;
        }
        C06898v.A0B(this.A03);
        if (KT.A08(ku)) {
            MA.A06.execute(new C1191Tc(this));
            String A02 = KT.A02(ku);
            if (A02 != null) {
                this.A03.A0D().AFB();
                A0M(A02, 0L, ku);
                return;
            }
            AdErrorType adErrorType2 = AdErrorType.LOAD_TOO_FREQUENTLY;
            this.A03.A0D().A2j(C1008Ly.A01(this.A00), adErrorType2.getErrorCode(), adErrorType2.getDefaultErrorMessage(), adErrorType2.isPublicError());
            A0D(K3.A01(adErrorType2, null));
            return;
        }
        A08.execute(new C1190Tb(this, ku));
    }

    public final void A0O(KW kw) {
        this.A01 = kw;
    }
}
