package com.pinguo.camera360.camera.options;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.lib.ui.InterceptTouchEventMaskView;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: OptionsWatermarkActivity.kt */
/* loaded from: classes3.dex */
public final class OptionsWatermarkActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TabLayout.d {
    private boolean b;
    public Map<Integer, View> a = new LinkedHashMap();
    private final int[] c = {R.id.fl_watermark_type1, R.id.fl_watermark_type2, R.id.fl_watermark_type3, R.id.fl_watermark_type7, R.id.fl_watermark_type4, R.id.fl_watermark_type5, R.id.fl_watermark_type6};

    /* renamed from: d  reason: collision with root package name */
    private final int[] f6254d = {R.drawable.water_mark1, R.drawable.water_mark2, R.drawable.water_mark3, R.drawable.water_mark7, R.drawable.water_mark4, R.drawable.water_mark5, R.drawable.water_mark6};

    private final void q0(int i2) {
        int i3 = this.f6254d[i2];
        if (i2 != 2 && i2 != 4) {
            ((ImageView) _$_findCachedViewById(R.id.imgWatermarkVertical)).setVisibility(8);
            int i4 = R.id.imgWaterMarkHorizontal;
            ((ImageView) _$_findCachedViewById(i4)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i4)).setImageResource(i3);
            return;
        }
        ((ImageView) _$_findCachedViewById(R.id.imgWaterMarkHorizontal)).setVisibility(8);
        int i5 = R.id.imgWatermarkVertical;
        ((ImageView) _$_findCachedViewById(i5)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i5)).setImageResource(i3);
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

    public final void initView() {
        Integer h2;
        kotlin.z.d q;
        int o;
        if (this.b) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.mask_view);
            _$_findCachedViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, 4);
            ((InterceptTouchEventMaskView) _$_findCachedViewById(R.id.fl_water_content)).setShouldIntercept(false);
        } else {
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.mask_view);
            _$_findCachedViewById2.setVisibility(0);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById2, 0);
            ((InterceptTouchEventMaskView) _$_findCachedViewById(R.id.fl_water_content)).setShouldIntercept(true);
        }
        ((TabLayout) _$_findCachedViewById(R.id.tab_watermark_style)).d(this);
        String u = CameraBusinessSettingModel.v().u();
        kotlin.jvm.internal.s.g(u, "instance().watermarkType");
        h2 = kotlin.text.s.h(u);
        int intValue = h2 == null ? 1 : h2.intValue();
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_watermark_style_collection, (ViewGroup) null);
        q = kotlin.collections.n.q(this.f6254d);
        o = kotlin.collections.v.o(q, 10);
        ArrayList arrayList = new ArrayList(o);
        Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.h0) it).nextInt();
            int i2 = R.id.tab_watermark_style;
            TabLayout.f F = ((TabLayout) _$_findCachedViewById(i2)).F();
            kotlin.jvm.internal.s.g(F, "tab_watermark_style.newTab()");
            F.o(inflate.findViewById(this.c[nextInt]));
            if (nextInt == intValue) {
                ((TabLayout) _$_findCachedViewById(i2)).g(F, true);
            } else {
                ((TabLayout) _$_findCachedViewById(i2)).g(F, false);
            }
            arrayList.add(kotlin.u.a);
        }
        q0(intValue);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    @Instrumented
    public void onCheckedChanged(CompoundButton buttonView, boolean z) {
        VdsAgent.onCheckedChanged(this, buttonView, z);
        kotlin.jvm.internal.s.h(buttonView, "buttonView");
        if (z) {
            this.b = true;
            CameraBusinessSettingModel.v().H("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
            View _$_findCachedViewById = _$_findCachedViewById(R.id.mask_view);
            _$_findCachedViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(_$_findCachedViewById, 4);
            ((InterceptTouchEventMaskView) _$_findCachedViewById(R.id.fl_water_content)).setShouldIntercept(false);
            return;
        }
        this.b = false;
        CameraBusinessSettingModel.v().H("key_watermark_new", "off");
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.mask_view);
        _$_findCachedViewById2.setVisibility(0);
        VdsAgent.onSetViewVisibility(_$_findCachedViewById2, 0);
        ((InterceptTouchEventMaskView) _$_findCachedViewById(R.id.fl_water_content)).setShouldIntercept(true);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View v) {
        VdsAgent.onClick(this, v);
        kotlin.jvm.internal.s.h(v, "v");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_watermark);
        this.b = kotlin.jvm.internal.s.c(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON, CameraBusinessSettingModel.v().t("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON));
        int i2 = R.id.title_bar_layout;
        ((TitleBarLayout) _$_findCachedViewById(i2)).setTiTleText(R.string.options_watermark);
        ((TitleBarLayout) _$_findCachedViewById(i2)).setTitleTextColor(Color.argb(255, 25, 25, 25));
        ((TitleBarLayout) _$_findCachedViewById(i2)).setTitleTextSize(us.pinguo.foundation.t.b.a.c(this, 20.0f));
        ((TitleBarLayout) _$_findCachedViewById(i2)).setLeftImageBtnRes(R.drawable.ic_camera_setting_back);
        int i3 = R.id.switchWatermark;
        ((SwitchCompat) _$_findCachedViewById(i3)).setChecked(this.b);
        ((SwitchCompat) _$_findCachedViewById(i3)).setOnCheckedChangeListener(this);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clWatermarkToggle)).setOnClickListener(this);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CameraBusinessSettingModel.v().b();
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(TabLayout.f fVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(TabLayout.f tab) {
        kotlin.jvm.internal.s.h(tab, "tab");
        View e2 = tab.e();
        if (e2 != null) {
            e2.setAlpha(1.0f);
        }
        int g2 = tab.g();
        CameraBusinessSettingModel.v().U(String.valueOf(g2));
        q0(g2);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(TabLayout.f fVar) {
        View e2 = fVar == null ? null : fVar.e();
        if (e2 == null) {
            return;
        }
        e2.setAlpha(0.6f);
    }
}
