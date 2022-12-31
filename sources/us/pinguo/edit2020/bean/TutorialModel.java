package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.R;
import us.pinguo.edit2020.manager.TutorialDownloadManager;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: EditTutorialModel.kt */
/* loaded from: classes4.dex */
public final class TutorialModel implements NoProguard {
    public static final a Companion = new a(null);
    public static final String VIDEO_TYPE_BG_BLUR = "bg_blur";
    public static final String VIDEO_TYPE_BODY_SHAPING = "tutorial_body_shaping";
    public static final String VIDEO_TYPE_LONG_LEG = "tutorial_long_leg";
    public static final String VIDEO_TYPE_REMOVE_PEN = "tutorial_remove_pen";
    public static final String VIDEO_TYPE_SKIN_REFRESH = "tutorial_skin_refresh";
    private static final boolean isAsiaModel;
    private static final String videoFilePrefix;
    private String coverPath;
    private int defaultCoverImg;
    private int desc;
    private String sourcePath;
    private String sourceType;
    private int title;

    /* compiled from: EditTutorialModel.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        private final TutorialModel[] a() {
            return new TutorialModel[]{new TutorialModel(kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_background_blur.mp4"), "", "video", l(R.string.background_blur), R.string.str_bg_blur_tutorial_title, R.string.str_bg_blur_tutorial_desc)};
        }

        private final TutorialModel[] b() {
            String q = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_expand_shrink.mp4");
            String q2 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_area_protection.mp4");
            int i2 = R.string.edit_skin_refresh_expand;
            TutorialModel tutorialModel = new TutorialModel(q, "", "video", l(i2), i2, R.string.edit_skin_refresh_expand_desc);
            int i3 = R.string.edit_area_protection;
            return new TutorialModel[]{tutorialModel, new TutorialModel(q2, "", "video", l(i3), i3, R.string.edit_area_protection_guide_desc)};
        }

        private final TutorialModel[] c() {
            return new TutorialModel[]{new TutorialModel(kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_detail.mp4"), "", "video", l(R.string.edit_skin_refresh_detail), R.string.str_shining_manually, R.string.edit_skin_refresh_detail_desc)};
        }

        private final TutorialModel[] d() {
            return new TutorialModel[]{new TutorialModel(kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_long_leg.mp4"), "", "video", l(R.string.main_menu_beauty_long_leg), R.string.long_leg_stovepip, R.string.str_long_leg_desc)};
        }

        private final TutorialModel[] e() {
            String q = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_mopi.mp4");
            String q2 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_quheitou.mp4");
            int i2 = R.string.edit_skin_refresh_smooth;
            return new TutorialModel[]{new TutorialModel(q, "", "video", l(i2), i2, R.string.edit_skin_refresh_smooth_desc), new TutorialModel(q2, "", "video", l(R.string.edit_skin_refresh_blackhead), R.string.quheitou, R.string.edit_new_beauty_truing_desc)};
        }

        private final TutorialModel[] f() {
            String q = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_qudou.mp4");
            int i2 = R.string.edit_skin_refresh_acne;
            return new TutorialModel[]{new TutorialModel(q, "", "video", l(i2), i2, R.string.edit_skin_refresh_acne_desc)};
        }

        private final TutorialModel[] g() {
            return new TutorialModel[]{new TutorialModel(kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_quheitou.mp4"), "", "video", l(R.string.edit_skin_refresh_blackhead), R.string.quheitou, R.string.edit_new_beauty_truing_desc)};
        }

        private final TutorialModel[] h() {
            String q = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_quzhou.mp4");
            int i2 = R.string.edit_skin_refresh_firm;
            return new TutorialModel[]{new TutorialModel(q, "", "video", l(i2), i2, R.string.edit_skin_refresh_firm_desc)};
        }

        private final TutorialModel[] i() {
            return new TutorialModel[]{new TutorialModel(kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_remove_pen.mp4"), "", "video", R.drawable.tt_remove_pen_cv, R.string.edit_elimination, R.string.edit_elimination_guide_desc)};
        }

        private final TutorialModel[] j() {
            String q = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_mopi.mp4");
            String q2 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_qudou.mp4");
            String q3 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_quzhou.mp4");
            String q4 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_quheitou.mp4");
            String q5 = kotlin.jvm.internal.s.q(TutorialModel.videoFilePrefix, "/tt_skin_refresh_detail.mp4");
            int i2 = R.string.edit_skin_refresh_smooth;
            TutorialModel tutorialModel = new TutorialModel(q, "", "video", l(i2), i2, R.string.edit_skin_refresh_smooth_desc);
            int i3 = R.string.edit_skin_refresh_acne;
            TutorialModel tutorialModel2 = new TutorialModel(q2, "", "video", l(i3), i3, R.string.edit_skin_refresh_acne_desc);
            int i4 = R.string.edit_skin_refresh_firm;
            TutorialModel tutorialModel3 = new TutorialModel(q3, "", "video", l(i4), i4, R.string.edit_skin_refresh_firm_desc);
            int i5 = R.string.edit_skin_refresh_blackhead;
            TutorialModel tutorialModel4 = new TutorialModel(q4, "", "video", l(i5), i5, R.string.edit_skin_refresh_blackhead_desc);
            int i6 = R.string.edit_skin_refresh_detail;
            return new TutorialModel[]{tutorialModel, tutorialModel2, tutorialModel3, tutorialModel4, new TutorialModel(q5, "", "video", l(i6), i6, R.string.edit_skin_refresh_detail_desc)};
        }

        private final int l(int i2) {
            if (i2 == R.string.edit_skin_refresh_expand) {
                if (TutorialModel.isAsiaModel) {
                    return R.drawable.tt_expand_shrink_cv;
                }
                return R.drawable.tt_expand_shrink_other_cv;
            } else if (i2 == R.string.edit_area_protection) {
                if (TutorialModel.isAsiaModel) {
                    return R.drawable.tt_area_protection_cv;
                }
                return R.drawable.tt_area_protection_other_cv;
            } else if (i2 == R.string.edit_elimination) {
                return R.drawable.tt_remove_pen_cv;
            } else {
                if (i2 == R.string.edit_skin_refresh_smooth) {
                    if (TutorialModel.isAsiaModel) {
                        return R.drawable.tt_skin_refresh_mopi_cv;
                    }
                    return R.drawable.tt_skin_refresh_mopi_other_cv;
                } else if (i2 == R.string.edit_skin_refresh_acne) {
                    if (TutorialModel.isAsiaModel) {
                        return R.drawable.tt_skin_refresh_qudou_cv;
                    }
                    return R.drawable.tt_skin_refresh_qudou_other_cv;
                } else if (i2 == R.string.edit_skin_refresh_firm) {
                    return R.drawable.tt_skin_refresh_quzhou_cv;
                } else {
                    if (i2 == R.string.edit_skin_refresh_blackhead) {
                        return R.drawable.tt_skin_refresh_quheitou_cv;
                    }
                    if (i2 == R.string.edit_skin_refresh_detail) {
                        if (TutorialModel.isAsiaModel) {
                            return R.drawable.tt_skin_refresh_detail_cv;
                        }
                        return R.drawable.tt_skin_refresh_detail_other_cv;
                    } else if (i2 == R.string.background_blur) {
                        return R.drawable.tt_background_blur_cv;
                    } else {
                        if (i2 == R.string.main_menu_beauty_long_leg) {
                            return R.drawable.tt_long_leg_cv;
                        }
                        return 0;
                    }
                }
            }
        }

        public final TutorialModel[] k(String videoType) {
            kotlin.jvm.internal.s.h(videoType, "videoType");
            switch (videoType.hashCode()) {
                case -1397393062:
                    if (videoType.equals(TutorialModel.VIDEO_TYPE_SKIN_REFRESH)) {
                        return j();
                    }
                    break;
                case -1395136116:
                    if (videoType.equals(TutorialModel.VIDEO_TYPE_LONG_LEG)) {
                        return d();
                    }
                    break;
                case -1093229070:
                    if (videoType.equals("quheitou")) {
                        return g();
                    }
                    break;
                case -643700056:
                    if (videoType.equals("quzhouwen")) {
                        return h();
                    }
                    break;
                case -179388383:
                    if (videoType.equals(TutorialModel.VIDEO_TYPE_BG_BLUR)) {
                        return a();
                    }
                    break;
                case 3357467:
                    if (videoType.equals("mopi")) {
                        return e();
                    }
                    break;
                case 107943078:
                    if (videoType.equals("qudou")) {
                        return f();
                    }
                    break;
                case 733674079:
                    if (videoType.equals(TutorialModel.VIDEO_TYPE_REMOVE_PEN)) {
                        return i();
                    }
                    break;
                case 825363977:
                    if (videoType.equals("liangyan")) {
                        return c();
                    }
                    break;
            }
            return b();
        }
    }

    static {
        TutorialDownloadManager tutorialDownloadManager = TutorialDownloadManager.a;
        videoFilePrefix = kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, tutorialDownloadManager.g());
        isAsiaModel = tutorialDownloadManager.h();
    }

    public TutorialModel(String sourcePath, String coverPath, String sourceType, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(sourcePath, "sourcePath");
        kotlin.jvm.internal.s.h(coverPath, "coverPath");
        kotlin.jvm.internal.s.h(sourceType, "sourceType");
        this.sourcePath = sourcePath;
        this.coverPath = coverPath;
        this.sourceType = sourceType;
        this.defaultCoverImg = i2;
        this.title = i3;
        this.desc = i4;
    }

    public static /* synthetic */ TutorialModel copy$default(TutorialModel tutorialModel, String str, String str2, String str3, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = tutorialModel.sourcePath;
        }
        if ((i5 & 2) != 0) {
            str2 = tutorialModel.coverPath;
        }
        String str4 = str2;
        if ((i5 & 4) != 0) {
            str3 = tutorialModel.sourceType;
        }
        String str5 = str3;
        if ((i5 & 8) != 0) {
            i2 = tutorialModel.defaultCoverImg;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = tutorialModel.title;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = tutorialModel.desc;
        }
        return tutorialModel.copy(str, str4, str5, i6, i7, i4);
    }

    public final String component1() {
        return this.sourcePath;
    }

    public final String component2() {
        return this.coverPath;
    }

    public final String component3() {
        return this.sourceType;
    }

    public final int component4() {
        return this.defaultCoverImg;
    }

    public final int component5() {
        return this.title;
    }

    public final int component6() {
        return this.desc;
    }

    public final TutorialModel copy(String sourcePath, String coverPath, String sourceType, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(sourcePath, "sourcePath");
        kotlin.jvm.internal.s.h(coverPath, "coverPath");
        kotlin.jvm.internal.s.h(sourceType, "sourceType");
        return new TutorialModel(sourcePath, coverPath, sourceType, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TutorialModel) {
            TutorialModel tutorialModel = (TutorialModel) obj;
            return kotlin.jvm.internal.s.c(this.sourcePath, tutorialModel.sourcePath) && kotlin.jvm.internal.s.c(this.coverPath, tutorialModel.coverPath) && kotlin.jvm.internal.s.c(this.sourceType, tutorialModel.sourceType) && this.defaultCoverImg == tutorialModel.defaultCoverImg && this.title == tutorialModel.title && this.desc == tutorialModel.desc;
        }
        return false;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final int getDefaultCoverImg() {
        return this.defaultCoverImg;
    }

    public final int getDesc() {
        return this.desc;
    }

    public final String getSourcePath() {
        return this.sourcePath;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.sourcePath.hashCode() * 31) + this.coverPath.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + this.defaultCoverImg) * 31) + this.title) * 31) + this.desc;
    }

    public final void setCoverPath(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.coverPath = str;
    }

    public final void setDefaultCoverImg(int i2) {
        this.defaultCoverImg = i2;
    }

    public final void setDesc(int i2) {
        this.desc = i2;
    }

    public final void setSourcePath(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.sourcePath = str;
    }

    public final void setSourceType(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.sourceType = str;
    }

    public final void setTitle(int i2) {
        this.title = i2;
    }

    public String toString() {
        return "TutorialModel(sourcePath=" + this.sourcePath + ", coverPath=" + this.coverPath + ", sourceType=" + this.sourceType + ", defaultCoverImg=" + this.defaultCoverImg + ", title=" + this.title + ", desc=" + this.desc + ')';
    }
}
