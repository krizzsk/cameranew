package us.pinguo.edit2020.controller;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.menuview.BeautySkinRefreshViewNew;
import us.pinguo.repository2020.entity.BeautyEditData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SkinRefreshController.kt */
/* loaded from: classes4.dex */
public final class SkinRefreshController$setUnityStepHistory$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ SkinRefreshController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinRefreshController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.SkinRefreshController$setUnityStepHistory$1$1", f = "SkinRefreshController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.SkinRefreshController$setUnityStepHistory$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ String $it;
        int label;
        final /* synthetic */ SkinRefreshController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SkinRefreshController skinRefreshController, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = skinRefreshController;
            this.$it = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$it, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float f2;
            float floatValue;
            int maxValue;
            us.pinguo.edit2020.bean.i O;
            int b;
            us.pinguo.edit2020.view.c0 c0Var;
            int b2;
            float defaultValue;
            float maxValue2;
            us.pinguo.edit2020.bean.i O2;
            us.pinguo.edit2020.view.c0 c0Var2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                Float f0 = this.this$0.f10417d.f0(this.$it);
                String d0 = this.this$0.f10417d.d0(this.$it);
                boolean e0 = this.this$0.f10417d.e0(this.$it);
                if (f0 != null) {
                    SkinRefreshController skinRefreshController = this.this$0;
                    f0.floatValue();
                    us.pinguo.edit2020.bean.i I = skinRefreshController.I();
                    if (I != null && d0 != null) {
                        f2 = skinRefreshController.r;
                        if (kotlin.jvm.internal.s.a(f0, f2)) {
                            if (kotlin.jvm.internal.s.c(d0, skinRefreshController.p)) {
                                defaultValue = I.g().getDefaultValue() / I.g().getMaxValue();
                                maxValue2 = skinRefreshController.q;
                            } else {
                                defaultValue = I.g().getDefaultValue();
                                maxValue2 = I.g().getMaxValue();
                            }
                            skinRefreshController.f10417d.v0(d0, defaultValue / maxValue2);
                            if (kotlin.jvm.internal.s.c(I.f(), d0)) {
                                c0Var2 = skinRefreshController.c;
                                c0Var2.I(I.g().getMinValue(), I.g().getMaxValue(), I.g().getDefaultValue(), I.g().getDefaultValue());
                            }
                            O2 = skinRefreshController.O(d0);
                            if (O2 != null) {
                                O2.g().setCurrentValue(O2.g().getDefaultValue());
                                O2.h(false);
                            }
                        } else {
                            if (kotlin.jvm.internal.s.c(d0, skinRefreshController.p)) {
                                floatValue = f0.floatValue() * skinRefreshController.q;
                                maxValue = I.g().getMaxValue();
                            } else {
                                floatValue = f0.floatValue();
                                maxValue = I.g().getMaxValue();
                            }
                            float f3 = floatValue * maxValue;
                            if (kotlin.jvm.internal.s.c(I.f(), d0)) {
                                c0Var = skinRefreshController.c;
                                int minValue = I.g().getMinValue();
                                int maxValue3 = I.g().getMaxValue();
                                b2 = kotlin.y.c.b(f3);
                                c0Var.I(minValue, maxValue3, b2, I.g().getDefaultValue());
                            }
                            O = skinRefreshController.O(d0);
                            if (O != null) {
                                BeautyEditData g2 = O.g();
                                b = kotlin.y.c.b(f3);
                                g2.setCurrentValue(b);
                                O.h(e0);
                            }
                        }
                    }
                }
                this.this$0.d0();
                BeautySkinRefreshViewNew H = this.this$0.H();
                if (H != null) {
                    H.k();
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinRefreshController$setUnityStepHistory$1(SkinRefreshController skinRefreshController) {
        super(1);
        this.this$0 = skinRefreshController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        LifecycleOwner lifecycleOwner;
        kotlin.jvm.internal.s.h(it, "it");
        lifecycleOwner = this.this$0.f10418e;
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(this.this$0, it, null), 2, null);
    }
}
