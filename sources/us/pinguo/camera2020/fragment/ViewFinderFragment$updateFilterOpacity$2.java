package us.pinguo.camera2020.fragment;

import com.pinguo.camera360.effect.model.entity.Effect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$updateFilterOpacity$2", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$updateFilterOpacity$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ int $currentOpacity;
    final /* synthetic */ int $defaultOpacity;
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ boolean $isNonePreviewFilter;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$updateFilterOpacity$2(ViewFinderFragment viewFinderFragment, boolean z, FilterEntry filterEntry, int i2, int i3, Continuation<? super ViewFinderFragment$updateFilterOpacity$2> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
        this.$isNonePreviewFilter = z;
        this.$entry = filterEntry;
        this.$currentOpacity = i2;
        this.$defaultOpacity = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$updateFilterOpacity$2(this.this$0, this.$isNonePreviewFilter, this.$entry, this.$currentOpacity, this.$defaultOpacity, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$updateFilterOpacity$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.camera2020.module.b bVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.this$0.n4(this.$isNonePreviewFilter);
            FilterController filterController = this.this$0.u;
            if (filterController != null) {
                int i2 = this.$currentOpacity;
                int i3 = this.$defaultOpacity;
                filterController.B1(i2);
                filterController.A1(i3);
            }
            if (kotlin.jvm.internal.s.c(this.$entry.getItemId(), Effect.EFFECT_FILTER_NONE_KEY)) {
                CameraViewModel cameraViewModel = this.this$0.f9174j;
                if (cameraViewModel == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (cameraViewModel.getCameraFilterModule().E()) {
                    CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                    if (cameraViewModel2 != null) {
                        cameraViewModel2.getCameraFilterModule().i0(false);
                        return kotlin.u.a;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            bVar = this.this$0.I;
            bVar.a(ExclusiveEffectType.EFFECT_FILTER);
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
