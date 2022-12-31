package com.pinguo.camera360.adv.oaid;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import d.b.a.a;
import us.pinguo.advconfigdata.Utils.SPUtils;
/* loaded from: classes3.dex */
public class MiitHelper implements a {
    private static MiitHelper b;
    private Context a = null;

    public static MiitHelper getInstance() {
        if (b == null) {
            b = new MiitHelper();
        }
        return b;
    }

    public String a() {
        return SPUtils.get(this.a, "oaid", "unknown").toString();
    }

    public void b(Context context) {
        this.a = context;
        MdidSdkHelper.InitSdk(context, true, this);
    }
}
