package vStudio.Android.Camera360.guide;

import android.app.Activity;
import android.os.Bundle;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.foundation.d;
import vStudio.Android.Camera360.guide.pageview.GuidePageViewFragment2;
/* loaded from: classes7.dex */
public abstract class GuideFragment extends BaseFragment {
    protected boolean a = false;
    protected Activity b;

    public static GuideFragment a0(int i2, int i3) {
        if (i2 != 1 && i3 >= d.a.f10993d) {
            return new GuidePicFilmFragment();
        }
        return new GuidePageViewFragment2();
    }

    public abstract void b0();

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.a = arguments.getBoolean("directly_to_end", false);
        }
        this.b = getActivity();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b = null;
    }
}
