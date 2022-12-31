package us.pinguo.inspire.module.challenge.videomusic;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.foundation.base.InspireContentActivity;
/* compiled from: VideoMusicListActivity.kt */
/* loaded from: classes9.dex */
public final class VideoMusicListActivity extends InspireContentActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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

    @Override // us.pinguo.foundation.base.InspireContentActivity
    protected String getFragmentClsName() {
        String name = VideoMusicListFragment.class.getName();
        kotlin.jvm.internal.s.g(name, "VideoMusicListFragment::class.java.name");
        return name;
    }
}
