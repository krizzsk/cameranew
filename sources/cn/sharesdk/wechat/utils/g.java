package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
/* compiled from: SubscribeMessageReq.java */
/* loaded from: classes.dex */
public class g extends m {
    public int a;
    public String b;
    public String c;

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 18;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        bundle.putInt("_wxapi_subscribemessage_req_scene", this.a);
        bundle.putString("_wxapi_subscribemessage_req_templateid", this.b);
        bundle.putString("_wxapi_subscribemessage_req_reserved", this.c);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean a(boolean z) {
        String str = this.b;
        if (str != null && str.length() != 0) {
            if (this.b.length() > 1024) {
                SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is too long");
                return false;
            }
            String str2 = this.c;
            if (str2 == null || str2.length() <= 1024) {
                return true;
            }
            SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, reserved is too long");
            return false;
        }
        SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, "MicroMsg.SDK.SubscribeMessage.ReqcheckArgs fail, templateID is null");
        return false;
    }
}
