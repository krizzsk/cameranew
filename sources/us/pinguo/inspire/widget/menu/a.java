package us.pinguo.inspire.widget.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.inspire.util.k;
import vStudio.Android.Camera360.R;
/* compiled from: InspireMenuAdapter.java */
/* loaded from: classes9.dex */
public class a extends k<String> {

    /* compiled from: InspireMenuAdapter.java */
    /* renamed from: us.pinguo.inspire.widget.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0408a {
        TextView a;

        C0408a(a aVar) {
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            C0408a c0408a = new C0408a(this);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inspire_menu_item, (ViewGroup) null);
            c0408a.a = (TextView) inflate.findViewById(R.id.inspire_menu_txt);
            inflate.setTag(c0408a);
            view = inflate;
        }
        C0408a c0408a2 = (C0408a) view.getTag();
        String item = getItem(i2);
        if (item == null) {
            item = "";
        }
        c0408a2.a.setText(item);
        return view;
    }
}
