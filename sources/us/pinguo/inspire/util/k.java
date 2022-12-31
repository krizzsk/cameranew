package us.pinguo.inspire.util;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseArrayAdapter.java */
/* loaded from: classes9.dex */
public abstract class k<T> extends BaseAdapter {
    protected List<T> a = new ArrayList();

    public void a(List<T> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= this.a.size()) {
            return null;
        }
        return this.a.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }
}
