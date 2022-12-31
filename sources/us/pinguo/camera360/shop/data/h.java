package us.pinguo.camera360.shop.data;

import androidx.annotation.NonNull;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import vStudio.Android.Camera360.R;
/* compiled from: FilterPackage.java */
/* loaded from: classes2.dex */
public class h {
    private List<g> a = null;
    private FilterPackageTable b;
    private NameHelper c;

    /* renamed from: d  reason: collision with root package name */
    public long f9594d;

    public h(FilterPackageTable filterPackageTable) {
        this.b = filterPackageTable;
        this.c = new NameHelper(filterPackageTable.getNamejson());
    }

    private String e() {
        if (!this.b.getIcon().startsWith(InspirePublishFragment.FILE_HEADER) && !this.b.getIcon().startsWith("assets://") && !this.b.getIcon().startsWith("asset://") && !this.b.getIcon().startsWith(Constants.HTTP_PROTOCOL_PREFIX) && !this.b.getIcon().startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            if (this.b.getIcon().charAt(0) == '/') {
                return InspirePublishFragment.FILE_HEADER + this.b.getIcon();
            }
            String str = InspirePublishFragment.FILE_HEADER + t.b + this.b.getIcon();
            if (!us.pinguo.camera360.shop.h.a.b().containsKey(this.b.getId()) || new File(URI.create(str)).exists()) {
                return str;
            }
            return "assets://builtin_data/filters/" + this.b.getId() + File.separator + "icon.jpg";
        }
        return this.b.getIcon();
    }

    public List<g> a() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            g gVar = this.a.get(i2);
            if (gVar.isCollect()) {
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    public h b(@NonNull FilterType... filterTypeArr) {
        if (this.a == null || filterTypeArr.length == 0) {
            return this;
        }
        for (FilterType filterType : filterTypeArr) {
            if (filterType == FilterType.Combin) {
                return this;
            }
        }
        h hVar = new h(this.b);
        hVar.a = c(filterTypeArr);
        return hVar;
    }

    public List<g> c(@NonNull FilterType... filterTypeArr) {
        List<g> list = this.a;
        if (list == null) {
            return new ArrayList();
        }
        if (filterTypeArr.length == 0) {
            return list;
        }
        for (FilterType filterType : filterTypeArr) {
            if (filterType == FilterType.Combin) {
                return this.a;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (g gVar : this.a) {
            FilterType fliterType = gVar.getFliterType();
            for (FilterType filterType2 : filterTypeArr) {
                if (filterType2 == fliterType) {
                    arrayList.add(gVar);
                }
            }
        }
        us.pinguo.common.log.a.c("filterList.size:" + arrayList.size(), new Object[0]);
        return arrayList;
    }

    @NonNull
    public String d() {
        String e2 = e();
        if (e2.startsWith(InspirePublishFragment.FILE_HEADER)) {
            String trim = e2.substring(7).trim();
            if (trim.endsWith(".png") || trim.endsWith(".jpg")) {
                String str = trim.substring(0, trim.length() - 4) + "_online";
                if (new File(str).exists()) {
                    return InspirePublishFragment.FILE_HEADER + str;
                }
                return e2;
            }
            return e2;
        }
        return e2;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof h) && i().getId().equals(((h) obj).i().getId());
    }

    @NonNull
    public String f() {
        return this.b.getId();
    }

    @NonNull
    public String g() {
        if ("collect_filter_package".equals(this.b.getId())) {
            return BaseApplication.d().getString(R.string.filter_collect);
        }
        return this.c.a(Locale.getDefault());
    }

    @NonNull
    public String h() {
        if ("collect_filter_package".equals(this.b.getId())) {
            return BaseApplication.d().getString(R.string.filter_collect);
        }
        return this.c.a(Locale.CHINA);
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{i().getId()});
    }

    public FilterPackageTable i() {
        return this.b;
    }

    public boolean j() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).isCollect()) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        return "true".equals(i().getTemp1());
    }

    public void l(List<g> list) {
        this.a = list;
    }

    public void m(String str) {
        this.b.setIcon(str);
    }

    public String toString() {
        return g();
    }
}
