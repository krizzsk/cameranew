package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ l<Animator, u> $onPause;
    final /* synthetic */ l<Animator, u> $onResume;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addPauseListener$listener$1(l<? super Animator, u> lVar, l<? super Animator, u> lVar2) {
        this.$onPause = lVar;
        this.$onResume = lVar2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        s.h(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        s.h(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
