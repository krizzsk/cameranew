package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class StoreOrderItem implements Serializable {
    public String createTime;
    public String icon;
    public String name;
    public String productId;
    public int status;
    public int type;

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StoreOrderItem) || (str = this.productId) == null) {
            return false;
        }
        return str.equals(((StoreOrderItem) obj).productId);
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.productId});
    }
}
