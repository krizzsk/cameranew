package cn.sharesdk.douyin.bdopen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.douyin.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
/* loaded from: classes.dex */
public class DouYinHandlerActivity extends Activity implements IApiEventHandler {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DouYinOpenApiFactory.create(this).handleIntent(getIntent(), this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onErrorIntent(Intent intent) {
        finish();
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler
    public void onResp(BaseResp baseResp) {
        try {
            c.a().a(baseResp);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        finish();
    }
}
