package com.pinguo.camera360.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import vStudio.Android.Camera360.R;
/* compiled from: OptionsSavePathAdapter.java */
/* loaded from: classes3.dex */
public class b extends com.pinguo.camera360.e.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OptionsSavePathAdapter.java */
    /* renamed from: com.pinguo.camera360.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0238b {
        TextView a;

        private C0238b() {
        }
    }

    public b(Context context, List list) {
        super(context, list);
    }

    private void c(C0238b c0238b, int i2) {
        c0238b.a.setText((String) ((HashMap) b().get(i2)).get("name"));
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0238b c0238b;
        if (view == null) {
            view = a().inflate(R.layout.options_save_path_item, (ViewGroup) null);
            c0238b = new C0238b();
            c0238b.a = (TextView) view.findViewById(R.id.tv_options_save_path);
            view.setTag(c0238b);
        } else {
            c0238b = (C0238b) view.getTag();
        }
        c(c0238b, i2);
        return view;
    }
}
