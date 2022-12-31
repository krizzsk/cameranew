package us.pinguo.share.core;

import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public enum ShareSite {
    OTHER(""),
    FACEBOOK("com.facebook.katana"),
    INSTAGRAM("com.instagram.android"),
    QQ("com.tencent.mobileqq"),
    QZONE(Constants.PACKAGE_QZONE),
    SINAWEIBO("com.sina.weibo"),
    TWITTER("com.twitter.android"),
    WECHAT_FRIENDS("com.tencent.mm"),
    WECHAT_MOMENTS("com.tencent.mm"),
    DOUYIN("com.ss.android.ugc.aweme");
    
    private String mPackageName;

    ShareSite(String str) {
        this.mPackageName = str;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + ":" + getPackageName();
    }
}
