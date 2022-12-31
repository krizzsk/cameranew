package us.pinguo.pgshare.commons;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import us.pinguo.share.core.ShareSite;
/* compiled from: ShareDialogOptions.java */
/* loaded from: classes5.dex */
public class f {
    private Set<ShareSite> a;
    private List<us.pinguo.pgshare.commons.dialog.c> b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.pgshare.commons.a f11636d;

    /* compiled from: ShareDialogOptions.java */
    /* loaded from: classes5.dex */
    public static class b {
        private String c;
        private List<us.pinguo.pgshare.commons.dialog.c> b = new ArrayList();
        private Set<ShareSite> a = new LinkedHashSet();

        /* renamed from: d  reason: collision with root package name */
        private us.pinguo.pgshare.commons.a f11637d = new us.pinguo.pgshare.commons.a();

        public static f i() {
            b bVar = new b();
            bVar.e();
            bVar.k("image/jpeg");
            return bVar.h();
        }

        public b e() {
            if (Locale.getDefault().equals(Locale.SIMPLIFIED_CHINESE)) {
                this.a.add(ShareSite.WECHAT_FRIENDS);
                this.a.add(ShareSite.WECHAT_MOMENTS);
                this.a.add(ShareSite.SINAWEIBO);
                this.a.add(ShareSite.QZONE);
                this.a.add(ShareSite.QQ);
                this.a.add(ShareSite.FACEBOOK);
                this.a.add(ShareSite.INSTAGRAM);
                this.a.add(ShareSite.TWITTER);
            } else {
                this.a.add(ShareSite.FACEBOOK);
                this.a.add(ShareSite.INSTAGRAM);
                this.a.add(ShareSite.TWITTER);
                this.a.add(ShareSite.WECHAT_FRIENDS);
                this.a.add(ShareSite.WECHAT_MOMENTS);
                this.a.add(ShareSite.SINAWEIBO);
                this.a.add(ShareSite.QZONE);
                this.a.add(ShareSite.QQ);
            }
            return this;
        }

        public b f(int i2, int i3, String str) {
            this.b.add(new us.pinguo.pgshare.commons.dialog.c(i2, i3, str));
            return this;
        }

        public b g(ShareSite shareSite) {
            this.a.add(shareSite);
            return this;
        }

        public f h() {
            return new f(this);
        }

        public boolean j() {
            return this.a.size() == 0;
        }

        public b k(String str) {
            this.c = str;
            return this;
        }
    }

    public us.pinguo.pgshare.commons.a a() {
        return this.f11636d;
    }

    public List<us.pinguo.pgshare.commons.dialog.c> b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Set<ShareSite> d() {
        return this.a;
    }

    private f(b bVar) {
        this.a = bVar.a;
        this.c = bVar.c;
        this.f11636d = bVar.f11637d;
        this.b = bVar.b;
    }
}
