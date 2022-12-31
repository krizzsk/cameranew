package us.pinguo.camera2020.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.camera2020.view.adapter.t;
import us.pinguo.common.EventType;
import us.pinguo.common.h;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.database.sticker.StickerCategory;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: StickerViewController.kt */
/* loaded from: classes3.dex */
public final class StickerViewController implements us.pinguo.common.h, us.pinguo.common.g {
    private final CameraStickerModule a;
    private final StickerLayout b;
    private final LifecycleOwner c;

    /* renamed from: d  reason: collision with root package name */
    private StickerManagerLayout f9307d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9308e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9309f;

    /* renamed from: g  reason: collision with root package name */
    private int f9310g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9311h;

    /* renamed from: i  reason: collision with root package name */
    private String f9312i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9313j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f9314k;

    /* renamed from: l  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> f9315l;
    private kotlin.jvm.b.a<? extends ArrayList<String>> m;
    private StickerCategory n;

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public enum StickerGotoSource {
        URL,
        FRESH_STICKER_USER,
        RESTORE
    }

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        final /* synthetic */ CameraStickerModule a;
        final /* synthetic */ StickerViewController b;

        a(CameraStickerModule cameraStickerModule, StickerViewController stickerViewController) {
            this.a = cameraStickerModule;
            this.b = stickerViewController;
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            this.a.M(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (kotlin.jvm.internal.s.c(this.a.r().getValue(), "filter")) {
                this.b.a.H(i2 / 100.0f);
            } else if (kotlin.jvm.internal.s.c(this.a.r().getValue(), "makeup")) {
                this.a.I(i2 / 100.0f);
            }
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public static final class b implements TabLayout.d {
        final /* synthetic */ List<StickerCategory> a;
        final /* synthetic */ StickerViewController b;
        final /* synthetic */ ColorMatrixColorFilter c;

        b(List<StickerCategory> list, StickerViewController stickerViewController, ColorMatrixColorFilter colorMatrixColorFilter) {
            this.a = list;
            this.b = stickerViewController;
            this.c = colorMatrixColorFilter;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            View e2 = tab.e();
            if (e2 == null) {
                return;
            }
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) e2.findViewById(R.id.imgCategoryIcon);
            simpleDraweeView.e().s(null);
            int g2 = tab.g();
            if (g2 == 0) {
                simpleDraweeView.setActualImageResource(R.drawable.ic_sticker_recent);
            } else {
                simpleDraweeView.setImageURI(this.a.get(g2).getIcon());
            }
            this.b.n = this.a.get(g2);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            View e2 = tab.e();
            if (e2 == null) {
                return;
            }
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) e2.findViewById(R.id.imgCategoryIcon);
            simpleDraweeView.e().s(null);
            int g2 = tab.g();
            if (g2 == 0) {
                simpleDraweeView.setActualImageResource(R.drawable.ic_sticker_recent);
            } else {
                simpleDraweeView.setImageURI(this.a.get(g2).getIcon());
            }
            this.b.n = this.a.get(g2);
            Boolean bool = this.b.f9314k;
            if (bool != null) {
                us.pinguo.foundation.statistics.h.b.I(this.a.get(g2).getTopic_id(), bool.booleanValue() ? "slide" : "click");
            }
            this.b.f9314k = Boolean.FALSE;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            View e2 = tab.e();
            if (e2 == null) {
                return;
            }
            ((SimpleDraweeView) e2.findViewById(R.id.imgCategoryIcon)).e().s(this.c);
        }
    }

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public static final class c implements ViewPager.OnPageChangeListener {
        final /* synthetic */ ViewPager b;
        final /* synthetic */ CameraStickerModule c;

        c(ViewPager viewPager, CameraStickerModule cameraStickerModule) {
            this.b = viewPager;
            this.c = cameraStickerModule;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (i2 == 1) {
                StickerViewController.this.f9314k = Boolean.TRUE;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            RecyclerView recyclerView;
            PagerAdapter adapter = this.b.getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type us.pinguo.camera2020.view.adapter.CategoryPagerAdapter");
            us.pinguo.camera2020.view.adapter.k kVar = (us.pinguo.camera2020.view.adapter.k) adapter;
            if (i2 == 0) {
                List<Sticker> q = this.c.q("recent_");
                if (q == null || (recyclerView = kVar.a().get(0)) == null) {
                    return;
                }
                RecyclerView.ItemDecoration itemDecorationAt = recyclerView.getItemDecorationAt(0);
                us.pinguo.camera2020.view.adapter.s sVar = itemDecorationAt instanceof us.pinguo.camera2020.view.adapter.s ? (us.pinguo.camera2020.view.adapter.s) itemDecorationAt : null;
                if (sVar != null) {
                    sVar.a((int) Math.ceil((q.size() + 1) * 0.2f));
                }
                kVar.b(0, q);
            }
            RecyclerView recyclerView2 = kVar.a().get(i2);
            RecyclerView.Adapter adapter2 = recyclerView2 == null ? null : recyclerView2.getAdapter();
            us.pinguo.camera2020.view.adapter.u uVar = adapter2 instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter2 : null;
            if (uVar == null) {
                return;
            }
            Sticker value = this.c.u().getValue();
            uVar.q(value == null ? null : value.getPid(), null);
        }
    }

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public static final class d implements t.a {
        final /* synthetic */ us.pinguo.camera2020.view.adapter.t a;
        final /* synthetic */ Ref$ObjectRef<StickerManagerLayout> b;
        final /* synthetic */ Context c;

        d(us.pinguo.camera2020.view.adapter.t tVar, Ref$ObjectRef<StickerManagerLayout> ref$ObjectRef, Context context) {
            this.a = tVar;
            this.b = ref$ObjectRef;
            this.c = context;
        }

        @Override // us.pinguo.camera2020.view.adapter.t.a
        public void a(t.b holder, int i2, String stickerId) {
            kotlin.jvm.internal.s.h(holder, "holder");
            kotlin.jvm.internal.s.h(stickerId, "stickerId");
            LinkedList<Integer> f2 = this.a.f();
            if (f2.contains(Integer.valueOf(i2))) {
                f2.remove(Integer.valueOf(i2));
            } else {
                f2.add(Integer.valueOf(i2));
            }
            TextView textView = (TextView) this.b.element._$_findCachedViewById(R.id.txtDelete);
            TextView textView2 = (TextView) this.b.element._$_findCachedViewById(R.id.txtAll);
            String string = this.c.getString(R.string.delete);
            kotlin.jvm.internal.s.g(string, "context.getString(R.string.delete)");
            if (f2.isEmpty()) {
                textView.setClickable(false);
                textView.setText(string);
                textView.setTextColor(Color.parseColor("#DBDBDB"));
                textView2.setText(R.string.select_all);
            } else {
                textView.setClickable(true);
                textView.setText(string + (char) 65288 + f2.size() + (char) 65289);
                textView.setTextColor(Color.parseColor("#F05853"));
                int size = f2.size();
                List<Sticker> e2 = this.a.e();
                if (size >= (e2 != null ? e2.size() : 1)) {
                    textView2.setText(R.string.deselect_all);
                } else {
                    textView2.setText(R.string.select_all);
                }
            }
            this.a.notifyItemChanged(i2);
        }
    }

    /* compiled from: StickerViewController.kt */
    /* loaded from: classes3.dex */
    public static final class e extends RecyclerView.ItemDecoration {
        final /* synthetic */ Context a;

        e(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            Context context = this.a;
            kotlin.jvm.internal.s.g(context, "context");
            int a = us.pinguo.util.g.a(context, 7.0f);
            outRect.top = a;
            outRect.right = a;
            outRect.bottom = a;
            outRect.left = a;
            if (childAdapterPosition <= 3) {
                Context context2 = this.a;
                kotlin.jvm.internal.s.g(context2, "context");
                outRect.top = us.pinguo.util.g.a(context2, 20.0f);
            }
            int i2 = childAdapterPosition % 4;
            if (i2 == 0) {
                Context context3 = this.a;
                kotlin.jvm.internal.s.g(context3, "context");
                outRect.left = us.pinguo.util.g.a(context3, 16.0f);
            }
            if (i2 == 3) {
                Context context4 = this.a;
                kotlin.jvm.internal.s.g(context4, "context");
                outRect.right = us.pinguo.util.g.a(context4, 16.0f);
            }
        }
    }

    public StickerViewController(CameraStickerModule stickerModule, StickerLayout stickerLayout, LifecycleOwner lifecycleOwner) {
        kotlin.jvm.internal.s.h(stickerModule, "stickerModule");
        kotlin.jvm.internal.s.h(stickerLayout, "stickerLayout");
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        this.a = stickerModule;
        this.b = stickerLayout;
        this.c = lifecycleOwner;
        this.f9310g = us.pinguo.foundation.j.e().i("hairCut", 0);
        K();
        F();
        H();
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(StickerViewController this$0, CameraStickerModule module, StickerLayout layout, String str) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(module, "$module");
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this$0.c), kotlinx.coroutines.z0.b(), null, new StickerViewController$initAdjustBar$1$1(module, str, layout, this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CameraStickerModule module, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(module, "$module");
        module.r().setValue("filter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(CameraStickerModule module, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(module, "$module");
        module.r().setValue("makeup");
    }

    private final void F() {
        kotlin.z.d h2;
        View inflate;
        StickerLayout stickerLayout = this.b;
        Context context = stickerLayout.getContext();
        TabLayout tabLayout = (TabLayout) stickerLayout._$_findCachedViewById(R.id.tabStickerCategory);
        List<StickerCategory> t = this.a.t();
        if (t == null) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        tabLayout.d(new b(t, this, colorMatrixColorFilter));
        tabLayout.setupWithViewPager((ViewPager) stickerLayout._$_findCachedViewById(R.id.pagerStickerCategory));
        h2 = kotlin.z.j.h(0, tabLayout.A());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.h0) it).nextInt();
            TabLayout.f z = tabLayout.z(nextInt);
            if (z != null && (inflate = LayoutInflater.from(context).inflate(R.layout.sticker_tab_item, (ViewGroup) z.f4588h, false)) != null) {
                int i2 = R.id.imgCategoryIcon;
                ((SimpleDraweeView) inflate.findViewById(i2)).e().s(colorMatrixColorFilter);
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(i2);
                if (nextInt == 0) {
                    simpleDraweeView.setActualImageResource(R.drawable.ic_sticker_recent);
                } else {
                    simpleDraweeView.setImageURI(t.get(nextInt).getIcon());
                }
                View findViewById = inflate.findViewById(R.id.categoryRedDot);
                kotlin.jvm.internal.s.g(findViewById, "itemLayout.categoryRedDot");
                int i3 = t.get(nextInt).getHasFreshSticker() ? 0 : 8;
                findViewById.setVisibility(i3);
                VdsAgent.onSetViewVisibility(findViewById, i3);
                z.o(inflate);
                View e2 = z.e();
                View view = (View) (e2 == null ? null : e2.getParent());
                if (view != null) {
                    view.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_common_bg));
                }
            }
        }
        TabLayout.f z2 = tabLayout.z(0);
        if (z2 == null) {
            return;
        }
        z2.l();
    }

    private final void H() {
        final StickerLayout stickerLayout = this.b;
        final CameraStickerModule cameraStickerModule = this.a;
        cameraStickerModule.u().observe(this.c, new Observer() { // from class: us.pinguo.camera2020.view.z0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StickerViewController.I(StickerLayout.this, cameraStickerModule, (Sticker) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(StickerLayout layout, CameraStickerModule module, Sticker sticker) {
        List<RecyclerView> a2;
        RecyclerView recyclerView;
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.h(module, "$module");
        if (sticker == null) {
            ViewPager viewPager = (ViewPager) layout._$_findCachedViewById(R.id.pagerStickerCategory);
            layout.i();
            PagerAdapter adapter = viewPager.getAdapter();
            us.pinguo.camera2020.view.adapter.k kVar = adapter instanceof us.pinguo.camera2020.view.adapter.k ? (us.pinguo.camera2020.view.adapter.k) adapter : null;
            RecyclerView.Adapter adapter2 = (kVar == null || (a2 = kVar.a()) == null || (recyclerView = a2.get(viewPager.getCurrentItem())) == null) ? null : recyclerView.getAdapter();
            us.pinguo.camera2020.view.adapter.u uVar = adapter2 instanceof us.pinguo.camera2020.view.adapter.u ? adapter2 : null;
            if (uVar == null) {
                return;
            }
            uVar.e();
            return;
        }
        module.B();
        module.r().setValue("filter");
        Integer s = module.s("filter");
        module.H((s == null ? 70 : s.intValue()) / 100.0f);
        layout.p();
        ViewPager viewPager2 = (ViewPager) layout._$_findCachedViewById(R.id.pagerStickerCategory);
        PagerAdapter adapter3 = viewPager2.getAdapter();
        Objects.requireNonNull(adapter3, "null cannot be cast to non-null type us.pinguo.camera2020.view.adapter.CategoryPagerAdapter");
        RecyclerView recyclerView2 = ((us.pinguo.camera2020.view.adapter.k) adapter3).a().get(viewPager2.getCurrentItem());
        RecyclerView.Adapter adapter4 = recyclerView2 == null ? null : recyclerView2.getAdapter();
        us.pinguo.camera2020.view.adapter.u uVar2 = adapter4 instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter4 : null;
        if (uVar2 == null) {
            return;
        }
        uVar2.q(sticker.getPid(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.StickerViewController.K():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(StickerViewController this$0, ViewPager viewPager, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f9313j) {
            return;
        }
        viewPager.setCurrentItem(i2);
    }

    private final void b0() {
        kotlin.z.d h2;
        View e2;
        TabLayout tabLayout = (TabLayout) this.b._$_findCachedViewById(R.id.tabStickerCategory);
        List<StickerCategory> t = this.a.t();
        if (t == null) {
            return;
        }
        h2 = kotlin.z.j.h(0, Math.min(t.size(), tabLayout.A()));
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.h0) it).nextInt();
            if (!t.get(nextInt).getHasFreshSticker()) {
                TabLayout.f z = tabLayout.z(nextInt);
                View view = null;
                if (z != null && (e2 = z.e()) != null) {
                    view = e2.findViewById(R.id.categoryRedDot);
                }
                if (view != null) {
                    view.setVisibility(8);
                    VdsAgent.onSetViewVisibility(view, 8);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v100, types: [T, us.pinguo.camera2020.view.StickerManagerLayout] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, us.pinguo.camera2020.view.StickerManagerLayout] */
    private final void f0() {
        final List<Sticker> W;
        us.pinguo.foundation.statistics.f.d("camerafragment");
        us.pinguo.foundation.statistics.f.f("delete_sticker_page");
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f9315l;
        if (lVar != null) {
            lVar.invoke(Boolean.TRUE);
        }
        final CameraStickerModule cameraStickerModule = this.a;
        final Context context = this.b.getContext();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r0 = this.f9307d;
        ref$ObjectRef.element = r0;
        if (r0 == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.sticker_manager_layout, (ViewGroup) null, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.camera2020.view.StickerManagerLayout");
            ?? r02 = (StickerManagerLayout) inflate;
            ref$ObjectRef.element = r02;
            this.f9307d = (StickerManagerLayout) r02;
            int i2 = R.id.viewHeader;
            View _$_findCachedViewById = ((StickerManagerLayout) r02)._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(_$_findCachedViewById, "layout.viewHeader");
            int i3 = this.f9310g > 0 ? 0 : 8;
            _$_findCachedViewById.setVisibility(i3);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, i3);
            View _$_findCachedViewById2 = ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(_$_findCachedViewById2, "layout.viewHeader");
            ViewGroup.LayoutParams layoutParams = _$_findCachedViewById2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = this.f9310g;
            _$_findCachedViewById2.setLayoutParams(layoutParams2);
            RecyclerView recyclerView = (RecyclerView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.rvStickers);
            us.pinguo.camera2020.view.adapter.t tVar = new us.pinguo.camera2020.view.adapter.t();
            tVar.k(new d(tVar, ref$ObjectRef, context));
            recyclerView.setAdapter(tVar);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
            recyclerView.addItemDecoration(new e(context));
        }
        List<Sticker> q = cameraStickerModule.q("recent_");
        if (q == null) {
            q = new ArrayList<>();
        }
        W = kotlin.collections.c0.W(q);
        if (W.isEmpty()) {
            TextView textView = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtAll);
            kotlin.jvm.internal.s.g(textView, "layout.txtAll");
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            TextView textView2 = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtDelete);
            kotlin.jvm.internal.s.g(textView2, "layout.txtDelete");
            textView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView2, 8);
            RecyclerView recyclerView2 = (RecyclerView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.rvStickers);
            kotlin.jvm.internal.s.g(recyclerView2, "layout.rvStickers");
            recyclerView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(recyclerView2, 8);
            View _$_findCachedViewById3 = ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.viewStickerManagementDivider);
            kotlin.jvm.internal.s.g(_$_findCachedViewById3, "layout.viewStickerManagementDivider");
            _$_findCachedViewById3.setVisibility(8);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById3, 8);
            ImageView imageView = (ImageView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.imgEmpty);
            kotlin.jvm.internal.s.g(imageView, "layout.imgEmpty");
            imageView.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView, 0);
            TextView textView3 = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtEmptyHint);
            kotlin.jvm.internal.s.g(textView3, "layout.txtEmptyHint");
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
        } else {
            TextView textView4 = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtAll);
            kotlin.jvm.internal.s.g(textView4, "layout.txtAll");
            textView4.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView4, 0);
            TextView textView5 = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtDelete);
            kotlin.jvm.internal.s.g(textView5, "layout.txtDelete");
            textView5.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView5, 0);
            RecyclerView recyclerView3 = (RecyclerView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.rvStickers);
            kotlin.jvm.internal.s.g(recyclerView3, "layout.rvStickers");
            recyclerView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(recyclerView3, 0);
            View _$_findCachedViewById4 = ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.viewStickerManagementDivider);
            kotlin.jvm.internal.s.g(_$_findCachedViewById4, "layout.viewStickerManagementDivider");
            _$_findCachedViewById4.setVisibility(0);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById4, 0);
            ImageView imageView2 = (ImageView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.imgEmpty);
            kotlin.jvm.internal.s.g(imageView2, "layout.imgEmpty");
            imageView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView2, 8);
            TextView textView6 = (TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.txtEmptyHint);
            kotlin.jvm.internal.s.g(textView6, "layout.txtEmptyHint");
            textView6.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView6, 8);
        }
        RecyclerView.Adapter adapter = ((RecyclerView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.rvStickers)).getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type us.pinguo.camera2020.view.adapter.StickerManageAdapter");
        final us.pinguo.camera2020.view.adapter.t tVar2 = (us.pinguo.camera2020.view.adapter.t) adapter;
        final LinkedList<Integer> f2 = tVar2.f();
        tVar2.l(W);
        tVar2.notifyDataSetChanged();
        int i4 = R.id.txtAll;
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i4)).setText(R.string.select_all);
        int i5 = R.id.txtDelete;
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i5)).setText(R.string.delete);
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i5)).setTextColor(Color.parseColor("#DBDBDB"));
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i5)).setClickable(false);
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i4)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewController.g0(us.pinguo.camera2020.view.adapter.t.this, ref$ObjectRef, f2, W, context, view);
            }
        });
        ((TextView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(i5)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewController.h0(f2, cameraStickerModule, W, tVar2, ref$ObjectRef, this, view);
            }
        });
        ((ImageView) ((StickerManagerLayout) ref$ObjectRef.element)._$_findCachedViewById(R.id.imgBack)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewController.i0(f2, this, view);
            }
        });
        ((StickerManagerLayout) ref$ObjectRef.element).setOnKeyListener(new View.OnKeyListener() { // from class: us.pinguo.camera2020.view.x0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
                boolean j0;
                j0 = StickerViewController.j0(f2, this, view, i6, keyEvent);
                return j0;
            }
        });
        ((StickerManagerLayout) ref$ObjectRef.element).setFocusableInTouchMode(true);
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams();
        layoutParams3.type = 1002;
        layoutParams3.flags = 1024;
        layoutParams3.systemUiVisibility = us.pinguo.util.h.c();
        us.pinguo.util.h.a(layoutParams3);
        layoutParams3.windowAnimations = 16973910;
        if (((StickerManagerLayout) ref$ObjectRef.element).isShown() || ((StickerManagerLayout) ref$ObjectRef.element).getParent() != null || ((StickerManagerLayout) ref$ObjectRef.element).isAttachedToWindow()) {
            windowManager.removeViewImmediate((View) ref$ObjectRef.element);
        }
        windowManager.addView((View) ref$ObjectRef.element, layoutParams3);
        ((StickerManagerLayout) ref$ObjectRef.element).requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(us.pinguo.camera2020.view.adapter.t adapter, Ref$ObjectRef layout, LinkedList selectedData, List stickerData, Context context, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(adapter, "$adapter");
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.h(selectedData, "$selectedData");
        kotlin.jvm.internal.s.h(stickerData, "$stickerData");
        List<Sticker> e2 = adapter.e();
        int i2 = 0;
        if ((e2 == null ? 0 : e2.size()) == 0) {
            return;
        }
        TextView textView = (TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(R.id.txtDelete);
        int size = selectedData.size();
        List<Sticker> e3 = adapter.e();
        if (size < (e3 == null ? 1 : e3.size())) {
            for (Object obj : stickerData) {
                int i3 = i2 + 1;
                if (i2 >= 0) {
                    Sticker sticker = (Sticker) obj;
                    if (!selectedData.contains(Integer.valueOf(i2))) {
                        selectedData.add(Integer.valueOf(i2));
                        adapter.notifyItemChanged(i2);
                    }
                    i2 = i3;
                } else {
                    kotlin.collections.s.n();
                    throw null;
                }
            }
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) view).setText(R.string.deselect_all);
            textView.setText(context.getString(R.string.delete) + (char) 65288 + selectedData.size() + (char) 65289);
            textView.setTextColor(Color.parseColor("#F05853"));
            textView.setClickable(true);
            return;
        }
        selectedData.clear();
        adapter.notifyDataSetChanged();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(R.string.select_all);
        textView.setText(R.string.delete);
        textView.setTextColor(Color.parseColor("#DBDBDB"));
        textView.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(LinkedList selectedData, CameraStickerModule module, List stickerData, us.pinguo.camera2020.view.adapter.t adapter, Ref$ObjectRef layout, StickerViewController this$0, View view) {
        int o;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(selectedData, "$selectedData");
        kotlin.jvm.internal.s.h(module, "$module");
        kotlin.jvm.internal.s.h(stickerData, "$stickerData");
        kotlin.jvm.internal.s.h(adapter, "$adapter");
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        o = kotlin.collections.v.o(selectedData, 10);
        ArrayList arrayList = new ArrayList(o);
        Iterator it = selectedData.iterator();
        while (it.hasNext()) {
            arrayList.add(((Sticker) stickerData.get(((Number) it.next()).intValue())).getPid());
        }
        module.F(arrayList);
        kotlin.collections.z.u(stickerData, new StickerViewController$showStickerManagement$4$1(arrayList));
        selectedData.clear();
        adapter.notifyDataSetChanged();
        int i2 = R.id.txtAll;
        ((TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i2)).setText(R.string.select_all);
        int i3 = R.id.txtDelete;
        ((TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i3)).setText(R.string.delete);
        ((TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i3)).setTextColor(Color.parseColor("#DBDBDB"));
        ((TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i3)).setClickable(false);
        if (stickerData.isEmpty()) {
            TextView textView = (TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(textView, "layout.txtAll");
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            TextView textView2 = (TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(i3);
            kotlin.jvm.internal.s.g(textView2, "layout.txtDelete");
            textView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView2, 8);
            RecyclerView recyclerView = (RecyclerView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(R.id.rvStickers);
            kotlin.jvm.internal.s.g(recyclerView, "layout.rvStickers");
            recyclerView.setVisibility(8);
            VdsAgent.onSetViewVisibility(recyclerView, 8);
            View _$_findCachedViewById = ((StickerManagerLayout) layout.element)._$_findCachedViewById(R.id.viewStickerManagementDivider);
            kotlin.jvm.internal.s.g(_$_findCachedViewById, "layout.viewStickerManagementDivider");
            _$_findCachedViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, 8);
            ImageView imageView = (ImageView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(R.id.imgEmpty);
            kotlin.jvm.internal.s.g(imageView, "layout.imgEmpty");
            imageView.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView, 0);
            TextView textView3 = (TextView) ((StickerManagerLayout) layout.element)._$_findCachedViewById(R.id.txtEmptyHint);
            kotlin.jvm.internal.s.g(textView3, "layout.txtEmptyHint");
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
        }
        PagerAdapter adapter2 = ((ViewPager) this$0.b._$_findCachedViewById(R.id.pagerStickerCategory)).getAdapter();
        Objects.requireNonNull(adapter2, "null cannot be cast to non-null type us.pinguo.camera2020.view.adapter.CategoryPagerAdapter");
        RecyclerView recyclerView2 = ((us.pinguo.camera2020.view.adapter.k) adapter2).a().get(0);
        RecyclerView.Adapter adapter3 = recyclerView2 == null ? null : recyclerView2.getAdapter();
        us.pinguo.camera2020.view.adapter.u uVar = adapter3 instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter3 : null;
        List<Sticker> q = module.q("recent_");
        if (q != null && uVar != null) {
            uVar.n(q);
        }
        if (uVar == null) {
            return;
        }
        Sticker value = module.u().getValue();
        uVar.q(value == null ? null : value.getPid(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(LinkedList selectedData, StickerViewController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(selectedData, "$selectedData");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        selectedData.clear();
        this$0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j0(LinkedList selectedData, StickerViewController this$0, View view, int i2, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.h(selectedData, "$selectedData");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == 4) {
            selectedData.clear();
            this$0.y();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(final String str) {
        CameraStickerModule cameraStickerModule = this.a;
        PagerAdapter adapter = ((ViewPager) this.b._$_findCachedViewById(R.id.pagerStickerCategory)).getAdapter();
        us.pinguo.camera2020.view.adapter.k kVar = adapter instanceof us.pinguo.camera2020.view.adapter.k ? (us.pinguo.camera2020.view.adapter.k) adapter : null;
        if (kVar == null) {
            return;
        }
        List<RecyclerView> a2 = kVar.a();
        List<StickerCategory> t = cameraStickerModule.t();
        if (t == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : t) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                String[] package_ids = ((StickerCategory) obj).getPackage_ids();
                int length = package_ids.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i4 = -1;
                        break;
                    } else if (kotlin.jvm.internal.s.c(package_ids[i4], str)) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 >= 0) {
                    RecyclerView recyclerView = a2.get(i2);
                    RecyclerView.Adapter adapter2 = recyclerView == null ? null : recyclerView.getAdapter();
                    us.pinguo.camera2020.view.adapter.u uVar = adapter2 instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter2 : null;
                    if (uVar != null) {
                        arrayList.add(new Pair(Integer.valueOf(i4), uVar));
                    }
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        cameraStickerModule.C(str, this.c, new Observer() { // from class: us.pinguo.camera2020.view.g1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj2) {
                StickerViewController.l0(arrayList, str, (Integer) obj2);
            }
        });
        cameraStickerModule.k(str, true, StickerViewController$triggerStickerDownload$3.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(ArrayList stickerAdapterList, String stickerId, Integer progress) {
        kotlin.jvm.internal.s.h(stickerAdapterList, "$stickerAdapterList");
        kotlin.jvm.internal.s.h(stickerId, "$stickerId");
        Iterator it = stickerAdapterList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int intValue = ((Number) pair.getFirst()).intValue();
            us.pinguo.camera2020.view.adapter.u uVar = (us.pinguo.camera2020.view.adapter.u) pair.getSecond();
            kotlin.jvm.internal.s.g(progress, "progress");
            uVar.i(stickerId, intValue, progress.intValue());
            if (progress.intValue() == 100) {
                uVar.o(stickerId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(us.pinguo.camera2020.view.adapter.k pagerAdapter, Ref$IntRef categoryPos, boolean z, String str, List categories) {
        int v;
        kotlin.jvm.internal.s.h(pagerAdapter, "$pagerAdapter");
        kotlin.jvm.internal.s.h(categoryPos, "$categoryPos");
        kotlin.jvm.internal.s.h(categories, "$categories");
        RecyclerView recyclerView = pagerAdapter.a().get(categoryPos.element);
        if (recyclerView == null) {
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        us.pinguo.camera2020.view.adapter.u uVar = adapter instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter : null;
        if (uVar == null) {
            return;
        }
        if (z) {
            uVar.p(str);
        }
        v = kotlin.collections.n.v(((StickerCategory) categories.get(categoryPos.element)).getPackage_ids(), str);
        int i2 = categoryPos.element;
        recyclerView.scrollToPosition(v + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(us.pinguo.camera2020.view.adapter.k pagerAdapter, Ref$IntRef categoryPos, boolean z, String str, List categories) {
        int v;
        kotlin.jvm.internal.s.h(pagerAdapter, "$pagerAdapter");
        kotlin.jvm.internal.s.h(categoryPos, "$categoryPos");
        kotlin.jvm.internal.s.h(categories, "$categories");
        RecyclerView recyclerView = pagerAdapter.a().get(categoryPos.element);
        if (recyclerView == null) {
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        us.pinguo.camera2020.view.adapter.u uVar = adapter instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter : null;
        if (uVar == null) {
            return;
        }
        if (z) {
            uVar.p(str);
        }
        v = kotlin.collections.n.v(((StickerCategory) categories.get(categoryPos.element)).getPackage_ids(), str);
        int i2 = categoryPos.element;
        recyclerView.scrollToPosition(v + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i2, String str) {
        StickerLayout stickerLayout = this.b;
        Context context = stickerLayout.getContext();
        CameraStickerModule cameraStickerModule = this.a;
        if (((ViewPager) stickerLayout._$_findCachedViewById(R.id.pagerStickerCategory)).getCurrentItem() == 0 && i2 == 0) {
            f0();
            return;
        }
        cameraStickerModule.J(str);
        b0();
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.c), kotlinx.coroutines.z0.b(), null, new StickerViewController$handleStickerItemClicked$1(cameraStickerModule, str, this, context, null), 2, null);
    }

    private final void y() {
        Context context;
        us.pinguo.foundation.statistics.f.f("camerafragment");
        us.pinguo.foundation.statistics.f.d("delete_sticker_page");
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f9315l;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        StickerManagerLayout stickerManagerLayout = this.f9307d;
        if (stickerManagerLayout == null || (context = stickerManagerLayout.getContext()) == null) {
            return;
        }
        if (stickerManagerLayout.isShown() || stickerManagerLayout.isAttachedToWindow()) {
            Object systemService = context.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).removeView(stickerManagerLayout);
        }
    }

    private final void z() {
        final StickerLayout stickerLayout = this.b;
        final CameraStickerModule cameraStickerModule = this.a;
        cameraStickerModule.r().observe(this.c, new Observer() { // from class: us.pinguo.camera2020.view.b1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StickerViewController.A(StickerViewController.this, cameraStickerModule, stickerLayout, (String) obj);
            }
        });
        ((ImageView) stickerLayout._$_findCachedViewById(R.id.viewFilterAdjust)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewController.B(CameraStickerModule.this, view);
            }
        });
        ((ImageView) stickerLayout._$_findCachedViewById(R.id.viewMakeupAdjust)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewController.C(CameraStickerModule.this, view);
            }
        });
        ((StickySeekBar) stickerLayout._$_findCachedViewById(R.id.stickerAdjustBar)).setTrackListener(new a(cameraStickerModule, this));
    }

    @Override // us.pinguo.common.h
    public int D() {
        return us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.effect_adjust_bar_height);
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (event.c() == EventType.BACK_PRESS || event.c() == EventType.TOUCH_UP || event.c() == EventType.DOUBLE_CLICK) {
            if (this.f9311h) {
                if (this.b.getVisibility() == 0) {
                    v();
                    return true;
                }
            }
            if (this.f9311h) {
                if (!(this.b.getVisibility() == 0)) {
                    m();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // us.pinguo.common.h
    public int G() {
        return us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.effect_tab_height);
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        this.f9309f = z;
        CameraStickerModule cameraStickerModule = this.a;
        StickerLayout stickerLayout = this.b;
        String value = cameraStickerModule.r().getValue();
        if (value == null) {
            value = "";
        }
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.c), kotlinx.coroutines.z0.b(), null, new StickerViewController$changeAdjustBarStyle$1(cameraStickerModule, value, stickerLayout, this, z, null), 2, null);
    }

    public final boolean M() {
        return this.f9311h;
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    public final void a0() {
        RecyclerView recyclerView;
        ViewPager viewPager = (ViewPager) this.b._$_findCachedViewById(R.id.pagerStickerCategory);
        if (viewPager.getCurrentItem() != 0) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        us.pinguo.camera2020.view.adapter.k kVar = adapter instanceof us.pinguo.camera2020.view.adapter.k ? (us.pinguo.camera2020.view.adapter.k) adapter : null;
        if (kVar == null || (recyclerView = kVar.a().get(0)) == null) {
            return;
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Objects.requireNonNull(adapter2, "null cannot be cast to non-null type us.pinguo.camera2020.view.adapter.StickerRecyclerAdapter");
        us.pinguo.camera2020.view.adapter.u uVar = (us.pinguo.camera2020.view.adapter.u) adapter2;
        List<Sticker> q = this.a.q("recent_");
        if (q == null) {
            return;
        }
        RecyclerView.ItemDecoration itemDecorationAt = recyclerView.getItemDecorationAt(0);
        us.pinguo.camera2020.view.adapter.s sVar = itemDecorationAt instanceof us.pinguo.camera2020.view.adapter.s ? (us.pinguo.camera2020.view.adapter.s) itemDecorationAt : null;
        if (sVar != null) {
            sVar.a((int) Math.ceil((q.size() + 1) * 0.2f));
        }
        uVar.n(q);
        Sticker value = this.a.u().getValue();
        uVar.q(value == null ? null : value.getPid(), null);
    }

    public final void c0(kotlin.jvm.b.a<? extends ArrayList<String>> aVar) {
        this.m = aVar;
    }

    public final void d0(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.f9315l = lVar;
    }

    public final void e0() {
        this.f9311h = true;
        m();
    }

    @Override // us.pinguo.common.h
    public void h(boolean z) {
        TabLayout tabLayout = (TabLayout) this.b._$_findCachedViewById(R.id.tabStickerCategory);
        if (z) {
            tabLayout.setBackgroundColor(-1);
        } else {
            tabLayout.setBackgroundResource(R.color.black_70);
        }
        us.pinguo.common.filter.util.b.a.a((ImageView) this.b._$_findCachedViewById(R.id.imgCancel), z ? R.color.color_camera_theme_black : R.color.color_camera_theme_light);
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        h.a.e(this, z);
    }

    public final void m() {
        this.b.show();
    }

    public final void n() {
        this.b.a();
    }

    public final StickerCategory o() {
        return this.n;
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        this.f9308e = z;
        StickerLayout stickerLayout = this.b;
        int i2 = R.id.pagerStickerCategory;
        ((ViewPager) stickerLayout._$_findCachedViewById(i2)).setBackgroundResource(z ? R.color.white : R.color.black_70);
        PagerAdapter adapter = ((ViewPager) this.b._$_findCachedViewById(i2)).getAdapter();
        us.pinguo.camera2020.view.adapter.k kVar = adapter instanceof us.pinguo.camera2020.view.adapter.k ? (us.pinguo.camera2020.view.adapter.k) adapter : null;
        if (kVar == null) {
            return;
        }
        for (RecyclerView recyclerView : kVar.a()) {
            RecyclerView.Adapter adapter2 = recyclerView == null ? null : recyclerView.getAdapter();
            us.pinguo.camera2020.view.adapter.u uVar = adapter2 instanceof us.pinguo.camera2020.view.adapter.u ? (us.pinguo.camera2020.view.adapter.u) adapter2 : null;
            if (uVar != null) {
                uVar.s(z);
            }
        }
    }

    public final void q(String str, final String str2, StickerGotoSource source) {
        ViewPager viewPager;
        final List<StickerCategory> t;
        boolean z;
        kotlin.jvm.internal.s.h(source, "source");
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                return;
            }
        }
        final boolean z2 = source == StickerGotoSource.URL || source == StickerGotoSource.FRESH_STICKER_USER;
        if (z2) {
            this.f9312i = str2;
        }
        this.f9313j = true;
        TabLayout tabLayout = (TabLayout) this.b._$_findCachedViewById(R.id.tabStickerCategory);
        if (tabLayout == null || (viewPager = (ViewPager) this.b._$_findCachedViewById(R.id.pagerStickerCategory)) == null) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        us.pinguo.camera2020.view.adapter.k kVar = adapter instanceof us.pinguo.camera2020.view.adapter.k ? (us.pinguo.camera2020.view.adapter.k) adapter : null;
        if (kVar == null || (t = this.a.t()) == null) {
            return;
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i2 = -1;
        if (str == null || str.length() == 0) {
            Iterator<StickerCategory> it = t.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String[] package_ids = it.next().getPackage_ids();
                int length = package_ids.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    } else if (kotlin.jvm.internal.s.c(package_ids[i4], str2)) {
                        z = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            ref$IntRef.element = i2;
            if (i2 < 0) {
                return;
            }
            TabLayout.f z3 = tabLayout.z(i2);
            if (z3 != null) {
                z3.l();
            }
            final us.pinguo.camera2020.view.adapter.k kVar2 = kVar;
            us.pinguo.foundation.ui.c.c(tabLayout, new Runnable() { // from class: us.pinguo.camera2020.view.h1
                @Override // java.lang.Runnable
                public final void run() {
                    StickerViewController.r(us.pinguo.camera2020.view.adapter.k.this, ref$IntRef, z2, str2, t);
                }
            }, false);
        } else {
            if (str2 == null || str2.length() == 0) {
                Iterator<StickerCategory> it2 = t.iterator();
                int i5 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (kotlin.jvm.internal.s.c(it2.next().getTopic_id(), str)) {
                        i2 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                ref$IntRef.element = i2;
                if (i2 < 0) {
                    ref$IntRef.element = 0;
                }
                TabLayout.f z4 = tabLayout.z(ref$IntRef.element);
                if (z4 != null) {
                    z4.l();
                }
            } else {
                Iterator<StickerCategory> it3 = t.iterator();
                int i6 = 0;
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    } else if (kotlin.jvm.internal.s.c(it3.next().getTopic_id(), str)) {
                        i2 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
                ref$IntRef.element = i2;
                if (i2 < 0) {
                    ref$IntRef.element = 0;
                }
                TabLayout.f z5 = tabLayout.z(ref$IntRef.element);
                if (z5 != null) {
                    z5.l();
                }
                final us.pinguo.camera2020.view.adapter.k kVar3 = kVar;
                us.pinguo.foundation.ui.c.c(tabLayout, new Runnable() { // from class: us.pinguo.camera2020.view.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickerViewController.t(us.pinguo.camera2020.view.adapter.k.this, ref$IntRef, z2, str2, t);
                    }
                }, false);
            }
        }
        if (source == StickerGotoSource.URL) {
            us.pinguo.foundation.statistics.h.b.I(t.get(ref$IntRef.element).getTopic_id(), "goto");
        }
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return this.f9311h;
    }

    public final void v() {
        this.f9311h = false;
        n();
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        StickerLayout stickerLayout = this.b;
        ImageView imageView = (ImageView) stickerLayout._$_findCachedViewById(R.id.viewFilterAdjust);
        kotlin.jvm.internal.s.g(imageView, "layout.viewFilterAdjust");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2;
        imageView.setLayoutParams(layoutParams2);
        ImageView imageView2 = (ImageView) stickerLayout._$_findCachedViewById(R.id.viewMakeupAdjust);
        kotlin.jvm.internal.s.g(imageView2, "layout.viewMakeupAdjust");
        ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i2;
        imageView2.setLayoutParams(layoutParams4);
        StickySeekBar stickySeekBar = (StickySeekBar) stickerLayout._$_findCachedViewById(R.id.stickerAdjustBar);
        kotlin.jvm.internal.s.g(stickySeekBar, "layout.stickerAdjustBar");
        ViewGroup.LayoutParams layoutParams5 = stickySeekBar.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = i2;
        stickySeekBar.setLayoutParams(layoutParams6);
    }

    @Override // us.pinguo.common.h
    public int x() {
        return ((ViewPager) this.b._$_findCachedViewById(R.id.pagerStickerCategory)).getLayoutParams().height;
    }
}
