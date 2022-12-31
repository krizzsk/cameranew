package us.pinguo.inspire_proxy.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import us.pinguo.inspire_proxy.R;
import us.pinguo.inspire_proxy.media.h;
import us.pinguo.inspire_proxy.media.k;
import us.pinguo.share.c.e;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.ShareDataType;
import us.pinguo.share.util.l;
import us.pinguo.share.util.o;
/* compiled from: LocalShareProcessor.java */
/* loaded from: classes4.dex */
public class a extends e<String> {
    private boolean c;

    public a(String str, boolean z) {
        super(str);
        this.c = z;
    }

    public static String o(Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() == 0) {
            return null;
        }
        if (z) {
            Paint paint = new Paint();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            Bitmap decodeResource = BitmapFactory.decodeResource(us.pinguo.foundation.e.b().getResources(), R.drawable.icon_play_video);
            Rect rect = new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight());
            int width = bitmap.getWidth() / 2;
            int height = bitmap.getHeight() / 2;
            canvas.drawBitmap(decodeResource, rect, new Rect(width - 51, height - 51, width + 51, height + 51), paint);
            bitmap = createBitmap;
        }
        File r = r();
        String absolutePath = new File(r, "thumb_" + System.currentTimeMillis() + ".jpg").getAbsolutePath();
        try {
            us.pinguo.util.e.t(absolutePath, bitmap, 80);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return absolutePath;
    }

    private String p(String str) {
        File r = r();
        return h.a(str, new File(r, "scale_" + System.currentTimeMillis() + ".jpg").getAbsolutePath());
    }

    private String q(String str) {
        File file = new File(str);
        File r = r();
        File file2 = new File(r, "scale_" + file.getName());
        if (file2.length() > 0) {
            return file2.getAbsolutePath();
        }
        try {
            file2.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        k.c(str, file2.getAbsolutePath());
        return file2.getAbsolutePath();
    }

    static File r() {
        File externalCacheDir = us.pinguo.foundation.e.b().getExternalCacheDir();
        return !externalCacheDir.exists() ? us.pinguo.foundation.e.b().getCacheDir() : externalCacheDir;
    }

    @Override // us.pinguo.share.c.e
    protected l a(l lVar) {
        String str;
        PGShareInfo a = lVar.a();
        a.setTitle(t(lVar.b(), b()));
        Bitmap bitmap = null;
        a.setText(s(lVar.b(), a.getTitle(), null, null));
        if (u(lVar.b()) == null) {
            if (this.c) {
                if (v()) {
                    str = q((String) this.a);
                } else {
                    str = (String) this.a;
                }
                a.setVideoUri(str);
            } else {
                a.setImageUri(p((String) this.a));
            }
        }
        if (this.c) {
            try {
                bitmap = us.pinguo.util.e.n((String) this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
                us.pinguo.foundation.e.e(e2);
            }
            String o = o(us.pinguo.util.e.o(bitmap, 256, k.b((String) this.a)), lVar.b() == ShareSite.QQ || lVar.b() == ShareSite.QZONE || lVar.b() == ShareSite.WECHAT_FRIENDS || lVar.b() == ShareSite.WECHAT_MOMENTS);
            if (o != null) {
                a.setThumbnailUri(o);
            }
        }
        return lVar;
    }

    @Override // us.pinguo.share.c.e
    protected ShareDataType b() {
        return this.c ? ShareDataType.VIDEO : ShareDataType.SINGLE_PHOTO;
    }

    @Override // us.pinguo.share.c.e
    public boolean j(ShareSite shareSite) {
        return true;
    }

    protected String s(ShareSite shareSite, String str, @Nullable String str2, @Nullable String str3) {
        return o.a(shareSite, str, str2, str3);
    }

    protected String t(ShareSite shareSite, ShareDataType shareDataType) {
        return o.b(shareSite, shareDataType);
    }

    protected String u(ShareSite shareSite) {
        if (b() != ShareDataType.VIDEO || shareSite == ShareSite.FACEBOOK || shareSite == ShareSite.INSTAGRAM || shareSite == ShareSite.QQ || shareSite == ShareSite.DOUYIN) {
            return null;
        }
        return (String) this.a;
    }

    protected boolean v() {
        return false;
    }
}
