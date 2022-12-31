package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: DestinationCameraSocial.java */
/* loaded from: classes4.dex */
public class m extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        String queryParameter = uri.getQueryParameter("pkgId");
        String queryParameter2 = uri.getQueryParameter("filterId");
        String queryParameter3 = uri.getQueryParameter("cameraType");
        String queryParameter4 = uri.getQueryParameter("isSticker");
        String queryParameter5 = uri.getQueryParameter("stickerShowMode");
        String queryParameter6 = uri.getQueryParameter("initUnity");
        if (TextUtils.isEmpty(queryParameter6)) {
            queryParameter6 = "true";
        }
        String queryParameter7 = uri.getQueryParameter("categoryID");
        if ("true".equals(queryParameter4) && !"0".equals(queryParameter5) && !"true".equals(queryParameter6)) {
            Intent a = us.pinguo.foundation.b.a(context);
            a.putExtra("bundle_key_is_sticker", "true");
            if (!TextUtils.isEmpty(queryParameter7)) {
                a.putExtra("bundle_key_category", queryParameter7);
            }
            return a;
        }
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("bundle_key_filter", queryParameter2);
        intent.putExtra("bundle_key_package", queryParameter);
        intent.putExtra("bundle_key_is_sticker", queryParameter4);
        intent.putExtra("bundle_key_init_unity", "true".equals(queryParameter6));
        if (!TextUtils.isEmpty(queryParameter7)) {
            intent.putExtra("bundle_key_category", queryParameter7);
        }
        if ("1".equals(queryParameter3) || "2".equals(queryParameter3) || "3".equals(queryParameter3)) {
            intent.putExtra("camera_type", Integer.parseInt(queryParameter3));
        }
        String queryParameter8 = uri.getQueryParameter("makeup");
        if (!TextUtils.isEmpty(queryParameter8)) {
            intent.putExtra("bundle_key_makeup", queryParameter8);
        }
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return uri.toString().contains("app://camera360/cameraSocial");
    }
}
