package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Tl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1200Tl implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, C8H {
    public static byte[] A02;
    public final XT A00;
    public final /* synthetic */ C1198Tj A01;

    static {
        A03();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{43, 14, 74, 9, 11, 4, 4, 5, 30, 74, 8, 15, 74, 9, 6, 3, 9, 1, 15, 14, 74, 8, 15, 12, 5, 24, 15, 74, 3, 30, 74, 3, 25, 74, 28, 3, 15, 29, 15, 14, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, 20, 16, 19, 39, 54, 59, 55, 60, 49, 55, 28, 55, 38, 37, 61, 32, 57, 56, 25, 86, 2, 25, 3, 21, 30, 86, 18, 23, 2, 23, 86, 4, 19, 21, 25, 4, 18, 19, 18, 90, 86, 6, 26, 19, 23, 5, 19, 86, 19, 24, 5, 3, 4, 19, 86, 2, 25, 3, 21, 30, 86, 19, 0, 19, 24, 2, 5, 86, 4, 19, 23, 21, 30, 86, 2, 30, 19, 86, 23, 18, 86, 32, 31, 19, 1, 86, 20, 15, 86, 4, 19, 2, 3, 4, 24, 31, 24, 17, 86, 16, 23, 26, 5, 19, 86, 31, 16, 86, 15, 25, 3, 86, 31, 24, 2, 19, 4, 21, 19, 6, 2, 86, 2, 30, 19, 86, 19, 0, 19, 24, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    public View$OnClickListenerC1200Tl(C1198Tj c1198Tj, XT xt) {
        this.A01 = c1198Tj;
        this.A00 = xt;
    }

    public /* synthetic */ View$OnClickListenerC1200Tl(C1198Tj c1198Tj, XT xt, C1208Tt c1208Tt) {
        this(c1198Tj, xt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01() {
        QZ qz;
        C1009Lz c1009Lz;
        EnumC0956Ju enumC0956Ju;
        boolean z;
        boolean z2;
        EnumC0956Ju enumC0956Ju2;
        C1055Nu c1055Nu = new C1055Nu();
        qz = this.A01.A0R;
        C1055Nu A03 = c1055Nu.A03(qz);
        c1009Lz = this.A01.A0e;
        Map<String, String> A05 = A03.A02(c1009Lz).A05();
        enumC0956Ju = this.A01.A0J;
        if (enumC0956Ju != null) {
            enumC0956Ju2 = this.A01.A0J;
            A05.put(A00(201, 3, 11), String.valueOf(enumC0956Ju2.A04()));
        }
        z = this.A01.A0W;
        if (z) {
            z2 = this.A01.A0W;
            A05.put(A00(198, 3, 116), String.valueOf(z2));
        }
        return A05;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(Map<String, String> map) {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0a(map);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C8H
    public final XT A5Y() {
        return this.A00;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1009Lz c1009Lz;
        XT xt;
        C1009Lz c1009Lz2;
        XT xt2;
        XT xt3;
        C1009Lz c1009Lz3;
        C1009Lz c1009Lz4;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            c1009Lz = this.A01.A0e;
            boolean A08 = c1009Lz.A08();
            String A00 = A00(66, 17, 105);
            if (!A08) {
                Log.e(A00, A00(83, 115, 77));
            }
            xt = this.A01.A0D;
            int A0E = JD.A0E(xt);
            if (A0E >= 0) {
                c1009Lz3 = this.A01.A0e;
                if (c1009Lz3.A03() < A0E) {
                    c1009Lz4 = this.A01.A0e;
                    if (!c1009Lz4.A07()) {
                        Log.e(A00, A00(0, 41, 81));
                        return;
                    } else {
                        Log.e(A00, A00(41, 25, 58));
                        return;
                    }
                }
            }
            c1009Lz2 = this.A01.A0e;
            xt2 = this.A01.A0D;
            if (!c1009Lz2.A09(xt2)) {
                xt3 = this.A01.A0D;
                if (JD.A12(xt3)) {
                    if (this.A01.A0a != null) {
                        this.A01.A0a.A0e(A01());
                    }
                    LX.A00(new DialogInterface$OnClickListenerC0949Jn(this), new DialogInterface$OnClickListenerC0950Jo(this), ActivityUtils.A00());
                    return;
                }
                A05(A01());
            } else if (this.A01.A0a != null) {
                this.A01.A0a.A0b(A01());
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        View view2;
        C1053Ns c1053Ns;
        C1053Ns c1053Ns2;
        View view3;
        View view4;
        C1053Ns c1053Ns3;
        C1053Ns c1053Ns4;
        view2 = this.A01.A04;
        if (view2 != null) {
            c1053Ns = this.A01.A0M;
            if (c1053Ns != null) {
                c1053Ns2 = this.A01.A0M;
                view3 = this.A01.A04;
                int width = view3.getWidth();
                view4 = this.A01.A04;
                c1053Ns2.setBounds(0, 0, width, view4.getHeight());
                c1053Ns3 = this.A01.A0M;
                c1053Ns4 = this.A01.A0M;
                c1053Ns3.A0D(!c1053Ns4.A0E());
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1009Lz c1009Lz;
        View view2;
        View.OnTouchListener onTouchListener;
        View.OnTouchListener onTouchListener2;
        c1009Lz = this.A01.A0e;
        view2 = this.A01.A04;
        c1009Lz.A06(motionEvent, view2, view);
        onTouchListener = this.A01.A02;
        if (onTouchListener != null) {
            onTouchListener2 = this.A01.A02;
            if (onTouchListener2.onTouch(view, motionEvent)) {
                return true;
            }
        }
        return false;
    }
}
