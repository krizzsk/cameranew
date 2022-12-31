package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
/* compiled from: Select.kt */
/* loaded from: classes3.dex */
public interface a<R> {
    void h(long j2, l<? super Continuation<? super R>, ? extends Object> lVar);

    <Q> void s(d<? extends Q> dVar, p<? super Q, ? super Continuation<? super R>, ? extends Object> pVar);
}
