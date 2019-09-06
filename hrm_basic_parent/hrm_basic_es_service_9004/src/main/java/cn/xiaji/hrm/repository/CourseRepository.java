package cn.xiaji.hrm.repository;


import cn.xiaji.hrm.doc.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseRepository extends ElasticsearchRepository<EsCourse, Long> {
}
