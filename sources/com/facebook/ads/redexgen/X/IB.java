package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.connection.HttpConnection;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: assets/audience_network.dex */
public final class IB {
    public static byte[] A00;
    public static String[] A01 = {"tfV41ato8nsARoo", "RgCUIJnwcO1OfAmeWTYuRnXZnI57XYFD", "DJciDkYTn", "uMFTc", "LlMXsB6l4iKS5bQTPghSZUcK3UrlpU", "hCuliPavAGhKBs7ieDCx41JmqO1LYr4d", "tMCGhDkY5Hy7JFEW2GCFcmc3Z4A29Z", "PNBze"};
    public static final Map<String, Integer> A02;
    public static final Pattern A03;
    public static final Pattern A04;
    public static final Pattern A05;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 36);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{101, 0, 20, 9, 4, -2, -54, -54, -2, 6, 29, -45, -50, -43, 31, -53, -50, -54, -2, 6, 29, -45, -50, -43, 31, -53, -50, -54, -2, 6, 29, -45, -50, -43, 31, -53, -2, -53, -58, -94, -74, -85, -90, -91, -96, 108, 108, -96, -88, -65, 117, 112, 119, -63, 109, 112, 108, -96, -88, -65, 117, 112, 119, -63, 109, 112, 108, -96, -88, -65, 117, 112, 119, -63, 109, 112, 108, -96, -88, 110, -96, 114, -125, -96, -88, 110, -125, 109, -96, 109, 104, -80, -60, -71, -76, -77, -82, 122, 122, -82, -74, -51, -125, 126, -123, -49, 123, 126, 122, -82, -74, -51, -125, 126, -123, -49, 123, 126, 122, -82, -74, -51, -125, 126, -123, -49, 123, 126, 122, -82, -74, -51, -125, 126, -123, -49, 123, -82, 123, 118, -122, -111, -114, -120, -118, -121, -111, -102, -118, -3, 10, 16, 5, Draft_75.CR, 17, 1, 19, 4, 5, 16, 1, -94, -78, -74, -94, -6, 10, 14, -6, 6, -6, 11, 2, 7, -2, -106, -81, -86, -89, -102, -66, -63, -59, -61, -63, -104, -97, -87, -89, -85, -101, -58, -48, -59, -57, -49, -80, -70, -81, -68, -79, -74, -77, -78, -81, -70, -69, -67, -68, -78, -61, -51, -42, -58, -86, -76, -67, -83, -66, -79, -73, -76, -83, -68, 4, 20, 17, 25, 16, -13, 6, 3, -3, 10, 8, 0, 0, -11, -7, -9, -6, -5, 10, -8, 2, 11, -5, -100, -95, -102, -85, -83, -85, -98, -82, -84, -98, -69, -64, -57, -69, -57, -60, -71, -52, -67, -73, -61, -58, -75, -64, -98, -86, -83, -87, -95, -89, -86, -78, -96, -83, -99, -89, -80, -96, 5, 17, 20, 16, 21, 11, 14, Draft_75.CR, -38, -23, -32, -28, -22, -26, -27, -7, 15, -9, 4, -74, -77, -60, -67, -76, -66, -57, -73, -95, -98, -81, -88, -96, -74, -98, -85, -87, -90, -73, -80, -84, -76, -79, -87, -86, -77, -73, -76, -87, -30, -33, -16, -23, -27, -16, -33, -9, -93, -96, -79, -86, -90, -79, -92, -92, -83, -24, -27, -10, -17, -21, -10, -23, -3, -50, -53, -36, -43, -43, -46, -53, -43, -45, -110, -113, -96, -103, -101, -113, -107, -109, -100, -94, -113, -85, -88, -71, -78, -74, -77, -80, -67, -84, -82, -71, -84, -84, -75, 5, 2, 19, 12, 16, 19, 2, 15, 8, 6, -105, -108, -91, -98, -94, -91, -106, -101, -100, -105, -81, -84, -67, -74, -67, -80, -81, -89, -92, -75, -82, -74, -92, -81, -80, -78, -79, -90, -93, -76, -83, -75, -89, -93, -87, -76, -89, -89, -80, -54, -57, -40, -47, -39, -46, -57, -38, -53, -56, -46, -37, -53, -115, -118, -101, -108, -100, -107, -118, -99, -114, -112, -101, -118, -94, -87, -90, -73, -80, -72, -79, -90, -71, -86, -84, -73, -86, -66, -96, -99, -82, -89, -80, -79, -82, -83, -79, -85, -91, -81, -95, -88, -91, -74, -81, -70, -83, -77, -80, -87, -72, -41, -40, -40, -29, -29, -36, -31, -34, -21, -20, -20, -9, -6, -14, 0, -23, -13, -4, -20, -41, -36, -32, -38, -27, -44, -20, -113, -108, -104, -110, -99, -112, -92, -48, -37, -48, -45, -47, -34, -50, -40, -31, -47, -110, -107, -98, -111, -114, -98, -107, -113, -105, -96, -90, -87, -84, -101, -90, -79, -94, -93, -82, -97, -113, -104, -101, -114, -100, -99, -112, -101, -114, -114, -105, -99, -84, -102, -97, -86, -96, -104, -45, -51, -43, -38, -33, -50, -37, -34, -37, -73, -72, -65, -61, -60, -57, -72, -71, -60, -75, -20, -12, -15, -23, -72, -64, -67, -75, -74, -65, -61, -64, -75, -49, -38, -55, -31, -5, 6, -7, -7, 2, -94, -83, -96, -96, -87, -76, -96, -89, -89, -86, -78, -105, -94, -107, -87, -18, -11, -12, -21, -1, -22, -21, -3, -106, -99, -94, -98, -105, -100, -103, -24, -19, -29, -24, -32, -19, -15, -28, -29, -73, -68, -78, -73, -75, -67, -56, -43, -50, -47, -40, -102, -105, -112, -102, -104, -35, -46, -25, -42, -33, -43, -42, -29, -58, -69, -48, -65, -56, -66, -65, -52, -68, -58, -49, -51, -62, -51, -62, -40, -49, -56, -45, -58, -58, -49, -60, -67, -59, -57, -58, -69, -64, -63, -66, -66, -57, -58, -24, -27, -29, -28, -16, -34, -24, -15, -31, -22, -25, -27, -26, -14, -31, -19, -16, -33, -22, -53, -56, -58, -57, -45, -62, -40, -64, -51, -39, -42, -44, -43, -31, -44, -36, -39, -47, -46, -37, -33, -36, -47, -26, -46, -39, -39, -36, -28, -50, -53, -55, -54, -42, -55, -44, -61, -37, -34, -37, -39, -38, -26, -39, -28, -41, -41, -32, -71, -74, -76, -75, -63, -76, -65, -78, -58, -106, -109, -111, -110, -98, -102, -109, -104, -107, -51, -54, -56, -55, -43, -44, -62, -51, -50, -48, -49, -2, -5, -7, -6, 6, 5, -9, -13, -7, 4, -9, -9, 0, -14, -17, -19, -18, -6, -7, -15, -1, -24, -14, -5, -21, -5, -8, -10, -9, 3, 2, -5, -16, 3, -12, -10, 1, -16, 8, -50, -53, -55, -54, -42, -43, -50, -61, -42, -57, -55, -44, -57, -37, -95, -98, -100, -99, -87, -88, -87, -102, -102, -95, -105, -95, -86, -102, 5, 2, 0, 1, Draft_75.CR, 18, -2, 5, 5, 8, 16, -65, -68, -64, -72, -81, -84, -80, -88, -86, -75, -88, -88, -79, -51, -54, -49, -58, -49, -31, -43, -37, -39, -30, -24, -43, 4, -8, 9, 6, 6, 5, -27, -35, -36, -31, -19, -27, -39, -23, -19, -39, -27, -39, -22, -31, -26, -35, -46, -54, -55, -50, -38, -46, -57, -47, -38, -54, -103, -111, -112, -107, -95, -103, -101, -98, -113, -108, -107, -112, -108, -116, -117, -112, -100, -108, -105, -100, -103, -105, -109, -116, -37, -45, -46, -41, -29, -37, -31, -45, -49, -43, -32, -45, -45, -36, 4, -4, -5, 0, 12, 4, 10, 3, -8, 
        11, -4, -7, 3, 12, -4, -7, -15, -16, -11, 1, -7, -1, -4, -2, -11, -6, -13, -13, -2, -15, -15, -6, -93, -101, -102, -97, -85, -93, -86, -85, -88, -89, -85, -91, -97, -87, -101, -10, -18, -19, -14, -2, -10, -1, -14, -8, -11, -18, -3, -5, -18, -19, 0, -4, -9, 1, -4, -6, -5, 7, -11, -1, 8, -8, -90, -94, -89, -83, -100, -85, -98, -102, -90, -55, -59, -49, -48, -43, -50, -53, -49, -63, -7, -5, -17, -17, -19, -1, -11, -6, -6, -19, 2, -19, -10, -5, 3, -12, -11, 0, -15, -82, -95, -74, -71, -69, -72, -80, -72, -83, -81, -79, -30, -33, -36, -23, -40, -17, -20, -23, -10, -27, -28, -14, -31, -30, -81, -78, -95, -82, -89, -91, -14, -11, -28, -15, -22, -24, -11, -24, -25, -38, -35, -50, -45, -44, -49, -49, -64, -53, -60, -58, -50, -53, -61, -60, -51, -47, -50, -61, -7, -22, -11, -18, -16, -5, -18, -18, -9, -19, -34, -23, -30, -15, -14, -17, -18, -14, -20, -26, -16, -30, -84, -99, -88, -95, -78, -91, -85, -88, -95, -80, -82, -95, -96, 7, -8, 7, -8, 16, -8, 14, -1, 0, 7, -10, -21, -25, -23, -18, -10, -5, -20, -20, -16, -27, -14, -11, -55, -62, -57, -60, -33, -37, -28, -36, 11, 10, 18, -1, 0, Draft_75.CR, -3, 7, 16, 0, -86, -81, -84, -86, -90, -97, -72, -85, -88, -85, -87, -87, -89, -74, -69, -72, -74, -78, -85, -16, -29, -30, -65, -76, -81, -82, -93, -98, -99, 6, 3, 7, Draft_75.CR, -10, 6, 3, 11, 2, -92, -95, -85, -109, -98, -108, -98, -89, -105, -15, -33, -30, -30, -22, -29, -32, -16, -19, -11, -20, -22, -40, -29, -28, -26, -27, -78, -96, -83, -93, -72, -95, -79, -82, -74, -83, -79, -93, -97, -91, -80, -93, -93, -84, 16, 2, -2, 16, 5, 2, 9, 9, -96, -106, -110, -101, -101, -114, -103, -113, -110, -100, -117, -104, -66, -74, -60, -83, -73, -64, -80, -4, -11, -22, -3, -18, -21, -11, -2, -18, 3, -4, -15, 4, -11, -9, 2, -15, 9, -55, -62, -73, -54, -69, -67, -56, -69, -49, -103, -108, -107, -99, -62, -65, -63, -72, -67, -74, -74, -63, -76, -76, -67, -14, -13, -28, -28, -21, -31, -21, -12, -28, 6, -13, 0, -96, -111, -115, -104, -23, -35, -34, -24, -23, -31, -38, -48, -53, -55, -67, -48, -53, -17, -19, -36, -23, -18, -21, -36, -19, -32, -23, -17, -78, -77, -80, -81, -77, -83, -89, -79, -93, -40, -53, -47, -50, -57, -42, -63, -78, -81, -85, -66, -61, -76, -75, -64, -79, 2, -13, -12, -1, -16, -2, -8, -6, -10, -16, 22, 2, 9, 9, 12, 20, -20, -40, -33, -33, -30, -22, -38, -27, -40, -40, -31};
    }

    static {
        A06();
        A05 = Pattern.compile(A05(1, 38, 126));
        A04 = Pattern.compile(A05(91, 49, 46));
        A03 = Pattern.compile(A05(39, 52, 32));
        A02 = new HashMap();
        A02.put(A05(InspirePublishFragment.MAX_DESC_COUNT, 9, 1), -984833);
        A02.put(A05(149, 12, 120), -332841);
        A02.put(A05(161, 4, 29), -16711681);
        A02.put(A05(165, 10, 117), -8388652);
        A02.put(A05(175, 5, 17), -983041);
        A02.put(A05(BaseBlurEffect.ROTATION_180, 5, 56), -657956);
        A02.put(A05(185, 6, 18), -6972);
        A02.put(A05(191, 5, 64), Integer.valueOf((int) ViewCompat.MEASURED_STATE_MASK));
        A02.put(A05(196, 14, 42), -5171);
        A02.put(A05(210, 4, 61), -16776961);
        A02.put(A05(214, 10, 36), -7722014);
        A02.put(A05(224, 5, 126), -5952982);
        A02.put(A05(229, 9, 109), -2180985);
        A02.put(A05(238, 9, 114), -10510688);
        A02.put(A05(247, 10, 21), -8388864);
        A02.put(A05(257, 9, 52), -2987746);
        A02.put(A05(266, 5, 48), -32944);
        A02.put(A05(271, 14, 23), -10185235);
        A02.put(A05(285, 8, 126), -1828);
        A02.put(A05(293, 7, 83), -2354116);
        A02.put(A05(IjkMediaCodecInfo.RANK_SECURE, 4, 114), -16711681);
        A02.put(A05(304, 8, 46), -16777077);
        A02.put(A05(312, 8, 25), -16741493);
        A02.put(A05(320, 13, 33), -4684277);
        A02.put(A05(333, 8, 90), -5658199);
        A02.put(A05(341, 9, 27), -16751616);
        A02.put(A05(350, 8, 96), -5658199);
        A02.put(A05(358, 9, 70), -4343957);
        A02.put(A05(367, 11, 10), -7667573);
        A02.put(A05(378, 14, 35), -11179217);
        A02.put(A05(392, 10, 125), -29696);
        A02.put(A05(TypedValues.CycleType.TYPE_VISIBILITY, 10, 15), -6737204);
        A02.put(A05(DeeplinkCallback.ERROR_URL_FORMAT_ERROR, 7, 39), -7667712);
        A02.put(A05(419, 10, 31), -1468806);
        A02.put(A05(HttpConnection.HTTP_TOO_MANY_REQUESTS, 12, 30), -7357297);
        A02.put(A05(441, 13, 66), -12042869);
        A02.put(A05(454, 13, 5), -13676721);
        A02.put(A05(467, 13, 33), -13676721);
        A02.put(A05(480, 13, 24), -16724271);
        A02.put(A05(493, 10, 32), -7077677);
        A02.put(A05(TypedValues.PositionType.TYPE_PERCENT_WIDTH, 8, 79), -60269);
        A02.put(A05(FrameMetricsAggregator.EVERY_DURATION, 11, 99), -16728065);
        A02.put(A05(522, 7, 79), -9868951);
        A02.put(A05(529, 7, 7), -9868951);
        A02.put(A05(536, 10, 72), -14774017);
        A02.put(A05(546, 9, 8), -5103070);
        A02.put(A05(555, 11, 22), -1296);
        A02.put(A05(566, 11, 5), -14513374);
        A02.put(A05(577, 7, 19), -65281);
        A02.put(A05(584, 9, 72), -2302756);
        A02.put(A05(593, 10, 44), -460545);
        A02.put(A05(TypedValues.MotionType.TYPE_EASING, 4, 97), -10496);
        A02.put(A05(TypedValues.MotionType.TYPE_PATHMOTION_ARC, 9, 45), -2448096);
        A02.put(A05(616, 4, 68), -8355712);
        A02.put(A05(620, 5, 112), -16744448);
        A02.put(A05(625, 11, 23), -5374161);
        A02.put(A05(636, 4, 12), -8355712);
        A02.put(A05(VideoEdit2Activity.MIN_SCALED_SIZE, 8, 98), -983056);
        A02.put(A05(648, 7, 10), -38476);
        A02.put(A05(655, 9, 91), -3318692);
        A02.put(A05(664, 6, 42), -11861886);
        A02.put(A05(670, 5, 59), -16);
        A02.put(A05(675, 5, 11), -989556);
        A02.put(A05(680, 8, 77), -1644806);
        A02.put(A05(688, 13, 54), -3851);
        A02.put(A05(701, 9, 61), -8586240);
        A02.put(A05(710, 12, 52), -1331);
        A02.put(A05(722, 9, 88), -5383962);
        A02.put(A05(731, 10, 90), -1015680);
        A02.put(A05(741, 9, 59), -2031617);
        A02.put(A05(750, 20, 73), -329006);
        A02.put(A05(770, 9, 62), -2894893);
        A02.put(A05(779, 10, 78), -7278960);
        A02.put(A05(789, 9, 41), -2894893);
        A02.put(A05(798, 9, 6), -18751);
        A02.put(A05(807, 11, 61), -24454);
        A02.put(A05(818, 13, 110), -14634326);
        A02.put(A05(831, 12, 98), -7876870);
        A02.put(A05(843, 14, 107), -8943463);
        A02.put(A05(857, 14, 62), -8943463);
        A02.put(A05(871, 14, 17), -5192482);
        A02.put(A05(885, 11, 117), -32);
        A02.put(A05(896, 4, 47), -16711936);
        A02.put(A05(900, 9, 31), -13447886);
        A02.put(A05(909, 5, 61), -331546);
        A02.put(A05(914, 7, 80), -65281);
        A02.put(A05(921, 6, 115), -8388608);
        A02.put(A05(927, 16, 84), -10039894);
        A02.put(A05(943, 10, 65), -16777011);
        A02.put(A05(953, 12, 8), -4565549);
        A02.put(A05(965, 12, 3), -7114533);
        A02.put(A05(977, 14, 74), -12799119);
        A02.put(A05(991, 15, 115), -8689426);
        A02.put(A05(1006, 17, 104), -16713062);
        A02.put(A05(1023, 15, 18), -12004916);
        A02.put(A05(1038, 15, 101), -3730043);
        A02.put(A05(1053, 12, 111), -15132304);
        A02.put(A05(1065, 9, 21), -655366);
        A02.put(A05(1074, 9, 56), -6943);
        A02.put(A05(1083, 8, 104), -6987);
        A02.put(A05(1091, 11, 104), -8531);
        A02.put(A05(1102, 4, 28), -16777088);
        A02.put(A05(1106, 7, 40), -133658);
        A02.put(A05(1113, 5, 79), -8355840);
        A02.put(A05(1118, 9, 92), -9728477);
        A02.put(A05(1127, 6, 28), -23296);
        A02.put(A05(1133, 9, 95), -47872);
        A02.put(A05(1142, 6, 71), -2461482);
        A02.put(A05(1148, 13, 59), -1120086);
        A02.put(A05(1161, 9, 101), -6751336);
        A02.put(A05(1170, 13, 89), -5247250);
        A02.put(A05(1183, 13, 24), -2396013);
        A02.put(A05(1196, 10, 115), -4139);
        A02.put(A05(1206, 9, 98), -9543);
        A02.put(A05(1215, 4, 92), -3308225);
        A02.put(A05(1219, 4, 53), -16181);
        A02.put(A05(1223, 4, 75), -2252579);
        A02.put(A05(1227, 10, 119), -5185306);
        A02.put(A05(1237, 6, 22), -8388480);
        A02.put(A05(1243, 13, 34), -10079335);
        A02.put(A05(1256, 3, 90), Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        A02.put(A05(1266, 9, 112), -4419697);
        A02.put(A05(1275, 9, 14), -12490271);
        A02.put(A05(1284, 11, 90), -7650029);
        A02.put(A05(1295, 6, 83), -360334);
        A02.put(A05(1301, 10, 27), -744352);
        A02.put(A05(1311, 8, 26), -13726889);
        A02.put(A05(1319, 8, 121), -2578);
        A02.put(A05(1327, 6, 9), -6270419);
        A02.put(A05(1333, 6, 2), -4144960);
        A02.put(A05(1339, 7, 39), -7876885);
        A02.put(A05(1346, 9, 101), -9807155);
        A02.put(A05(1355, 9, 108), -9404272);
        A02.put(A05(1364, 9, 50), -9404272);
        A02.put(A05(1373, 4, 2), -1286);
        A02.put(A05(1377, 11, 43), -16711809);
        A02.put(A05(1388, 9, 91), -12156236);
        A02.put(A05(1397, 3, 110), -2968436);
        A02.put(A05(1400, 4, 8), -16744320);
        A02.put(A05(1404, 7, 81), -2572328);
        A02.put(A05(1411, 6, 56), -40121);
        A02.put(A05(1417, 11, 87), 0);
        A02.put(A05(1428, 9, 26), -12525360);
        A02.put(A05(1437, 6, 62), -1146130);
        A02.put(A05(1443, 5, 38), -663885);
        A02.put(A05(1448, 5, 40), -1);
        A02.put(A05(1453, 10, 103), -657931);
        A02.put(A05(1463, 6, 121), Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        A02.put(A05(1469, 11, 79), -6632142);
    }

    public static int A00(int i2, int i3, int i4) {
        return A01(255, i2, i3, i4);
    }

    public static int A01(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    public static int A02(String str) {
        return A04(str, true);
    }

    public static int A03(String str) {
        return A04(str, false);
    }

    public static int A04(String str, boolean z) {
        int parseInt;
        I6.A03(!TextUtils.isEmpty(str));
        String replace = str.replace(A05(0, 1, 33), A05(0, 0, 106));
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith(A05(1262, 4, 24))) {
            Matcher matcher = (z ? A03 : A04).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    String group = matcher.group(4);
                    if (A01[3].length() == 4) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[6] = "ezp4QHszMRmr708yEGNtrd3AWYcmA7";
                    strArr[4] = "h8MdBMnsaR6MUBpG9WVcXHCqZtusub";
                    parseInt = (int) (Float.parseFloat(group) * 255.0f);
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                int parseInt2 = Integer.parseInt(matcher.group(1), 10);
                int parseInt3 = Integer.parseInt(matcher.group(2), 10);
                String group2 = matcher.group(3);
                if (A01[3].length() != 4) {
                    A01[3] = "KCEZn76ApEjFeS";
                    return A01(parseInt, parseInt2, parseInt3, Integer.parseInt(group2, 10));
                }
                throw new RuntimeException();
            }
        } else if (replace.startsWith(A05(1259, 3, 41))) {
            Matcher matcher2 = A05.matcher(replace);
            if (matcher2.matches()) {
                return A00(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = A02.get(C0923Il.A0M(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
