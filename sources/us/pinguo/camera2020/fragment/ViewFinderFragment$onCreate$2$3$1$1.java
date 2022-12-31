package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$2$3$1$1", f = "ViewFinderFragment.kt", i = {0}, l = {IjkMediaCodecInfo.RANK_SECURE}, m = "invokeSuspend", n = {"entry"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$onCreate$2$3$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onCreate$2$3$1$1(ViewFinderFragment viewFinderFragment, Continuation<? super ViewFinderFragment$onCreate$2$3$1$1> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$onCreate$2$3$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$onCreate$2$3$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FilterEntry filterEntry;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            CameraViewModel cameraViewModel = this.this$0.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            FilterEntry value = cameraViewModel.getCameraFilterModule().y().getValue();
            if (value == null) {
                return kotlin.u.a;
            }
            CameraViewModel cameraViewModel2 = this.this$0.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            CameraFilterModule cameraFilterModule = cameraViewModel2.getCameraFilterModule();
            this.L$0 = value;
            this.label = 1;
            Object W = cameraFilterModule.W(value, this);
            if (W == coroutine_suspended) {
                return coroutine_suspended;
            }
            filterEntry = value;
            obj = W;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            filterEntry = (FilterEntry) this.L$0;
            kotlin.j.b(obj);
        }
        if (kotlin.jvm.internal.s.c(obj, Boxing.boxBoolean(true))) {
            CameraViewModel cameraViewModel3 = this.this$0.f9174j;
            if (cameraViewModel3 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            } else if (cameraViewModel3.getCurrentExclusiveType() == ExclusiveEffectType.EFFECT_FILTER) {
                this.this$0.v4(filterEntry);
            }
        }
        return kotlin.u.a;
    }
}
