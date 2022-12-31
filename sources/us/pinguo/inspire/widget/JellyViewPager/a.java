package us.pinguo.inspire.widget.JellyViewPager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import com.facebook.rebound.g;
/* compiled from: AndroidSpringLooperFactory.java */
/* loaded from: classes9.dex */
abstract class a {

    /* compiled from: AndroidSpringLooperFactory.java */
    @TargetApi(16)
    /* renamed from: us.pinguo.inspire.widget.JellyViewPager.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0404a extends g {
        private final Choreographer b;
        private final Choreographer.FrameCallback c = new Choreographer$FrameCallbackC0405a();

        /* renamed from: d  reason: collision with root package name */
        private boolean f11332d;

        /* renamed from: e  reason: collision with root package name */
        private long f11333e;

        /* compiled from: AndroidSpringLooperFactory.java */
        /* renamed from: us.pinguo.inspire.widget.JellyViewPager.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class Choreographer$FrameCallbackC0405a implements Choreographer.FrameCallback {
            Choreographer$FrameCallbackC0405a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                if (!C0404a.this.f11332d || ((g) C0404a.this).a == null) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                ((g) C0404a.this).a.e(uptimeMillis - C0404a.this.f11333e);
                C0404a.this.f11333e = uptimeMillis;
                C0404a.this.b.postFrameCallback(C0404a.this.c);
            }
        }

        public C0404a(Choreographer choreographer) {
            this.b = choreographer;
        }

        public static C0404a k() {
            return new C0404a(Choreographer.getInstance());
        }

        @Override // com.facebook.rebound.g
        public void b() {
            if (this.f11332d) {
                return;
            }
            this.f11332d = true;
            this.f11333e = SystemClock.uptimeMillis();
            this.b.removeFrameCallback(this.c);
            this.b.postFrameCallback(this.c);
        }

        @Override // com.facebook.rebound.g
        public void c() {
            this.f11332d = false;
            this.b.removeFrameCallback(this.c);
        }
    }

    /* compiled from: AndroidSpringLooperFactory.java */
    /* loaded from: classes9.dex */
    private static class b extends g {
        private final Handler b;
        private final Runnable c = new RunnableC0406a();

        /* renamed from: d  reason: collision with root package name */
        private boolean f11334d;

        /* renamed from: e  reason: collision with root package name */
        private long f11335e;

        /* compiled from: AndroidSpringLooperFactory.java */
        /* renamed from: us.pinguo.inspire.widget.JellyViewPager.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class RunnableC0406a implements Runnable {
            RunnableC0406a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.f11334d || ((g) b.this).a == null) {
                    return;
                }
                ((g) b.this).a.e(SystemClock.uptimeMillis() - b.this.f11335e);
                b.this.b.post(b.this.c);
            }
        }

        public b(Handler handler) {
            this.b = handler;
        }

        public static g j() {
            return new b(new Handler());
        }

        @Override // com.facebook.rebound.g
        public void b() {
            if (this.f11334d) {
                return;
            }
            this.f11334d = true;
            this.f11335e = SystemClock.uptimeMillis();
            this.b.removeCallbacks(this.c);
            this.b.post(this.c);
        }

        @Override // com.facebook.rebound.g
        public void c() {
            this.f11334d = false;
            this.b.removeCallbacks(this.c);
        }
    }

    public static g a() {
        if (Build.VERSION.SDK_INT >= 16) {
            return C0404a.k();
        }
        return b.j();
    }
}
