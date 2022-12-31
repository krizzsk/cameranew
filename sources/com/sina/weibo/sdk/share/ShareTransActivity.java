package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.c.a;
/* loaded from: classes3.dex */
public class ShareTransActivity extends BaseActivity {
    private d C;
    private Intent u;
    private FrameLayout v;
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareTransActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareTransActivity.a(ShareTransActivity.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "onActivityResult.");
        Handler handler = this.x;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View progressBar;
        super.onCreate(bundle);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity.");
        Intent intent = getIntent();
        this.u = intent;
        if (intent == null) {
            finish();
        } else if (intent.getIntExtra("start_flag", -1) != 0) {
            finish();
        } else {
            this.v = new FrameLayout(this);
            int intExtra = getIntent().getIntExtra("progress_id", -1);
            if (intExtra != -1) {
                progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null);
            } else {
                progressBar = new ProgressBar(this);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.v.addView(progressBar, layoutParams);
            this.v.setBackgroundColor(855638016);
            setContentView(this.v);
            com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare wb resource.");
            Bundle extras = this.u.getExtras();
            if (extras == null) {
                finish();
                return;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.readFromBundle(extras);
            if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
                a(weiboMultiMessage);
                return;
            }
            d dVar = this.C;
            if (dVar != null) {
                dVar.cancel(true);
            }
            d dVar2 = new d(this, new b() { // from class: com.sina.weibo.sdk.share.ShareTransActivity.2
                @Override // com.sina.weibo.sdk.share.b
                public final void a(c cVar) {
                    FrameLayout frameLayout = ShareTransActivity.this.v;
                    frameLayout.setVisibility(4);
                    VdsAgent.onSetViewVisibility(frameLayout, 4);
                    if (cVar == null) {
                        ShareTransActivity.this.c("Trans result is null.");
                    } else if (cVar.E) {
                        ShareTransActivity.this.a(cVar.F);
                    } else if (TextUtils.isEmpty(cVar.errorMessage)) {
                        ShareTransActivity.this.c("Trans resource fail.");
                    } else {
                        ShareTransActivity.this.c(cVar.errorMessage);
                    }
                }
            });
            this.C = dVar2;
            dVar2.execute(weiboMultiMessage);
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity again.");
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeiboMultiMessage weiboMultiMessage) {
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start wb composer");
        try {
            this.u.putExtra("start_flag", -1);
            Bundle extras = this.u.getExtras();
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            intent.putExtras(weiboMultiMessage.writeToBundle(extras));
            intent.putExtra("_weibo_sdkVersion", "0041005000");
            intent.putExtra("_weibo_appPackage", getPackageName());
            intent.putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            intent.putExtra("_weibo_sign", com.sina.weibo.sdk.c.d.f(com.sina.weibo.sdk.c.e.e(this, getPackageName())));
            String stringExtra = this.u.getStringExtra("start_web_activity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, 10001);
            } else if (com.sina.weibo.sdk.a.a(this)) {
                a.C0256a c = com.sina.weibo.sdk.c.a.c(this);
                if (c != null) {
                    intent.setPackage(c.packageName);
                }
                startActivityForResult(intent, 10001);
            } else {
                c("Start weibo client's composer fail. And Weibo client is not installed.");
            }
        } catch (Throwable th) {
            com.sina.weibo.sdk.c.c.b("WBShareTag", "start wb composer fail," + th.getMessage());
            c("Start weibo client's composer fail. " + th.getMessage());
        }
    }

    static /* synthetic */ void a(ShareTransActivity shareTransActivity) {
        FrameLayout frameLayout = shareTransActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareTransActivity.setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Handler handler = shareTransActivity.x;
        if (handler != null) {
            handler.removeMessages(0);
            shareTransActivity.x = null;
        }
        shareTransActivity.finish();
    }
}
