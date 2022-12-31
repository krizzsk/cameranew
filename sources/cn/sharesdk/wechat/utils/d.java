package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import androidx.core.view.PointerIconCompat;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* compiled from: SendMessageReq.java */
/* loaded from: classes.dex */
public class d extends m {
    public WXMediaMessage a;
    public int b;
    public String c;

    @Override // cn.sharesdk.wechat.utils.m
    public int a() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.m
    public void a(Bundle bundle) {
        super.a(bundle);
        bundle.putAll(WXMediaMessage.a.a(this.a));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.b);
        bundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.a.getType());
        bundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.c);
    }

    @Override // cn.sharesdk.wechat.utils.m
    public boolean a(boolean z) {
        byte[] bArr;
        if (this.a.getType() == 8 && ((bArr = this.a.thumbData) == null || bArr.length <= 0)) {
            SSDKLog.b().d("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
            return false;
        }
        if (z) {
            byte[] bArr2 = this.a.thumbData;
            if (bArr2 != null && bArr2.length > 131072) {
                SSDKLog.b().d("checkArgs fail, thumbData is invalid", new Object[0]);
                return false;
            }
        } else {
            byte[] bArr3 = this.a.thumbData;
            if (bArr3 != null && bArr3.length > 32768) {
                SSDKLog.b().d("checkArgs fail, thumbData is invalid", new Object[0]);
                return false;
            }
        }
        String str = this.a.title;
        if (str != null && str.length() > 512) {
            SSDKLog.b().d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        }
        String str2 = this.a.description;
        if (str2 != null && str2.length() > 1024) {
            WXMediaMessage wXMediaMessage = this.a;
            wXMediaMessage.description = this.a.description.substring(0, PointerIconCompat.TYPE_GRABBING) + "...";
        }
        WXMediaMessage.IMediaObject iMediaObject = this.a.mediaObject;
        if (iMediaObject == null) {
            SSDKLog.b().d("checkArgs fail, mediaObject is null", new Object[0]);
            return false;
        }
        int i2 = this.b;
        if (i2 == 3 && this.c == null) {
            SSDKLog.b().d("Send specifiedContact userOpenId can not be null.", new Object[0]);
            return false;
        } else if (i2 == 3 && this.f324f == null) {
            SSDKLog.b().d("Send specifiedContact openid can not be null.", new Object[0]);
            return false;
        } else {
            return iMediaObject.checkArgs();
        }
    }
}
