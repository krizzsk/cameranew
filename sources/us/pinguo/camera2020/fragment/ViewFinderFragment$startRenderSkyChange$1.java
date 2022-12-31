package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$startRenderSkyChange$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$startRenderSkyChange$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$startRenderSkyChange$1(ViewFinderFragment viewFinderFragment, FilterEntry filterEntry, Continuation<? super ViewFinderFragment$startRenderSkyChange$1> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
        this.$entry = filterEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$startRenderSkyChange$1(this.this$0, this.$entry, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$startRenderSkyChange$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            CameraViewModel cameraViewModel = this.this$0.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.getAfterCaptureModule().r().postValue(Boxing.boxBoolean(true));
                CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                if (cameraViewModel2 != null) {
                    if (cameraViewModel2.getAfterCaptureModule().l() != null) {
                        this.this$0.s2(this.$entry);
                    } else {
                        CameraViewModel cameraViewModel3 = this.this$0.f9174j;
                        if (cameraViewModel3 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        cameraViewModel3.getAfterCaptureModule().M();
                    }
                    return kotlin.u.a;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
