package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: Zip.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {292, 292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$6$2 extends SuspendLambda implements kotlin.jvm.b.q<d<? super R>, T[], Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlin.jvm.b.p<T[], Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(kotlin.jvm.b.p<? super T[], ? super Continuation<? super R>, ? extends Object> pVar, Continuation<? super FlowKt__ZipKt$combine$6$2> continuation) {
        super(3, continuation);
        this.$transform = pVar;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(d<? super R> dVar, T[] tArr, Continuation<? super kotlin.u> continuation) {
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, continuation);
        flowKt__ZipKt$combine$6$2.L$0 = dVar;
        flowKt__ZipKt$combine$6$2.L$1 = tArr;
        return flowKt__ZipKt$combine$6$2.invokeSuspend(kotlin.u.a);
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
            kotlin.jvm.b.p<T[], Continuation<? super R>, Object> pVar = this.$transform;
            this.L$0 = dVar;
            this.label = 1;
            obj = pVar.invoke((Object[]) this.L$1, this);
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

    public final Object invokeSuspend$$forInline(Object obj) {
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        kotlin.jvm.internal.r.c(0);
        ((d) this.L$0).emit(invoke, this);
        kotlin.jvm.internal.r.c(1);
        return kotlin.u.a;
    }
}
