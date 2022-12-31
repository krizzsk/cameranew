package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/* renamed from: com.facebook.ads.redexgen.X.ah  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1411ah implements LB {
    @Override // com.facebook.ads.redexgen.X.LB
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Window.Callback callback = activity.getWindow() != null ? activity.getWindow().getCallback() : null;
        if (callback != null) {
            L7 l7 = new L7(callback, activity);
            L7.A00(new C1412ai(this));
            activity.getWindow().setCallback(l7);
        }
    }
}
