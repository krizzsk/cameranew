package com.pinguo.camera360.newShop.model;

import com.pinguo.camera360.newShop.model.StoreCategoryNew;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreCategoryItem implements Serializable {
    public int activeTime;
    public String classifyId;
    public int createTime;
    public int expireTime;
    public int frontImage;
    public int idFace;
    public int isChangeFace;
    public boolean isLock;
    public int isMusic;
    public String jsonUrl;
    public StoreCategoryNew.Lock lock;
    public String pkgUrl;
    public int priority;
    public String shareContent;
    public List<StoreCategoryNew.ShareTag> shareTag;
    public String shareTitle;
    public transient int status;
    public String stickerIconUrl;
    public String stickerId;
    public String stickerTitle;
    public int updateTime;
}
