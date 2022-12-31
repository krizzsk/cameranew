package us.pinguo.camera2020.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.Objects;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.settings.CameraTopSettingsModule;
import us.pinguo.camera2020.view.TopSettingController$transitionListener$2;
import us.pinguo.camera2020.widget.CameraSwitchMode;
import us.pinguo.common.EventType;
import us.pinguo.ui.widget.MultiStateImageTextView;
/* compiled from: TopSettingController.kt */
/* loaded from: classes3.dex */
public final class TopSettingController implements us.pinguo.common.g {
    private final TopSettingLayout a;
    private final LifecycleOwner b;
    private final Integer[] c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.f f9318d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.f f9319e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.f f9320f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9321g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9322h;

    public TopSettingController(final CameraTopSettingsModule settingsModule, final TopSettingLayout settingLayout, LiveData<CameraSwitchMode> cameraSwitchLiveData, LifecycleOwner lifecycleOwner) {
        kotlin.f b;
        kotlin.f b2;
        kotlin.f b3;
        kotlin.jvm.internal.s.h(settingsModule, "settingsModule");
        kotlin.jvm.internal.s.h(settingLayout, "settingLayout");
        kotlin.jvm.internal.s.h(cameraSwitchLiveData, "cameraSwitchLiveData");
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        this.a = settingLayout;
        this.b = lifecycleOwner;
        int i2 = 3;
        this.c = new Integer[]{10, 30, 60, Integer.valueOf((int) IjkMediaCodecInfo.RANK_SECURE)};
        b = kotlin.h.b(new TopSettingController$autoTrans$2(this));
        this.f9318d = b;
        b2 = kotlin.h.b(new TopSettingController$customTransitionSet$2(this));
        this.f9319e = b2;
        b3 = kotlin.h.b(new TopSettingController$transitionListener$2(this));
        this.f9320f = b3;
        this.f9322h = true;
        final MultiStateImageTextView multiStateImageTextView = (MultiStateImageTextView) settingLayout._$_findCachedViewById(R.id.msvFlash);
        final MultiStateImageTextView multiStateImageTextView2 = (MultiStateImageTextView) settingLayout._$_findCachedViewById(R.id.msvDarkCorner);
        final MultiStateImageTextView multiStateImageTextView3 = (MultiStateImageTextView) settingLayout._$_findCachedViewById(R.id.msvTouchScreenShot);
        final SwitchCompat switchCompat = (SwitchCompat) settingLayout._$_findCachedViewById(R.id.switchAutoSave);
        final LinearLayout videoTimeValues = (LinearLayout) settingLayout._$_findCachedViewById(R.id.videoTimeValues);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.camera2020.view.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopSettingController.a(CameraTopSettingsModule.this, this, videoTimeValues, view);
            }
        };
        int childCount = videoTimeValues.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            kotlin.jvm.internal.s.g(videoTimeValues, "videoTimeValues");
            ViewGroupKt.get(videoTimeValues, i3).setOnClickListener(onClickListener);
        }
        settingsModule.n().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.n1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.b(MultiStateImageTextView.this, settingsModule, (Boolean) obj);
            }
        });
        multiStateImageTextView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopSettingController.h(CameraTopSettingsModule.this, view);
            }
        });
        multiStateImageTextView3.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopSettingController.i(CameraTopSettingsModule.this, view);
            }
        });
        Boolean value = settingsModule.k().getValue();
        Boolean bool = Boolean.TRUE;
        boolean c = kotlin.jvm.internal.s.c(value, bool);
        multiStateImageTextView3.setEnabled(c);
        if (c) {
            multiStateImageTextView3.j(!kotlin.jvm.internal.s.c(settingsModule.l().getValue(), bool) ? 1 : 0);
        }
        multiStateImageTextView2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopSettingController.j(CameraTopSettingsModule.this, view);
            }
        });
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.view.o1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TopSettingController.k(CameraTopSettingsModule.this, compoundButton, z);
            }
        });
        settingsModule.j().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.a2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.l(MultiStateImageTextView.this, (Integer) obj);
            }
        });
        settingsModule.i().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.w1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.m(TopSettingController.this, multiStateImageTextView, settingsModule, settingLayout, (Boolean) obj);
            }
        });
        settingsModule.l().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.m1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.n(MultiStateImageTextView.this, (Boolean) obj);
            }
        });
        settingsModule.k().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.z1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.c(TopSettingLayout.this, settingsModule, multiStateImageTextView3, this, (Boolean) obj);
            }
        });
        settingsModule.g().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.p1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.d(MultiStateImageTextView.this, (Boolean) obj);
            }
        });
        settingsModule.h().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.x1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.e(MultiStateImageTextView.this, (Boolean) obj);
            }
        });
        settingsModule.d().observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.u1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.f(SwitchCompat.this, settingsModule, (Boolean) obj);
            }
        });
        Integer[] numArr = this.c;
        int length = numArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            }
            int intValue = numArr[i4].intValue();
            Integer value2 = settingsModule.m().getValue();
            if (value2 != null && value2.intValue() == intValue) {
                break;
            }
            i4++;
        }
        if (i4 < 0 || i4 > 3) {
            settingsModule.q(IjkMediaCodecInfo.RANK_SECURE);
        } else {
            i2 = i4;
        }
        int childCount2 = videoTimeValues.getChildCount();
        int i5 = 0;
        while (i5 < childCount2) {
            int i6 = i5 + 1;
            kotlin.jvm.internal.s.g(videoTimeValues, "videoTimeValues");
            ((TextView) ViewGroupKt.get(videoTimeValues, i5)).setTextColor(us.pinguo.util.v.b(i2 == i5 ? R.color.color_camera_theme_light : R.color.color_camera_theme_dark));
            i5 = i6;
        }
        R(cameraSwitchLiveData.getValue());
        cameraSwitchLiveData.observe(this.b, new Observer() { // from class: us.pinguo.camera2020.view.v1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopSettingController.g(TopSettingController.this, (CameraSwitchMode) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TopSettingController this$0, MultiStateImageTextView touchMsv, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f9321g) {
            return;
        }
        kotlin.jvm.internal.s.g(touchMsv, "touchMsv");
        kotlin.jvm.internal.s.g(it, "it");
        int i2 = it.booleanValue() ? 0 : 8;
        touchMsv.setVisibility(i2);
        VdsAgent.onSetViewVisibility(touchMsv, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(TopSettingController this$0, MultiStateImageTextView flashMsv, Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f9321g) {
            return;
        }
        kotlin.jvm.internal.s.g(flashMsv, "flashMsv");
        kotlin.jvm.internal.s.g(it, "it");
        int i2 = it.booleanValue() ? 0 : 8;
        flashMsv.setVisibility(i2);
        VdsAgent.onSetViewVisibility(flashMsv, i2);
    }

    private final void R(CameraSwitchMode cameraSwitchMode) {
        ConstraintSet constraintSet = new ConstraintSet();
        TopSettingLayout topSettingLayout = this.a;
        int i2 = R.id.clTopSetting;
        constraintSet.clone((ConstraintLayout) topSettingLayout._$_findCachedViewById(i2));
        if (cameraSwitchMode == CameraSwitchMode.MOVIE) {
            TransitionManager.beginDelayedTransition((ConstraintLayout) this.a._$_findCachedViewById(i2), q());
            constraintSet.setVisibility(R.id.layoutVideoTime, 0);
            constraintSet.setVisibility(R.id.layoutAutoSave, 4);
            constraintSet.setVisibility(R.id.msvTouchScreenShot, 8);
            constraintSet.setVisibility(R.id.msvFlash, 8);
        } else {
            TransitionManager.beginDelayedTransition((ConstraintLayout) this.a._$_findCachedViewById(i2), r());
            constraintSet.setVisibility(R.id.layoutVideoTime, 4);
            constraintSet.setVisibility(R.id.layoutAutoSave, 0);
            constraintSet.setVisibility(R.id.msvTouchScreenShot, 0);
            if (this.f9322h) {
                constraintSet.setVisibility(R.id.msvFlash, 0);
            }
        }
        constraintSet.applyTo((ConstraintLayout) this.a._$_findCachedViewById(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CameraTopSettingsModule settingsModule, TopSettingController this$0, LinearLayout videoTimeValues, View view) {
        int i2;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int id = view.getId();
        int i3 = 0;
        if (id == R.id.videoTime1) {
            i2 = 0;
        } else if (id == R.id.videoTime2) {
            i2 = 1;
        } else {
            i2 = id == R.id.videoTime3 ? 2 : 3;
        }
        settingsModule.q(this$0.c[i2].intValue());
        int childCount = videoTimeValues.getChildCount();
        while (i3 < childCount) {
            int i4 = i3 + 1;
            kotlin.jvm.internal.s.g(videoTimeValues, "videoTimeValues");
            ((TextView) ViewGroupKt.get(videoTimeValues, i3)).setTextColor(us.pinguo.util.v.b(i2 == i3 ? R.color.color_camera_theme_light : R.color.color_camera_theme_dark));
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MultiStateImageTextView multiStateImageTextView, CameraTopSettingsModule settingsModule, Boolean bool) {
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        if (kotlin.jvm.internal.s.c(bool, Boolean.TRUE)) {
            int[] iArr = {R.drawable.ic_flash_off, R.drawable.ic_flash_on};
            int i2 = R.string.txt_flash_light;
            multiStateImageTextView.k(iArr, new int[]{i2, i2}, new int[]{R.style.TopSettingTextAppearanceOff, R.style.TopSettingTextAppearanceOn});
            multiStateImageTextView.j(0);
            settingsModule.p(2);
            return;
        }
        int[] iArr2 = {R.drawable.ic_flash_off, R.drawable.ic_flash_on, R.drawable.ic_flash_auto, R.drawable.ic_flash_torch};
        int i3 = R.string.txt_flash_light;
        int i4 = R.style.TopSettingTextAppearanceOn;
        multiStateImageTextView.k(iArr2, new int[]{i3, i3, i3, i3}, new int[]{R.style.TopSettingTextAppearanceOff, i4, i4, i4});
        multiStateImageTextView.j(0);
        settingsModule.p(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TopSettingLayout layout, CameraTopSettingsModule settingsModule, final MultiStateImageTextView multiStateImageTextView, final TopSettingController this$0, final Boolean bool) {
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        layout.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.t1
            @Override // java.lang.Runnable
            public final void run() {
                TopSettingController.O(TopSettingController.this, multiStateImageTextView, bool);
            }
        }, 80L);
        if (kotlin.jvm.internal.s.c(settingsModule.l().getValue(), Boolean.TRUE)) {
            multiStateImageTextView.h(1);
        } else {
            multiStateImageTextView.h(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MultiStateImageTextView multiStateImageTextView, Boolean it) {
        kotlin.jvm.internal.s.g(it, "it");
        multiStateImageTextView.h(it.booleanValue() ? 1 : 0);
        us.pinguo.foundation.statistics.a.u().E(it.booleanValue() ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MultiStateImageTextView darkCornerMsv, Boolean it) {
        kotlin.jvm.internal.s.g(darkCornerMsv, "darkCornerMsv");
        kotlin.jvm.internal.s.g(it, "it");
        int i2 = it.booleanValue() ? 0 : 8;
        darkCornerMsv.setVisibility(i2);
        VdsAgent.onSetViewVisibility(darkCornerMsv, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SwitchCompat switchCompat, CameraTopSettingsModule settingsModule, Boolean bool) {
        boolean booleanValue;
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        Boolean bool2 = Boolean.FALSE;
        if (kotlin.jvm.internal.s.c(bool, bool2)) {
            booleanValue = false;
        } else {
            Boolean value = settingsModule.e().getValue();
            if (value != null) {
                bool2 = value;
            }
            booleanValue = bool2.booleanValue();
        }
        switchCompat.setChecked(booleanValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TopSettingController this$0, CameraSwitchMode cameraSwitchMode) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.R(cameraSwitchMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(CameraTopSettingsModule settingsModule, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        if (kotlin.jvm.internal.s.c(settingsModule.i().getValue(), Boolean.FALSE)) {
            return;
        }
        CameraTopSettingsModule.w(settingsModule, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(CameraTopSettingsModule settingsModule, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        if (kotlin.jvm.internal.s.c(settingsModule.k().getValue(), Boolean.FALSE)) {
            return;
        }
        settingsModule.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(CameraTopSettingsModule settingsModule, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        if (kotlin.jvm.internal.s.c(settingsModule.h().getValue(), Boolean.FALSE)) {
            return;
        }
        CameraTopSettingsModule.u(settingsModule, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(CameraTopSettingsModule settingsModule, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        if (kotlin.jvm.internal.s.c(settingsModule.d().getValue(), Boolean.FALSE)) {
            return;
        }
        settingsModule.r(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MultiStateImageTextView multiStateImageTextView, Integer it) {
        kotlin.jvm.internal.s.g(it, "it");
        multiStateImageTextView.h(it.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final TopSettingController this$0, final MultiStateImageTextView multiStateImageTextView, CameraTopSettingsModule settingsModule, TopSettingLayout layout, final Boolean it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(settingsModule, "$settingsModule");
        kotlin.jvm.internal.s.h(layout, "$layout");
        kotlin.jvm.internal.s.g(it, "it");
        this$0.f9322h = it.booleanValue();
        Integer value = settingsModule.j().getValue();
        kotlin.jvm.internal.s.e(value);
        kotlin.jvm.internal.s.g(value, "settingsModule.flashStateLiveData.value!!");
        multiStateImageTextView.h(value.intValue());
        layout.postDelayed(new Runnable() { // from class: us.pinguo.camera2020.view.q1
            @Override // java.lang.Runnable
            public final void run() {
                TopSettingController.P(TopSettingController.this, multiStateImageTextView, it);
            }
        }, 80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MultiStateImageTextView multiStateImageTextView, Boolean bool) {
        multiStateImageTextView.g();
    }

    private final AutoTransition q() {
        return (AutoTransition) this.f9318d.getValue();
    }

    private final TransitionSet r() {
        return (TransitionSet) this.f9319e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TopSettingController$transitionListener$2.a s() {
        return (TopSettingController$transitionListener$2.a) this.f9320f.getValue();
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if ((this.a.getVisibility() == 0) && (event.c() == EventType.TOUCH_UP || event.c() == EventType.BACK_PRESS || event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.FLING)) {
            t();
            return true;
        }
        return false;
    }

    public final void Q() {
        if (this.a.getVisibility() == 0) {
            return;
        }
        this.a.show();
    }

    public final void t() {
        if (this.a.getVisibility() == 0) {
            this.a.a();
        }
    }

    public final void u() {
        if (this.a.getVisibility() == 0) {
            this.a.h();
        }
    }

    public final void v(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        TopSettingLayout topSettingLayout = this.a;
        int i2 = R.id.ivArrow;
        ImageView imageView = (ImageView) topSettingLayout._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(imageView, "settingLayout.ivArrow");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        Context context = this.a.getContext();
        kotlin.jvm.internal.s.g(context, "settingLayout.context");
        if (us.pinguo.edit2020.utils.d.f(context)) {
            layoutParams2.startToStart = -1;
            ViewParent parent = ((ImageView) this.a._$_findCachedViewById(i2)).getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            layoutParams2.endToEnd = ((ConstraintLayout) parent).getId();
            layoutParams2.setMarginEnd((int) view.getX());
        } else {
            layoutParams2.endToEnd = -1;
            ViewParent parent2 = ((ImageView) this.a._$_findCachedViewById(i2)).getParent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            layoutParams2.startToStart = ((ConstraintLayout) parent2).getId();
            layoutParams2.setMarginStart((int) view.getX());
        }
        imageView.setLayoutParams(layoutParams2);
    }

    public final boolean w() {
        return this.a.getVisibility() == 0;
    }
}
