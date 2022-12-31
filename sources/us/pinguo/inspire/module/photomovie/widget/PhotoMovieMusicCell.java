package us.pinguo.inspire.module.photomovie.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.ui.widget.RoundRecImageView;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoMovieMusicCell.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieMusicCell extends us.pinguo.widget.common.cell.recycler.b<VideoMusic, us.pinguo.widget.common.cell.recycler.c> {
    private PhotoMovieMusicCallback callback;
    private boolean isSelect;
    private final VideoMusic music;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieMusicCell(VideoMusic music) {
        super(music);
        s.h(music, "music");
        this.music = music;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m186onBindViewHolder$lambda0(PhotoMovieMusicCell this$0, View view) {
        s.h(this$0, "this$0");
        PhotoMovieMusicCallback photoMovieMusicCallback = this$0.callback;
        if (photoMovieMusicCallback == null) {
            return;
        }
        photoMovieMusicCallback.onMusicSelect(this$0.music);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup parent) {
        s.h(parent, "parent");
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_movie_music_item_layout, parent, false));
    }

    public final PhotoMovieMusicCallback getCallback() {
        return this.callback;
    }

    public final VideoMusic getMusic() {
        return this.music;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 2;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c viewHolder) {
        s.h(viewHolder, "viewHolder");
        ((ImageView) viewHolder.getView(R.id.photo_movie_music_item_cover)).setVisibility(this.isSelect ? 0 : 8);
        RoundRecImageView roundRecImageView = (RoundRecImageView) viewHolder.getView(R.id.photo_movie_music_item_img);
        roundRecImageView.setRoundPx(roundRecImageView.getResources().getDimensionPixelSize(R.dimen.photo_movie_music_item_corner));
        roundRecImageView.setImageUri(this.music.b());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.photomovie.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoMovieMusicCell.m186onBindViewHolder$lambda0(PhotoMovieMusicCell.this, view);
            }
        });
    }

    public final void setCallback(PhotoMovieMusicCallback photoMovieMusicCallback) {
        this.callback = photoMovieMusicCallback;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
