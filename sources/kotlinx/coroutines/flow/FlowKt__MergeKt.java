package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Merge.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__MergeKt {
    static {
        kotlinx.coroutines.internal.d0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);
    }

    public static final <T, R> c<R> a(c<? extends T> cVar, kotlin.jvm.b.p<? super T, ? super Continuation<? super R>, ? extends Object> pVar) {
        return e.E(cVar, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    public static final <T, R> c<R> b(c<? extends T> cVar, kotlin.jvm.b.q<? super d<? super R>, ? super T, ? super Continuation<? super kotlin.u>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, cVar, null, 0, null, 28, null);
    }
}
