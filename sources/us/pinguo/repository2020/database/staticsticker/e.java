package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: StaticStickerCategoryDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface e {
    @Query("DELETE FROM downloaded_static_sticker_category WHERE pid = :id")
    void a(String str);

    @Query("DELETE FROM downloaded_static_sticker_category WHERE pid IN (:idList)")
    void b(List<String> list);

    @Update
    void c(List<StaticStickerCategoryTable> list);

    @Insert(onConflict = 1)
    void d(StaticStickerCategoryTable staticStickerCategoryTable);

    @Update
    void e(StaticStickerCategoryTable staticStickerCategoryTable);

    @Query("SELECT * FROM downloaded_static_sticker_category")
    List<StaticStickerCategoryTable> getAll();
}
