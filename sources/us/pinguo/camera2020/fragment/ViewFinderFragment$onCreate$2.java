package us.pinguo.camera2020.fragment;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.model.Scene;
import us.pinguo.camera2020.view.AfterCaptureBottomController;
import us.pinguo.camera2020.view.m2;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.manager.FilterRepository;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onCreate$2 extends Lambda implements kotlin.jvm.b.l<Scene, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onCreate$2(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m64invoke$lambda1(ViewFinderFragment this$0) {
        ViewGroup O1;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        O1 = this$0.O1();
        if (O1 == null) {
            return;
        }
        O1.setVisibility(8);
        VdsAgent.onSetViewVisibility(O1, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final void m65invoke$lambda3(final ViewFinderFragment this$0, final CountDownLatch lock) {
        Handler handler;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(lock, "$lock");
        if (this$0.E == 90 || this$0.E == 270) {
            FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(R.id.viewFinderContainer);
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
            this$0.G = true;
        }
        handler = this$0.C;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.camera2020.fragment.c0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewFinderFragment$onCreate$2.m66invoke$lambda3$lambda2(lock, this$0);
                }
            });
        } else {
            kotlin.jvm.internal.s.z("mainHandler");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-2  reason: not valid java name */
    public static final void m66invoke$lambda3$lambda2(CountDownLatch lock, ViewFinderFragment this$0) {
        boolean z;
        m2 m2Var;
        ViewGroup O1;
        LifecycleCoroutineScope J1;
        kotlin.jvm.internal.s.h(lock, "$lock");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        lock.countDown();
        z = this$0.G;
        if (z) {
            this$0.K1();
        }
        m2Var = this$0.f9176l;
        if (m2Var != null) {
            m2Var.u(false);
            FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(R.id.viewFinderContainer);
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            AfterCaptureBottomController afterCaptureBottomController = this$0.q;
            if (afterCaptureBottomController != null) {
                afterCaptureBottomController.d0(true);
                AfterCaptureBottomController afterCaptureBottomController2 = this$0.q;
                if (afterCaptureBottomController2 != null) {
                    afterCaptureBottomController2.k0(true, 0);
                    O1 = this$0.O1();
                    if (O1 != null) {
                        O1.setVisibility(8);
                        VdsAgent.onSetViewVisibility(O1, 8);
                    }
                    this$0.j4();
                    J1 = this$0.J1();
                    if (J1 == null) {
                        return;
                    }
                    kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$onCreate$2$3$1$1(this$0, null), 2, null);
                    return;
                }
                kotlin.jvm.internal.s.z("afterCaptureController");
                throw null;
            }
            kotlin.jvm.internal.s.z("afterCaptureController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraTopBar");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final void m67invoke$lambda4(ViewFinderFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.E == 90 || this$0.E == 270) {
            this$0.K1();
            this$0.G = true;
        }
        AfterCaptureBottomController afterCaptureBottomController = this$0.q;
        if (afterCaptureBottomController != null) {
            afterCaptureBottomController.k0(false, 1);
            FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(R.id.viewFinderContainer);
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            return;
        }
        kotlin.jvm.internal.s.z("afterCaptureController");
        throw null;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Scene scene) {
        invoke2(scene);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Scene scene) {
        boolean z;
        kotlin.jvm.internal.s.h(scene, "scene");
        us.pinguo.foundation.c.e(kotlin.jvm.internal.s.q("OnCaptureRenderEnd:", scene));
        if (scene == Scene.AFTER_CAPTURE) {
            CameraViewModel cameraViewModel = this.this$0.f9174j;
            if (cameraViewModel != null) {
                FilterEntry value = cameraViewModel.getCameraFilterModule().y().getValue();
                if (value != null) {
                    ViewFinderFragment viewFinderFragment = this.this$0;
                    if (FilterRepository.a.u(value.getPkgId()) == 1) {
                        viewFinderFragment.W3(false, false, null);
                    }
                }
                z = this.this$0.Z;
                if (!z) {
                    this.this$0.d0 = false;
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final ViewFinderFragment viewFinderFragment2 = this.this$0;
                    us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.a0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewFinderFragment$onCreate$2.m65invoke$lambda3(ViewFinderFragment.this, countDownLatch);
                        }
                    });
                    countDownLatch.await();
                    return;
                }
                final ViewFinderFragment viewFinderFragment3 = this.this$0;
                us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewFinderFragment$onCreate$2.m64invoke$lambda1(ViewFinderFragment.this);
                    }
                });
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        } else if (scene == Scene.AFTER_SCREEN_IMAGE) {
            this.this$0.d0 = false;
            final ViewFinderFragment viewFinderFragment4 = this.this$0;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.d0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewFinderFragment$onCreate$2.m67invoke$lambda4(ViewFinderFragment.this);
                }
            });
        }
    }
}
