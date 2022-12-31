package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: Topic.kt */
/* loaded from: classes6.dex */
public final class Topic {
    private final List<String> cids;
    private final String name;
    private final Integer off_time;
    private final Integer onsale_time;
    private final List<String> pids;
    private final String tag;
    private final String tid;

    public Topic(List<String> list, String str, Integer num, Integer num2, List<String> list2, String str2, String str3) {
        this.cids = list;
        this.name = str;
        this.off_time = num;
        this.onsale_time = num2;
        this.pids = list2;
        this.tag = str2;
        this.tid = str3;
    }

    public static /* synthetic */ Topic copy$default(Topic topic, List list, String str, Integer num, Integer num2, List list2, String str2, String str3, int i2, Object obj) {
        List<String> list3 = list;
        if ((i2 & 1) != 0) {
            list3 = topic.cids;
        }
        if ((i2 & 2) != 0) {
            str = topic.name;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            num = topic.off_time;
        }
        Integer num3 = num;
        if ((i2 & 8) != 0) {
            num2 = topic.onsale_time;
        }
        Integer num4 = num2;
        List<String> list4 = list2;
        if ((i2 & 16) != 0) {
            list4 = topic.pids;
        }
        List list5 = list4;
        if ((i2 & 32) != 0) {
            str2 = topic.tag;
        }
        String str5 = str2;
        if ((i2 & 64) != 0) {
            str3 = topic.tid;
        }
        return topic.copy(list3, str4, num3, num4, list5, str5, str3);
    }

    public final List<String> component1() {
        return this.cids;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.off_time;
    }

    public final Integer component4() {
        return this.onsale_time;
    }

    public final List<String> component5() {
        return this.pids;
    }

    public final String component6() {
        return this.tag;
    }

    public final String component7() {
        return this.tid;
    }

    public final Topic copy(List<String> list, String str, Integer num, Integer num2, List<String> list2, String str2, String str3) {
        return new Topic(list, str, num, num2, list2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Topic) {
            Topic topic = (Topic) obj;
            return s.c(this.cids, topic.cids) && s.c(this.name, topic.name) && s.c(this.off_time, topic.off_time) && s.c(this.onsale_time, topic.onsale_time) && s.c(this.pids, topic.pids) && s.c(this.tag, topic.tag) && s.c(this.tid, topic.tid);
        }
        return false;
    }

    public final List<String> getCids() {
        return this.cids;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOff_time() {
        return this.off_time;
    }

    public final Integer getOnsale_time() {
        return this.onsale_time;
    }

    public final List<String> getPids() {
        return this.pids;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        List<String> list = this.cids;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.off_time;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.onsale_time;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<String> list2 = this.pids;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.tag;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tid;
        return hashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Topic(cids=" + this.cids + ", name=" + ((Object) this.name) + ", off_time=" + this.off_time + ", onsale_time=" + this.onsale_time + ", pids=" + this.pids + ", tag=" + ((Object) this.tag) + ", tid=" + ((Object) this.tid) + ')';
    }
}
