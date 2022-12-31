package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
/* compiled from: StaticStickerController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$onWorkflowCompleted$1", f = "StaticStickerController.kt", i = {}, l = {751, 752}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class StaticStickerController$onWorkflowCompleted$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$onWorkflowCompleted$1$1", f = "StaticStickerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.StaticStickerController$onWorkflowCompleted$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ StaticStickerController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StaticStickerController staticStickerController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                this.this$0.b0();
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$onWorkflowCompleted$1(StaticStickerController staticStickerController, Continuation<? super StaticStickerController$onWorkflowCompleted$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerController$onWorkflowCompleted$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StaticStickerController$onWorkflowCompleted$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object v0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            StaticStickerController staticStickerController = this.this$0;
            this.label = 1;
            v0 = staticStickerController.v0("save", this);
            if (v0 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return kotlin.u.a;
        } else {
            kotlin.j.b(obj);
        }
        kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
