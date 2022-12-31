package com.pinguo.camera360.camera.options;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.camera360.ui.view.SettingItemSwitcher;
import com.pinguo.camera360.ui.view.TitleView;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.domain.OptionsSettingEntry;
import us.pinguo.user.User;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsNotificationSettings extends BaseActivity implements TitleView.d, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private SettingItemSwitcher a;
    private SettingItemSwitcher b;
    private SettingItemSwitcher c;

    /* renamed from: d  reason: collision with root package name */
    private SettingItemSwitcher f6229d;

    /* renamed from: i  reason: collision with root package name */
    private OptionsSettingEntry f6234i;

    /* renamed from: j  reason: collision with root package name */
    private com.pinguo.camera360.camera.options.m0.f f6235j;

    /* renamed from: l  reason: collision with root package name */
    private Dialog f6237l;

    /* renamed from: e  reason: collision with root package name */
    private SwitchCompat f6230e = null;

    /* renamed from: f  reason: collision with root package name */
    private SwitchCompat f6231f = null;

    /* renamed from: g  reason: collision with root package name */
    private SwitchCompat f6232g = null;

    /* renamed from: h  reason: collision with root package name */
    private SwitchCompat f6233h = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6236k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements com.pinguo.camera360.camera.options.m0.e {
        a() {
        }

        @Override // com.pinguo.camera360.camera.options.m0.e
        public void a(OptionsSettingEntry optionsSettingEntry) {
            us.pinguo.common.log.a.c("OptionsSettingEntry is:" + optionsSettingEntry, new Object[0]);
            if (optionsSettingEntry == null) {
                return;
            }
            String userId = s0.getInstance().getUserId();
            CameraBusinessSettingModel.v().D("key_notify_set_comment", userId, optionsSettingEntry.comment == 1);
            CameraBusinessSettingModel.v().D("key_notify_set_praise", userId, optionsSettingEntry.favour == 1);
            CameraBusinessSettingModel.v().D("key_notify_set_aitme", userId, optionsSettingEntry.atMe == 1);
            CameraBusinessSettingModel.v().D("key_notify_set_new_fans", userId, optionsSettingEntry.newFans == 1);
            OptionsNotificationSettings.this.u0();
            if (OptionsNotificationSettings.this.f6237l != null) {
                OptionsNotificationSettings.this.f6237l.dismiss();
            }
        }

        @Override // com.pinguo.camera360.camera.options.m0.e
        public void b(Throwable th) {
            if (OptionsNotificationSettings.this.f6237l != null) {
                OptionsNotificationSettings.this.f6237l.dismiss();
            }
            us.pinguo.common.log.a.f(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements com.pinguo.camera360.camera.options.m0.e {
        b() {
        }

        @Override // com.pinguo.camera360.camera.options.m0.e
        public void a(OptionsSettingEntry optionsSettingEntry) {
            OptionsNotificationSettings.this.f6234i = optionsSettingEntry;
        }

        @Override // com.pinguo.camera360.camera.options.m0.e
        public void b(Throwable th) {
            us.pinguo.common.log.a.f(th);
        }
    }

    private void initView() {
        ((TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781)).setTiTleText(R.string.settings_notification_sets_title);
        this.a = (SettingItemSwitcher) findViewById(R.id.option_item_comment);
        this.b = (SettingItemSwitcher) findViewById(R.id.option_item_praise);
        this.c = (SettingItemSwitcher) findViewById(R.id.option_item_aitme);
        this.f6229d = (SettingItemSwitcher) findViewById(R.id.option_item_new_fans);
        this.a.b().setText(R.string.option_item_comment);
        this.b.b().setText(R.string.option_item_praise);
        this.c.b().setText(R.string.option_item_aitme);
        this.f6229d.b().setText(R.string.option_item_new_fans);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.f6229d.setOnClickListener(this);
        this.f6230e = this.a.a();
        this.f6231f = this.b.a();
        this.f6232g = this.c.a();
        this.f6233h = this.f6229d.a();
        this.f6230e.setId(R.id.id_option_item_notification_comment);
        this.f6231f.setId(R.id.id_option_item_notification_praise);
        this.f6232g.setId(R.id.id_option_item_notification_aitme);
        this.f6233h.setId(R.id.id_option_item_notification_newfans);
        this.f6230e.setOnCheckedChangeListener(this);
        this.f6231f.setOnCheckedChangeListener(this);
        this.f6232g.setOnCheckedChangeListener(this);
        this.f6233h.setOnCheckedChangeListener(this);
    }

    private void t0() {
        OptionsSettingEntry optionsSettingEntry = new OptionsSettingEntry();
        this.f6234i = optionsSettingEntry;
        optionsSettingEntry.comment = CameraBusinessSettingModel.v().f("key_notify_set_comment", false) ? 1 : 0;
        this.f6234i.atMe = CameraBusinessSettingModel.v().f("key_notify_set_aitme", false) ? 1 : 0;
        this.f6234i.newFans = CameraBusinessSettingModel.v().f("key_notify_set_new_fans", false) ? 1 : 0;
        this.f6234i.favour = CameraBusinessSettingModel.v().f("key_notify_set_praise", false) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.f6236k = true;
        String userId = s0.getInstance().getUserId();
        this.f6230e.setChecked(CameraBusinessSettingModel.v().e("key_notify_set_comment", userId, false));
        this.f6231f.setChecked(CameraBusinessSettingModel.v().e("key_notify_set_praise", userId, false));
        this.f6232g.setChecked(CameraBusinessSettingModel.v().e("key_notify_set_aitme", userId, false));
        this.f6233h.setChecked(CameraBusinessSettingModel.v().e("key_notify_set_new_fans", userId, false));
        this.f6236k = false;
    }

    private void v0() {
        new com.pinguo.camera360.camera.options.m0.f().b(new a());
    }

    private void w0(OptionsSettingEntry optionsSettingEntry) {
        this.f6235j.h(optionsSettingEntry, new b());
    }

    private void x0() {
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
        VdsAgent.onCheckedChanged(this, compoundButton, z);
        String userId = s0.getInstance().getUserId();
        switch (compoundButton.getId()) {
            case R.id.id_option_item_notification_aitme /* 2131297099 */:
                this.f6234i.atMe = this.f6232g.isChecked() ? 1 : 0;
                CameraBusinessSettingModel.v().D("key_notify_set_aitme", userId, z);
                break;
            case R.id.id_option_item_notification_comment /* 2131297100 */:
                this.f6234i.comment = this.f6230e.isChecked() ? 1 : 0;
                CameraBusinessSettingModel.v().D("key_notify_set_comment", userId, z);
                break;
            case R.id.id_option_item_notification_newfans /* 2131297101 */:
                this.f6234i.newFans = this.f6233h.isChecked() ? 1 : 0;
                CameraBusinessSettingModel.v().D("key_notify_set_new_fans", userId, z);
                break;
            case R.id.id_option_item_notification_praise /* 2131297102 */:
                this.f6234i.favour = this.f6231f.isChecked() ? 1 : 0;
                CameraBusinessSettingModel.v().D("key_notify_set_praise", userId, z);
                break;
        }
        if (this.f6236k) {
            return;
        }
        w0(this.f6234i);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        if (id != R.id.option_item_praise) {
            switch (id) {
                case R.id.option_item_aitme /* 2131297588 */:
                    SwitchCompat switchCompat = this.f6232g;
                    if (switchCompat == null) {
                        return;
                    }
                    switchCompat.setChecked(!switchCompat.isChecked());
                    return;
                case R.id.option_item_comment /* 2131297589 */:
                    SwitchCompat switchCompat2 = this.f6230e;
                    if (switchCompat2 == null) {
                        return;
                    }
                    switchCompat2.setChecked(!switchCompat2.isChecked());
                    return;
                case R.id.option_item_new_fans /* 2131297590 */:
                    SwitchCompat switchCompat3 = this.f6233h;
                    if (switchCompat3 == null) {
                        return;
                    }
                    switchCompat3.setChecked(!switchCompat3.isChecked());
                    return;
                default:
                    return;
            }
        }
        SwitchCompat switchCompat4 = this.f6231f;
        if (switchCompat4 == null) {
            return;
        }
        switchCompat4.setChecked(!switchCompat4.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t0();
        setContentView(R.layout.layout_option_notification_settings);
        this.f6235j = new com.pinguo.camera360.camera.options.m0.f();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.pinguo.camera360.camera.options.m0.f fVar = this.f6235j;
        if (fVar != null) {
            fVar.g();
        }
        Dialog dialog = this.f6237l;
        if (dialog != null) {
            dialog.dismiss();
            this.f6237l = null;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        u0();
        x0();
        if (User.d().n()) {
            this.f6237l = us.pinguo.foundation.utils.w.p(this, -999);
            v0();
        }
    }
}
