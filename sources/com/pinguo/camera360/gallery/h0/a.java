package com.pinguo.camera360.gallery.h0;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Size;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.save.processer.e;
import java.io.File;
import us.pinguo.edit2020.activity.AIEditActivity;
import us.pinguo.edit2020.activity.EditActivity;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.model.editgoto.b;
import us.pinguo.edit2020.model.editgoto.c;
import us.pinguo.foundation.utils.k0;
import us.pinguo.image.saver.sandbox.SandBoxSql;
import vStudio.Android.Camera360.R;
/* compiled from: EditPicModel.java */
/* loaded from: classes3.dex */
public class a {
    private static final String b = "a";
    private Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditPicModel.java */
    /* renamed from: com.pinguo.camera360.gallery.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0240a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditGotoType.values().length];
            a = iArr;
            try {
                iArr[EditGotoType.IMAGE_RESTORARION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(Activity activity) {
        this.a = activity;
    }

    private Size a(String str) {
        if (new File(str).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 >= 100 && i3 >= 100) {
                return new Size(i2, i3);
            }
            k0.a.a(R.string.pick_pic_waring);
        }
        return null;
    }

    private Size b(String str) {
        if (!new File(str).exists()) {
            k0.a.a(R.string.puzzle_msg_pic_error);
            return null;
        }
        Size a = a(str);
        if (a == null) {
            return null;
        }
        return a;
    }

    private void c(String str, Uri uri) {
        if (b(str) == null) {
            return;
        }
        b a = new c().a(uri);
        if (a != null) {
            if (C0240a.a[a.a().ordinal()] != 1) {
                EditActivity.a.b(this.a, str, false, uri, false);
                return;
            } else {
                AIEditActivity.a.a(this.a, str, false, uri, false);
                return;
            }
        }
        EditActivity.a.b(this.a, str, false, uri, false);
    }

    public void d(String str, Uri uri) {
        us.pinguo.image.saver.d.a aVar;
        try {
            aVar = SandBoxSql.getInstance().c(str);
        } catch (Exception unused) {
            aVar = null;
        }
        com.pinguo.camera360.m.b a = e.a(aVar);
        boolean z = aVar != null ? !TextUtils.isEmpty(aVar.o()) : false;
        if (z) {
            str = a.c();
        }
        a.d.c(R.id.edit_button);
        if (z) {
            try {
                if ("finished".equals(aVar.o())) {
                    c(str, uri);
                } else {
                    k0.a.a(R.string.album_photo_in_making);
                }
                return;
            } catch (Exception e2) {
                us.pinguo.common.log.a.g(b, "can not get project state .....", new Object[0]);
                e2.printStackTrace();
                return;
            }
        }
        c(str, uri);
    }
}
