package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: AbsToolBar.java */
/* loaded from: classes3.dex */
public class b {
    protected PgToolBar a;
    protected Spinner b;
    protected boolean c;

    public void a(Activity activity, b bVar, float f2) {
        float f3;
        if (this.a == null || bVar == null) {
            return;
        }
        float d2 = com.pinguo.album.j.a.d(f2, 0.0f, 1.0f);
        if (d2 <= 0.5f) {
            f3 = d2 / 0.5f;
            g(this.a, this.b, null, activity);
        } else {
            f3 = d2 - 1.0f;
            bVar.g(this.a, this.b, null, activity);
        }
        this.a.setAlpha(1.0f - f3);
    }

    public void b(Activity activity) {
    }

    public void c(Activity activity, int i2) {
    }

    public void d() {
        this.a.getMenu().clear();
    }

    public boolean e() {
        return this.c;
    }

    public void f(Activity activity) {
    }

    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        j(pgToolBar, spinner);
        this.a = pgToolBar;
        this.b = spinner;
        this.c = true;
        return true;
    }

    public void h(Activity activity) {
    }

    public void i(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(PgToolBar pgToolBar, Spinner spinner) {
        if (spinner != null) {
            spinner.setVisibility(8);
            VdsAgent.onSetViewVisibility(spinner, 8);
        }
        if (pgToolBar.getMenu() != null) {
            pgToolBar.getMenu().clear();
        }
        pgToolBar.setBackgroundColor(-1);
        pgToolBar.b();
        pgToolBar.setTitle((CharSequence) null);
    }

    public void k(View.OnClickListener onClickListener) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar != null) {
            pgToolBar.setNavigationOnClickListener(onClickListener);
        }
    }

    public void l(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        PgToolBar pgToolBar = this.a;
        if (pgToolBar != null) {
            pgToolBar.setOnMenuItemClickListener(onMenuItemClickListener);
        }
    }

    public void m(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        Spinner spinner = this.b;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    public void n(boolean z, int... iArr) {
        MenuItem item;
        PgToolBar pgToolBar = this.a;
        if (pgToolBar == null || pgToolBar.getMenu() == null) {
            return;
        }
        Menu menu = this.a.getMenu();
        int size = menu.size();
        for (int i2 : iArr) {
            if (i2 < size && (item = menu.getItem(i2)) != null && item.isEnabled() != z) {
                item.setEnabled(z);
            }
        }
    }

    public void o(int i2) {
    }

    public void p(int i2) {
    }
}
