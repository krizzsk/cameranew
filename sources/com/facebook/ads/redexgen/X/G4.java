package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class G4 implements InterfaceC1591dl {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"IEiXcTkMIl1ap8Zf6qOVAjQ1rvSIicom", "QYAiQp9VSKIcO10LfC8C0oMZ52KCP", "5FnqVZjKRiUcCEiMettDGQkf", "eIcxxbRAXAOJgXUDruK", "Xqq5h503ORagU11Zkm", "kVW5mdc93LjiLmP7jOmm8EZ9ikbuw", "", "Pup9EGwYSaPQ0jjcMKTOfwULbNi8Bcjo"};
    public final InterfaceC1593dn A02;
    public final WeakReference<View> A03;
    public final List<Rect> A04 = new LinkedList();
    public final List<Rect> A05 = new ArrayList();
    public final Rect A01 = new Rect();
    public final Rect A00 = new Rect();

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 64);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-50, -52, -37, -86, -45, -48, -41, -71, -52, -54, -37};
    }

    static {
        A01();
    }

    public G4(View view, InterfaceC1593dn interfaceC1593dn) {
        this.A03 = new WeakReference<>(view);
        this.A02 = interfaceC1593dn;
    }

    private final void A02(List<Rect> list) {
        list.clear();
        this.A04.clear();
        View view = this.A03.get();
        if (view == null || !view.getGlobalVisibleRect(this.A01) || this.A01.isEmpty()) {
            return;
        }
        List<Rect> list2 = this.A04;
        Rect rect = this.A01;
        String[] strArr = A08;
        if (strArr[2].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A08[4] = "LbYMkqiRG6i19Q3hsX";
        list2.add(rect);
        Iterator<Cdo> it = this.A02.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NullPointerException(A00(0, 11, 39));
        } else {
            list.addAll(this.A04);
        }
    }

    private final void A03(List<Rect> list) {
        list.clear();
        List<Rect> outList = this.A05;
        outList.clear();
        View view = this.A03.get();
        if (view == null || !view.getGlobalVisibleRect(this.A01) || this.A01.isEmpty()) {
            return;
        }
        this.A05.add(this.A01);
        if (0 < this.A02.size()) {
            this.A02.A5V(0);
            throw new NullPointerException(A00(0, 11, 39));
        } else {
            list.addAll(this.A05);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1591dl
    public final void A7j(List<Rect> list) {
        if (A06) {
            A03(list);
        } else {
            A02(list);
        }
    }
}
