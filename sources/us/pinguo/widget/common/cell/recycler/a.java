package us.pinguo.widget.common.cell.recycler;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.widget.common.cell.recycler.b;
import us.pinguo.widget.common.cell.recycler.c;
/* compiled from: BaseRecyclerAdapter.java */
/* loaded from: classes6.dex */
public class a<C extends us.pinguo.widget.common.cell.recycler.b, VH extends c> extends RecyclerView.Adapter {
    protected RecyclerView mRecyclerView;
    protected List<C> mCells = new ArrayList();
    protected AtomicBoolean mBeginChange = new AtomicBoolean(false);
    private List<C> mTempList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseRecyclerAdapter.java */
    /* renamed from: us.pinguo.widget.common.cell.recycler.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0465a extends DiffUtil.Callback {
        C0465a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i2, int i3) {
            us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) a.this.mTempList.get(i2);
            C c = a.this.mCells.get(i3);
            boolean areContentsTheSame = bVar.areContentsTheSame(c);
            if (areContentsTheSame) {
                a.this.mCells.set(i3, bVar);
                c.setData(bVar.getData());
            }
            return areContentsTheSame;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i2, int i3) {
            return ((us.pinguo.widget.common.cell.recycler.b) a.this.mTempList.get(i2)).areItemsTheSame(a.this.mCells.get(i3));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @Nullable
        public Object getChangePayload(int i2, int i3) {
            return ((us.pinguo.widget.common.cell.recycler.b) a.this.mTempList.get(i2)).getChangePayload(a.this.mCells.get(i3));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return a.this.mCells.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return a.this.mTempList.size();
        }
    }

    /* compiled from: BaseRecyclerAdapter.java */
    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public void add(C c) {
        if (c == null) {
            return;
        }
        int itemCount = getItemCount();
        this.mCells.add(c);
        if (this.mBeginChange.get()) {
            return;
        }
        if (itemCount == 0) {
            itemCount = 0;
        }
        notifyItemInserted(itemCount);
    }

    public void addAll(Collection<? extends C> collection) {
        addAll(getItemCount(), collection);
    }

    public void beginChange() {
        this.mTempList = new ArrayList(this.mCells);
        this.mBeginChange.set(true);
    }

    public void clear() {
        int size = this.mCells.size();
        this.mCells.clear();
        if (this.mBeginChange.get()) {
            return;
        }
        notifyItemRangeRemoved(0, size);
    }

    public void endChange(boolean z) {
        endChange(z, true);
    }

    public List<C> getCells() {
        return this.mCells;
    }

    public int getFirstPositionByType(int i2) {
        int itemCount = getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            if (getItem(i3).getType() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public C getItem(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.mCells.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<C> list = this.mCells;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        C item = getItem(i2);
        if (item != null) {
            return item.getType();
        }
        throw new IllegalArgumentException("position:" + i2);
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public int indexOf(C c) {
        List<C> list = this.mCells;
        if (list == null) {
            return -1;
        }
        return list.indexOf(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        onBindViewHolder(viewHolder, i2, null);
    }

    public void onDestroyView() {
        for (int i2 = 0; i2 < this.mCells.size(); i2++) {
            this.mCells.get(i2).onDestroyView();
        }
        this.mRecyclerView = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (viewHolder instanceof c) {
            ((c) viewHolder).onViewRecycled();
        }
    }

    public void remove(C c) {
        remove(indexOf(c));
    }

    public void set(List<C> list) {
        List<C> list2;
        if (list == null || (list2 = this.mCells) == null) {
            return;
        }
        int size = list2.size();
        int size2 = list.size();
        this.mCells.clear();
        this.mCells.addAll(list);
        if (this.mBeginChange.get()) {
            return;
        }
        if (size == 0) {
            notifyItemRangeInserted(0, size2);
        } else if (size == size2) {
            notifyItemRangeChanged(0, size2);
        } else if (size < size2) {
            notifyItemRangeChanged(0, size);
            notifyItemRangeInserted(size, size2 - size);
        } else {
            notifyItemRangeChanged(0, size2);
            notifyItemRangeRemoved(size2, size - size2);
        }
    }

    public void setCells(List<C> list) {
        this.mCells = list;
    }

    public void smartSet(List<C> list) {
        if (list == null || this.mCells == null) {
            return;
        }
        beginChange();
        set(list);
        endChange(true, false);
    }

    public void addAll(int i2, Collection<? extends C> collection) {
        if (collection != null && i2 >= 0) {
            this.mCells.addAll(i2, collection);
            if (this.mBeginChange.get()) {
                return;
            }
            notifyItemRangeInserted(i2, collection.size());
        }
    }

    public void endChange(boolean z, boolean z2) {
        this.mBeginChange.set(false);
        if (z) {
            DiffUtil.calculateDiff(new C0465a(), z2).dispatchUpdatesTo(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        C item = getItem(i2);
        if (item != null) {
            item.setAdapter(this);
            item.setRecyclerView(this.mRecyclerView);
            item.bindViewHolder((c) viewHolder, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.mRecyclerView = (RecyclerView) viewGroup;
        C item = getItem(getFirstPositionByType(i2));
        if (item == null) {
            return null;
        }
        return (VH) item.createViewHolder(viewGroup);
    }

    public void remove(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return;
        }
        this.mCells.remove(i2);
        if (this.mBeginChange.get()) {
            return;
        }
        notifyItemRemoved(i2);
    }

    public void add(int i2, C c) {
        if (c == null) {
            return;
        }
        this.mCells.add(i2, c);
        if (this.mBeginChange.get()) {
            return;
        }
        notifyItemInserted(i2);
    }

    public void smartSet(int i2, List<C> list, b bVar) {
        if (list == null || this.mCells == null) {
            return;
        }
        if (i2 > 0) {
            list.addAll(0, new ArrayList(this.mCells.subList(0, i2)));
        }
        beginChange();
        set(list);
        endChange(true);
        if (bVar != null) {
            bVar.a();
        }
    }

    public void remove(int i2, int i3) {
        if (i2 > i3) {
            us.pinguo.common.log.a.e("start:" + i2 + " is bigger than end:" + i3, new Object[0]);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int itemCount = getItemCount() - 1;
        if (i3 > itemCount) {
            i3 = itemCount;
        }
        for (int i4 = i3; i4 >= i2; i4--) {
            this.mCells.remove(i4);
        }
        if (this.mBeginChange.get()) {
            return;
        }
        notifyItemRangeRemoved(i2, (i3 - i2) + 1);
    }
}
