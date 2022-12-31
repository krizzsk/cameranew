package us.pinguo.inspire.event;

import java.util.List;
import us.pinguo.inspire.module.contact.entry.Recommend;
/* loaded from: classes9.dex */
public class ShowProfileRecommendEvent {
    public String a;
    public List<Recommend> b;

    public ShowProfileRecommendEvent(String str, List<Recommend> list) {
        this.b = list;
        this.a = str;
    }
}
