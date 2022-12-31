package us.pinguo.inspire.module.feeds.model;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class LiveCnt {
    public String cover;
    public String desc;
    public String roomId;
    public Urls urls;

    /* loaded from: classes9.dex */
    public static class Urls {
        public String origin;
    }

    public String getCover() {
        return TextUtils.isEmpty(this.cover) ? "http://phototask.c360dn.com/Flz9M_8E4jLTHYsc-DB-hB5NuKNe" : this.cover;
    }
}
