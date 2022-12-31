package com.pinguo.camera360.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.AuthFailureError;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.request.GetUserInfo;
import com.pinguo.camera360.ui.view.SettingItemSwitcher;
import com.pinguo.camera360.vip.VipManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.camera360.shop.download.RequestIntervalPref;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.common.widget.sample.activity.SimpleActivity;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.hawkeye.debug.DebugSettingsActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class DevelopModeActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f6960h = false;
    private SwitchCompat a;
    private SwitchCompat b;
    private SwitchCompat c;

    /* renamed from: d  reason: collision with root package name */
    private SwitchCompat f6961d;

    /* renamed from: e  reason: collision with root package name */
    private SwitchCompat f6962e;

    /* renamed from: f  reason: collision with root package name */
    private SwitchCompat f6963f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f6964g;
    @BindView
    TextView mBtnAbTest;
    @BindView
    TextView mBtnCloneDb;
    @BindView
    TextView mBtnEditTest;
    @BindView
    TextView mBtnGetCameraInfo;
    @BindView
    TextView mBtnGetInfo;
    @BindView
    TextView mBtnInstallFilter;
    @BindView
    TextView mBtnPushTest;
    @BindView
    TextView mBtnUnityImport;
    @BindView
    SettingItemSwitcher mEnableBigDataSession;
    @BindView
    SettingItemSwitcher mEnablePgFaceDetector;
    @BindView
    SettingItemSwitcher mFpsLogItem;
    @BindView
    SettingItemSwitcher mGlFpsLogItem;
    @BindView
    TextView mHawkeyeDebugSettings;
    @BindView
    TextView mHawkeyeReport;
    @BindView
    TextView mLogoutAccount;
    @BindView
    TextView mPhotoInfoPage;
    @BindView
    TextView mSkyChange;
    @BindView
    TextView mUnBindMobile;
    @BindView
    TextView mVipUnsubscribe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            throw new IllegalArgumentException("重新启动");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends HttpStringRequest {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends j.a.c.b.d<Void> {
            a() {
            }

            @Override // j.a.c.b.d
            /* renamed from: a */
            public void onSuccess(Void r2) {
                if (((BaseActivity) DevelopModeActivity.this).pgDistroy) {
                    return;
                }
                us.pinguo.foundation.utils.k0.a.b("手机号解绑成功!!!");
                DevelopModeActivity.this.mUnBindMobile.setTextColor(-5592406);
                DevelopModeActivity.this.mUnBindMobile.setEnabled(false);
            }

            @Override // j.a.c.b.d
            public void onError(Exception exc) {
            }
        }

        b(int i2, String str) {
            super(i2, str);
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            hashMap.put(GuestProfileFragment.USER_ID, User.d().h().userId);
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            if (((BaseActivity) DevelopModeActivity.this).pgDistroy) {
                return;
            }
            boolean z = false;
            try {
                if (new JSONObject(str).optInt("status") == 200) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            if (z) {
                new GetUserInfo(DevelopModeActivity.this).get(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends HttpStringRequest {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a extends j.a.c.b.d<Void> {
            a() {
            }

            @Override // j.a.c.b.d
            /* renamed from: a */
            public void onSuccess(Void r2) {
                if (((BaseActivity) DevelopModeActivity.this).pgDistroy) {
                    return;
                }
                us.pinguo.foundation.utils.k0.a.b("账号注销成功!!!");
                DevelopModeActivity.this.mUnBindMobile.setTextColor(-5592406);
                DevelopModeActivity.this.mUnBindMobile.setEnabled(false);
            }

            @Override // j.a.c.b.d
            public void onError(Exception exc) {
            }
        }

        c(int i2, String str) {
            super(i2, str);
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            hashMap.put(GuestProfileFragment.USER_ID, User.d().h().userId);
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            if (((BaseActivity) DevelopModeActivity.this).pgDistroy) {
                return;
            }
            boolean z = false;
            try {
                if (new JSONObject(str).optInt("status") == 200) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            if (z) {
                new GetUserInfo(DevelopModeActivity.this).get(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        j.a.b.a.b.a.c(z);
        w0(this, "重新启动APP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        j.a.b.a.b.a.d(z);
        w0(this, "重新启动APP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        us.pinguo.foundation.base.e.e(this, "enable_pg_face_detector", z);
        w0(this, "重新启动APP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        us.pinguo.foundation.base.e.e(this, "enable_bigdata_session", z);
        w0(this, "重新启动APP");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        if (z) {
            us.pinguo.foundation.base.e.e(this, "jp_location", true);
        } else {
            us.pinguo.foundation.base.e.e(this, "jp_location", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void M0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        a1(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        b1(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        Z0(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ void S0(View view) {
        VdsAgent.lambdaOnClick(view);
        us.pinguo.foundation.d.f10992k = false;
        CameraBusinessSettingModel.v().E("key_vup_sub", false);
        VipManager.a.W(1);
        this.mVipUnsubscribe.setTextColor(us.pinguo.foundation.d.f10992k ? ViewCompat.MEASURED_STATE_MASK : -5592406);
        this.mVipUnsubscribe.setEnabled(us.pinguo.foundation.d.f10992k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0(View view) {
        VdsAgent.lambdaOnClick(view);
        v0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void V0(CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        f6960h = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(View view) {
        VdsAgent.lambdaOnClick(view);
        startActivity(new Intent(this, PayWallTestActivity.class));
    }

    private void Y0() {
        c cVar = new c(1, "https://itest.camera360.com/inner/user/destroyed");
        cVar.setRetryPolicy(us.pinguo.user.u0.b());
        cVar.execute();
    }

    private void Z0(boolean z) {
        if (z) {
            us.pinguo.foundation.base.e.e(this, "google_vip", true);
        } else {
            us.pinguo.foundation.base.e.e(this, "google_vip", false);
        }
        w0(this, "重新启动APP");
    }

    private void a1(boolean z) {
        if (z) {
            us.pinguo.foundation.base.e.e(this, "release_host", true);
        } else {
            us.pinguo.foundation.base.e.e(this, "release_host", false);
        }
        w0(this, "重新启动APP");
    }

    private void b1(boolean z) {
        if (z) {
            us.pinguo.foundation.base.e.e(this, "new_user", true);
        } else {
            us.pinguo.foundation.base.e.e(this, "new_user", false);
        }
        w0(this, "重新启动APP");
    }

    private void c1() {
        b bVar = new b(1, "https://itest.camera360.com/inner/user/resetMobile");
        bVar.setRetryPolicy(us.pinguo.user.u0.b());
        bVar.execute();
    }

    private boolean u0() {
        User.Info h2 = User.d().h();
        return (h2 == null || TextUtils.isEmpty(h2.userId) || TextUtils.isEmpty(h2.token) || TextUtils.isEmpty(h2.mobile)) ? false : true;
    }

    private void v0() {
        RequestIntervalPref.a.a();
        AdvPrefUtil.getInstance().clear();
        x0("缓存清理成功，重新启动", 1000L);
    }

    public static void w0(Context context, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        if (!TextUtils.isEmpty(str)) {
            TextView textView = new TextView(context);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setText(str);
            textView.setTextSize(2, 18.0f);
            textView.setPadding(us.pinguo.foundation.t.b.a.a(context, 25.0f), us.pinguo.foundation.t.b.a.a(context, 10.0f), 0, 0);
            linearLayout.addView(textView);
        }
        final TextView textView2 = new TextView(context);
        textView2.setTextSize(2, 30.0f);
        int a2 = us.pinguo.foundation.t.b.a.a(context, 30.0f);
        textView2.setPadding(a2, a2, a2, a2);
        textView2.setTextColor(SupportMenu.CATEGORY_MASK);
        textView2.setText("3");
        textView2.setGravity(17);
        linearLayout.addView(textView2);
        new AlertDialog.Builder(context).setView(linearLayout).setCancelable(false).show();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(4.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.test.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DevelopModeActivity.y0(textView2, valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        ofFloat.setDuration(2000L);
        ofFloat.start();
    }

    private void x0(final String str, long j2) {
        us.pinguo.foundation.utils.f.d(new Runnable() { // from class: com.pinguo.camera360.test.p
            @Override // java.lang.Runnable
            public final void run() {
                DevelopModeActivity.this.A0(str);
            }
        }, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void y0(TextView textView, ValueAnimator valueAnimator) {
        int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue > 0) {
            textView.setText(floatValue + "");
            return;
        }
        textView.setText("beng!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(String str) {
        w0(this, str);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    @SuppressLint({"SdCardPath"})
    public void onClick(View view) {
        SwitchCompat switchCompat;
        SwitchCompat switchCompat2;
        SwitchCompat switchCompat3;
        VdsAgent.onClick(this, view);
        if (us.pinguo.foundation.d.f10985d || us.pinguo.foundation.d.f10987f) {
            switch (view.getId()) {
                case R.id.btn_ab_test /* 2131296526 */:
                    startActivity(new Intent(this, ABActivity.class));
                    return;
                case R.id.btn_clone_fliter_db /* 2131296529 */:
                    us.pinguo.util.l.c(BaseApplication.d().getDatabasePath("filter.db"), new File("/sdcard/Camera360/testdb/filter.db"));
                    Toast makeText = Toast.makeText(this, "拷贝成功:/sdcard/Camera360/testdb/filter.db", 1);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                    return;
                case R.id.btn_edit_test /* 2131296531 */:
                    startActivity(new Intent(this, PhotoEditTestActivity.class));
                    return;
                case R.id.btn_filter_install /* 2131296534 */:
                    startActivity(new Intent(this, FilterInstallTestActivity.class));
                    return;
                case R.id.btn_get_camera_info /* 2131296537 */:
                    startActivity(new Intent(this, CameraInfoActivity.class));
                    return;
                case R.id.btn_get_info /* 2131296538 */:
                    Intent intent = new Intent(this, CameraInfoActivity.class);
                    intent.putExtra("type", "sysinfo");
                    startActivity(intent);
                    return;
                case R.id.btn_logout_account /* 2131296544 */:
                    Y0();
                    return;
                case R.id.btn_photo_info_page /* 2131296547 */:
                    startActivity(new Intent(this, ExifTestActivity.class));
                    return;
                case R.id.btn_push_test /* 2131296548 */:
                    startActivity(new Intent(this, PushTestActivity.class));
                    return;
                case R.id.btn_unbind_mobile /* 2131296552 */:
                    c1();
                    return;
                case R.id.btn_unity_import /* 2131296553 */:
                    startActivity(new Intent(this, UnityImportActivity.class));
                    return;
                case R.id.btn_widget_sample /* 2131296554 */:
                    startActivity(new Intent(this, SimpleActivity.class));
                    return;
                case R.id.hawkeye_debug_setting /* 2131297024 */:
                    startActivity(new Intent(this, DebugSettingsActivity.class));
                    return;
                case R.id.hawkeye_report /* 2131297025 */:
                    us.pinguo.hawkeye.b.f11145f.f();
                    return;
                case R.id.id_debug_url /* 2131297070 */:
                case R.id.option_debug_url /* 2131297575 */:
                    this.b.setChecked(!switchCompat.isChecked());
                    a1(this.b.isChecked());
                    v0();
                    return;
                case R.id.id_google_vip_enable /* 2131297075 */:
                case R.id.option_google_vip_enable /* 2131297578 */:
                    this.c.setChecked(!switchCompat2.isChecked());
                    Z0(this.c.isChecked());
                    return;
                case R.id.id_jp_location /* 2131297076 */:
                case R.id.option_jp_location /* 2131297596 */:
                    boolean z = !us.pinguo.foundation.base.e.a(this, "jp_location", false);
                    this.a.setChecked(z);
                    us.pinguo.foundation.base.e.e(this, "jp_location", z);
                    return;
                case R.id.id_new_user /* 2131297089 */:
                case R.id.option_new_user /* 2131297597 */:
                    this.f6961d.setChecked(!switchCompat3.isChecked());
                    return;
                case R.id.option_hawkeye_fps /* 2131297579 */:
                    j.a.b.a.b bVar = j.a.b.a.b.a;
                    boolean z2 = !bVar.a();
                    this.f6962e.setChecked(z2);
                    bVar.c(z2);
                    return;
                case R.id.option_hawkeye_gl_fps /* 2131297580 */:
                    j.a.b.a.b bVar2 = j.a.b.a.b.a;
                    boolean z3 = !bVar2.b();
                    this.f6963f.setChecked(z3);
                    bVar2.d(z3);
                    return;
                case R.id.txtGotoSkyChange /* 2131298538 */:
                    AppGoto.getInstance().c("app://camera360/skyChange").b(this);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test_develop_mode);
        if (us.pinguo.foundation.d.f10985d || us.pinguo.foundation.d.f10987f) {
            ButterKnife.bind(this);
            getSupportActionBar().setTitle("测试页面");
            this.mBtnGetInfo.setOnClickListener(this);
            this.mBtnEditTest.setOnClickListener(this);
            this.mBtnGetCameraInfo.setOnClickListener(this);
            this.mBtnCloneDb.setOnClickListener(this);
            this.mHawkeyeReport.setOnClickListener(this);
            this.mHawkeyeDebugSettings.setOnClickListener(this);
            this.mFpsLogItem.b().setText("页面Fps Log开关");
            this.mFpsLogItem.setOnClickListener(this);
            SwitchCompat a2 = this.mFpsLogItem.a();
            this.f6962e = a2;
            j.a.b.a.b bVar = j.a.b.a.b.a;
            a2.setChecked(bVar.a());
            this.f6962e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.o
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.C0(compoundButton, z);
                }
            });
            this.mGlFpsLogItem.b().setText("页面GL Fps Log开关");
            this.mGlFpsLogItem.setOnClickListener(this);
            SwitchCompat a3 = this.mGlFpsLogItem.a();
            this.f6963f = a3;
            a3.setChecked(bVar.b());
            this.f6963f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.q
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.E0(compoundButton, z);
                }
            });
            SettingItemSwitcher settingItemSwitcher = (SettingItemSwitcher) findViewById(R.id.option_jp_location);
            SwitchCompat a4 = settingItemSwitcher.a();
            this.a = a4;
            a4.setId(R.id.id_jp_location);
            this.a.setChecked(us.pinguo.foundation.base.e.a(this, "jp_location", false));
            settingItemSwitcher.b().setText("贴纸请求使用日本地区经纬度");
            settingItemSwitcher.setOnClickListener(this);
            this.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.K0(compoundButton, z);
                }
            });
            SettingItemSwitcher settingItemSwitcher2 = (SettingItemSwitcher) findViewById(R.id.option_debug_url);
            settingItemSwitcher2.setOnClickListener(this);
            SwitchCompat a5 = settingItemSwitcher2.a();
            this.b = a5;
            a5.setId(R.id.id_debug_url);
            this.b.setChecked(us.pinguo.foundation.base.e.a(this, "release_host", false));
            settingItemSwitcher2.b().setText("请求正式环境地址");
            settingItemSwitcher2.setOnClickListener(this);
            this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.h
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.M0(compoundButton, z);
                }
            });
            SettingItemSwitcher settingItemSwitcher3 = (SettingItemSwitcher) findViewById(R.id.option_new_user);
            settingItemSwitcher3.setOnClickListener(this);
            SwitchCompat a6 = settingItemSwitcher3.a();
            this.f6961d = a6;
            a6.setId(R.id.id_new_user);
            this.f6961d.setChecked(us.pinguo.foundation.base.e.a(this, "new_user", false));
            settingItemSwitcher3.b().setText("模拟新用户数据");
            settingItemSwitcher3.setOnClickListener(this);
            this.f6961d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.i
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.O0(compoundButton, z);
                }
            });
            SettingItemSwitcher settingItemSwitcher4 = (SettingItemSwitcher) findViewById(R.id.option_google_vip_enable);
            settingItemSwitcher4.setOnClickListener(this);
            SwitchCompat a7 = settingItemSwitcher4.a();
            this.c = a7;
            a7.setId(R.id.id_google_vip_enable);
            this.c.setChecked(us.pinguo.foundation.base.e.a(this, "google_vip", false));
            settingItemSwitcher4.b().setText("模拟支持Google订阅");
            settingItemSwitcher4.setOnClickListener(this);
            this.c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.m
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DevelopModeActivity.this.Q0(compoundButton, z);
                }
            });
            boolean z = us.pinguo.foundation.d.f10991j;
            int i2 = ViewCompat.MEASURED_STATE_MASK;
            if (z) {
                TextView textView = this.mVipUnsubscribe;
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
                this.mVipUnsubscribe.setTextColor(us.pinguo.foundation.d.f10992k ? ViewCompat.MEASURED_STATE_MASK : -5592406);
                this.mVipUnsubscribe.setEnabled(us.pinguo.foundation.d.f10992k);
                this.mVipUnsubscribe.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DevelopModeActivity.this.S0(view);
                    }
                });
            } else {
                TextView textView2 = this.mVipUnsubscribe;
                textView2.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView2, 8);
            }
            findViewById(R.id.clear_cache_tv).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DevelopModeActivity.this.U0(view);
                }
            });
            this.mBtnPushTest.setOnClickListener(this);
            this.mBtnAbTest.setOnClickListener(this);
            this.mBtnUnityImport.setOnClickListener(this);
            this.mBtnInstallFilter.setOnClickListener(this);
            this.mLogoutAccount.setOnClickListener(this);
            this.mUnBindMobile.setOnClickListener(this);
            boolean u0 = u0();
            TextView textView3 = this.mUnBindMobile;
            if (!u0) {
                i2 = -5592406;
            }
            textView3.setTextColor(i2);
            this.mUnBindMobile.setEnabled(u0);
            SettingItemSwitcher settingItemSwitcher5 = (SettingItemSwitcher) findViewById(R.id.option_debug_export_beauty_param);
            settingItemSwitcher5.b().setText("开启导出美颜开关");
            settingItemSwitcher5.a().setChecked(f6960h);
            settingItemSwitcher5.a().setOnCheckedChangeListener(g.a);
            this.mPhotoInfoPage.setOnClickListener(this);
            this.mSkyChange.setOnClickListener(this);
            TextView textView4 = (TextView) findViewById(R.id.btn_widget_sample);
            this.f6964g = textView4;
            textView4.setOnClickListener(this);
            findViewById(R.id.btn_pay_wall_test).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.test.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DevelopModeActivity.this.X0(view);
                }
            });
            this.mEnablePgFaceDetector.b().setText("使用LightFace进行人脸识别");
            this.mEnablePgFaceDetector.a().setChecked(us.pinguo.foundation.base.e.a(this, "enable_pg_face_detector", false));
            this.mEnablePgFaceDetector.a().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    DevelopModeActivity.this.G0(compoundButton, z2);
                }
            });
            this.mEnableBigDataSession.b().setText("开启大数据Session");
            this.mEnableBigDataSession.a().setChecked(us.pinguo.foundation.base.e.a(this, "enable_bigdata_session", false));
            this.mEnableBigDataSession.a().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.pinguo.camera360.test.r
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    DevelopModeActivity.this.I0(compoundButton, z2);
                }
            });
            return;
        }
        throw new RuntimeException("test only");
    }
}
