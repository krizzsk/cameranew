package com.guojiang.Interface;

import android.content.Context;
/* loaded from: classes2.dex */
public interface IGJVideoPlayer {
    int CurrentFrameIndex();

    boolean Dispose();

    void DoRender();

    int GetVideoHeight();

    int GetVideoTextureID();

    int GetVideoWidth();

    void OnUnityRenderFramePrepared();

    boolean Pause();

    boolean Play();

    void SetContext(Context context);

    void SetVideoPlayerCapability(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2);

    boolean SetVideoUrl(String str);

    boolean Stop();
}
