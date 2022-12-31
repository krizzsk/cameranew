package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreCategoryNew implements Serializable {
    public Data data;
    public String message;
    public double serverTime;
    public int status;

    /* loaded from: classes3.dex */
    public class Data implements Serializable {
        public List<StoreCategoryItem> items;

        public Data() {
        }
    }

    /* loaded from: classes3.dex */
    public class Lock implements Serializable {
        public Lock() {
        }
    }

    /* loaded from: classes3.dex */
    public class ShareTag implements Serializable {
        public String channel;
        public String tag;

        public ShareTag() {
        }
    }
}
