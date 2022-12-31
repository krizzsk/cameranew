package us.pinguo.camera2020.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tapjoy.TapjoyConstants;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.utils.d.e;
import us.pinguo.camera2020.view.VideoPreviewController;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.widget.ShutterButton;
import us.pinguo.svideo.bean.VideoInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$goToAfterCapture$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ VideoInfo a;
        final /* synthetic */ ViewFinderFragment b;

        a(VideoInfo videoInfo, ViewFinderFragment viewFinderFragment) {
            this.a = videoInfo;
            this.b = viewFinderFragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPreviewController videoPreviewController;
            boolean z;
            VideoInfo videoInfo = this.a;
            String videoPath = videoInfo == null ? null : videoInfo.getVideoPath();
            if (videoPath != null) {
                CameraViewModel cameraViewModel = this.b.f9174j;
                if (cameraViewModel != null) {
                    cameraViewModel.getCameraFilterModule().c();
                    e.a aVar = us.pinguo.camera2020.utils.d.e.f9258f;
                    Context a = us.pinguo.util.v.a();
                    kotlin.jvm.internal.s.g(a, "getAppContext()");
                    aVar.a(a, videoPath, this.a);
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            videoPreviewController = this.b.o;
            if (videoPreviewController != null) {
                videoPreviewController.b();
                ViewFinderFragment.A1(this.b, false, false, 3, null);
                z = this.b.Q;
                if (z) {
                    Intent intent = new Intent();
                    intent.putExtra("video_uri", videoPath);
                    intent.putExtra(TapjoyConstants.TJC_VIDEO_URL, videoPath);
                    us.pinguo.camera2020.activity.y.b().e(-1, intent);
                    FragmentActivity activity = this.b.getActivity();
                    if (activity == null) {
                        return;
                    }
                    activity.finish();
                    return;
                }
                return;
            }
            kotlin.jvm.internal.s.z("videoPreviewController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$goToAfterCapture$1(ViewFinderFragment viewFinderFragment) {
        super(0);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VideoPreviewController videoPreviewController;
        videoPreviewController = this.this$0.o;
        if (videoPreviewController != null) {
            VideoInfo a2 = videoPreviewController.a();
            us.pinguo.foundation.statistics.h.b.G(String.valueOf((a2 == null ? 0L : a2.getDuration()) / 1000));
            ((ShutterButton) this.this$0._$_findCachedViewById(R.id.bottomMenuLayout).findViewById(R.id.imgShutterOrSave)).w(new a(a2, this.this$0));
            return;
        }
        kotlin.jvm.internal.s.z("videoPreviewController");
        throw null;
    }
}
