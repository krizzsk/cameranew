package us.pinguo.camera360.shop.data.install;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import us.pinguo.camera360.shop.data.install.table.ItemTable1;
/* compiled from: ItemInstaller1.java */
/* loaded from: classes3.dex */
public class r extends f<ItemTable1> {
    @Override // us.pinguo.camera360.shop.data.install.f
    protected Class a() throws ClassNotFoundException {
        return com.google.gson.t.a.get(((ParameterizedType) r.class.getGenericSuperclass()).getActualTypeArguments()[0]).getRawType();
    }

    @Override // us.pinguo.camera360.shop.data.install.f
    public void b(List<ItemTable1> list) {
    }
}
