package us.pinguo.inspire.module.message.category.entity;

import com.rockerhieu.emoji.model.Emoticon;
import java.util.List;
import us.pinguo.inspire.model.InspirePhoto;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class InspireMsgData implements IRelation {
    public static final String MEDIA_TYPE_PHOTO = "photo";
    public static final String MEDIA_TYPE_VIDEO = "video";
    public static final int STATE_DELETE = -1;
    public String awardUrl;
    public String content;
    public int cpoint;
    public Emoticon emoticon;
    public String from;
    public String gameName;
    public String gotoUrl;
    public int height;
    public String homepage;
    public List<InspirePhoto> imgs;
    public String media;
    public String mid;
    public int picNum;
    public int ranking;
    public int relation;
    public int score;
    public int stat;
    public String taskId;
    public String tid;
    public String tips;
    public String url;
    public int wStat;
    public int width;

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        return this.relation;
    }

    public int hashCode() {
        String str = this.media;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.from;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.content;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        int hashCode4 = (((((((((((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.picNum) * 31) + this.height) * 31) + this.width) * 31) + this.ranking) * 31) + this.cpoint) * 31) + this.score) * 31;
        String str5 = this.gotoUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.awardUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.homepage;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.tips;
        int hashCode8 = (((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.relation) * 31;
        String str9 = this.taskId;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.mid;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.tid;
        return ((((hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31) + this.wStat) * 31) + this.stat;
    }

    public boolean isVideoMsg() {
        return "video".equals(this.media);
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.relation = i2;
    }
}
