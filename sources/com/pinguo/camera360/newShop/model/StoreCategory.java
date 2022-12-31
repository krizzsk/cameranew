package com.pinguo.camera360.newShop.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class StoreCategory implements Serializable {
    private Data data;
    private String message;
    private double serverTime;
    private int status;

    /* loaded from: classes3.dex */
    public class Data implements Serializable {
        private List<Items> items;

        public Data() {
        }

        public List<Items> getItems() {
            return this.items;
        }

        public void setItems(List<Items> list) {
            this.items = list;
        }
    }

    /* loaded from: classes3.dex */
    public class Items implements Serializable {
        private int activeTime;
        private String classifyId;
        private int createTime;
        private int expireTime;
        private int frontImage;
        private int idFace;
        private int isChangeFace;
        private boolean isLock;
        private int isMusic;
        private String jsonUrl;
        private Lock lock;
        private String pkgUrl;
        private int priority;
        private String shareContent;
        private List<ShareTag> shareTag;
        private String shareTitle;
        public transient int status;
        private String stickerIconUrl;
        private String stickerId;
        private String stickerTitle;
        private int updateTime;

        public Items() {
        }

        public int getActiveTime() {
            return this.activeTime;
        }

        public String getClassifyId() {
            return this.classifyId;
        }

        public int getCreateTime() {
            return this.createTime;
        }

        public int getExpireTime() {
            return this.expireTime;
        }

        public int getFrontImage() {
            return this.frontImage;
        }

        public int getIdFace() {
            return this.idFace;
        }

        public int getIsChangeFace() {
            return this.isChangeFace;
        }

        public boolean getIsLock() {
            return this.isLock;
        }

        public int getIsMusic() {
            return this.isMusic;
        }

        public String getJsonUrl() {
            return this.jsonUrl;
        }

        public Lock getLock() {
            return this.lock;
        }

        public String getPkgUrl() {
            return this.pkgUrl;
        }

        public int getPriority() {
            return this.priority;
        }

        public String getShareContent() {
            return this.shareContent;
        }

        public List<ShareTag> getShareTag() {
            return this.shareTag;
        }

        public String getShareTitle() {
            return this.shareTitle;
        }

        public int getStatus() {
            return this.status;
        }

        public String getStickerIconUrl() {
            return this.stickerIconUrl;
        }

        public String getStickerId() {
            return this.stickerId;
        }

        public String getStickerTitle() {
            return this.stickerTitle;
        }

        public int getUpdateTime() {
            return this.updateTime;
        }

        public void setActiveTime(int i2) {
            this.activeTime = i2;
        }

        public void setClassifyId(String str) {
            this.classifyId = str;
        }

        public void setCreateTime(int i2) {
            this.createTime = i2;
        }

        public void setExpireTime(int i2) {
            this.expireTime = i2;
        }

        public void setFrontImage(int i2) {
            this.frontImage = i2;
        }

        public void setIdFace(int i2) {
            this.idFace = i2;
        }

        public void setIsChangeFace(int i2) {
            this.isChangeFace = i2;
        }

        public void setIsLock(boolean z) {
            this.isLock = z;
        }

        public void setIsMusic(int i2) {
            this.isMusic = i2;
        }

        public void setJsonUrl(String str) {
            this.jsonUrl = str;
        }

        public void setLock(Lock lock) {
            this.lock = lock;
        }

        public void setPkgUrl(String str) {
            this.pkgUrl = str;
        }

        public void setPriority(int i2) {
            this.priority = i2;
        }

        public void setShareContent(String str) {
            this.shareContent = str;
        }

        public void setShareTag(List<ShareTag> list) {
            this.shareTag = list;
        }

        public void setShareTitle(String str) {
            this.shareTitle = str;
        }

        public void setStatus(int i2) {
            this.status = i2;
        }

        public void setStickerIconUrl(String str) {
            this.stickerIconUrl = str;
        }

        public void setStickerId(String str) {
            this.stickerId = str;
        }

        public void setStickerTitle(String str) {
            this.stickerTitle = str;
        }

        public void setUpdateTime(int i2) {
            this.updateTime = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class Lock implements Serializable {
        public Lock() {
        }
    }

    /* loaded from: classes3.dex */
    public class ShareTag implements Serializable {
        private String channel;
        private String tag;

        public ShareTag() {
        }

        public String getChannel() {
            return this.channel;
        }

        public String getTag() {
            return this.tag;
        }

        public void setChannel(String str) {
            this.channel = str;
        }

        public void setTag(String str) {
            this.tag = str;
        }
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public double getServerTime() {
        return this.serverTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setServerTime(double d2) {
        this.serverTime = d2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
