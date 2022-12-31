package vStudio.Android.Camera360.guide.pageview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.util.p;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.guide.GuideFragment;
/* compiled from: GuidePageViewFragment2.kt */
/* loaded from: classes7.dex */
public final class GuidePageViewFragment2 extends GuideFragment {
    public Map<Integer, View> c = new LinkedHashMap();

    private final GuideFragment c0() {
        if (Conditions.e()) {
            if (p.a.f()) {
                return new PayWallGuideFragment();
            }
            return new NormalGuideFragment();
        }
        return new NormalGuideFragment();
    }

    public void _$_clearFindViewByIdCache() {
        this.c.clear();
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment
    public void b0() {
        if (isAdded()) {
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("guide");
            GuideFragment guideFragment = findFragmentByTag instanceof GuideFragment ? (GuideFragment) findFragmentByTag : null;
            if (guideFragment != null && guideFragment.isAdded() && us.pinguo.edit2020.utils.d.d(guideFragment.getActivity())) {
                guideFragment.b0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        Context requireContext = requireContext();
        s.g(requireContext, "requireContext()");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(requireContext);
        fragmentContainerView.setId(R.id.fragment_container);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("guide");
        if (findFragmentByTag != null && (findFragmentByTag instanceof GuideFragment)) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            FragmentTransaction replace = beginTransaction.replace(R.id.fragment_container, findFragmentByTag, "guide");
            VdsAgent.onFragmentTransactionReplace(beginTransaction, R.id.fragment_container, findFragmentByTag, "guide", replace);
            replace.commitAllowingStateLoss();
        } else {
            GuideFragment c0 = c0();
            FragmentTransaction beginTransaction2 = getChildFragmentManager().beginTransaction();
            FragmentTransaction add = beginTransaction2.add(R.id.fragment_container, c0, "guide");
            VdsAgent.onFragmentTransactionAdd(beginTransaction2, R.id.fragment_container, c0, "guide", add);
            add.commitAllowingStateLoss();
        }
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
