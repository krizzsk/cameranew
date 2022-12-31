package us.pinguo.share.util;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.core.ShareSite;
/* loaded from: classes6.dex */
public enum ShareChannel {
    OTHER(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, ShareSite.OTHER),
    FACEBOOK("facebook", ShareSite.FACEBOOK),
    INSTAGRAM("instagram", ShareSite.INSTAGRAM),
    QQ("qq", ShareSite.QQ),
    QZONE("qqzone", ShareSite.QZONE),
    SINAWEIBO("sina", ShareSite.SINAWEIBO),
    TWITTER(FindFriendHeaderCell.TWITTER, ShareSite.TWITTER),
    DOUYIN("douyin", ShareSite.DOUYIN),
    WECHAT_FRIENDS(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, ShareSite.WECHAT_FRIENDS),
    WECHAT_MOMENTS("wechatMoments", ShareSite.WECHAT_MOMENTS);
    
    private String mName;
    private ShareSite mShareSite;

    ShareChannel(String str, ShareSite shareSite) {
        this.mName = str;
        this.mShareSite = shareSite;
    }

    public static String getChannel(ShareSite shareSite) {
        ShareChannel[] values;
        for (ShareChannel shareChannel : values()) {
            if (shareChannel.mShareSite == shareSite) {
                return shareChannel.mName;
            }
        }
        return null;
    }

    public static ShareSite getShareSite(String str) {
        ShareChannel[] values;
        for (ShareChannel shareChannel : values()) {
            if (shareChannel.mName.equals(str)) {
                return shareChannel.mShareSite;
            }
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + ":" + getName();
    }
}
