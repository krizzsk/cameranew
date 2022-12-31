package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Zip.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements kotlin.jvm.b.q<d<? super R>, Object[], Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.q<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ZipKt$combine$1$1(kotlin.jvm.b.q<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> qVar, Continuation<? super FlowKt__ZipKt$combine$1$1> continuation) {
        super(3, continuation);
        this.$transform = qVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(d<? super R> dVar, Object[] objArr, Continuation<? super kotlin.u> continuation) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.$transform, continuation);
        flowKt__ZipKt$combine$1$1.L$0 = dVar;
        flowKt__ZipKt$combine$1$1.L$1 = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        d dVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            dVar = (d) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            kotlin.jvm.b.q<T1, T2, Continuation<? super R>, Object> qVar = this.$transform;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            this.L$0 = dVar;
            this.label = 1;
            obj = qVar.invoke(obj2, obj3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            dVar = (d) this.L$0;
            kotlin.j.b(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (dVar.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
