package com.pinguo.camera360.gallery.temps;

import android.content.Context;
import android.content.DialogInterface;
import us.pinguo.foundation.utils.w;
import us.pinguo.util.l;
import vStudio.Android.Camera360.R;
/* compiled from: GalleryUtil.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(long j2, String str) {
        l.j(SandBox.a(j2));
        l.j(str);
    }

    public static us.pinguo.foundation.ui.mddialog.a b(Context context, int i2, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnKeyListener onKeyListener, int i3, int i4, int i5) {
        us.pinguo.foundation.ui.mddialog.a c = w.c(context, i2, z);
        c.h(-2, context.getResources().getString(R.string.cancel_sync_photo), onClickListener);
        c.l(onCancelListener);
        c.m(onDismissListener);
        c.n(onKeyListener);
        c.j(i3);
        c.o(i4);
        c.q();
        return c;
    }
}
