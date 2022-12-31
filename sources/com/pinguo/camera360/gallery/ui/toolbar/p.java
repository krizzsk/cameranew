package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPageWaterFallToolBarImpl.java */
/* loaded from: classes3.dex */
public class p extends b {
    private void q(Activity activity) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar == null) {
            return;
        }
        if (pgToolBar.a() != null) {
            View a = this.a.a();
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more));
    }

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
        this.a.inflateMenu(R.menu.photo_page_waterfall_toolbar_menu);
        this.a.setBackgroundResource(R.color.photo_page_bar_color);
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more));
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void h(Activity activity) {
        q(activity);
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
        if (pgToolBar == null) {
            return;
        }
        if (i2 == 0) {
            if (pgToolBar.getMenu().size() <= 0) {
                this.a.inflateMenu(R.menu.photo_page_waterfall_toolbar_menu);
                return;
            }
            return;
        }
        pgToolBar.getMenu().close();
        this.a.getMenu().clear();
    }
}
