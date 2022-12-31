package com.pinguo.camera360.gallery.util;

import com.tencent.connect.common.Constants;
import java.util.Locale;
import us.pinguo.foundation.utils.v;
/* compiled from: AlbumDateFormat.java */
/* loaded from: classes3.dex */
public class a {
    public static String b = "Jan ";
    public static String c = "Feb ";

    /* renamed from: d  reason: collision with root package name */
    public static String f6735d = "Mar ";

    /* renamed from: e  reason: collision with root package name */
    public static String f6736e = "Apr ";

    /* renamed from: f  reason: collision with root package name */
    public static String f6737f = "May ";

    /* renamed from: g  reason: collision with root package name */
    public static String f6738g = "Jun ";

    /* renamed from: h  reason: collision with root package name */
    public static String f6739h = "Jul ";

    /* renamed from: i  reason: collision with root package name */
    public static String f6740i = "Aug ";

    /* renamed from: j  reason: collision with root package name */
    public static String f6741j = "Sep ";

    /* renamed from: k  reason: collision with root package name */
    public static String f6742k = "Oct ";

    /* renamed from: l  reason: collision with root package name */
    public static String f6743l = "Nov ";
    public static String m = "Dec ";
    private boolean a;

    public a() {
        this.a = false;
        this.a = "zh".equals(v.a().getLanguage().toLowerCase(Locale.ENGLISH));
    }

    public String a(String str) {
        String substring;
        String str2;
        String substring2 = str.substring(0, 2);
        if (this.a) {
            String substring3 = str.length() > 3 ? str.substring(3, 5) : "";
            substring = str.length() > 5 ? str.substring(5) : "";
            if (substring2.startsWith("0")) {
                substring2 = substring2.substring(1);
            }
            if (substring3.startsWith("0")) {
                substring3 = substring3.substring(1);
            }
            if (substring3.isEmpty()) {
                return substring2 + "月";
            }
            return substring2 + "月" + substring3 + "日" + substring;
        }
        substring = str.length() > 3 ? str.substring(3) : "";
        if ("01".equals(substring2)) {
            str2 = b;
        } else if ("02".equals(substring2)) {
            str2 = c;
        } else if ("03".equals(substring2)) {
            str2 = f6735d;
        } else if ("04".equals(substring2)) {
            str2 = f6736e;
        } else if ("05".equals(substring2)) {
            str2 = f6737f;
        } else if ("06".equals(substring2)) {
            str2 = f6738g;
        } else if ("07".equals(substring2)) {
            str2 = f6739h;
        } else if ("08".equals(substring2)) {
            str2 = f6740i;
        } else if ("09".equals(substring2)) {
            str2 = f6741j;
        } else if (Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(substring2)) {
            str2 = f6742k;
        } else if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(substring2)) {
            str2 = f6743l;
        } else if (Constants.VIA_REPORT_TYPE_SET_AVATAR.equals(substring2)) {
            str2 = m;
        } else {
            str2 = substring2 + " ";
        }
        return str2 + substring;
    }

    public String b(String str) {
        String str2;
        String substring = str.substring(0, 4);
        String substring2 = str.substring(5, 7);
        String substring3 = str.length() > 8 ? str.substring(8, 10) : "";
        String substring4 = str.length() > 10 ? str.substring(10) : "";
        if (this.a) {
            if (substring2.startsWith("0")) {
                substring2 = substring2.substring(1);
            }
            if (substring3.startsWith("0")) {
                substring3 = substring3.substring(1);
            }
            if (substring3.isEmpty()) {
                return substring + "年" + substring2 + "月";
            }
            return substring + "年" + substring2 + "月" + substring3 + "日" + substring4;
        }
        if ("01".equals(substring2)) {
            str2 = b;
        } else if ("02".equals(substring2)) {
            str2 = c;
        } else if ("03".equals(substring2)) {
            str2 = f6735d;
        } else if ("04".equals(substring2)) {
            str2 = f6736e;
        } else if ("05".equals(substring2)) {
            str2 = f6737f;
        } else if ("06".equals(substring2)) {
            str2 = f6738g;
        } else if ("07".equals(substring2)) {
            str2 = f6739h;
        } else if ("08".equals(substring2)) {
            str2 = f6740i;
        } else if ("09".equals(substring2)) {
            str2 = f6741j;
        } else if (Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(substring2)) {
            str2 = f6742k;
        } else if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(substring2)) {
            str2 = f6743l;
        } else if (Constants.VIA_REPORT_TYPE_SET_AVATAR.equals(substring2)) {
            str2 = m;
        } else {
            str2 = substring2 + " ";
        }
        if (substring3.isEmpty()) {
            return str2 + ", " + substring + substring4;
        }
        return str2 + substring3 + ", " + substring + substring4;
    }
}
