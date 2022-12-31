package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.widget.Spinner;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumSetPickPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class i extends b {
    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        pgToolBar.setNavigationIcon(R.drawable.cancel);
        return true;
    }
}
