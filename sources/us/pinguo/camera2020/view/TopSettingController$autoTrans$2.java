package us.pinguo.camera2020.view;

import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.view.TopSettingController$transitionListener$2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopSettingController.kt */
/* loaded from: classes3.dex */
public final class TopSettingController$autoTrans$2 extends Lambda implements kotlin.jvm.b.a<AutoTransition> {
    final /* synthetic */ TopSettingController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingController$autoTrans$2(TopSettingController topSettingController) {
        super(0);
        this.this$0 = topSettingController;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final AutoTransition invoke() {
        TopSettingController$transitionListener$2.a s;
        AutoTransition autoTransition = new AutoTransition();
        TopSettingController topSettingController = this.this$0;
        autoTransition.setDuration(200L);
        s = topSettingController.s();
        autoTransition.addListener((Transition.TransitionListener) s);
        return autoTransition;
    }
}
