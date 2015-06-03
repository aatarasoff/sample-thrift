include "entity.thrift"

namespace java ru.alfabank.thrift.service

exception UnexpectedException {
    string message;
}

service EntityService {
    list<entity.Entity> findById(1: string id) throws (1: UnexpectedException e)
}