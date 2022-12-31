package us.pinguo.camera2020.fragment;

import android.os.Parcelable;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.activity.Camera2020Activity;
import us.pinguo.camera2020.module.AfterCaptureMode;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.camera2020.view.TimerCountDownController;
import us.pinguo.camera2020.view.VideoPreviewController;
import us.pinguo.camera2020.view.r2;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.svideo.bean.VideoInfo;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$onViewCreated$11 implements r2 {
    private Boolean a;
    final /* synthetic */ ViewFinderFragment b;
    final /* synthetic */ CameraViewModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewFinderFragment$onViewCreated$11(ViewFinderFragment viewFinderFragment, CameraViewModel cameraViewModel) {
        this.b = viewFinderFragment;
        this.c = cameraViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        us.pinguo.camera2020.utils.d.e eVar;
        this.c.startRecord(this.b.E >= 0 ? this.b.E : 0);
        eVar = this.b.A;
        if (eVar != null) {
            eVar.l();
            ViewFinderFragment viewFinderFragment = this.b;
            int i2 = R.id.touchScreenCapture;
            TextView touchScreenCapture = (TextView) viewFinderFragment._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(touchScreenCapture, "touchScreenCapture");
            Boolean valueOf = Boolean.valueOf(touchScreenCapture.getVisibility() == 0);
            this.a = valueOf;
            if (kotlin.jvm.internal.s.c(valueOf, Boolean.TRUE)) {
                TextView textView = (TextView) this.b._$_findCachedViewById(i2);
                textView.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView, 4);
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("videoRecordManager");
        throw null;
    }

    @Override // us.pinguo.camera2020.view.r2
    public void a() {
        us.pinguo.common.f fVar;
        VideoMusic videoMusic;
        VideoPreviewController videoPreviewController;
        us.pinguo.camera2020.utils.d.e eVar;
        if (kotlin.jvm.internal.s.c(this.a, Boolean.TRUE)) {
            TextView textView = (TextView) this.b._$_findCachedViewById(R.id.touchScreenCapture);
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
        }
        this.a = null;
        fVar = this.b.H;
        fVar.d(false);
        videoMusic = this.b.B;
        if (videoMusic != null) {
            this.b.U3();
        } else {
            this.b.M1(false);
        }
        videoPreviewController = this.b.o;
        if (videoPreviewController != null) {
            videoPreviewController.m();
            eVar = this.b.A;
            if (eVar != null) {
                eVar.n();
                FragmentActivity activity = this.b.getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.camera2020.activity.Camera2020Activity");
                ((Camera2020Activity) activity).t0();
                return;
            }
            kotlin.jvm.internal.s.z("videoRecordManager");
            throw null;
        }
        kotlin.jvm.internal.s.z("videoPreviewController");
        throw null;
    }

    @Override // us.pinguo.camera2020.view.r2
    public void b(VideoInfo videoInfo) {
        us.pinguo.common.f fVar;
        VideoMusic videoMusic;
        Parcelable parcelable;
        boolean z;
        VideoPreviewController videoPreviewController;
        String h2;
        kotlin.jvm.internal.s.h(videoInfo, "videoInfo");
        fVar = this.b.H;
        fVar.d(false);
        this.c.getAfterCaptureModule().I(videoInfo);
        us.pinguo.foundation.statistics.a u = us.pinguo.foundation.statistics.a.u();
        videoMusic = this.b.B;
        String str = "original";
        if (videoMusic != null && (h2 = videoMusic.h()) != null) {
            str = h2;
        }
        u.C(str);
        us.pinguo.foundation.statistics.a.u().D(String.valueOf(videoInfo.getDuration()));
        us.pinguo.foundation.statistics.a.u().onEvent();
        parcelable = this.b.R;
        z = this.b.Q;
        if (!z || parcelable == null) {
            this.b.Q1(AfterCaptureMode.VIDEO, CameraSwitchMode.MOVIE);
            videoPreviewController = this.b.o;
            if (videoPreviewController != null) {
                videoPreviewController.n(videoInfo);
                return;
            } else {
                kotlin.jvm.internal.s.z("videoPreviewController");
                throw null;
            }
        }
        this.b.c4();
        FragmentActivity activity = this.b.getActivity();
        if (activity == null) {
            return;
        }
        ViewFinderFragment viewFinderFragment = this.b;
        FragmentActivity requireActivity = viewFinderFragment.requireActivity();
        kotlin.jvm.internal.s.g(requireActivity, "requireActivity()");
        viewFinderFragment.e2(requireActivity, "Inspire", new ViewFinderFragment$onViewCreated$11$onRecordSuccess$1$1(activity, parcelable, viewFinderFragment, videoInfo));
    }

    @Override // us.pinguo.camera2020.view.r2
    public void c() {
        us.pinguo.common.f fVar;
        VideoMusic videoMusic;
        us.pinguo.foundation.i P1;
        us.pinguo.foundation.i P12;
        us.pinguo.foundation.i P13;
        fVar = this.b.H;
        fVar.d(true);
        videoMusic = this.b.B;
        if (videoMusic != null) {
            P1 = this.b.P1();
            P1.j();
            P12 = this.b.P1();
            P12.e(0);
            P13 = this.b.P1();
            P13.i();
            this.b.M1(false);
        } else {
            this.b.M1(true);
        }
        this.b.X1();
        CameraStickerModule cameraStickerModule = this.c.getCameraStickerModule();
        Sticker value = cameraStickerModule.u().getValue();
        if (value != null) {
            cameraStickerModule.h();
            cameraStickerModule.D(value.getPid());
        }
        this.c.recordUpToStatistics();
        FragmentActivity activity = this.b.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.camera2020.activity.Camera2020Activity");
        ((Camera2020Activity) activity).u0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0150, code lost:
        if (kotlin.jvm.internal.s.c(r10, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // us.pinguo.camera2020.view.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$onViewCreated$11.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // us.pinguo.camera2020.view.r2
    public boolean e() {
        TimerCountDownController timerCountDownController = this.b.r;
        if (timerCountDownController == null) {
            kotlin.jvm.internal.s.z("timerCountDownController");
            throw null;
        } else if (timerCountDownController.f()) {
            TimerCountDownController timerCountDownController2 = this.b.r;
            if (timerCountDownController2 != null) {
                TimerCountDownController.d(timerCountDownController2, null, 1, null);
                this.b.d4();
                return true;
            }
            kotlin.jvm.internal.s.z("timerCountDownController");
            throw null;
        } else {
            return false;
        }
    }

    @Override // us.pinguo.camera2020.view.r2
    public void f() {
        this.b.U1();
    }

    @Override // us.pinguo.camera2020.view.r2
    public void g() {
        us.pinguo.camera2020.utils.d.e eVar;
        eVar = this.b.A;
        if (eVar != null) {
            eVar.m();
            this.c.stopRecord();
            return;
        }
        kotlin.jvm.internal.s.z("videoRecordManager");
        throw null;
    }

    @Override // us.pinguo.camera2020.view.r2
    public void h() {
        this.b.c4();
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x013d, code lost:
        if (kotlin.jvm.internal.s.c(r10, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @Override // us.pinguo.camera2020.view.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$onViewCreated$11.i(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
