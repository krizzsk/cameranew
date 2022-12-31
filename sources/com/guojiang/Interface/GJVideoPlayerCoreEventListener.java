package com.guojiang.Interface;

import com.guojiang.Common.TextureSizeInfo;
/* loaded from: classes2.dex */
public interface GJVideoPlayerCoreEventListener {
    void OnVideoCompleted();

    void OnVideoError(String str);

    void OnVideoSizeChanged(TextureSizeInfo textureSizeInfo);
}
