package com.pinguo.camera360.adv.ui;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.a;
import pl.droidsonroids.gif.GifImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class AlbumGIFAdvActivity_ViewBinding implements Unbinder {
    @UiThread
    public AlbumGIFAdvActivity_ViewBinding(AlbumGIFAdvActivity albumGIFAdvActivity, View view) {
        albumGIFAdvActivity.mAlbumGiftBgGifview = (GifImageView) a.c(view, R.id.album_gift_bg_gifview, "field 'mAlbumGiftBgGifview'", GifImageView.class);
        albumGIFAdvActivity.mAdvLayout = (RelativeLayout) a.c(view, R.id.llAd, "field 'mAdvLayout'", RelativeLayout.class);
    }
}
