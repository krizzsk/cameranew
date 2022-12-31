package us.pinguo.inspire.module.challenge.videomusic;

import java.io.File;
/* compiled from: MusicDownloader.kt */
/* loaded from: classes9.dex */
public interface MusicDownloadListener {
    void onComplete(String str, boolean z, File file);

    void onProgress(String str, float f2, boolean z);
}
