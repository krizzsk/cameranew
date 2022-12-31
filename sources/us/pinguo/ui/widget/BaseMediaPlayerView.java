package us.pinguo.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes6.dex */
public class BaseMediaPlayerView extends TextureView implements TextureView.SurfaceTextureListener {
    MediaPlayer.OnPreparedListener A;
    private MediaPlayer.OnCompletionListener B;
    private MediaPlayer.OnInfoListener C;
    private MediaPlayer.OnErrorListener D;
    private MediaPlayer.OnBufferingUpdateListener E;
    private String a;
    private Uri b;
    private Map<String, String> c;

    /* renamed from: d  reason: collision with root package name */
    private int f12104d;

    /* renamed from: e  reason: collision with root package name */
    private int f12105e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f12106f;

    /* renamed from: g  reason: collision with root package name */
    private MediaPlayer f12107g;

    /* renamed from: h  reason: collision with root package name */
    private int f12108h;

    /* renamed from: i  reason: collision with root package name */
    private int f12109i;

    /* renamed from: j  reason: collision with root package name */
    private int f12110j;

    /* renamed from: k  reason: collision with root package name */
    private MediaPlayer.OnCompletionListener f12111k;

    /* renamed from: l  reason: collision with root package name */
    private MediaPlayer.OnPreparedListener f12112l;
    private int m;
    private MediaPlayer.OnErrorListener n;
    private MediaPlayer.OnInfoListener o;
    private us.pinguo.ui.widget.f p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private Context u;
    protected boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    MediaPlayer.OnVideoSizeChangedListener z;

    /* loaded from: classes6.dex */
    class a implements MediaPlayer.OnVideoSizeChangedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            BaseMediaPlayerView.this.f12109i = mediaPlayer.getVideoWidth();
            BaseMediaPlayerView.this.f12110j = mediaPlayer.getVideoHeight();
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            BaseMediaPlayerView baseMediaPlayerView = BaseMediaPlayerView.this;
            if (baseMediaPlayerView.v) {
                return;
            }
            String str = baseMediaPlayerView.a;
            us.pinguo.common.log.a.m(str, "Video size changed: " + i2 + "x" + i3, new Object[0]);
            BaseMediaPlayerView.this.q(i2, i3);
        }
    }

    /* loaded from: classes6.dex */
    class b implements MediaPlayer.OnPreparedListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            BaseMediaPlayerView.this.f12104d = 2;
            BaseMediaPlayerView baseMediaPlayerView = BaseMediaPlayerView.this;
            baseMediaPlayerView.t = true;
            baseMediaPlayerView.s = true;
            baseMediaPlayerView.r = true;
            if (BaseMediaPlayerView.this.f12112l != null) {
                BaseMediaPlayerView.this.f12112l.onPrepared(BaseMediaPlayerView.this.f12107g);
            }
            BaseMediaPlayerView.this.f12109i = mediaPlayer.getVideoWidth();
            BaseMediaPlayerView.this.f12110j = mediaPlayer.getVideoHeight();
            int i2 = BaseMediaPlayerView.this.q;
            if (i2 != 0) {
                BaseMediaPlayerView.this.A(i2);
            }
            if (BaseMediaPlayerView.this.f12105e == 3) {
                BaseMediaPlayerView.this.B();
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            BaseMediaPlayerView.this.f12104d = 5;
            BaseMediaPlayerView.this.f12105e = 5;
            if (BaseMediaPlayerView.this.f12111k != null) {
                BaseMediaPlayerView.this.f12111k.onCompletion(BaseMediaPlayerView.this.f12107g);
            }
        }
    }

    /* loaded from: classes6.dex */
    class d implements MediaPlayer.OnInfoListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (BaseMediaPlayerView.this.o != null) {
                BaseMediaPlayerView.this.o.onInfo(mediaPlayer, i2, i3);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class e implements MediaPlayer.OnErrorListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            String str = BaseMediaPlayerView.this.a;
            Log.d(str, "Error: " + i2 + "," + i3);
            BaseMediaPlayerView.this.f12104d = -1;
            BaseMediaPlayerView.this.f12105e = -1;
            if ((BaseMediaPlayerView.this.n == null || !BaseMediaPlayerView.this.n.onError(BaseMediaPlayerView.this.f12107g, i2, i3)) && BaseMediaPlayerView.this.f12111k != null) {
                BaseMediaPlayerView.this.f12111k.onCompletion(BaseMediaPlayerView.this.f12107g);
            }
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class f implements MediaPlayer.OnBufferingUpdateListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            BaseMediaPlayerView.this.m = i2;
        }
    }

    public BaseMediaPlayerView(Context context) {
        super(context);
        this.a = "BabyTextureVideoView";
        this.f12104d = 0;
        this.f12105e = 0;
        this.f12107g = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.E = new f();
        t();
    }

    private void t() {
        this.u = getContext();
        this.f12109i = 0;
        this.f12110j = 0;
        setSurfaceTextureListener(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f12104d = 0;
        this.f12105e = 0;
    }

    private void w() {
        if (this.b == null || this.f12106f == null) {
            return;
        }
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra(TJAdUnitConstants.String.COMMAND, "pause");
        this.u.sendBroadcast(intent);
        z(false);
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f12107g = mediaPlayer;
            int i2 = this.f12108h;
            if (i2 != 0) {
                mediaPlayer.setAudioSessionId(i2);
            } else {
                this.f12108h = mediaPlayer.getAudioSessionId();
            }
            this.f12107g.setOnPreparedListener(this.A);
            this.f12107g.setOnVideoSizeChangedListener(this.z);
            this.f12107g.setOnCompletionListener(this.B);
            this.f12107g.setOnErrorListener(this.D);
            this.f12107g.setOnInfoListener(this.C);
            this.f12107g.setOnBufferingUpdateListener(this.E);
            this.f12107g.setDataSource(this.u, this.b, this.c);
            this.f12107g.setSurface(this.f12106f);
            this.f12107g.setAudioStreamType(3);
            this.f12107g.setScreenOnWhilePlaying(true);
            this.f12107g.setLooping(this.w);
            if (this.x) {
                this.f12107g.setVolume(0.0f, 0.0f);
            } else {
                this.f12107g.setVolume(1.0f, 1.0f);
            }
            this.f12107g.prepareAsync();
            this.f12104d = 1;
        } catch (IOException e2) {
            us.pinguo.common.log.a.e("Unable to open content: " + this.b, e2);
            this.f12104d = -1;
            this.f12105e = -1;
            this.D.onError(this.f12107g, 1, 0);
        } catch (IllegalArgumentException e3) {
            us.pinguo.common.log.a.e("Unable to open content: " + this.b, e3);
            this.f12104d = -1;
            this.f12105e = -1;
            this.D.onError(this.f12107g, 1, 0);
        }
    }

    private void z(boolean z) {
        MediaPlayer mediaPlayer = this.f12107g;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f12107g.reset();
                this.f12107g.release();
                this.f12107g = null;
                this.f12104d = 0;
                if (z) {
                    this.f12105e = 0;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void A(int i2) {
        if (u()) {
            this.f12107g.seekTo(i2);
            this.q = 0;
            return;
        }
        this.q = i2;
    }

    public void B() {
        if (u()) {
            this.f12107g.start();
            this.y = true;
            this.f12104d = 3;
        }
        this.f12105e = 3;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Surface surface = this.f12106f;
        if (surface != null) {
            surface.release();
            this.f12106f = null;
        }
        z(true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(BaseMediaPlayerView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(BaseMediaPlayerView.class.getName());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (u() && z) {
            if (i2 == 79 || i2 == 85) {
                if (this.f12107g.isPlaying()) {
                    x();
                } else {
                    B();
                }
                return true;
            } else if (i2 == 126) {
                if (!this.f12107g.isPlaying()) {
                    B();
                }
                return true;
            } else if (i2 == 86 || i2 == 127) {
                if (this.f12107g.isPlaying()) {
                    x();
                }
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r1 > r6) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f12109i
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.f12110j
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.f12109i
            if (r2 <= 0) goto L7f
            int r2 = r5.f12110j
            if (r2 <= 0) goto L7f
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L43
            if (r1 != r2) goto L43
            int r0 = r5.f12109i
            int r1 = r0 * r7
            int r2 = r5.f12110j
            int r3 = r6 * r2
            if (r1 >= r3) goto L38
            int r0 = r0 * r7
            int r0 = r0 / r2
            goto L66
        L38:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L63
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L54
        L43:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L56
            int r0 = r5.f12110j
            int r0 = r0 * r6
            int r2 = r5.f12109i
            int r0 = r0 / r2
            if (r1 != r3) goto L53
            if (r0 <= r7) goto L53
            goto L63
        L53:
            r1 = r0
        L54:
            r0 = r6
            goto L7f
        L56:
            if (r1 != r2) goto L68
            int r1 = r5.f12109i
            int r1 = r1 * r7
            int r2 = r5.f12110j
            int r1 = r1 / r2
            if (r0 != r3) goto L65
            if (r1 <= r6) goto L65
        L63:
            r0 = r6
            goto L66
        L65:
            r0 = r1
        L66:
            r1 = r7
            goto L7f
        L68:
            int r2 = r5.f12109i
            int r4 = r5.f12110j
            if (r1 != r3) goto L74
            if (r4 <= r7) goto L74
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L76
        L74:
            r1 = r2
            r7 = r4
        L76:
            if (r0 != r3) goto L65
            if (r1 <= r6) goto L65
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L54
        L7f:
            r5.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.widget.BaseMediaPlayerView.onMeasure(int, int):void");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f12109i = i2;
        this.f12110j = i3;
        this.f12106f = new Surface(surfaceTexture);
        w();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.f12106f;
        if (surface != null) {
            surface.release();
            this.f12106f = null;
        }
        z(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f12109i = i2;
        this.f12110j = i3;
        boolean z = this.f12105e == 3;
        if (this.f12107g == null || !z) {
            return;
        }
        int i4 = this.q;
        if (i4 != 0) {
            A(i4);
        }
        B();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.y) {
            this.y = false;
            us.pinguo.ui.widget.f fVar = this.p;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    protected void q(int i2, int i3) {
        int i4 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i5 = (int) ((i3 / i2) * i4);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i4, i5);
        }
        layoutParams.width = i4;
        layoutParams.height = i5;
        setLayoutParams(layoutParams);
        this.v = true;
    }

    public int r() {
        return this.f12110j;
    }

    public int s() {
        return this.f12109i;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f12107g;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
        this.w = true;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12111k = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.n = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.o = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f12112l = onPreparedListener;
    }

    public void setOnStartListener(us.pinguo.ui.widget.f fVar) {
        this.p = fVar;
    }

    public void setSilent(boolean z) {
        MediaPlayer mediaPlayer = this.f12107g;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.x = z;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    public boolean u() {
        int i2;
        return (this.f12107g == null || (i2 = this.f12104d) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    public boolean v() {
        return this.x;
    }

    public void x() {
        if (u() && this.f12107g.isPlaying()) {
            this.f12107g.pause();
            this.f12104d = 4;
        }
        this.f12105e = 4;
    }

    public void y() {
        z(true);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.b = uri;
        this.c = map;
        this.q = 0;
        w();
        requestLayout();
        invalidate();
    }

    public BaseMediaPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t();
    }

    public BaseMediaPlayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "BabyTextureVideoView";
        this.f12104d = 0;
        this.f12105e = 0;
        this.f12107g = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        this.E = new f();
        t();
    }
}
