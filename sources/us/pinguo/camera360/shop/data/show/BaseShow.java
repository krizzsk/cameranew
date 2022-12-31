package us.pinguo.camera360.shop.data.show;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class BaseShow implements Serializable {
    private String id;
    private int vip = 0;

    public BaseShow(String str) {
        this.id = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseShow) {
            return this.id.equals(((BaseShow) obj).id);
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public int getVip() {
        return this.vip;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean isVip() {
        return getVip() != 0;
    }

    public void setVip(int i2) {
        this.vip = i2;
    }
}
