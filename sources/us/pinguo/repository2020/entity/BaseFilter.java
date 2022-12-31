package us.pinguo.repository2020.entity;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
import java.net.URI;
import java.util.Locale;
import kotlin.jvm.internal.s;
import kotlin.text.t;
import kotlinx.coroutines.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.filter.util.a;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.p;
import us.pinguo.repository2020.utils.NameHelper;
/* compiled from: BaseFilter.kt */
/* loaded from: classes6.dex */
public abstract class BaseFilter {
    private final int camera_support;
    private final int enableGesture;
    private final FilterItemTable mItemBean;
    private final NameHelper mNameHelper;
    private int opacity;
    private int templateOpacity;
    private final int unity_engine_filter;

    public BaseFilter(FilterItemTable mItemBean) {
        s.h(mItemBean, "mItemBean");
        this.mItemBean = mItemBean;
        this.mNameHelper = new NameHelper(mItemBean.getNamejson());
        Integer unity_engine_filter = mItemBean.getUnity_engine_filter();
        this.unity_engine_filter = unity_engine_filter == null ? 0 : unity_engine_filter.intValue();
        Integer camera_support = mItemBean.getCamera_support();
        this.camera_support = camera_support == null ? 1 : camera_support.intValue();
        Integer enableGesture = mItemBean.getEnableGesture();
        this.enableGesture = enableGesture != null ? enableGesture.intValue() : 0;
        this.opacity = -1;
        this.templateOpacity = -1;
    }

    public final void collect(boolean z) {
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
        if (obj == null || !(obj instanceof BaseFilter) || getFilterId() == null) {
            return false;
        }
        return s.c(getFilterId(), ((BaseFilter) obj).getFilterId());
    }

    public final int getCamera_support() {
        return this.camera_support;
    }

    public final long getCollectTime() {
        Long collectTime = this.mItemBean.getCollectTime();
        s.e(collectTime);
        return collectTime.longValue();
    }

    public final int getEnableGesture() {
        return this.enableGesture;
    }

    public final String getFilterIcon() {
        boolean x;
        boolean x2;
        boolean x3;
        boolean x4;
        if (TextUtils.isEmpty(this.mItemBean.getIcon())) {
            return "";
        }
        String icon = this.mItemBean.getIcon();
        s.e(icon);
        x = t.x(icon, InspirePublishFragment.FILE_HEADER, false, 2, null);
        if (!x) {
            String icon2 = this.mItemBean.getIcon();
            s.e(icon2);
            x2 = t.x(icon2, "assets://", false, 2, null);
            if (!x2) {
                String icon3 = this.mItemBean.getIcon();
                s.e(icon3);
                x3 = t.x(icon3, Constants.HTTP_PROTOCOL_PREFIX, false, 2, null);
                if (!x3) {
                    String icon4 = this.mItemBean.getIcon();
                    s.e(icon4);
                    x4 = t.x(icon4, Constants.HTTPS_PROTOCOL_PREFIX, false, 2, null);
                    if (!x4) {
                        String icon5 = this.mItemBean.getIcon();
                        s.e(icon5);
                        if (icon5.charAt(0) == '/') {
                            String icon6 = this.mItemBean.getIcon();
                            s.e(icon6);
                            return s.q(InspirePublishFragment.FILE_HEADER, icon6);
                        }
                        String str = InspirePublishFragment.FILE_HEADER + a.a.c() + ((Object) this.mItemBean.getIcon());
                        if (!p.a.a().containsKey(this.mItemBean.getId()) || new File(URI.create(str)).exists()) {
                            return str;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("assets://builtin_data/filters/");
                        sb.append((Object) this.mItemBean.getPackageId());
                        String str2 = File.separator;
                        sb.append((Object) str2);
                        sb.append((Object) this.mItemBean.getId());
                        sb.append((Object) str2);
                        sb.append("icon.jpg");
                        return sb.toString();
                    }
                }
            }
        }
        String icon7 = this.mItemBean.getIcon();
        s.e(icon7);
        return icon7;
    }

    public final String getFilterId() {
        return this.mItemBean.getId();
    }

    public abstract String getFilterKey();

    public final String getFilterName() {
        return getName();
    }

    public final FilterConstants.FilterType getFilterType() {
        FilterConstants.FilterType.a aVar = FilterConstants.FilterType.Companion;
        String type = this.mItemBean.getType();
        s.e(type);
        return aVar.b(type);
    }

    public final int getIndexInPackage() {
        Integer sortInPackage = this.mItemBean.getSortInPackage();
        s.e(sortInPackage);
        return sortInPackage.intValue();
    }

    public final FilterItemTable getItemBean() {
        return this.mItemBean;
    }

    public final String getName() {
        String a = this.mNameHelper.a(Locale.getDefault());
        s.g(a, "mNameHelper.getNameByLocal(Locale.getDefault())");
        return a;
    }

    public final String getNameCN() {
        String a = this.mNameHelper.a(Locale.CHINA);
        s.g(a, "mNameHelper.getNameByLocal(Locale.CHINA)");
        return a;
    }

    public final int getOpacity() {
        return getItemBean().getOpacity();
    }

    public final String getPackageId() {
        return this.mItemBean.getPackageId();
    }

    public final String getPackageMd5() {
        return this.mItemBean.getPackageMd5();
    }

    public final int getSortInPackage() {
        Integer sortInPackage = this.mItemBean.getSortInPackage();
        s.e(sortInPackage);
        return sortInPackage.intValue();
    }

    public final int getTemplateOpacity() {
        return this.templateOpacity;
    }

    public final int getUnity_engine_filter() {
        return this.unity_engine_filter;
    }

    public final boolean hasMusic() {
        Integer hasMusic = this.mItemBean.getHasMusic();
        return hasMusic == null || hasMusic.intValue() != 0;
    }

    public int hashCode() {
        String filterId = getFilterId();
        if (filterId == null) {
            return 0;
        }
        return filterId.hashCode();
    }

    public final boolean isCollect() {
        Integer isCollect = this.mItemBean.isCollect();
        return isCollect == null || isCollect.intValue() != 0;
    }

    public final void setCollectTime(long j2) {
        this.mItemBean.setCollectTime(Long.valueOf(j2));
    }

    public final void setOpacity(int i2) {
        this.opacity = i2;
        getItemBean().setOpacity(i2);
        j.d(n0.a(z0.a()), null, null, new BaseFilter$opacity$1(this, null), 3, null);
    }

    public final void setOpacityOnlyMemory(int i2) {
        getItemBean().setOpacity(i2);
    }

    public final void setTemplateOpacity(int i2) {
        this.templateOpacity = i2;
    }

    public String toString() {
        return getName();
    }
}
