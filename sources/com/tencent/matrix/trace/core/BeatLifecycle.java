package com.tencent.matrix.trace.core;
/* loaded from: classes3.dex */
public interface BeatLifecycle {
    boolean isAlive();

    void onStart();

    void onStop();
}
