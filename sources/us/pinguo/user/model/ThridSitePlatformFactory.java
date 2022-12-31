package us.pinguo.user.model;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.adjust.sdk.Constants;
/* loaded from: classes6.dex */
public class ThridSitePlatformFactory {
    public static Platform getHuawei() {
        return getPlatform(Constants.REFERRER_API_HUAWEI);
    }

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

    public static Platform getQQ() {
        return getPlatform(QQ.NAME);
    }

    public static Platform getSinaWeibo() {
        return getPlatform(SinaWeibo.NAME);
    }

    public static Platform getWechat() {
        return getPlatform(Wechat.NAME);
    }
}
