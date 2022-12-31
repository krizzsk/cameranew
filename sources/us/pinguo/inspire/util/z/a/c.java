package us.pinguo.inspire.util.z.a;

import android.text.TextUtils;
import java.util.Locale;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.share.c.e;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.l;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* compiled from: TaskShareProcessor.java */
/* loaded from: classes9.dex */
public class c extends e<InspireTask> {
    public static final String c = Inspire.f11205f + "/taskDetail/index.html?locale=" + Locale.getDefault().getLanguage().toLowerCase().toString() + "&taskId=";

    public c(InspireTask inspireTask) {
        super(inspireTask);
    }

    @Override // us.pinguo.share.c.e
    protected l a(l lVar) {
        String str;
        String str2;
        String str3;
        String str4;
        PGShareInfo a = lVar.a();
        InspireTask inspireTask = (InspireTask) this.a;
        if (inspireTask.isNewTask()) {
            str = inspireTask.icon;
        } else if (inspireTask.isVideo()) {
            str = PhotoImageView.addQiNiuSuffix(inspireTask.videoUrl, 0, 0, true);
        } else {
            str = inspireTask.cover;
        }
        String str5 = inspireTask.shareTitle;
        String str6 = "";
        if (str5 != null && !TextUtils.isEmpty(str5)) {
            str2 = inspireTask.shareTitle;
        } else {
            String str7 = inspireTask.taskName;
            str2 = (str7 == null || TextUtils.isEmpty(str7)) ? "" : inspireTask.taskName;
        }
        try {
            str4 = inspireTask.shareDescription;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (str4 != null && !TextUtils.isEmpty(str4)) {
            str3 = inspireTask.shareDescription;
        } else {
            String str8 = inspireTask.shortDesc;
            if (str8 != null && !TextUtils.isEmpty(str8)) {
                str3 = inspireTask.shortDesc;
            }
            str3 = "";
        }
        if (lVar.b() == ShareSite.SINAWEIBO) {
            if (str3 != null) {
                str6 = str3 + "#" + Inspire.a().getString(R.string.app_name_res_0x7d090005) + "#";
            }
            str3 = str6;
        }
        a.setWebUrl(c + inspireTask.taskId);
        a.setTitle(str2);
        a.setText(str3);
        a.setThumbnailUri(str);
        return lVar;
    }

    @Override // us.pinguo.share.c.e
    public boolean j(ShareSite shareSite) {
        return false;
    }
}
