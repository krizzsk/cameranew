package us.pinguo.camera2020.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.h0;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.database.sticker.StickerCategory;
/* compiled from: CategoryPagerAdapter.kt */
/* loaded from: classes3.dex */
public final class k extends PagerAdapter {
    private final List<StickerCategory> a;
    private final ArrayList<RecyclerView> b;
    private q c;

    public k(List<StickerCategory> data) {
        kotlin.z.d h2;
        kotlin.jvm.internal.s.h(data, "data");
        this.a = data;
        this.b = new ArrayList<>(data.size());
        h2 = kotlin.z.j.h(0, data.size());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            ((h0) it).nextInt();
            this.b.add(null);
        }
    }

    public final List<RecyclerView> a() {
        return this.b;
    }

    public final kotlin.u b(int i2, List<Sticker> stickerList) {
        kotlin.jvm.internal.s.h(stickerList, "stickerList");
        RecyclerView recyclerView = this.b.get(i2);
        RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
        u uVar = adapter instanceof u ? (u) adapter : null;
        if (uVar == null) {
            return null;
        }
        uVar.n(stickerList);
        return kotlin.u.a;
    }

    public final void c(q listener) {
        kotlin.jvm.internal.s.h(listener, "listener");
        this.c = listener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i2, Object object) {
        kotlin.jvm.internal.s.h(container, "container");
        kotlin.jvm.internal.s.h(object, "object");
        container.removeView(this.b.get(i2));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        kotlin.jvm.internal.s.h(object, "object");
        int i2 = 0;
        for (StickerCategory stickerCategory : this.a) {
            if (kotlin.jvm.internal.s.c(stickerCategory.getTopic_id(), object)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i2) {
        kotlin.jvm.internal.s.h(container, "container");
        ArrayList<RecyclerView> arrayList = this.b;
        RecyclerView recyclerView = arrayList.get(i2);
        if (recyclerView == null) {
            Context context = container.getContext();
            StickerCategory stickerCategory = this.a.get(i2);
            RecyclerView recyclerView2 = new RecyclerView(context);
            recyclerView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            q qVar = this.c;
            if (qVar != null) {
                qVar.a(i2, stickerCategory.getTopic_id(), recyclerView2);
            }
            arrayList.set(i2, recyclerView2);
            recyclerView = recyclerView2;
        }
        if (recyclerView.getParent() == null) {
            container.addView(recyclerView);
        }
        return recyclerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(object, "object");
        return kotlin.jvm.internal.s.c(object, view);
    }
}
