package us.pinguo.inspire.module.master;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import rx.functions.Action1;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.foundation.proxy.ILoginProxy;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.ui.ViewPagerScroll;
import us.pinguo.foundation.utils.w;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.profile.ProfileEntry;
import us.pinguo.inspire.module.profile.ProfileLoader;
import us.pinguo.ui.widget.banner.DrawableIndicator;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.s0;
import us.pinguo.user.v0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MasterFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private Button mButtonApplyFor;
    private DrawableIndicator mIndicator;
    private ViewPager mViewPager;
    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() { // from class: us.pinguo.inspire.module.master.MasterFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (MasterFragment.this.isResumed() && MasterFragment.this.isVisible()) {
                MasterFragment.this.mViewPager.setCurrentItem((MasterFragment.this.mViewPager.getCurrentItem() + 1) % MasterFragment.this.mViewPager.getAdapter().getCount(), true);
                MasterFragment masterFragment = MasterFragment.this;
                masterFragment.mHandler.postDelayed(masterFragment.runnable, 3000L);
            }
        }
    };

    /* loaded from: classes9.dex */
    class MyAdapter extends PagerAdapter {
        int[] icons = {R.drawable.master_01, R.drawable.master_02, R.drawable.master_03};
        int[] title = {R.string.master_apply_page_title_1, R.string.master_apply_page_title_2, R.string.master_apply_page_title_3};
        int[] msg = {R.string.master_apply_page_msg_1, R.string.master_apply_page_msg_2, R.string.master_apply_page_msg_3};

        MyAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View inflate = MasterFragment.this.getActivity().getLayoutInflater().inflate(R.layout.master_viewpage_item, viewGroup, false);
            ((ImageView) inflate.findViewById(R.id.master_item_iv)).setImageResource(this.icons[i2]);
            ((TextView) inflate.findViewById(R.id.master_item_tv1)).setText(this.title[i2]);
            ((TextView) inflate.findViewById(R.id.master_item_tv2)).setText(this.msg[i2]);
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchMaterState() {
        ILoginProxy s0Var = s0.getInstance();
        final AlertDialog p = w.p(getContext(), R.string.master_waiting_text);
        p.setCancelable(false);
        MasterApi.checkExpert(s0Var.getUserId()).subscribe(new Action1<Integer>() { // from class: us.pinguo.inspire.module.master.MasterFragment.4
            @Override // rx.functions.Action1
            public void call(Integer num) {
                p.dismiss();
                MasterFragment.this.updateUiForMaster(num);
            }
        }, e.a);
    }

    private void initUi() {
        new ProfileLoader().getProfileFromDiskCache().subscribe(new Action1<ProfileEntry>() { // from class: us.pinguo.inspire.module.master.MasterFragment.3
            @Override // rx.functions.Action1
            public void call(ProfileEntry profileEntry) {
                ProfileAuthorInfo profileAuthorInfo;
                if (profileEntry != null && (profileAuthorInfo = profileEntry.authorInfo) != null && profileAuthorInfo.type == 1) {
                    MasterFragment.this.updateUiForMaster(3);
                } else if (s0.getInstance().e()) {
                    MasterFragment.this.fetchMaterState();
                }
            }
        }, f.a);
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "master_intro_page";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_master, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mViewPager.removeOnPageChangeListener(this);
        super.onDestroyView();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.mIndicator.setCurrentItem(i2);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mHandler.postDelayed(this.runnable, 3000L);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mViewPager = (ViewPager) view.findViewById(R.id.master_view_pager);
        new ViewPagerScroll(getActivity()).a(this.mViewPager);
        this.mButtonApplyFor = (Button) view.findViewById(R.id.master_btn_apply_for);
        DrawableIndicator drawableIndicator = (DrawableIndicator) view.findViewById(R.id.master_indicator);
        this.mIndicator = drawableIndicator;
        drawableIndicator.setCellDrawable(getResources().getDrawable(R.drawable.master_indicator), getResources().getDrawable(R.drawable.master_indicator_on));
        ((MasterActivity) getActivity()).updateUIForMaterFragment();
        this.mViewPager.setAdapter(new MyAdapter());
        this.mIndicator.setCellCount(this.mViewPager.getAdapter().getCount());
        this.mViewPager.addOnPageChangeListener(this);
        this.mButtonApplyFor.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.master.MasterFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                l.h(Inspire.a(), "master_apply_entry_click");
                if (s0.getInstance().e()) {
                    FragmentTransaction beginTransaction = MasterFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                    beginTransaction.replace(R.id.master_apply_for_fragment_container, new MasterApplyFragment());
                    beginTransaction.commit();
                    return;
                }
                v0.h(MasterFragment.this.getActivity(), 7070, -999, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            }
        });
        initUi();
    }

    public void updateUiForMaster(Integer num) {
        this.mButtonApplyFor.setEnabled(num.intValue() == 0 || num.intValue() == 2);
        int intValue = num.intValue();
        if (intValue == 0) {
            this.mButtonApplyFor.setText(R.string.master_apply_btn_text_0);
        } else if (intValue == 1) {
            this.mButtonApplyFor.setText(R.string.master_apply_btn_text_1);
            this.mButtonApplyFor.setAlpha(0.4f);
        } else if (intValue == 2) {
            this.mButtonApplyFor.setText(R.string.master_apply_btn_text_2);
        } else if (intValue != 3) {
        } else {
            this.mButtonApplyFor.setText(R.string.master_apply_btn_text_3);
            this.mButtonApplyFor.setAlpha(0.4f);
        }
    }
}
