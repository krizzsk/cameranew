package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.camera360.shop.download.RequestIntervalPref;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.u0;
/* compiled from: ShaderInstallTask.java */
/* loaded from: classes3.dex */
public abstract class v extends AsyncTask<Void, Void, u> {
    private static final String a = u0.b + "/download/guid/2960de4668ac4413abac9d869b2c";
    private static boolean b = false;

    private boolean b(String str, int i2, int i3, String str2) {
        if (i2 <= Math.max(us.pinguo.foundation.j.e().h(), 97)) {
            return true;
        }
        return p(str, str2);
    }

    private File c() {
        return new File((BaseApplication.d().getFilesDir().getAbsolutePath() + "/effect/installed/") + "/shader/frontImage.jpg");
    }

    private String d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=2960de4668ac4413abac9d869b2c");
        return a + "?sig=" + us.pinguo.util.o.d(arrayList, "*jNb29>,1*)4`:\\Bo)023&3MnvQ14Lk@");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f() {
        o(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h() {
        o(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j() {
        o(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l() {
        o(false);
    }

    private boolean m() {
        return RequestIntervalPref.a.e(a, ((long) us.pinguo.foundation.j.e().g()) * 1000, null) != RequestIntervalPref.RefreshType.NONE_REFRESH;
    }

    private boolean p(String str, String str2) {
        File file = new File(BaseApplication.d().getCacheDir(), "frontImage.jpg");
        try {
            try {
                com.pinguo.camera360.h.a.a(str, file, BaseApplication.d().getCacheDir());
                if (Long.toHexString(us.pinguo.util.i.c(file.getAbsolutePath())).equals(str2)) {
                    us.pinguo.util.l.c(file, c());
                    if (file.exists()) {
                        file.delete();
                        return true;
                    }
                    return true;
                }
                if (file.exists()) {
                    file.delete();
                }
                return false;
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                if (file.exists()) {
                    file.delete();
                }
                return false;
            }
        } catch (Throwable th) {
            if (file.exists()) {
                file.delete();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: a */
    public u doInBackground(Void[] voidArr) {
        if (m() && !b) {
            b = true;
            try {
                HttpRequest httpRequest = new HttpRequest(d(), "POST");
                httpRequest.connectTimeout(5000);
                httpRequest.readTimeout(10000);
                if (httpRequest.code() != 200) {
                    us.pinguo.common.log.a.e("FilterPackageInstallTask Shader install request error : " + String.valueOf(httpRequest.code()), new Object[0]);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(httpRequest.body());
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    String string = jSONObject2.getString("url");
                    String string2 = jSONObject2.getString(BigAlbumStore.PhotoColumns.CRC32);
                    int i2 = jSONObject2.getInt("version");
                    int i3 = jSONObject.getInt("status");
                    int i4 = jSONObject2.getInt("intervalTime");
                    if (i3 == 200 && !string.isEmpty() && i2 != 0 && !string2.isEmpty()) {
                        if (b(string, i2, i4, string2)) {
                            u uVar = new u();
                            uVar.a = string2;
                            uVar.b = i2;
                            uVar.c = i4;
                            return uVar;
                        }
                        return null;
                    }
                    if (i3 == 420) {
                        User.E();
                    }
                    return new u();
                } catch (JSONException unused) {
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            } finally {
                b = false;
            }
        }
        return new u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.utils.AsyncTask
    /* renamed from: n */
    public void onPostExecute(u uVar) {
        if (uVar != null) {
            if (TextUtils.isEmpty(uVar.a)) {
                us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.camera360.shop.data.install.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.f();
                    }
                });
                return;
            } else if (!c().exists()) {
                us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.camera360.shop.data.install.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.h();
                    }
                });
                RequestIntervalPref.a.g(a, 0L, null);
                return;
            } else {
                us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
                if (e2 != null) {
                    e2.p(uVar.b);
                    e2.n(uVar.c);
                    e2.s("key_front_image_crc32", uVar.a);
                    e2.o(System.currentTimeMillis() / 1000);
                    e2.a();
                }
                com.pinguo.camera360.m.a.i();
                us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.camera360.shop.data.install.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.this.j();
                    }
                });
                RequestIntervalPref.a.g(a, 0L, null);
                return;
            }
        }
        us.pinguo.foundation.utils.f.b(new Runnable() { // from class: us.pinguo.camera360.shop.data.install.a
            @Override // java.lang.Runnable
            public final void run() {
                v.this.l();
            }
        });
    }

    protected abstract boolean o(boolean z);
}
