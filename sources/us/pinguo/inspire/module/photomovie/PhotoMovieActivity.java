package us.pinguo.inspire.module.photomovie;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.util.w;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoMovieActivity.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieActivity extends InspireBaseActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private PhotoMovieFragment mFragment;

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

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        s.h(ev, "ev");
        PhotoMovieFragment photoMovieFragment = this.mFragment;
        boolean z = false;
        if (photoMovieFragment != null && photoMovieFragment.dispatchTouchEvent(ev)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mEnableBaseNotch = false;
        w.a(this);
        super.onCreate(bundle);
        setContentView(R.layout.inspire_comment_layout);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("PhotoMovieFragment");
        PhotoMovieFragment photoMovieFragment = findFragmentByTag instanceof PhotoMovieFragment ? (PhotoMovieFragment) findFragmentByTag : null;
        this.mFragment = photoMovieFragment;
        if (photoMovieFragment == null) {
            PhotoMovieFragment photoMovieFragment2 = new PhotoMovieFragment();
            this.mFragment = photoMovieFragment2;
            s.e(photoMovieFragment2);
            photoMovieFragment2.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            PhotoMovieFragment photoMovieFragment3 = this.mFragment;
            s.e(photoMovieFragment3);
            beginTransaction.add(R.id.comment_container, photoMovieFragment3, "PhotoMovieFragment").commit();
        }
    }
}
