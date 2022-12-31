package us.pinguo.camera360.shop.data.install;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller;
import us.pinguo.camera360.shop.data.install.table.EffectTable1;
/* compiled from: EffectInstaller1.java */
/* loaded from: classes3.dex */
public class h extends BaseEffectInstaller<EffectTable1> {
    @Override // us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller
    protected Class getGenericClass() throws ClassNotFoundException {
        return com.google.gson.t.a.get(((ParameterizedType) h.class.getGenericSuperclass()).getActualTypeArguments()[0]).getRawType();
    }

    @Override // us.pinguo.camera360.shop.data.install.table.BaseEffectInstaller
    protected void insert(List<EffectTable1> list) {
    }
}
