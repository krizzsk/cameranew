package us.pinguo.edit2020.controller;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$quitWithApplyManualMatting$1 extends Lambda implements kotlin.jvm.b.l<Float, kotlin.u> {
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$quitWithApplyManualMatting$1$1", f = "BackgroundReplacementController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$quitWithApplyManualMatting$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ float $validPixelPercent;
        int label;
        final /* synthetic */ BackgroundReplacementController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f2, BackgroundReplacementController backgroundReplacementController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$validPixelPercent = f2;
            this.this$0 = backgroundReplacementController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$validPixelPercent, this.this$0, continuation);
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
                if (this.$validPixelPercent >= 0.005f) {
                    this.this$0.c.w0(true);
                    this.this$0.K0();
                } else {
                    us.pinguo.foundation.utils.k0.a.c(R.string.str_empty_musk_hint);
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$quitWithApplyManualMatting$1(BackgroundReplacementController backgroundReplacementController) {
        super(1);
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2) {
        invoke(f2.floatValue());
        return kotlin.u.a;
    }

    public final void invoke(float f2) {
        LifecycleOwner lifecycleOwner;
        lifecycleOwner = this.this$0.a;
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(f2, this.this$0, null), 2, null);
    }
}
