package us.pinguo.camera2020.fragment;

import android.util.Log;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$3;
import us.pinguo.camera2020.module.SaveReason;
import us.pinguo.camera2020.view.AfterCaptureBottomController;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.u3dengine.api.CaptureModel;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onCreate$3 extends Lambda implements kotlin.jvm.b.l<CaptureModel, kotlin.u> {
    final /* synthetic */ CameraViewModel $viewModel;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$3$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$3$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ CameraViewModel $viewModel;
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewFinderFragment viewFinderFragment, CameraViewModel cameraViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
            this.$viewModel = cameraViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m68invokeSuspend$lambda0(ViewFinderFragment viewFinderFragment) {
            AfterCaptureBottomController afterCaptureBottomController = viewFinderFragment.q;
            if (afterCaptureBottomController == null) {
                kotlin.jvm.internal.s.z("afterCaptureController");
                throw null;
            } else if (afterCaptureBottomController.H()) {
                ViewFinderFragment.A1(viewFinderFragment, true, false, 2, null);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$viewModel, continuation);
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
                us.pinguo.common.log.a.c("setOnCaptureImageRenderEndCallback", new Object[0]);
                us.pinguo.foundation.c.e("OnCaptureImageRenderEnd");
                CameraViewModel cameraViewModel = this.this$0.f9174j;
                if (cameraViewModel != null) {
                    if (cameraViewModel.getAfterCaptureModule().h() == SaveReason.USER) {
                        CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                        if (cameraViewModel2 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        } else if (cameraViewModel2.getAfterCaptureModule().h() != SaveReason.SKY_CHANGE) {
                            this.$viewModel.getAfterCaptureModule().r().postValue(Boxing.boxBoolean(false));
                            final ViewFinderFragment viewFinderFragment = this.this$0;
                            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.e0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ViewFinderFragment$onCreate$3.AnonymousClass1.m68invokeSuspend$lambda0(ViewFinderFragment.this);
                                }
                            });
                        }
                    }
                    return kotlin.u.a;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onCreate$3(ViewFinderFragment viewFinderFragment, CameraViewModel cameraViewModel) {
        super(1);
        this.this$0 = viewFinderFragment;
        this.$viewModel = cameraViewModel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(CaptureModel captureModel) {
        invoke2(captureModel);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(CaptureModel captureModel) {
        LifecycleCoroutineScope J1;
        kotlin.jvm.internal.s.h(captureModel, "captureModel");
        Log.d("OnRenderImageEnd", "android side called");
        J1 = this.this$0.J1();
        if (J1 == null) {
            return;
        }
        kotlinx.coroutines.l.d(J1, z0.c(), null, new AnonymousClass1(this.this$0, this.$viewModel, null), 2, null);
    }
}
