package us.pinguo.inspire.module.message.category.vo;

import java.math.BigDecimal;
import java.util.List;
import us.pinguo.inspire.module.message.category.entity.SystemMsg;
/* loaded from: classes9.dex */
public class InspireSystemMsgResp {
    public List<SystemMsg> list;
    public BigDecimal sp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InspireSystemMsgResp inspireSystemMsgResp = (InspireSystemMsgResp) obj;
        BigDecimal bigDecimal = this.sp;
        if (bigDecimal == null ? inspireSystemMsgResp.sp == null : bigDecimal.equals(inspireSystemMsgResp.sp)) {
            List<SystemMsg> list = this.list;
            List<SystemMsg> list2 = inspireSystemMsgResp.list;
            return list != null ? list.equals(list2) : list2 == null;
        }
        return false;
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.sp;
        int hashCode = (bigDecimal != null ? bigDecimal.hashCode() : 0) * 31;
        List<SystemMsg> list = this.list;
        return hashCode + (list != null ? list.hashCode() : 0);
    }
}
