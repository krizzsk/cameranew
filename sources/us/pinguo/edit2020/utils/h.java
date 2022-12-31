package us.pinguo.edit2020.utils;

import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
/* compiled from: StaticStickerExtension.kt */
/* loaded from: classes4.dex */
public final class h {
    public static final String a(Map<String, StaticStickerCategoryTable> map, String pid, Integer num) {
        Integer completed;
        s.h(pid, "pid");
        if (map == null) {
            return b(num);
        }
        if (map.containsKey(pid)) {
            StaticStickerCategoryTable staticStickerCategoryTable = map.get(pid);
            boolean z = false;
            if (staticStickerCategoryTable != null && (completed = staticStickerCategoryTable.getCompleted()) != null && 1 == completed.intValue()) {
                z = true;
            }
            if (z) {
                return d.k(R.string.str_installed);
            }
        }
        return b(num);
    }

    private static final String b(Integer num) {
        if (num != null && num.intValue() == 0) {
            return d.k(R.string.shop_item_free);
        }
        if (us.pinguo.vip.proxy.b.a.f()) {
            return d.k(R.string.str_vip_free);
        }
        if (num != null && num.intValue() == 2) {
            return d.k(R.string.str_vip_limit);
        }
        return d.k(R.string.str_vip_only);
    }
}
