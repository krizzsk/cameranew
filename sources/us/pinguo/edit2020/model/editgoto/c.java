package us.pinguo.edit2020.model.editgoto;

import android.net.Uri;
/* compiled from: EditGotoParser.kt */
/* loaded from: classes4.dex */
public final class c {
    public final b a(Uri uri) {
        String queryParameter = uri == null ? null : uri.getQueryParameter("position");
        if (queryParameter != null) {
            switch (queryParameter.hashCode()) {
                case -2139146388:
                    if (queryParameter.equals("skinAdjust")) {
                        return new b(EditGotoType.SKIN_REFRESH, null, null, null, 14, null);
                    }
                    return null;
                case -2074084917:
                    if (queryParameter.equals("long_leg")) {
                        return new b(EditGotoType.LONG_LEG, uri.getQueryParameter("typeId"), null, null, 12, null);
                    }
                    return null;
                case -1871957908:
                    if (queryParameter.equals("static_sticker")) {
                        return new b(EditGotoType.STATIC_STICKER, uri.getQueryParameter("typeId"), uri.getQueryParameter("typeCategoryId"), uri.getQueryParameter("type"));
                    }
                    return null;
                case -1806214155:
                    if (queryParameter.equals("oneKeyBeauty")) {
                        return new b(EditGotoType.ONE_KEY_BEAUTY, null, null, null, 14, null);
                    }
                    return null;
                case -1600401472:
                    if (queryParameter.equals("selective_color")) {
                        return new b(EditGotoType.SELECTIVE_COLOR, null, null, null, 14, null);
                    }
                    return null;
                case -1422313585:
                    if (queryParameter.equals("adjust")) {
                        return new b(EditGotoType.ADJUST, null, null, null, 14, null);
                    }
                    return null;
                case -1274492040:
                    if (queryParameter.equals("filter")) {
                        return new b(EditGotoType.FILTER, uri.getQueryParameter("typeId"), uri.getQueryParameter("typeCategoryId"), uri.getQueryParameter("type"));
                    }
                    return null;
                case -1081519863:
                    if (queryParameter.equals("makeup")) {
                        return new b(EditGotoType.MAKEUP, uri.getQueryParameter("typeId"), null, null, 12, null);
                    }
                    return null;
                case -1068356470:
                    if (queryParameter.equals("mosaic")) {
                        return new b(EditGotoType.MOSAIC, null, null, null, 14, null);
                    }
                    return null;
                case -753287370:
                    if (queryParameter.equals("skinAdjustManualTiliang")) {
                        return new b(EditGotoType.SKIN_REFRESH_MANUAL_TILIANG, null, null, null, 14, null);
                    }
                    return null;
                case 91412680:
                    if (queryParameter.equals("graffiti")) {
                        return new b(EditGotoType.GRAFFITI, null, null, null, 14, null);
                    }
                    return null;
                case 223298353:
                    if (queryParameter.equals("vacuity")) {
                        return new b(EditGotoType.VACUITY, null, null, null, 14, null);
                    }
                    return null;
                case 356886458:
                    if (queryParameter.equals("image_restoration")) {
                        return new b(EditGotoType.IMAGE_RESTORARION, null, null, null, 14, null);
                    }
                    return null;
                case 500789693:
                    if (queryParameter.equals("facial3D")) {
                        return new b(EditGotoType.FACIAL3D, null, null, null, 14, null);
                    }
                    return null;
                case 906676818:
                    if (queryParameter.equals("skinAdjustManual")) {
                        return new b(EditGotoType.SKIN_REFRESH_MANUAL, null, null, null, 14, null);
                    }
                    return null;
                case 908015853:
                    if (queryParameter.equals("skinAdjustFuse")) {
                        return new b(EditGotoType.SKIN_REFRESH_AUTO_FUSE, null, null, null, 14, null);
                    }
                    return null;
                case 957978110:
                    if (queryParameter.equals("skinRefreshAutoQuban")) {
                        return new b(EditGotoType.SKIN_REFRESH_AUTO_QUBAN, null, null, null, 14, null);
                    }
                    return null;
                case 965377972:
                    if (queryParameter.equals("skinRefreshAutoYunfu")) {
                        return new b(EditGotoType.SKIN_REFRESH_AUTO_YUNFU, null, null, null, 14, null);
                    }
                    return null;
                case 1084009526:
                    if (queryParameter.equals("erasingPen")) {
                        return new b(EditGotoType.ERASING_PEN, null, null, null, 14, null);
                    }
                    return null;
                case 1142571843:
                    if (queryParameter.equals("skinAdjustManualXijie")) {
                        return new b(EditGotoType.SKIN_REFRESH_MANUAL_XIJIE, null, null, null, 14, null);
                    }
                    return null;
                case 1144914061:
                    if (queryParameter.equals("skinAdjustManualMopi")) {
                        return new b(EditGotoType.SKIN_REFRESH_MANUAL_MOPI, null, null, null, 14, null);
                    }
                    return null;
                case 1241570079:
                    if (queryParameter.equals("bodyShape")) {
                        return new b(EditGotoType.BODY_SHAPE, null, null, null, 14, null);
                    }
                    return null;
                case 1312596184:
                    if (queryParameter.equals("background_blur")) {
                        return new b(EditGotoType.BACKGROUND_BLUR, uri.getQueryParameter("typeId"), null, null, 12, null);
                    }
                    return null;
                case 1601683977:
                    if (queryParameter.equals("editHome")) {
                        return new b(EditGotoType.HOME, null, null, null, 14, null);
                    }
                    return null;
                case 2025720489:
                    if (queryParameter.equals("facialFeatures")) {
                        return new b(EditGotoType.FACIAL_FEATURES, null, null, null, 14, null);
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }
}
