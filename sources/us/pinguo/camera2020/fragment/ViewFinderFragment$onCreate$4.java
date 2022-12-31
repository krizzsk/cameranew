package us.pinguo.camera2020.fragment;

import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.model.Scene;
import us.pinguo.camera2020.module.SaveReason;
import us.pinguo.camera2020.view.AfterCaptureBottomController;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onCreate$4 extends Lambda implements kotlin.jvm.b.q<String, Integer, Scene, kotlin.u> {
    final /* synthetic */ CameraViewModel $viewModel;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$4$1", f = "ViewFinderFragment.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$onCreate$4$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        final /* synthetic */ CameraViewModel $viewModel;
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CameraViewModel cameraViewModel, FilterEntry filterEntry, ViewFinderFragment viewFinderFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewModel = cameraViewModel;
            this.$entry = filterEntry;
            this.this$0 = viewFinderFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$viewModel, this.$entry, this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                if (this.$viewModel.getAfterCaptureModule().l() != null) {
                    CameraFilterModule cameraFilterModule = this.$viewModel.getCameraFilterModule();
                    FilterEntry filterEntry = this.$entry;
                    this.label = 1;
                    obj = cameraFilterModule.W(filterEntry, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return kotlin.u.a;
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            if (kotlin.jvm.internal.s.c(obj, Boxing.boxBoolean(true))) {
                AfterCaptureBottomController afterCaptureBottomController = this.this$0.q;
                if (afterCaptureBottomController == null) {
                    kotlin.jvm.internal.s.z("afterCaptureController");
                    throw null;
                } else if (afterCaptureBottomController.H()) {
                    this.this$0.s2(this.$entry);
                }
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onCreate$4(CameraViewModel cameraViewModel, ViewFinderFragment viewFinderFragment) {
        super(3);
        this.$viewModel = cameraViewModel;
        this.this$0 = viewFinderFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m69invoke$lambda0(ViewFinderFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(R.id.viewFinderContainer);
        frameLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(frameLayout, 4);
    }

    @Override // kotlin.jvm.b.q
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Integer num, Scene scene) {
        invoke(str, num.intValue(), scene);
        return kotlin.u.a;
    }

    public final void invoke(String path, int i2, Scene scene) {
        LifecycleCoroutineScope J1;
        kotlin.jvm.internal.s.h(path, "path");
        kotlin.jvm.internal.s.h(scene, "scene");
        us.pinguo.foundation.c.e("OnCaptureImageSaved");
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("photoRotation=", Integer.valueOf(i2)), new Object[0]);
        if (us.pinguo.camera2020.i.a.a.f() && scene == Scene.AUTO_SAVE) {
            this.$viewModel.getAfterCaptureModule().A(false);
        }
        this.$viewModel.getAfterCaptureModule().t(path, i2, scene);
        CameraViewModel cameraViewModel = this.this$0.f9174j;
        if (cameraViewModel != null) {
            if (cameraViewModel.getAfterCaptureModule().h() != SaveReason.USER) {
                CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                if (cameraViewModel2 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (cameraViewModel2.getAfterCaptureModule().h() != SaveReason.SKY_CHANGE) {
                    this.$viewModel.getAfterCaptureModule().r().postValue(Boolean.FALSE);
                }
            }
            if (scene == Scene.HD_IMAGE) {
                CameraViewModel cameraViewModel3 = this.this$0.f9174j;
                if (cameraViewModel3 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (cameraViewModel3.getAfterCaptureModule().h() == SaveReason.SKY_CHANGE) {
                    CameraViewModel cameraViewModel4 = this.this$0.f9174j;
                    if (cameraViewModel4 != null) {
                        FilterEntry value = cameraViewModel4.getCameraFilterModule().y().getValue();
                        J1 = this.this$0.J1();
                        if (J1 == null) {
                            return;
                        }
                        kotlinx.coroutines.l.d(J1, z0.b(), null, new AnonymousClass1(this.$viewModel, value, this.this$0, null), 2, null);
                        return;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            if (scene == Scene.SCREEN_IMAGE) {
                if (this.this$0.E == 90 || this.this$0.E == 270) {
                    final ViewFinderFragment viewFinderFragment = this.this$0;
                    us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.f0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewFinderFragment$onCreate$4.m69invoke$lambda0(ViewFinderFragment.this);
                        }
                    });
                }
                AfterCaptureBottomController afterCaptureBottomController = this.this$0.q;
                if (afterCaptureBottomController != null) {
                    afterCaptureBottomController.d0(true);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("afterCaptureController");
                    throw null;
                }
            }
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }
}
