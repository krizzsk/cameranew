package com.camera360.dynamic_feature_splice;

import android.content.res.Resources;
import kotlin.jvm.internal.Lambda;
/* compiled from: SpliceUtils.kt */
/* loaded from: classes8.dex */
final class SpliceUtils$spliceWidth$2 extends Lambda implements kotlin.jvm.b.a<Integer> {
    public static final SpliceUtils$spliceWidth$2 INSTANCE = new SpliceUtils$spliceWidth$2();

    SpliceUtils$spliceWidth$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final Integer invoke() {
        int i2;
        int i3 = Resources.getSystem().getDisplayMetrics().widthPixels;
        if (i3 < 500) {
            i2 = 600;
        } else if (i3 < 700) {
            i2 = 800;
        } else {
            i2 = (i3 < 900 || Splices.a.a() < 5000) ? 1000 : 1200;
        }
        return Integer.valueOf(i2);
    }
}
