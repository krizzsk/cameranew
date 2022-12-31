package us.pinguo.inspire.module.feeds.model;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
/* loaded from: classes9.dex */
public class PortalFollowFeeds {
    public static final String TYPE_ALL = "all";
    public static final String TYPE_NONE = "none";
    public String lastTime;
    public List<FeedFollowItem> list;
    public List<Recommend> recUsers;
    public double serverTime;
    public String sp;
    public String type;

    /* loaded from: classes9.dex */
    public static class Assert implements Func1<PortalFollowFeeds, PortalFollowFeeds> {
        @Override // rx.functions.Func1
        public PortalFollowFeeds call(PortalFollowFeeds portalFollowFeeds) {
            String str;
            if (portalFollowFeeds != null && (str = portalFollowFeeds.type) != null) {
                if (PortalFollowFeeds.TYPE_ALL.equals(str) && (portalFollowFeeds.recUsers == null || portalFollowFeeds.list == null)) {
                    throw new IllegalArgumentException();
                }
                if (PortalFollowFeeds.TYPE_NONE.equals(portalFollowFeeds.type) && portalFollowFeeds.list == null) {
                    throw new IllegalArgumentException();
                }
                return portalFollowFeeds;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes9.dex */
    public static class FeedFollowItem {
        public InspireFeed content;
        public FeedStat stat;
    }
}
