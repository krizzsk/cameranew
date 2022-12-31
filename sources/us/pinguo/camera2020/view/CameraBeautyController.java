package us.pinguo.camera2020.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.abtest.Plan;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.camera2020.view.BeautyTabLayout;
import us.pinguo.camera2020.view.adapter.MakeupColorsAdapter;
import us.pinguo.camera2020.view.adapter.j;
import us.pinguo.camera2020.view.t2.a;
import us.pinguo.common.EventType;
import us.pinguo.common.filter.ChangeStatus;
import us.pinguo.common.h;
import us.pinguo.common.m.h;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: CameraBeautyController.kt */
/* loaded from: classes3.dex */
public final class CameraBeautyController implements j.b, View.OnClickListener, View.OnTouchListener, us.pinguo.ui.widget.h, us.pinguo.camera2020.view.adapter.l, BeautyTabLayout.a, h.b, us.pinguo.common.h, us.pinguo.common.g {
    private final View a;
    private final CameraBeautyModule b;
    private final us.pinguo.camera2020.view.adapter.j c;

    /* renamed from: d  reason: collision with root package name */
    private final us.pinguo.camera2020.view.adapter.j f9276d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.common.m.h f9277e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f9278f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.camera2020.f.g f9279g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableInt f9280h;

    /* renamed from: i  reason: collision with root package name */
    private final ObservableInt f9281i;

    /* renamed from: j  reason: collision with root package name */
    private final ObservableBoolean f9282j;

    /* renamed from: k  reason: collision with root package name */
    private final ObservableBoolean f9283k;

    /* renamed from: l  reason: collision with root package name */
    private final ObservableBoolean f9284l;
    private final MakeupColorsAdapter m;
    private final us.pinguo.camera2020.view.t2.a n;
    private BeautyData o;
    private final us.pinguo.camera2020.view.adapter.r p;
    private boolean q;
    private final ObservableBoolean r;
    private us.pinguo.camera2020.module.b s;
    private StyleMakeup t;
    private kotlin.jvm.b.a<? extends ArrayList<String>> u;
    private int v;
    private boolean w;

    /* compiled from: CameraBeautyController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements a.InterfaceC0363a {
        final /* synthetic */ View a;
        final /* synthetic */ CameraBeautyController b;
        final /* synthetic */ CameraBeautyModule c;

        a(View view, CameraBeautyController cameraBeautyController, CameraBeautyModule cameraBeautyModule) {
            this.a = view;
            this.b = cameraBeautyController;
            this.c = cameraBeautyModule;
        }

        @Override // us.pinguo.camera2020.view.t2.a.InterfaceC0363a
        public void a(View itemView) {
            kotlin.jvm.internal.s.h(itemView, "itemView");
            int childAdapterPosition = ((RecyclerView) this.a.findViewById(R.id.rvColors)).getChildAdapterPosition(itemView);
            BeautyData beautyData = this.b.o;
            if (beautyData != null && beautyData.isGroup()) {
                List<String> colorList = beautyData.getColorList();
                if (!(colorList == null || colorList.isEmpty())) {
                    beautyData.setColorIndex(childAdapterPosition);
                    BeautyDataManager.a.l().v(beautyData);
                }
            }
            this.c.m(childAdapterPosition);
        }
    }

    /* compiled from: CameraBeautyController.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        final /* synthetic */ int a;
        final /* synthetic */ View b;
        final /* synthetic */ CameraBeautyController c;

        b(int i2, View view, CameraBeautyController cameraBeautyController) {
            this.a = i2;
            this.b = view;
            this.c = cameraBeautyController;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null) {
                return;
            }
            if (childAdapterPosition == 0) {
                outRect.left = this.a - (this.b.getResources().getDimensionPixelSize(R.dimen.beauty_clear_width) + (this.b.getResources().getDimensionPixelSize(R.dimen.make_up_colors_size) / 2));
                outRect.right = view.getResources().getDimensionPixelSize(R.dimen.beauty_color_item_gap);
            } else if (childAdapterPosition != adapter.getItemCount() - 1) {
                BeautyData beautyData = this.c.o;
                boolean z = false;
                if (beautyData != null && childAdapterPosition == beautyData.getColorIndex()) {
                    z = true;
                }
                if (z) {
                    Resources resources = view.getResources();
                    int i2 = R.dimen.beauty_color_item_gap_bigger;
                    outRect.left = resources.getDimensionPixelSize(i2);
                    outRect.right = view.getResources().getDimensionPixelSize(i2);
                } else if (childAdapterPosition < adapter.getItemCount() - 1) {
                    Resources resources2 = view.getResources();
                    int i3 = R.dimen.beauty_color_item_gap;
                    outRect.left = resources2.getDimensionPixelSize(i3);
                    outRect.right = view.getResources().getDimensionPixelSize(i3);
                }
            } else {
                outRect.left = view.getResources().getDimensionPixelSize(R.dimen.beauty_color_item_gap);
                outRect.right = this.a - (view.getWidth() / 2);
            }
        }
    }

    public CameraBeautyController(View beautyView, CameraBeautyModule cameraBeautyModule, us.pinguo.camera2020.module.b exclusiveEffectManager) {
        kotlin.jvm.internal.s.h(beautyView, "beautyView");
        kotlin.jvm.internal.s.h(cameraBeautyModule, "cameraBeautyModule");
        kotlin.jvm.internal.s.h(exclusiveEffectManager, "exclusiveEffectManager");
        this.f9280h = new ObservableInt(0);
        ObservableInt observableInt = new ObservableInt(0);
        this.f9281i = observableInt;
        ObservableBoolean observableBoolean = new ObservableBoolean(false);
        this.f9282j = observableBoolean;
        this.f9283k = new ObservableBoolean(false);
        ObservableBoolean observableBoolean2 = new ObservableBoolean(false);
        this.f9284l = observableBoolean2;
        this.p = new us.pinguo.camera2020.view.adapter.r();
        ObservableBoolean observableBoolean3 = new ObservableBoolean(false);
        this.r = observableBoolean3;
        this.w = true;
        this.a = beautyView;
        this.s = exclusiveEffectManager;
        this.b = cameraBeautyModule;
        us.pinguo.camera2020.f.g gVar = (us.pinguo.camera2020.f.g) DataBindingUtil.bind(beautyView);
        this.f9279g = gVar;
        if (gVar != null) {
            gVar.g(observableBoolean2);
        }
        us.pinguo.camera2020.f.g gVar2 = this.f9279g;
        if (gVar2 != null) {
            gVar2.f(observableBoolean);
        }
        us.pinguo.camera2020.f.g gVar3 = this.f9279g;
        if (gVar3 != null) {
            gVar3.j(observableBoolean3);
        }
        us.pinguo.camera2020.f.g gVar4 = this.f9279g;
        if (gVar4 != null) {
            gVar4.b(observableInt);
        }
        us.pinguo.camera2020.f.g gVar5 = this.f9279g;
        if (gVar5 != null) {
            gVar5.h(new ObservableBoolean(false));
        }
        Context context = beautyView.getContext();
        kotlin.jvm.internal.s.g(context, "beautyView.context");
        this.f9278f = context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        int i2 = R.id.rvStyleMakeup;
        ((RecyclerView) beautyView.findViewById(i2)).setLayoutManager(linearLayoutManager);
        BeautyDataManager beautyDataManager = BeautyDataManager.a;
        MaterialResponse<StyleMakeup> value = beautyDataManager.p().getValue();
        List<StyleMakeup> suites = value == null ? null : value.getSuites();
        if (beautyDataManager.p().getValue() != null) {
            if (!(suites == null || suites.isEmpty())) {
                us.pinguo.common.m.h hVar = new us.pinguo.common.m.h(suites, false, false, 4, null);
                this.f9277e = hVar;
                if (hVar != null) {
                    hVar.d(observableBoolean2.get());
                }
                ((RecyclerView) beautyView.findViewById(i2)).setAdapter(this.f9277e);
                us.pinguo.common.m.h hVar2 = this.f9277e;
                if (hVar2 != null) {
                    hVar2.l(this);
                }
                o0();
            }
        }
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setOrientation(0);
        int i3 = R.id.rvSelfDefMakeup;
        ((RecyclerView) beautyView.findViewById(i3)).setLayoutManager(linearLayoutManager2);
        ((RecyclerView) beautyView.findViewById(i3)).setItemAnimator(new us.pinguo.camera2020.view.adapter.n());
        us.pinguo.camera2020.view.adapter.n nVar = new us.pinguo.camera2020.view.adapter.n();
        nVar.setMoveDuration(250L);
        nVar.setChangeDuration(250L);
        nVar.setAddDuration(250L);
        nVar.setRemoveDuration(250L);
        ((RecyclerView) beautyView.findViewById(i3)).setItemAnimator(nVar);
        Context context2 = beautyView.getContext();
        kotlin.jvm.internal.s.g(context2, "beautyView.context");
        us.pinguo.camera2020.view.adapter.j jVar = new us.pinguo.camera2020.view.adapter.j(context2, true);
        this.f9276d = jVar;
        jVar.o(cameraBeautyModule.N());
        jVar.q(this);
        ((RecyclerView) beautyView.findViewById(i3)).setAdapter(jVar);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(context);
        linearLayoutManager3.setOrientation(0);
        int i4 = R.id.rvBeauty;
        ((RecyclerView) beautyView.findViewById(i4)).setLayoutManager(linearLayoutManager3);
        Context context3 = beautyView.getContext();
        kotlin.jvm.internal.s.g(context3, "beautyView.context");
        us.pinguo.camera2020.view.adapter.j jVar2 = new us.pinguo.camera2020.view.adapter.j(context3, false);
        this.c = jVar2;
        jVar2.o(cameraBeautyModule.t());
        jVar2.q(this);
        ((RecyclerView) beautyView.findViewById(i4)).setAdapter(jVar2);
        beautyView.setOnClickListener(this);
        ((StickySeekBar) beautyView.findViewById(R.id.sbBeauty)).setTrackListener(this);
        ((AppCompatImageView) beautyView.findViewById(R.id.ivCompareToOriginal)).setOnTouchListener(this);
        ((AppCompatImageView) beautyView.findViewById(R.id.ivFilterAdjust)).setOnClickListener(this);
        ((AppCompatImageView) beautyView.findViewById(R.id.ivStyleMakeupAdjust)).setOnClickListener(this);
        ((AppCompatImageView) beautyView.findViewById(R.id.ivClear)).setOnClickListener(this);
        ((AutofitTextView) beautyView.findViewById(R.id.tvReset)).setOnClickListener(this);
        ((TextView) beautyView.findViewById(R.id.tvCancelStyleMakeup)).setOnClickListener(this);
        ((TextView) beautyView.findViewById(R.id.tvCancelSticker)).setOnClickListener(this);
        ((LinearLayout) beautyView.findViewById(R.id.llBeautyHint)).setOnClickListener(n.a);
        View findViewById = beautyView.findViewById(R.id.tbBeauty);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type us.pinguo.camera2020.view.BeautyTabLayout");
        ((BeautyTabLayout) findViewById).setOnBeautyTabClickListener(this);
        int i5 = us.pinguo.foundation.utils.n0.i() / 2;
        MakeupColorsAdapter makeupColorsAdapter = new MakeupColorsAdapter(context);
        this.m = makeupColorsAdapter;
        makeupColorsAdapter.k(this);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(context);
        linearLayoutManager4.setOrientation(0);
        int i6 = R.id.rvColors;
        ((RecyclerView) beautyView.findViewById(i6)).setLayoutManager(linearLayoutManager4);
        us.pinguo.camera2020.view.t2.a aVar = new us.pinguo.camera2020.view.t2.a();
        this.n = aVar;
        aVar.k(i5 - beautyView.getResources().getDimensionPixelSize(R.dimen.beauty_clear_width));
        Resources resources = beautyView.getResources();
        int i7 = R.dimen.make_up_colors_size_bigger;
        Resources resources2 = beautyView.getResources();
        int i8 = R.dimen.make_up_colors_size;
        aVar.j(resources.getDimensionPixelSize(i7) / resources2.getDimensionPixelSize(i8));
        makeupColorsAdapter.j(beautyView.getResources().getDimensionPixelSize(i7) / beautyView.getResources().getDimensionPixelSize(i8));
        aVar.i(beautyView.getResources().getDimensionPixelSize(R.dimen.beauty_color_item_gap_bigger) + beautyView.getResources().getDimensionPixelSize(R.dimen.beauty_color_item_gap) + (beautyView.getResources().getDimensionPixelSize(i8) / 2) + (beautyView.getResources().getDimensionPixelSize(i7) / 2));
        aVar.h(new a(beautyView, this, cameraBeautyModule));
        ((RecyclerView) beautyView.findViewById(i6)).setAdapter(makeupColorsAdapter);
        ((RecyclerView) beautyView.findViewById(i6)).addOnScrollListener(aVar);
        ((RecyclerView) beautyView.findViewById(i6)).addItemDecoration(new b(i5, beautyView, this));
        m0();
        n0();
        this.w = us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "key_auto_makeup", true, null, 4, null);
        jVar.g().set(this.w);
        cameraBeautyModule.g(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CameraBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        View view = this$0.a;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(CameraBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        View view = this$0.a;
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final CameraBeautyController this$0, final int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i3 = us.pinguo.foundation.utils.n0.i();
        Resources resources = this$0.a.getResources();
        int i4 = R.dimen.stylemakeup_clear_size;
        int dimensionPixelSize = ((i3 + resources.getDimensionPixelSize(i4)) / 2) - (this$0.a.getResources().getDimensionPixelSize(i4) + (this$0.a.getResources().getDimensionPixelSize(R.dimen.stylemakeup_rv_item_size) / 2));
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this$0.a.findViewById(R.id.rvStyleMakeup)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, dimensionPixelSize);
        this$0.a.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.l
            @Override // java.lang.Runnable
            public final void run() {
                CameraBeautyController.L(CameraBeautyController.this, i2);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(CameraBeautyController this$0, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) this$0.a.findViewById(R.id.rvStyleMakeup)).findViewHolderForAdapterPosition(i2);
        View view = findViewHolderForAdapterPosition == null ? null : findViewHolderForAdapterPosition.itemView;
        if (view == null) {
            return;
        }
        view.performClick();
    }

    private final void N() {
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.flSeekBar);
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivFilterAdjust)).setVisibility(8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivStyleMakeupAdjust)).setVisibility(8);
    }

    private final void Q(StyleMakeup styleMakeup) {
        if (this.f9280h.get() == 3) {
            StickySeekBar stickySeekBar = (StickySeekBar) this.a.findViewById(R.id.sbBeauty);
            Integer filterCurrentValue = styleMakeup.getFilterCurrentValue();
            stickySeekBar.setValues(0, 100, filterCurrentValue == null ? 60 : filterCurrentValue.intValue(), styleMakeup.getFilterDefaultValue());
        } else if (this.f9280h.get() == 0) {
            StickySeekBar stickySeekBar2 = (StickySeekBar) this.a.findViewById(R.id.sbBeauty);
            Integer makeupCurrentValue = styleMakeup.getMakeupCurrentValue();
            stickySeekBar2.setValues(0, 100, makeupCurrentValue == null ? 80 : makeupCurrentValue.intValue(), styleMakeup.getMakeupDefaultValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(CameraBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.camera2020.view.t2.a aVar = this$0.n;
        RecyclerView recyclerView = (RecyclerView) this$0.a.findViewById(R.id.rvColors);
        kotlin.jvm.internal.s.g(recyclerView, "beautyView.rvColors");
        aVar.f(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(CameraBeautyController this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((RecyclerView) this$0.a.findViewById(R.id.rvSelfDefMakeup)).smoothScrollBy(view.getLeft(), 0, new LinearInterpolator(), 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(CameraBeautyController this$0, View view, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((RecyclerView) this$0.a.findViewById(R.id.rvSelfDefMakeup)).smoothScrollBy((view.getLeft() + (view.getWidth() / 2)) - i2, 0, new LinearInterpolator(), 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(CameraBeautyController this$0, DialogInterface dialogInterface, int i2) {
        ObservableBoolean a2;
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.b.n0();
            BeautyData f2 = this$0.c.f();
            boolean z = false;
            if (f2 != null && f2.getBeautyType() == 1) {
                z = true;
            }
            if (z) {
                f2 = BeautyData.BeautyType.getNoneBeauty();
            }
            us.pinguo.camera2020.f.g gVar = this$0.f9279g;
            if (gVar != null) {
                gVar.c(f2);
            }
            ObservableField<Boolean> W = this$0.b.W();
            Boolean bool = Boolean.FALSE;
            W.set(bool);
            us.pinguo.camera2020.f.g gVar2 = this$0.f9279g;
            if (gVar2 != null && (a2 = gVar2.a()) != null) {
                Boolean bool2 = this$0.b.W().get();
                if (bool2 != null) {
                    bool = bool2;
                }
                a2.set(bool.booleanValue());
            }
            us.pinguo.camera2020.module.b bVar = this$0.s;
            if (bVar != null) {
                bVar.c(ExclusiveEffectType.EFFECT_SHAPE);
            }
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(CameraBeautyController this$0, DialogInterface dialogInterface, int i2) {
        ObservableBoolean a2;
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            boolean z = false;
            this$0.f9276d.g().set(false);
            this$0.f9276d.notifyItemChanged(0);
            this$0.m(false);
            this$0.b.p();
            this$0.f9276d.p();
            BeautyData f2 = this$0.c.f();
            if (f2 != null && f2.getBeautyType() == 1) {
                z = true;
            }
            if (!z) {
                f2 = BeautyData.BeautyType.getNoneBeauty();
            }
            us.pinguo.camera2020.f.g gVar = this$0.f9279g;
            if (gVar != null) {
                gVar.c(f2);
            }
            RecyclerView recyclerView = (RecyclerView) this$0.a.findViewById(R.id.rvColors);
            recyclerView.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView, 4);
            this$0.b.J().set(Boolean.FALSE);
            us.pinguo.camera2020.f.g gVar2 = this$0.f9279g;
            if (gVar2 != null && (a2 = gVar2.a()) != null) {
                a2.set(this$0.y0());
            }
            us.pinguo.camera2020.module.b bVar = this$0.s;
            if (bVar != null) {
                bVar.c(ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP);
            }
        }
        dialogInterface.cancel();
    }

    private final void m0() {
        ObservableBoolean a2;
        this.b.f0();
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar == null || (a2 = gVar.a()) == null) {
            return;
        }
        a2.set(kotlin.jvm.internal.s.c(this.b.W().get(), Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void n0() {
        ObservableBoolean a2;
        this.b.g0();
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar == null || (a2 = gVar.a()) == null) {
            return;
        }
        a2.set(y0());
    }

    private final void o0() {
        List<StyleMakeup> suites;
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        if (value == null || (suites = value.getSuites()) == null) {
            return;
        }
        for (StyleMakeup styleMakeup : suites) {
            ObservableBoolean isSelected = styleMakeup.isSelected();
            boolean z = false;
            if (isSelected != null && isSelected.get()) {
                z = true;
            }
            if (z) {
                this.b.L().setValue(styleMakeup);
            }
        }
    }

    private final void p0() {
        l(null, this.f9276d.e(), this.f9276d.f(), null, null, -1, -1);
    }

    private final void q0() {
        ObservableBoolean a2;
        this.f9280h.set(1);
        ((AppCompatImageView) this.a.findViewById(R.id.ivFilterAdjust)).setVisibility(8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivStyleMakeupAdjust)).setVisibility(8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivClear)).setVisibility(8);
        TextView textView = (TextView) this.a.findViewById(R.id.tvStyleMakeupNone);
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar != null && (a2 = gVar.a()) != null) {
            a2.set(y0());
        }
        ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setText(this.a.getResources().getString(R.string.beauty_clear));
        RecyclerView recyclerView = (RecyclerView) this.a.findViewById(R.id.rvStyleMakeup);
        recyclerView.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView, 4);
        ((AppCompatImageView) this.a.findViewById(R.id.ivCompareToOriginal)).setVisibility(0);
        RecyclerView recyclerView2 = (RecyclerView) this.a.findViewById(R.id.rvSelfDefMakeup);
        recyclerView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView2, 0);
        RecyclerView recyclerView3 = (RecyclerView) this.a.findViewById(R.id.rvBeauty);
        recyclerView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView3, 4);
        p(this.f9284l.get());
        h(this.f9283k.get());
    }

    private final void t() {
        ObservableBoolean isSelected;
        us.pinguo.camera2020.i.a.a.j(false);
        if (this.b.L().getValue() != null) {
            StyleMakeup value = this.b.L().getValue();
            if (value != null && (isSelected = value.isSelected()) != null) {
                isSelected.set(false);
            }
            BeautyDataManager.a.l().w(this.b.L().getValue());
        }
        if (this.b.z() != ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP) {
            this.b.q();
            if (this.b.z() != ExclusiveEffectType.EFFECT_SHAPE) {
                N();
            }
        }
        this.r.set(true);
    }

    private final void t0(final StyleMakeup styleMakeup) {
        us.pinguo.foundation.utils.w.i(this.f9278f, R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.view.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CameraBeautyController.u0(CameraBeautyController.this, styleMakeup, dialogInterface, i2);
            }
        });
    }

    private final void u(BeautyData beautyData) {
        this.b.j(beautyData, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(CameraBeautyController this$0, StyleMakeup styleMakeup, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(styleMakeup, "$styleMakeup");
        if (i2 == -1) {
            this$0.v(styleMakeup);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    private final void v(StyleMakeup styleMakeup) {
        ObservableField<MaterialInstallState> installState = styleMakeup.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        String pid = styleMakeup.getPid();
        if (pid == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.r0("camera_page", pid, "download_begin");
        this.b.r(pid, new CameraBeautyController$downStyleMakeup$1(styleMakeup, this));
    }

    private final void v0(StyleMakeup styleMakeup) {
        if (styleMakeup == null) {
            return;
        }
        Q(styleMakeup);
        FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.flSeekBar);
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
    }

    private final boolean w0(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            us.pinguo.camera2020.module.b bVar = this.s;
            y(!((bVar == null || bVar.b(ExclusiveEffectType.EFFECT_SHAPE)) ? false : true));
            us.pinguo.camera2020.module.b bVar2 = this.s;
            if ((bVar2 == null || bVar2.b(ExclusiveEffectType.EFFECT_SHAPE)) ? false : true) {
                LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
                linearLayout.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout, 0);
                ((TextView) this.a.findViewById(R.id.tvBeautyHint)).setText(this.a.getResources().getString(R.string.beauty_cancel_sticker_hint));
                TextView textView = (TextView) this.a.findViewById(R.id.tvCancelStyleMakeup);
                textView.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView, 8);
                TextView textView2 = (TextView) this.a.findViewById(R.id.tvCancelSticker);
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
                return true;
            }
            LinearLayout linearLayout2 = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
            linearLayout2.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout2, 4);
            return false;
        }
        us.pinguo.camera2020.module.b bVar3 = this.s;
        z(!((bVar3 == null || bVar3.b(ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP)) ? false : true));
        us.pinguo.camera2020.module.b bVar4 = this.s;
        if ((bVar4 == null || bVar4.b(ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP)) ? false : true) {
            LinearLayout linearLayout3 = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
            linearLayout3.setVisibility(0);
            VdsAgent.onSetViewVisibility(linearLayout3, 0);
            if (this.b.P() != ExclusiveEffectType.EFFECT_STYLED_MAKEUP && !this.b.a0()) {
                ((TextView) this.a.findViewById(R.id.tvBeautyHint)).setText(this.a.getResources().getString(R.string.selfdef_makeup_cancel_sticker_hint));
                TextView textView3 = (TextView) this.a.findViewById(R.id.tvCancelStyleMakeup);
                textView3.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView3, 8);
                TextView textView4 = (TextView) this.a.findViewById(R.id.tvCancelSticker);
                textView4.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView4, 0);
            } else {
                ((TextView) this.a.findViewById(R.id.tvBeautyHint)).setText(this.a.getResources().getString(R.string.selfdef_makeup_cancel_stylemakeup_hint));
                TextView textView5 = (TextView) this.a.findViewById(R.id.tvCancelStyleMakeup);
                textView5.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView5, 0);
                TextView textView6 = (TextView) this.a.findViewById(R.id.tvCancelSticker);
                textView6.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView6, 8);
                us.pinguo.common.m.h hVar = this.f9277e;
                if (hVar != null) {
                    hVar.notifyDataSetChanged();
                }
            }
            N();
            return true;
        }
        LinearLayout linearLayout4 = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
        linearLayout4.setVisibility(4);
        VdsAgent.onSetViewVisibility(linearLayout4, 4);
        return false;
    }

    private final void x0() {
        StyleMakeup value = this.b.C().getValue();
        if (value == null) {
            N();
        } else if (value.isInstalled()) {
            if (this.f9280h.get() == 0 || this.f9280h.get() == 3) {
                ((AppCompatImageView) this.a.findViewById(R.id.ivFilterAdjust)).setVisibility(0);
                ((AppCompatImageView) this.a.findViewById(R.id.ivStyleMakeupAdjust)).setVisibility(0);
                ((AppCompatImageView) this.a.findViewById(R.id.ivCompareToOriginal)).setVisibility(8);
                v0(value);
            }
        } else {
            N();
            ((AppCompatImageView) this.a.findViewById(R.id.ivFilterAdjust)).setVisibility(8);
            ((AppCompatImageView) this.a.findViewById(R.id.ivStyleMakeupAdjust)).setVisibility(8);
        }
    }

    private final void y(boolean z) {
        if (z) {
            ((RecyclerView) this.a.findViewById(R.id.rvBeauty)).setAlpha(1.0f);
            ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setAlpha(1.0f);
            return;
        }
        ((RecyclerView) this.a.findViewById(R.id.rvBeauty)).setAlpha(0.2f);
        ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setAlpha(0.2f);
    }

    private final boolean y0() {
        return kotlin.jvm.internal.s.c(this.b.J().get(), Boolean.TRUE) || this.f9276d.g().get();
    }

    private final void z(boolean z) {
        if (z) {
            ((RecyclerView) this.a.findViewById(R.id.rvSelfDefMakeup)).setAlpha(1.0f);
            ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setAlpha(1.0f);
            ((RecyclerView) this.a.findViewById(R.id.rvColors)).setAlpha(1.0f);
            return;
        }
        ((RecyclerView) this.a.findViewById(R.id.rvSelfDefMakeup)).setAlpha(0.2f);
        ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setAlpha(0.2f);
        ((RecyclerView) this.a.findViewById(R.id.rvColors)).setAlpha(0.2f);
    }

    public final void A() {
        if (this.a.getVisibility() == 0) {
            return;
        }
        this.a.animate().alpha(1.0f).setDuration(400L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.u
            @Override // java.lang.Runnable
            public final void run() {
                CameraBeautyController.B(CameraBeautyController.this);
            }
        }).start();
    }

    public final void C() {
        if (this.a.getVisibility() == 0) {
            this.a.animate().alpha(0.0f).setDuration(400L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.v
                @Override // java.lang.Runnable
                public final void run() {
                    CameraBeautyController.F(CameraBeautyController.this);
                }
            }).start();
        }
    }

    @Override // us.pinguo.common.h
    public int D() {
        return this.f9278f.getResources().getDimensionPixelSize(R.dimen.beauty_adjust_bar_height);
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (event.c() == EventType.TOUCH_UP || event.c() == EventType.BACK_PRESS || event.c() == EventType.DOUBLE_CLICK) {
            if (this.q) {
                if (this.a.getVisibility() == 0) {
                    M();
                    return true;
                }
            }
            if (this.q) {
                if (!(this.a.getVisibility() == 0)) {
                    A();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // us.pinguo.common.h
    public int G() {
        return this.f9278f.getResources().getDimensionPixelSize(R.dimen.beauty_tab_height);
    }

    public final ObservableInt H() {
        return this.f9280h;
    }

    public final void I(String styleMakeupId) {
        List<StyleMakeup> suites;
        kotlin.jvm.internal.s.h(styleMakeupId, "styleMakeupId");
        final int i2 = 0;
        this.f9280h.set(0);
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        if (value == null || (suites = value.getSuites()) == null) {
            return;
        }
        for (Object obj : suites) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                if (kotlin.jvm.internal.s.c(((StyleMakeup) obj).getPid(), styleMakeupId)) {
                    RecyclerView recyclerView = (RecyclerView) this.a.findViewById(R.id.rvStyleMakeup);
                    kotlin.jvm.internal.s.g(recyclerView, "beautyView.rvStyleMakeup");
                    us.pinguo.foundation.ui.c.b(recyclerView, new Runnable() { // from class: us.pinguo.camera2020.view.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraBeautyController.K(CameraBeautyController.this, i2);
                        }
                    });
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        int h2;
        this.f9282j.set(z);
        if (z) {
            h2 = us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_black);
        } else {
            h2 = us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_light);
        }
        View view = this.a;
        int i2 = R.id.sbBeauty;
        ((StickySeekBar) view.findViewById(i2)).setMainColor(h2);
        ((StickySeekBar) this.a.findViewById(i2)).setIndicatorColor(h2);
    }

    public final void M() {
        this.q = false;
        C();
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    public final void P(int i2) {
        int b2;
        b2 = kotlin.y.c.b(us.pinguo.foundation.utils.n0.b(3.5f));
        this.v = i2 + b2;
        ConstraintSet constraintSet = new ConstraintSet();
        View view = this.a;
        int i3 = R.id.makeupPanel;
        constraintSet.clone((ConstraintLayout) view.findViewById(i3));
        View view2 = this.a;
        int i4 = R.id.clColors;
        constraintSet.setMargin(((ConstraintLayout) view2.findViewById(i4)).getId(), 4, this.v);
        constraintSet.connect(((ConstraintLayout) this.a.findViewById(i4)).getId(), 4, ((ConstraintLayout) this.a.findViewById(i3)).getId(), 4);
        constraintSet.applyTo((ConstraintLayout) this.a.findViewById(i3));
    }

    public final boolean R() {
        return this.q;
    }

    public final boolean S() {
        return this.f9280h.get() == 0;
    }

    @Override // us.pinguo.common.m.h.b
    public void a() {
    }

    @Override // us.pinguo.ui.widget.h
    public void b(int i2) {
        if (this.f9280h.get() == 2) {
            m0();
        } else if (this.f9280h.get() == 1) {
            n0();
        } else {
            BeautyDataManager.a.l().w(this.b.C().getValue());
        }
    }

    @Override // us.pinguo.ui.widget.h
    public void c(int i2) {
        int i3 = this.f9280h.get();
        if (i3 == 0) {
            StyleMakeup value = this.b.C().getValue();
            if (value != null) {
                value.setMakeupCurrentValue(Integer.valueOf(i2));
            }
            this.b.o(i2);
        } else if (i3 != 3) {
            this.b.l(i2);
        } else {
            StyleMakeup value2 = this.b.C().getValue();
            if (value2 != null) {
                value2.setFilterCurrentValue(Integer.valueOf(i2));
            }
            this.b.n(i2);
        }
    }

    @Override // us.pinguo.camera2020.view.adapter.l
    public void d(View itemView, int i2, String color1, String color2) {
        int b2;
        kotlin.jvm.internal.s.h(itemView, "itemView");
        kotlin.jvm.internal.s.h(color1, "color1");
        kotlin.jvm.internal.s.h(color2, "color2");
        float left = itemView.getLeft() + (itemView.getWidth() * 0.5f);
        View view = this.a;
        int i3 = R.id.rvColors;
        b2 = kotlin.y.c.b(left - ((us.pinguo.foundation.utils.n0.i() * 0.5f) - ((RecyclerView) view.findViewById(i3)).getLeft()));
        ((RecyclerView) this.a.findViewById(i3)).smoothScrollBy(b2, 0);
        this.b.m(i2);
    }

    @Override // us.pinguo.camera2020.view.BeautyTabLayout.a
    public void e() {
        ObservableBoolean a2;
        us.pinguo.foundation.statistics.h.b.C0("beauty", "show");
        this.f9280h.set(2);
        ((AppCompatImageView) this.a.findViewById(R.id.ivFilterAdjust)).setVisibility(8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivStyleMakeupAdjust)).setVisibility(8);
        ((AppCompatImageView) this.a.findViewById(R.id.ivClear)).setVisibility(8);
        TextView textView = (TextView) this.a.findViewById(R.id.tvStyleMakeupNone);
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar != null && (a2 = gVar.a()) != null) {
            a2.set(kotlin.jvm.internal.s.c(this.b.W().get(), Boolean.TRUE));
        }
        RecyclerView recyclerView = (RecyclerView) this.a.findViewById(R.id.rvStyleMakeup);
        recyclerView.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView, 4);
        RecyclerView recyclerView2 = (RecyclerView) this.a.findViewById(R.id.rvSelfDefMakeup);
        recyclerView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView2, 4);
        ((AppCompatImageView) this.a.findViewById(R.id.ivCompareToOriginal)).setVisibility(0);
        RecyclerView recyclerView3 = (RecyclerView) this.a.findViewById(R.id.rvBeauty);
        recyclerView3.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView3, 0);
        ((AutofitTextView) this.a.findViewById(R.id.tvReset)).setText(this.a.getResources().getString(R.string.beauty_reset));
        RecyclerView recyclerView4 = (RecyclerView) this.a.findViewById(R.id.rvColors);
        recyclerView4.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView4, 4);
        p(this.f9284l.get());
        h(this.f9283k.get());
        if (w0(this.f9280h.get())) {
            return;
        }
        BeautyData f2 = this.c.f();
        l(null, null, f2, null, null, -1, -1);
        if (f2 == null) {
            us.pinguo.camera2020.f.g gVar2 = this.f9279g;
            if (gVar2 == null) {
                return;
            }
            gVar2.c(BeautyData.BeautyType.getNoneBeauty());
            return;
        }
        us.pinguo.camera2020.f.g gVar3 = this.f9279g;
        if (gVar3 == null) {
            return;
        }
        gVar3.c(f2);
    }

    @Override // us.pinguo.common.m.h.b
    public void f(View view, StyleMakeup styleMakeup, boolean z) {
        if (styleMakeup == null) {
            N();
            return;
        }
        Plan icon_ab = styleMakeup.getIcon_ab();
        if (icon_ab != null) {
            if (!kotlin.jvm.internal.s.c(icon_ab.getGid(), "gid_default")) {
                if (!kotlin.jvm.internal.s.c(icon_ab.getTid(), "tid_default")) {
                    us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                    String gid = icon_ab.getGid();
                    String str = gid != null ? gid : "gid_default";
                    String tid = icon_ab.getTid();
                    iVar.D(str, "camera_page", tid != null ? tid : "tid_default", "click");
                }
            }
        }
        us.pinguo.foundation.statistics.h.b.r0("camera_page", styleMakeup.getPid(), "click");
        this.b.s0(z ? ChangeStatus.CLICK_LEFT : ChangeStatus.CLICK_RIGHT);
        boolean z2 = !this.b.b0(styleMakeup);
        this.t = styleMakeup;
        if (view != null) {
            this.b.l0(styleMakeup, new CameraBeautyController$onStyleMakeupItemClick$1(this, styleMakeup));
        } else {
            z2 = false;
            x0();
        }
        if (z2) {
            ObservableField<MaterialInstallState> installState = styleMakeup.getInstallState();
            if ((installState == null ? null : installState.get()) != MaterialInstallState.STATE_DOWNLOADING) {
                N();
                if (us.pinguo.util.q.f(this.f9278f)) {
                    if (!us.pinguo.util.q.h(this.f9278f) && !us.pinguo.repository2020.m.a.C()) {
                        t0(styleMakeup);
                        return;
                    } else {
                        v(styleMakeup);
                        return;
                    }
                }
                us.pinguo.foundation.utils.k0.a.a(R.string.no_network_connection_toast);
            }
        }
    }

    @Override // us.pinguo.camera2020.view.BeautyTabLayout.a
    public void g() {
        us.pinguo.foundation.statistics.h.b.C0("makeup", "show");
        q0();
        if (w0(this.f9280h.get())) {
            return;
        }
        p0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00da, code lost:
        if (r3 != 3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r3 != 3) goto L8;
     */
    @Override // us.pinguo.common.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(boolean r5) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.CameraBeautyController.h(boolean):void");
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        h.a.e(this, z);
    }

    @Override // us.pinguo.camera2020.view.BeautyTabLayout.a
    public void j() {
        ObservableBoolean a2;
        us.pinguo.foundation.statistics.h.b.C0("looks", "show");
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
        linearLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(linearLayout, 4);
        this.f9280h.set(this.f9281i.get());
        ((AppCompatImageView) this.a.findViewById(R.id.ivClear)).setVisibility(0);
        TextView textView = (TextView) this.a.findViewById(R.id.tvStyleMakeupNone);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar != null && (a2 = gVar.a()) != null) {
            a2.set(false);
        }
        View view = this.a;
        int i2 = R.id.rvColors;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(i2);
        recyclerView.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView, 4);
        RecyclerView recyclerView2 = (RecyclerView) this.a.findViewById(R.id.rvStyleMakeup);
        recyclerView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView2, 0);
        RecyclerView recyclerView3 = (RecyclerView) this.a.findViewById(R.id.rvSelfDefMakeup);
        recyclerView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView3, 4);
        ((AppCompatImageView) this.a.findViewById(R.id.ivCompareToOriginal)).setVisibility(8);
        RecyclerView recyclerView4 = (RecyclerView) this.a.findViewById(R.id.rvBeauty);
        recyclerView4.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView4, 4);
        RecyclerView recyclerView5 = (RecyclerView) this.a.findViewById(i2);
        recyclerView5.setVisibility(4);
        VdsAgent.onSetViewVisibility(recyclerView5, 4);
        p(this.f9284l.get());
        h(this.f9283k.get());
        x0();
    }

    public final void j0(BeautyData beautyData) {
        if (beautyData != null) {
            int h2 = this.c.h(beautyData);
            View view = this.a;
            int i2 = R.id.rvBeauty;
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(i2)).getLayoutManager();
            View findViewByPosition = layoutManager == null ? null : layoutManager.findViewByPosition(h2);
            int i3 = us.pinguo.foundation.utils.n0.i() / 2;
            if (findViewByPosition != null) {
                ((RecyclerView) this.a.findViewById(i2)).smoothScrollBy((findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2)) - i3, 0);
                return;
            }
            int dimensionPixelSize = i3 - (this.a.getResources().getDimensionPixelSize(R.dimen.make_up_size) / 2);
            RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) this.a.findViewById(i2)).getLayoutManager();
            Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(h2, dimensionPixelSize);
        }
    }

    @Override // us.pinguo.ui.widget.h
    public void k(float f2) {
        h.a.a(this, f2);
    }

    public final void k0(BeautyData beautyData) {
        if (beautyData == null || beautyData.isGroup()) {
            return;
        }
        int h2 = this.f9276d.h(beautyData);
        View view = this.a;
        int i2 = R.id.rvSelfDefMakeup;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(i2)).getLayoutManager();
        View findViewByPosition = layoutManager == null ? null : layoutManager.findViewByPosition(h2);
        int i3 = us.pinguo.foundation.utils.n0.i() / 2;
        if (findViewByPosition != null) {
            ((RecyclerView) this.a.findViewById(i2)).smoothScrollBy((findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2)) - i3, 0);
            return;
        }
        int dimensionPixelSize = i3 - (this.a.getResources().getDimensionPixelSize(R.dimen.make_up_size) / 2);
        RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) this.a.findViewById(i2)).getLayoutManager();
        Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(h2, dimensionPixelSize);
    }

    @Override // us.pinguo.camera2020.view.adapter.j.b
    public void l(final View view, BeautyData beautyData, BeautyData beautyData2, BeautyData beautyData3, Boolean bool, int i2, int i3) {
        List<String> colorList;
        BeautyData beautyData4;
        boolean C;
        int b2;
        if (this.f9280h.get() == 1) {
            n0();
        } else if (this.f9280h.get() == 2) {
            m0();
        }
        if (beautyData2 == null) {
            N();
            return;
        }
        final int i4 = us.pinguo.foundation.utils.n0.i() / 2;
        BeautyData beautyData5 = null;
        if (beautyData != null && beautyData.isGroup()) {
            if (beautyData.isExtended().get()) {
                if (beautyData.getColorList() == null || !(!colorList.isEmpty())) {
                    beautyData4 = null;
                } else {
                    beautyData2.setColorIndex(beautyData.getColorIndex());
                    beautyData4 = beautyData;
                }
                if (beautyData4 == null) {
                    beautyData4 = beautyData2;
                }
                List<String> colorList2 = beautyData4.getColorList();
                if (!(colorList2 == null || colorList2.isEmpty())) {
                    C = StringsKt__StringsKt.C(beautyData2.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
                    if (!C) {
                        this.m.i(colorList2, beautyData4.getColorIndex());
                        View view2 = this.a;
                        int i5 = R.id.rvColors;
                        RecyclerView recyclerView = (RecyclerView) view2.findViewById(i5);
                        recyclerView.setVisibility(0);
                        VdsAgent.onSetViewVisibility(recyclerView, 0);
                        b2 = kotlin.y.c.b(this.a.getResources().getDimensionPixelSize(R.dimen.beauty_clear_width) + (this.a.getResources().getDimensionPixelSize(R.dimen.make_up_colors_size) / 2.0f) + this.a.getResources().getDimensionPixelSize(R.dimen.beauty_color_item_gap_bigger));
                        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.a.findViewById(i5)).getLayoutManager();
                        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(beautyData4.getColorIndex(), i4 - b2);
                        RecyclerView recyclerView2 = (RecyclerView) this.a.findViewById(i5);
                        kotlin.jvm.internal.s.g(recyclerView2, "beautyView.rvColors");
                        us.pinguo.foundation.ui.c.b(recyclerView2, new Runnable() { // from class: us.pinguo.camera2020.view.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                CameraBeautyController.e0(CameraBeautyController.this);
                            }
                        });
                        beautyData5 = beautyData4;
                    }
                }
                RecyclerView recyclerView3 = (RecyclerView) this.a.findViewById(R.id.rvColors);
                recyclerView3.setVisibility(4);
                VdsAgent.onSetViewVisibility(recyclerView3, 4);
                beautyData5 = beautyData4;
            } else {
                RecyclerView recyclerView4 = (RecyclerView) this.a.findViewById(R.id.rvColors);
                recyclerView4.setVisibility(4);
                VdsAgent.onSetViewVisibility(recyclerView4, 4);
                FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.flSeekBar);
                frameLayout.setVisibility(8);
                VdsAgent.onSetViewVisibility(frameLayout, 8);
            }
        }
        if (view != null && beautyData2.getBeautyType() == 1 && bool != null && bool.booleanValue() && beautyData != null) {
            if (beautyData.isExtended().get()) {
                this.p.d(true);
                this.p.f(i2);
                this.p.e(i3);
                this.a.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraBeautyController.f0(CameraBeautyController.this, view);
                    }
                }, 1L);
            } else {
                this.a.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraBeautyController.g0(CameraBeautyController.this, view, i4);
                    }
                }, 1L);
                this.p.d(false);
            }
            View view3 = this.a;
            int i6 = R.id.rvSelfDefMakeup;
            ((RecyclerView) view3.findViewById(i6)).removeItemDecoration(this.p);
            ((RecyclerView) this.a.findViewById(i6)).addItemDecoration(this.p);
        }
        if (!beautyData2.isGroup()) {
            u(beautyData2);
            us.pinguo.foundation.statistics.h.b.w0(beautyData2.getBeautyKey(), "click");
            if (beautyData3 != null) {
                BeautyDataManager.a.l().v(beautyData3);
            }
        } else {
            BeautyDataManager.a.l().v(beautyData2);
        }
        this.o = beautyData5;
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar == null) {
            return;
        }
        gVar.c(beautyData2);
    }

    public final void l0(StyleMakeup styleMakeup) {
        List<StyleMakeup> suites;
        if (styleMakeup != null) {
            MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
            Integer valueOf = (value == null || (suites = value.getSuites()) == null) ? null : Integer.valueOf(suites.indexOf(styleMakeup));
            if (valueOf != null) {
                valueOf.intValue();
                View view = this.a;
                int i2 = R.id.rvStyleMakeup;
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(i2)).getLayoutManager();
                View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(valueOf.intValue()) : null;
                if (findViewByPosition != null) {
                    ((RecyclerView) this.a.findViewById(i2)).smoothScrollBy(((findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2)) + (this.a.getResources().getDimensionPixelSize(R.dimen.stylemakeup_clear_size) - us.pinguo.foundation.utils.n0.c(6))) - (us.pinguo.foundation.utils.n0.i() / 2), 0);
                } else {
                    int i3 = us.pinguo.foundation.utils.n0.i();
                    Resources resources = this.a.getResources();
                    int i4 = R.dimen.stylemakeup_clear_size;
                    int dimensionPixelSize = ((i3 + resources.getDimensionPixelSize(i4)) / 2) - (this.a.getResources().getDimensionPixelSize(i4) + (this.a.getResources().getDimensionPixelSize(R.dimen.stylemakeup_rv_item_size) / 2));
                    RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) this.a.findViewById(i2)).getLayoutManager();
                    Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(valueOf.intValue(), dimensionPixelSize);
                }
            }
            this.r.set(false);
            this.b.e0(styleMakeup);
            x0();
            return;
        }
        t();
    }

    @Override // us.pinguo.camera2020.view.adapter.j.b
    public void m(boolean z) {
        ObservableBoolean a2;
        if (1 != this.f9280h.get()) {
            return;
        }
        us.pinguo.camera2020.f.g gVar = this.f9279g;
        if (gVar != null && (a2 = gVar.a()) != null) {
            a2.set(y0());
        }
        this.b.g(z);
        us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "key_auto_makeup", z, null, 4, null);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View v) {
        VdsAgent.onClick(this, v);
        kotlin.jvm.internal.s.h(v, "v");
        int id = v.getId();
        if (id == R.id.ivFilterAdjust) {
            this.f9281i.set(3);
            this.f9280h.set(3);
            v0(this.b.C().getValue());
        } else if (id == R.id.ivStyleMakeupAdjust) {
            this.f9281i.set(0);
            this.f9280h.set(0);
            v0(this.b.C().getValue());
        } else if (id == R.id.tvReset) {
            if (this.f9280h.get() == 2) {
                if (kotlin.jvm.internal.s.c(this.b.W().get(), Boolean.TRUE)) {
                    us.pinguo.foundation.utils.w.i(this.f9278f, R.string.hint_reset_beauty_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.view.r
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            CameraBeautyController.h0(CameraBeautyController.this, dialogInterface, i2);
                        }
                    });
                }
            } else if (this.f9280h.get() == 1) {
                if (kotlin.jvm.internal.s.c(this.b.J().get(), Boolean.TRUE) || this.f9276d.g().get()) {
                    us.pinguo.foundation.utils.w.i(this.f9278f, R.string.hint_clear_selfdef_makeup_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.view.p
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            CameraBeautyController.i0(CameraBeautyController.this, dialogInterface, i2);
                        }
                    });
                }
            }
        } else if (id == R.id.ivClear) {
            N();
            this.b.C().setValue(null);
            us.pinguo.camera2020.module.b bVar = this.s;
            if (bVar != null) {
                bVar.c(ExclusiveEffectType.EFFECT_STYLED_MAKEUP);
            }
            us.pinguo.foundation.statistics.h.b.r0("camera_page", "non", "click");
        } else if (id == R.id.tvCancelStyleMakeup) {
            this.b.C().setValue(null);
            us.pinguo.camera2020.module.b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.c(ExclusiveEffectType.EFFECT_STYLED_MAKEUP);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
            linearLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout, 4);
            this.f9280h.set(this.f9281i.get());
            us.pinguo.common.m.h hVar = this.f9277e;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
            g();
        } else if (id == R.id.tvCancelSticker) {
            kotlin.jvm.b.a<kotlin.u> v2 = this.b.v();
            if (v2 != null) {
                v2.invoke();
            }
            us.pinguo.camera2020.module.b bVar3 = this.s;
            if (bVar3 != null) {
                bVar3.c(ExclusiveEffectType.EFFECT_STICKER);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.a.findViewById(R.id.llBeautyHint);
            linearLayout2.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout2, 4);
            q0();
            p0();
            if (this.f9280h.get() == 1) {
                z(true);
            } else if (this.f9280h.get() == 2) {
                y(true);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            this.b.Z().setValue(Boolean.TRUE);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.b.Z().setValue(Boolean.FALSE);
        }
        return true;
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        this.f9284l.set(z);
        View view = this.a;
        int i2 = R.id.rvSelfDefMakeup;
        if (((RecyclerView) view.findViewById(i2)).getAdapter() != null) {
            RecyclerView.Adapter adapter = ((RecyclerView) this.a.findViewById(i2)).getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type us.pinguo.common.adapter.IBeautyAdapter");
            ((us.pinguo.common.m.e) adapter).d(this.f9284l.get());
        }
        View view2 = this.a;
        int i3 = R.id.rvStyleMakeup;
        if (((RecyclerView) view2.findViewById(i3)).getAdapter() != null) {
            RecyclerView.Adapter adapter2 = ((RecyclerView) this.a.findViewById(i3)).getAdapter();
            Objects.requireNonNull(adapter2, "null cannot be cast to non-null type us.pinguo.common.adapter.IBeautyAdapter");
            ((us.pinguo.common.m.e) adapter2).d(this.f9284l.get());
        }
        View view3 = this.a;
        int i4 = R.id.rvBeauty;
        if (((RecyclerView) view3.findViewById(i4)).getAdapter() != null) {
            RecyclerView.Adapter adapter3 = ((RecyclerView) this.a.findViewById(i4)).getAdapter();
            Objects.requireNonNull(adapter3, "null cannot be cast to non-null type us.pinguo.common.adapter.IBeautyAdapter");
            ((us.pinguo.common.m.e) adapter3).d(this.f9284l.get());
        }
    }

    public final void r0(kotlin.jvm.b.a<? extends ArrayList<String>> aVar) {
        this.u = aVar;
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return this.q;
    }

    public final void s0() {
        this.q = true;
        w0(this.f9280h.get());
        A();
        int i2 = this.f9280h.get();
        if (i2 == 1) {
            g();
        } else if (i2 != 2) {
            j();
        } else {
            e();
        }
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        View view = this.a;
        int i3 = R.id.clAdjust;
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) view.findViewById(i3)).getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2;
        ((ConstraintLayout) this.a.findViewById(i3)).setLayoutParams(layoutParams2);
    }

    @Override // us.pinguo.common.h
    public int x() {
        return this.a.getResources().getDimensionPixelSize(R.dimen.stylemakeup_body_height) + this.v;
    }
}
