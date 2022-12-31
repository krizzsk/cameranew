package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class s extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {
    private static boolean a = false;
    private final Context b;
    private final SurfaceView c;

    /* renamed from: d  reason: collision with root package name */
    private final SurfaceHolder f8423d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8424e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8425f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8426g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f8427h;

    /* renamed from: i  reason: collision with root package name */
    private final long f8428i;

    /* renamed from: j  reason: collision with root package name */
    private final long f8429j;

    /* renamed from: k  reason: collision with root package name */
    private final FrameLayout f8430k;

    /* renamed from: l  reason: collision with root package name */
    private final Display f8431l;
    private int m;
    private int n;
    private int o;
    private int p;
    private MediaPlayer q;
    private MediaController r;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private a x;
    private b y;
    private volatile int z;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private s b;
        private boolean c = false;

        public b(s sVar) {
            this.b = sVar;
        }

        public final void a() {
            this.c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.c) {
                return;
            }
            if (s.a) {
                s.b("Stopping the video player due to timeout.");
            }
            this.b.CancelOnPrepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(Context context, String str, int i2, int i3, int i4, boolean z, long j2, long j3, a aVar) {
        super(context);
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.z = 0;
        this.x = aVar;
        this.b = context;
        this.f8430k = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.c = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f8423d = holder;
        holder.addCallback(this);
        setBackgroundColor(i2);
        addView(surfaceView);
        this.f8431l = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f8424e = str;
        this.f8425f = i3;
        this.f8426g = i4;
        this.f8427h = z;
        this.f8428i = j2;
        this.f8429j = j3;
        if (a) {
            b("fileName: " + str);
        }
        if (a) {
            b("backgroundColor: " + i2);
        }
        if (a) {
            b("controlMode: " + i3);
        }
        if (a) {
            b("scalingMode: " + i4);
        }
        if (a) {
            b("isURL: " + z);
        }
        if (a) {
            b("videoOffset: " + j2);
        }
        if (a) {
            b("videoLength: " + j3);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a(int i2) {
        this.z = i2;
        a aVar = this.x;
        if (aVar != null) {
            aVar.a(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    private void c() {
        FileInputStream fileInputStream;
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(this.f8423d);
            if (this.v) {
                return;
            }
            if (a) {
                b("Resuming playback");
            }
            this.q.start();
            return;
        }
        a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.q = mediaPlayer2;
            if (this.f8427h) {
                mediaPlayer2.setDataSource(this.b, Uri.parse(this.f8424e));
            } else {
                if (this.f8429j != 0) {
                    fileInputStream = new FileInputStream(this.f8424e);
                    this.q.setDataSource(fileInputStream.getFD(), this.f8428i, this.f8429j);
                } else {
                    try {
                        AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f8424e);
                        this.q.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                    } catch (IOException unused) {
                        fileInputStream = new FileInputStream(this.f8424e);
                        this.q.setDataSource(fileInputStream.getFD());
                    }
                }
                fileInputStream.close();
            }
            this.q.setDisplay(this.f8423d);
            this.q.setScreenOnWhilePlaying(true);
            this.q.setOnBufferingUpdateListener(this);
            this.q.setOnCompletionListener(this);
            this.q.setOnPreparedListener(this);
            this.q.setOnVideoSizeChangedListener(this);
            this.q.setAudioStreamType(3);
            this.q.prepareAsync();
            this.y = new b(this);
            new Thread(this.y).start();
        } catch (Exception e2) {
            if (a) {
                b("error: " + e2.getMessage() + e2);
            }
            a(2);
        }
    }

    private void d() {
        if (isPlaying()) {
            return;
        }
        a(1);
        if (a) {
            b("startVideoPlayback");
        }
        updateVideoLayout();
        if (this.v) {
            return;
        }
        start();
    }

    public final void CancelOnPrepare() {
        a(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void destroyPlayer() {
        if (a) {
            b("destroyPlayer");
        }
        if (!this.v) {
            pause();
        }
        doCleanUp();
    }

    protected final void doCleanUp() {
        b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.q = null;
        }
        this.o = 0;
        this.p = 0;
        this.t = false;
        this.s = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        if (this.f8427h) {
            return this.u;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        boolean z = this.t && this.s;
        MediaPlayer mediaPlayer = this.q;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        if (a) {
            b("onBufferingUpdate percent:" + i2);
        }
        this.u = i2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (a) {
            b("onCompletion called");
        }
        destroyPlayer();
        a(3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 && (this.f8425f != 2 || i2 == 0 || keyEvent.isSystem())) {
            MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onKeyDown(i2, keyEvent) : super.onKeyDown(i2, keyEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (a) {
            b("onPrepared called");
        }
        b bVar = this.y;
        if (bVar != null) {
            bVar.a();
            this.y = null;
        }
        int i2 = this.f8425f;
        if (i2 == 0 || i2 == 1) {
            MediaController mediaController = new MediaController(this.b);
            this.r = mediaController;
            mediaController.setMediaPlayer(this);
            this.r.setAnchorView(this);
            this.r.setEnabled(true);
            Context context = this.b;
            if (context instanceof Activity) {
                this.r.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.r.show();
        }
        this.t = true;
        if (this.s) {
            d();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f8425f != 2 || action != 0) {
            MediaController mediaController = this.r;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        if (a) {
            b("onVideoSizeChanged called " + i2 + "x" + i3);
        }
        if (i2 != 0 && i3 != 0) {
            this.s = true;
            this.o = i2;
            this.p = i3;
            if (!this.t || 1 == 0) {
                return;
            }
            d();
        } else if (a) {
            b("invalid video width(" + i2 + ") or height(" + i3 + ")");
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.pause();
        }
        this.v = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i2) {
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void start() {
        if (a) {
            b("Start");
        }
        MediaPlayer mediaPlayer = this.q;
        if (mediaPlayer == null) {
            return;
        }
        if (this.w) {
            mediaPlayer.start();
        }
        this.v = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (a) {
            b("surfaceChanged called " + i2 + " " + i3 + "x" + i4);
        }
        if (this.m == i3 && this.n == i4) {
            return;
        }
        this.m = i3;
        this.n = i4;
        if (this.w) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (a) {
            b("surfaceCreated called");
        }
        this.w = true;
        c();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (a) {
            b("surfaceDestroyed called");
        }
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r5 <= r3) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        r1 = (int) (r0 / r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        r0 = (int) (r1 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r5 >= r3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateVideoLayout() {
        /*
            r8 = this;
            boolean r0 = com.unity3d.player.s.a
            if (r0 == 0) goto L9
            java.lang.String r0 = "updateVideoLayout"
            b(r0)
        L9:
            android.media.MediaPlayer r0 = r8.q
            if (r0 != 0) goto Le
            return
        Le:
            int r0 = r8.m
            if (r0 == 0) goto L16
            int r0 = r8.n
            if (r0 != 0) goto L34
        L16:
            android.content.Context r0 = r8.b
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.Display r0 = r0.getDefaultDisplay()
            r0.getMetrics(r1)
            int r0 = r1.widthPixels
            r8.m = r0
            int r0 = r1.heightPixels
            r8.n = r0
        L34:
            int r0 = r8.m
            int r1 = r8.n
            boolean r2 = r8.s
            if (r2 == 0) goto L65
            int r2 = r8.o
            float r3 = (float) r2
            int r4 = r8.p
            float r5 = (float) r4
            float r3 = r3 / r5
            float r5 = (float) r0
            float r6 = (float) r1
            float r5 = r5 / r6
            int r6 = r8.f8426g
            r7 = 1
            if (r6 != r7) goto L58
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L53
        L4f:
            float r1 = (float) r0
            float r1 = r1 / r3
            int r1 = (int) r1
            goto L6e
        L53:
            float r0 = (float) r1
            float r0 = r0 * r3
            int r0 = (int) r0
            goto L6e
        L58:
            r7 = 2
            if (r6 != r7) goto L60
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L53
            goto L4f
        L60:
            if (r6 != 0) goto L6e
            r0 = r2
            r1 = r4
            goto L6e
        L65:
            boolean r2 = com.unity3d.player.s.a
            if (r2 == 0) goto L6e
            java.lang.String r2 = "updateVideoLayout: Video size is not known yet"
            b(r2)
        L6e:
            int r2 = r8.m
            if (r2 != r0) goto L76
            int r2 = r8.n
            if (r2 == r1) goto La1
        L76:
            boolean r2 = com.unity3d.player.s.a
            if (r2 == 0) goto L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "frameWidth = "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r3 = "; frameHeight = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            b(r2)
        L93:
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r0, r1, r3)
            android.widget.FrameLayout r0 = r8.f8430k
            android.view.SurfaceView r1 = r8.c
            r0.updateViewLayout(r1, r2)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.s.updateVideoLayout():void");
    }
}
