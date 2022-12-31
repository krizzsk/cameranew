package us.pinguo.edit2020.repository;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.bean.h;
import us.pinguo.repository2020.R;
/* compiled from: NewBeautyDataUtil.kt */
/* loaded from: classes4.dex */
public final class a {
    private static final List<String> a;

    static {
        List<String> j2;
        j2 = u.j("qudou", "jili", "liangyan", "baiya", "youguang", "heiyanquan", "yandai", "hongxuesi");
        a = j2;
    }

    public static final ArrayList<h> a() {
        ArrayList<h> f2;
        f2 = u.f(new h("one_key_beauty", R.drawable.icon_beauty_workflow_onekeybeauty, R.string.main_menu_beauty_onebtbeauty), new h("facial_feature", R.drawable.icon_beauty_workflow_facialfeatures, R.string.main_menu_beauty_facialfeatures), new h("hand_shape", R.drawable.icon_beauty_workflow_bodyshaping, R.string.main_menu_beauty_handshape), new h("skin_tone", R.drawable.icon_beauty_skinrefresh_meibai, R.string.fuse_refresh), new h("makeup", R.drawable.icon_beauty_workflow_makeup, R.string.main_menu_beauty_makeup), new h("facial_3D", R.drawable.ic_facial3d, R.string.main_menu_facial_three_dimensional), new h("tiliang", R.drawable.icon_beauty_skinrefresh_tiliang, R.string.str_tiliang_jiashen), new h("mopi", R.drawable.icon_beauty_skinrefresh_mopi, R.string.mopi), new h("qudou", R.drawable.icon_beauty_skinrefresh_qudou, R.string.qudou), new h("quzhouwen", R.drawable.icon_beauty_quzhou, R.string.quzhou), new h("heiyanquan", R.drawable.icon_beauty_skinrefresh_heiyanquan, R.string.heiyanquan), new h("yandai", R.drawable.icon_beauty_skinrefresh_yandai, R.string.quyandai), new h("hongxuesi", R.drawable.icon_beauty_skinrefresh_hongxuesi, R.string.hongxuesi), new h("youguang", R.drawable.icon_beauty_skinrefresh_quyouguang, R.string.youguang), new h("jili", R.drawable.icon_beauty_skinrefresh_jili, R.string.jili), new h("liangyan", R.drawable.icon_beauty_skinrefresh_liangyan, R.string.liangyan), new h("baiya", R.drawable.icon_beauty_skinrefresh_baiya, R.string.baiya));
        return f2;
    }

    public static final ArrayList<h> b() {
        ArrayList<h> f2;
        f2 = u.f(new h("one_key_beauty", R.drawable.icon_beauty_workflow_onekeybeauty, R.string.main_menu_beauty_onebtbeauty), new h("facial_feature", R.drawable.icon_beauty_workflow_facialfeatures, R.string.main_menu_beauty_facialfeatures), new h("hand_shape", R.drawable.icon_beauty_workflow_bodyshaping, R.string.main_menu_beauty_handshape), new h("skin_tone", R.drawable.icon_beauty_skinrefresh_meibai, R.string.fuse_refresh), new h("facial_3D", R.drawable.ic_facial3d, R.string.main_menu_facial_three_dimensional), new h("tiliang", R.drawable.icon_beauty_skinrefresh_tiliang, R.string.str_tiliang_jiashen), new h("mopi", R.drawable.icon_beauty_skinrefresh_mopi, R.string.mopi), new h("qudou", R.drawable.icon_beauty_skinrefresh_qudou, R.string.qudou), new h("quzhouwen", R.drawable.icon_beauty_quzhou, R.string.quzhou), new h("heiyanquan", R.drawable.icon_beauty_skinrefresh_heiyanquan, R.string.heiyanquan), new h("yandai", R.drawable.icon_beauty_skinrefresh_yandai, R.string.quyandai), new h("hongxuesi", R.drawable.icon_beauty_skinrefresh_hongxuesi, R.string.hongxuesi), new h("youguang", R.drawable.icon_beauty_skinrefresh_quyouguang, R.string.youguang), new h("jili", R.drawable.icon_beauty_skinrefresh_jili, R.string.jili), new h("liangyan", R.drawable.icon_beauty_skinrefresh_liangyan, R.string.liangyan), new h("baiya", R.drawable.icon_beauty_skinrefresh_baiya, R.string.baiya));
        return f2;
    }

    public static final ArrayList<h> c() {
        ArrayList<h> f2;
        f2 = u.f(new h("one_key_beauty", R.drawable.icon_beauty_workflow_onekeybeauty, R.string.main_menu_beauty_onebtbeauty), new h("facial_feature", R.drawable.icon_beauty_workflow_facialfeatures, R.string.main_menu_beauty_facialfeatures), new h("hand_shape", R.drawable.icon_beauty_workflow_bodyshaping, R.string.main_menu_beauty_handshape), new h("mopi", R.drawable.icon_beauty_skinrefresh_mopi, R.string.mopi), new h("skin_tone", R.drawable.icon_beauty_skinrefresh_meibai, R.string.fuse_refresh), new h("facial_3D", R.drawable.ic_facial3d, R.string.main_menu_facial_three_dimensional), new h("tiliang", R.drawable.icon_beauty_skinrefresh_tiliang, R.string.str_tiliang_jiashen), new h("qudou", R.drawable.icon_beauty_skinrefresh_qudou, R.string.qudou), new h("quzhouwen", R.drawable.icon_beauty_quzhou, R.string.quzhou), new h("heiyanquan", R.drawable.icon_beauty_skinrefresh_heiyanquan, R.string.heiyanquan), new h("yandai", R.drawable.icon_beauty_skinrefresh_yandai, R.string.quyandai), new h("hongxuesi", R.drawable.icon_beauty_skinrefresh_hongxuesi, R.string.hongxuesi), new h("youguang", R.drawable.icon_beauty_skinrefresh_quyouguang, R.string.youguang), new h("jili", R.drawable.icon_beauty_skinrefresh_jili, R.string.jili), new h("liangyan", R.drawable.icon_beauty_skinrefresh_liangyan, R.string.liangyan), new h("baiya", R.drawable.icon_beauty_skinrefresh_baiya, R.string.baiya));
        return f2;
    }

    public static final List<String> d() {
        return a;
    }

    public static final String e(String str) {
        s.h(str, "<this>");
        switch (str.hashCode()) {
            case -1655346876:
                if (str.equals("facial_3D")) {
                    return "edit_panel_facial_contour";
                }
                break;
            case -1314729496:
                if (str.equals("tiliang")) {
                    return "edit_panel_tiliangjiashen";
                }
                break;
            case -1225514539:
                if (str.equals("one_key_beauty")) {
                    return "edit_panel_instant_beauty";
                }
                break;
            case -1208883106:
                if (str.equals("hongxuesi")) {
                    return "edit_panel_quhongxuesi";
                }
                break;
            case -1081519863:
                if (str.equals("makeup")) {
                    return "edit_panel_makeup";
                }
                break;
            case -737882266:
                if (str.equals("yandai")) {
                    return "edit_panel_quyandai";
                }
                break;
            case -691337875:
                if (str.equals("youguang")) {
                    return "edit_panel_quyouguang";
                }
                break;
            case -664214525:
                if (str.equals("facial_feature")) {
                    return "edit_panel_facial_remodel";
                }
                break;
            case -643700056:
                if (str.equals("quzhouwen")) {
                    return "edit_panel_quzhou";
                }
                break;
            case 3262204:
                if (str.equals("jili")) {
                    return "edit_panel_jili";
                }
                break;
            case 3357467:
                if (str.equals("mopi")) {
                    return "edit_panel_mopi";
                }
                break;
            case 80508971:
                if (str.equals("heiyanquan")) {
                    return "edit_panel_quheiyanquan";
                }
                break;
            case 93499538:
                if (str.equals("baiya")) {
                    return "edit_panel_baiya";
                }
                break;
            case 107943078:
                if (str.equals("qudou")) {
                    return "edit_panel_qudou";
                }
                break;
            case 825363977:
                if (str.equals("liangyan")) {
                    return "edit_panel_liangyan";
                }
                break;
            case 1628840913:
                if (str.equals("hand_shape")) {
                    return "edit_panel_face_lift";
                }
                break;
            case 2037392116:
                if (str.equals("skin_tone")) {
                    return "edit_panel_fuse";
                }
                break;
        }
        return "";
    }
}
