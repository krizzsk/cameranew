package us.pinguo.inspire_proxy.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;
import us.pinguo.inspire_proxy.media.g;
/* loaded from: classes4.dex */
public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static final int[] M = {0, 1, 2, 4, 5};
    private boolean A;
    IMediaPlayer.OnVideoSizeChangedListener B;
    IMediaPlayer.OnPreparedListener C;
    private IMediaPlayer.OnCompletionListener D;
    private IMediaPlayer.OnInfoListener E;
    private IMediaPlayer.OnErrorListener F;
    private IMediaPlayer.OnBufferingUpdateListener G;
    g.a H;
    private int I;
    private List<Integer> J;
    private int K;
    private int L;
    private String a;
    private Uri b;
    private Map<String, String> c;

    /* renamed from: d  reason: collision with root package name */
    private int f11490d;

    /* renamed from: e  reason: collision with root package name */
    private int f11491e;

    /* renamed from: f  reason: collision with root package name */
    private g.b f11492f;

    /* renamed from: g  reason: collision with root package name */
    private IMediaPlayer f11493g;

    /* renamed from: h  reason: collision with root package name */
    private int f11494h;

    /* renamed from: i  reason: collision with root package name */
    private int f11495i;

    /* renamed from: j  reason: collision with root package name */
    private int f11496j;

    /* renamed from: k  reason: collision with root package name */
    private int f11497k;

    /* renamed from: l  reason: collision with root package name */
    private int f11498l;
    private us.pinguo.inspire_proxy.media.f m;
    private IMediaPlayer.OnCompletionListener n;
    private IMediaPlayer.OnPreparedListener o;
    private int p;
    private IMediaPlayer.OnErrorListener q;
    private IMediaPlayer.OnInfoListener r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Context w;
    private us.pinguo.inspire_proxy.media.g x;
    private int y;
    private int z;

    /* loaded from: classes4.dex */
    class a implements IMediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
            IjkVideoView.this.f11494h = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.f11495i = iMediaPlayer.getVideoHeight();
            IjkVideoView.this.y = iMediaPlayer.getVideoSarNum();
            IjkVideoView.this.z = iMediaPlayer.getVideoSarDen();
            if (IjkVideoView.this.f11494h == 0 || IjkVideoView.this.f11495i == 0) {
                return;
            }
            if (IjkVideoView.this.x != null) {
                IjkVideoView.this.x.setVideoSize(IjkVideoView.this.f11494h, IjkVideoView.this.f11495i);
                IjkVideoView.this.x.setVideoSampleAspectRatio(IjkVideoView.this.y, IjkVideoView.this.z);
            }
            IjkVideoView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    class b implements IMediaPlayer.OnPreparedListener {
        b() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f11490d = 2;
            if (IjkVideoView.this.o != null) {
                IjkVideoView.this.o.onPrepared(IjkVideoView.this.f11493g);
            }
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.setEnabled(true);
            }
            IjkVideoView.this.f11494h = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.f11495i = iMediaPlayer.getVideoHeight();
            int i2 = IjkVideoView.this.s;
            if (i2 != 0) {
                IjkVideoView.this.seekTo(i2);
            }
            if (IjkVideoView.this.f11494h == 0 || IjkVideoView.this.f11495i == 0) {
                if (IjkVideoView.this.f11491e == 3) {
                    IjkVideoView.this.start();
                }
            } else if (IjkVideoView.this.x != null) {
                IjkVideoView.this.x.setVideoSize(IjkVideoView.this.f11494h, IjkVideoView.this.f11495i);
                IjkVideoView.this.x.setVideoSampleAspectRatio(IjkVideoView.this.y, IjkVideoView.this.z);
                if (!IjkVideoView.this.x.b() || (IjkVideoView.this.f11496j == IjkVideoView.this.f11494h && IjkVideoView.this.f11497k == IjkVideoView.this.f11495i)) {
                    if (IjkVideoView.this.f11491e == 3) {
                        IjkVideoView.this.start();
                        if (IjkVideoView.this.m != null) {
                            IjkVideoView.this.m.show();
                        }
                    } else if (IjkVideoView.this.isPlaying()) {
                    } else {
                        if ((i2 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.m != null) {
                            IjkVideoView.this.m.c(0);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements IMediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.f11490d = 5;
            IjkVideoView.this.f11491e = 5;
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.a();
            }
            if (IjkVideoView.this.n != null) {
                IjkVideoView.this.n.onCompletion(IjkVideoView.this.f11493g);
            }
        }
    }

    /* loaded from: classes4.dex */
    class d implements IMediaPlayer.OnInfoListener {
        d() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
            if (IjkVideoView.this.r != null) {
                IjkVideoView.this.r.onInfo(iMediaPlayer, i2, i3);
            }
            if (i2 == 3) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_VIDEO_RENDERING_START:");
                return true;
            } else if (i2 == 901) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                return true;
            } else if (i2 == 902) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                return true;
            } else if (i2 == 10001) {
                IjkVideoView.this.f11498l = i3;
                String str = IjkVideoView.this.a;
                Log.d(str, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i3);
                if (IjkVideoView.this.x != null) {
                    IjkVideoView.this.x.setVideoRotation(i3);
                    return true;
                }
                return true;
            } else if (i2 != 10002) {
                switch (i2) {
                    case 700:
                        Log.d(IjkVideoView.this.a, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        return true;
                    case 701:
                        Log.d(IjkVideoView.this.a, "MEDIA_INFO_BUFFERING_START:");
                        return true;
                    case 702:
                        Log.d(IjkVideoView.this.a, "MEDIA_INFO_BUFFERING_END:");
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                        String str2 = IjkVideoView.this.a;
                        Log.d(str2, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i3);
                        return true;
                    default:
                        switch (i2) {
                            case 800:
                                Log.d(IjkVideoView.this.a, "MEDIA_INFO_BAD_INTERLEAVING:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                Log.d(IjkVideoView.this.a, "MEDIA_INFO_NOT_SEEKABLE:");
                                return true;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                Log.d(IjkVideoView.this.a, "MEDIA_INFO_METADATA_UPDATE:");
                                return true;
                            default:
                                return true;
                        }
                }
            } else {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        }
    }

    /* loaded from: classes4.dex */
    class e implements IMediaPlayer.OnErrorListener {
        e() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
            String str = IjkVideoView.this.a;
            Log.d(str, "Error: " + i2 + "," + i3);
            IjkVideoView.this.f11490d = -1;
            IjkVideoView.this.f11491e = -1;
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.a();
            }
            if (IjkVideoView.this.q == null || IjkVideoView.this.q.onError(IjkVideoView.this.f11493g, i2, i3)) {
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    class f implements IMediaPlayer.OnBufferingUpdateListener {
        f() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
            IjkVideoView.this.p = i2;
        }
    }

    /* loaded from: classes4.dex */
    class g implements g.a {
        g() {
        }

        @Override // us.pinguo.inspire_proxy.media.g.a
        public void a(@NonNull g.b bVar) {
            if (bVar.a() != IjkVideoView.this.x) {
                Log.e(IjkVideoView.this.a, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            IjkVideoView.this.f11492f = null;
            IjkVideoView.this.M();
        }

        @Override // us.pinguo.inspire_proxy.media.g.a
        public void b(@NonNull g.b bVar, int i2, int i3) {
            if (bVar.a() != IjkVideoView.this.x) {
                Log.e(IjkVideoView.this.a, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            IjkVideoView.this.f11492f = bVar;
            if (IjkVideoView.this.f11493g != null) {
                us.pinguo.common.log.a.m("hwLog", "onSurfaceCreated bindSurfaceHolder", new Object[0]);
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.E(ijkVideoView.f11493g, bVar);
                return;
            }
            us.pinguo.common.log.a.m("hwLog", "onSurfaceCreated openVideo", new Object[0]);
            IjkVideoView.this.K();
        }

        @Override // us.pinguo.inspire_proxy.media.g.a
        public void c(@NonNull g.b bVar, int i2, int i3, int i4) {
            if (bVar.a() != IjkVideoView.this.x) {
                Log.e(IjkVideoView.this.a, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            us.pinguo.common.log.a.m("hwLog", "onSurfaceChanged", new Object[0]);
            IjkVideoView.this.f11496j = i3;
            IjkVideoView.this.f11497k = i4;
            boolean z = true;
            boolean z2 = IjkVideoView.this.f11491e == 3;
            if (IjkVideoView.this.x.b() && (IjkVideoView.this.f11494h != i3 || IjkVideoView.this.f11495i != i4)) {
                z = false;
            }
            if (IjkVideoView.this.f11493g != null && z2 && z) {
                if (IjkVideoView.this.s != 0) {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.seekTo(ijkVideoView.s);
                }
                us.pinguo.common.log.a.m("hwLog", "onSurfaceChanged,start", new Object[0]);
                IjkVideoView.this.start();
            }
        }
    }

    public IjkVideoView(Context context) {
        super(context);
        this.a = "IjkVideoView";
        this.f11490d = 0;
        this.f11491e = 0;
        this.f11492f = null;
        this.f11493g = null;
        this.t = true;
        this.u = true;
        this.v = true;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.F = new e();
        this.G = new f();
        this.H = new g();
        this.I = M[0];
        this.J = new ArrayList();
        this.K = 0;
        this.L = 0;
        I(context);
    }

    private void D() {
        us.pinguo.inspire_proxy.media.f fVar;
        if (this.f11493g == null || (fVar = this.m) == null) {
            return;
        }
        fVar.d(this);
        this.m.b(getParent() instanceof View ? (View) getParent() : this);
        this.m.setEnabled(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(IMediaPlayer iMediaPlayer, g.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    private void G() {
    }

    private void H() {
        this.J.clear();
        this.J.add(2);
        if (this.J.isEmpty()) {
            this.J.add(1);
        }
        int intValue = this.J.get(this.K).intValue();
        this.L = intValue;
        setRender(intValue);
    }

    private void I(Context context) {
        this.w = context.getApplicationContext();
        G();
        H();
        this.f11494h = 0;
        this.f11495i = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f11490d = 0;
        this.f11491e = 0;
    }

    private boolean J() {
        int i2;
        return (this.f11493g == null || (i2 = this.f11490d) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void K() {
        if (this.b == null || this.f11492f == null) {
            return;
        }
        L(false);
        ((AudioManager) this.w.getSystemService("audio")).requestAudioFocus(null, 3, 1);
        try {
            try {
                this.f11493g = F();
                getContext();
                this.f11493g.setOnPreparedListener(this.C);
                this.f11493g.setOnVideoSizeChangedListener(this.B);
                this.f11493g.setOnCompletionListener(this.D);
                this.f11493g.setOnErrorListener(this.F);
                this.f11493g.setOnInfoListener(this.E);
                this.f11493g.setOnBufferingUpdateListener(this.G);
                this.p = 0;
                if (Build.VERSION.SDK_INT > 14) {
                    this.f11493g.setDataSource(this.w, this.b, this.c);
                } else {
                    this.f11493g.setDataSource(this.b.toString());
                }
                E(this.f11493g, this.f11492f);
                this.f11493g.setAudioStreamType(3);
                this.f11493g.setScreenOnWhilePlaying(true);
                this.f11493g.setLooping(this.A);
                this.f11493g.prepareAsync();
                this.f11490d = 1;
                D();
            } catch (IOException e2) {
                String str = this.a;
                Log.w(str, "Unable to open content: " + this.b, e2);
                this.f11490d = -1;
                this.f11491e = -1;
                this.F.onError(this.f11493g, 1, 0);
            }
        } catch (IllegalArgumentException e3) {
            String str2 = this.a;
            Log.w(str2, "Unable to open content: " + this.b, e3);
            this.f11490d = -1;
            this.f11491e = -1;
            this.F.onError(this.f11493g, 1, 0);
        }
    }

    private void N(Uri uri, Map<String, String> map) {
        this.b = uri;
        this.c = map;
        this.s = 0;
        K();
        requestLayout();
        invalidate();
    }

    private void P() {
        if (this.m.isShowing()) {
            this.m.a();
        } else {
            this.m.show();
        }
    }

    public IMediaPlayer F() {
        IjkMediaPlayer ijkMediaPlayer;
        if (this.b != null) {
            ijkMediaPlayer = new IjkMediaPlayer();
            IjkMediaPlayer.native_setLogLevel(3);
            ijkMediaPlayer.setOption(4, "mediacodec", 0L);
            ijkMediaPlayer.setOption(4, "opensles", 1L);
            ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
        } else {
            ijkMediaPlayer = null;
        }
        return new TextureMediaPlayer(ijkMediaPlayer);
    }

    public void L(boolean z) {
        IMediaPlayer iMediaPlayer = this.f11493g;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.f11493g.release();
            this.f11493g = null;
            this.f11490d = 0;
            if (z) {
                this.f11491e = 0;
            }
            ((AudioManager) this.w.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void M() {
        IMediaPlayer iMediaPlayer = this.f11493g;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void O() {
        IMediaPlayer iMediaPlayer = this.f11493g;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.f11493g.release();
            this.f11493g = null;
            this.f11490d = 0;
            this.f11491e = 0;
            ((AudioManager) this.w.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.t;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.u;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f11493g != null) {
            return this.p;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (J()) {
            return (int) this.f11493g.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (J()) {
            return (int) this.f11493g.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return J() && this.f11493g.isPlaying();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (J() && z && this.m != null) {
            if (i2 == 79 || i2 == 85) {
                if (this.f11493g.isPlaying()) {
                    pause();
                    this.m.show();
                } else {
                    start();
                    this.m.a();
                }
                return true;
            } else if (i2 == 126) {
                if (!this.f11493g.isPlaying()) {
                    start();
                    this.m.a();
                }
                return true;
            } else if (i2 != 86 && i2 != 127) {
                P();
            } else {
                if (this.f11493g.isPlaying()) {
                    pause();
                    this.m.show();
                }
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!J() || this.m == null) {
            return false;
        }
        P();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!J() || this.m == null) {
            return false;
        }
        P();
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (J() && this.f11493g.isPlaying()) {
            this.f11493g.pause();
            this.f11490d = 4;
        }
        this.f11491e = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        if (J()) {
            this.f11493g.seekTo(i2);
            this.s = 0;
            return;
        }
        this.s = i2;
    }

    public void setLooping(boolean z) {
        this.A = z;
    }

    public void setMediaController(us.pinguo.inspire_proxy.media.f fVar) {
        us.pinguo.inspire_proxy.media.f fVar2 = this.m;
        if (fVar2 != null) {
            fVar2.a();
        }
        this.m = fVar;
        D();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.n = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.q = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.r = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.o = onPreparedListener;
    }

    public void setRender(int i2) {
        if (i2 == 0) {
            setRenderView(null);
        } else if (i2 == 1) {
            setRenderView(new SurfaceRenderView(getContext()));
        } else if (i2 != 2) {
        } else {
            TextureRenderView textureRenderView = new TextureRenderView(getContext());
            if (this.f11493g != null) {
                textureRenderView.e().b(this.f11493g);
                textureRenderView.setVideoSize(this.f11493g.getVideoWidth(), this.f11493g.getVideoHeight());
                textureRenderView.setVideoSampleAspectRatio(this.f11493g.getVideoSarNum(), this.f11493g.getVideoSarDen());
                textureRenderView.setAspectRatio(this.I);
            }
            setRenderView(textureRenderView);
        }
    }

    public void setRenderView(us.pinguo.inspire_proxy.media.g gVar) {
        int i2;
        int i3;
        if (this.x != null) {
            IMediaPlayer iMediaPlayer = this.f11493g;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.x.getView();
            this.x.a(this.H);
            this.x = null;
            removeView(view);
        }
        if (gVar == null) {
            return;
        }
        this.x = gVar;
        gVar.setAspectRatio(this.I);
        int i4 = this.f11494h;
        if (i4 > 0 && (i3 = this.f11495i) > 0) {
            gVar.setVideoSize(i4, i3);
        }
        int i5 = this.y;
        if (i5 > 0 && (i2 = this.z) > 0) {
            gVar.setVideoSampleAspectRatio(i5, i2);
        }
        View view2 = this.x.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.x.c(this.H);
        this.x.setVideoRotation(this.f11498l);
    }

    public void setSilent(boolean z) {
        IMediaPlayer iMediaPlayer = this.f11493g;
        if (iMediaPlayer != null) {
            if (z) {
                iMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                iMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        N(uri, null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.f11490d == 3) {
            return;
        }
        if (J()) {
            us.pinguo.common.log.a.m("hwLog", "mMediaPlayer.start()", new Object[0]);
            this.f11493g.start();
            this.f11490d = 3;
        }
        us.pinguo.common.log.a.m("hwLog", "mTargetState = STATE_PLAYING", new Object[0]);
        this.f11491e = 3;
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "IjkVideoView";
        this.f11490d = 0;
        this.f11491e = 0;
        this.f11492f = null;
        this.f11493g = null;
        this.t = true;
        this.u = true;
        this.v = true;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.F = new e();
        this.G = new f();
        this.H = new g();
        this.I = M[0];
        this.J = new ArrayList();
        this.K = 0;
        this.L = 0;
        I(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "IjkVideoView";
        this.f11490d = 0;
        this.f11491e = 0;
        this.f11492f = null;
        this.f11493g = null;
        this.t = true;
        this.u = true;
        this.v = true;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        this.F = new e();
        this.G = new f();
        this.H = new g();
        this.I = M[0];
        this.J = new ArrayList();
        this.K = 0;
        this.L = 0;
        I(context);
    }
}
