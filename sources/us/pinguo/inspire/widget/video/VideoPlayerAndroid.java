package us.pinguo.inspire.widget.video;

import android.content.Context;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import us.pinguo.ui.widget.video.VideoPlayer;
/* loaded from: classes9.dex */
public class VideoPlayerAndroid extends VideoPlayer {
    public VideoPlayerAndroid(Context context) {
        super(context);
    }

    @Override // us.pinguo.ui.widget.video.VideoPlayer
    protected IMediaPlayer C() {
        return new AndroidMediaPlayer();
    }
}
