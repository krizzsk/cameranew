package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.UnlockType;
import vStudio.Android.Camera360.R;
/* compiled from: StoreVipAdapter.kt */
/* loaded from: classes3.dex */
public final class k extends RecyclerView.Adapter<l> {
    private final Context a;
    private final int b;
    private final List<ShowPkg> c;

    public k(Context context, ShowScene showScene, int i2) {
        s.h(context, "context");
        s.h(showScene, "showScene");
        this.a = context;
        this.b = i2;
        this.c = new ArrayList();
        for (ShowPkg pkg : showScene.getShowPkgs()) {
            if (pkg.getVip() != 0 && !TextUtils.isEmpty(pkg.getVipBanner())) {
                List<ShowPkg> list = this.c;
                s.g(pkg, "pkg");
                list.add(pkg);
            }
        }
    }

    public final void e(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        int size = this.c.size();
        while (i2 < size) {
            int i3 = i2 + 1;
            if (s.c(str, this.c.get(i2).getId())) {
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void f(UnlockType ut) {
        s.h(ut, "ut");
        int size = this.c.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (ut == this.c.get(i2).getType()) {
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(l holder, int i2) {
        s.h(holder, "holder");
        ShowPkg showPkg = this.c.get(i2);
        holder.a(showPkg);
        us.pinguo.camera360.shop.data.k.a.a(this.b, showPkg);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public l onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View view = View.inflate(this.a, R.layout.layout_store_vip_item, null);
        s.g(view, "view");
        return new l(view, this.a);
    }
}
