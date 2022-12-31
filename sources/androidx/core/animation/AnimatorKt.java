package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator animator, l<? super Animator, u> onEnd, l<? super Animator, u> onStart, l<? super Animator, u> onCancel, l<? super Animator, u> onRepeat) {
        s.h(animator, "<this>");
        s.h(onEnd, "onEnd");
        s.h(onStart, "onStart");
        s.h(onCancel, "onCancel");
        s.h(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, l onEnd, l onStart, l onCancel, l onRepeat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onEnd = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            onStart = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            onCancel = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            onRepeat = AnimatorKt$addListener$4.INSTANCE;
        }
        s.h(animator, "<this>");
        s.h(onEnd, "onEnd");
        s.h(onStart, "onStart");
        s.h(onCancel, "onCancel");
        s.h(onRepeat, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(onRepeat, onEnd, onCancel, onStart);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, l<? super Animator, u> onResume, l<? super Animator, u> onPause) {
        s.h(animator, "<this>");
        s.h(onResume, "onResume");
        s.h(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, l onResume, l onPause, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onResume = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            onPause = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        s.h(animator, "<this>");
        s.h(onResume, "onResume");
        s.h(onPause, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(onPause, onResume);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                s.h(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                s.h(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                s.h(animator2, "animator");
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                s.h(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, final l<? super Animator, u> action) {
        s.h(animator, "<this>");
        s.h(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                s.h(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                s.h(animator2, "animator");
                l.this.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
