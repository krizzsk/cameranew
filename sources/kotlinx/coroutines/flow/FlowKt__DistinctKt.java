package kotlinx.coroutines.flow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Distinct.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class FlowKt__DistinctKt {
    private static final kotlin.jvm.b.l<Object, Object> a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
    private static final kotlin.jvm.b.p<Object, Object, Boolean> b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> c<T> a(c<? extends T> cVar) {
        return cVar instanceof h1 ? cVar : b(cVar, a, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> c<T> b(c<? extends T> cVar, kotlin.jvm.b.l<? super T, ? extends Object> lVar, kotlin.jvm.b.p<Object, Object, Boolean> pVar) {
        if (cVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) cVar;
            if (distinctFlowImpl.b == lVar && distinctFlowImpl.c == pVar) {
                return cVar;
            }
        }
        return new DistinctFlowImpl(cVar, lVar, pVar);
    }
}
