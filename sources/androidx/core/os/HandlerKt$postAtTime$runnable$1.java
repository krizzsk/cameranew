package androidx.core.os;

import kotlin.jvm.b.a;
import kotlin.u;
/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ a<u> $action;

    public HandlerKt$postAtTime$runnable$1(a<u> aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
