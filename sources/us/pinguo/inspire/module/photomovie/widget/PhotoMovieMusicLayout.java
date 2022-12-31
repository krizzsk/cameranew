package us.pinguo.inspire.module.photomovie.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.R;
/* compiled from: PhotoMovieMusicLayout.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieMusicLayout extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private PhotoMovieMusicCallback callback;
    public us.pinguo.user.recycler.c mAdapter;
    public RecyclerView mRecyclerView;
    private int selectIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieMusicLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.selectIndex = -1;
    }

    private final void initCells() {
        List j2;
        j2 = u.j(new PhotoMovieOnlineMusicCell(), new PhotoMovieMusicNoneCell());
        getMAdapter().setCells(new ArrayList(j2));
    }

    private final void setCallbacks(PhotoMovieMusicCallback photoMovieMusicCallback) {
        int itemCount = getMAdapter().getItemCount();
        if (itemCount < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            us.pinguo.widget.common.cell.recycler.b item = getMAdapter().getItem(i2);
            if (item instanceof PhotoMovieMusicNoneCell) {
                ((PhotoMovieMusicNoneCell) item).setCallback(photoMovieMusicCallback);
            } else if (item instanceof PhotoMovieOnlineMusicCell) {
                ((PhotoMovieOnlineMusicCell) item).setCallback(photoMovieMusicCallback);
            } else if (item instanceof PhotoMovieMusicCell) {
                ((PhotoMovieMusicCell) item).setCallback(photoMovieMusicCallback);
            }
            if (i2 == itemCount) {
                return;
            }
            i2 = i3;
        }
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

    public final PhotoMovieMusicCallback getCallback() {
        return this.callback;
    }

    public final us.pinguo.user.recycler.c getMAdapter() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            return cVar;
        }
        s.z("mAdapter");
        throw null;
    }

    public final RecyclerView getMRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        s.z("mRecyclerView");
        throw null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView photo_movie_music_list = (RecyclerView) _$_findCachedViewById(R.id.photo_movie_music_list);
        s.g(photo_movie_music_list, "photo_movie_music_list");
        setMRecyclerView(photo_movie_music_list);
        setMAdapter(new us.pinguo.user.recycler.c());
        getMRecyclerView().setAdapter(getMAdapter());
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getMRecyclerView().addItemDecoration(new SpaceItemDecoration(us.pinguo.foundation.t.b.a.b(getMRecyclerView().getResources(), 16.0f)));
        initCells();
    }

    public final void select(String str) {
        us.pinguo.widget.common.cell.recycler.b item = getMAdapter().getItem(this.selectIndex);
        PhotoMovieMusicCell photoMovieMusicCell = item instanceof PhotoMovieMusicCell ? (PhotoMovieMusicCell) item : null;
        if (photoMovieMusicCell != null) {
            photoMovieMusicCell.setSelect(false);
        }
        if (this.selectIndex > 0) {
            getMAdapter().notifyItemChanged(this.selectIndex);
        }
        if (str == null) {
            return;
        }
        int i2 = 2;
        int itemCount = getMAdapter().getItemCount();
        if (2 > itemCount) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            us.pinguo.widget.common.cell.recycler.b item2 = getMAdapter().getItem(i2);
            if (item2 instanceof PhotoMovieMusicCell) {
                PhotoMovieMusicCell photoMovieMusicCell2 = (PhotoMovieMusicCell) item2;
                if (f0.b(photoMovieMusicCell2.getData().h(), str)) {
                    this.selectIndex = i2;
                    photoMovieMusicCell2.setSelect(true);
                    getMAdapter().notifyItemChanged(this.selectIndex);
                    return;
                }
            }
            if (i2 == itemCount) {
                return;
            }
            i2 = i3;
        }
    }

    public final void setCallback(PhotoMovieMusicCallback photoMovieMusicCallback) {
        this.callback = photoMovieMusicCallback;
        setCallbacks(photoMovieMusicCallback);
    }

    public final void setLocalMusicCell(List<PhotoMovieMusicCell> cellList) {
        s.h(cellList, "cellList");
        getMAdapter().beginChange();
        getMAdapter().remove(2, getMAdapter().getItemCount());
        getMAdapter().addAll(cellList);
        getMAdapter().endChange(true);
    }

    public final void setMAdapter(us.pinguo.user.recycler.c cVar) {
        s.h(cVar, "<set-?>");
        this.mAdapter = cVar;
    }

    public final void setMRecyclerView(RecyclerView recyclerView) {
        s.h(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }

    public final void setPlayingMusic(String str) {
        if (str == null) {
            ((TextView) _$_findCachedViewById(R.id.photo_movie_music_title)).setVisibility(8);
            return;
        }
        int i2 = R.id.photo_movie_music_title;
        ((TextView) _$_findCachedViewById(i2)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i2)).setText(getResources().getString(vStudio.Android.Camera360.R.string.photo_movie_music_playing) + '-' + ((Object) str));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieMusicLayout(Context context, AttributeSet attr) {
        super(context, attr);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
        this.selectIndex = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieMusicLayout(Context context, AttributeSet attr, int i2) {
        super(context, attr, i2);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
        this.selectIndex = -1;
    }
}
