package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import us.pinguo.foundation.utils.m0;
/* compiled from: EffectPackageUpdateInstallTask.java */
/* loaded from: classes3.dex */
public class j extends l {
    public j(k kVar, p pVar) {
        super(kVar, pVar);
        us.pinguo.common.log.a.c("EffectPackageUpdateInstallTask", new Object[0]);
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected o B() {
        return new h();
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected o C() {
        return new r();
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected q D() {
        try {
            if (!TextUtils.isEmpty(this.c.getDisplayZipMd5()) && !TextUtils.isEmpty(this.c.getPackageZipMd5())) {
                String c = t.c(this.c.getDisplayZipMd5());
                String c2 = t.c(this.c.getPackageZipMd5());
                if (!new File(c).exists()) {
                    us.pinguo.util.l.f(c);
                    m0.c(this.f9602e, c);
                    publishProgress(92);
                }
                if (new File(c2).exists()) {
                    return null;
                }
                us.pinguo.util.l.f(c2);
                m0.c(this.f9601d, c2);
                publishProgress(95);
                return null;
            }
            us.pinguo.common.log.a.e("package md5 is empty", new Object[0]);
            throw new IOException("package md5 is empty");
        } catch (IOException e2) {
            e2.printStackTrace();
            return new q(this.b.b(), false, 6, e2);
        }
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected ShowDetail w() throws Exception {
        return us.pinguo.camera360.shop.data.show.u.b().g(this.b.b());
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected void z(String str, String str2) throws Exception {
    }
}
