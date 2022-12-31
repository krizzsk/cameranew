package com.pinguo.lib.download.listener;

import com.pinguo.lib.download.Config;
/* loaded from: classes3.dex */
public interface DownloadListener {
    void onComplete(Config config);

    void onFailed(Config config, Throwable th);

    void onPause(Config config, Throwable th);

    void onStart(Config config);
}
