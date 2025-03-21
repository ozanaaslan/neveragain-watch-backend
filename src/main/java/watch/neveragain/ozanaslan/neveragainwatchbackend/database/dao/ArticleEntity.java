package watch.neveragain.ozanaslan.neveragainwatchbackend.database.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "articles")
@Audited
public class ArticleEntity extends AbstractEntity{

    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Getter @Setter private String evaluation;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String content;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64avatar;

    @Getter private long creationTimestamp;
    @Getter @Setter private long lastEditedTimestamp;

    @ManyToMany
    @Getter private List<UserEntity> editors;

    public ArticleEntity(){}

    public ArticleEntity(String title, String description, String evaluation, String content){
        this.title = title;
        this.description = description;
        this.evaluation = evaluation;
        this.content = content;
        this.creationTimestamp = System.currentTimeMillis();
        this.base64avatar = "";
    }


}
