package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.filter.util.FilterParamsHelper;
import us.pinguo.repository2020.FilterConstants;
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$filterMutex$1$onEffectApplied$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class ViewFinderFragment$filterMutex$1$onEffectApplied$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ ExclusiveEffectType $effectType;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$filterMutex$1$onEffectApplied$1(ExclusiveEffectType exclusiveEffectType, ViewFinderFragment viewFinderFragment, Continuation<? super ViewFinderFragment$filterMutex$1$onEffectApplied$1> continuation) {
        super(2, continuation);
        this.$effectType = exclusiveEffectType;
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$filterMutex$1$onEffectApplied$1(this.$effectType, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$filterMutex$1$onEffectApplied$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            ExclusiveEffectType exclusiveEffectType = this.$effectType;
            ExclusiveEffectType exclusiveEffectType2 = ExclusiveEffectType.EFFECT_FILTER;
            if (exclusiveEffectType != exclusiveEffectType2 && exclusiveEffectType != ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP && exclusiveEffectType != ExclusiveEffectType.EFFECT_SHAPE) {
                us.pinguo.repository2020.o h2 = us.pinguo.repository2020.m.a.h();
                if (h2 != null) {
                    h2.h(true);
                }
                CameraViewModel cameraViewModel = this.this$0.f9174j;
                if (cameraViewModel != null) {
                    cameraViewModel.getCameraFilterModule().i0(true);
                    CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                    if (cameraViewModel2 != null) {
                        cameraViewModel2.getCameraFilterModule().y().setValue(FilterConstants.f());
                        us.pinguo.processor.d a = FilterParamsHelper.c.a();
                        CameraViewModel cameraViewModel3 = this.this$0.f9174j;
                        if (cameraViewModel3 != null) {
                            cameraViewModel3.setMakeInfo(a);
                            this.this$0.v.c();
                            FilterController filterController = this.this$0.u;
                            if (filterController != null) {
                                filterController.h0();
                            }
                            us.pinguo.camera2020.i.a aVar = us.pinguo.camera2020.i.a.a;
                            aVar.i(false);
                            aVar.m("");
                            aVar.k(false);
                            FilterController filterController2 = this.this$0.u;
                            if (filterController2 != null) {
                                filterController2.p1(true);
                            }
                        } else {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            if (this.$effectType == exclusiveEffectType2) {
                us.pinguo.repository2020.o h3 = us.pinguo.repository2020.m.a.h();
                if (h3 != null) {
                    h3.h(false);
                }
                FilterController filterController3 = this.this$0.u;
                if (filterController3 != null) {
                    filterController3.p1(false);
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
