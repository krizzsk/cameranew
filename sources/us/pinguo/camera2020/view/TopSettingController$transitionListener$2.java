package us.pinguo.camera2020.view;

import androidx.transition.Transition;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopSettingController.kt */
/* loaded from: classes3.dex */
public final class TopSettingController$transitionListener$2 extends Lambda implements kotlin.jvm.b.a<a> {
    final /* synthetic */ TopSettingController this$0;

    /* compiled from: TopSettingController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Transition.TransitionListener {
        final /* synthetic */ TopSettingController a;

        a(TopSettingController topSettingController) {
            this.a = topSettingController;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            kotlin.jvm.internal.s.h(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            kotlin.jvm.internal.s.h(transition, "transition");
            this.a.f9321g = false;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            kotlin.jvm.internal.s.h(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            kotlin.jvm.internal.s.h(transition, "transition");
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            kotlin.jvm.internal.s.h(transition, "transition");
            this.a.f9321g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingController$transitionListener$2(TopSettingController topSettingController) {
        super(0);
        this.this$0 = topSettingController;
    }

    @Override // kotlin.jvm.b.a
    public final a invoke() {
        return new a(this.this$0);
    }
}
