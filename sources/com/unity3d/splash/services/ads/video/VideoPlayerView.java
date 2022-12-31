package com.unity3d.splash.services.ads.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.widget.VideoView;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import com.unity3d.splash.services.core.webview.WebViewEventCategory;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class VideoPlayerView extends VideoView {
    private String a;
    private Timer b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPlayer f8449d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8450e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = VideoPlayerView.this.isPlaying();
                try {
                    WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PROGRESS, Integer.valueOf(VideoPlayerView.this.getCurrentPosition()));
                } catch (IllegalStateException e2) {
                    e = e2;
                    DeviceLog.g("Exception while sending current position to webapp", e);
                    WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, VideoPlayerEvent.PROGRESS, VideoPlayerView.this.a, Boolean.valueOf(z));
                }
            } catch (IllegalStateException e3) {
                e = e3;
                z = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements MediaPlayer.OnInfoListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.INFO, VideoPlayerView.this.a, Integer.valueOf(i2), Integer.valueOf(i3));
            return true;
        }
    }

    public VideoPlayerView(Context context) {
        super(context);
        this.c = 500;
        this.f8449d = null;
        this.f8450e = true;
    }

    private void b() {
        Timer timer = new Timer();
        this.b = timer;
        a aVar = new a();
        int i2 = this.c;
        timer.scheduleAtFixedRate(aVar, i2, i2);
    }

    public void c() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b.purge();
            this.b = null;
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        try {
            super.pause();
            c();
            WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE, this.a);
        } catch (Exception e2) {
            WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE_ERROR, this.a);
            DeviceLog.g("Error pausing video", e2);
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        try {
            super.seekTo(i2);
            WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO, this.a);
        } catch (Exception e2) {
            WebViewApp.e().k(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO_ERROR, this.a);
            DeviceLog.g("Error seeking video", e2);
        }
    }

    public void setInfoListenerEnabled(boolean z) {
        this.f8450e = z;
        if (Build.VERSION.SDK_INT > 16) {
            if (z) {
                setOnInfoListener(new b());
            } else {
                setOnInfoListener(null);
            }
        }
    }

    public void setProgressEventInterval(int i2) {
        this.c = i2;
        if (this.b != null) {
            c();
            b();
        }
    }

    public void setVolume(Float f2) {
        try {
            this.f8449d.setVolume(f2.floatValue(), f2.floatValue());
        } catch (Exception e2) {
            DeviceLog.g("MediaPlayer generic error", e2);
        }
    }
}
