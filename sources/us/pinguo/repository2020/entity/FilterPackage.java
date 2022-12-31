package us.pinguo.repository2020.entity;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.collections.c0;
import kotlin.jvm.internal.s;
import kotlin.text.t;
import us.pinguo.common.filter.util.a;
import us.pinguo.foundation.e;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.p;
import us.pinguo.repository2020.utils.NameHelper;
/* compiled from: FilterPackage.kt */
/* loaded from: classes6.dex */
public final class FilterPackage {
    private final Integer camera_support;
    private List<BaseFilter> mFilters;
    private final NameHelper mNameHelper;
    private long maxCollectTime;
    private final FilterPackageTable packageBean;
    private final Integer unity_engine_filter;

    public FilterPackage(FilterPackageTable packageBean) {
        s.h(packageBean, "packageBean");
        this.packageBean = packageBean;
        this.mNameHelper = new NameHelper(packageBean.getNamejson());
        this.unity_engine_filter = packageBean.getUnity_engine_filter();
        this.camera_support = packageBean.getCamera_support();
    }

    private final String getIconInner() {
        boolean x;
        boolean x2;
        boolean x3;
        boolean x4;
        String icon = this.packageBean.getIcon();
        s.e(icon);
        x = t.x(icon, InspirePublishFragment.FILE_HEADER, false, 2, null);
        if (!x) {
            String icon2 = this.packageBean.getIcon();
            s.e(icon2);
            x2 = t.x(icon2, "assets://", false, 2, null);
            if (!x2) {
                String icon3 = this.packageBean.getIcon();
                s.e(icon3);
                x3 = t.x(icon3, Constants.HTTP_PROTOCOL_PREFIX, false, 2, null);
                if (!x3) {
                    String icon4 = this.packageBean.getIcon();
                    s.e(icon4);
                    x4 = t.x(icon4, Constants.HTTPS_PROTOCOL_PREFIX, false, 2, null);
                    if (!x4) {
                        String icon5 = this.packageBean.getIcon();
                        s.e(icon5);
                        if (icon5.charAt(0) == '/') {
                            String icon6 = this.packageBean.getIcon();
                            s.e(icon6);
                            return s.q(InspirePublishFragment.FILE_HEADER, icon6);
                        }
                        String str = InspirePublishFragment.FILE_HEADER + a.a.c() + ((Object) this.packageBean.getIcon());
                        if (!p.a.b().containsKey(this.packageBean.getId()) || new File(URI.create(str)).exists()) {
                            return str;
                        }
                        return "assets://builtin_data/filters/" + this.packageBean.getId() + ((Object) File.separator) + "icon.jpg";
                    }
                }
            }
        }
        String icon7 = this.packageBean.getIcon();
        s.e(icon7);
        return icon7;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof FilterPackage)) {
            return s.c(this.packageBean.getId(), ((FilterPackage) obj).packageBean.getId());
        }
        return false;
    }

    public final Integer getCamera_support() {
        return this.camera_support;
    }

    public final String getCategoryId() {
        return this.packageBean.getCategoryId();
    }

    public final BaseFilter getFilterById(String filterId) {
        s.h(filterId, "filterId");
        if (TextUtils.isEmpty(filterId)) {
            return null;
        }
        List<BaseFilter> list = this.mFilters;
        s.e(list);
        for (BaseFilter baseFilter : list) {
            if (s.c(filterId, baseFilter.getFilterId())) {
                return baseFilter;
            }
        }
        return null;
    }

    public final FilterPackage getFilterPackage(FilterConstants.FilterType... filterType) {
        s.h(filterType, "filterType");
        if (this.mFilters != null) {
            int i2 = 0;
            if (!(filterType.length == 0)) {
                int length = filterType.length;
                while (i2 < length) {
                    FilterConstants.FilterType filterType2 = filterType[i2];
                    i2++;
                    if (filterType2 == FilterConstants.FilterType.Combin) {
                        return this;
                    }
                }
                FilterPackage filterPackage = new FilterPackage(this.packageBean);
                filterPackage.mFilters = getFilters((FilterConstants.FilterType[]) Arrays.copyOf(filterType, filterType.length));
                return filterPackage;
            }
        }
        return this;
    }

    public final BaseFilter getFilterWithoutNone(String filterId) {
        s.h(filterId, "filterId");
        if (TextUtils.isEmpty(filterId)) {
            return null;
        }
        List<BaseFilter> list = this.mFilters;
        s.e(list);
        for (BaseFilter baseFilter : list) {
            if (s.c(filterId, baseFilter.getFilterId())) {
                return baseFilter;
            }
        }
        return null;
    }

    public final List<BaseFilter> getFilters(FilterConstants.FilterType... filterTypes) {
        s.h(filterTypes, "filterTypes");
        List<BaseFilter> list = this.mFilters;
        if (list == null) {
            return new ArrayList();
        }
        if (filterTypes.length == 0) {
            s.e(list);
            return list;
        }
        int length = filterTypes.length;
        int i2 = 0;
        while (i2 < length) {
            FilterConstants.FilterType filterType = filterTypes[i2];
            i2++;
            if (filterType == FilterConstants.FilterType.Combin) {
                List<BaseFilter> list2 = this.mFilters;
                s.e(list2);
                return list2;
            }
        }
        ArrayList arrayList = new ArrayList();
        List<BaseFilter> list3 = this.mFilters;
        s.e(list3);
        for (BaseFilter baseFilter : list3) {
            FilterConstants.FilterType filterType2 = baseFilter.getFilterType();
            int length2 = filterTypes.length;
            int i3 = 0;
            while (i3 < length2) {
                FilterConstants.FilterType filterType3 = filterTypes[i3];
                i3++;
                if (filterType3 == filterType2) {
                    arrayList.add(baseFilter);
                }
            }
        }
        us.pinguo.common.log.a.c(s.q("filterList.size:", Integer.valueOf(arrayList.size())), new Object[0]);
        return arrayList;
    }

    public final String getIcon() {
        boolean x;
        boolean m;
        boolean m2;
        String iconInner = getIconInner();
        x = t.x(iconInner, InspirePublishFragment.FILE_HEADER, false, 2, null);
        if (x) {
            String substring = iconInner.substring(7);
            s.g(substring, "this as java.lang.String).substring(startIndex)");
            int length = substring.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = s.j(substring.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            String obj = substring.subSequence(i2, length + 1).toString();
            m = t.m(obj, ".png", false, 2, null);
            if (!m) {
                m2 = t.m(obj, ".jpg", false, 2, null);
                if (!m2) {
                    return iconInner;
                }
            }
            String substring2 = obj.substring(0, obj.length() - 4);
            s.g(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            String q = s.q(substring2, "_online");
            return new File(q).exists() ? s.q(InspirePublishFragment.FILE_HEADER, q) : iconInner;
        }
        return iconInner;
    }

    public final String getKey() {
        return this.packageBean.getId();
    }

    public final long getMaxCollectTime() {
        return this.maxCollectTime;
    }

    public final String getName() {
        if (s.c("collect_filter_package", this.packageBean.getId())) {
            String string = e.b().getString(R.string.filter_collect);
            s.g(string, "{\n            Foundation…filter_collect)\n        }");
            return string;
        }
        String a = this.mNameHelper.a(Locale.getDefault());
        s.g(a, "{\n            mNameHelpe…e.getDefault())\n        }");
        return a;
    }

    public final String getNameCN() {
        if (s.c("collect_filter_package", this.packageBean.getId())) {
            String string = e.b().getString(R.string.filter_collect);
            s.g(string, "{\n            Foundation…filter_collect)\n        }");
            return string;
        }
        String a = this.mNameHelper.a(Locale.CHINA);
        s.g(a, "{\n            mNameHelpe…l(Locale.CHINA)\n        }");
        return a;
    }

    public final FilterPackageTable getPackageBean() {
        return this.packageBean;
    }

    public final FilterConstants.FilterType getPackageFilterType() {
        FilterConstants.FilterType.a aVar = FilterConstants.FilterType.Companion;
        String filterType = this.packageBean.getFilterType();
        s.e(filterType);
        return aVar.a(filterType);
    }

    public final String getSubType() {
        return this.packageBean.getSubType();
    }

    public final Integer getUnity_engine_filter() {
        return this.unity_engine_filter;
    }

    public final int getVip() {
        Integer vip = this.packageBean.getVip();
        if (vip == null) {
            return 0;
        }
        return vip.intValue();
    }

    public final boolean hasFilter(String filterId) {
        s.h(filterId, "filterId");
        if (TextUtils.isEmpty(filterId)) {
            return false;
        }
        List<BaseFilter> list = this.mFilters;
        s.e(list);
        for (BaseFilter baseFilter : list) {
            if (s.c(filterId, baseFilter.getFilterId())) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasUpdate() {
        return s.c("true", this.packageBean.getTemp1());
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.packageBean.getId()});
    }

    public final boolean isEmpty() {
        List<BaseFilter> list = this.mFilters;
        if (list != null) {
            s.e(list);
            if (!list.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final void setFilters(List<? extends BaseFilter> list) {
        this.mFilters = list == null ? null : c0.W(list);
    }

    public final void setMaxCollectTime(long j2) {
        this.maxCollectTime = j2;
    }

    public String toString() {
        return getName();
    }
}
