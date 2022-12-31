package us.pinguo.repository2020.manager;

import android.content.Context;
import com.pinguo.lib.GsonUtilKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.entity.ShopData;
import us.pinguo.repository2020.entity.ShopResponse;
import us.pinguo.repository2020.utils.o;
/* compiled from: FilterCache.kt */
/* loaded from: classes6.dex */
public final class k {
    private final ShopData b() {
        String str = FilterRepository.a.B() ? "shop/shop_zh_cn.json" : "shop/shop_en.json";
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        ShopData data = ((ShopResponse) GsonUtilKt.getCachedGson().j(c(str, b), ShopResponse.class)).getData();
        s.e(data);
        return data;
    }

    private final String c(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        String sb2 = sb.toString();
        s.g(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final ShopData a() {
        String i2 = o.a.i("sp_key_filter_json", null, "filterCache");
        if (i2 == null) {
            return b();
        }
        Object j2 = GsonUtilKt.getCachedGson().j(i2, ShopData.class);
        s.g(j2, "{\n            cachedGson…ta::class.java)\n        }");
        return (ShopData) j2;
    }

    public final void d(ShopData shopData) {
        s.h(shopData, "shopData");
        o.a.u("sp_key_filter_json", GsonUtilKt.getCachedGson().s(shopData), "filterCache");
    }
}
