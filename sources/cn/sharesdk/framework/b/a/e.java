package cn.sharesdk.framework.b.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;
/* compiled from: SharePrefrenceUtil.java */
/* loaded from: classes.dex */
public class e {
    private static e b;
    private SharePrefrenceHelper a;

    private e() {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.a = sharePrefrenceHelper;
        sharePrefrenceHelper.open("share_sdk", 1);
    }

    public static e a() {
        if (b == null) {
            b = new e();
        }
        return b;
    }

    public long b() {
        return this.a.getLong("service_time");
    }

    public boolean c() {
        String string = this.a.getString("upload_device_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean d() {
        String string = this.a.getString("upload_user_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean e() {
        String string = this.a.getString("trans_short_link");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public int f() {
        String string = this.a.getString("upload_share_content");
        if ("true".equals(string)) {
            return 1;
        }
        return "false".equals(string) ? -1 : 0;
    }

    public boolean g() {
        String string = this.a.getString("open_login_plus");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean h() {
        String string = this.a.getString("open_sina_link_card");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public String i() {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        return sharePrefrenceHelper.getString("buffered_snsconf_" + MobSDK.getAppkey());
    }

    public Long j() {
        return Long.valueOf(this.a.getLong("device_time"));
    }

    public boolean k() {
        return this.a.getBoolean("connect_server");
    }

    public Long l() {
        return Long.valueOf(this.a.getLong("connect_server_time"));
    }

    public boolean m() {
        return this.a.getBoolean("sns_info_buffered");
    }

    public void b(String str) {
        this.a.putString("upload_device_info", str);
    }

    public long i(String str) {
        return this.a.getLong(str);
    }

    public int j(String str) {
        return this.a.getInt(str);
    }

    public Object k(String str) {
        return this.a.get(str);
    }

    public void b(boolean z) {
        this.a.putBoolean("no_use_gpp", Boolean.valueOf(z));
    }

    public void a(String str) {
        this.a.putString("trans_short_link", str);
    }

    public void b(long j2) {
        this.a.putLong("connect_server_time", Long.valueOf(j2));
    }

    public void c(String str) {
        this.a.putString("upload_user_info", str);
    }

    public void d(String str) {
        this.a.putString("upload_share_content", str);
    }

    public void e(String str) {
        this.a.putString("open_login_plus", str);
    }

    public void f(String str) {
        this.a.putString("open_sina_link_card", str);
    }

    public void g(String str) {
        SharePrefrenceHelper sharePrefrenceHelper = this.a;
        sharePrefrenceHelper.putString("buffered_snsconf_" + MobSDK.getAppkey(), str);
    }

    public boolean h(String str) {
        return this.a.getBoolean(str);
    }

    public void a(boolean z) {
        this.a.putBoolean("gpp_ver_sent", Boolean.valueOf(z));
    }

    public void c(boolean z) {
        this.a.putBoolean("connect_server", Boolean.valueOf(z));
    }

    public void d(boolean z) {
        this.a.putBoolean("sns_info_buffered", Boolean.valueOf(z));
    }

    public void a(long j2) {
        this.a.putLong("device_time", Long.valueOf(j2));
    }

    public void a(String str, Long l2) {
        this.a.putLong(str, l2);
    }

    public void a(String str, int i2) {
        this.a.putInt(str, Integer.valueOf(i2));
    }

    public void a(String str, Object obj) {
        this.a.put(str, obj);
    }
}
