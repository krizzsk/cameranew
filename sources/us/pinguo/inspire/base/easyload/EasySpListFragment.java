package us.pinguo.inspire.base.easyload;

import java.util.HashMap;
import us.pinguo.inspire.base.easyload.j;
/* loaded from: classes9.dex */
public abstract class EasySpListFragment<T extends j> extends EasyListFragment<T> {
    protected static final String SP_NO_MORE_ITEMS = "-1";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected /* bridge */ /* synthetic */ HashMap addParamForPage(Object obj) {
        return addParamForPage((EasySpListFragment<T>) ((j) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public /* bridge */ /* synthetic */ boolean isLoadMoreEnable(Object obj) {
        return isLoadMoreEnable((EasySpListFragment<T>) ((j) obj));
    }

    protected HashMap<String, String> addParamForPage(T t) {
        if (t == null || t.sp == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sp", t.sp);
        return hashMap;
    }

    public boolean isLoadMoreEnable(T t) {
        String str;
        return (t == null || (str = t.sp) == null || str.equals("-1")) ? false : true;
    }
}
