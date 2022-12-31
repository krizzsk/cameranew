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
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareChatActivity extends BaseActivity {
    private Intent u;
    private FrameLayout v;
    private com.sina.weibo.sdk.b.d w;
    private Handler x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareChatActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareChatActivity.a(ShareChatActivity.this);
        }
    };

    static /* synthetic */ void a(ShareChatActivity shareChatActivity) {
        FrameLayout frameLayout = shareChatActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareChatActivity.setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Handler handler = shareChatActivity.x;
        if (handler != null) {
            handler.removeMessages(0);
            shareChatActivity.x = null;
        }
        shareChatActivity.finish();
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
        com.sina.weibo.sdk.b.b bVar;
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
            Bundle extras = this.u.getExtras();
            if (extras == null) {
                finish();
                return;
            }
            final ChatObject chatObject = (ChatObject) extras.getParcelable("chat_object");
            if (chatObject != null) {
                com.sina.weibo.sdk.b.d dVar = this.w;
                if (dVar != null) {
                    dVar.S.cancel(true);
                }
                this.w = new com.sina.weibo.sdk.b.d(this, chatObject, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.share.ShareChatActivity.2
                    @Override // com.sina.weibo.sdk.net.c
                    public final /* synthetic */ void a(String str) {
                        String str2 = str;
                        FrameLayout frameLayout = ShareChatActivity.this.v;
                        frameLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(frameLayout, 4);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            int optInt = jSONObject.optInt("code");
                            String optString = jSONObject.optString("errmsg");
                            String optString2 = jSONObject.optString("data");
                            if (optInt == 0 && !TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject2 = new JSONObject(optString2);
                                ShareChatActivity.a(ShareChatActivity.this, chatObject, jSONObject2.optString("short_url"), jSONObject2.optString("object_id"));
                                return;
                            }
                            ShareChatActivity shareChatActivity = ShareChatActivity.this;
                            ShareChatActivity.a(shareChatActivity, optString + "(" + optInt + ")");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }

                    @Override // com.sina.weibo.sdk.net.c
                    public final void onError(Throwable th) {
                        FrameLayout frameLayout = ShareChatActivity.this.v;
                        frameLayout.setVisibility(4);
                        VdsAgent.onSetViewVisibility(frameLayout, 4);
                        ShareChatActivity.a(ShareChatActivity.this, th.getMessage());
                    }
                });
                bVar = b.a.P;
                bVar.a(this.w);
                return;
            }
            FrameLayout frameLayout = this.v;
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
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
        setResult(-1, intent);
        finish();
    }

    static /* synthetic */ void a(ShareChatActivity shareChatActivity, ChatObject chatObject, String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("page_url", str);
            bundle.putString("page_id", str2);
            bundle.putInt("page_type", 0);
            bundle.putInt("composer_launch_type", 4002);
            bundle.putBoolean("page_showcard", true);
            bundle.putString("page_pic", chatObject.image_url);
            bundle.putString("page_title", chatObject.content);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("sinaweibo://extendthirdshare"));
            intent.setPackage("com.sina.weibo");
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("param_bundle", bundle);
            bundle2.putInt("share_type", 1001);
            intent.putExtras(bundle2);
            shareChatActivity.startActivityForResult(intent, 10001);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(ShareChatActivity shareChatActivity, String str) {
        FrameLayout frameLayout = shareChatActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout, 4);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        shareChatActivity.setResult(-1, intent);
        shareChatActivity.finish();
    }
}
