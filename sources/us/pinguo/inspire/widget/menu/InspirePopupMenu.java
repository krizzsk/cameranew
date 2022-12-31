package us.pinguo.inspire.widget.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.Arrays;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspirePopupMenu {
    private Context a;
    private PopupWindow b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private ListView f11379d;

    /* renamed from: e  reason: collision with root package name */
    private a f11380e;

    /* renamed from: f  reason: collision with root package name */
    private View f11381f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f11382g;

    /* renamed from: h  reason: collision with root package name */
    private int f11383h;

    public InspirePopupMenu(Context context) {
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.inspire_menu_item, (ViewGroup) null);
        this.f11381f = inflate;
        this.f11382g = (TextView) inflate.findViewById(R.id.inspire_menu_txt);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.inspire_menu_layout, (ViewGroup) null);
        this.c = inflate2;
        this.f11379d = (ListView) inflate2.findViewById(R.id.inspire_menu_listview);
        a aVar = new a();
        this.f11380e = aVar;
        this.f11379d.setAdapter((ListAdapter) aVar);
        PopupWindow popupWindow = new PopupWindow(this.c, -2, -2, true);
        this.b = popupWindow;
        popupWindow.setTouchable(true);
        this.b.setBackgroundDrawable(new ColorDrawable(0));
        this.b.setAnimationStyle(R.style.popup_menu);
    }

    public void a() {
        this.b.dismiss();
    }

    public InspirePopupMenu b(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String str = "";
            for (String str2 : strArr) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
            this.f11382g.setText(str);
            this.f11381f.measure(View.MeasureSpec.makeMeasureSpec(us.pinguo.foundation.t.b.a.j(this.a), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(32767, Integer.MIN_VALUE));
            int measuredWidth = this.f11381f.getMeasuredWidth();
            int i2 = this.f11383h;
            if (measuredWidth <= i2) {
                measuredWidth = i2;
            }
            ViewGroup.LayoutParams layoutParams = this.f11379d.getLayoutParams();
            layoutParams.width = measuredWidth;
            this.f11379d.setLayoutParams(layoutParams);
            this.f11380e.a(Arrays.asList(strArr));
        }
        return this;
    }

    public InspirePopupMenu c(int i2) {
        this.f11383h = i2;
        return this;
    }

    public InspirePopupMenu d(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.f11379d.setOnItemClickListener(onItemClickListener);
        }
        return this;
    }

    public void e(View view, int i2, int i3) {
        this.b.showAsDropDown(view, i2, i3);
    }
}
