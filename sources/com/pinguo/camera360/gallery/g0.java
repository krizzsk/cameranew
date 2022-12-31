package com.pinguo.camera360.gallery;

import android.content.Context;
import android.content.res.Resources;
import com.pinguo.camera360.gallery.ui.h;
import com.pinguo.camera360.gallery.ui.z;
import vStudio.Android.Camera360.R;
/* compiled from: UIConfig.java */
/* loaded from: classes3.dex */
public class g0 {
    private static g0 c;
    public z.f a;
    public h.b b;

    private g0(Context context) {
        Resources resources = context.getResources();
        z.f fVar = new z.f();
        this.a = fVar;
        fVar.f6709d = resources.getInteger(R.integer.album_set_rows_land);
        this.a.f6710e = resources.getInteger(R.integer.album_set_rows_port);
        this.a.a = resources.getDimensionPixelSize(R.dimen.album_set_slot_gap);
        this.a.b = resources.getDimensionPixelSize(R.dimen.local_album_set_slot_gap);
        this.a.f6711f = resources.getDimensionPixelSize(R.dimen.album_set_label_height);
        this.a.f6712g = resources.getDimensionPixelSize(R.dimen.album_set_padding_left);
        this.a.f6714i = resources.getDimensionPixelSize(R.dimen.album_set_padding_top);
        this.a.c = resources.getDimensionPixelSize(R.dimen.local_album_set_title_content);
        this.a.f6713h = resources.getDimensionPixelSize(R.dimen.album_set_padding_right);
        this.a.f6715j = resources.getDimensionPixelSize(R.dimen.album_set_padding_bottom);
        this.a.f6716k = resources.getDimensionPixelSize(R.dimen.album_header_bar_height);
        this.a.f6717l = resources.getDimensionPixelSize(R.dimen.album_rooter_bar_height);
        h.b bVar = new h.b();
        this.b = bVar;
        bVar.b = resources.getDimensionPixelSize(R.dimen.album_set_label_height);
        this.b.c = resources.getDimensionPixelSize(R.dimen.album_set_title_offset);
        this.b.f6561d = resources.getDimensionPixelSize(R.dimen.album_set_count_offset);
        this.b.f6562e = resources.getDimensionPixelSize(R.dimen.album_set_title_font_size);
        this.b.f6565h = resources.getDimensionPixelSize(R.dimen.album_set_count_font_size);
        this.b.f6566i = resources.getDimensionPixelSize(R.dimen.album_set_icon_size);
        this.b.f6563f = resources.getDimensionPixelSize(R.dimen.album_tag_line_width);
        this.b.f6564g = resources.getDimensionPixelSize(R.dimen.album_tag_year_height);
        this.b.a = resources.getDimensionPixelSize(R.dimen.album_set_slot_padding);
        this.b.f6567j = resources.getDimensionPixelSize(R.dimen.album_set_label_top_padding);
        this.b.f6568k = resources.getDimensionPixelSize(R.dimen.album_set_label_left_padding);
        this.b.m = resources.getDimensionPixelSize(R.dimen.album_set_label_bottom_padding);
        this.b.f6569l = resources.getDimensionPixelSize(R.dimen.album_set_label_title_padding);
        this.b.n = resources.getDimensionPixelSize(R.dimen.local_album_set_slot_gap);
    }

    public static synchronized g0 a(Context context) {
        g0 g0Var;
        synchronized (g0.class) {
            if (c == null) {
                c = new g0(context);
            }
            g0Var = c;
        }
        return g0Var;
    }
}
