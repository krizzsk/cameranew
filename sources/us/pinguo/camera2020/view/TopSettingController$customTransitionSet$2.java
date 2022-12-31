package us.pinguo.camera2020.view;

import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.view.TopSettingController$transitionListener$2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopSettingController.kt */
/* loaded from: classes3.dex */
public final class TopSettingController$customTransitionSet$2 extends Lambda implements kotlin.jvm.b.a<TransitionSet> {
    final /* synthetic */ TopSettingController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingController$customTransitionSet$2(TopSettingController topSettingController) {
        super(0);
        this.this$0 = topSettingController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final TransitionSet invoke() {
        TopSettingController$transitionListener$2.a s;
        TransitionSet transitionSet = new TransitionSet();
        TopSettingController topSettingController = this.this$0;
        transitionSet.setOrdering(1);
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new Fade(1));
        s = topSettingController.s();
        transitionSet.addListener((Transition.TransitionListener) s);
        return transitionSet;
    }
}
