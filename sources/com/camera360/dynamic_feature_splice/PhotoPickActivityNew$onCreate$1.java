package com.camera360.dynamic_feature_splice;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import us.pinguo.picker.image.PickItem;
/* compiled from: PhotoPickActivityNew.kt */
/* loaded from: classes8.dex */
final class PhotoPickActivityNew$onCreate$1 extends Lambda implements kotlin.jvm.b.p<Integer, PickItem, kotlin.u> {
    final /* synthetic */ PhotoPickActivityNew this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPickActivityNew$onCreate$1(PhotoPickActivityNew photoPickActivityNew) {
        super(2);
        this.this$0 = photoPickActivityNew;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, PickItem pickItem) {
        invoke(num.intValue(), pickItem);
        return kotlin.u.a;
    }

    public final void invoke(int i2, PickItem pickItem) {
        kotlin.jvm.internal.s.h(pickItem, "pickItem");
        us.pinguo.foundation.statistics.h.a.F("delete_pic");
        this.this$0.f2144f.remove(i2);
        Iterator<us.pinguo.picker.image.gallery.m> it = this.this$0.f2148j.i().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (kotlin.jvm.internal.s.c(it.next().f(), pickItem.path)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            if (((ViewPager) this.this$0._$_findCachedViewById(R.id.vp_big_pic)).getCurrentItem() == i3) {
                ((ImageView) this.this$0._$_findCachedViewById(R.id.title_right_btn_select_label)).setImageResource(vStudio.Android.Camera360.R.drawable.ic_splice_select_label_gray);
            }
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.txt_pick_num);
            PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.this$0.f2146h;
            if (pickedPhotoPreviewAdapter != null) {
                textView.setText(String.valueOf(pickedPhotoPreviewAdapter.getItemCount()));
                PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter2 = this.this$0.f2146h;
                if (pickedPhotoPreviewAdapter2 != null) {
                    if (pickedPhotoPreviewAdapter2.getItemCount() == 0) {
                        this.this$0.B0();
                    }
                    this.this$0.f2148j.g(i3);
                    return;
                }
                kotlin.jvm.internal.s.z("previewAdapter");
                throw null;
            }
            kotlin.jvm.internal.s.z("previewAdapter");
            throw null;
        }
    }
}
