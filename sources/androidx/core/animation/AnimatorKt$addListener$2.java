package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$2 extends Lambda implements l<Animator, u> {
    public static final AnimatorKt$addListener$2 INSTANCE = new AnimatorKt$addListener$2();

    public AnimatorKt$addListener$2() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Animator animator) {
        invoke2(animator);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Animator it) {
        s.h(it, "it");
    }
}
