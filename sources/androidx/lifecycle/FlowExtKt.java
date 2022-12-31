package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.e;
/* compiled from: FlowExt.kt */
/* loaded from: classes.dex */
public final class FlowExtKt {
    public static final <T> c<T> flowWithLifecycle(c<? extends T> cVar, Lifecycle lifecycle, Lifecycle.State minActiveState) {
        s.h(cVar, "<this>");
        s.h(lifecycle, "lifecycle");
        s.h(minActiveState, "minActiveState");
        return e.c(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, cVar, null));
    }

    public static /* synthetic */ c flowWithLifecycle$default(c cVar, Lifecycle lifecycle, Lifecycle.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(cVar, lifecycle, state);
    }
}
