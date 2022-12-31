package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import com.pinguo.camera360.test.DevelopModeActivity;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.camera360.ui.view.SettingItemMore;
import com.pinguo.camera360.ui.view.TitleView;
import java.io.File;
import java.util.Locale;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushPreference;
import us.pinguo.repository2020.ServiceControlRepository;
import us.pinguo.repository2020.entity.ServiceControlSwitch;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsAbouts extends BaseActivity implements TitleView.d, View.OnClickListener {
    private TitleBarLayout b;
    private TextView a = null;
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a(OptionsAbouts optionsAbouts) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File c = us.pinguo.util.v.c();
                File file = new File(c, ".pcache");
                if (!file.exists()) {
                    us.pinguo.util.l.e(c);
                }
                String str = new PushPreference(BaseApplication.d()).d("clientId", "NULL") + "\n" + us.pinguo.bigdata.f.a.e(BaseApplication.d()) + "\n" + us.pinguo.util.s.f(BaseApplication.d()) + "   " + us.pinguo.foundation.utils.i.a();
                us.pinguo.util.k.l(file, str);
                us.pinguo.common.log.a.k(str, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    private void initView() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781);
        this.b = titleBarLayout;
        titleBarLayout.setTiTleText(R.string.options_about);
        this.a = (TextView) findViewById(R.id.about_version);
        this.a.setText((getString(R.string.app_name_res_0x7f110062) + "  V9.9.27") + "(132099270)");
        SettingItemMore settingItemMore = (SettingItemMore) findViewById(R.id.option_item_about_privacy);
        settingItemMore.b().setText(R.string.options_privacy);
        settingItemMore.setOnClickListener(this);
        SettingItemMore settingItemMore2 = (SettingItemMore) findViewById(R.id.option_item_about_service_agreements_cloud);
        settingItemMore2.b().setText(R.string.options_service_sgreement);
        settingItemMore2.setOnClickListener(this);
        SettingItemMore settingItemMore3 = (SettingItemMore) findViewById(R.id.option_item_about_permission_list);
        settingItemMore3.b().setText(R.string.options_permission_list);
        settingItemMore3.setOnClickListener(this);
        SettingItemMore settingItemMore4 = (SettingItemMore) findViewById(R.id.option_item_about_personal_information_list);
        settingItemMore4.b().setText(R.string.option_personal_information_list);
        settingItemMore4.setOnClickListener(this);
        SettingItemMore settingItemMore5 = (SettingItemMore) findViewById(R.id.option_item_about_information_share_list);
        settingItemMore5.b().setText(R.string.options_information_share_list);
        settingItemMore5.setOnClickListener(this);
        if (vStudio.Android.Camera360.guide.f.a.a.b()) {
            settingItemMore3.setVisibility(0);
            VdsAgent.onSetViewVisibility(settingItemMore3, 0);
            settingItemMore4.setVisibility(0);
            VdsAgent.onSetViewVisibility(settingItemMore4, 0);
            settingItemMore5.setVisibility(0);
            VdsAgent.onSetViewVisibility(settingItemMore5, 0);
        }
        SettingItemMore settingItemMore6 = (SettingItemMore) findViewById(R.id.option_item_about_license);
        settingItemMore6.b().setText(R.string.options_license);
        settingItemMore6.setOnClickListener(this);
        SettingItemMore settingItemMore7 = (SettingItemMore) findViewById(R.id.option_item_about_vip_notice);
        settingItemMore7.b().setText(R.string.options_subscr_notice);
        settingItemMore7.setOnClickListener(this);
        if (Locale.getDefault().toString().contains("zh_CN")) {
            settingItemMore6.setVisibility(0);
            VdsAgent.onSetViewVisibility(settingItemMore6, 0);
            return;
        }
        settingItemMore6.setVisibility(8);
        VdsAgent.onSetViewVisibility(settingItemMore6, 8);
    }

    private void q0() {
        us.pinguo.foundation.utils.f.b(new a(this));
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void W() {
        finish();
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void f() {
        finish();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        ServiceControlSwitch a2 = ServiceControlRepository.a.a();
        int id = view.getId();
        if (id != R.id.iv_options_about_logo) {
            switch (id) {
                case R.id.option_item_about_information_share_list /* 2131297581 */:
                    Intent intent = new Intent();
                    intent.putExtra("towhere", "information_share_list");
                    intent.setClass(this, OptionsWebviewActivity.class);
                    startActivity(intent);
                    return;
                case R.id.option_item_about_license /* 2131297582 */:
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.camera360.com/license/index.html")));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                case R.id.option_item_about_permission_list /* 2131297583 */:
                    Intent intent2 = new Intent();
                    intent2.putExtra("towhere", "permission_list");
                    intent2.setClass(this, OptionsWebviewActivity.class);
                    startActivity(intent2);
                    return;
                case R.id.option_item_about_personal_information_list /* 2131297584 */:
                    Intent intent3 = new Intent();
                    intent3.putExtra("towhere", "personal_information_list");
                    intent3.setClass(this, OptionsWebviewActivity.class);
                    startActivity(intent3);
                    return;
                case R.id.option_item_about_privacy /* 2131297585 */:
                    CameraBusinessSettingModel.v().G("pref_privacy_update_date", a2 != null ? a2.getPrivacyUpdateDate().longValue() : 0L);
                    Intent intent4 = new Intent();
                    intent4.putExtra("towhere", VipHalfScreenController.URL_PRIVACY);
                    intent4.setClass(this, OptionsWebviewActivity.class);
                    startActivity(intent4);
                    return;
                case R.id.option_item_about_service_agreements_cloud /* 2131297586 */:
                    CameraBusinessSettingModel.v().G("pref_service_update_date", a2 != null ? a2.getServiceUpdateDate().longValue() : 0L);
                    startActivity(new Intent(this, OptionsWebviewActivity.class));
                    return;
                case R.id.option_item_about_vip_notice /* 2131297587 */:
                    Intent intent5 = new Intent();
                    intent5.putExtra("towhere", VipHalfScreenController.URL_SERVICE_PROTOCOL);
                    intent5.setClass(this, OptionsWebviewActivity.class);
                    startActivity(intent5);
                    return;
                default:
                    return;
            }
        } else if (us.pinguo.foundation.d.f10987f) {
            startActivity(new Intent(this, DevelopModeActivity.class));
            q0();
        } else {
            int i2 = this.c + 1;
            this.c = i2;
            if (i2 >= 10) {
                this.c = -10000;
                q0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_about);
        initView();
        this.c = 0;
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        if (menuItem.getItemId() != 16908332) {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
            return onOptionsItemSelected;
        }
        finish();
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
    }
}
