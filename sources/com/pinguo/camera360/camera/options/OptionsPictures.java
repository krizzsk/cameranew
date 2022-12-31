package com.pinguo.camera360.camera.options;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.options.OptionsPictures;
import com.pinguo.camera360.ui.TitleBarLayout;
import com.pinguo.camera360.ui.view.SettingItemMore;
import com.pinguo.camera360.ui.view.SettingItemSwitcher;
import com.pinguo.camera360.ui.view.TitleView;
import com.tencent.matrix.report.Issue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.dialog.SinglePermissionDialog;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.o0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.permissionlib.PermissionManager;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsPictures extends BaseActivity implements TitleView.d, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private com.pinguo.camera360.k.a.a.a.c f6239e;

    /* renamed from: g  reason: collision with root package name */
    private AsyncTask<Object, Object, Boolean> f6241g;
    private com.pinguo.camera360.k.a.a.a.c a = null;
    private us.pinguo.foundation.h b = null;
    private SwitchCompat c = null;

    /* renamed from: d  reason: collision with root package name */
    private SwitchCompat f6238d = null;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.foundation.ui.e f6240f = null;

    /* renamed from: h  reason: collision with root package name */
    private AlertDialog f6242h = null;

    /* renamed from: i  reason: collision with root package name */
    SettingItemMore f6243i = null;

    /* renamed from: j  reason: collision with root package name */
    private TextView f6244j = null;

    /* renamed from: k  reason: collision with root package name */
    private PermissionManager f6245k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements us.pinguo.foundation.dialog.c {
        final /* synthetic */ String[] a;

        a(String[] strArr) {
            this.a = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(String[] strArr, String[] strArr2) {
            if (strArr.length > 0) {
                us.pinguo.foundation.statistics.h.b.e0("yes");
                us.pinguo.librouter.b.b.b().getInterface().d(true);
                OptionsPictures.this.a.q(true);
                OptionsPictures.this.c.setChecked(true);
                return;
            }
            us.pinguo.foundation.statistics.h.b.e0("no");
            us.pinguo.librouter.b.b.b().getInterface().d(false);
            OptionsPictures.this.a.q(false);
            OptionsPictures.this.c.setChecked(false);
        }

        @Override // us.pinguo.foundation.dialog.c
        public void a() {
            us.pinguo.foundation.statistics.h.b.e0("no");
            us.pinguo.librouter.b.b.b().getInterface().d(false);
            OptionsPictures.this.a.q(false);
            OptionsPictures.this.c.setChecked(false);
        }

        @Override // us.pinguo.foundation.dialog.c
        public void b() {
            OptionsPictures.this.f6245k.u(new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.camera.options.a0
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr, String[] strArr2) {
                    OptionsPictures.a.this.d(strArr, strArr2);
                }
            }, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends AsyncTask<Object, Object, Boolean> {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            SystemClock.sleep(500L);
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            String str = File.separator;
            sb.append(str);
            sb.append("DCIM");
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (!file.exists() && !file.mkdirs()) {
                return Boolean.FALSE;
            }
            File file2 = new File(sb2 + str + "test.txt");
            try {
                if (!file2.createNewFile()) {
                    return Boolean.FALSE;
                }
                if (file2.exists() && file2.delete()) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            } catch (IOException unused) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.foundation.utils.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (OptionsPictures.this.f6242h != null) {
                OptionsPictures.this.f6242h.dismiss();
            }
            boolean z = bool != null && bool.booleanValue();
            if (z) {
                CameraBusinessSettingModel.v().E("key_show_kitkat_extcard_dialog", true);
            } else {
                Toast makeText = Toast.makeText(OptionsPictures.this, (int) R.string.ex_sdcard_not_permissions, 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            OptionsPictures.this.K0(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(String[] strArr, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            this.f6245k.t(new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.camera.options.z
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr2, String[] strArr3) {
                    OptionsPictures.this.A0(strArr2, strArr3);
                }
            }, true, strArr);
            return;
        }
        us.pinguo.foundation.statistics.h.b.e0("no");
        us.pinguo.librouter.b.b.b().getInterface().d(false);
        this.a.q(false);
        this.c.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(String[] strArr, String[] strArr2) {
        if (strArr.length > 0) {
            us.pinguo.inspire.util.u.f();
            v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(String str, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        dialogInterface.dismiss();
        if (i2 == -1) {
            this.f6245k.u(new us.pinguo.permissionlib.c.a() { // from class: com.pinguo.camera360.camera.options.d0
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr, String[] strArr2) {
                    OptionsPictures.this.E0(strArr, strArr2);
                }
            }, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ boolean I0(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            CameraBusinessSettingModel.v().Q(us.pinguo.image.saver.c.c);
            this.b.o(itemId);
        } else {
            Intent intent = new Intent(this, OptionsSavePath.class);
            intent.putExtra("select_which", itemId);
            if (itemId == 1) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory == null || !externalStorageDirectory.exists()) {
                    return true;
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                } else {
                    str = us.pinguo.image.saver.c.b;
                }
                intent.putExtra("select_root", str);
                startActivityForResult(intent, 10);
            } else if (itemId == 2) {
                o0 d2 = o0.d(BaseApplication.d());
                if (!d2.f()) {
                    us.pinguo.foundation.ui.e eVar = new us.pinguo.foundation.ui.e(this, (int) R.string.no_storage_save_path, 0);
                    this.f6240f = eVar;
                    eVar.d();
                    return true;
                }
                intent.putExtra("select_root", d2.c());
                startActivityForResult(intent, 10);
            }
        }
        return true;
    }

    private void J0() {
        us.pinguo.foundation.statistics.h.b.T();
        this.f6245k.w("android.permission.ACCESS_FINE_LOCATION");
        final String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        if (this.f6245k.o("android.permission.ACCESS_FINE_LOCATION")) {
            us.pinguo.permissionlib.a.a.c(us.pinguo.inspire.util.u.b(this.f6245k), this, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.options.c0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    OptionsPictures.this.C0(strArr, dialogInterface, i2);
                }
            });
            return;
        }
        SinglePermissionDialog singlePermissionDialog = new SinglePermissionDialog();
        singlePermissionDialog.e0(new a(strArr));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        singlePermissionDialog.show(supportFragmentManager, Issue.ISSUE_REPORT_TAG);
        VdsAgent.showDialogFragment(singlePermissionDialog, supportFragmentManager, Issue.ISSUE_REPORT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(boolean z) {
        if (!z) {
            this.b.a(x0(false));
        } else {
            this.b.a(x0(true));
        }
        us.pinguo.foundation.utils.w.t(this, this.b, this.f6244j, new PopupMenu.OnMenuItemClickListener() { // from class: com.pinguo.camera360.camera.options.e0
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return OptionsPictures.this.I0(menuItem);
            }
        });
    }

    private void L0() {
        this.c.setChecked(this.a.p());
        this.f6238d.setChecked(this.f6239e.p());
        this.f6244j.setText(CameraBusinessSettingModel.v().r());
    }

    private void initView() {
        ((TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781)).setTiTleText(R.string.picture_save_settings);
        SettingItemMore settingItemMore = (SettingItemMore) findViewById(R.id.option_item_picture_save_path);
        this.f6243i = settingItemMore;
        TextView a2 = settingItemMore.a();
        this.f6244j = a2;
        a2.setVisibility(0);
        VdsAgent.onSetViewVisibility(a2, 0);
        SettingItemSwitcher settingItemSwitcher = (SettingItemSwitcher) findViewById(R.id.option_item_picture_gps);
        SwitchCompat a3 = settingItemSwitcher.a();
        this.c = a3;
        a3.setId(R.id.id_option_item_picture_gps_checkbox);
        if ((us.pinguo.foundation.utils.b0.d() || us.pinguo.foundation.utils.b0.c()) && us.pinguo.util.c.f12476j) {
            settingItemSwitcher.setDescription(R.string.location_hint_before_m_for_oppo_vivo);
        }
        SettingItemSwitcher settingItemSwitcher2 = (SettingItemSwitcher) findViewById(R.id.option_item_picture_save_org);
        SwitchCompat a4 = settingItemSwitcher2.a();
        this.f6238d = a4;
        a4.setId(R.id.id_option_item_picture_save_org_checkbox);
        this.f6243i.b().setText(R.string.pref_camera_save_type_title);
        settingItemSwitcher.b().setText(R.string.options_recordlocation);
        settingItemSwitcher2.b().setText(R.string.option_item_save_org_path);
        this.f6243i.setOnClickListener(this);
        settingItemSwitcher.setOnClickListener(this);
        settingItemSwitcher2.setOnClickListener(this);
        this.c.setOnCheckedChangeListener(this);
        this.f6238d.setOnCheckedChangeListener(this);
    }

    private void v0() {
        Context d2 = BaseApplication.d();
        String c = o0.d(d2).c();
        if (us.pinguo.util.c.f12471e && o0.d(d2).f() && c != null) {
            AsyncTask<Object, Object, Boolean> asyncTask = this.f6241g;
            if (asyncTask == null || asyncTask.getStatus() == AsyncTask.Status.FINISHED) {
                this.f6242h = us.pinguo.foundation.utils.w.r(this, R.string.ex_sdcard_permissions_check, R.string.ex_sdcard_permissions_check_title);
                this.f6241g = new b(c).execute(new Object[0]);
                return;
            }
            return;
        }
        K0(true);
    }

    private boolean w0() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(ActivityRecorder.getInstance().d(), "android.permission.ACCESS_FINE_LOCATION");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(us.pinguo.foundation.e.b(), "android.permission.ACCESS_COARSE_LOCATION");
        if (checkSelfPermission == 0 || checkSelfPermission2 == 0) {
            return true;
        }
        J0();
        return false;
    }

    private List<String> x0(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
        if (Environment.getExternalStorageState().equals("mounted")) {
            arrayList.add("phone");
        }
        o0 d2 = o0.d(BaseApplication.d());
        if (z && d2.f()) {
            arrayList.add("sdcard");
        }
        return arrayList;
    }

    private void y0() {
        this.a = (com.pinguo.camera360.k.a.a.a.c) com.pinguo.camera360.camera.businessPrefSetting.a.a("pref_camera_recordlocation_key");
        this.f6239e = (com.pinguo.camera360.k.a.a.a.c) com.pinguo.camera360.camera.businessPrefSetting.a.a("pref_camera_saveorg_key");
        us.pinguo.foundation.h a2 = com.pinguo.camera360.camera.businessPrefSetting.a.a("pref_camera_save_type_key");
        this.b = a2;
        if (a2 != null) {
            a2.a(x0(true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(String[] strArr, String[] strArr2) {
        if (strArr.length > 0) {
            us.pinguo.foundation.statistics.h.b.e0("yes");
            us.pinguo.librouter.b.b.b().getInterface().d(true);
            this.a.q(true);
            this.c.setChecked(true);
            return;
        }
        us.pinguo.foundation.statistics.h.b.e0("no");
        us.pinguo.librouter.b.b.b().getInterface().d(false);
        this.a.q(false);
        this.c.setChecked(false);
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void W() {
        finish();
    }

    @Override // com.pinguo.camera360.ui.view.TitleView.d
    public void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f6245k.r(i2, i3, intent);
        if (i3 == R.layout.options_save_path) {
            us.pinguo.foundation.h hVar = this.b;
            if (hVar != null) {
                hVar.o(intent.getExtras().getInt("select_which"));
            }
            if (intent != null) {
                this.f6244j.setText(intent.getExtras().getString("pic_save_path"));
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    @Instrumented
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        VdsAgent.onCheckedChanged(this, compoundButton, z);
        switch (compoundButton.getId()) {
            case R.id.id_option_item_picture_gps_checkbox /* 2131297106 */:
                com.pinguo.camera360.k.a.a.a.c cVar = this.a;
                if (cVar == null) {
                    return;
                }
                if (z) {
                    if (w0()) {
                        us.pinguo.librouter.b.b.b().getInterface().d(true);
                        this.a.q(true);
                        return;
                    }
                    return;
                }
                cVar.q(false);
                return;
            case R.id.id_option_item_picture_save_org_checkbox /* 2131297107 */:
                com.pinguo.camera360.k.a.a.a.c cVar2 = this.f6239e;
                if (cVar2 == null) {
                    return;
                }
                cVar2.q(z);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        switch (view.getId()) {
            case R.id.option_item_picture_gps /* 2131297591 */:
                com.pinguo.camera360.k.a.a.a.c cVar = this.a;
                if (cVar == null || this.c == null) {
                    return;
                }
                if (!cVar.p()) {
                    this.a.q(false);
                    SwitchCompat switchCompat = this.c;
                    switchCompat.setChecked(true ^ switchCompat.isChecked());
                    return;
                } else if (w0()) {
                    us.pinguo.librouter.b.b.b().getInterface().d(true);
                    this.a.q(true);
                    SwitchCompat switchCompat2 = this.c;
                    switchCompat2.setChecked(true ^ switchCompat2.isChecked());
                    return;
                } else {
                    return;
                }
            case R.id.option_item_picture_save_org /* 2131297592 */:
                com.pinguo.camera360.k.a.a.a.c cVar2 = this.f6239e;
                if (cVar2 == null || this.f6238d == null) {
                    return;
                }
                cVar2.q(!cVar2.p());
                SwitchCompat switchCompat3 = this.f6238d;
                switchCompat3.setChecked(true ^ switchCompat3.isChecked());
                return;
            case R.id.option_item_picture_save_path /* 2131297593 */:
                if (!this.f6245k.p("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    us.pinguo.permissionlib.b.a d2 = us.pinguo.inspire.util.u.d(this.f6245k);
                    this.f6245k.w("android.permission.WRITE_EXTERNAL_STORAGE");
                    us.pinguo.permissionlib.a.a.c(d2, this, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.options.b0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            OptionsPictures.this.G0(r2, dialogInterface, i2);
                        }
                    });
                    return;
                }
                v0();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_option_picture);
        initView();
        this.f6245k = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f6245k.d();
        this.f6245k = null;
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
        CameraBusinessSettingModel.v().b();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.f6245k.s(i2, strArr, iArr);
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f6245k.v();
        com.pinguo.camera360.camera.businessPrefSetting.a.f();
        y0();
        L0();
    }
}
