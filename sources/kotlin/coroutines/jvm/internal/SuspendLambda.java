package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class SuspendLambda extends ContinuationImpl implements q<Object>, SuspendFunction {
    private final int arity;

    public SuspendLambda(int i2, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.q
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String j2 = v.j(this);
            s.g(j2, "renderLambdaToString(this)");
            return j2;
        }
        return super.toString();
    }

    public SuspendLambda(int i2) {
        this(i2, null);
    }
}
