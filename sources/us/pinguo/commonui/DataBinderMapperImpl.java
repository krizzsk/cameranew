package us.pinguo.commonui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.commonui.b.d;
import us.pinguo.commonui.b.f;
/* loaded from: classes4.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray a;

    /* loaded from: classes4.dex */
    private static class a {
        static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(5);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "isClearSelected");
            sparseArray.put(2, "isInEdit");
            sparseArray.put(3, "makeupMaterial");
            sparseArray.put(4, "styleMakeup");
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            a = hashMap;
            hashMap.put("layout/item_selfdef_makeup_0", Integer.valueOf(R.layout.item_selfdef_makeup));
            hashMap.put("layout/item_style_makeup_0", Integer.valueOf(R.layout.item_style_makeup));
            hashMap.put("layout/item_style_makeup_none_0", Integer.valueOf(R.layout.item_style_makeup_none));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.item_selfdef_makeup, 1);
        sparseIntArray.put(R.layout.item_style_makeup, 2);
        sparseIntArray.put(R.layout.item_style_makeup_none, 3);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.repository2020.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.a.get(i2);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = a.get(i2);
        if (i3 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i3 == 1) {
                    if ("layout/item_selfdef_makeup_0".equals(tag)) {
                        return new us.pinguo.commonui.b.b(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_selfdef_makeup is invalid. Received: " + tag);
                } else if (i3 == 2) {
                    if ("layout/item_style_makeup_0".equals(tag)) {
                        return new d(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_style_makeup is invalid. Received: " + tag);
                } else if (i3 != 3) {
                    return null;
                } else {
                    if ("layout/item_style_makeup_none_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_style_makeup_none is invalid. Received: " + tag);
                }
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
