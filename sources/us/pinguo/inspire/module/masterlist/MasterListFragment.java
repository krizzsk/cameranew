package us.pinguo.inspire.module.masterlist;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.shizhefei.view.indicator.b;
import com.shizhefei.view.viewpager.DurationScroller;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.utils.u;
import us.pinguo.foundation.utils.w;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.masterlist.LoadMoreRecyclerView;
import us.pinguo.inspire.module.masterlist.MasterData;
import us.pinguo.inspire.module.masterlist.MasterListFragment;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.s0;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class MasterListFragment extends SubscriptionFragment implements SwipeRefreshLayout.OnRefreshListener {
    private ViewPager bannerVP;
    private ImageView iv1;
    private ImageView iv2;
    private MasterBindLoader loader;
    private com.shizhefei.view.indicator.b mIndicatorViewPager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ViewPager mViewPager;
    private MyAdapter tabAdapter;
    private CompatibleToolbar toolbar_common;
    private TextView tv_master_apply;
    private long delayTime = 3000;
    private int delayWhat = 0;
    private Map<Integer, String> spMap = new HashMap();
    private Handler mHandler = new Handler() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (MasterListFragment.this) {
                MasterListFragment.this.bannerVP.setCurrentItem(MasterListFragment.this.bannerVP.getCurrentItem() + 1);
                Message obtainMessage = MasterListFragment.this.mHandler.obtainMessage();
                obtainMessage.what = MasterListFragment.this.delayWhat;
                MasterListFragment.this.mHandler.sendMessageDelayed(obtainMessage, MasterListFragment.this.delayTime);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class MyAdapter extends b.d {
        private List<MasterData> masterDatas = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: us.pinguo.inspire.module.masterlist.MasterListFragment$MyAdapter$2  reason: invalid class name */
        /* loaded from: classes9.dex */
        public class AnonymousClass2 implements LoadMoreRecyclerView.LoadMoreListener {
            final /* synthetic */ PageAdpater val$adapter;
            final /* synthetic */ MasterData val$data;
            final /* synthetic */ int val$position;
            final /* synthetic */ LoadMoreRecyclerView val$recyclerView;

            AnonymousClass2(int i2, MasterData masterData, LoadMoreRecyclerView loadMoreRecyclerView, PageAdpater pageAdpater) {
                this.val$position = i2;
                this.val$data = masterData;
                this.val$recyclerView = loadMoreRecyclerView;
                this.val$adapter = pageAdpater;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void b(LoadMoreRecyclerView loadMoreRecyclerView, int i2, PageAdpater pageAdpater, MasterListData masterListData) {
                if (masterListData.getList().size() == 0) {
                    loadMoreRecyclerView.notifyMoreFinish(false);
                    us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai===>没有加载更多", new Object[0]);
                    return;
                }
                us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai===>size=" + masterListData.getList().size(), new Object[0]);
                loadMoreRecyclerView.notifyMoreFinish(true);
                MasterListFragment.this.spMap.put(Integer.valueOf(i2), masterListData.getList().get(0).getSp());
                pageAdpater.setPageData(masterListData.getList().get(0).getList());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void c(LoadMoreRecyclerView loadMoreRecyclerView, Throwable th) {
                loadMoreRecyclerView.notifyMoreFinish(false);
                Inspire.f(th);
                us.pinguo.common.log.a.f(th);
                us.pinguo.user.util.i.b(th);
            }

            @Override // us.pinguo.inspire.module.masterlist.LoadMoreRecyclerView.LoadMoreListener
            public void onLoadMore() {
                us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai===>加载更多", new Object[0]);
                Observable<MasterListData> masterList = MasterListFragment.this.loader.getMasterList((String) MasterListFragment.this.spMap.get(Integer.valueOf(this.val$position)), this.val$data.getType());
                final LoadMoreRecyclerView loadMoreRecyclerView = this.val$recyclerView;
                final int i2 = this.val$position;
                final PageAdpater pageAdpater = this.val$adapter;
                MasterListFragment.this.addSubscription(masterList.subscribe(new Action1() { // from class: us.pinguo.inspire.module.masterlist.g
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        MasterListFragment.MyAdapter.AnonymousClass2.this.b(loadMoreRecyclerView, i2, pageAdpater, (MasterListData) obj);
                    }
                }, new Action1() { // from class: us.pinguo.inspire.module.masterlist.f
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        MasterListFragment.MyAdapter.AnonymousClass2.c(LoadMoreRecyclerView.this, (Throwable) obj);
                    }
                }));
            }
        }

        public MyAdapter() {
        }

        @Override // com.shizhefei.view.indicator.b.d, com.shizhefei.view.indicator.b.e
        public int getCount() {
            List<MasterData> list = this.masterDatas;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public List<MasterData> getData() {
            return this.masterDatas;
        }

        @Override // com.shizhefei.view.indicator.b.d
        public int getItemPosition(Object obj) {
            return -1;
        }

        @Override // com.shizhefei.view.indicator.b.d
        public View getViewForPage(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.master_list_page_layout, viewGroup, false);
            }
            LoadMoreRecyclerView loadMoreRecyclerView = (LoadMoreRecyclerView) view.findViewById(R.id.recyclerView_res_0x7d0601ec);
            MasterData masterData = this.masterDatas.get(i2);
            PageAdpater pageAdpater = new PageAdpater(masterData.getList());
            loadMoreRecyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
            linearLayoutManager.setOrientation(1);
            loadMoreRecyclerView.setLayoutManager(linearLayoutManager);
            loadMoreRecyclerView.setAutoLoadMoreEnable(true);
            loadMoreRecyclerView.setAdapter(pageAdpater);
            loadMoreRecyclerView.setLoadMoreListener(new AnonymousClass2(i2, masterData, loadMoreRecyclerView, pageAdpater));
            pageAdpater.notifyDataSetChanged();
            return view;
        }

        @Override // com.shizhefei.view.indicator.b.d
        public View getViewForTab(final int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.master_list_tab_layout, viewGroup, false);
            }
            MasterData masterData = this.masterDatas.get(i2);
            TextView textView = (TextView) view.findViewById(R.id.master_list_tab_title);
            if (!TextUtils.isEmpty(masterData.getName())) {
                textView.setText(masterData.getName());
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.MyAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MasterListFragment.this.mIndicatorViewPager.e(i2, true);
                }
            });
            return view;
        }

        public void setData(List<MasterData> list) {
            this.masterDatas.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AttentionButton attentionButton;
        public ImageView iv_index;
        public PortraitImageView profile_avatar;
        public RelativeLayout rl_container;
        public TextView tv_desc;
        public TextView tv_index;
        public TextView tv_info_hint;
        public TextView tv_name;

        public MyViewHolder(View view) {
            super(view);
            this.tv_name = (TextView) view.findViewById(R.id.tv_name_res_0x7d060259);
            this.tv_desc = (TextView) view.findViewById(R.id.tv_desc);
            this.iv_index = (ImageView) view.findViewById(R.id.iv_index);
            this.tv_index = (TextView) view.findViewById(R.id.tv_index_res_0x7d060254);
            this.profile_avatar = (PortraitImageView) view.findViewById(R.id.profile_avatar_res_0x7d0601c1);
            this.attentionButton = (AttentionButton) view.findViewById(R.id.attentionButton);
            this.rl_container = (RelativeLayout) view.findViewById(R.id.rl_container);
            this.tv_info_hint = (TextView) view.findViewById(R.id.tv_info_hint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class PageAdpater extends RecyclerView.Adapter<MyViewHolder> {
        private List<MasterData.ListBean> beans;
        private int pageCount;

        public PageAdpater(List<MasterData.ListBean> list) {
            this.pageCount = 0;
            this.beans = list;
            this.pageCount = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(MyViewHolder myViewHolder, MasterData.ListBean listBean, View view) {
            PortraitImageView portraitImageView = myViewHolder.profile_avatar;
            PortraitImageView.f(MasterListFragment.this.getContext(), listBean.getUserId());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MasterData.ListBean> list = this.beans;
            if (list == null) {
                this.pageCount = 0;
            } else {
                this.pageCount = list.size();
            }
            return this.pageCount;
        }

        public void setPageData(List<MasterData.ListBean> list) {
            this.beans.addAll(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder myViewHolder, int i2) {
            if (i2 == 0) {
                myViewHolder.tv_info_hint.setVisibility(0);
            } else {
                myViewHolder.tv_info_hint.setVisibility(8);
            }
            final MasterData.ListBean listBean = this.beans.get(i2);
            if (TextUtils.isEmpty(listBean.getNickname())) {
                myViewHolder.tv_name.setVisibility(8);
            } else {
                myViewHolder.tv_name.setVisibility(0);
                myViewHolder.tv_name.setText(listBean.getNickname());
            }
            if (TextUtils.isEmpty(listBean.getDesc())) {
                myViewHolder.tv_desc.setVisibility(8);
            } else {
                myViewHolder.tv_desc.setVisibility(0);
                myViewHolder.tv_desc.setText(listBean.getDesc());
            }
            if (i2 == 0) {
                myViewHolder.tv_index.setVisibility(8);
                myViewHolder.rl_container.setVisibility(0);
                myViewHolder.iv_index.setBackgroundResource(R.drawable.one_icon);
            } else if (i2 == 1) {
                myViewHolder.tv_index.setVisibility(8);
                myViewHolder.rl_container.setVisibility(0);
                myViewHolder.iv_index.setBackgroundResource(R.drawable.two_icon);
            } else if (i2 == 2) {
                myViewHolder.tv_index.setVisibility(8);
                myViewHolder.rl_container.setVisibility(0);
                myViewHolder.iv_index.setBackgroundResource(R.drawable.three_icon);
            } else {
                myViewHolder.tv_index.setVisibility(0);
                myViewHolder.rl_container.setVisibility(8);
                myViewHolder.tv_index.setText(String.valueOf(i2 + 1));
            }
            myViewHolder.profile_avatar.setUserType(listBean.getType());
            myViewHolder.profile_avatar.setMark(listBean.getMark());
            myViewHolder.profile_avatar.setUserId(listBean.getUserId());
            myViewHolder.profile_avatar.setImageUri(listBean.getAvatar(), us.pinguo.ui.R.drawable.default_avatar);
            myViewHolder.attentionButton.setAttentionStyle(new AttentionButton.h() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.PageAdpater.1
                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void animingStyle(AttentionButton attentionButton) {
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void followedStyle(AttentionButton attentionButton) {
                    attentionButton.setBackgroundResource(R.drawable.bg_followed);
                    attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void friendStyle(AttentionButton attentionButton) {
                    attentionButton.setBackgroundResource(R.drawable.bg_friends);
                    attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }

                @Override // us.pinguo.inspire.widget.AttentionButton.h
                public void unFollowedStyle(AttentionButton attentionButton) {
                    attentionButton.setBackgroundResource(R.drawable.bg_unfollow);
                    attentionButton.setTextColor(ViewCompat.MEASURED_SIZE_MASK);
                }
            });
            myViewHolder.attentionButton.k(listBean, true, listBean.getUserId(), MasterListFragment.this);
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.masterlist.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MasterListFragment.PageAdpater.this.f(myViewHolder, listBean, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.master_list_page_item, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(MasterCheckData masterCheckData) {
        us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai===>" + masterCheckData, new Object[0]);
        this.tv_master_apply.setEnabled(true);
        if (masterCheckData.getStatus() == 3) {
            Toast.makeText(getActivity(), (int) R.string.master_apply_btn_text_3, 0).show();
        } else if (masterCheckData.getStatus() == 1) {
            Toast.makeText(getActivity(), (int) R.string.master_wait_info_msg, 0).show();
        } else {
            AppGoto.getInstance().c(Inspire.f11203d + masterCheckData.getGotoUrl() + "?clickUrlInner=1").b(getContext());
        }
    }

    private void apply() {
        us.pinguo.foundation.statistics.l.h(Inspire.a(), "talent_board_banner_register");
        this.tv_master_apply.setEnabled(false);
        addSubscription(this.loader.checkMasterList(s0.getInstance().getUserId()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.masterlist.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MasterListFragment.this.b0((MasterCheckData) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.masterlist.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MasterListFragment.this.d0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(Throwable th) {
        this.tv_master_apply.setEnabled(true);
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelHandler() {
        if (this.mHandler.hasMessages(this.delayWhat)) {
            this.mHandler.removeMessages(this.delayWhat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(View view) {
        if (!s0.getInstance().e()) {
            us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
            s0.getInstance().a(getActivity(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            return;
        }
        apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(AlertDialog alertDialog, MasterListData masterListData) {
        us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai===>" + masterListData.getList().size(), new Object[0]);
        for (int i2 = 0; i2 < masterListData.getList().size(); i2++) {
            this.spMap.put(Integer.valueOf(i2), masterListData.getList().get(i2).getSp());
        }
        this.tabAdapter.setData(masterListData.getList());
        alertDialog.dismiss();
    }

    private void initBanner(View view) {
        View findViewById;
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.master_list_banner_viewPager);
        this.bannerVP = viewPager;
        viewPager.setOffscreenPageLimit(2);
        com.shizhefei.view.viewpager.b bVar = new com.shizhefei.view.viewpager.b() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override // com.shizhefei.view.viewpager.b
            public View getView(int i2, View view2, ViewGroup viewGroup) {
                int i3 = i2 % 2;
                if (view2 == null) {
                    view2 = LayoutInflater.from(MasterListFragment.this.getActivity()).inflate(R.layout.master_list_banner_item, viewGroup, false);
                }
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.container_res_0x7d06006d);
                TextView textView = (TextView) view2.findViewById(R.id.tv_banner_title);
                TextView textView2 = (TextView) view2.findViewById(R.id.tv_banner_desc);
                if (i3 == 0) {
                    textView.setText(MasterListFragment.this.getString(R.string.master_banner_title_one));
                    textView2.setText(MasterListFragment.this.getString(R.string.master_banner_desc_one));
                } else {
                    textView.setText(MasterListFragment.this.getString(R.string.master_banner_title_two));
                    textView2.setText(MasterListFragment.this.getString(R.string.master_banner_desc_two));
                }
                return view2;
            }
        };
        initViewPagerScroll(this.bannerVP);
        this.iv1.setBackgroundResource(R.drawable.master_list_select);
        this.iv2.setBackgroundResource(R.drawable.master_list_unselect);
        this.bannerVP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (i2 % 2 == 0) {
                    MasterListFragment.this.iv1.setBackgroundResource(R.drawable.master_list_select);
                    MasterListFragment.this.iv2.setBackgroundResource(R.drawable.master_list_unselect);
                    return;
                }
                MasterListFragment.this.iv1.setBackgroundResource(R.drawable.master_list_unselect);
                MasterListFragment.this.iv2.setBackgroundResource(R.drawable.master_list_select);
            }
        });
        this.bannerVP.setAdapter(bVar);
        this.bannerVP.setCurrentItem(150);
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = this.delayWhat;
        this.mHandler.sendMessageDelayed(obtainMessage, this.delayTime);
        this.bannerVP.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        Message obtainMessage2 = MasterListFragment.this.mHandler.obtainMessage();
                        obtainMessage2.what = MasterListFragment.this.delayWhat;
                        MasterListFragment.this.mHandler.sendMessageDelayed(obtainMessage2, MasterListFragment.this.delayTime);
                        return false;
                    } else if (action != 2) {
                        Message obtainMessage3 = MasterListFragment.this.mHandler.obtainMessage();
                        obtainMessage3.what = MasterListFragment.this.delayWhat;
                        MasterListFragment.this.mHandler.sendMessageDelayed(obtainMessage3, MasterListFragment.this.delayTime);
                        return false;
                    }
                }
                MasterListFragment.this.cancelHandler();
                return false;
            }
        });
        Locale locale = Locale.getDefault();
        if (!"zh".equals(locale.getLanguage()) || "cn".equalsIgnoreCase(locale.getCountry()) || (findViewById = view.findViewById(R.id.banner_layout)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    private void initPagers(View view) {
        this.mViewPager = (ViewPager) view.findViewById(R.id.master_list_viewpager);
        com.shizhefei.view.indicator.a aVar = (com.shizhefei.view.indicator.a) view.findViewById(R.id.master_list_tab);
        int color = getResources().getColor(us.pinguo.ui.R.color.color_highlight);
        int color2 = getResources().getColor(us.pinguo.ui.R.color.text_deeper);
        com.shizhefei.view.indicator.c.a aVar2 = new com.shizhefei.view.indicator.c.a() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.5
            @Override // com.shizhefei.view.indicator.c.a
            public TextView getTextView(View view2, int i2) {
                return (TextView) view2.findViewById(R.id.master_list_tab_title);
            }
        };
        aVar2.setColor(color, color2);
        aVar.setOnTransitionListener(aVar2);
        aVar.setScrollBar(new com.shizhefei.view.indicator.slidebar.a(getActivity(), color, us.pinguo.foundation.t.b.a.a(getActivity(), 3.0f)));
        this.mViewPager.setOffscreenPageLimit(2);
        this.mIndicatorViewPager = new com.shizhefei.view.indicator.b(aVar, this.mViewPager);
        MyAdapter myAdapter = new MyAdapter();
        this.tabAdapter = myAdapter;
        this.mIndicatorViewPager.d(myAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: us.pinguo.inspire.module.masterlist.MasterListFragment.6
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
                us.pinguo.common.log.a.m("chenxiaokai", "chenxiaokai position=" + i2 + ",positionOffset=" + f2 + ",positionOffsetPixels=" + i3, new Object[0]);
                if (i2 == 0 && f2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    Context a = Inspire.a();
                    us.pinguo.foundation.statistics.l.i(a, "talent_category_view", "type=" + MasterListFragment.this.tabAdapter.getData().get(i2).getType());
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (i2 != 0) {
                    Context a = Inspire.a();
                    us.pinguo.foundation.statistics.l.i(a, "talent_category_view", "type=" + MasterListFragment.this.tabAdapter.getData().get(i2).getType());
                }
            }
        });
    }

    private void initViewPagerScroll(ViewPager viewPager) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(viewPager, new DurationScroller(viewPager.getContext()));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k0(AlertDialog alertDialog, Throwable th) {
        alertDialog.dismiss();
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        us.pinguo.user.util.i.b(th);
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "talent_board_view";
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.master_list_fragment, viewGroup, false);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        cancelHandler();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        this.mSwipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.mSwipeRefreshLayout.setEnabled(false);
        this.iv1 = (ImageView) view.findViewById(R.id.iv1);
        this.iv2 = (ImageView) view.findViewById(R.id.iv2);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) view.findViewById(us.pinguo.user.R.id.toolbar_common);
        this.toolbar_common = compatibleToolbar;
        Toolbar b = compatibleToolbar.b();
        b.setBackgroundColor(-1);
        b.setTitleTextColor(getResources().getColor(us.pinguo.foundation.R.color.light_main_title_text));
        b.setTitleTextAppearance(getActivity(), us.pinguo.user.R.style.ToolBar_TextSize);
        b.setTitle(getString(R.string.master_list_enter));
        b.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        b.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.masterlist.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MasterListFragment.this.f0(view2);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.tv_master_apply);
        this.tv_master_apply = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.masterlist.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MasterListFragment.this.h0(view2);
            }
        });
        if (u.c()) {
            this.tv_master_apply.setVisibility(8);
        }
        initBanner(view);
        initPagers(view);
        this.loader = new MasterBindLoader();
        final AlertDialog p = w.p(getContext(), R.string.master_waiting_text);
        p.setCancelable(true);
        if (p.isShowing()) {
            p.dismiss();
        }
        addSubscription(this.loader.getMasterList().subscribe(new Action1() { // from class: us.pinguo.inspire.module.masterlist.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MasterListFragment.this.j0(p, (MasterListData) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.masterlist.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MasterListFragment.k0(AlertDialog.this, (Throwable) obj);
            }
        }));
    }
}
