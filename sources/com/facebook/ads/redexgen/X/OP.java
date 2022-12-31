package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class OP implements View.OnTouchListener {
    public static String[] A01 = {"0HsLQMHMjdf9XxY0FoFJM6DI5mSYk5cq", "dhr4behIProWKSykj", "GE701vnHE9lzBn3SwA4tW4e1BtUaptEm", "cLSMigQ4cfHVDaX8bfW4FJ5X08fXhUZC", "1xDVph1vyW65p7zSnZeJ5giXq27He7tX", "cas2Jd68DEdp6", "xZiGDxwVLZDgesSRv509BK1mAeaT2HFq", "7L9x50qsEvVQf3Iy1"};
    public final /* synthetic */ SK A00;

    public OP(SK sk) {
        this.A00 = sk;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                float y = motionEvent.getY();
                f2 = this.A00.A00;
                int i2 = (f2 > y ? 1 : (f2 == y ? 0 : -1));
                String[] strArr = A01;
                if (strArr[1].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[1] = "l6HJRtuhNtCgLlDek";
                strArr2[7] = "Xh4l6Kh17owsVyOO9";
                if (i2 < 0) {
                    this.A00.A0P(false);
                }
            }
        } else {
            this.A00.A00 = motionEvent.getY();
        }
        return true;
    }
}
