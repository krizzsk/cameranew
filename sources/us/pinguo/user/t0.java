package us.pinguo.user;

import com.adjust.sdk.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
/* compiled from: PGLoginConstants.java */
/* loaded from: classes6.dex */
public interface t0 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String[] a = {Constants.REFERRER_API_HUAWEI, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "qq", "sina", "facebook", FindFriendHeaderCell.TWITTER};
    public static final String[] b = {ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "qq", "sina", "facebook", FindFriendHeaderCell.TWITTER};
    public static final int[] c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f12373d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f12374e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f12375f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f12376g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f12377h;

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f12378i;

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f12379j;

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f12380k;

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f12381l;
    public static final boolean m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    static {
        int i2 = R.string.site_name_huawei;
        int i3 = R.string.site_name_wechat;
        int i4 = R.string.site_name_qq;
        int i5 = R.string.site_name_sina;
        int i6 = R.string.site_name_facebook;
        int i7 = R.string.site_name_twitter;
        c = new int[]{i2, i3, i4, i5, i6, i7};
        f12373d = new int[]{i3, i4, i5, i6, i7};
        int i8 = R.drawable.pg_third_huawei_normal;
        int i9 = R.drawable.pg_third_wechat_normal;
        int i10 = R.drawable.pg_third_qq_normal;
        int i11 = R.drawable.pg_third_sina_normal;
        int i12 = R.drawable.pg_third_facebook_normal;
        int i13 = R.drawable.pg_third_twitter_normal;
        f12374e = new int[]{i8, i9, i10, i11, i12, i13};
        f12375f = new int[]{i9, i10, i11, i12, i13};
        f12376g = new String[]{Constants.REFERRER_API_HUAWEI, "facebook", FindFriendHeaderCell.TWITTER, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "qq", "sina"};
        f12377h = new String[]{"facebook", FindFriendHeaderCell.TWITTER, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "qq", "sina"};
        f12378i = new int[]{i2, i6, i7, i3, i4, i5};
        f12379j = new int[]{i6, i7, i3, i4, i5};
        f12380k = new int[]{i8, i12, i13, i9, i10, i11};
        f12381l = new int[]{i12, i13, i9, i10, i11};
        boolean z2 = us.pinguo.foundation.d.f10985d;
        m = z2;
        String str = z2 ? "http://itest.camera360.com" : "https://i.camera360.com";
        n = str;
        o = str + "/api/v2/mailLogin";
        p = str + "/api/v2/mobLogin";
        q = str + "/api/v2/mailRegister";
        r = str + "/api/v2/mobRegister";
        s = str + "/api/v2/mobVerify";
        t = str + "/api/v2/refreshToken";
        u = str + "/api/mobile/sendverifycode";
        v = str + "/api/mobile/forgetpassword";
        w = str + "/api/mobile/bindingEmail";
        x = str + "/api/mobile/binding";
        y = str + "/api/mobile/rebind";
        String str2 = str + "/api/mobile/remove";
        r0 = str + "/api/mobile/getCode";
        z = str + "/api/third/login/index";
        String str3 = str + "/api/third/login/binding";
        A = str + "/api/v2/ssoLogin";
        String str4 = str + "/api/third/login/bindingSso";
        B = str + "/api/user/forgetpassword";
        C = str + "/api/user/updateInfo";
        D = str + "/api/third/login/bindingEmail";
        String str5 = str + "/api/user/checkemail";
        String str6 = str + "/api/mobile/check";
        E = str + "/api/v2/changePassword";
        F = str + "/api/user/info";
        G = str + "/api/v2/locationByGeo";
    }
}
