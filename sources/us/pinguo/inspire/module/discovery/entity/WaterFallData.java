package us.pinguo.inspire.module.discovery.entity;

import java.util.List;
import us.pinguo.inspire.module.message.category.entity.Sender;
/* loaded from: classes9.dex */
public class WaterFallData {
    public int awardsCount;
    public int commentsCount;
    public String content;
    public int height;
    public Sender sender;
    public String uri;
    public WaterFallAd waterFallAd;
    public List<WaterFallWork> waterFallWorks;
    public int width;
    public String workId;

    public WaterFallData(String str, Sender sender, int i2, int i3, String str2, String str3, int i4, int i5) {
        this(null, str, sender, i2, i3, str2, str3, i4, i5);
    }

    public WaterFallData(List<WaterFallWork> list, String str, Sender sender, int i2, int i3, String str2, String str3, int i4, int i5) {
        this.waterFallWorks = list;
        this.workId = str;
        this.sender = sender;
        this.awardsCount = i2;
        this.commentsCount = i3;
        this.content = str2;
        this.height = i5;
        this.uri = str3;
        this.width = i4;
    }

    public WaterFallData() {
    }
}
