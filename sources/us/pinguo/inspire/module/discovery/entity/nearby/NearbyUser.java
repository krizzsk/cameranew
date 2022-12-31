package us.pinguo.inspire.module.discovery.entity.nearby;

import java.util.List;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.user.model.IRelation;
/* loaded from: classes9.dex */
public class NearbyUser implements IRelation {
    public String avatar;
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
        if (obj instanceof NearbyUser) {
            String str = this.userId;
            String str2 = ((NearbyUser) obj).userId;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    @Override // us.pinguo.user.model.IRelation
    public int getRelation() {
        return this.relation;
    }

    public int hashCode() {
        String str = this.userId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // us.pinguo.user.model.IRelation
    public void setRelation(int i2) {
        this.relation = i2;
    }
}
