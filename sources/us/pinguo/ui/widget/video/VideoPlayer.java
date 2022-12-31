package us.pinguo.ui.widget.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.c;
/* loaded from: classes6.dex */
public class VideoPlayer implements BaseVideoTextureView.a, us.pinguo.ui.widget.video.c {
    private Context a;
    private Uri b;

    /* renamed from: f  reason: collision with root package name */
    private IMediaPlayer.OnCompletionListener f12331f;

    /* renamed from: g  reason: collision with root package name */
    private IMediaPlayer.OnPreparedListener f12332g;

    /* renamed from: h  reason: collision with root package name */
    private IMediaPlayer.OnErrorListener f12333h;

    /* renamed from: i  reason: collision with root package name */
    private IMediaPlayer.OnInfoListener f12334i;

    /* renamed from: j  reason: collision with root package name */
    private int f12335j;
    private HandlerThread m;
    private Handler n;
    private WeakReference<BaseVideoTextureView> q;
    private c.a s;
    private c.InterfaceC0457c t;
    private volatile c.b u;
    private volatile boolean v;
    private volatile int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f12329d = 0;

    /* renamed from: e  reason: collision with root package name */
    private IMediaPlayer f12330e = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12336k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12337l = false;
    private boolean o = false;
    private boolean p = false;
    private final Vector<Runnable> r = new Vector<>();
    private Map<String, Integer> w = new HashMap();
    private boolean x = true;
    private IMediaPlayer.OnCompletionListener y = new e();
    private IMediaPlayer.OnInfoListener z = new f();
    private IMediaPlayer.OnErrorListener A = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayer.this.f12330e != null && VideoPlayer.this.c >= 2) {
                VideoPlayer.this.f12330e.setLooping(this.a);
            }
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoTextureView baseVideoTextureView;
            VideoPlayer.this.o = true;
            Surface surface = null;
            while (!VideoPlayer.this.p && (baseVideoTextureView = (BaseVideoTextureView) VideoPlayer.this.q.get()) != null) {
                baseVideoTextureView.a(true);
                surface = baseVideoTextureView.b();
                if (surface == null) {
                    SystemClock.sleep(5L);
                    continue;
                }
                if (surface != null) {
                    break;
                }
            }
            if (VideoPlayer.this.q.get() != null && VideoPlayer.this.v) {
                ((BaseVideoTextureView) VideoPlayer.this.q.get()).setOnSurfaceReNewListener(VideoPlayer.this);
            }
            VideoPlayer.this.o = false;
            VideoPlayer.this.p = false;
            if (VideoPlayer.this.c > 0 && VideoPlayer.this.f12330e != null && surface != null) {
                VideoPlayer.this.f12330e.setSurface(surface);
            }
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {
        final /* synthetic */ float a;

        c(float f2) {
            this.a = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer.this.f0(this.a);
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer.this.R();
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    class e implements IMediaPlayer.OnCompletionListener {
        e() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            VideoPlayer.this.c = 5;
            VideoPlayer.this.f12329d = 5;
            if (VideoPlayer.this.f12331f != null) {
                VideoPlayer.this.f12331f.onCompletion(VideoPlayer.this.f12330e);
            }
            if (VideoPlayer.this.u != null) {
                VideoPlayer.this.u.onComplete();
            }
        }
    }

    /* loaded from: classes6.dex */
    class f implements IMediaPlayer.OnInfoListener {
        f() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
            if (VideoPlayer.this.f12334i != null) {
                VideoPlayer.this.f12334i.onInfo(iMediaPlayer, i2, i3);
            }
            if (i2 == 10001 && VideoPlayer.this.q != null && VideoPlayer.this.q.get() != null) {
                if (((i3 / 90) & 1) == 1 && VideoPlayer.this.b != null && !TextUtils.isEmpty(VideoPlayer.this.b.toString())) {
                    VideoPlayer.this.w.put(VideoPlayer.this.b.toString(), Integer.valueOf(i3));
                }
                BaseVideoTextureView baseVideoTextureView = (BaseVideoTextureView) VideoPlayer.this.q.get();
                if (baseVideoTextureView instanceof us.pinguo.ui.widget.video.e) {
                    ((us.pinguo.ui.widget.video.e) baseVideoTextureView).setFixRotation(i3);
                }
            }
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class g implements IMediaPlayer.OnErrorListener {
        g() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
            us.pinguo.common.log.a.c("Error: " + i2 + "," + i3, new Object[0]);
            VideoPlayer.this.c = -1;
            VideoPlayer.this.f12329d = -1;
            if ((VideoPlayer.this.f12333h == null || !VideoPlayer.this.f12333h.onError(VideoPlayer.this.f12330e, i2, i3)) && VideoPlayer.this.f12331f != null) {
                VideoPlayer.this.f12331f.onCompletion(VideoPlayer.this.f12330e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer.this.S(true);
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer.this.g0();
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayer.this.O();
            synchronized (VideoPlayer.this.r) {
                VideoPlayer.this.r.remove(this);
            }
        }
    }

    public VideoPlayer(Context context) {
        this.a = context.getApplicationContext();
        D();
    }

    private void D() {
        this.c = 0;
        this.f12329d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(IMediaPlayer iMediaPlayer) {
        us.pinguo.common.log.a.m("zhouwei", "network video prepared............", new Object[0]);
        c.InterfaceC0457c interfaceC0457c = this.t;
        if (interfaceC0457c != null) {
            interfaceC0457c.onPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(IMediaPlayer iMediaPlayer, int i2) {
        c.a aVar = this.s;
        if (aVar != null) {
            aVar.onBufferingUpdate(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void R() {
        this.w.clear();
        if (this.f12330e != null && this.c > 0) {
            this.f12330e.reset();
        }
        try {
            if (this.f12330e == null) {
                this.f12330e = C();
            }
            IMediaPlayer iMediaPlayer = this.f12330e;
            if (iMediaPlayer instanceof IjkMediaPlayer) {
                if (this.x) {
                    ((IjkMediaPlayer) iMediaPlayer).setOption(4, "start-on-prepared", 1L);
                } else {
                    ((IjkMediaPlayer) iMediaPlayer).setOption(4, "start-on-prepared", 0L);
                }
            }
            this.c = 1;
            this.f12330e.setOnCompletionListener(this.y);
            this.f12330e.setOnErrorListener(this.A);
            this.f12330e.setOnInfoListener(this.z);
            this.f12330e.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: us.pinguo.ui.widget.video.a
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
                public final void onPrepared(IMediaPlayer iMediaPlayer2) {
                    VideoPlayer.this.K(iMediaPlayer2);
                }
            });
            this.f12330e.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() { // from class: us.pinguo.ui.widget.video.b
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
                public final void onBufferingUpdate(IMediaPlayer iMediaPlayer2, int i2) {
                    VideoPlayer.this.M(iMediaPlayer2, i2);
                }
            });
            us.pinguo.common.log.a.k("setDataSource:" + this.b, new Object[0]);
            this.f12330e.setDataSource(this.a, this.b);
            this.f12330e.setAudioStreamType(3);
            this.f12330e.setScreenOnWhilePlaying(true);
            this.f12330e.setLooping(this.f12336k);
            if (this.f12337l) {
                this.f12330e.setVolume(0.0f, 0.0f);
            } else {
                this.f12330e.setVolume(1.0f, 1.0f);
            }
            this.f12330e.prepareAsync();
            N(this.f12330e);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            this.c = -1;
            this.f12329d = -1;
            this.A.onError(this.f12330e, 1, 0);
            IMediaPlayer iMediaPlayer2 = this.f12330e;
            if (iMediaPlayer2 != null) {
                iMediaPlayer2.release();
            }
            this.f12330e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void S(boolean z) {
        try {
            IMediaPlayer iMediaPlayer = this.f12330e;
            if (iMediaPlayer != null) {
                iMediaPlayer.reset();
                this.f12330e.release();
                this.f12330e = null;
                this.c = 0;
                if (z) {
                    this.f12329d = 0;
                }
            }
            HandlerThread handlerThread = this.m;
            if (handlerThread != null) {
                handlerThread.quit();
                this.m = null;
                this.n = null;
            }
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(float f2) {
        IMediaPlayer iMediaPlayer = this.f12330e;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(f2, f2);
        }
    }

    public BaseVideoTextureView A() {
        WeakReference<BaseVideoTextureView> weakReference = this.q;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public Uri B() {
        return this.b;
    }

    protected IMediaPlayer C() {
        return new IjkMediaPlayer();
    }

    public boolean E(Uri uri) {
        return us.pinguo.ui.widget.video.d.a(uri).equals(this.b);
    }

    public boolean F() {
        return this.c == -1;
    }

    public boolean G() {
        return (this.f12330e == null || this.c == -1 || this.c == 0 || this.c == 1) ? false : true;
    }

    public boolean H() {
        return this.c == 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0008, code lost:
        if (r2.c >= 1) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean I() {
        /*
            r2 = this;
            monitor-enter(r2)
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r2.f12330e     // Catch: java.lang.Throwable -> Le
            r1 = 1
            if (r0 == 0) goto Lb
            int r0 = r2.c     // Catch: java.lang.Throwable -> Le
            if (r0 < r1) goto Lb
            goto Lc
        Lb:
            r1 = 0
        Lc:
            monitor-exit(r2)
            return r1
        Le:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.widget.video.VideoPlayer.I():boolean");
    }

    public void N(IMediaPlayer iMediaPlayer) {
        this.c = 2;
        IMediaPlayer.OnPreparedListener onPreparedListener = this.f12332g;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this.f12330e);
        }
        iMediaPlayer.getVideoWidth();
        iMediaPlayer.getVideoHeight();
        int i2 = this.f12335j;
        if (i2 != 0) {
            T(i2);
        }
        if (this.f12329d == 3) {
            g0();
        }
    }

    public synchronized void O() {
        if (G() && this.f12330e.isPlaying()) {
            this.f12330e.pause();
            this.c = 4;
        }
        this.f12329d = 4;
    }

    public void P() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra(TJAdUnitConstants.String.COMMAND, "pause");
        this.a.sendBroadcast(intent);
    }

    public void Q(Uri uri) {
        if (uri == null) {
            return;
        }
        Uri a2 = us.pinguo.ui.widget.video.d.a(uri);
        if (this.m == null || this.n == null) {
            HandlerThread handlerThread = new HandlerThread("VideoPlayer", -19);
            this.m = handlerThread;
            handlerThread.start();
            this.n = new Handler(this.m.getLooper());
        }
        this.b = a2;
        this.f12335j = 0;
        d dVar = new d();
        synchronized (this.r) {
            this.r.add(dVar);
        }
        this.n.post(dVar);
    }

    public void T(int i2) {
        if (G()) {
            this.f12330e.seekTo(i2);
            this.f12335j = 0;
            return;
        }
        this.f12335j = i2;
    }

    public synchronized void U(boolean z) {
        this.x = z;
    }

    public void V(boolean z) {
        if (this.n == null) {
            return;
        }
        a aVar = new a(z);
        synchronized (this.r) {
            this.r.add(aVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(aVar);
        }
        this.f12336k = z;
    }

    public void W(c.a aVar) {
        this.s = aVar;
    }

    public void X(c.b bVar) {
        this.u = bVar;
    }

    public void Y(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12331f = onCompletionListener;
    }

    public void Z(IMediaPlayer.OnErrorListener onErrorListener) {
        this.f12333h = onErrorListener;
    }

    @Override // us.pinguo.ui.widget.video.c
    public void a() {
        if (this.n == null) {
            return;
        }
        j jVar = new j();
        synchronized (this.r) {
            this.r.add(jVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(jVar);
        }
    }

    public void a0(IMediaPlayer.OnInfoListener onInfoListener) {
        this.f12334i = onInfoListener;
    }

    @Override // us.pinguo.ui.widget.video.c
    public void b() {
        if (this.n == null) {
            return;
        }
        h hVar = new h();
        synchronized (this.r) {
            this.r.add(hVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(hVar);
        }
    }

    public void b0(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.f12332g = onPreparedListener;
    }

    @Override // us.pinguo.ui.widget.video.c
    public void c(BaseVideoTextureView baseVideoTextureView) {
        if (this.n == null) {
            return;
        }
        this.q = new WeakReference<>(baseVideoTextureView);
        baseVideoTextureView.a(false);
        baseVideoTextureView.postInvalidate();
        b bVar = new b();
        synchronized (this.r) {
            this.r.add(bVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(bVar);
        }
    }

    public void c0(c.InterfaceC0457c interfaceC0457c) {
        this.t = interfaceC0457c;
    }

    @Override // us.pinguo.ui.widget.video.c
    public void d() {
        Integer num;
        i iVar = new i();
        Uri uri = this.b;
        if (uri != null && (num = this.w.get(uri.toString())) != null) {
            BaseVideoTextureView baseVideoTextureView = this.q.get();
            if (baseVideoTextureView instanceof us.pinguo.ui.widget.video.e) {
                ((us.pinguo.ui.widget.video.e) baseVideoTextureView).setFixRotation(num.intValue());
            }
        }
        synchronized (this.r) {
            this.r.add(iVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(iVar);
        }
    }

    public void d0(boolean z) {
        IMediaPlayer iMediaPlayer = this.f12330e;
        if (iMediaPlayer != null) {
            if (z) {
                iMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                iMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.f12337l = z;
    }

    @Override // us.pinguo.ui.widget.video.BaseVideoTextureView.a
    public void e(BaseVideoTextureView baseVideoTextureView, Surface surface) {
        if (I()) {
            c(baseVideoTextureView);
            d();
        }
    }

    public void e0(float f2) {
        if (this.n == null) {
            return;
        }
        c cVar = new c(f2);
        synchronized (this.r) {
            this.r.add(cVar);
        }
        Handler handler = this.n;
        if (handler != null) {
            handler.post(cVar);
        }
    }

    @Override // us.pinguo.ui.widget.video.c
    public void f() {
        if (this.n == null) {
            return;
        }
        if (this.o) {
            this.p = true;
        }
        synchronized (this.r) {
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                Runnable runnable = this.r.get(i2);
                Handler handler = this.n;
                if (handler != null) {
                    handler.removeCallbacks(runnable);
                }
            }
            this.r.clear();
        }
    }

    public synchronized void g0() {
        P();
        us.pinguo.common.log.a.k("start mCurrentState = " + this.c, new Object[0]);
        if (G()) {
            this.f12330e.start();
            WeakReference<BaseVideoTextureView> weakReference = this.q;
            BaseVideoTextureView baseVideoTextureView = weakReference == null ? null : weakReference.get();
            if (baseVideoTextureView != null) {
                baseVideoTextureView.a(true);
            }
            this.c = 3;
        }
        this.f12329d = 3;
    }

    @Override // us.pinguo.ui.widget.video.c
    public boolean isPlaying() {
        return G() && this.f12330e.isPlaying();
    }

    public long z() {
        if (G()) {
            return this.f12330e.getCurrentPosition();
        }
        return 0L;
    }
}
