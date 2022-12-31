package us.pinguo.inspire.module.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.challenge.ChallengeTabUnread;
import us.pinguo.inspire.module.comment.FeedsRecFragment;
import us.pinguo.inspire.module.discovery.cell.ChallengeListPhotoCell;
import us.pinguo.inspire.module.discovery.fragment.DiscoverySquareFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChallengeTabFragment extends SubscriptionFragment implements us.pinguo.librouter.module.inspire.c, ViewPager.OnPageChangeListener, TabLayout.d, ChallengeTabUnread.OnNewTaskListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabLayout.f[] mTabs = new TabLayout.f[2];
    private us.pinguo.librouter.module.inspire.c[] mFragments = new us.pinguo.librouter.module.inspire.c[2];
    private int[] titleRes = {R.string.challenge_rec, R.string.home_inspire_title};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class FeedsPagerAdapter extends FragmentPagerAdapter {
        public FeedsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ChallengeTabFragment.this.mFragments.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return ChallengeTabFragment.this.mFragments[i2].getFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private void checkAction() {
        int i2 = us.pinguo.foundation.proxy.b.c;
        if (i2 >= 0) {
            TabLayout.f[] fVarArr = this.mTabs;
            if (i2 < fVarArr.length) {
                TabLayout.f fVar = fVarArr[i2];
                if (fVar != null && !fVar.j()) {
                    fVar.l();
                }
                us.pinguo.foundation.proxy.b.c = -1;
            }
        }
    }

    private void initPagers() {
        this.mFragments[0] = new FeedsRecFragment();
        Bundle bundle = new Bundle();
        bundle.putAll(getArguments());
        bundle.putString("feed_detail_from", "from_rec");
        this.mFragments[0].getFragment().setArguments(bundle);
        this.mFragments[1] = new DiscoverySquareFragment();
        this.mViewPager.setAdapter(new FeedsPagerAdapter(getChildFragmentManager()));
    }

    private void initTab() {
        this.mTabLayout.setupWithViewPager(this.mViewPager);
        this.mTabLayout.setTabMode(1);
        this.mTabLayout.d(this);
        this.mTabs[0] = this.mTabLayout.z(0);
        this.mTabs[0].o(getTabView(0));
        this.mTabs[1] = this.mTabLayout.z(1);
        this.mTabs[1].o(getTabView(1));
        LinearLayout linearLayout = (LinearLayout) this.mTabLayout.getChildAt(0);
        linearLayout.setShowDividers(2);
        linearLayout.setDividerDrawable(new ChallengeTabDivider());
        if (getArguments() != null && getArguments().getBoolean("challenge_list")) {
            this.mTabs[1].l();
            us.pinguo.librouter.module.inspire.c[] cVarArr = this.mFragments;
            if (cVarArr[0] instanceof FeedsRecFragment) {
                ((FeedsRecFragment) cVarArr[0]).setNoAutoPlay();
                this.mFragments[1].onSelected();
                return;
            }
            return;
        }
        this.mTabs[0].l();
        this.mFragments[0].onSelected();
    }

    public RecyclerView checkScrollTo(InspireWork inspireWork) {
        if (this.mTabs[0].j()) {
            return ((DiscoverySquareFragment) this.mFragments[0].getFragment()).checkScrollTo(inspireWork);
        }
        return null;
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void clearNewStatus() {
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.clearNewStatus();
        }
    }

    public View getChangedShareElementByWork(InspireWork inspireWork) {
        ChallengeListPhotoCell shareElementByWork;
        if (inspireWork == null || this.mTabs[0].j() || !this.mTabs[1].j() || (shareElementByWork = ((DiscoverySquareFragment) this.mFragments[0].getFragment()).getShareElementByWork(inspireWork)) == null) {
            return null;
        }
        return shareElementByWork.getChangedShareElement();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public Fragment getFragment() {
        return this;
    }

    public boolean getNewStatus() {
        return false;
    }

    public View getTabView(int i2) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.challenge_tab_layout, (ViewGroup) this.mTabLayout, false);
        ((TextView) relativeLayout.findViewById(R.id.feeds_tab_txt)).setText(this.titleRes[i2]);
        if (i2 == 1) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.feeds_tab_point);
            ChallengeTabUnread challengeTabUnread = ChallengeTabUnread.INSTANCE;
            int unread = challengeTabUnread.getUnread();
            if (unread > 0) {
                textView.setText(String.valueOf(unread));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            challengeTabUnread.setOnNewTaskListener(this);
            relativeLayout.setGravity(19);
        }
        return relativeLayout;
    }

    public void handleSharePreprocessResult() {
        FeedsRecFragment feedsRecFragment = (FeedsRecFragment) this.mFragments[0];
        if (feedsRecFragment != null) {
            feedsRecFragment.handleSharePreprocessResult();
        }
    }

    protected void initTitle(View view) {
        view.findViewById(R.id.challenge_tab_title_layout).findViewById(R.id.challenge_back).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.challenge.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChallengeTabFragment.this.b0(view2);
            }
        });
        initTab();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onAdvDataChange() {
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.onAdvDataChange();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public boolean onBackPressed() {
        if (this.mTabs[0].j()) {
            return this.mFragments[0].onBackPressed();
        }
        if (this.mTabs[1].j()) {
            return this.mFragments[1].onBackPressed();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.challenge_tab_fragment, viewGroup, false);
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ChallengeTabUnread.INSTANCE.setOnNewTaskListener(null);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogin() {
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.onLogin();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onLogout() {
        if (this.mTabs[1].j()) {
            this.mTabs[0].l();
        }
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.onLogout();
        }
    }

    public void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("challenge_list") && (this.mFragments[0].getFragment() instanceof FeedsRecFragment)) {
            if (intent.getBooleanExtra("challenge_list", false)) {
                this.mTabs[1].l();
                return;
            }
            this.mFragments[0].getFragment().setArguments(intent.getExtras());
            this.mTabs[0].l();
            ((FeedsRecFragment) this.mFragments[0].getFragment()).triggerRefresh();
        }
    }

    @Override // us.pinguo.inspire.module.challenge.ChallengeTabUnread.OnNewTaskListener
    public void onNewTask() {
        if (this.mViewPager.getCurrentItem() == 0) {
            TextView textView = (TextView) this.mTabs[1].e().findViewById(R.id.feeds_tab_point);
            int unread = ChallengeTabUnread.INSTANCE.getUnread();
            if (unread > 0) {
                textView.setText(String.valueOf(unread));
                textView.setVisibility(0);
                if (this.mFragments[0].getFragment() instanceof FeedsRecFragment) {
                    ((FeedsRecFragment) this.mFragments[0].getFragment()).checkShowCameraToast();
                    return;
                }
                return;
            }
            textView.setVisibility(8);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (i2 == 0) {
            this.mFragments[0].onSelected();
            this.mFragments[1].onUnSelected();
            return;
        }
        this.mFragments[0].onUnSelected();
        this.mFragments[1].onSelected();
    }

    public void onPublishSuccess() {
        TabLayout.f[] fVarArr = this.mTabs;
        if (fVarArr[1] == null || fVarArr[1].j()) {
            return;
        }
        this.mTabs[1].l();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkAction();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onSelected() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null) {
            return;
        }
        this.mFragments[viewPager.getCurrentItem()].onSelected();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onTabClickWhenSelected() {
        int i2 = 0;
        while (true) {
            TabLayout.f[] fVarArr = this.mTabs;
            if (i2 >= fVarArr.length) {
                return;
            }
            if (fVarArr[i2].j()) {
                this.mFragments[i2].onTabClickWhenSelected();
            }
            i2++;
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.f fVar) {
        ((TextView) fVar.e().findViewById(R.id.feeds_tab_txt)).animate().scaleX(1.15f).scaleY(1.15f).setDuration(200L).start();
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.f fVar) {
        ((TextView) fVar.e().findViewById(R.id.feeds_tab_txt)).animate().scaleX(1.15f).scaleY(1.15f).alpha(1.0f).setDuration(200L).start();
        if (fVar == this.mTabs[1]) {
            ChallengeTabUnread.INSTANCE.clearUnread();
            ((TextView) fVar.e().findViewById(R.id.feeds_tab_point)).setVisibility(8);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.f fVar) {
        ((TextView) fVar.e().findViewById(R.id.feeds_tab_txt)).animate().scaleX(1.0f).scaleY(1.0f).alpha(0.6f).setDuration(200L).start();
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void onUnSelected() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null) {
            return;
        }
        this.mFragments[viewPager.getCurrentItem()].onUnSelected();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mTabLayout = (TabLayout) view.findViewById(R.id.challenge_tab_layout);
        this.mViewPager = (ViewPager) view.findViewById(R.id.challenge_viewpager);
        initPagers();
        initTitle(view);
        this.mViewPager.addOnPageChangeListener(this);
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void releaseResource() {
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.releaseResource();
        }
    }

    @Override // us.pinguo.librouter.module.inspire.c
    public void reloadResource() {
        for (us.pinguo.librouter.module.inspire.c cVar : this.mFragments) {
            cVar.reloadResource();
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected boolean useDefaultPageStatistic() {
        return false;
    }
}
