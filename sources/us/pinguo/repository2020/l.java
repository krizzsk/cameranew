package us.pinguo.repository2020;

import java.util.List;
import java.util.Map;
import kotlin.collections.m0;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.repository2020.entity.BeautyUnityEnumData;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.Facial3dType;
import us.pinguo.u3dengine.api.SoftSkinParam;
/* compiled from: BeautyEditRepository.kt */
/* loaded from: classes6.dex */
public final class l {
    public static final a n = new a(null);
    private final List<String> a;
    private final List<String> b;
    private final List<String> c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f11868d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f11869e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f11870f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f11871g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f11872h;

    /* renamed from: i  reason: collision with root package name */
    private final List<BeautyEditData> f11873i;

    /* renamed from: j  reason: collision with root package name */
    private final List<BeautyEditData> f11874j;

    /* renamed from: k  reason: collision with root package name */
    private final List<BeautyEditData> f11875k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, BeautyEditData> f11876l;
    private final Map<String, BeautyEditData> m;

    /* compiled from: BeautyEditRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final BeautyEditData a() {
            return new BeautyEditData(PortalFollowFeeds.TYPE_NONE, R.string.str_none, R.drawable.ic_icon_camera_none, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.ZI_RAN_BAI, null, null, null, 14, null), false, false, 0, 1280, null);
        }
    }

    public l() {
        List<String> j2;
        List<String> j3;
        List<String> j4;
        List<String> j5;
        List<String> j6;
        List<String> j7;
        List<String> j8;
        List<String> j9;
        List<BeautyEditData> j10;
        List<BeautyEditData> j11;
        List<BeautyEditData> j12;
        Map<String, BeautyEditData> h2;
        Map<String, BeautyEditData> h3;
        j2 = kotlin.collections.u.j("mopi", "fuse", "yunfu", "wuguanliti", "quban", "falingwen", "yuweiwen", "heiyanquan", "yandai", "hongxuesi", "quhuang", "youguang", "pifusewen", "jili", "liangyan", "baiya");
        this.a = j2;
        j3 = kotlin.collections.u.j("meibai", "ziranbai", "fenbai", "gutong", "qiaokeli");
        this.b = j3;
        j4 = kotlin.collections.u.j("fuse", "pifusewen");
        this.c = j4;
        j5 = kotlin.collections.u.j("xiaolian", "liankuan", "shouxiae", "fajixian", "shouquangu", "fengtaiyangxue", "dianxiaba", "xiaoxiaba");
        this.f11868d = j5;
        j6 = kotlin.collections.u.j("yandaxiao", "eye_type_liuxing", "yankuan", "yanjianju", "yangaodu", "yanweizhi", "yanxuanzhuan", "gaodiyan", "neiyanjiao", "waiyanwei", "yanjianxiazhi", "tiyanwei", "neiyanjiaoxiazhi");
        this.f11869e = j6;
        j7 = kotlin.collections.u.j("meicuxi", "meichangduan", "eyebrow_type_gongxing", "timeiwei", "meiqingxie", "meijianju", "meigaodu", "gaodimei");
        this.f11870f = j7;
        j8 = kotlin.collections.u.j("bidaxiao", "shoubitou", "bishangxia", "bijianchangduan", "shoubiyi", "shoubiliang", "shoushangen", "biweizhi");
        this.f11871g = j8;
        j9 = kotlin.collections.u.j("zuidaxiao", "zuigaodi", "zuikuan", "chunhoubao", "yangzuijiao");
        this.f11872h = j9;
        int i2 = R.string.daxiao;
        int i3 = R.string.gaodi;
        int i4 = R.string.qudou;
        int i5 = R.drawable.icon_beauty_skinrefresh_quban;
        SoftSkinParam softSkinParam = SoftSkinParam.QU_BAN;
        int i6 = R.string.youguang;
        int i7 = R.drawable.icon_beauty_skinrefresh_quyouguang;
        int i8 = R.string.jili;
        int i9 = R.drawable.icon_beauty_skinrefresh_jili;
        SoftSkinParam softSkinParam2 = SoftSkinParam.JI_LI;
        j10 = kotlin.collections.u.j(new BeautyEditData("xiaolian", R.string.xiaolian, R.drawable.icon_beauty_facialfeatures_xiaolian, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_XIAOLIAN, null, null, 13, null), false, false, 0, 1792, null), new BeautyEditData("liankuan", R.string.shoulian, R.drawable.icon_beauty_facialfeatures_shoulian, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_LIANKUAN, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("shouxiae", R.string.shouhegu, R.drawable.icon_beauty_facialfeatures_shouhegu, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_SHOUXIAE, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("fajixian", R.string.fajixian, R.drawable.icon_beauty_facialfeatures_fajixian, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_FAJIXIAN, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("shouquangu", R.string.shouquangu, R.drawable.icon_beauty_facialfeatures_shouquangu, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_SHOUQUANGU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("fengtaiyangxue", R.string.fengtaiyangxue, R.drawable.icon_beauty_facialfeatures_fengtaiyangxue, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_FENGTAIYANGXUE, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("dianxiaba", R.string.dianxiaba, R.drawable.icon_beauty_facialfeatures_dianxiaba, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_DIANXIABA, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("xiaoxiaba", R.string.shouxiaba, R.drawable.icon_beauty_facialfeatures_shouxiaba, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_XIAOXIABA, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("bidaxiao", i2, R.drawable.icon_beauty_facialfeatures_bidaxiao, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BIDAXIAO, null, null, 13, null), false, false, 0, 1792, null), new BeautyEditData("shoubitou", R.string.bijiandaxiao, R.drawable.icon_beauty_facialfeatures_bijiandaxiao, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUBITOU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("bishangxia", R.string.changduan, R.drawable.icon_beauty_facialfeatures_bichangduan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BISHANGXIA, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("bijianchangduan", R.string.bijianchangduan, R.drawable.icon_beauty_facialfeatures_bijianchangduan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BIJIANCHANGDUAN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("shoubiyi", R.string.biyikuandu, R.drawable.icon_beauty_facialfeatures_biyikuandu, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BIYIKUANDU, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("shoubiliang", R.string.shoubiliang, R.drawable.icon_beauty_facialfeatures_biliangkuandu, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUBILIANG, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("shoushangen", R.string.shoushangen, R.drawable.icon_beauty_facialfeatures_shoushangen, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUSHANGEN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("biweizhi", R.string.biweizhi, R.drawable.icon_beauty_facialfeatures_biweizhi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BIWEIZHI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("yandaxiao", i2, R.drawable.icon_beauty_facialfeatures_yandaxiao, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANDAXIAO, null, null, 13, null), false, false, 0, 1792, null), new BeautyEditData("eye_type_liuxing", R.string.yuanyan, R.drawable.icon_beauty_facialfeatures_yuanyan, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YUANYAN, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("yankuan", R.string.yankuan, R.drawable.icon_beauty_facialfeatures_yankuan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANKUAN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("yanjianju", R.string.yanju, R.drawable.icon_beauty_facialfeatures_yanju, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANJIANJU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("yangaodu", R.string.yangaodu, R.drawable.icon_beauty_facialfeatures_yangaodu, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANGAODU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("yanweizhi", R.string.yanweizhi, R.drawable.icon_beauty_facialfeatures_yanweizhi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANWEIZHI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("daxiaoyan", R.string.daxiaoyan, R.drawable.icon_beauty_facialfeatures_daxiaoyan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_DAXIAOYAN, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("yanxuanzhuan", R.string.qinxie, R.drawable.icon_beauty_facialfeatures_yanqingxie, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANXUANZHUAN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("gaodiyan", R.string.gaodiyan, R.drawable.icon_beauty_facialfeatures_gaodiyan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_GAODIYAN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("neiyanjiao", R.string.kaiyanjiao, R.drawable.icon_beauty_facialfeatures_kaiyanjiao, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_NEIYANJIAO, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("waiyanwei", R.string.kaiyanwei, R.drawable.icon_beauty_facialfeatures_kaiyanwei, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_WAIYANWEI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("yanjianxiazhi", R.string.yanjianxiazhi, R.drawable.icon_beauty_facialfeatures_yanjianxiazhi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANJIANXIAZHI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("tiyanwei", R.string.tiyanwei, R.drawable.icon_beauty_facialfeatures_tiyanwei, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_TIYANWEI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("neiyanjiaoxiazhi", R.string.neiyanjiaoxiazhi, R.drawable.icon_beauty_facialfeatures_neiyanjiaoxiazhi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_NEIYANJIAOXIAZHI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("zuidaxiao", R.string.daxiao, R.drawable.icon_beauty_facialfeatures_zuidaxiao, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_ZUIDAXIAO, null, null, 13, null), false, false, 0, 1792, null), new BeautyEditData("zuigaodi", i3, R.drawable.icon_beauty_facialfeatures_zuigaodi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_ZUIGAODI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("zuikuan", R.string.zuikuan, R.drawable.icon_beauty_facialfeatures_zuikuan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_ZUIKUAN, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("chunhoubao", R.string.fengchun, R.drawable.icon_beauty_facialfeatures_fengchun, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_CHUNHOUBAO, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("yangzuijiao", R.string.weixiao, R.drawable.icon_beauty_facialfeatures_zuiweixiao, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_YANGZUIJIAO, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("meicuxi", R.string.cuxi, R.drawable.icon_beauty_facialfeatures_meicuxi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_MEICUXI, null, null, 13, null), false, false, 0, 1792, null), new BeautyEditData("meichangduan", R.string.changduan, R.drawable.icon_beauty_facialfeatures_meichangduan, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_MEICHANGDUAN, null, null, 13, null), true, false, 0, 1536, null), new BeautyEditData("eyebrow_type_gongxing", R.string.timeifeng, R.drawable.icon_beauty_facialfeatures_timeifeng, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_TIMEIFENG, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("timeiwei", R.string.timeiwei, R.drawable.icon_beauty_facialfeatures_timeiwei, 0, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_TIMEIWEI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("meiqingxie", R.string.meiqingxie, R.drawable.icon_beauty_facialfeatures_meiqinxie, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_QINGXIE, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("meijianju", R.string.meijianju, R.drawable.icon_beauty_facialfeatures_meijianju, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_MEIJIANJU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("meigaodu", i3, R.drawable.icon_beauty_facialfeatures_meigaodi, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_GAODU, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("gaodimei", R.string.gaodimei, R.drawable.icon_beauty_facialfeatures_gaodimei, -100, 100, 0, 0, new BeautyUnityEnumData(null, DeformationParam.EDIT_EYEBROW_ADJUST_GAODIMEI, null, null, 13, null), false, false, 0, 1536, null), new BeautyEditData("mopi", R.string.mopi, R.drawable.icon_beauty_skinrefresh_mopi, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.MO_PI, null, null, null, 14, null), false, false, 0, 1280, null), new BeautyEditData("fuse", R.string.fuse_refresh, R.drawable.icon_beauty_skinrefresh_meibai, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.MEI_BAI, null, null, null, 14, null), false, false, 0, 1280, null), new BeautyEditData("yunfu", R.string.yunfu, R.drawable.ic_yunfu, 0, 100, 20, -1, new BeautyUnityEnumData(SoftSkinParam.YUN_FU, null, null, null, 14, null), true, true, 0, 1024, null), new BeautyEditData("wuguanliti", R.string.wuguanliti, R.drawable.icon_beauty_skinrefresh_wuguanliti, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.YIN_YING, null, null, null, 14, null), false, false, 0, 1792, null), new BeautyEditData("quban", i4, i5, 0, 100, 0, 0, new BeautyUnityEnumData(softSkinParam, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("baiya", R.string.baiya, R.drawable.icon_beauty_skinrefresh_baiya, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.BAI_YA, null, null, null, 14, null), false, false, 0, 1792, null), new BeautyEditData("liangyan", R.string.liangyan, R.drawable.icon_beauty_skinrefresh_liangyan, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.LIANG_YAN, null, null, null, 14, null), false, false, 0, 1792, null), new BeautyEditData("heiyanquan", R.string.heiyanquan, R.drawable.icon_beauty_skinrefresh_heiyanquan, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.HEI_YAN_QUAN, null, null, null, 14, null), false, false, 0, 1536, null), new BeautyEditData("pifusewen", R.string.fuse, R.drawable.icon_beauty_skinrefresh_fuse, -100, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.FU_SE, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("yandai", R.string.quyandai, R.drawable.icon_beauty_skinrefresh_yandai, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.YAN_DAI, null, null, null, 14, null), false, false, 0, 1536, null), new BeautyEditData("falingwen", R.string.falingwen, R.drawable.icon_beauty_skinrefresh_falingwen, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.FA_LING_WEN, null, null, null, 14, null), true, false, 0, 1536, null), new BeautyEditData("yuweiwen", R.string.yuweiwen, R.drawable.icon_beauty_skinrefresh_yuweiwen, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.YU_WEI_WEN, null, null, null, 14, null), true, false, 0, 1536, null), new BeautyEditData("hongxuesi", R.string.hongxuesi, R.drawable.icon_beauty_skinrefresh_hongxuesi, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.HONG_XUE_SI, null, null, null, 14, null), true, false, 0, 1536, null), new BeautyEditData("quhuang", R.string.quhuang, R.drawable.icon_beauty_skinrefresh_quhuang, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.QU_HUANG, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("youguang", i6, i7, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.YOU_GUANG, null, null, null, 14, null), true, false, 0, 1536, null), new BeautyEditData("jili", i8, i9, 0, 100, 0, 0, new BeautyUnityEnumData(softSkinParam2, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("quban", i4, i5, 0, 100, 0, 0, new BeautyUnityEnumData(softSkinParam, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("meibai", R.string.meibai, R.color.color_whitening, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.FU_SE_MEI_BAI, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("ziranbai", R.string.ziranbai, R.color.color_ziranbai, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.ZI_RAN_BAI, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("fenbai", R.string.fenbai, R.color.color_fenbai, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.FEN_BAI, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("gutong", R.string.gutong, R.color.color_gutong, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.GU_TONG, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("qiaokeli", R.string.qiaokeli, R.color.color_qiaokeli, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.QIAO_KE_LI, null, null, null, 14, null), true, false, 0, 1024, null));
        this.f11873i = j10;
        int i10 = R.string.qudou;
        int i11 = R.string.liangbai;
        int i12 = R.drawable.icon_beauty_skinrefresh_baiya;
        j11 = kotlin.collections.u.j(new BeautyEditData("mopi", R.string.mopi, R.drawable.icon_beauty_skinrefresh_mopi, 0, 100, 35, 35, new BeautyUnityEnumData(SoftSkinParam.MO_PI, null, null, null, 14, null), false, false, 0, 1280, null), new BeautyEditData("tiliang", R.string.tiliang, R.drawable.icon_beauty_manual_tiliang, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.TI_LIANG, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("jiashen", R.string.jiashen, R.drawable.icon_beauty_skinrefresh_jiashen, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.JIA_SHEN, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("quzhouwen", R.string.quzhou, R.drawable.icon_beauty_skinrefresh_quzhou, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.QU_ZHOU_WEN, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("qudou", i10, R.drawable.icon_beauty_skinrefresh_qudou, 0, 100, 80, 80, new BeautyUnityEnumData(SoftSkinParam.QU_DOU, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("quheitou", R.string.quheitou, R.drawable.icon_beauty_skinrefresh_quheitou, 0, 100, 100, 100, new BeautyUnityEnumData(SoftSkinParam.QU_HEITOU, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("zengse", R.string.qise, R.drawable.icon_beauty_skinrefresh_qise, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.ZENG_SE, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("yaguang", R.string.yaguang, i7, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.YA_GUANG, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("jili", i8, i9, 0, 100, 100, 100, new BeautyUnityEnumData(softSkinParam2, null, null, null, 14, null), true, false, 0, 1024, null), new BeautyEditData("jiegoutuchu", R.string.xijie, R.drawable.icon_beauty_skinrefresh_xijie, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.XI_JIE, null, null, null, 14, null), false, false, 0, 1024, null), new BeautyEditData("liangbai", i11, i12, 0, 100, 100, 100, new BeautyUnityEnumData(SoftSkinParam.LIANG_BAI, null, null, null, 14, null), false, false, 0, 1024, null));
        this.f11874j = j11;
        j12 = kotlin.collections.u.j(new BeautyEditData("quanbuliti", R.string.facial3d_quanbu, R.drawable.ic_facial3d_all, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, null, 15, null), true, true, 0, 1024, null), new BeautyEditData("bizi", R.string.edit_facialfeatures_tab_nose, R.drawable.ic_facial3d_bizi, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.BIZI, 7, null), true, true, 0, 1024, null), new BeautyEditData("meimao", R.string.edit_facialfeatures_tab_eyebrow, R.drawable.ic_facial3d_meimao, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.MEIMAO, 7, null), true, true, 0, 1024, null), new BeautyEditData("yanjing", R.string.edit_facialfeatures_tab_eye, R.drawable.ic_facial3d_yanjing, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.YANGJING, 7, null), true, true, 0, 1024, null), new BeautyEditData("lianjia", R.string.facial3d_lianjia, R.drawable.ic_facial3d_lianjia, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.LIANJIA, 7, null), true, true, 0, 1024, null), new BeautyEditData("xiahe", R.string.facial3d_xiahe, R.drawable.ic_facial3d_xiahe, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.XIAHE, 7, null), true, true, 0, 1024, null), new BeautyEditData("zuiba", R.string.edit_facialfeatures_tab_mouth, R.drawable.ic_facial3d_zuiba, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.ZUIBA, 7, null), true, true, 0, 1024, null), new BeautyEditData("etou", R.string.facial3d_etou, R.drawable.ic_facial3d_etou, -50, 50, 0, 0, new BeautyUnityEnumData(null, null, null, Facial3dType.ETOU, 7, null), true, true, 0, 1024, null));
        this.f11875k = j12;
        int i13 = R.string.mopi;
        int i14 = R.drawable.icon_beauty_skinrefresh_mopi;
        SoftSkinParam softSkinParam3 = SoftSkinParam.MO_PI;
        int i15 = R.string.jili;
        int i16 = R.drawable.icon_beauty_skinrefresh_jili;
        SoftSkinParam softSkinParam4 = SoftSkinParam.JI_LI;
        h2 = m0.h(kotlin.k.a("qudou", new BeautyEditData("quban", i10, R.drawable.icon_beauty_skinrefresh_quban, 0, 100, 0, 100, new BeautyUnityEnumData(SoftSkinParam.QU_BAN, null, null, null, 14, null), false, false, 100)), kotlin.k.a("mopi", new BeautyEditData("mopi", i13, i14, 0, 100, 0, 30, new BeautyUnityEnumData(softSkinParam3, null, null, null, 14, null), false, false, 30, 256, null)), kotlin.k.a("yunfu", new BeautyEditData("yunfu", R.string.yunfu, R.drawable.ic_yunfu, 0, 100, 0, 20, new BeautyUnityEnumData(SoftSkinParam.YUN_FU, null, null, null, 14, null), true, true, 30)), kotlin.k.a("baiya", new BeautyEditData("baiya", R.string.baiya, i12, 0, 100, 0, 50, new BeautyUnityEnumData(SoftSkinParam.BAI_YA, null, null, null, 14, null), false, false, 50, 768, null)), kotlin.k.a("liangyan", new BeautyEditData("liangyan", R.string.liangyan, R.drawable.icon_beauty_skinrefresh_liangyan, 0, 100, 0, 100, new BeautyUnityEnumData(SoftSkinParam.LIANG_YAN, null, null, null, 14, null), false, false, 100, 768, null)), kotlin.k.a("heiyanquan", new BeautyEditData("heiyanquan", R.string.heiyanquan, R.drawable.icon_beauty_skinrefresh_heiyanquan, 0, 100, 0, 50, new BeautyUnityEnumData(SoftSkinParam.HEI_YAN_QUAN, null, null, null, 14, null), false, false, 50, 512, null)), kotlin.k.a("yandai", new BeautyEditData("yandai", R.string.quyandai, R.drawable.icon_beauty_skinrefresh_yandai, 0, 100, 0, 50, new BeautyUnityEnumData(SoftSkinParam.YAN_DAI, null, null, null, 14, null), false, false, 50, 512, null)), kotlin.k.a("hongxuesi", new BeautyEditData("hongxuesi", R.string.hongxuesi, R.drawable.icon_beauty_skinrefresh_hongxuesi, 0, 100, 0, 100, new BeautyUnityEnumData(SoftSkinParam.HONG_XUE_SI, null, null, null, 14, null), true, false, 100, 512, null)), kotlin.k.a("youguang", new BeautyEditData("youguang", R.string.youguang, R.drawable.icon_beauty_skinrefresh_quyouguang, 0, 100, 0, 100, new BeautyUnityEnumData(SoftSkinParam.YOU_GUANG, null, null, null, 14, null), true, false, 100, 512, null)), kotlin.k.a("jili", new BeautyEditData("jili", i15, i16, 0, 100, 0, 50, new BeautyUnityEnumData(softSkinParam4, null, null, null, 14, null), true, false, 50)), kotlin.k.a("wuguanliti", new BeautyEditData("wuguanliti", R.string.wuguanliti, R.drawable.icon_beauty_skinrefresh_wuguanliti, 0, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.YIN_YING, null, null, null, 14, null), false, false, 0, 1792, null)));
        this.f11876l = h2;
        int i17 = R.string.xijie;
        int i18 = R.drawable.icon_beauty_manual;
        int i19 = R.string.tiliang;
        SoftSkinParam softSkinParam5 = SoftSkinParam.TI_LIANG;
        h3 = m0.h(kotlin.k.a("liangyan", new BeautyEditData("jiegoutuchu", i17, i18, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.XI_JIE, null, null, null, 14, null), false, false, 0, 1024, null)), kotlin.k.a("baiya", new BeautyEditData("liangbai", R.string.liangbai, i18, 0, 100, 100, 100, new BeautyUnityEnumData(SoftSkinParam.LIANG_BAI, null, null, null, 14, null), false, false, 0, 1024, null)), kotlin.k.a("youguang", new BeautyEditData("yaguang", R.string.yaguang, i18, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.YA_GUANG, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("heiyanquan", new BeautyEditData("tiliang", i19, i18, 0, 100, 50, 50, new BeautyUnityEnumData(softSkinParam5, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("yandai", new BeautyEditData("tiliang", i19, i18, 0, 100, 50, 50, new BeautyUnityEnumData(softSkinParam5, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("hongxuesi", new BeautyEditData("tiliang", i19, i18, 0, 100, 50, 50, new BeautyUnityEnumData(softSkinParam5, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("quzhouwen", new BeautyEditData("quzhouwen", R.string.quzhou, i18, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.QU_ZHOU_WEN, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("mopi", new BeautyEditData("mopi", i13, i18, 0, 100, 35, 35, new BeautyUnityEnumData(softSkinParam3, null, null, null, 14, null), false, false, 0, 1024, null)), kotlin.k.a("quheitou", new BeautyEditData("quheitou", R.string.quheitou, R.drawable.icon_beauty_quheitou, 0, 100, 100, 100, new BeautyUnityEnumData(SoftSkinParam.QU_HEITOU, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("qudou", new BeautyEditData("qudou", R.string.qudou, i18, 0, 100, 80, 80, new BeautyUnityEnumData(SoftSkinParam.QU_DOU, null, null, null, 14, null), false, false, 0, 1024, null)), kotlin.k.a("tiliang", new BeautyEditData("tiliang", i19, R.drawable.icon_beauty_manual_tiliang, 0, 100, 50, 50, new BeautyUnityEnumData(softSkinParam5, null, null, null, 14, null), true, false, 0, 1024, null)), kotlin.k.a("jiashen", new BeautyEditData("jiashen", R.string.jiashen, R.drawable.icon_beauty_skinrefresh_jiashen, 0, 100, 50, 50, new BeautyUnityEnumData(SoftSkinParam.JIA_SHEN, null, null, null, 14, null), false, false, 0, 1024, null)), kotlin.k.a("jili", new BeautyEditData("jili", i15, i18, 0, 100, 100, 100, new BeautyUnityEnumData(softSkinParam4, null, null, null, 14, null), true, false, 0, 1024, null)));
        this.m = h3;
    }

    public final List<BeautyEditData> a() {
        return this.f11873i;
    }

    public final List<BeautyEditData> b() {
        return this.f11875k;
    }

    public final List<String> c() {
        return this.f11869e;
    }

    public final List<String> d() {
        return this.f11870f;
    }

    public final List<String> e() {
        return this.f11868d;
    }

    public final List<String> f() {
        return this.f11872h;
    }

    public final List<String> g() {
        return this.f11871g;
    }

    public final BeautyEditData h() {
        return new BeautyEditData("pifusewen", R.string.fuse, R.drawable.icon_beauty_skinrefresh_fuse, -100, 100, 0, 0, new BeautyUnityEnumData(SoftSkinParam.FU_SE, null, null, null, 14, null), false, false, 0, 1024, null);
    }

    public final Map<String, BeautyEditData> i() {
        return this.f11876l;
    }

    public final Map<String, BeautyEditData> j() {
        return this.m;
    }

    public final List<String> k() {
        return this.c;
    }

    public final List<String> l() {
        return this.b;
    }

    public final List<BeautyEditData> m() {
        return this.f11874j;
    }

    public final List<String> n() {
        return this.a;
    }

    public final boolean o(String beautyKey) {
        kotlin.jvm.internal.s.h(beautyKey, "beautyKey");
        return this.b.contains(beautyKey) || kotlin.jvm.internal.s.c(PortalFollowFeeds.TYPE_NONE, beautyKey);
    }
}
