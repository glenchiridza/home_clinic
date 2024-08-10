package org.glenchiridza.insolvent.repository;

import org.glenchiridza.insolvent.model.InsolventCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsolventCheckHistoryRepository extends JpaRepository<InsolventCheckHistory, Integer> {

}
