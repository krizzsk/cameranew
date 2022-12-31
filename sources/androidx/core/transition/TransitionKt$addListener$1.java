package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt$addListener$1 extends Lambda implements l<Transition, u> {
    public static final TransitionKt$addListener$1 INSTANCE = new TransitionKt$addListener$1();

    public TransitionKt$addListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Transition transition) {
        invoke2(transition);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Transition it) {
        s.h(it, "it");
    }
}
