package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
/* loaded from: classes3.dex */
public final class ae extends ad {
    private final AnimationSet b;

    public ae() {
        super(new AnimationSet(true));
        this.b = (AnimationSet) this.a;
    }

    public final ae a(Animation animation) {
        this.b.addAnimation(animation);
        return this;
    }

    @Override // com.tapjoy.internal.ad
    public final /* bridge */ /* synthetic */ Animation a() {
        return this.b;
    }
}
