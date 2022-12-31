package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPickPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class q extends b {
    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(8);
            VdsAgent.onSetViewVisibility(a, 8);
        }
        Spinner spinner2 = this.b;
        spinner2.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner2, 8);
        pgToolBar.setNavigationIcon(R.drawable.back);
        this.a.setBackgroundResource(R.color.photo_page_bar_color);
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void i(Activity activity) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar == null) {
            return;
        }
        pgToolBar.setAlpha(1.0f);
        this.a.setTranslationY(0.0f);
        this.a.clearAnimation();
        this.a.setVisibility(0);
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void o(int i2) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar == null || i2 == 0) {
            return;
        }
        pgToolBar.getMenu().close();
        this.a.getMenu().clear();
    }
}
