package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
public class i {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements e<T> {
        final /* synthetic */ p a;

        public a(p pVar) {
            this.a = pVar;
        }

        @Override // kotlin.sequences.e
        public Iterator<T> iterator() {
            return i.a(this.a);
        }
    }

    public static final <T> Iterator<T> a(p<? super g<? super T>, ? super Continuation<? super u>, ? extends Object> block) {
        Continuation<u> createCoroutineUnintercepted;
        s.h(block, "block");
        f fVar = new f();
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(block, fVar, fVar);
        fVar.i(createCoroutineUnintercepted);
        return fVar;
    }

    public static <T> e<T> b(p<? super g<? super T>, ? super Continuation<? super u>, ? extends Object> block) {
        s.h(block, "block");
        return new a(block);
    }
}
