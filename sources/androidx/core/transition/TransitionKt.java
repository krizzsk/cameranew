package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, l<? super Transition, u> onEnd, l<? super Transition, u> onStart, l<? super Transition, u> onCancel, l<? super Transition, u> onResume, l<? super Transition, u> onPause) {
        s.h(transition, "<this>");
        s.h(onEnd, "onEnd");
        s.h(onStart, "onStart");
        s.h(onCancel, "onCancel");
        s.h(onResume, "onResume");
        s.h(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l onEnd, l lVar, l lVar2, l onResume, l onPause, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onEnd = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            lVar = TransitionKt$addListener$2.INSTANCE;
        }
        l onStart = lVar;
        if ((i2 & 4) != 0) {
            lVar2 = TransitionKt$addListener$3.INSTANCE;
        }
        l onCancel = lVar2;
        if ((i2 & 8) != 0) {
            onResume = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            onPause = TransitionKt$addListener$5.INSTANCE;
        }
        s.h(transition, "<this>");
        s.h(onEnd, "onEnd");
        s.h(onStart, "onStart");
        s.h(onCancel, "onCancel");
        s.h(onResume, "onResume");
        s.h(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, final l<? super Transition, u> action) {
        s.h(transition, "<this>");
        s.h(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                s.h(transition2, "transition");
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                s.h(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, final l<? super Transition, u> action) {
        s.h(transition, "<this>");
        s.h(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                s.h(transition2, "transition");
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                s.h(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, final l<? super Transition, u> action) {
        s.h(transition, "<this>");
        s.h(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                s.h(transition2, "transition");
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                s.h(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, final l<? super Transition, u> action) {
        s.h(transition, "<this>");
        s.h(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                s.h(transition2, "transition");
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                s.h(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, final l<? super Transition, u> action) {
        s.h(transition, "<this>");
        s.h(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                s.h(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                s.h(transition2, "transition");
                l.this.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
