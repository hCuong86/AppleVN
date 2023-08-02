package poly.edu.asmjava5.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import poly.edu.asmjava5.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findByNameContaining(String name);

    <S extends Category> S saveAndFlush(S entity);

    Page<Category> findByNameContaining(String name, Pageable pageable);

    <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Category getById(Long aLong);

    <S extends Category> List<S> saveAll(Iterable<S> entities);


    List<Category> findAllById(Iterable<Long> longs);

    <S extends Category> S save(S entity);

    <S extends Category> List<S> findAll(Example<S> example);

    <S extends Category> List<S> findAll(Example<S> example, Sort sort);

    List<Category> findAll();

    List<Category> findAll(Sort sort);

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Category entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Category> entities);

    void deleteAll();

    

}
