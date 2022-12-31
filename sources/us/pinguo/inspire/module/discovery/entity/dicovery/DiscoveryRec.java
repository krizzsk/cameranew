package us.pinguo.inspire.module.discovery.entity.dicovery;
/* loaded from: classes9.dex */
public class DiscoveryRec {
    public String categoryId;
    public String cover;
    public String desc;
    public String gotoUrl;
    public String recId;
    public String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiscoveryRec discoveryRec = (DiscoveryRec) obj;
        String str = this.recId;
        if (str == null ? discoveryRec.recId == null : str.equals(discoveryRec.recId)) {
            String str2 = this.categoryId;
            if (str2 == null ? discoveryRec.categoryId == null : str2.equals(discoveryRec.categoryId)) {
                String str3 = this.title;
                if (str3 == null ? discoveryRec.title == null : str3.equals(discoveryRec.title)) {
                    String str4 = this.desc;
                    if (str4 == null ? discoveryRec.desc == null : str4.equals(discoveryRec.desc)) {
                        String str5 = this.cover;
                        if (str5 == null ? discoveryRec.cover == null : str5.equals(discoveryRec.cover)) {
                            String str6 = this.gotoUrl;
                            String str7 = discoveryRec.gotoUrl;
                            return str6 != null ? str6.equals(str7) : str7 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.recId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.categoryId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.desc;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cover;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.gotoUrl;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }
}
