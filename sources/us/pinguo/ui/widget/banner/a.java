package us.pinguo.ui.widget.banner;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* compiled from: BaseArrayAdapter.java */
/* loaded from: classes6.dex */
public abstract class a<T> extends BaseAdapter {
    private List<T> mList = new ArrayList();

    public void add(T t) {
        this.mList.add(t);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> collection) {
        this.mList.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.mList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public void remove(T t) {
        this.mList.remove(t);
        notifyDataSetChanged();
    }

    public void replace(int i2, T t) {
        this.mList.remove(i2);
        this.mList.add(i2, t);
        notifyDataSetChanged();
    }

    public void set(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void add(int i2, T t) {
        this.mList.add(i2, t);
        notifyDataSetChanged();
    }

    public void remove(int i2) {
        if (i2 < 0 || i2 >= this.mList.size()) {
            return;
        }
        this.mList.remove(i2);
        notifyDataSetChanged();
    }
}
