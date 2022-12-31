package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* loaded from: classes.dex */
public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    public String canvasPageXml;
    public String extInfo;
    public String webpageUrl;

    public WXWebpageObject() {
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str == null || str.length() == 0 || this.webpageUrl.length() > 10240) {
            SSDKLog.b().d("checkArgs fail, webpageUrl is invalid", new Object[0]);
            return false;
        }
        return true;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        bundle.putString("_wxwebpageobject_extInfo", this.extInfo);
        bundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
        this.extInfo = bundle.getString("_wxwebpageobject_extInfo");
        this.canvasPageXml = bundle.getString("_wxwebpageobject_canvaspagexml");
    }

    public WXWebpageObject(String str) {
        this.webpageUrl = str;
    }
}
