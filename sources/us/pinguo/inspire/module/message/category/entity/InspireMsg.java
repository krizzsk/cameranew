package us.pinguo.inspire.module.message.category.entity;

import us.pinguo.inspire.module.message.category.type.InspireRelation;
/* loaded from: classes9.dex */
public class InspireMsg {
    public static final String TYPE_AT = "at";
    public static final String TYPE_AWAWRDS = "collect";
    public static final String TYPE_COMMENT = "comment";
    public static final String TYPE_FLOWER = "gift";
    public static final String TYPE_FOLLOW = "follow";
    public static final String TYPE_LIKE = "like";
    public static final String TYPE_MERGE_VOTE = "mergeVote";
    public static final String TYPE_RANKING = "ranking";
    public static final String TYPE_RELAY = "relay";
    public static final String TYPE_VOTE = "vote";
    public InspireMsgData data;
    public String msgId;
    public String photoUrl;
    private int relation = InspireRelation.FANS.ordinal();
    public Sender sender;
    public double timeline;
    public String type;
    public int userCount;

    public int hashCode() {
        String str = this.msgId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Sender sender = this.sender;
        int hashCode3 = (hashCode2 + (sender != null ? sender.hashCode() : 0)) * 31;
        InspireMsgData inspireMsgData = this.data;
        int hashCode4 = hashCode3 + (inspireMsgData != null ? inspireMsgData.hashCode() : 0);
        long doubleToLongBits = Double.doubleToLongBits(this.timeline);
        int i2 = ((((hashCode4 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.userCount) * 31;
        String str3 = this.photoUrl;
        return i2 + (str3 != null ? str3.hashCode() : 0);
    }
}
