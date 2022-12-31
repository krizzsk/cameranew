package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.LowerResolutionCpuMobile;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.CommonVideoTutorialActivity;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.controller.d3;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.view.BodyShapingGestureView;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.ManualSkinFullScreenGuide;
import us.pinguo.edit2020.view.NoFaceTipView;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.edit2020.view.m0;
import us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView;
import us.pinguo.edit2020.view.menuview.BeautyMenuView;
import us.pinguo.edit2020.view.menuview.BeautySkinColorView;
import us.pinguo.edit2020.view.menuview.BeautySkinRefreshView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.edit2020.viewmodel.module.EditAutoBeautifyModule;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.viewmodel.module.EditBodyShapeModule;
import us.pinguo.edit2020.viewmodel.module.EditLongLegModule;
import us.pinguo.edit2020.viewmodel.module.EditMakeupModule;
import us.pinguo.edit2020.widget.AreaProtectionBoldAdjustView;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.libdeepretouch.DeepRetouch;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController implements d3, PGEditBottomTabLayout.a {
    private final String A;
    private final String B;
    private final float C;
    private final String D;
    private int E;
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> F;
    private kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.x, kotlin.u> G;
    private h3 H;
    private GuideHandler I;
    private String J;
    private final int K;
    private final String L;
    private volatile long M;
    private final f N;
    private final EditBottomTabBeautyController$skinRefreshTabSelectListener$1 O;
    private boolean P;
    private int Q;
    private AtomicInteger R;
    private final us.pinguo.edit2020.view.m0 S;
    private final LifecycleOwner a;
    private final ConstraintLayout b;
    private final us.pinguo.edit2020.view.c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final b3 f10325d;

    /* renamed from: e  reason: collision with root package name */
    private final EditBeautyModule f10326e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.jvm.b.l<kotlin.jvm.b.a<kotlin.u>, kotlin.u> f10327f;

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.jvm.b.p<Float, Float, kotlin.u> f10328g;

    /* renamed from: h  reason: collision with root package name */
    private final EnumMap<FunctionType, View> f10329h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f10330i;

    /* renamed from: j  reason: collision with root package name */
    private y2 f10331j;

    /* renamed from: k  reason: collision with root package name */
    private LongLegController f10332k;

    /* renamed from: l  reason: collision with root package name */
    private EditBodyShapingController f10333l;
    private ConstraintLayout m;
    private MakeupController n;
    private Facial3DController o;
    private us.pinguo.facedetector.c p;
    private PGEditBottomTabLayout.a q;
    private boolean r;
    private e3 s;
    private us.pinguo.edit2020.b.c t;
    private int u;
    private HashMap<Integer, Integer> v;
    private int w;
    private int x;
    private final String y;
    private final String z;

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.FacialFeatures.ordinal()] = 1;
            iArr[FunctionType.SkinRefresh.ordinal()] = 2;
            iArr[FunctionType.AutoBeauty.ordinal()] = 3;
            iArr[FunctionType.BodyShaping.ordinal()] = 4;
            iArr[FunctionType.FACIAL_3D.ordinal()] = 5;
            iArr[FunctionType.LongLeg.ordinal()] = 6;
            a = iArr;
            int[] iArr2 = new int[EditGotoType.values().length];
            iArr2[EditGotoType.HOME.ordinal()] = 1;
            iArr2[EditGotoType.ONE_KEY_BEAUTY.ordinal()] = 2;
            iArr2[EditGotoType.BODY_SHAPE.ordinal()] = 3;
            iArr2[EditGotoType.FACIAL_FEATURES.ordinal()] = 4;
            iArr2[EditGotoType.SKIN_REFRESH.ordinal()] = 5;
            iArr2[EditGotoType.SKIN_REFRESH_AUTO_FUSE.ordinal()] = 6;
            iArr2[EditGotoType.SKIN_REFRESH_AUTO_YUNFU.ordinal()] = 7;
            iArr2[EditGotoType.SKIN_REFRESH_AUTO_QUBAN.ordinal()] = 8;
            iArr2[EditGotoType.SKIN_REFRESH_MANUAL.ordinal()] = 9;
            iArr2[EditGotoType.SKIN_REFRESH_MANUAL_MOPI.ordinal()] = 10;
            iArr2[EditGotoType.SKIN_REFRESH_MANUAL_TILIANG.ordinal()] = 11;
            iArr2[EditGotoType.SKIN_REFRESH_MANUAL_XIJIE.ordinal()] = 12;
            iArr2[EditGotoType.MAKEUP.ordinal()] = 13;
            iArr2[EditGotoType.FACIAL3D.ordinal()] = 14;
            iArr2[EditGotoType.LONG_LEG.ordinal()] = 15;
            b = iArr2;
        }
    }

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements PGEditTabLayout.d {
        b() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void h(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.b(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = ((PGEditBottomTabLayout) EditBottomTabBeautyController.this.b.findViewById(R.id.bottomTabLayout)).getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.bottomTabLayout.context");
            aVar.a(context, TutorialModel.VIDEO_TYPE_BODY_SHAPING);
            Context context2 = EditBottomTabBeautyController.this.f10330i;
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements PGEditTabLayout.d {
        final /* synthetic */ BeautyAdjustFacialFeaturesView b;

        c(BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView) {
            this.b = beautyAdjustFacialFeaturesView;
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void a(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            EditBottomTabBeautyController.this.v.put(Integer.valueOf(tab.i()), Integer.valueOf(EditBottomTabBeautyController.this.u));
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            EditBottomTabBeautyController.this.w = tab.i();
            ArrayList<us.pinguo.edit2020.bean.r> arrayList = EditBottomTabBeautyController.this.f10326e.y().get(EditBottomTabBeautyController.this.f10326e.z()[tab.i()]);
            if (arrayList == null) {
                return;
            }
            BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView = this.b;
            Integer num = (Integer) EditBottomTabBeautyController.this.v.get(Integer.valueOf(tab.i()));
            if (num == null) {
                num = 1;
            }
            beautyAdjustFacialFeaturesView.j(arrayList, num.intValue());
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements PGEditTabLayout.d {
        d() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void h(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.b(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = ((PGEditBottomTabLayout) EditBottomTabBeautyController.this.b.findViewById(R.id.bottomTabLayout)).getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.bottomTabLayout.context");
            aVar.a(context, TutorialModel.VIDEO_TYPE_LONG_LEG);
            Context context2 = EditBottomTabBeautyController.this.f10330i;
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements us.pinguo.edit2020.view.m0 {
        e() {
        }

        @Override // us.pinguo.edit2020.view.m0
        public void h(int i2) {
            BeautyEditData value;
            if (EditBottomTabBeautyController.this.x == 1 && EditBottomTabBeautyController.this.f10326e.t().getValue() == FunctionType.SkinRefresh) {
                us.pinguo.edit2020.bean.n0 s = EditBottomTabBeautyController.this.f10326e.s();
                if (s == null) {
                    return;
                }
                EditBottomTabBeautyController editBottomTabBeautyController = EditBottomTabBeautyController.this;
                if (kotlin.jvm.internal.s.c(s.f(), editBottomTabBeautyController.B)) {
                    editBottomTabBeautyController.f10326e.v0(s.f(), (i2 / s.g().getMaxValue()) / editBottomTabBeautyController.C);
                } else {
                    editBottomTabBeautyController.f10326e.v0(s.f(), i2 / s.g().getMaxValue());
                }
                s.g().setCurrentValue(i2);
            } else if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList() || (value = EditBottomTabBeautyController.this.f10326e.p().getValue()) == null) {
            } else {
                EditBottomTabBeautyController editBottomTabBeautyController2 = EditBottomTabBeautyController.this;
                if (kotlin.jvm.internal.s.c(value.getBeautyKey(), "yunfu") && editBottomTabBeautyController2.Q <= 0) {
                    if (value.getCurrentValue() == 0 && i2 != 0) {
                        editBottomTabBeautyController2.Q--;
                        ((SwitchCompat) editBottomTabBeautyController2.c.g().findViewById(R.id.switchToggle)).setChecked(true);
                    } else if (value.getCurrentValue() != 0 && i2 == 0) {
                        editBottomTabBeautyController2.Q--;
                        ((SwitchCompat) editBottomTabBeautyController2.c.g().findViewById(R.id.switchToggle)).setChecked(false);
                    }
                }
                value.setCurrentValue(i2);
                editBottomTabBeautyController2.f10326e.q0(value);
            }
        }

        @Override // us.pinguo.edit2020.view.m0
        public void i(float f2) {
            m0.a.a(this, f2);
        }

        @Override // us.pinguo.edit2020.view.m0
        public void l(int i2) {
            BeautyEditData value;
            if (EditBottomTabBeautyController.this.x != 1 || EditBottomTabBeautyController.this.f10326e.t().getValue() != FunctionType.SkinRefresh) {
                View view = (View) EditBottomTabBeautyController.this.f10329h.get(FunctionType.SkinRefresh);
                if (view != null && view.getParent() != null) {
                    Objects.requireNonNull(view, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautySkinRefreshView");
                    ((BeautySkinRefreshView) view).v();
                }
                View view2 = (View) EditBottomTabBeautyController.this.f10329h.get(FunctionType.FacialFeatures);
                if (view2 != null && view2.getParent() != null) {
                    Objects.requireNonNull(view2, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView");
                    ((BeautyAdjustFacialFeaturesView) view2).m();
                }
                EditBottomTabBeautyController.this.j1(i2);
                if (!LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList() || (value = EditBottomTabBeautyController.this.f10326e.p().getValue()) == null) {
                    return;
                }
                EditBottomTabBeautyController editBottomTabBeautyController = EditBottomTabBeautyController.this;
                if (kotlin.jvm.internal.s.c(value.getBeautyKey(), "yunfu") && editBottomTabBeautyController.Q <= 0) {
                    if (value.getCurrentValue() == 0 && i2 != 0) {
                        editBottomTabBeautyController.Q--;
                        ((SwitchCompat) editBottomTabBeautyController.c.g().findViewById(R.id.switchToggle)).setChecked(true);
                    } else if (value.getCurrentValue() != 0 && i2 == 0) {
                        editBottomTabBeautyController.Q--;
                        ((SwitchCompat) editBottomTabBeautyController.c.g().findViewById(R.id.switchToggle)).setChecked(false);
                    }
                }
                value.setCurrentValue(i2);
                editBottomTabBeautyController.f10326e.q0(value);
                return;
            }
            UnityEditCaller.Common.INSTANCE.addSoftSkinStepWithParamUpdate();
        }
    }

    /* compiled from: EditBottomTabBeautyController.kt */
    /* loaded from: classes4.dex */
    public static final class f implements us.pinguo.edit2020.view.p0 {
        f() {
        }

        @Override // us.pinguo.edit2020.view.p0
        public void P() {
            p0.a.d(this);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void j() {
            EditBottomTabBeautyController.this.J = "redo";
            UnityEditCaller.Common.moveNext();
        }

        @Override // us.pinguo.edit2020.view.p0
        public void k(boolean z) {
            UnityEditCaller.Common.showOriginalTexture(z);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void m() {
            p0.a.f(this);
        }

        @Override // us.pinguo.edit2020.view.p0
        public void t(boolean z) {
            us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.n0> g2;
            ArrayList<us.pinguo.edit2020.bean.n0> M = EditBottomTabBeautyController.this.f10326e.M();
            Iterator<us.pinguo.edit2020.bean.n0> it = M.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (kotlin.jvm.internal.s.c(it.next().f(), "quban")) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            us.pinguo.edit2020.bean.n0 n0Var = M.get(i2);
            EditBottomTabBeautyController editBottomTabBeautyController = EditBottomTabBeautyController.this;
            us.pinguo.edit2020.bean.n0 n0Var2 = n0Var;
            if (editBottomTabBeautyController.Q <= 0) {
                editBottomTabBeautyController.Q++;
            }
            n0Var2.g().setCurrentValue(z ? 100 : 0);
            Object obj = editBottomTabBeautyController.f10329h.get(FunctionType.SkinRefresh);
            BeautySkinRefreshView beautySkinRefreshView = obj instanceof BeautySkinRefreshView ? (BeautySkinRefreshView) obj : null;
            if (beautySkinRefreshView != null && (g2 = beautySkinRefreshView.g()) != null) {
                g2.notifyItemChanged(i2);
            }
            if (!editBottomTabBeautyController.P && z && editBottomTabBeautyController.Q > 0) {
                editBottomTabBeautyController.P = true;
                editBottomTabBeautyController.M = System.currentTimeMillis();
                us.pinguo.foundation.statistics.h.b.l("new_qudou", "N/A", TJAdUnitConstants.String.VIDEO_START);
                editBottomTabBeautyController.g1();
            }
            editBottomTabBeautyController.f10326e.q0(n0Var2.g());
        }

        @Override // us.pinguo.edit2020.view.p0
        public void y() {
            EditBottomTabBeautyController.this.J = "undo";
            UnityEditCaller.Common.movePrevious();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [us.pinguo.edit2020.controller.EditBottomTabBeautyController$skinRefreshTabSelectListener$1] */
    public EditBottomTabBeautyController(LifecycleOwner lifecycleOwner, ConstraintLayout fragmentLayout, us.pinguo.edit2020.view.c0 bottomOperationController, b3 faceCurveController, EditBeautyModule bottomModule, kotlin.jvm.b.l<? super kotlin.jvm.b.a<kotlin.u>, kotlin.u> checkUnityPrepareAction, kotlin.jvm.b.p<? super Float, ? super Float, kotlin.u> enterModeAction) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(bottomOperationController, "bottomOperationController");
        kotlin.jvm.internal.s.h(faceCurveController, "faceCurveController");
        kotlin.jvm.internal.s.h(bottomModule, "bottomModule");
        kotlin.jvm.internal.s.h(checkUnityPrepareAction, "checkUnityPrepareAction");
        kotlin.jvm.internal.s.h(enterModeAction, "enterModeAction");
        this.a = lifecycleOwner;
        this.b = fragmentLayout;
        this.c = bottomOperationController;
        this.f10325d = faceCurveController;
        this.f10326e = bottomModule;
        this.f10327f = checkUnityPrepareAction;
        this.f10328g = enterModeAction;
        this.f10329h = new EnumMap<>(FunctionType.class);
        this.f10330i = fragmentLayout.getContext();
        this.v = new HashMap<>();
        this.x = -1;
        this.y = "pifusewen";
        this.z = "fuse";
        this.A = "qudou";
        this.B = bottomModule.A();
        this.C = bottomModule.B();
        this.D = "quzhouwen";
        this.K = 1073676288;
        this.L = "#4DD8D8D8";
        N0(lifecycleOwner);
        this.N = new f();
        this.O = new PGEditTabLayout.d() { // from class: us.pinguo.edit2020.controller.EditBottomTabBeautyController$skinRefreshTabSelectListener$1
            private final ImageView b(PGEditTabLayout.f fVar) {
                View f2;
                if (fVar == null || fVar.i() != 1 || (f2 = fVar.f()) == null) {
                    return null;
                }
                return (ImageView) f2.findViewById(R.id.tip);
            }

            @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
            public void a(PGEditTabLayout.f fVar) {
                us.pinguo.common.widget.tab.l.c(this, fVar);
                ImageView b2 = b(fVar);
                if (b2 == null) {
                    return;
                }
                b2.setImageResource(R.drawable.ic_function_tip_unselect);
            }

            @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
            public void h(PGEditTabLayout.f fVar) {
                h3 h3Var;
                LifecycleOwner lifecycleOwner2;
                us.pinguo.common.widget.tab.l.b(this, fVar);
                if (fVar == null) {
                    return;
                }
                EditBottomTabBeautyController editBottomTabBeautyController = EditBottomTabBeautyController.this;
                String str = fVar.i() == 0 ? "auto" : "manual";
                if (editBottomTabBeautyController.x != -1) {
                    if (fVar.i() != editBottomTabBeautyController.x) {
                        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                        iVar.s0(str, "click");
                        iVar.s0(str, "switch");
                    }
                } else {
                    us.pinguo.foundation.statistics.h.b.s0(str, "click");
                }
                us.pinguo.repository2020.abtest.e.a.e(fVar.i());
                Object obj = editBottomTabBeautyController.f10329h.get(FunctionType.SkinRefresh);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautySkinRefreshView");
                BeautySkinRefreshView beautySkinRefreshView = (BeautySkinRefreshView) obj;
                if (fVar.i() == 1) {
                    if (editBottomTabBeautyController.x != 1) {
                        editBottomTabBeautyController.x = fVar.i();
                        us.pinguo.edit2020.bean.n0 i2 = beautySkinRefreshView.i();
                        if (i2 != null) {
                            editBottomTabBeautyController.f10326e.b(i2.f());
                            editBottomTabBeautyController.c.I(i2.g().getMinValue(), i2.g().getMaxValue(), i2.g().getCurrentValue(), i2.g().getDefaultValue());
                        }
                        editBottomTabBeautyController.c.z(true);
                        ImageView b2 = b(fVar);
                        if (b2 != null) {
                            b2.setImageResource(R.drawable.ic_function_tip);
                        }
                        ArrayList<us.pinguo.edit2020.bean.n0> N = editBottomTabBeautyController.f10326e.N();
                        if (beautySkinRefreshView.m() >= 0) {
                            beautySkinRefreshView.s(N, beautySkinRefreshView.m());
                            beautySkinRefreshView.setSelectedPosition(-1);
                            lifecycleOwner2 = editBottomTabBeautyController.a;
                            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2), kotlinx.coroutines.z0.c(), null, new EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$2(beautySkinRefreshView, null), 2, null);
                        } else {
                            BeautySkinRefreshView.t(beautySkinRefreshView, N, 0, 2, null);
                        }
                        editBottomTabBeautyController.c.F(true);
                        h3Var = editBottomTabBeautyController.H;
                        editBottomTabBeautyController.s = h3Var;
                        editBottomTabBeautyController.f10326e.B0(new EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$3(editBottomTabBeautyController, beautySkinRefreshView));
                        editBottomTabBeautyController.J1();
                        editBottomTabBeautyController.L0(false);
                        return;
                    }
                    CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
                    Context context = ((PGEditBottomTabLayout) editBottomTabBeautyController.b.findViewById(R.id.bottomTabLayout)).getContext();
                    kotlin.jvm.internal.s.g(context, "fragmentLayout.bottomTabLayout.context");
                    aVar.a(context, TutorialModel.VIDEO_TYPE_SKIN_REFRESH);
                    Context context2 = editBottomTabBeautyController.f10330i;
                    Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
                    ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
                    return;
                }
                editBottomTabBeautyController.x = fVar.i();
                editBottomTabBeautyController.c.z(false);
                ArrayList<us.pinguo.edit2020.bean.n0> M = editBottomTabBeautyController.f10326e.M();
                if (beautySkinRefreshView.m() >= 0) {
                    beautySkinRefreshView.q(M, beautySkinRefreshView.m());
                    beautySkinRefreshView.setSelectedPosition(-1);
                } else {
                    BeautySkinRefreshView.r(beautySkinRefreshView, M, 0, 2, null);
                }
                editBottomTabBeautyController.W0(false);
                editBottomTabBeautyController.c.F(false);
                editBottomTabBeautyController.s = null;
                editBottomTabBeautyController.f10326e.B0(null);
                editBottomTabBeautyController.f10326e.b(PortalFollowFeeds.TYPE_NONE);
            }

            @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
            public void i(PGEditTabLayout.f fVar) {
                us.pinguo.common.widget.tab.l.a(this, fVar);
                h(fVar);
            }
        };
        this.R = new AtomicInteger(0);
        this.S = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(BeautyEditData beautyEditData) {
        this.f10326e.q0(beautyEditData);
    }

    private final void A1(String str) {
        F0();
        MakeupController makeupController = this.n;
        this.s = makeupController;
        this.t = makeupController;
        this.f10325d.r(false);
        X0();
        MakeupController makeupController2 = this.n;
        if (makeupController2 != null) {
            makeupController2.K(this.p);
        }
        us.pinguo.edit2020.b.c cVar = this.t;
        if (cVar == null) {
            return;
        }
        cVar.z(str);
    }

    private final void B0() {
        if (this.f10331j == null) {
            EditAutoBeautifyModule k2 = this.f10326e.k();
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer);
            kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flIrregularPanelContainer");
            NumberTipView numberTipView = (NumberTipView) this.b.findViewById(R.id.numberTipView);
            kotlin.jvm.internal.s.g(numberTipView, "fragmentLayout.numberTipView");
            this.f10331j = new y2(k2, frameLayout, numberTipView);
            this.f10326e.u0(null, new EditBottomTabBeautyController$createAutoBeautifyView$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(float f2, int i2) {
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new EditBottomTabBeautyController$showMaskAnim$1(f2, i2, null), 3, null);
    }

    private final View C0() {
        EnumMap<FunctionType, View> enumMap = this.f10329h;
        FunctionType functionType = FunctionType.BeautyMenu;
        BeautyMenuView beautyMenuView = (BeautyMenuView) enumMap.get(functionType);
        if (beautyMenuView == null) {
            Context context = this.f10330i;
            kotlin.jvm.internal.s.g(context, "context");
            beautyMenuView = new BeautyMenuView(context);
            beautyMenuView.i(this.f10326e.m());
            this.f10329h.put((EnumMap<FunctionType, View>) functionType, (FunctionType) beautyMenuView);
            beautyMenuView.setItemClickListener(new BeautyMenuView.a() { // from class: us.pinguo.edit2020.controller.EditBottomTabBeautyController$createBeautyMenuView$1
                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void a() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onFacial3DClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_contour", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void b() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onAutoBeautyClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_instant_beauty", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void c() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onHandShapeClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_face_lift", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void d() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onFacialFeaturesClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_remodel", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void e() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onMakeupClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_makeup", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void f() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onLongLegClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_legs", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyMenuView.a
                public void g() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyController.this.f10327f;
                    lVar.invoke(new EditBottomTabBeautyController$createBeautyMenuView$1$onSkinRefreshClick$1(EditBottomTabBeautyController.this));
                    us.pinguo.foundation.statistics.h.b.K("edit_panel_skin_refreshing", null, "click");
                }
            });
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.K("edit_panel_instant_beauty", null, "show");
        iVar.K("edit_panel_skin_refreshing", null, "show");
        iVar.K("edit_panel_facial_remodel", null, "show");
        iVar.K("edit_panel_legs", null, "show");
        iVar.K("edit_panel_face_lift", null, "show");
        iVar.K("edit_panel_makeup", null, "show");
        iVar.K("edit_panel_facial_contour", null, "show");
        return beautyMenuView;
    }

    private final void C1(boolean z) {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new EditBottomTabBeautyController$showNoFaceDialog$1(this, z, null), 2, null);
    }

    private final RecyclerView D0() {
        String str;
        if (this.f10333l == null) {
            View inflate = LayoutInflater.from(this.f10330i).inflate(R.layout.layout_individual_recyclerview, (ViewGroup) ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)), false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) inflate;
            View inflate2 = ((ViewStub) this.b.findViewById(R.id.stubBodyShapeControl)).inflate();
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate2;
            this.m = constraintLayout;
            LifecycleOwner lifecycleOwner = this.a;
            EditBodyShapeModule n = this.f10326e.n();
            TextView textView = (TextView) this.b.findViewById(R.id.txtEditHint);
            kotlin.jvm.internal.s.g(textView, "fragmentLayout.txtEditHint");
            TopSnackBar topSnackBar = (TopSnackBar) this.b.findViewById(R.id.topSnack);
            kotlin.jvm.internal.s.g(topSnackBar, "fragmentLayout.topSnack");
            ShapeDirectionView shapeDirectionView = (ShapeDirectionView) this.b.findViewById(R.id.handShapeView);
            kotlin.jvm.internal.s.g(shapeDirectionView, "fragmentLayout.handShapeView");
            BodyShapingGestureView bodyShapingGestureView = (BodyShapingGestureView) this.b.findViewById(R.id.narrowExpandView);
            kotlin.jvm.internal.s.g(bodyShapingGestureView, "fragmentLayout.narrowExpandView");
            MagnifierLayout magnifierLayout = (MagnifierLayout) this.b.findViewById(R.id.flMagnifier);
            kotlin.jvm.internal.s.g(magnifierLayout, "fragmentLayout.flMagnifier");
            ImageView imageView = (ImageView) this.b.findViewById(R.id.editInnerUndo);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.editInnerUndo");
            ImageView imageView2 = (ImageView) this.b.findViewById(R.id.editInnerRedo);
            kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.editInnerRedo");
            str = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView";
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.b.findViewById(R.id.showOriginPicBt);
            kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
            EditBodyShapingController editBodyShapingController = new EditBodyShapingController(lifecycleOwner, n, constraintLayout, textView, topSnackBar, recyclerView, shapeDirectionView, bodyShapingGestureView, magnifierLayout, new us.pinguo.edit2020.manager.b(imageView, imageView2, appCompatImageView));
            editBodyShapingController.M(new EditBottomTabBeautyController$createBodyShapingView$1(this));
            this.f10329h.put((EnumMap<FunctionType, View>) FunctionType.BodyShaping, (FunctionType) recyclerView);
            this.f10333l = editBodyShapingController;
        } else {
            str = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView";
        }
        View view = this.f10329h.get(FunctionType.BodyShaping);
        Objects.requireNonNull(view, str);
        return (RecyclerView) view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1() {
        NoFaceTipView noFaceTipView = (NoFaceTipView) this.b.findViewById(R.id.noFaceTipView);
        kotlin.jvm.internal.s.g(noFaceTipView, "fragmentLayout.noFaceTipView");
        noFaceTipView.setVisibility(0);
        VdsAgent.onSetViewVisibility(noFaceTipView, 0);
        this.c.w(4);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView, T] */
    private final View E0() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        EnumMap<FunctionType, View> enumMap = this.f10329h;
        FunctionType functionType = FunctionType.FacialFeatures;
        ?? r1 = enumMap.get(functionType);
        ref$ObjectRef.element = r1;
        if (r1 == 0) {
            Context context = this.f10330i;
            kotlin.jvm.internal.s.g(context, "context");
            ?? beautyAdjustFacialFeaturesView = new BeautyAdjustFacialFeaturesView(context);
            ref$ObjectRef.element = beautyAdjustFacialFeaturesView;
            ((BeautyAdjustFacialFeaturesView) beautyAdjustFacialFeaturesView).setOnItemChanged(new EditBottomTabBeautyController$createFacialFeaturesView$1(this, ref$ObjectRef));
            ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10326e.y().get(this.f10330i.getString(R.string.edit_facialfeatures_tab_face));
            if (arrayList != null) {
                BeautyAdjustFacialFeaturesView.k((BeautyAdjustFacialFeaturesView) ref$ObjectRef.element, arrayList, 0, 2, null);
            }
            this.f10329h.put(functionType, ref$ObjectRef.element);
        }
        return (View) ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(us.pinguo.edit2020.bean.n0 n0Var) {
        BeautySkinColorView beautySkinColorView = (BeautySkinColorView) G0();
        ViewParent parent = beautySkinColorView.getParent();
        if (us.pinguo.edit2020.utils.d.d(parent)) {
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(beautySkinColorView);
        }
        ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)).addView(beautySkinColorView);
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{n0Var.c()}, false, null, 6, null);
        this.q = ((PGEditBottomTabLayout) this.b.findViewById(i2)).m();
        ((PGEditBottomTabLayout) this.b.findViewById(i2)).setOnBottomClickListener(this);
    }

    private final void F0() {
        if (this.n == null) {
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.stubMakeupAdjust);
            if (viewStub != null) {
                View inflate = viewStub.inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout");
                PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) inflate;
            }
            this.n = new MakeupController(this.f10326e.D(), this.b, this.f10325d, this.f10327f);
        }
    }

    private final void F1(View view) {
        Context context = this.f10330i;
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuideHandler k2 = GuideHandler.k((Activity) context);
        k2.H("skin_manual_guide", 1);
        k2.B(GuideHandler.Gravity.CENTER_IN_VIEW);
        k2.G(GuideHandler.VGravity.UP);
        k2.A(us.pinguo.commonui.R.drawable.guide_toast_center2);
        k2.m();
        k2.E(true);
        k2.w(false);
        k2.F(this.f10330i.getString(us.pinguo.commonui.R.string.skin_manual_tip));
        this.I = k2;
        if (k2 == null) {
            return;
        }
        k2.z(-6, 0);
        if (k2 == null) {
            return;
        }
        k2.x(view);
    }

    private final View G0() {
        EnumMap<FunctionType, View> enumMap = this.f10329h;
        FunctionType functionType = FunctionType.SKIN_COLOR;
        View view = enumMap.get(functionType);
        if (view == null) {
            us.pinguo.edit2020.view.c0 c0Var = this.c;
            Context context = this.f10330i;
            kotlin.jvm.internal.s.g(context, "context");
            BeautySkinColorView beautySkinColorView = new BeautySkinColorView(context, null, 0, 6, null);
            beautySkinColorView.setOnSelectedListener(new EditBottomTabBeautyController$createSkinColorView$1$1(c0Var, beautySkinColorView, this));
            beautySkinColorView.f(this.f10326e.J());
            this.f10329h.put((EnumMap<FunctionType, View>) functionType, (FunctionType) beautySkinColorView);
            return beautySkinColorView;
        }
        ((BeautySkinColorView) view).k(this.f10326e.I());
        return view;
    }

    private final void G1(int i2, int i3) {
        PGEditTabLayout.f D;
        View f2;
        this.c.v(this.S);
        BeautySkinRefreshView beautySkinRefreshView = (BeautySkinRefreshView) H0();
        beautySkinRefreshView.u();
        X0();
        this.c.D(this.N);
        ConstraintLayout constraintLayout = this.b;
        int i4 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i4)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i4)).addView(beautySkinRefreshView);
        ConstraintLayout constraintLayout2 = this.b;
        int i5 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout2.findViewById(i5)).B();
        ((PGEditBottomTabLayout) this.b.findViewById(i5)).e(this.f10326e.P(), true, new us.pinguo.common.widget.tab.m(1, us.pinguo.common.widget.i.a.a(12)));
        ((PGEditBottomTabLayout) this.b.findViewById(i5)).d(this.O);
        this.f10325d.r(true);
        if (i2 < 0) {
            us.pinguo.repository2020.abtest.e eVar = us.pinguo.repository2020.abtest.e.a;
            if (kotlin.jvm.internal.s.c(eVar.b(), "skin_keep_tab")) {
                i2 = eVar.a();
            } else {
                i2 = !this.f10326e.S() ? 1 : 0;
            }
        }
        if (i3 >= 0) {
            beautySkinRefreshView.setSelectedPosition(i3);
        }
        ((PGEditBottomTabLayout) this.b.findViewById(i5)).y(i2);
        if (i2 == 1) {
            this.c.F(true);
            this.s = this.H;
        } else {
            us.pinguo.edit2020.bean.n0 n0Var = (us.pinguo.edit2020.bean.n0) kotlin.collections.s.D(this.f10326e.M(), i3);
            if (kotlin.jvm.internal.s.c(n0Var == null ? null : n0Var.f(), "quban")) {
                this.c.G();
            } else {
                this.c.x(true);
            }
            if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.abtest.e.a.b(), "skin_control") && (D = ((PGEditBottomTabLayout) this.b.findViewById(i5)).n().D(1)) != null && (f2 = D.f()) != null) {
                F1(f2);
            }
        }
        us.pinguo.repository2020.abtest.e eVar2 = us.pinguo.repository2020.abtest.e.a;
        if (eVar2.f()) {
            ConstraintLayout constraintLayout3 = this.b;
            int i6 = R.id.manualSkinFullGuide;
            ManualSkinFullScreenGuide manualSkinFullScreenGuide = (ManualSkinFullScreenGuide) constraintLayout3.findViewById(i6);
            manualSkinFullScreenGuide.setVisibility(0);
            VdsAgent.onSetViewVisibility(manualSkinFullScreenGuide, 0);
            ((ManualSkinFullScreenGuide) this.b.findViewById(i6)).setGotoManualSkin(new EditBottomTabBeautyController$showSkinRefresh$2(this));
            ((ManualSkinFullScreenGuide) this.b.findViewById(i6)).o();
            eVar2.d();
        }
    }

    private final View H0() {
        EnumMap<FunctionType, View> enumMap = this.f10329h;
        FunctionType functionType = FunctionType.SkinRefresh;
        View view = enumMap.get(functionType);
        if (view == null) {
            this.f10326e.u0(null, new EditBottomTabBeautyController$createSkinRefreshView$1(this));
            Context context = this.f10330i;
            kotlin.jvm.internal.s.g(context, "context");
            BeautySkinRefreshView beautySkinRefreshView = new BeautySkinRefreshView(context);
            beautySkinRefreshView.setOnItemChanged(new EditBottomTabBeautyController$createSkinRefreshView$2(this));
            beautySkinRefreshView.setOnManualItemChanged(new EditBottomTabBeautyController$createSkinRefreshView$3(this));
            BeautySkinRefreshView.r(beautySkinRefreshView, this.f10326e.M(), 0, 2, null);
            this.f10329h.put((EnumMap<FunctionType, View>) functionType, (FunctionType) beautySkinRefreshView);
            this.H = new h3(this.f10326e, this.b, this.c);
            return beautySkinRefreshView;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(int i2, int i3) {
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.F;
        if (lVar != null) {
            lVar.invoke(Boolean.TRUE);
        }
        this.f10326e.c(EditModel.SoftSkin);
        this.c.E();
        this.f10326e.t().setValue(FunctionType.SkinRefresh);
        if (this.f10326e.C0()) {
            DeepRetouch.init("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", "vStudio.Android.Camera360", true);
        } else {
            DeepRetouch.init("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", "vStudio.Android.Camera360", false);
        }
        G1(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I0() {
        int i2 = this.w;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "facial_remodel_lip" : "facial_remodel_eyebrow" : "facial_remodel_eye" : "facial_remodel_nose" : "facial_remodel_face";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I1(EditBottomTabBeautyController editBottomTabBeautyController, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        editBottomTabBeautyController.H1(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_skin_refresh", true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "new_to_skin_refresh", false, null, 4, null);
            AppCompatActivity appCompatActivity = (AppCompatActivity) this.f10330i;
            if (appCompatActivity != null) {
                us.pinguo.foundation.utils.d0.b(appCompatActivity);
            }
            Context context = this.b.getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context, TutorialModel.VIDEO_TYPE_SKIN_REFRESH);
            kVar.d(new EditBottomTabBeautyController$showTutorial$1(this));
            kVar.show();
            VdsAgent.showDialog(kVar);
        }
    }

    private final void K0() {
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(true);
        FragmentLoadingView loadingView = (FragmentLoadingView) this.b.findViewById(R.id.loadingView);
        loadingView.b();
        kotlin.jvm.internal.s.g(loadingView, "loadingView");
        loadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(loadingView, 8);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.bgEventInterceptor");
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        Group group = (Group) this.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
    }

    private final void K1() {
        boolean z;
        FunctionType value = this.f10326e.t().getValue();
        boolean z2 = false;
        switch (value == null ? -1 : a.a[value.ordinal()]) {
            case 1:
                ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_face));
                if (arrayList != null) {
                    for (us.pinguo.edit2020.bean.r rVar : arrayList) {
                        if (rVar.e() && rVar.a()) {
                            z2 = true;
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList2 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_eye));
                if (arrayList2 != null) {
                    for (us.pinguo.edit2020.bean.r rVar2 : arrayList2) {
                        if (rVar2.e() && rVar2.a()) {
                            z2 = true;
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList3 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_eyebrow));
                if (arrayList3 != null) {
                    for (us.pinguo.edit2020.bean.r rVar3 : arrayList3) {
                        if (rVar3.e() && rVar3.a()) {
                            z2 = true;
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList4 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_nose));
                if (arrayList4 != null) {
                    for (us.pinguo.edit2020.bean.r rVar4 : arrayList4) {
                        if (rVar4.e() && rVar4.a()) {
                            z2 = true;
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList5 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_mouth));
                if (arrayList5 != null) {
                    for (us.pinguo.edit2020.bean.r rVar5 : arrayList5) {
                        if (rVar5.e() && rVar5.a()) {
                            z2 = true;
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_remodel", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
                return;
            case 2:
                for (us.pinguo.edit2020.bean.n0 n0Var : this.f10326e.M()) {
                    if (kotlin.jvm.internal.s.c("fuse", n0Var.f())) {
                        if (this.f10326e.I() != null) {
                            us.pinguo.edit2020.bean.m0 I = this.f10326e.I();
                            kotlin.jvm.internal.s.e(I);
                            if (I.e()) {
                                us.pinguo.edit2020.bean.m0 I2 = this.f10326e.I();
                                kotlin.jvm.internal.s.e(I2);
                                if (I2.a()) {
                                    z2 = true;
                                }
                            }
                        }
                    } else if (n0Var.e() && n0Var.a()) {
                        z2 = true;
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_skin_refreshing", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
                return;
            case 3:
                us.pinguo.foundation.statistics.h.b.K("edit_panel_instant_beauty", "nonuse_vip_func_or_material", "exited");
                return;
            case 4:
                for (us.pinguo.edit2020.bean.k kVar : this.f10326e.n().e()) {
                    if (kVar.e() && kVar.a()) {
                        z2 = true;
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_face_lift", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
                return;
            case 5:
                Iterator<us.pinguo.edit2020.bean.q> it = this.f10326e.w().iterator();
                while (true) {
                    if (it.hasNext()) {
                        us.pinguo.edit2020.bean.q next = it.next();
                        if (next.e() && next.a()) {
                            z2 = true;
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_contour", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
                return;
            case 6:
                ArrayList<us.pinguo.edit2020.bean.b0> e2 = this.f10326e.C().e();
                if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                    Iterator<T> it2 = e2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            us.pinguo.edit2020.bean.b0 b0Var = (us.pinguo.edit2020.bean.b0) it2.next();
                            if (b0Var.e() && b0Var.n()) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                            }
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_legs", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(boolean z) {
        NoFaceTipView noFaceTipView = (NoFaceTipView) this.b.findViewById(R.id.noFaceTipView);
        kotlin.jvm.internal.s.g(noFaceTipView, "fragmentLayout.noFaceTipView");
        noFaceTipView.setVisibility(8);
        VdsAgent.onSetViewVisibility(noFaceTipView, 8);
        this.c.w(z ? 0 : 4);
    }

    private final void L1() {
        boolean z;
        FunctionType value = this.f10326e.t().getValue();
        boolean z2 = false;
        switch (value == null ? -1 : a.a[value.ordinal()]) {
            case 1:
                ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_face));
                if (arrayList != null) {
                    for (us.pinguo.edit2020.bean.r rVar : arrayList) {
                        if (rVar.e()) {
                            if (rVar.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.h.b.Z(rVar.f(), String.valueOf(rVar.g().getCurrentValue()));
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList2 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_eye));
                if (arrayList2 != null) {
                    for (us.pinguo.edit2020.bean.r rVar2 : arrayList2) {
                        if (rVar2.e()) {
                            if (rVar2.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.h.b.z(rVar2.f(), String.valueOf(rVar2.g().getCurrentValue()));
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList3 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_eyebrow));
                if (arrayList3 != null) {
                    for (us.pinguo.edit2020.bean.r rVar3 : arrayList3) {
                        if (rVar3.e()) {
                            if (rVar3.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.h.b.o0(rVar3.f(), String.valueOf(rVar3.g().getCurrentValue()));
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList4 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_nose));
                if (arrayList4 != null) {
                    for (us.pinguo.edit2020.bean.r rVar4 : arrayList4) {
                        if (rVar4.e()) {
                            if (rVar4.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.h.b.a0(rVar4.f(), String.valueOf(rVar4.g().getCurrentValue()));
                        }
                    }
                }
                ArrayList<us.pinguo.edit2020.bean.r> arrayList5 = this.f10326e.y().get(this.f10330i.getString(us.pinguo.repository2020.R.string.edit_facialfeatures_tab_mouth));
                if (arrayList5 != null) {
                    for (us.pinguo.edit2020.bean.r rVar5 : arrayList5) {
                        if (rVar5.e()) {
                            if (rVar5.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.h.b.J(rVar5.f(), String.valueOf(rVar5.g().getCurrentValue()));
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_remodel", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
                return;
            case 2:
                for (us.pinguo.edit2020.bean.n0 n0Var : this.f10326e.M()) {
                    if (kotlin.jvm.internal.s.c("fuse", n0Var.f())) {
                        if (this.f10326e.I() != null) {
                            us.pinguo.edit2020.bean.m0 I = this.f10326e.I();
                            kotlin.jvm.internal.s.e(I);
                            if (I.a()) {
                                z2 = true;
                            }
                            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                            String f2 = n0Var.f();
                            us.pinguo.edit2020.bean.m0 I2 = this.f10326e.I();
                            kotlin.jvm.internal.s.e(I2);
                            iVar.E(f2, us.pinguo.edit2020.bean.o0.a(I2));
                        }
                    } else if (n0Var.e()) {
                        if (n0Var.a()) {
                            z2 = true;
                        }
                        us.pinguo.foundation.statistics.h.b.E(n0Var.f(), String.valueOf(n0Var.g().getCurrentValue()));
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_skin_refreshing", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
                return;
            case 3:
                for (us.pinguo.edit2020.bean.c cVar : this.f10326e.k().a()) {
                    us.pinguo.foundation.statistics.h.b.i(cVar.f(), String.valueOf(cVar.g()));
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_instant_beauty", "nonuse_vip_func_or_material", "save");
                return;
            case 4:
                for (us.pinguo.edit2020.bean.k kVar : this.f10326e.n().e()) {
                    if (kVar.e()) {
                        if (kVar.a()) {
                            z2 = true;
                        }
                        us.pinguo.foundation.statistics.h.b.f(kVar.f());
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_face_lift", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
                return;
            case 5:
                Iterator<us.pinguo.edit2020.bean.q> it = this.f10326e.w().iterator();
                while (true) {
                    if (it.hasNext()) {
                        us.pinguo.edit2020.bean.q next = it.next();
                        if (next.e() && next.a()) {
                            z2 = true;
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_facial_contour", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
                return;
            case 6:
                ArrayList<us.pinguo.edit2020.bean.b0> e2 = this.f10326e.C().e();
                if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                    Iterator<T> it2 = e2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            us.pinguo.edit2020.bean.b0 b0Var = (us.pinguo.edit2020.bean.b0) it2.next();
                            if (b0Var.e() && b0Var.n()) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                z2 = true;
                            }
                        }
                    }
                }
                us.pinguo.foundation.statistics.h.b.K("edit_panel_legs", z2 ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void M0(EditBottomTabBeautyController editBottomTabBeautyController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        editBottomTabBeautyController.L0(z);
    }

    private final void N0(LifecycleOwner lifecycleOwner) {
        this.f10326e.p().observe(lifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.controller.v0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditBottomTabBeautyController.O0(EditBottomTabBeautyController.this, (BeautyEditData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(EditBottomTabBeautyController this$0, BeautyEditData data) {
        boolean z;
        Object obj;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, data.getBeautyKey())) {
            return;
        }
        if (kotlin.jvm.internal.s.c(data.getBeautyKey(), "yunfu")) {
            us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, kotlin.jvm.internal.s.q(data.getBeautyKey(), "_used"), true, null, 4, null);
            if (data.getCurrentValue() == -1) {
                data.setCurrentValue(data.getDefaultValue());
                z = true;
            } else {
                z = false;
            }
            this$0.c.I(data.getMinValue(), data.getMaxValue(), data.getCurrentValue(), 0);
            if (z) {
                this$0.M = System.currentTimeMillis();
                us.pinguo.foundation.statistics.h.b.l("yunfu", "N/A", TJAdUnitConstants.String.VIDEO_START);
                this$0.g1();
            }
            kotlin.jvm.internal.s.g(data, "data");
            this$0.A0(data);
            if (this$0.Q <= 0) {
                Iterator<T> it = this$0.f10326e.M().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (kotlin.jvm.internal.s.c(((us.pinguo.edit2020.bean.n0) obj).f(), "quban")) {
                        break;
                    }
                }
                us.pinguo.edit2020.bean.n0 n0Var = (us.pinguo.edit2020.bean.n0) obj;
                if (n0Var != null) {
                    if (data.getCurrentValue() > 0 && n0Var.g().getCurrentValue() != 100) {
                        this$0.Q--;
                        this$0.P = true;
                        if (z) {
                            this$0.g1();
                        }
                        ((SwitchCompat) this$0.c.g().findViewById(R.id.switchToggle)).setChecked(true);
                    } else if (data.getCurrentValue() == 0 && n0Var.g().getCurrentValue() != 0) {
                        this$0.Q--;
                        ((SwitchCompat) this$0.c.g().findViewById(R.id.switchToggle)).setChecked(false);
                    }
                }
            }
            kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this$0.F;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Boolean.FALSE);
            return;
        }
        if (!kotlin.jvm.internal.s.c(data.getBeautyKey(), "quban")) {
            this$0.c.I(data.getMinValue(), data.getMaxValue(), data.getCurrentValue(), data.getDefaultValue());
            kotlin.jvm.internal.s.g(data, "data");
            this$0.A0(data);
        }
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar2 = this$0.F;
        if (lVar2 == null) {
            return;
        }
        lVar2.invoke(Boolean.valueOf(data.getNeedFace()));
    }

    private final void V0() {
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(false);
        Group group = (Group) this.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.bgEventInterceptor");
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        FragmentLoadingView loadingView = (FragmentLoadingView) this.b.findViewById(R.id.loadingView);
        loadingView.d(true);
        kotlin.jvm.internal.s.g(loadingView, "loadingView");
        loadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(loadingView, 0);
        loadingView.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(boolean z) {
        View adjustView = this.c.g().findViewById(R.id.skinErasingAdjust);
        if (adjustView == null) {
            if (!z) {
                return;
            }
            adjustView = ((ViewStub) this.c.g().findViewById(R.id.stubSkinErasingView)).inflate();
            int i2 = R.id.selectBar;
            ((AreaProtectionBoldAdjustView) adjustView.findViewById(i2)).setCallBackLevel(new EditBottomTabBeautyController$manualSkinErasingAdjustEnable$1(this));
            ((AreaProtectionBoldAdjustView) adjustView.findViewById(i2)).setHeight(44.0f);
        }
        kotlin.jvm.internal.s.g(adjustView, "adjustView");
        int i3 = z ? 0 : 8;
        adjustView.setVisibility(i3);
        VdsAgent.onSetViewVisibility(adjustView, i3);
    }

    private final void X0() {
        TextView textView = (TextView) this.b.findViewById(R.id.txtSave);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        this.c.H(false);
        this.f10326e.f(true);
    }

    private final void Y0() {
        this.s = null;
        TextView textView = (TextView) this.b.findViewById(R.id.txtSave);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        this.c.J(false, false);
        this.c.F(false);
        this.c.v(null);
        ConstraintLayout constraintLayout = this.m;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(constraintLayout, 4);
        }
        this.c.y(StickySeekBar.DefaultDotStyle.CIRCLE);
        this.c.B(Color.parseColor(this.L));
        this.c.C(true);
        ((StickySeekBar) this.c.g().findViewById(R.id.seekBar)).setEnabled(true);
        this.f10326e.H().clear();
        ((NumberTipView) this.b.findViewById(R.id.numberTipView)).a();
        this.E = 0;
        View view = this.f10329h.get(FunctionType.SkinRefresh);
        if (view != null) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautySkinRefreshView");
            ((BeautySkinRefreshView) view).p();
        }
        this.f10326e.x0(null);
        this.f10326e.w0(null);
        this.f10326e.f(false);
    }

    private final void Z0() {
        us.pinguo.edit2020.b.c cVar = this.t;
        if (!(cVar != null && cVar.f())) {
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).f();
            W0(false);
            this.c.D(null);
            ((SwitchCompat) this.c.g().findViewById(R.id.switchToggle)).setChecked(false);
            this.c.z(false);
            if (this.M != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.M;
                this.M = 0L;
                if (this.Q <= 0) {
                    us.pinguo.foundation.statistics.h.b.l("yunfu", String.valueOf(currentTimeMillis), "interrupt");
                } else {
                    us.pinguo.foundation.statistics.h.b.l("new_qudou", String.valueOf(currentTimeMillis), "interrupt");
                }
            }
            this.Q = 0;
            this.P = false;
            this.M = 0L;
            this.R.set(0);
            Y0();
            K1();
            us.pinguo.edit2020.b.c cVar2 = this.t;
            if (cVar2 != null) {
                cVar2.g();
            }
            this.t = null;
            this.f10326e.i0();
            this.f10326e.y0(null);
            ((StickySeekBar) this.c.g().findViewById(R.id.seekBar)).setEnabled(true);
            L0(false);
            ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(true);
            show();
            return;
        }
        us.pinguo.edit2020.b.c cVar3 = this.t;
        if (cVar3 == null) {
            return;
        }
        cVar3.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        if (this.R.decrementAndGet() > 0) {
            return;
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.w0
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyController.b1(EditBottomTabBeautyController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(EditBottomTabBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        if (this.R.incrementAndGet() > 1) {
            return;
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.u0
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyController.d1(EditBottomTabBeautyController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(EditBottomTabBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        Log.d("Retouch", "onRetouchFinished");
        if (this.R.decrementAndGet() > 0) {
            return;
        }
        if (this.M != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.M;
            this.M = 0L;
            if (this.Q <= 0) {
                us.pinguo.foundation.statistics.h.b.l("yunfu", String.valueOf(currentTimeMillis), TJAdUnitConstants.String.VIDEO_COMPLETE);
            } else {
                us.pinguo.foundation.statistics.h.b.l("new_qudou", String.valueOf(currentTimeMillis), TJAdUnitConstants.String.VIDEO_COMPLETE);
            }
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.z0
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyController.f1(EditBottomTabBeautyController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(EditBottomTabBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((StickySeekBar) this$0.c.g().findViewById(R.id.seekBar)).setEnabled(true);
        this$0.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1() {
        Log.d("Retouch", "onRetouchStart");
        if (this.R.get() < 0 || this.R.incrementAndGet() > 1) {
            return;
        }
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.a1
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyController.h1(EditBottomTabBeautyController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(EditBottomTabBeautyController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((StickySeekBar) this$0.c.g().findViewById(R.id.seekBar)).setEnabled(false);
        this$0.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(EditBottomTabBeautyController this$0, boolean z, boolean z2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.n1(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(int i2) {
        HashMap<String, Integer> hashMap = this.f10326e.H().get(Integer.valueOf(this.E));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f10326e.H().put(Integer.valueOf(this.E), hashMap);
        }
        BeautyEditData value = this.f10326e.p().getValue();
        String beautyKey = value == null ? null : value.getBeautyKey();
        if (beautyKey == null) {
            return;
        }
        hashMap.put(beautyKey, Integer.valueOf(i2));
    }

    private final void k1() {
        FunctionType value = this.f10326e.t().getValue();
        int i2 = value == null ? -1 : a.a[value.ordinal()];
        if (i2 == 1) {
            View view = this.f10329h.get(FunctionType.FacialFeatures);
            if (view == null) {
                return;
            }
            HashMap<String, Integer> hashMap = this.f10326e.H().get(Integer.valueOf(this.E));
            Collection<ArrayList<us.pinguo.edit2020.bean.r>> values = this.f10326e.y().values();
            kotlin.jvm.internal.s.g(values, "bottomModule.getFacialFeaturesData().values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                ArrayList<us.pinguo.edit2020.bean.r> it2 = (ArrayList) it.next();
                kotlin.jvm.internal.s.g(it2, "it");
                for (us.pinguo.edit2020.bean.r rVar : it2) {
                    Integer num = hashMap == null ? null : hashMap.get(rVar.f());
                    if (num == null) {
                        num = Integer.valueOf(rVar.g().getDefaultValue());
                    }
                    rVar.g().setCurrentValue(num.intValue());
                }
            }
            ((BeautyAdjustFacialFeaturesView) view).l();
        } else if (i2 == 2) {
            View view2 = this.f10329h.get(FunctionType.SkinRefresh);
            if (view2 == null) {
                return;
            }
            HashMap<String, Integer> hashMap2 = this.f10326e.H().get(Integer.valueOf(this.E));
            for (us.pinguo.edit2020.bean.n0 n0Var : this.f10326e.M()) {
                Integer num2 = hashMap2 == null ? null : hashMap2.get(n0Var.f());
                if (num2 == null) {
                    num2 = Integer.valueOf(n0Var.g().getDefaultValue());
                }
                n0Var.g().setCurrentValue(num2.intValue());
            }
            ((BeautySkinRefreshView) view2).u();
        }
        BeautyEditData value2 = this.f10326e.p().getValue();
        if (value2 == null) {
            return;
        }
        this.c.I(value2.getMinValue(), value2.getMaxValue(), value2.getCurrentValue(), value2.getDefaultValue());
        this.f10326e.q0(value2);
    }

    private final void l1() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        if (((FrameLayout) constraintLayout.findViewById(i2)).getChildCount() > 1) {
            ((FrameLayout) this.b.findViewById(i2)).removeViewAt(1);
        }
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout2.findViewById(i3)).setOnBottomClickListener(this.q);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).e(this.f10326e.P(), true, new us.pinguo.common.widget.tab.m(1, us.pinguo.common.widget.i.a.a(12)));
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).y(0);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).d(this.O);
    }

    private final void m1(View view) {
        int i2;
        Objects.requireNonNull(view, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautySkinRefreshView");
        BeautySkinRefreshView beautySkinRefreshView = (BeautySkinRefreshView) view;
        us.pinguo.edit2020.bean.n0 l2 = beautySkinRefreshView.l();
        if (l2 != null) {
            if (kotlin.jvm.internal.s.c(this.y, l2.f())) {
                o1();
            }
            this.f10326e.p().setValue(l2.g());
            kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.x, kotlin.u> lVar = this.G;
            if (lVar != null) {
                lVar.invoke(l2);
            }
            if (this.f10326e.I() != null) {
                us.pinguo.edit2020.bean.m0 I = this.f10326e.I();
                kotlin.jvm.internal.s.e(I);
                i2 = I.g().getCurrentValue();
            } else {
                i2 = 0;
            }
            beautySkinRefreshView.w(i2);
            if (this.c.l()) {
                return;
            }
            this.c.x(true);
            return;
        }
        this.c.k();
    }

    private final void n1(boolean z, boolean z2) {
        Drawable drawable = AppCompatResources.getDrawable(this.f10330i, z ? R.drawable.ic_inner_undo_enable : R.drawable.ic_inner_undo_unable);
        if (drawable != null) {
            this.c.i().setImageDrawable(drawable);
        }
        Drawable drawable2 = AppCompatResources.getDrawable(this.f10330i, z2 ? R.drawable.ic_inner_redo_enable : R.drawable.ic_inner_redo_unable);
        if (drawable2 == null) {
            return;
        }
        this.c.h().setImageDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1() {
        this.c.B(Color.parseColor("#3FC0E2"), Color.parseColor("#FFE362"), Color.parseColor("#E82222"));
        this.c.y(StickySeekBar.DefaultDotStyle.RECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        this.f10326e.c(EditModel.OneStepToBeauty);
        q1();
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.F;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        this.f10326e.t().setValue(FunctionType.AutoBeauty);
        y2 y2Var = this.f10331j;
        if (y2Var != null) {
            y2Var.h(false);
        }
        if (this.f10326e.C0()) {
            DeepRetouch.init("EgBAduI8CwasPnAO64qU1Lf7y9g2SLYc99J+jsEucHCIoz1U5Uod64PpOd514kmiK2ghOZ5kuWCI40l8YEg0b+9IqxEAgncKFAAQ83Vb5YKN3udFrypk8DU7qBQAEBdGmpZH1EzaF7zjr6iQAloUABDZ9os7hu+5kqlBJbrnXdpoFAAQ7Lj4AQezKAOjlFCSAE9mXRQAECwgxnKpsb6j/0ccZE166HcUABCfQFwgCKIoO3lw/X4w8bCWFAAQPgtlFycv7J4AkT3u9kvUqxQAEODoRCzxWUWrCikY3Dg0LZYUABBIIuT6t45ZeOvOmv2JfUssFAAQJAFT7iojEGAAelFcjIeHMBQAEDX1zQeNF+CFu4u3ODgqQb8UABCivSLUZGNXFj/0nr2TZtzNFAAQpw+ekHv9tLGwyZ6ICwVfqRQAEBqIpiCND8OAz5XOpttdYfkUABA0CxM4ItVWrrd9Nid9kOGXFAAQu1CXQZqDMiCmg7wk/42aTxQAEG2wfhQl4Cy7bvOGV0KKD40UABALrpaJz4Lkpyi/n1ZRt8sWFAAQ/mxZI5/I3wY0PILALWpG5xQAEAdPRJoRRYMRbU7t5F76TR8UABC/FPw+7ofNgHAKVJ+iwVY8FAAQU57BMetLctzOgbNTS4mp8BQAELnhau2dcY7tt2kFwzkzIrQUABC4TUB4bkxogrx4OwoEvFoWFAAQjMgq9sP6Y1zZ7nW8kGs+WxQAEGxcnHhGbdVBrr1IcGX0WsUUABDTYNLzE5aSfw2ee11MN4a5FAAQIPL6c9tIjeaARxBLT2LRmBQAEKDr9jld3ljgjS6HxzaOMloUABAM3cU3vTkLlP7IOTeGKaPqFAAQK8I0wYugpkkN7XI9e3YddxQAEOsF9YZ0W4sAqfpYlAOeOqEUABBav7QTVGYzR2U1vss7kja8FAAQmoWNqh6HifWK3GD3YmYNahQAEMtX0RBFNJJ7L5WXA4+sDTIUABAFAIt1+Ohv11jUtL/Veo40FAAQ/wJQRQHMaKt+WUfoCdXQYxQAEMYtqpsGs7ZWDkuvUTjNSLsUABAhMoz8kFhPKnOD2aZ+wI37FAAQBGPOVCnpjmzDj/DiOzx5LxQAEJDhJPMbNObYZdmBCdTR8VMUABDvUy4Mg/NNqbSs8UTbnmKyFAAQ/C4Szu/+z7a6aoDHy2VJqhQAEHQmwgaz+oj5HOINhpaodGcUABDeevhN/0Xsv0sxS35iY1sXFAAQUOOQZCqrER2kyKZkwomONxQAEKOT033vIpOhVI4v32+atZ4UABDBr0pHtSuHaA4qb7eoARrmFAAQsAfyG8wo15DIkBWqM7R9XhQAEOoALUzR7SL+AUds+HmTBksUABBzEC+o/WTvGMBV41cOjGCzFAAQwBz5ZTEfPHkZyiUBlkiCMhQAEPgfVrAkpzy2mLdU81VIlY0UABDwZgVF++772WOG7t8TQbpNFAAQP4wD7W4NYxc8Ulho4wpTqxQAEAeNvGuAki1ggD1ejuvlpioUABDp5sJ12nmCxVP3Y9lpf9ApFAAQG9efYZ9s6BZNbBywMfx5qhQAEGJFCCpGdOMKTW/3BGl2OP4UABAZ9/TPziZnVhRvDq/oIQZZFAAQ9yWIC57wj2O1io5UyrcG9RQAEJVP6VK9TaisWBGhY6mgh8QUABAwP4bMLGOPUAN2KhztZLeOFAAQVr3yRpxoxu6ZjYQXrJCXFRQAEI7ZKBZ37EGOun5GhZP/X5MUABA/n+f7aT5Epi/ew9ZNjIUxFAAQMYzRPfdUaUh4BGjeleUsIBQAEDpNUOMWBA4u4a01cnMfe2AUABBfWUPSMUkv18t1KUAh56CiFAAQDf0LhJNsATAmycBooXV2DBQAEJ949GrAT9qG6y3PFXhfSAwUABDqbEU6u3VHqzd2/lvIj5zLFAAQxCDJiuzxrb/RIPpPcgkOwBQAEB+QNzGKQDVqTJyx9dFBHXUUABAhyP1g5BiK1BdBmon4H601FAAQDeRUAV9lgQoyDTUujZitIxQAELOruoDx7IwFuCFQEbKqoHoUABCdATxZvBf91wsKbGROPioTFAAQMRc1y9vwwhig7xF0n3SaURQAEGVwDIRJBVYO2gDnLNRcDGEUABCjgGqAroKQmhCH0UswtWwYFAAQZvnZYC6iCiJeL4rYcUZzZBQAEOQ4oUs9inrt0YqKO3r7XZEUABAMXsnOKIc3iklMylvXMqWHFAAQjNeeZMMouuN46kbabQZ5fxQAEA536bVwDTXsb0Vp9A6AAqkUABCEHObxCwppXwwambGeWcsdFAAQiaIilI3W5hInmaTjfqgUwBQAENY4DIWCOSJPG5t8tdKzeGIUABDHdRPadqvsio2NCJMLOi4NFAAQsURcFjf+qAMwEPUh/VqJNhQAEFCg0k9MkG3lia/XfoT6NAwUABBTHY/joJjOZaIZgb2gBFDZFAAQPhvYBdVtk2T0qscE5EF+shQAELSwFmCOOmYa648APM6bqVwUABBkpl238DFo5bDkr2kOVpgPFAAQJ14gEtbu93lR+WZJ0M9MURQAEP0iAQnLwx5BijPxQKT5QNsUABA09Yc1g2iW+f9RicimpB6WFAAQPYgRFSGxjhYJRwv1mMH8YBQAECYEyRf9ZrwWph5hcYA4ryEUABC6BFQ7mLvgryrcbAeeeU0PFAAQC+X2rMihEp13nBQjr64ZRRQAENrBjRFWwumHAWiSklnXMQwUABAmTbRIxXR0YKEk28AkK10nFAAQV0kNHnYiRd1xV2uVvi2nKBQAEC8fS78lxKWy+0nEfr1p3d0UABBcR3lgcEev7xM0Lhz6pZAeFAAQhsQmCWUPdiEpc3W9/mxnkRQAEKA0e7lyxwMHhxp8awUGeZgUABBDsqTOfULAByad9hPAWKXuFAAQXw/1jzL6Ozp3c0mR1BaLThQAEHbzfeZ9QPN/5iQmLcDqSmsUABCIpfnuGNIYHDJVo92ti5bEFAAQFQeQAqQ7x1lnPlqFEOwImxQAEOCx+doEkf5Fz2sHXUa1LoEUABBsebh9MgOta8J72zS4oN4YFAAQwAVWVKaJhg8cqRvVrofu6hQAEDgA3ZZ/ekyx8kQNFAHlSygUABDauH6V3ShpqMYnCX4loaT6FAAQglmv88Q7ORjg+ZmIqp4knRQAEDEQQ3QCS803jVFNapcNizsUABCCVLyh8HdLUMUn5a3qIkP9FAAQo2fq0aRGQkiUoPllmODItxQAEEPMZOIty3KAbbNcn53c/bwUABAWY81xSpmG5tyfYG5h4oDaFAAQn+5eaDa2ighZC/6Q2jyurhQAELoabhSkkxSrtCqlFo7bXU0UABCVShDAJueh+kaWyc8OSdY2FAAQc9ezKVD9HPJcgsQsGlfdFRQAEEtkQsTwZjpFFU6CilQQb2oUABA6VlRPDBfjO1kWQ9fmKipnFAAQJJS9a6PoWnUyXdAsOtg0MBQAEFEx7ghoKvSELAv+K0uYzqYUABBWBqRso3GlUXCqKe72DteXFAAQ4SDyeiRVqcprE1dE1pSXehQAEDJ0WrmqnTtikNd59qY2zU4UABAk8QjReNsYvu+fm6HTguPfFAAQOnnezr2Mb9RgsQF5tEyuqRQAEPMhxeWumFm4IR7/M4n5H14UABAzP4qc71MlhBzAWR6RZme8EwAQRDZBU0RGS0hTRDdGS1NEABQACOyVsWIAAAAA", "dV8iP1c8vi4S+ld/Alz0Pi3ZUa5ghPFf0Q/T76IFAVM=", "vStudio.Android.Camera360", true);
        } else {
            DeepRetouch.init("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", "vStudio.Android.Camera360", false);
        }
        C1(!this.f10326e.C0());
    }

    private final void q1() {
        B0();
        ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)).removeAllViews();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout.findViewById(i2)).B();
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.f10326e.k().b(), false, null, 6, null);
        y2 y2Var = this.f10331j;
        this.s = y2Var;
        this.t = y2Var;
        X0();
        us.pinguo.edit2020.b.c cVar = this.t;
        if (cVar == null) {
            return;
        }
        c.a.e(cVar, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1() {
        this.f10326e.c(EditModel.ManualDeformation);
        this.c.E();
        s1();
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.F;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        this.f10326e.t().setValue(FunctionType.BodyShaping);
    }

    private final void s1() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(D0());
        X0();
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout2.findViewById(i3)).l();
        Context context = this.f10330i;
        kotlin.jvm.internal.s.g(context, "context");
        View a2 = us.pinguo.edit2020.utils.d.a(context, R.string.main_menu_beauty_handshape, false, true);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i3);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{a2}, false, null, 6, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).d(new b());
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).B();
        this.s = this.f10333l;
        this.c.I(0, 100, 25, 25);
        this.c.D(this.f10333l);
        this.c.F(true);
        this.c.x(false);
        this.t = this.f10333l;
        n1(false, false);
        us.pinguo.edit2020.b.c cVar = this.t;
        if (cVar != null) {
            c.a.e(cVar, null, 1, null);
        }
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_body_shaping", true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "new_to_body_shaping", false, null, 4, null);
            Context context2 = this.b.getContext();
            kotlin.jvm.internal.s.g(context2, "fragmentLayout.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context2, TutorialModel.VIDEO_TYPE_BODY_SHAPING);
            kVar.show();
            VdsAgent.showDialog(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        this.f10326e.c(EditModel.Facial3D);
        if (this.o == null) {
            EditBeautyModule editBeautyModule = this.f10326e;
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.flContainerSubItems);
            kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flContainerSubItems");
            PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout);
            kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.stubFacial3DAdjust);
            kotlin.jvm.internal.s.g(viewStub, "fragmentLayout.stubFacial3DAdjust");
            this.o = new Facial3DController(editBeautyModule, frameLayout, pGEditBottomTabLayout, viewStub);
        }
        this.c.E();
        Facial3DController facial3DController = this.o;
        this.s = facial3DController;
        this.t = facial3DController;
        if (facial3DController != null) {
            c.a.e(facial3DController, null, 1, null);
        }
        X0();
        this.f10326e.t().setValue(FunctionType.FACIAL_3D);
        C1(false);
    }

    private final void u1() {
        this.w = 0;
        this.v.clear();
        this.f10325d.r(false);
        this.f10325d.u(-1);
        BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView = (BeautyAdjustFacialFeaturesView) E0();
        this.c.v(this.S);
        this.c.x(true);
        if (this.f10326e.v() >= 2) {
            beautyAdjustFacialFeaturesView.setFaceSelectTipVisible(true);
            this.c.C(false);
        } else {
            beautyAdjustFacialFeaturesView.setFaceSelectTipVisible(false);
            this.c.C(true);
        }
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(beautyAdjustFacialFeaturesView);
        X0();
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.bottomTabLayout;
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) constraintLayout2.findViewById(i3);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.f10326e.z(), true, null, 4, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).B();
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).y(this.w);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).d(new c(beautyAdjustFacialFeaturesView));
        ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10326e.y().get(this.f10330i.getString(R.string.edit_facialfeatures_tab_face));
        if (arrayList == null) {
            return;
        }
        BeautyAdjustFacialFeaturesView.k(beautyAdjustFacialFeaturesView, arrayList, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        this.f10326e.c(EditModel.AutoDeformation);
        this.c.E();
        u1();
        this.f10326e.r0(true);
        C1(false);
        this.f10326e.t().setValue(FunctionType.FacialFeatures);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.F;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(us.pinguo.edit2020.model.editgoto.b bVar) {
        this.f10326e.c(EditModel.BodyBeautify);
        this.c.E();
        y1(bVar);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.F;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        this.f10326e.t().setValue(FunctionType.LongLeg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x1(EditBottomTabBeautyController editBottomTabBeautyController, us.pinguo.edit2020.model.editgoto.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bVar = null;
        }
        editBottomTabBeautyController.w1(bVar);
    }

    private final void y1(us.pinguo.edit2020.model.editgoto.b bVar) {
        LongLegController longLegController = this.f10332k;
        if (longLegController == null) {
            longLegController = new LongLegController(this.a, this.b, this.f10326e.C());
            this.f10332k = longLegController;
        }
        longLegController.G(bVar);
        X0();
        ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)).removeAllViews();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout.findViewById(i2)).l();
        Context context = this.f10330i;
        kotlin.jvm.internal.s.g(context, "context");
        View a2 = us.pinguo.edit2020.utils.d.a(context, R.string.main_menu_beauty_long_leg, EditLongLegModule.f10861e.a(), true);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{a2}, false, null, 6, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i2)).d(new d());
        ((PGEditBottomTabLayout) this.b.findViewById(i2)).B();
        this.s = longLegController;
        this.c.I(-100, 100, 0, 0);
        this.c.D(longLegController);
        this.c.F(false);
        this.c.x(false);
        n1(false, false);
        this.t = longLegController;
        if (longLegController == null) {
            return;
        }
        c.a.e(longLegController, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(String str) {
        this.f10326e.c(EditModel.Makeup);
        this.c.E();
        A1(str);
        this.f10326e.t().setValue(FunctionType.MakeupMenu);
        C1(false);
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void B(boolean z) {
        MakeupController makeupController;
        if (!(this.t instanceof MakeupController) || (makeupController = this.n) == null) {
            return;
        }
        makeupController.B(z);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    @Override // us.pinguo.edit2020.controller.z2
    /* renamed from: J0 */
    public ArrayList<us.pinguo.edit2020.bean.x> v() {
        return this.f10326e.R();
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void K(us.pinguo.facedetector.c cVar) {
        this.p = cVar;
        int c2 = cVar == null ? -1 : cVar.c();
        if (c2 > 0) {
            EditMakeupModule D = this.f10326e.D();
            Long[] lArr = new Long[c2];
            for (int i2 = 0; i2 < c2; i2++) {
                lArr[i2] = 0L;
            }
            D.n0(lArr);
            EditMakeupModule D2 = this.f10326e.D();
            StyleMakeup[] styleMakeupArr = new StyleMakeup[c2];
            for (int i3 = 0; i3 < c2; i3++) {
                styleMakeupArr[i3] = null;
            }
            D2.v0(styleMakeupArr);
        }
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        switch (a.b[editGoto.a().ordinal()]) {
            case 1:
                show();
                return true;
            case 2:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$1(this));
                return true;
            case 3:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$2(this));
                return true;
            case 4:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$3(this));
                return true;
            case 5:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$4(this));
                return true;
            case 6:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$5(this));
                return true;
            case 7:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$6(this));
                return true;
            case 8:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$7(this));
                return true;
            case 9:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$8(this));
                return true;
            case 10:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$9(this));
                return true;
            case 11:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$10(this));
                return true;
            case 12:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$11(this));
                return true;
            case 13:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$12(this, editGoto));
                return true;
            case 14:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$13(this));
                return true;
            case 15:
                this.f10327f.invoke(new EditBottomTabBeautyController$onGotoEvent$14(this, editGoto));
                return true;
            default:
                return false;
        }
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void N(kotlin.jvm.b.l<? super Boolean, kotlin.u> outFun) {
        kotlin.jvm.internal.s.h(outFun, "outFun");
        this.F = outFun;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public void Q() {
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return d3.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        FunctionType value = this.f10326e.t().getValue();
        int i2 = value == null ? -1 : a.a[value.ordinal()];
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 6) {
                    return d3.a.b(this);
                }
                return this.f10326e.X();
            }
            return this.r;
        }
        return this.f10326e.a0();
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void a() {
        BeautyEditData g2;
        View view = this.f10329h.get(FunctionType.SKIN_COLOR);
        View view2 = this.f10329h.get(FunctionType.SkinRefresh);
        if (view != null) {
            BeautySkinColorView beautySkinColorView = (BeautySkinColorView) view;
            Pair<us.pinguo.edit2020.bean.m0, Integer> d2 = beautySkinColorView.d();
            us.pinguo.edit2020.bean.m0 first = d2 == null ? null : d2.getFirst();
            if (kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, first == null ? null : first.f())) {
                this.f10326e.y0(null);
            } else {
                int i2 = -1;
                if (first != null && (g2 = first.g()) != null) {
                    i2 = g2.getCurrentValue();
                }
                beautySkinColorView.setLastSelectedBeautyValue(i2);
                this.f10326e.y0(first);
            }
        }
        if (view2 != null) {
            m1(view2);
        }
        l1();
        this.c.z(false);
    }

    @Override // us.pinguo.edit2020.controller.d3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        e3 e3Var = this.s;
        if (e3Var == null) {
            return true;
        }
        return e3Var.b(event);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void c() {
        if (this.f10326e.I() == null) {
            BeautyEditData value = this.f10326e.p().getValue();
            if (value != null) {
                value.setCurrentValue(0);
                this.f10326e.p().setValue(value);
            }
        } else {
            BeautySkinColorView beautySkinColorView = (BeautySkinColorView) this.f10329h.get(FunctionType.SKIN_COLOR);
            int b2 = beautySkinColorView == null ? -1 : beautySkinColorView.b();
            if (b2 != -1) {
                us.pinguo.edit2020.bean.m0 I = this.f10326e.I();
                kotlin.jvm.internal.s.e(I);
                I.g().setCurrentValue(b2);
            }
            us.pinguo.repository2020.u<BeautyEditData> p = this.f10326e.p();
            us.pinguo.edit2020.bean.m0 I2 = this.f10326e.I();
            kotlin.jvm.internal.s.e(I2);
            p.setValue(I2.g());
        }
        m1(this.f10329h.get(FunctionType.SkinRefresh));
        l1();
        this.c.z(false);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        us.pinguo.edit2020.b.c cVar = this.t;
        if (!(cVar != null && cVar.f())) {
            this.f10329h.remove(FunctionType.SKIN_COLOR);
            Y0();
            L1();
            us.pinguo.edit2020.b.c cVar2 = this.t;
            if (cVar2 != null) {
                cVar2.d();
            }
            this.t = null;
            this.f10326e.i0();
            this.f10326e.m0();
            M0(this, false, 1, null);
            show();
            W0(false);
            this.c.D(null);
            ((SwitchCompat) this.c.g().findViewById(R.id.switchToggle)).setChecked(false);
            this.c.z(false);
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).f();
            this.x = -1;
            if (this.M != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.M;
                this.M = 0L;
                if (this.Q <= 0) {
                    us.pinguo.foundation.statistics.h.b.l("yunfu", String.valueOf(currentTimeMillis), TJAdUnitConstants.String.VIDEO_COMPLETE);
                } else {
                    us.pinguo.foundation.statistics.h.b.l("new_qudou", String.valueOf(currentTimeMillis), TJAdUnitConstants.String.VIDEO_COMPLETE);
                }
            }
            this.Q = 0;
            this.P = false;
            this.R.set(0);
            ((StickySeekBar) this.c.g().findViewById(R.id.seekBar)).setEnabled(true);
            ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).setTabLayoutAndCompleteButtonEnabled(true);
            return;
        }
        us.pinguo.edit2020.b.c cVar3 = this.t;
        if (cVar3 == null) {
            return;
        }
        cVar3.d();
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        MakeupController makeupController = this.n;
        if (makeupController == null) {
            return;
        }
        makeupController.e(unityCanvasStatus);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        us.pinguo.edit2020.b.c cVar = this.t;
        if (cVar == null) {
            return false;
        }
        return cVar.f();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        BeautySkinColorView beautySkinColorView = (BeautySkinColorView) this.f10329h.get(FunctionType.SKIN_COLOR);
        if (beautySkinColorView != null) {
            beautySkinColorView.i();
        }
        this.x = -1;
        Z0();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        this.f10326e.n().j(records);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(final boolean z, final boolean z2) {
        this.r = z;
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.x0
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyController.i1(EditBottomTabBeautyController.this, z, z2);
            }
        });
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void o(int i2) {
        View view;
        this.E = i2;
        k1();
        FunctionType value = this.f10326e.t().getValue();
        FunctionType functionType = FunctionType.FacialFeatures;
        if (value == functionType && (view = this.f10329h.get(functionType)) != null) {
            ((BeautyAdjustFacialFeaturesView) view).setFaceSelectTipVisible(false);
            this.c.C(true);
        }
        FunctionType value2 = this.f10326e.t().getValue();
        int i3 = value2 == null ? -1 : a.a[value2.ordinal()];
        if (i3 == 1) {
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            String I0 = I0();
            BeautyEditData value3 = this.f10326e.p().getValue();
            iVar.u(I0, value3 != null ? value3.getBeautyKey() : null, "change_face");
        } else if (i3 != 2) {
        } else {
            us.pinguo.foundation.statistics.i iVar2 = us.pinguo.foundation.statistics.h.b;
            BeautyEditData value4 = this.f10326e.p().getValue();
            iVar2.u0(value4 != null ? value4.getBeautyKey() : null, "", "change_face");
        }
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        GuideHandler guideHandler = this.I;
        if (guideHandler != null && guideHandler.r()) {
            GuideHandler guideHandler2 = this.I;
            kotlin.jvm.internal.s.e(guideHandler2);
            guideHandler2.l();
            return true;
        }
        us.pinguo.edit2020.b.c cVar = this.t;
        if (cVar == null) {
            return false;
        }
        return cVar.onBackPressed();
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void show() {
        View C0 = C0();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(C0);
        this.c.x(false);
        this.f10326e.r0(false);
        this.f10326e.t().setValue(FunctionType.BeautyMenu);
    }
}
