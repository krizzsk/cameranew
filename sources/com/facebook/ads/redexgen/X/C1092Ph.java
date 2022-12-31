package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Ph  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1092Ph extends RelativeLayout {
    public static String[] A03 = {"Z7YDROQZDOzGgLZ6JRzm0VB6SZj4zDor", "PEDxZ1hmcJv2HtokqPZuboN03zqPqfuu", "ZN3aiXgGzfL", "UoQOzdqMFdmvRVk6jZTbQbhJ01APWmUd", "BWydKlRDXGFiivyHlYlBLR13h8bygoZy", "calSGpe10AH6YV6oPZJsWkhcYoOFDSm8", "CqyCvSup05V", "6oqVw1T1HmkJfSZKyFG8rr7XXeYSScI0"};
    @Nullable
    public C06527b A00;
    public WeakReference<InterfaceC1091Pg> A01;
    public final QU A02;

    public C1092Ph(XT xt, QU qu) {
        super(xt);
        this.A02 = qu;
        M5.A0J((View) this.A02);
        addView(this.A02.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public final void A00(AbstractC1020Mk abstractC1020Mk) {
        addView(abstractC1020Mk, new RelativeLayout.LayoutParams(-1, -1));
        this.A00 = (C06527b) abstractC1020Mk;
    }

    public final void A01(AbstractC1020Mk abstractC1020Mk) {
        M5.A0J(abstractC1020Mk);
        this.A00 = null;
    }

    public final boolean A02() {
        return this.A02.A7y();
    }

    public int getCurrentPosition() {
        return this.A02.getCurrentPosition();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        ((View) this.A02).layout(0, 0, getWidth(), getHeight());
        C06527b c06527b = this.A00;
        if (c06527b != null) {
            c06527b.layout(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r6 > r5) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        r4 = (r0 * r8) / r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
        if (r6 > r5) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
        if (r5 == Integer.MIN_VALUE) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e2, code lost:
        if (r0 <= r6) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
        if (r5 == Integer.MIN_VALUE) goto L29;
     */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1092Ph.onMeasure(int, int):void");
    }

    public void setViewImplInflationListener(InterfaceC1091Pg interfaceC1091Pg) {
        this.A01 = new WeakReference<>(interfaceC1091Pg);
    }
}
