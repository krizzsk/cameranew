package us.pinguo.inspire.module.challenge.videomusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.inspire.Inspire;
import vStudio.Android.Camera360.R;
/* compiled from: VideoMusicCell.kt */
/* loaded from: classes9.dex */
public final class VideoMusicCell extends us.pinguo.widget.common.cell.recycler.b<VideoMusic, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, MusicDownloadListener {
    public static final Companion Companion = new Companion(null);
    private static VideoMusicCell playingCell;
    private VideoMusic data;
    private boolean isPlaying;
    private final IMusicListFragment player;

    /* compiled from: VideoMusicCell.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final VideoMusicCell getPlayingCell() {
            return VideoMusicCell.playingCell;
        }

        public final void setPlayingCell(VideoMusicCell videoMusicCell) {
            VideoMusicCell.playingCell = videoMusicCell;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMusicCell(VideoMusic data, IMusicListFragment player) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        kotlin.jvm.internal.s.h(player, "player");
        this.data = data;
        this.player = player;
    }

    private final void setPlayState(boolean z) {
        this.isPlaying = z;
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return;
        }
        vh.setImageResource(R.id.video_music_play, z ? R.drawable.video_edit_pause : R.drawable.video_edit_play);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext()).inflate(R.layout.video_music_cell, viewGroup, false));
    }

    public final void downloadOrSelect() {
        MusicDownloader musicDownloader = MusicDownloader.INSTANCE;
        File downloadedMusic = musicDownloader.getDownloadedMusic(this.data.j());
        if (downloadedMusic != null && downloadedMusic.exists()) {
            this.player.onMusicSelected(this.data);
            return;
        }
        this.player.onMusicDownload(true, false, this.data, false);
        musicDownloader.downloadMusic(this.data.j(), this);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public final VideoMusic getData() {
        return this.data;
    }

    public final IMusicListFragment getPlayer() {
        return this.player;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar != null) {
            cVar.setText(R.id.video_music_name, this.data.h());
        }
        if (cVar != null) {
            cVar.setText(R.id.video_music_author, this.data.a());
        }
        if (cVar != null) {
            cVar.setText(R.id.video_music_duration, this.data.f());
        }
        us.pinguo.inspire.cell.recycler.f.c(cVar, R.id.video_music_icon, this.data.b());
        if (cVar != null) {
            cVar.setOnClickListener(R.id.video_music_icon_layout, this);
        }
        if (cVar != null) {
            cVar.setOnClickListener(R.id.video_music_cell_layout, this);
        }
        setPlayState(this.isPlaying);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.video_music_icon_layout) {
            if (!us.pinguo.util.q.e(Inspire.a())) {
                us.pinguo.foundation.utils.j0.c(us.pinguo.c360.i18n.R.string.network_error);
            } else if (!this.isPlaying) {
                this.player.play(this);
                setPlayState(true);
                VideoMusicCell videoMusicCell = playingCell;
                if (videoMusicCell != null) {
                    videoMusicCell.setPlayState(false);
                }
                playingCell = this;
            } else {
                this.player.pause();
                playingCell = null;
                setPlayState(false);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.video_music_cell_layout) {
            downloadOrSelect();
        }
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.MusicDownloadListener
    public void onComplete(String url, boolean z, File file) {
        kotlin.jvm.internal.s.h(url, "url");
        if (us.pinguo.foundation.utils.f0.b(url, this.data.j())) {
            if (z) {
                this.player.onMusicDownload(false, true, this.data, false);
            } else {
                this.player.onMusicDownload(false, true, this.data, true);
            }
        }
    }

    public final void onPlayStop() {
        setPlayState(false);
        playingCell = null;
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.MusicDownloadListener
    public void onProgress(String url, float f2, boolean z) {
        kotlin.jvm.internal.s.h(url, "url");
        if (!us.pinguo.foundation.utils.f0.b(url, this.data.j())) {
        }
    }

    public final void setData(VideoMusic videoMusic) {
        kotlin.jvm.internal.s.h(videoMusic, "<set-?>");
        this.data = videoMusic;
    }
}
