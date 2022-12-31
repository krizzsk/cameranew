package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tencent.bugly.BuglyStrategy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: assets/audience_network.dex */
public final class JD {
    public static JD A01;
    public static byte[] A02;
    public static String[] A03 = {"lby1W0wNbQrJZLPqMH4DTOw3yxUdqdf", "kgmV30Pytio8Y45c0SmevPSfJ", "GuqAlZnTPhAyqf6xpABukX78gW1eK", "0NViSQPmvGXLcgxETt4LuQqf8msO5qX", "Lug9XUXTwCkms8e17b8k", "9KOEFfUvG6glq1MfonBkT6Lvp1EWxJyS", "tUrZTe4M4NOwFWRIXhIm4QJOvCAxV", "2InOXM9Ds0dFubkAVSo31GYyY3vE8A8q"};
    public static final String[] A04;
    public static final String[] A05;
    public final SharedPreferences A00;

    public static String A0P(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "rwxiKY1yX8M1uCycGOqUPfCL86zZ3gS";
            strArr[0] = "P38LhqS18Cw18aUWRDVsuYtPAT7MPJu";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 46);
            i5++;
        }
    }

    public static void A0a() {
        A02 = new byte[]{108, 73, 107, 100, 105, 111, 102, 82, 126, Byte.MAX_VALUE, 101, 120, Byte.MAX_VALUE, 100, 116, 3, 47, 46, 52, 41, 46, 53, 37, Byte.MAX_VALUE, 106, 92, 70, 19, 68, 90, 95, 95, 19, 81, 86, 19, 71, 82, 88, 86, 93, 19, 71, 92, 19, 82, 93, 92, 71, 91, 86, 65, 19, 87, 86, 64, 71, 90, 93, 82, 71, 90, 92, 93, 29, 6, 17, 25, 8, 112, 109, 112, 109, 0, 45, 58, 50, 35, 91, 71, 91, 71, 70, 70, 70, 43, 123, 108, 100, 117, 125, 12, 10, 121, 123, 123, 113, 124, 125, 118, 108, 121, 116, 71, 123, 116, 113, 123, 115, 107, 71, 123, 119, 118, 126, 113, Byte.MAX_VALUE, 34, 32, 32, 42, 39, 38, 45, 55, 34, 47, 28, 32, 47, 42, 32, 40, 48, 28, 32, 44, 45, 37, 42, 36, 109, 55, 52, 44, 28, 48, 55, 38, 51, 28, 32, 34, 45, 32, 38, 47, 28, 33, 54, 55, 55, 44, 45, 28, 55, 38, 59, 55, 25, 27, 27, 17, 28, 29, 22, 12, 25, 20, 39, 27, 20, 17, 27, 19, 11, 39, 27, 23, 22, 30, 17, 31, 86, 12, 15, 23, 39, 11, 12, 29, 8, 39, 27, 23, 22, 30, 17, 10, 21, 39, 26, Draft_75.CR, 12, 12, 23, 22, 39, 12, 29, 0, 12, 3, 1, 1, 11, 6, 7, 12, 22, 3, 14, 61, 1, 14, 11, 1, 9, 17, 61, 1, Draft_75.CR, 12, 4, 11, 5, 76, 22, 21, Draft_75.CR, 61, 17, 22, 7, 18, 61, 1, Draft_75.CR, 12, 4, 11, 16, 15, 3, 22, 11, Draft_75.CR, 12, 68, 70, 70, 76, 65, 64, 75, 81, 68, 73, 122, 70, 73, 76, 70, 78, 86, 122, 70, 74, 75, 67, 76, 66, 11, 81, 82, 74, 122, 86, 81, 64, 85, 122, 70, 74, 75, 67, 76, 87, 72, 68, 81, 76, 74, 75, 122, 71, 74, 65, 92, 30, 28, 28, 22, 27, 26, 17, 11, 30, 19, 32, 28, 19, 22, 28, 20, 12, 32, 28, 16, 17, 25, 22, 24, 81, 11, 8, 16, 32, 12, 11, 26, 15, 32, 28, 16, 17, 25, 22, Draft_75.CR, 18, 30, 11, 22, 16, 17, 32, 11, 22, 11, 19, 26, 100, 97, 107, 114, 90, 100, 102, 102, 96, 117, 113, 100, 103, 105, 96, 90, 118, 113, 100, 102, 110, 113, 119, 100, 102, 96, 90, 102, 106, 107, 113, 96, 125, 113, 90, 99, 108, 105, 113, 96, 119, 90, 118, 108, Byte.MAX_VALUE, 96, 23, 18, 24, 1, 41, 23, 21, 21, 19, 6, 2, 23, 20, 26, 19, 41, 5, 2, 23, 21, 29, 2, 4, 23, 21, 19, 41, 26, 19, 24, 17, 2, 30, 63, 58, 48, 41, 1, 63, 50, 50, 49, 41, 1, 61, 49, 49, 53, 55, 59, 1, 51, 63, 48, 63, 57, 59, 44, 1, 55, 48, 55, 42, 55, 63, 50, 55, 36, 63, 42, 55, 49, 48, 1, 55, 48, 1, 60, 63, 45, 59, 1, 63, 58, 1, 61, 49, 48, 42, 44, 49, 50, 50, 59, 44, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 121, 116, 116, 119, 111, 71, 116, 119, 121, 124, 71, 124, 109, 106, 113, 118, Byte.MAX_VALUE, 71, 107, 112, 119, 111, 113, 118, Byte.MAX_VALUE, 31, 26, 16, 9, 33, 31, 16, 26, 12, 17, 23, 26, 33, 31, 16, 12, 33, 26, 27, 10, 27, 29, 10, 17, 12, 33, 27, 16, 31, 28, 18, 27, 46, 43, 33, 56, 16, 46, 33, 43, 61, 32, 38, 43, 16, 46, 33, 61, 16, 43, 42, 59, 42, 44, 59, 32, 61, 16, 59, 38, 34, 42, 32, 58, 59, 16, 34, 60, 62, 59, 49, 40, 0, 62, 49, 59, 45, 48, 54, 59, 0, 61, 51, 62, 60, 52, 51, 54, 44, 43, 58, 59, 0, 54, 49, 43, 58, 49, 43, 0, 42, 45, 51, 0, 47, 45, 58, 57, 54, 39, 58, 44, 112, 117, Byte.MAX_VALUE, 102, 78, 112, Byte.MAX_VALUE, 117, 99, 126, 120, 117, 78, 115, 125, 126, 114, 122, 78, 100, Byte.MAX_VALUE, 98, 112, 119, 116, 78, 97, 125, 112, 104, 112, 115, 125, 116, 78, 118, 112, 124, 116, 98, 78, 114, 112, 114, 121, 116, 33, 36, 46, 55, 31, 33, 46, 36, 50, 47, 41, 36, 31, 35, 33, 35, 40, 37, 31, 45, 47, 36, 53, 44, 37, 31, 45, 33, 56, 31, 51, 41, 58, 37, 5, 0, 10, 19, 59, 5, 10, 0, 22, 11, Draft_75.CR, 0, 59, 7, 5, 7, 12, 1, 59, 9, 11, 0, 17, 8, 1, 59, 22, 1, 16, 22, 29, 59, 8, Draft_75.CR, 9, Draft_75.CR, 16, 115, 118, 124, 101, 77, 115, 124, 118, 96, 125, 123, 118, 77, 113, 115, 96, 125, 103, 97, 119, 126, 77, 101, 122, 123, 102, 119, 77, 123, 124, 102, 119, 96, 97, 102, 123, 102, 123, 115, 126, 28, 25, 19, 10, 34, 28, 19, 25, 15, 18, 20, 25, 34, 30, 18, 16, Draft_75.CR, 15, 24, 14, 14, 34, 20, 16, 28, 26, 24, 14, 34, 25, 8, 15, 20, 19, 26, 34, 25, 18, 10, 19, 17, 18, 28, 25, 69, 64, 74, 83, 123, 69, 74, 64, 86, 75, 77, 64, 123, 64, 65, 66, 69, 81, 72, 80, 123, 69, 87, 87, 65, 80, 123, 84, 86, 65, 72, 75, 69, 64, 123, 87, 77, 94, 65, 123, 70, 93, 80, 65, 87, 97, 100, 110, 119, 95, 97, 110, 100, 114, 111, 105, 100, 95, 100, 105, 115, 97, 98, 108, 101, 95, 112, 108, 97, 121, 97, 98, 108, 101, 95, 112, 114, 101, 99, 97, 99, 104, 101, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 67, 72, 71, 68, 74, 67, 121, 72, 71, 82, 79, 80, 67, 121, 64, 83, 72, 72, 67, 74, 126, 123, 113, 104, 64, 126, 113, 123, 109, 112, 118, 123, 64, 122, 103, 112, 64, 111, 115, 126, 102, 
        122, 109, 64, 124, 126, 124, 119, 122, 64, 114, 126, 103, 64, 108, 118, 101, 122, 125, 120, 114, 107, 67, 125, 114, 120, 110, 115, 117, 120, 67, 122, 125, 117, 112, 67, 115, 114, 67, 107, 121, 126, 106, 117, 121, 107, 67, 121, 110, 110, 115, 110, 111, 55, 50, 56, 33, 9, 55, 56, 50, 36, 57, 63, 50, 9, 48, 57, 36, 53, 51, 9, 62, 55, 36, 50, 33, 55, 36, 51, 9, 55, 53, 53, 51, 58, 51, 36, 55, 34, 63, 57, 56, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 89, 88, 85, 84, 110, 71, 88, 85, 84, 94, 65, 67, 94, 86, 67, 84, 66, 66, 110, 80, 95, 88, 92, 80, 69, 88, 94, 95, 12, 9, 3, 26, 50, 12, 3, 9, 31, 2, 4, 9, 50, 4, 0, 12, 10, 8, 50, 14, 12, 14, 5, 8, 50, 30, 25, 2, 31, 8, 50, 15, 20, 25, 8, 50, 14, 2, 24, 3, 25, 120, 125, 119, 110, 70, 120, 119, 125, 107, 118, 112, 125, 70, 116, 124, 116, 118, 107, 96, 70, 118, 105, 109, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 102, 121, 104, 84, 98, 102, 123, 121, 110, 120, 120, 98, 100, 101, 84, 109, 100, 121, 84, 101, 106, Byte.MAX_VALUE, 98, 125, 110, 84, 125, 98, 111, 110, 100, 84, 106, 111, 120, 84, 125, 57, 10, 15, 5, 28, 52, 10, 5, 15, 25, 4, 2, 15, 52, 5, 10, 31, 2, 29, 14, 52, 8, 10, 25, 4, 30, 24, 14, 7, 52, 14, 19, 31, 14, 5, 24, 2, 4, 5, 52, 29, 10, 25, 2, 10, 5, 31, 21, 16, 26, 3, 43, 21, 26, 16, 6, 27, 29, 16, 43, 26, 21, 0, 29, 2, 17, 43, 26, 17, 3, 43, 23, 21, 6, 27, 1, 7, 17, 24, 43, 16, 17, 7, 29, 19, 26, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 101, 110, Byte.MAX_VALUE, 124, 100, 121, 96, 84, 111, 110, 109, 106, 126, 103, Byte.MAX_VALUE, 84, 104, 100, 101, 101, 110, 104, Byte.MAX_VALUE, 98, 100, 101, 84, Byte.MAX_VALUE, 98, 102, 110, 100, 126, Byte.MAX_VALUE, 84, 102, 120, 43, 46, 36, 61, 21, 43, 36, 46, 56, 37, 35, 46, 21, 36, 47, 62, 61, 37, 56, 33, 21, 46, 47, 44, 43, 63, 38, 62, 21, 56, 47, 43, 46, 21, 62, 35, 39, 47, 37, 63, 62, 21, 39, 57, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 72, 67, 82, 81, 73, 84, 77, 121, 66, 67, 64, 71, 83, 74, 82, 121, 84, 67, 82, 84, 79, 67, 85, 121, 72, 83, 75, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 118, 125, 108, 111, 119, 106, 115, 71, 124, 125, 126, 121, 109, 116, 108, 71, 108, 112, 106, 119, 108, 108, 116, 125, 71, 108, 113, 117, 125, 119, 109, 108, 71, 117, 107, 103, 98, 104, 113, 89, 103, 104, 98, 116, 105, 111, 98, 89, 104, 99, 114, 113, 105, 116, 109, 89, 98, 99, 96, 103, 115, 106, 114, 89, 114, 111, 107, 99, 105, 115, 114, 89, 107, 117, 124, 121, 115, 106, 66, 124, 115, 121, 111, 114, 116, 121, 66, 114, 105, 110, 113, 66, 120, 115, 124, Byte.MAX_VALUE, 113, 120, 121, 56, 61, 55, 46, 6, 56, 55, 61, 43, 54, 48, 61, 6, 43, 60, 41, 54, 43, 45, 6, 41, 43, 60, 42, 60, 55, 45, 56, 45, 48, 54, 55, 6, 60, 43, 43, 54, 43, 6, 46, 49, 60, 55, 6, 55, 54, 6, 48, 52, 41, 43, 60, 42, 42, 48, 54, 55, 86, 83, 89, 64, 104, 86, 89, 83, 69, 88, 94, 83, 104, 69, 82, 71, 88, 69, 67, 104, 71, 69, 82, 68, 82, 89, 67, 86, 67, 94, 88, 89, 104, 82, 69, 69, 88, 69, 68, 104, 94, 89, 68, 67, 82, 86, 83, 104, 88, 81, 104, 94, 89, 67, 82, 69, 89, 86, 91, 91, 94, 84, 77, 101, 91, 84, 94, 72, 85, 83, 94, 101, 73, 82, 85, 79, 86, 94, 101, 88, 86, 85, 89, 81, 101, 73, 67, 84, 89, 101, 85, 84, 101, 88, 91, 89, 81, 93, 72, 85, 79, 84, 94, 52, 49, 59, 34, 10, 52, 59, 49, 39, 58, 60, 49, 10, 38, 61, 58, 32, 57, 49, 10, 61, 60, 49, 48, 10, 57, 58, 52, 49, 48, 39, 14, 11, 1, 24, 48, 14, 1, 11, 29, 0, 6, 11, 48, 28, 7, 0, 26, 3, 11, 48, 6, 1, 6, 27, 48, 26, 1, 28, 4, 6, 31, 31, 14, Draft_75.CR, 3, 10, 48, 28, 10, 12, 0, 1, 11, 28, 48, 12, 0, 2, 31, 3, 10, 27, 10, 109, 104, 98, 123, 83, 109, 98, 104, 126, 99, 101, 104, 83, Byte.MAX_VALUE, 100, 99, 121, 96, 104, 83, 126, 105, Byte.MAX_VALUE, 105, 120, 83, 106, 99, 111, 121, Byte.MAX_VALUE, 83, 99, 98, 83, 98, 109, 120, 101, 122, 105, 83, 126, 105, 124, 99, 126, 120, 101, 98, 107, 58, 63, 53, 44, 4, 58, 53, 63, 41, 52, 50, 63, 4, 46, 57, 45, 41, 56, 35, 38, 44, 53, 29, 35, 44, 38, 48, 45, 43, 38, 29, 55, 49, 39, 29, 33, 35, 33, 42, 39, 29, 47, 45, 38, 55, 46, 39, 29, 36, 45, 48, 29, 43, 47, 35, 37, 39, 49, 91, 94, 84, 77, 101, 91, 84, 94, 72, 85, 83, 94, 101, 79, 73, 95, 101, 73, 78, 95, 91, 87, 83, 84, 93, 101, 83, 87, 91, 93, 95, 101, 94, 95, 89, 85, 94, 83, 84, 93, 45, 40, 34, 59, 19, 45, 34, 40, 62, 35, 37, 40, 19, 59, 36, 37, 56, 41, 32, 37, 63, 56, 41, 40, 19, 37, 34, 56, 
        41, 34, 56, 19, 57, 62, 32, 19, 60, 62, 41, 42, 37, 52, 41, 63, 7, 2, 8, 17, 57, 7, 21, 21, 3, 18, 57, 0, 3, 18, 5, 14, 15, 8, 1, 57, 19, 8, 15, 0, 15, 3, 2, 41, 44, 38, 63, 23, 42, 41, 38, 38, 45, 58, 23, 38, 39, 60, 33, 46, 49, 23, 41, 44, 23, 36, 39, 41, 44, 45, 44, 23, 39, 38, 23, 41, 59, 59, 45, 60, 59, 23, 36, 39, 41, 44, 45, 44, 114, 119, 125, 100, 76, 113, 118, 125, 112, 123, 126, 114, 97, 120, 76, 97, 118, 99, 124, 97, 103, 76, 122, 125, 103, 118, 97, 101, 114, Byte.MAX_VALUE, 76, 126, 96, 122, Byte.MAX_VALUE, 117, 108, 68, 121, 119, 116, 120, 112, 68, 119, 116, 120, 112, 104, 120, 105, 126, 126, 117, 21, 16, 26, 3, 43, 23, 6, 21, 7, 28, 43, 7, 28, 29, 17, 24, 16, 43, 17, 26, 21, 22, 24, 17, 16, 91, 94, 84, 77, 101, 89, 78, 91, 101, 91, 84, 83, 87, 91, 78, 83, 85, 84, 101, 94, 95, 86, 91, 67, 101, 87, 73, 51, 54, 60, 37, Draft_75.CR, 49, 38, 51, Draft_75.CR, 63, 59, 60, Draft_75.CR, 33, 49, 51, 62, 55, Draft_75.CR, 51, 60, 59, 63, 51, 38, 59, 61, 60, Draft_75.CR, 34, 55, 32, 49, 55, 60, 38, 51, 53, 55, 35, 38, 44, 53, 29, 38, 45, 29, 46, 39, 49, 49, 29, 49, 54, 48, 43, 33, 54, 29, 49, 39, 33, 45, 44, 38, 29, 33, 42, 35, 44, 44, 39, 46, 29, 43, 47, 50, 26, 31, 21, 12, 36, 30, 21, 26, 25, 23, 30, 36, 26, 14, 15, 20, 36, 31, 30, 8, 15, 9, 20, 2, 36, 23, 30, 26, 16, 8, 66, 71, 77, 84, 124, 70, 77, 66, 65, 79, 70, 124, 65, 74, 71, 71, 70, 81, 124, 87, 76, 72, 70, 77, 124, 74, 77, 69, 76, 52, 49, 59, 34, 10, 48, 59, 52, 55, 57, 48, 10, 49, 48, 55, 32, 50, 10, 58, 35, 48, 39, 57, 52, 44, 37, 32, 42, 51, 27, 33, 42, 37, 38, 40, 33, 27, 33, 60, 43, 52, 40, 37, 61, 33, 54, 27, 39, 37, 39, 44, 33, 89, 92, 86, 79, 103, 93, 86, 89, 90, 84, 93, 103, 93, 64, 87, 72, 84, 89, 65, 93, 74, 103, 91, 89, 91, 80, 93, 103, 94, 87, 74, 103, 92, 75, 84, 87, 82, 88, 65, 105, 83, 88, 87, 84, 90, 83, 105, 83, 78, 89, 70, 90, 87, 79, 83, 68, 105, 64, 4, 58, 63, 53, 44, 4, 62, 53, 58, 57, 55, 62, 4, 61, 46, 53, 53, 62, 55, 47, 42, 32, 57, 17, 43, 32, 47, 44, 34, 43, 17, 39, 32, 34, 39, 32, 43, 17, 54, 17, 33, 59, 58, 17, 32, 33, 32, 17, 40, 59, 34, 34, 61, 45, 60, 43, 43, 32, 17, 33, 32, 17, 61, 42, 37, 10, 15, 5, 28, 52, 14, 5, 10, 9, 7, 14, 52, 5, 14, 31, 28, 4, 25, 0, 65, 68, 78, 87, Byte.MAX_VALUE, 69, 78, 65, 66, 76, 69, Byte.MAX_VALUE, 80, 82, 69, 76, 79, 65, 68, 94, 91, 81, 72, 96, 90, 81, 94, 93, 83, 90, 96, 77, 94, 88, 90, 96, 76, 87, 94, 84, 90, 24, 29, 23, 14, 38, 28, 23, 24, 27, 21, 28, 38, 10, 0, 23, 26, Draft_75.CR, 8, 2, 27, 51, 9, 20, 28, 3, 31, 9, 51, 26, 5, 8, 9, 3, 51, 27, Draft_75.CR, 24, 15, 4, 51, 24, 5, 1, 9, 77, 72, 66, 91, 115, 74, 69, 64, 88, 73, 94, 115, 78, 69, 72, 72, 69, 66, 75, 115, 88, 67, 71, 73, 66, 27, 30, 20, Draft_75.CR, 37, 19, 23, 10, 9, 37, 9, 31, 25, 21, 20, 30, 37, 25, 18, 27, 20, 20, 31, 22, 37, 31, 20, 27, 24, 22, 31, 30, 100, 97, 107, 114, 90, 108, 107, 113, 96, 119, 118, 113, 108, 113, 108, 100, 105, 90, 107, 96, 114, 90, 108, 104, 100, 98, 96, 90, 97, 96, 118, 108, 98, 107, 79, 74, 64, 89, 113, 66, 65, 73, 73, 71, 64, 73, 113, 75, 64, 74, 94, 65, 71, 64, 90, 113, 94, 92, 75, 72, 71, 86, 96, 101, 111, 118, 94, 111, 96, 117, 104, 119, 100, 94, 98, 96, 115, 110, 116, 114, 100, 109, 94, 98, 110, 108, 113, 96, 98, 117, 94, 117, 105, 115, 100, 114, 105, 110, 109, 101, 15, 10, 0, 25, 49, 0, 15, 26, 7, 24, 11, 49, 24, 7, 11, 25, 49, 29, 0, 15, 30, 29, 6, 1, 26, 49, 2, 1, 9, 9, 7, 0, 9, 49, 11, 0, 15, 12, 2, 11, 10, 20, 17, 27, 2, 42, 26, 27, 17, 16, 3, 28, 22, 16, 42, 29, 28, 6, 1, 26, 7, 12, 42, 17, 20, 1, 20, 42, 16, 27, 20, 23, 25, 16, 17, 117, 112, 122, 99, 75, 123, 100, 113, 122, 75, 114, 118, 75, 117, 100, 100, 75, 117, 120, 99, 117, 109, 103, 121, 124, 118, 111, 71, 104, 116, 121, 97, 121, 122, 116, 125, 71, 123, 116, 113, 123, 115, 71, 117, 121, 96, 71, 124, 125, 116, 121, 97, 71, 117, 107, 123, 126, 116, 109, 69, 106, 118, 123, 99, 123, 120, 118, Byte.MAX_VALUE, 69, 126, 115, 105, 123, 120, 118, Byte.MAX_VALUE, 69, 104, Byte.MAX_VALUE, 119, 117, 110, Byte.MAX_VALUE, 69, 117, 116, 69, 116, Byte.MAX_VALUE, 110, 109, 117, 104, 113, 69, 118, 117, 105, 105, 43, 46, 36, 61, 21, 58, 38, 43, 51, 43, 40, 38, 47, 57, 21, 38, 37, 45, 45, 35, 36, 45, 21, 47, 36, 43, 40, 38, 47, 46, 56, 61, 55, 46, 6, 41, 53, 56, 32, 56, 59, 53, 60, 42, 6, 55, 60, 46, 6, 61, 60, 42, 48, 62, 55, 109, 104, 98, 123, 83, 
        124, 96, 109, 117, 109, 110, 96, 105, Byte.MAX_VALUE, 83, Byte.MAX_VALUE, 100, 99, 123, 83, 105, 98, 104, 111, 109, 126, 104, 10, 15, 5, 28, 52, 27, 25, 14, 7, 4, 10, 15, 52, 2, 5, 31, 14, 25, 24, 31, 2, 31, 2, 10, 7, 52, 15, 18, 5, 10, 6, 2, 8, 52, 28, 14, 9, 29, 2, 14, 28, 100, 97, 107, 114, 90, 117, 119, 96, 105, 106, 100, 97, 90, 119, 115, 90, 97, 124, 107, 100, 104, 108, 102, 90, 114, 96, 103, 115, 108, 96, 114, 0, 5, 15, 22, 62, 17, 19, 4, 23, 4, 15, 21, 62, 17, Draft_75.CR, 0, 24, 0, 3, Draft_75.CR, 4, 62, 0, 20, 21, 14, 62, 2, Draft_75.CR, 8, 2, 10, 23, 18, 24, 1, 41, 6, 3, 4, 17, 19, 41, 25, 24, 41, 66, 71, 69, 41, 4, 19, 5, 6, 25, 24, 5, 19, 52, 49, 59, 34, 10, 39, 48, 54, 58, 56, 37, 32, 33, 48, 10, 55, 33, 10, 52, 51, 33, 48, 39, 10, 48, 45, 33, 39, 52, 38, 10, 54, 61, 52, 59, 50, 48, 81, 84, 94, 71, 111, 66, 70, 111, 82, 69, 86, 86, 85, 66, 111, 83, 88, 85, 83, 91, 111, 85, 94, 81, 82, 92, 85, 84, 115, 118, 124, 101, 77, 96, 100, 77, 98, 126, 115, 107, 112, 115, 113, 121, 77, 113, 96, 115, 97, 122, 77, 116, 115, 126, 126, 112, 115, 113, 121, 61, 56, 50, 43, 3, 47, 57, 50, 56, 3, 46, 40, 58, 3, 44, 61, 46, 61, 49, 47, 71, 66, 72, 81, 121, 85, 67, 72, 66, 79, 72, 65, 121, 64, 84, 67, 87, 83, 67, 72, 69, 95, 121, 69, 71, 86, 86, 79, 72, 65, 121, 71, 74, 74, 73, 81, 67, 66, 99, 102, 108, 117, 93, 113, 103, 118, 93, 118, 103, 122, 118, 93, 97, 109, 110, 109, 112, 93, 102, 123, 108, 99, 111, 107, 97, 99, 110, 110, 123, 58, 63, 53, 44, 4, 40, 51, 52, 46, 55, 63, 4, 58, 63, 63, 4, 62, 35, 47, 62, 53, 40, 50, 52, 53, 4, 47, 52, 4, 43, 55, 58, 34, 58, 57, 55, 62, 40, 121, 124, 118, 111, 71, 107, 112, 119, 109, 116, 124, 71, 123, 116, 125, 121, 106, 71, 126, 125, 121, 108, 109, 106, 125, 71, 123, 119, 118, 126, 113, Byte.MAX_VALUE, 71, 119, 118, 71, 123, 106, 121, 107, 112, 125, 107, 34, 39, 45, 52, 28, 48, 43, 44, 54, 47, 39, 28, 42, 36, 45, 44, 49, 38, 28, 39, 38, 48, 55, 49, 44, 58, 28, 32, 34, 47, 47, 25, 28, 22, 15, 39, 11, 16, 23, Draft_75.CR, 20, 28, 39, 17, 22, 27, 10, 29, 21, 29, 22, 12, 39, 10, 29, 12, 10, 1, 39, 27, 23, Draft_75.CR, 22, 12, 29, 10, 39, 23, 22, 39, 29, 21, 8, 12, 1, 39, 10, 29, 11, 8, 23, 22, 11, 29, 94, 91, 81, 72, 96, 76, 87, 80, 74, 83, 91, 96, 86, 81, 86, 75, 96, 89, 77, 80, 82, 96, 92, 80, 81, 75, 90, 81, 75, 96, 79, 77, 80, 73, 86, 91, 90, 77, 44, 41, 35, 58, 18, 62, 37, 34, 56, 33, 41, 18, 36, 35, 36, 57, 18, 34, 35, 18, 46, 33, 44, 62, 62, 18, 33, 34, 44, 41, 36, 35, 42, 32, 37, 47, 54, 30, 50, 41, 46, 52, 45, 37, 30, 45, 46, 38, 30, 32, 50, 50, 36, 53, 30, 52, 51, 45, 125, 120, 114, 107, 67, 111, 116, 115, 105, 112, 120, 67, 108, 110, 121, Byte.MAX_VALUE, 115, 113, 108, 105, 104, 121, 67, 126, 117, 120, 120, 121, 110, 67, 104, 115, 119, 121, 114, 68, 65, 75, 82, 122, 86, 78, 76, 85, 122, 83, 76, 65, 64, 74, 122, 75, 74, 75, 122, 77, 68, 87, 65, 82, 68, 87, 64, 122, 68, 70, 70, 64, 73, 64, 87, 68, 81, 64, 65, 34, 39, 45, 52, 28, 48, 55, 34, 32, 40, 55, 49, 34, 32, 38, 28, 36, 49, 44, 54, 51, 42, 45, 36, 28, 38, 45, 34, 33, 47, 38, 39, 10, 15, 5, 28, 52, 24, 18, 5, 8, 52, 10, Draft_75.CR, 31, 14, 25, 52, 10, 15, 52, 7, 4, 10, 15, 46, 43, 33, 56, 16, 60, 54, 33, 44, 16, 42, 33, 43, 63, 32, 38, 33, 59, 16, 63, 61, 42, 41, 38, 55, 1, 4, 14, 23, 63, 20, 9, Draft_75.CR, 5, 63, 20, 15, 63, 23, 1, 9, 20, 63, 6, 15, 18, 63, 22, 9, 4, 5, 15, 63, 16, 12, 1, 25, 63, Draft_75.CR, 19, 52, 49, 59, 34, 10, 33, 60, 56, 48, 10, 33, 58, 10, 34, 52, 60, 33, 10, 51, 58, 39, 10, 35, 60, 49, 48, 58, 10, 37, 39, 48, 37, 52, 39, 48, 49, 10, 56, 38, 76, 73, 67, 90, 114, 89, 68, 64, 72, 66, 88, 89, 114, 95, 72, 90, 76, 95, 73, 72, 73, 114, 91, 68, 73, 72, 66, 12, 9, 3, 26, 50, 25, 31, 4, 10, 10, 8, 31, 50, 3, 12, 25, 4, 27, 8, 50, 31, 8, 10, 4, 30, 25, 8, 31, 50, 27, 4, 8, 26, 50, 8, 31, 31, 2, 31, 50, 14, 12, 1, 1, 15, 12, 14, 6, 79, 74, 64, 89, 113, 91, 64, 71, 95, 91, 75, 113, 74, 76, 113, 64, 79, 67, 75, 113, 94, 75, 92, 113, 94, 92, 65, 77, 75, 93, 93, 55, 50, 56, 33, 9, 35, 37, 51, 9, 55, 38, 38, 9, 50, 63, 49, 51, 37, 34, 9, 55, 38, 63, 126, 123, 113, 104, 64, 106, 108, 122, 64, 124, 126, 124, 119, 122, 123, 64, 122, 103, 122, 124, 106, 107, 112, 109, 64, 121, 112, 109, 64, 113, 122, 107, 104, 112, 109, 116, 3, 6, 12, 21, 61, 23, 17, 7, 
        61, 1, 3, 1, 10, 7, 6, 61, 7, 26, 7, 1, 23, 22, Draft_75.CR, 16, 61, 11, 12, 61, 1, 3, 1, 10, 7, 61, 15, 3, 12, 3, 5, 7, 16, 121, 124, 118, 111, 71, 109, 107, 125, 71, 106, 113, 104, 104, 116, 125, 71, 121, 118, 113, 117, 121, 108, 113, 119, 118, 33, 36, 46, 55, 31, 54, 41, 37, 55, 33, 34, 41, 44, 41, 52, 57, 31, 35, 40, 37, 35, 43, 31, 33, 50, 37, 33, 31, 34, 33, 51, 37, 36, 104, 124, 125, 102, 123, 102, 125, 104, 125, 108, 86, 109, 96, 122, 104, 107, 101, 108, 109, 7, 19, 18, 9, 20, 9, 18, 7, 18, 3, 57, 3, 8, 7, 4, 10, 3, 2, 96, 111, 106, 96, 104, 100, 118, 98, 113, 103, 92, 119, 106, 110, 102, 92, 110, 112, 121, 117, 119, 52, 124, 123, 121, Byte.MAX_VALUE, 120, 117, 117, 113, 52, 123, 126, 105, 52, 92, 95, 91, 78, 79, 72, 95, 69, 89, 85, 84, 92, 83, 93, 47, 43, 44, 43, 47, 55, 47, 29, 39, 46, 35, 50, 49, 39, 38, 29, 54, 43, 47, 39, 29, 35, 36, 54, 39, 48, 29, 43, 47, 50, 48, 39, 49, 49, 43, 45, 44, 111, 116, 109, 109, 121, 110, 120, Byte.MAX_VALUE, 121, 98, 104, Byte.MAX_VALUE, 110, 111, 84, 111, 106, Byte.MAX_VALUE, 106, 84, 123, 121, 100, 104, 110, 120, 120, 98, 101, 108, 84, 104, 100, 102, 105, 98, 101, 106, Byte.MAX_VALUE, 98, 100, 101, 120, 87, 80, 69, 71, 79, 123, 80, 86, 69, 71, 65, 123, 87, 69, 73, 84, 72, 65, 123, 86, 69, 80, 65, 68, 91, 86, 87, 93, 109, 83, 92, 86, 109, 87, 92, 86, 81, 83, 64, 86, 109, 83, 71, 70, 93, 64, 93, 70, 83, 70, 87, 101, 101, 101};
    }

    static {
        A0a();
        A04 = new String[0];
        A05 = new String[]{A0P(86, 5, 14), A0P(65, 9, 115), A0P(74, 12, 88)};
    }

    public JD(Context context) {
        this.A00 = context.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A0P(4146, 31, 52), context), 0);
    }

    public static float A00(Context context) {
        return A0O(context).A20(A0P(2194, 39, 124), 0.98f);
    }

    public static int A01(Context context) {
        return A0O(context).A21(A0P(417, 33, 88), 100);
    }

    public static int A02(Context context) {
        return A0O(context).A21(A0P(2088, 33, 61), 0);
    }

    public static int A03(Context context) {
        return A0O(context).A21(A0P(2167, 27, 20), -1);
    }

    public static int A04(Context context) {
        return A0O(context).A21(A0P(742, 37, 74), 3);
    }

    public static int A05(Context context) {
        return A0O(context).A21(A0P(4128, 18, 45), 0);
    }

    public static int A06(Context context) {
        return A0O(context).A21(A0P(582, 36, 97), PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public static int A07(Context context) {
        return A0O(context).A21(A0P(1333, 50, 37), BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
    }

    public static int A08(Context context) {
        return A0O(context).A21(A0P(1427, 40, 8), 3);
    }

    public static int A09(Context context) {
        return A0O(context).A21(A0P(1383, 44, 100), PayResult.PAY_RESULT_ALIPAY_CHECK_IN);
    }

    public static int A0A(Context context) {
        return A0O(context).A21(A0P(1467, 48, 54), 100);
    }

    public static int A0B(Context context) {
        return A0O(context).A21(A0P(1515, 39, 40), 60000);
    }

    public static int A0C(Context context) {
        return A0O(context).A21(A0P(2728, 38, 47), 225);
    }

    public static int A0D(Context context) {
        return A0O(context).A21(A0P(1133, 41, 67), 3145728);
    }

    public static int A0E(Context context) {
        return A0O(context).A21(A0P(4177, 37, 108), -1);
    }

    public static int A0F(Context context) {
        return A0O(context).A21(A0P(2864, 32, 54), 2000);
    }

    public static int A0G(Context context) {
        return A0O(context).A21(A0P(371, 46, 43), -1);
    }

    public static int A0H(Context context) {
        return A0O(context).A21(A0P(4257, 23, 10), 0);
    }

    public static int A0I(Context context) {
        return A0O(context).A21(A0P(3753, 35, 78), PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public static int A0J(Context context) {
        return A0O(context).A21(A0P(3788, 39, 123), PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public static int A0K(Context context) {
        return A0O(context).A21(A0P(1248, 46, 69), 0);
    }

    public static long A0L(Context context) {
        return A0O(context).A22(A0P(708, 34, 110), 67108864L);
    }

    public static long A0M(Context context) {
        return A0O(context).A22(A0P(863, 45, 10), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }

    public static long A0N(Context context) {
        return A0O(context).A22(A0P(979, 38, 49), 16777216L);
    }

    public static synchronized JD A0O(Context context) {
        JD jd;
        synchronized (JD.class) {
            if (A01 == null) {
                A01 = new JD(context);
            }
            jd = A01;
        }
        return jd;
    }

    public static String A0Q(Context context) {
        return A0O(context).A23(A0P(2700, 28, 0), A0P(4308, 3, 60));
    }

    public static String A0R(Context context) {
        return A0O(context).A23(A0P(3728, 25, 97), A0P(4308, 3, 60));
    }

    public static String A0S(Context context) {
        return A0O(context).A23(A0P(117, 52, 109), A0P(1, 6, 36));
    }

    public static String A0T(Context context) {
        return A0O(context).A23(A0P(268, 51, 11), A0P(24, 41, 29));
    }

    public static String A0U(Context context) {
        return A0O(context).A23(A0P(169, 53, 86), A0P(7, 8, 63));
    }

    public static String A0V(Context context) {
        return A0O(context).A23(A0P(319, 52, 81), A0P(15, 9, 110));
    }

    public static Set<String> A0W(Context context) {
        return A0O(context).A0Z(A0P(618, 44, 113), A04);
    }

    public static Set<String> A0X(Context context) {
        return A0O(context).A0Z(A0P(4218, 39, 37), A05);
    }

    public static Set<String> A0Y(Context context) {
        return A0O(context).A0Z(A0P(1972, 44, 98), A04);
    }

    private Set<String> A0Z(String str, String[] strArr) {
        JSONArray jSONArray;
        String A23 = A23(str, null);
        try {
            if (A23 != null) {
                jSONArray = new JSONArray(A23);
            } else {
                jSONArray = new JSONArray((Collection) Arrays.asList(strArr));
            }
            int length = jSONArray.length();
            LinkedHashSet linkedHashSet = new LinkedHashSet(length);
            for (int i2 = 0; i2 < length; i2++) {
                linkedHashSet.add(jSONArray.getString(i2));
            }
            return linkedHashSet;
        } catch (JSONException unused) {
            return new LinkedHashSet();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void A0b(Context context) {
        A0O(context).A00.edit().clear().commit();
    }

    private void A0c(@Nullable String str, @Nullable String str2) throws JSONException {
        if (str == null || str.isEmpty() || str.equals(A0P(91, 2, 121))) {
            return;
        }
        A0d(new JSONObject(str), str2);
    }

    private void A0d(JSONObject jSONObject, @Nullable String key) throws JSONException {
        SharedPreferences.Editor edit = this.A00.edit();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equals(A0P(93, 24, 54))) {
                A0c(jSONObject.getString(next), next);
            } else {
                String str = next;
                if (key != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(key);
                    String sharedPrefKey = A0P(0, 1, 108);
                    sb.append(sharedPrefKey);
                    sb.append(str);
                    str = sb.toString();
                }
                String sharedPrefKey2 = jSONObject.getString(next);
                edit.putString(str, sharedPrefKey2);
            }
        }
        edit.apply();
    }

    public static boolean A0e(Context context) {
        return A0O(context).A23(A0P(4280, 28, 28), A0P(4091, 19, 39)).equals(A0P(4110, 18, 72));
    }

    public static boolean A0f(Context context) {
        return A0O(context).A26(A0P(512, 38, 54), false);
    }

    public static boolean A0g(Context context) {
        return A0O(context).A26(A0P(3152, 37, 123), false);
    }

    public static boolean A0h(Context context) {
        return A0O(context).A26(A0P(2301, 29, 13), true);
    }

    public static boolean A0i(Context context) {
        return A0O(context).A26(A0P(2995, 27, 34), false);
    }

    public static boolean A0j(Context context) {
        return A0O(context).A26(A0P(819, 44, 83), true);
    }

    public static boolean A0k(Context context) {
        return A0O(context).A26(A0P(2142, 25, 90), true);
    }

    public static boolean A0l(Context context) {
        return A0O(context).A26(A0P(2896, 44, 52), true);
    }

    public static boolean A0m(Context context) {
        return A0O(context).A26(A0P(450, 62, 112), false);
    }

    public static boolean A0n(Context context) {
        return A0O(context).A26(A0P(2271, 30, 85), false);
    }

    public static boolean A0o(Context context) {
        return A0O(context).A26(A0P(946, 33, 8), true);
    }

    public static boolean A0p(Context context) {
        return A0O(context).A26(A0P(2581, 28, 66), false);
    }

    public static boolean A0q(Context context) {
        return A0O(context).A26(A0P(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 35, 50), false);
    }

    public static boolean A0r(Context context) {
        return A0O(context).A26(A0P(2441, 18, 117), false);
    }

    public static boolean A0s(Context context) {
        return A0O(context).A26(A0P(550, 32, 80), false);
    }

    public static boolean A0t(Context context) {
        return A0O(context).A26(A0P(2609, 25, 2), false);
    }

    public static boolean A0u(Context context) {
        if (Build.VERSION.SDK_INT >= 18) {
            JD A0O = A0O(context);
            String A0P = A0P(2330, 25, 123);
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "eVi9wsoxiKuO8fS3Ni664QsxmOwf4Hz";
            strArr[0] = "nOcXZ0DMfofG3U9htYbEeRQSfAelmGW";
            return A0O.A26(A0P, false);
        }
        return false;
    }

    public static boolean A0v(Context context) {
        return A0O(context).A26(A0P(2807, 34, 91), false);
    }

    public static boolean A0w(Context context) {
        return A0O(context).A26(A0P(1174, 23, 55), false);
    }

    public static boolean A0x(Context context) {
        return A0O(context).A26(A0P(2766, 41, 64), false);
    }

    public static boolean A0y(Context context) {
        return A0O(context).A26(A0P(2543, 22, 17), false);
    }

    public static boolean A0z(Context context) {
        return A0O(context).A26(A0P(3189, 28, 30), true);
    }

    public static boolean A10(Context context) {
        return A0O(context).A26(A0P(3217, 31, 60), true);
    }

    public static boolean A11(Context context) {
        return A0O(context).A26(A0P(3673, 32, 109), false);
    }

    public static boolean A12(Context context) {
        return A0O(context).A26(A0P(222, 46, 76), false);
    }

    public static boolean A13(Context context) {
        return A0O(context).A26(A0P(2233, 38, 108), false);
    }

    public static boolean A14(Context context) {
        return A0O(context).A26(A0P(2505, 19, 69), true);
    }

    public static boolean A15(Context context) {
        return A0O(context).A26(A0P(2043, 45, 102), false);
    }

    public static boolean A16(Context context) {
        return A0O(context).A26(A0P(1554, 25, 51), true);
    }

    public static boolean A17(Context context) {
        return A0O(context).A26(A0P(3022, 41, 69), true);
    }

    public static boolean A18(Context context) {
        return A0O(context).A26(A0P(2524, 19, 14), true);
    }

    public static boolean A19(Context context) {
        return A0O(context).A26(A0P(3063, 31, 43), true);
    }

    public static boolean A1A(Context context) {
        return A0O(context).A26(A0P(3094, 32, 79), true);
    }

    public static boolean A1B(Context context) {
        return A0O(context).A26(A0P(1579, 57, 119), false);
    }

    public static boolean A1C(Context context) {
        return A0O(context).A26(A0P(1636, 59, 25), true);
    }

    public static boolean A1D(Context context) {
        return A0O(context).A26(A0P(2634, 32, 84), false);
    }

    public static boolean A1E(Context context) {
        return A0O(context).A26(A0P(3268, 38, 8), true);
    }

    public static boolean A1F(Context context) {
        return A0O(context).A26(A0P(3337, 38, 117), true);
    }

    public static boolean A1G(Context context) {
        return A0O(context).A26(A0P(2841, 23, 58), true);
    }

    public static boolean A1H(Context context) {
        return A0O(context).A26(A0P(2121, 21, 53), false);
    }

    public static boolean A1I(Context context) {
        return A0O(context).A26(A0P(1695, 44, 20), true);
    }

    public static boolean A1J(Context context) {
        return Build.VERSION.SDK_INT >= 16 && A0O(context).A26(A0P(662, 46, 63), false);
    }

    public static boolean A1K(Context context) {
        return A0O(context).A26(A0P(3375, 43, 54), true);
    }

    public static boolean A1L(Context context) {
        return A0O(context).A26(A0P(908, 38, 46), false);
    }

    public static boolean A1M(Context context) {
        return A0O(context).A26(A0P(2940, 30, 100), true);
    }

    public static boolean A1N(Context context) {
        return A0O(context).A26(A0P(2016, 27, 72), false);
    }

    public static boolean A1O(Context context) {
        return A0O(context).A26(A0P(1197, 51, 37), false);
    }

    public static boolean A1P(Context context) {
        return A0O(context).A26(A0P(1052, 40, 120), true);
    }

    public static boolean A1Q(Context context) {
        return A0O(context).A26(A0P(1739, 31, 123), false);
    }

    public static boolean A1R(Context context) {
        return A0O(context).A26(A0P(1092, 41, 31), false);
    }

    public static boolean A1S(Context context) {
        return A0O(context).A26(A0P(3418, 31, 109), false);
    }

    public static boolean A1T(Context context) {
        return A0O(context).A26(A0P(3449, 53, 86), false);
    }

    public static boolean A1U(Context context) {
        return A0O(context).A26(A0P(3502, 38, 17), true);
    }

    public static boolean A1V(Context context) {
        return A0O(context).A26(A0P(3540, 33, 99), false);
    }

    public static boolean A1W(Context context) {
        return A0O(context).A26(A0P(1770, 53, 65), false);
    }

    public static boolean A1X(Context context) {
        return A0O(context).A26(A0P(3573, 25, 111), false);
    }

    public static boolean A1Y(Context context) {
        return A0O(context).A26(A0P(3598, 35, 50), false);
    }

    public static boolean A1Z(Context context) {
        return A0O(context).A26(A0P(3126, 26, 88), false);
    }

    public static boolean A1a(Context context) {
        return A0O(context).A26(A0P(1823, 51, 34), true);
    }

    public static boolean A1b(Context context) {
        return A0O(context).A26(A0P(3248, 20, 114), false);
    }

    public static boolean A1c(Context context) {
        return A0O(context).A26(A0P(3306, 31, 44), false);
    }

    public static boolean A1d(Context context) {
        return A0O(context).A26(A0P(3705, 23, 69), true);
    }

    public static boolean A1e(Context context) {
        return A0O(context).A26(A0P(3827, 27, 3), false);
    }

    public static boolean A1f(Context context) {
        return A0O(context).A26(A0P(4058, 33, 110), false);
    }

    public static boolean A1g(Context context) {
        return A0O(context).A26(A0P(2459, 46, 96), true);
    }

    public static boolean A1h(Context context) {
        return A0O(context).A26(A0P(2666, 34, 43), false);
    }

    public static boolean A1i(Context context) {
        return A0O(context).A26(A0P(4033, 25, 54), false);
    }

    public static boolean A1j(Context context) {
        return A0O(context).A26(A0P(3902, 31, 0), false);
    }

    public static boolean A1k(Context context) {
        return A0O(context).A26(A0P(3633, 40, 11), true);
    }

    public static boolean A1l(Context context) {
        return A0O(context).A26(A0P(2565, 16, 87), true);
    }

    public static boolean A1m(Context context) {
        return A0O(context).A26(A0P(3854, 48, 67), false);
    }

    public static boolean A1n(Context context) {
        return A0O(context).A26(A0P(3933, 23, 120), false);
    }

    public static boolean A1o(Context context) {
        return A0O(context).A26(A0P(1874, 18, 117), false);
    }

    public static boolean A1p(Context context) {
        return A0O(context).A26(A0P(1892, 40, 108), false);
    }

    public static boolean A1q(Context context) {
        return A0O(context).A26(A0P(3956, 36, 49), false);
    }

    public static boolean A1r(Context context) {
        return A0O(context).A26(A0P(3992, 41, 76), true);
    }

    public static boolean A1s(Context context) {
        return A0O(context).A26(A0P(779, 40, 60), false);
    }

    public static boolean A1t(Context context) {
        return A0O(context).A26(A0P(1294, 39, 90), false);
    }

    public static boolean A1u(Context context) {
        return A0O(context).A26(A0P(2970, 25, 119), false);
    }

    public static boolean A1v(Context context) {
        return A0O(context).A26(A0P(1932, 40, 20), true);
    }

    public static boolean A1w(Context context, boolean z) {
        return A1y(context, z) && A0O(context).A26(A0P(2355, 27, 106), false);
    }

    public static boolean A1x(Context context, boolean z) {
        return Build.VERSION.SDK_INT >= 21 && A1w(context, z) && A0O(context).A26(A0P(2382, 35, 22), true);
    }

    public static boolean A1y(Context context, boolean z) {
        return z && Build.VERSION.SDK_INT >= 19 && A0O(context).A26(A0P(2417, 24, 24), false);
    }

    public final double A1z(String str, double d2) {
        String string = this.A00.getString(str, String.valueOf(d2));
        if (string != null) {
            try {
                if (string.equals(A0P(4214, 4, 47))) {
                    return d2;
                }
                d2 = Double.parseDouble(string);
                return d2;
            } catch (NumberFormatException unused) {
                return d2;
            }
        }
        return d2;
    }

    public final float A20(String str, float f2) {
        String string = this.A00.getString(str, String.valueOf(f2));
        if (string != null) {
            try {
                if (string.equals(A0P(4214, 4, 47))) {
                    return f2;
                }
                f2 = Float.parseFloat(string);
                return f2;
            } catch (NumberFormatException unused) {
                return f2;
            }
        }
        return f2;
    }

    public final int A21(String str, int i2) {
        String string = this.A00.getString(str, String.valueOf(i2));
        if (string != null) {
            try {
                if (string.equals(A0P(4214, 4, 47))) {
                    return i2;
                }
                i2 = Integer.parseInt(string);
                return i2;
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return i2;
    }

    public final long A22(String str, long j2) {
        String string = this.A00.getString(str, String.valueOf(j2));
        if (string != null) {
            try {
                if (string.equals(A0P(4214, 4, 47))) {
                    return j2;
                }
                j2 = Long.parseLong(string);
                return j2;
            } catch (NumberFormatException unused) {
                return j2;
            }
        }
        return j2;
    }

    public final String A23(String str, String str2) {
        String string = this.A00.getString(str, str2);
        return (string == null || string.equals(A0P(4214, 4, 47))) ? str2 : string;
    }

    public final void A24(@Nullable String str) throws JSONException {
        A0c(str, null);
    }

    public final void A25(@Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        A0d(jSONObject, null);
    }

    public final boolean A26(String str, boolean z) {
        String string = this.A00.getString(str, String.valueOf(z));
        if (string != null) {
            boolean equals = string.equals(A0P(4214, 4, 47));
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            A03[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
            return equals ? z : Boolean.parseBoolean(string);
        }
        return z;
    }
}
