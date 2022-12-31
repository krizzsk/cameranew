package us.pinguo.foundation;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* compiled from: MusicPlayer.java */
/* loaded from: classes4.dex */
public class i {
    private MediaPlayer a;
    private boolean b;
    private MediaPlayer.OnErrorListener c;

    /* renamed from: d  reason: collision with root package name */
    private a f11013d;

    /* compiled from: MusicPlayer.java */
    /* loaded from: classes4.dex */
    class a implements Runnable {
        public void a() {
            throw null;
        }
    }

    public i() {
        a();
    }

    private void a() {
        if (this.a == null) {
            this.a = new MediaPlayer();
            g(true);
        }
    }

    public boolean b() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public void c() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.a.pause();
        }
    }

    public void d() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.a = null;
        }
    }

    public void e(int i2) {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
    }

    public void f(Context context, Uri uri) {
        try {
            a();
            this.a.reset();
            this.a.setDataSource(context, uri);
            this.a.prepare();
        } catch (IOException e2) {
            us.pinguo.common.log.a.f(e2);
            MediaPlayer.OnErrorListener onErrorListener = this.c;
            if (onErrorListener != null) {
                onErrorListener.onError(this.a, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }

    public void g(boolean z) {
        this.b = z;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void h(float f2) {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public void i() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return;
        }
        a aVar = this.f11013d;
        if (aVar == null) {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            this.a.start();
            this.a.setLooping(this.b);
            return;
        }
        aVar.a();
        throw null;
    }

    public void j() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.a.stop();
            try {
                this.a.prepare();
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
            }
            this.a.seekTo(0);
        }
    }
}
