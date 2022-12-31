package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* compiled from: Filter.kt */
/* loaded from: classes6.dex */
public final class Filter extends Effect {
    public static final Companion Companion = new Companion(null);
    private static final String PARAM_KEY_OPACITY = "EffectOpacity";
    private static final String TAG = Filter.class.getSimpleName();

    /* compiled from: Filter.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final String getPARAM_KEY_OPACITY() {
            return Filter.PARAM_KEY_OPACITY;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Filter(FilterItemTable itemBean, FilterParamsTable bean) {
        super(itemBean, bean);
        s.h(itemBean, "itemBean");
        s.h(bean, "bean");
    }

    @Override // us.pinguo.repository2020.entity.Effect
    public Object clone() {
        return super.clone();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Filter(FilterItemTable itemBean, List<FilterParamsTable> beans) {
        super(itemBean, beans);
        s.h(itemBean, "itemBean");
        s.h(beans, "beans");
    }
}
