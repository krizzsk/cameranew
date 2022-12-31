package us.pinguo.inspire.module.MissionDetail;

import android.view.View;
/* compiled from: HeaderShadowHelper.kt */
/* loaded from: classes9.dex */
public final class HeaderShadowHelper {
    private final View headerRoot;
    private final String headerViewTag;
    private final View titleShadowView;

    public HeaderShadowHelper(View titleShadowView, String headerViewTag, View headerRoot) {
        kotlin.jvm.internal.s.h(titleShadowView, "titleShadowView");
        kotlin.jvm.internal.s.h(headerViewTag, "headerViewTag");
        kotlin.jvm.internal.s.h(headerRoot, "headerRoot");
        this.titleShadowView = titleShadowView;
        this.headerViewTag = headerViewTag;
        this.headerRoot = headerRoot;
    }

    public final void onScrolled() {
        View findViewWithTag = this.headerRoot.findViewWithTag(this.headerViewTag);
        if (findViewWithTag != null && findViewWithTag.getParent() != null) {
            int height = findViewWithTag.getHeight();
            int[] iArr = new int[2];
            findViewWithTag.getLocationInWindow(iArr);
            float f2 = (-iArr[1]) / height;
            this.titleShadowView.setAlpha(f2 <= 1.0f ? f2 < 0.0f ? 0.0f : f2 : 1.0f);
            return;
        }
        this.titleShadowView.setAlpha(1.0f);
    }
}
