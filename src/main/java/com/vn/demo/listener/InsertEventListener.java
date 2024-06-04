package com.vn.demo.listener;

import com.vn.demo.entity.LogDetail;
import com.vn.demo.entity.LogEntity;
import com.vn.demo.helper.LogHelper;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertEventListener implements PostInsertEventListener {

    private final LogHelper logHelper;


    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        Object entity = postInsertEvent.getEntity();
        if (entity instanceof LogEntity || entity instanceof LogDetail) {
            return;
        }
        Object idObject = postInsertEvent.getId();
        logHelper.setId((Long) idObject);
    }


    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return true;
    }
}
