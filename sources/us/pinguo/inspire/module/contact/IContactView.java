package us.pinguo.inspire.module.contact;

import java.util.List;
import us.pinguo.inspire.module.contact.entry.HotUserEntry;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.contact.entry.ThirdSiteRedDot;
/* loaded from: classes9.dex */
public interface IContactView extends us.pinguo.foundation.p.b {
    void appendRecommend(List<Recommend> list);

    void hideLoadMore();

    void hideLoading();

    void notifyData(List<HotUserEntry> list);

    void onBindThirdSiteSuccess(String str, String str2);

    void setRecommend(List<Recommend> list);

    void setRedDotCount(int i2);

    void setThirdSiteFriendCount(ThirdSiteRedDot thirdSiteRedDot);

    void showLoadingKeepHeader();
}
