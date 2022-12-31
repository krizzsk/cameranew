package us.pinguo.common.widget.banner2;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.jvm.internal.s;
/* compiled from: ViewPager2BannerLayoutManager.kt */
/* loaded from: classes4.dex */
public final class ViewPager2LinearSmoothScroller extends LinearSmoothScroller {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2LinearSmoothScroller(Context context) {
        super(context);
        s.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        s.h(displayMetrics, "displayMetrics");
        return 50.0f / displayMetrics.densityDpi;
    }
}
