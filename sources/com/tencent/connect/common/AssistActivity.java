package com.tencent.connect.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import org.json.JSONObject;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";

    /* renamed from: d  reason: collision with root package name */
    private String f8076d;

    /* renamed from: e  reason: collision with root package name */
    private c f8077e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8078f;
    private boolean c = false;
    protected boolean a = false;
    protected Handler b = new a();

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
            AssistActivity.this.finish();
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = "#";
            VdsAgent.onBroadcastReceiver(this, context, intent);
            Uri uri = (Uri) intent.getParcelableExtra("uriData");
            Intent intent2 = new Intent();
            try {
                String uri2 = uri.toString();
                if (!uri2.contains("#")) {
                    str = "?";
                }
                for (String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    String[] split = str2.split("=");
                    intent2.putExtra(split[0], split[1]);
                }
            } catch (Exception e2) {
                SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e2.getMessage());
            }
            intent2.putExtra(Constants.KEY_ACTION, "action_share");
            intent2.setData(uri);
            AssistActivity.this.setResult(-1, intent2);
        }

        /* synthetic */ c(AssistActivity assistActivity, a aVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.os.Bundle r13) {
        /*
            r12 = this;
            java.lang.String r0 = "viaShareType"
            java.lang.String r8 = r13.getString(r0)
            java.lang.String r0 = "callbackAction"
            java.lang.String r0 = r13.getString(r0)
            java.lang.String r1 = "url"
            java.lang.String r1 = r13.getString(r1)
            java.lang.String r2 = "openId"
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r3 = "appId"
            java.lang.String r3 = r13.getString(r3)
            java.lang.String r13 = "shareToQQ"
            boolean r13 = r13.equals(r0)
            java.lang.String r4 = ""
            if (r13 == 0) goto L2f
            java.lang.String r13 = "ANDROIDQQ.SHARETOQQ.XX"
            java.lang.String r4 = "10"
        L2c:
            r5 = r4
            r4 = r13
            goto L3d
        L2f:
            java.lang.String r13 = "shareToQzone"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L3c
            java.lang.String r13 = "ANDROIDQQ.SHARETOQZ.XX"
            java.lang.String r4 = "11"
            goto L2c
        L3c:
            r5 = r4
        L3d:
            boolean r13 = com.tencent.open.utils.l.a(r12, r1)
            if (r13 != 0) goto L6e
            com.tencent.connect.common.UIListenerManager r13 = com.tencent.connect.common.UIListenerManager.getInstance()
            com.tencent.tauth.IUiListener r13 = r13.getListnerWithAction(r0)
            if (r13 == 0) goto L59
            com.tencent.tauth.UiError r0 = new com.tencent.tauth.UiError
            r1 = -6
            r6 = 0
            java.lang.String r7 = "打开浏览器失败!"
            r0.<init>(r1, r7, r6)
            r13.onError(r0)
        L59:
            com.tencent.open.a.d r1 = com.tencent.open.a.d.a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "1"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.finish()
            goto L7f
        L6e:
            com.tencent.open.a.d r1 = com.tencent.open.a.d.a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "0"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L7f:
            android.content.Intent r13 = r12.getIntent()
            java.lang.String r0 = "shareH5"
            r13.removeExtra(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.AssistActivity.a(android.os.Bundle):void");
    }

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i2);
        sb.append(" | resultCode: ");
        sb.append(i3);
        sb.append("data = null ? ");
        sb.append(intent == null);
        SLog.i("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(Constants.KEY_ACTION, "action_login");
        }
        setResultData(i2, intent);
        if (!this.f8078f) {
            SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
            finish();
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b(), 200L);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().addFlags(67108864);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f8078f = getIntent().getBooleanExtra(Constants.KEY_RESTORE_LANDSCAPE, false);
        SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f8078f);
        if (getIntent() == null) {
            SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        int intExtra = intent == null ? 0 : intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        this.f8076d = intent == null ? "" : intent.getStringExtra("appid");
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c) {
            SLog.d("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
            try {
                String queryParameter = intent.getData().getQueryParameter("share_id");
                IntentFilter intentFilter = new IntentFilter(Constants.SHARE_QQ_AND_STAY + queryParameter);
                if (this.f8077e == null) {
                    this.f8077e = new c(this, null);
                }
                registerReceiver(this.f8077e, intentFilter);
            } catch (Exception e2) {
                SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e2.getMessage());
            }
            startActivityForResult(intent, intExtra);
        } else {
            SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        c cVar = this.f8077e;
        if (cVar != null) {
            unregisterReceiver(cVar);
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(Constants.KEY_REQUEST_CODE, -1);
        if (intExtra == 10108) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } else if (intExtra == 10109) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } else if (intExtra == 10110) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } else if (intExtra == 10111) {
            intent.putExtra(Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } else if (intExtra == 10112) {
            intent.putExtra(Constants.KEY_ACTION, "bindGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
        } else {
            intent.putExtra(Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.c && !isFinishing()) {
            finish();
        }
        if (this.a) {
            this.b.sendMessage(this.b.obtainMessage(0));
            return;
        }
        this.a = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i2, Intent intent) {
        if (intent == null) {
            SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i2 == 11101) {
                d.a().a("", this.f8076d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                String optString3 = jSONObject.optString("proxy_code");
                long optLong = jSONObject.optLong("proxy_expires_in");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    d.a().a(optString, this.f8076d, "2", "1", "7", "0");
                } else if (!TextUtils.isEmpty(optString3) && optLong != 0) {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                } else {
                    SLog.w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    d.a().a("", this.f8076d, "2", "1", "7", "1");
                }
            } else {
                SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e2.printStackTrace();
        }
    }
}
