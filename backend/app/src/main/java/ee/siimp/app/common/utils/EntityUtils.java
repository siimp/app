package ee.siimp.app.common.utils;

import ee.siimp.app.common.entity.BaseEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityUtils {
    public static boolean isSameVersion(BaseEntity entity, Long version) {
        return entity != null && entity.getVersion() != null && entity.getVersion().equals(version);
    }
}
