package us.pinguo.camera360.shop.data;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
import java.net.URI;
import java.util.Arrays;
import java.util.Locale;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.repository2020.database.filter.FilterItemTable;
/* compiled from: BaseFilter.java */
/* loaded from: classes2.dex */
public abstract class g {
    private FilterItemTable mItemBean;
    private NameHelper mNameHelper;

    public g(FilterItemTable filterItemTable) {
        this.mNameHelper = null;
        this.mItemBean = filterItemTable;
        this.mNameHelper = new NameHelper(filterItemTable.getNamejson());
    }

    public void collect(boolean z) {
        if (z) {
            this.mItemBean.setCollect(1);
        } else {
            this.mItemBean.setCollect(0);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g) || getFilterId() == null) {
            return false;
        }
        return getFilterId().equals(((g) obj).getFilterId());
    }

    public long getCollectTime() {
        if (this.mItemBean.getCollectTime() == null) {
            return 0L;
        }
        return this.mItemBean.getCollectTime().longValue();
    }

    public String getFilterIcon() {
        if (TextUtils.isEmpty(this.mItemBean.getIcon())) {
            return "";
        }
        if (!this.mItemBean.getIcon().startsWith(InspirePublishFragment.FILE_HEADER) && !this.mItemBean.getIcon().startsWith("assets://") && !this.mItemBean.getIcon().startsWith(Constants.HTTP_PROTOCOL_PREFIX) && !this.mItemBean.getIcon().startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            if (this.mItemBean.getIcon().charAt(0) == '/') {
                return InspirePublishFragment.FILE_HEADER + this.mItemBean.getIcon();
            }
            String str = InspirePublishFragment.FILE_HEADER + t.b + this.mItemBean.getIcon();
            if (!us.pinguo.camera360.shop.h.a.a().containsKey(this.mItemBean.getId()) || new File(URI.create(str)).exists()) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("assets://builtin_data/filters/");
            sb.append(this.mItemBean.getPackageId());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(this.mItemBean.getId());
            sb.append(str2);
            sb.append("icon.jpg");
            return sb.toString();
        }
        return this.mItemBean.getIcon();
    }

    public String getFilterId() {
        return this.mItemBean.getId();
    }

    public abstract String getFilterKey();

    public String getFilterName() {
        return getName();
    }

    public FilterType getFliterType() {
        return FilterType.getFliterTypeBySubt(this.mItemBean.getType());
    }

    public int getIndexInPackage() {
        return this.mItemBean.getSortInPackage().intValue();
    }

    public FilterItemTable getItemBean() {
        return this.mItemBean;
    }

    public String getName() {
        return this.mNameHelper.a(Locale.getDefault());
    }

    public String getNameCN() {
        return this.mNameHelper.a(Locale.CHINA);
    }

    public String getPackageId() {
        return this.mItemBean.getPackageId();
    }

    public String getPackageMd5() {
        return this.mItemBean.getPackageMd5();
    }

    public int getSortInPackage() {
        if (this.mItemBean.getSortInPackage() == null) {
            return 0;
        }
        return this.mItemBean.getSortInPackage().intValue();
    }

    public boolean hasMusic() {
        return this.mItemBean.getHasMusic().intValue() != 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{getFilterId()});
    }

    public boolean isCollect() {
        return this.mItemBean.isCollect().intValue() != 0;
    }

    public int isUnityFilter() {
        return this.mItemBean.getUnity_engine_filter().intValue();
    }

    public void setCollectTime(long j2) {
        this.mItemBean.setCollectTime(Long.valueOf(j2));
    }

    public int supportCamera() {
        return this.mItemBean.getCamera_support().intValue();
    }

    public String toString() {
        return getName();
    }
}
