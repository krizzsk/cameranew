package us.pinguo.edit2020.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.h0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.MaterialAdapter$Companion$MaterialType;
import us.pinguo.edit2020.adapter.i0;
import us.pinguo.edit2020.adapter.j0;
import us.pinguo.edit2020.view.RoundCornerRecyclerView;
import us.pinguo.edit2020.viewmodel.module.StaticStickerModule;
import us.pinguo.edit2020.widget.DrawerPanelView;
import us.pinguo.foundation.utils.n0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.Template;
import us.pinguo.repository2020.database.staticsticker.TemplateCategory;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: DrawerPanelView.kt */
/* loaded from: classes4.dex */
public final class DrawerPanelView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final StaticStickerModule b;
    private BottomSheetBehavior<View> c;

    /* renamed from: d  reason: collision with root package name */
    private i0.b f10916d;

    /* renamed from: e  reason: collision with root package name */
    private a f10917e;

    /* renamed from: f  reason: collision with root package name */
    private j0 f10918f;

    /* renamed from: g  reason: collision with root package name */
    private j0 f10919g;

    /* renamed from: h  reason: collision with root package name */
    private i0[] f10920h;

    /* renamed from: i  reason: collision with root package name */
    private i0[] f10921i;

    /* renamed from: j  reason: collision with root package name */
    private int f10922j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f10923k;

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2);
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class b extends BottomSheetBehavior.g {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(View p0, float f2) {
            s.h(p0, "p0");
            float a = ((us.pinguo.common.widget.i.a.a(Integer.valueOf((int) IjkMediaCodecInfo.RANK_SECURE)) - us.pinguo.common.widget.i.a.b(100)) * f2) + us.pinguo.common.widget.i.a.b(100);
            us.pinguo.common.log.a.e("currentPanelContentHeight:" + (a / n0.b(1.0f)) + "  panel slide progress:" + f2, new Object[0]);
            ConstraintSet constraintSet = new ConstraintSet();
            DrawerPanelView drawerPanelView = DrawerPanelView.this;
            int i2 = R.id.clSkipEmptyHint;
            constraintSet.clone((ConstraintLayout) drawerPanelView._$_findCachedViewById(i2));
            constraintSet.constrainHeight(((ConstraintLayout) DrawerPanelView.this._$_findCachedViewById(R.id.clSkipEmpty)).getId(), (int) a);
            constraintSet.applyTo((ConstraintLayout) DrawerPanelView.this._$_findCachedViewById(i2));
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View p0, int i2) {
            s.h(p0, "p0");
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class c implements j0.b {
        c() {
        }

        @Override // us.pinguo.edit2020.adapter.j0.b
        public void a(View view, int i2, Material category) {
            ObservableBoolean isSelected;
            ObservableBoolean isSelected2;
            s.h(category, "category");
            String pid = category.getPid();
            if (pid == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.y0("sticker_template_category", pid, "click");
            if (!(category instanceof TemplateCategory) || s.c(category, DrawerPanelView.this.o().G())) {
                return;
            }
            TemplateCategory G = DrawerPanelView.this.o().G();
            if (G != null && (isSelected2 = G.isSelected()) != null) {
                isSelected2.set(false);
            }
            TemplateCategory templateCategory = (TemplateCategory) category;
            DrawerPanelView.this.o().u0(templateCategory);
            TemplateCategory D = DrawerPanelView.this.o().D();
            if (D != null && (isSelected = D.isSelected()) != null) {
                isSelected.set(true);
            }
            DrawerPanelView.this.o().x0(templateCategory);
            DrawerPanelView drawerPanelView = DrawerPanelView.this;
            int i3 = R.id.rvTemplate;
            RecyclerView recyclerView = (RecyclerView) drawerPanelView._$_findCachedViewById(i3);
            i0[] i0VarArr = DrawerPanelView.this.f10921i;
            recyclerView.setAdapter(i0VarArr == null ? null : i0VarArr[i2]);
            int left = (view == null ? 0 : view.getLeft()) + ((view == null ? 0 : view.getWidth()) / 2);
            DrawerPanelView drawerPanelView2 = DrawerPanelView.this;
            int i4 = R.id.rvCategory;
            ((RoundCornerRecyclerView) DrawerPanelView.this._$_findCachedViewById(i4)).smoothScrollBy(left - (((RoundCornerRecyclerView) drawerPanelView2._$_findCachedViewById(i4)).getWidth() / 2), 0);
            DrawerPanelView drawerPanelView3 = DrawerPanelView.this;
            drawerPanelView3.t((RecyclerView) drawerPanelView3._$_findCachedViewById(i3));
            DrawerPanelView.this.K(category, 1);
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        final /* synthetic */ int a;
        final /* synthetic */ float b;

        d(int i2, float f2) {
            this.a = i2;
            this.b = f2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            s.h(outRect, "outRect");
            s.h(view, "view");
            s.h(parent, "parent");
            s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i2 = this.a;
            if (childAdapterPosition > i2) {
                outRect.top = (int) (this.b * 2);
            }
            if (childAdapterPosition % i2 == 0) {
                float f2 = this.b;
                outRect.left = (int) ((i2 == 5 ? 1.4f : 2.0f) * f2);
                outRect.right = (int) f2;
                return;
            }
            float f3 = this.b;
            outRect.left = (int) f3;
            outRect.right = (int) f3;
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class e implements i0.b {
        final /* synthetic */ RecyclerView b;

        e(RecyclerView recyclerView) {
            this.b = recyclerView;
        }

        @Override // us.pinguo.edit2020.adapter.i0.b
        public void a(View view, int i2, Material material) {
            i0.b n = DrawerPanelView.this.n();
            if (n != null) {
                n.a(view, i2, material);
            }
            DrawerPanelView.this.f10922j = i2;
            Rect rect = new Rect();
            if (view != null) {
                view.getGlobalVisibleRect(rect);
            }
            if (view != null && rect.height() < DrawerPanelView.this.getContext().getResources().getDimensionPixelSize(R.dimen.paint_material_rv_item_size) && !this.b.canScrollVertically(-1)) {
                DrawerPanelView.this.m();
                return;
            }
            s.e(view);
            this.b.smoothScrollBy(0, (int) (view.getY() - this.b.getY()));
        }

        @Override // us.pinguo.edit2020.adapter.i0.b
        public void b(View view, int i2, Material material) {
            i0.b n = DrawerPanelView.this.n();
            if (n == null) {
                return;
            }
            n.b(view, i2, material);
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class f implements j0.b {
        f() {
        }

        @Override // us.pinguo.edit2020.adapter.j0.b
        public void a(View view, int i2, Material category) {
            ObservableBoolean isSelected;
            ObservableBoolean isSelected2;
            s.h(category, "category");
            String pid = category.getPid();
            if (pid == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.y0("sticker_package", pid, "click");
            if (!(category instanceof StaticStickerCategory) || s.c(category, DrawerPanelView.this.o().E())) {
                return;
            }
            StaticStickerCategory E = DrawerPanelView.this.o().E();
            if (E != null && (isSelected2 = E.isSelected()) != null) {
                isSelected2.set(false);
            }
            StaticStickerCategory staticStickerCategory = (StaticStickerCategory) category;
            DrawerPanelView.this.o().s0(staticStickerCategory);
            StaticStickerCategory B = DrawerPanelView.this.o().B();
            if (B != null && (isSelected = B.isSelected()) != null) {
                isSelected.set(true);
            }
            DrawerPanelView.this.o().v0(staticStickerCategory);
            DrawerPanelView drawerPanelView = DrawerPanelView.this;
            int i3 = R.id.rvMaterial;
            RecyclerView recyclerView = (RecyclerView) drawerPanelView._$_findCachedViewById(i3);
            i0[] i0VarArr = DrawerPanelView.this.f10920h;
            recyclerView.setAdapter(i0VarArr == null ? null : i0VarArr[i2]);
            int left = (view == null ? 0 : view.getLeft()) + ((view == null ? 0 : view.getWidth()) / 2);
            DrawerPanelView drawerPanelView2 = DrawerPanelView.this;
            int i4 = R.id.rvCategory;
            ((RoundCornerRecyclerView) DrawerPanelView.this._$_findCachedViewById(i4)).smoothScrollBy(left - (((RoundCornerRecyclerView) drawerPanelView2._$_findCachedViewById(i4)).getWidth() / 2), 0);
            DrawerPanelView drawerPanelView3 = DrawerPanelView.this;
            drawerPanelView3.t((RecyclerView) drawerPanelView3._$_findCachedViewById(i3));
            DrawerPanelView.this.B();
            DrawerPanelView.this.K(category, 0);
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class g implements kotlin.jvm.b.a<u> {
        final /* synthetic */ Ref$ObjectRef<String> b;
        final /* synthetic */ us.pinguo.edit2020.model.editgoto.b c;

        g(Ref$ObjectRef<String> ref$ObjectRef, us.pinguo.edit2020.model.editgoto.b bVar) {
            this.b = ref$ObjectRef;
            this.c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(DrawerPanelView this$0, Ref$ObjectRef typeCategoryId, us.pinguo.edit2020.model.editgoto.b bVar) {
            View view;
            s.h(this$0, "this$0");
            s.h(typeCategoryId, "$typeCategoryId");
            Integer U = this$0.o().U((String) typeCategoryId.element, bVar.d());
            if (U != null) {
                int i2 = R.id.rvTemplate;
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) this$0._$_findCachedViewById(i2)).getLayoutManager();
                Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(U.intValue(), 0);
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) this$0._$_findCachedViewById(i2)).findViewHolderForAdapterPosition(U.intValue());
                if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
                    return;
                }
                view.performClick();
            }
        }

        public void a() {
            RecyclerView rvTemplate = (RecyclerView) DrawerPanelView.this._$_findCachedViewById(R.id.rvTemplate);
            s.g(rvTemplate, "rvTemplate");
            final DrawerPanelView drawerPanelView = DrawerPanelView.this;
            final Ref$ObjectRef<String> ref$ObjectRef = this.b;
            final us.pinguo.edit2020.model.editgoto.b bVar = this.c;
            us.pinguo.foundation.ui.c.b(rvTemplate, new Runnable() { // from class: us.pinguo.edit2020.widget.g
                @Override // java.lang.Runnable
                public final void run() {
                    DrawerPanelView.g.b(DrawerPanelView.this, ref$ObjectRef, bVar);
                }
            });
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ u invoke() {
            a();
            return u.a;
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class h extends RecyclerView.OnScrollListener {
        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                DrawerPanelView.this.D();
            }
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class i extends RecyclerView.OnScrollListener {
        i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                DrawerPanelView.this.E();
            }
        }
    }

    /* compiled from: DrawerPanelView.kt */
    /* loaded from: classes4.dex */
    public static final class j extends RecyclerView.OnScrollListener {
        j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                DrawerPanelView.this.E();
            }
        }
    }

    public /* synthetic */ DrawerPanelView(Context context, AttributeSet attributeSet, int i2, StaticStickerModule staticStickerModule, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2, staticStickerModule);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H(DrawerPanelView drawerPanelView, int i2, kotlin.jvm.b.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        drawerPanelView.G(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(final DrawerPanelView this$0, final int i2, float f2, final kotlin.jvm.b.a aVar) {
        s.h(this$0, "this$0");
        int i3 = R.id.rvCategory;
        RecyclerView.LayoutManager layoutManager = ((RoundCornerRecyclerView) this$0._$_findCachedViewById(i3)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, (int) f2);
        RoundCornerRecyclerView rvCategory = (RoundCornerRecyclerView) this$0._$_findCachedViewById(i3);
        s.g(rvCategory, "rvCategory");
        us.pinguo.foundation.ui.c.c(rvCategory, new Runnable() { // from class: us.pinguo.edit2020.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                DrawerPanelView.J(DrawerPanelView.this, i2, aVar);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DrawerPanelView this$0, int i2, kotlin.jvm.b.a aVar) {
        View view;
        s.h(this$0, "this$0");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RoundCornerRecyclerView) this$0._$_findCachedViewById(R.id.rvCategory)).findViewHolderForAdapterPosition(i2);
        if (findViewHolderForAdapterPosition != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
            view.performClick();
        }
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(Material material, int i2) {
        int i3;
        if (material instanceof StaticStickerCategory) {
            if (s.c(material.getPid(), Material.MATERIAL_RECENT)) {
                List<StaticSticker> H = this.b.H();
                if ((H == null || H.isEmpty()) || this.b.H().size() <= 1) {
                    ((TextView) _$_findCachedViewById(R.id.tvStickerEmptyHint)).setText(getContext().getString(R.string.str_no_sticker_used));
                    ConstraintLayout clSkipEmptyHint = (ConstraintLayout) _$_findCachedViewById(R.id.clSkipEmptyHint);
                    s.g(clSkipEmptyHint, "clSkipEmptyHint");
                    i3 = i2 == 0 ? 0 : 8;
                    clSkipEmptyHint.setVisibility(i3);
                    VdsAgent.onSetViewVisibility(clSkipEmptyHint, i3);
                    return;
                }
            }
            ConstraintLayout clSkipEmptyHint2 = (ConstraintLayout) _$_findCachedViewById(R.id.clSkipEmptyHint);
            s.g(clSkipEmptyHint2, "clSkipEmptyHint");
            clSkipEmptyHint2.setVisibility(8);
            VdsAgent.onSetViewVisibility(clSkipEmptyHint2, 8);
        } else if (material instanceof TemplateCategory) {
            if (s.c(material.getPid(), "collect")) {
                List<Template> w = this.b.w();
                if (w == null || w.isEmpty()) {
                    ((TextView) _$_findCachedViewById(R.id.tvStickerEmptyHint)).setText(getContext().getString(R.string.str_sticker_no_favorite));
                    ConstraintLayout clSkipEmptyHint3 = (ConstraintLayout) _$_findCachedViewById(R.id.clSkipEmptyHint);
                    s.g(clSkipEmptyHint3, "clSkipEmptyHint");
                    i3 = i2 == 1 ? 0 : 8;
                    clSkipEmptyHint3.setVisibility(i3);
                    VdsAgent.onSetViewVisibility(clSkipEmptyHint3, i3);
                    return;
                }
            }
            ConstraintLayout clSkipEmptyHint4 = (ConstraintLayout) _$_findCachedViewById(R.id.clSkipEmptyHint);
            s.g(clSkipEmptyHint4, "clSkipEmptyHint");
            clSkipEmptyHint4.setVisibility(8);
            VdsAgent.onSetViewVisibility(clSkipEmptyHint4, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void M(us.pinguo.edit2020.widget.DrawerPanelView r13, us.pinguo.edit2020.model.editgoto.b r14) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.s.h(r13, r0)
            int r0 = us.pinguo.edit2020.R.id.rvMaterial
            android.view.View r1 = r13._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L14
            goto L16
        L14:
            int r0 = us.pinguo.edit2020.R.id.rvTemplate
        L16:
            android.view.View r0 = r13._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r13.f10923k = r0
            if (r14 == 0) goto Ld9
            java.lang.String r0 = r14.b()
            java.lang.String r1 = "stickerPackage"
            boolean r0 = kotlin.jvm.internal.s.c(r0, r1)
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L3d
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r0 = r13.b
            java.lang.String r14 = r14.c()
            int r14 = r0.N(r14)
            H(r13, r14, r2, r1, r2)
            goto Ld9
        L3d:
            java.lang.String r0 = r14.b()
            java.lang.String r3 = "stickerTemplate"
            boolean r0 = kotlin.jvm.internal.s.c(r0, r3)
            if (r0 == 0) goto Ld9
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            java.lang.String r3 = r14.c()
            r4 = 44
            r5 = 1
            r6 = 0
            if (r3 != 0) goto L5a
        L58:
            r1 = 0
            goto L61
        L5a:
            boolean r1 = kotlin.text.l.B(r3, r4, r6, r1, r2)
            if (r1 != r5) goto L58
            r1 = 1
        L61:
            if (r1 == 0) goto Lc1
            java.lang.String r7 = r14.c()
            char[] r8 = new char[r5]
            r8[r6] = r4
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            java.util.List r1 = kotlin.text.l.o0(r7, r8, r9, r10, r11, r12)
            java.util.Iterator r1 = r1.iterator()
        L77:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lc7
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r4 = r13.o()
            java.util.List r4 = r4.R()
            if (r4 != 0) goto L8f
        L8d:
            r4 = 0
            goto Lbc
        L8f:
            java.util.Iterator r4 = r4.iterator()
        L93:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto Lab
            java.lang.Object r7 = r4.next()
            r8 = r7
            us.pinguo.repository2020.database.staticsticker.TemplateCategory r8 = (us.pinguo.repository2020.database.staticsticker.TemplateCategory) r8
            java.lang.String r8 = r8.getCid()
            boolean r8 = kotlin.jvm.internal.s.c(r8, r3)
            if (r8 == 0) goto L93
            goto Lac
        Lab:
            r7 = r2
        Lac:
            us.pinguo.repository2020.database.staticsticker.TemplateCategory r7 = (us.pinguo.repository2020.database.staticsticker.TemplateCategory) r7
            if (r7 != 0) goto Lb1
            goto L8d
        Lb1:
            long r8 = java.lang.System.currentTimeMillis()
            boolean r4 = r7.isValid(r8)
            if (r4 != r5) goto L8d
            r4 = 1
        Lbc:
            if (r4 == 0) goto L77
            r0.element = r3
            goto L77
        Lc1:
            java.lang.String r1 = r14.c()
            r0.element = r1
        Lc7:
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r1 = r13.b
            T r2 = r0.element
            java.lang.String r2 = (java.lang.String) r2
            int r1 = r1.S(r2)
            us.pinguo.edit2020.widget.DrawerPanelView$g r2 = new us.pinguo.edit2020.widget.DrawerPanelView$g
            r2.<init>(r0, r14)
            r13.G(r1, r2)
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.DrawerPanelView.M(us.pinguo.edit2020.widget.DrawerPanelView, us.pinguo.edit2020.model.editgoto.b):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(DrawerPanelView this$0) {
        s.h(this$0, "this$0");
        this$0.D();
    }

    private final void p() {
        BottomSheetBehavior<View> y = BottomSheetBehavior.y((LinearLayout) _$_findCachedViewById(R.id.llBottomSheetBehavior));
        this.c = y;
        if (y != null) {
            y.V(5);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.c;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.P(false);
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.c;
        if (bottomSheetBehavior2 == null) {
            return;
        }
        bottomSheetBehavior2.o(new b());
    }

    private final void r(RecyclerView recyclerView, int i2) {
        Resources resources;
        int i3;
        float i4 = n0.i();
        if (i2 == 5) {
            resources = getContext().getResources();
            i3 = R.dimen.paint_material_rv_item_size;
        } else {
            resources = getContext().getResources();
            i3 = R.dimen.sticker_template_rv_item_size;
        }
        recyclerView.addItemDecoration(new d(i2, (i4 - (resources.getDimensionPixelSize(i3) * i2)) / ((i2 * 2) + 2)));
    }

    private final void s() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 4);
        ((RoundCornerRecyclerView) _$_findCachedViewById(R.id.rvCategory)).setLayoutManager(linearLayoutManager);
        int i2 = R.id.rvMaterial;
        ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(gridLayoutManager);
        int i3 = R.id.rvTemplate;
        ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(gridLayoutManager2);
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) _$_findCachedViewById(i3)).getItemAnimator();
        DefaultItemAnimator defaultItemAnimator = itemAnimator instanceof DefaultItemAnimator ? (DefaultItemAnimator) itemAnimator : null;
        if (defaultItemAnimator != null) {
            defaultItemAnimator.setSupportsChangeAnimations(false);
        }
        RecyclerView rvMaterial = (RecyclerView) _$_findCachedViewById(i2);
        s.g(rvMaterial, "rvMaterial");
        r(rvMaterial, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(RecyclerView recyclerView) {
        i0 i0Var;
        if (recyclerView == null || (i0Var = (i0) recyclerView.getAdapter()) == null) {
            return;
        }
        i0Var.m(new e(recyclerView));
    }

    public static /* synthetic */ void z(DrawerPanelView drawerPanelView, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        drawerPanelView.y(str);
    }

    public final void A() {
        i0[] i0VarArr = this.f10921i;
        boolean z = true;
        if (i0VarArr != null) {
            if (!(i0VarArr.length == 0)) {
                z = false;
            }
        }
        i0 i0Var = null;
        if (!z && i0VarArr != null) {
            i0Var = i0VarArr[0];
        }
        if (i0Var != null) {
            i0Var.l(this.b.w());
        }
        TemplateCategory D = this.b.D();
        if (D == null) {
            return;
        }
        K(D, o().z());
    }

    public final void B() {
        i0[] i0VarArr = this.f10920h;
        boolean z = true;
        if (i0VarArr != null) {
            if (!(i0VarArr.length == 0)) {
                z = false;
            }
        }
        i0 i0Var = null;
        if (!z && i0VarArr != null) {
            i0Var = i0VarArr[0];
        }
        if (i0Var != null) {
            i0Var.l(this.b.H());
        }
        StaticStickerCategory B = this.b.B();
        if (B == null) {
            return;
        }
        K(B, o().z());
    }

    public final void C() {
        kotlin.z.d h2;
        i0[] i0VarArr;
        i0 i0Var;
        i0[] i0VarArr2 = this.f10921i;
        if ((i0VarArr2 == null ? 0 : i0VarArr2.length) > 0) {
            s.e(i0VarArr2);
            h2 = kotlin.z.j.h(1, i0VarArr2.length);
            Iterator<Integer> it = h2.iterator();
            while (it.hasNext()) {
                int nextInt = ((h0) it).nextInt();
                List<TemplateCategory> R = o().R();
                TemplateCategory templateCategory = R == null ? null : R.get(nextInt);
                if (templateCategory != null && (i0VarArr = this.f10921i) != null && (i0Var = i0VarArr[nextInt]) != null) {
                    i0Var.l(o().T(templateCategory));
                }
            }
        }
    }

    public final void D() {
        String pid;
        int i2 = R.id.rvCategory;
        RecyclerView.LayoutManager layoutManager = ((RoundCornerRecyclerView) _$_findCachedViewById(i2)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        RecyclerView.Adapter adapter = ((RoundCornerRecyclerView) _$_findCachedViewById(i2)).getAdapter();
        j0 j0Var = adapter instanceof j0 ? (j0) adapter : null;
        List<Material> e2 = j0Var != null ? j0Var.e() : null;
        if (e2 == null) {
            return;
        }
        Iterator<Integer> it = new kotlin.z.d(findFirstVisibleItemPosition, findLastVisibleItemPosition).iterator();
        while (it.hasNext()) {
            Material material = (Material) kotlin.collections.s.D(e2, ((h0) it).nextInt());
            if (material != null && (pid = material.getPid()) != null) {
                if (s.c(j0Var, this.f10918f)) {
                    us.pinguo.foundation.statistics.h.b.y0("sticker_package", pid, "show");
                } else if (s.c(j0Var, this.f10919g)) {
                    us.pinguo.foundation.statistics.h.b.y0("sticker_template_category", pid, "show");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r7.f10923k
            if (r0 != 0) goto L5
            return
        L5:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.getLayoutManager()
            boolean r2 = r1 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r2 == 0) goto L10
            androidx.recyclerview.widget.GridLayoutManager r1 = (androidx.recyclerview.widget.GridLayoutManager) r1
            goto L11
        L10:
            r1 = 0
        L11:
            if (r1 != 0) goto L14
            return
        L14:
            int r2 = r1.findFirstVisibleItemPosition()
            int r1 = r1.findLastVisibleItemPosition()
            androidx.recyclerview.widget.RecyclerView$Adapter r3 = r0.getAdapter()
            java.lang.String r4 = "null cannot be cast to non-null type us.pinguo.edit2020.adapter.MaterialAdapter"
            java.util.Objects.requireNonNull(r3, r4)
            us.pinguo.edit2020.adapter.i0 r3 = (us.pinguo.edit2020.adapter.i0) r3
            java.util.List r3 = r3.e()
            if (r3 != 0) goto L2e
            return
        L2e:
            kotlin.z.d r1 = kotlin.z.h.h(r2, r1)
            java.util.Iterator r1 = r1.iterator()
        L36:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L94
            r2 = r1
            kotlin.collections.h0 r2 = (kotlin.collections.h0) r2
            int r2 = r2.nextInt()
            java.lang.Object r2 = kotlin.collections.s.D(r3, r2)
            us.pinguo.repository2020.entity.Material r2 = (us.pinguo.repository2020.entity.Material) r2
            if (r2 != 0) goto L4c
            goto L36
        L4c:
            boolean r4 = r2 instanceof us.pinguo.repository2020.database.staticsticker.StaticSticker
            if (r4 == 0) goto L59
            us.pinguo.repository2020.database.staticsticker.StaticSticker r2 = (us.pinguo.repository2020.database.staticsticker.StaticSticker) r2
            java.lang.String r2 = r2.getSid()
            if (r2 != 0) goto L66
            goto L36
        L59:
            boolean r4 = r2 instanceof us.pinguo.repository2020.database.staticsticker.Template
            if (r4 == 0) goto L36
            us.pinguo.repository2020.database.staticsticker.Template r2 = (us.pinguo.repository2020.database.staticsticker.Template) r2
            java.lang.String r2 = r2.getTid()
            if (r2 != 0) goto L66
            goto L36
        L66:
            int r4 = us.pinguo.edit2020.R.id.rvMaterial
            android.view.View r4 = r7._$_findCachedViewById(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            boolean r4 = kotlin.jvm.internal.s.c(r0, r4)
            java.lang.String r5 = "show"
            if (r4 == 0) goto L7e
            us.pinguo.foundation.statistics.i r4 = us.pinguo.foundation.statistics.h.b
            java.lang.String r6 = "sticker_single"
            r4.y0(r6, r2, r5)
            goto L36
        L7e:
            int r4 = us.pinguo.edit2020.R.id.rvTemplate
            android.view.View r4 = r7._$_findCachedViewById(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            boolean r4 = kotlin.jvm.internal.s.c(r0, r4)
            if (r4 == 0) goto L36
            us.pinguo.foundation.statistics.i r4 = us.pinguo.foundation.statistics.h.b
            java.lang.String r6 = "sticker_template"
            r4.y0(r6, r2, r5)
            goto L36
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.DrawerPanelView.E():void");
    }

    public final void F() {
        i0 i0Var;
        ((RoundCornerRecyclerView) _$_findCachedViewById(R.id.rvCategory)).setAdapter(this.f10918f);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMaterial);
        i0[] i0VarArr = this.f10920h;
        i0 i0Var2 = null;
        if ((i0VarArr == null ? 0 : i0VarArr.length) >= 2) {
            if (i0VarArr != null) {
                i0Var = i0VarArr[1];
            }
            i0Var = null;
        } else {
            if (i0VarArr != null) {
                i0Var = i0VarArr[0];
            }
            i0Var = null;
        }
        recyclerView.setAdapter(i0Var);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rvTemplate);
        i0[] i0VarArr2 = this.f10921i;
        if ((i0VarArr2 == null ? 0 : i0VarArr2.length) >= 2) {
            if (i0VarArr2 != null) {
                i0Var2 = i0VarArr2[1];
            }
        } else if (i0VarArr2 != null) {
            i0Var2 = i0VarArr2[0];
        }
        recyclerView2.setAdapter(i0Var2);
    }

    public final void G(final int i2, final kotlin.jvm.b.a<u> aVar) {
        int i3 = R.id.rvCategory;
        final float i4 = ((n0.i() / 2) - (((RoundCornerRecyclerView) _$_findCachedViewById(i3)).getContext().getResources().getDimension(R.dimen.paint_material_category_item_width) / 2)) - ((AutofitTextView) _$_findCachedViewById(R.id.tvMoreSticker)).getWidth();
        RoundCornerRecyclerView rvCategory = (RoundCornerRecyclerView) _$_findCachedViewById(i3);
        s.g(rvCategory, "rvCategory");
        us.pinguo.foundation.ui.c.c(rvCategory, new Runnable() { // from class: us.pinguo.edit2020.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                DrawerPanelView.I(DrawerPanelView.this, i2, i4, aVar);
            }
        }, false);
    }

    public final void L(final us.pinguo.edit2020.model.editgoto.b bVar) {
        CoordinatorLayout drawerView = (CoordinatorLayout) _$_findCachedViewById(R.id.drawerView);
        s.g(drawerView, "drawerView");
        drawerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(drawerView, 0);
        int i2 = R.id.rvCategory;
        RoundCornerRecyclerView rvCategory = (RoundCornerRecyclerView) _$_findCachedViewById(i2);
        s.g(rvCategory, "rvCategory");
        us.pinguo.foundation.ui.c.b(rvCategory, new Runnable() { // from class: us.pinguo.edit2020.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                DrawerPanelView.M(DrawerPanelView.this, bVar);
            }
        });
        RoundCornerRecyclerView rvCategory2 = (RoundCornerRecyclerView) _$_findCachedViewById(i2);
        s.g(rvCategory2, "rvCategory");
        us.pinguo.foundation.ui.c.c(rvCategory2, new Runnable() { // from class: us.pinguo.edit2020.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                DrawerPanelView.N(DrawerPanelView.this);
            }
        }, true);
        ((RoundCornerRecyclerView) _$_findCachedViewById(i2)).addOnScrollListener(new h());
        ((RecyclerView) _$_findCachedViewById(R.id.rvMaterial)).addOnScrollListener(new i());
        ((RecyclerView) _$_findCachedViewById(R.id.rvTemplate)).addOnScrollListener(new j());
    }

    public final void O(int i2) {
        this.b.r0(i2);
        int i3 = 0;
        if (i2 == 0) {
            ((RoundCornerRecyclerView) _$_findCachedViewById(R.id.rvCategory)).setAdapter(this.f10918f);
            int i4 = R.id.rvMaterial;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i4);
            recyclerView.setVisibility(0);
            VdsAgent.onSetViewVisibility(recyclerView, 0);
            ((RecyclerView) _$_findCachedViewById(i4)).setNestedScrollingEnabled(true);
            int i5 = R.id.rvTemplate;
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i5);
            recyclerView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView2, 4);
            ((RecyclerView) _$_findCachedViewById(i5)).setNestedScrollingEnabled(false);
            this.f10923k = (RecyclerView) _$_findCachedViewById(i4);
            StaticStickerModule staticStickerModule = this.b;
            StaticStickerCategory B = staticStickerModule.B();
            int N = staticStickerModule.N(B == null ? null : B.getPid());
            if (this.b.B() != null) {
                StaticStickerCategory B2 = this.b.B();
                s.e(B2);
                K(B2, 0);
            }
            B();
            i3 = N;
        } else if (i2 == 1) {
            ((RoundCornerRecyclerView) _$_findCachedViewById(R.id.rvCategory)).setAdapter(this.f10919g);
            int i6 = R.id.rvMaterial;
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(i6);
            recyclerView3.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView3, 4);
            ((RecyclerView) _$_findCachedViewById(i6)).setNestedScrollingEnabled(false);
            int i7 = R.id.rvTemplate;
            RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(i7);
            recyclerView4.setVisibility(0);
            VdsAgent.onSetViewVisibility(recyclerView4, 0);
            ((RecyclerView) _$_findCachedViewById(i7)).setNestedScrollingEnabled(true);
            this.f10923k = (RecyclerView) _$_findCachedViewById(i7);
            StaticStickerModule staticStickerModule2 = this.b;
            TemplateCategory D = staticStickerModule2.D();
            i3 = staticStickerModule2.S(D == null ? null : D.getPid());
            if (this.b.D() != null) {
                TemplateCategory D2 = this.b.D();
                s.e(D2);
                K(D2, 1);
            }
        }
        H(this, i3, null, 2, null);
        a aVar = this.f10917e;
        if (aVar != null) {
            aVar.a(i2);
        }
        t(this.f10923k);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
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

    public final void a() {
        CoordinatorLayout drawerView = (CoordinatorLayout) _$_findCachedViewById(R.id.drawerView);
        s.g(drawerView, "drawerView");
        drawerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(drawerView, 8);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void l() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.c;
        boolean z = false;
        if (bottomSheetBehavior2 != null && bottomSheetBehavior2.C() == 4) {
            z = true;
        }
        if (z || (bottomSheetBehavior = this.c) == null) {
            return;
        }
        bottomSheetBehavior.V(4);
    }

    public final void m() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.c;
        boolean z = false;
        if (bottomSheetBehavior2 != null && bottomSheetBehavior2.C() == 3) {
            z = true;
        }
        if (z || (bottomSheetBehavior = this.c) == null) {
            return;
        }
        bottomSheetBehavior.V(3);
    }

    public final i0.b n() {
        return this.f10916d;
    }

    public final StaticStickerModule o() {
        return this.b;
    }

    public final void q() {
        i0 i0Var;
        z(this, null, 1, null);
        List<TemplateCategory> R = this.b.R();
        if (!(R == null || R.isEmpty()) && R.size() >= 2) {
            if (this.b.D() == null) {
                this.b.u0(R.get(1));
            }
            if (this.b.G() == null) {
                this.b.x0(R.get(1));
            }
            int size = R.size();
            i0[] i0VarArr = new i0[size];
            for (int i2 = 0; i2 < size; i2++) {
                if (s.c(R.get(i2).getCid(), "collect")) {
                    i0Var = new i0(this.b.w(), MaterialAdapter$Companion$MaterialType.TEMPLATE);
                } else {
                    i0Var = new i0(this.b.T(R.get(i2)), MaterialAdapter$Companion$MaterialType.TEMPLATE);
                }
                i0VarArr[i2] = i0Var;
            }
            this.f10921i = i0VarArr;
            j0 j0Var = this.f10919g;
            if (j0Var == null) {
                j0 j0Var2 = new j0(R);
                this.f10919g = j0Var2;
                j0Var2.k(new c());
            } else if (j0Var != null) {
                j0Var.j(R);
            }
        }
        int i3 = R.id.rvTemplate;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i3);
        Objects.requireNonNull(recyclerView, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        if (recyclerView.getAdapter() == null) {
            i0[] i0VarArr2 = this.f10921i;
            if ((i0VarArr2 != null ? i0VarArr2.length : 0) >= 2) {
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i3);
                Objects.requireNonNull(recyclerView2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                i0[] i0VarArr3 = this.f10921i;
                recyclerView2.setAdapter(i0VarArr3 != null ? i0VarArr3[1] : null);
            }
        }
        int i4 = R.id.rvMaterial;
        this.f10923k = (RecyclerView) _$_findCachedViewById(i4);
        t((RecyclerView) _$_findCachedViewById(i4));
    }

    public final void setOnMaterialItemClick(i0.b bVar) {
        this.f10916d = bVar;
    }

    public final void setOnSecondTabSelectedListener(a aVar) {
        this.f10917e = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.DrawerPanelView.y(java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerPanelView(Context context, AttributeSet attributeSet, int i2, StaticStickerModule staticStickerModule) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        s.h(staticStickerModule, "staticStickerModule");
        this.a = new LinkedHashMap();
        this.b = staticStickerModule;
        ViewGroup.inflate(context, R.layout.layout_drawer_panel, this);
        s();
        p();
    }
}
