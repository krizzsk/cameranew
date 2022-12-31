package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumPageImportToolBarImpl.java */
/* loaded from: classes3.dex */
public class d extends b {

    /* renamed from: d  reason: collision with root package name */
    protected View f6650d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f6651e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f6652f;

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void c(Activity activity, int i2) {
        this.a.setNavigationIcon(R.drawable.cancel);
        Spinner spinner = this.b;
        spinner.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner, 8);
        this.a.getMenu().close();
        this.a.getMenu().clear();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.album_pick_toolbar_custom_view, (ViewGroup) null);
        this.f6650d = inflate;
        this.a.addView(inflate);
        this.f6651e = (TextView) this.f6650d.findViewById(R.id.select_pic_count);
        TextView textView = (TextView) this.f6650d.findViewById(R.id.select_pic_text);
        this.f6652f = textView;
        if (i2 != 0) {
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            this.a.inflateMenu(r());
        } else {
            this.a.setOverflowIcon(null);
        }
        TextView textView2 = this.f6652f;
        textView2.setText(((Object) this.f6650d.getContext().getText(R.string.select_pic_count)) + "(0)");
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void f(Activity activity) {
        if (this.f6650d != null) {
            this.a.setNavigationIcon(R.drawable.back);
            Spinner spinner = this.b;
            spinner.setVisibility(0);
            VdsAgent.onSetViewVisibility(spinner, 0);
            this.a.getMenu().close();
            this.a.getMenu().clear();
            this.a.inflateMenu(q());
            this.a.removeView(this.f6650d);
            this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more));
            this.f6651e = null;
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        this.a.setBackgroundColor(-1);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(activity, R.array.browse_pic_mode, R.layout.spinner_dropdown_item);
        if (this.a.a() != null) {
            View a = this.a.a();
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
        createFromResource.setDropDownViewResource(R.layout.spinner_dropdown_item2);
        this.b.setAdapter((SpinnerAdapter) createFromResource);
        this.b.setSelection(1);
        Spinner spinner2 = this.b;
        spinner2.setVisibility(0);
        VdsAgent.onSetViewVisibility(spinner2, 0);
        pgToolBar.setNavigationIcon(R.drawable.back);
        this.a.inflateMenu(q());
        this.a.setOverflowIcon(activity.getResources().getDrawable(R.drawable.more));
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void p(int i2) {
        TextView textView = this.f6651e;
        if (textView != null) {
            textView.setText(((Object) this.f6650d.getContext().getText(R.string.select_pic_count)) + "(" + i2 + ")");
        }
        int size = this.a.getMenu().size();
        if (i2 == 0) {
            if (size != 0) {
                TextView textView2 = this.f6651e;
                textView2.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView2, 8);
                TextView textView3 = this.f6652f;
                textView3.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView3, 0);
                this.a.getMenu().close();
                this.a.getMenu().clear();
                return;
            }
            return;
        }
        if (size == 0) {
            this.a.inflateMenu(r());
            TextView textView4 = this.f6651e;
            textView4.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView4, 0);
            TextView textView5 = this.f6652f;
            textView5.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView5, 8);
        }
        MenuItem findItem = this.a.getMenu().findItem(R.id.action_share);
        if (findItem != null) {
            if (i2 > 1) {
                findItem.setEnabled(false);
                findItem.setIcon(R.drawable.share_alpha);
                return;
            }
            findItem.setEnabled(true);
            findItem.setIcon(R.drawable.share);
        }
    }

    protected int q() {
        return R.menu.album_page_import_toolbar_menu;
    }

    protected int r() {
        return R.menu.album_page_select_toolbar_menu;
    }
}
