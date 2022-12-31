package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.File;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class QN {
    public static QN A09;
    public static byte[] A0A;
    public static String[] A0B = {"688Ud0WFcmtoZguZNYMQvcz7Ljs", "nPELSPwzrl0V6IBXdfGSyJY", "V1hbmPEna1XhhewDQ0tbDQdr9h5aChAO", "TQqT5oCJg2dLoA7GlYM3aQ", "u27pUDvoszRTHHiSsQOFNRfLPBfceTs8", "ATiE4qOK4Q4Yex0MbemwEb7mKStAZOqp", "bMYeiabzwxfEm1FBemkFwtc", "vCUl1zlXyex2u5GmhzPd2ypZUlS"};
    public static final DownloadAction.Deserializer[] A0C;
    public C0825En A00;
    @Nullable
    public InterfaceC0902Hq A01;
    public File A02;
    public boolean A03;
    public final Context A04;
    public final Handler A05 = new Handler(Looper.getMainLooper());
    public final SparseArray<QL> A06 = new SparseArray<>();
    public final Runnable A08 = new QK(this);
    public final InterfaceC0818Eg A07 = new C0896Hk(this);

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 103);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A0A = new byte[]{-103, -69, -14, -19, -34, -20, -77, -103, -69, -3, 20, 15, 0, 14, -69, -24, 19, 27, 18, 16, 19, 5, 8, 9, 8, -46, -60, -9, 24, 5, 24, 9, -34, -60, 27, 72, 72, 69, 72, 4, -10, 41, 74, 55, 74, 59, 16, -10, -44, -31, -13, -21, 33, 36, 46, 55, -19, 33, 35, 52, 41, 47, 46, 51, -40, -37, -27, -18, -92, -37, -26, -18, -27, -29, -26, -40, -37, -22, 33, 36, 51};
    }

    static {
        A0B();
        A0C = new DownloadAction.Deserializer[]{VC.A03};
    }

    @VisibleForTesting
    public QN(Context context, @Nullable C0825En c0825En) {
        this.A04 = context;
        if (c0825En != null) {
            this.A00 = c0825En;
            c0825En.A0Q(this.A07);
        }
        A01().A0P();
    }

    private C0825En A01() {
        if (this.A00 == null) {
            this.A00 = new C0825En(new C0830Es(A03(), A02()), 10, 5, new File(A06(), A07(52, 12, 89)), A0C);
            this.A00.A0Q(this.A07);
        }
        return this.A00;
    }

    private UX A02() {
        return new C2G(A07(78, 3, 89), null);
    }

    private final synchronized InterfaceC0902Hq A03() {
        InterfaceC0902Hq interfaceC0902Hq;
        if (this.A01 == null) {
            this.A01 = new UJ(new File(A06(), A07(64, 14, 16)), new B2(JD.A0N(this.A04)));
        }
        interfaceC0902Hq = this.A01;
        String[] strArr = A0B;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0B[5] = "O4H7XzH8kHHYhvbNpS10DOnxTEfi7R6X";
        return interfaceC0902Hq;
    }

    public static UM A04(C1218Ud c1218Ud, InterfaceC0902Hq interfaceC0902Hq) {
        return new UM(interfaceC0902Hq, c1218Ud, new UZ(), null, 2, null);
    }

    public static QN A05(Context context) {
        if (A09 == null) {
            A09 = new QN(context.getApplicationContext(), null);
        }
        return A09;
    }

    private File A06() {
        if (this.A02 == null) {
            this.A02 = this.A04.getCacheDir();
        }
        return this.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08() {
        C0824Em[] A0S;
        for (C0824Em c0824Em : A01().A0S()) {
            int state = c0824Em.A02;
            QL ql = this.A06.get(state);
            if (ql != null) {
                int i2 = c0824Em.A01;
                if (i2 == 2 || c0824Em.A03 > ql.A00) {
                    String str = A07(15, 19, 61) + i2 + A07(0, 8, 18) + c0824Em.A03;
                    ql.A01.AAM();
                    this.A06.remove(state);
                } else if (i2 == 4 || i2 == 3) {
                    String str2 = A07(34, 14, 111) + i2;
                    ql.A01.AAV();
                    this.A06.remove(state);
                }
            }
            String str3 = A07(48, 4, 25) + state + A07(8, 7, 52) + c0824Em.A03;
        }
    }

    private void A09() {
        if (!this.A03) {
            this.A03 = true;
            this.A05.post(this.A08);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A05.removeCallbacks(this.A08);
        this.A03 = false;
    }

    public final HQ A0E(Context context) {
        return A04(new C1218Ud(context, (InterfaceC0898Hm<? super HR>) null, A02()), A03());
    }

    public final void A0F(Uri uri, QM qm, long j2) {
        this.A06.put(A01().A0O(new VC(uri, false, null, null)), new QL(qm, j2, null));
        A09();
    }
}
