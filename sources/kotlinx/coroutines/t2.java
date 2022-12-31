package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: ThreadContextElement.kt */
/* loaded from: classes3.dex */
public interface t2<S> extends CoroutineContext.Element {

    /* compiled from: ThreadContextElement.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <S, R> R a(t2<S> t2Var, R r, kotlin.jvm.b.p<? super R, ? super CoroutineContext.Element, ? extends R> pVar) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(t2Var, r, pVar);
        }

        public static <S> CoroutineContext b(t2<S> t2Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(t2Var, coroutineContext);
        }
    }

    S N(CoroutineContext coroutineContext);

    void n(CoroutineContext coroutineContext, S s);
}
