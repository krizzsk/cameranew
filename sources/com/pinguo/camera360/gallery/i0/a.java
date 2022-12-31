package com.pinguo.camera360.gallery.i0;

import android.content.Context;
import android.content.SharedPreferences;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: AlbumSettingModel.java */
/* loaded from: classes3.dex */
public class a {
    private static a c = new a();
    private SharedPreferences a = null;
    private boolean b;

    public a() {
        b();
    }

    private void b() {
        Context d2 = BaseApplication.d();
        this.a = d2.getSharedPreferences(d2.getPackageName() + "_album_", 0);
    }

    public static a c() {
        return c;
    }

    public boolean a() {
        return false;
    }

    public boolean d() {
        return this.b || this.a.getBoolean("key_show_camera360_album", true);
    }

    public void e(boolean z) {
        this.b = z;
    }

    public void f(boolean z) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean("key_first_show_album_tips", z);
        edit.commit();
    }

    public void g(boolean z) {
        this.b = false;
        SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean("key_show_camera360_album", z);
        edit.commit();
    }

    public void h(int i2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putInt("key_story_count", i2);
        edit.commit();
    }
}
