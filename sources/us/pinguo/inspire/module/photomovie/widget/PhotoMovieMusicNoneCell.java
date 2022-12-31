package us.pinguo.inspire.module.photomovie.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoMovieMusicNoneCell.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieMusicNoneCell extends us.pinguo.widget.common.cell.recycler.b<Object, us.pinguo.widget.common.cell.recycler.c> {
    private PhotoMovieMusicCallback callback;
    private boolean isSelect;

    public PhotoMovieMusicNoneCell() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m187onBindViewHolder$lambda0(PhotoMovieMusicNoneCell this$0, View view) {
        s.h(this$0, "this$0");
        PhotoMovieMusicCallback photoMovieMusicCallback = this$0.callback;
        if (photoMovieMusicCallback == null) {
            return;
        }
        photoMovieMusicCallback.onMusicSelect(null);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup parent) {
        s.h(parent, "parent");
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_movie_music_item_none_layout, parent, false));
    }

    public final PhotoMovieMusicCallback getCallback() {
        return this.callback;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c viewHolder) {
        s.h(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.photomovie.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoMovieMusicNoneCell.m187onBindViewHolder$lambda0(PhotoMovieMusicNoneCell.this, view);
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
