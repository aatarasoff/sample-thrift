package ru.alfabank.thrift.test;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;
import ru.alfabank.thrift.entity.Entity;
import ru.alfabank.thrift.service.EntityService;
import ru.alfabank.thrift.service.UnexpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandr on 03.06.15.
 */
@Component
public class EntityServiceBean implements EntityService.Iface {
    @Override
    public List<Entity> findById(final String id) throws UnexpectedException, TException {
        List<Entity> result = new ArrayList<>();
        result.add(new Entity() {
            @Override
            public String getId() {
                return id;
            }

            @Override
            public int getSomeNumber() {
                return 100;
            }

            @Override
            public boolean isTrueOrFalse() {
                return true;
            }
        });
        return result;
    }
}
