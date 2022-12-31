package us.pinguo.edit2020;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.edit2020.databinding.d;
import us.pinguo.edit2020.databinding.f;
import us.pinguo.edit2020.databinding.h;
import us.pinguo.edit2020.databinding.j;
import us.pinguo.edit2020.databinding.l;
import us.pinguo.edit2020.databinding.n;
import us.pinguo.edit2020.databinding.p;
/* loaded from: classes4.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray a;

    /* loaded from: classes4.dex */
    private static class a {
        static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(11);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adjustBeautyType");
            sparseArray.put(2, "canRedo");
            sparseArray.put(3, "canUndo");
            sparseArray.put(4, "isClearSelected");
            sparseArray.put(5, "isInEdit");
            sparseArray.put(6, "makeupMaterial");
            sparseArray.put(7, "material");
            sparseArray.put(8, "paintMaterial");
            sparseArray.put(9, "position");
            sparseArray.put(10, "styleMakeup");
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(8);
            a = hashMap;
            hashMap.put("layout/item_background_blur_lens_0", Integer.valueOf(R.layout.item_background_blur_lens));
            hashMap.put("layout/item_background_blur_shape_0", Integer.valueOf(R.layout.item_background_blur_shape));
            hashMap.put("layout/item_material_0", Integer.valueOf(R.layout.item_material));
            hashMap.put("layout/item_material_category_0", Integer.valueOf(R.layout.item_material_category));
            hashMap.put("layout/item_material_template_0", Integer.valueOf(R.layout.item_material_template));
            hashMap.put("layout/item_paint_material_0", Integer.valueOf(R.layout.item_paint_material));
            hashMap.put("layout/layout_adjust_paint_0", Integer.valueOf(R.layout.layout_adjust_paint));
            hashMap.put("layout/layout_adjust_paint_style_0", Integer.valueOf(R.layout.layout_adjust_paint_style));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(8);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.item_background_blur_lens, 1);
        sparseIntArray.put(R.layout.item_background_blur_shape, 2);
        sparseIntArray.put(R.layout.item_material, 3);
        sparseIntArray.put(R.layout.item_material_category, 4);
        sparseIntArray.put(R.layout.item_material_template, 5);
        sparseIntArray.put(R.layout.item_paint_material, 6);
        sparseIntArray.put(R.layout.layout_adjust_paint, 7);
        sparseIntArray.put(R.layout.layout_adjust_paint_style, 8);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new us.pinguo.commonui.DataBinderMapperImpl());
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
                switch (i3) {
                    case 1:
                        if ("layout/item_background_blur_lens_0".equals(tag)) {
                            return new us.pinguo.edit2020.databinding.b(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_background_blur_lens is invalid. Received: " + tag);
                    case 2:
                        if ("layout/item_background_blur_shape_0".equals(tag)) {
                            return new d(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_background_blur_shape is invalid. Received: " + tag);
                    case 3:
                        if ("layout/item_material_0".equals(tag)) {
                            return new f(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_material is invalid. Received: " + tag);
                    case 4:
                        if ("layout/item_material_category_0".equals(tag)) {
                            return new h(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_material_category is invalid. Received: " + tag);
                    case 5:
                        if ("layout/item_material_template_0".equals(tag)) {
                            return new j(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_material_template is invalid. Received: " + tag);
                    case 6:
                        if ("layout/item_paint_material_0".equals(tag)) {
                            return new l(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for item_paint_material is invalid. Received: " + tag);
                    case 7:
                        if ("layout/layout_adjust_paint_0".equals(tag)) {
                            return new n(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for layout_adjust_paint is invalid. Received: " + tag);
                    case 8:
                        if ("layout/layout_adjust_paint_style_0".equals(tag)) {
                            return new p(dataBindingComponent, view);
                        }
                        throw new IllegalArgumentException("The tag for layout_adjust_paint_style is invalid. Received: " + tag);
                    default:
                        return null;
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
