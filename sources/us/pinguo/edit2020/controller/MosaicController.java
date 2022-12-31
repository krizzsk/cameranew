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
import java.util.Objects;
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
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.manager.MaterialDataManager;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.BrushBuilder;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: MosaicController.kt */
/* loaded from: classes4.dex */
public final class MosaicController implements i3, us.pinguo.edit2020.view.p0, a3, e3, g3 {
    private final us.pinguo.edit2020.viewmodel.module.g a;
    private final FrameLayout b;
    private final us.pinguo.edit2020.utils.g c;

    /* renamed from: d  reason: collision with root package name */
    private final PGEditBottomTabLayout f10399d;

    /* renamed from: e  reason: collision with root package name */
    private final BoldTipView f10400e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f10401f;

    /* renamed from: g  reason: collision with root package name */
    private final SlidiablePanelView f10402g;

    /* renamed from: h  reason: collision with root package name */
    private final us.pinguo.edit2020.databinding.o f10403h;

    /* renamed from: i  reason: collision with root package name */
    private final PaintEraserAdjustLayout2 f10404i;

    /* renamed from: j  reason: collision with root package name */
    private BasicBrushMode f10405j;

    /* renamed from: k  reason: collision with root package name */
    private final Handler f10406k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.edit2020.bean.u0 f10407l;
    private float m;
    private int n;
    private int o;
    private float p;
    private boolean q;
    private boolean r;

    /* compiled from: MosaicController.kt */
    /* renamed from: us.pinguo.edit2020.controller.MosaicController$1  reason: invalid class name */
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

    /* compiled from: MosaicController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements PaintEraserAdjustLayout2.a {
        a() {
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.a
        public void a() {
            ObservableBoolean isSelected;
            BasicBrushMode basicBrushMode = MosaicController.this.f10405j;
            BasicBrushMode basicBrushMode2 = BasicBrushMode.Erasing;
            if (basicBrushMode != basicBrushMode2) {
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode2);
                MosaicController.this.f10405j = basicBrushMode2;
                MosaicController mosaicController = MosaicController.this;
                mosaicController.n = mosaicController.O();
                MosaicController.this.f10404i.setSizeProgress(MosaicController.this.n);
                MosaicController.this.a.k().setValue(MosaicController.this.a.i().getValue());
                Mosaic value = MosaicController.this.a.i().getValue();
                if (value != null && (isSelected = value.isSelected()) != null) {
                    isSelected.set(false);
                }
                MosaicController.this.a.i().setValue(null);
                MosaicController.this.a0(false);
            }
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.a
        public void b() {
            ObservableBoolean isSelected;
            BasicBrushMode basicBrushMode = MosaicController.this.f10405j;
            BasicBrushMode basicBrushMode2 = BasicBrushMode.Brush;
            if (basicBrushMode != basicBrushMode2) {
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode2);
                MosaicController.this.f10405j = basicBrushMode2;
                MosaicController mosaicController = MosaicController.this;
                mosaicController.n = mosaicController.O();
                MosaicController.this.f10404i.setSizeProgress(MosaicController.this.n);
                if (MosaicController.this.a.k().getValue() != null) {
                    MosaicController.this.a.i().setValue(MosaicController.this.a.k().getValue());
                    Mosaic value = MosaicController.this.a.i().getValue();
                    if (value != null && (isSelected = value.isSelected()) != null) {
                        isSelected.set(true);
                    }
                }
                MosaicController.this.a0(false);
            }
        }
    }

    /* compiled from: MosaicController.kt */
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

    /* compiled from: MosaicController.kt */
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
                MosaicController.this.n = i2;
                MosaicController.this.Q().animate().cancel();
                MosaicController.this.Q().setAlpha(1.0f);
                MosaicController.this.f10406k.removeCallbacks(this.b);
                BoldTipView Q = MosaicController.this.Q();
                Q.setVisibility(0);
                VdsAgent.onSetViewVisibility(Q, 0);
                MosaicController.this.Z();
            }
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.c
        public void b(int i2, String type) {
            kotlin.jvm.internal.s.h(type, "type");
            if (kotlin.jvm.internal.s.c(type, BigAlbumStore.PhotoColumns.SIZE)) {
                MosaicController.this.a0(true);
                MosaicController.this.f10406k.postDelayed(this.b, 500L);
                return;
            }
            MosaicController.this.a.o(Float.valueOf(i2 / 100.0f));
        }
    }

    /* compiled from: MosaicController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements n0.b {
        final /* synthetic */ Context b;

        d(Context context) {
            this.b = context;
        }

        @Override // us.pinguo.edit2020.adapter.n0.b
        public void a(View view, int i2, PaintMaterial paintMaterial) {
            kotlin.jvm.internal.s.h(paintMaterial, "paintMaterial");
            if (paintMaterial.isInstalled()) {
                MosaicController.this.Y(paintMaterial, view != null);
            } else if (us.pinguo.util.q.f(this.b)) {
                Context context = this.b;
                kotlin.jvm.internal.s.g(context, "context");
                if (us.pinguo.util.q.h(context) || us.pinguo.repository2020.m.a.C()) {
                    MosaicController.this.J(paintMaterial);
                } else {
                    MosaicController.this.d0(paintMaterial);
                }
            } else {
                us.pinguo.foundation.utils.k0.a.a(R.string.download_not_network);
            }
        }
    }

    /* compiled from: MosaicController.kt */
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

    /* compiled from: MosaicController.kt */
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
            MosaicController.this.o = fVar == null ? 0 : fVar.i();
            MosaicController mosaicController = MosaicController.this;
            mosaicController.c0(mosaicController.o);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    public MosaicController(us.pinguo.edit2020.viewmodel.module.g editMosaicModule, FrameLayout flPanelContainer, us.pinguo.edit2020.utils.g magnifierUtils, PGEditBottomTabLayout tabLayout, BoldTipView imgBoldTip, ImageView ivCompareOriginal) {
        kotlin.jvm.internal.s.h(editMosaicModule, "editMosaicModule");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(imgBoldTip, "imgBoldTip");
        kotlin.jvm.internal.s.h(ivCompareOriginal, "ivCompareOriginal");
        this.a = editMosaicModule;
        this.b = flPanelContainer;
        this.c = magnifierUtils;
        this.f10399d = tabLayout;
        this.f10400e = imgBoldTip;
        this.f10401f = ivCompareOriginal;
        Context context = flPanelContainer.getContext();
        kotlin.jvm.internal.s.g(context, "flPanelContainer.context");
        SlidiablePanelView slidiablePanelView = new SlidiablePanelView(context, null, 0, FunctionType.MOSAIC, null, 22, null);
        this.f10402g = slidiablePanelView;
        us.pinguo.edit2020.databinding.o oVar = (us.pinguo.edit2020.databinding.o) DataBindingUtil.inflate(LayoutInflater.from(flPanelContainer.getContext()), R.layout.layout_adjust_paint_style, null, false);
        this.f10403h = oVar;
        PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = (PaintEraserAdjustLayout2) oVar.getRoot();
        this.f10404i = paintEraserAdjustLayout2;
        this.f10405j = BasicBrushMode.None;
        this.f10406k = new Handler();
        this.m = 1.0f;
        this.n = 50;
        this.p = us.pinguo.foundation.utils.n0.i();
        Context context2 = slidiablePanelView.getContext();
        ((FrameLayout) slidiablePanelView.k().findViewById(R.id.flAdjust)).addView(paintEraserAdjustLayout2);
        paintEraserAdjustLayout2.setSizeProgress(O());
        if (oVar != null) {
            oVar.b(editMosaicModule.f());
        }
        if (oVar != null) {
            oVar.a(editMosaicModule.e());
        }
        magnifierUtils.j(AnonymousClass1.INSTANCE);
        Runnable runnable = new Runnable() { // from class: us.pinguo.edit2020.controller.l2
            @Override // java.lang.Runnable
            public final void run() {
                MosaicController.a(MosaicController.this);
            }
        };
        paintEraserAdjustLayout2.setOnPaintEraseClickListener(new a());
        paintEraserAdjustLayout2.setOnUndoRedoClick(new b());
        paintEraserAdjustLayout2.setTrackSwitchListener(new c(runnable));
        slidiablePanelView.setOnPaintItemClick(new d(context2));
        editMosaicModule.r(M());
        editMosaicModule.q(M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(PaintMaterial paintMaterial) {
        MaterialDataManager.a.a(paintMaterial, new MosaicController$downloadMaterial$1(this));
    }

    private final float M() {
        return (((this.n * 0.45f) + 5.0f) * 3.25f) / this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O() {
        float h2;
        float f2;
        int i2 = e.a[this.f10405j.ordinal()];
        if (i2 == 1) {
            h2 = this.a.h();
            f2 = this.p;
        } else if (i2 != 2) {
            this.n = 50;
            return 50;
        } else {
            h2 = this.a.g();
            f2 = this.p;
        }
        return (int) (((((h2 * f2) / 3.25f) - 5) * 20) / 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MosaicController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView boldTipView = this$0.f10400e;
        boldTipView.setVisibility(4);
        VdsAgent.onSetViewVisibility(boldTipView, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(PaintMaterial paintMaterial, boolean z) {
        ObservableBoolean isSelected;
        if (paintMaterial.getBrushSourceType() == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.o("", paintMaterial.getPid());
        Mosaic value = this.a.k().getValue();
        boolean z2 = false;
        if (value != null && (isSelected = value.isSelected()) != null) {
            isSelected.set(false);
        }
        this.a.i().setValue((Mosaic) paintMaterial);
        this.a.k().setValue(paintMaterial);
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
        brushBuilder.setResourceChildPath(paintMaterial.getResourceChildPath());
        brushBuilder.setPaintIntervalRatio(paintMaterial.getPaintIntervalRatio());
        brushBuilder.setAutoAdjustPaintInterval(paintMaterial.getAutoAdjustPaintInterval());
        brushBuilder.setEnableRandomSpriteIndex(paintMaterial.getEnableRandomSpriteIndex());
        brushBuilder.setEnableRotate(paintMaterial.getEnableRotate());
        brushBuilder.setResourceChildBlendMode(paintMaterial.getResourceChildBlendMode());
        brushBuilder.setVIP(paintMaterial.getVip());
        brushBuilder.setSourceID(paintMaterial.getPid());
        SlidiablePanelView slidiablePanelView = this.f10402g;
        Integer supportChangeColor = paintMaterial.getSupportChangeColor();
        slidiablePanelView.setPanelHeight(Boolean.valueOf(supportChangeColor != null && supportChangeColor.intValue() == 1));
        ((ImageView) this.f10404i.a(R.id.ivPaint)).performClick();
        this.a.t(brushBuilder);
        a0(false);
        this.a.o(paintMaterial.getBrushEffectIntensity());
        ObservableBoolean isSelected3 = paintMaterial.isSelected();
        if ((isSelected3 != null && isSelected3.get()) && z) {
            z2 = true;
        }
        this.f10404i.setAlphaRestrict(!z2);
        this.f10404i.z(z2);
        if (z2) {
            PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = this.f10404i;
            Float brushEffectIntensity = paintMaterial.getBrushEffectIntensity();
            paintEraserAdjustLayout2.setAlphaProgress((int) ((brushEffectIntensity == null ? 1.0f : brushEffectIntensity.floatValue()) * 100));
            return;
        }
        this.f10404i.e();
        this.f10404i.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        float M = M() * this.p;
        this.f10400e.setSize(M);
        this.c.n(M);
        this.c.o(M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MosaicController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10400e.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.k2
            @Override // java.lang.Runnable
            public final void run() {
                MosaicController.X(MosaicController.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(boolean z) {
        int i2 = e.a[this.f10405j.ordinal()];
        if (i2 == 1) {
            this.a.r(M());
            UnityEditCaller.Brush.setBrushSize(BasicBrushMode.Brush, this.a.h());
        } else if (i2 != 2) {
            this.n = 50;
            this.a.q(M());
        } else {
            this.a.q(M());
            UnityEditCaller.Brush.setBrushSize(BasicBrushMode.Erasing, this.a.g());
        }
        Z();
        this.f10404i.setSizeProgress(O());
    }

    private final void b0() {
        this.o = 0;
        this.n = 50;
        this.a.r(M());
        this.a.q(M());
        this.a.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(int i2) {
        this.f10399d.y(i2);
        this.f10402g.p(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(final PaintMaterial paintMaterial) {
        Activity activity = (Activity) this.f10402g.getContext();
        if (activity != null) {
            us.pinguo.foundation.utils.d0.b(activity);
        }
        us.pinguo.foundation.utils.w.i(this.f10402g.getContext(), R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.i2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MosaicController.e0(MosaicController.this, paintMaterial, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.j2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MosaicController.f0(MosaicController.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MosaicController this$0, PaintMaterial material, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(material, "$material");
        if (i2 == -1) {
            this$0.J(material);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(MosaicController this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Activity activity = (Activity) this$0.f10402g.getContext();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(activity);
    }

    private final void g0(boolean z) {
        ImageView imageView = (ImageView) this.f10404i.a(R.id.ivUndo);
        kotlin.jvm.internal.s.g(imageView, "paintEraserAdjustLayout.ivUndo");
        int i2 = z ^ true ? 4 : 0;
        imageView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(imageView, i2);
        ImageView imageView2 = (ImageView) this.f10404i.a(R.id.ivRedo);
        kotlin.jvm.internal.s.g(imageView2, "paintEraserAdjustLayout.ivRedo");
        int i3 = z ^ true ? 4 : 0;
        imageView2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(imageView2, i3);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    public void L() {
        b0();
        this.f10402g.a();
        this.r = false;
        ImageView imageView = this.f10401f;
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
        this.b.removeAllViews();
        this.a.b(false);
        this.f10405j = BasicBrushMode.None;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    public final BoldTipView Q() {
        return this.f10400e;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return i3.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return this.r;
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.u0 u0Var = this.f10407l;
        if (u0Var == null) {
            return false;
        }
        this.c.f(u0Var, event);
        int action = event.getAction();
        if (action == 0) {
            this.f10402g.h();
            g0(false);
        } else if (action == 1) {
            g0(true);
            if (!this.q) {
                this.q = true;
                this.f10404i.x("mosaic_alpha_guide");
            }
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        if (f()) {
            i3.a.a(this, null, 1, null);
        } else {
            L();
        }
    }

    @Override // us.pinguo.edit2020.controller.g3
    public void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        this.f10407l = unityCanvasStatus;
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
            this.a.o(Float.valueOf(this.m));
            return;
        }
        L();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        this.a.m(records);
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
        this.r = z;
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
        PGEditBottomTabLayout pGEditBottomTabLayout = this.f10399d;
        String string = pGEditBottomTabLayout.getContext().getString(R.string.mosaic_classic);
        kotlin.jvm.internal.s.g(string, "tabLayout.context.getStr…(R.string.mosaic_classic)");
        String string2 = this.f10399d.getContext().getString(R.string.mosaic_creativity);
        kotlin.jvm.internal.s.g(string2, "tabLayout.context.getStr…string.mosaic_creativity)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string, string2}, true, null, 4, null);
        this.f10399d.B();
        this.f10399d.d(new f());
        ImageView imageView = this.f10401f;
        imageView.setVisibility(4);
        VdsAgent.onSetViewVisibility(imageView, 4);
        this.a.a(EditModel.Brush);
        this.a.p(0.04f);
        this.f10404i.e();
        a0(false);
        this.a.b(true);
        kotlin.jvm.b.a<kotlin.u> j2 = this.a.j();
        if (j2 != null) {
            j2.invoke();
        }
        if (us.pinguo.edit2020.utils.d.d(this.f10402g.getParent())) {
            ViewParent parent = this.f10402g.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.f10402g);
        }
        this.b.addView(this.f10402g);
        this.f10402g.show();
        c0(this.o);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.a.l();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }
}
