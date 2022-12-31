package com.google.zxing.pdf417.encoder;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.monitor.BuildConfig;
import com.growingio.android.sdk.monitor.connection.HttpConnection;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: PDF417ErrorCorrection.java */
/* loaded from: classes2.dex */
final class e {
    private static final int[][] a = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, VideoEdit2Activity.MIN_SCALED_SIZE, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 6, 93, 862, 771, 453, 106, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 287, 107, TypedValues.PositionType.TYPE_SIZE_PERCENT, 733, 877, 381, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 723, 476, 462, 172, 430, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 158, 651, 201, 488, TypedValues.PositionType.TYPE_DRAWPATH, 648, 733, 717, 83, DeeplinkCallback.ERROR_LINK_NOT_EXIST, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, 928, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 583, 620, 246, 148, 447, 631, 292, 908, 490, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, BaseBlurEffect.ROTATION_270, 447, 90, TypedValues.PositionType.TYPE_PERCENT_Y, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, TypedValues.Custom.TYPE_DIMENSION, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 540, 913, IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, TypedValues.Custom.TYPE_REFERENCE, 90, 2, 290, 743, 199, 655, TypedValues.Custom.TYPE_STRING, 329, 49, IMediaPlayer.MEDIA_INFO_METADATA_UPDATE, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 374, 601, 192, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 142, 673, 687, 234, 722, 384, 177, 752, TypedValues.MotionType.TYPE_PATHMOTION_ARC, VideoEdit2Activity.MIN_SCALED_SIZE, 455, 193, 689, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, TypedValues.CycleType.TYPE_WAVE_SHAPE, 726, 528, TypedValues.PositionType.TYPE_PERCENT_WIDTH, 118, 49, 795, 32, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 441, BaseBlurEffect.ROTATION_180, 791, 893, 754, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 829, 189, 20, 167, 29, 872, 449, 83, TypedValues.CycleType.TYPE_VISIBILITY, 41, 656, TypedValues.PositionType.TYPE_SIZE_PERCENT, 579, 481, 173, DeeplinkCallback.ERROR_LINK_NOT_EXIST, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, VideoEdit2Activity.MIN_SCALED_SIZE, 268, 794, 534, 539, 781, DeeplinkCallback.ERROR_TIMEOUT, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, BaseBlurEffect.ROTATION_180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, HttpConnection.HTTP_TOO_MANY_REQUESTS, 531, 207, 676, 710, 89, 168, 304, TypedValues.CycleType.TYPE_VISIBILITY, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 173, 35, 463, 651, 51, 699, 591, 452, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, 911, 283, 711, 472, TypedValues.CycleType.TYPE_EASING, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, DeeplinkCallback.ERROR_TIMEOUT, 842, 383, 721, 521, 560, 644, 714, 559, 62, BuildConfig.VERSION_CODE, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, TypedValues.MotionType.TYPE_DRAW_PATH, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, TypedValues.CycleType.TYPE_WAVE_OFFSET, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, TypedValues.Custom.TYPE_DIMENSION, 789, TypedValues.CycleType.TYPE_EASING, 305, 441, 207, IjkMediaCodecInfo.RANK_SECURE, 892, 827, 141, 537, 381, 662, InputDeviceCompat.SOURCE_DPAD, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, TypedValues.CycleType.TYPE_WAVE_PHASE, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, TypedValues.Custom.TYPE_DIMENSION, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 907, 817, 187, 62, 16, TypedValues.CycleType.TYPE_WAVE_PHASE, 535, 336, 286, 437, 375, 273, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, TypedValues.CycleType.TYPE_WAVE_OFFSET, 242, 749, 321, 54, 669, TypedValues.AttributesType.TYPE_PATH_ROTATE, 342, 299, 534, 105, 667, 488, VideoEdit2Activity.MIN_SCALED_SIZE, 672, 576, 540, TypedValues.AttributesType.TYPE_PATH_ROTATE, 486, 721, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 31, 121, 303, 263}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(CharSequence charSequence, int i2) {
        int b = b(i2);
        char[] cArr = new char[b];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = b - 1;
            int charAt = (charSequence.charAt(i3) + cArr[i4]) % 929;
            while (i4 > 0) {
                cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((a[i2][i4] * charAt) % 929))) % 929);
                i4--;
            }
            cArr[0] = (char) ((929 - ((charAt * a[i2][0]) % 929)) % 929);
        }
        StringBuilder sb = new StringBuilder(b);
        for (int i5 = b - 1; i5 >= 0; i5--) {
            if (cArr[i5] != 0) {
                cArr[i5] = (char) (929 - cArr[i5]);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2) {
        if (i2 < 0 || i2 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i2 + 1);
    }
}
