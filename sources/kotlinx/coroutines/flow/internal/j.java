package kotlinx.coroutines.flow.internal;
/* compiled from: FlowExceptions.common.kt */
/* loaded from: classes3.dex */
public final class j {
    public static final void a(AbortFlowException abortFlowException, kotlinx.coroutines.flow.d<?> dVar) {
        if (abortFlowException.getOwner() != dVar) {
            throw abortFlowException;
        }
    }
}
