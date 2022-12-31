package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumCoverPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class c extends b {
    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(8);
            VdsAgent.onSetViewVisibility(a, 8);
        }
        ViewCompat.setElevation(this.a, 0.0f);
        Spinner spinner2 = this.b;
        spinner2.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner2, 8);
        pgToolBar.setNavigationIcon(R.drawable.back_white);
        this.a.inflateMenu(R.menu.album_cover_page_toolbar_menu);
        this.a.setBackgroundResource(R.drawable.photo_page_top_shade);
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more_white));
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void h(Activity activity) {
        ViewCompat.setElevation(this.a, 15.0f);
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
    }
}
