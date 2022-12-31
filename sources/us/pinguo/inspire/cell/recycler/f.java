package us.pinguo.inspire.cell.recycler;

import android.text.TextUtils;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.ui.uilview.PhotoImageView;
/* compiled from: ViewHolderHelper.java */
/* loaded from: classes9.dex */
public class f {
    public static void a(us.pinguo.widget.common.cell.recycler.c cVar, int i2, int i3, int i4) {
        if (cVar == null || i3 == 0 || i4 == 0) {
            return;
        }
        PhotoImageView photoImageView = (PhotoImageView) cVar.getView(i2);
        photoImageView.setSize(us.pinguo.foundation.t.b.a.a(photoImageView.getContext(), i3), us.pinguo.foundation.t.b.a.a(photoImageView.getContext(), i4));
    }

    public static void b(us.pinguo.widget.common.cell.recycler.c cVar, int i2, int i3, int i4) {
        if (cVar == null || i3 == 0 || i4 == 0) {
            return;
        }
        ((PhotoImageView) cVar.getView(i2)).setSize(i3, i4);
    }

    public static void c(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str) {
        if (cVar == null) {
            return;
        }
        ((PhotoImageView) cVar.getView(i2)).setImageUri(str);
    }

    public static void d(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str, int i3, int i4) {
        if (cVar == null) {
            return;
        }
        a(cVar, i2, i3, i4);
        c(cVar, i2, str);
    }

    public static void e(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str, int i3, int i4) {
        if (cVar == null) {
            return;
        }
        b(cVar, i2, i3, i4);
        c(cVar, i2, str);
    }

    public static void f(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str) {
        if (cVar == null) {
            return;
        }
        ((PhotoImageView) cVar.getView(i2)).setLocalVideoUri(InspirePublishFragment.FILE_HEADER + str);
    }

    public static void g(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        ((PhotoImageView) cVar.getView(i2)).setVideoThumbnailUri(str);
    }

    public static void h(us.pinguo.widget.common.cell.recycler.c cVar, int i2, String str, int i3, int i4) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        ((PhotoImageView) cVar.getView(i2)).setVideoImageUrl(str, i3, i4);
    }
}
