package us.pinguo.inspire.module.message.category.vo;

import java.math.BigDecimal;
import java.util.List;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
/* loaded from: classes9.dex */
public class InspireMsgResp {
    public List<InspireMsg> list;
    public double serverTime;
    public BigDecimal sp;

    public int hashCode() {
        return this.list.hashCode();
    }
}
