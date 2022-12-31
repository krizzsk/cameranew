package us.pinguo.camera2020.view;

import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.io.File;
import java.util.Objects;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.svideo.bean.VideoInfo;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.VideoPlayer;
import us.pinguo.ui.widget.video.c;
/* compiled from: VideoPreviewController.kt */
/* loaded from: classes3.dex */
public final class VideoPreviewController implements LifecycleObserver, us.pinguo.svideo.c.d {
    private final ViewGroup a;
    private final ProgressWheel b;
    private BaseVideoTextureView c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.ui.widget.video.c f9323d;

    /* renamed from: e  reason: collision with root package name */
    private final us.pinguo.svideo.manager.a f9324e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f9325f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9326g;

    /* renamed from: h  reason: collision with root package name */
    private VideoInfo f9327h;

    /* renamed from: i  reason: collision with root package name */
    private VideoMusic f9328i;

    public VideoPreviewController(ViewGroup viewGroup) {
        kotlin.jvm.internal.s.h(viewGroup, "viewGroup");
        this.a = viewGroup;
        this.b = (ProgressWheel) viewGroup.findViewById(R.id.videoLoadingProgress);
        us.pinguo.svideo.manager.a b = us.pinguo.svideo.manager.a.b();
        kotlin.jvm.internal.s.g(b, "newInstance()");
        this.f9324e = b;
        this.f9325f = new Handler();
        this.f9326g = true;
        b.a();
    }

    private final void c(String str) {
        VideoInfo videoInfo = this.f9327h;
        if (videoInfo != null) {
            videoInfo.setVideoPath(str);
        }
        Uri fromFile = Uri.fromFile(new File(str));
        final VideoPlayer videoPlayer = new VideoPlayer(us.pinguo.util.v.a());
        videoPlayer.c0(new c.InterfaceC0457c() { // from class: us.pinguo.camera2020.view.g2
            @Override // us.pinguo.ui.widget.video.c.InterfaceC0457c
            public final void onPrepared() {
                VideoPreviewController.d(VideoPreviewController.this, videoPlayer);
            }
        });
        BaseVideoTextureView baseVideoTextureView = new BaseVideoTextureView(this.a.getContext());
        baseVideoTextureView.setId(R.id.preview_video_view);
        this.a.addView(baseVideoTextureView, 0, new FrameLayout.LayoutParams(-1, -1));
        baseVideoTextureView.setOnClickListener(f2.a);
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
        videoPlayer.U(false);
        videoPlayer.Q(fromFile);
        videoPlayer.c(baseVideoTextureView);
        videoPlayer.V(true);
        this.c = baseVideoTextureView;
        this.f9323d = videoPlayer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void create() {
        if (g() && this.f9327h == null) {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final VideoPreviewController this$0, final VideoPlayer videoPlayer) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(videoPlayer, "$videoPlayer");
        this$0.f9325f.post(new Runnable() { // from class: us.pinguo.camera2020.view.h2
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreviewController.e(VideoPreviewController.this, videoPlayer);
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void destroy() {
        this.f9324e.d();
        this.f9324e.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(VideoPreviewController this$0, VideoPlayer videoPlayer) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(videoPlayer, "$videoPlayer");
        ProgressWheel progressWheel = this$0.b;
        progressWheel.setVisibility(4);
        VdsAgent.onSetViewVisibility(progressWheel, 4);
        if (this$0.f9326g) {
            videoPlayer.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void p() {
        final VideoInfo videoInfo;
        us.pinguo.ui.widget.video.c cVar = this.f9323d;
        if ((cVar != null && cVar.isPlaying()) || (videoInfo = this.f9327h) == null) {
            return;
        }
        final VideoMusic videoMusic = this.f9328i;
        if (videoMusic == null) {
            String videoPath = videoInfo.getVideoPath();
            kotlin.jvm.internal.s.g(videoPath, "videoInfo.videoPath");
            c(videoPath);
            return;
        }
        ProgressWheel progressWheel = this.b;
        progressWheel.setVisibility(0);
        VdsAgent.onSetViewVisibility(progressWheel, 0);
        new Thread(new Runnable() { // from class: us.pinguo.camera2020.view.d2
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreviewController.q(VideoInfo.this, videoMusic, this);
            }
        }).start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void pause() {
        us.pinguo.ui.widget.video.c cVar = this.f9323d;
        if (cVar != null && cVar.isPlaying()) {
            cVar.a();
        }
        this.f9326g = false;
        this.f9324e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final VideoInfo videoInfo, VideoMusic videoMusic, final VideoPreviewController this$0) {
        kotlin.jvm.internal.s.h(videoInfo, "$videoInfo");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        String generate = new IVideoPathGeneratorImpl().generate();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.hw.videoprocessor.g.b.m(videoInfo.getVideoPath(), videoMusic.c(), generate, true);
            long currentTimeMillis2 = System.currentTimeMillis();
            us.pinguo.common.log.a.s("合成背景音乐耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
            new File(videoInfo.getVideoPath()).delete();
            videoInfo.setVideoPath(generate);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.view.e2
            @Override // java.lang.Runnable
            public final void run() {
                VideoPreviewController.r(VideoPreviewController.this, videoInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(VideoPreviewController this$0, VideoInfo videoInfo) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(videoInfo, "$videoInfo");
        ProgressWheel progressWheel = this$0.b;
        progressWheel.setVisibility(4);
        VdsAgent.onSetViewVisibility(progressWheel, 4);
        String videoPath = videoInfo.getVideoPath();
        kotlin.jvm.internal.s.g(videoPath, "videoInfo.videoPath");
        this$0.c(videoPath);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void resume() {
        us.pinguo.ui.widget.video.c cVar;
        this.f9326g = true;
        if (!g() || (cVar = this.f9323d) == null || cVar.isPlaying()) {
            return;
        }
        cVar.f();
        View findViewById = this.a.findViewById(R.id.preview_video_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type us.pinguo.ui.widget.video.BaseVideoTextureView");
        cVar.c((BaseVideoTextureView) findViewById);
        cVar.d();
    }

    public final VideoInfo a() {
        return this.f9327h;
    }

    public final void b() {
        us.pinguo.ui.widget.video.c cVar = this.f9323d;
        if (cVar != null) {
            cVar.f();
            if (cVar.isPlaying()) {
                cVar.a();
            }
            cVar.b();
        }
        this.f9324e.d();
        BaseVideoTextureView baseVideoTextureView = this.c;
        if (baseVideoTextureView != null) {
            this.a.removeView(baseVideoTextureView);
            this.c = null;
        }
        this.f9327h = null;
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
    }

    public final boolean g() {
        return this.a.getVisibility() == 0;
    }

    @Override // us.pinguo.svideo.c.d
    public String generate() {
        String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        return absolutePath + "/Camera/C360VID_" + System.currentTimeMillis() + ".mp4";
    }

    public final void m() {
        ProgressWheel progressWheel = this.b;
        progressWheel.setVisibility(0);
        VdsAgent.onSetViewVisibility(progressWheel, 0);
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
    }

    public final void n(VideoInfo videoInfo) {
        kotlin.jvm.internal.s.h(videoInfo, "videoInfo");
        us.pinguo.common.log.a.g("Frisky", "onRecordSuccess videoInfo:" + ((Object) videoInfo.getVideoPath()) + "   size:" + videoInfo.getVideoWidth() + 'x' + videoInfo.getVideoHeight() + "   BitRate:" + videoInfo.getVideoBitRate(), new Object[0]);
        this.f9327h = videoInfo;
        p();
    }

    public final void o(VideoMusic videoMusic) {
        this.f9328i = videoMusic;
    }
}
