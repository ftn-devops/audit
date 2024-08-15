package ftn.devops.audit.Repository;

import ftn.devops.audit.Entity.Log;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface LogRepository extends CassandraRepository<Log,String> {

    List<Log> findAll();


}
