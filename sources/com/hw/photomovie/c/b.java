package com.hw.photomovie.c;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* compiled from: MusicPlayer.java */
/* loaded from: classes2.dex */
public class b implements com.hw.photomovie.c.a {
    private MediaPlayer a;
    private MediaPlayer.OnErrorListener b;
    private a c;

    /* compiled from: MusicPlayer.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        public void a() {
            throw null;
        }
    }

    public b() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setLooping(true);
    }

    private void a(float f2) {
        try {
            this.a.setVolume(f2, f2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.hw.photomovie.c.a
    public boolean isPlaying() {
        try {
            return this.a.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.hw.photomovie.c.a
    public void pause() {
        if (isPlaying()) {
            this.a.pause();
        }
    }

    @Override // com.hw.photomovie.c.a
    public void release() {
        this.a.release();
    }

    @Override // com.hw.photomovie.c.a
    public void setDataSource(String str) {
        try {
            this.a.reset();
            this.a.setDataSource(str);
            this.a.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.b;
            if (onErrorListener != null) {
                onErrorListener.onError(this.a, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }

    @Override // com.hw.photomovie.c.a
    public void start() {
        a aVar = this.c;
        if (aVar == null) {
            if (isPlaying()) {
                return;
            }
            a(1.0f);
            try {
                this.a.start();
                return;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return;
            }
        }
        aVar.a();
        throw null;
    }

    @Override // com.hw.photomovie.c.a
    public void stop() {
        if (isPlaying()) {
            this.a.stop();
            try {
                this.a.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.a.seekTo(0);
        }
    }

    @Override // com.hw.photomovie.c.a
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.a.reset();
            this.a.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
            this.a.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.b;
            if (onErrorListener != null) {
                onErrorListener.onError(this.a, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }
}
