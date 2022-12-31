package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes3.dex */
public class ShareResultActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        try {
            intent = getIntent();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (intent == null) {
            finish();
        } else if (intent.getIntExtra("start_flag", -1) == 0) {
            finish();
        } else {
            String action = intent.getAction();
            if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(action)) {
                intent.setClassName(this, "com.sina.weibo.sdk.share.ShareTransActivity");
            } else if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY".equals(action)) {
                intent.setClassName(this, "com.sina.weibo.sdk.share.ShareStoryActivity");
            }
            startActivity(intent);
            finish();
        }
    }
}
