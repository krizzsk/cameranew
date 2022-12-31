package us.pinguo.inspire.module.discovery.entity.niceuser;

import java.util.List;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class NiceUser implements IRelation {
    public String avatar;
    public String cover;
    public String desc;
    public int distance;
    public int mark;
    public String nickname;
    public int relation;
    public int type;
    public String userId;
    public List<InspireWork> work;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NiceUser niceUser = (NiceUser) obj;
        if (this.distance == niceUser.distance && this.relation == niceUser.relation && this.type == niceUser.type && this.mark == niceUser.mark) {
            String str = this.userId;
            if (str == null ? niceUser.userId == null : str.equals(niceUser.userId)) {
                String str2 = this.avatar;
                if (str2 == null ? niceUser.avatar == null : str2.equals(niceUser.avatar)) {
                    String str3 = this.desc;
                    if (str3 == null ? niceUser.desc == null : str3.equals(niceUser.desc)) {
                        String str4 = this.nickname;
                        if (str4 == null ? niceUser.nickname == null : str4.equals(niceUser.nickname)) {
                            String str5 = this.cover;
                            if (str5 == null ? niceUser.cover == null : str5.equals(niceUser.cover)) {
                                List<InspireWork> list = this.work;
                                List<InspireWork> list2 = niceUser.work;
                                return list != null ? list.equals(list2) : list2 == null;
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
        return false;
    }

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        return this.relation;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.avatar;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.distance) * 31;
        String str3 = this.desc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nickname;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cover;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.relation) * 31;
        List<InspireWork> list = this.work;
        return ((((hashCode5 + (list != null ? list.hashCode() : 0)) * 31) + this.type) * 31) + this.mark;
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.relation = i2;
    }
}
