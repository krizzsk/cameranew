package us.pinguo.inspire.model;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class FansInfo implements Serializable {
    private static final long serialVersionUID = -1228650563213815173L;
    public String avatar;
    public String userId;

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.avatar;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
