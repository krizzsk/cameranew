package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Scene.kt */
/* loaded from: classes6.dex */
public final class Scene implements NoProguard {
    private final Integer editPriority;
    private final String id;
    private final String name;
    private final String[] package_ids;
    private final String[] products_in_camera;
    private int show_in_camera;
    private final String[] topic_group_ids;
    private int vip;

    public Scene(String str, String str2, String[] strArr, String[] strArr2, int i2, int i3, String[] strArr3, Integer num) {
        this.name = str;
        this.id = str2;
        this.package_ids = strArr;
        this.topic_group_ids = strArr2;
        this.vip = i2;
        this.show_in_camera = i3;
        this.products_in_camera = strArr3;
        this.editPriority = num;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.id;
    }

    public final String[] component3() {
        return this.package_ids;
    }

    public final String[] component4() {
        return this.topic_group_ids;
    }

    public final int component5() {
        return this.vip;
    }

    public final int component6() {
        return this.show_in_camera;
    }

    public final String[] component7() {
        return this.products_in_camera;
    }

    public final Integer component8() {
        return this.editPriority;
    }

    public final Scene copy(String str, String str2, String[] strArr, String[] strArr2, int i2, int i3, String[] strArr3, Integer num) {
        return new Scene(str, str2, strArr, strArr2, i2, i3, strArr3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(Scene.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.Scene");
            Scene scene = (Scene) obj;
            if (s.c(this.name, scene.name) && s.c(this.id, scene.id) && s.c(this.editPriority, scene.editPriority)) {
                String[] strArr = this.package_ids;
                if (strArr != null) {
                    String[] strArr2 = scene.package_ids;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (scene.package_ids != null) {
                    return false;
                }
                String[] strArr3 = this.topic_group_ids;
                if (strArr3 != null) {
                    String[] strArr4 = scene.topic_group_ids;
                    if (strArr4 == null || !Arrays.equals(strArr3, strArr4)) {
                        return false;
                    }
                } else if (scene.topic_group_ids != null) {
                    return false;
                }
                if (this.vip == scene.vip && this.show_in_camera == scene.show_in_camera) {
                    String[] strArr5 = this.products_in_camera;
                    if (strArr5 != null) {
                        String[] strArr6 = scene.products_in_camera;
                        if (strArr6 == null || !Arrays.equals(strArr5, strArr6)) {
                            return false;
                        }
                    } else if (scene.products_in_camera != null) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final Integer getEditPriority() {
        return this.editPriority;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String[] getPackage_ids() {
        return this.package_ids;
    }

    public final String[] getProducts_in_camera() {
        return this.products_in_camera;
    }

    public final int getShow_in_camera() {
        return this.show_in_camera;
    }

    public final String[] getTopic_group_ids() {
        return this.topic_group_ids;
    }

    public final int getVip() {
        return this.vip;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.editPriority;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.id;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String[] strArr = this.package_ids;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String[] strArr2 = this.topic_group_ids;
        int hashCode5 = (((((hashCode4 + (strArr2 == null ? 0 : Arrays.hashCode(strArr2))) * 31) + this.vip) * 31) + this.show_in_camera) * 31;
        String[] strArr3 = this.products_in_camera;
        return hashCode5 + (strArr3 != null ? Arrays.hashCode(strArr3) : 0);
    }

    public final void setShow_in_camera(int i2) {
        this.show_in_camera = i2;
    }

    public final void setVip(int i2) {
        this.vip = i2;
    }

    public String toString() {
        return "Scene(name=" + ((Object) this.name) + ", id=" + ((Object) this.id) + ", package_ids=" + Arrays.toString(this.package_ids) + ", topic_group_ids=" + Arrays.toString(this.topic_group_ids) + ", vip=" + this.vip + ", show_in_camera=" + this.show_in_camera + ", products_in_camera=" + Arrays.toString(this.products_in_camera) + ", editPriority=" + this.editPriority + ')';
    }

    public /* synthetic */ Scene(String str, String str2, String[] strArr, String[] strArr2, int i2, int i3, String[] strArr3, Integer num, int i4, o oVar) {
        this(str, str2, strArr, strArr2, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, strArr3, num);
    }
}
