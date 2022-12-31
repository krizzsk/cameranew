package us.pinguo.inspire.y.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.y.a.b;
/* compiled from: BasePagerAdapter.kt */
/* loaded from: classes9.dex */
public class a<DATA, CELL extends b<DATA, c>> extends PagerAdapter {
    private final int MAX_CACHE_VIEW;
    private ArrayList<CELL> mDataList;
    private SparseArray<LinkedList<c>> mViewCaches;

    public a(List<? extends CELL> dataList) {
        s.h(dataList, "dataList");
        this.MAX_CACHE_VIEW = 5;
        this.mDataList = new ArrayList<>(dataList);
        this.mViewCaches = new SparseArray<>();
    }

    private final void cacheItem(CELL cell) {
        int type = cell.getType();
        LinkedList<c> linkedList = this.mViewCaches.get(type);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.mViewCaches.put(type, linkedList);
        }
        if (cell.getMViewHolder() == null || linkedList.size() >= this.MAX_CACHE_VIEW) {
            return;
        }
        c mViewHolder = cell.getMViewHolder();
        s.e(mViewHolder);
        linkedList.add(mViewHolder);
    }

    private final c popViewFromCache(CELL cell) {
        LinkedList<c> linkedList = this.mViewCaches.get(cell == null ? -1 : cell.getType());
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        return linkedList.pop();
    }

    public final void addItems(List<? extends CELL> itemList) {
        s.h(itemList, "itemList");
        ArrayList<CELL> arrayList = this.mDataList;
        s.e(arrayList);
        arrayList.addAll(itemList);
    }

    public final void clear() {
        ArrayList<CELL> arrayList = this.mDataList;
        if (arrayList != null) {
            s.e(arrayList);
            arrayList.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i2, Object object) {
        s.h(container, "container");
        s.h(object, "object");
        b bVar = (b) object;
        c mViewHolder = bVar.getMViewHolder();
        container.removeView(mViewHolder == null ? null : mViewHolder.b);
        cacheItem(bVar);
        bVar.onViewRecycled();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        ArrayList<CELL> arrayList = this.mDataList;
        if (arrayList == null) {
            return 0;
        }
        s.e(arrayList);
        return arrayList.size();
    }

    public final CELL getItem(int i2) {
        if (this.mDataList == null || i2 >= getCount() || i2 < 0) {
            return null;
        }
        ArrayList<CELL> arrayList = this.mDataList;
        s.e(arrayList);
        return arrayList.get(i2);
    }

    public final int getItemIndex(CELL item) {
        s.h(item, "item");
        ArrayList<CELL> arrayList = this.mDataList;
        if (arrayList == null) {
            return -1;
        }
        s.e(arrayList);
        return arrayList.indexOf(item);
    }

    protected final int getMAX_CACHE_VIEW() {
        return this.MAX_CACHE_VIEW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<CELL> getMDataList() {
        return this.mDataList;
    }

    protected final SparseArray<LinkedList<c>> getMViewCaches() {
        return this.mViewCaches;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i2) {
        s.h(container, "container");
        CELL item = getItem(i2);
        c popViewFromCache = popViewFromCache(item);
        if (popViewFromCache == null) {
            popViewFromCache = item == null ? null : item.createViewHolder(container);
        }
        if (popViewFromCache != null) {
            container.addView(popViewFromCache.b);
            if (item != null) {
                item.bindViewHolder(popViewFromCache);
            }
        }
        s.e(item);
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        s.h(view, "view");
        s.h(object, "object");
        c mViewHolder = ((b) object).getMViewHolder();
        return view == (mViewHolder == null ? null : mViewHolder.b);
    }

    public final void removeItem(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 < getCount()) {
            z = true;
        }
        if (z) {
            ArrayList<CELL> arrayList = this.mDataList;
            s.e(arrayList);
            if (arrayList.size() > 0) {
                ArrayList<CELL> arrayList2 = this.mDataList;
                s.e(arrayList2);
                arrayList2.remove(i2);
            }
        }
    }

    protected final void setMDataList(ArrayList<CELL> arrayList) {
        this.mDataList = arrayList;
    }

    protected final void setMViewCaches(SparseArray<LinkedList<c>> sparseArray) {
        s.h(sparseArray, "<set-?>");
        this.mViewCaches = sparseArray;
    }
}
