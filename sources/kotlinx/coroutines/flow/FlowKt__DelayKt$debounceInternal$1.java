package kotlinx.coroutines.flow;

import com.tapjoy.TJAdUnitConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {224, 358}, m = "invokeSuspend", n = {"downstream", TJAdUnitConstants.String.USAGE_TRACKER_VALUES, "lastValue", "timeoutMillis", "downstream", TJAdUnitConstants.String.USAGE_TRACKER_VALUES, "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements kotlin.jvm.b.q<kotlinx.coroutines.m0, d<? super T>, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ c<T> $this_debounceInternal;
    final /* synthetic */ kotlin.jvm.b.l<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1(kotlin.jvm.b.l<? super T, Long> lVar, c<? extends T> cVar, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = lVar;
        this.$this_debounceInternal = cVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(kotlinx.coroutines.m0 m0Var, d<? super T> dVar, Continuation<? super kotlin.u> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = m0Var;
        flowKt__DelayKt$debounceInternal$1.L$1 = dVar;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:61|26|30|31|(3:33|(1:41)(1:37)|(2:39|40))|42|43|44|(1:46)|47|48|(1:50)|(1:52)(1:53)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0117, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0118, code lost:
        r13.V(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0100 A[Catch: all -> 0x0117, TryCatch #0 {all -> 0x0117, blocks: (B:49:0x00fc, B:51:0x0100, B:52:0x010a), top: B:64:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x012b -> B:11:0x0072). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
