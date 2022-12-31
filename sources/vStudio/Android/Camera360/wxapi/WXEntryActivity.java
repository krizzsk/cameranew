package vStudio.Android.Camera360.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import us.pinguo.foundation.proxy.b;
/* loaded from: classes7.dex */
public class WXEntryActivity extends WechatHandlerActivity implements IWXAPIEventHandler {
    private static a b;
    private IWXAPI a;

    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, us.pinguo.foundation.s.a.a);
        this.a = createWXAPI;
        boolean handleIntent = createWXAPI.handleIntent(getIntent(), this);
        us.pinguo.common.log.a.e("handleIntent rst1:" + handleIntent, new Object[0]);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        finish();
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        boolean handleIntent = this.a.handleIntent(intent, this);
        us.pinguo.common.log.a.e("handleIntent rst2:" + handleIntent, new Object[0]);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        a aVar;
        us.pinguo.common.log.a.e("WXEntryActivity onResp", new Object[0]);
        int type = baseResp.getType();
        if (type == 2) {
            a aVar2 = b;
            if (aVar2 != null) {
                aVar2.a(baseResp.errCode, baseResp.errStr);
                b = null;
            }
        } else if (type == 5) {
            a aVar3 = b;
            if (aVar3 != null) {
                aVar3.a(-5, "error type");
                b = null;
            }
        } else if (type != 19 && (aVar = b) != null) {
            aVar.a(-5, "error type");
            b = null;
        }
        if (baseResp.errCode == 0) {
            b.a = true;
        } else {
            b.a = false;
        }
        finish();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }
}
