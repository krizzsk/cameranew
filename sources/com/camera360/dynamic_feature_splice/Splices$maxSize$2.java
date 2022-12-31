package com.camera360.dynamic_feature_splice;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.Lambda;
/* compiled from: Splices.kt */
/* loaded from: classes8.dex */
final class Splices$maxSize$2 extends Lambda implements kotlin.jvm.b.a<Integer> {
    public static final Splices$maxSize$2 INSTANCE = new Splices$maxSize$2();

    Splices$maxSize$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final Integer invoke() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return Integer.valueOf((displayMetrics.widthPixels * displayMetrics.heightPixels) / 3);
    }
}
