package us.pinguo.repository2020;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.m0;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.database.makeup.MaterialItemTable;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.BeautyUnityEnumData;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.u3dengine.api.DeformationParam;
import us.pinguo.u3dengine.api.MakeupType;
import us.pinguo.u3dengine.api.SoftSkinParam;
/* compiled from: BeautyDataRepository.kt */
/* loaded from: classes6.dex */
public final class BeautyDataRepository {
    public static final a D = new a(null);
    private static final HashMap<String, Integer> E;
    private static final HashMap<String, String> F;
    private final ArrayList<BeautyData> A;
    private final ArrayList<BeautyData> B;
    private final ArrayList<BeautyData> C;
    private final String a = kotlin.jvm.internal.s.q(us.pinguo.foundation.e.b().getFilesDir().getAbsolutePath(), File.separator);
    private final HashMap<String, String> b = new HashMap<>();
    private final HashMap<String, String> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private u<StyleMakeup> f11790d = new u<>(null);

    /* renamed from: e  reason: collision with root package name */
    private u<BeautyData> f11791e = new u<>(null);

    /* renamed from: f  reason: collision with root package name */
    private u<BeautyData> f11792f = new u<>(null);

    /* renamed from: g  reason: collision with root package name */
    private int f11793g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f11794h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, Integer> f11795i;

    /* renamed from: j  reason: collision with root package name */
    private final List<String> f11796j;

    /* renamed from: k  reason: collision with root package name */
    private final List<Integer> f11797k;

    /* renamed from: l  reason: collision with root package name */
    private final List<Integer> f11798l;
    private final List<Integer> m;
    private final List<BeautyUnityEnumData> n;
    private final List<Integer> o;
    private final List<Integer> p;
    private final List<Integer> q;
    private final List<ObservableInt> r;
    private final List<Boolean> s;
    private final List<Boolean> t;
    private final List<Boolean> u;
    private final List<String> v;
    private final List<List<String>> w;
    private final ArrayList<BeautyData> x;
    private final ArrayList<BeautyData> y;
    private final ArrayList<BeautyData> z;

    /* compiled from: BeautyDataRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final HashMap<String, String> a() {
            return BeautyDataRepository.F;
        }

        public final HashMap<String, Integer> b() {
            return BeautyDataRepository.E;
        }
    }

    static {
        HashMap<String, Integer> g2;
        HashMap<String, String> g3;
        g2 = m0.g(kotlin.k.a("EYEBROW", Integer.valueOf(R.drawable.camera_icon_makeup_meimao)), kotlin.k.a("EYESHADOW", Integer.valueOf(R.drawable.camera_icon_makeup_yanying)), kotlin.k.a("EYELASH", Integer.valueOf(R.drawable.camera_icon_makeup_jiemao)), kotlin.k.a("EYEBALL", Integer.valueOf(R.drawable.camera_icon_makeup_meitong)), kotlin.k.a("LIP", Integer.valueOf(R.drawable.camera_icon_beauty_kouhong)), kotlin.k.a("FACE_BLUSHER", Integer.valueOf(R.drawable.camera_icon_makeup_saihong)), kotlin.k.a("FACE_T_AREA", Integer.valueOf(R.drawable.camera_icon_makeup_xiurong)), kotlin.k.a("COMPLEXION", Integer.valueOf(R.drawable.camera_icon_beauty_fendi)));
        E = g2;
        g3 = m0.g(kotlin.k.a("EYEBROW", "meimao"), kotlin.k.a("EYESHADOW", "yanying"), kotlin.k.a("EYELASH", "jiemao"), kotlin.k.a("EYEBALL", "meitong"), kotlin.k.a("LIP", "kouhong"), kotlin.k.a("FACE_BLUSHER", "saihong"), kotlin.k.a("FACE_T_AREA", "xiurong"), kotlin.k.a("COMPLEXION", "fendi"), kotlin.k.a("DEFAULT", ""));
        F = g3;
    }

    public BeautyDataRepository() {
        List<String> j2;
        HashMap<String, Integer> g2;
        List<String> j3;
        List<Integer> j4;
        List<Integer> j5;
        List<Integer> j6;
        List<BeautyUnityEnumData> j7;
        List<Integer> j8;
        List<Integer> j9;
        List<Integer> j10;
        List<ObservableInt> j11;
        List<Boolean> j12;
        List<Boolean> j13;
        List<Boolean> j14;
        List<String> j15;
        List j16;
        List j17;
        List j18;
        List j19;
        List j20;
        List j21;
        List j22;
        List<List<String>> j23;
        j2 = kotlin.collections.u.j("mopi", "meibai", "xiaolian", "vlian", "shoulian", "shouquangu", "dianxiaba", "fajixian", "shoubiyi", "shoubiliang", "bichangduan", "shoubitou", "baiya", "zuidaxiao", "fengchun", "gaodu", "weixiao", "dayan", "liangyan", "heiyanquan", "yuanyan", "yanju", "kaiyanjiao", "jiaodu", "quyandai", "falingwen", "yuweiwen", "pingzhi", "gongxing", "liuye", "cuxi", "gaodimei", "timeiwei", "fendi", "fendiwu", "fendinatural", "ivory", "pink", "malt", "kouhong", "kouhongwu", "kouhongnatural", "matte", "moisten", "bite", "saihong", "saihongwu", "area", "sunburn", "triangle", "corner of eye", "meimao", "meimaowu", "light", "thick", "yanying", "yanyingwu", "single", "double", "jiemao", "jiemaowu", "jiemaoN°1", "jiemaoN°2", "jiemaoN°3", "xiurong", "xiurongwu", "xiurongN°1", "xiurongN°2", "xiurongN°3", "xiurongN°4", "meitong", "meitongwu", "meitongnatural", "water_wave", "flower", "starry_sky");
        this.f11794h = j2;
        g2 = m0.g(kotlin.k.a("shoulian", 40), kotlin.k.a("heiyanquan", 0), kotlin.k.a("yuanyan", 10));
        this.f11795i = g2;
        j3 = kotlin.collections.u.j("mopi", "meibai", "heiyanquan", "falingwen", "quyandai", "yuweiwen", "liangyan", "xiaolian", "vlian", "shoulian", "shouquangu", "dianxiaba", "fajixian", "baiya", "zuidaxiao", "fengchun", "gaodu", "weixiao", "pingzhi", "gongxing", "liuye", "cuxi", "gaodimei", "timeiwei", "dayan", "yuanyan", "yanju", "kaiyanjiao", "jiaodu", "shoubiyi", "shoubiliang", "bichangduan", "shoubitou", "fendi", "fendiwu", "fendinatural", "ivory", "pink", "malt", "kouhong", "kouhongwu", "kouhongnatural", "matte", "moisten", "bite", "saihong", "saihongwu", "area", "sunburn", "triangle", "corner of eye", "meimao", "meimaowu", "light", "thick", "yanying", "yanyingwu", "single", "double", "jiemao", "jiemaowu", "jiemaoN°1", "jiemaoN°2", "jiemaoN°3", "xiurong", "xiurongwu", "xiurongN°1", "xiurongN°2", "xiurongN°3", "xiurongN°4", "meitong", "meitongwu", "meitongnatural", "water_wave", "flower", "starry_sky");
        this.f11796j = j3;
        int i2 = R.string.str_none;
        int i3 = R.string.ziran;
        int i4 = R.string.N1;
        int i5 = R.string.N2;
        int i6 = R.string.N3;
        j4 = kotlin.collections.u.j(Integer.valueOf(R.string.mopi), Integer.valueOf(R.string.meibai), Integer.valueOf(R.string.heiyanquan), Integer.valueOf(R.string.falingwen), Integer.valueOf(R.string.quyandai), Integer.valueOf(R.string.yuweiwen), Integer.valueOf(R.string.liangyan), Integer.valueOf(R.string.xiaolian), Integer.valueOf(R.string.vlian), Integer.valueOf(R.string.shoulian), Integer.valueOf(R.string.shouquangu), Integer.valueOf(R.string.dianxiaba), Integer.valueOf(R.string.fajixian), Integer.valueOf(R.string.baiya), Integer.valueOf(R.string.daxiao), Integer.valueOf(R.string.fengchun), Integer.valueOf(R.string.gaodu), Integer.valueOf(R.string.weixiao), Integer.valueOf(R.string.pingzhi), Integer.valueOf(R.string.gongxing), Integer.valueOf(R.string.liuye), Integer.valueOf(R.string.cuxi), Integer.valueOf(R.string.gaodimei), Integer.valueOf(R.string.timeiwei), Integer.valueOf(R.string.dayan), Integer.valueOf(R.string.yuanyan), Integer.valueOf(R.string.yanju), Integer.valueOf(R.string.kaiyanjiao), Integer.valueOf(R.string.jiaodu), Integer.valueOf(R.string.shoubiyi), Integer.valueOf(R.string.shoubiliang), Integer.valueOf(R.string.bichangduan), Integer.valueOf(R.string.shoubitou), Integer.valueOf(R.string.fendi), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(R.string.xiangyabai), Integer.valueOf(R.string.fennen), Integer.valueOf(R.string.maiya), Integer.valueOf(R.string.kouhong), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(R.string.yaguang), Integer.valueOf(R.string.zirun), Integer.valueOf(R.string.yaochun), Integer.valueOf(R.string.saihong), Integer.valueOf(i2), Integer.valueOf(R.string.mianji), Integer.valueOf(R.string.shaishang), Integer.valueOf(R.string.sanjiao), Integer.valueOf(R.string.yanjiao), Integer.valueOf(R.string.meimao), Integer.valueOf(i2), Integer.valueOf(R.string.danmei), Integer.valueOf(R.string.nongmei), Integer.valueOf(R.string.yanying), Integer.valueOf(i2), Integer.valueOf(R.string.danse), Integer.valueOf(R.string.shuangse), Integer.valueOf(R.string.jiemao), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(R.string.xiurong), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(R.string.N4), Integer.valueOf(R.string.meitong), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(R.string.shuibo), Integer.valueOf(R.string.huaduo), Integer.valueOf(R.string.xingkong));
        this.f11797k = j4;
        int i7 = R.drawable.camera_icon_makeup_none;
        j5 = kotlin.collections.u.j(Integer.valueOf(R.drawable.icon_beauty_skinrefresh_mopi), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_meibai), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_heiyanquan), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_falingwen), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_yandai), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_yuweiwen), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_liangyan), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_xiaolian), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_vlian), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_shoulian), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_shouquangu), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_dianxiaba), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_fajixian), Integer.valueOf(R.drawable.icon_beauty_skinrefresh_baiya), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_zuidaxiao), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_fengchun), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_zuigaodi), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_zuiweixiao), Integer.valueOf(R.drawable.camera_icon_beauty_brow_pingzhi_dark), Integer.valueOf(R.drawable.camera_icon_beauty_brow_gongxing_dark), Integer.valueOf(R.drawable.camera_icon_beauty_brow_liuye_dark), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_meicuxi), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_gaodimei), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_timeiwei), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_yandaxiao), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_yuanyan), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_yanju), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_kaiyanjiao), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_yanqingxie), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_biyikuandu), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_biliangkuandu), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_bichangduan), Integer.valueOf(R.drawable.icon_beauty_facialfeatures_bijiandaxiao), Integer.valueOf(R.drawable.camera_icon_beauty_fendi), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_fendi_ziranse), Integer.valueOf(R.drawable.ic_fendi_xiangyabai), Integer.valueOf(R.drawable.ic_fendi_fennense), Integer.valueOf(R.drawable.ic_fendi_maiyase), Integer.valueOf(R.drawable.camera_icon_beauty_kouhong), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_kouhong_zhengchang), Integer.valueOf(R.drawable.ic_kouhong_yaguang), Integer.valueOf(R.drawable.ic_kouhong_zirun), Integer.valueOf(R.drawable.ic_kouhong_yaochun), Integer.valueOf(R.drawable.camera_icon_makeup_saihong), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_saihong_mianji), Integer.valueOf(R.drawable.ic_saihong_shaishang), Integer.valueOf(R.drawable.ic_saihong_sanjiao), Integer.valueOf(R.drawable.ic_saihong_yanjiao), Integer.valueOf(R.drawable.camera_icon_makeup_meimao), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_meimao_danmei), Integer.valueOf(R.drawable.ic_meimao_nongmei), Integer.valueOf(R.drawable.camera_icon_makeup_yanying), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_makeup_danse), Integer.valueOf(R.drawable.ic_makeup_shuangse), Integer.valueOf(R.drawable.camera_icon_makeup_jiemao), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_makeup_jiemao_1), Integer.valueOf(R.drawable.ic_makeup_jiemao_2), Integer.valueOf(R.drawable.ic_makeup_jiemao_3), Integer.valueOf(R.drawable.camera_icon_makeup_xiurong), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_xiurong_biliang), Integer.valueOf(R.drawable.ic_xiurong_etou), Integer.valueOf(R.drawable.ic_xiurong_quangu), Integer.valueOf(R.drawable.ic_xiurong_xiahe), Integer.valueOf(R.drawable.camera_icon_makeup_meitong), Integer.valueOf(i7), Integer.valueOf(R.drawable.ic_makeup_ziran), Integer.valueOf(R.drawable.ic_makeup_shuibo), Integer.valueOf(R.drawable.ic_makeup_huaduo), Integer.valueOf(R.drawable.ic_makeup_xingkong));
        this.f11798l = j5;
        j6 = kotlin.collections.u.j(2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        this.m = j6;
        MakeupType makeupType = MakeupType.COMPLEXION;
        MakeupType makeupType2 = MakeupType.LIP;
        MakeupType makeupType3 = MakeupType.FACE_BLUSHER;
        MakeupType makeupType4 = MakeupType.EYEBROW;
        MakeupType makeupType5 = MakeupType.EYESHADOW;
        MakeupType makeupType6 = MakeupType.EYELINER;
        MakeupType makeupType7 = MakeupType.FACE_T_AREA;
        MakeupType makeupType8 = MakeupType.EYEBALL;
        j7 = kotlin.collections.u.j(new BeautyUnityEnumData(SoftSkinParam.SOFT_SKIN, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.SKIN_WHITE, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.HEI_YAN_QUAN, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.FA_LING_WEN, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.YAN_DAI, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.YU_WEI_WEN, null, null, null, 14, null), new BeautyUnityEnumData(SoftSkinParam.LIANG_YAN, null, null, null, 14, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_XIAOLIAN, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_SHOUXIAE, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_LIANKUAN, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_SHOUQUANGU, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_DIANXIABA, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.FACE_ADJUST_FAJIXIAN, null, null, 13, null), new BeautyUnityEnumData(SoftSkinParam.WHITE_TOOTH, null, null, null, 14, null), new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_ZUIDAXIAO, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_CHUNHOUBAO, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_ZUIGAODI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.MOUTH_ADJUST_YANGZUIJIAO, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_TYPE_PINGZHI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_TYPE_GONGXING, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_TYPE_LIUYE, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_MEICUXI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_GAODIMEI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYEBROW_ADJUST_TIMEIWEI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANDAXIAO, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYE_TYPE_LIUXING, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANJIANJU, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_NEIYANJIAO, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.EYE_ADJUST_YANXUANZHUAN, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUBIYI, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUBILIANG, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_BISHANGXIA, null, null, 13, null), new BeautyUnityEnumData(null, DeformationParam.NOSE_ADJUST_SHOUBITOU, null, null, 13, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType, null, 11, null), new BeautyUnityEnumData(null, null, makeupType, null, 11, null), new BeautyUnityEnumData(null, null, makeupType, null, 11, null), new BeautyUnityEnumData(null, null, makeupType, null, 11, null), new BeautyUnityEnumData(null, null, makeupType, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType2, null, 11, null), new BeautyUnityEnumData(null, null, makeupType2, null, 11, null), new BeautyUnityEnumData(null, null, makeupType2, null, 11, null), new BeautyUnityEnumData(null, null, makeupType2, null, 11, null), new BeautyUnityEnumData(null, null, makeupType2, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType3, null, 11, null), new BeautyUnityEnumData(null, null, makeupType3, null, 11, null), new BeautyUnityEnumData(null, null, makeupType3, null, 11, null), new BeautyUnityEnumData(null, null, makeupType3, null, 11, null), new BeautyUnityEnumData(null, null, makeupType3, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType4, null, 11, null), new BeautyUnityEnumData(null, null, makeupType4, null, 11, null), new BeautyUnityEnumData(null, null, makeupType4, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType5, null, 11, null), new BeautyUnityEnumData(null, null, makeupType5, null, 11, null), new BeautyUnityEnumData(null, null, makeupType5, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType6, null, 11, null), new BeautyUnityEnumData(null, null, makeupType6, null, 11, null), new BeautyUnityEnumData(null, null, makeupType6, null, 11, null), new BeautyUnityEnumData(null, null, makeupType6, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType7, null, 11, null), new BeautyUnityEnumData(null, null, makeupType7, null, 11, null), new BeautyUnityEnumData(null, null, makeupType7, null, 11, null), new BeautyUnityEnumData(null, null, makeupType7, null, 11, null), new BeautyUnityEnumData(null, null, makeupType7, null, 11, null), new BeautyUnityEnumData(null, null, null, null, 15, null), new BeautyUnityEnumData(null, null, makeupType8, null, 11, null), new BeautyUnityEnumData(null, null, makeupType8, null, 11, null), new BeautyUnityEnumData(null, null, makeupType8, null, 11, null), new BeautyUnityEnumData(null, null, makeupType8, null, 11, null), new BeautyUnityEnumData(null, null, makeupType8, null, 11, null));
        this.n = j7;
        j8 = kotlin.collections.u.j(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, -1, 100, 100, 100, 100, 100, -1, 100, 100, 100, 100, 100, -1, 100, 100, 100, 100, 100, -1, 100, 100, 100, -1, 100, 100, 100, -1, 100, 100, 100, 100, -1, 100, 100, 100, 100, 100, -1, 100, 100, 100, 100, 100);
        this.o = j8;
        j9 = kotlin.collections.u.j(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -100, -100, 0, -100, -100, -100, 0, 0, 0, 0, -100, -100, 0, 0, 0, -100, 0, -100, 0, 0, -100, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
        this.p = j9;
        j10 = kotlin.collections.u.j(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0);
        this.q = j10;
        j11 = kotlin.collections.u.j(new ObservableInt(40), new ObservableInt(0), new ObservableInt(50), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(50), new ObservableInt(30), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(20), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(20), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(20), new ObservableInt(10), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(0), new ObservableInt(80), new ObservableInt(80), new ObservableInt(80), new ObservableInt(80), new ObservableInt(0), new ObservableInt(0), new ObservableInt(60), new ObservableInt(60), new ObservableInt(60), new ObservableInt(60), new ObservableInt(0), new ObservableInt(0), new ObservableInt(30), new ObservableInt(30), new ObservableInt(30), new ObservableInt(30), new ObservableInt(0), new ObservableInt(0), new ObservableInt(60), new ObservableInt(60), new ObservableInt(0), new ObservableInt(0), new ObservableInt(40), new ObservableInt(60), new ObservableInt(0), new ObservableInt(0), new ObservableInt(70), new ObservableInt(70), new ObservableInt(70), new ObservableInt(0), new ObservableInt(0), new ObservableInt(70), new ObservableInt(70), new ObservableInt(70), new ObservableInt(70), new ObservableInt(0), new ObservableInt(0), new ObservableInt(65), new ObservableInt(65), new ObservableInt(65), new ObservableInt(65));
        this.r = j11;
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.TRUE;
        j12 = kotlin.collections.u.j(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool2, bool, bool, bool, bool2, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool);
        this.s = j12;
        j13 = kotlin.collections.u.j(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool2, bool, bool, bool, bool2, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool);
        this.t = j13;
        j14 = kotlin.collections.u.j(bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool2, bool2, bool2, bool, bool, bool, bool2, bool, bool2, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool2, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool);
        this.u = j14;
        j15 = kotlin.collections.u.j("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "fuseziranse/bundle/888ce478083098e45ff46ba612c001b0", "fusexiangyabai/bundle/e057267aedcdfefa9bc9bb422e8a000a", "fusefennense/bundle/79646026b15494fffc0907fa20c1463f", "fusemaiyase/bundle/8571e01dd9865e62829ca3981eabaa6f", "", "", "kouhongzhengchang/bundle/ce96d04544d7cc035e8c87f875661c83", "kouhongyaguang/bundle/473b3fd19da6cf969cc15d918d93cc6b", "kouhongzirun/bundle/0fea45f67752fee66ca9bc2fb0e26583", "kouhongyaochun/bundle/ccb956b6db6bb0f6919615350d6c8a42", "", "", "saihongmianji/bundle/fbc9a332daf47f99d638071f09cac8fb", "saihongshaishang/bundle/bef49aeb6e23fa7b3bdbc976db732236", "saihongsanjiao/bundle/2f98576758d642251d9d8fc235ad93a5", "saihongyanjiao/bundle/1af6334a1c092facca9af50855e3c364", "", "", "meimaodanmei/bundle/ed9190346d8e0eea2b06e3b29cae5539", "meimaonongmei/bundle/320131f6dc4cc68923a4d33a217b409d", "", "", "yanyingdanse/bundle/0d6e58ab09910ae59f9a82b26dbfb8fc", "yanyingjianceng/bundle/2c68e04cae812fe8ba3d3ee2690fe1a8", "", "", "yanxianxixian/bundle/1676bed6e9f5003be185de2c7ef1557e", "yanxiancuxian/bundle/b701df9e9e0d16aaa6e944f23f50d30a", "yanxiancuqiaoxian/bundle/405b065c8e99550bd88c950aaf8b1e14", "", "", "bibubiliang/bundle/d25a200087c95b637e93d26411b15b4b", "bibuetou/bundle/07fc00fcc975047404293da02c136c3b", "bibuquangu/bundle/a4d880994d3489f0371e4943dd086edf", "bibuxiahe/bundle/3a11afdc9e952e837b9527aeb5b0a999", "", "", "meitongziran/bundle/68228a229bd61feebfcf0a3867636949", "meitongshuibo/bundle/9459f46e38a27b5b32eb0748c4a14dcc", "meitonghuaduo/bundle/b656f6cbfba0917b090b6696ef5ced65", "meitongxingkong/bundle/70b619f80211214dba80adfdf7793f52");
        this.v = j15;
        j16 = kotlin.collections.u.j("#8e3711", "#951554", "#850707", "#d87160", "#c6666b", "#db3232", "#fd7c5e", "#e96191", "#fe5659");
        j17 = kotlin.collections.u.j("#fc463a", "#da585b", "#b73547", "#d34272", "#e17077", "#e36e4d", "#f49352");
        j18 = kotlin.collections.u.j("#171717", "#1b1610", "#2a1c12", "#4a3121", "#362624", "#41220f", "#160905", "#000000");
        j19 = kotlin.collections.u.j("#ff6a6a", "#ff734e", "#e7588a", "#d99f85", "#ac5841", "#c9616c");
        j20 = kotlin.collections.u.j(String.valueOf(R.drawable.yanying_color0), String.valueOf(R.drawable.yanying_color1), String.valueOf(R.drawable.yanying_color2), String.valueOf(R.drawable.yanying_color3), String.valueOf(R.drawable.yanying_color4));
        j21 = kotlin.collections.u.j("#000000", "#5c3524", "#5e3037", "#29425c", "#3f503b");
        j22 = kotlin.collections.u.j("#ccd5d2", "#697476", "#fd9a54", "#f668b2", "#5c3466", "#684b2d", "#672622", "#66662a", "#5d828b", "#3e575c", "#99554a");
        j23 = kotlin.collections.u.j(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, j16, null, null, null, null, null, j17, null, null, null, null, null, j18, null, null, null, null, null, j19, j20, j21, null, null, null, null, null, null, null, null, null, null, j22, null, null, null, null, null);
        this.w = j23;
        ArrayList<BeautyData> d2 = d();
        this.x = d2;
        this.y = f(d2, 0, 32);
        ArrayList<BeautyData> f2 = f(this.x, 33, 75);
        this.z = f2;
        this.A = f(f2, 0, 5);
        this.B = f(this.z, 6, 11);
        this.C = f(this.z, 22, 25);
    }

    private final ArrayList<BeautyData> d() {
        int i2;
        List p0;
        s();
        ArrayList<BeautyData> arrayList = new ArrayList<>();
        int size = this.f11794h.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            int size2 = this.f11796j.size();
            int i5 = 0;
            while (i5 < size2) {
                int i6 = i5 + 1;
                if (this.f11794h.get(i3).equals(this.f11796j.get(i5))) {
                    String str = this.f11796j.get(i5);
                    int intValue = this.f11797k.get(i5).intValue();
                    int intValue2 = this.f11798l.get(i5).intValue();
                    int intValue3 = this.m.get(i5).intValue();
                    BeautyUnityEnumData beautyUnityEnumData = this.n.get(i5);
                    String str2 = this.v.get(i5);
                    i2 = size;
                    BeautyData beautyData = new BeautyData(str, intValue, intValue2, intValue3, beautyUnityEnumData, str2 == null || str2.length() == 0 ? "" : this.a + "makeup" + ((Object) File.separator) + this.v.get(i5), this.p.get(i5).intValue(), this.o.get(i5).intValue(), true, this.r.get(i5).get(), this.s.get(i5).booleanValue(), this.u.get(i5).booleanValue(), this.r.get(i5), this.w.get(i5), this.q.get(i5).intValue(), 0, null, new ObservableBoolean(this.t.get(i5).booleanValue()), null, null, 884736, null);
                    String str3 = this.b.get(this.f11796j.get(i5));
                    if (str3 != null) {
                        p0 = StringsKt__StringsKt.p0(str3, new String[]{";"}, false, 0, 6, null);
                        if (!(p0 == null || p0.isEmpty()) && p0.size() >= 4) {
                            beautyData.getCurrentValue().set(Integer.parseInt((String) p0.get(0)));
                            beautyData.isSelected().set(Boolean.parseBoolean((String) p0.get(1)));
                            beautyData.setColorIndex(Integer.parseInt((String) p0.get(2)));
                            beautyData.isExtended().set(Boolean.parseBoolean((String) p0.get(3)));
                            arrayList.add(beautyData);
                        }
                    }
                    arrayList.add(beautyData);
                } else {
                    i2 = size;
                }
                i5 = i6;
                size = i2;
            }
            i3 = i4;
        }
        if (!us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "has_been_used_this_version", false, null, 4, null)) {
            for (BeautyData beautyData2 : arrayList) {
                Set<String> keySet = q().keySet();
                kotlin.jvm.internal.s.g(keySet, "updateDefaultBeauty.keys");
                for (String str4 : keySet) {
                    if (kotlin.jvm.internal.s.c(beautyData2.getBeautyKey(), str4)) {
                        int i7 = beautyData2.getCurrentValue().get();
                        Integer num = q().get(str4);
                        if (num != null && i7 == num.intValue()) {
                            beautyData2.getCurrentValue().set(beautyData2.getDefaultValue());
                        }
                    }
                }
            }
            us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "has_been_used_this_version", true, null, 4, null);
        }
        return arrayList;
    }

    private final ArrayList<BeautyData> f(ArrayList<BeautyData> arrayList, int i2, int i3) {
        boolean z = true;
        if (i2 >= 0 && i2 < arrayList.size()) {
            if ((i3 < 0 || i3 >= arrayList.size()) ? false : false) {
                ArrayList<BeautyData> arrayList2 = new ArrayList<>();
                if (i2 <= i3) {
                    while (true) {
                        int i4 = i2 + 1;
                        arrayList2.add(arrayList.get(i2));
                        if (i2 == i3) {
                            break;
                        }
                        i2 = i4;
                    }
                }
                return arrayList2;
            }
        }
        return new ArrayList<>();
    }

    private final void s() {
        List<String> p0;
        List p02;
        String i0;
        String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "beauty_cache_data", null, null, 4, null);
        if (j2 == null) {
            StringBuilder sb = new StringBuilder();
            int size = this.f11796j.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = this.r.get(i2).get() + ';' + this.t.get(i2).booleanValue() + ";0;false";
                sb.append(this.f11796j.get(i2) + '=' + str + '|');
                this.b.put(this.f11796j.get(i2), str);
            }
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "str.toString()");
            i0 = StringsKt__StringsKt.i0(sb2, Effect.DIVIDER);
            us.pinguo.repository2020.utils.o.v(oVar, "beauty_cache_data", i0, null, 4, null);
            return;
        }
        p0 = StringsKt__StringsKt.p0(j2, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        for (String str2 : p0) {
            p02 = StringsKt__StringsKt.p0(str2, new String[]{"="}, false, 0, 6, null);
            if (!(p02.size() == 2)) {
                p02 = null;
            }
            if (p02 != null) {
                this.b.put(p02.get(0), p02.get(1));
            }
        }
    }

    private final void t(List<StyleMakeup> list) {
        List<String> p0;
        List p02;
        String i0;
        String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "stylemakeup_cache_data", null, null, 4, null);
        int i2 = 0;
        if (j2 == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            while (i2 < size) {
                int i3 = i2 + 1;
                StyleMakeup styleMakeup = list.get(i2);
                sb.append(((Object) styleMakeup.getPid()) + "=80;false;-1|");
                HashMap<String, String> hashMap = this.c;
                String pid = styleMakeup.getPid();
                kotlin.jvm.internal.s.e(pid);
                hashMap.put(pid, "80;false;-1");
                i2 = i3;
            }
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "str.toString()");
            i0 = StringsKt__StringsKt.i0(sb2, Effect.DIVIDER);
            us.pinguo.repository2020.utils.o.v(oVar, "stylemakeup_cache_data", i0, null, 4, null);
            return;
        }
        p0 = StringsKt__StringsKt.p0(j2, new String[]{Effect.DIVIDER}, false, 0, 6, null);
        for (String str : p0) {
            p02 = StringsKt__StringsKt.p0(str, new String[]{"="}, false, 0, 6, null);
            if (!(p02.size() == 2)) {
                p02 = null;
            }
            if (p02 != null) {
                this.c.put(p02.get(0), p02.get(1));
            }
        }
    }

    public final ArrayList<BeautyData> e() {
        return this.x;
    }

    public final ArrayList<BeautyData> g() {
        return this.y;
    }

    public final u<BeautyData> h() {
        return this.f11792f;
    }

    public final u<BeautyData> i() {
        return this.f11791e;
    }

    public final u<StyleMakeup> j() {
        return this.f11790d;
    }

    public final int k() {
        return this.f11793g;
    }

    public final ArrayList<BeautyData> l() {
        return this.A;
    }

    public final CopyOnWriteArrayList<String> m() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<MaterialDetailTable> all = us.pinguo.repository2020.database.a.a().z().getAll();
        if (!(all == null || all.isEmpty())) {
            for (MaterialDetailTable materialDetailTable : all) {
                copyOnWriteArrayList.add(materialDetailTable.getId());
            }
        }
        return copyOnWriteArrayList;
    }

    public final CopyOnWriteArrayList<String> n() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<MaterialDetailTable> all = us.pinguo.repository2020.database.a.a().z().getAll();
        List<MaterialItemTable> all2 = us.pinguo.repository2020.database.a.a().A().getAll();
        boolean z = false;
        if (!(all == null || all.isEmpty())) {
            if (!((all2 == null || all2.isEmpty()) ? true : true)) {
                for (MaterialDetailTable materialDetailTable : all) {
                    String id = materialDetailTable.getId();
                    for (MaterialItemTable materialItemTable : all2) {
                        if (kotlin.jvm.internal.s.c(id, materialItemTable.getPackageId()) && !copyOnWriteArrayList.contains(id)) {
                            copyOnWriteArrayList.add(id);
                        }
                    }
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public final ArrayList<BeautyData> o() {
        return this.B;
    }

    public final ArrayList<BeautyData> p() {
        return this.z;
    }

    public final HashMap<String, Integer> q() {
        return this.f11795i;
    }

    public final ArrayList<BeautyData> r() {
        return this.C;
    }

    public final void u(List<StyleMakeup> styleMakeups) {
        List p0;
        int h2;
        int h3;
        kotlin.jvm.internal.s.h(styleMakeups, "styleMakeups");
        t(styleMakeups);
        for (StyleMakeup styleMakeup : styleMakeups) {
            String str = this.c.get(styleMakeup.getPid());
            if (str != null) {
                p0 = StringsKt__StringsKt.p0(str, new String[]{";"}, false, 0, 6, null);
                if (!(p0 == null || p0.isEmpty()) && p0.size() >= 3) {
                    h2 = kotlin.text.s.h((String) p0.get(0));
                    if (h2 == null) {
                        h2 = 80;
                    }
                    styleMakeup.setMakeupCurrentValue(h2);
                    if (styleMakeup.isSelected() == null) {
                        styleMakeup.setSelected(new ObservableBoolean(Boolean.parseBoolean((String) p0.get(1))));
                    } else {
                        ObservableBoolean isSelected = styleMakeup.isSelected();
                        if (isSelected != null) {
                            isSelected.set(Boolean.parseBoolean((String) p0.get(1)));
                        }
                    }
                    h3 = kotlin.text.s.h((String) p0.get(2));
                    if (h3 == null) {
                        h3 = 60;
                    }
                    styleMakeup.setFilterCurrentValue(h3);
                }
            }
        }
    }

    public final void v(BeautyData beautyData) {
        if (beautyData == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(beautyData.getCurrentValue().get());
        sb.append(';');
        sb.append(beautyData.isSelected().get());
        sb.append(';');
        sb.append(beautyData.getColorIndex());
        sb.append(';');
        sb.append(beautyData.isExtended().get());
        this.b.put(beautyData.getBeautyKey(), sb.toString());
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.b.entrySet()) {
            sb2.append(entry.getKey() + '=' + entry.getValue() + '|');
        }
        StringsKt__StringsKt.h0(sb2, Effect.DIVIDER);
        us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "beauty_cache_data", sb2.toString(), null, 4, null);
    }

    public final void w(StyleMakeup styleMakeup) {
        ObservableBoolean isSelected;
        String i0;
        String pid;
        Integer filterCurrentValue;
        Integer makeupCurrentValue;
        StringBuilder sb = new StringBuilder();
        int i2 = 80;
        if (styleMakeup != null && (makeupCurrentValue = styleMakeup.getMakeupCurrentValue()) != null) {
            i2 = makeupCurrentValue.intValue();
        }
        sb.append(i2);
        sb.append(';');
        sb.append((styleMakeup == null || (isSelected = styleMakeup.isSelected()) == null || !isSelected.get()) ? false : true);
        sb.append(';');
        int i3 = 60;
        if (styleMakeup != null && (filterCurrentValue = styleMakeup.getFilterCurrentValue()) != null) {
            i3 = filterCurrentValue.intValue();
        }
        sb.append(i3);
        String sb2 = sb.toString();
        HashMap<String, String> hashMap = this.c;
        String str = "";
        if (styleMakeup != null && (pid = styleMakeup.getPid()) != null) {
            str = pid;
        }
        hashMap.put(str, sb2);
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            sb3.append(entry.getKey() + '=' + entry.getValue() + '|');
        }
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        String sb4 = sb3.toString();
        kotlin.jvm.internal.s.g(sb4, "cacheStr.toString()");
        i0 = StringsKt__StringsKt.i0(sb4, Effect.DIVIDER);
        us.pinguo.repository2020.utils.o.v(oVar, "stylemakeup_cache_data", i0, null, 4, null);
    }

    public final void x() {
        if (us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "is_selfdef_makeup_material_ready", false, null, 4, null)) {
            return;
        }
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDataRepository$prepareBuiltInSelfdefMakeupMaterial$1(this, null), 3, null);
    }

    public final void y(int i2) {
        this.f11793g = i2;
    }
}
