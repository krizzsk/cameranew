package com.guojiang;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import com.guojiang.Common.TextureSizeInfo;
import com.guojiang.Core.GJVideoPlayerHWCore;
import com.guojiang.Core.GJVideoPlayerRenderCore;
import com.guojiang.Interface.GJVideoPlayerCoreEventListener;
import com.guojiang.Interface.IGJVideoPlayer;
import com.guojiang.Interface.IGJVideoPlayerCore;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class GJVideoPlayer implements SurfaceTexture.OnFrameAvailableListener, IGJVideoPlayer, GJVideoPlayerCoreEventListener {
    private static ConcurrentLinkedQueue glThreadJobQueue = new ConcurrentLinkedQueue();
    private GJVideoPlayerRenderCore renderCore;
    private String LOG_Tag = getClass().getName();
    private Context mContext = null;
    private IGJVideoPlayerCore _mMediaPlayerCore = null;
    private boolean isUnityRenderFramePrepared = false;
    private boolean isVideoLooping = false;
    private boolean isAudioMute = false;
    private float mAudioVolume = 0.5f;
    private int currentFrameIndex = 0;
    private TextureSizeInfo textureSize = new TextureSizeInfo(0, 0);
    private boolean isVideoFristPlay = false;
    private boolean isVideoReadyToPlay = false;
    private boolean isVideoPlayOnWake = false;
    private boolean isVideoPlayWaitFirstFrame = false;
    private boolean isVideoPlayerInitialized = false;
    private boolean useVideoPlayerHW = false;

    public GJVideoPlayer() {
        this.renderCore = null;
        this.renderCore = new GJVideoPlayerRenderCore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitializeVideoPlayer() {
        this.renderCore.InitializeRenderCore();
        SurfaceTexture GetSurfaceTexture = this.renderCore.GetSurfaceTexture();
        if (GetSurfaceTexture != null) {
            GetSurfaceTexture.setOnFrameAvailableListener(this);
            getCurrentVideoPalyerCore().SetSurfaceTexture(GetSurfaceTexture);
            this.isVideoPlayerInitialized = true;
        }
    }

    static /* synthetic */ int access$108(GJVideoPlayer gJVideoPlayer) {
        int i2 = gJVideoPlayer.currentFrameIndex;
        gJVideoPlayer.currentFrameIndex = i2 + 1;
        return i2;
    }

    private IGJVideoPlayerCore getCurrentVideoPalyerCore() {
        if (this._mMediaPlayerCore == null) {
            GJVideoPlayerHWCore gJVideoPlayerHWCore = new GJVideoPlayerHWCore();
            this._mMediaPlayerCore = gJVideoPlayerHWCore;
            gJVideoPlayerHWCore.SetVideoPlayerCoreEventListener(this);
        }
        return this._mMediaPlayerCore;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public int CurrentFrameIndex() {
        return this.currentFrameIndex;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public boolean Dispose() {
        getCurrentVideoPalyerCore().Dispose();
        this.renderCore.Dispose();
        this._mMediaPlayerCore = null;
        return true;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public void DoRender() {
        try {
            this.renderCore.SetCurrentTextureSize(this.textureSize);
            while (true) {
                Runnable runnable = (Runnable) glThreadJobQueue.poll();
                if (runnable == null) {
                    break;
                }
                runnable.run();
            }
            if (this.renderCore.GetTexture2DHandle() != 0 && this.isVideoReadyToPlay && this.isUnityRenderFramePrepared) {
                if (this.isVideoFristPlay && this.isVideoPlayOnWake && this.isVideoPlayWaitFirstFrame) {
                    Play();
                }
                this.isVideoReadyToPlay = false;
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public int GetVideoHeight() {
        return this.renderCore.GetCurrentTextureSize().mHeight;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public int GetVideoTextureID() {
        return this.renderCore.GetTexture2DHandle();
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public int GetVideoWidth() {
        return this.renderCore.GetCurrentTextureSize().mWidth;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public void OnUnityRenderFramePrepared() {
        this.isUnityRenderFramePrepared = true;
    }

    @Override // com.guojiang.Interface.GJVideoPlayerCoreEventListener
    public void OnVideoCompleted() {
        this.currentFrameIndex = 0;
        this.isVideoFristPlay = false;
        if (this.isVideoLooping) {
            Play();
        }
    }

    @Override // com.guojiang.Interface.GJVideoPlayerCoreEventListener
    public void OnVideoError(String str) {
        Log.i(this.LOG_Tag, str);
    }

    @Override // com.guojiang.Interface.GJVideoPlayerCoreEventListener
    public void OnVideoSizeChanged(TextureSizeInfo textureSizeInfo) {
        this.textureSize = textureSizeInfo;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public boolean Pause() {
        return getCurrentVideoPalyerCore().Pause();
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public boolean Play() {
        if (!getCurrentVideoPalyerCore().IsPlaying()) {
            this.currentFrameIndex = 0;
        }
        return getCurrentVideoPalyerCore().Play();
    }

    public void SetAudioMute(boolean z) {
        this.isAudioMute = z;
        getCurrentVideoPalyerCore().SetVideoPlayerCapability(this.isAudioMute ? 0.0f : this.mAudioVolume);
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public void SetContext(Context context) {
        this.mContext = context;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public void SetVideoPlayerCapability(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2) {
        this.useVideoPlayerHW = z;
        this.isVideoPlayWaitFirstFrame = z2;
        this.isVideoPlayOnWake = z3;
        this.isVideoLooping = z4;
        this.isAudioMute = z5;
        this.mAudioVolume = f2;
        getCurrentVideoPalyerCore().SetVideoPlayerCapability(this.isAudioMute ? 0.0f : this.mAudioVolume);
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public boolean SetVideoUrl(String str) {
        if (!this.isVideoPlayerInitialized) {
            glThreadJobQueue.add(new Runnable() { // from class: com.guojiang.GJVideoPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    GJVideoPlayer.this.InitializeVideoPlayer();
                }
            });
        }
        getCurrentVideoPalyerCore().Reset();
        this.isVideoFristPlay = true;
        this.isVideoReadyToPlay = getCurrentVideoPalyerCore().SetVideoUrl(this.mContext, str);
        if (this.isVideoFristPlay && !this.isVideoPlayWaitFirstFrame) {
            Play();
        }
        return this.isVideoReadyToPlay;
    }

    @Override // com.guojiang.Interface.IGJVideoPlayer
    public boolean Stop() {
        return getCurrentVideoPalyerCore().Stop();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        glThreadJobQueue.add(new Runnable() { // from class: com.guojiang.GJVideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.updateTexImage();
                } catch (Exception unused) {
                }
                GJVideoPlayer.access$108(GJVideoPlayer.this);
                GJVideoPlayer.this.renderCore.RenderToTexture();
            }
        });
    }
}
