package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: StaticStickerDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface g {
    @Insert(onConflict = 1)
    void a(List<StaticStickerTable> list);

    @Query("DELETE FROM downloaded_static_sticker WHERE sid IN (:idList)")
    void b(List<String> list);

    @Query("SELECT * FROM downloaded_static_sticker WHERE sid = :id")
    StaticStickerTable d(String str);

    @Query("SELECT * FROM downloaded_static_sticker")
    List<StaticStickerTable> getAll();
}
