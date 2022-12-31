package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.net.Uri;
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
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
/* loaded from: classes3.dex */
public class ShareStoryActivity extends BaseActivity {
    private e A;
    private Intent u;
    private FrameLayout v;
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareStoryActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareStoryActivity.this.a(1, "cancel");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        a(2, str);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
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
            if (this.u.getExtras() == null) {
                finish();
                return;
            }
            StoryMessage storyMessage = (StoryMessage) getIntent().getParcelableExtra("_weibo_message_stroy");
            if (storyMessage == null) {
                c("StoryMessage is null.");
            } else if (storyMessage.checkResource() && com.sina.weibo.sdk.a.b(this)) {
                e eVar = this.A;
                if (eVar != null) {
                    eVar.cancel(true);
                }
                e eVar2 = new e(this, new b() { // from class: com.sina.weibo.sdk.share.ShareStoryActivity.2
                    @Override // com.sina.weibo.sdk.share.b
                    public final void a(c cVar) {
                        FrameLayout frameLayout = ShareStoryActivity.this.v;
                        frameLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(frameLayout, 4);
                        if (cVar == null) {
                            ShareStoryActivity.this.c("Trans result is null.");
                        } else if (cVar.E) {
                            ShareStoryActivity.a(ShareStoryActivity.this, cVar.G);
                        } else if (TextUtils.isEmpty(cVar.errorMessage)) {
                            ShareStoryActivity.this.c("Trans story fail.");
                        } else {
                            ShareStoryActivity.this.c(cVar.errorMessage);
                        }
                    }
                });
                this.A = eVar2;
                eVar2.execute(storyMessage);
            } else {
                c("StoryMessage's resource is error.");
            }
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        if (intent.getIntExtra("backType", 0) == 0) {
            a(1, "cancel");
        } else {
            a(0, "ok");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        try {
            try {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("_weibo_resp_errcode", i2);
                bundle.putString("_weibo_resp_errstr", str);
                intent.putExtras(bundle);
                setResult(-1, intent);
                Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(0);
                    this.x = null;
                }
                finish();
            } catch (Exception e2) {
                e2.printStackTrace();
                Handler handler2 = this.x;
                if (handler2 != null) {
                    handler2.removeMessages(0);
                    this.x = null;
                }
                finish();
            }
        } catch (Throwable th) {
            Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(0);
                this.x = null;
            }
            finish();
            throw th;
        }
    }

    static /* synthetic */ void a(ShareStoryActivity shareStoryActivity, StoryObject storyObject) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
            intent.setPackage("com.sina.weibo");
            intent.putExtra("storyData", storyObject);
            shareStoryActivity.startActivityForResult(intent, 10001);
        } catch (Exception e2) {
            shareStoryActivity.c(e2.getMessage());
        }
    }
}
