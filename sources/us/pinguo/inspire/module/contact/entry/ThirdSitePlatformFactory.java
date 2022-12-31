package us.pinguo.inspire.module.contact.entry;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.wechat.friends.Wechat;
/* loaded from: classes9.dex */
public class ThirdSitePlatformFactory {
    private static Platform getPlatform(String str) {
        if (!TextUtils.isEmpty(str)) {
            Platform platform = ShareSDK.getPlatform(str);
            if (platform != null) {
                return platform;
            }
            throw new IllegalArgumentException("please input the right site name");
        }
        throw new IllegalArgumentException("please input the right site name");
    }

    public static Platform getSinaWeibo() {
        return getPlatform(SinaWeibo.NAME);
    }

    public static Platform getWechat() {
        return getPlatform(Wechat.NAME);
    }
}
