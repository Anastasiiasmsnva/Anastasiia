package repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Controllers extends PackageRepository {

    private static final Map<Integer, PackageBox>  PACKAGEBOX_REPOSITORY_MAP =new HashMap<>();
    private static final AtomicInteger PACKAGEBOX_ID_HOLDER = new AtomicInteger();

    @Override
    public void add(@NotNull PackageBox pckg) {
        final int pckgId = PACKAGEBOX_ID_HOLDER.incrementAndGet();
        pckg.setId(pckgId);
        PACKAGEBOX_REPOSITORY_MAP.put(pckgId, pckg);
    }

    @Override
    public ArrayList<PackageBox> getArray() {
        return new ArrayList<>(PACKAGEBOX_REPOSITORY_MAP.values());
    }

    @Override
    public PackageBox read(int Id) {
        return PACKAGEBOX_REPOSITORY_MAP.get(Id);
    }

    @Override
    public boolean update(PackageBox pckg, int Id) {
        if(PACKAGEBOX_REPOSITORY_MAP.containsKey(Id)) {
            pckg.setId(Id);
            PACKAGEBOX_REPOSITORY_MAP.put(Id, pckg);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int Id) {
        return PACKAGEBOX_REPOSITORY_MAP.remove(Id) != null;
    }
}

