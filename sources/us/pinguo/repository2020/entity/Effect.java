package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* compiled from: Effect.kt */
/* loaded from: classes6.dex */
public class Effect extends BaseFilter implements Comparable<Effect>, Cloneable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Effect(FilterItemTable itemBean, FilterParamsTable effectBean) {
        super(itemBean);
        s.h(itemBean, "itemBean");
        s.h(effectBean, "effectBean");
    }

    public Object clone() {
        return super.clone();
    }

    @Override // us.pinguo.repository2020.entity.BaseFilter
    public String getFilterKey() {
        return "";
    }

    public final String getKey() {
        return "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Effect(FilterItemTable itemBean, List<FilterParamsTable> effectBeans) {
        super(itemBean);
        s.h(itemBean, "itemBean");
        s.h(effectBeans, "effectBeans");
    }

    @Override // java.lang.Comparable
    public int compareTo(Effect other) {
        s.h(other, "other");
        return other.getIndexInPackage() - getIndexInPackage() < 0 ? 1 : -1;
    }
}
