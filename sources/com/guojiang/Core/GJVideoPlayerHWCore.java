package com.guojiang.Core;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import com.guojiang.Common.TextureSizeInfo;
import com.guojiang.Interface.GJVideoPlayerCoreEventListener;
import com.guojiang.Interface.IGJVideoPlayerCore;
/* loaded from: classes2.dex */
public class GJVideoPlayerHWCore implements IGJVideoPlayerCore, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private MediaPlayer mMediaPlayer;
    private String LOG_Tag = getClass().getName();
    private GJVideoPlayerCoreEventListener eventListener = null;
    private Surface mSurface = null;

    public GJVideoPlayerHWCore() {
        this.mMediaPlayer = null;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer;
        mediaPlayer.setOnErrorListener(this);
        this.mMediaPlayer.setOnCompletionListener(this);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this);
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean Dispose() {
        Surface surface = this.mSurface;
        if (surface != null) {
            if (surface.isValid()) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
        }
        this.eventListener = null;
        return true;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean IsPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean Pause() {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean Play() {
        if (!this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.start();
        }
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean Reset() {
        if (Pause() && Stop()) {
            this.mMediaPlayer.reset();
            return true;
        }
        return true;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public void SetSurfaceTexture(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        this.mMediaPlayer.setSurface(surface);
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public void SetVideoPlayerCapability(float f2) {
        this.mMediaPlayer.setVolume(f2, f2);
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public void SetVideoPlayerCoreEventListener(GJVideoPlayerCoreEventListener gJVideoPlayerCoreEventListener) {
        this.eventListener = gJVideoPlayerCoreEventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[Catch: Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:3:0x0003, B:6:0x000c, B:8:0x0012, B:10:0x002a, B:14:0x0049, B:11:0x003c), top: B:19:0x0003 }] */
    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean SetVideoUrl(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "/assets/"
            r1 = 0
            int r2 = r12.length()     // Catch: java.lang.Exception -> L50
            r3 = 1
            if (r2 <= 0) goto L46
            if (r11 == 0) goto L46
            boolean r2 = r12.contains(r0)     // Catch: java.lang.Exception -> L50
            if (r2 == 0) goto L3c
            int r2 = r12.lastIndexOf(r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r12 = r12.substring(r2)     // Catch: java.lang.Exception -> L50
            java.lang.String r2 = ""
            java.lang.String r12 = r12.replace(r0, r2)     // Catch: java.lang.Exception -> L50
            android.content.res.AssetManager r11 = r11.getAssets()     // Catch: java.lang.Exception -> L50
            android.content.res.AssetFileDescriptor r11 = r11.openFd(r12)     // Catch: java.lang.Exception -> L50
            if (r11 == 0) goto L46
            android.media.MediaPlayer r4 = r10.mMediaPlayer     // Catch: java.lang.Exception -> L50
            java.io.FileDescriptor r5 = r11.getFileDescriptor()     // Catch: java.lang.Exception -> L50
            long r6 = r11.getStartOffset()     // Catch: java.lang.Exception -> L50
            long r8 = r11.getLength()     // Catch: java.lang.Exception -> L50
            r4.setDataSource(r5, r6, r8)     // Catch: java.lang.Exception -> L50
            goto L47
        L3c:
            android.net.Uri r12 = android.net.Uri.parse(r12)     // Catch: java.lang.Exception -> L50
            android.media.MediaPlayer r0 = r10.mMediaPlayer     // Catch: java.lang.Exception -> L50
            r0.setDataSource(r11, r12)     // Catch: java.lang.Exception -> L50
            goto L47
        L46:
            r3 = 0
        L47:
            if (r3 == 0) goto L4e
            android.media.MediaPlayer r11 = r10.mMediaPlayer     // Catch: java.lang.Exception -> L50
            r11.prepare()     // Catch: java.lang.Exception -> L50
        L4e:
            r1 = r3
            goto L5a
        L50:
            r11 = move-exception
            java.lang.String r12 = r10.LOG_Tag
            java.lang.String r11 = r11.toString()
            android.util.Log.i(r12, r11)
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.guojiang.Core.GJVideoPlayerHWCore.SetVideoUrl(android.content.Context, java.lang.String):boolean");
    }

    @Override // com.guojiang.Interface.IGJVideoPlayerCore
    public boolean Stop() {
        if (Pause()) {
            this.mMediaPlayer.reset();
            return true;
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        GJVideoPlayerCoreEventListener gJVideoPlayerCoreEventListener = this.eventListener;
        if (gJVideoPlayerCoreEventListener != null) {
            gJVideoPlayerCoreEventListener.OnVideoCompleted();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        GJVideoPlayerCoreEventListener gJVideoPlayerCoreEventListener = this.eventListener;
        if (gJVideoPlayerCoreEventListener != null) {
            gJVideoPlayerCoreEventListener.OnVideoError(String.format("{0} Erroer, What:{1} , Extra:{2}", this.LOG_Tag, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        GJVideoPlayerCoreEventListener gJVideoPlayerCoreEventListener = this.eventListener;
        if (gJVideoPlayerCoreEventListener != null) {
            gJVideoPlayerCoreEventListener.OnVideoSizeChanged(new TextureSizeInfo(i2, i3));
        }
    }
}
