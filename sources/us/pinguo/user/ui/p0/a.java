package us.pinguo.user.ui.p0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import org.slf4j.Marker;
import us.pinguo.user.R;
import us.pinguo.user.model.CityZones;
/* compiled from: CityZonsSpinnerAdapter.java */
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private Context a;
    private ArrayList<CityZones> b;
    private LayoutInflater c;

    public a(Context context, ArrayList<CityZones> arrayList) {
        this.a = context;
        this.c = LayoutInflater.from(context);
        this.b = arrayList;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public CityZones getItem(int i2) {
        return this.b.get(i2);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.c.inflate(R.layout.spinner_item_layout, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.zone)).setText(getItem(i2).getZone());
        ((TextView) view.findViewById(R.id.cc)).setText(Marker.ANY_NON_NULL_MARKER + getItem(i2).getCc());
        return view;
    }
}
