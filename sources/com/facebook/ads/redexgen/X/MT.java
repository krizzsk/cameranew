package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
/* loaded from: assets/audience_network.dex */
public abstract class MT extends LinearLayout {
    public static int A00 = (int) (LY.A00 * 56.0f);

    public abstract void A04(C1I c1i, boolean z);

    public abstract boolean A05();

    public abstract int getToolbarHeight();

    public abstract void setAdReportingVisible(boolean z);

    public abstract void setPageDetails(C1S c1s, String str, int i2, C1Z c1z);

    public abstract void setPageDetailsVisible(boolean z);

    public abstract void setProgress(float f2);

    public abstract void setProgressSpinnerInvisible(boolean z);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i2);

    public abstract void setToolbarListener(MS ms);

    public MT(Context context) {
        super(context);
    }
}
