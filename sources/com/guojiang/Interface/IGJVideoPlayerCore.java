package com.guojiang.Interface;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes2.dex */
public interface IGJVideoPlayerCore {
    boolean Dispose();

    boolean IsPlaying();

    boolean Pause();

    boolean Play();

    boolean Reset();

    void SetSurfaceTexture(SurfaceTexture surfaceTexture);

    void SetVideoPlayerCapability(float f2);

    void SetVideoPlayerCoreEventListener(GJVideoPlayerCoreEventListener gJVideoPlayerCoreEventListener);

    boolean SetVideoUrl(Context context, String str);

    boolean Stop();
}
