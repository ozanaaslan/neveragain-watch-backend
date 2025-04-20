package watch.neveragain.ozanaslan.neveragainwatchbackend.database.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import watch.neveragain.ozanaslan.neveragainwatchbackend.database.dao.ArticleEntity;
import watch.neveragain.ozanaslan.neveragainwatchbackend.database.dao.UserEntity;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findArticleEntitiesByUserEntity(UserEntity user);
    ArticleEntity findArticleEntityById(String postId);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND a.views >= :minViews")
    List<ArticleEntity> findPopularArticlesWithMinViews(int minViews);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND a.publishedTimestamp IS NOT NULL ORDER BY a.publishedTimestamp DESC")
    List<ArticleEntity> findAllPublishedArticles(Pageable pageable);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = false")
    List<ArticleEntity> findAllUnpublishedArticles();

    List<ArticleEntity> findArticleEntitiesByUserEntityAndPublishedTrueOrderByPublishedMillisDesc(UserEntity user, Pageable pageable);

    List<ArticleEntity> findAllByPublishedTrue(Pageable pageable);

    List<ArticleEntity> findAllByUserEntityAndPublishedIsTrue(UserEntity user);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND ( " +
            "LOWER(a.tags) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(a.title) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(a.content) LIKE LOWER(concat('%', :query, '%')) )")
    List<ArticleEntity> findArticlesByQuery(@Param("query") String query, Pageable pageable);



    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND ( " +
            "LOWER(a.tags) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(a.title) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(a.content) LIKE LOWER(concat('%', :query, '%')) )")
    List<ArticleEntity> findAllArticlesByQuery(@Param("query") String query);

    List<ArticleEntity> findAllByPublishedTrueAndUserEntity(UserEntity user);

    boolean existsArticleEntityById(String postId);

}