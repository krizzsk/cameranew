package us.pinguo.camera2020.fragment;

import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.AfterCaptureMode;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.view.AfterCaptureBottomController;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.processor.PreviewProcessState;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$goToAfterCapture$2", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$goToAfterCapture$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ AfterCaptureMode $mode;
    final /* synthetic */ CameraSwitchMode $switchMode;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$goToAfterCapture$2(ViewFinderFragment viewFinderFragment, AfterCaptureMode afterCaptureMode, CameraSwitchMode cameraSwitchMode, Continuation<? super ViewFinderFragment$goToAfterCapture$2> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
        this.$mode = afterCaptureMode;
        this.$switchMode = cameraSwitchMode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$goToAfterCapture$2(this.this$0, this.$mode, this.$switchMode, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$goToAfterCapture$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FilterController filterController;
        ViewGroup O1;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            CameraViewModel cameraViewModel = this.this$0.f9174j;
            if (cameraViewModel != null) {
                FilterEntry value = cameraViewModel.getCameraFilterModule().y().getValue();
                if (value == null) {
                    value = FilterConstants.f();
                }
                kotlin.jvm.internal.s.g(value, "cameraViewModel.cameraFi…nstants.FILTER_ENTRY_NONE");
                if (this.$mode == AfterCaptureMode.PHOTO) {
                    us.pinguo.processor.i.a.j(PreviewProcessState.START);
                    AfterCaptureBottomController afterCaptureBottomController = this.this$0.q;
                    if (afterCaptureBottomController != null) {
                        afterCaptureBottomController.d0(false);
                        CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                        if (cameraViewModel2 != null) {
                            us.pinguo.processor.d k2 = cameraViewModel2.getCameraFilterModule().k(true);
                            if (kotlin.jvm.internal.s.c(k2 == null ? null : k2.c(), "Effect=NONE_PREVIEW")) {
                                O1 = this.this$0.O1();
                                ProgressBar progressBar = O1 == null ? null : (ProgressBar) O1.findViewById(R.id.after_process_bar);
                                if (progressBar != null) {
                                    progressBar.setVisibility(0);
                                    VdsAgent.onSetViewVisibility(progressBar, 0);
                                }
                                TextView textView = O1 == null ? null : (TextView) O1.findViewById(R.id.after_process_tips);
                                if (textView != null) {
                                    textView.setVisibility(4);
                                    VdsAgent.onSetViewVisibility(textView, 4);
                                }
                                if (O1 != null) {
                                    O1.setVisibility(0);
                                    VdsAgent.onSetViewVisibility(O1, 0);
                                }
                            }
                            CameraViewModel cameraViewModel3 = this.this$0.f9174j;
                            if (cameraViewModel3 == null) {
                                kotlin.jvm.internal.s.z("cameraViewModel");
                                throw null;
                            } else if (cameraViewModel3.getCurrentExclusiveType() != ExclusiveEffectType.EFFECT_STYLED_MAKEUP) {
                                CameraViewModel cameraViewModel4 = this.this$0.f9174j;
                                if (cameraViewModel4 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else if (cameraViewModel4.getCurrentExclusiveType() != ExclusiveEffectType.EFFECT_STICKER && (filterController = this.this$0.u) != null) {
                                    FilterController.B0(filterController, value, false, 2, null);
                                }
                            }
                        } else {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.s.z("afterCaptureController");
                        throw null;
                    }
                } else if (this.$switchMode == CameraSwitchMode.MOVIE) {
                    AfterCaptureBottomController afterCaptureBottomController2 = this.this$0.q;
                    if (afterCaptureBottomController2 == null) {
                        kotlin.jvm.internal.s.z("afterCaptureController");
                        throw null;
                    }
                    afterCaptureBottomController2.d0(true);
                }
                return kotlin.u.a;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
