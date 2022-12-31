package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Zip.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 extends SuspendLambda implements kotlin.jvm.b.q<d<? super R>, Object[], Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.s $transform$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2(Continuation continuation, kotlin.jvm.b.s sVar) {
        super(3, continuation);
        this.$transform$inlined = sVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(d<? super R> dVar, Object[] objArr, Continuation<? super kotlin.u> continuation) {
        FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 = new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2(continuation, this.$transform$inlined);
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.L$0 = dVar;
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.L$1 = objArr;
        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2.invokeSuspend(kotlin.u.a);
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
            kotlin.jvm.b.s sVar = this.$transform$inlined;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Object obj4 = objArr[2];
            Object obj5 = objArr[3];
            this.L$0 = dVar;
            this.label = 1;
            kotlin.jvm.internal.r.c(6);
            obj = sVar.invoke(obj2, obj3, obj4, obj5, this);
            kotlin.jvm.internal.r.c(7);
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
