package us.pinguo.inspire.y.a;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
/* compiled from: BasePagerViewHolder.java */
/* loaded from: classes9.dex */
public class c {
    private SparseArray<View> a = new SparseArray<>();
    public View b;

    public c(View view) {
        this.b = view;
    }

    public <T extends View> T a(int i2) {
        T t = (T) this.a.get(i2);
        if (t == null) {
            T t2 = (T) this.b.findViewById(i2);
            this.a.put(i2, t2);
            return t2;
        }
        return t;
    }

    public void b(int i2, View.OnClickListener onClickListener) {
        View a = a(i2);
        if (a != null) {
            a.setOnClickListener(onClickListener);
        }
    }

    public void c(int i2, int i3) {
        ((TextView) a(i2)).setText(i3);
    }

    public void d(int i2, CharSequence charSequence) {
        TextView textView = (TextView) a(i2);
        if (charSequence == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
    }

    public void e(int i2, int i3) {
        a(i2).setVisibility(i3);
    }
}
