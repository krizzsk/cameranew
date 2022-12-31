package us.pinguo.inspire.module.discovery.entity.dicovery;

import java.util.List;
import us.pinguo.inspire.model.InspireTask;
/* loaded from: classes9.dex */
public class DiscoverySquareResp {
    public List<SquareBanner> banner;
    public List<DiscoveryFall> falls;
    public List<DiscoveryFixed> fixedList;
    public List<DiscoveryRec> rec;
    public int sp;
    public List<InspireTask> taskPos;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiscoverySquareResp discoverySquareResp = (DiscoverySquareResp) obj;
        if (this.sp != discoverySquareResp.sp) {
            return false;
        }
        List<SquareBanner> list = this.banner;
        if (list == null ? discoverySquareResp.banner == null : list.equals(discoverySquareResp.banner)) {
            List<DiscoveryRec> list2 = this.rec;
            if (list2 == null ? discoverySquareResp.rec == null : list2.equals(discoverySquareResp.rec)) {
                List<DiscoveryFixed> list3 = this.fixedList;
                if (list3 == null ? discoverySquareResp.fixedList == null : list3.equals(discoverySquareResp.fixedList)) {
                    List<DiscoveryFall> list4 = this.falls;
                    List<DiscoveryFall> list5 = discoverySquareResp.falls;
                    return list4 != null ? list4.equals(list5) : list5 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        List<SquareBanner> list = this.banner;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<DiscoveryRec> list2 = this.rec;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<DiscoveryFixed> list3 = this.fixedList;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<DiscoveryFall> list4 = this.falls;
        return ((hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.sp;
    }
}
