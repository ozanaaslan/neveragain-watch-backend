package watch.neveragain.ozanaslan.neveragainwatchbackend.database.revisioning;

import com.sun.security.auth.UserPrincipal;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class RevisionSubmissionListener implements RevisionListener {

    //TODO: Add meta-data of recent editor to the revision in order to pinpoint who edited the latest version of a document

    @Override
    public void newRevision(Object o) {
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) o;
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
