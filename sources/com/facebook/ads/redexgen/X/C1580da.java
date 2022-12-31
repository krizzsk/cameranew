package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.Nullsafe$Mode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Nullsafe(Nullsafe$Mode.LOCAL)
/* renamed from: com.facebook.ads.redexgen.X.da  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1580da {
    public static byte[] A0C;
    public static String[] A0D = {"YcCIPLCDTe1wGTKdO7xqYhpFwQzvmXtt", "FfIdHaSVTal814YVh5tJNVr21T0wsSAo", "HLDls6wic6LzndIKtUvgWnGJ4QMP07cO", "ccYpD8PuArRKO9YkPTuVfhIh5pDN1br2", "LFFD576NBTVByEN649EglQB81U0zBBuc", "sO5gz1O188I9hNkbLLxzl8j4JWiDgVKK", "Hord6YvHX1lmSPmhXyMRW660HCYjcXOm", "5HbQDpK1pfSpB47EOovGOWVGJlrw1BSl"};
    @Nullable
    public InterfaceC1584de A00;
    public boolean A01;
    public final Rect A02;
    public final Rect A03;
    public final Handler A04;
    public final InterfaceC1150Rn A05;
    public final InterfaceC1591dl A06;
    public final C1582dc A07;
    public final G3 A08;
    public final Runnable A09;
    public final List<Rect> A0A;
    public final List<View> A0B;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 73);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{-4, -5, -32, -16, -18, -5, -46, -5, -15};
    }

    static {
        A04();
    }

    public C1580da(InterfaceC1591dl interfaceC1591dl, InterfaceC1150Rn interfaceC1150Rn, G3 g3, C1582dc c1582dc, Handler handler) {
        this(interfaceC1591dl, interfaceC1150Rn, g3, c1582dc, handler, 100);
    }

    public C1580da(InterfaceC1591dl interfaceC1591dl, InterfaceC1150Rn interfaceC1150Rn, G3 g3, C1582dc c1582dc, Handler handler, int i2) {
        this.A03 = new Rect();
        this.A02 = new Rect();
        this.A0B = new ArrayList();
        this.A0A = new ArrayList();
        this.A01 = false;
        this.A06 = interfaceC1591dl;
        this.A05 = interfaceC1150Rn;
        this.A08 = g3;
        this.A07 = c1582dc;
        this.A04 = handler;
        this.A09 = new RunnableC1581db(this, i2);
    }

    private void A05(long j2) {
        Preconditions.checkState(this.A0B.isEmpty());
        this.A06.A7j(this.A0A);
        this.A08.A3o(j2, this.A0A);
        this.A08.A5B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(long j2) {
        this.A06.A7j(this.A0A);
        this.A08.A3o(j2, this.A0A);
        Preconditions.checkState(this.A0B.isEmpty());
        this.A07.A03(this.A0B);
        for (View view : this.A0B) {
            C1589dj A00 = this.A07.A00(view);
            for (Rect rect : this.A0A) {
                Rect rect2 = this.A03;
                Rect containerRect = this.A02;
                if (C1573dT.A00(view, rect2, containerRect, rect) && A00 != C1589dj.A06) {
                    G3 g3 = this.A08;
                    Rect rect3 = this.A03;
                    Rect containerRect2 = this.A02;
                    g3.A3I(A00, rect3, containerRect2);
                }
            }
        }
        this.A08.A5B();
        InterfaceC1584de interfaceC1584de = this.A00;
        if (A0D[0].charAt(21) != 'h') {
            throw new RuntimeException();
        }
        A0D[6] = "BhrT0c14O8Thrmtg3HRzOfRcpCyh5HNl";
        if (interfaceC1584de != null) {
            throw new NullPointerException(A03(0, 9, 68));
        }
        this.A0B.clear();
    }

    public final void A09() {
        if (this.A01) {
            this.A04.removeCallbacks(this.A09);
            A05(this.A05.A9Y());
        }
        this.A01 = false;
    }

    public final void A0A() {
        if (!this.A01) {
            this.A01 = true;
            this.A04.post(this.A09);
        }
    }

    public final void A0B(@Nullable InterfaceC1586dg interfaceC1586dg) {
        this.A08.AEY(interfaceC1586dg);
    }

    public final void A0C(@Nullable InterfaceC1584de interfaceC1584de) {
        this.A00 = interfaceC1584de;
    }
}
