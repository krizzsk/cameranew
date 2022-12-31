package us.pinguo.inspire.module.contact.entry;

import java.util.List;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.InspireUser;
/* loaded from: classes9.dex */
public class Recommend {
    public static final int FROM_COMMON_FRIEND = 2;
    public static final int FROM_CONTACT = 1;
    public static final int FROM_MASTER = 3;
    public String from;
    public String nickName;
    public int pos = 1;
    public InspireUser user;
    public List<InspireWork> works;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Recommend) {
            Recommend recommend = (Recommend) obj;
            InspireUser inspireUser = this.user;
            if (inspireUser == null ? recommend.user == null : inspireUser.equals(recommend.user)) {
                String str = this.from;
                if (str == null ? recommend.from == null : str.equals(recommend.from)) {
                    String str2 = this.nickName;
                    String str3 = recommend.nickName;
                    return str2 != null ? str2.equals(str3) : str3 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        InspireUser inspireUser = this.user;
        int hashCode = (inspireUser != null ? inspireUser.hashCode() : 0) * 31;
        String str = this.from;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.nickName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
