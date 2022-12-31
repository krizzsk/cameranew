package us.pinguo.camera2020.fragment;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.z0;
import us.pinguo.ad.RewardVipAdController;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.activity.Camera2020Activity;
import us.pinguo.camera2020.activity.ViewFinderSettingsActivity;
import us.pinguo.camera2020.module.AfterCaptureMode;
import us.pinguo.camera2020.module.AfterCaptureModule;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.module.PhotoState;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.camera2020.module.frame.FrameRatioModule;
import us.pinguo.camera2020.module.settings.CameraTopSettingsModule;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.camera2020.view.AccelerationSensorController;
import us.pinguo.camera2020.view.AfterCaptureBottomController;
import us.pinguo.camera2020.view.CameraBeautyController;
import us.pinguo.camera2020.view.CameraBottomViewController;
import us.pinguo.camera2020.view.CameraRootLayout;
import us.pinguo.camera2020.view.CameraZoomLayout;
import us.pinguo.camera2020.view.StickerLayout;
import us.pinguo.camera2020.view.StickerViewController;
import us.pinguo.camera2020.view.TimerCountDownController;
import us.pinguo.camera2020.view.TopSettingController;
import us.pinguo.camera2020.view.TopSettingLayout;
import us.pinguo.camera2020.view.VideoPreviewController;
import us.pinguo.camera2020.view.ViewFinderGestureDetector;
import us.pinguo.camera2020.view.ViewFinderPermissionControl;
import us.pinguo.camera2020.view.focusview.PGFocusView;
import us.pinguo.camera2020.view.l2;
import us.pinguo.camera2020.view.m2;
import us.pinguo.camera2020.view.o2;
import us.pinguo.camera2020.view.p2;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.viewmodel.CameraViewModelFactory;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.camera2020.widget.FlashWhiteView;
import us.pinguo.camera2020.widget.ParameterAdvanceSettingView;
import us.pinguo.camera2020.widget.PictureFramePanel;
import us.pinguo.camera2020.widget.ShutterActionView;
import us.pinguo.cameramanger.CameraPreferencesManager;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.cameramanger.info.WhiteBalance;
import us.pinguo.common.EventType;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.ChangeStatus;
import us.pinguo.common.filter.controller.AutoFilterProducer;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.filter.util.FilterParamsHelper;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.common.manager.AdvDialogManager;
import us.pinguo.common.widget.ColorAnimDraweeView;
import us.pinguo.common.widget.FilterNameAnimView;
import us.pinguo.common.widget.SkyChangeGuideView;
import us.pinguo.common.widget.VipNoticeAnimView;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.foundation.o.c;
import us.pinguo.processor.PreviewProcessState;
import us.pinguo.processor.ShaderCache;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.database.sticker.StickerCategory;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.u3dengine.PGUnityCameraFragment;
import us.pinguo.u3dengine.PgUnityPlayer;
import us.pinguo.u3dengine.api.UnityCallbackApi;
import us.pinguo.u3dengine.api.UnityMethodCaller;
import us.pinguo.u3dengine.api.WatermarkStyle;
import us.pinguo.ui.widget.MultiStateImageTextView;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment extends PGUnityCameraFragment implements m2.a, us.pinguo.camera2020.view.focusview.a, us.pinguo.camera2020.view.focusview.b, AccelerationSensorController.a, ParameterAdvanceSettingView.c {
    public static final a e0 = new a(null);
    private static boolean f0;
    private us.pinguo.camera2020.utils.d.e A;
    private VideoMusic B;
    private Handler C;
    private OrientationEventListener D;
    private int E;
    private int F;
    private boolean G;
    private us.pinguo.common.f H;
    private us.pinguo.camera2020.module.b I;
    private AccelerationSensorController J;
    private boolean K;
    private boolean L;
    private AlertDialog M;
    private ParameterAdvanceSettingView N;
    private float O;
    private ViewFinderPermissionControl P;
    private boolean Q;
    private Parcelable R;
    private AdvDialogManager S;
    private boolean T;
    private volatile boolean U;
    private ConstraintLayout V;
    private boolean W;
    private boolean X;
    private Object Y;
    private volatile boolean Z;
    private volatile boolean d0;

    /* renamed from: h  reason: collision with root package name */
    private TopSettingController f9172h;

    /* renamed from: i  reason: collision with root package name */
    private StickerViewController f9173i;

    /* renamed from: j  reason: collision with root package name */
    private CameraViewModel f9174j;

    /* renamed from: k  reason: collision with root package name */
    private p2 f9175k;

    /* renamed from: l  reason: collision with root package name */
    private m2 f9176l;
    private CameraZoomLayout m;
    private CameraBottomViewController n;
    private VideoPreviewController o;
    private CameraBeautyController p;
    private AfterCaptureBottomController q;
    private TimerCountDownController r;
    private ViewFinderGestureDetector s;
    private RewardVipAdController t;
    private FilterController u;
    private Resources.Theme w;
    private CameraRootLayout x;
    private PGFocusView y;
    private final kotlin.f z;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f9171g = new LinkedHashMap();
    private final AutoFilterProducer v = new AutoFilterProducer();

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final ViewFinderFragment a() {
            return new ViewFinderFragment();
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PhotoState.values().length];
            iArr[PhotoState.SAVED.ordinal()] = 1;
            iArr[PhotoState.DISCARDED.ordinal()] = 2;
            iArr[PhotoState.FAILED.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[ExclusiveEffectType.values().length];
            iArr2[ExclusiveEffectType.EFFECT_FILTER.ordinal()] = 1;
            iArr2[ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP.ordinal()] = 2;
            iArr2[ExclusiveEffectType.EFFECT_STYLED_MAKEUP.ordinal()] = 3;
            iArr2[ExclusiveEffectType.EFFECT_STICKER.ordinal()] = 4;
            b = iArr2;
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> implements Observer<T> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            Boolean it = (Boolean) t;
            AutoFilterProducer autoFilterProducer = ViewFinderFragment.this.v;
            kotlin.jvm.internal.s.g(it, "it");
            autoFilterProducer.j(it.booleanValue());
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class d<T> implements Observer<T> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            ViewFinderFragment.this.v.i((us.pinguo.facedetector.c) t);
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class e<T> implements Observer<T> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            ViewFinderFragment.this.v.k((AutoFilterProducer.b) t);
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class f<T> implements Observer<T> {
        final /* synthetic */ CameraBeautyController a;

        public f(CameraBeautyController cameraBeautyController) {
            this.a = cameraBeautyController;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            this.a.l0((StyleMakeup) t);
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class g<T> implements Observer<T> {
        final /* synthetic */ CameraBeautyController a;

        public g(CameraBeautyController cameraBeautyController) {
            this.a = cameraBeautyController;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            this.a.k0((BeautyData) t);
        }
    }

    /* compiled from: LiveData.kt */
    /* loaded from: classes3.dex */
    public static final class h<T> implements Observer<T> {
        final /* synthetic */ CameraBeautyController a;

        public h(CameraBeautyController cameraBeautyController) {
            this.a = cameraBeautyController;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            this.a.j0((BeautyData) t);
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class i implements c.a {
        final /* synthetic */ AlertDialog a;
        final /* synthetic */ kotlin.jvm.b.a<kotlin.u> b;

        i(AlertDialog alertDialog, kotlin.jvm.b.a<kotlin.u> aVar) {
            this.a = alertDialog;
            this.b = aVar;
        }

        @Override // us.pinguo.foundation.o.c.a
        public void a() {
            kotlin.jvm.b.a<kotlin.u> aVar = this.b;
            if (aVar != null) {
                aVar.invoke();
            }
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void b() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void c() {
            AlertDialog alertDialog = this.a;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }

        @Override // us.pinguo.foundation.o.c.a
        public void d() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

        @Override // us.pinguo.foundation.o.c.a
        public void e() {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void f(int i2) {
        }

        @Override // us.pinguo.foundation.o.c.a
        public void g() {
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class j implements us.pinguo.camera2020.module.a {
        j() {
        }

        @Override // us.pinguo.camera2020.module.a
        public void a(ExclusiveEffectType effectType) {
            kotlin.jvm.internal.s.h(effectType, "effectType");
        }

        @Override // us.pinguo.camera2020.module.a
        public boolean b(ExclusiveEffectType effectType) {
            kotlin.jvm.internal.s.h(effectType, "effectType");
            return true;
        }

        @Override // us.pinguo.camera2020.module.a
        public void c(ExclusiveEffectType effectType) {
            kotlin.jvm.internal.s.h(effectType, "effectType");
            if (effectType == ExclusiveEffectType.EFFECT_STICKER || effectType == ExclusiveEffectType.EFFECT_FILTER || effectType == ExclusiveEffectType.EFFECT_STYLED_MAKEUP || effectType == ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP) {
                CameraViewModel cameraViewModel = ViewFinderFragment.this.f9174j;
                if (cameraViewModel != null) {
                    cameraViewModel.setCurrentExclusiveType(effectType);
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class k extends o2 {

        /* compiled from: ViewFinderFragment.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ExclusiveEffectType.values().length];
                iArr[ExclusiveEffectType.EFFECT_FILTER.ordinal()] = 1;
                iArr[ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP.ordinal()] = 2;
                iArr[ExclusiveEffectType.EFFECT_STYLED_MAKEUP.ordinal()] = 3;
                a = iArr;
            }
        }

        k() {
        }

        @Override // us.pinguo.camera2020.view.o2
        public /* bridge */ /* synthetic */ kotlin.u a(boolean z) {
            b(z);
            return kotlin.u.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
            if ((r0 != null && r0.S()) != false) goto L101;
         */
        /* JADX WARN: Removed duplicated region for block: B:122:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00da  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(boolean r9) {
            /*
                Method dump skipped, instructions count: 411
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.k.b(boolean):void");
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class l implements us.pinguo.camera2020.widget.f {
        final /* synthetic */ FrameRatioModule b;

        l(FrameRatioModule frameRatioModule) {
            this.b = frameRatioModule;
        }

        @Override // us.pinguo.camera2020.widget.f
        public void a() {
            ViewFinderFragment.this.C1();
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = this.b.f();
            us.pinguo.camera2020.module.frame.a aVar = f2 == null ? null : f2.get(this.b.d().getValue());
            if (aVar != null) {
                FrameRatioModule frameRatioModule = this.b;
                ViewFinderFragment viewFinderFragment = ViewFinderFragment.this;
                frameRatioModule.k(aVar);
                CameraBottomViewController cameraBottomViewController = viewFinderFragment.n;
                if (cameraBottomViewController == null) {
                    kotlin.jvm.internal.s.z("cameraBottomController");
                    throw null;
                } else {
                    Integer b = aVar.b();
                    cameraBottomViewController.F(b == null ? 0 : b.intValue());
                }
            }
            View _$_findCachedViewById = ViewFinderFragment.this._$_findCachedViewById(R.id.viewFinderMask);
            if (_$_findCachedViewById == null) {
                return;
            }
            _$_findCachedViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, 4);
        }

        @Override // us.pinguo.camera2020.widget.f
        public void onStart() {
            ((VipNoticeAnimView) ViewFinderFragment.this._$_findCachedViewById(R.id.vipNoticeView)).setAlpha(0.0f);
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class m extends OrientationEventListener {
        final /* synthetic */ CameraViewModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(CameraViewModel cameraViewModel, FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.b = cameraViewModel;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            ViewFinderFragment viewFinderFragment = ViewFinderFragment.this;
            viewFinderFragment.E = us.pinguo.foundation.utils.h0.e(i2, viewFinderFragment.E);
            ViewFinderFragment viewFinderFragment2 = ViewFinderFragment.this;
            viewFinderFragment2.E = viewFinderFragment2.E >= 0 ? ViewFinderFragment.this.E : 0;
            if (ViewFinderFragment.this.F != ViewFinderFragment.this.E) {
                us.pinguo.common.log.a.q("lastDeviceOrientation=" + ViewFinderFragment.this.F + ", newDeviceOrientation=" + ViewFinderFragment.this.E, new Object[0]);
                ViewFinderFragment viewFinderFragment3 = ViewFinderFragment.this;
                viewFinderFragment3.F = viewFinderFragment3.E;
                this.b.setOrientation(ViewFinderFragment.this.F);
            }
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class n implements us.pinguo.common.g {
        final /* synthetic */ CameraViewModel a;
        final /* synthetic */ ViewFinderFragment b;

        n(CameraViewModel cameraViewModel, ViewFinderFragment viewFinderFragment) {
            this.a = cameraViewModel;
            this.b = viewFinderFragment;
        }

        @Override // us.pinguo.common.g
        public boolean E(us.pinguo.common.d event) {
            kotlin.jvm.internal.s.h(event, "event");
            CameraTopSettingsModule cameraTopSettingModule = this.a.getCameraTopSettingModule();
            if (event.c() == EventType.LONG_PRESS) {
                Boolean value = cameraTopSettingModule.k().getValue();
                Boolean bool = Boolean.TRUE;
                if (kotlin.jvm.internal.s.c(value, bool) && kotlin.jvm.internal.s.c(cameraTopSettingModule.l().getValue(), bool)) {
                    return true;
                }
            }
            if (event.c() == EventType.TOUCH_UP && this.a.getCameraBottomModule().a().getValue() == CameraSwitchMode.PHOTO) {
                Boolean value2 = cameraTopSettingModule.k().getValue();
                Boolean bool2 = Boolean.TRUE;
                if (kotlin.jvm.internal.s.c(value2, bool2) && kotlin.jvm.internal.s.c(cameraTopSettingModule.l().getValue(), bool2)) {
                    PictureFramePanel pictureFramePanel = (PictureFramePanel) this.b._$_findCachedViewById(R.id.framePanel);
                    MotionEvent b = event.b();
                    if (pictureFramePanel.b(b == null ? 0.0f : b.getY())) {
                        this.b.U1();
                        return true;
                    }
                }
            }
            if (event.c() == EventType.DOUBLE_CLICK) {
                PictureFramePanel pictureFramePanel2 = (PictureFramePanel) this.b._$_findCachedViewById(R.id.framePanel);
                MotionEvent b2 = event.b();
                if (pictureFramePanel2.b(b2 != null ? b2.getY() : 0.0f)) {
                    this.b.U();
                    return true;
                }
            }
            if (event.c() == EventType.BACK_PRESS) {
                this.b.f();
                return true;
            }
            return false;
        }
    }

    /* compiled from: ViewFinderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class o implements us.pinguo.common.g {
        o() {
        }

        @Override // us.pinguo.common.g
        public boolean E(us.pinguo.common.d event) {
            kotlin.jvm.internal.s.h(event, "event");
            TimerCountDownController timerCountDownController = ViewFinderFragment.this.r;
            if (timerCountDownController == null) {
                kotlin.jvm.internal.s.z("timerCountDownController");
                throw null;
            } else if (timerCountDownController.f()) {
                if (event.c() == EventType.BACK_PRESS || ((event.c() == EventType.TOUCH_UP || event.c() == EventType.DOUBLE_CLICK) && event.a())) {
                    TimerCountDownController timerCountDownController2 = ViewFinderFragment.this.r;
                    if (timerCountDownController2 != null) {
                        TimerCountDownController.d(timerCountDownController2, null, 1, null);
                        ViewFinderFragment.this.d4();
                    } else {
                        kotlin.jvm.internal.s.z("timerCountDownController");
                        throw null;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }

    public ViewFinderFragment() {
        kotlin.f b2;
        b2 = kotlin.h.b(ViewFinderFragment$musicPlayer$2.INSTANCE);
        this.z = b2;
        this.E = -1;
        this.F = -1;
        this.H = new us.pinguo.common.f();
        this.I = new us.pinguo.camera2020.module.b();
        this.J = new AccelerationSensorController();
        this.K = true;
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A1(ViewFinderFragment viewFinderFragment, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        viewFinderFragment.z1(z, z2);
    }

    private final void A4() {
        LifecycleCoroutineScope J1 = J1();
        if (J1 == null) {
            return;
        }
        kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$updateTouchCaptureEnableState$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(ViewFinderFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraViewModel cameraViewModel = this$0.f9174j;
        if (cameraViewModel != null) {
            CameraViewModel.focusAndMetering$default(cameraViewModel, 528.6621f, 979.10156f, 1080, 2400, null, 16, null);
            this$0.l();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B3(ViewFinderFragment this$0, StyleMakeup styleMakeup) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraViewModel cameraViewModel = this$0.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.getCameraBeautyModule().c0(styleMakeup);
            CameraViewModel cameraViewModel2 = this$0.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            } else if (cameraViewModel2.getCurrentExclusiveType() == ExclusiveEffectType.EFFECT_STYLED_MAKEUP) {
                CameraViewModel cameraViewModel3 = this$0.f9174j;
                if (cameraViewModel3 != null) {
                    this$0.t4(styleMakeup, cameraViewModel3.getCameraBeautyModule().w() == ChangeStatus.CLICK_LEFT);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            } else {
                return;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B4() {
        try {
            Object obj = this.Y;
            Class<?> cls = Class.forName("com.pinguo.camera360.camera.controller.VipHalfScreenController");
            if (obj == null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(CameraViewModel.class);
                Object[] objArr = new Object[1];
                CameraViewModel cameraViewModel = this.f9174j;
                if (cameraViewModel == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                objArr[0] = cameraViewModel;
                obj = declaredConstructor.newInstance(objArr);
                if (obj != null) {
                    this.Y = obj;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
            }
            Object invoke = cls.getDeclaredMethod(TJAdUnitConstants.String.ENABLED, new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Exception e2) {
            if (us.pinguo.foundation.d.f10985d) {
                e2.printStackTrace();
            }
            CrashReport.postCatchedException(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
            CameraFrame value = frameRatioModule.d().getValue();
            if (value == null) {
                return;
            }
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = frameRatioModule.f();
            us.pinguo.camera2020.module.frame.a aVar = f2 != null ? f2.get(value) : null;
            if (aVar == null) {
                return;
            }
            Integer d2 = aVar.d();
            int intValue = d2 == null ? 0 : d2.intValue();
            Integer b2 = aVar.b();
            H1(intValue, b2 != null ? b2.intValue() : 0, aVar.a());
            I1();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C3(ViewFinderFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        l2 l2Var = l2.a;
        kotlin.jvm.internal.s.g(it, "it");
        l2Var.k(it.booleanValue());
        this$0.z4();
    }

    private final void D1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        us.pinguo.foundation.utils.w.i(context, R.string.camera_exception, R.string.ok, -999, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.fragment.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ViewFinderFragment.E1(ViewFinderFragment.this, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D3(Boolean bool) {
        l2.a.j(!bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(ViewFinderFragment this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E3(ViewFinderFragment this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraBottomViewController cameraBottomViewController = this$0.n;
        if (cameraBottomViewController != null) {
            cameraBottomViewController.C0(num.intValue() * 1000);
        } else {
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
    }

    private final void F1(int i2) {
        Resources.Theme theme = this.w;
        if (theme != null) {
            theme.applyStyle(i2, true);
            View _$_findCachedViewById = _$_findCachedViewById(R.id.bottomMenuLayout);
            Resources.Theme theme2 = this.w;
            if (theme2 != null) {
                us.pinguo.common.utils.d.a(_$_findCachedViewById, theme2);
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraTheme");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraTheme");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F3(ViewFinderFragment this$0, CameraSwitchMode cameraSwitchMode) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f4(cameraSwitchMode);
        this$0.A4();
        this$0.z4();
    }

    private final void G1(int i2, int i3, boolean z) {
        String obj;
        ParameterAdvanceSettingView parameterAdvanceSettingView;
        int v;
        int v2;
        int v3;
        us.pinguo.foundation.h hVar = null;
        if (i2 != 0) {
            boolean z2 = true;
            if (i2 == 1) {
                us.pinguo.foundation.h a2 = us.pinguo.camera2020.h.b.b().a("key_camera_whitebalance");
                kotlin.jvm.internal.s.e(a2);
                a2.o(i3);
                CameraViewModel cameraViewModel = this.f9174j;
                if (cameraViewModel != null) {
                    List<WhiteBalance> supportedWhiteBalance = cameraViewModel.getSupportedWhiteBalance();
                    us.pinguo.camera2020.h.a aVar = new us.pinguo.camera2020.h.a(a2.g(), a2.h());
                    if (supportedWhiteBalance != null && !supportedWhiteBalance.isEmpty()) {
                        z2 = false;
                    }
                    if (!z2) {
                        int size = supportedWhiteBalance.size();
                        Object[] objArr = new Object[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            Object[] c2 = a2.c();
                            String[] f2 = a2.f();
                            kotlin.jvm.internal.s.g(f2, "pref!!.entryValues");
                            v3 = kotlin.collections.n.v(f2, supportedWhiteBalance.get(i4).name());
                            objArr[i4] = c2[v3];
                        }
                        aVar.l(objArr);
                        int size2 = supportedWhiteBalance.size();
                        String[] strArr = new String[size2];
                        for (int i5 = 0; i5 < size2; i5++) {
                            String[] f3 = a2.f();
                            String[] f4 = a2.f();
                            kotlin.jvm.internal.s.g(f4, "pref!!.entryValues");
                            v2 = kotlin.collections.n.v(f4, supportedWhiteBalance.get(i5).name());
                            strArr[i5] = f3[v2];
                        }
                        aVar.m(strArr);
                        int size3 = supportedWhiteBalance.size();
                        int[] iArr = new int[size3];
                        for (int i6 = 0; i6 < size3; i6++) {
                            int[] p = ((us.pinguo.camera2020.h.a) a2).p();
                            String[] f5 = a2.f();
                            kotlin.jvm.internal.s.g(f5, "pref!!.entryValues");
                            v = kotlin.collections.n.v(f5, supportedWhiteBalance.get(i6).name());
                            iArr[i6] = p[v];
                        }
                        aVar.q(iArr);
                    }
                    CameraViewModel cameraViewModel2 = this.f9174j;
                    if (cameraViewModel2 != null) {
                        String str = aVar.f()[i3];
                        kotlin.jvm.internal.s.g(str, "pref.entryValues[scaleIndex]");
                        cameraViewModel2.setWhiteBalance(WhiteBalance.valueOf(str));
                        obj = aVar.c()[i3].toString();
                        hVar = aVar;
                    } else {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            } else if (i2 == 2) {
                hVar = us.pinguo.camera2020.h.b.b().a("key_camera_exposure");
                kotlin.jvm.internal.s.e(hVar);
                hVar.o(i3);
                obj = hVar.d().toString();
            } else if (i2 == 3) {
                hVar = us.pinguo.camera2020.h.b.b().a("pref_camera_iso_key");
                kotlin.jvm.internal.s.e(hVar);
                hVar.o(i3);
                if (i3 == 0) {
                    String i7 = hVar.i();
                    kotlin.jvm.internal.s.e(i7);
                    Integer.parseInt(i7);
                }
                obj = hVar.d().toString();
            } else if (i2 == 5) {
                hVar = us.pinguo.camera2020.h.b.b().a("key_camera_focus_distance");
                kotlin.jvm.internal.s.e(hVar);
                hVar.o(i3);
                obj = hVar.d().toString();
            } else if (i2 != 6) {
                obj = null;
            } else {
                hVar = us.pinguo.camera2020.h.b.b().a("key_camera_shutter_speed");
                kotlin.jvm.internal.s.e(hVar);
                hVar.o(i3);
                if (i3 == 0) {
                    String i8 = hVar.i();
                    kotlin.jvm.internal.s.e(i8);
                    Long valueOf = Long.valueOf(i8);
                    if (valueOf != null) {
                        valueOf.longValue();
                    }
                }
                obj = hVar.d().toString();
            }
        } else {
            hVar = us.pinguo.camera2020.h.b.b().a("key_camera_focusmode");
            kotlin.jvm.internal.s.e(hVar);
            hVar.o(i3);
            String i9 = hVar.i();
            kotlin.jvm.internal.s.e(i9);
            Integer.valueOf(i9);
            obj = hVar.d().toString();
        }
        if (hVar == null || obj == null || (parameterAdvanceSettingView = this.N) == null) {
            return;
        }
        String h2 = hVar.h();
        kotlin.jvm.internal.s.g(h2, "pref.title");
        parameterAdvanceSettingView.J(h2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G3(ViewFinderFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.z4();
    }

    private final void H1(int i2, int i3, int i4) {
        FrameLayout frameLayout;
        int i5 = R.id.viewFinderContainer;
        if (((FrameLayout) _$_findCachedViewById(i5)) == null) {
            return;
        }
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer != null && (frameLayout = (FrameLayout) _$_findCachedViewById(i5)) != null) {
            frameLayout.removeView(pgUnityPlayer);
        }
        FrameLayout viewFinderContainer = (FrameLayout) _$_findCachedViewById(i5);
        kotlin.jvm.internal.s.g(viewFinderContainer, "viewFinderContainer");
        ViewGroup.LayoutParams layoutParams = viewFinderContainer.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        int i6 = R.id.clRootLayout;
        layoutParams2.startToStart = i6;
        layoutParams2.endToEnd = i6;
        layoutParams2.topToTop = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i2;
        layoutParams2.bottomToBottom = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = i4;
        viewFinderContainer.setLayoutParams(layoutParams2);
        FrameLayout layoutVideoPreview = (FrameLayout) _$_findCachedViewById(R.id.layoutVideoPreview);
        kotlin.jvm.internal.s.g(layoutVideoPreview, "layoutVideoPreview");
        ViewGroup.LayoutParams layoutParams3 = layoutVideoPreview.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = 0;
        layoutParams4.startToStart = i6;
        layoutParams4.endToEnd = i6;
        layoutParams4.topToTop = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = i2;
        layoutParams4.bottomToBottom = i6;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = i4;
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = i4;
        layoutVideoPreview.setLayoutParams(layoutParams4);
        PgUnityPlayer pgUnityPlayer2 = PgUnityPlayer.getInstance();
        if ((pgUnityPlayer2 == null ? null : pgUnityPlayer2.getParent()) == null) {
            us.pinguo.common.log.a.c("re-add unity player", new Object[0]);
            ((FrameLayout) _$_findCachedViewById(i5)).addView(pgUnityPlayer2, 0);
            return;
        }
        CrashReport.postCatchedException(new IllegalStateException("mUnityPlayer parent not null"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H3(ViewFinderFragment this$0, Size size) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        AfterCaptureBottomController afterCaptureBottomController = this$0.q;
        if (afterCaptureBottomController == null) {
            kotlin.jvm.internal.s.z("afterCaptureController");
            throw null;
        } else if (afterCaptureBottomController.H()) {
        } else {
            CameraViewModel cameraViewModel = this$0.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.restoreCameraPreview();
                CameraViewModel cameraViewModel2 = this$0.f9174j;
                if (cameraViewModel2 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (cameraViewModel2.getFrameRatioModule().d().getValue() == CameraFrame.FRAME_1_1) {
                    int width = size.getWidth() < size.getHeight() ? size.getWidth() : size.getHeight();
                    us.pinguo.camera2020.utils.d.e eVar = this$0.A;
                    if (eVar != null) {
                        eVar.k(width, width);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("videoRecordManager");
                        throw null;
                    }
                } else {
                    us.pinguo.camera2020.utils.d.e eVar2 = this$0.A;
                    if (eVar2 != null) {
                        eVar2.k(size.getWidth(), size.getHeight());
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("videoRecordManager");
                        throw null;
                    }
                }
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    private final void I1() {
        Integer d2;
        int a2;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
            CameraFrame value = frameRatioModule.d().getValue();
            if (value == null) {
                return;
            }
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = frameRatioModule.f();
            us.pinguo.camera2020.module.frame.a aVar = f2 == null ? null : f2.get(value);
            if (aVar == null || (d2 = aVar.d()) == null) {
                return;
            }
            int intValue = d2.intValue();
            if (intValue > 0) {
                Context b2 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b2, "getAppContext()");
                a2 = intValue + us.pinguo.util.g.a(b2, 14.0f);
            } else {
                Context b3 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b3, "getAppContext()");
                a2 = us.pinguo.util.g.a(b3, 94.0f);
            }
            int i2 = R.id.vipNoticeView;
            if (us.pinguo.edit2020.utils.d.e((VipNoticeAnimView) _$_findCachedViewById(i2))) {
                return;
            }
            VipNoticeAnimView vipNoticeView = (VipNoticeAnimView) _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(vipNoticeView, "vipNoticeView");
            ViewGroup.LayoutParams layoutParams = vipNoticeView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = a2;
            vipNoticeView.setLayoutParams(layoutParams2);
            if (((VipNoticeAnimView) _$_findCachedViewById(i2)).g()) {
                LifecycleCoroutineScope J1 = J1();
                if (J1 == null) {
                    return;
                }
                kotlinx.coroutines.l.d(J1, z0.c(), null, new ViewFinderFragment$changeVipNoticePosition$2(this, null), 2, null);
                return;
            }
            ((VipNoticeAnimView) _$_findCachedViewById(i2)).setAlpha(1.0f);
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I3(final ViewFinderFragment this$0, final CameraViewModel viewModel, final Boolean bool) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        Handler handler = this$0.C;
        if (handler != null) {
            handler.post(new Runnable() { // from class: us.pinguo.camera2020.fragment.t0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewFinderFragment.J3(CameraViewModel.this, bool, this$0);
                }
            });
        } else {
            kotlin.jvm.internal.s.z("mainHandler");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleCoroutineScope J1() {
        LifecycleOwner value = getViewLifecycleOwnerLiveData().getValue();
        if (value == null) {
            return null;
        }
        return LifecycleOwnerKt.getLifecycleScope(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J3(CameraViewModel viewModel, Boolean bool, ViewFinderFragment this$0) {
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        try {
            Boolean bool2 = Boolean.TRUE;
            viewModel.switchCamera(kotlin.jvm.internal.s.c(bool, bool2));
            this$0.z4();
            this$0.O = 0.0f;
            viewModel.getFrameRatioModule().r(kotlin.jvm.internal.s.c(bool, bool2) ? LensFacing.FRONT : LensFacing.BACK);
            p2 p2Var = this$0.f9175k;
            if (p2Var == null) {
                return;
            }
            p2Var.d();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            CrashReport.postCatchedException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        FragmentActivity activity;
        us.pinguo.camera2020.module.frame.a o2;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
            CameraFrame value = frameRatioModule.d().getValue();
            if (value == null || value == CameraFrame.FRAME_1_1 || (activity = getActivity()) == null || (o2 = frameRatioModule.o()) == null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            kotlin.jvm.internal.s.g(decorView, "act.window.decorView");
            int b2 = us.pinguo.util.h.b(decorView);
            int i2 = R.id.framePanel;
            ((PictureFramePanel) _$_findCachedViewById(i2)).setHaircutHeight(b2);
            Integer d2 = o2.d();
            int intValue = d2 == null ? 0 : d2.intValue();
            Integer b3 = o2.b();
            int intValue2 = b3 == null ? 0 : b3.intValue();
            ((PictureFramePanel) _$_findCachedViewById(i2)).setBottomBlackHeight(frameRatioModule.c() + frameRatioModule.h());
            ((PictureFramePanel) _$_findCachedViewById(i2)).setUpperAndLowerHeight(intValue, intValue2, false);
            Integer d3 = o2.d();
            int intValue3 = d3 == null ? 0 : d3.intValue();
            Integer b4 = o2.b();
            H1(intValue3, b4 != null ? b4.intValue() : 0, o2.a());
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(ViewFinderFragment this$0, CameraViewModel viewModel, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.g(it, "it");
        if (it.booleanValue()) {
            PGFocusView pGFocusView = this$0.y;
            if (pGFocusView == null) {
                kotlin.jvm.internal.s.z("focusView");
                throw null;
            }
            pGFocusView.G(0L);
        }
        TextView touchScreenCapture = (TextView) this$0._$_findCachedViewById(R.id.touchScreenCapture);
        kotlin.jvm.internal.s.g(touchScreenCapture, "touchScreenCapture");
        int i2 = it.booleanValue() && kotlin.jvm.internal.s.c(viewModel.getCameraTopSettingModule().k().getValue(), Boolean.TRUE) ? 0 : 8;
        touchScreenCapture.setVisibility(i2);
        VdsAgent.onSetViewVisibility(touchScreenCapture, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            boolean z = true;
            AfterCaptureMode afterCaptureMode = ((cameraViewModel.getCameraStickerModule().u().getValue() != null) || (us.pinguo.camera2020.utils.b.a.a() && l2.a.a())) ? AfterCaptureMode.SCREENSHOT : AfterCaptureMode.PHOTO;
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            } else if (cameraViewModel2.getGettingPictureAfterSnapshot()) {
                return;
            } else {
                int i2 = R.id.shutterAction;
                if (((ShutterActionView) _$_findCachedViewById(i2)) == null) {
                    return;
                }
                CameraViewModel cameraViewModel3 = this.f9174j;
                if (cameraViewModel3 != null) {
                    cameraViewModel3.captureUpToStatistics();
                    CameraViewModel cameraViewModel4 = this.f9174j;
                    if (cameraViewModel4 != null) {
                        cameraViewModel4.cameraAttrUpToStat("camera_shot");
                        us.pinguo.foundation.statistics.a.u().C("original");
                        us.pinguo.foundation.statistics.a.u().D("0");
                        us.pinguo.foundation.statistics.a.u().onEvent();
                        int i3 = this.E;
                        int i4 = i3 >= 0 ? i3 : 0;
                        ((ShutterActionView) _$_findCachedViewById(i2)).a();
                        CameraViewModel cameraViewModel5 = this.f9174j;
                        if (cameraViewModel5 != null) {
                            CameraTopSettingsModule cameraTopSettingModule = cameraViewModel5.getCameraTopSettingModule();
                            Boolean value = cameraTopSettingModule.d().getValue();
                            Boolean bool = Boolean.TRUE;
                            z = (kotlin.jvm.internal.s.c(value, bool) && kotlin.jvm.internal.s.c(cameraTopSettingModule.e().getValue(), bool)) ? false : false;
                            CameraViewModel cameraViewModel6 = this.f9174j;
                            if (cameraViewModel6 != null) {
                                FilterEntry value2 = cameraViewModel6.getCameraFilterModule().y().getValue();
                                LifecycleCoroutineScope J1 = J1();
                                if (J1 != null) {
                                    kotlinx.coroutines.l.d(J1, z0.c(), null, new ViewFinderFragment$doTakePicture$1(z, this, value2, afterCaptureMode, null), 2, null);
                                }
                                us.pinguo.foundation.c.e("do_camera_shot");
                                CameraViewModel cameraViewModel7 = this.f9174j;
                                if (cameraViewModel7 != null) {
                                    cameraViewModel7.takePicture(i4);
                                    CameraViewModel cameraViewModel8 = this.f9174j;
                                    if (cameraViewModel8 != null) {
                                        cameraViewModel8.resolutionStat();
                                        return;
                                    } else {
                                        kotlin.jvm.internal.s.z("cameraViewModel");
                                        throw null;
                                    }
                                }
                                kotlin.jvm.internal.s.z("cameraViewModel");
                                throw null;
                            }
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(ViewFinderFragment this$0, CameraViewModel viewModel, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        TextView touchScreenCapture = (TextView) this$0._$_findCachedViewById(R.id.touchScreenCapture);
        kotlin.jvm.internal.s.g(touchScreenCapture, "touchScreenCapture");
        kotlin.jvm.internal.s.g(it, "it");
        int i2 = it.booleanValue() && kotlin.jvm.internal.s.c(viewModel.getCameraTopSettingModule().l().getValue(), Boolean.TRUE) ? 0 : 8;
        touchScreenCapture.setVisibility(i2);
        VdsAgent.onSetViewVisibility(touchScreenCapture, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(boolean z) {
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("enableUnityVolume：", Boolean.valueOf(z)), new Object[0]);
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setUnityVolumeEnable(z);
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M3(CameraViewModel viewModel, Boolean it) {
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.g(it, "it");
        viewModel.setIsShowBeautyCompare(it.booleanValue());
    }

    private final void N1() {
        this.I.d(new us.pinguo.camera2020.module.a() { // from class: us.pinguo.camera2020.fragment.ViewFinderFragment$filterMutex$1
            @Override // us.pinguo.camera2020.module.a
            public void a(ExclusiveEffectType effectType) {
                kotlin.jvm.internal.s.h(effectType, "effectType");
            }

            @Override // us.pinguo.camera2020.module.a
            public boolean b(ExclusiveEffectType effectType) {
                kotlin.jvm.internal.s.h(effectType, "effectType");
                return true;
            }

            @Override // us.pinguo.camera2020.module.a
            public void c(ExclusiveEffectType effectType) {
                LifecycleCoroutineScope J1;
                kotlin.jvm.internal.s.h(effectType, "effectType");
                J1 = ViewFinderFragment.this.J1();
                if (J1 == null) {
                    return;
                }
                kotlinx.coroutines.l.d(J1, z0.c(), null, new ViewFinderFragment$filterMutex$1$onEffectApplied$1(effectType, ViewFinderFragment.this, null), 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N3(ViewFinderFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.V;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        AfterCaptureBottomController afterCaptureBottomController = this$0.q;
        if (afterCaptureBottomController != null) {
            afterCaptureBottomController.q0();
        } else {
            kotlin.jvm.internal.s.z("afterCaptureController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup O1() {
        int i2 = R.id.viewFinderContainer;
        if (((FrameLayout) _$_findCachedViewById(i2)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) ((FrameLayout) _$_findCachedViewById(i2)).findViewById(R.id.after_process_layout);
        if (viewGroup == null) {
            View inflate = View.inflate(((FrameLayout) _$_findCachedViewById(i2)).getContext(), R.layout.preview_process_layout, (FrameLayout) _$_findCachedViewById(i2));
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            return (ViewGroup) inflate;
        }
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(ViewFinderFragment this$0, us.pinguo.camera2020.module.c cVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraBottomViewController cameraBottomViewController = this$0.n;
        if (cameraBottomViewController != null) {
            cameraBottomViewController.s0();
            int i2 = b.a[cVar.b().ordinal()];
            if (i2 == 1) {
                this$0.y3(cVar.a());
                return;
            } else if (i2 == 2) {
                this$0.w3();
                return;
            } else if (i2 != 3) {
                return;
            } else {
                this$0.x3();
                return;
            }
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final us.pinguo.foundation.i P1() {
        return (us.pinguo.foundation.i) this.z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P3(ViewFinderFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.M == null) {
            this$0.M = us.pinguo.ui.b.a.a(this$0.getContext());
        }
        kotlin.jvm.internal.s.g(it, "it");
        boolean booleanValue = it.booleanValue();
        AlertDialog alertDialog = this$0.M;
        if (!booleanValue) {
            if (alertDialog == null) {
                return;
            }
            alertDialog.dismiss();
        } else if (alertDialog == null) {
        } else {
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q1(us.pinguo.camera2020.module.AfterCaptureMode r10, us.pinguo.camera2020.widget.CameraSwitchMode r11) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.Q1(us.pinguo.camera2020.module.AfterCaptureMode, us.pinguo.camera2020.widget.CameraSwitchMode):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q3(CameraViewModel viewModel, ViewFinderFragment this$0, FrameRatioModule frameModule, View view, MotionEvent event) {
        Integer d2;
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(frameModule, "$frameModule");
        CameraStickerModule cameraStickerModule = viewModel.getCameraStickerModule();
        Sticker value = cameraStickerModule.u().getValue();
        Integer valueOf = value == null ? null : Integer.valueOf(cameraStickerModule.y(value.getPid()));
        boolean b2 = ((PictureFramePanel) this$0._$_findCachedViewById(R.id.framePanel)).b(event.getY());
        if (b2 && ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2))) {
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = frameModule.f();
            int i2 = 0;
            if (f2 != null) {
                CameraFrame value2 = frameModule.d().getValue();
                if (value2 == null) {
                    value2 = CameraFrame.FRAME_4_3;
                }
                us.pinguo.camera2020.module.frame.a aVar = f2.get(value2);
                if (aVar != null && (d2 = aVar.d()) != null) {
                    i2 = d2.intValue();
                }
            }
            MotionEvent obtain = MotionEvent.obtain(event);
            obtain.offsetLocation(0.0f, -i2);
            PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
            if (pgUnityPlayer != null) {
                pgUnityPlayer.injectEvent(obtain);
            }
        }
        ViewFinderGestureDetector viewFinderGestureDetector = this$0.s;
        if (viewFinderGestureDetector == null) {
            kotlin.jvm.internal.s.z("viewFinderGestureDetector");
            throw null;
        }
        kotlin.jvm.internal.s.g(event, "event");
        viewFinderGestureDetector.d(event, valueOf, b2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(String str, int i2) {
        LifecycleCoroutineScope J1;
        Context context = getContext();
        if (context == null || (J1 = J1()) == null) {
            return;
        }
        kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$gotoEdit$1(str, i2, this, context, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R3(ViewFinderFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((PictureFramePanel) this$0._$_findCachedViewById(R.id.framePanel)).setEnableGrid(kotlin.jvm.internal.s.c(bool, Boolean.TRUE));
    }

    private final void S1(String str, String str2, String str3) {
        o3(true);
        FilterController filterController = this.u;
        if (filterController == null) {
            return;
        }
        filterController.Z0(str, str2, str3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S3(ViewFinderFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.Y3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ViewFinderFragment.handleShutterClick:stickerVipResourceUsed:");
        us.pinguo.camera2020.i.a aVar = us.pinguo.camera2020.i.a.a;
        sb.append(aVar.c());
        sb.append(" || filterVipResourceUsed:");
        sb.append(aVar.a());
        sb.append(" || makeupVipResourceUsed:");
        sb.append(aVar.b());
        us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
        ViewFinderPermissionControl viewFinderPermissionControl = this.P;
        if (viewFinderPermissionControl == null) {
            kotlin.jvm.internal.s.z("permissionControl");
            throw null;
        } else if (viewFinderPermissionControl.i()) {
        } else {
            CameraBottomViewController cameraBottomViewController = this.n;
            if (cameraBottomViewController == null) {
                kotlin.jvm.internal.s.z("cameraBottomController");
                throw null;
            } else if (cameraBottomViewController.V()) {
            } else {
                CameraViewModel cameraViewModel = this.f9174j;
                if (cameraViewModel != null) {
                    cameraViewModel.reportModifiedCameraBeautyKeys();
                    Bundle bundle = new Bundle();
                    CameraViewModel cameraViewModel2 = this.f9174j;
                    if (cameraViewModel2 != null) {
                        bundle.putStringArrayList("camera_stat_attr_subscription", cameraViewModel2.cameraAttrToSubscription());
                        CameraViewModel cameraViewModel3 = this.f9174j;
                        if (cameraViewModel3 != null) {
                            CameraTopSettingsModule cameraTopSettingModule = cameraViewModel3.getCameraTopSettingModule();
                            CameraViewModel cameraViewModel4 = this.f9174j;
                            if (cameraViewModel4 != null) {
                                AfterCaptureModule afterCaptureModule = cameraViewModel4.getAfterCaptureModule();
                                Boolean value = cameraTopSettingModule.d().getValue();
                                Boolean bool = Boolean.TRUE;
                                boolean z = kotlin.jvm.internal.s.c(value, bool) && kotlin.jvm.internal.s.c(cameraTopSettingModule.e().getValue(), bool);
                                if (us.pinguo.repository2020.abtest.i.a.b()) {
                                    if (z && !afterCaptureModule.g() && aVar.f() && !us.pinguo.vip.proxy.b.b(us.pinguo.vip.proxy.b.a, false, 1, null)) {
                                        RewardVipAdController rewardVipAdController = this.t;
                                        if (rewardVipAdController != null) {
                                            rewardVipAdController.g(new ViewFinderFragment$handleShutterClick$1(afterCaptureModule, this));
                                        }
                                        RewardVipAdController rewardVipAdController2 = this.t;
                                        if (rewardVipAdController2 == null) {
                                            return;
                                        }
                                        rewardVipAdController2.h();
                                        return;
                                    }
                                } else if (aVar.h() && B4()) {
                                    u4();
                                    return;
                                } else if (!aVar.e() && aVar.g(getContext(), bundle)) {
                                    return;
                                }
                                TimerCountDownController timerCountDownController = this.r;
                                if (timerCountDownController == null) {
                                    kotlin.jvm.internal.s.z("timerCountDownController");
                                    throw null;
                                } else if (timerCountDownController.f()) {
                                    TimerCountDownController timerCountDownController2 = this.r;
                                    if (timerCountDownController2 != null) {
                                        TimerCountDownController.d(timerCountDownController2, null, 1, null);
                                        d4();
                                        return;
                                    }
                                    kotlin.jvm.internal.s.z("timerCountDownController");
                                    throw null;
                                } else {
                                    CameraViewModel cameraViewModel5 = this.f9174j;
                                    if (cameraViewModel5 == null) {
                                        kotlin.jvm.internal.s.z("cameraViewModel");
                                        throw null;
                                    }
                                    Integer value2 = cameraViewModel5.getCameraTopSettingModule().f().getValue();
                                    if (value2 == null) {
                                        value2 = 0;
                                    }
                                    int intValue = value2.intValue();
                                    if (intValue > 0) {
                                        Y1();
                                        CameraBottomViewController cameraBottomViewController2 = this.n;
                                        if (cameraBottomViewController2 != null) {
                                            cameraBottomViewController2.o0();
                                            TimerCountDownController timerCountDownController3 = this.r;
                                            if (timerCountDownController3 != null) {
                                                timerCountDownController3.k(intValue, new ViewFinderFragment$handleShutterClick$2(this));
                                                return;
                                            } else {
                                                kotlin.jvm.internal.s.z("timerCountDownController");
                                                throw null;
                                            }
                                        }
                                        kotlin.jvm.internal.s.z("cameraBottomController");
                                        throw null;
                                    }
                                    W1();
                                    return;
                                }
                            }
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U3() {
        P1().c();
    }

    private final void V1() {
        Bundle arguments;
        if (this.f9173i == null) {
            t2();
        }
        StickerViewController stickerViewController = this.f9173i;
        if (stickerViewController == null || (arguments = getArguments()) == null || !kotlin.jvm.internal.s.c(arguments.getString("bundle_key_is_sticker", "false"), "true")) {
            return;
        }
        stickerViewController.q(arguments.getString("bundle_key_category", null), arguments.getString("bundle_key_package", null), StickerViewController.StickerGotoSource.URL);
    }

    private final void V3(String str) {
        us.pinguo.foundation.i P1 = P1();
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.s.e(str);
        P1.f(activity, Uri.fromFile(new File(str)));
        P1().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            CameraStickerModule cameraStickerModule = cameraViewModel.getCameraStickerModule();
            cameraStickerModule.h();
            if (x2()) {
                ((FlashWhiteView) _$_findCachedViewById(R.id.flashWhiteView)).d();
                LifecycleCoroutineScope J1 = J1();
                if (J1 != null) {
                    kotlinx.coroutines.l.d(J1, z0.c(), null, new ViewFinderFragment$handleTakePictureWithScreenFlash$1(this, null), 2, null);
                }
            } else {
                L1();
            }
            Sticker value = cameraStickerModule.u().getValue();
            if (value == null) {
                return;
            }
            cameraStickerModule.D(value.getPid());
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W3(final boolean z, final boolean z2, final String str) {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.n0
            @Override // java.lang.Runnable
            public final void run() {
                ViewFinderFragment.X3(ViewFinderFragment.this, z, z2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1() {
        CameraBottomViewController cameraBottomViewController = this.n;
        if (cameraBottomViewController != null) {
            CameraBottomViewController.N(cameraBottomViewController, false, 1, null);
            CameraBottomViewController cameraBottomViewController2 = this.n;
            if (cameraBottomViewController2 != null) {
                cameraBottomViewController2.T0();
                m2 m2Var = this.f9176l;
                if (m2Var != null) {
                    m2Var.f();
                    StickerViewController stickerViewController = this.f9173i;
                    if (stickerViewController != null) {
                        stickerViewController.n();
                    }
                    FilterController filterController = this.u;
                    if (filterController != null) {
                        FilterController.p0(filterController, false, 1, null);
                    }
                    CameraBeautyController cameraBeautyController = this.p;
                    if (cameraBeautyController != null) {
                        cameraBeautyController.C();
                    }
                    p2 p2Var = this.f9175k;
                    if (p2Var != null) {
                        p2Var.b();
                    }
                    TopSettingController topSettingController = this.f9172h;
                    if (topSettingController == null) {
                        return;
                    }
                    topSettingController.t();
                    return;
                }
                kotlin.jvm.internal.s.z("cameraTopBar");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X3(ViewFinderFragment this$0, boolean z, boolean z2, String str) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.X = z;
        CameraRootLayout cameraRootLayout = this$0.x;
        if (cameraRootLayout != null) {
            cameraRootLayout.setInterceptTouchEvent(z);
            ViewGroup O1 = this$0.O1();
            TextView textView = O1 == null ? null : (TextView) O1.findViewById(R.id.after_process_tips);
            if (textView != null) {
                int i2 = (z && z2) ? 0 : 4;
                textView.setVisibility(i2);
                VdsAgent.onSetViewVisibility(textView, i2);
            }
            if (O1 != null) {
                int i3 = z ? 0 : 4;
                O1.setVisibility(i3);
                VdsAgent.onSetViewVisibility(O1, i3);
            }
            if (z) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (kotlin.jvm.internal.s.c(str, "EXIT")) {
                    A1(this$0, false, false, 3, null);
                } else if (kotlin.jvm.internal.s.c(str, "CANCEL")) {
                    us.pinguo.foundation.utils.k0.a.c(R.string.poker_cancel);
                } else {
                    us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
                    kotlin.jvm.internal.s.e(str);
                    k0Var.d(str);
                }
            }
            us.pinguo.processor.i.a.j(PreviewProcessState.COMPLETE);
            return;
        }
        kotlin.jvm.internal.s.z("cameraRootLayout");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y1() {
        /*
            r5 = this;
            us.pinguo.camera2020.widget.ParameterAdvanceSettingView r0 = r5.N
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
        L6:
            r0 = 0
            goto L14
        L8:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 != r1) goto L6
            r0 = 1
        L14:
            if (r0 == 0) goto L37
            us.pinguo.camera2020.widget.ParameterAdvanceSettingView r0 = r5.N
            if (r0 != 0) goto L1b
            goto L36
        L1b:
            android.view.ViewPropertyAnimator r0 = r0.animate()
            if (r0 != 0) goto L22
            goto L36
        L22:
            r1 = 0
            android.view.ViewPropertyAnimator r0 = r0.alpha(r1)
            if (r0 != 0) goto L2a
            goto L36
        L2a:
            r1 = 200(0xc8, double:9.9E-322)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r1)
            if (r0 != 0) goto L33
            goto L36
        L33:
            r0.start()
        L36:
            return
        L37:
            us.pinguo.camera2020.view.CameraBottomViewController r0 = r5.n
            java.lang.String r3 = "cameraBottomController"
            r4 = 0
            if (r0 == 0) goto L82
            us.pinguo.camera2020.view.CameraBottomViewController.N(r0, r2, r1, r4)
            us.pinguo.camera2020.view.CameraBottomViewController r0 = r5.n
            if (r0 == 0) goto L7e
            r0.T0()
            us.pinguo.camera2020.view.m2 r0 = r5.f9176l
            if (r0 == 0) goto L78
            r0.f()
            us.pinguo.camera2020.view.StickerViewController r0 = r5.f9173i
            if (r0 != 0) goto L54
            goto L57
        L54:
            r0.n()
        L57:
            us.pinguo.common.filter.controller.FilterController r0 = r5.u
            if (r0 != 0) goto L5c
            goto L5f
        L5c:
            us.pinguo.common.filter.controller.FilterController.p0(r0, r2, r1, r4)
        L5f:
            us.pinguo.camera2020.view.CameraBeautyController r0 = r5.p
            if (r0 != 0) goto L64
            goto L67
        L64:
            r0.C()
        L67:
            us.pinguo.camera2020.view.p2 r0 = r5.f9175k
            if (r0 != 0) goto L6c
            goto L6f
        L6c:
            r0.c()
        L6f:
            us.pinguo.camera2020.view.TopSettingController r0 = r5.f9172h
            if (r0 != 0) goto L74
            goto L77
        L74:
            r0.t()
        L77:
            return
        L78:
            java.lang.String r0 = "cameraTopBar"
            kotlin.jvm.internal.s.z(r0)
            throw r4
        L7e:
            kotlin.jvm.internal.s.z(r3)
            throw r4
        L82:
            kotlin.jvm.internal.s.z(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.Y1():void");
    }

    private final void Y3() {
        if (us.pinguo.repository2020.abtest.k.a.a()) {
            if (us.pinguo.camera2020.i.a.a.f() && !us.pinguo.vip.proxy.b.a.f()) {
                ((VipNoticeAnimView) _$_findCachedViewById(R.id.vipNoticeView)).j();
            } else {
                ((VipNoticeAnimView) _$_findCachedViewById(R.id.vipNoticeView)).f();
            }
        }
    }

    private final void Z1() {
        us.pinguo.repository2020.u<us.pinguo.processor.d> d2 = this.v.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        d2.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderFragment.a2(ViewFinderFragment.this, (us.pinguo.processor.d) obj);
            }
        });
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            us.pinguo.repository2020.u<Boolean> n2 = cameraViewModel.getCameraTopSettingModule().n();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
            n2.observe(viewLifecycleOwner2, new c());
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                us.pinguo.repository2020.u<us.pinguo.facedetector.c> recentFaceResult = cameraViewModel2.getRecentFaceResult();
                LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                kotlin.jvm.internal.s.g(viewLifecycleOwner3, "viewLifecycleOwner");
                recentFaceResult.observe(viewLifecycleOwner3, new d());
                CameraViewModel cameraViewModel3 = this.f9174j;
                if (cameraViewModel3 != null) {
                    us.pinguo.repository2020.u<AutoFilterProducer.b> yuvFrame = cameraViewModel3.getYuvFrame();
                    LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
                    kotlin.jvm.internal.s.g(viewLifecycleOwner4, "viewLifecycleOwner");
                    yuvFrame.observe(viewLifecycleOwner4, new e());
                    return;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z3(FilterEntry filterEntry, boolean z, Continuation<? super kotlin.u> continuation) {
        Object coroutine_suspended;
        if (!z) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.doUnityFilterRender(filterEntry);
                Object y4 = y4(filterEntry, z, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return y4 == coroutine_suspended ? y4 : kotlin.u.a;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        return kotlin.u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(ViewFinderFragment this$0, us.pinguo.processor.d dVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (dVar == null) {
            return;
        }
        if (kotlin.jvm.internal.s.c(dVar.c(), "Effect=Normal")) {
            CameraViewModel cameraViewModel = this$0.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            cameraViewModel.getCameraBeautyModule().v0(0.7f);
        } else {
            CameraViewModel cameraViewModel2 = this$0.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            cameraViewModel2.getCameraBeautyModule().o0();
        }
        CameraViewModel cameraViewModel3 = this$0.f9174j;
        if (cameraViewModel3 != null) {
            cameraViewModel3.setMakeInfo(dVar);
            CameraViewModel cameraViewModel4 = this$0.f9174j;
            if (cameraViewModel4 != null) {
                cameraViewModel4.setCaptureInfo(dVar);
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a4(FilterEntry filterEntry) {
        us.pinguo.processor.d a2 = FilterParamsHelper.c.a();
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setCaptureInfo(a2);
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.setMakeInfo(a2);
                LifecycleCoroutineScope J1 = J1();
                if (J1 != null) {
                    kotlinx.coroutines.l.d(J1, z0.c(), null, new ViewFinderFragment$renderNoneFilter$1(this, null), 2, null);
                }
                if (kotlin.jvm.internal.s.c(filterEntry.getItemId(), Effect.EFFECT_FILTER_NONE_KEY)) {
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    } else if (cameraViewModel3.getCameraFilterModule().E()) {
                        CameraViewModel cameraViewModel4 = this.f9174j;
                        if (cameraViewModel4 != null) {
                            cameraViewModel4.getCameraFilterModule().i0(false);
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                    }
                }
                this.I.a(ExclusiveEffectType.EFFECT_FILTER);
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void b2() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.getCameraBeautyModule().V();
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            us.pinguo.repository2020.u<us.pinguo.processor.d> Q = cameraViewModel2.getCameraBeautyModule().Q();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
            Q.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ViewFinderFragment.c2(ViewFinderFragment.this, (us.pinguo.processor.d) obj);
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b4() {
        us.pinguo.repository2020.o h2 = us.pinguo.repository2020.m.a.h();
        if (h2 == null) {
            return;
        }
        int f2 = h2.f();
        if (f2 == 0) {
            Integer a2 = h2.a();
            l4(a2 == null ? -1 : a2.intValue());
        } else if (f2 != 1) {
            String c2 = h2.c();
            String d2 = h2.d();
            String e2 = h2.e();
            if (!h2.b() && c2 != null && d2 != null && e2 != null) {
                S1(e2, c2, d2);
            } else {
                o3(false);
            }
        } else {
            String c3 = h2.c();
            String d3 = h2.d();
            s4(false);
            us.pinguo.foundation.statistics.h.b.I(c3 == null ? "recent_" : c3, "show");
            StickerViewController stickerViewController = this.f9173i;
            if (stickerViewController == null) {
                return;
            }
            stickerViewController.q(c3, d3, StickerViewController.StickerGotoSource.RESTORE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(ViewFinderFragment this$0, us.pinguo.processor.d dVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (dVar != null) {
            CameraViewModel cameraViewModel = this$0.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.setMakeInfo(dVar);
                CameraViewModel cameraViewModel2 = this$0.f9174j;
                if (cameraViewModel2 != null) {
                    cameraViewModel2.setCaptureInfo(dVar);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c4() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.restoreCameraPreview();
            m2 m2Var = this.f9176l;
            if (m2Var != null) {
                m2Var.r();
                StickerViewController stickerViewController = this.f9173i;
                if (stickerViewController != null && stickerViewController.M()) {
                    StickerViewController stickerViewController2 = this.f9173i;
                    if (stickerViewController2 != null) {
                        stickerViewController2.m();
                    }
                    CameraBottomViewController cameraBottomViewController = this.n;
                    if (cameraBottomViewController != null) {
                        cameraBottomViewController.H();
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("cameraBottomController");
                        throw null;
                    }
                }
                FilterController filterController = this.u;
                if (filterController != null && filterController.L0()) {
                    FilterController filterController2 = this.u;
                    if (filterController2 != null) {
                        FilterController.n0(filterController2, false, 1, null);
                    }
                    CameraBottomViewController cameraBottomViewController2 = this.n;
                    if (cameraBottomViewController2 != null) {
                        cameraBottomViewController2.H();
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("cameraBottomController");
                        throw null;
                    }
                }
                CameraBeautyController cameraBeautyController = this.p;
                if (cameraBeautyController != null && cameraBeautyController.R()) {
                    CameraBeautyController cameraBeautyController2 = this.p;
                    if (cameraBeautyController2 != null) {
                        cameraBeautyController2.A();
                    }
                    CameraBottomViewController cameraBottomViewController3 = this.n;
                    if (cameraBottomViewController3 != null) {
                        cameraBottomViewController3.H();
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("cameraBottomController");
                        throw null;
                    }
                }
                CameraBottomViewController cameraBottomViewController4 = this.n;
                if (cameraBottomViewController4 != null) {
                    CameraBottomViewController.K(cameraBottomViewController4, false, 1, null);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("cameraBottomController");
                    throw null;
                }
            }
            kotlin.jvm.internal.s.z("cameraTopBar");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void d2(int i2) {
        View inflate = ((ViewStub) _$_findCachedViewById(R.id.makeupPanel)).inflate();
        kotlin.jvm.internal.s.e(inflate);
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            CameraBeautyController cameraBeautyController = new CameraBeautyController(inflate, cameraViewModel.getCameraBeautyModule(), this.I);
            this.H.c(cameraBeautyController, 2);
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.getFrameRatioModule().n(cameraBeautyController);
                if (i2 != -1) {
                    cameraBeautyController.H().set(i2);
                }
                CameraViewModel cameraViewModel3 = this.f9174j;
                if (cameraViewModel3 != null) {
                    us.pinguo.repository2020.u<StyleMakeup> C = cameraViewModel3.getCameraBeautyModule().C();
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
                    C.observe(viewLifecycleOwner, new f(cameraBeautyController));
                    CameraViewModel cameraViewModel4 = this.f9174j;
                    if (cameraViewModel4 != null) {
                        us.pinguo.repository2020.u<BeautyData> B = cameraViewModel4.getCameraBeautyModule().B();
                        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                        kotlin.jvm.internal.s.g(viewLifecycleOwner2, "viewLifecycleOwner");
                        B.observe(viewLifecycleOwner2, new g(cameraBeautyController));
                        CameraViewModel cameraViewModel5 = this.f9174j;
                        if (cameraViewModel5 != null) {
                            us.pinguo.repository2020.u<BeautyData> A = cameraViewModel5.getCameraBeautyModule().A();
                            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                            kotlin.jvm.internal.s.g(viewLifecycleOwner3, "viewLifecycleOwner");
                            A.observe(viewLifecycleOwner3, new h(cameraBeautyController));
                            CameraViewModel cameraViewModel6 = this.f9174j;
                            if (cameraViewModel6 != null) {
                                CameraBeautyModule cameraBeautyModule = cameraViewModel6.getCameraBeautyModule();
                                CameraViewModel cameraViewModel7 = this.f9174j;
                                if (cameraViewModel7 != null) {
                                    cameraBeautyModule.w0(cameraViewModel7.getCameraBeautyModule().C().getValue() != null);
                                    this.p = cameraBeautyController;
                                    if (cameraBeautyController != null) {
                                        int i3 = R.id.bottomMenuLayout;
                                        int i4 = _$_findCachedViewById(i3).getLayoutParams().height;
                                        CameraViewModel cameraViewModel8 = this.f9174j;
                                        if (cameraViewModel8 == null) {
                                            kotlin.jvm.internal.s.z("cameraViewModel");
                                            throw null;
                                        }
                                        cameraBeautyController.P((i4 - cameraViewModel8.getFrameRatioModule().h()) - ((ConstraintLayout) _$_findCachedViewById(i3).findViewById(R.id.clFuncArea)).getLayoutParams().height);
                                    }
                                    CameraBeautyController cameraBeautyController2 = this.p;
                                    if (cameraBeautyController2 == null) {
                                        return;
                                    }
                                    cameraBeautyController2.r0(new ViewFinderFragment$initBeautyController$4(this));
                                    return;
                                }
                                kotlin.jvm.internal.s.z("cameraViewModel");
                                throw null;
                            }
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d4() {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.d4():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(Context context, String str, kotlin.jvm.b.a<kotlin.u> aVar) {
        us.pinguo.foundation.o.c.a.a(str, new i(us.pinguo.ui.b.a.a(context), aVar));
    }

    private final void e4() {
        List<StyleMakeup> suites;
        if (this.W) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.startCameraRender();
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 != null) {
                    CameraBeautyModule.U(cameraViewModel2.getCameraBeautyModule(), false, 1, null);
                    FilterController filterController = this.u;
                    if (filterController != null) {
                        FilterController.d1(filterController, false, 1, null);
                    }
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 != null) {
                        CameraBeautyModule cameraBeautyModule = cameraViewModel3.getCameraBeautyModule();
                        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
                        cameraBeautyModule.s(null, (value == null || (suites = value.getSuites()) == null) ? 0 : suites.size());
                        this.W = false;
                        return;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2() {
        Integer value;
        String str;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setShutterSoundEnable(us.pinguo.camera2020.utils.b.a.a());
            CameraTopSettingsModule cameraTopSettingModule = cameraViewModel.getCameraTopSettingModule();
            Boolean value2 = cameraTopSettingModule.i().getValue();
            Boolean bool = Boolean.TRUE;
            if (kotlin.jvm.internal.s.c(value2, bool)) {
                Integer value3 = cameraTopSettingModule.j().getValue();
                if (value3 != null && value3.intValue() == 3) {
                    cameraTopSettingModule.v(0);
                } else if (kotlin.jvm.internal.s.c(cameraTopSettingModule.n().getValue(), bool) && ((value = cameraTopSettingModule.j().getValue()) == null || value.intValue() != 1)) {
                    cameraTopSettingModule.v(0);
                } else {
                    Integer value4 = cameraTopSettingModule.j().getValue();
                    if (value4 == null) {
                        value4 = 0;
                    }
                    cameraTopSettingModule.v(value4);
                }
                Integer value5 = cameraTopSettingModule.j().getValue();
                if (value5 != null && value5.intValue() == 0) {
                    str = "FLASH_OFF";
                } else if (value5 != null && value5.intValue() == 1) {
                    str = "FLASH_ON";
                } else if (value5 != null && value5.intValue() == 2) {
                    str = "FLASH_AUTO";
                } else {
                    str = (value5 != null && value5.intValue() == 3) ? "FLASH_TORCH" : "UN_KNOWN";
                }
                us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("ViewFinderFragment.initCameraParams.switchFlashLight.setFlashState:", str), new Object[0]);
            } else {
                cameraTopSettingModule.v(0);
            }
            cameraTopSettingModule.a(kotlin.jvm.internal.s.c(cameraTopSettingModule.h().getValue(), bool));
            cameraTopSettingModule.t(Boolean.valueOf(kotlin.jvm.internal.s.c(cameraTopSettingModule.g().getValue(), bool)));
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera2020.fragment.h0
                @Override // java.lang.Runnable
                public final void run() {
                    ViewFinderFragment.g2(ViewFinderFragment.this);
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void f4(CameraSwitchMode cameraSwitchMode) {
        VideoMusic videoMusic = this.B;
        if (cameraSwitchMode == null) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            cameraSwitchMode = cameraViewModel.getCameraBottomModule().a().getValue();
        }
        if (videoMusic != null && cameraSwitchMode == CameraSwitchMode.MOVIE) {
            P1().i();
            M1(false);
            return;
        }
        if (P1().b()) {
            P1().j();
        }
        M1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(ViewFinderFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        float f2 = 2;
        float f3 = (this$0.O + 1) / f2;
        PGFocusView pGFocusView = this$0.y;
        if (pGFocusView != null) {
            pGFocusView.setExposureSeekRate(f3);
            int i2 = (int) (this$0.O * f2);
            ParameterAdvanceSettingView parameterAdvanceSettingView = this$0.N;
            if (parameterAdvanceSettingView == null) {
                return;
            }
            parameterAdvanceSettingView.setExposureValue(i2);
            return;
        }
        kotlin.jvm.internal.s.z("focusView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g4(ViewFinderFragment viewFinderFragment, CameraSwitchMode cameraSwitchMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cameraSwitchMode = null;
        }
        viewFinderFragment.f4(cameraSwitchMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            ExclusiveEffectType currentExclusiveType = cameraViewModel.getCurrentExclusiveType();
            int i2 = currentExclusiveType == null ? -1 : b.b[currentExclusiveType.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j2();
            } else if (i2 != 3) {
                if (i2 == 4 && !f0) {
                    j2();
                }
            } else {
                us.pinguo.repository2020.u<MaterialResponse<StyleMakeup>> p = BeautyDataManager.a.p();
                View view = getView();
                LifecycleOwner findViewTreeLifecycleOwner = view != null ? ViewKt.findViewTreeLifecycleOwner(view) : null;
                if (findViewTreeLifecycleOwner == null) {
                    return;
                }
                p.observe(findViewTreeLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.o0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ViewFinderFragment.i2(ViewFinderFragment.this, (MaterialResponse) obj);
                    }
                });
            }
            f0 = true;
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void h4() {
        ObservableInt H;
        StickerCategory o2;
        us.pinguo.repository2020.m mVar = us.pinguo.repository2020.m.a;
        us.pinguo.repository2020.o h2 = mVar.h();
        int i2 = -1;
        if (h2 == null) {
            h2 = new us.pinguo.repository2020.o(-1, null, null, null, -1, false, 32, null);
            mVar.R(h2);
        }
        StickerViewController stickerViewController = this.f9173i;
        boolean z = false;
        if (stickerViewController != null && stickerViewController.M()) {
            h2.l(1);
            StickerViewController stickerViewController2 = this.f9173i;
            h2.i((stickerViewController2 == null || (o2 = stickerViewController2.o()) == null) ? null : o2.getTopic_id());
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                Sticker value = cameraViewModel.getCameraStickerModule().u().getValue();
                h2.j(value == null ? null : value.getPid());
                h2.g(null);
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        CameraBeautyController cameraBeautyController = this.p;
        if (cameraBeautyController != null && cameraBeautyController.R()) {
            h2.l(0);
            h2.i(null);
            h2.j(null);
            CameraBeautyController cameraBeautyController2 = this.p;
            if (cameraBeautyController2 != null && (H = cameraBeautyController2.H()) != null) {
                i2 = Integer.valueOf(H.get());
            }
            h2.g(i2);
            return;
        }
        FilterController filterController = this.u;
        if (filterController != null && filterController.L0()) {
            z = true;
        }
        if (z) {
            h2.l(2);
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                FilterEntry value2 = cameraViewModel2.getCameraFilterModule().y().getValue();
                if (value2 != null) {
                    h2.i(value2.getPkgId());
                    h2.j(value2.getItemId());
                    h2.k(value2.getCategoryId());
                }
                h2.g(null);
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        mVar.R(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(ViewFinderFragment this$0, MaterialResponse materialResponse) {
        List<StyleMakeup> suites;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraViewModel cameraViewModel = this$0.f9174j;
        if (cameraViewModel == null) {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        } else if (cameraViewModel.getCameraBeautyModule().C().getValue() != null) {
            CameraViewModel cameraViewModel2 = this$0.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            CameraBeautyModule cameraBeautyModule = cameraViewModel2.getCameraBeautyModule();
            MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
            int i2 = 0;
            if (value != null && (suites = value.getSuites()) != null) {
                i2 = suites.size();
            }
            cameraBeautyModule.s(null, i2);
        }
    }

    private final void i4() {
        ParameterAdvanceSettingView parameterAdvanceSettingView = this.N;
        if (parameterAdvanceSettingView == null) {
            View inflate = ((ViewStub) _$_findCachedViewById(R.id.advancedSettingsStub)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.camera2020.widget.ParameterAdvanceSettingView");
            parameterAdvanceSettingView = (ParameterAdvanceSettingView) inflate;
            this.N = parameterAdvanceSettingView;
            parameterAdvanceSettingView.setOnParamScaleChangedListener(this);
            this.H.c(parameterAdvanceSettingView, 2);
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                parameterAdvanceSettingView.A(cameraViewModel);
                parameterAdvanceSettingView.x();
                parameterAdvanceSettingView.setExposureValue((int) (this.O * 2));
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        Context context = parameterAdvanceSettingView.getContext();
        kotlin.jvm.internal.s.g(context, "advanceLayout.context");
        parameterAdvanceSettingView.G(us.pinguo.util.g.a(context, 100.0f), 1000.0f);
    }

    private final void j2() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FilterEntry value = cameraViewModel.getCameraFilterModule().y().getValue();
            if (value != null) {
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (cameraViewModel2.getCameraFilterModule().Q(value.getPkgId())) {
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    cameraViewModel3.getCameraFilterModule().y().setValue(value);
                } else {
                    FilterController filterController = this.u;
                    if (filterController != null) {
                        FilterController.B0(filterController, FilterConstants.f(), false, 2, null);
                    }
                }
            }
            CameraViewModel cameraViewModel4 = this.f9174j;
            if (cameraViewModel4 != null) {
                cameraViewModel4.getCameraBeautyModule().T(true);
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r2v20, types: [T, androidx.constraintlayout.widget.ConstraintLayout, java.lang.Object] */
    public final void j4() {
        Integer h2;
        if (kotlin.jvm.internal.s.c(us.pinguo.foundation.j.e().k("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON)) {
            int i2 = R.id.viewForWatermarkClick;
            View viewForWatermarkClick = _$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(viewForWatermarkClick, "viewForWatermarkClick");
            viewForWatermarkClick.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewForWatermarkClick, 0);
            String k2 = us.pinguo.foundation.j.e().k("key_watermark_type", "0");
            kotlin.jvm.internal.s.g(k2, "get().getString(CameraBu….KEY_WATERMARK_TYPE, \"0\")");
            h2 = kotlin.text.s.h(k2);
            int intValue = h2 == null ? 1 : h2.intValue();
            if (intValue != 0 && intValue != 1 && intValue != 3 && intValue != 5 && intValue != 6) {
                View viewForWatermarkClick2 = _$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(viewForWatermarkClick2, "viewForWatermarkClick");
                ViewGroup.LayoutParams layoutParams = viewForWatermarkClick2.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                Context b2 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b2, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = us.pinguo.util.g.a(b2, 52.0f);
                Context b3 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b3, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = us.pinguo.util.g.a(b3, 128.0f);
                int i3 = R.id.viewFinderContainer;
                layoutParams2.startToStart = i3;
                layoutParams2.bottomToBottom = i3;
                viewForWatermarkClick2.setLayoutParams(layoutParams2);
            } else {
                View viewForWatermarkClick3 = _$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(viewForWatermarkClick3, "viewForWatermarkClick");
                ViewGroup.LayoutParams layoutParams3 = viewForWatermarkClick3.getLayoutParams();
                Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                Context b4 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b4, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams4).width = us.pinguo.util.g.a(b4, 128.0f);
                Context b5 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b5, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams4).height = us.pinguo.util.g.a(b5, 52.0f);
                int i4 = R.id.viewFinderContainer;
                layoutParams4.startToStart = i4;
                layoutParams4.bottomToBottom = i4;
                viewForWatermarkClick3.setLayoutParams(layoutParams4);
            }
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            if (us.pinguo.repository2020.utils.o.b(oVar, "key_water_mark_tip", false, null, 6, null)) {
                return;
            }
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                Boolean value = cameraViewModel.getCameraTopSettingModule().d().getValue();
                Boolean bool = Boolean.TRUE;
                if (kotlin.jvm.internal.s.c(value, bool)) {
                    CameraViewModel cameraViewModel2 = this.f9174j;
                    if (cameraViewModel2 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    } else if (kotlin.jvm.internal.s.c(cameraViewModel2.getCameraTopSettingModule().e().getValue(), bool)) {
                        return;
                    }
                }
                us.pinguo.repository2020.utils.o.n(oVar, "key_water_mark_tip", true, null, 4, null);
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ?? r2 = this.V;
                ref$ObjectRef.element = r2;
                if (r2 == 0) {
                    View inflate = ((ViewStub) _$_findCachedViewById(R.id.stubWaterMarkTip)).inflate();
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    ?? r22 = (ConstraintLayout) inflate;
                    ref$ObjectRef.element = r22;
                    Objects.requireNonNull(r22, "null cannot be cast to non-null type android.view.View");
                    View view = (View) r22;
                    ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
                    Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                    layoutParams6.topToTop = i2;
                    layoutParams6.bottomToBottom = i2;
                    layoutParams6.startToEnd = i2;
                    Context b6 = us.pinguo.foundation.e.b();
                    kotlin.jvm.internal.s.g(b6, "getAppContext()");
                    layoutParams6.setMarginStart(us.pinguo.util.g.a(b6, 3.0f));
                    view.setLayoutParams(layoutParams6);
                    this.V = (ConstraintLayout) ref$ObjectRef.element;
                }
                View view2 = (View) ref$ObjectRef.element;
                view2.setVisibility(0);
                VdsAgent.onSetViewVisibility(view2, 0);
                ((ConstraintLayout) ref$ObjectRef.element).postDelayed(new Runnable() { // from class: us.pinguo.camera2020.fragment.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewFinderFragment.k4(Ref$ObjectRef.this);
                    }
                }, 3000L);
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        View viewForWatermarkClick4 = _$_findCachedViewById(R.id.viewForWatermarkClick);
        kotlin.jvm.internal.s.g(viewForWatermarkClick4, "viewForWatermarkClick");
        viewForWatermarkClick4.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewForWatermarkClick4, 4);
    }

    private final void k2() {
        p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k4(Ref$ObjectRef tipLayout) {
        kotlin.jvm.internal.s.h(tipLayout, "$tipLayout");
        View view = (View) tipLayout.element;
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
    }

    private final void l2() {
        this.I.d(new j());
        ViewFinderGestureDetector viewFinderGestureDetector = this.s;
        if (viewFinderGestureDetector != null) {
            viewFinderGestureDetector.e(new k());
        } else {
            kotlin.jvm.internal.s.z("viewFinderGestureDetector");
            throw null;
        }
    }

    private final void l3() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel == null) {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        us.pinguo.repository2020.u<FilterEntry> y = cameraViewModel.getCameraFilterModule().y();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        y.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderFragment.m3(ViewFinderFragment.this, (FilterEntry) obj);
            }
        });
    }

    private final void l4(int i2) {
        if (this.p == null) {
            d2(i2);
        }
        CameraBeautyController cameraBeautyController = this.p;
        if (cameraBeautyController == null) {
            return;
        }
        CameraBottomViewController cameraBottomViewController = this.n;
        us.pinguo.camera2020.module.frame.a aVar = null;
        if (cameraBottomViewController != null) {
            CameraBottomViewController.N(cameraBottomViewController, false, 1, null);
            CameraBottomViewController cameraBottomViewController2 = this.n;
            if (cameraBottomViewController2 != null) {
                cameraBottomViewController2.H();
                TopSettingController topSettingController = this.f9172h;
                if (topSettingController != null) {
                    topSettingController.t();
                }
                p2 p2Var = this.f9175k;
                if (p2Var != null) {
                    p2Var.b();
                }
                StickerViewController stickerViewController = this.f9173i;
                if (stickerViewController != null) {
                    stickerViewController.v();
                }
                FilterController filterController = this.u;
                if (filterController != null) {
                    FilterController.I0(filterController, false, 1, null);
                }
                cameraBeautyController.s0();
                CameraViewModel cameraViewModel = this.f9174j;
                if (cameraViewModel != null) {
                    FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
                    Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = frameRatioModule.f();
                    if (f2 != null) {
                        CameraViewModel cameraViewModel2 = this.f9174j;
                        if (cameraViewModel2 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        aVar = f2.get(cameraViewModel2.getFrameRatioModule().d().getValue());
                    }
                    if (aVar == null) {
                        return;
                    }
                    frameRatioModule.k(aVar);
                    return;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    private final void m2() {
        int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            ((PictureFramePanel) _$_findCachedViewById(R.id.framePanel)).setHaircutHeight(i2);
            if (i2 > 0) {
                View topBarLayout = _$_findCachedViewById(R.id.topBarLayout);
                kotlin.jvm.internal.s.g(topBarLayout, "topBarLayout");
                ViewGroup.LayoutParams layoutParams = topBarLayout.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i2;
                topBarLayout.setLayoutParams(layoutParams2);
            }
            LensFacing lensFacing = LensFacing.BACK;
            if (cameraViewModel.hasCamera(lensFacing)) {
                cameraViewModel.getTargetCameraResolutionInfo(lensFacing).observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.camera2020.fragment.m
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ViewFinderFragment.n2(ViewFinderFragment.this, (us.pinguo.cameramanger.info.b) obj);
                    }
                });
            }
            LensFacing lensFacing2 = LensFacing.FRONT;
            if (cameraViewModel.hasCamera(lensFacing2)) {
                cameraViewModel.getTargetCameraResolutionInfo(lensFacing2).observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.camera2020.fragment.u
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ViewFinderFragment.o2(ViewFinderFragment.this, (us.pinguo.cameramanger.info.b) obj);
                    }
                });
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
        if ((r8 <= r7.getTagOffTime() && r7.getTagOnTime() <= r8) == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3(us.pinguo.camera2020.fragment.ViewFinderFragment r18, us.pinguo.repository2020.entity.FilterEntry r19) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.m3(us.pinguo.camera2020.fragment.ViewFinderFragment, us.pinguo.repository2020.entity.FilterEntry):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m4(ViewFinderFragment viewFinderFragment, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1;
        }
        viewFinderFragment.l4(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(ViewFinderFragment this$0, us.pinguo.cameramanger.info.b it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        this$0.q3(it);
        this$0.x4(it.a(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n3() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        TopSettingController topSettingController = this.f9172h;
        if (topSettingController != null) {
            topSettingController.t();
        }
        p2 p2Var = this.f9175k;
        if (p2Var != null) {
            p2Var.b();
        }
        try {
            com.pinguo.camera360.j.a.b(activity);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n4(boolean z) {
        String itemId;
        String str;
        FilterNameAnimView.Direction direction;
        boolean z2;
        us.pinguo.repository2020.o h2 = us.pinguo.repository2020.m.a.h();
        boolean z3 = false;
        if (h2 != null && h2.b()) {
            z3 = true;
        }
        if (z3) {
            return;
        }
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            ChangeStatus n2 = cameraViewModel.getCameraFilterModule().n();
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            FilterEntry value = cameraViewModel2.getCameraFilterModule().y().getValue();
            if (value == null || (itemId = value.getItemId()) == null) {
                return;
            }
            if (kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_NONE_KEY)) {
                str = getResources().getString(R.string.filter_name_none);
            } else if (kotlin.jvm.internal.s.c(itemId, Effect.EFFECT_FILTER_AUTO_KEY)) {
                str = getResources().getString(R.string.filter_name_auto);
            } else {
                CameraViewModel cameraViewModel3 = this.f9174j;
                if (cameraViewModel3 != null) {
                    FilterItem z4 = cameraViewModel3.getCameraFilterModule().z(value.getPkgId(), itemId);
                    String name = z4 != null ? z4.getName() : null;
                    if (name == null) {
                        return;
                    }
                    str = name;
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            kotlin.jvm.internal.s.g(str, "when (val filterId = cur…      ?: return\n        }");
            int i2 = R.id.effectTipView;
            ((FilterNameAnimView) _$_findCachedViewById(i2)).setNameText(str);
            String string = getResources().getString(R.string.filter);
            kotlin.jvm.internal.s.g(string, "resources.getString(R.string.filter)");
            ((FilterNameAnimView) _$_findCachedViewById(i2)).setTypeText(string);
            if (n2 != ChangeStatus.CLICK_RIGHT && n2 != ChangeStatus.SLIDE_RIGHT) {
                direction = FilterNameAnimView.Direction.LEFT_TO_RIGHT;
            } else {
                direction = FilterNameAnimView.Direction.RIGHT_TO_LEFT;
            }
            z2 = kotlin.collections.c0.z(FilterConstants.a.i(), value.getPkgId());
            if (z2) {
                ((FilterNameAnimView) _$_findCachedViewById(i2)).setSubContentText(us.pinguo.edit2020.utils.d.k(R.string.str_open_flash_light));
                ((FilterNameAnimView) _$_findCachedViewById(i2)).setSubContentEnable(true);
            } else {
                ((FilterNameAnimView) _$_findCachedViewById(i2)).setSubContentText(us.pinguo.edit2020.utils.d.k(R.string.none_preview_filter_tip));
                ((FilterNameAnimView) _$_findCachedViewById(i2)).setSubContentEnable(z);
            }
            ((FilterNameAnimView) _$_findCachedViewById(i2)).b(direction);
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(ViewFinderFragment this$0, us.pinguo.cameramanger.info.b it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        this$0.q3(it);
        this$0.x4(it.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3(boolean z) {
        us.pinguo.camera2020.module.frame.a aVar;
        FilterController filterController;
        CameraBottomViewController cameraBottomViewController = this.n;
        if (cameraBottomViewController != null) {
            CameraBottomViewController.N(cameraBottomViewController, false, 1, null);
            CameraBottomViewController cameraBottomViewController2 = this.n;
            if (cameraBottomViewController2 != null) {
                cameraBottomViewController2.H();
                TopSettingController topSettingController = this.f9172h;
                if (topSettingController != null) {
                    topSettingController.t();
                }
                p2 p2Var = this.f9175k;
                if (p2Var != null) {
                    p2Var.b();
                }
                StickerViewController stickerViewController = this.f9173i;
                if (stickerViewController != null) {
                    stickerViewController.v();
                }
                CameraBeautyController cameraBeautyController = this.p;
                if (cameraBeautyController != null) {
                    cameraBeautyController.M();
                }
                CameraViewModel cameraViewModel = this.f9174j;
                if (cameraViewModel != null) {
                    if (cameraViewModel.getCameraFilterModule().y().getValue() != null) {
                        CameraViewModel cameraViewModel2 = this.f9174j;
                        if (cameraViewModel2 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        FilterEntry value = cameraViewModel2.getCameraFilterModule().y().getValue();
                        if (value != null && (filterController = this.u) != null) {
                            filterController.Z0(value.getCategoryId(), value.getPkgId(), value.getItemId(), z);
                        }
                    } else {
                        FilterController filterController2 = this.u;
                        if (filterController2 != null) {
                            FilterController.r1(filterController2, false, false, 3, null);
                        }
                    }
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = cameraViewModel3.getFrameRatioModule().f();
                    if (f2 == null) {
                        aVar = null;
                    } else {
                        CameraViewModel cameraViewModel4 = this.f9174j;
                        if (cameraViewModel4 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        aVar = f2.get(cameraViewModel4.getFrameRatioModule().d().getValue());
                    }
                    CameraViewModel cameraViewModel5 = this.f9174j;
                    if (cameraViewModel5 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    FrameRatioModule frameRatioModule = cameraViewModel5.getFrameRatioModule();
                    if (aVar == null) {
                        return;
                    }
                    frameRatioModule.k(aVar);
                    return;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o4() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.utils.w.i(activity, R.string.str_unlock_all_vip, R.string.str_use_now, -999, i0.a);
    }

    private final void p2() {
        FilterPanelView filterView = (FilterPanelView) _$_findCachedViewById(R.id.filterView);
        kotlin.jvm.internal.s.g(filterView, "filterView");
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FilterController filterController = new FilterController(filterView, cameraViewModel.getCameraFilterModule(), false, 4, null);
            filterController.i1(new ViewFinderFragment$initNewFilter$controller$1$1(this));
            FilterController.d1(filterController, false, 1, null);
            this.u = filterController;
            this.H.c(filterController, 2);
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.getFrameRatioModule().n(filterController);
                filterController.o1(new ViewFinderFragment$initNewFilter$1(this));
                AfterCaptureBottomController afterCaptureBottomController = this.q;
                if (afterCaptureBottomController != null) {
                    afterCaptureBottomController.y().observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.camera2020.fragment.t
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            ViewFinderFragment.q2(ViewFinderFragment.this, (Boolean) obj);
                        }
                    });
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 != null) {
                        us.pinguo.repository2020.u<Integer> s = cameraViewModel3.getCameraFilterModule().s();
                        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
                        s.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.d
                            @Override // androidx.lifecycle.Observer
                            public final void onChanged(Object obj) {
                                ViewFinderFragment.r2(ViewFinderFragment.this, (Integer) obj);
                            }
                        });
                        CameraViewModel cameraViewModel4 = this.f9174j;
                        if (cameraViewModel4 != null) {
                            cameraViewModel4.setSkyChangeRenderCompleteCallback(new ViewFinderFragment$initNewFilter$4(this));
                            CameraViewModel cameraViewModel5 = this.f9174j;
                            if (cameraViewModel5 != null) {
                                cameraViewModel5.setPreviewAction(new ViewFinderFragment$initNewFilter$5(this));
                                l3();
                                Z1();
                                N1();
                                return;
                            }
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                kotlin.jvm.internal.s.z("afterCaptureController");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3() {
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.s.g(requireActivity, "requireActivity()");
        e2(requireActivity, "Inspire", new ViewFinderFragment$onBottomMusicClick$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p4(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(ViewFinderFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        CameraViewModel cameraViewModel = this$0.f9174j;
        if (cameraViewModel != null) {
            ObservableBoolean M = cameraViewModel.getCameraFilterModule().M();
            kotlin.jvm.internal.s.g(it, "it");
            M.set(it.booleanValue());
            this$0.z4();
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void q3(us.pinguo.cameramanger.info.b bVar) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final int i2 = us.pinguo.foundation.j.e().i("hairCut", 0);
        final CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            final FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
            EnumMap<CameraFrame, Size> c2 = bVar.c();
            us.pinguo.repository2020.m mVar = us.pinguo.repository2020.m.a;
            frameRatioModule.i(i2, c2, kotlin.jvm.internal.s.c(mVar.y().getValue(), Boolean.TRUE) ? LensFacing.FRONT : LensFacing.BACK);
            p2 p2Var = this.f9175k;
            if (p2Var != null) {
                p2Var.d();
            }
            int i3 = R.id.framePanel;
            ((PictureFramePanel) _$_findCachedViewById(i3)).setBottomBlackHeight(frameRatioModule.c() + frameRatioModule.h());
            int i4 = R.id.bottomMenuLayout;
            View bottomMenuLayout = _$_findCachedViewById(i4);
            kotlin.jvm.internal.s.g(bottomMenuLayout, "bottomMenuLayout");
            ViewGroup.LayoutParams layoutParams = bottomMenuLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int b2 = frameRatioModule.b() + frameRatioModule.c();
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = b2;
            mVar.Q(b2);
            int i5 = R.id.previewAdvGoto;
            ((ColorAnimDraweeView) _$_findCachedViewById(i5)).setTranslationY(Math.min(-((ViewGroup.MarginLayoutParams) layoutParams2).height, ((ColorAnimDraweeView) _$_findCachedViewById(i5)).getTranslationY()));
            bottomMenuLayout.setLayoutParams(layoutParams2);
            FilterController filterController = this.u;
            if (filterController != null) {
                filterController.x1(_$_findCachedViewById(i4).getLayoutParams().height);
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(i4).findViewById(R.id.clFuncArea);
            kotlin.jvm.internal.s.g(constraintLayout, "bottomMenuLayout.clFuncArea");
            ViewGroup.LayoutParams layoutParams3 = constraintLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            ((ViewGroup.MarginLayoutParams) layoutParams4).height = frameRatioModule.b() - frameRatioModule.h();
            constraintLayout.setLayoutParams(layoutParams4);
            View findViewById = _$_findCachedViewById(i4).findViewById(R.id.cameraModeSwitchLayout);
            kotlin.jvm.internal.s.g(findViewById, "bottomMenuLayout.cameraModeSwitchLayout");
            ViewGroup.LayoutParams layoutParams5 = findViewById.getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            ((ViewGroup.MarginLayoutParams) layoutParams6).height = frameRatioModule.h();
            findViewById.setLayoutParams(layoutParams6);
            CameraBottomViewController cameraBottomViewController = this.n;
            if (cameraBottomViewController != null) {
                cameraBottomViewController.t0(frameRatioModule.c());
                AfterCaptureBottomController afterCaptureBottomController = this.q;
                if (afterCaptureBottomController != null) {
                    afterCaptureBottomController.Y(frameRatioModule.c());
                    if (!this.K) {
                        CameraFrame value = frameRatioModule.d().getValue();
                        if (value == null) {
                            return;
                        }
                        frameRatioModule.a(value, true);
                        return;
                    }
                    ((PictureFramePanel) _$_findCachedViewById(i3)).setOnRatioAnimatorListener(new l(frameRatioModule));
                    us.pinguo.repository2020.u<CameraFrame> d2 = frameRatioModule.d();
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
                    d2.observe(viewLifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.fragment.u0
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            ViewFinderFragment.r3(ViewFinderFragment.this, cameraViewModel, frameRatioModule, i2, activity, (CameraFrame) obj);
                        }
                    });
                    return;
                }
                kotlin.jvm.internal.s.z("afterCaptureController");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void q4() {
        if (this.S == null) {
            this.S = new AdvDialogManager();
        }
        AdvDialogManager advDialogManager = this.S;
        if (advDialogManager == null) {
            return;
        }
        advDialogManager.g("059cb142134fa6993e486b574028e6e4", "viewPage", getActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(ViewFinderFragment this$0, Integer num) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        float intValue = num.intValue() / 100.0f;
        CameraViewModel cameraViewModel = this$0.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setFilterOpacity(intValue);
            CameraViewModel cameraViewModel2 = this$0.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.getCameraFilterModule().d0();
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r3(ViewFinderFragment this$0, CameraViewModel viewModel, FrameRatioModule module, int i2, FragmentActivity act, CameraFrame frame) {
        Iterator<Map.Entry<CameraFrame, us.pinguo.camera2020.module.frame.a>> it;
        String str;
        int a2;
        Integer b2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.h(module, "$module");
        kotlin.jvm.internal.s.h(act, "$act");
        int i3 = R.id.viewFinderMask;
        View viewFinderMask = this$0._$_findCachedViewById(i3);
        kotlin.jvm.internal.s.g(viewFinderMask, "viewFinderMask");
        viewFinderMask.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewFinderMask, 0);
        kotlin.jvm.internal.s.g(frame, "frame");
        viewModel.changeFrame(frame);
        module.q(frame);
        m2 m2Var = this$0.f9176l;
        if (m2Var != null) {
            m2Var.c(frame);
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = module.f();
            us.pinguo.camera2020.module.frame.a aVar = f2 == null ? null : f2.get(frame);
            if (aVar != null && aVar.c()) {
                Integer d2 = aVar.d();
                int intValue = d2 == null ? 0 : d2.intValue();
                Integer b3 = aVar.b();
                int intValue2 = b3 == null ? 0 : b3.intValue();
                Integer d3 = aVar.d();
                int intValue3 = d3 == null ? 0 : d3.intValue();
                if (intValue3 == 0 || intValue3 == i2) {
                    intValue3 = act.getResources().getDimensionPixelSize(R.dimen.view_finder_top_bar_height) + i2;
                }
                int a3 = intValue3 + us.pinguo.util.g.a(act, 10.0f);
                a2 = kotlin.z.j.a(this$0._$_findCachedViewById(R.id.bottomMenuLayout).getHeight(), us.pinguo.repository2020.m.a.d());
                float f3 = -Math.max(aVar.b() == null ? 0 : b2.intValue(), a2);
                if (this$0.K) {
                    this$0.K = false;
                    ((PictureFramePanel) this$0._$_findCachedViewById(R.id.framePanel)).setUpperAndLowerHeight(intValue, intValue2, false);
                    float f4 = a3;
                    ((TextView) this$0._$_findCachedViewById(R.id.touchScreenCapture)).setTranslationY(f4);
                    ((TextView) this$0._$_findCachedViewById(R.id.pg_focus_lock_tips)).setTranslationY(f4);
                    ((ColorAnimDraweeView) this$0._$_findCachedViewById(R.id.previewAdvGoto)).setTranslationY(f3);
                    this$0.C1();
                    module.k(aVar);
                    CameraBottomViewController cameraBottomViewController = this$0.n;
                    if (cameraBottomViewController != null) {
                        Integer b4 = aVar.b();
                        cameraBottomViewController.F(b4 != null ? b4.intValue() : 0);
                        View viewFinderMask2 = this$0._$_findCachedViewById(i3);
                        kotlin.jvm.internal.s.g(viewFinderMask2, "viewFinderMask");
                        viewFinderMask2.setVisibility(4);
                        VdsAgent.onSetViewVisibility(viewFinderMask2, 4);
                        return;
                    }
                    kotlin.jvm.internal.s.z("cameraBottomController");
                    throw null;
                }
                ((PictureFramePanel) this$0._$_findCachedViewById(R.id.framePanel)).setUpperAndLowerHeight(intValue, intValue2, true);
                int i4 = R.id.touchScreenCapture;
                TextView touchScreenCapture = (TextView) this$0._$_findCachedViewById(i4);
                kotlin.jvm.internal.s.g(touchScreenCapture, "touchScreenCapture");
                if (touchScreenCapture.getVisibility() == 0) {
                    float f5 = a3;
                    ((TextView) this$0._$_findCachedViewById(i4)).animate().translationY(f5).setDuration(200L).start();
                    ((TextView) this$0._$_findCachedViewById(R.id.pg_focus_lock_tips)).animate().translationY(f5).setDuration(200L).start();
                } else {
                    float f6 = a3;
                    ((TextView) this$0._$_findCachedViewById(i4)).setTranslationY(f6);
                    ((TextView) this$0._$_findCachedViewById(R.id.pg_focus_lock_tips)).setTranslationY(f6);
                }
                int i5 = R.id.previewAdvGoto;
                ColorAnimDraweeView previewAdvGoto = (ColorAnimDraweeView) this$0._$_findCachedViewById(i5);
                kotlin.jvm.internal.s.g(previewAdvGoto, "previewAdvGoto");
                if ((previewAdvGoto.getVisibility() == 0 ? 1 : 0) != 0) {
                    if (Math.abs(((ColorAnimDraweeView) this$0._$_findCachedViewById(i5)).getTranslationY() - f3) >= 0.5f) {
                        ((ColorAnimDraweeView) this$0._$_findCachedViewById(i5)).animate().translationY(f3).setDuration(200L).start();
                        return;
                    }
                    return;
                }
                ((ColorAnimDraweeView) this$0._$_findCachedViewById(i5)).setTranslationY(f3);
                return;
            }
            Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f7 = module.f();
            String str2 = "";
            if (f7 == null) {
                str = "";
            } else {
                str = "";
                while (f7.entrySet().iterator().hasNext()) {
                    str = str + it.next().getKey() + ',';
                }
            }
            Map<CameraFrame, Size> e2 = module.e();
            if (e2 != null) {
                for (Map.Entry<CameraFrame, Size> entry : e2.entrySet()) {
                    str2 = str2 + entry.getKey() + ':' + entry.getValue() + ',';
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ratioInfoMap:");
            sb.append(str);
            sb.append(",previewSizeMap:");
            sb.append(str2);
            sb.append(",frame:");
            sb.append(frame);
            sb.append(",fixedBottomMargin:");
            sb.append(module.c());
            sb.append(",hairCut:");
            sb.append(i2);
            sb.append(",previewSize:");
            Map<CameraFrame, Size> e3 = module.e();
            sb.append(e3 != null ? e3.get(frame) : null);
            sb.append(",screenSize:");
            sb.append(new Size(us.pinguo.util.h.i(act), us.pinguo.util.h.g(act)));
            sb.append(",pxPerDp:");
            sb.append(act.getResources().getDimension(R.dimen.dp1));
            sb.append(",density:");
            sb.append(us.pinguo.util.h.e(act));
            sb.append(",scaledDensity:");
            sb.append(us.pinguo.util.h.h(act));
            sb.append(",dpi:");
            sb.append(us.pinguo.util.h.f(act));
            CrashReport.postCatchedException(new IllegalStateException(sb.toString()));
            return;
        }
        kotlin.jvm.internal.s.z("cameraTopBar");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r4() {
        LifecycleCoroutineScope J1;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel == null) {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        FilterEntry value = cameraViewModel.getCameraFilterModule().y().getValue();
        if (value == null || (J1 = J1()) == null) {
            return;
        }
        kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$showSkyChangeGuide$1(this, value, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(FilterEntry filterEntry) {
        String itemId;
        String pkgId = filterEntry == null ? null : filterEntry.getPkgId();
        if (pkgId == null || (itemId = filterEntry.getItemId()) == null) {
            return;
        }
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            CameraFilterModule cameraFilterModule = cameraViewModel.getCameraFilterModule();
            if (cameraFilterModule.X()) {
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                cameraViewModel2.getCameraFilterModule().h();
            }
            cameraFilterModule.j0(true);
            CameraViewModel cameraViewModel3 = this.f9174j;
            if (cameraViewModel3 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            CameraFilterModule cameraFilterModule2 = cameraViewModel3.getCameraFilterModule();
            CameraViewModel cameraViewModel4 = this.f9174j;
            if (cameraViewModel4 != null) {
                cameraFilterModule2.H(cameraViewModel4.getAfterCaptureModule().l(), new ViewFinderFragment$initSkyChange$1(this, pkgId, itemId, filterEntry));
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s3(ViewFinderFragment this$0, Integer it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        this$0.F1(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s4(boolean z) {
        us.pinguo.camera2020.module.frame.a aVar;
        if (this.f9173i == null) {
            t2();
        }
        StickerViewController stickerViewController = this.f9173i;
        if (stickerViewController == null) {
            return;
        }
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            FrameRatioModule frameRatioModule = cameraViewModel.getFrameRatioModule();
            TopSettingController topSettingController = this.f9172h;
            if (topSettingController != null) {
                topSettingController.t();
            }
            p2 p2Var = this.f9175k;
            if (p2Var != null) {
                p2Var.b();
            }
            FilterController filterController = this.u;
            if (filterController != null) {
                FilterController.I0(filterController, false, 1, null);
            }
            CameraBeautyController cameraBeautyController = this.p;
            if (cameraBeautyController != null) {
                cameraBeautyController.M();
            }
            stickerViewController.e0();
            CameraBottomViewController cameraBottomViewController = this.n;
            if (cameraBottomViewController != null) {
                CameraBottomViewController.N(cameraBottomViewController, false, 1, null);
                CameraBottomViewController cameraBottomViewController2 = this.n;
                if (cameraBottomViewController2 != null) {
                    cameraBottomViewController2.H();
                    Map<CameraFrame, us.pinguo.camera2020.module.frame.a> f2 = frameRatioModule.f();
                    if (f2 == null) {
                        aVar = null;
                    } else {
                        CameraViewModel cameraViewModel2 = this.f9174j;
                        if (cameraViewModel2 == null) {
                            kotlin.jvm.internal.s.z("cameraViewModel");
                            throw null;
                        }
                        aVar = f2.get(cameraViewModel2.getFrameRatioModule().d().getValue());
                    }
                    if (aVar == null) {
                        return;
                    }
                    frameRatioModule.k(aVar);
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 == null) {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    } else if (!cameraViewModel3.getCameraStickerModule().A() || z) {
                        return;
                    } else {
                        stickerViewController.q("recent_", "5e6a360fa35dde3d3e028c2d", StickerViewController.StickerGotoSource.FRESH_STICKER_USER);
                        return;
                    }
                }
                kotlin.jvm.internal.s.z("cameraBottomController");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void t2() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            final CameraStickerModule cameraStickerModule = cameraViewModel.getCameraStickerModule();
            View inflate = ((ViewStub) _$_findCachedViewById(R.id.stubStickerLayout)).inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.camera2020.view.StickerLayout");
            StickerLayout stickerLayout = (StickerLayout) inflate;
            int i2 = _$_findCachedViewById(R.id.bottomMenuLayout).getLayoutParams().height;
            int i3 = R.id.pagerStickerCategory;
            if (i2 > ((ViewPager) stickerLayout._$_findCachedViewById(i3)).getLayoutParams().height) {
                ViewPager viewPager = (ViewPager) stickerLayout._$_findCachedViewById(i3);
                kotlin.jvm.internal.s.g(viewPager, "stickerLayout.pagerStickerCategory");
                ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
                viewPager.setLayoutParams(layoutParams2);
            }
            StickerViewController stickerViewController = new StickerViewController(cameraStickerModule, stickerLayout, this);
            stickerViewController.c0(new ViewFinderFragment$initStickerController$2(this));
            this.H.c(stickerViewController, 2);
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.getFrameRatioModule().n(stickerViewController);
                us.pinguo.common.filter.util.b bVar = us.pinguo.common.filter.util.b.a;
                int i4 = R.id.imgCancel;
                bVar.a((ImageView) stickerLayout._$_findCachedViewById(i4), R.color.color_camera_theme_dark);
                ((ImageView) stickerLayout._$_findCachedViewById(i4)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.fragment.m0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewFinderFragment.u2(CameraStickerModule.this, this, view);
                    }
                });
                stickerViewController.d0(new ViewFinderFragment$initStickerController$4(this));
                this.f9173i = stickerViewController;
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t3(ViewFinderFragment this$0, Message msg) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(msg, "msg");
        if (msg.what == 996) {
            this$0.D1();
            return true;
        }
        return false;
    }

    private final void t4(StyleMakeup styleMakeup, boolean z) {
        FilterNameAnimView.Direction direction;
        String name = styleMakeup == null ? null : styleMakeup.getName();
        if (name == null || name.length() == 0) {
            return;
        }
        int i2 = R.id.effectTipView;
        ((FilterNameAnimView) _$_findCachedViewById(i2)).setNameText(name);
        String string = getResources().getString(R.string.beauty_style_makeup);
        kotlin.jvm.internal.s.g(string, "resources.getString(R.string.beauty_style_makeup)");
        ((FilterNameAnimView) _$_findCachedViewById(i2)).setTypeText(string);
        if (z) {
            direction = FilterNameAnimView.Direction.LEFT_TO_RIGHT;
        } else {
            direction = FilterNameAnimView.Direction.RIGHT_TO_LEFT;
        }
        ((FilterNameAnimView) _$_findCachedViewById(i2)).setSubContentEnable(false);
        ((FilterNameAnimView) _$_findCachedViewById(i2)).b(direction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(CameraStickerModule stickerModule, ViewFinderFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(stickerModule, "$stickerModule");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (stickerModule.i()) {
            this$0.I.c(ExclusiveEffectType.EFFECT_STICKER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3(CameraViewModel viewModel, Boolean it) {
        kotlin.jvm.internal.s.h(viewModel, "$viewModel");
        kotlin.jvm.internal.s.g(it, "it");
        viewModel.setIsFrontMirror(it.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u4() {
        Object obj;
        FragmentActivity activity = getActivity();
        if (activity == null || (obj = this.Y) == null) {
            return;
        }
        Class.forName("com.pinguo.camera360.camera.controller.VipHalfScreenController").getDeclaredMethod("showHalfScreenPopup", Context.class, ViewStub.class).invoke(obj, activity, (ViewStub) _$_findCachedViewById(R.id.stubVipHalfScreenPopup));
    }

    private final void v2() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            final CameraStickerModule cameraStickerModule = cameraViewModel.getCameraStickerModule();
            cameraStickerModule.u().observe(getViewLifecycleOwner(), new Observer() { // from class: us.pinguo.camera2020.fragment.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ViewFinderFragment.w2(ViewFinderFragment.this, cameraStickerModule, (Sticker) obj);
                }
            });
            this.I.d(new us.pinguo.camera2020.module.a() { // from class: us.pinguo.camera2020.fragment.ViewFinderFragment$initStickerObservation$2
                @Override // us.pinguo.camera2020.module.a
                public void a(ExclusiveEffectType effectType) {
                    kotlin.jvm.internal.s.h(effectType, "effectType");
                }

                @Override // us.pinguo.camera2020.module.a
                public boolean b(ExclusiveEffectType effectType) {
                    kotlin.jvm.internal.s.h(effectType, "effectType");
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    ref$BooleanRef.element = true;
                    kotlinx.coroutines.k.b(null, new ViewFinderFragment$initStickerObservation$2$canApply$1(CameraStickerModule.this, effectType, ref$BooleanRef, null), 1, null);
                    return ref$BooleanRef.element;
                }

                @Override // us.pinguo.camera2020.module.a
                public void c(ExclusiveEffectType effectType) {
                    kotlin.jvm.internal.s.h(effectType, "effectType");
                    if (CameraStickerModule.this.u().getValue() == null) {
                        return;
                    }
                    if (effectType == ExclusiveEffectType.EFFECT_FILTER || effectType == ExclusiveEffectType.EFFECT_CUSTOM_MAKEUP || effectType == ExclusiveEffectType.EFFECT_STYLED_MAKEUP) {
                        CameraStickerModule.this.i();
                    }
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v3(ViewFinderFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        TopSettingController topSettingController = this$0.f9172h;
        if (topSettingController != null) {
            topSettingController.t();
        }
        Context context = view.getContext();
        context.startActivity(new Intent(context, ViewFinderSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v4(FilterEntry filterEntry) {
        LifecycleCoroutineScope J1 = J1();
        if (J1 == null) {
            return;
        }
        kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$startRenderSkyChange$1(this, filterEntry, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(ViewFinderFragment this$0, CameraStickerModule stickerModule, Sticker sticker) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(stickerModule, "$stickerModule");
        us.pinguo.repository2020.m.a.U(sticker == null ? null : sticker.getPid());
        ViewFinderGestureDetector viewFinderGestureDetector = this$0.s;
        if (viewFinderGestureDetector != null) {
            viewFinderGestureDetector.f(sticker == null);
            this$0.A4();
            this$0.z4();
            CameraViewModel cameraViewModel = this$0.f9174j;
            if (cameraViewModel != null) {
                CameraBeautyModule cameraBeautyModule = cameraViewModel.getCameraBeautyModule();
                String pid = sticker == null ? null : sticker.getPid();
                if (pid == null) {
                    us.pinguo.camera2020.i.a.a.l(false);
                    UnityMethodCaller.clearSticker$default(false, 1, null);
                    cameraBeautyModule.q();
                    return;
                }
                us.pinguo.camera2020.i.a.a.l(sticker.isVip());
                this$0.I.a(ExclusiveEffectType.EFFECT_STICKER);
                LifecycleCoroutineScope J1 = this$0.J1();
                if (J1 == null) {
                    return;
                }
                kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$initStickerObservation$1$1(stickerModule, pid, cameraBeautyModule, null), 2, null);
                return;
            }
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
        kotlin.jvm.internal.s.z("viewFinderGestureDetector");
        throw null;
    }

    private final void w3() {
        A1(this, false, false, 3, null);
    }

    private final boolean x2() {
        Integer value;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            CameraTopSettingsModule cameraTopSettingModule = cameraViewModel.getCameraTopSettingModule();
            Boolean value2 = cameraTopSettingModule.n().getValue();
            Boolean bool = Boolean.TRUE;
            return kotlin.jvm.internal.s.c(value2, bool) && kotlin.jvm.internal.s.c(cameraTopSettingModule.i().getValue(), bool) && ((value = cameraTopSettingModule.j().getValue()) == null || value.intValue() != 0);
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    private final void x3() {
        A1(this, false, false, 3, null);
    }

    private final void x4(List<? extends Camera.Size> list, boolean z) {
        if (z) {
            us.pinguo.camera2020.g.a aVar = us.pinguo.camera2020.g.a.a;
            if (aVar.b()) {
                return;
            }
            aVar.d();
        } else {
            us.pinguo.camera2020.g.a aVar2 = us.pinguo.camera2020.g.a.a;
            if (aVar2.a()) {
                return;
            }
            aVar2.c();
        }
        String str = z ? "front_cam" : "rear_cam";
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        for (Camera.Size size : list) {
            int i5 = i2 + 1;
            int i6 = size.width * size.height;
            if (i6 > i3) {
                i4 = i2;
                i3 = i6;
            }
            us.pinguo.foundation.statistics.h.b.b(new Rational(size.width, size.height).toString(), str, String.valueOf(i6));
            i2 = i5;
        }
        if (i4 != -1) {
            Camera.Size size2 = list.get(i4);
            us.pinguo.foundation.statistics.h.b.d(new Rational(size2.width, size2.height).toString(), String.valueOf(Math.max(size2.width, size2.height)), String.valueOf(i3));
        }
    }

    private final void y3(String str) {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.getCameraFilterModule().c();
            CameraBottomViewController cameraBottomViewController = this.n;
            if (cameraBottomViewController != null) {
                cameraBottomViewController.u0(str);
                CameraBottomViewController cameraBottomViewController2 = this.n;
                if (cameraBottomViewController2 != null) {
                    cameraBottomViewController2.L0();
                    AfterCaptureBottomController afterCaptureBottomController = this.q;
                    if (afterCaptureBottomController == null) {
                        kotlin.jvm.internal.s.z("afterCaptureController");
                        throw null;
                    } else if (afterCaptureBottomController.H()) {
                        A1(this, false, false, 3, null);
                        return;
                    } else {
                        return;
                    }
                }
                kotlin.jvm.internal.s.z("cameraBottomController");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y4(us.pinguo.repository2020.entity.FilterEntry r23, boolean r24, kotlin.coroutines.Continuation<? super kotlin.u> r25) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.y4(us.pinguo.repository2020.entity.FilterEntry, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z1(boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.z1(boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z3(String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "us.pinguo.camera360.shop.StoreActivity2");
        intent.putExtra("pre_selected", str);
        startActivityForResult(intent, 1573);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r2.H() == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z4() {
        /*
            r9 = this;
            us.pinguo.camera2020.viewmodel.CameraViewModel r0 = r9.f9174j
            r1 = 0
            if (r0 == 0) goto L6b
            us.pinguo.camera2020.module.sticker.CameraStickerModule r2 = r0.getCameraStickerModule()
            androidx.lifecycle.LiveData r2 = r2.u()
            java.lang.Object r2 = r2.getValue()
            us.pinguo.repository2020.database.sticker.Sticker r2 = (us.pinguo.repository2020.database.sticker.Sticker) r2
            us.pinguo.camera2020.module.settings.a r3 = r0.getCameraBottomModule()
            us.pinguo.repository2020.u r3 = r3.a()
            java.lang.Object r3 = r3.getValue()
            us.pinguo.camera2020.widget.CameraSwitchMode r4 = us.pinguo.camera2020.widget.CameraSwitchMode.PHOTO
            r5 = 1
            r6 = 0
            if (r3 != r4) goto L27
            r3 = 1
            goto L28
        L27:
            r3 = 0
        L28:
            us.pinguo.camera2020.view.l2 r4 = us.pinguo.camera2020.view.l2.a
            boolean r4 = r4.a()
            if (r4 == 0) goto L3a
            us.pinguo.camera2020.utils.b r4 = us.pinguo.camera2020.utils.b.a
            boolean r4 = r4.a()
            if (r4 == 0) goto L3a
            r4 = 1
            goto L3b
        L3a:
            r4 = 0
        L3b:
            us.pinguo.camera2020.module.settings.CameraTopSettingsModule r0 = r0.getCameraTopSettingModule()
            androidx.lifecycle.LiveData r7 = r0.e()
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            boolean r7 = kotlin.jvm.internal.s.c(r7, r8)
            if (r7 == 0) goto L66
            if (r3 == 0) goto L66
            if (r4 != 0) goto L66
            if (r2 != 0) goto L66
            us.pinguo.camera2020.view.AfterCaptureBottomController r2 = r9.q
            if (r2 == 0) goto L60
            boolean r1 = r2.H()
            if (r1 != 0) goto L66
            goto L67
        L60:
            java.lang.String r0 = "afterCaptureController"
            kotlin.jvm.internal.s.z(r0)
            throw r1
        L66:
            r5 = 0
        L67:
            r0.b(r5)
            return
        L6b:
            java.lang.String r0 = "cameraViewModel"
            kotlin.jvm.internal.s.z(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.z4():void");
    }

    public final void A3() {
        if (this.H.a()) {
            return;
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.camera2020.activity.Camera2020Activity");
        ((Camera2020Activity) activity).t0();
    }

    @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.c
    public void B(int i2, int i3, int i4, boolean z) {
        if (i2 == 7) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.setContrastValue(i3 / 100.0f);
                ParameterAdvanceSettingView parameterAdvanceSettingView = this.N;
                if (parameterAdvanceSettingView != null) {
                    String string = getString(R.string.advanced_contrast);
                    kotlin.jvm.internal.s.g(string, "getString(R.string.advanced_contrast)");
                    parameterAdvanceSettingView.J(string, kotlin.jvm.internal.s.q("", Integer.valueOf(i3)));
                }
                if (z) {
                    us.pinguo.foundation.statistics.h.a.N("contrast");
                }
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        } else if (i2 != 8) {
            G1(i2, i3, z);
        } else {
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                cameraViewModel2.setSaturationValue(i3 / 100.0f);
                ParameterAdvanceSettingView parameterAdvanceSettingView2 = this.N;
                if (parameterAdvanceSettingView2 != null) {
                    String string2 = getString(R.string.advanced_saturation);
                    kotlin.jvm.internal.s.g(string2, "getString(R.string.advanced_saturation)");
                    parameterAdvanceSettingView2.J(string2, kotlin.jvm.internal.s.q("", Integer.valueOf(i3)));
                }
                if (z) {
                    us.pinguo.foundation.statistics.h.a.N("saturation");
                }
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        if (i2 == 0) {
            if (z) {
                us.pinguo.foundation.statistics.h.a.N("focal_length");
            }
        } else if (i2 == 1) {
            if (z) {
                us.pinguo.foundation.statistics.h.a.N("white_balance");
            }
        } else if (i2 == 2) {
            float f2 = i3;
            float f3 = i4 / 2;
            float f4 = 1;
            float f5 = (f2 / f3) - f4;
            this.O = f5;
            float f6 = (f5 + f4) / f3;
            PGFocusView pGFocusView = this.y;
            if (pGFocusView != null) {
                pGFocusView.setExposureSeekRate(f6);
                CameraViewModel cameraViewModel3 = this.f9174j;
                if (cameraViewModel3 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                cameraViewModel3.setExposureCompensation(this.O);
                if (z) {
                    us.pinguo.foundation.statistics.h.a.N("exposure_gain");
                    return;
                }
                return;
            }
            kotlin.jvm.internal.s.z("focusView");
            throw null;
        } else if (i2 != 3) {
            if (i2 != 5) {
                if (i2 == 6 && z) {
                    us.pinguo.foundation.statistics.h.a.N("shutter_speed");
                    return;
                }
                return;
            }
            PGFocusView pGFocusView2 = this.y;
            if (pGFocusView2 == null) {
                kotlin.jvm.internal.s.z("focusView");
                throw null;
            }
            pGFocusView2.setExposureSeekRate(i3 / (i4 - 1));
            if (z) {
                us.pinguo.foundation.statistics.h.a.N("focal_length");
            }
        } else {
            if (i3 == 0) {
                PGFocusView pGFocusView3 = this.y;
                if (pGFocusView3 == null) {
                    kotlin.jvm.internal.s.z("focusView");
                    throw null;
                }
                pGFocusView3.setExposureSeekRate(0.5f);
            } else {
                PGFocusView pGFocusView4 = this.y;
                if (pGFocusView4 == null) {
                    kotlin.jvm.internal.s.z("focusView");
                    throw null;
                }
                pGFocusView4.setExposureSeekRate(i3 / (i4 - 1));
            }
            if (z) {
                us.pinguo.foundation.statistics.h.a.N("iso");
            }
        }
    }

    @Override // us.pinguo.camera2020.view.focusview.a
    public void E(float f2) {
        float f3 = 2;
        float f4 = (f2 * f3) - 1;
        this.O = f4;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setExposureCompensation(f4);
            int i2 = (int) (this.O * f3);
            ParameterAdvanceSettingView parameterAdvanceSettingView = this.N;
            if (parameterAdvanceSettingView == null) {
                return;
            }
            parameterAdvanceSettingView.setExposureValue(i2);
            return;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void F(int i2) {
        TopSettingController topSettingController = this.f9172h;
        if (topSettingController != null) {
            topSettingController.t();
        }
        p2 p2Var = this.f9175k;
        if (p2Var != null) {
            p2Var.b();
        }
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.getCameraTopSettingModule().f().setValue(Integer.valueOf(i2));
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void K() {
        TopSettingController topSettingController = this.f9172h;
        if (topSettingController == null) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                View inflate = ((ViewStub) _$_findCachedViewById(R.id.stubTopSettingLayout)).inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.camera2020.view.TopSettingLayout");
                TopSettingLayout topSettingLayout = (TopSettingLayout) inflate;
                TopSettingController topSettingController2 = new TopSettingController(cameraViewModel.getCameraTopSettingModule(), topSettingLayout, cameraViewModel.getCameraBottomModule().a(), this);
                m2 m2Var = this.f9176l;
                if (m2Var != null) {
                    topSettingController2.v(m2Var.e());
                    this.H.c(topSettingController2, 1);
                    this.f9172h = topSettingController2;
                    ((MultiStateImageTextView) topSettingLayout._$_findCachedViewById(R.id.msvSetting)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.fragment.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ViewFinderFragment.v3(ViewFinderFragment.this, view);
                        }
                    });
                    topSettingController = topSettingController2;
                } else {
                    kotlin.jvm.internal.s.z("cameraTopBar");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        if (topSettingController.w()) {
            topSettingController.t();
            return;
        }
        p2 p2Var = this.f9175k;
        if (p2Var != null) {
            p2Var.b();
        }
        topSettingController.Q();
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void L() {
        ParameterAdvanceSettingView parameterAdvanceSettingView = this.N;
        if (parameterAdvanceSettingView != null && parameterAdvanceSettingView.isShown()) {
            ParameterAdvanceSettingView parameterAdvanceSettingView2 = this.N;
            if (parameterAdvanceSettingView2 == null) {
                return;
            }
            parameterAdvanceSettingView2.v(0.0f);
            return;
        }
        StickerViewController stickerViewController = this.f9173i;
        if (stickerViewController != null) {
            stickerViewController.n();
        }
        FilterController filterController = this.u;
        if (filterController != null) {
            FilterController.I0(filterController, false, 1, null);
        }
        CameraBeautyController cameraBeautyController = this.p;
        if (cameraBeautyController != null) {
            cameraBeautyController.C();
        }
        TopSettingController topSettingController = this.f9172h;
        if (topSettingController != null) {
            topSettingController.t();
        }
        p2 p2Var = this.f9175k;
        if (p2Var != null) {
            p2Var.b();
        }
        CameraBottomViewController cameraBottomViewController = this.n;
        if (cameraBottomViewController != null) {
            CameraBottomViewController.N(cameraBottomViewController, false, 1, null);
            CameraBottomViewController cameraBottomViewController2 = this.n;
            if (cameraBottomViewController2 != null) {
                cameraBottomViewController2.O0();
                m2 m2Var = this.f9176l;
                if (m2Var != null) {
                    m2Var.f();
                    i4();
                    return;
                }
                kotlin.jvm.internal.s.z("cameraTopBar");
                throw null;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    @Override // us.pinguo.camera2020.view.focusview.b
    public void N(float f2) {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.setZoom(f2);
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    public final void T1() {
        Bundle arguments = getArguments();
        String string = arguments == null ? null : arguments.getString("bundle_key_is_sticker", "false");
        boolean z = true;
        if (kotlin.jvm.internal.s.c(string, "true")) {
            s4(true);
            V1();
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                cameraViewModel.setCurrentExclusiveType(ExclusiveEffectType.EFFECT_STICKER);
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        } else if (kotlin.jvm.internal.s.c(string, "false")) {
            Bundle arguments2 = getArguments();
            String string2 = arguments2 == null ? null : arguments2.getString("bundle_key_filter");
            Bundle arguments3 = getArguments();
            String string3 = arguments3 == null ? null : arguments3.getString("bundle_key_package");
            Bundle arguments4 = getArguments();
            String string4 = arguments4 == null ? null : arguments4.getString("bundle_key_style_makeup");
            if (!(string3 == null || string3.length() == 0)) {
                FilterController filterController = this.u;
                if (filterController != null) {
                    filterController.h1(true);
                }
                S1("", string3, string2);
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 != null) {
                    cameraViewModel2.setCurrentExclusiveType(ExclusiveEffectType.EFFECT_FILTER);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
            if (string4 != null && string4.length() != 0) {
                z = false;
            }
            if (!z) {
                CameraBeautyController cameraBeautyController = this.p;
                if (cameraBeautyController != null) {
                    cameraBeautyController.I(string4);
                }
                CameraBottomViewController cameraBottomViewController = this.n;
                if (cameraBottomViewController != null) {
                    kotlin.jvm.b.l<View, kotlin.u> R = cameraBottomViewController.R();
                    if (R != null) {
                        ImageView imgBeauty = (ImageView) _$_findCachedViewById(R.id.imgBeauty);
                        kotlin.jvm.internal.s.g(imgBeauty, "imgBeauty");
                        R.invoke(imgBeauty);
                    }
                    CameraViewModel cameraViewModel3 = this.f9174j;
                    if (cameraViewModel3 != null) {
                        cameraViewModel3.setCurrentExclusiveType(ExclusiveEffectType.EFFECT_STYLED_MAKEUP);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("cameraViewModel");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("cameraBottomController");
                throw null;
            }
            h2();
        }
    }

    public final boolean T3(boolean z) {
        CameraZoomLayout cameraZoomLayout;
        AfterCaptureBottomController afterCaptureBottomController = this.q;
        if (afterCaptureBottomController == null) {
            kotlin.jvm.internal.s.z("afterCaptureController");
            throw null;
        }
        boolean z2 = false;
        if (!afterCaptureBottomController.H()) {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            } else if (cameraViewModel.getCameraBottomModule().a().getValue() != CameraSwitchMode.MOVIE) {
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 != null) {
                    Integer value = cameraViewModel2.getViewFinderSettingsModule().c().getValue();
                    if (value != null && value.intValue() == 2) {
                        U1();
                        return true;
                    } else if (value != null && value.intValue() == 3) {
                        CameraZoomLayout cameraZoomLayout2 = this.m;
                        if (cameraZoomLayout2 != null && cameraZoomLayout2.i()) {
                            z2 = true;
                        }
                        if (!z2 || (cameraZoomLayout = this.m) == null) {
                            return true;
                        }
                        cameraZoomLayout.c(z ? 0.05f : -0.05f);
                        return true;
                    }
                } else {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
            }
        }
        return false;
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void U() {
        try {
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            } else if (cameraViewModel.canSwitchCamera()) {
                View _$_findCachedViewById = _$_findCachedViewById(R.id.viewFinderMaskForSwitchCamera);
                if (_$_findCachedViewById != null) {
                    _$_findCachedViewById.setVisibility(0);
                    VdsAgent.onSetViewVisibility(_$_findCachedViewById, 0);
                }
                CameraZoomLayout cameraZoomLayout = this.m;
                if (cameraZoomLayout != null) {
                    cameraZoomLayout.j();
                }
                p2 p2Var = this.f9175k;
                if (p2Var != null) {
                    p2Var.b();
                }
                TopSettingController topSettingController = this.f9172h;
                if (topSettingController != null) {
                    topSettingController.t();
                }
                CameraViewModel cameraViewModel2 = this.f9174j;
                if (cameraViewModel2 != null) {
                    cameraViewModel2.getCameraTopSettingModule().s();
                    PGFocusView pGFocusView = this.y;
                    if (pGFocusView != null) {
                        pGFocusView.X();
                        PGFocusView pGFocusView2 = this.y;
                        if (pGFocusView2 != null) {
                            pGFocusView2.w(false);
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("focusView");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.s.z("focusView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            CrashReport.postCatchedException(e2);
        }
    }

    @Override // us.pinguo.u3dengine.PGUnityCameraFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this.f9171g.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f9171g;
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

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment
    public ViewGroup b0() {
        return (FrameLayout) _$_findCachedViewById(R.id.viewFinderContainer);
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void f() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // us.pinguo.camera2020.view.focusview.a
    public void l() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.clearFocusAndMetering();
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    @Override // us.pinguo.camera2020.view.focusview.a
    public void n(float f2, float f3, int i2, int i3) {
        this.J.d();
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            CameraViewModel.focusAndMetering$default(cameraViewModel, f2, f3, i2, i3, null, 16, null);
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }

    @Override // us.pinguo.camera2020.view.m2.a
    public void o() {
        p2 p2Var = this.f9175k;
        if (p2Var == null) {
            View frameLayout = ((ViewStub) _$_findCachedViewById(R.id.frameMenuLayout)).inflate();
            kotlin.jvm.internal.s.g(frameLayout, "frameLayout");
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
            CameraViewModel cameraViewModel = this.f9174j;
            if (cameraViewModel != null) {
                p2 p2Var2 = new p2(frameLayout, cameraViewModel.getFrameRatioModule());
                p2Var2.d();
                this.f9175k = p2Var2;
                p2Var = p2Var2;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        this.H.c(p2Var, 1);
        if (p2Var.e()) {
            p2Var.b();
            return;
        }
        TopSettingController topSettingController = this.f9172h;
        if (topSettingController != null) {
            topSettingController.t();
        }
        m2 m2Var = this.f9176l;
        if (m2Var != null) {
            p2Var.l(m2Var.d());
        } else {
            kotlin.jvm.internal.s.z("cameraTopBar");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        FilterController filterController;
        if (i2 != 1001) {
            if (i2 != 1002) {
                if (i2 == 1573 && (filterController = this.u) != null) {
                    filterController.b1(i3, intent);
                }
            } else if (i3 == -1 && intent != null) {
                us.pinguo.camera2020.activity.y.b().e(-1, intent);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        } else if (i3 == -1 && intent != null) {
            VideoMusic videoMusic = (VideoMusic) intent.getParcelableExtra("music_select");
            this.B = videoMusic;
            VideoPreviewController videoPreviewController = this.o;
            if (videoPreviewController == null) {
                kotlin.jvm.internal.s.z("videoPreviewController");
                throw null;
            }
            videoPreviewController.o(videoMusic);
            if (videoMusic == null) {
                U3();
                P1().d();
                M1(true);
                return;
            }
            V3(videoMusic.c());
            M1(false);
        }
        ViewFinderPermissionControl viewFinderPermissionControl = this.P;
        if (viewFinderPermissionControl != null) {
            viewFinderPermissionControl.d(i2, i3, intent);
        } else {
            kotlin.jvm.internal.s.z("permissionControl");
            throw null;
        }
    }

    public final boolean onBackPressed() {
        SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) _$_findCachedViewById(R.id.gvSkyChange);
        kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
        if (gvSkyChange.getVisibility() == 0) {
            return true;
        }
        CameraBottomViewController cameraBottomViewController = this.n;
        if (cameraBottomViewController == null) {
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        } else if (cameraBottomViewController.V()) {
            return false;
        } else {
            if (this.X) {
                return true;
            }
            us.pinguo.common.d dVar = new us.pinguo.common.d();
            dVar.f(EventType.BACK_PRESS);
            return this.H.b(dVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        this.P = new ViewFinderPermissionControl(this);
        Bundle arguments = getArguments();
        Parcelable parcelable = null;
        boolean z = true;
        Integer valueOf = arguments == null ? null : Integer.valueOf(arguments.getInt("key_cam", 1));
        if (valueOf != null && (valueOf.intValue() == 1 || valueOf.intValue() == 2)) {
            us.pinguo.repository2020.m mVar = us.pinguo.repository2020.m.a;
            mVar.T(false);
            boolean z2 = valueOf.intValue() == 1;
            mVar.y().setValue(Boolean.valueOf(z2));
            mVar.T(true);
            z = z2;
        } else if (kotlin.jvm.internal.s.c(us.pinguo.repository2020.m.a.y().getValue(), Boolean.FALSE)) {
            z = false;
        }
        if (!CameraPreferencesManager.a.b(z ? LensFacing.FRONT : LensFacing.BACK)) {
            z = !z;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        kotlin.jvm.internal.s.g(viewModelStore, "viewModelStore");
        FragmentActivity activity = getActivity();
        Application application = activity == null ? null : activity.getApplication();
        if (application == null) {
            return;
        }
        final CameraViewModel cameraViewModel = (CameraViewModel) new ViewModelProvider(viewModelStore, new CameraViewModelFactory(application, z)).get(CameraViewModel.class);
        this.f9174j = cameraViewModel;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            boolean z3 = arguments2.getBoolean("is_intent", false);
            this.Q = z3;
            if (z3) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null) {
                    parcelable = intent.getParcelableExtra("task");
                }
                this.R = parcelable;
                cameraViewModel.getAfterCaptureModule().G(new ViewFinderFragment$onCreate$1$1(this));
                cameraViewModel.setIntent(this.Q);
                if (this.R == null) {
                    cameraViewModel.setShotSource("commuity");
                } else {
                    cameraViewModel.setShotSource("challenge");
                }
            } else {
                cameraViewModel.setShotSource("non_challenge");
            }
        }
        cameraViewModel.setOnCaptureRenderEndCallback(new ViewFinderFragment$onCreate$2(this));
        cameraViewModel.setOnCaptureImageRenderEndCallback(new ViewFinderFragment$onCreate$3(this, cameraViewModel));
        cameraViewModel.setOnCaptureImageSavedCallback(new ViewFinderFragment$onCreate$4(cameraViewModel, this));
        cameraViewModel.getCameraThemeStyle().observe(this, new Observer() { // from class: us.pinguo.camera2020.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderFragment.s3(ViewFinderFragment.this, (Integer) obj);
            }
        });
        cameraViewModel.setOnFirstRenderStart(new ViewFinderFragment$onCreate$6(this, cameraViewModel));
        d0(cameraViewModel.getUnityGLRender());
        this.C = new Handler(new Handler.Callback() { // from class: us.pinguo.camera2020.fragment.r0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean t3;
                t3 = ViewFinderFragment.t3(ViewFinderFragment.this, message);
                return t3;
            }
        });
        this.D = new m(cameraViewModel, getActivity());
        cameraViewModel.getViewFinderSettingsModule().a().observe(this, new Observer() { // from class: us.pinguo.camera2020.fragment.g0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewFinderFragment.u3(CameraViewModel.this, (Boolean) obj);
            }
        });
        us.pinguo.processor.i.a.l(ShaderCache.a.a());
        us.pinguo.repository2020.utils.k.a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_view_finder, viewGroup, false);
    }

    @Override // us.pinguo.u3dengine.PGUnityCameraFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.camera2020.utils.d.e eVar = this.A;
        if (eVar == null) {
            kotlin.jvm.internal.s.z("videoRecordManager");
            throw null;
        }
        CameraBottomViewController cameraBottomViewController = this.n;
        if (cameraBottomViewController != null) {
            eVar.j(cameraBottomViewController);
            us.pinguo.camera2020.utils.d.e eVar2 = this.A;
            if (eVar2 != null) {
                eVar2.h();
                Handler handler = this.C;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    l2.a.h();
                    return;
                }
                kotlin.jvm.internal.s.z("mainHandler");
                throw null;
            }
            kotlin.jvm.internal.s.z("videoRecordManager");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraBottomController");
        throw null;
    }

    @Override // us.pinguo.u3dengine.PGUnityCameraFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FrameLayout frameLayout;
        super.onDestroyView();
        this.v.c();
        P1().d();
        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
        if (pgUnityPlayer != null && (frameLayout = (FrameLayout) _$_findCachedViewById(R.id.viewFinderContainer)) != null) {
            frameLayout.removeView(pgUnityPlayer);
        }
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.u3dengine.PGUnityCameraFragment, us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        us.pinguo.location.d.c().i();
        this.Z = true;
        CameraZoomLayout cameraZoomLayout = this.m;
        if (cameraZoomLayout != null) {
            cameraZoomLayout.j();
        }
        PGFocusView pGFocusView = this.y;
        if (pGFocusView != null) {
            pGFocusView.X();
            PGFocusView pGFocusView2 = this.y;
            if (pGFocusView2 != null) {
                pGFocusView2.w(false);
                OrientationEventListener orientationEventListener = this.D;
                if (orientationEventListener != null) {
                    orientationEventListener.disable();
                }
                U3();
                TimerCountDownController timerCountDownController = this.r;
                if (timerCountDownController != null) {
                    if (timerCountDownController.f()) {
                        TimerCountDownController timerCountDownController2 = this.r;
                        if (timerCountDownController2 != null) {
                            TimerCountDownController.d(timerCountDownController2, null, 1, null);
                            d4();
                        } else {
                            kotlin.jvm.internal.s.z("timerCountDownController");
                            throw null;
                        }
                    }
                    us.pinguo.camera2020.utils.d.e eVar = this.A;
                    if (eVar != null) {
                        eVar.m();
                        h4();
                        us.pinguo.foundation.statistics.f.d("camerafragment");
                        return;
                    }
                    kotlin.jvm.internal.s.z("videoRecordManager");
                    throw null;
                }
                kotlin.jvm.internal.s.z("timerCountDownController");
                throw null;
            }
            kotlin.jvm.internal.s.z("focusView");
            throw null;
        }
        kotlin.jvm.internal.s.z("focusView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.s.h(permissions, "permissions");
        kotlin.jvm.internal.s.h(grantResults, "grantResults");
        ViewFinderPermissionControl viewFinderPermissionControl = this.P;
        if (viewFinderPermissionControl != null) {
            viewFinderPermissionControl.e(i2, permissions, grantResults);
        } else {
            kotlin.jvm.internal.s.z("permissionControl");
            throw null;
        }
    }

    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (kotlin.jvm.internal.s.c(us.pinguo.foundation.j.e().k("pref_camera_recordlocation_key", "off"), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON)) {
            us.pinguo.location.d.c().h(null);
        }
        this.Z = false;
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.resume();
            e4();
            if (kotlin.jvm.internal.s.c(us.pinguo.foundation.j.e().k("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON), TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON)) {
                String k2 = us.pinguo.foundation.j.e().k("key_watermark_type", "0");
                if (k2 != null) {
                    switch (k2.hashCode()) {
                        case 48:
                            if (k2.equals("0")) {
                                CameraViewModel cameraViewModel2 = this.f9174j;
                                if (cameraViewModel2 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel2.setWatermarkStyle(WatermarkStyle.STYLE_0);
                                    break;
                                }
                            }
                            break;
                        case 49:
                            if (k2.equals("1")) {
                                CameraViewModel cameraViewModel3 = this.f9174j;
                                if (cameraViewModel3 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel3.setWatermarkStyle(WatermarkStyle.STYLE_1);
                                    break;
                                }
                            }
                            break;
                        case 50:
                            if (k2.equals("2")) {
                                CameraViewModel cameraViewModel4 = this.f9174j;
                                if (cameraViewModel4 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel4.setWatermarkStyle(WatermarkStyle.STYLE_2);
                                    break;
                                }
                            }
                            break;
                        case 51:
                            if (k2.equals("3")) {
                                CameraViewModel cameraViewModel5 = this.f9174j;
                                if (cameraViewModel5 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel5.setWatermarkStyle(WatermarkStyle.STYLE_3);
                                    break;
                                }
                            }
                            break;
                        case 52:
                            if (k2.equals(Constants.VIA_TO_TYPE_QZONE)) {
                                CameraViewModel cameraViewModel6 = this.f9174j;
                                if (cameraViewModel6 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel6.setWatermarkStyle(WatermarkStyle.STYLE_4);
                                    break;
                                }
                            }
                            break;
                        case 53:
                            if (k2.equals("5")) {
                                CameraViewModel cameraViewModel7 = this.f9174j;
                                if (cameraViewModel7 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel7.setWatermarkStyle(WatermarkStyle.STYLE_5);
                                    break;
                                }
                            }
                            break;
                        case 54:
                            if (k2.equals(Constants.VIA_SHARE_TYPE_INFO)) {
                                CameraViewModel cameraViewModel8 = this.f9174j;
                                if (cameraViewModel8 == null) {
                                    kotlin.jvm.internal.s.z("cameraViewModel");
                                    throw null;
                                } else {
                                    cameraViewModel8.setWatermarkStyle(WatermarkStyle.STYLE_6);
                                    break;
                                }
                            }
                            break;
                    }
                }
                CameraViewModel cameraViewModel9 = this.f9174j;
                if (cameraViewModel9 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                cameraViewModel9.setWatermarkStyle(WatermarkStyle.STYLE_0);
            } else {
                CameraViewModel cameraViewModel10 = this.f9174j;
                if (cameraViewModel10 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                cameraViewModel10.setWatermarkStyle(WatermarkStyle.NONE);
            }
            OrientationEventListener orientationEventListener = this.D;
            if (orientationEventListener != null) {
                orientationEventListener.enable();
            }
            if (this.B != null) {
                g4(this, null, 1, null);
            }
            us.pinguo.foundation.statistics.f.f("camerafragment");
            CameraBottomViewController cameraBottomViewController = this.n;
            if (cameraBottomViewController != null) {
                cameraBottomViewController.U0();
                if (this.T) {
                    this.T = false;
                    q4();
                }
                if (this.d0) {
                    this.d0 = false;
                    CameraViewModel cameraViewModel11 = this.f9174j;
                    if (cameraViewModel11 != null) {
                        cameraViewModel11.setGettingPictureAfterSnapshot(false);
                        A1(this, false, false, 3, null);
                        return;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                return;
            }
            kotlin.jvm.internal.s.z("cameraBottomController");
            throw null;
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            UnityCallbackApi unityCallback = cameraViewModel.getUnityCallback();
            CameraViewModel cameraViewModel2 = this.f9174j;
            if (cameraViewModel2 != null) {
                c0(unityCallback, cameraViewModel2.getUnityFilterCallback());
                return;
            } else {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.s.z("cameraViewModel");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021a  */
    @Override // us.pinguo.u3dengine.BaseUnityPlayerFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 1614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // us.pinguo.camera2020.view.AccelerationSensorController.a
    public void r() {
        this.J.a();
        PGFocusView pGFocusView = this.y;
        if (pGFocusView == null) {
            kotlin.jvm.internal.s.z("focusView");
            throw null;
        } else if (pGFocusView.L()) {
            PGFocusView pGFocusView2 = this.y;
            if (pGFocusView2 == null) {
                kotlin.jvm.internal.s.z("focusView");
                throw null;
            }
            long v = pGFocusView2.v();
            if (v >= 3000) {
                PGFocusView pGFocusView3 = this.y;
                if (pGFocusView3 != null) {
                    PGFocusView.x(pGFocusView3, false, 1, null);
                    return;
                } else {
                    kotlin.jvm.internal.s.z("focusView");
                    throw null;
                }
            }
            long j2 = 3000 - v;
            if (j2 < 100) {
                j2 = 100;
            }
            PGFocusView pGFocusView4 = this.y;
            if (pGFocusView4 != null) {
                pGFocusView4.G(j2);
            } else {
                kotlin.jvm.internal.s.z("focusView");
                throw null;
            }
        }
    }

    public final void w4() {
        CameraViewModel cameraViewModel = this.f9174j;
        if (cameraViewModel != null) {
            cameraViewModel.cameraAttrUpToStat("back_to_camera");
        } else {
            kotlin.jvm.internal.s.z("cameraViewModel");
            throw null;
        }
    }
}
