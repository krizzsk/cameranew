package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumPageWaterFallToolBarImpl.java */
/* loaded from: classes3.dex */
public class f extends e {

    /* renamed from: g  reason: collision with root package name */
    private String f6656g;

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e, com.pinguo.camera360.gallery.ui.toolbar.b
    public void c(Activity activity, int i2) {
        this.a.setTitle((CharSequence) null);
        super.c(activity, i2);
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e, com.pinguo.camera360.gallery.ui.toolbar.b
    public void f(Activity activity) {
        super.f(activity);
        s(this.f6656g);
        Spinner spinner = this.b;
        spinner.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner, 8);
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e, com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        this.a = pgToolBar;
        this.b = spinner;
        j(pgToolBar, spinner);
        this.a.setBackgroundColor(-1);
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
        pgToolBar.setNavigationIcon(R.drawable.back);
        this.a.inflateMenu(q());
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more));
        s(this.f6656g);
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e, com.pinguo.camera360.gallery.ui.toolbar.b
    public void i(Activity activity) {
        super.i(activity);
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e
    protected int q() {
        return R.menu.album_page_waterfall_toolbar_menu;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.e
    protected int r() {
        return R.menu.album_page_waterfall_select_toolbar_menu;
    }

    public void s(String str) {
        this.f6656g = str;
        this.a.setTitle(str);
    }
}
