package com.pinguo.camera360.gallery;

import android.content.Context;
import android.content.res.Resources;
import com.pinguo.camera360.gallery.ui.j;
import com.pinguo.camera360.gallery.ui.z;
import vStudio.Android.Camera360.R;
/* compiled from: UIConfig.java */
/* loaded from: classes3.dex */
public class f0 {
    private static f0 c;
    public z.f a;
    public j.d b;

    private f0(Context context) {
        Resources resources = context.getResources();
        z.f fVar = new z.f();
        this.a = fVar;
        fVar.f6709d = resources.getInteger(R.integer.album_rows_land);
        this.a.f6710e = resources.getInteger(R.integer.album_rows_port);
        this.a.a = resources.getDimensionPixelSize(R.dimen.album_slot_gap);
        this.a.f6711f = resources.getDimensionPixelSize(R.dimen.album_tag_height);
        this.a.f6712g = resources.getDimensionPixelSize(R.dimen.album_padding_left);
        this.a.f6714i = resources.getDimensionPixelSize(R.dimen.album_padding_top);
        this.a.f6713h = resources.getDimensionPixelSize(R.dimen.album_padding_right);
        this.a.f6715j = resources.getDimensionPixelSize(R.dimen.album_padding_bottom);
        this.a.f6716k = resources.getDimensionPixelSize(R.dimen.album_header_bar_height);
        this.a.f6717l = resources.getDimensionPixelSize(R.dimen.album_rooter_bar_height);
        j.d dVar = new j.d();
        this.b = dVar;
        dVar.a = resources.getDimensionPixelSize(R.dimen.album_day_font_size);
        this.b.b = resources.getDimensionPixelSize(R.dimen.album_month_font_size);
        this.b.c = resources.getDimensionPixelSize(R.dimen.album_date_font_size);
        this.b.f6589d = resources.getDimensionPixelSize(R.dimen.album_divider_line_height);
        this.b.f6590e = resources.getDimensionPixelSize(R.dimen.album_music_sign_height);
        this.b.f6591f = resources.getDimensionPixelSize(R.dimen.album_video_sign_height);
        this.b.f6592g = resources.getDimensionPixelSize(R.dimen.album_video_time_margin);
        this.b.f6593h = resources.getDimensionPixelSize(R.dimen.album_slot_tag_padding);
        this.b.f6594i = resources.getDimensionPixelSize(R.dimen.album_slot_select_padding);
        this.b.f6595j = resources.getDimensionPixelSize(R.dimen.album_slot_tag_check_padding);
    }

    public static synchronized f0 a(Context context) {
        f0 f0Var;
        synchronized (f0.class) {
            if (c == null) {
                c = new f0(context);
            }
            f0Var = c;
        }
        return f0Var;
    }
}
