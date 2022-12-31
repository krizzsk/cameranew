package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Lu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class View$OnSystemUiVisibilityChangeListenerC1004Lu implements View.OnSystemUiVisibilityChangeListener {
    public int A00;
    @Nullable
    public Window A01;
    public final View A03;
    public EnumC1003Lt A02 = EnumC1003Lt.A03;
    public final Runnable A04 = new TK(this);

    public View$OnSystemUiVisibilityChangeListenerC1004Lu(View view) {
        this.A03 = view;
        this.A03.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i2, boolean z) {
        Window window = this.A01;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= i2;
        } else {
            attributes.flags &= i2 ^ (-1);
        }
        this.A01.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(boolean z) {
        if (EnumC1003Lt.A03.equals(this.A02)) {
            return;
        }
        int i2 = 3840;
        if (!z) {
            i2 = 3840 | 7;
        }
        Handler handler = this.A03.getHandler();
        if (handler != null && z) {
            handler.removeCallbacks(this.A04);
            handler.postDelayed(this.A04, 2000L);
        }
        this.A03.setSystemUiVisibility(i2);
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(EnumC1003Lt enumC1003Lt) {
        this.A02 = enumC1003Lt;
        if (C1002Ls.A00[this.A02.ordinal()] != 1) {
            A00(67108864, false);
            A00(134217728, false);
            this.A03.setSystemUiVisibility(0);
            return;
        }
        A00(67108864, true);
        A00(134217728, true);
        A02(false);
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i2) {
        this.A00 = i2;
        if (((this.A00 ^ i2) & 2) != 0 && (i2 & 2) == 0) {
            A02(true);
        }
    }
}
