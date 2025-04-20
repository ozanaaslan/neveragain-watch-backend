package watch.neveragain.ozanaslan.neveragainwatchbackend.database.dao;

import jakarta.persistence.*;
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
    @Getter @Setter private String tags;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String content;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64avatar;

    @Getter @Setter private boolean published;
    @Getter @Setter private boolean archived;
    @Getter @Setter private boolean editable;
    @Getter @Setter private boolean reviewed;

    @Getter private long creationTimestamp;
    @Getter @Setter private long lastEditedTimestamp;
    @Getter @Setter private long publishedTimestamp;

    @Getter @Setter private int views;
    @Getter @Setter private int upVotes;
    @Getter @Setter private int downVotes;

    @ManyToMany @Getter private List<UserEntity> editors;

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
