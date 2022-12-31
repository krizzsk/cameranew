package us.pinguo.poker;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.matrix.report.Issue;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: AuthInfo.java */
/* loaded from: classes5.dex */
public class j {

    /* renamed from: h  reason: collision with root package name */
    private static j f11738h;
    String a;
    String b;
    int c;

    /* renamed from: d  reason: collision with root package name */
    String f11739d;

    /* renamed from: e  reason: collision with root package name */
    String f11740e;

    /* renamed from: f  reason: collision with root package name */
    int f11741f;

    /* renamed from: g  reason: collision with root package name */
    long f11742g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        f11738h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j b() {
        j jVar = f11738h;
        if (jVar == null) {
            return null;
        }
        if (jVar.c()) {
            return jVar;
        }
        a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j e(JSONObject jSONObject) throws JSONException {
        j jVar = new j();
        jVar.a = jSONObject.optString("url");
        jVar.b = jSONObject.optString("token");
        int optInt = (jSONObject.optInt("expires", 1800) * 5) / 6;
        jVar.c = optInt;
        if (optInt < 10 || optInt >= 259200) {
            jVar.c = PathInterpolatorCompat.MAX_NUM_POINTS;
        }
        jVar.f11739d = jSONObject.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
        jVar.f11740e = jSONObject.optString("req_host");
        long optLong = jSONObject.optLong(Issue.ISSUE_REPORT_TIME, 0L);
        jVar.f11742g = optLong;
        if (optLong == 0) {
            jVar.f11742g = System.currentTimeMillis();
        }
        int optInt2 = jSONObject.optInt("pixel", VideoEdit2Activity.MAX_SCALED_BITRATE) / 10000;
        jVar.f11741f = optInt2;
        if (optInt2 < 10) {
            jVar.f11741f = 100;
        }
        if (jVar.f11741f > 2000) {
            jVar.f11741f = 2000;
        }
        if (jVar.c()) {
            return jVar;
        }
        throw new IllegalArgumentException("error arg:" + jSONObject);
    }

    public boolean c() {
        return !(TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f11740e) || Math.abs(this.f11742g - System.currentTimeMillis()) >= ((long) (this.c * 1000)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f11738h = this;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", this.a);
            jSONObject.put("token", this.b);
            jSONObject.put("expires", this.c);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, this.f11739d);
            jSONObject.put("req_host", this.f11740e);
            jSONObject.put(Issue.ISSUE_REPORT_TIME, this.f11742g);
            jSONObject.put("pixel", this.f11741f * 10000);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
