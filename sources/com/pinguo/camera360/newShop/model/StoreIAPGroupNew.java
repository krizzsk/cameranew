package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreIAPGroupNew implements Serializable {
    public Data data;
    public String message;
    public double serverTime;
    public int status;

    /* loaded from: classes3.dex */
    public class Data implements Serializable {
        public long intervalTime;
        public List<StoreIAPItem> lists;
        public int version;

        public Data() {
        }
    }
}
