package us.pinguo.inspire.module.challenge;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: ChallengeTabHelper.kt */
/* loaded from: classes9.dex */
final class ChallengeTabHelper$titleShadowView$2 extends Lambda implements kotlin.jvm.b.a<View> {
    final /* synthetic */ ChallengeTabHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeTabHelper$titleShadowView$2(ChallengeTabHelper challengeTabHelper) {
        super(0);
        this.this$0 = challengeTabHelper;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final View invoke() {
        View view = this.this$0.getView();
        s.e(view);
        return view.getRootView().findViewById(R.id.challenge_tab_title_shadow);
    }
}
