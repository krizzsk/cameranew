package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.widget.Spinner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSetPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class h extends b {
    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        pgToolBar.setTitle(R.string.story);
        Spinner spinner2 = this.b;
        spinner2.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner2, 8);
        pgToolBar.setNavigationIcon(R.drawable.back);
        this.a.inflateMenu(R.menu.album_set_page_toolbar_menu);
        return true;
    }
}
