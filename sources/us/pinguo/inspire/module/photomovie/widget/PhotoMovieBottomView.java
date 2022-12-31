package us.pinguo.inspire.module.photomovie.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoMovieBottomView.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieBottomView extends ConstraintLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private PhotoMovieBottomCallback callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieBottomView(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final PhotoMovieBottomCallback getCallback() {
        return this.callback;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        s.h(v, "v");
        int id = v.getId();
        if (id != R.id.photo_movie_music_img) {
            switch (id) {
                case R.id.photo_movie_effect_img /* 2097545613 */:
                case R.id.photo_movie_effect_txt /* 2097545614 */:
                    PhotoMovieBottomCallback photoMovieBottomCallback = this.callback;
                    if (photoMovieBottomCallback == null) {
                        return;
                    }
                    photoMovieBottomCallback.onTransferClick();
                    return;
                case R.id.photo_movie_filter_img /* 2097545615 */:
                case R.id.photo_movie_filter_txt /* 2097545616 */:
                    PhotoMovieBottomCallback photoMovieBottomCallback2 = this.callback;
                    if (photoMovieBottomCallback2 == null) {
                        return;
                    }
                    photoMovieBottomCallback2.onFilterClick();
                    return;
                default:
                    switch (id) {
                        case R.id.photo_movie_music_txt /* 2097545626 */:
                            break;
                        case R.id.photo_movie_next /* 2097545627 */:
                            PhotoMovieBottomCallback photoMovieBottomCallback3 = this.callback;
                            if (photoMovieBottomCallback3 == null) {
                                return;
                            }
                            photoMovieBottomCallback3.onNextClick();
                            return;
                        default:
                            return;
                    }
            }
        }
        PhotoMovieBottomCallback photoMovieBottomCallback4 = this.callback;
        if (photoMovieBottomCallback4 == null) {
            return;
        }
        photoMovieBottomCallback4.onMusicClick();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((AppCompatImageView) _$_findCachedViewById(us.pinguo.inspire.R.id.photo_movie_effect_img)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(us.pinguo.inspire.R.id.photo_movie_effect_txt)).setOnClickListener(this);
        int i2 = us.pinguo.inspire.R.id.photo_movie_music_img;
        ((AppCompatImageView) _$_findCachedViewById(i2)).setOnClickListener(this);
        int i3 = us.pinguo.inspire.R.id.photo_movie_music_txt;
        ((TextView) _$_findCachedViewById(i3)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(us.pinguo.inspire.R.id.photo_movie_filter_img)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(us.pinguo.inspire.R.id.photo_movie_filter_txt)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(us.pinguo.inspire.R.id.photo_movie_next)).setOnClickListener(this);
        if (us.pinguo.util.c.f12474h) {
            ((AppCompatImageView) _$_findCachedViewById(i2)).setVisibility(8);
            ((TextView) _$_findCachedViewById(i3)).setVisibility(8);
        }
    }

    public final void setCallback(PhotoMovieBottomCallback photoMovieBottomCallback) {
        this.callback = photoMovieBottomCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieBottomView(Context context, AttributeSet attr) {
        super(context, attr);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieBottomView(Context context, AttributeSet attr, int i2) {
        super(context, attr, i2);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
    }
}
