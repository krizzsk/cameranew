package i;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.hw.photomovie.segment.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: GLMovieRecorder.java */
@TargetApi(18)
/* loaded from: classes3.dex */
public class a {
    private com.hw.photomovie.render.b a;
    private boolean b;
    private HandlerThread c;

    /* renamed from: d  reason: collision with root package name */
    private int f8659d;

    /* renamed from: e  reason: collision with root package name */
    private int f8660e;

    /* renamed from: f  reason: collision with root package name */
    private int f8661f;

    /* renamed from: g  reason: collision with root package name */
    private int f8662g;

    /* renamed from: h  reason: collision with root package name */
    private int f8663h;

    /* renamed from: i  reason: collision with root package name */
    private MediaCodec f8664i;

    /* renamed from: j  reason: collision with root package name */
    private b f8665j;

    /* renamed from: k  reason: collision with root package name */
    private MediaMuxer f8666k;

    /* renamed from: l  reason: collision with root package name */
    private int f8667l;
    private boolean m;
    private MediaCodec.BufferInfo n;
    private String o;

    /* compiled from: GLMovieRecorder.java */
    /* renamed from: i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0310a implements e.a {
        final /* synthetic */ e a;
        final /* synthetic */ Handler b;
        final /* synthetic */ c c;

        /* compiled from: GLMovieRecorder.java */
        /* renamed from: i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0311a implements Runnable {

            /* compiled from: GLMovieRecorder.java */
            /* renamed from: i.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class RunnableC0312a implements Runnable {
                final /* synthetic */ boolean a;

                RunnableC0312a(boolean z) {
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0310a.this.c.onRecordFinish(this.a);
                }
            }

            RunnableC0311a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    C0310a c0310a = C0310a.this;
                    a.this.k(c0310a.c);
                    z = true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    z = false;
                }
                if (C0310a.this.c != null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0312a(z));
                }
            }
        }

        C0310a(e eVar, Handler handler, c cVar) {
            this.a = eVar;
            this.b = handler;
            this.c = cVar;
        }

        @Override // com.hw.photomovie.segment.e.a
        public void a(boolean z) {
            this.a.u(null);
            this.b.post(new RunnableC0311a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GLMovieRecorder.java */
    /* loaded from: classes3.dex */
    public static class b {
        private EGLDisplay a = EGL14.EGL_NO_DISPLAY;
        private EGLContext b = EGL14.EGL_NO_CONTEXT;
        private EGLSurface c = EGL14.EGL_NO_SURFACE;

        /* renamed from: d  reason: collision with root package name */
        private Surface f8669d;

        public b(Surface surface) {
            Objects.requireNonNull(surface);
            this.f8669d = surface;
            b();
        }

        private void a(String str) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }

        private void b() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    a("eglCreateContext RGB888+recordable ES2");
                    this.b = EGL14.eglCreateContext(this.a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    this.c = EGL14.eglCreateWindowSurface(this.a, eGLConfigArr[0], this.f8669d, new int[]{12344}, 0);
                    a("eglCreateWindowSurface");
                    return;
                }
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }

        public void c() {
            EGLDisplay eGLDisplay = this.a;
            EGLSurface eGLSurface = this.c;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.b);
            a("eglMakeCurrent");
        }

        public void d() {
            EGLDisplay eGLDisplay = this.a;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.a, this.c);
                EGL14.eglDestroyContext(this.a, this.b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.a);
            }
            this.f8669d.release();
            this.a = EGL14.EGL_NO_DISPLAY;
            this.b = EGL14.EGL_NO_CONTEXT;
            this.c = EGL14.EGL_NO_SURFACE;
            this.f8669d = null;
        }

        public void e(long j2) {
            EGLExt.eglPresentationTimeANDROID(this.a, this.c, j2);
            a("eglPresentationTimeANDROID");
        }

        public boolean f() {
            boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.a, this.c);
            a("eglSwapBuffers");
            return eglSwapBuffers;
        }
    }

    /* compiled from: GLMovieRecorder.java */
    /* loaded from: classes3.dex */
    public interface c {
        void onRecordFinish(boolean z);

        void onRecordProgress(int i2, int i3);
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("GLMovieRecorder");
        this.c = handlerThread;
        this.f8659d = -1;
        this.f8660e = -1;
        this.f8661f = -1;
        this.f8662g = 30;
        this.f8663h = 10;
        handlerThread.start();
    }

    private long a(int i2) {
        return (i2 * 1000000000) / this.f8662g;
    }

    private void c(boolean z) {
        if (Build.VERSION.SDK_INT < 21) {
            e(z);
        } else {
            d(z);
        }
    }

    @TargetApi(21)
    private void d(boolean z) {
        Log.d("GLMovieRecorder", "drainEncoder(" + z + ")");
        if (z) {
            Log.d("GLMovieRecorder", "sending EOS to encoder");
            this.f8664i.signalEndOfInputStream();
        }
        while (true) {
            int dequeueOutputBuffer = this.f8664i.dequeueOutputBuffer(this.n, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
                Log.d("GLMovieRecorder", "no output available, spinning to await EOS");
            } else if (dequeueOutputBuffer == -3) {
                continue;
            } else if (dequeueOutputBuffer == -2) {
                if (!this.m) {
                    MediaFormat outputFormat = this.f8664i.getOutputFormat();
                    Log.d("GLMovieRecorder", "encoder output format changed: " + outputFormat);
                    this.f8667l = this.f8666k.addTrack(outputFormat);
                    this.f8666k.start();
                    this.m = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("GLMovieRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer outputBuffer = this.f8664i.getOutputBuffer(dequeueOutputBuffer);
                if (outputBuffer != null) {
                    if ((this.n.flags & 2) != 0) {
                        Log.d("GLMovieRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.n.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo = this.n;
                    if (bufferInfo.size != 0) {
                        if (this.m) {
                            outputBuffer.position(bufferInfo.offset);
                            MediaCodec.BufferInfo bufferInfo2 = this.n;
                            outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            this.f8666k.writeSampleData(this.f8667l, outputBuffer, this.n);
                            Log.d("GLMovieRecorder", "sent " + this.n.size + " bytes to muxer");
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f8664i.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.n.flags & 4) != 0) {
                        if (!z) {
                            Log.w("GLMovieRecorder", "reached end of stream unexpectedly");
                            return;
                        } else {
                            Log.d("GLMovieRecorder", "end of stream reached");
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    private void e(boolean z) {
        Log.d("GLMovieRecorder", "drainEncoder(" + z + ")");
        if (z) {
            Log.d("GLMovieRecorder", "sending EOS to encoder");
            this.f8664i.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f8664i.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f8664i.dequeueOutputBuffer(this.n, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
                Log.d("GLMovieRecorder", "no output available, spinning to await EOS");
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f8664i.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.m) {
                    MediaFormat outputFormat = this.f8664i.getOutputFormat();
                    Log.d("GLMovieRecorder", "encoder output format changed: " + outputFormat);
                    this.f8667l = this.f8666k.addTrack(outputFormat);
                    this.f8666k.start();
                    this.m = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w("GLMovieRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    if ((this.n.flags & 2) != 0) {
                        Log.d("GLMovieRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        this.n.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo = this.n;
                    if (bufferInfo.size != 0) {
                        if (this.m) {
                            byteBuffer.position(bufferInfo.offset);
                            MediaCodec.BufferInfo bufferInfo2 = this.n;
                            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            this.f8666k.writeSampleData(this.f8667l, byteBuffer, this.n);
                            Log.d("GLMovieRecorder", "sent " + this.n.size + " bytes to muxer");
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f8664i.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.n.flags & 4) != 0) {
                        if (!z) {
                            Log.w("GLMovieRecorder", "reached end of stream unexpectedly");
                            return;
                        } else {
                            Log.d("GLMovieRecorder", "end of stream reached");
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    private int f(int i2) {
        return i2 % 2 == 0 ? i2 : i2 + 1;
    }

    private void g() throws IOException {
        this.n = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", f(this.f8659d), f(this.f8660e));
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.f8661f);
        createVideoFormat.setInteger("frame-rate", this.f8662g);
        createVideoFormat.setInteger("i-frame-interval", this.f8663h);
        Log.d("GLMovieRecorder", "format: " + createVideoFormat);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f8664i = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f8665j = new b(this.f8664i.createInputSurface());
        this.f8664i.start();
        String str = this.o;
        Log.d("GLMovieRecorder", "output file is " + str);
        try {
            this.f8666k = new MediaMuxer(str, 0);
            this.f8667l = -1;
            this.m = false;
        } catch (IOException e2) {
            throw new RuntimeException("MediaMuxer creation failed", e2);
        }
    }

    private void h() {
        Log.d("GLMovieRecorder", "releasing encoder objects");
        MediaCodec mediaCodec = this.f8664i;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f8664i.release();
            this.f8664i = null;
        }
        b bVar = this.f8665j;
        if (bVar != null) {
            bVar.d();
            this.f8665j = null;
        }
        MediaMuxer mediaMuxer = this.f8666k;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f8666k.release();
            this.f8666k = null;
        }
    }

    public void b(int i2, int i3, int i4, int i5, int i6, String str) {
        this.f8659d = i2;
        this.f8660e = i3;
        this.f8661f = i4;
        this.f8662g = i5;
        this.f8663h = i6;
        this.o = str;
        this.b = true;
    }

    public void i(com.hw.photomovie.render.b bVar) {
        this.a = bVar;
    }

    public void j(c cVar) {
        if (this.b) {
            if (this.a != null) {
                Handler handler = new Handler(this.c.getLooper());
                e eVar = (e) this.a.d().e().get(0);
                eVar.u(new C0310a(eVar, handler, cVar));
                eVar.r();
                return;
            }
            throw new RuntimeException("please setDataSource first.");
        }
        throw new RuntimeException("please configOutput first.");
    }

    public void k(c cVar) throws IOException {
        a aVar = this;
        g();
        aVar.f8665j.c();
        aVar.a.t(true);
        if (aVar.a.l() != null) {
            aVar.a.l().release();
        }
        aVar.a.s();
        aVar.a.u(aVar.f8659d, aVar.f8660e);
        com.hw.photomovie.a d2 = aVar.a.d();
        int i2 = (int) (1000.0f / aVar.f8662g);
        int d3 = d2.d();
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.c(z);
                long currentTimeMillis2 = System.currentTimeMillis();
                aVar.a.a(i3);
                long currentTimeMillis3 = System.currentTimeMillis();
                int i5 = i2;
                aVar.f8665j.e(aVar.a(i4));
                aVar.f8665j.f();
                long currentTimeMillis4 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                try {
                    sb.append("record frame ");
                    sb.append(i4);
                    com.hw.photomovie.util.b.c("GLMovieRecorder", sb.toString());
                    com.hw.photomovie.util.b.c("GLMovieRecorder", "record 耗时 " + (currentTimeMillis4 - currentTimeMillis) + "ms 绘制耗时:" + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                    i4++;
                    i3 += i5;
                    int d4 = d2.d();
                    if (cVar != null) {
                        cVar.onRecordProgress(i3, d3);
                    }
                    if (i3 > d4) {
                        aVar = this;
                        aVar.c(true);
                        aVar.a.e();
                        h();
                        aVar.a.t(false);
                        return;
                    }
                    aVar = this;
                    i2 = i5;
                    z = false;
                } catch (Throwable th) {
                    th = th;
                    aVar = this;
                    aVar.a.e();
                    h();
                    aVar.a.t(false);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
