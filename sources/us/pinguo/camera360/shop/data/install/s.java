package us.pinguo.camera360.shop.data.install;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import us.pinguo.repository2020.database.filter.FilterItemTable;
/* compiled from: ItemInstaller.java */
/* loaded from: classes3.dex */
public class s extends f<FilterItemTable> {
    @Override // us.pinguo.camera360.shop.data.install.f
    protected Class a() throws ClassNotFoundException {
        return com.google.gson.t.a.get(((ParameterizedType) s.class.getGenericSuperclass()).getActualTypeArguments()[0]).getRawType();
    }

    @Override // us.pinguo.camera360.shop.data.install.f
    public void b(List<FilterItemTable> list) {
        us.pinguo.repository2020.database.a.a.w().b(list);
    }
}
