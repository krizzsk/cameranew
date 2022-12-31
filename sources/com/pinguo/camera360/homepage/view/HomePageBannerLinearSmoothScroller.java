package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.jvm.internal.s;
/* compiled from: HomePageBannerLinearSmoothScroller.kt */
/* loaded from: classes3.dex */
public final class HomePageBannerLinearSmoothScroller extends LinearSmoothScroller {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageBannerLinearSmoothScroller(Context context) {
        super(context);
        s.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        s.h(displayMetrics, "displayMetrics");
        return 60.0f / displayMetrics.densityDpi;
    }
}
