package us.pinguo.inspire.module.feeds.model;

import java.util.List;
import us.pinguo.inspire.module.discovery.entity.InspireFeedSender;
import us.pinguo.inspire.module.feeds.model.InspireCompositeCnt;
/* loaded from: classes9.dex */
public class InspireFollowAndLikeDetail {
    public static final String TYPE_FOLLOW = "follow";
    public static final String TYPE_LIKE = "like";
    public List<InspireFeedSender> followList;
    public List<InspireCompositeCnt.Work> likeList;
    public long timeline;
    public String type;
    public InspireFeedSender user;
}
