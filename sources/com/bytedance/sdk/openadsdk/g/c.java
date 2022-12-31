package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
/* compiled from: TTAdNetDepend.java */
/* loaded from: classes.dex */
public class c implements com.bytedance.sdk.adnet.c.b {
    String a = "sp_multi_ttadnet_config";
    private Context b;

    public c(Context context) {
        this.b = context;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int a() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public Address a(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String b() {
        return "pangle_sdk";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String c() {
        return TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int d() {
        return 3154;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String e() {
        return j.a(this.b);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String[] f() {
        String[] strArr = {"dm16-useast1a.byteoversea.com", "dm16-useast2a.byteoversea.com"};
        String t = o.h().t();
        if (!TextUtils.isEmpty(t)) {
            if ("SG".equals(t)) {
                return new String[]{"dm16-alisg.byteoversea.com"};
            }
            return "CN".equals(t) ? new String[]{"dm.toutiao.com", "dm-hl.toutiao.com", "dm-lq.toutiao.com", "dm.bytedance.com"} : strArr;
        }
        int l2 = ab.l();
        if (l2 == 2) {
            return new String[]{"dm16-alisg.byteoversea.com"};
        }
        return l2 == 1 ? new String[]{"dm.toutiao.com", "dm-hl.toutiao.com", "dm-lq.toutiao.com", "dm.bytedance.com"} : strArr;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.d.a.b(this.a, str, str2);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.a, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.a, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.a, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.a, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(this.a, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
