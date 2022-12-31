package com.google.android.gms.ads.instream;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class InstreamAdView extends FrameLayout {
    public InstreamAdView(Context context) {
        super(context);
        q.k(context, "Context cannot be null");
    }

    public final void setInstreamAd(InstreamAd instreamAd) {
        if (instreamAd != null) {
            instreamAd.zza(this);
        }
    }

    public InstreamAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstreamAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
