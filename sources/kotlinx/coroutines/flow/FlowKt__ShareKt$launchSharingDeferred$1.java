package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.y1;
/* compiled from: Share.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ kotlinx.coroutines.z<h1<T>> $result;
    final /* synthetic */ c<T> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Collect.kt */
    /* loaded from: classes3.dex */
    public static final class a implements d<T> {
        final /* synthetic */ Ref$ObjectRef a;
        final /* synthetic */ kotlinx.coroutines.m0 b;
        final /* synthetic */ kotlinx.coroutines.z c;

        public a(Ref$ObjectRef ref$ObjectRef, kotlinx.coroutines.m0 m0Var, kotlinx.coroutines.z zVar) {
            this.a = ref$ObjectRef;
            this.b = m0Var;
            this.c = zVar;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.h1, kotlinx.coroutines.flow.y0] */
        @Override // kotlinx.coroutines.flow.d
        public Object emit(T t, Continuation<? super kotlin.u> continuation) {
            kotlin.u uVar;
            y0 y0Var = (y0) this.a.element;
            if (y0Var == null) {
                uVar = null;
            } else {
                y0Var.setValue(t);
                uVar = kotlin.u.a;
            }
            if (uVar == null) {
                kotlinx.coroutines.m0 m0Var = this.b;
                Ref$ObjectRef ref$ObjectRef = this.a;
                ?? a = i1.a(t);
                this.c.p(new z0(a, y1.i(m0Var.getCoroutineContext())));
                kotlin.u uVar2 = kotlin.u.a;
                ref$ObjectRef.element = a;
            }
            return kotlin.u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ShareKt$launchSharingDeferred$1(c<? extends T> cVar, kotlinx.coroutines.z<h1<T>> zVar, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.$upstream = cVar;
        this.$result = zVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                kotlin.j.b(obj);
                kotlinx.coroutines.m0 m0Var = (kotlinx.coroutines.m0) this.L$0;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                c<T> cVar = this.$upstream;
                a aVar = new a(ref$ObjectRef, m0Var, this.$result);
                this.label = 1;
                if (cVar.d(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        } catch (Throwable th) {
            this.$result.o(th);
            throw th;
        }
    }
}
