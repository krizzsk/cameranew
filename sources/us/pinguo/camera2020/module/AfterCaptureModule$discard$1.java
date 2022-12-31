package us.pinguo.camera2020.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AfterCaptureModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.AfterCaptureModule$discard$1", f = "AfterCaptureModule.kt", i = {}, l = {259, 260}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AfterCaptureModule$discard$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ AfterCaptureModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AfterCaptureModule.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.module.AfterCaptureModule$discard$1$2", f = "AfterCaptureModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.module.AfterCaptureModule$discard$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        int label;
        final /* synthetic */ AfterCaptureModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AfterCaptureModule afterCaptureModule, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = afterCaptureModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                this.this$0.v();
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfterCaptureModule$discard$1(AfterCaptureModule afterCaptureModule, Continuation<? super AfterCaptureModule$discard$1> continuation) {
        super(2, continuation);
        this.this$0 = afterCaptureModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AfterCaptureModule$discard$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((AfterCaptureModule$discard$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.j.b(r6)
            goto L51
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.j.b(r6)
            goto L33
        L1e:
            kotlin.j.b(r6)
            us.pinguo.camera2020.module.AfterCaptureModule r6 = r5.this$0
            java.lang.String r6 = r6.l()
            if (r6 != 0) goto L2a
            goto L3c
        L2a:
            r5.label = r3
            java.lang.Object r6 = us.pinguo.util.FileUtils.l(r6, r5)
            if (r6 != r0) goto L33
            return r0
        L33:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L3c:
            kotlinx.coroutines.g2 r6 = kotlinx.coroutines.z0.c()
            us.pinguo.camera2020.module.AfterCaptureModule$discard$1$2 r1 = new us.pinguo.camera2020.module.AfterCaptureModule$discard$1$2
            us.pinguo.camera2020.module.AfterCaptureModule r3 = r5.this$0
            r4 = 0
            r1.<init>(r3, r4)
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.j.g(r6, r1, r5)
            if (r6 != r0) goto L51
            return r0
        L51:
            kotlin.u r6 = kotlin.u.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.AfterCaptureModule$discard$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
