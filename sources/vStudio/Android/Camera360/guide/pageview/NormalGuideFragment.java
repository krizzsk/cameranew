package vStudio.Android.Camera360.guide.pageview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.foundation.ui.ViewPagerScroll;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.util.h;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
import vStudio.Android.Camera360.guide.GuideFragment;
import vStudio.Android.Camera360.guide.view.IndicatorView2;
/* compiled from: NormalGuideFragment.kt */
/* loaded from: classes7.dex */
public final class NormalGuideFragment extends GuideFragment implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private e f12611d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager2 f12612e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12613f;

    /* renamed from: g  reason: collision with root package name */
    private int f12614g;

    /* renamed from: k  reason: collision with root package name */
    private int f12618k;

    /* renamed from: l  reason: collision with root package name */
    private vStudio.Android.Camera360.guide.pageview.c f12619l;
    public Map<Integer, View> c = new LinkedHashMap();

    /* renamed from: h  reason: collision with root package name */
    private final int f12615h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final long f12616i = 2500;

    /* renamed from: j  reason: collision with root package name */
    private d f12617j = new d();

    /* compiled from: NormalGuideFragment.kt */
    /* loaded from: classes7.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
        }
    }

    /* compiled from: NormalGuideFragment.kt */
    /* loaded from: classes7.dex */
    public final class b extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ NormalGuideFragment a;

        public b(NormalGuideFragment this$0) {
            s.h(this$0, "this$0");
            this.a = this$0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            this.a.f12614g = i2;
            if (this.a.f12614g < 2) {
                this.a.j0();
            }
            IndicatorView2 indicatorView2 = (IndicatorView2) this.a._$_findCachedViewById(R.id.indicator);
            if (indicatorView2 == null) {
                return;
            }
            indicatorView2.selectIndex(i2);
        }
    }

    /* compiled from: NormalGuideFragment.kt */
    /* loaded from: classes7.dex */
    public final class c extends RecyclerView.Adapter<a> {
        private final List<vStudio.Android.Camera360.guide.pageview.d> a;

        public c(NormalGuideFragment this$0, List<vStudio.Android.Camera360.guide.pageview.d> guidePageDrawables) {
            s.h(this$0, "this$0");
            s.h(guidePageDrawables, "guidePageDrawables");
            this.a = guidePageDrawables;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public void onBindViewHolder(a holder, int i2) {
            s.h(holder, "holder");
            View view = holder.itemView;
            vStudio.Android.Camera360.guide.pageview.d dVar = this.a.get(i2);
            ((ImageView) view.findViewById(R.id.iv_welcome_bg)).setImageResource(dVar.a());
            ((ImageView) view.findViewById(R.id.iv_welcome_text)).setImageResource(dVar.b());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public a onCreateViewHolder(ViewGroup parent, int i2) {
            s.h(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_page_item, parent, false);
            s.g(view, "view");
            return new a(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    /* compiled from: NormalGuideFragment.kt */
    /* loaded from: classes7.dex */
    public static final class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ViewPager2 viewPager2;
            s.h(msg, "msg");
            if (msg.what == NormalGuideFragment.this.f12615h) {
                if ((NormalGuideFragment.this.f12614g == 0 || NormalGuideFragment.this.f12614g == 1) && (viewPager2 = NormalGuideFragment.this.f12612e) != null) {
                    viewPager2.setCurrentItem(NormalGuideFragment.this.f12614g + 1);
                }
            }
        }
    }

    private final float h0() {
        Context b2 = us.pinguo.foundation.e.b();
        s.g(b2, "getAppContext()");
        int g2 = h.g(b2);
        Context b3 = us.pinguo.foundation.e.b();
        s.g(b3, "getAppContext()");
        return g2 / h.i(b3);
    }

    private final void i0(View view) {
        this.f12612e = (ViewPager2) view.findViewById(R.id.guideViewPager);
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mScroller");
            s.g(declaredField, "ViewPager2::class.java.g…eclaredField(\"mScroller\")");
            declaredField.setAccessible(true);
            ViewPagerScroll viewPagerScroll = new ViewPagerScroll(view.getContext(), new AccelerateInterpolator());
            declaredField.set(this.f12612e, viewPagerScroll);
            viewPagerScroll.b(IjkMediaCodecInfo.RANK_SECURE);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = R.id.guideViewPager;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i2);
        vStudio.Android.Camera360.guide.pageview.c cVar = this.f12619l;
        if (cVar != null) {
            viewPager2.setAdapter(new c(this, cVar.a()));
            ((ViewPager2) view.findViewById(i2)).registerOnPageChangeCallback(new b(this));
            ((IndicatorView2) view.findViewById(R.id.indicator)).selectIndex(0);
            this.f12614g = 0;
            return;
        }
        s.z("guideImageControl");
        throw null;
    }

    public void _$_clearFindViewByIdCache() {
        this.c.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.c;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment
    public void b0() {
        e eVar = this.f12611d;
        if (eVar != null) {
            eVar.c(false);
            e eVar2 = this.f12611d;
            if (eVar2 == null) {
                s.z("guideModel");
                throw null;
            } else if (eVar2.e()) {
                FragmentActivity activity = getActivity();
                if (this.f12613f || activity == null) {
                    return;
                }
                us.pinguo.foundation.l.c.b(activity, new NormalGuideFragment$updateFinish$1(this), getResources().getInteger(R.integer.mb_animation));
                return;
            } else {
                return;
            }
        }
        s.z("guideModel");
        throw null;
    }

    public final void j0() {
        this.f12617j.removeMessages(this.f12615h);
        this.f12617j.sendEmptyMessageDelayed(this.f12615h, this.f12616i);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        us.pinguo.foundation.statistics.h.a.B0("welcome_page", "click");
        e eVar = this.f12611d;
        if (eVar == null) {
            s.z("guideModel");
            throw null;
        } else if (eVar.b()) {
            e eVar2 = this.f12611d;
            if (eVar2 != null) {
                eVar2.d(true);
            } else {
                s.z("guideModel");
                throw null;
            }
        } else {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            us.pinguo.foundation.l.c.b(activity, new NormalGuideFragment$onClick$1(this), getResources().getInteger(R.integer.mb_animation));
        }
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type vStudio.Android.Camera360.GuideControl.GuideActionListener");
        this.f12611d = new e((a.InterfaceC0470a) activity, this.a);
        this.f12613f = false;
        l.d(n0.a(z0.c()), null, null, new NormalGuideFragment$onCreate$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        View fragmentView = inflater.inflate(R.layout.fragment_guide_page_view, (ViewGroup) null);
        this.f12619l = new vStudio.Android.Camera360.guide.pageview.c();
        s.g(fragmentView, "fragmentView");
        i0(fragmentView);
        ((AlphaPressedConstraintLayout) fragmentView.findViewById(R.id.startBtn)).setOnClickListener(this);
        us.pinguo.foundation.statistics.h.a.B0("welcome_page", "show");
        return fragmentView;
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f12613f = true;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Window window;
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.clearFlags(128);
        }
        this.f12617j.removeMessages(this.f12615h);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(128);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        super.onViewCreated(view, bundle);
        float f2 = 0.18f;
        if (h0() > 2.0777779f) {
            f2 = 0.24f;
        } else if (h0() > 1.7777778f) {
            f2 = 0.22f;
        } else if (h0() == 1.7777778f) {
        }
        this.f12618k = (int) (us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b()) * f2);
        ConstraintLayout alphaContainer = (ConstraintLayout) _$_findCachedViewById(R.id.alphaContainer);
        s.g(alphaContainer, "alphaContainer");
        ViewGroup.LayoutParams layoutParams = alphaContainer.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.f12618k;
        alphaContainer.setLayoutParams(layoutParams2);
    }
}
