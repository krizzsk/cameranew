package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: FilterDetailResponse.kt */
/* loaded from: classes6.dex */
public final class FilterDetailResponse implements NoProguard {
    private final FilterDetailData[] data;
    private final String message;
    private final Integer status;

    public FilterDetailResponse(Integer num, String str, FilterDetailData[] filterDetailDataArr) {
        this.status = num;
        this.message = str;
        this.data = filterDetailDataArr;
    }

    public static /* synthetic */ FilterDetailResponse copy$default(FilterDetailResponse filterDetailResponse, Integer num, String str, FilterDetailData[] filterDetailDataArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = filterDetailResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = filterDetailResponse.message;
        }
        if ((i2 & 4) != 0) {
            filterDetailDataArr = filterDetailResponse.data;
        }
        return filterDetailResponse.copy(num, str, filterDetailDataArr);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final FilterDetailData[] component3() {
        return this.data;
    }

    public final FilterDetailResponse copy(Integer num, String str, FilterDetailData[] filterDetailDataArr) {
        return new FilterDetailResponse(num, str, filterDetailDataArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(FilterDetailResponse.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.FilterDetailResponse");
            FilterDetailResponse filterDetailResponse = (FilterDetailResponse) obj;
            if (s.c(this.status, filterDetailResponse.status) && s.c(this.message, filterDetailResponse.message)) {
                FilterDetailData[] filterDetailDataArr = this.data;
                if (filterDetailDataArr != null) {
                    FilterDetailData[] filterDetailDataArr2 = filterDetailResponse.data;
                    if (filterDetailDataArr2 == null || !Arrays.equals(filterDetailDataArr, filterDetailDataArr2)) {
                        return false;
                    }
                } else if (filterDetailResponse.data != null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final FilterDetailData[] getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.status;
        int intValue = (num == null ? 0 : num.intValue()) * 31;
        String str = this.message;
        int hashCode = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        FilterDetailData[] filterDetailDataArr = this.data;
        return hashCode + (filterDetailDataArr != null ? Arrays.hashCode(filterDetailDataArr) : 0);
    }

    public String toString() {
        return "FilterDetailResponse(status=" + this.status + ", message=" + ((Object) this.message) + ", data=" + Arrays.toString(this.data) + ')';
    }
}
