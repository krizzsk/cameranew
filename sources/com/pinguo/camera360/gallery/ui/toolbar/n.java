package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPageCameraToolBarImpl.java */
/* loaded from: classes3.dex */
public class n extends b {
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
        pgToolBar.setNavigationIcon(R.drawable.back_white);
        pgToolBar.getMenu().clear();
        this.a.inflateMenu(R.menu.photo_page_camera_toolbar_menu);
        this.a.setBackgroundResource(R.color.photo_page_bar_color);
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.info_photo));
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void n(boolean z, int... iArr) {
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void o(int i2) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar == null) {
            return;
        }
        if (i2 == 0) {
            if (pgToolBar.getMenu().size() <= 0) {
                this.a.inflateMenu(R.menu.photo_page_camera_toolbar_menu);
                return;
            }
            return;
        }
        pgToolBar.getMenu().close();
        this.a.getMenu().clear();
    }
}
