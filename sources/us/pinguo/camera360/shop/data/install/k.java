package us.pinguo.camera360.shop.data.install;

import java.util.Arrays;
import us.pinguo.camera360.shop.data.show.ShowPkg;
/* compiled from: FilterInstallRequest.java */
/* loaded from: classes3.dex */
public class k {
    private final ShowPkg a;
    private final String b = null;

    public k(ShowPkg showPkg) {
        this.a = showPkg;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a.getId();
    }

    public ShowPkg c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof k) && ((k) obj).b().equals(c().getId());
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{c().getId()});
    }
}
