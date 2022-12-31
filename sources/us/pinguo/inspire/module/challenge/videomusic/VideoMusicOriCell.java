package us.pinguo.inspire.module.challenge.videomusic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import us.pinguo.foundation.VideoMusic;
import vStudio.Android.Camera360.R;
/* compiled from: VideoMusicOriCell.kt */
/* loaded from: classes9.dex */
public final class VideoMusicOriCell extends us.pinguo.widget.common.cell.recycler.b<VideoMusic, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener, MusicDownloadListener {
    private VideoMusic data;
    private final IMusicListFragment player;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMusicOriCell(VideoMusic videoMusic, IMusicListFragment player) {
        super(videoMusic);
        kotlin.jvm.internal.s.h(player, "player");
        this.data = videoMusic;
        this.player = player;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public boolean areItemsTheSame(us.pinguo.widget.common.cell.recycler.b<?, ?> bVar) {
        return true;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext()).inflate(R.layout.video_music_ori_cell, viewGroup, false));
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
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.setOnClickListener(R.id.video_music_cell_layout, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.video_music_cell_layout) {
            this.player.onOriMusicSeleced();
        }
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.MusicDownloadListener
    public void onComplete(String url, boolean z, File file) {
        kotlin.jvm.internal.s.h(url, "url");
    }

    @Override // us.pinguo.inspire.module.challenge.videomusic.MusicDownloadListener
    public void onProgress(String url, float f2, boolean z) {
        kotlin.jvm.internal.s.h(url, "url");
    }

    public final void setData(VideoMusic videoMusic) {
        this.data = videoMusic;
    }
}
