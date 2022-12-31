package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class KF implements InterfaceC1095Pk {
    public static String[] A0C = {"ua4Z1F3Vn1tdURaP0tTj5Z", "VlqKJtfjGqtNso0qX2A6lmnvOZsZ2xTE", "1pb0xsuTqC4ySw1JjiCpjHk6a0KK", "HW9a8amQa56v9usqS4J3KzzxMBRp7oUY", "lzg290ZQq0ECc78zj7A2Pt", "9JBQniCNh78hbF6UnJo6", "DIRAqcjzgSQz4x9q8OrEXdtc6Zce0V5V", "FPN1H6gS7aT4O5CCkRk249I"};
    @Nullable
    public C1099Po A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final L3 A07 = new L3() { // from class: com.facebook.ads.redexgen.X.7s
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9P
        /* renamed from: A00 */
        public final void A03(C06677u c06677u) {
            Handler handler;
            boolean A0D;
            handler = KF.this.A05;
            handler.removeCallbacksAndMessages(null);
            A0D = KF.this.A0D(Q5.A05);
            if (A0D) {
                KF.this.A03();
                KF.this.A06(true, false);
            }
            KF.this.A03 = true;
        }
    };
    public final AbstractC1018Mi A06 = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.7r
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9P
        /* renamed from: A00 */
        public final void A03(C06687v c06687v) {
            KF.this.A03();
            KF.this.A06(false, false);
            KF.this.A03 = true;
        }
    };
    public final AbstractC0976Kq A08 = new C06647q(this);
    public final AbstractC0968Kh A09 = new AbstractC0968Kh() { // from class: com.facebook.ads.redexgen.X.7p
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9P
        /* renamed from: A00 */
        public final void A03(C06667t c06667t) {
            boolean z;
            boolean A0D;
            z = KF.this.A02;
            if (z) {
                return;
            }
            A0D = KF.this.A0D(Q5.A05);
            if (!A0D) {
                return;
            }
            KF.this.A03();
            KF.this.A06(true, false);
        }
    };
    public final KO A0A = new C06627o(this);
    public final Handler A05 = new Handler();
    public final List<Q6> A0B = new ArrayList();
    public int A00 = 2000;

    public KF(boolean z) {
        this.A02 = z;
    }

    public static /* synthetic */ int A00(KF kf) {
        return kf.A00;
    }

    public static /* synthetic */ Handler A01(KF kf) {
        return kf.A05;
    }

    public void A03() {
        this.A05.removeCallbacksAndMessages(null);
        Iterator<Q6> it = this.A0B.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            A0C[1] = "SzC94btdcN1119JNHgRanzsWdfoutew0";
            if (hasNext) {
                it.next().cancel();
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void A04(KF kf) {
        kf.A03();
    }

    public static /* synthetic */ void A05(KF kf, boolean z, boolean z2) {
        kf.A06(z, z2);
    }

    public void A06(boolean z, boolean z2) {
        for (Q6 q6 : this.A0B) {
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            A0C[1] = "qWrr7wKcnD6M25Nm7U3j0NNRElcnIA4d";
            q6.A3L(z, z2);
        }
    }

    public static /* synthetic */ boolean A07(KF kf) {
        return kf.A03;
    }

    public static /* synthetic */ boolean A08(KF kf) {
        return kf.A02;
    }

    public static /* synthetic */ boolean A09(KF kf) {
        return kf.A04;
    }

    public static /* synthetic */ boolean A0A(KF kf, Q5 q5) {
        return kf.A0D(q5);
    }

    public static /* synthetic */ boolean A0B(KF kf, boolean z) {
        kf.A03 = z;
        return z;
    }

    public static /* synthetic */ boolean A0C(KF kf, boolean z) {
        kf.A04 = z;
        return z;
    }

    public boolean A0D(Q5 q5) {
        for (Q6 q6 : this.A0B) {
            if (q6.A7R() != q5) {
                return false;
            }
        }
        return true;
    }

    public final void A0E() {
        this.A0B.clear();
    }

    public final void A0F() {
        if (this.A02) {
            this.A05.removeCallbacksAndMessages(null);
            this.A02 = false;
        }
    }

    public final void A0G() {
        this.A04 = true;
        this.A03 = true;
        A06(false, false);
    }

    public final void A0H(int i2) {
        this.A00 = i2;
    }

    public final void A0I(Q6 q6) {
        this.A0B.add(q6);
    }

    public final boolean A0J() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void A8f(C1099Po c1099Po) {
        this.A01 = c1099Po;
        c1099Po.getEventBus().A03(this.A07, this.A0A, this.A08, this.A09, this.A06);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void AF4(C1099Po c1099Po) {
        A03();
        c1099Po.getEventBus().A04(this.A06, this.A0A, this.A08, this.A09, this.A07);
        this.A01 = null;
    }
}
