package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class AlbumCoverInfoView extends RelativeLayout {
    private TextView a;
    private View b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f6454d;

    public AlbumCoverInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.album_cover_page_info, this);
        this.a = (TextView) findViewById(R.id.album_set_name);
        this.b = findViewById(R.id.enter_slot_page_icon);
        this.c = (TextView) findViewById(R.id.album_create_date);
        this.f6454d = (TextView) findViewById(R.id.album_set_pics_count);
    }

    public void b(String str, String str2, String str3) {
        this.a.setText(str);
        this.c.setText(str2);
        this.f6454d.setText(str3);
    }

    public void setEnterAlbumPageListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public AlbumCoverInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AlbumCoverInfoView(Context context) {
        super(context);
        a(context);
    }
}
