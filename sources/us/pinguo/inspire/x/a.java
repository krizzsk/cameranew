package us.pinguo.inspire.x;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import us.pinguo.inspire.profile.CountryZone;
/* compiled from: ZoneListAdapter.java */
/* loaded from: classes4.dex */
public abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private ArrayList<CountryZone.ListBean> a = new ArrayList<>();

    public a() {
        setHasStableIds(true);
    }

    public void addAll(Collection<? extends CountryZone.ListBean> collection) {
        if (collection != null) {
            this.a.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public CountryZone.ListBean e(int i2) {
        return this.a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return e(i2).hashCode();
    }
}
