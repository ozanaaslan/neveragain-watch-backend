package watch.neveragain.ozanaslan.neveragainwatchbackend.database.revisioning;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(RevisionSubmissionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {

    //Contains the editors id
    @Getter @Setter private String userId;

}
