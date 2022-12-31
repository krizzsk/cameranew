package us.pinguo.inspire.module.challenge.videomusic;

import java.util.List;
import us.pinguo.foundation.VideoMusic;
/* compiled from: VideoMusicListFragment.kt */
/* loaded from: classes9.dex */
public final class VideoMusicResp {
    private final List<VideoMusic> items;

    public VideoMusicResp(List<VideoMusic> items) {
        kotlin.jvm.internal.s.h(items, "items");
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoMusicResp copy$default(VideoMusicResp videoMusicResp, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = videoMusicResp.items;
        }
        return videoMusicResp.copy(list);
    }

    public final List<VideoMusic> component1() {
        return this.items;
    }

    public final VideoMusicResp copy(List<VideoMusic> items) {
        kotlin.jvm.internal.s.h(items, "items");
        return new VideoMusicResp(items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoMusicResp) && kotlin.jvm.internal.s.c(this.items, ((VideoMusicResp) obj).items);
    }

    public final List<VideoMusic> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "VideoMusicResp(items=" + this.items + ')';
    }
}
