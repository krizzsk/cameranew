package us.pinguo.edit2020.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.b0;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.l;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.utils.k;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
import us.pinguo.repository2020.database.staticsticker.StaticStickerTable;
/* compiled from: StaticStickerStoreViewModel.kt */
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel extends ViewModel {
    private final e<k<us.pinguo.edit2020.model.f.b>> a;
    private final kotlinx.coroutines.flow.c<k<us.pinguo.edit2020.model.f.b>> b;
    private final e<k<ShopDetail>> c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlinx.coroutines.flow.c<k<ShopDetail>> f10816d;

    /* renamed from: e  reason: collision with root package name */
    private final e<d> f10817e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlinx.coroutines.flow.c<d> f10818f;

    /* renamed from: g  reason: collision with root package name */
    private final e<List<StaticSticker>> f10819g;

    /* renamed from: h  reason: collision with root package name */
    private final kotlinx.coroutines.flow.c<List<StaticSticker>> f10820h;

    /* renamed from: i  reason: collision with root package name */
    private final e<Integer> f10821i;

    /* renamed from: j  reason: collision with root package name */
    private final kotlinx.coroutines.flow.c<Integer> f10822j;

    /* renamed from: k  reason: collision with root package name */
    private final e<Integer> f10823k;

    /* renamed from: l  reason: collision with root package name */
    private final kotlinx.coroutines.flow.c<Integer> f10824l;
    private boolean m;

    public StaticStickerStoreViewModel() {
        e<k<us.pinguo.edit2020.model.f.b>> b = g.b(-2, null, null, 6, null);
        this.a = b;
        this.b = kotlinx.coroutines.flow.e.z(b);
        e<k<ShopDetail>> b2 = g.b(0, null, null, 7, null);
        this.c = b2;
        this.f10816d = kotlinx.coroutines.flow.e.z(b2);
        e<d> b3 = g.b(0, null, null, 7, null);
        this.f10817e = b3;
        this.f10818f = kotlinx.coroutines.flow.e.z(b3);
        e<List<StaticSticker>> b4 = g.b(0, null, null, 7, null);
        this.f10819g = b4;
        this.f10820h = kotlinx.coroutines.flow.e.z(b4);
        e<Integer> b5 = g.b(0, null, null, 7, null);
        this.f10821i = b5;
        this.f10822j = kotlinx.coroutines.flow.e.z(b5);
        e<Integer> b6 = g.b(0, null, null, 7, null);
        this.f10823k = b6;
        this.f10824l = kotlinx.coroutines.flow.e.z(b6);
    }

    public final void g(String pid) {
        s.h(pid, "pid");
        StaticStickerManager.a.i(pid);
    }

    public final void h(List<String> idList) {
        s.h(idList, "idList");
        StaticStickerManager.a.k(idList);
    }

    public final void i(StaticStickerCategory stickerCategory) {
        s.h(stickerCategory, "stickerCategory");
        StaticStickerManager.a.m(stickerCategory, new StaticStickerStoreViewModel$downloadStickerPack$1(this, stickerCategory), null);
    }

    public final void j(String pid) {
        s.h(pid, "pid");
        l.d(ViewModelKt.getViewModelScope(this), null, null, new StaticStickerStoreViewModel$fetchShopDetail$1(this, null), 3, null);
        StaticStickerManager.a.n(pid, new StaticStickerStoreViewModel$fetchShopDetail$2(this));
    }

    public final kotlinx.coroutines.flow.c<k<us.pinguo.edit2020.model.f.b>> k() {
        return this.b;
    }

    public final void l() {
        StaticStickerManager.a.F(new StaticStickerStoreViewModel$getData$1(this));
    }

    public final kotlinx.coroutines.flow.c<k<ShopDetail>> m() {
        return this.f10816d;
    }

    public final kotlinx.coroutines.flow.c<Integer> n() {
        return this.f10822j;
    }

    public final void o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, StaticStickerTable> entry : StaticStickerManager.a.s().entrySet()) {
            StaticStickerTable value = entry.getValue();
            StaticSticker staticSticker = StaticStickerManager.a.y().get(value.getSid());
            if (staticSticker == null) {
                staticSticker = new StaticSticker(null, value.getSid(), value.getName(), value.getIcon(), null, value.getDisplay_md5(), value.getDown_url());
            }
            arrayList.add(staticSticker);
        }
        b0.x(arrayList);
        l.d(ViewModelKt.getViewModelScope(this), z0.c(), null, new StaticStickerStoreViewModel$getDownloaded$1(this, arrayList, null), 2, null);
    }

    public final Map<String, StaticStickerCategoryTable> p() {
        return StaticStickerManager.a.r();
    }

    public final kotlinx.coroutines.flow.c<List<StaticSticker>> q() {
        return this.f10820h;
    }

    public final kotlinx.coroutines.flow.c<Integer> r() {
        return this.f10824l;
    }

    public final kotlinx.coroutines.flow.c<d> s() {
        return this.f10818f;
    }

    public final StaticStickerCategory t(String pid) {
        s.h(pid, "pid");
        return StaticStickerManager.a.x().get(pid);
    }

    public final boolean u() {
        return this.m;
    }

    public final void v(d location) {
        s.h(location, "location");
        l.d(ViewModelKt.getViewModelScope(this), z0.c(), null, new StaticStickerStoreViewModel$jumpTo$1(this, location, null), 2, null);
    }

    public final void w() {
        l.d(ViewModelKt.getViewModelScope(this), null, null, new StaticStickerStoreViewModel$notifyRefresh$1(this, null), 3, null);
    }

    public final void x(boolean z) {
        this.m = z;
    }
}
