package com.pinguo.camera360.effect.model.entity.type;

import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.List;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* loaded from: classes3.dex */
public class Filter extends Effect {
    public static final String PARAM_KEY_OPACITY = "EffectOpacity";
    private static final String TAG = Filter.class.getSimpleName();

    public Filter(FilterItemTable filterItemTable, FilterParamsTable filterParamsTable) {
        super(filterItemTable, filterParamsTable);
    }

    @Override // com.pinguo.camera360.effect.model.entity.Effect
    public Object clone() throws CloneNotSupportedException {
        Filter filter;
        try {
            filter = (Filter) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            filter = null;
        }
        return filter != null ? filter : new Filter(getItemBean(), getBean(Effect.Version.latest));
    }

    public Filter(FilterItemTable filterItemTable, List<FilterParamsTable> list) {
        super(filterItemTable, list);
    }
}
