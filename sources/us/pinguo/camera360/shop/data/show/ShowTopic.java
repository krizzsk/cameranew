package us.pinguo.camera360.shop.data.show;

import java.util.ArrayList;
import java.util.List;
import us.pinguo.camera360.shop.bean.PayInfo;
/* loaded from: classes4.dex */
public class ShowTopic extends BaseShow {
    public static final String USED_CATEGORY_ID = "recently_used";
    private String banner;
    private String description;
    private String icon;
    private List<ShowPkg> mPkgs;
    private long onsaleTime;
    private PayInfo payInfo;
    private String topicName;
    private UnlockType unLockType;

    public ShowTopic(String str, String str2, String str3, String str4, String str5, long j2) {
        super(str);
        this.mPkgs = new ArrayList();
        this.icon = str2;
        this.topicName = str3;
        this.banner = str4;
        this.description = str5;
        this.onsaleTime = j2;
    }

    public void clearRedPoint() {
        t.f().e(getId());
    }

    public String getBanner() {
        return this.banner;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public long getOnsaleTime() {
        return this.onsaleTime;
    }

    public PayInfo getPayInfo() {
        return this.payInfo;
    }

    public List<ShowPkg> getPkgs() {
        return this.mPkgs;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public UnlockType getUnlockType() {
        return this.unLockType;
    }

    public boolean hasRedPoint() {
        return t.f().k(this);
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setUnlockType(UnlockType unlockType, PayInfo payInfo) {
        this.unLockType = unlockType;
        this.payInfo = payInfo;
    }
}
