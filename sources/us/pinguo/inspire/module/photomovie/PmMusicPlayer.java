package us.pinguo.inspire.module.photomovie;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: classes9.dex */
public class PmMusicPlayer implements com.hw.photomovie.c.a {
    private static final int FADE_DURATION = 1800;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnErrorListener mOnErrorListener;

    public PmMusicPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setLooping(true);
    }

    private void safeReset() {
        try {
            this.mMediaPlayer.reset();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    private void safeSetVolume(float f2) {
        try {
            this.mMediaPlayer.setVolume(f2, f2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.hw.photomovie.c.a
    public boolean isPlaying() {
        try {
            return this.mMediaPlayer.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.hw.photomovie.c.a
    public void pause() {
        if (isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    @Override // com.hw.photomovie.c.a
    public void release() {
        this.mMediaPlayer.release();
    }

    public void seekTo(int i2) {
        this.mMediaPlayer.seekTo(i2);
    }

    @Override // com.hw.photomovie.c.a
    public void setDataSource(String str) {
        try {
            safeReset();
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(this.mMediaPlayer, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }

    public void setErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setLooping(boolean z) {
        this.mMediaPlayer.setLooping(z);
    }

    @Override // com.hw.photomovie.c.a
    public void start() {
        if (isPlaying()) {
            return;
        }
        safeSetVolume(1.0f);
        try {
            this.mMediaPlayer.start();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.hw.photomovie.c.a
    public void stop() {
        if (isPlaying()) {
            this.mMediaPlayer.stop();
            try {
                this.mMediaPlayer.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mMediaPlayer.seekTo(0);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        try {
            safeReset();
            this.mMediaPlayer.setDataSource(fileDescriptor);
            this.mMediaPlayer.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(this.mMediaPlayer, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }

    @Override // com.hw.photomovie.c.a
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        try {
            safeReset();
            this.mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
            this.mMediaPlayer.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(this.mMediaPlayer, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }

    public void setDataSource(Context context, Uri uri) {
        try {
            safeReset();
            this.mMediaPlayer.setDataSource(context, uri);
            this.mMediaPlayer.prepare();
        } catch (IOException e2) {
            e2.printStackTrace();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(this.mMediaPlayer, IMediaPlayer.MEDIA_ERROR_IO, 0);
            }
        }
    }
}
