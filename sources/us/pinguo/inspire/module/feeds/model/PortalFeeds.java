package us.pinguo.inspire.module.feeds.model;

import java.util.List;
import rx.functions.Func1;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
/* loaded from: classes9.dex */
public class PortalFeeds {
    public AppConf appConf;
    public Body body;
    public Dns dns;
    public Msg msg;
    public Publish publish;
    public double serverTime;

    /* loaded from: classes9.dex */
    public static class AppConf {
        public CameraPics cameraPics;
    }

    /* loaded from: classes9.dex */
    public static class Assert implements Func1<PortalFeeds, PortalFeeds> {
        @Override // rx.functions.Func1
        public PortalFeeds call(PortalFeeds portalFeeds) {
            Body body;
            if (portalFeeds == null || (body = portalFeeds.body) == null || body.list == null) {
                throw new IllegalArgumentException();
            }
            return portalFeeds;
        }
    }

    /* loaded from: classes9.dex */
    public static class Body {
        public List<FeedItem> list;
        public int page;

        /* loaded from: classes9.dex */
        public static class FeedItem {
            public int cache;
            public int catId;
            public InspireFeed content;
            public FeedStat stat;
        }
    }

    /* loaded from: classes9.dex */
    public static class CameraPics {
        public int interval;
        public int num;
    }

    /* loaded from: classes9.dex */
    public static class Dns {
        public String photoTask;
    }

    /* loaded from: classes9.dex */
    public static class Msg {
        public int unReadCount;
    }

    /* loaded from: classes9.dex */
    public static class Publish {
        public String text;
    }
}
