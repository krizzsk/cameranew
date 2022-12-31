package com.bytedance.sdk.openadsdk.core.video.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* compiled from: AndroidMediaPlayer.java */
/* loaded from: classes.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.e.a {
    private final MediaPlayer a;
    private final a b;
    private com.bytedance.sdk.openadsdk.core.video.a.b c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f1806d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f1807e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1808f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidMediaPlayer.java */
    /* loaded from: classes.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<b> b;

        public a(b bVar) {
            this.b = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            try {
                if (this.b.get() != null) {
                    b.this.a(i2);
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.c();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.b.get() != null) {
                    return b.this.a(i2, i3);
                }
                return false;
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.b.get() != null) {
                    return b.this.b(i2, i3);
                }
                return false;
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.b();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (this.b.get() != null) {
                    b.this.d();
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            try {
                if (this.b.get() != null) {
                    b.this.a(i2, i3, 1, 1);
                }
            } catch (Throwable th) {
                o.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f1807e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.b = new a(this);
        n();
    }

    private void a(MediaPlayer mediaPlayer) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19 || i2 >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bytedance.sdk.openadsdk.core.o.a(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, new Handler());
            declaredField.setAccessible(false);
            mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "setSubtitleController error: ", th);
        }
    }

    private void m() {
        com.bytedance.sdk.openadsdk.core.video.a.b bVar;
        if (Build.VERSION.SDK_INT < 23 || (bVar = this.c) == null) {
            return;
        }
        try {
            bVar.close();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.c = null;
    }

    private void n() {
        this.a.setOnPreparedListener(this.b);
        this.a.setOnBufferingUpdateListener(this.b);
        this.a.setOnCompletionListener(this.b);
        this.a.setOnSeekCompleteListener(this.b);
        this.a.setOnVideoSizeChangedListener(this.b);
        this.a.setOnErrorListener(this.b);
        this.a.setOnInfoListener(this.b);
    }

    private void o() {
        try {
            Surface surface = this.f1806d;
            if (surface != null) {
                surface.release();
                this.f1806d = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void b(boolean z) throws Throwable {
        this.a.setLooping(z);
    }

    public MediaPlayer e() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void f() throws Throwable {
        this.a.start();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void g() throws Throwable {
        this.a.stop();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void h() throws Throwable {
        this.a.pause();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public long i() {
        try {
            return this.a.getCurrentPosition();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public long j() {
        try {
            return this.a.getDuration();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void k() throws Throwable {
        this.f1808f = true;
        this.a.release();
        o();
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void l() throws Throwable {
        try {
            this.a.reset();
        } catch (Throwable th) {
            o.c("AndroidMediaPlayer", "reset error: ", th);
        }
        m();
        a();
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f1807e) {
            if (!this.f1808f) {
                this.a.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    @TargetApi(14)
    public void a(Surface surface) {
        o();
        this.f1806d = surface;
        this.a.setSurface(surface);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.a.setDataSource(parse.getPath());
        } else {
            this.a.setDataSource(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.a.setDataSource(fileDescriptor);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    @RequiresApi(api = 23)
    public void a(String str, String str2) {
        com.bytedance.sdk.openadsdk.core.video.a.b a2 = com.bytedance.sdk.openadsdk.core.video.a.a.a(str2);
        this.c = a2;
        if (a2 == null) {
            com.bytedance.sdk.openadsdk.core.video.a.b bVar = new com.bytedance.sdk.openadsdk.core.video.a.b(com.bytedance.sdk.openadsdk.core.o.a(), str, str2);
            this.c = bVar;
            if (bVar.a()) {
                com.bytedance.sdk.openadsdk.core.video.a.a.a(str2, this.c);
            }
        }
        this.a.setDataSource(this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(boolean z) throws Throwable {
        this.a.setScreenOnWhilePlaying(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(long j2) throws Throwable {
        this.a.seekTo((int) j2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(float f2, float f3) throws Throwable {
        this.a.setVolume(f2, f3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public void a(Context context, int i2) throws Throwable {
        this.a.setWakeMode(context, i2);
    }
}
