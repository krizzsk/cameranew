package com.pinguo.camera360.camera.options;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.camera360.ui.view.SettingItemSwitcher;
import com.pinguo.camera360.ui.view.TitleView;
import com.tapjoy.TJAdUnitConstants;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsRecommendation extends BaseActivity implements TitleView.d, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private com.pinguo.camera360.k.a.a.a.c a = null;
    private SwitchCompat b = null;

    private void initView() {
        ((TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781)).setTiTleText(R.string.options_recommendation);
        SettingItemSwitcher settingItemSwitcher = (SettingItemSwitcher) findViewById(R.id.option_item_recommendation);
        SwitchCompat a = settingItemSwitcher.a();
        this.b = a;
        a.setId(R.id.id_option_item_recommendation_checkbox);
        settingItemSwitcher.setProfile(R.string.option_item_recommendation);
        settingItemSwitcher.b().setText(R.string.option_content_recommendation);
        settingItemSwitcher.setOnClickListener(this);
        this.b.setOnCheckedChangeListener(this);
    }

    private void q0() {
        this.a = new com.pinguo.camera360.k.a.a.a.c("pref_personalized_recommendation_key", getResources().getString(R.string.pref_personalized_recommendation_title));
        Resources resources = getResources();
        String[] stringArray = resources.getStringArray(R.array.switcher_entriyvalues);
        String[] stringArray2 = resources.getStringArray(R.array.switcher_entries);
        this.a.m(stringArray);
        this.a.l(stringArray2);
        this.a.j(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void s0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -2) {
            this.b.setChecked(true);
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            this.a.q(false);
            this.b.setChecked(false);
            dialogInterface.dismiss();
        }
    }

    private void t0() {
        this.b.setChecked(this.a.p());
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void W() {
        finish();
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void f() {
        finish();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    @Instrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        com.pinguo.camera360.k.a.a.a.c cVar;
        VdsAgent.onCheckedChanged(this, compoundButton, z);
        if (compoundButton.getId() == R.id.id_option_item_recommendation_checkbox && (cVar = this.a) != null) {
            if (!z) {
                us.pinguo.foundation.utils.w.i(this, R.string.dialog_recommendation_close_hint, R.string.pgcommon_ok, R.string.pgcommon_cancel, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.options.f0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        OptionsRecommendation.this.s0(dialogInterface, i2);
                    }
                });
                return;
            }
            cVar.q(true);
            this.b.setChecked(true);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        com.pinguo.camera360.k.a.a.a.c cVar;
        VdsAgent.onClick(this, view);
        if (view.getId() != R.id.option_item_recommendation || (cVar = this.a) == null || this.b == null) {
            return;
        }
        cVar.q(!cVar.p());
        SwitchCompat switchCompat = this.b;
        switchCompat.setChecked(!switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_recommendation);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CameraBusinessSettingModel.v().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.pinguo.camera360.camera.businessPrefSetting.a.f();
        q0();
        t0();
    }
}
