package com.pinguo.camera360.gallery.photopick;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoPickHLVAdapter.java */
/* loaded from: classes3.dex */
public class f extends us.pinguo.ui.widget.banner.a<e> {
    private Activity a;

    /* compiled from: PhotoPickHLVAdapter.java */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ e a;

        a(f fVar, e eVar) {
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            PhotoPickBroker.k().d(this.a);
        }
    }

    /* compiled from: PhotoPickHLVAdapter.java */
    /* loaded from: classes3.dex */
    private class b {
        ImageView a;
        View b;

        private b(f fVar) {
        }

        /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public f(Activity activity) {
        this.a = activity;
        set(PhotoPickBroker.k().j());
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b(this, null);
            View inflate = this.a.getLayoutInflater().inflate(R.layout.album_gv_item_choice_photo, (ViewGroup) null);
            bVar2.a = (ImageView) inflate.findViewById(R.id.iv_album_gv_item_choice_photo);
            bVar2.b = inflate.findViewById(R.id.iv_album_gv_item_choice_photo_del);
            inflate.setTag(bVar2);
            bVar = bVar2;
            view = inflate;
        } else {
            bVar = (b) view.getTag();
        }
        e item = getItem(i2);
        if (item == null) {
            return view;
        }
        Bitmap bitmap = item.b;
        if (bitmap != null && !bitmap.isRecycled()) {
            bVar.a.setImageBitmap(item.b);
        }
        bVar.b.setOnClickListener(new a(this, item));
        return view;
    }
}
