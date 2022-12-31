package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* loaded from: classes.dex */
public class WXTextObject implements WXMediaMessage.IMediaObject {
    public String text;

    public WXTextObject() {
        this(null);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.text;
        if (str == null || str.length() == 0 || this.text.length() > 10240) {
            SSDKLog.b().d("checkArgs fail, text is invalid", new Object[0]);
            return false;
        }
        return true;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }

    public WXTextObject(String str) {
        this.text = str;
    }
}
