package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: BackgroundReplacementController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$enter$1", f = "BackgroundReplacementController.kt", i = {}, l = {189, 190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BackgroundReplacementController$enter$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackgroundReplacementController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.BackgroundReplacementController$enter$1$1", f = "BackgroundReplacementController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$enter$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ BackgroundReplacementController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BackgroundReplacementController.kt */
        /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$enter$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public /* synthetic */ class C03831 extends FunctionReferenceImpl implements kotlin.jvm.b.w<String, Float, Float, Float, Float, Float, Float, Integer, Integer, kotlin.u> {
            C03831(Object obj) {
                super(9, obj, BackgroundReplacementController.class, "onBgItemChanged", "onBgItemChanged(Ljava/lang/String;FFFFFFII)V", 0);
            }

            @Override // kotlin.jvm.b.w
            public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Integer num, Integer num2) {
                invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), f6.floatValue(), f7.floatValue(), num.intValue(), num2.intValue());
                return kotlin.u.a;
            }

            public final void invoke(String p0, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
                kotlin.jvm.internal.s.h(p0, "p0");
                ((BackgroundReplacementController) this.receiver).J0(p0, f2, f3, f4, f5, f6, f7, i2, i3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackgroundReplacementController backgroundReplacementController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = backgroundReplacementController;
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
            kotlin.jvm.b.l<? super EditModel, kotlin.u> lVar;
            PGEditBottomTabLayout pGEditBottomTabLayout;
            PGEditBottomTabLayout pGEditBottomTabLayout2;
            us.pinguo.edit2020.view.c0 c0Var;
            us.pinguo.edit2020.view.c0 c0Var2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                BackgroundReplacementModule backgroundReplacementModule = this.this$0.c;
                lVar = this.this$0.I;
                backgroundReplacementModule.r(lVar);
                this.this$0.c.B(true);
                this.this$0.c.u0(new C03831(this.this$0));
                pGEditBottomTabLayout = this.this$0.f10283d;
                PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.this$0.c.M(), false, null, 6, null);
                pGEditBottomTabLayout2 = this.this$0.f10283d;
                pGEditBottomTabLayout2.B();
                this.this$0.P0();
                c0Var = this.this$0.f10289j;
                c0Var.D(this.this$0);
                this.this$0.f10287h.V(true);
                c0Var2 = this.this$0.f10289j;
                c0Var2.u(false);
                this.this$0.C0();
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$enter$1(BackgroundReplacementController backgroundReplacementController, Continuation<? super BackgroundReplacementController$enter$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundReplacementController$enter$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((BackgroundReplacementController$enter$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            BackgroundReplacementModule backgroundReplacementModule = this.this$0.c;
            this.label = 1;
            if (backgroundReplacementModule.s(this) == coroutine_suspended) {
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
