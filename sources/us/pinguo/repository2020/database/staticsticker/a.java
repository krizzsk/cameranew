package us.pinguo.repository2020.database.staticsticker;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: BackgroundBlurMaterialDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface a {
    @Query("DELETE FROM background_blur_material WHERE sid = :id")
    void a(String str);

    @Query("DELETE FROM background_blur_material WHERE sid IN (:idList)")
    void b(List<String> list);

    @Insert(onConflict = 1)
    void c(BackgroundBlurMaterialTable backgroundBlurMaterialTable);

    @Update
    void d(BackgroundBlurMaterialTable backgroundBlurMaterialTable);

    @Query("SELECT * FROM background_blur_material")
    List<BackgroundBlurMaterialTable> getAll();
}
