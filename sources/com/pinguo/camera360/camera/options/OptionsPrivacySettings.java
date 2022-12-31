package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.ui.TitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.permissionlib.PermissionManager;
import vStudio.Android.Camera360.R;
/* compiled from: OptionsPrivacySettings.kt */
/* loaded from: classes3.dex */
public final class OptionsPrivacySettings extends BaseActivity implements View.OnClickListener {
    public Map<Integer, View> a = new LinkedHashMap();
    private PermissionManager b;

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

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.clPrivacySetting) {
            startActivity(new Intent(this, OptionsCancelPrivacySetting.class));
        } else if (valueOf != null && valueOf.intValue() == R.id.clRecommendation) {
            Intent intent = new Intent();
            intent.setClassName(this, "com.pinguo.camera360.camera.options.OptionsRecommendation");
            startActivity(intent);
        } else {
            us.pinguo.inspire.util.u.a.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_privacy_settings);
        this.b = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clCameraPermissionSetting)).setOnClickListener(this);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clAlbumPermissionSetting)).setOnClickListener(this);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clMicrophonePermissionSetting)).setOnClickListener(this);
        ((ConstraintLayout) _$_findCachedViewById(R.id.clLocationPermissionSetting)).setOnClickListener(this);
        int i2 = R.id.clRecommendation;
        ((ConstraintLayout) _$_findCachedViewById(i2)).setOnClickListener(this);
        ConstraintLayout clRecommendation = (ConstraintLayout) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(clRecommendation, "clRecommendation");
        com.pinguo.camera360.utils.a aVar = com.pinguo.camera360.utils.a.a;
        int i3 = aVar.b() ? 0 : 8;
        clRecommendation.setVisibility(i3);
        VdsAgent.onSetViewVisibility(clRecommendation, i3);
        TextView txtRecommendation = (TextView) _$_findCachedViewById(R.id.txtRecommendation);
        kotlin.jvm.internal.s.g(txtRecommendation, "txtRecommendation");
        int i4 = aVar.b() ? 0 : 8;
        txtRecommendation.setVisibility(i4);
        VdsAgent.onSetViewVisibility(txtRecommendation, i4);
        int i5 = R.id.clPrivacySetting;
        ((ConstraintLayout) _$_findCachedViewById(i5)).setOnClickListener(this);
        if (vStudio.Android.Camera360.guide.f.a.a.b()) {
            ConstraintLayout clPrivacySetting = (ConstraintLayout) _$_findCachedViewById(i5);
            kotlin.jvm.internal.s.g(clPrivacySetting, "clPrivacySetting");
            clPrivacySetting.setVisibility(0);
            VdsAgent.onSetViewVisibility(clPrivacySetting, 0);
            TextView txtPrivacyDesc = (TextView) _$_findCachedViewById(R.id.txtPrivacyDesc);
            kotlin.jvm.internal.s.g(txtPrivacyDesc, "txtPrivacyDesc");
            txtPrivacyDesc.setVisibility(0);
            VdsAgent.onSetViewVisibility(txtPrivacyDesc, 0);
        }
        ((TitleBarLayout) _$_findCachedViewById(R.id.title_bar_layout)).setTiTleText(R.string.options_privacy_setting);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TextView txtCameraPermissionSettingNow = (TextView) _$_findCachedViewById(R.id.txtCameraPermissionSettingNow);
        kotlin.jvm.internal.s.g(txtCameraPermissionSettingNow, "txtCameraPermissionSettingNow");
        PermissionManager permissionManager = this.b;
        if (permissionManager != null) {
            int i2 = permissionManager.p("android.permission.CAMERA") ^ true ? 0 : 8;
            txtCameraPermissionSettingNow.setVisibility(i2);
            VdsAgent.onSetViewVisibility(txtCameraPermissionSettingNow, i2);
            TextView txtAlbumPermissionSettingNow = (TextView) _$_findCachedViewById(R.id.txtAlbumPermissionSettingNow);
            kotlin.jvm.internal.s.g(txtAlbumPermissionSettingNow, "txtAlbumPermissionSettingNow");
            PermissionManager permissionManager2 = this.b;
            if (permissionManager2 != null) {
                int i3 = permissionManager2.p("android.permission.WRITE_EXTERNAL_STORAGE") ^ true ? 0 : 8;
                txtAlbumPermissionSettingNow.setVisibility(i3);
                VdsAgent.onSetViewVisibility(txtAlbumPermissionSettingNow, i3);
                TextView txtMicrophonePermissionSettingNow = (TextView) _$_findCachedViewById(R.id.txtMicrophonePermissionSettingNow);
                kotlin.jvm.internal.s.g(txtMicrophonePermissionSettingNow, "txtMicrophonePermissionSettingNow");
                PermissionManager permissionManager3 = this.b;
                if (permissionManager3 != null) {
                    int i4 = permissionManager3.p("android.permission.RECORD_AUDIO") ^ true ? 0 : 8;
                    txtMicrophonePermissionSettingNow.setVisibility(i4);
                    VdsAgent.onSetViewVisibility(txtMicrophonePermissionSettingNow, i4);
                    TextView txtLocationPermissionSettingNow = (TextView) _$_findCachedViewById(R.id.txtLocationPermissionSettingNow);
                    kotlin.jvm.internal.s.g(txtLocationPermissionSettingNow, "txtLocationPermissionSettingNow");
                    PermissionManager permissionManager4 = this.b;
                    if (permissionManager4 != null) {
                        int i5 = permissionManager4.p("android.permission.ACCESS_COARSE_LOCATION") ^ true ? 0 : 8;
                        txtLocationPermissionSettingNow.setVisibility(i5);
                        VdsAgent.onSetViewVisibility(txtLocationPermissionSettingNow, i5);
                        return;
                    }
                    kotlin.jvm.internal.s.z("permissionManager");
                    throw null;
                }
                kotlin.jvm.internal.s.z("permissionManager");
                throw null;
            }
            kotlin.jvm.internal.s.z("permissionManager");
            throw null;
        }
        kotlin.jvm.internal.s.z("permissionManager");
        throw null;
    }
}
