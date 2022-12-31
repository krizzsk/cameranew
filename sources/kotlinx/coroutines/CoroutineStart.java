package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
/* compiled from: CoroutineStart.kt */
/* loaded from: classes3.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            a = iArr;
        }
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public final <T> void invoke(kotlin.jvm.b.l<? super Continuation<? super T>, ? extends Object> lVar, Continuation<? super T> continuation) {
        int i2 = a.a[ordinal()];
        if (i2 == 1) {
            kotlinx.coroutines.d3.a.d(lVar, continuation);
        } else if (i2 == 2) {
            ContinuationKt.startCoroutine(lVar, continuation);
        } else if (i2 == 3) {
            kotlinx.coroutines.d3.b.a(lVar, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }

    public final <R, T> void invoke(kotlin.jvm.b.p<? super R, ? super Continuation<? super T>, ? extends Object> pVar, R r, Continuation<? super T> continuation) {
        int i2 = a.a[ordinal()];
        if (i2 == 1) {
            kotlinx.coroutines.d3.a.f(pVar, r, continuation, null, 4, null);
        } else if (i2 == 2) {
            ContinuationKt.startCoroutine(pVar, r, continuation);
        } else if (i2 == 3) {
            kotlinx.coroutines.d3.b.b(pVar, r, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
