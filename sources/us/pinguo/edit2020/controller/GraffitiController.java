package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.n0;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.edit2020.widget.SlidiablePanelView;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.manager.MaterialDataManager;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.BrushBuilder;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: GraffitiController.kt */
/* loaded from: classes4.dex */
public final class GraffitiController implements i3, e3, us.pinguo.edit2020.view.p0, a3, g3 {
    private static final int t = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_max_in_discrete_mode);
    private static final int u = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_min_in_discrete_mode);
    private final us.pinguo.edit2020.viewmodel.module.d a;
    private final FrameLayout b;
    private final us.pinguo.edit2020.utils.g c;

    /* renamed from: d  reason: collision with root package name */
    private final PGEditBottomTabLayout f10366d;

    /* renamed from: e  reason: collision with root package name */
    private final BoldTipView f10367e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f10368f;

    /* renamed from: g  reason: collision with root package name */
    private final SlidiablePanelView f10369g;

    /* renamed from: h  reason: collision with root package name */
    private final us.pinguo.edit2020.databinding.o f10370h;

    /* renamed from: i  reason: collision with root package name */
    private final PaintEraserAdjustLayout2 f10371i;

    /* renamed from: j  reason: collision with root package name */
    private BasicBrushMode f10372j;

    /* renamed from: k  reason: collision with root package name */
    private final Handler f10373k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.edit2020.bean.u0 f10374l;
    private float m;
    private int n;
    private int o;
    private float p;
    private Integer[] q;
    private boolean r;
    private boolean s;

    /* compiled from: GraffitiController.kt */
    /* renamed from: us.pinguo.edit2020.controller.GraffitiController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<ShapeDirectionView, kotlin.u> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(ShapeDirectionView shapeDirectionView) {
            invoke2(shapeDirectionView);
            return kotlin.u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ShapeDirectionView it) {
            kotlin.jvm.internal.s.h(it, "it");
            it.setSinglePointMode(true);
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements PaintEraserAdjustLayout2.a {
        a() {
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.a
        public void a() {
            ObservableBoolean isSelected;
            BasicBrushMode basicBrushMode = GraffitiController.this.f10372j;
            BasicBrushMode basicBrushMode2 = BasicBrushMode.Erasing;
            if (basicBrushMode != basicBrushMode2) {
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode2);
                GraffitiController.this.f10372j = basicBrushMode2;
                GraffitiController graffitiController = GraffitiController.this;
                graffitiController.n = graffitiController.T();
                GraffitiController.this.f10371i.setSizeProgress(GraffitiController.this.n);
                GraffitiController.this.a.l().setValue(GraffitiController.this.a.i().getValue());
                Graffiti value = GraffitiController.this.a.i().getValue();
                if (value != null && (isSelected = value.isSelected()) != null) {
                    isSelected.set(false);
                }
                GraffitiController.this.a.i().setValue(null);
                GraffitiController.this.c0(false);
            }
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.a
        public void b() {
            ObservableBoolean isSelected;
            BasicBrushMode basicBrushMode = GraffitiController.this.f10372j;
            BasicBrushMode basicBrushMode2 = BasicBrushMode.Brush;
            if (basicBrushMode != basicBrushMode2) {
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode2);
                GraffitiController.this.f10372j = basicBrushMode2;
                GraffitiController graffitiController = GraffitiController.this;
                graffitiController.n = graffitiController.T();
                GraffitiController.this.f10371i.setSizeProgress(GraffitiController.this.n);
                if (GraffitiController.this.a.l().getValue() != null) {
                    GraffitiController.this.a.i().setValue(GraffitiController.this.a.l().getValue());
                    Graffiti value = GraffitiController.this.a.i().getValue();
                    if (value != null && (isSelected = value.isSelected()) != null) {
                        isSelected.set(true);
                    }
                }
                GraffitiController.this.c0(false);
            }
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements PaintEraserAdjustLayout2.b {
        b() {
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.b
        public void a() {
            UnityEditCaller.Common.movePrevious();
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.b
        public void b() {
            UnityEditCaller.Common.moveNext();
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements PaintEraserAdjustLayout2.c {
        final /* synthetic */ Runnable b;

        c(Runnable runnable) {
            this.b = runnable;
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.c
        public void a(int i2, String type) {
            kotlin.jvm.internal.s.h(type, "type");
            if (kotlin.jvm.internal.s.c(type, BigAlbumStore.PhotoColumns.SIZE)) {
                GraffitiController.this.n = i2;
                GraffitiController.this.U().animate().cancel();
                GraffitiController.this.U().setAlpha(1.0f);
                GraffitiController.this.f10373k.removeCallbacks(this.b);
                BoldTipView U = GraffitiController.this.U();
                U.setVisibility(0);
                VdsAgent.onSetViewVisibility(U, 0);
                GraffitiController.this.b0();
            }
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.c
        public void b(int i2, String type) {
            kotlin.jvm.internal.s.h(type, "type");
            if (kotlin.jvm.internal.s.c(type, BigAlbumStore.PhotoColumns.SIZE)) {
                GraffitiController.this.c0(true);
                GraffitiController.this.f10373k.postDelayed(this.b, 500L);
                return;
            }
            GraffitiController.this.a.s(Float.valueOf(i2 / 100.0f));
            GraffitiController.this.f10371i.setAlphaProgress(i2);
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements n0.b {
        final /* synthetic */ Context b;

        d(Context context) {
            this.b = context;
        }

        @Override // us.pinguo.edit2020.adapter.n0.b
        public void a(View view, int i2, PaintMaterial paintMaterial) {
            boolean z;
            boolean m;
            kotlin.jvm.internal.s.h(paintMaterial, "paintMaterial");
            if (paintMaterial.isInstalled()) {
                GraffitiController graffitiController = GraffitiController.this;
                if (view != null) {
                    m = kotlin.collections.n.m(graffitiController.q, paintMaterial.getBrushSourceType());
                    if (!m) {
                        z = true;
                        graffitiController.a0(paintMaterial, z);
                    }
                }
                z = false;
                graffitiController.a0(paintMaterial, z);
            } else if (us.pinguo.util.q.f(this.b)) {
                Context context = this.b;
                kotlin.jvm.internal.s.g(context, "context");
                if (us.pinguo.util.q.h(context) || us.pinguo.repository2020.m.a.C()) {
                    GraffitiController.this.L(paintMaterial);
                } else {
                    GraffitiController.this.g0(paintMaterial);
                }
            } else {
                us.pinguo.foundation.utils.k0.a.a(R.string.download_not_network);
            }
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BasicBrushMode.values().length];
            iArr[BasicBrushMode.Brush.ordinal()] = 1;
            iArr[BasicBrushMode.Erasing.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class f implements PGEditTabLayout.d {
        f() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f fVar) {
            GraffitiController.this.o = fVar == null ? 0 : fVar.i();
            GraffitiController graffitiController = GraffitiController.this;
            graffitiController.f0(graffitiController.o);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    /* compiled from: GraffitiController.kt */
    /* loaded from: classes4.dex */
    public static final class g implements us.pinguo.edit2020.adapter.m0 {
        final /* synthetic */ PaintMaterial a;
        final /* synthetic */ GraffitiController b;

        g(PaintMaterial paintMaterial, GraffitiController graffitiController) {
            this.a = paintMaterial;
            this.b = graffitiController;
        }

        @Override // us.pinguo.edit2020.adapter.m0
        public void a(View view, int i2, String color) {
            kotlin.jvm.internal.s.h(color, "color");
            this.a.setBrushColor(color);
            this.b.a.r(color);
        }
    }

    public GraffitiController(us.pinguo.edit2020.viewmodel.module.d editGraffitiModule, FrameLayout flPanelContainer, us.pinguo.edit2020.utils.g magnifierUtils, PGEditBottomTabLayout tabLayout, BoldTipView imgBoldTip, ImageView ivCompareOriginal) {
        kotlin.jvm.internal.s.h(editGraffitiModule, "editGraffitiModule");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(imgBoldTip, "imgBoldTip");
        kotlin.jvm.internal.s.h(ivCompareOriginal, "ivCompareOriginal");
        this.a = editGraffitiModule;
        this.b = flPanelContainer;
        this.c = magnifierUtils;
        this.f10366d = tabLayout;
        this.f10367e = imgBoldTip;
        this.f10368f = ivCompareOriginal;
        Context context = flPanelContainer.getContext();
        kotlin.jvm.internal.s.g(context, "flPanelContainer.context");
        SlidiablePanelView slidiablePanelView = new SlidiablePanelView(context, null, 0, FunctionType.GRAFFITI, Boolean.valueOf(editGraffitiModule.o()), 6, null);
        this.f10369g = slidiablePanelView;
        us.pinguo.edit2020.databinding.o oVar = (us.pinguo.edit2020.databinding.o) DataBindingUtil.inflate(LayoutInflater.from(flPanelContainer.getContext()), R.layout.layout_adjust_paint_style, null, false);
        this.f10370h = oVar;
        PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = (PaintEraserAdjustLayout2) oVar.getRoot();
        this.f10371i = paintEraserAdjustLayout2;
        this.f10372j = BasicBrushMode.None;
        this.f10373k = new Handler();
        this.m = 1.0f;
        this.n = 50;
        this.p = us.pinguo.foundation.utils.n0.i();
        this.q = new Integer[]{103};
        Context context2 = slidiablePanelView.getContext();
        ((FrameLayout) slidiablePanelView.k().findViewById(R.id.flAdjust)).addView(paintEraserAdjustLayout2);
        paintEraserAdjustLayout2.setSizeProgress(T());
        if (oVar != null) {
            oVar.b(editGraffitiModule.f());
        }
        if (oVar != null) {
            oVar.a(editGraffitiModule.e());
        }
        magnifierUtils.j(AnonymousClass1.INSTANCE);
        Runnable runnable = new Runnable() { // from class: us.pinguo.edit2020.controller.q1
            @Override // java.lang.Runnable
            public final void run() {
                GraffitiController.a(GraffitiController.this);
            }
        };
        paintEraserAdjustLayout2.setOnPaintEraseClickListener(new a());
        paintEraserAdjustLayout2.setOnUndoRedoClick(new b());
        paintEraserAdjustLayout2.setTrackSwitchListener(new c(runnable));
        slidiablePanelView.setOnPaintItemClick(new d(context2));
        editGraffitiModule.v(O());
        editGraffitiModule.u(O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(PaintMaterial paintMaterial) {
        MaterialDataManager.a.a(paintMaterial, new GraffitiController$downloadMaterial$1(this));
    }

    private final float O() {
        int i2 = t;
        int i3 = u;
        return (((this.n / 100.0f) * (i2 - i3)) + i3) / this.p;
    }

    private final float Q() {
        Integer brushSourceType;
        float O = O() * this.p * 0.5f;
        Graffiti value = this.a.i().getValue();
        boolean z = false;
        if (value != null && (brushSourceType = value.getBrushSourceType()) != null && brushSourceType.intValue() == 102) {
            z = true;
        }
        return O * (z ? 0.5f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T() {
        int i2;
        float f2;
        int i3;
        int i4 = e.a[this.f10372j.ordinal()];
        if (i4 == 1) {
            float h2 = this.a.h() * this.p;
            i2 = u;
            f2 = (h2 - i2) * 100;
            i3 = t;
        } else if (i4 != 2) {
            this.n = 50;
            return 50;
        } else {
            float g2 = this.a.g() * this.p;
            i2 = u;
            f2 = (g2 - i2) * 100;
            i3 = t;
        }
        return (int) (f2 / (i3 - i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GraffitiController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView boldTipView = this$0.f10367e;
        boldTipView.setVisibility(4);
        VdsAgent.onSetViewVisibility(boldTipView, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final GraffitiController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10367e.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.r1
            @Override // java.lang.Runnable
            public final void run() {
                GraffitiController.Z(GraffitiController.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(PaintMaterial paintMaterial, boolean z) {
        ObservableBoolean isSelected;
        if (paintMaterial.getBrushSourceType() == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.c0("", paintMaterial.getPid());
        Graffiti value = this.a.l().getValue();
        boolean z2 = false;
        if (value != null && (isSelected = value.isSelected()) != null) {
            isSelected.set(false);
        }
        this.a.i().setValue((Graffiti) paintMaterial);
        this.a.l().setValue(paintMaterial);
        ObservableBoolean isSelected2 = paintMaterial.isSelected();
        if (isSelected2 != null) {
            isSelected2.set(true);
        }
        Integer brushSourceType = paintMaterial.getBrushSourceType();
        kotlin.jvm.internal.s.e(brushSourceType);
        BrushBuilder brushBuilder = new BrushBuilder(brushSourceType.intValue());
        brushBuilder.setBrushSizeCalculateMode(paintMaterial.getBrushSizeCalculateMode());
        brushBuilder.setBrushDefaultEffectIntensity(paintMaterial.getBrushDefaultEffectIntensity());
        brushBuilder.setBrushColorString(paintMaterial.getBrushColor());
        brushBuilder.setBrushBlendMode(paintMaterial.getBrushBlendMode());
        brushBuilder.setResourceFolderPath(paintMaterial.getResourceFolderPath());
        brushBuilder.setBrushSizeRatio(paintMaterial.getBrushSizeRatio());
        brushBuilder.setBrushDisplaySizeRatio(paintMaterial.getBrushDisplaySizeRatio());
        brushBuilder.setResourceChildPath(paintMaterial.getResourceChildPath());
        brushBuilder.setPaintIntervalRatio(paintMaterial.getPaintIntervalRatio());
        brushBuilder.setAutoAdjustPaintInterval(paintMaterial.getAutoAdjustPaintInterval());
        brushBuilder.setEnableRandomSpriteIndex(paintMaterial.getEnableRandomSpriteIndex());
        brushBuilder.setEnableRotate(paintMaterial.getEnableRotate());
        brushBuilder.setResourceChildBlendMode(paintMaterial.getResourceChildBlendMode());
        brushBuilder.setVIP(paintMaterial.getVip());
        brushBuilder.setSourceID(paintMaterial.getPid());
        SlidiablePanelView slidiablePanelView = this.f10369g;
        Integer supportChangeColor = paintMaterial.getSupportChangeColor();
        slidiablePanelView.setPanelHeight(Boolean.valueOf((supportChangeColor == null || supportChangeColor.intValue() != 1 || this.f10372j == BasicBrushMode.Erasing) ? false : true));
        d0(paintMaterial);
        brushBuilder.setBrushColorString(this.f10371i.g());
        ((ImageView) this.f10371i.a(R.id.ivPaint)).performClick();
        this.a.x(brushBuilder);
        c0(false);
        this.a.s(paintMaterial.getBrushEffectIntensity());
        ObservableBoolean isSelected3 = paintMaterial.isSelected();
        if ((isSelected3 != null && isSelected3.get()) && z) {
            z2 = true;
        }
        this.f10371i.setAlphaRestrict(!z2);
        this.f10371i.z(z2);
        if (z2) {
            PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = this.f10371i;
            Float brushEffectIntensity = paintMaterial.getBrushEffectIntensity();
            paintEraserAdjustLayout2.setAlphaProgress((int) ((brushEffectIntensity == null ? 1.0f : brushEffectIntensity.floatValue()) * 100));
            return;
        }
        this.f10371i.e();
        this.f10371i.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        this.f10367e.setSize(Q());
        this.c.o(Q());
        this.c.n(Q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(boolean z) {
        Integer brushSourceType;
        Float brushEffectIntensity;
        Integer supportChangeColor;
        int i2 = e.a[this.f10372j.ordinal()];
        float f2 = 1.0f;
        boolean z2 = false;
        if (i2 == 1) {
            this.a.v(O());
            BasicBrushMode basicBrushMode = BasicBrushMode.Brush;
            float h2 = this.a.h();
            Graffiti value = this.a.i().getValue();
            UnityEditCaller.Brush.setBrushSize(basicBrushMode, h2 * (value != null && (brushSourceType = value.getBrushSourceType()) != null && brushSourceType.intValue() == 102 ? 0.5f : 1.0f));
            us.pinguo.edit2020.viewmodel.module.d dVar = this.a;
            Graffiti value2 = dVar.i().getValue();
            if (value2 != null && (brushEffectIntensity = value2.getBrushEffectIntensity()) != null) {
                f2 = brushEffectIntensity.floatValue();
            }
            dVar.s(Float.valueOf(f2));
        } else if (i2 != 2) {
            this.n = 50;
            this.a.u(O());
        } else {
            this.a.u(O());
            UnityEditCaller.Brush.setBrushSize(BasicBrushMode.Erasing, this.a.g() / 2.0f);
            this.a.s(Float.valueOf(1.0f));
        }
        b0();
        SlidiablePanelView slidiablePanelView = this.f10369g;
        Graffiti value3 = this.a.i().getValue();
        if (((value3 == null || (supportChangeColor = value3.getSupportChangeColor()) == null || supportChangeColor.intValue() != 1) ? false : true) && this.f10372j != BasicBrushMode.Erasing) {
            z2 = true;
        }
        slidiablePanelView.setPanelHeight(Boolean.valueOf(z2));
        if (z) {
            return;
        }
        this.f10371i.setSizeProgress(T());
    }

    private final void d0(PaintMaterial paintMaterial) {
        Integer supportChangeColor = paintMaterial.getSupportChangeColor();
        if (supportChangeColor != null && supportChangeColor.intValue() == 1) {
            Integer brushSourceType = paintMaterial.getBrushSourceType();
            if (brushSourceType != null && brushSourceType.intValue() == 103) {
                this.f10371i.setColors(this.a.k(), paintMaterial.getBrushColor());
            } else {
                this.f10371i.setColors(this.a.m(), paintMaterial.getBrushColor());
            }
            this.f10371i.setOnColorItemClickListener(new g(paintMaterial, this));
        } else {
            this.f10371i.setColors(null, null);
        }
        c0(false);
    }

    private final void e0() {
        this.o = 0;
        this.n = 50;
        this.a.v(O());
        this.a.u(O());
        this.a.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int i2) {
        this.f10366d.y(i2);
        this.f10369g.p(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(final PaintMaterial paintMaterial) {
        Activity activity = (Activity) this.f10369g.getContext();
        if (activity != null) {
            us.pinguo.foundation.utils.d0.b(activity);
        }
        us.pinguo.foundation.utils.w.i(this.f10369g.getContext(), R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.s1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                GraffitiController.h0(GraffitiController.this, paintMaterial, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.p1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GraffitiController.i0(GraffitiController.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(GraffitiController this$0, PaintMaterial material, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(material, "$material");
        if (i2 == -1) {
            this$0.L(material);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(GraffitiController this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Activity activity = (Activity) this$0.f10369g.getContext();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(activity);
    }

    private final void j0(boolean z) {
        ImageView imageView = (ImageView) this.f10371i.a(R.id.ivUndo);
        kotlin.jvm.internal.s.g(imageView, "paintEraserAdjustLayout.ivUndo");
        int i2 = z ^ true ? 4 : 0;
        imageView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(imageView, i2);
        ImageView imageView2 = (ImageView) this.f10371i.a(R.id.ivRedo);
        kotlin.jvm.internal.s.g(imageView2, "paintEraserAdjustLayout.ivRedo");
        int i3 = z ^ true ? 4 : 0;
        imageView2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(imageView2, i3);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    public void M() {
        e0();
        this.f10369g.a();
        this.s = false;
        ImageView imageView = this.f10368f;
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
        this.a.b(true);
        this.b.removeAllViews();
        this.f10372j = BasicBrushMode.None;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return i3.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return this.s;
    }

    public final BoldTipView U() {
        return this.f10367e;
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        Integer supportChangeColor;
        Integer supportChangeColor2;
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.u0 u0Var = this.f10374l;
        boolean z = false;
        if (u0Var == null) {
            return false;
        }
        this.c.f(u0Var, event);
        int action = event.getAction();
        if (action == 0) {
            this.f10369g.h();
            j0(false);
            this.f10369g.setPanelHeight(Boolean.FALSE);
        } else if (action == 1) {
            j0(true);
            if (!this.r) {
                this.r = true;
                this.f10371i.x("graffiti_alpha_guide");
            }
            Graffiti value = this.a.i().getValue();
            if ((value == null || (supportChangeColor = value.getSupportChangeColor()) == null || supportChangeColor.intValue() != 1) ? false : true) {
                SlidiablePanelView slidiablePanelView = this.f10369g;
                Graffiti value2 = this.a.i().getValue();
                if (((value2 == null || (supportChangeColor2 = value2.getSupportChangeColor()) == null || supportChangeColor2.intValue() != 1) ? false : true) && this.f10372j != BasicBrushMode.Erasing) {
                    z = true;
                }
                slidiablePanelView.setPanelHeight(Boolean.valueOf(z));
            }
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        if (f()) {
            i3.a.a(this, null, 1, null);
        } else {
            M();
        }
    }

    @Override // us.pinguo.edit2020.controller.g3
    public void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        this.f10374l = unityCanvasStatus;
        this.p = unityCanvasStatus.h();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        if (f()) {
            i3.a.a(this, null, 1, null);
            this.a.s(Float.valueOf(this.m));
            return;
        }
        M();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        this.a.p(records);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        p0.a.a(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        p0.a.e(this, z);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(boolean z, boolean z2) {
        this.s = z;
        this.a.f().set(z);
        this.a.e().set(z2);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        PGEditBottomTabLayout pGEditBottomTabLayout = this.f10366d;
        String string = pGEditBottomTabLayout.getContext().getString(R.string.text_graffiti);
        kotlin.jvm.internal.s.g(string, "tabLayout.context.getStr…g(R.string.text_graffiti)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string}, false, null, 6, null);
        this.f10366d.B();
        this.f10366d.d(new f());
        ImageView imageView = this.f10368f;
        imageView.setVisibility(4);
        VdsAgent.onSetViewVisibility(imageView, 4);
        this.a.a(EditModel.Brush);
        this.a.t(0.04f);
        this.f10371i.e();
        c0(false);
        kotlin.jvm.b.a<kotlin.u> j2 = this.a.j();
        if (j2 != null) {
            j2.invoke();
        }
        this.a.b(true);
        ViewParent parent = this.f10369g.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f10369g);
        }
        this.b.addView(this.f10369g);
        this.f10369g.show();
        f0(this.o);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.a.n();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }
}
