package us.pinguo.edit2020.model.f;

import java.util.List;
import java.util.Map;
import kotlin.collections.m0;
import kotlin.jvm.internal.o;
import us.pinguo.repository2020.database.staticsticker.ShopCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
/* compiled from: StaticStickerShopWrapper.kt */
/* loaded from: classes4.dex */
public final class b {
    private final Map<ShopCategory, List<StaticStickerCategory>> a;

    public b() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<ShopCategory, ? extends List<StaticStickerCategory>> map) {
        this.a = map;
    }

    public final Map<ShopCategory, List<StaticStickerCategory>> a() {
        return this.a;
    }

    public /* synthetic */ b(Map map, int i2, o oVar) {
        this((i2 & 1) != 0 ? m0.f() : map);
    }
}
