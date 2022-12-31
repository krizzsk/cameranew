package com.pinguo.camera360.camera.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.options.l0;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.camera360.vip.VipManager;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.Executors;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.bigalbum.BigAlbumConfig;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.camera2020.activity.y;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.edit2020.activity.EditActivity;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.e;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.j;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.i;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.util.c;
import us.pinguo.util.h;
import us.pinguo.util.l;
import us.pinguo.util.v;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.activity.g;
import vStudio.Android.Camera360.activity.i;
/* loaded from: classes3.dex */
public class IntentBufferActivity extends BaseActivity {

    /* renamed from: e  reason: collision with root package name */
    private View f6198e;

    /* renamed from: f  reason: collision with root package name */
    private View f6199f;
    private CharSequence a = null;
    private int b = 0;
    private Intent c = null;

    /* renamed from: d  reason: collision with root package name */
    private TextView f6197d = null;

    /* renamed from: g  reason: collision with root package name */
    private Handler f6200g = new a();

    /* loaded from: classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    IntentBufferActivity.this.B0();
                }
            } else if (IntentBufferActivity.this.f6197d != null) {
                TextView textView = IntentBufferActivity.this.f6197d;
                textView.setText(((Object) IntentBufferActivity.this.a) + ".....".substring(0, (IntentBufferActivity.this.b % 3) + 1));
                IntentBufferActivity.t0(IntentBufferActivity.this);
                IntentBufferActivity.this.f6200g.sendEmptyMessageDelayed(1, 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends BigAlbumConfig {
        b(IntentBufferActivity intentBufferActivity) {
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppChannel() {
            return i.a();
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppName() {
            return "camera360";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        boolean z;
        String str;
        Intent g2;
        String action = this.c.getAction();
        Intent intent = new Intent();
        if ("android.intent.action.VIEW".equals(action)) {
            if ("camera360".equals(this.c.getScheme())) {
                String dataString = this.c.getDataString();
                if (dataString != null && dataString.startsWith("camera360://")) {
                    AppGoto appGoto = AppGoto.getInstance();
                    appGoto.c("app://" + dataString.substring(12)).b(this);
                }
            } else {
                Intent intent2 = new Intent();
                intent2.setClassName(this, "us.pinguo.camera2020.activity.Camera2020Activity");
                startActivity(intent2);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
            finish();
        } else if ("com.pinguo.camera360.IMAGE_EDIT".equals(action)) {
            EditActivity.a.b(this, this.c.getStringExtra("input"), false, null, false);
            finish();
        } else if ("com.pinguo.camera360.IMAGE_EDIT_WITH_RESULT".equals(action)) {
            EditActivity.a.b(this, w0((Uri) this.c.getExtras().getParcelable("android.intent.extra.STREAM")), false, null, false);
            finish();
        } else if ("android.media.action.IMAGE_CAPTURE".equals(action)) {
            y.b().e(0, null);
            intent.setClassName(this, "us.pinguo.camera2020.activity.IntentCamera2020Activity");
            Uri uri = (Uri) this.c.getParcelableExtra("output");
            if (uri != null) {
                intent.putExtra("output", uri);
            }
            startActivity(intent);
        } else if ("us.pinguo.camera360.MARKET_OPERATIONS".equals(action)) {
            String stringExtra = this.c.getStringExtra("market_operations_link");
            if (stringExtra == null) {
                g.c(this);
                finish();
                return;
            }
            if (Constants.PUSH.equals(this.c.getStringExtra("web_view_from"))) {
                String stringExtra2 = this.c.getStringExtra("web_view_push_id");
                k.g(0, stringExtra2);
                k.i(1, stringExtra2);
            }
            AppGoto.getInstance().c(stringExtra).b(this);
            finish();
        } else if (!"android.media.action.STILL_IMAGE_CAMERA".equals(action) && !"us.pinguo.camera360.EFFECT_IMAGE_CAPTURE".equals(action)) {
            if ("com.camera360.inspire_IMAGE_CAPTURE".equals(action)) {
                y.b().e(0, null);
                intent.setClassName(this, "us.pinguo.camera2020.activity.IntentCamera2020Activity");
                Uri uri2 = (Uri) this.c.getParcelableExtra("output");
                int intExtra = this.c.getIntExtra("camera_type", 3);
                String stringExtra3 = this.c.getStringExtra("bundle_key_package");
                String stringExtra4 = this.c.getStringExtra("bundle_key_filter");
                String stringExtra5 = this.c.getStringExtra("bundle_key_is_sticker");
                boolean booleanExtra = this.c.getBooleanExtra("bundle_key_init_unity", false);
                int intExtra2 = this.c.getIntExtra("bundle_key_sticker_goto_type", 1);
                boolean booleanExtra2 = this.c.getBooleanExtra("key_no_watermark", false);
                int intExtra3 = this.c.getIntExtra("key_cam", 3);
                String stringExtra6 = this.c.getStringExtra("bundle_key_category");
                String stringExtra7 = this.c.getStringExtra("bundle_key_makeup");
                boolean booleanExtra3 = this.c.getBooleanExtra(us.pinguo.foundation.constant.a.f10980d, false);
                if ("true".equals(stringExtra5)) {
                    str = "com.camera360.inspire_IMAGE_CAPTURE";
                    g2 = us.pinguo.foundation.b.h(this, intExtra, stringExtra3, stringExtra4, uri2, booleanExtra2, stringExtra5, intExtra3, intExtra2);
                    g2.putExtra("bundle_key_init_unity", booleanExtra);
                    if (!TextUtils.isEmpty(stringExtra6)) {
                        g2.putExtra("bundle_key_category", stringExtra6);
                    }
                    z = booleanExtra3;
                } else {
                    z = booleanExtra3;
                    str = "com.camera360.inspire_IMAGE_CAPTURE";
                    if (!TextUtils.isEmpty(stringExtra3) && !FilterOperateManager.h().k(stringExtra3)) {
                        g2 = us.pinguo.camera360.shop.i.b(this, intExtra, stringExtra3, stringExtra4, uri2, booleanExtra2, intExtra3);
                    } else {
                        g2 = us.pinguo.foundation.b.g(this, intExtra, stringExtra3, stringExtra4, uri2, booleanExtra2, "false", intExtra3);
                        if (!TextUtils.isEmpty(stringExtra7)) {
                            g2.putExtra("bundle_key_makeup", stringExtra7);
                        }
                    }
                }
                if (this.c.hasExtra("task")) {
                    g2.putExtra("task", this.c.getParcelableExtra("task"));
                }
                if (this.c.hasExtra(us.pinguo.foundation.constant.a.f10984h)) {
                    String str2 = us.pinguo.foundation.constant.a.f10984h;
                    g2.putExtra(str2, this.c.getBooleanExtra(str2, false));
                }
                g2.putExtra(us.pinguo.foundation.constant.a.f10980d, z);
                g2.setAction(str);
                startActivity(g2);
            } else if (!"android.intent.action.EDIT".equals(action) && !"android.intent.action.SEND".equals(action)) {
                if ("com.pinguo.camera360.IMAGE_SECOND_MENU_EDIT".equals(action)) {
                    EditActivity.a.a(this, PGEditResultActivity2.PATH, 0);
                    finish();
                } else if ("us.pinguo.camera360.GALLERY".equals(action)) {
                    Intent intent3 = new Intent();
                    intent3.setClassName(this, "com.pinguo.camera360.gallery.GalleryActivity");
                    if ("app://pinguo.android.team.albumView".equals(this.c.getStringExtra("app://pinguo.android.team.albumView"))) {
                        k.i(1, intent3.getStringExtra("web_view_push_id"));
                        intent3.putExtra("web_view_from", this.c.getStringExtra("web_view_from"));
                    }
                    startActivity(intent3);
                    finish();
                } else if ("us.pinguo.camera360.FEEDBACK".equals(action)) {
                    l0.b(this);
                    finish();
                } else if ("com.camera360.selfie_IMAGE_CAPTURE".equals(action)) {
                    y.b().e(0, null);
                    intent.setClassName(this, "us.pinguo.camera2020.activity.IntentCamera2020Activity");
                    Uri uri3 = (Uri) this.c.getParcelableExtra("output");
                    if (uri3 != null) {
                        intent.putExtra("output", uri3);
                    }
                    intent.putExtra("bundle_key_mode", "bc833a31761642e78dc09c16e4366dd8");
                    startActivity(intent);
                } else {
                    Intent intent4 = new Intent();
                    intent4.setClassName(this, "us.pinguo.camera2020.activity.Camera2020Activity");
                    startActivity(intent4);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
            } else {
                EditActivity.a.b(this, w0(null), false, null, false);
                finish();
            }
        } else {
            Uri uri4 = (Uri) this.c.getParcelableExtra("output");
            if (uri4 == null) {
                if ("app://pinguo.android.team.cameraView".equals(this.c.getStringExtra("app://pinguo.android.team.cameraView"))) {
                    String stringExtra8 = this.c.getStringExtra("web_view_push_id");
                    k.g(0, stringExtra8);
                    k.i(1, stringExtra8);
                }
                String stringExtra9 = this.c.getStringExtra("stickerUnityId");
                String stringExtra10 = this.c.getStringExtra("stickerCategoryId");
                us.pinguo.common.log.a.r("========", ":" + stringExtra9, new Object[0]);
                Intent intent5 = new Intent();
                intent5.setClassName(this, "us.pinguo.camera2020.activity.Camera2020Activity");
                intent5.putExtra("bundle_key_mode", "c205e3582b514d6fb5c21a953e1e901e");
                if (!TextUtils.isEmpty(stringExtra9)) {
                    intent5.putExtra("bundle_key_sticker_id", stringExtra9);
                    intent5.putExtra("bundle_key_sticker_category_id", stringExtra10);
                }
                if (this.c.hasExtra("camera_type")) {
                    intent5.putExtra("camera_type", this.c.getIntExtra("camera_type", 3));
                }
                startActivity(intent5);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                return;
            }
            y.b().e(0, null);
            intent.setClassName(this, "us.pinguo.camera2020.activity.IntentCamera2020Activity");
            intent.putExtra("output", uri4);
            String stringExtra11 = this.c.getStringExtra("stickerUnityId");
            String stringExtra12 = this.c.getStringExtra("stickerCategoryId");
            intent.putExtra("bundle_key_mode", "c205e3582b514d6fb5c21a953e1e901e");
            if (!TextUtils.isEmpty(stringExtra11)) {
                intent.putExtra("bundle_key_sticker_id", stringExtra11);
                intent.putExtra("bundle_key_sticker_category_id", stringExtra12);
            }
            String stringExtra13 = this.c.getStringExtra("effect_type_key");
            if (!TextUtils.isEmpty(stringExtra13)) {
                intent.putExtra("bundle_key_effect", stringExtra13);
            }
            startActivity(intent);
        }
    }

    private void showLoading() {
        setContentView(R.layout.layout_launch_loading);
        TextView textView = (TextView) findViewById(R.id.tv_guide_wait_some_time);
        this.f6197d = textView;
        this.a = textView.getText();
        this.f6198e = findViewById(R.id.layout_loading_data);
        this.f6199f = findViewById(R.id.tv_loading_wait);
    }

    static /* synthetic */ int t0(IntentBufferActivity intentBufferActivity) {
        int i2 = intentBufferActivity.b;
        intentBufferActivity.b = i2 + 1;
        return i2;
    }

    private void x0(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        this.c = intent;
        y0();
    }

    private void y0() {
        if (v.j()) {
            BigAlbumManager.instance().init(BaseApplication.d(), new b(this));
        }
        vStudio.Android.Camera360.a aVar = new vStudio.Android.Camera360.a();
        int e2 = aVar.e();
        int g2 = aVar.g();
        if (g2 == 1) {
            CameraBusinessSettingModel.v().J(c.f12471e ? Effect.EFFECT_FILTER_DEFAULT_KEY : "C360_FilmFlex_006");
        }
        VipManager vipManager = VipManager.a;
        vipManager.A(BaseApplication.d());
        if (vipManager.g(true)) {
            com.pinguo.camera360.adv.c.h();
        }
        AsyncTask e3 = vStudio.Android.Camera360.activity.i.e(g2, e2, new i.c() { // from class: com.pinguo.camera360.camera.activity.a
            @Override // vStudio.Android.Camera360.activity.i.c
            public final void a(boolean z, long j2) {
                IntentBufferActivity.this.A0(z, j2);
            }
        });
        if (e3 != null) {
            us.pinguo.common.log.a.k("load_unity showLoading", new Object[0]);
            showLoading();
            e3.executeOnExecutor(Executors.newSingleThreadExecutor(), new Object[0]);
            return;
        }
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(boolean z, long j2) {
        j.e().q("key_version_code", 111099270);
        this.f6200g.removeMessages(1);
        View view = this.f6198e;
        if (view != null) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
        View view2 = this.f6199f;
        if (view2 != null) {
            view2.setVisibility(0);
            VdsAgent.onSetViewVisibility(view2, 0);
        }
        this.f6200g.sendEmptyMessageDelayed(2, 500L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        j.e().q("hairCut", h.b(getWindow().getDecorView()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            x0(getIntent());
            return;
        }
        Parcelable parcelable = bundle.getParcelable("intent_data");
        if (parcelable instanceof Intent) {
            this.c = (Intent) parcelable;
        }
        if (y.b().a()) {
            setResult(y.b().d(), y.b().c());
            y.b().e(0, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f6200g.removeMessages(1);
        this.f6200g.removeMessages(2);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        x0(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (y.b().a()) {
            setResult(y.b().d(), y.b().c());
            y.b().e(0, new Intent());
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Intent intent = this.c;
        if (intent != null) {
            bundle.putParcelable("intent_data", intent);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (y.b().a()) {
            setResult(y.b().d(), y.b().c());
            y.b().e(0, null);
            finish();
        }
    }

    public String w0(Uri uri) {
        String scheme;
        Bundle extras;
        if (uri == null) {
            uri = this.c.getData();
        }
        if (uri == null && (extras = this.c.getExtras()) != null) {
            uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
            Log.d("share_uri", uri.toString());
            Log.d("share_uri", uri.getPath());
            Log.d("share_uri", uri.getEncodedPath());
            Log.d("share_uri", uri.getAuthority());
            Log.d("share_uri", uri.getEncodedAuthority());
        }
        String str = null;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return null;
        }
        if (!scheme.toLowerCase().startsWith("file")) {
            String[] strArr = {"_data"};
            ContentResolver contentResolver = getContentResolver();
            try {
                Cursor query = contentResolver.query(uri, strArr, null, null, null);
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("_data");
                if (columnIndex == -1) {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    str = e.b().getFilesDir().getAbsolutePath() + "/.shared.tmp";
                    l.j(str);
                    l.h(str);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str), 8192);
                    kotlin.io.a.a(openInputStream, bufferedOutputStream, 8192);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    openInputStream.close();
                } else {
                    str = query.getString(columnIndex);
                }
                if (query != null) {
                    query.close();
                    return str;
                }
                return str;
            } catch (Exception e2) {
                e2.printStackTrace();
                CrashReport.postCatchedException(e2);
                return str;
            }
        }
        return uri.getPath();
    }
}
