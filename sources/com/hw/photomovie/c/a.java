package com.hw.photomovie.c;

import android.content.res.AssetFileDescriptor;
/* compiled from: IMusicPlayer.java */
/* loaded from: classes2.dex */
public interface a {
    boolean isPlaying();

    void pause();

    void release();

    void setDataSource(AssetFileDescriptor assetFileDescriptor);

    void setDataSource(String str);

    void start();

    void stop();
}
