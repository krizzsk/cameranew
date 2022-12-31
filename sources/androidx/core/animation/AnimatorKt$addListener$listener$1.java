package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ l<Animator, u> $onCancel;
    final /* synthetic */ l<Animator, u> $onEnd;
    final /* synthetic */ l<Animator, u> $onRepeat;
    final /* synthetic */ l<Animator, u> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(l<? super Animator, u> lVar, l<? super Animator, u> lVar2, l<? super Animator, u> lVar3, l<? super Animator, u> lVar4) {
        this.$onRepeat = lVar;
        this.$onEnd = lVar2;
        this.$onCancel = lVar3;
        this.$onStart = lVar4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        s.h(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        s.h(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        s.h(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        s.h(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
