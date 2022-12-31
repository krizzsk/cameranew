package us.pinguo.camera360.shop.data.install;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* compiled from: EffectInstaller.java */
/* loaded from: classes3.dex */
public class i extends BaseEffectInstaller<FilterParamsTable> {
    @Override // us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller
    protected Class getGenericClass() throws ClassNotFoundException {
        return com.google.gson.t.a.get(((ParameterizedType) i.class.getGenericSuperclass()).getActualTypeArguments()[0]).getRawType();
    }

    @Override // us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller
    protected void insert(List<FilterParamsTable> list) {
        us.pinguo.repository2020.database.a.a.y().b(list);
    }
}
