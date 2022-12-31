package us.pinguo.inspire.module.challenge.videomusic;

import us.pinguo.foundation.VideoMusic;
/* compiled from: VideoMusicListFragment.kt */
/* loaded from: classes9.dex */
public interface IMusicListFragment {
    void onMusicDownload(boolean z, boolean z2, VideoMusic videoMusic, boolean z3);

    void onMusicSelected(VideoMusic videoMusic);

    void onOriMusicSeleced();

    void pause();

    void play(VideoMusicCell videoMusicCell);
}
