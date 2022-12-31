package vStudio.Android.Camera360.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import us.pinguo.paylibwxalipay.wxpay.WXDopay;
/* loaded from: classes7.dex */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public static String b = us.pinguo.foundation.s.a.a;
    private static a c = null;
    private IWXAPI a;

    public static void a(a aVar) {
        c = aVar;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, b);
        this.a = createWXAPI;
        boolean handleIntent = createWXAPI.handleIntent(getIntent(), this);
        us.pinguo.common.log.a.e("handleIntent rst1:" + handleIntent, new Object[0]);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        finish();
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
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
        us.pinguo.common.log.a.e("WXPayEntryActivity onResp", new Object[0]);
        int type = baseResp.getType();
        if (type == 2) {
            a aVar = c;
            if (aVar != null) {
                aVar.a(-5, "error type");
                c = null;
            }
        } else if (type != 5) {
            a aVar2 = c;
            if (aVar2 != null) {
                aVar2.a(-5, "error type");
                c = null;
            }
        } else {
            a aVar3 = c;
            if (aVar3 != null) {
                aVar3.a(baseResp.errCode, baseResp.errStr);
                c = null;
            }
            WXDopay.getInstance().a(baseResp);
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
