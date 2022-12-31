package us.pinguo.user.ui.p0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import us.pinguo.user.R;
/* compiled from: SnsSiteAdapter.java */
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private int[] a;
    private String[] b;

    public c(int[] iArr, int[] iArr2, String[] strArr) {
        this.b = strArr;
        this.a = iArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        String[] strArr = this.b;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        String[] strArr = this.b;
        if (strArr != null) {
            return strArr[i2];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater");
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_third_site_item, (ViewGroup) null, false);
        }
        view.setTag(this.b[i2]);
        ((ImageView) view.findViewById(R.id.id_third_site_icon)).setImageResource(this.a[i2]);
        return view;
    }
}
