package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.StickerStoreActivity;
import us.pinguo.edit2020.adapter.i0;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.AdvanceStickerAdjustView;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.RoundCornerRecyclerView;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.SelectRectFunctionView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.StaticStickerModule;
import us.pinguo.edit2020.widget.DrawerPanelView;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
import us.pinguo.repository2020.database.staticsticker.Template;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.u3dengine.api.PGEditBlendMode;
import us.pinguo.u3dengine.api.StaticStickerItem;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController implements i3, us.pinguo.edit2020.view.p0, a3, e3, SelectRectFunctionView.a {
    private final LifecycleOwner a;
    private final StaticStickerModule b;
    private final us.pinguo.edit2020.utils.g c;

    /* renamed from: d  reason: collision with root package name */
    private final us.pinguo.edit2020.view.c0 f10426d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f10427e;

    /* renamed from: f  reason: collision with root package name */
    private final DrawerPanelView f10428f;

    /* renamed from: g  reason: collision with root package name */
    private int f10429g;

    /* renamed from: h  reason: collision with root package name */
    private float f10430h;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap f10431i;

    /* renamed from: j  reason: collision with root package name */
    private final Bitmap f10432j;

    /* renamed from: k  reason: collision with root package name */
    private final Bitmap f10433k;

    /* renamed from: l  reason: collision with root package name */
    private final Bitmap f10434l;
    private AdvanceStickerAdjustView m;
    private Observer<us.pinguo.edit2020.bean.u0> n;

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.edit2020.view.i0 {
        final /* synthetic */ AdvanceStickerAdjustView b;
        final /* synthetic */ Runnable c;

        a(AdvanceStickerAdjustView advanceStickerAdjustView, Runnable runnable) {
            this.b = advanceStickerAdjustView;
            this.c = runnable;
        }

        @Override // us.pinguo.edit2020.view.i0
        public void a(int i2, boolean z) {
            if (!z) {
                float u = StaticStickerController.this.b.u(i2) * StaticStickerController.this.f10430h * 0.85f;
                ViewGroup viewGroup = StaticStickerController.this.f10427e;
                int i3 = R.id.imgBoldTip;
                ((BoldTipView) viewGroup.findViewById(i3)).animate().cancel();
                ((BoldTipView) StaticStickerController.this.f10427e.findViewById(i3)).setAlpha(1.0f);
                BoldTipView boldTipView = (BoldTipView) StaticStickerController.this.f10427e.findViewById(i3);
                boldTipView.setVisibility(0);
                VdsAgent.onSetViewVisibility(boldTipView, 0);
                ((BoldTipView) StaticStickerController.this.f10427e.findViewById(i3)).setSize(u);
                StaticStickerController.this.c.o(u);
                return;
            }
            StaticStickerModule.F0(StaticStickerController.this.b, null, Float.valueOf(i2 / 100.0f), Boolean.FALSE, false, 8, null);
        }

        @Override // us.pinguo.edit2020.view.i0
        public void b(int i2, boolean z) {
            if (!z) {
                StaticStickerModule staticStickerModule = StaticStickerController.this.b;
                AdvanceStickerAdjustView advanceStickerAdjustView = StaticStickerController.this.m;
                kotlin.jvm.internal.s.e(advanceStickerAdjustView);
                staticStickerModule.p0(advanceStickerAdjustView.j(), StaticStickerController.this.b.u(this.b.k()));
                float u = StaticStickerController.this.b.u(i2) * StaticStickerController.this.f10430h * 0.85f;
                StaticStickerController.this.c.n(u);
                ((BoldTipView) StaticStickerController.this.f10427e.findViewById(R.id.imgBoldTip)).setSize(u);
                this.b.postDelayed(this.c, 500L);
                return;
            }
            StaticStickerModule.F0(StaticStickerController.this.b, null, Float.valueOf(i2 / 100.0f), Boolean.TRUE, false, 8, null);
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements kotlin.jvm.b.l<Integer, kotlin.u> {
        final /* synthetic */ Material a;

        b(Material material) {
            this.a = material;
        }

        public void a(int i2) {
            ObservableInt downloadProgress = ((StaticSticker) this.a).getDownloadProgress();
            if (downloadProgress != null) {
                downloadProgress.set(i2);
            }
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("sticker download progress:", Integer.valueOf(i2)), new Object[0]);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
            a(num.intValue());
            return kotlin.u.a;
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements kotlin.jvm.b.l<Boolean, kotlin.u> {
        final /* synthetic */ Material a;
        final /* synthetic */ StaticStickerController b;

        /* compiled from: StaticStickerController.kt */
        /* loaded from: classes4.dex */
        public static final class a implements kotlin.jvm.b.a<kotlin.u> {
            final /* synthetic */ StaticStickerController a;

            a(StaticStickerController staticStickerController) {
                this.a = staticStickerController;
            }

            public void a() {
                this.a.f10428f.B();
            }

            @Override // kotlin.jvm.b.a
            public /* bridge */ /* synthetic */ kotlin.u invoke() {
                a();
                return kotlin.u.a;
            }
        }

        c(Material material, StaticStickerController staticStickerController) {
            this.a = material;
            this.b = staticStickerController;
        }

        public void a(boolean z) {
            if (z) {
                ObservableField<MaterialInstallState> installState = ((StaticSticker) this.a).getInstallState();
                if (installState != null) {
                    installState.set(MaterialInstallState.STATE_INSTALLED);
                }
                StaticStickerCategory B = this.b.b.B();
                if (B == null) {
                    return;
                }
                StaticStickerController staticStickerController = this.b;
                Material material = this.a;
                if (kotlin.jvm.internal.s.c(staticStickerController.b.x(), material)) {
                    staticStickerController.b.C0((StaticSticker) material, B, false, new a(staticStickerController));
                    return;
                }
                return;
            }
            ObservableField<MaterialInstallState> installState2 = ((StaticSticker) this.a).getInstallState();
            if (installState2 == null) {
                return;
            }
            installState2.set(MaterialInstallState.STATE_UNDOWNLOAD);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
            a(bool.booleanValue());
            return kotlin.u.a;
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements kotlin.jvm.b.l<Integer, kotlin.u> {
        final /* synthetic */ Material a;

        d(Material material) {
            this.a = material;
        }

        public void a(int i2) {
            ObservableInt downloadProgress = ((Template) this.a).getDownloadProgress();
            if (downloadProgress != null) {
                downloadProgress.set(i2);
            }
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("template download progress:", Integer.valueOf(i2)), new Object[0]);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num) {
            a(num.intValue());
            return kotlin.u.a;
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements kotlin.jvm.b.l<Boolean, kotlin.u> {
        final /* synthetic */ Material a;
        final /* synthetic */ StaticStickerController b;

        e(Material material, StaticStickerController staticStickerController) {
            this.a = material;
            this.b = staticStickerController;
        }

        public void a(boolean z) {
            if (z) {
                ObservableField<MaterialInstallState> installState = ((Template) this.a).getInstallState();
                if (installState != null) {
                    installState.set(MaterialInstallState.STATE_INSTALLED);
                }
                for (StaticSticker staticSticker : this.b.b.Q((Template) this.a)) {
                    ObservableField<MaterialInstallState> installState2 = staticSticker.getInstallState();
                    if (installState2 != null) {
                        installState2.set(MaterialInstallState.STATE_INSTALLED);
                    }
                }
                this.b.W((Template) this.a, false);
                return;
            }
            ObservableField<MaterialInstallState> installState3 = ((Template) this.a).getInstallState();
            if (installState3 == null) {
                return;
            }
            installState3.set(MaterialInstallState.STATE_UNDOWNLOAD);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
            a(bool.booleanValue());
            return kotlin.u.a;
        }
    }

    /* compiled from: StaticStickerController.kt */
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
            StaticStickerController.this.f10429g = fVar == null ? 0 : fVar.i();
            StaticStickerController staticStickerController = StaticStickerController.this;
            staticStickerController.x0(staticStickerController.f10429g);
            if (StaticStickerController.this.f10429g != 0) {
                if (StaticStickerController.this.f10429g == 1) {
                    us.pinguo.foundation.statistics.h.b.y0("template_tab", "", "click");
                    return;
                }
                return;
            }
            us.pinguo.foundation.statistics.h.b.y0("sticker_tab", "", "click");
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class g implements SelectRectAdjustView.a {
        g() {
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void a() {
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void b() {
            StaticStickerController.this.e0();
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void c() {
            StaticStickerController.this.b.n0(((SelectRectAdjustView) StaticStickerController.this.f10427e.findViewById(R.id.selectRectAdjustView)).I());
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void d() {
            StaticStickerController.this.b.h();
            ((SelectRectAdjustView) StaticStickerController.this.f10427e.findViewById(R.id.selectRectAdjustView)).setLastSelectKey("");
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void e() {
            ((SelectRectAdjustView) StaticStickerController.this.f10427e.findViewById(R.id.selectRectAdjustView)).E();
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void f(PointF pointF) {
            kotlin.jvm.internal.s.h(pointF, "pointF");
            float f2 = pointF.x;
            ViewGroup viewGroup = StaticStickerController.this.f10427e;
            int i2 = R.id.selectRectAdjustView;
            pointF.set(f2 / ((SelectRectAdjustView) viewGroup.findViewById(i2)).getWidth(), 1 - (pointF.y / ((SelectRectAdjustView) StaticStickerController.this.f10427e.findViewById(i2)).getHeight()));
            StaticStickerController.this.b.m0(pointF);
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class h implements i0.b {
        final /* synthetic */ Context b;

        /* compiled from: StaticStickerController.kt */
        /* loaded from: classes4.dex */
        public static final class a implements kotlin.jvm.b.a<kotlin.u> {
            final /* synthetic */ StaticStickerController a;

            a(StaticStickerController staticStickerController) {
                this.a = staticStickerController;
            }

            public void a() {
                StaticStickerCategory B = this.a.b.B();
                if (kotlin.jvm.internal.s.c(B == null ? null : B.getPid(), Material.MATERIAL_RECENT)) {
                    return;
                }
                this.a.f10428f.B();
            }

            @Override // kotlin.jvm.b.a
            public /* bridge */ /* synthetic */ kotlin.u invoke() {
                a();
                return kotlin.u.a;
            }
        }

        h(Context context) {
            this.b = context;
        }

        @Override // us.pinguo.edit2020.adapter.i0.b
        public void a(View view, int i2, Material material) {
            String tid;
            boolean z = material instanceof StaticSticker;
            if (z) {
                tid = ((StaticSticker) material).getSid();
            } else if (!(material instanceof Template)) {
                return;
            } else {
                tid = ((Template) material).getTid();
            }
            if (tid == null) {
                return;
            }
            StaticStickerController.this.b.q0(material);
            if (z) {
                StaticSticker staticSticker = (StaticSticker) material;
                if (kotlin.jvm.internal.s.c(staticSticker.getSid(), Material.MATERIAL_DUSTBIN)) {
                    us.pinguo.foundation.statistics.h.b.y0("manage_sticker", "", "click");
                    ActivityResultLauncher<Intent> I = StaticStickerController.this.b.I();
                    if (I == null) {
                        return;
                    }
                    StickerStoreActivity.a aVar = StickerStoreActivity.c;
                    Context context = this.b;
                    kotlin.jvm.internal.s.g(context, "context");
                    I.launch(aVar.a(context));
                    return;
                }
                us.pinguo.foundation.statistics.h.b.y0("sticker_single", tid, "click");
                if (staticSticker.isInstalled()) {
                    StaticStickerCategory B = StaticStickerController.this.b.B();
                    if (B == null) {
                        return;
                    }
                    StaticStickerController staticStickerController = StaticStickerController.this;
                    if (kotlin.jvm.internal.s.c(staticStickerController.b.x(), material)) {
                        staticStickerController.b.C0(staticSticker, B, false, new a(staticStickerController));
                        return;
                    }
                    return;
                }
                StaticStickerController staticStickerController2 = StaticStickerController.this;
                Context context2 = this.b;
                kotlin.jvm.internal.s.g(context2, "context");
                staticStickerController2.D0(context2, material);
            } else if (material instanceof Template) {
                us.pinguo.foundation.statistics.h.b.y0("sticker_template", tid, "click");
                Template template = (Template) material;
                if (StaticStickerController.this.b.b0(template) && kotlin.jvm.internal.s.c(StaticStickerController.this.b.x(), material)) {
                    if (kotlin.jvm.internal.s.c(tid, Material.MATERIAL_SELECT_NONE_FLAG)) {
                        StaticStickerController.this.b.i(StaticStickerController.this.b.C());
                    } else {
                        StaticStickerController.this.W(template, false);
                    }
                    StaticStickerController.this.s0(material);
                    return;
                }
                StaticStickerController staticStickerController3 = StaticStickerController.this;
                Context context3 = this.b;
                kotlin.jvm.internal.s.g(context3, "context");
                staticStickerController3.D0(context3, material);
            }
        }

        @Override // us.pinguo.edit2020.adapter.i0.b
        public void b(View view, int i2, Material material) {
            if (material instanceof Template) {
                if (StaticStickerController.this.b.w().contains(material)) {
                    StaticStickerController.this.b.l((Template) material);
                } else {
                    StaticStickerController.this.b.k((Template) material);
                }
                StaticStickerController.this.f10428f.A();
            }
        }
    }

    /* compiled from: StaticStickerController.kt */
    /* loaded from: classes4.dex */
    public static final class i implements DrawerPanelView.a {
        i() {
        }

        @Override // us.pinguo.edit2020.widget.DrawerPanelView.a
        public void a(int i2) {
            AutofitTextView autofitTextView = (AutofitTextView) StaticStickerController.this.f10427e.findViewById(R.id.tvSkipToStickerPackage);
            kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.tvSkipToStickerPackage");
            boolean z = true;
            int i3 = (i2 != 1 || kotlin.jvm.internal.s.c(StaticStickerController.this.b.C().getTid(), Material.MATERIAL_SELECT_NONE_FLAG)) ? false : false ? 0 : 8;
            autofitTextView.setVisibility(i3);
            VdsAgent.onSetViewVisibility(autofitTextView, i3);
        }
    }

    public StaticStickerController(LifecycleOwner lifecycleOwner, StaticStickerModule staticStickerModule, us.pinguo.edit2020.utils.g magnifierUtils, us.pinguo.edit2020.view.c0 userOperationController, ViewGroup fragmentLayout) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(staticStickerModule, "staticStickerModule");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(userOperationController, "userOperationController");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        this.a = lifecycleOwner;
        this.b = staticStickerModule;
        this.c = magnifierUtils;
        this.f10426d = userOperationController;
        this.f10427e = fragmentLayout;
        Context context = fragmentLayout.getContext();
        kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
        this.f10428f = new DrawerPanelView(context, null, 0, staticStickerModule, 6, null);
        this.f10430h = us.pinguo.foundation.utils.n0.i();
        this.f10431i = BitmapFactory.decodeResource(fragmentLayout.getContext().getResources(), R.drawable.edit_icon_koutu);
        this.f10432j = BitmapFactory.decodeResource(fragmentLayout.getContext().getResources(), R.drawable.edit_icon_jingxiang);
        this.f10433k = BitmapFactory.decodeResource(fragmentLayout.getContext().getResources(), R.drawable.edit_icon_xuanzhuan);
        this.f10434l = BitmapFactory.decodeResource(fragmentLayout.getContext().getResources(), R.drawable.edit_icon_delete);
        h0();
        f0();
        ((SelectRectFunctionView) fragmentLayout.findViewById(R.id.selectRectFunctionView)).setFunctionClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(StaticStickerController this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Activity activity = (Activity) this$0.f10428f.getContext();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(final int i2) {
        if (i2 > -1) {
            x0(0);
            RoundCornerRecyclerView roundCornerRecyclerView = (RoundCornerRecyclerView) this.f10428f._$_findCachedViewById(R.id.rvCategory);
            kotlin.jvm.internal.s.g(roundCornerRecyclerView, "stickerView.rvCategory");
            us.pinguo.foundation.ui.c.c(roundCornerRecyclerView, new Runnable() { // from class: us.pinguo.edit2020.controller.q2
                @Override // java.lang.Runnable
                public final void run() {
                    StaticStickerController.C0(StaticStickerController.this, i2);
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(StaticStickerController this$0, int i2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        DrawerPanelView.H(this$0.f10428f, i2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(Context context, Material material) {
        if (us.pinguo.util.q.f(context)) {
            if (!us.pinguo.util.q.h(context) && !us.pinguo.repository2020.m.a.C()) {
                y0(material);
                return;
            } else {
                a0(material);
                return;
            }
        }
        us.pinguo.foundation.utils.k0.a.a(R.string.download_not_network);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float E0(AdvanceStickerAdjustView advanceStickerAdjustView) {
        float u = this.b.u(advanceStickerAdjustView.k()) * this.f10430h * 0.85f;
        this.c.o(u);
        this.c.n(u);
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(Template template, boolean z) {
        if (kotlin.jvm.internal.s.c(this.b.x(), template)) {
            StaticStickerModule staticStickerModule = this.b;
            staticStickerModule.i(staticStickerModule.C());
            this.b.g(template, z);
            s0(template);
        }
    }

    private final AdvanceStickerAdjustView X() {
        View inflate = LayoutInflater.from(this.f10427e.getContext()).inflate(R.layout.layout_sticker_advance_adjust, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.AdvanceStickerAdjustView");
        AdvanceStickerAdjustView advanceStickerAdjustView = (AdvanceStickerAdjustView) inflate;
        advanceStickerAdjustView.setOnCloseAction(new StaticStickerController$createAdvancedAdjustView$1$1(this));
        advanceStickerAdjustView.setOnFunctionClick(new StaticStickerController$createAdvancedAdjustView$1$2(this, advanceStickerAdjustView));
        advanceStickerAdjustView.setOnBlendTypeChange(new StaticStickerController$createAdvancedAdjustView$1$3(this));
        advanceStickerAdjustView.setOnSeekBarChange(new a(advanceStickerAdjustView, new Runnable() { // from class: us.pinguo.edit2020.controller.s2
            @Override // java.lang.Runnable
            public final void run() {
                StaticStickerController.Y(StaticStickerController.this);
            }
        }));
        return advanceStickerAdjustView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(final StaticStickerController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((BoldTipView) this$0.f10427e.findViewById(R.id.imgBoldTip)).animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.w2
            @Override // java.lang.Runnable
            public final void run() {
                StaticStickerController.Z(StaticStickerController.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(StaticStickerController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView boldTipView = (BoldTipView) this$0.f10427e.findViewById(R.id.imgBoldTip);
        kotlin.jvm.internal.s.g(boldTipView, "fragmentLayout.imgBoldTip");
        boldTipView.setVisibility(4);
        VdsAgent.onSetViewVisibility(boldTipView, 4);
    }

    private final void a0(Material material) {
        String tid;
        ArrayList f2;
        boolean z = material instanceof StaticSticker;
        if (z) {
            tid = ((StaticSticker) material).getSid();
        } else if (!(material instanceof Template)) {
            return;
        } else {
            tid = ((Template) material).getTid();
        }
        if (tid == null) {
            return;
        }
        ObservableField<MaterialInstallState> installState = material.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        if (z) {
            StaticStickerManager staticStickerManager = StaticStickerManager.a;
            f2 = kotlin.collections.u.f((StaticSticker) material);
            staticStickerManager.l(f2, 0, new b(material), new c(material, this));
        } else if (material instanceof Template) {
            StaticStickerManager.a.l(this.b.Q((Template) material), 1, new d(material), new e(material, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observer<us.pinguo.edit2020.bean.u0> c0() {
        if (us.pinguo.edit2020.utils.d.d(this.n)) {
            Observer<us.pinguo.edit2020.bean.u0> observer = this.n;
            kotlin.jvm.internal.s.e(observer);
            return observer;
        }
        Observer<us.pinguo.edit2020.bean.u0> observer2 = new Observer() { // from class: us.pinguo.edit2020.controller.u2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StaticStickerController.d0(StaticStickerController.this, (us.pinguo.edit2020.bean.u0) obj);
            }
        };
        this.n = observer2;
        kotlin.jvm.internal.s.e(observer2);
        return observer2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(StaticStickerController this$0, us.pinguo.edit2020.bean.u0 it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        ((SelectRectAdjustView) this$0.f10427e.findViewById(R.id.selectRectAdjustView)).a0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        PGEditBlendMode blendMode;
        if (us.pinguo.edit2020.utils.d.e(this.m)) {
            this.m = X();
        }
        ((SelectRectAdjustView) this.f10427e.findViewById(R.id.selectRectAdjustView)).setShowSizeRect(true);
        FrameLayout frameLayout = (FrameLayout) this.f10427e.findViewById(R.id.flViewContainer);
        this.b.q(true);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.f10427e.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        pGEditBottomTabLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(pGEditBottomTabLayout, 8);
        FrameLayout frameLayout2 = (FrameLayout) this.f10427e.findViewById(R.id.flIrregularPanelContainer);
        kotlin.jvm.internal.s.g(frameLayout2, "fragmentLayout.flIrregularPanelContainer");
        frameLayout2.setVisibility(4);
        VdsAgent.onSetViewVisibility(frameLayout2, 4);
        this.f10426d.F(true);
        ViewGroup viewGroup = this.f10427e;
        int i2 = R.id.tvSkipToStickerPackage;
        AutofitTextView autofitTextView = (AutofitTextView) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.tvSkipToStickerPackage");
        if (autofitTextView.getVisibility() == 0) {
            AutofitTextView autofitTextView2 = (AutofitTextView) this.f10427e.findViewById(i2);
            kotlin.jvm.internal.s.g(autofitTextView2, "fragmentLayout.tvSkipToStickerPackage");
            autofitTextView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(autofitTextView2, 4);
        }
        frameLayout.removeAllViews();
        AdvanceStickerAdjustView advanceStickerAdjustView = this.m;
        if (advanceStickerAdjustView != null) {
            StaticStickerItem A = this.b.A();
            advanceStickerAdjustView.setStickerInfo((A == null || (blendMode = A.getBlendMode()) == null) ? null : Integer.valueOf(blendMode.getValue()), A != null ? A.getOpacity() : null);
            advanceStickerAdjustView.r(this.b.s(), this.b.t());
            frameLayout.addView(advanceStickerAdjustView, new FrameLayout.LayoutParams(-1, -1));
            advanceStickerAdjustView.t();
        }
        StaticStickerModule staticStickerModule = this.b;
        AdvanceStickerAdjustView advanceStickerAdjustView2 = this.m;
        kotlin.jvm.internal.s.e(advanceStickerAdjustView2);
        float u = staticStickerModule.u(advanceStickerAdjustView2.k()) * this.f10430h * 0.85f;
        this.c.j(new StaticStickerController$gotoAdvanceAdjust$1$2(u));
        this.c.k(new StaticStickerController$gotoAdvanceAdjust$1$3(u));
        this.b.v().observe(this.a, c0());
    }

    private final void f0() {
        kotlinx.coroutines.flow.c y;
        kotlinx.coroutines.flow.c<ActivityResult> J = this.b.J();
        if (J == null || (y = kotlinx.coroutines.flow.e.y(J, new StaticStickerController$initActivityResult$1(this, null))) == null) {
            return;
        }
        kotlinx.coroutines.flow.e.w(y, LifecycleOwnerKt.getLifecycleScope(this.a));
    }

    private final void g0() {
        ViewGroup viewGroup = this.f10427e;
        int i2 = R.id.selectRectAdjustView;
        ((SelectRectAdjustView) viewGroup.findViewById(i2)).setOnLayerStatusChange(new StaticStickerController$initSelectRectView$1(this));
        ((SelectRectAdjustView) this.f10427e.findViewById(i2)).setFuntionClickListener(new g());
        ((SelectRectAdjustView) this.f10427e.findViewById(i2)).setLongPressCallback(new StaticStickerController$initSelectRectView$3(this));
        Bitmap bitmapDelete = this.f10434l;
        kotlin.jvm.internal.s.g(bitmapDelete, "bitmapDelete");
        Bitmap bitmapJingxiang = this.f10432j;
        kotlin.jvm.internal.s.g(bitmapJingxiang, "bitmapJingxiang");
        Bitmap bitmapKoutu = this.f10431i;
        kotlin.jvm.internal.s.g(bitmapKoutu, "bitmapKoutu");
        Bitmap bitmapXuanzhuan = this.f10433k;
        kotlin.jvm.internal.s.g(bitmapXuanzhuan, "bitmapXuanzhuan");
        ((SelectRectAdjustView) this.f10427e.findViewById(i2)).Q(bitmapDelete, bitmapJingxiang, bitmapKoutu, bitmapXuanzhuan);
        ((SelectRectAdjustView) this.f10427e.findViewById(i2)).W();
        this.b.A0(new StaticStickerController$initSelectRectView$4(this));
    }

    private final void h0() {
        this.f10428f.setOnMaterialItemClick(new h(us.pinguo.foundation.e.b()));
        ((AutofitTextView) this.f10428f._$_findCachedViewById(R.id.tvMoreSticker)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StaticStickerController.i0(StaticStickerController.this, view);
            }
        });
        this.f10428f.setOnSecondTabSelectedListener(new i());
        ((AutofitTextView) this.f10427e.findViewById(R.id.tvSkipToStickerPackage)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StaticStickerController.j0(StaticStickerController.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(StaticStickerController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.b.y0("sticker_store", "", "click");
        ActivityResultLauncher<Intent> I = this$0.b.I();
        if (I == null) {
            return;
        }
        I.launch(new Intent(this$0.f10428f.getContext(), StickerStoreActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(StaticStickerController this$0, View view) {
        Integer is_display_new;
        String pid;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        StaticStickerModule staticStickerModule = this$0.b;
        StaticStickerCategory K = staticStickerModule.K(staticStickerModule.C());
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        String str = "";
        if (K != null && (pid = K.getPid()) != null) {
            str = pid;
        }
        iVar.y0("more_details", str, "click");
        long currentTimeMillis = System.currentTimeMillis();
        if (((K != null && K.isValid(currentTimeMillis)) && K.duringDisplayTime(currentTimeMillis) && (is_display_new = K.is_display_new()) != null && is_display_new.intValue() == 1) || this$0.b.a0(K)) {
            StaticStickerModule staticStickerModule2 = this$0.b;
            this$0.B0(staticStickerModule2.O(staticStickerModule2.C()));
            return;
        }
        ActivityResultLauncher<Intent> I = this$0.b.I();
        if (I == null) {
            return;
        }
        StickerStoreActivity.a aVar = StickerStoreActivity.c;
        Context context = this$0.f10427e.getContext();
        kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
        I.launch(aVar.b(context, this$0.b.C().getPid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(Material material) {
        if (material instanceof Template) {
            ObservableBoolean isSelected = this.b.F().isSelected();
            if (isSelected != null) {
                isSelected.set(false);
            }
            Template template = (Template) material;
            this.b.t0(template);
            this.b.w0(template);
            ObservableBoolean isSelected2 = material.isSelected();
            if (isSelected2 != null) {
                isSelected2.set(true);
            }
            StaticStickerCategory K = this.b.K(template);
            AutofitTextView autofitTextView = (AutofitTextView) this.f10427e.findViewById(R.id.tvSkipToStickerPackage);
            kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.tvSkipToStickerPackage");
            int i2 = kotlin.jvm.internal.s.c(template.getTid(), Material.MATERIAL_SELECT_NONE_FLAG) ^ true ? 0 : 8;
            autofitTextView.setVisibility(i2);
            VdsAgent.onSetViewVisibility(autofitTextView, i2);
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new StaticStickerController$onStickerItemSelected$1(material, K, this, null), 2, null);
            return;
        }
        AutofitTextView autofitTextView2 = (AutofitTextView) this.f10427e.findViewById(R.id.tvSkipToStickerPackage);
        kotlin.jvm.internal.s.g(autofitTextView2, "fragmentLayout.tvSkipToStickerPackage");
        autofitTextView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(autofitTextView2, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        us.pinguo.edit2020.bean.u0 value = this.b.v().getValue();
        if (value == null) {
            return;
        }
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new StaticStickerController$onStickerStatusChangedCallback$1$1(this, i2, f7, i3, str, f6, f4, f5, f2, f3, value, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        FrameLayout frameLayout = (FrameLayout) this.f10427e.findViewById(R.id.flIrregularPanelContainer);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flIrregularPanelContainer");
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.f10427e.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        pGEditBottomTabLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(pGEditBottomTabLayout, 4);
        AdvanceStickerAdjustView advanceStickerAdjustView = this.m;
        if (advanceStickerAdjustView == null) {
            return;
        }
        advanceStickerAdjustView.u(new StaticStickerController$quitAdvancedAdjust$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v0(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.u> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof us.pinguo.edit2020.controller.StaticStickerController$reportUsed$1
            if (r0 == 0) goto L13
            r0 = r9
            us.pinguo.edit2020.controller.StaticStickerController$reportUsed$1 r0 = (us.pinguo.edit2020.controller.StaticStickerController$reportUsed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.controller.StaticStickerController$reportUsed$1 r0 = new us.pinguo.edit2020.controller.StaticStickerController$reportUsed$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r0.L$0
            us.pinguo.edit2020.controller.StaticStickerController r0 = (us.pinguo.edit2020.controller.StaticStickerController) r0
            kotlin.j.b(r9)
            goto L76
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            kotlin.j.b(r9)
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r9 = r7.b
            java.util.List r9 = r9.X()
            java.util.Iterator r9 = r9.iterator()
        L47:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L66
            java.lang.Object r2 = r9.next()
            java.lang.String r2 = (java.lang.String) r2
            int r5 = r2.length()
            if (r5 <= 0) goto L5b
            r5 = 1
            goto L5c
        L5b:
            r5 = 0
        L5c:
            if (r5 == 0) goto L47
            us.pinguo.foundation.statistics.i r5 = us.pinguo.foundation.statistics.h.b
            java.lang.String r6 = "sticker_single"
            r5.y0(r6, r2, r8)
            goto L47
        L66:
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r9 = r7.b
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.W(r0)
            if (r9 != r1) goto L75
            return r1
        L75:
            r0 = r7
        L76:
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L7c:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L9b
            java.lang.Object r1 = r9.next()
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.length()
            if (r2 <= 0) goto L90
            r2 = 1
            goto L91
        L90:
            r2 = 0
        L91:
            if (r2 == 0) goto L7c
            us.pinguo.foundation.statistics.i r2 = us.pinguo.foundation.statistics.h.b
            java.lang.String r5 = "sticker_package"
            r2.y0(r5, r1, r8)
            goto L7c
        L9b:
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r9 = r0.b
            java.lang.String r9 = r9.Z()
            if (r9 != 0) goto La4
            goto Lab
        La4:
            us.pinguo.foundation.statistics.i r1 = us.pinguo.foundation.statistics.h.b
            java.lang.String r2 = "sticker_template"
            r1.y0(r2, r9, r8)
        Lab:
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r9 = r0.b
            java.lang.String r9 = r9.Y()
            if (r9 != 0) goto Lb4
            goto Lbb
        Lb4:
            us.pinguo.foundation.statistics.i r0 = us.pinguo.foundation.statistics.h.b
            java.lang.String r1 = "sticker_template_category"
            r0.y0(r1, r9, r8)
        Lbb:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.StaticStickerController.v0(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void w0() {
        this.f10429g = 0;
        this.b.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(int i2) {
        ((PGEditBottomTabLayout) this.f10427e.findViewById(R.id.bottomTabLayout)).y(i2);
        this.f10428f.O(i2);
    }

    private final void y0(final Material material) {
        if (material == null) {
            return;
        }
        Activity activity = (Activity) this.f10428f.getContext();
        if (activity != null) {
            us.pinguo.foundation.utils.d0.b(activity);
        }
        us.pinguo.foundation.utils.w.i(this.f10428f.getContext(), R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.p2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                StaticStickerController.z0(StaticStickerController.this, material, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.r2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                StaticStickerController.A0(StaticStickerController.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(StaticStickerController this$0, Material material, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.a0(material);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
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
        return i3.a.c(this);
    }

    @Override // us.pinguo.edit2020.view.SelectRectFunctionView.a
    public void a() {
        us.pinguo.edit2020.bean.q0 y = this.b.y();
        if (y == null) {
            return;
        }
        this.b.o(y);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        ((SelectRectAdjustView) this.f10427e.findViewById(R.id.selectRectAdjustView)).U(event);
        us.pinguo.edit2020.bean.u0 value = this.b.v().getValue();
        if (value == null) {
            return false;
        }
        if (f()) {
            this.c.f(value, event);
        }
        if (event.getAction() != 0) {
            return true;
        }
        this.f10428f.l();
        return true;
    }

    public void b0() {
        w0();
        this.f10428f.a();
        this.m = null;
        this.n = null;
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f10427e.findViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        appCompatImageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView, 0);
        AutofitTextView autofitTextView = (AutofitTextView) this.f10427e.findViewById(R.id.tvSkipToStickerPackage);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.tvSkipToStickerPackage");
        autofitTextView.setVisibility(8);
        VdsAgent.onSetViewVisibility(autofitTextView, 8);
        ViewGroup viewGroup = this.f10427e;
        int i2 = R.id.selectRectAdjustView;
        ((SelectRectAdjustView) viewGroup.findViewById(i2)).setLongPressCallback(null);
        ((SelectRectAdjustView) this.f10427e.findViewById(i2)).A();
        ((SelectRectFunctionView) this.f10427e.findViewById(R.id.selectRectFunctionView)).j();
        this.b.q(false);
        this.b.D0();
        this.b.r();
        this.f10428f.F();
        ((FrameLayout) this.f10427e.findViewById(R.id.flIrregularPanelContainer)).removeAllViews();
    }

    @Override // us.pinguo.edit2020.view.SelectRectFunctionView.a
    public void c() {
        us.pinguo.edit2020.bean.q0 y = this.b.y();
        if (y == null) {
            return;
        }
        this.b.p(y);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new StaticStickerController$onWorkflowCompleted$1(this, null), 2, null);
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return ((FrameLayout) this.f10427e.findViewById(R.id.flViewContainer)).getChildCount() != 0;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        if (!f()) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new StaticStickerController$onWorkflowCanceled$1(this, null), 2, null);
        } else {
            u0();
        }
    }

    @Override // us.pinguo.edit2020.view.SelectRectFunctionView.a
    public void h() {
        e0();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        us.pinguo.common.log.a.c("onUnityRecordsCallBack", new Object[0]);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        AdvanceStickerAdjustView advanceStickerAdjustView = this.m;
        if (advanceStickerAdjustView != null) {
            advanceStickerAdjustView.setRevertOrForward(true);
        }
        UnityEditCaller.Common.moveNext();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        p0.a.e(this, z);
    }

    @Override // us.pinguo.edit2020.view.SelectRectFunctionView.a
    public void l() {
        us.pinguo.edit2020.bean.q0 y = this.b.y();
        if (y == null) {
            return;
        }
        this.b.c0(y);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(boolean z, boolean z2) {
        this.f10426d.J(z, z2);
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
        this.b.j();
        this.b.q(true);
        ViewGroup viewGroup = this.f10427e;
        int i2 = R.id.bottomTabLayout;
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        String string = ((PGEditBottomTabLayout) this.f10427e.findViewById(i2)).getContext().getString(R.string.sticker);
        kotlin.jvm.internal.s.g(string, "fragmentLayout.bottomTab…tString(R.string.sticker)");
        String string2 = ((PGEditBottomTabLayout) this.f10427e.findViewById(i2)).getContext().getString(R.string.sticker_template);
        kotlin.jvm.internal.s.g(string2, "fragmentLayout.bottomTab….string.sticker_template)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string, string2}, true, null, 4, null);
        ((PGEditBottomTabLayout) this.f10427e.findViewById(i2)).B();
        ((PGEditBottomTabLayout) this.f10427e.findViewById(i2)).d(new f());
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f10427e.findViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        appCompatImageView.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView, 4);
        ViewParent parent = this.f10428f.getParent();
        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f10428f);
        }
        ((FrameLayout) this.f10427e.findViewById(R.id.flIrregularPanelContainer)).addView(this.f10428f);
        if (kotlin.jvm.internal.s.c(bVar == null ? null : bVar.b(), "stickerPackage")) {
            this.f10429g = 0;
        } else {
            if (kotlin.jvm.internal.s.c(bVar != null ? bVar.b() : null, "stickerTemplate")) {
                this.f10429g = 1;
            }
        }
        this.f10426d.D(this);
        this.f10426d.u(false);
        this.b.B0(new StaticStickerController$enter$2(this));
        g0();
        this.b.d0(new StaticStickerController$enter$3(this, bVar));
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.b.V();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        AdvanceStickerAdjustView advanceStickerAdjustView = this.m;
        if (advanceStickerAdjustView != null) {
            advanceStickerAdjustView.setRevertOrForward(true);
        }
        UnityEditCaller.Common.movePrevious();
    }
}
