package us.pinguo.camera360.shop.data.show;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ShowScene extends BaseShow {
    private List<ShowPkg> mShowPkgList;
    private List<ShowPkg> mShowPkgListInCamera;
    private List<ShowTopic> mTopicList;
    private String name;

    public ShowScene(String str, String str2) {
        super(str);
        this.mShowPkgList = new ArrayList();
        this.mTopicList = new ArrayList(1);
        this.mShowPkgListInCamera = new ArrayList();
        this.name = str2;
    }

    public void clearRedPoint() {
        t.f().d(getId());
    }

    public String getName() {
        return this.name.trim();
    }

    public List<ShowPkg> getShowPkgListInCamera() {
        return this.mShowPkgListInCamera;
    }

    public List<ShowPkg> getShowPkgs() {
        return this.mShowPkgList;
    }

    public List<ShowTopic> getTopicList() {
        return this.mTopicList;
    }

    public boolean hasRedPoint() {
        return t.f().j(this);
    }

    public boolean isOk() {
        List<ShowPkg> list;
        return !(TextUtils.isEmpty(getId()) || TextUtils.isEmpty(this.name) || (list = this.mShowPkgList) == null || list.isEmpty());
    }

    public void set(List<ShowPkg> list, List<ShowTopic> list2) {
        this.mShowPkgList.clear();
        this.mShowPkgList.addAll(list);
        this.mTopicList.clear();
        this.mTopicList.addAll(list2);
    }

    public void setShowPkgListInCamera(List<ShowPkg> list) {
        this.mShowPkgListInCamera.clear();
        this.mShowPkgListInCamera.addAll(list);
    }
}
