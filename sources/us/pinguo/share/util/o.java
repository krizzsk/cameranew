package us.pinguo.share.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.pinguo.camera360.effect.model.entity.Effect;
import us.pinguo.share.R;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareTextUtil.java */
/* loaded from: classes6.dex */
public class o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareTextUtil.java */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareDataType.values().length];
            a = iArr;
            try {
                iArr[ShareDataType.SINGLE_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareDataType.MULTI_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareDataType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String a(ShareSite shareSite, String str, @Nullable String str2, @Nullable String str3) {
        if (shareSite == ShareSite.QZONE || shareSite == ShareSite.WECHAT_MOMENTS) {
            return null;
        }
        String string = us.pinguo.foundation.e.b().getString(R.string.share_social_default_desc);
        if (shareSite == ShareSite.QQ || shareSite == ShareSite.WECHAT_FRIENDS || shareSite == ShareSite.OTHER) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (shareSite == ShareSite.SINAWEIBO) {
            sb.append("@Camera360");
            sb.append(" ");
        }
        if (sb.length() > 0 && " ".equals(Character.valueOf(sb.charAt(sb.length() - 1)))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String b(ShareSite shareSite, ShareDataType shareDataType) {
        Context b = us.pinguo.foundation.e.b();
        int i2 = a.a[shareDataType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return b.getString(R.string.share_camera_photo_title);
        }
        if (i2 != 3) {
            return null;
        }
        return b.getString(R.string.share_camera_video_title);
    }

    public static String c(ShareSite shareSite, String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        ShareSite shareSite2;
        if (shareSite == ShareSite.WECHAT_MOMENTS || shareSite == (shareSite2 = ShareSite.QZONE)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = us.pinguo.librouter.c.d.c().getInterface().c(str2);
        }
        Context b = us.pinguo.foundation.e.b();
        if (shareSite == shareSite2 || shareSite == ShareSite.QQ || shareSite == ShareSite.WECHAT_FRIENDS || shareSite == ShareSite.FACEBOOK) {
            return TextUtils.isEmpty(str2) ? b.getString(R.string.share_social_default_desc) : str2;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append((char) 8220);
            sb.append(str2);
            sb.append((char) 8221);
            sb.append(" ");
            sb.append(Effect.DIVIDER);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (shareSite == ShareSite.SINAWEIBO) {
            sb.append("@Camera360");
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String d(ShareSite shareSite, String str, ShareDataType shareDataType, String str2) {
        Context b = us.pinguo.foundation.e.b();
        if (str == null) {
            str = "";
        }
        String str3 = null;
        int i2 = a.a[shareDataType.ordinal()];
        if (i2 == 1) {
            str3 = b.getString(R.string.share_social_photo_title);
        } else if (i2 == 2) {
            str3 = b.getString(R.string.share_social_photo_group_title);
        } else if (i2 == 3) {
            str3 = b.getString(R.string.share_social_video_title);
        }
        String format = String.format(str3, str);
        if ((shareSite == ShareSite.WECHAT_MOMENTS || shareSite == ShareSite.QZONE) && !TextUtils.isEmpty(str2)) {
            return format + " | " + str2;
        }
        return format;
    }
}
