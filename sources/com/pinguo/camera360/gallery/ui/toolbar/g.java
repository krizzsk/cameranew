package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumPickPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class g extends b {

    /* renamed from: d  reason: collision with root package name */
    private View f6657d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f6658e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f6659f;

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void f(Activity activity) {
        TextView textView = this.f6658e;
        if (textView != null) {
            textView.setText("");
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        this.a.setNavigationIcon(R.drawable.cancel);
        Spinner spinner2 = this.b;
        spinner2.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner2, 8);
        this.a.getMenu().close();
        this.a.getMenu().clear();
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.album_pick_toolbar_custom_view, (ViewGroup) null);
        this.f6657d = inflate;
        this.a.addView(inflate);
        this.f6658e = (TextView) this.f6657d.findViewById(R.id.select_pic_count);
        this.f6659f = (TextView) this.f6657d.findViewById(R.id.select_pic_text);
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void i(Activity activity) {
        if (this.a != null) {
            TextView textView = this.f6658e;
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            TextView textView2 = this.f6659f;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            this.a.getMenu().close();
            this.a.getMenu().clear();
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void p(int i2) {
        if (this.f6658e != null) {
            if (i2 == 0) {
                TextView textView = this.f6659f;
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
                TextView textView2 = this.f6658e;
                textView2.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView2, 8);
            } else {
                TextView textView3 = this.f6659f;
                textView3.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView3, 8);
                TextView textView4 = this.f6658e;
                textView4.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView4, 0);
                TextView textView5 = this.f6658e;
                textView5.setText(((Object) this.f6657d.getContext().getText(R.string.select_pic_count)) + "(" + i2 + ")");
            }
        }
        int size = this.a.getMenu().size();
        if (i2 != 0 && size == 0) {
            this.a.inflateMenu(q());
        } else if (size == 0 || i2 != 0) {
        } else {
            this.a.getMenu().close();
            this.a.getMenu().clear();
        }
    }

    protected int q() {
        return R.menu.album_pick_page_toolbar_menu;
    }
}
