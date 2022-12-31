package cn.sharesdk.framework;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mob.tools.utils.Hashon;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class InnerShareParams {
    protected static final String ACTIVITY = "activity";
    protected static final String ADDRESS = "address";
    protected static final String AUTHOR = "author";
    protected static final String COMMENT = "comment";
    protected static final String CONTENT_TYPE = "contentType";
    protected static final String CUSTOM_FLAG = "customFlag";
    protected static final String EXECUTE_URL = "executeUrl";
    protected static final String EXT_INFO = "extInfo";
    protected static final String FILE_IMAGE = "file_image";
    protected static final String FILE_PATH = "filePath";
    protected static final String FILE_STICKER = "file_sticker";
    protected static final String FILE_VIDEO = "file_video";
    protected static final String GROPU_ID = "groupID";
    protected static final String HASHTAG = "HASHTAG";
    protected static final String HASHTAGS = "HASHTAGS";
    protected static final String HIDDEN = "hidden";
    protected static final String IMAGE_ARRAY = "imageArray";
    protected static final String IMAGE_DATA = "imageData";
    protected static final String IMAGE_FILE_PROVIDER_PATH = "image_provider_path";
    protected static final String IMAGE_LIST = "imageList";
    protected static final String IMAGE_PATH = "imagePath";
    protected static final String IMAGE_URI_LIST = "imageUriList";
    protected static final String IMAGE_URL = "imageUrl";
    protected static final String IMAGE_URL_LIST = "imageUrlList";
    protected static final String INSTALL_URL = "installUrl";
    protected static final String IS_FAMILY = "isFamily";
    protected static final String IS_FRIEND = "isFriend";
    protected static final String IS_LOG_EVEN = "isLogEven";
    protected static final String IS_PUBLIC = "isPublic";
    protected static final String IS_SHARE_TENCENT_WEIBO = "isShareTencentWeibo";
    protected static final String KAKAO_CUSTOM_TEMPLATE = "kaokao_custom_template";
    protected static final String KAKAO_CUSTOM_TEMPLATEID = "kakao_custom_templateid";
    protected static final String KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL = "kaokao_template_button_mobileweburl";
    protected static final String KAKAO_TEMPLATE_ADDBUTTON_TITLE = "kakao_template_button_title";
    protected static final String KAKAO_TEMPLATE_ADDBUTTON_WEBURL = "kakao_template_button_weburl";
    protected static final String KAKAO_TEMPLATE_COMMENTCOUNT = "kakao_template_commentcount";
    protected static final String KAKAO_TEMPLATE_DISCOUNTPRICE = "kakao_template_discountprice";
    protected static final String KAKAO_TEMPLATE_DISCOUNTRATE = "kakao_template_discountrate";
    protected static final String KAKAO_TEMPLATE_LIKECOUNT = "kakao_template_likecount";
    protected static final String KAKAO_TEMPLATE_MOBILEWEBURL = "kakao_template_mobileweburl";
    protected static final String KAKAO_TEMPLATE_PRODUCTNAME = "kakao_template_productname";
    protected static final String KAKAO_TEMPLATE_REGULARPRICE = "kaokao_template_regularprice";
    protected static final String KAKAO_TEMPLATE_SHARECOUNT = "kakao_template_sharecount";
    protected static final String KAKAO_TEMPLATE_WEBURL = "kakao_template_weburl";
    protected static final String LATITUDE = "latitude";
    protected static final String LC_CREATE_AT = "lc_create_at";
    protected static final String LC_DISPLAY_NAME = "lc_display_name";
    protected static final String LC_IMAGE = "lc_image";
    protected static final String LC_OBJECT_TYPE = "lc_object_type";
    protected static final String LC_SUMMARY = "lc_summary";
    protected static final String LC_URL = "lc_url";
    protected static final String LINKEDIN_DESCRIPTION = "linkedinDescription";
    protected static final String LONGITUDE = "longitude";
    protected static final String LOOPSHARE_PARAMS_MOBID = "loopshare_params_mobid";
    protected static final String MUSIC_URL = "musicUrl";
    protected static final String NOTEBOOK = "notebook";
    protected static final String QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    protected static final String QQ_MINI_PROGRAM_PATH = "mini_program_path";
    protected static final String QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    protected static final String QUOTE = "QUOTE";
    protected static final String SAFETY_LEVEL = "safetyLevel";
    protected static final String SCENCE = "scene";
    protected static final String SHARE_TO_PUBLISH = "shareToPublish";
    protected static final String SHARE_TYPE = "shareType";
    protected static final String SITE = "site";
    protected static final String SITE_URL = "siteUrl";
    protected static final String STACK = "stack";
    protected static final String SUBREDDIT = "sr";
    protected static final String TAGS = "tags";
    protected static final String TEXT = "text";
    protected static final String TITLE = "title";
    protected static final String TITLE_URL = "titleUrl";
    protected static final String URL = "url";
    protected static final String VENUE_DESCRIPTION = "venueDescription";
    protected static final String VENUE_NAME = "venueName";
    protected static final String VIDEO_ARRAY = "videoArray";
    protected static final String VIDEO_PATH_OASIS = "video_path_oasis";
    protected static final String VIDEO_URI = "video_uri";
    protected static final String VIDEO_URI_OASIS = "video_uri_oasis";
    protected static final String VIDEO_URL = "video_url";
    protected static final String WX_MINIPROGRAM_MINIPROGRAM_TYPE = "wxMiniProgramType";
    protected static final String WX_MINIPROGRAM_PATH = "wxPath";
    protected static final String WX_MINIPROGRAM_USER_NAME = "wxUserName";
    protected static final String WX_MINIPROGRAM_WITH_SHARETICKET = "wxWithShareTicket";
    protected static final String WX_RESERVED = "wx_reserved";
    protected static final String WX_SCENE = "wx_scene";
    protected static final String WX_TEMPLATEID = "wx_templateid";
    private HashMap<String, Object> params;

    public InnerShareParams() {
        this.params = new HashMap<>();
    }

    public <T> T get(String str, Class<T> cls) {
        Object obj = this.params.get(str);
        if (obj != null) {
            return cls.cast(obj);
        }
        if (!Byte.class.equals(cls) && !Byte.TYPE.equals(cls)) {
            if (!Short.class.equals(cls) && !Short.TYPE.equals(cls)) {
                if (!Integer.class.equals(cls) && !Integer.TYPE.equals(cls)) {
                    if (!Long.class.equals(cls) && !Long.TYPE.equals(cls)) {
                        if (!Float.class.equals(cls) && !Float.TYPE.equals(cls)) {
                            if (!Double.class.equals(cls) && !Double.TYPE.equals(cls)) {
                                if (!Boolean.class.equals(cls) && !Boolean.TYPE.equals(cls)) {
                                    if (HashMap.class.equals(cls) || Map.class.equals(cls)) {
                                        return cls.cast(new HashMap());
                                    }
                                    return null;
                                }
                                return cls.cast(Boolean.FALSE);
                            }
                            return cls.cast(new Double((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                        }
                        return cls.cast(new Float(0.0f));
                    }
                    return cls.cast(new Long(0L));
                }
                return cls.cast(new Integer(0));
            }
            return cls.cast(new Short((short) 0));
        }
        return cls.cast(new Byte((byte) 0));
    }

    public Activity getActivity() {
        return (Activity) get(ACTIVITY, Activity.class);
    }

    public String getAddress() {
        return (String) get(ADDRESS, String.class);
    }

    public String getAuthor() {
        return (String) get(AUTHOR, String.class);
    }

    public String getComment() {
        return (String) get("comment", String.class);
    }

    public int getContentType() {
        return ((Integer) get(CONTENT_TYPE, Integer.class)).intValue();
    }

    public String[] getCustomFlag() {
        return (String[]) get(CUSTOM_FLAG, String[].class);
    }

    public boolean getDouyinShareToPublish() {
        return ((Boolean) get(SHARE_TO_PUBLISH, Boolean.class)).booleanValue();
    }

    public String getExtInfo() {
        return (String) get(EXT_INFO, String.class);
    }

    public File getFileImage() {
        return (File) get(FILE_IMAGE, File.class);
    }

    public String getFilePath() {
        return (String) get(FILE_PATH, String.class);
    }

    public File getFileVideo() {
        return (File) get(FILE_VIDEO, File.class);
    }

    public String getGroupId() {
        return (String) get(GROPU_ID, String.class);
    }

    public String getHashtag() {
        return (String) get(HASHTAG, String.class);
    }

    public String[] getHashtags() {
        return (String[]) get(HASHTAGS, String[].class);
    }

    public int getHidden() {
        return ((Integer) get(HIDDEN, Integer.class)).intValue();
    }

    public String[] getImageArray() {
        return (String[]) get(IMAGE_ARRAY, String[].class);
    }

    public Bitmap getImageData() {
        return (Bitmap) get(IMAGE_DATA, Bitmap.class);
    }

    public String getImageFileProviderPath() {
        return (String) get(IMAGE_FILE_PROVIDER_PATH, String.class);
    }

    public String getImagePath() {
        return (String) get(IMAGE_PATH, String.class);
    }

    public List<Uri> getImageUriList() {
        return (List) get(IMAGE_URI_LIST, List.class);
    }

    public String getImageUrl() {
        return (String) get("imageUrl", String.class);
    }

    public List<String> getImageUrlList() {
        return (List) get(IMAGE_URL_LIST, List.class);
    }

    public String getKakaoAddbuttonMobileweburl() {
        return (String) get(KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL, String.class);
    }

    public String getKakaoAddbuttonTitle() {
        return (String) get(KAKAO_TEMPLATE_ADDBUTTON_TITLE, String.class);
    }

    public String getKakaoAddbuttonWeburl() {
        return (String) get(KAKAO_TEMPLATE_ADDBUTTON_WEBURL, String.class);
    }

    public int getKakaoCommentcount() {
        return ((Integer) get(KAKAO_TEMPLATE_COMMENTCOUNT, Integer.class)).intValue();
    }

    public HashMap<String, String> getKakaoCustomTemplate() {
        return (HashMap) get(KAKAO_CUSTOM_TEMPLATE, HashMap.class);
    }

    public String getKakaoCustomTemplateId() {
        return (String) get(KAKAO_CUSTOM_TEMPLATEID, String.class);
    }

    public int getKakaoDiscountprice() {
        return ((Integer) get(KAKAO_TEMPLATE_DISCOUNTPRICE, Integer.class)).intValue();
    }

    public int getKakaoDiscountrate() {
        return ((Integer) get(KAKAO_TEMPLATE_DISCOUNTRATE, Integer.class)).intValue();
    }

    public int getKakaoLikecount() {
        return ((Integer) get(KAKAO_TEMPLATE_LIKECOUNT, Integer.class)).intValue();
    }

    public String getKakaoMobileweburl() {
        return (String) get(KAKAO_TEMPLATE_MOBILEWEBURL, String.class);
    }

    public int getKakaoRegularprice() {
        return ((Integer) get(KAKAO_TEMPLATE_REGULARPRICE, Integer.class)).intValue();
    }

    public int getKakaoSharecount() {
        return ((Integer) get(KAKAO_TEMPLATE_SHARECOUNT, Integer.class)).intValue();
    }

    public String getKakaoTemplateProductname() {
        return (String) get(KAKAO_TEMPLATE_PRODUCTNAME, String.class);
    }

    public String getKakaoWebUrl() {
        return (String) get(KAKAO_TEMPLATE_WEBURL, String.class);
    }

    public float getLatitude() {
        return ((Float) get("latitude", Float.class)).floatValue();
    }

    public String getLcCreateAt() {
        return (String) get(LC_CREATE_AT, String.class);
    }

    public String getLcDisplayName() {
        return (String) get(LC_DISPLAY_NAME, String.class);
    }

    public JSONObject getLcImage() {
        return (JSONObject) get(LC_IMAGE, JSONObject.class);
    }

    public String getLcObjectType() {
        return (String) get(LC_OBJECT_TYPE, String.class);
    }

    public String getLcSummary() {
        return (String) get(LC_SUMMARY, String.class);
    }

    public String getLcUrl() {
        return (String) get(LC_URL, String.class);
    }

    public String getLinkedinDsscription() {
        return (String) get(LINKEDIN_DESCRIPTION, String.class);
    }

    public float getLongitude() {
        return ((Float) get("longitude", Float.class)).floatValue();
    }

    public HashMap<String, Object> getLoopshareCustomParams() {
        return (HashMap) get(LOOPSHARE_PARAMS_MOBID, HashMap.class);
    }

    public String getMusicUrl() {
        return (String) get(MUSIC_URL, String.class);
    }

    public String getNotebook() {
        return (String) get(NOTEBOOK, String.class);
    }

    public boolean getOpenCustomEven() {
        return ((Boolean) get(IS_LOG_EVEN, Boolean.class)).booleanValue();
    }

    public String getQQMiniProgramAppid() {
        return (String) get("mini_program_appid", String.class);
    }

    public String getQQMiniProgramPath() {
        return (String) get("mini_program_path", String.class);
    }

    public String getQQMiniProgramType() {
        return (String) get("mini_program_type", String.class);
    }

    public String getQuote() {
        return (String) get(QUOTE, String.class);
    }

    public int getSafetyLevel() {
        return ((Integer) get(SAFETY_LEVEL, Integer.class)).intValue();
    }

    public int getScence() {
        return ((Integer) get("scene", Integer.class)).intValue();
    }

    public int getShareType() {
        return ((Integer) get(SHARE_TYPE, Integer.class)).intValue();
    }

    public String getSite() {
        return (String) get("site", String.class);
    }

    public String getSiteUrl() {
        return (String) get(SITE_URL, String.class);
    }

    public String getStack() {
        return (String) get("stack", String.class);
    }

    public File getStickerFile() {
        return (File) get(FILE_STICKER, File.class);
    }

    public String getSubreddit() {
        return (String) get(SUBREDDIT, String.class);
    }

    public String[] getTags() {
        return (String[]) get("tags", String[].class);
    }

    public String getText() {
        return (String) get("text", String.class);
    }

    public String getTitle() {
        return (String) get("title", String.class);
    }

    public String getTitleUrl() {
        return (String) get(TITLE_URL, String.class);
    }

    public String getUrl() {
        return (String) get("url", String.class);
    }

    public String getVenueDescription() {
        return (String) get(VENUE_DESCRIPTION, String.class);
    }

    public String getVenueName() {
        return (String) get(VENUE_NAME, String.class);
    }

    public String[] getVideoPathArray() {
        return (String[]) get(VIDEO_ARRAY, String[].class);
    }

    public String getVideoPathOasis() {
        return (String) get(VIDEO_PATH_OASIS, String.class);
    }

    public Uri getVideoUri() {
        return (Uri) get(VIDEO_URI, Uri.class);
    }

    public Uri getVideoUriOasis() {
        return (Uri) get(VIDEO_URI_OASIS, Uri.class);
    }

    public String getVideoUrl() {
        return (String) get("video_url", String.class);
    }

    public int getWxMiniProgramType() {
        return ((Integer) get(WX_MINIPROGRAM_MINIPROGRAM_TYPE, Integer.class)).intValue();
    }

    public String getWxPath() {
        return (String) get(WX_MINIPROGRAM_PATH, String.class);
    }

    public String getWxReserved() {
        return (String) get(WX_RESERVED, String.class);
    }

    public String getWxTemplateid() {
        return (String) get(WX_TEMPLATEID, String.class);
    }

    public String getWxUserName() {
        return (String) get(WX_MINIPROGRAM_USER_NAME, String.class);
    }

    public boolean getWxWithShareTicket() {
        return ((Boolean) get(WX_MINIPROGRAM_WITH_SHARETICKET, Boolean.class)).booleanValue();
    }

    public boolean isFamily() {
        return ((Boolean) get(IS_FAMILY, Boolean.class)).booleanValue();
    }

    public boolean isFriend() {
        return ((Boolean) get(IS_FRIEND, Boolean.class)).booleanValue();
    }

    public boolean isPublic() {
        return ((Boolean) get(IS_PUBLIC, Boolean.class)).booleanValue();
    }

    public boolean isShareTencentWeibo() {
        return ((Boolean) get(IS_SHARE_TENCENT_WEIBO, Boolean.class)).booleanValue();
    }

    public void set(String str, Object obj) {
        this.params.put(str, obj);
    }

    public void setActivity(Activity activity) {
        set(ACTIVITY, activity);
    }

    public void setAddress(String str) {
        set(ADDRESS, str);
    }

    public void setAuthor(String str) {
        set(AUTHOR, str);
    }

    public void setComment(String str) {
        set("comment", str);
    }

    public void setContentType(int i2) {
        set(CONTENT_TYPE, Integer.valueOf(i2));
    }

    public void setCustomFlag(String[] strArr) {
        set(CUSTOM_FLAG, strArr);
    }

    public void setDouyinShareToPublish(boolean z) {
        set(SHARE_TO_PUBLISH, Boolean.valueOf(z));
    }

    public void setExtInfo(String str) {
        set(EXT_INFO, str);
    }

    public void setFamily(boolean z) {
        set(IS_FAMILY, Boolean.valueOf(z));
    }

    public void setFileImage(File file) {
        set(FILE_IMAGE, file);
    }

    public void setFilePath(String str) {
        set(FILE_PATH, str);
    }

    public void setFileSticker(File file) {
        set(FILE_STICKER, file);
    }

    public void setFileVideo(File file) {
        set(FILE_VIDEO, file);
    }

    public void setFriend(boolean z) {
        set(IS_FRIEND, Boolean.valueOf(z));
    }

    public void setGroupId(String str) {
        set(GROPU_ID, str);
    }

    public void setHashtag(String str) {
        set(HASHTAG, str);
    }

    public void setHashtags(String[] strArr) {
        set(HASHTAGS, strArr);
    }

    public void setHidden(int i2) {
        set(HIDDEN, Integer.valueOf(i2));
    }

    public void setImageArray(String[] strArr) {
        set(IMAGE_ARRAY, strArr);
    }

    public void setImageData(Bitmap bitmap) {
        set(IMAGE_DATA, bitmap);
    }

    public void setImageFileProviderPath(String str) {
        set(IMAGE_FILE_PROVIDER_PATH, str);
    }

    public void setImagePath(String str) {
        set(IMAGE_PATH, str);
    }

    public void setImageUriList(List<Uri> list) {
        set(IMAGE_URI_LIST, list);
    }

    public void setImageUrl(String str) {
        set("imageUrl", str);
    }

    public void setImageUrlList(List<String> list) {
        set(IMAGE_URL_LIST, list);
    }

    public void setKakaoAddbuttonMobileweburl(String str) {
        set(KAKAO_TEMPLATE_ADDBUTTON_MOBILEWEBURL, str);
    }

    public void setKakaoAddbuttonTitle(String str) {
        set(KAKAO_TEMPLATE_ADDBUTTON_TITLE, str);
    }

    public void setKakaoAddbuttonWeburl(String str) {
        set(KAKAO_TEMPLATE_ADDBUTTON_WEBURL, str);
    }

    public void setKakaoCommentcount(int i2) {
        set(KAKAO_TEMPLATE_COMMENTCOUNT, Integer.valueOf(i2));
    }

    public void setKakaoCustomTemplate(HashMap<String, String> hashMap) {
        set(KAKAO_CUSTOM_TEMPLATE, hashMap);
    }

    public void setKakaoCustomTemplateId(String str) {
        set(KAKAO_CUSTOM_TEMPLATEID, str);
    }

    public void setKakaoDiscountprice(int i2) {
        set(KAKAO_TEMPLATE_DISCOUNTPRICE, Integer.valueOf(i2));
    }

    public void setKakaoDiscountrate(int i2) {
        set(KAKAO_TEMPLATE_DISCOUNTRATE, Integer.valueOf(i2));
    }

    public void setKakaoLikecount(int i2) {
        set(KAKAO_TEMPLATE_LIKECOUNT, Integer.valueOf(i2));
    }

    public void setKakaoMobileWebUrl(String str) {
        set(KAKAO_TEMPLATE_MOBILEWEBURL, str);
    }

    public void setKakaoProductname(String str) {
        set(KAKAO_TEMPLATE_PRODUCTNAME, str);
    }

    public void setKakaoRegularprice(int i2) {
        set(KAKAO_TEMPLATE_REGULARPRICE, Integer.valueOf(i2));
    }

    public void setKakaoSharecount(int i2) {
        set(KAKAO_TEMPLATE_SHARECOUNT, Integer.valueOf(i2));
    }

    public void setKakaoWebUrl(String str) {
        set(KAKAO_TEMPLATE_WEBURL, str);
    }

    public void setLatitude(float f2) {
        set("latitude", Float.valueOf(f2));
    }

    public void setLcCreateAt(String str) {
        set(LC_CREATE_AT, str);
    }

    public void setLcDisplayName(String str) {
        set(LC_DISPLAY_NAME, str);
    }

    public void setLcImage(JSONObject jSONObject) {
        set(LC_IMAGE, jSONObject);
    }

    public void setLcObjectType(String str) {
        set(LC_OBJECT_TYPE, str);
    }

    public void setLcSummary(String str) {
        set(LC_SUMMARY, str);
    }

    public void setLcUrl(String str) {
        set(LC_URL, str);
    }

    public void setLinkedinDescription(String str) {
        set(LINKEDIN_DESCRIPTION, str);
    }

    public void setLongitude(float f2) {
        set("longitude", Float.valueOf(f2));
    }

    public void setLoopshareCustomParams(HashMap<String, Object> hashMap) {
        set(LOOPSHARE_PARAMS_MOBID, hashMap);
    }

    public void setMusicUrl(String str) {
        set(MUSIC_URL, str);
    }

    public void setNotebook(String str) {
        set(NOTEBOOK, str);
    }

    public void setOpenCustomEven(boolean z) {
        set(IS_LOG_EVEN, Boolean.valueOf(z));
    }

    public void setPublic(boolean z) {
        set(IS_PUBLIC, Boolean.valueOf(z));
    }

    public void setQQMiniProgramAppid(String str) {
        set("mini_program_appid", str);
    }

    public void setQQMiniProgramPath(String str) {
        set("mini_program_path", str);
    }

    public void setQQMiniProgramType(String str) {
        set("mini_program_type", str);
    }

    public void setQuote(String str) {
        set(QUOTE, str);
    }

    public void setSafetyLevel(int i2) {
        set(SAFETY_LEVEL, Integer.valueOf(i2));
    }

    public void setScence(int i2) {
        set("scene", Integer.valueOf(i2));
    }

    public void setShareTencentWeibo(boolean z) {
        set(IS_SHARE_TENCENT_WEIBO, Boolean.valueOf(z));
    }

    public void setShareType(int i2) {
        set(SHARE_TYPE, Integer.valueOf(i2));
    }

    public void setSite(String str) {
        set("site", str);
    }

    public void setSiteUrl(String str) {
        set(SITE_URL, str);
    }

    public void setStack(String str) {
        set("stack", str);
    }

    public void setSubreddit(String str) {
        set(SUBREDDIT, str);
    }

    public void setTags(String[] strArr) {
        set("tags", strArr);
    }

    public void setText(String str) {
        set("text", str);
    }

    public void setTitle(String str) {
        set("title", str);
    }

    public void setTitleUrl(String str) {
        set(TITLE_URL, str);
    }

    public void setUrl(String str) {
        set("url", str);
    }

    public void setVenueDescription(String str) {
        set(VENUE_DESCRIPTION, str);
    }

    public void setVenueName(String str) {
        set(VENUE_NAME, str);
    }

    public void setVideoPathArray(String[] strArr) {
        set(VIDEO_ARRAY, strArr);
    }

    public void setVideoPathOasis(String str) {
        set(VIDEO_PATH_OASIS, str);
    }

    public void setVideoUri(Uri uri) {
        set(VIDEO_URI, uri);
    }

    public void setVideoUriOasis(Uri uri) {
        set(VIDEO_URI_OASIS, uri);
    }

    public void setVideoUrl(String str) {
        set("video_url", str);
    }

    public void setWxMiniProgramType(int i2) {
        set(WX_MINIPROGRAM_MINIPROGRAM_TYPE, Integer.valueOf(i2));
    }

    public void setWxPath(String str) {
        set(WX_MINIPROGRAM_PATH, str);
    }

    public void setWxReserved(String str) {
        set(WX_RESERVED, str);
    }

    public void setWxTemplateid(String str) {
        set(WX_TEMPLATEID, str);
    }

    public void setWxUserName(String str) {
        set(WX_MINIPROGRAM_USER_NAME, str);
    }

    public void setWxWithShareTicket(boolean z) {
        set(WX_MINIPROGRAM_WITH_SHARETICKET, Boolean.valueOf(z));
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> hashMap = this.params;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public String toString() {
        try {
            return new Hashon().fromHashMap(this.params);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    public InnerShareParams(HashMap<String, Object> hashMap) {
        this();
        if (hashMap != null) {
            this.params.putAll(hashMap);
        }
    }

    public InnerShareParams(String str) {
        this(new Hashon().fromJson(str));
    }
}
