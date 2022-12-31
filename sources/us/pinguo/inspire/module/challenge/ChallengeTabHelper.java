package us.pinguo.inspire.module.challenge;

import android.view.View;
import kotlin.jvm.internal.s;
/* compiled from: ChallengeTabHelper.kt */
/* loaded from: classes9.dex */
public final class ChallengeTabHelper {
    private final kotlin.f titleShadowView$delegate;
    private final View view;

    public ChallengeTabHelper(View view) {
        kotlin.f b;
        s.h(view, "view");
        this.view = view;
        b = kotlin.h.b(new ChallengeTabHelper$titleShadowView$2(this));
        this.titleShadowView$delegate = b;
    }

    private final View getTitleShadowView() {
        Object value = this.titleShadowView$delegate.getValue();
        s.g(value, "<get-titleShadowView>(...)");
        return (View) value;
    }

    public final View getView() {
        return this.view;
    }

    public final void onScrolled() {
        View findViewWithTag = this.view.findViewWithTag("challenge_banner");
        if (findViewWithTag == null) {
            getTitleShadowView().setAlpha(1.0f);
            return;
        }
        int height = findViewWithTag.getHeight();
        int[] iArr = new int[2];
        findViewWithTag.getLocationInWindow(iArr);
        float f2 = (-iArr[1]) / height;
        getTitleShadowView().setAlpha(f2 <= 1.0f ? f2 < 0.0f ? 0.0f : f2 : 1.0f);
    }
}
