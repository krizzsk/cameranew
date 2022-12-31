package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.wechat.utils.WXMediaMessage;
/* loaded from: classes.dex */
public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;
    public int miniprogramType = 0;
    public int disableforward = 0;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str != null && str.length() != 0 && this.webpageUrl.length() <= 10240) {
            String str2 = this.userName;
            if (str2 != null && str2.length() != 0 && this.userName.length() <= 10240) {
                int i2 = this.miniprogramType;
                if (i2 < 0 || i2 > 2) {
                    SSDKLog.b().d("checkArgs fail", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                    return false;
                }
                return true;
            }
            SSDKLog.b().d("checkArgs fail, userName is invalid", new Object[0]);
            return false;
        }
        SSDKLog.b().d("checkArgs fail, webpageUrl is invalid", new Object[0]);
        return false;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 36;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
    }
}
